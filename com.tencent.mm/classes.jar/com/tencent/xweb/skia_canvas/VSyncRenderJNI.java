package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class VSyncRenderJNI
{
  private static long addAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217590);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(217590);
      throw ((Throwable)localObject);
    }
    paramLong = ((VSyncRenderer)localObject).addAnimationCallback(new VSyncRenderer.AnimationCallback()
    {
      public final void doAnimation(long paramAnonymousLong)
      {
        AppMethodBeat.i(217589);
        VSyncRenderJNI.access$000(paramAnonymousLong, this.val$cookie);
        AppMethodBeat.o(217589);
      }
    });
    AppMethodBeat.o(217590);
    return paramLong;
  }
  
  private static native void nativeOnAnimation(long paramLong1, long paramLong2);
  
  private static void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(217591);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(217591);
      throw ((Throwable)localObject);
    }
    ((VSyncRenderer)localObject).removeAnimationCallback(paramLong);
    AppMethodBeat.o(217591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderJNI
 * JD-Core Version:    0.7.0.1
 */