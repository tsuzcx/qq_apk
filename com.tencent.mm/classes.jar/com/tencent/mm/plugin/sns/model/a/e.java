package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class e
  extends f
{
  public e(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final boolean duv()
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
    if ((!bt.isNullOrNil(this.wLz.wBe)) && (!bt.isNullOrNil(this.wLz.wBf)))
    {
      i = 1;
      if (i == 0) {
        break label622;
      }
      str1 = this.wLz.wBf;
      String str2 = this.wLz.getPath() + this.wLz.dut();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str2, localOptions);
      if (localOptions.outMimeType == null) {
        break label634;
      }
      localObject = localOptions.outMimeType.toLowerCase();
      l3 = i.aMN(str2);
      if ((!this.wMa) && (!((String)localObject).contains("webp"))) {
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
          ad.i("MicroMsg.SnsDownloadImage", bool);
          l2 = i.aMN(this.wLz.getPath() + str1);
          h.vKh.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.dtK(), b.aib() });
          if (this.wLz.wLu == 3) {
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
        if (this.wLz.wAv != null)
        {
          j = i;
          if (this.wLz.wAv.wBd != 4)
          {
            j = i;
            if (this.wLz.wAv.wBd != 5) {
              j = 0;
            }
          }
        }
        if (j != 0)
        {
          localObject = q.d(this.dyS);
          if (i.eK(this.wLz.getPath() + (String)localObject)) {
            i.deleteFile(this.wLz.getPath() + (String)localObject);
          }
          l1 = bt.GC();
          u.a(this.wLz.getPath(), str1, (String)localObject, af.dtF());
          l1 = bt.aS(l1);
          i.aMN(this.wLz.getPath() + (String)localObject);
          h.vKh.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2), Thread.currentThread().getName(), af.dtK(), b.aib() });
          localObject = q.e(this.dyS);
          if (!i.eK(this.wLz.getPath() + (String)localObject)) {
            u.b(this.wLz.getPath(), str1, (String)localObject, af.dtE());
          }
        }
        AppMethodBeat.o(96071);
        return true;
        i = 0;
        break;
        label622:
        str1 = q.k(this.dyS);
        break label51;
        label634:
        localObject = "";
        break label124;
        if ((this.wMb) || (((String)localObject).contains("vcodec")))
        {
          i = 1;
          break label150;
        }
        if (!((String)localObject).contains("wxam")) {
          break label1474;
        }
        i = 3;
        break label150;
        h.vKh.idkeyStat(22L, 64L, 1L, true);
        i.deleteFile(this.wLz.getPath() + str1);
        l1 = bt.GC();
        u.d(this.wLz.getPath(), this.wLz.getPath() + this.wLz.dut(), str1, false);
        l2 = bt.aS(l1);
        i.deleteFile(this.wLz.getPath() + this.wLz.dut());
        l1 = bt.aS(l1);
        d.a(this.wLz.getPath() + str1, this.wLz.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        ad.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[] { this.wLz.getPath() + this.wLz.dut() });
        i.deleteFile(this.wLz.getPath() + str1);
        l1 = bt.GC();
        u.d(this.wLz.getPath(), this.wLz.getPath() + this.wLz.dut(), str1, false);
        l2 = bt.aS(l1);
        i.deleteFile(this.wLz.getPath() + this.wLz.dut());
        l1 = bt.aS(l1);
        d.a(this.wLz.getPath() + str1, this.wLz.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, -1, l3, l2);
        break label180;
        l2 = -1L;
        if (q.anQ(this.wLz.getPath() + this.wLz.dut()))
        {
          ad.w("MicroMsg.SnsDownloadImage", "the " + this.wLz.mediaId + " is too max ! " + this.wLz.url);
          i.deleteFile(this.wLz.getPath() + str1);
          l1 = bt.GC();
          u.d(this.wLz.getPath(), this.wLz.getPath() + this.wLz.dut(), str1, false);
          l2 = bt.aS(l1);
          i.deleteFile(this.wLz.getPath() + this.wLz.dut());
        }
        for (l1 = bt.aS(l1);; l1 = 0L)
        {
          j = -1;
          if ((((String)localObject).contains("jpg")) || (((String)localObject).contains("jpeg")))
          {
            int k = MMNativeJpeg.queryQuality(this.wLz.getPath() + str1);
            j = k;
            if (k == 0) {
              j = -1;
            }
          }
          d.a(this.wLz.getPath() + str1, this.wLz.url, 0, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, j, l3, l2);
          break;
          i.aQ(this.wLz.getPath(), this.wLz.dut(), str1);
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