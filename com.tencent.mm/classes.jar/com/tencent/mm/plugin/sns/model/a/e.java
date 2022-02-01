package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static void a(a parama, bzh parambzh, String paramString, float paramFloat)
  {
    AppMethodBeat.i(219362);
    parambzh = r.e(parambzh);
    if (!o.fB(parama.getPath() + parambzh)) {
      u.b(parama.getPath(), paramString, parambzh, paramFloat);
    }
    AppMethodBeat.o(219362);
  }
  
  public final boolean dYJ()
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
    if ((!bu.isNullOrNil(this.zFt.zuj)) && (!bu.isNullOrNil(this.zFt.zuk)))
    {
      i = 1;
      if (i == 0) {
        break label480;
      }
      str1 = this.zFt.zuk;
      String str2 = this.zFt.getPath() + this.zFt.dYH();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      h.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label492;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = o.aZR(str2);
      if ((!this.zFU) && (!((String)localObject).contains("webp"))) {
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
          ae.i("MicroMsg.SnsDownloadImage", bool);
          l2 = o.aZR(this.zFt.getPath() + str1);
          com.tencent.mm.plugin.report.service.g.yxI.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
          if (this.zFt.zFo == 3) {
            break label1328;
          }
          i = 1;
          j = i;
          if (this.zFt.ztw != null)
          {
            j = i;
            if (this.zFt.ztw.zui != 4)
            {
              j = i;
              if (this.zFt.ztw.zui != 5) {
                j = 0;
              }
            }
          }
          if (j == 0) {
            break label1533;
          }
          localObject = r.d(this.dKe);
          if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxU, 0)) {
            break label1333;
          }
        }
        break;
      }
      label1328:
      label1333:
      for (i = 1;; i = 0)
      {
        if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED) || (j.DEBUG)) {
          i = 1;
        }
        if ((i == 0) || (!o.fB(this.zFt.getPath() + (String)localObject))) {
          break label1338;
        }
        a(this.zFt, this.dKe, str1, ah.dXP());
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label480:
        str1 = r.k(this.dKe);
        break label51;
        label492:
        localObject = "";
        break label124;
        label499:
        if ((this.zFV) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1540;
        }
        i = 3;
        break label150;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(22L, 64L, 1L, true);
        o.deleteFile(this.zFt.getPath() + str1);
        l1 = bu.HQ();
        u.d(this.zFt.getPath(), this.zFt.getPath() + this.zFt.dYH(), str1, false);
        l2 = bu.aO(l1);
        o.deleteFile(this.zFt.getPath() + this.zFt.dYH());
        l1 = bu.aO(l1);
        c.a(this.zFt.getPath() + str1, this.zFt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        ae.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.zFt.getPath() + this.zFt.dYH() });
        o.deleteFile(this.zFt.getPath() + str1);
        l1 = bu.HQ();
        u.d(this.zFt.getPath(), this.zFt.getPath() + this.zFt.dYH(), str1, false);
        l2 = bu.aO(l1);
        o.deleteFile(this.zFt.getPath() + this.zFt.dYH());
        l1 = bu.aO(l1);
        c.a(this.zFt.getPath() + str1, this.zFt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (r.azy(this.zFt.getPath() + this.zFt.dYH()))
        {
          ae.w("MicroMsg.SnsDownloadImage", "the " + this.zFt.mediaId + " is too max ! " + this.zFt.url);
          o.deleteFile(this.zFt.getPath() + str1);
          l1 = bu.HQ();
          u.d(this.zFt.getPath(), this.zFt.getPath() + this.zFt.dYH(), str1, false);
          l2 = bu.aO(l1);
          o.deleteFile(this.zFt.getPath() + this.zFt.dYH());
        }
        for (l1 = bu.aO(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.zFt.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          c.a(this.zFt.getPath() + str1, this.zFt.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          o.bc(this.zFt.getPath(), this.zFt.dYH(), str1);
        }
        bool = false;
        break label198;
        i = 0;
        break label314;
      }
      label1338:
      if (o.fB(this.zFt.getPath() + (String)localObject)) {
        o.deleteFile(this.zFt.getPath() + (String)localObject);
      }
      l1 = bu.HQ();
      u.a(this.zFt.getPath(), str1, (String)localObject, ah.dXQ());
      l1 = bu.aO(l1);
      o.aZR(this.zFt.getPath() + (String)localObject);
      com.tencent.mm.plugin.report.service.g.yxI.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
      a(this.zFt, this.dKe, str1, ah.dXP());
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