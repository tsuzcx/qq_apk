package com.tencent.mm.plugin.voip_cs.b;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.model.c;
import com.tencent.mm.plugin.voip_cs.model.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends com.tencent.mm.plugin.voip.video.camera.prev.a
{
  public a()
  {
    super(640, 480);
  }
  
  public final void ies()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.LpP != null)
      {
        localSize = this.LpP.getPreviewSize();
        locald = c.idY();
        if (!this.LpS) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.LpP.getPreviewFrameRate();
        int j = this.Lqb;
        int k = this.Lqc;
        int m = localSize.width;
        int n = localSize.height;
        Log.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.UXd = i;
        locald.UWZ = j;
        locald.UXa = k;
        locald.UXb = m;
        locald.UXc = n;
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
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */