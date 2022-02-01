package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.f;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class g
  extends h
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  private static void a(a parama, dmz paramdmz, String paramString, float paramFloat)
  {
    AppMethodBeat.i(309478);
    paramdmz = t.e(paramdmz);
    if (!y.ZC(parama.getPath() + paramdmz)) {
      aa.b(parama.getPath(), paramString, paramdmz, paramFloat);
    }
    AppMethodBeat.o(309478);
  }
  
  protected final int getMediaType()
  {
    return 1;
  }
  
  public final boolean hhI()
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
    if ((!Util.isNullOrNil(this.QzS.QnZ)) && (!Util.isNullOrNil(this.QzS.Qoa)))
    {
      i = 1;
      if (i == 0) {
        break label480;
      }
      str1 = this.QzS.Qoa;
      String str2 = this.QzS.getPath() + this.QzS.hhG();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label492;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = y.bEl(str2);
      if ((!this.QAu) && (!((String)localObject).contains("webp"))) {
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
          l2 = y.bEl(this.QzS.getPath() + str1);
          com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), al.hgV(), b.bmt() });
          if (this.QzS.QzN == 3) {
            break label1328;
          }
          i = 1;
          j = i;
          if (this.QzS.QmT != null)
          {
            j = i;
            if (this.QzS.QmT.QnY != 4)
            {
              j = i;
              if (this.QzS.QmT.QnY != 5) {
                j = 0;
              }
            }
          }
          if (j == 0) {
            break label1533;
          }
          localObject = t.d(this.ibT);
          if (1 != ((c)com.tencent.mm.kernel.h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yJb, 0)) {
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
        if ((i == 0) || (!y.ZC(this.QzS.getPath() + (String)localObject))) {
          break label1338;
        }
        a(this.QzS, this.ibT, str1, al.hgP());
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label480:
        str1 = t.k(this.ibT);
        break label51;
        label492:
        localObject = "";
        break label124;
        label499:
        if ((this.QAv) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1540;
        }
        i = 3;
        break label150;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 64L, 1L, true);
        y.deleteFile(this.QzS.getPath() + str1);
        l1 = Util.currentTicks();
        aa.i(this.QzS.getPath(), this.QzS.getPath() + this.QzS.hhG(), str1, false);
        l2 = Util.ticksToNow(l1);
        y.deleteFile(this.QzS.getPath() + this.QzS.hhG());
        l1 = Util.ticksToNow(l1);
        f.a(this.QzS.getPath() + str1, this.QzS.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        Log.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.QzS.getPath() + this.QzS.hhG() });
        y.deleteFile(this.QzS.getPath() + str1);
        l1 = Util.currentTicks();
        aa.i(this.QzS.getPath(), this.QzS.getPath() + this.QzS.hhG(), str1, false);
        l2 = Util.ticksToNow(l1);
        y.deleteFile(this.QzS.getPath() + this.QzS.hhG());
        l1 = Util.ticksToNow(l1);
        f.a(this.QzS.getPath() + str1, this.QzS.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (t.aXC(this.QzS.getPath() + this.QzS.hhG()))
        {
          Log.w("MicroMsg.SnsDownloadImage", "the " + this.QzS.mediaId + " is too max ! " + this.QzS.url);
          y.deleteFile(this.QzS.getPath() + str1);
          l1 = Util.currentTicks();
          aa.i(this.QzS.getPath(), this.QzS.getPath() + this.QzS.hhG(), str1, false);
          l2 = Util.ticksToNow(l1);
          y.deleteFile(this.QzS.getPath() + this.QzS.hhG());
        }
        for (l1 = Util.ticksToNow(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.QzS.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          f.a(this.QzS.getPath() + str1, this.QzS.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          y.bF(this.QzS.getPath(), this.QzS.hhG(), str1);
        }
        bool = false;
        break label198;
        i = 0;
        break label314;
      }
      label1338:
      if (y.ZC(this.QzS.getPath() + (String)localObject)) {
        y.deleteFile(this.QzS.getPath() + (String)localObject);
      }
      l1 = Util.currentTicks();
      aa.a(this.QzS.getPath(), str1, (String)localObject, al.hgQ());
      l1 = Util.ticksToNow(l1);
      y.bEl(this.QzS.getPath() + (String)localObject);
      com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), al.hgV(), b.bmt() });
      a(this.QzS, this.ibT, str1, al.hgP());
      label1533:
      AppMethodBeat.o(96071);
      return true;
      label1540:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.g
 * JD-Core Version:    0.7.0.1
 */