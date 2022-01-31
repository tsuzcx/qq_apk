package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.c.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.a.a.b;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$4
  implements Runnable
{
  a$4(a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.sight.base.a locala;
    int m;
    int k;
    int j;
    if (com.tencent.mm.bi.e.om(this.mpw.videoPath))
    {
      locala = null;
      if (locala == null) {
        break label108;
      }
      m = locala.width;
      k = locala.height;
      j = locala.videoBitrate;
    }
    label108:
    Object localObject;
    for (;;)
    {
      if ((m > 0) && (k > 0) && (j > 0)) {
        break label176;
      }
      y.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      return;
      locala = d.MH(this.mpw.videoPath);
      break;
      localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(this.mpw.videoPath);
      m = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), -1);
      k = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), -1);
      j = bk.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), -1);
      ((MediaMetadataRetriever)localObject).release();
    }
    label176:
    int n = j;
    int i;
    if (this.mpw.mpp)
    {
      n = j;
      if (this.mpw.mgW != null)
      {
        i = j;
        if (j > this.mpw.mgW.videoBitrate) {
          i = this.mpw.mgW.videoBitrate;
        }
        j = this.mpw.mgW.width;
        n = this.mpw.mgW.height;
        y.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + m + "], decoderOutputHeight = [" + k + "], specWidth = [" + j + "], specHeight = [" + n + "]");
        if ((m <= j) && (k <= n))
        {
          y.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
          localObject = null;
          n = i;
          if (localObject == null) {
            break label1533;
          }
          m = ((Point)localObject).x;
          k = ((Point)localObject).y;
        }
      }
    }
    for (;;)
    {
      localObject = this.mpw.videoPath + "remuxOutput.mp4";
      if (!bk.bl(this.mpw.mps)) {
        localObject = this.mpw.mps;
      }
      if ((k >= 2000) || (m >= 2000)) {
        this.mpw.mpt = 1;
      }
      if ((this.mpw.mpg >= 0) && (this.mpw.mph > 0)) {
        if ((this.mpw.mpt != -1) && ((this.mpw.mpt == 1) || (this.mpw.mpt == 2))) {
          this.mpw.mpm = com.tencent.mm.plugin.mmsight.api.a.mfF.a(this.mpw.mpt, this.mpw.videoPath, (String)localObject, m, k, i, this.mpw.mgW.fps, this.mpw.mpg, this.mpw.mph);
        }
      }
      for (;;)
      {
        y.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[] { Integer.valueOf(this.mpw.mpt), this.mpw.mpm });
        if (this.mpw.mpm != null) {
          break label1238;
        }
        ai.d(new a.4.1(this));
        return;
        int i4 = Math.max(m, k);
        int i3 = Math.min(m, k);
        int i1 = Math.max(j, n);
        int i2 = Math.min(j, n);
        if ((i4 % 16 == 0) && (Math.abs(i4 - i1) < 16) && (i3 % 16 == 0) && (Math.abs(i3 - i2) < 16))
        {
          y.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
          localObject = null;
          break;
        }
        if ((i4 / 2 == i1) && (i3 / 2 == i2))
        {
          y.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
          n = m / 2;
          i1 = k / 2;
          j = n;
          if (n % 2 != 0) {
            j = n + 1;
          }
          n = i1;
          if (i1 % 2 != 0) {
            n = i1 + 1;
          }
          localObject = new Point(j, n);
          break;
        }
        i4 /= 2;
        i3 /= 2;
        if ((i4 % 16 == 0) && (Math.abs(i4 - i1) < 16) && (i3 % 16 == 0) && (Math.abs(i3 - i2) < 16))
        {
          y.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
          n = m / 2;
          i1 = k / 2;
          j = n;
          if (n % 2 != 0) {
            j = n + 1;
          }
          n = i1;
          if (i1 % 2 != 0) {
            n = i1 + 1;
          }
          localObject = new Point(j, n);
          break;
        }
        localObject = new Point();
        double d;
        if (m < k)
        {
          j = Math.min(j, n);
          d = 1.0D * m / j;
          n = (int)(k / d);
        }
        for (;;)
        {
          i1 = n;
          if (n % 2 != 0) {
            i1 = n + 1;
          }
          n = j;
          if (j % 2 != 0) {
            n = j + 1;
          }
          y.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
          ((Point)localObject).x = n;
          ((Point)localObject).y = i1;
          break;
          n = Math.min(j, n);
          d = 1.0D * k / n;
          j = (int)(m / d);
        }
        this.mpw.mpm = com.tencent.mm.plugin.mmsight.api.a.mfF.a(this.mpw.videoPath, (String)localObject, m, k, i, this.mpw.mgW.fps, this.mpw.mpg, this.mpw.mph);
        continue;
        if ((this.mpw.mpt != -1) && ((this.mpw.mpt == 1) || (this.mpw.mpt == 2))) {
          this.mpw.mpm = com.tencent.mm.plugin.mmsight.api.a.mfF.a(this.mpw.mpt, this.mpw.videoPath, (String)localObject, m, k, i, this.mpw.mgW.fps);
        } else {
          this.mpw.mpm = com.tencent.mm.plugin.mmsight.api.a.mfF.b(this.mpw.videoPath, (String)localObject, m, k, i, this.mpw.mgW.fps);
        }
      }
      label1238:
      n.ug(this.mpw.mpm.getType());
      long l = bk.UZ();
      if (this.ara != null) {
        this.mpw.mpm.B(this.ara);
      }
      i = this.mpw.mpm.biD();
      if (i < 0)
      {
        y.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[] { Integer.valueOf(i) });
        ai.d(new a.4.2(this));
        n.uh(this.mpw.mpm.getType());
        return;
      }
      if (bk.bl(this.mpw.mps)) {
        com.tencent.mm.vfs.e.aA((String)localObject, this.mpw.videoPath);
      }
      l = bk.cp(l);
      y.i("MicroMsg.MMSightVideoEditor", "doRemuxVideo used %sms", new Object[] { Long.valueOf(l) });
      n.G(this.mpw.mpm.getType(), l);
      this.mpw.bIW = g.bQ(this.mpw.videoPath);
      localObject = this.mpw.mpu;
      boolean bool;
      if ((this.mpw.mpg >= 0) && (this.mpw.mph > 0))
      {
        bool = true;
        ((a.b)localObject).mlm = bool;
        this.mpw.mpu.mlj = (this.mpw.mph - this.mpw.mpg);
        localObject = this.mpw.mpu;
        if (locala != null) {
          break label1524;
        }
      }
      label1524:
      for (i = 0;; i = locala.jlu)
      {
        ((a.b)localObject).mli = i;
        ai.d(new a.4.3(this));
        return;
        bool = false;
        break;
      }
      label1533:
      i = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.4
 * JD-Core Version:    0.7.0.1
 */