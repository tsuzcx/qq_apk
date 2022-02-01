package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean dIV()
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
    if ((!bs.isNullOrNil(this.xYf.xNz)) && (!bs.isNullOrNil(this.xYf.xNA)))
    {
      i = 1;
      if (i == 0) {
        break label622;
      }
      str1 = this.xYf.xNA;
      String str2 = this.xYf.getPath() + this.xYf.dIT();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label634;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = i.aSp(str2);
      if ((!this.xYG) && (!((String)localObject).contains("webp"))) {
        break label641;
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
      switch (i)
      {
      default: 
        localObject = new StringBuilder("donwload big pic isWebp ");
        if (i == 0)
        {
          bool = true;
          ac.i("MicroMsg.SnsDownloadImage", bool);
          l2 = i.aSp(this.xYf.getPath() + str1);
          h.wUl.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.dIi(), b.apb() });
          if (this.xYf.xYa == 3) {
            break label1469;
          }
        }
        break;
      }
      label641:
      label1469:
      for (i = 1;; i = 0)
      {
        int j = i;
        if (this.xYf.xMO != null)
        {
          j = i;
          if (this.xYf.xMO.xNy != 4)
          {
            j = i;
            if (this.xYf.xMO.xNy != 5) {
              j = 0;
            }
          }
        }
        if (j != 0)
        {
          localObject = q.d(this.dwE);
          if (i.eA(this.xYf.getPath() + (String)localObject)) {
            i.deleteFile(this.xYf.getPath() + (String)localObject);
          }
          l1 = bs.Gn();
          u.a(this.xYf.getPath(), str1, (String)localObject, af.dId());
          l1 = bs.aO(l1);
          i.aSp(this.xYf.getPath() + (String)localObject);
          h.wUl.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.dIi(), b.apb() });
          localObject = q.e(this.dwE);
          if (!i.eA(this.xYf.getPath() + (String)localObject)) {
            u.b(this.xYf.getPath(), str1, (String)localObject, af.dIc());
          }
        }
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label622:
        str1 = q.k(this.dwE);
        break label51;
        label634:
        localObject = "";
        break label124;
        if ((this.xYH) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1474;
        }
        i = 3;
        break label150;
        h.wUl.idkeyStat(22L, 64L, 1L, true);
        i.deleteFile(this.xYf.getPath() + str1);
        l1 = bs.Gn();
        u.d(this.xYf.getPath(), this.xYf.getPath() + this.xYf.dIT(), str1, false);
        l2 = bs.aO(l1);
        i.deleteFile(this.xYf.getPath() + this.xYf.dIT());
        l1 = bs.aO(l1);
        d.a(this.xYf.getPath() + str1, this.xYf.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        ac.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.xYf.getPath() + this.xYf.dIT() });
        i.deleteFile(this.xYf.getPath() + str1);
        l1 = bs.Gn();
        u.d(this.xYf.getPath(), this.xYf.getPath() + this.xYf.dIT(), str1, false);
        l2 = bs.aO(l1);
        i.deleteFile(this.xYf.getPath() + this.xYf.dIT());
        l1 = bs.aO(l1);
        d.a(this.xYf.getPath() + str1, this.xYf.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (q.atc(this.xYf.getPath() + this.xYf.dIT()))
        {
          ac.w("MicroMsg.SnsDownloadImage", "the " + this.xYf.mediaId + " is too max ! " + this.xYf.url);
          i.deleteFile(this.xYf.getPath() + str1);
          l1 = bs.Gn();
          u.d(this.xYf.getPath(), this.xYf.getPath() + this.xYf.dIT(), str1, false);
          l2 = bs.aO(l1);
          i.deleteFile(this.xYf.getPath() + this.xYf.dIT());
        }
        for (l1 = bs.aO(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.xYf.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          d.a(this.xYf.getPath() + str1, this.xYf.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          i.aT(this.xYf.getPath(), this.xYf.dIT(), str1);
        }
        bool = false;
        break label198;
      }
      label1474:
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