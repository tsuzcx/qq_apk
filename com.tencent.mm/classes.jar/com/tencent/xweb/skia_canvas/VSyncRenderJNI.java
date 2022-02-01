package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class VSyncRenderJNI
{
  private static long addAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(196750);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(196750);
      throw ((Throwable)localObject);
    }
    paramLong = ((VSyncRenderer)localObject).addAnimationCallback(new VSyncRenderer.AnimationCallback()
    {
      public final void doAnimation(long paramAnonymousLong)
      {
        AppMethodBeat.i(196746);
        VSyncRenderJNI.access$000(paramAnonymousLong, this.val$cookie);
        AppMethodBeat.o(196746);
      }
    });
    AppMethodBeat.o(196750);
    return paramLong;
  }
  
  private static native void nativeOnAnimation(long paramLong1, long paramLong2);
  
  private static void removeAnimationCallback(long paramLong)
  {
    AppMethodBeat.i(196751);
    Object localObject = VSyncRenderer.getInstance();
    if (localObject == null)
    {
      localObject = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
      AppMethodBeat.o(196751);
      throw ((Throwable)localObject);
    }
    ((VSyncRenderer)localObject).removeAnimationCallback(paramLong);
    AppMethodBeat.o(196751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderJNI
 * JD-Core Version:    0.7.0.1
 */