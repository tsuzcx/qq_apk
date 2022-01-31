package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.aa;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements Camera.PreviewCallback
{
  a$2(a parama) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(5021);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      h.qsU.idkeyStat(159L, 0L, 1L, false);
      h.qsU.idkeyStat(159L, 3L, 1L, false);
      if (this.tFR.tFE != null) {
        this.tFR.tFE.bho();
      }
      AppMethodBeat.o(5021);
      return;
    }
    if (this.tFR.tFx == null)
    {
      ab.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
      AppMethodBeat.o(5021);
      return;
    }
    int m;
    int j;
    int k;
    int i;
    if (this.tFR.tFE != null)
    {
      m = 1;
      if (this.tFR.tFo)
      {
        j = i.tHB;
        k = j;
        if (!ac.eru.enW) {
          break label616;
        }
        k = j;
        if (ac.eru.enV.rotate == 0) {
          break label616;
        }
        i = ac.eru.enV.eoF;
        m = 1;
        k = j;
        j = m;
      }
    }
    for (;;)
    {
      label181:
      boolean bool;
      if (k > 0)
      {
        m = 32;
        paramCamera = this.tFR;
        if ((j != 0) || (k <= 0)) {
          break label534;
        }
        bool = true;
        label199:
        paramCamera.tFp = bool;
        k = this.tFR.tFx.width;
        int n = this.tFR.tFx.height;
        if ((j == 0) || (this.tFR.bhn())) {
          break label540;
        }
        if (this.tFR.tFH == null)
        {
          j = k * n * 3 / 2;
          this.tFR.tFH = new byte[j];
          this.tFR.tFH[0] = 90;
        }
        Object localObject = b.cLC();
        j = paramArrayOfByte.length;
        int i1 = this.tFR.tFy;
        paramCamera = this.tFR.tFH;
        int i2 = this.tFR.tFH.length;
        localObject = ((t)localObject).tyR.ttm.tvl;
        if ((((m)localObject).kJF != m.kJE) && (((m)localObject).ttm.tvj.cOG()) && (((m)localObject).ttm.cMg())) {
          ((m)localObject).ttm.tvj.videoRorate90D(paramArrayOfByte, j, k, n, i1, paramCamera, i2, k, n, i);
        }
        this.tFR.tFE.a(this.tFR.tFH, this.tFR.tFH.length, k, n, this.tFR.tFy, m);
      }
      for (;;)
      {
        if (d.cPs() >= 8)
        {
          if (this.tFR.mrD == null)
          {
            ab.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
            AppMethodBeat.o(5021);
            return;
            i = i.tHC;
            k = i;
            if (!ac.eru.enY) {
              break label616;
            }
            k = i;
            if (ac.eru.enX.rotate == 0) {
              break label616;
            }
            m = ac.eru.enX.eoF;
            j = 1;
            k = i;
            i = m;
            break;
            m = 0;
            break label181;
            label534:
            bool = false;
            break label199;
            label540:
            this.tFR.tFE.a(paramArrayOfByte, paramArrayOfByte.length, this.tFR.tFx.width, this.tFR.tFx.height, this.tFR.tFy, m);
            continue;
          }
          if (this.tFR.mrD != null) {
            this.tFR.mrD.addCallbackBuffer(paramArrayOfByte);
          }
        }
      }
      AppMethodBeat.o(5021);
      return;
      label616:
      j = 0;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.2
 * JD-Core Version:    0.7.0.1
 */