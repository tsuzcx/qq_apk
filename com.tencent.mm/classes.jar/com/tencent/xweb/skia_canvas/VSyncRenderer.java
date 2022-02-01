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
    AppMethodBeat.i(218250);
    sRendererList = new ThreadLocal();
    AppMethodBeat.o(218250);
  }
  
  VSyncRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(218243);
    this.mThreadHandler = paramIXWebWorkingHandler;
    this.mPresentCallbackList = new LinkedList();
    this.mAnimationCallbackIdMap = new HashMap();
    startVSyncLoop();
    AppMethodBeat.o(218243);
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    AppMethodBeat.i(218247);
    if (this.mThreadHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(218247);
      return;
    }
    this.mThreadHandler.post(paramRunnable);
    AppMethodBeat.o(218247);
  }
  
  private long generateAnimationCallbackUniqueId()
  {
    long l = this.mAnimationCallbackUniqueId;
    this.mAnimationCallbackUniqueId = (1L + l);
    return l;
  }
  
  static VSyncRenderer getInstance()
  {
    AppMethodBeat.i(218242);
    VSyncRenderer localVSyncRenderer = (VSyncRenderer)sRendererList.get();
    AppMethodBeat.o(218242);
    return localVSyncRenderer;
  }
  
  static void initRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    AppMethodBeat.i(218241);
    if (sRendererList.get() == null) {
      sRendererList.set(new VSyncRenderer(paramIXWebWorkingHandler));
    }
    AppMethodBeat.o(218241);
  }
  
  private void startVSyncLoop()
  {
    AppMethodBeat.i(218248);
    VSyncWaiter.getInstance().asyncWaitForVSync(this);
    AppMethodBeat.o(218248);
  }
  
  long addAnimationCallback(AnimationCallback paramAnimationCallback)
  {
    AppMethodBeat.i(218245);
    long l = generateAnimationCallbackUniqueId();
    this.mAnimationCallbackIdMap.put(Long.valueOf(l), paramAnimationCallback);
    AppMethodBeat.o(218245);
    return l;
  }
  
  void addPresentCallback(PresentCallback paramPresentCallback)
  {
    AppMethodBeat.i(218244);
    this.mPresentCallbackList.add(paramPresentCallback);
    AppMethodBeat.o(218244);
  }
  
  public void doFrame(long paramLong)
  {
    AppMethodBeat.i(218249);
    checkAndPost(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(218240);
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
        AppMethodBeat.o(218240);
      }
    });
    AppMethodBeat.o(218249);
  }
  
  void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(218246);
    this.mAnimationCallbackIdMap.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(218246);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderer
 * JD-Core Version:    0.7.0.1
 */