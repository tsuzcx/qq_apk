package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
  extends f
{
  private boolean dVs = false;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    h.nFQ.a(150L, 10L, 1L, true);
  }
  
  public final boolean bEs()
  {
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.ouO.omO != null)
    {
      str2 = com.tencent.mm.plugin.sns.data.i.e(this.bZK);
      this.dVs = s.OR(this.ouO.getPath() + this.ouO.bEq());
      if (this.ovn) {
        this.dVs = true;
      }
      if (this.dVs) {
        h.nFQ.a(22L, 64L, 1L, true);
      }
      str3 = this.ouO.getPath() + this.ouO.bEq();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(str3, localOptions, null, 0, new int[0]);
      if (localOptions.outMimeType == null) {
        break label1087;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bk.bl(localOptions.outMimeType))) {
        h.nFQ.a(150L, 35L, 1L, true);
      }
      if ((!str1.contains("jpg")) && (!str1.contains("jpeg"))) {
        break label1119;
      }
      int j = MMNativeJpeg.queryQuality(str3);
      i = j;
      if (j != 0) {}
    }
    label1087:
    label1095:
    label1119:
    for (int i = -1;; i = -1)
    {
      long l1 = com.tencent.mm.vfs.e.aeQ(str3);
      if (l1 <= 0L) {
        h.nFQ.a(150L, 23L, 1L, true);
      }
      long l2 = bk.UZ();
      str1 = com.tencent.mm.plugin.sns.data.i.i(this.bZK);
      com.tencent.mm.vfs.e.r(this.ouO.getPath() + this.ouO.bEq(), this.ouO.getPath() + str1);
      y.v("MicroMsg.SnsDownloadThumb", "file src" + com.tencent.mm.vfs.e.bK(new StringBuilder().append(this.ouO.getPath()).append(str1).toString()));
      long l3 = bk.UZ();
      if (!s.a(this.ouO.getPath(), this.ouO.bEq(), str2, af.bDO()))
      {
        y.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.nFQ.a(150L, 27L, 1L, true);
      }
      l3 = bk.cp(l3);
      boolean bool = com.tencent.mm.vfs.e.bK(this.ouO.getPath() + this.ouO.bEq());
      com.tencent.mm.vfs.e.deleteFile(this.ouO.getPath() + this.ouO.bEq());
      l2 = bk.cp(l2);
      if (!com.tencent.mm.vfs.e.bK(this.ouO.getPath() + str2))
      {
        y.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.aeQ(this.ouO.getPath() + str2)) });
        h.nFQ.a(150L, 31L, 1L, true);
        if ((bool) && (!com.tencent.mm.vfs.e.bK(this.ouO.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.mGK.boO();
          y.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.nFQ.a(150L, 32L, 1L, true);
          if (bool) {
            h.nFQ.a(150L, 33L, 1L, true);
          }
        }
      }
      h.nFQ.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.ovi), Thread.currentThread().getName(), af.bDS(), com.tencent.mm.compatible.util.e.bkF });
      if ((this.ouO.omO.omU == 0) || (this.ouO.omO.omU == 5))
      {
        str1 = com.tencent.mm.plugin.sns.data.i.f(this.bZK);
        s.b(this.ouO.getPath(), str2, str1, af.bDN());
      }
      for (;;)
      {
        c.a(this.ouO.getPath() + str1, this.ouO.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        this.ouN = com.tencent.mm.plugin.sns.data.i.Na(this.ouO.getPath() + str1);
        bool = com.tencent.mm.plugin.sns.data.i.b(this.ouN);
        y.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.dVs + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.nFQ.a(150L, 65L, 1L, true);
          if (!this.ovp) {
            break label1095;
          }
          h.nFQ.a(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.ovo) {
            h.nFQ.a(150L, 54L, 1L, true);
          }
          if (this.ovn) {
            h.nFQ.a(150L, 57L, 1L, true);
          }
          if ((this.dVs) && (!bool)) {
            h.nFQ.a(22L, 65L, 1L, true);
          }
          if ((this.ovp) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(139);
          }
          return true;
          str1 = "";
          break;
          h.nFQ.a(150L, 51L, 1L, true);
        }
        str1 = str2;
      }
    }
  }
  
  protected final int bEt()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.i
 * JD-Core Version:    0.7.0.1
 */