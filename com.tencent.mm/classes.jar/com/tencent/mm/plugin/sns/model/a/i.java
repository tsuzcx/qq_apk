package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
  extends f
{
  private boolean hnp;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(96075);
    this.hnp = false;
    h.wUl.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(96075);
  }
  
  public final boolean OA(int paramInt)
  {
    AppMethodBeat.i(96077);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.xYf.xMP != null) && (this.xYf.xMP.size() > 0))
    {
      localObject4 = (m)this.xYf.xMP.get(paramInt);
      localObject3 = (btz)this.xYf.xNC.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        ac.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(96077);
        return false;
      }
      ac.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((btz)localObject3).Id;
      str1 = an.jc(af.getAccSnsPath(), (String)localObject2) + q.m((btz)localObject3);
      localObject2 = q.d((btz)localObject3);
      this.hnp = u.avm(str1);
      if (this.xYG) {
        this.hnp = true;
      }
      if (this.hnp) {
        h.wUl.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1211;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bs.isNullOrNil(localOptions.outMimeType))) {
        h.wUl.idkeyStat(150L, 35L, 1L, true);
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
      this.xYf.mediaType = q.aiF(str1);
      long l1 = com.tencent.mm.vfs.i.aSp(str1);
      if (l1 <= 0L)
      {
        ac.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", new Object[] { str1 });
        h.wUl.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bs.Gn();
      localObject1 = q.h((btz)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((btz)localObject3).Id;
      com.tencent.mm.vfs.i.lZ(str1, an.jc(af.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((btz)localObject3).Id;
      ac.v("MicroMsg.SnsDownloadThumb", com.tencent.mm.vfs.i.eA(((StringBuilder)localObject5).append(an.jc(af.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = bs.Gn();
      localObject1 = ((btz)localObject3).Id;
      if (!u.a(an.jc(af.getAccSnsPath(), (String)localObject1), q.m((btz)localObject3), (String)localObject2, af.dId()))
      {
        ac.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.wUl.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bs.aO(l3);
      boolean bool = com.tencent.mm.vfs.i.eA(str1);
      com.tencent.mm.vfs.i.deleteFile(str1);
      l2 = bs.aO(l2);
      localObject1 = new StringBuilder();
      str1 = ((btz)localObject3).Id;
      if (!com.tencent.mm.vfs.i.eA(an.jc(af.getAccSnsPath(), str1) + (String)localObject2))
      {
        ac.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aSp(this.xYf.getPath() + (String)localObject2)) });
        h.wUl.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((btz)localObject3).Id;
          if (!com.tencent.mm.vfs.i.eA(an.jc(af.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = com.tencent.mm.plugin.normsg.a.b.vor.dky();
            ac.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            h.wUl.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              h.wUl.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      h.wUl.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.xYy), Thread.currentThread().getName(), af.dIi(), com.tencent.mm.loader.j.b.apb() });
      if ((((m)localObject4).xNy == 0) || (this.xYf.xMO.xNy == 5))
      {
        localObject1 = q.e((btz)localObject3);
        localObject4 = ((btz)localObject3).Id;
        u.b(an.jc(af.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, af.dIc());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((btz)localObject3).Id;
        d.a(an.jc(af.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((btz)localObject3).Fjh, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((btz)localObject3).Id;
        this.xYe = q.asX(an.jc(af.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.xYz.put(paramInt, this.xYe);
        bool = q.b(this.xYe);
        ac.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hnp + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          h.wUl.idkeyStat(150L, 65L, 1L, true);
          if (!this.xYJ) {
            break label1219;
          }
          h.wUl.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.xYH) {
            h.wUl.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.xYG) {
            h.wUl.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hnp) && (!bool)) {
            h.wUl.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.xYJ) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.lA(139);
          }
          AppMethodBeat.o(96077);
          return true;
          localObject1 = "";
          break;
          h.wUl.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean dIV()
  {
    AppMethodBeat.i(96076);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.xYf.xMO != null)
    {
      str2 = q.d(this.dwE);
      this.hnp = u.avm(this.xYf.getPath() + this.xYf.dIT());
      if (this.xYG) {
        this.hnp = true;
      }
      if (this.hnp) {
        h.wUl.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.xYf.getPath() + this.xYf.dIT();
      this.xYf.mediaType = q.aiF(str3);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1126;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bs.isNullOrNil(localOptions.outMimeType))) {
        h.wUl.idkeyStat(150L, 35L, 1L, true);
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
      long l1 = com.tencent.mm.vfs.i.aSp(str3);
      if (l1 <= 0L)
      {
        ac.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", new Object[] { str3 });
        h.wUl.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bs.Gn();
      str1 = q.h(this.dwE);
      com.tencent.mm.vfs.i.lZ(this.xYf.getPath() + this.xYf.dIT(), this.xYf.getPath() + str1);
      ac.v("MicroMsg.SnsDownloadThumb", "file src" + com.tencent.mm.vfs.i.eA(new StringBuilder().append(this.xYf.getPath()).append(str1).toString()));
      long l3 = bs.Gn();
      if (!u.a(this.xYf.getPath(), this.xYf.dIT(), str2, af.dId()))
      {
        ac.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.wUl.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bs.aO(l3);
      boolean bool = com.tencent.mm.vfs.i.eA(this.xYf.getPath() + this.xYf.dIT());
      com.tencent.mm.vfs.i.deleteFile(this.xYf.getPath() + this.xYf.dIT());
      l2 = bs.aO(l2);
      if (!com.tencent.mm.vfs.i.eA(this.xYf.getPath() + str2))
      {
        ac.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aSp(this.xYf.getPath() + str2)) });
        h.wUl.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!com.tencent.mm.vfs.i.eA(this.xYf.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.vor.dky();
          ac.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.wUl.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            h.wUl.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      h.wUl.f(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.xYy), Thread.currentThread().getName(), af.dIi(), com.tencent.mm.loader.j.b.apb() });
      if ((this.xYf.xMO.xNy == 0) || (this.xYf.xMO.xNy == 5))
      {
        str1 = q.e(this.dwE);
        u.b(this.xYf.getPath(), str2, str1, af.dIc());
      }
      for (;;)
      {
        d.a(this.xYf.getPath() + str1, this.xYf.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        this.xYe = q.asX(this.xYf.getPath() + str1);
        bool = q.b(this.xYe);
        ac.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.hnp + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.wUl.idkeyStat(150L, 65L, 1L, true);
          if (!this.xYJ) {
            break label1134;
          }
          h.wUl.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.xYH) {
            h.wUl.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.xYG) {
            h.wUl.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.hnp) && (!bool)) {
            h.wUl.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.xYJ) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.lA(139);
          }
          AppMethodBeat.o(96076);
          return true;
          label1126:
          str1 = "";
          break;
          label1134:
          h.wUl.idkeyStat(150L, 51L, 1L, true);
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