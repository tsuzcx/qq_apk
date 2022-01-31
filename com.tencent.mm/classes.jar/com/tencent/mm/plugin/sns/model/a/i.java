package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends f
{
  private boolean flB;
  
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
    AppMethodBeat.i(36754);
    this.flB = false;
    h.qsU.idkeyStat(150L, 10L, 1L, true);
    AppMethodBeat.o(36754);
  }
  
  public final boolean DY(int paramInt)
  {
    AppMethodBeat.i(36756);
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    String str1;
    BitmapFactory.Options localOptions;
    int i;
    if ((this.rjH.rbd != null) && (this.rjH.rbd.size() > 0))
    {
      localObject4 = (com.tencent.mm.plugin.sns.data.e)this.rjH.rbd.get(paramInt);
      localObject3 = (bcs)this.rjH.rbn.get(paramInt);
      if ((localObject4 == null) || (localObject3 == null))
      {
        ab.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
        AppMethodBeat.o(36756);
        return false;
      }
      ab.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", new Object[] { Integer.valueOf(paramInt) });
      localObject1 = new StringBuilder();
      localObject2 = ((bcs)localObject3).Id;
      str1 = ao.gl(ag.getAccSnsPath(), (String)localObject2) + com.tencent.mm.plugin.sns.data.i.n((bcs)localObject3);
      localObject2 = com.tencent.mm.plugin.sns.data.i.e((bcs)localObject3);
      this.flB = s.abL(str1);
      if (this.rki) {
        this.flB = true;
      }
      if (this.flB) {
        h.qsU.idkeyStat(22L, 64L, 1L, true);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(str1, localOptions);
      if (localOptions.outMimeType == null) {
        break label1182;
      }
      localObject1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bo.isNullOrNil(localOptions.outMimeType))) {
        h.qsU.idkeyStat(150L, 35L, 1L, true);
      }
      i = -1;
      if ((!((String)localObject1).contains("jpg")) && (!((String)localObject1).contains("jpeg"))) {
        break label1214;
      }
      int j = MMNativeJpeg.queryQuality(str1);
      i = j;
      if (j != 0) {
        break label1214;
      }
      i = -1;
    }
    label1182:
    label1190:
    label1214:
    for (;;)
    {
      long l1 = com.tencent.mm.vfs.e.avI(str1);
      if (l1 <= 0L) {
        h.qsU.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bo.yB();
      localObject1 = com.tencent.mm.plugin.sns.data.i.i((bcs)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject5 = ((bcs)localObject3).Id;
      com.tencent.mm.vfs.e.C(str1, ao.gl(ag.getAccSnsPath(), (String)localObject5) + (String)localObject1);
      localStringBuilder = new StringBuilder("file exist ");
      localObject5 = new StringBuilder();
      String str2 = ((bcs)localObject3).Id;
      ab.v("MicroMsg.SnsDownloadThumb", com.tencent.mm.vfs.e.cN(((StringBuilder)localObject5).append(ao.gl(ag.getAccSnsPath(), str2)).append((String)localObject1).toString()));
      long l3 = bo.yB();
      localObject1 = ((bcs)localObject3).Id;
      if (!s.a(ao.gl(ag.getAccSnsPath(), (String)localObject1), com.tencent.mm.plugin.sns.data.i.n((bcs)localObject3), (String)localObject2, ag.cpo()))
      {
        ab.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.qsU.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bo.av(l3);
      boolean bool = com.tencent.mm.vfs.e.cN(str1);
      com.tencent.mm.vfs.e.deleteFile(str1);
      l2 = bo.av(l2);
      localObject1 = new StringBuilder();
      str1 = ((bcs)localObject3).Id;
      if (!com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), str1) + (String)localObject2))
      {
        ab.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(this.rjH.getPath() + (String)localObject2)) });
        h.qsU.idkeyStat(150L, 31L, 1L, true);
        if (bool)
        {
          localObject1 = new StringBuilder();
          str1 = ((bcs)localObject3).Id;
          if (!com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), str1) + (String)localObject2))
          {
            bool = com.tencent.mm.plugin.normsg.a.b.pgQ.bXp();
            ab.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
            h.qsU.idkeyStat(150L, 32L, 1L, true);
            if (bool) {
              h.qsU.idkeyStat(150L, 33L, 1L, true);
            }
          }
        }
      }
      h.qsU.e(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.rka), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
      if ((((com.tencent.mm.plugin.sns.data.e)localObject4).rbj == 0) || (this.rjH.rbc.rbj == 5))
      {
        localObject1 = com.tencent.mm.plugin.sns.data.i.f((bcs)localObject3);
        localObject4 = ((bcs)localObject3).Id;
        s.b(ao.gl(ag.getAccSnsPath(), (String)localObject4), (String)localObject2, (String)localObject1, ag.cpn());
      }
      for (;;)
      {
        localObject2 = new StringBuilder();
        localObject4 = ((bcs)localObject3).Id;
        c.a(ao.gl(ag.getAccSnsPath(), (String)localObject4) + (String)localObject1, ((bcs)localObject3).xrS, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        localObject2 = new StringBuilder();
        localObject3 = ((bcs)localObject3).Id;
        this.rjG = com.tencent.mm.plugin.sns.data.i.ZH(ao.gl(ag.getAccSnsPath(), (String)localObject3) + (String)localObject1);
        this.rkb.put(paramInt, this.rjG);
        bool = com.tencent.mm.plugin.sns.data.i.b(this.rjG);
        ab.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.flB + " srcImgFileSize: " + l1 + " index: " + paramInt);
        if (!bool)
        {
          h.qsU.idkeyStat(150L, 65L, 1L, true);
          if (!this.rkk) {
            break label1190;
          }
          h.qsU.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.rkj) {
            h.qsU.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.rki) {
            h.qsU.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.flB) && (!bool)) {
            h.qsU.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.rkk) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.kS(139);
          }
          AppMethodBeat.o(36756);
          return true;
          localObject1 = "";
          break;
          h.qsU.idkeyStat(150L, 51L, 1L, true);
        }
        localObject1 = localObject2;
      }
    }
  }
  
  public final boolean cpR()
  {
    AppMethodBeat.i(36755);
    String str2;
    String str3;
    BitmapFactory.Options localOptions;
    String str1;
    if (this.rjH.rbc != null)
    {
      str2 = com.tencent.mm.plugin.sns.data.i.e(this.cIc);
      this.flB = s.abL(this.rjH.getPath() + this.rjH.cpP());
      if (this.rki) {
        this.flB = true;
      }
      if (this.flB) {
        h.qsU.idkeyStat(22L, 64L, 1L, true);
      }
      str3 = this.rjH.getPath() + this.rjH.cpP();
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(str3, localOptions);
      if (localOptions.outMimeType == null) {
        break label1096;
      }
      str1 = localOptions.outMimeType.toLowerCase();
      if ((localOptions.outMimeType == null) || (bo.isNullOrNil(localOptions.outMimeType))) {
        h.qsU.idkeyStat(150L, 35L, 1L, true);
      }
      if ((!str1.contains("jpg")) && (!str1.contains("jpeg"))) {
        break label1128;
      }
      int j = MMNativeJpeg.queryQuality(str3);
      i = j;
      if (j != 0) {}
    }
    label1096:
    label1104:
    label1128:
    for (int i = -1;; i = -1)
    {
      long l1 = com.tencent.mm.vfs.e.avI(str3);
      if (l1 <= 0L) {
        h.qsU.idkeyStat(150L, 23L, 1L, true);
      }
      long l2 = bo.yB();
      str1 = com.tencent.mm.plugin.sns.data.i.i(this.cIc);
      com.tencent.mm.vfs.e.C(this.rjH.getPath() + this.rjH.cpP(), this.rjH.getPath() + str1);
      ab.v("MicroMsg.SnsDownloadThumb", "file src" + com.tencent.mm.vfs.e.cN(new StringBuilder().append(this.rjH.getPath()).append(str1).toString()));
      long l3 = bo.yB();
      if (!s.a(this.rjH.getPath(), this.rjH.cpP(), str2, ag.cpo()))
      {
        ab.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
        h.qsU.idkeyStat(150L, 27L, 1L, true);
      }
      l3 = bo.av(l3);
      boolean bool = com.tencent.mm.vfs.e.cN(this.rjH.getPath() + this.rjH.cpP());
      com.tencent.mm.vfs.e.deleteFile(this.rjH.getPath() + this.rjH.cpP());
      l2 = bo.av(l2);
      if (!com.tencent.mm.vfs.e.cN(this.rjH.getPath() + str2))
      {
        ab.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(this.rjH.getPath() + str2)) });
        h.qsU.idkeyStat(150L, 31L, 1L, true);
        if ((bool) && (!com.tencent.mm.vfs.e.cN(this.rjH.getPath() + str2)))
        {
          bool = com.tencent.mm.plugin.normsg.a.b.pgQ.bXp();
          ab.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[] { Boolean.valueOf(bool) });
          h.qsU.idkeyStat(150L, 32L, 1L, true);
          if (bool) {
            h.qsU.idkeyStat(150L, 33L, 1L, true);
          }
        }
      }
      h.qsU.e(11696, new Object[] { Integer.valueOf(3), Long.valueOf(l2), Integer.valueOf(this.rka), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
      if ((this.rjH.rbc.rbj == 0) || (this.rjH.rbc.rbj == 5))
      {
        str1 = com.tencent.mm.plugin.sns.data.i.f(this.cIc);
        s.b(this.rjH.getPath(), str2, str1, ag.cpn());
      }
      for (;;)
      {
        c.a(this.rjH.getPath() + str1, this.rjH.url, 1, localOptions.outMimeType, localOptions.outWidth, localOptions.outHeight, i, l1, l3);
        this.rjG = com.tencent.mm.plugin.sns.data.i.ZH(this.rjH.getPath() + str1);
        bool = com.tencent.mm.plugin.sns.data.i.b(this.rjG);
        ab.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + bool + " isWebp: " + this.flB + " srcImgFileSize: " + l1);
        if (!bool)
        {
          h.qsU.idkeyStat(150L, 65L, 1L, true);
          if (!this.rkk) {
            break label1104;
          }
          h.qsU.idkeyStat(150L, 50L, 1L, true);
        }
        for (;;)
        {
          if (this.rkj) {
            h.qsU.idkeyStat(150L, 54L, 1L, true);
          }
          if (this.rki) {
            h.qsU.idkeyStat(150L, 57L, 1L, true);
          }
          if ((this.flB) && (!bool)) {
            h.qsU.idkeyStat(22L, 65L, 1L, true);
          }
          if ((this.rkk) && (bool)) {
            com.tencent.mm.plugin.sns.lucky.a.b.kS(139);
          }
          AppMethodBeat.o(36755);
          return true;
          str1 = "";
          break;
          h.qsU.idkeyStat(150L, 51L, 1L, true);
        }
        str1 = str2;
      }
    }
  }
  
  protected final int cpS()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.i
 * JD-Core Version:    0.7.0.1
 */