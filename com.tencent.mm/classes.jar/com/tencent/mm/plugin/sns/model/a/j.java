package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.statistics.f;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class j
  extends h
{
  private boolean okJ;
  
  public j(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.okJ = false;
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean akS(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.QzS.QmU != null) && (this.QzS.QmU.size() > 0))
    {
      localObject4 = (p)this.QzS.QmU.get(paramInt);
      localObject3 = (dmz)this.QzS.Qoc.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      Log.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((dmz)localObject3).Id;
      str1 = as.mg(al.getAccSnsPath(), (String)localObject2) + t.m((dmz)localObject3);
      localObject2 = t.d((dmz)localObject3);
      this.okJ = aa.bam(str1);
      if (this.QAu) {
        this.okJ = true;
      }
      if (this.okJ) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1212;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 35L, 1L, true);
      }
      i = -1;
      if ((!((String)localObject1).contains("jpg")) && (!((String)localObject1).contains("jpeg"))) {
        break label1244;
      }
      int j = MMNativeJpeg.queryQuality(str1);
      i = j;
      if (j != 0) {
        break label1244;
      }
      i = -1;
    }
    label1212:
    label1220:
    label1244:
    for (;;)
    {
      this.QzS.mediaType = t.aIP(str1);
      long l1 = y.bEl(str1);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      localObject1 = t.h((dmz)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((dmz)localObject3).Id;
      y.O(str1, as.mg(al.getAccSnsPath(), (String)localObject5) + (String)localObject1, false);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((dmz)localObject3).Id;
      Log.v("MicroMsg.SnsDownloadThumb", y.ZC(((StringBuilder)localObject5).append(as.mg(al.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = Util.currentTicks();
      localObject1 = ((dmz)localObject3).Id;
      if (!aa.a(as.mg(al.getAccSnsPath(), (String)localObject1), t.m((dmz)localObject3), (String)localObject2, al.hgQ()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = Util.ticksToNow(l3);
      boolean bool = y.ZC(str1);
      y.deleteFile(str1);
      l2 = Util.ticksToNow(l2);
      localObject1 = new StringBuilder();
      str1 = ((dmz)localObject3).Id;
      if (!y.ZC(as.mg(al.getAccSnsPath(), str1) + (String)localObject2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(y.bEl(this.QzS.getPath() + (String)localObject2)) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((dmz)localObject3).Id;
          if (!y.ZC(as.mg(al.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = d.MtP.gtD();
            Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.QAl), Thread.currentThread().getName(), al.hgV(), com.tencent.mm.loader.i.b.bmt() });
      if ((((p)localObject4).QnY == 0) || (this.QzS.QmT.QnY == 5))
      {
        localObject1 = t.e((dmz)localObject3);
        localObject4 = ((dmz)localObject3).Id;
        aa.b(as.mg(al.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, al.hgP());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((dmz)localObject3).Id;
        f.a(as.mg(al.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((dmz)localObject3).aaTl, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((dmz)localObject3).Id;
        this.QzR = t.aXx(as.mg(al.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.QAm.put(paramInt, this.QzR);
        bool = t.b(this.QzR);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.okJ + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 65L, 1L, true);
          if (!this.QAx) {
            break label1220;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.QAv) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.QAu) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.okJ) && (!bool)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.QAx) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.rG(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  protected final int getMediaType()
  {
    return 3;
  }
  
  public final boolean hhI()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.QzS.QmT != null)
    {
      str2 = t.d(this.ibT);
      this.okJ = aa.bam(this.QzS.getPath() + this.QzS.hhG());
      if (this.QAu) {
        this.okJ = true;
      }
      if (this.okJ) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.QzS.getPath() + this.QzS.hhG();
      this.QzS.mediaType = t.aIP(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1067;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 35L, 1L, true);
      }
      if ((!str1.contains("jpg")) && (!str1.contains("jpeg"))) {
        break label1099;
      }
      int j = MMNativeJpeg.queryQuality(str3);
      i = j;
      if (j != 0) {}
    }
    label1067:
    label1075:
    label1099:
    for (int i = -1;; i = -1)
    {
      long l1 = y.bEl(str3);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      str1 = t.h(this.ibT);
      y.bF(this.QzS.getPath(), this.QzS.hhG(), str1);
      Log.v("MicroMsg.SnsDownloadThumb", "file src" + y.ZC(new StringBuilder().append(this.QzS.getPath()).append(str1).toString()));
      long l3 = Util.currentTicks();
      if (!aa.a(this.QzS.getPath(), str1, str2, al.hgQ()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 27L, 1L, true);
      }
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
      l3 = Util.ticksToNow(l3);
      boolean bool = y.ZC(this.QzS.getPath() + str1);
      l2 = Util.ticksToNow(l2);
      if (!y.ZC(this.QzS.getPath() + str2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(y.bEl(this.QzS.getPath() + str2)) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!y.ZC(this.QzS.getPath() + str2)))
        {
          bool = d.MtP.gtD();
          Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.QAl), Thread.currentThread().getName(), al.hgV(), com.tencent.mm.loader.i.b.bmt() });
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
      if ((this.QzS.QmT.QnY == 0) || (this.QzS.QmT.QnY == 5))
      {
        str1 = t.e(this.ibT);
        aa.b(this.QzS.getPath(), str2, str1, al.hgP());
      }
      for (;;)
      {
        f.a(this.QzS.getPath() + str1, this.QzS.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        Log.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
        this.QzR = t.aXx(this.QzS.getPath() + str1);
        bool = t.b(this.QzR);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.okJ + " srcImgFileSize: " + l1);
        if (!bool)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 65L, 1L, true);
          if (!this.QAx) {
            break label1075;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.QAv) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.QAu) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.okJ) && (!bool)) {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.QAx) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.rG(139);
          }
          AppMethodBeat.o(96076);
          return true;
          str1 = "";
          break;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(150L, 51L, 1L, true);
        }
        str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.j
 * JD-Core Version:    0.7.0.1
 */