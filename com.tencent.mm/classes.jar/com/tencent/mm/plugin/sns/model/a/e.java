package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean bEs()
  {
    long l1 = -1L;
    int i;
    String str1;
    label46:
    BitmapFactory.Options localOptions;
    Object localObject;
    label124:
    long l3;
    if ((!bk.bl(this.ouO.omV)) && (!bk.bl(this.ouO.omW)))
    {
      i = 1;
      if (i == 0) {
        break label613;
      }
      str1 = this.ouO.omW;
      String str2 = this.ouO.getPath() + this.ouO.bEq();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(str2, localOptions, null, 0, new int[0]);
      if (localOptions.outMimeType == null) {
        break label625;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = com.tencent.mm.vfs.e.aeQ(str2);
      if ((!this.ovn) && (!((String)localObject).contains("webp"))) {
        break label632;
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
          y.i("MicroMsg.SnsDownloadImage", bool);
          l2 = com.tencent.mm.vfs.e.aeQ(this.ouO.getPath() + str1);
          h.nFQ.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.bDS(), com.tencent.mm.compatible.util.e.bkF });
          if (this.ouO.ouJ == 3) {
            break label1442;
          }
        }
        break;
      }
      label1442:
      for (i = 1;; i = 0)
      {
        int j = i;
        if (this.ouO.omO != null)
        {
          j = i;
          if (this.ouO.omO.omU != 4)
          {
            j = i;
            if (this.ouO.omO.omU != 5) {
              j = 0;
            }
          }
        }
        if (j != 0)
        {
          localObject = i.e(this.bZK);
          if (com.tencent.mm.vfs.e.bK(this.ouO.getPath() + (String)localObject)) {
            com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + (String)localObject);
          }
          l1 = bk.UZ();
          s.a(this.ouO.getPath(), str1, (String)localObject, af.bDO());
          l1 = bk.cp(l1);
          com.tencent.mm.vfs.e.aeQ(this.ouO.getPath() + (String)localObject);
          h.nFQ.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.bDS(), com.tencent.mm.compatible.util.e.bkF });
          localObject = i.f(this.bZK);
          if (!com.tencent.mm.vfs.e.bK(this.ouO.getPath() + (String)localObject)) {
            s.b(this.ouO.getPath(), str1, (String)localObject, af.bDN());
          }
        }
        return true;
        i = 0;
        break;
        label613:
        str1 = i.l(this.bZK);
        break label46;
        label625:
        localObject = "";
        break label124;
        label632:
        if ((!this.ovo) && (!((String)localObject).contains("vcodec"))) {
          break label1447;
        }
        i = 1;
        break label150;
        h.nFQ.a(22L, 64L, 1L, true);
        com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + str1);
        l1 = bk.UZ();
        s.d(this.ouO.getPath(), this.ouO.getPath() + this.ouO.bEq(), str1, false);
        l2 = bk.cp(l1);
        com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + this.ouO.bEq());
        l1 = bk.cp(l1);
        c.a(this.ouO.getPath() + str1, this.ouO.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label176;
        y.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.ouO.getPath() + this.ouO.bEq() });
        com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + str1);
        l1 = bk.UZ();
        s.d(this.ouO.getPath(), this.ouO.getPath() + this.ouO.bEq(), str1, false);
        l2 = bk.cp(l1);
        com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + this.ouO.bEq());
        l1 = bk.cp(l1);
        c.a(this.ouO.getPath() + str1, this.ouO.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label176;
        l2 = -1L;
        if (i.Nf(this.ouO.getPath() + this.ouO.bEq()))
        {
          y.w("MicroMsg.SnsDownloadImage", "the " + this.ouO.bUi + " is too max ! " + this.ouO.url);
          com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + str1);
          l1 = bk.UZ();
          s.ab(this.ouO.getPath(), this.ouO.getPath() + this.ouO.bEq(), str1);
          l2 = bk.cp(l1);
          com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + this.ouO.bEq());
        }
        for (l1 = bk.cp(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.ouO.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          c.a(this.ouO.getPath() + str1, this.ouO.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          com.tencent.mm.vfs.e.f(this.ouO.getPath(), this.ouO.bEq(), str1);
        }
        bool = false;
        break label194;
      }
      label1447:
      i = 2;
    }
  }
  
  protected final int bEt()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.e
 * JD-Core Version:    0.7.0.1
 */