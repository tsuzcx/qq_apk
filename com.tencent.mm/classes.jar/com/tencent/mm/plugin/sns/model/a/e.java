package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static void a(a parama, cvt paramcvt, String paramString, float paramFloat)
  {
    AppMethodBeat.i(220857);
    paramcvt = t.e(paramcvt);
    if (!u.agG(parama.getPath() + paramcvt)) {
      r.b(parama.getPath(), paramString, paramcvt, paramFloat);
    }
    AppMethodBeat.o(220857);
  }
  
  public final boolean fPQ()
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
    if ((!Util.isNullOrNil(this.KcA.JRo)) && (!Util.isNullOrNil(this.KcA.JRp)))
    {
      i = 1;
      if (i == 0) {
        break label480;
      }
      str1 = this.KcA.JRp;
      String str2 = this.KcA.getPath() + this.KcA.fPO();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label492;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = u.bBQ(str2);
      if ((!this.Kdb) && (!((String)localObject).contains("webp"))) {
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
          l2 = u.bBQ(this.KcA.getPath() + str1);
          com.tencent.mm.plugin.report.service.h.IzE.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), aj.fPb(), com.tencent.mm.loader.j.b.aSF() });
          if (this.KcA.Kcv == 3) {
            break label1328;
          }
          i = 1;
          j = i;
          if (this.KcA.JQm != null)
          {
            j = i;
            if (this.KcA.JQm.JRn != 4)
            {
              j = i;
              if (this.KcA.JQm.JRn != 5) {
                j = 0;
              }
            }
          }
          if (j == 0) {
            break label1533;
          }
          localObject = t.d(this.fVT);
          if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vwa, 0)) {
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
        if ((i == 0) || (!u.agG(this.KcA.getPath() + (String)localObject))) {
          break label1338;
        }
        a(this.KcA, this.fVT, str1, aj.fOV());
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label480:
        str1 = t.k(this.fVT);
        break label51;
        label492:
        localObject = "";
        break label124;
        label499:
        if ((this.Kdc) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1540;
        }
        i = 3;
        break label150;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(22L, 64L, 1L, true);
        u.deleteFile(this.KcA.getPath() + str1);
        l1 = Util.currentTicks();
        r.h(this.KcA.getPath(), this.KcA.getPath() + this.KcA.fPO(), str1, false);
        l2 = Util.ticksToNow(l1);
        u.deleteFile(this.KcA.getPath() + this.KcA.fPO());
        l1 = Util.ticksToNow(l1);
        com.tencent.mm.plugin.sns.k.e.a(this.KcA.getPath() + str1, this.KcA.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        Log.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.KcA.getPath() + this.KcA.fPO() });
        u.deleteFile(this.KcA.getPath() + str1);
        l1 = Util.currentTicks();
        r.h(this.KcA.getPath(), this.KcA.getPath() + this.KcA.fPO(), str1, false);
        l2 = Util.ticksToNow(l1);
        u.deleteFile(this.KcA.getPath() + this.KcA.fPO());
        l1 = Util.ticksToNow(l1);
        com.tencent.mm.plugin.sns.k.e.a(this.KcA.getPath() + str1, this.KcA.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (t.aZr(this.KcA.getPath() + this.KcA.fPO()))
        {
          Log.w("MicroMsg.SnsDownloadImage", "the " + this.KcA.mediaId + " is too max ! " + this.KcA.url);
          u.deleteFile(this.KcA.getPath() + str1);
          l1 = Util.currentTicks();
          r.h(this.KcA.getPath(), this.KcA.getPath() + this.KcA.fPO(), str1, false);
          l2 = Util.ticksToNow(l1);
          u.deleteFile(this.KcA.getPath() + this.KcA.fPO());
        }
        for (l1 = Util.ticksToNow(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.KcA.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          com.tencent.mm.plugin.sns.k.e.a(this.KcA.getPath() + str1, this.KcA.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          u.bj(this.KcA.getPath(), this.KcA.fPO(), str1);
        }
        bool = false;
        break label198;
        i = 0;
        break label314;
      }
      label1338:
      if (u.agG(this.KcA.getPath() + (String)localObject)) {
        u.deleteFile(this.KcA.getPath() + (String)localObject);
      }
      l1 = Util.currentTicks();
      r.a(this.KcA.getPath(), str1, (String)localObject, aj.fOW());
      l1 = Util.ticksToNow(l1);
      u.bBQ(this.KcA.getPath() + (String)localObject);
      com.tencent.mm.plugin.report.service.h.IzE.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), aj.fPb(), com.tencent.mm.loader.j.b.aSF() });
      a(this.KcA, this.fVT, str1, aj.fOV());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.e
 * JD-Core Version:    0.7.0.1
 */