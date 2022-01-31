package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import org.json.JSONObject;

final class SightCaptureUI$9$1
  implements Runnable
{
  SightCaptureUI$9$1(SightCaptureUI.9 param9, long paramLong) {}
  
  public final void run()
  {
    String str = SightCaptureUI.n(this.mqE.mqB).bjl();
    localavn = SightCaptureUI.J(this.mqE.mqB);
    for (;;)
    {
      try
      {
        if (!bk.bl(str))
        {
          boolean bool = e.bK(str);
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int n;
        int i1;
        com.tencent.mm.plugin.sight.base.a locala;
        y.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { localException.getMessage() });
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
        h.nFQ.a(440L, 88L, 1L, false);
        h.nFQ.a(440L, 48L, n, false);
        int k = 90;
        int j = 54;
        i = 50;
        continue;
        if (!j.mhB.bjd()) {
          continue;
        }
        j += 12;
        k += 2;
        int m = i + 12;
        i = k;
        k = m;
        continue;
        if ((n <= 10) || (n > 15)) {
          continue;
        }
        h.nFQ.a(440L, k + 1, 1L, false);
        continue;
        if ((n <= 15) || (n > 20)) {
          continue;
        }
        h.nFQ.a(440L, k + 2, 1L, false);
        continue;
        if ((n <= 20) || (n > 30)) {
          continue;
        }
        h.nFQ.a(440L, k + 3, 1L, false);
        continue;
        if (localavn.trc != 2) {
          continue;
        }
        h.nFQ.a(440L, 194L, i1, false);
        h.nFQ.a(440L, 195L, 1L, false);
        continue;
        h.nFQ.a(440L, 179L, i1, false);
        h.nFQ.a(440L, 180L, 1L, false);
        if (localavn == null) {
          continue;
        }
        if (localavn.trc != 1) {
          continue;
        }
        h.nFQ.a(440L, 189L, i1, false);
        h.nFQ.a(440L, 190L, 1L, false);
        continue;
        if (localavn.trc != 2) {
          continue;
        }
        h.nFQ.a(440L, 199L, i1, false);
        h.nFQ.a(440L, 200L, 1L, false);
        continue;
        m = i;
        i = k;
        k = m;
        continue;
      }
      k.d(false, this.mqD);
      return;
      h.nFQ.a(440L, 87L, 1L, false);
      localObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(str));
      n = (int)((JSONObject)localObject).getDouble("videoFPS");
      i1 = ((JSONObject)localObject).optInt("videoBitrate");
      y.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      localObject = com.tencent.mm.plugin.mmsight.model.a.biE();
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgd = j.mhB.dys;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).videoBitrate = j.mhB.videoBitrate;
      if (!j.mhB.mhL) {
        continue;
      }
      i = 1;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).dyt = i;
      if (!j.mhB.mhM) {
        continue;
      }
      i = 1;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).mge = i;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgf = j.mhB.mgf;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgg = n;
      ((com.tencent.mm.plugin.mmsight.model.a)localObject).fileSize = e.aeQ(str);
      locala = com.tencent.mm.plugin.sight.base.d.MH(str);
      if (locala != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgj = locala.width;
        ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgk = locala.height;
        ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgl = locala.videoBitrate;
        ((com.tencent.mm.plugin.mmsight.model.a)localObject).mgh = locala.jlu;
      }
      if (j.mhB.dys != 1) {
        continue;
      }
      h.nFQ.a(440L, 89L, 1L, false);
      h.nFQ.a(440L, 49L, n, false);
      k = 93;
      j = 73;
      i = 69;
      if (j.mhB.mgf != 720) {
        continue;
      }
      j += 6;
      m = k + 1;
      k = i + 6;
      i = m;
      h.nFQ.a(440L, j, n, false);
      h.nFQ.a(440L, i, 1L, false);
      h.nFQ.a(440L, 47L, n, false);
      y.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { str, Integer.valueOf(k) });
      if ((n < 0) || (n > 10)) {
        continue;
      }
      h.nFQ.a(440L, k, 1L, false);
      if (i1 > 0)
      {
        if (j.mhB.dys != 2) {
          continue;
        }
        h.nFQ.a(440L, 175L, i1, false);
        h.nFQ.a(440L, 176L, 1L, false);
        if (localavn != null)
        {
          if (localavn.trc != 1) {
            continue;
          }
          h.nFQ.a(440L, 184L, i1, false);
          h.nFQ.a(440L, 185L, 1L, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.9.1
 * JD-Core Version:    0.7.0.1
 */