package com.tencent.xweb.extension.video;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements SurfaceHolder.Callback
{
  d$1(d paramd) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(153572);
    Canvas localCanvas = paramSurfaceHolder.lockCanvas();
    localCanvas.drawColor(-16777216);
    paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
    AppMethodBeat.o(153572);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(153571);
    Canvas localCanvas = paramSurfaceHolder.lockCanvas();
    localCanvas.drawColor(-16777216);
    paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
    AppMethodBeat.o(153571);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.1
 * JD-Core Version:    0.7.0.1
 */