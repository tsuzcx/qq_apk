package com.tencent.mm.plugin.voip_cs.c;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends com.tencent.mm.plugin.voip.video.a
{
  public a(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final void cQJ()
  {
    AppMethodBeat.i(135436);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.tFw != null)
      {
        localSize = this.tFw.getPreviewSize();
        locald = c.cQo();
        if (!this.tFz) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.tFw.getPreviewFrameRate();
        int j = this.tFM;
        int k = this.tFN;
        int m = localSize.width;
        int n = localSize.height;
        ab.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.tJY = i;
        locald.tJU = j;
        locald.tJV = k;
        locald.tJW = m;
        locald.tJX = n;
        AppMethodBeat.o(135436);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + localException.getMessage());
      AppMethodBeat.o(135436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a
 * JD-Core Version:    0.7.0.1
 */