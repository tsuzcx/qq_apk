package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class VSyncRenderJNI
{
  private static long addAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217440);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(217440);
      throw ((Throwable)localObject);
    }
    paramLong = ((VSyncRenderer)localObject).addAnimationCallback(new VSyncRenderer.AnimationCallback()
    {
      public final void doAnimation()
      {
        AppMethodBeat.i(217439);
        VSyncRenderJNI.access$000(this.val$cookie);
        AppMethodBeat.o(217439);
      }
    });
    AppMethodBeat.o(217440);
    return paramLong;
  }
  
  private static native void nativeOnAnimation(long paramLong);
  
  private static void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217441);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(217441);
      throw ((Throwable)localObject);
    }
    ((VSyncRenderer)localObject).removeAnimationCallback(paramLong);
    AppMethodBeat.o(217441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderJNI
 * JD-Core Version:    0.7.0.1
 */