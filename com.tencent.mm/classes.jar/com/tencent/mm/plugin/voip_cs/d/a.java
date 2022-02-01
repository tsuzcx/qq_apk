package com.tencent.mm.plugin.voip_cs.d;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.voip.video.camera.prev.a
{
  public a()
  {
    super(640, 480);
  }
  
  public final void gFu()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.Ftv != null)
      {
        localSize = this.Ftv.getPreviewSize();
        locald = c.gEX();
        if (!this.Fty) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.Ftv.getPreviewFrameRate();
        int j = this.FtH;
        int k = this.FtI;
        int m = localSize.width;
        int n = localSize.height;
        Log.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.OiI = i;
        locald.OiE = j;
        locald.OiF = k;
        locald.OiG = m;
        locald.OiH = n;
        AppMethodBeat.o(125487);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
      AppMethodBeat.o(125487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.a
 * JD-Core Version:    0.7.0.1
 */