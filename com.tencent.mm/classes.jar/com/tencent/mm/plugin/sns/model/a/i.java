package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends f
{
  private boolean gMP;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.gMP = false;
    h.vKh.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean My(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.wLz.wAw != null) && (this.wLz.wAw.size() > 0))
    {
      localObject4 = (m)this.wLz.wAw.get(paramInt);
      localObject3 = (bpi)this.wLz.wBh.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      ad.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((bpi)localObject3).Id;
      str1 = an.iF(af.getAccSnsPath(), (String)localObject2) + q.m((bpi)localObject3);
      localObject2 = q.d((bpi)localObject3);
      this.gMP = u.aqd(str1);
      if (this.wMa) {
        this.gMP = true;
      }
      if (this.gMP) {
        h.vKh.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bt.isNullOrNil(localOptions.outMimeType))) {
        h.vKh.idkeyStat(150L, 35L, 1L, true);
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
      this.wLz.mediaType = q.adN(str1);
      long l1 = com.tencent.mm.vfs.i.aMN(str1);
      if (l1 <= 0L)
      {
        ad.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        h.vKh.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bt.GC();
      localObject1 = q.h((bpi)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((bpi)localObject3).Id;
      com.tencent.mm.vfs.i.lC(str1, an.iF(af.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((bpi)localObject3).Id;
      ad.v("MicroMsg.SnsDownloadThumb", com.tencent.mm.vfs.i.eK(((StringBuilder)localObject5).append(an.iF(af.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = bt.GC();
      localObject1 = ((bpi)localObject3).Id;
      if (!u.a(an.iF(af.getAccSnsPath(), (String)localObject1), q.m((bpi)localObject3), (String)localObject2, af.dtF()))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.vKh.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bt.aS(l3);
      boolean bool = com.tencent.mm.vfs.i.eK(str1);
      com.tencent.mm.vfs.i.deleteFile(str1);
      l2 = bt.aS(l2);
      localObject1 = new StringBuilder();
      str1 = ((bpi)localObject3).Id;
      if (!com.tencent.mm.vfs.i.eK(an.iF(af.getAccSnsPath(), str1) + (String)localObject2))
      {
        ad.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aMN(this.wLz.getPath() + (String)localObject2)) });
        h.vKh.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((bpi)localObject3).Id;
          if (!com.tencent.mm.vfs.i.eK(an.iF(af.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = com.tencent.mm.plugin.normsg.a.b.ufs.cWQ();
            ad.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            h.vKh.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              h.vKh.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      h.vKh.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.wLS), Thread.currentThread().getName(), af.dtK(), com.tencent.mm.loader.j.b.aib() });
      if ((((m)localObject4).wBd == 0) || (this.wLz.wAv.wBd == 5))
      {
        localObject1 = q.e((bpi)localObject3);
        localObject4 = ((bpi)localObject3).Id;
        u.b(an.iF(af.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, af.dtE());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((bpi)localObject3).Id;
        d.a(an.iF(af.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((bpi)localObject3).DMQ, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((bpi)localObject3).Id;
        this.wLy = q.anL(an.iF(af.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.wLT.put(paramInt, this.wLy);
        bool = q.b(this.wLy);
        ad.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.gMP + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          h.vKh.idkeyStat(150L, 65L, 1L, true);
          if (!this.wMd) {
            break label1219;
          }
          h.vKh.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.wMb) {
            h.vKh.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.wMa) {
            h.vKh.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.gMP) && (!bool)) {
            h.vKh.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.wMd) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.lI(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          h.vKh.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean duv()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.wLz.wAv != null)
    {
      str2 = q.d(this.dyS);
      this.gMP = u.aqd(this.wLz.getPath() + this.wLz.dut());
      if (this.wMa) {
        this.gMP = true;
      }
      if (this.gMP) {
        h.vKh.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.wLz.getPath() + this.wLz.dut();
      this.wLz.mediaType = q.adN(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1126;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bt.isNullOrNil(localOptions.outMimeType))) {
        h.vKh.idkeyStat(150L, 35L, 1L, true);
      }
      if ((!str1.contains("jpg")) && (!str1.contains("jpeg"))) {
        break label1158;
      }
      int j = MMNativeJpeg.queryQuality(str3);
      i = j;
      if (j != 0) {}
    }
    label1158:
    for (int i = -1;; i = -1)
    {
      long l1 = com.tencent.mm.vfs.i.aMN(str3);
      if (l1 <= 0L)
      {
        ad.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        h.vKh.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bt.GC();
      str1 = q.h(this.dyS);
      com.tencent.mm.vfs.i.lC(this.wLz.getPath() + this.wLz.dut(), this.wLz.getPath() + str1);
      ad.v("MicroMsg.SnsDownloadThumb", "file src" + com.tencent.mm.vfs.i.eK(new StringBuilder().append(this.wLz.getPath()).append(str1).toString()));
      long l3 = bt.GC();
      if (!u.a(this.wLz.getPath(), this.wLz.dut(), str2, af.dtF()))
      {
        ad.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.vKh.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bt.aS(l3);
      boolean bool = com.tencent.mm.vfs.i.eK(this.wLz.getPath() + this.wLz.dut());
      com.tencent.mm.vfs.i.deleteFile(this.wLz.getPath() + this.wLz.dut());
      l2 = bt.aS(l2);
      if (!com.tencent.mm.vfs.i.eK(this.wLz.getPath() + str2))
      {
        ad.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aMN(this.wLz.getPath() + str2)) });
        h.vKh.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!com.tencent.mm.vfs.i.eK(this.wLz.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.ufs.cWQ();
          ad.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.vKh.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            h.vKh.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      h.vKh.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.wLS), Thread.currentThread().getName(), af.dtK(), com.tencent.mm.loader.j.b.aib() });
      if ((this.wLz.wAv.wBd == 0) || (this.wLz.wAv.wBd == 5))
      {
        str1 = q.e(this.dyS);
        u.b(this.wLz.getPath(), str2, str1, af.dtE());
      }
      for (;;)
      {
        d.a(this.wLz.getPath() + str1, this.wLz.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        this.wLy = q.anL(this.wLz.getPath() + str1);
        bool = q.b(this.wLy);
        ad.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.gMP + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.vKh.idkeyStat(150L, 65L, 1L, true);
          if (!this.wMd) {
            break label1134;
          }
          h.vKh.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.wMb) {
            h.vKh.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.wMa) {
            h.vKh.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.gMP) && (!bool)) {
            h.vKh.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.wMd) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.lI(139);
          }
          AppMethodBeat.o(96076);
          return true;
          label1126:
          str1 = "";
          break;
          label1134:
          h.vKh.idkeyStat(150L, 51L, 1L, true);
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