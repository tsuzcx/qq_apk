package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.g;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.g.d.a;
import com.tencent.mm.media.g.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.m;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;

final class b$4
  implements Runnable
{
  b$4(b paramb, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(55145);
    int k;
    int j;
    int i;
    if (com.tencent.mm.bj.e.vB(b.g(this.oOV)))
    {
      ??? = null;
      if (??? == null) {
        break label109;
      }
      k = ((com.tencent.mm.plugin.sight.base.a)???).width;
      j = ((com.tencent.mm.plugin.sight.base.a)???).height;
      i = ((com.tencent.mm.plugin.sight.base.a)???).videoBitrate;
    }
    for (;;)
    {
      if ((k > 0) && (j > 0) && (i > 0)) {
        break label174;
      }
      ab.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(55145);
      return;
      ??? = com.tencent.mm.plugin.sight.base.d.Zo(b.g(this.oOV));
      break;
      label109:
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(b.g(this.oOV));
      k = bo.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), -1);
      j = bo.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), -1);
      i = bo.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), -1);
      ((MediaMetadataRetriever)localObject2).release();
    }
    label174:
    if ((j >= 2000) || (k >= 2000))
    {
      b.y(this.oOV);
      ab.i("MicroMsg.MMSightVideoEditor", "video size too large, change to mediacodec remuxer");
    }
    int i2 = i;
    int i1 = j;
    int m = k;
    if (b.b(this.oOV))
    {
      i2 = i;
      i1 = j;
      m = k;
      if (b.l(this.oOV) != null)
      {
        int n = i;
        if (i > b.l(this.oOV).videoBitrate) {
          n = b.l(this.oOV).videoBitrate;
        }
        localObject2 = b.B(k, j, b.l(this.oOV).width, b.l(this.oOV).height);
        i2 = n;
        i1 = j;
        m = k;
        if (localObject2 != null)
        {
          m = ((Point)localObject2).x;
          i1 = ((Point)localObject2).y;
          i2 = n;
        }
      }
    }
    Object localObject2 = b.g(this.oOV) + "remuxOutput.mp4";
    if (!bo.isNullOrNil(b.z(this.oOV))) {
      localObject2 = b.z(this.oOV);
    }
    for (;;)
    {
      ab.i("MicroMsg.MMSightVideoEditor", "Previous data width, height: %d  %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i1) });
      ab.i("MicroMsg.MMSightVideoEditor", "Hseasun Adaptive Bitrate Methods:%d %d  %d  %d  %d %d %d", new Object[] { Integer.valueOf(b.l(this.oOV).fAh), Integer.valueOf(b.l(this.oOV).fAj), Integer.valueOf(b.l(this.oOV).fAk), Integer.valueOf(b.l(this.oOV).fAl), Integer.valueOf(b.l(this.oOV).fAm), Integer.valueOf(b.A(this.oOV)), Integer.valueOf(512) });
      int[] arrayOfInt;
      if ((b.l(this.oOV).fAh == 2) && ((b.A(this.oOV) == 2) || (b.A(this.oOV) == 512)))
      {
        ab.i("MicroMsg.MMSightVideoEditor", "ABA: Videopath:%s Height: %d Width: %d fps: %d VideoBitrate: %d  Duration: %d StartTime: %d\n", new Object[] { b.g(this.oOV), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(b.l(this.oOV).fps), Integer.valueOf(b.l(this.oOV).videoBitrate), Integer.valueOf((b.c(this.oOV) - b.s(this.oOV)) / 1000), Integer.valueOf(b.s(this.oOV) / 1000) });
        arrayOfInt = AdaptiveAdjustBitrate.GetBitrate(b.g(this.oOV), i1, m, b.l(this.oOV).fps, b.l(this.oOV).videoBitrate, (b.c(this.oOV) - b.s(this.oOV)) / 1000, b.s(this.oOV) / 1000, 2, b.l(this.oOV).fAj, b.l(this.oOV).fAk, b.l(this.oOV).fAl, b.l(this.oOV).fAm);
        i2 = arrayOfInt[0] * 1000;
        j = arrayOfInt[1];
        i = arrayOfInt[2];
        ab.i("MicroMsg.MMSightVideoEditor", "ABA: Adaptive Bitrate Methods: [%d] [%d]  [%d]", new Object[] { Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
      }
      for (;;)
      {
        if ((com.tencent.mm.bj.e.vB(b.g(this.oOV))) || (b.B(this.oOV) == 1))
        {
          ab.i("MicroMsg.MMSightVideoEditor", "h265 format, try mediaCodec remuxer or is suggestRemuxerType is mediacodec");
          ??? = new d.b()
          {
            public final void mP(String paramAnonymousString)
            {
              AppMethodBeat.i(55140);
              ab.i("MicroMsg.MMSightVideoEditor", "mediaCodecRemuxer remux onFinish");
              synchronized (b.bRX())
              {
                try
                {
                  b.bRX().notifyAll();
                  if (bo.isNullOrNil(paramAnonymousString))
                  {
                    al.d(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(55138);
                        if (b.v(b.4.this.oOV) != null) {
                          b.v(b.4.this.oOV).dismiss();
                        }
                        if (b.a(b.4.this.oOV) != null) {
                          b.a(b.4.this.oOV).onError();
                        }
                        AppMethodBeat.o(55138);
                      }
                    });
                    m.zv(b.C(b.4.this.oOV).getType());
                    AppMethodBeat.o(55140);
                    return;
                  }
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    ab.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "wait mediaCodecRemuxer error", new Object[0]);
                  }
                }
              }
              if (bo.isNullOrNil(b.z(b.4.this.oOV))) {
                com.tencent.mm.vfs.e.aT(this.hvl, paramAnonymousString);
              }
              long l = bo.av(this.ngG);
              ab.i("MicroMsg.MMSightVideoEditor", "doRemuxVideo used %sms", new Object[] { Long.valueOf(l) });
              m.W(1, l);
              b.a(b.4.this.oOV, g.getMD5(paramAnonymousString));
              paramAnonymousString = b.D(b.4.this.oOV);
              boolean bool;
              if ((b.s(b.4.this.oOV) >= 0) && (b.c(b.4.this.oOV) > 0))
              {
                bool = true;
                paramAnonymousString.oKs = bool;
                b.D(b.4.this.oOV).oKp = (b.c(b.4.this.oOV) - b.s(b.4.this.oOV));
                paramAnonymousString = b.D(b.4.this.oOV);
                if (this.oOY != null) {
                  break label300;
                }
              }
              label300:
              for (int i = 0;; i = this.oOY.eVA)
              {
                paramAnonymousString.oKo = i;
                al.d(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(55139);
                    if (b.v(b.4.this.oOV) != null) {
                      b.v(b.4.this.oOV).dismiss();
                    }
                    if (b.a(b.4.this.oOV) != null) {
                      b.a(b.4.this.oOV).bRC();
                    }
                    AppMethodBeat.o(55139);
                  }
                });
                AppMethodBeat.o(55140);
                return;
                bool = false;
                break;
              }
            }
          };
          if ((b.s(this.oOV) >= 0) && (b.c(this.oOV) > 0)) {
            b.a(this.oOV, com.tencent.mm.media.g.d.eWu.a(b.g(this.oOV), (String)localObject2, j, i, i2, b.l(this.oOV).fps, b.s(this.oOV), b.c(this.oOV), (d.b)???));
          }
          for (;;)
          {
            ab.i("MicroMsg.MMSightVideoEditor", "create mediaCodecVideoRemuxer: %s", new Object[] { b.E(this.oOV) });
            if (b.E(this.oOV) != null) {
              break;
            }
            al.d(new b.4.2(this));
            AppMethodBeat.o(55145);
            return;
            b.a(this.oOV, com.tencent.mm.media.g.d.eWu.a(b.g(this.oOV), (String)localObject2, j, i, i2, b.l(this.oOV).fps, (d.b)???));
          }
          if (this.val$bitmap != null) {
            b.E(this.oOV).p(this.val$bitmap);
          }
          b.E(this.oOV).Va();
          synchronized (b.bRX())
          {
            try
            {
              b.bRX().wait();
              AppMethodBeat.o(55145);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.MMSightVideoEditor", localException, "wait mediaCodecRemux error", new Object[0]);
              }
            }
          }
        }
        if ((b.s(this.oOV) >= 0) && (b.c(this.oOV) > 0)) {
          if ((b.B(this.oOV) != -1) && ((b.B(this.oOV) == 1) || (b.B(this.oOV) == 2))) {
            b.a(this.oOV, com.tencent.mm.plugin.mmsight.api.a.oGf.a(b.B(this.oOV), b.g(this.oOV), str, j, i, i2, b.l(this.oOV).fps, b.s(this.oOV), b.c(this.oOV), b.l(this.oOV).fAn, b.l(this.oOV).fAo));
          }
        }
        for (;;)
        {
          ab.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[] { Integer.valueOf(b.B(this.oOV)), b.C(this.oOV) });
          if (b.C(this.oOV) != null) {
            break;
          }
          al.d(new b.4.3(this));
          AppMethodBeat.o(55145);
          return;
          b.a(this.oOV, com.tencent.mm.plugin.mmsight.api.a.oGf.a(b.g(this.oOV), str, j, i, i2, b.l(this.oOV).fps, b.s(this.oOV), b.c(this.oOV), b.l(this.oOV).fAn, b.l(this.oOV).fAo));
          continue;
          if ((b.B(this.oOV) != -1) && ((b.B(this.oOV) == 1) || (b.B(this.oOV) == 2))) {
            b.a(this.oOV, com.tencent.mm.plugin.mmsight.api.a.oGf.a(b.B(this.oOV), b.g(this.oOV), str, j, i, i2, b.l(this.oOV).fps, b.l(this.oOV).fAn, b.l(this.oOV).fAo));
          } else {
            b.a(this.oOV, com.tencent.mm.plugin.mmsight.api.a.oGf.a(b.g(this.oOV), str, j, i, i2, b.l(this.oOV).fps, b.l(this.oOV).fAn, b.l(this.oOV).fAo));
          }
        }
        m.zu(b.C(this.oOV).getType());
        long l = bo.yB();
        boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
        j = WXHardCoderJNI.hcEncodeVideoDelay;
        k = WXHardCoderJNI.hcEncodeVideoCPU;
        m = WXHardCoderJNI.hcEncodeVideoIO;
        if (WXHardCoderJNI.hcEncodeVideoThr) {}
        for (i = Process.myTid();; i = 0)
        {
          b.zy(WXHardCoderJNI.startPerformance(bool, j, k, m, i, 30000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.MMSightVideoEditor"));
          ab.i("MicroMsg.MMSightVideoEditor", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(b.bRY()) });
          if (this.val$bitmap != null) {
            b.C(this.oOV).p(this.val$bitmap);
          }
          i = b.C(this.oOV).Va();
          if (i >= 0) {
            break;
          }
          ab.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[] { Integer.valueOf(i) });
          al.d(new b.4.4(this));
          m.zv(b.C(this.oOV).getType());
          AppMethodBeat.o(55145);
          return;
        }
        if (bo.isNullOrNil(b.z(this.oOV))) {
          com.tencent.mm.vfs.e.aT(str, b.g(this.oOV));
        }
        if (b.bRY() != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, b.bRY());
          ab.i("MicroMsg.MMSightVideoEditor", "hardcoder summerPerformance stopPerformace %s", new Object[] { Integer.valueOf(b.bRY()) });
          b.zy(0);
        }
        com.tencent.mm.plugin.mmsight.a.a.b localb;
        if ((b.l(this.oOV).fAh == 2) && ((b.A(this.oOV) == 2) || (b.A(this.oOV) == 512)))
        {
          SightVideoJNI.addReportMetadata(str, arrayOfInt, b.l(this.oOV).fAh, 0);
          l = bo.av(l);
          ab.i("MicroMsg.MMSightVideoEditor", "doRemuxVideo used %sms", new Object[] { Long.valueOf(l) });
          m.W(b.C(this.oOV).getType(), l);
          b.a(this.oOV, g.getMD5(b.g(this.oOV)));
          localb = b.D(this.oOV);
          if ((b.s(this.oOV) < 0) || (b.c(this.oOV) <= 0)) {
            break label2118;
          }
          bool = true;
          label1975:
          localb.oKs = bool;
          b.D(this.oOV).oKp = (b.c(this.oOV) - b.s(this.oOV));
          localb = b.D(this.oOV);
          if (??? != null) {
            break label2124;
          }
        }
        label2118:
        label2124:
        for (i = 0;; i = ((com.tencent.mm.plugin.sight.base.a)???).eVA)
        {
          localb.oKo = i;
          al.d(new b.4.5(this));
          AppMethodBeat.o(55145);
          return;
          if ((b.l(this.oOV).fAi <= 0) || (b.l(this.oOV).fAh == 2) || ((b.A(this.oOV) != 2) && (b.A(this.oOV) != 512))) {
            break;
          }
          SightVideoJNI.addReportMetadata(localb, arrayOfInt, 0, b.l(this.oOV).fAi);
          break;
          bool = false;
          break label1975;
        }
        arrayOfInt = new int[] { -1 };
        i = i1;
        j = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.4
 * JD-Core Version:    0.7.0.1
 */