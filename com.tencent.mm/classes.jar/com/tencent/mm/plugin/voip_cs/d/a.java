package com.tencent.mm.plugin.voip_cs.d;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends com.tencent.mm.plugin.voip.video.a
{
  public a()
  {
    super(640, 480);
  }
  
  public final void eob()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.AMK != null)
      {
        localSize = this.AMK.getPreviewSize();
        locald = c.enE();
        if (!this.AMN) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.AMK.getPreviewFrameRate();
        int j = this.ANb;
        int k = this.ANc;
        int m = localSize.width;
        int n = localSize.height;
        ac.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.AUu = i;
        locald.AUq = j;
        locald.AUr = k;
        locald.AUs = m;
        locald.AUt = n;
        AppMethodBeat.o(125487);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
      AppMethodBeat.o(125487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.a
 * JD-Core Version:    0.7.0.1
 */