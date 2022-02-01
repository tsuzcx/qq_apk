package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static void a(a parama, cnb paramcnb, String paramString, float paramFloat)
  {
    AppMethodBeat.i(202798);
    paramcnb = com.tencent.mm.plugin.sns.data.r.f(paramcnb);
    if (!s.YS(parama.getPath() + paramcnb)) {
      com.tencent.mm.plugin.sns.storage.r.b(parama.getPath(), paramString, paramcnb, paramFloat);
    }
    AppMethodBeat.o(202798);
  }
  
  public final boolean fbX()
  {
    AppMethodBeat.i(96071);
    long l1 = -1L;
    int i;
    String str1;
    label51:
    BitmapFactory.Options localOptions;
    Object localObject;
    label124:
    long l3;
    if ((!Util.isNullOrNil(this.DPt.DEt)) && (!Util.isNullOrNil(this.DPt.DEu)))
    {
      i = 1;
      if (i == 0) {
        break label480;
      }
      str1 = this.DPt.DEu;
      String str2 = this.DPt.getPath() + this.DPt.fbV();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label492;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = s.boW(str2);
      if ((!this.DPU) && (!((String)localObject).contains("webp"))) {
        break label499;
      }
      i = 0;
    }
    for (;;)
    {
      label150:
      label180:
      boolean bool;
      label198:
      long l2;
      label314:
      int j;
      switch (i)
      {
      default: 
        localObject = new StringBuilder("donwload big pic isWebp ");
        if (i == 0)
        {
          bool = true;
          Log.i("MicroMsg.SnsDownloadImage", bool);
          l2 = s.boW(this.DPt.getPath() + str1);
          h.CyF.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
          if (this.DPt.DPo == 3) {
            break label1328;
          }
          i = 1;
          j = i;
          if (this.DPt.DDH != null)
          {
            j = i;
            if (this.DPt.DDH.DEs != 4)
            {
              j = i;
              if (this.DPt.DDH.DEs != 5) {
                j = 0;
              }
            }
          }
          if (j == 0) {
            break label1533;
          }
          localObject = com.tencent.mm.plugin.sns.data.r.e(this.ebR);
          if (1 != ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPP, 0)) {
            break label1333;
          }
        }
        break;
      }
      label1328:
      label1333:
      for (i = 1;; i = 0)
      {
        if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
          i = 1;
        }
        if ((i == 0) || (!s.YS(this.DPt.getPath() + (String)localObject))) {
          break label1338;
        }
        a(this.DPt, this.ebR, str1, aj.fbb());
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label480:
        str1 = com.tencent.mm.plugin.sns.data.r.l(this.ebR);
        break label51;
        label492:
        localObject = "";
        break label124;
        label499:
        if ((this.DPV) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1540;
        }
        i = 3;
        break label150;
        h.CyF.idkeyStat(22L, 64L, 1L, true);
        s.deleteFile(this.DPt.getPath() + str1);
        l1 = Util.currentTicks();
        com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), str1, false);
        l2 = Util.ticksToNow(l1);
        s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
        l1 = Util.ticksToNow(l1);
        c.a(this.DPt.getPath() + str1, this.DPt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        Log.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.DPt.getPath() + this.DPt.fbV() });
        s.deleteFile(this.DPt.getPath() + str1);
        l1 = Util.currentTicks();
        com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), str1, false);
        l2 = Util.ticksToNow(l1);
        s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
        l1 = Util.ticksToNow(l1);
        c.a(this.DPt.getPath() + str1, this.DPt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (com.tencent.mm.plugin.sns.data.r.aOv(this.DPt.getPath() + this.DPt.fbV()))
        {
          Log.w("MicroMsg.SnsDownloadImage", "the " + this.DPt.mediaId + " is too max ! " + this.DPt.url);
          s.deleteFile(this.DPt.getPath() + str1);
          l1 = Util.currentTicks();
          com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), str1, false);
          l2 = Util.ticksToNow(l1);
          s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
        }
        for (l1 = Util.ticksToNow(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.DPt.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          c.a(this.DPt.getPath() + str1, this.DPt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          s.bo(this.DPt.getPath(), this.DPt.fbV(), str1);
        }
        bool = false;
        break label198;
        i = 0;
        break label314;
      }
      label1338:
      if (s.YS(this.DPt.getPath() + (String)localObject)) {
        s.deleteFile(this.DPt.getPath() + (String)localObject);
      }
      l1 = Util.currentTicks();
      com.tencent.mm.plugin.sns.storage.r.a(this.DPt.getPath(), str1, (String)localObject, aj.fbc());
      l1 = Util.ticksToNow(l1);
      s.boW(this.DPt.getPath() + (String)localObject);
      h.CyF.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
      a(this.DPt, this.ebR, str1, aj.fbb());
      label1533:
      AppMethodBeat.o(96071);
      return true;
      label1540:
      i = 2;
    }
  }
  
  protected final int getMediaType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.e
 * JD-Core Version:    0.7.0.1
 */