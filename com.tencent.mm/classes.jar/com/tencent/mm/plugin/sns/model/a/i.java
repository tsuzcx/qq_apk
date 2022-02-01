package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class i
  extends f
{
  private boolean ltj;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.ltj = false;
    h.IzE.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean agd(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.KcA.JQn != null) && (this.KcA.JQn.size() > 0))
    {
      localObject4 = (p)this.KcA.JQn.get(paramInt);
      localObject3 = (cvt)this.KcA.JRr.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      Log.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((cvt)localObject3).Id;
      str1 = aq.kD(aj.getAccSnsPath(), (String)localObject2) + t.m((cvt)localObject3);
      localObject2 = t.d((cvt)localObject3);
      this.ltj = r.bbF(str1);
      if (this.Kdb) {
        this.ltj = true;
      }
      if (this.ltj) {
        h.IzE.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        h.IzE.idkeyStat(150L, 35L, 1L, true);
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
      this.KcA.mediaType = t.aLV(str1);
      long l1 = u.bBQ(str1);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        h.IzE.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      localObject1 = t.h((cvt)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((cvt)localObject3).Id;
      u.on(str1, aq.kD(aj.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((cvt)localObject3).Id;
      Log.v("MicroMsg.SnsDownloadThumb", u.agG(((StringBuilder)localObject5).append(aq.kD(aj.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = Util.currentTicks();
      localObject1 = ((cvt)localObject3).Id;
      if (!r.a(aq.kD(aj.getAccSnsPath(), (String)localObject1), t.m((cvt)localObject3), (String)localObject2, aj.fOW()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.IzE.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = Util.ticksToNow(l3);
      boolean bool = u.agG(str1);
      u.deleteFile(str1);
      l2 = Util.ticksToNow(l2);
      localObject1 = new StringBuilder();
      str1 = ((cvt)localObject3).Id;
      if (!u.agG(aq.kD(aj.getAccSnsPath(), str1) + (String)localObject2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(u.bBQ(this.KcA.getPath() + (String)localObject2)) });
        h.IzE.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((cvt)localObject3).Id;
          if (!u.agG(aq.kD(aj.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = d.GxJ.fjm();
            Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            h.IzE.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              h.IzE.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      h.IzE.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.KcT), Thread.currentThread().getName(), aj.fPb(), com.tencent.mm.loader.j.b.aSF() });
      if ((((p)localObject4).JRn == 0) || (this.KcA.JQm.JRn == 5))
      {
        localObject1 = t.e((cvt)localObject3);
        localObject4 = ((cvt)localObject3).Id;
        r.b(aq.kD(aj.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, aj.fOV());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((cvt)localObject3).Id;
        e.a(aq.kD(aj.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((cvt)localObject3).TDF, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((cvt)localObject3).Id;
        this.Kcz = t.aZm(aq.kD(aj.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.KcU.put(paramInt, this.Kcz);
        bool = t.b(this.Kcz);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.ltj + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          h.IzE.idkeyStat(150L, 65L, 1L, true);
          if (!this.Kde) {
            break label1219;
          }
          h.IzE.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.Kdc) {
            h.IzE.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.Kdb) {
            h.IzE.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.ltj) && (!bool)) {
            h.IzE.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.Kde) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.rE(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          h.IzE.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean fPQ()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.KcA.JQm != null)
    {
      str2 = t.d(this.fVT);
      this.ltj = r.bbF(this.KcA.getPath() + this.KcA.fPO());
      if (this.Kdb) {
        this.ltj = true;
      }
      if (this.ltj) {
        h.IzE.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.KcA.getPath() + this.KcA.fPO();
      this.KcA.mediaType = t.aLV(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1067;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        h.IzE.idkeyStat(150L, 35L, 1L, true);
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
      long l1 = u.bBQ(str3);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        h.IzE.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      str1 = t.h(this.fVT);
      u.bj(this.KcA.getPath(), this.KcA.fPO(), str1);
      Log.v("MicroMsg.SnsDownloadThumb", "file src" + u.agG(new StringBuilder().append(this.KcA.getPath()).append(str1).toString()));
      long l3 = Util.currentTicks();
      if (!r.a(this.KcA.getPath(), str1, str2, aj.fOW()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.IzE.idkeyStat(150L, 27L, 1L, true);
      }
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
      l3 = Util.ticksToNow(l3);
      boolean bool = u.agG(this.KcA.getPath() + str1);
      l2 = Util.ticksToNow(l2);
      if (!u.agG(this.KcA.getPath() + str2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(u.bBQ(this.KcA.getPath() + str2)) });
        h.IzE.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!u.agG(this.KcA.getPath() + str2)))
        {
          bool = d.GxJ.fjm();
          Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.IzE.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            h.IzE.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      h.IzE.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.KcT), Thread.currentThread().getName(), aj.fPb(), com.tencent.mm.loader.j.b.aSF() });
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
      if ((this.KcA.JQm.JRn == 0) || (this.KcA.JQm.JRn == 5))
      {
        str1 = t.e(this.fVT);
        r.b(this.KcA.getPath(), str2, str1, aj.fOV());
      }
      for (;;)
      {
        e.a(this.KcA.getPath() + str1, this.KcA.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        Log.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
        this.Kcz = t.aZm(this.KcA.getPath() + str1);
        bool = t.b(this.Kcz);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.ltj + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.IzE.idkeyStat(150L, 65L, 1L, true);
          if (!this.Kde) {
            break label1075;
          }
          h.IzE.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.Kdc) {
            h.IzE.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.Kdb) {
            h.IzE.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.ltj) && (!bool)) {
            h.IzE.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.Kde) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.rE(139);
          }
          AppMethodBeat.o(96076);
          return true;
          str1 = "";
          break;
          h.IzE.idkeyStat(150L, 51L, 1L, true);
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