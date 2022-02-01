package com.tencent.xweb.skia_canvas;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class VSyncRenderer
  implements VSyncWaiter.VSyncWaiterCallback
{
  private static ThreadLocal<VSyncRenderer> sRendererList;
  private final Map<Long, AnimationCallback> mAnimationCallbackIdMap;
  private long mAnimationCallbackUniqueId;
  private final List<PresentCallback> mPresentCallbackList;
  private final long mStartFrameTimeNanos;
  private final IXWebWorkingHandler mThreadHandler;
  private boolean mWaitingForNextVSync;
  
  static
  {
    AppMethodBeat.i(213822);
    sRendererList = new ThreadLocal();
    AppMethodBeat.o(213822);
  }
  
  VSyncRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(213758);
    this.mThreadHandler = paramIXWebWorkingHandler;
    this.mPresentCallbackList = new LinkedList();
    this.mAnimationCallbackIdMap = new HashMap();
    this.mStartFrameTimeNanos = SystemClock.elapsedRealtimeNanos();
    AppMethodBeat.o(213758);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(213775);
    if (this.mThreadHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(213775);
      return;
    }
    this.mThreadHandler.post(paramRunnable);
    AppMethodBeat.o(213775);
  }
  
  private long generateAnimationCallbackUniqueId()
  {
    long l = this.mAnimationCallbackUniqueId;
    this.mAnimationCallbackUniqueId = (1L + l);
    return l;
  }
  
  static VSyncRenderer getInstance()
  {
    AppMethodBeat.i(213747);
    VSyncRenderer localVSyncRenderer = (VSyncRenderer)sRendererList.get();
    AppMethodBeat.o(213747);
    return localVSyncRenderer;
  }
  
  static void initRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(213737);
    if (sRendererList.get() == null) {
      sRendererList.set(new VSyncRenderer(paramIXWebWorkingHandler));
    }
    AppMethodBeat.o(213737);
  }
  
  private void schedulerNextVSync()
  {
    AppMethodBeat.i(213785);
    this.mWaitingForNextVSync = true;
    VSyncWaiter.getInstance().asyncWaitForVSync(this);
    AppMethodBeat.o(213785);
  }
  
  long addAnimationCallback(AnimationCallback paramAnimationCallback)
  {
    AppMethodBeat.i(213844);
    long l = generateAnimationCallbackUniqueId();
    this.mAnimationCallbackIdMap.put(Long.valueOf(l), paramAnimationCallback);
    triggerNextVSync();
    AppMethodBeat.o(213844);
    return l;
  }
  
  void addPresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(213830);
    this.mPresentCallbackList.add(paramPresentCallback);
    triggerNextVSync();
    AppMethodBeat.o(213830);
  }
  
  public void doFrame(long paramLong)
  {
    AppMethodBeat.i(213867);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(213710);
        VSyncRenderer.access$002(VSyncRenderer.this, false);
        Object localObject = VSyncRenderer.this.mPresentCallbackList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VSyncRenderer.PresentCallback)((Iterator)localObject).next()).doPresent();
        }
        long l1 = SystemClock.elapsedRealtimeNanos();
        long l2 = VSyncRenderer.this.mStartFrameTimeNanos;
        localObject = new ArrayList(VSyncRenderer.this.mAnimationCallbackIdMap.values());
        VSyncRenderer.this.mAnimationCallbackIdMap.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VSyncRenderer.AnimationCallback)((Iterator)localObject).next()).doAnimation(l1 - l2);
        }
        AppMethodBeat.o(213710);
      }
    });
    AppMethodBeat.o(213867);
  }
  
  void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(213850);
    this.mAnimationCallbackIdMap.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(213850);
  }
  
  void removePresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(213838);
    this.mPresentCallbackList.remove(paramPresentCallback);
    AppMethodBeat.o(213838);
  }
  
  void triggerNextVSync()
  {
    AppMethodBeat.i(213858);
    if (!this.mWaitingForNextVSync) {
      schedulerNextVSync();
    }
    AppMethodBeat.o(213858);
  }
  
  static abstract interface AnimationCallback
  {
    public abstract void doAnimation(long paramLong);
  }
  
  static abstract interface PresentCallback
  {
    public abstract void doPresent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderer
 * JD-Core Version:    0.7.0.1
 */