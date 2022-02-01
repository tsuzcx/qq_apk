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
    AppMethodBeat.i(217605);
    sRendererList = new ThreadLocal();
    AppMethodBeat.o(217605);
  }
  
  VSyncRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(217596);
    this.mThreadHandler = paramIXWebWorkingHandler;
    this.mPresentCallbackList = new LinkedList();
    this.mAnimationCallbackIdMap = new HashMap();
    this.mStartFrameTimeNanos = SystemClock.elapsedRealtimeNanos();
    AppMethodBeat.o(217596);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(217601);
    if (this.mThreadHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(217601);
      return;
    }
    this.mThreadHandler.post(paramRunnable);
    AppMethodBeat.o(217601);
  }
  
  private long generateAnimationCallbackUniqueId()
  {
    long l = this.mAnimationCallbackUniqueId;
    this.mAnimationCallbackUniqueId = (1L + l);
    return l;
  }
  
  static VSyncRenderer getInstance()
  {
    AppMethodBeat.i(217595);
    VSyncRenderer localVSyncRenderer = (VSyncRenderer)sRendererList.get();
    AppMethodBeat.o(217595);
    return localVSyncRenderer;
  }
  
  static void initRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(217594);
    if (sRendererList.get() == null) {
      sRendererList.set(new VSyncRenderer(paramIXWebWorkingHandler));
    }
    AppMethodBeat.o(217594);
  }
  
  private void schedulerNextVSync()
  {
    AppMethodBeat.i(217602);
    this.mWaitingForNextVSync = true;
    VSyncWaiter.getInstance().asyncWaitForVSync(this);
    AppMethodBeat.o(217602);
  }
  
  long addAnimationCallback(AnimationCallback paramAnimationCallback)
  {
    AppMethodBeat.i(217599);
    long l = generateAnimationCallbackUniqueId();
    this.mAnimationCallbackIdMap.put(Long.valueOf(l), paramAnimationCallback);
    triggerNextVSync();
    AppMethodBeat.o(217599);
    return l;
  }
  
  void addPresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(217597);
    this.mPresentCallbackList.add(paramPresentCallback);
    triggerNextVSync();
    AppMethodBeat.o(217597);
  }
  
  public void doFrame(long paramLong)
  {
    AppMethodBeat.i(217604);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217593);
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
        AppMethodBeat.o(217593);
      }
    });
    AppMethodBeat.o(217604);
  }
  
  void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217600);
    this.mAnimationCallbackIdMap.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(217600);
  }
  
  void removePresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(217598);
    this.mPresentCallbackList.remove(paramPresentCallback);
    AppMethodBeat.o(217598);
  }
  
  void triggerNextVSync()
  {
    AppMethodBeat.i(217603);
    if (!this.mWaitingForNextVSync) {
      schedulerNextVSync();
    }
    AppMethodBeat.o(217603);
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