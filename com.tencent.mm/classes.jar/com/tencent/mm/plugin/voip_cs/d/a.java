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
  
  public final void fMQ()
  {
    AppMethodBeat.i(125487);
    try
    {
      Camera.Size localSize;
      d locald;
      if (this.zNY != null)
      {
        localSize = this.zNY.getPreviewSize();
        locald = c.fMt();
        if (!this.zOb) {
          break label112;
        }
      }
      label112:
      for (int i = 1;; i = 0)
      {
        this.zNY.getPreviewFrameRate();
        int j = this.zOk;
        int k = this.zOl;
        int m = localSize.width;
        int n = localSize.height;
        Log.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
        locald.HqX = i;
        locald.HqT = j;
        locald.HqU = k;
        locald.HqV = m;
        locald.HqW = n;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.a
 * JD-Core Version:    0.7.0.1
 */