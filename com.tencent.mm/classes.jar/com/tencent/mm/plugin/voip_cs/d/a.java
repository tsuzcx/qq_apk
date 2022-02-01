package com.tencent.mm.plugin.voip_cs.d;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.plugin.voip.video.a
{
  public a()
  {
    super(640, 480);
  }
  
  public final void eFI()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.CDC != null)
      {
        localSize = this.CDC.getPreviewSize();
        locald = c.eFl();
        if (!this.CDF) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.CDC.getPreviewFrameRate();
        int j = this.CDS;
        int k = this.CDT;
        int m = localSize.width;
        int n = localSize.height;
        ae.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.CMh = i;
        locald.CMd = j;
        locald.CMe = k;
        locald.CMf = m;
        locald.CMg = n;
        AppMethodBeat.o(125487);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
      AppMethodBeat.o(125487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.a
 * JD-Core Version:    0.7.0.1
 */