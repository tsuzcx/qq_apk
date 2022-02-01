package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static void a(a parama, byn parambyn, String paramString, float paramFloat)
  {
    AppMethodBeat.i(197868);
    parambyn = q.e(parambyn);
    if (!com.tencent.mm.vfs.i.fv(parama.getPath() + parambyn)) {
      u.b(parama.getPath(), paramString, parambyn, paramFloat);
    }
    AppMethodBeat.o(197868);
  }
  
  public final boolean dVi()
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
    if ((!bt.isNullOrNil(this.zoe.zdt)) && (!bt.isNullOrNil(this.zoe.zdu)))
    {
      i = 1;
      if (i == 0) {
        break label480;
      }
      str1 = this.zoe.zdu;
      String str2 = this.zoe.getPath() + this.zoe.dVg();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label492;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = com.tencent.mm.vfs.i.aYo(str2);
      if ((!this.zoF) && (!((String)localObject).contains("webp"))) {
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
          ad.i("MicroMsg.SnsDownloadImage", bool);
          l2 = com.tencent.mm.vfs.i.aYo(this.zoe.getPath() + str1);
          com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
          if (this.zoe.znZ == 3) {
            break label1328;
          }
          i = 1;
          j = i;
          if (this.zoe.zcG != null)
          {
            j = i;
            if (this.zoe.zcG.zds != 4)
            {
              j = i;
              if (this.zoe.zcG.zds != 5) {
                j = 0;
              }
            }
          }
          if (j == 0) {
            break label1533;
          }
          localObject = q.d(this.dIQ);
          if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qrf, 0)) {
            break label1333;
          }
        }
        break;
      }
      label1328:
      label1333:
      for (i = 1;; i = 0)
      {
        if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG)) {
          i = 1;
        }
        if ((i == 0) || (!com.tencent.mm.vfs.i.fv(this.zoe.getPath() + (String)localObject))) {
          break label1338;
        }
        a(this.zoe, this.dIQ, str1, ag.dUp());
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label480:
        str1 = q.k(this.dIQ);
        break label51;
        label492:
        localObject = "";
        break label124;
        label499:
        if ((this.zoG) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1540;
        }
        i = 3;
        break label150;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 64L, 1L, true);
        com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + str1);
        l1 = bt.HI();
        u.d(this.zoe.getPath(), this.zoe.getPath() + this.zoe.dVg(), str1, false);
        l2 = bt.aO(l1);
        com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + this.zoe.dVg());
        l1 = bt.aO(l1);
        c.a(this.zoe.getPath() + str1, this.zoe.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        ad.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.zoe.getPath() + this.zoe.dVg() });
        com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + str1);
        l1 = bt.HI();
        u.d(this.zoe.getPath(), this.zoe.getPath() + this.zoe.dVg(), str1, false);
        l2 = bt.aO(l1);
        com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + this.zoe.dVg());
        l1 = bt.aO(l1);
        c.a(this.zoe.getPath() + str1, this.zoe.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (q.ayh(this.zoe.getPath() + this.zoe.dVg()))
        {
          ad.w("MicroMsg.SnsDownloadImage", "the " + this.zoe.mediaId + " is too max ! " + this.zoe.url);
          com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + str1);
          l1 = bt.HI();
          u.d(this.zoe.getPath(), this.zoe.getPath() + this.zoe.dVg(), str1, false);
          l2 = bt.aO(l1);
          com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + this.zoe.dVg());
        }
        for (l1 = bt.aO(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.zoe.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          c.a(this.zoe.getPath() + str1, this.zoe.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          com.tencent.mm.vfs.i.bb(this.zoe.getPath(), this.zoe.dVg(), str1);
        }
        bool = false;
        break label198;
        i = 0;
        break label314;
      }
      label1338:
      if (com.tencent.mm.vfs.i.fv(this.zoe.getPath() + (String)localObject)) {
        com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + (String)localObject);
      }
      l1 = bt.HI();
      u.a(this.zoe.getPath(), str1, (String)localObject, ag.dUq());
      l1 = bt.aO(l1);
      com.tencent.mm.vfs.i.aYo(this.zoe.getPath() + (String)localObject);
      com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
      a(this.zoe, this.dIQ, str1, ag.dUp());
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