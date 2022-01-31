package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements Camera.PreviewCallback
{
  a$2(a parama) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      h.nFQ.a(159L, 0L, 1L, false);
      h.nFQ.a(159L, 3L, 1L, false);
      if (this.qao.qac != null) {
        this.qao.qac.blN();
      }
    }
    do
    {
      return;
      if (this.qao.pZV == null)
      {
        y.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
        return;
      }
    } while (this.qao.qac == null);
    int m = 1;
    int j;
    int k;
    int i;
    if (this.qao.pZM)
    {
      j = j.qbP;
      k = j;
      if (!q.dyd.dwd) {
        break label548;
      }
      k = j;
      if (q.dyd.dwc.rotate == 0) {
        break label548;
      }
      i = q.dyd.dwc.dwH;
      m = 1;
      k = j;
      j = m;
    }
    for (;;)
    {
      label163:
      boolean bool;
      if (k > 0)
      {
        m = 32;
        paramCamera = this.qao;
        if ((j != 0) || (k <= 0)) {
          break label494;
        }
        bool = true;
        label181:
        paramCamera.pZN = bool;
        k = this.qao.pZV.width;
        int n = this.qao.pZV.height;
        if (j == 0) {
          break label500;
        }
        if (this.qao.qaf == null)
        {
          j = k * n * 3 / 2;
          this.qao.qaf = new byte[j];
          this.qao.qaf[0] = 90;
        }
        Object localObject = b.bPx();
        j = paramArrayOfByte.length;
        int i1 = this.qao.pZW;
        paramCamera = this.qao.qaf;
        int i2 = this.qao.qaf.length;
        localObject = ((r)localObject).pTq.pNq.pQg;
        if ((((l)localObject).iEu != l.iEt) && (((l)localObject).pNq.pQe.isInited) && (((l)localObject).pNq.bQc())) {
          ((l)localObject).pNq.pQe.videoRorate90D(paramArrayOfByte, j, k, n, i1, paramCamera, i2, k, n, i);
        }
        this.qao.qac.a(this.qao.qaf, this.qao.qaf.length, k, n, this.qao.pZW, m);
      }
      for (;;)
      {
        if (d.bSj() < 8) {
          break label546;
        }
        this.qao.mCamera.addCallbackBuffer(paramArrayOfByte);
        return;
        i = j.qbQ;
        k = i;
        if (!q.dyd.dwf) {
          break label548;
        }
        k = i;
        if (q.dyd.dwe.rotate == 0) {
          break label548;
        }
        m = q.dyd.dwe.dwH;
        j = 1;
        k = i;
        i = m;
        break;
        m = 0;
        break label163;
        label494:
        bool = false;
        break label181;
        label500:
        this.qao.qac.a(paramArrayOfByte, paramArrayOfByte.length, this.qao.pZV.width, this.qao.pZV.height, this.qao.pZW, m);
      }
      label546:
      break;
      label548:
      j = 0;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.2
 * JD-Core Version:    0.7.0.1
 */