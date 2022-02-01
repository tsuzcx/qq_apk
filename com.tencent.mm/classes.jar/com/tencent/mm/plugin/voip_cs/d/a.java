package com.tencent.mm.plugin.voip_cs.d;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.plugin.voip.video.a
{
  public a()
  {
    super(640, 480);
  }
  
  public final void dYF()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.ztT != null)
      {
        localSize = this.ztT.getPreviewSize();
        locald = c.dYi();
        if (!this.ztW) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.ztT.getPreviewFrameRate();
        int j = this.zuj;
        int k = this.zuk;
        int m = localSize.width;
        int n = localSize.height;
        ad.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.zCg = i;
        locald.zCc = j;
        locald.zCd = k;
        locald.zCe = m;
        locald.zCf = n;
        AppMethodBeat.o(125487);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
      AppMethodBeat.o(125487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.a
 * JD-Core Version:    0.7.0.1
 */