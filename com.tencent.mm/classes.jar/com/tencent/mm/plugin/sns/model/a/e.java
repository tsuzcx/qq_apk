package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean cpR()
  {
    AppMethodBeat.i(36750);
    long l1 = -1L;
    int i;
    String str1;
    label51:
    BitmapFactory.Options localOptions;
    Object localObject;
    label124:
    long l3;
    if ((!bo.isNullOrNil(this.rjH.rbk)) && (!bo.isNullOrNil(this.rjH.rbl)))
    {
      i = 1;
      if (i == 0) {
        break label618;
      }
      str1 = this.rjH.rbl;
      String str2 = this.rjH.getPath() + this.rjH.cpP();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label630;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = com.tencent.mm.vfs.e.avI(str2);
      if ((!this.rki) && (!((String)localObject).contains("webp"))) {
        break label637;
      }
      i = 0;
    }
    for (;;)
    {
      label150:
      label176:
      boolean bool;
      label194:
      long l2;
      switch (i)
      {
      default: 
        localObject = new StringBuilder("donwload big pic isWebp ");
        if (i == 0)
        {
          bool = true;
          ab.i("MicroMsg.SnsDownloadImage", bool);
          l2 = com.tencent.mm.vfs.e.avI(this.rjH.getPath() + str1);
          h.qsU.e(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
          if (this.rjH.rjC == 3) {
            break label1448;
          }
        }
        break;
      }
      label1448:
      for (i = 1;; i = 0)
      {
        int j = i;
        if (this.rjH.rbc != null)
        {
          j = i;
          if (this.rjH.rbc.rbj != 4)
          {
            j = i;
            if (this.rjH.rbc.rbj != 5) {
              j = 0;
            }
          }
        }
        if (j != 0)
        {
          localObject = i.e(this.cIc);
          if (com.tencent.mm.vfs.e.cN(this.rjH.getPath() + (String)localObject)) {
            com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + (String)localObject);
          }
          l1 = bo.yB();
          s.a(this.rjH.getPath(), str1, (String)localObject, ag.cpo());
          l1 = bo.av(l1);
          com.tencent.mm.vfs.e.avI(this.rjH.getPath() + (String)localObject);
          h.qsU.e(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
          localObject = i.f(this.cIc);
          if (!com.tencent.mm.vfs.e.cN(this.rjH.getPath() + (String)localObject)) {
            s.b(this.rjH.getPath(), str1, (String)localObject, ag.cpn());
          }
        }
        AppMethodBeat.o(36750);
        return true;
        i = 0;
        break;
        label618:
        str1 = i.l(this.cIc);
        break label51;
        label630:
        localObject = "";
        break label124;
        label637:
        if ((!this.rkj) && (!((String)localObject).contains("vcodec"))) {
          break label1453;
        }
        i = 1;
        break label150;
        h.qsU.idkeyStat(22L, 64L, 1L, true);
        com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + str1);
        l1 = bo.yB();
        s.d(this.rjH.getPath(), this.rjH.getPath() + this.rjH.cpP(), str1, false);
        l2 = bo.av(l1);
        com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + this.rjH.cpP());
        l1 = bo.av(l1);
        c.a(this.rjH.getPath() + str1, this.rjH.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label176;
        ab.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.rjH.getPath() + this.rjH.cpP() });
        com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + str1);
        l1 = bo.yB();
        s.d(this.rjH.getPath(), this.rjH.getPath() + this.rjH.cpP(), str1, false);
        l2 = bo.av(l1);
        com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + this.rjH.cpP());
        l1 = bo.av(l1);
        c.a(this.rjH.getPath() + str1, this.rjH.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label176;
        l2 = -1L;
        if (i.ZM(this.rjH.getPath() + this.rjH.cpP()))
        {
          ab.w("MicroMsg.SnsDownloadImage", "the " + this.rjH.cBO + " is too max ! " + this.rjH.url);
          com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + str1);
          l1 = bo.yB();
          s.an(this.rjH.getPath(), this.rjH.getPath() + this.rjH.cpP(), str1);
          l2 = bo.av(l1);
          com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + this.rjH.cpP());
        }
        for (l1 = bo.av(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.rjH.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          c.a(this.rjH.getPath() + str1, this.rjH.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          com.tencent.mm.vfs.e.h(this.rjH.getPath(), this.rjH.cpP(), str1);
        }
        bool = false;
        break label194;
      }
      label1453:
      i = 2;
    }
  }
  
  protected final int cpS()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.e
 * JD-Core Version:    0.7.0.1
 */