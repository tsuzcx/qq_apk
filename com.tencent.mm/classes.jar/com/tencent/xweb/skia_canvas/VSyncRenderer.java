package com.tencent.xweb.skia_canvas;

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
  private final IXWebWorkingHandler mThreadHandler;
  
  static
  {
    AppMethodBeat.i(217453);
    sRendererList = new ThreadLocal();
    AppMethodBeat.o(217453);
  }
  
  VSyncRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(217446);
    this.mThreadHandler = paramIXWebWorkingHandler;
    this.mPresentCallbackList = new LinkedList();
    this.mAnimationCallbackIdMap = new HashMap();
    startVSyncLoop();
    AppMethodBeat.o(217446);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(217450);
    if (this.mThreadHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(217450);
      return;
    }
    this.mThreadHandler.post(paramRunnable);
    AppMethodBeat.o(217450);
  }
  
  private long generateAnimationCallbackUniqueId()
  {
    long l = this.mAnimationCallbackUniqueId;
    this.mAnimationCallbackUniqueId = (1L + l);
    return l;
  }
  
  static VSyncRenderer getInstance()
  {
    AppMethodBeat.i(217445);
    VSyncRenderer localVSyncRenderer = (VSyncRenderer)sRendererList.get();
    AppMethodBeat.o(217445);
    return localVSyncRenderer;
  }
  
  static void initRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(217444);
    if (sRendererList.get() == null) {
      sRendererList.set(new VSyncRenderer(paramIXWebWorkingHandler));
    }
    AppMethodBeat.o(217444);
  }
  
  private void startVSyncLoop()
  {
    AppMethodBeat.i(217451);
    VSyncWaiter.getInstance().asyncWaitForVSync(this);
    AppMethodBeat.o(217451);
  }
  
  long addAnimationCallback(AnimationCallback paramAnimationCallback)
  {
    AppMethodBeat.i(217448);
    long l = generateAnimationCallbackUniqueId();
    this.mAnimationCallbackIdMap.put(Long.valueOf(l), paramAnimationCallback);
    AppMethodBeat.o(217448);
    return l;
  }
  
  void addPresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(217447);
    this.mPresentCallbackList.add(paramPresentCallback);
    AppMethodBeat.o(217447);
  }
  
  public void doFrame(long paramLong)
  {
    AppMethodBeat.i(217452);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217443);
        Object localObject = new ArrayList(VSyncRenderer.this.mAnimationCallbackIdMap.values());
        VSyncRenderer.this.mAnimationCallbackIdMap.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VSyncRenderer.AnimationCallback)((Iterator)localObject).next()).doAnimation();
        }
        localObject = VSyncRenderer.this.mPresentCallbackList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VSyncRenderer.PresentCallback)((Iterator)localObject).next()).doPresent();
        }
        VSyncWaiter.getInstance().asyncWaitForVSync(VSyncRenderer.this);
        AppMethodBeat.o(217443);
      }
    });
    AppMethodBeat.o(217452);
  }
  
  void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217449);
    this.mAnimationCallbackIdMap.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(217449);
  }
  
  static abstract interface AnimationCallback
  {
    public abstract void doAnimation();
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