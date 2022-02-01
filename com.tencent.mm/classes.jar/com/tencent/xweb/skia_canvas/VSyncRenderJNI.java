package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class VSyncRenderJNI
{
  private static long addAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(218237);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(218237);
      throw ((Throwable)localObject);
    }
    paramLong = ((VSyncRenderer)localObject).addAnimationCallback(new VSyncRenderer.AnimationCallback()
    {
      public final void doAnimation()
      {
        AppMethodBeat.i(218236);
        VSyncRenderJNI.access$000(this.val$cookie);
        AppMethodBeat.o(218236);
      }
    });
    AppMethodBeat.o(218237);
    return paramLong;
  }
  
  private static native void nativeOnAnimation(long paramLong);
  
  private static void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(218238);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(218238);
      throw ((Throwable)localObject);
    }
    ((VSyncRenderer)localObject).removeAnimationCallback(paramLong);
    AppMethodBeat.o(218238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderJNI
 * JD-Core Version:    0.7.0.1
 */