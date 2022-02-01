package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;

public final class i
  extends f
{
  private boolean hIz;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.hIz = false;
    g.yxI.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean QP(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.zFt.ztx != null) && (this.zFt.ztx.size() > 0))
    {
      localObject4 = (n)this.zFt.ztx.get(paramInt);
      localObject3 = (bzh)this.zFt.zum.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        ae.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      ae.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((bzh)localObject3).Id;
      str1 = ap.jv(ah.getAccSnsPath(), (String)localObject2) + r.m((bzh)localObject3);
      localObject2 = r.d((bzh)localObject3);
      this.hIz = u.aBK(str1);
      if (this.zFU) {
        this.hIz = true;
      }
      if (this.hIz) {
        g.yxI.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      h.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bu.isNullOrNil(localOptions.outMimeType))) {
        g.yxI.idkeyStat(150L, 35L, 1L, true);
      }
      i = -1;
      if ((!((String)localObject1).contains("jpg")) && (!((String)localObject1).contains("jpeg"))) {
        break label1243;
      }
      int j = MMNativeJpeg.queryQuality(str1);
      i = j;
      if (j != 0) {
        break label1243;
      }
      i = -1;
    }
    label1211:
    label1219:
    label1243:
    for (;;)
    {
      this.zFt.mediaType = r.aou(str1);
      long l1 = o.aZR(str1);
      if (l1 <= 0L)
      {
        ae.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        g.yxI.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bu.HQ();
      localObject1 = r.h((bzh)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((bzh)localObject3).Id;
      o.mF(str1, ap.jv(ah.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((bzh)localObject3).Id;
      ae.v("MicroMsg.SnsDownloadThumb", o.fB(((StringBuilder)localObject5).append(ap.jv(ah.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = bu.HQ();
      localObject1 = ((bzh)localObject3).Id;
      if (!u.a(ap.jv(ah.getAccSnsPath(), (String)localObject1), r.m((bzh)localObject3), (String)localObject2, ah.dXQ()))
      {
        ae.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        g.yxI.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bu.aO(l3);
      boolean bool = o.fB(str1);
      o.deleteFile(str1);
      l2 = bu.aO(l2);
      localObject1 = new StringBuilder();
      str1 = ((bzh)localObject3).Id;
      if (!o.fB(ap.jv(ah.getAccSnsPath(), str1) + (String)localObject2))
      {
        ae.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(o.aZR(this.zFt.getPath() + (String)localObject2)) });
        g.yxI.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((bzh)localObject3).Id;
          if (!o.fB(ap.jv(ah.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = com.tencent.mm.plugin.normsg.a.b.wJt.dya();
            ae.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            g.yxI.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              g.yxI.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      g.yxI.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.zFM), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
      if ((((n)localObject4).zui == 0) || (this.zFt.ztw.zui == 5))
      {
        localObject1 = r.e((bzh)localObject3);
        localObject4 = ((bzh)localObject3).Id;
        u.b(ap.jv(ah.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, ah.dXP());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((bzh)localObject3).Id;
        c.a(ap.jv(ah.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((bzh)localObject3).Hmj, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((bzh)localObject3).Id;
        this.zFs = r.azt(ap.jv(ah.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.zFN.put(paramInt, this.zFs);
        bool = r.b(this.zFs);
        ae.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hIz + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          g.yxI.idkeyStat(150L, 65L, 1L, true);
          if (!this.zFX) {
            break label1219;
          }
          g.yxI.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.zFV) {
            g.yxI.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.zFU) {
            g.yxI.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hIz) && (!bool)) {
            g.yxI.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.zFX) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.md(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          g.yxI.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean dYJ()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.zFt.ztw != null)
    {
      str2 = r.d(this.dKe);
      this.hIz = u.aBK(this.zFt.getPath() + this.zFt.dYH());
      if (this.zFU) {
        this.hIz = true;
      }
      if (this.hIz) {
        g.yxI.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.zFt.getPath() + this.zFt.dYH();
      this.zFt.mediaType = r.aou(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      h.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1150;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bu.isNullOrNil(localOptions.outMimeType))) {
        g.yxI.idkeyStat(150L, 35L, 1L, true);
      }
      if ((!str1.contains("jpg")) && (!str1.contains("jpeg"))) {
        break label1182;
      }
      int j = MMNativeJpeg.queryQuality(str3);
      i = j;
      if (j != 0) {}
    }
    label1158:
    label1182:
    for (int i = -1;; i = -1)
    {
      long l1 = o.aZR(str3);
      if (l1 <= 0L)
      {
        ae.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        g.yxI.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bu.HQ();
      str1 = r.h(this.dKe);
      o.mF(this.zFt.getPath() + this.zFt.dYH(), this.zFt.getPath() + str1);
      ae.v("MicroMsg.SnsDownloadThumb", "file src" + o.fB(new StringBuilder().append(this.zFt.getPath()).append(str1).toString()));
      long l3 = bu.HQ();
      if (!u.a(this.zFt.getPath(), this.zFt.dYH(), str2, ah.dXQ()))
      {
        ae.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        g.yxI.idkeyStat(150L, 27L, 1L, true);
      }
      ae.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
      l3 = bu.aO(l3);
      boolean bool = o.fB(this.zFt.getPath() + this.zFt.dYH());
      o.deleteFile(this.zFt.getPath() + this.zFt.dYH());
      l2 = bu.aO(l2);
      if (!o.fB(this.zFt.getPath() + str2))
      {
        ae.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(o.aZR(this.zFt.getPath() + str2)) });
        g.yxI.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!o.fB(this.zFt.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.wJt.dya();
          ae.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          g.yxI.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            g.yxI.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      g.yxI.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.zFM), Thread.currentThread().getName(), ah.dXV(), com.tencent.mm.loader.j.b.asd() });
      ae.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
      if ((this.zFt.ztw.zui == 0) || (this.zFt.ztw.zui == 5))
      {
        str1 = r.e(this.dKe);
        u.b(this.zFt.getPath(), str2, str1, ah.dXP());
      }
      for (;;)
      {
        c.a(this.zFt.getPath() + str1, this.zFt.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        ae.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
        this.zFs = r.azt(this.zFt.getPath() + str1);
        bool = r.b(this.zFs);
        ae.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hIz + " srcImgFileSize: " + l1);
        if (!bool)
        {
          g.yxI.idkeyStat(150L, 65L, 1L, true);
          if (!this.zFX) {
            break label1158;
          }
          g.yxI.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.zFV) {
            g.yxI.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.zFU) {
            g.yxI.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hIz) && (!bool)) {
            g.yxI.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.zFX) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.md(139);
          }
          AppMethodBeat.o(96076);
          return true;
          label1150:
          str1 = "";
          break;
          g.yxI.idkeyStat(150L, 51L, 1L, true);
        }
        str1 = str2;
      }
    }
  }
  
  protected final int getMediaType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.i
 * JD-Core Version:    0.7.0.1
 */