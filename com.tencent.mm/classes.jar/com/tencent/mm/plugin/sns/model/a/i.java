package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class i
  extends f
{
  private boolean iDj;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.iDj = false;
    h.CyF.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean YM(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.DPt.DDI != null) && (this.DPt.DDI.size() > 0))
    {
      localObject4 = (n)this.DPt.DDI.get(paramInt);
      localObject3 = (cnb)this.DPt.DEw.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      Log.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((cnb)localObject3).Id;
      str1 = ar.ki(aj.getAccSnsPath(), (String)localObject2) + com.tencent.mm.plugin.sns.data.r.n((cnb)localObject3);
      localObject2 = com.tencent.mm.plugin.sns.data.r.e((cnb)localObject3);
      this.iDj = com.tencent.mm.plugin.sns.storage.r.aQF(str1);
      if (this.DPU) {
        this.iDj = true;
      }
      if (this.iDj) {
        h.CyF.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        h.CyF.idkeyStat(150L, 35L, 1L, true);
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
      this.DPt.mediaType = com.tencent.mm.plugin.sns.data.r.aBO(str1);
      long l1 = s.boW(str1);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        h.CyF.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      localObject1 = com.tencent.mm.plugin.sns.data.r.i((cnb)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((cnb)localObject3).Id;
      s.nw(str1, ar.ki(aj.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((cnb)localObject3).Id;
      Log.v("MicroMsg.SnsDownloadThumb", s.YS(((StringBuilder)localObject5).append(ar.ki(aj.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = Util.currentTicks();
      localObject1 = ((cnb)localObject3).Id;
      if (!com.tencent.mm.plugin.sns.storage.r.a(ar.ki(aj.getAccSnsPath(), (String)localObject1), com.tencent.mm.plugin.sns.data.r.n((cnb)localObject3), (String)localObject2, aj.fbc()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.CyF.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = Util.ticksToNow(l3);
      boolean bool = s.YS(str1);
      s.deleteFile(str1);
      l2 = Util.ticksToNow(l2);
      localObject1 = new StringBuilder();
      str1 = ((cnb)localObject3).Id;
      if (!s.YS(ar.ki(aj.getAccSnsPath(), str1) + (String)localObject2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(s.boW(this.DPt.getPath() + (String)localObject2)) });
        h.CyF.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((cnb)localObject3).Id;
          if (!s.YS(ar.ki(aj.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = d.AEF.exI();
            Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            h.CyF.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              h.CyF.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      h.CyF.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.DPM), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
      if ((((n)localObject4).DEs == 0) || (this.DPt.DDH.DEs == 5))
      {
        localObject1 = com.tencent.mm.plugin.sns.data.r.f((cnb)localObject3);
        localObject4 = ((cnb)localObject3).Id;
        com.tencent.mm.plugin.sns.storage.r.b(ar.ki(aj.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, aj.fbb());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((cnb)localObject3).Id;
        c.a(ar.ki(aj.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((cnb)localObject3).Msz, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((cnb)localObject3).Id;
        this.DPs = com.tencent.mm.plugin.sns.data.r.aOq(ar.ki(aj.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.DPN.put(paramInt, this.DPs);
        bool = com.tencent.mm.plugin.sns.data.r.b(this.DPs);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.iDj + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          h.CyF.idkeyStat(150L, 65L, 1L, true);
          if (!this.DPX) {
            break label1219;
          }
          h.CyF.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.DPV) {
            h.CyF.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.DPU) {
            h.CyF.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.iDj) && (!bool)) {
            h.CyF.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.DPX) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.pl(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          h.CyF.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean fbX()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.DPt.DDH != null)
    {
      str2 = com.tencent.mm.plugin.sns.data.r.e(this.ebR);
      this.iDj = com.tencent.mm.plugin.sns.storage.r.aQF(this.DPt.getPath() + this.DPt.fbV());
      if (this.DPU) {
        this.iDj = true;
      }
      if (this.iDj) {
        h.CyF.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.DPt.getPath() + this.DPt.fbV();
      this.DPt.mediaType = com.tencent.mm.plugin.sns.data.r.aBO(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1067;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (Util.isNullOrNil(localOptions.outMimeType))) {
        h.CyF.idkeyStat(150L, 35L, 1L, true);
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
      long l1 = s.boW(str3);
      if (l1 <= 0L)
      {
        Log.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        h.CyF.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = Util.currentTicks();
      str1 = com.tencent.mm.plugin.sns.data.r.i(this.ebR);
      s.bo(this.DPt.getPath(), this.DPt.fbV(), str1);
      Log.v("MicroMsg.SnsDownloadThumb", "file src" + s.YS(new StringBuilder().append(this.DPt.getPath()).append(str1).toString()));
      long l3 = Util.currentTicks();
      if (!com.tencent.mm.plugin.sns.storage.r.a(this.DPt.getPath(), str1, str2, aj.fbc()))
      {
        Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.CyF.idkeyStat(150L, 27L, 1L, true);
      }
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
      l3 = Util.ticksToNow(l3);
      boolean bool = s.YS(this.DPt.getPath() + str1);
      l2 = Util.ticksToNow(l2);
      if (!s.YS(this.DPt.getPath() + str2))
      {
        Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(s.boW(this.DPt.getPath() + str2)) });
        h.CyF.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!s.YS(this.DPt.getPath() + str2)))
        {
          bool = d.AEF.exI();
          Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.CyF.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            h.CyF.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      h.CyF.a(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.DPM), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD() });
      Log.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
      if ((this.DPt.DDH.DEs == 0) || (this.DPt.DDH.DEs == 5))
      {
        str1 = com.tencent.mm.plugin.sns.data.r.f(this.ebR);
        com.tencent.mm.plugin.sns.storage.r.b(this.DPt.getPath(), str2, str1, aj.fbb());
      }
      for (;;)
      {
        c.a(this.DPt.getPath() + str1, this.DPt.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        Log.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
        this.DPs = com.tencent.mm.plugin.sns.data.r.aOq(this.DPt.getPath() + str1);
        bool = com.tencent.mm.plugin.sns.data.r.b(this.DPs);
        Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.iDj + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.CyF.idkeyStat(150L, 65L, 1L, true);
          if (!this.DPX) {
            break label1075;
          }
          h.CyF.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.DPV) {
            h.CyF.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.DPU) {
            h.CyF.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.iDj) && (!bool)) {
            h.CyF.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.DPX) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.pl(139);
          }
          AppMethodBeat.o(96076);
          return true;
          str1 = "";
          break;
          h.CyF.idkeyStat(150L, 51L, 1L, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.i
 * JD-Core Version:    0.7.0.1
 */