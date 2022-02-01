package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends f
{
  private boolean hFH;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.hFH = false;
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean Qi(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.zoe.zcH != null) && (this.zoe.zcH.size() > 0))
    {
      localObject4 = (m)this.zoe.zcH.get(paramInt);
      localObject3 = (byn)this.zoe.zdw.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      ad.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((byn)localObject3).Id;
      str1 = ao.jo(ag.getAccSnsPath(), (String)localObject2) + q.m((byn)localObject3);
      localObject2 = q.d((byn)localObject3);
      this.hFH = u.aAt(str1);
      if (this.zoF) {
        this.hFH = true;
      }
      if (this.hFH) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bt.isNullOrNil(localOptions.outMimeType))) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 35L, 1L, true);
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
      this.zoe.mediaType = q.ans(str1);
      long l1 = com.tencent.mm.vfs.i.aYo(str1);
      if (l1 <= 0L)
      {
        ad.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bt.HI();
      localObject1 = q.h((byn)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((byn)localObject3).Id;
      com.tencent.mm.vfs.i.mz(str1, ao.jo(ag.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((byn)localObject3).Id;
      ad.v("MicroMsg.SnsDownloadThumb", com.tencent.mm.vfs.i.fv(((StringBuilder)localObject5).append(ao.jo(ag.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = bt.HI();
      localObject1 = ((byn)localObject3).Id;
      if (!u.a(ao.jo(ag.getAccSnsPath(), (String)localObject1), q.m((byn)localObject3), (String)localObject2, ag.dUq()))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bt.aO(l3);
      boolean bool = com.tencent.mm.vfs.i.fv(str1);
      com.tencent.mm.vfs.i.deleteFile(str1);
      l2 = bt.aO(l2);
      localObject1 = new StringBuilder();
      str1 = ((byn)localObject3).Id;
      if (!com.tencent.mm.vfs.i.fv(ao.jo(ag.getAccSnsPath(), str1) + (String)localObject2))
      {
        ad.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(this.zoe.getPath() + (String)localObject2)) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((byn)localObject3).Id;
          if (!com.tencent.mm.vfs.i.fv(ao.jo(ag.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = com.tencent.mm.plugin.normsg.a.b.wtJ.duK();
            ad.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.zox), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
      if ((((m)localObject4).zds == 0) || (this.zoe.zcG.zds == 5))
      {
        localObject1 = q.e((byn)localObject3);
        localObject4 = ((byn)localObject3).Id;
        u.b(ao.jo(ag.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, ag.dUp());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((byn)localObject3).Id;
        c.a(ao.jo(ag.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((byn)localObject3).GSI, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((byn)localObject3).Id;
        this.zod = q.ayc(ao.jo(ag.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.zoy.put(paramInt, this.zod);
        bool = q.b(this.zod);
        ad.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hFH + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 65L, 1L, true);
          if (!this.zoI) {
            break label1219;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.zoG) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.zoF) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hFH) && (!bool)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.zoI) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.ma(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean dVi()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.zoe.zcG != null)
    {
      str2 = q.d(this.dIQ);
      this.hFH = u.aAt(this.zoe.getPath() + this.zoe.dVg());
      if (this.zoF) {
        this.hFH = true;
      }
      if (this.hFH) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.zoe.getPath() + this.zoe.dVg();
      this.zoe.mediaType = q.ans(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1150;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bt.isNullOrNil(localOptions.outMimeType))) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 35L, 1L, true);
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
      long l1 = com.tencent.mm.vfs.i.aYo(str3);
      if (l1 <= 0L)
      {
        ad.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bt.HI();
      str1 = q.h(this.dIQ);
      com.tencent.mm.vfs.i.mz(this.zoe.getPath() + this.zoe.dVg(), this.zoe.getPath() + str1);
      ad.v("MicroMsg.SnsDownloadThumb", "file src" + com.tencent.mm.vfs.i.fv(new StringBuilder().append(this.zoe.getPath()).append(str1).toString()));
      long l3 = bt.HI();
      if (!u.a(this.zoe.getPath(), this.zoe.dVg(), str2, ag.dUq()))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 27L, 1L, true);
      }
      ad.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
      l3 = bt.aO(l3);
      boolean bool = com.tencent.mm.vfs.i.fv(this.zoe.getPath() + this.zoe.dVg());
      com.tencent.mm.vfs.i.deleteFile(this.zoe.getPath() + this.zoe.dVg());
      l2 = bt.aO(l2);
      if (!com.tencent.mm.vfs.i.fv(this.zoe.getPath() + str2))
      {
        ad.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(this.zoe.getPath() + str2)) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!com.tencent.mm.vfs.i.fv(this.zoe.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.wtJ.duK();
          ad.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.zox), Thread.currentThread().getName(), ag.dUv(), com.tencent.mm.loader.j.b.arO() });
      ad.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
      if ((this.zoe.zcG.zds == 0) || (this.zoe.zcG.zds == 5))
      {
        str1 = q.e(this.dIQ);
        u.b(this.zoe.getPath(), str2, str1, ag.dUp());
      }
      for (;;)
      {
        c.a(this.zoe.getPath() + str1, this.zoe.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        ad.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
        this.zod = q.ayc(this.zoe.getPath() + str1);
        bool = q.b(this.zod);
        ad.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hFH + " srcImgFileSize: " + l1);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 65L, 1L, true);
          if (!this.zoI) {
            break label1158;
          }
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.zoG) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.zoF) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hFH) && (!bool)) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.zoI) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.ma(139);
          }
          AppMethodBeat.o(96076);
          return true;
          label1150:
          str1 = "";
          break;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(150L, 51L, 1L, true);
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