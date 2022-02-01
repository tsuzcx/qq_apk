package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements h
{
  String EKf;
  private long EKg;
  private int EKh;
  private int EKi;
  public String EKj;
  public String EKk;
  public String EKl;
  public String EKm;
  public int EKn;
  public String EKo;
  public String EKp;
  public String EKq;
  private g EKr;
  private String EKs;
  private List<f> EKt;
  private List<f> EKu;
  private int EKv;
  private int EKw;
  public int fileType;
  public String hAi;
  private boolean isRunning;
  public int scene;
  private int successCount;
  
  public a(g paramg)
  {
    AppMethodBeat.i(195338);
    this.EKw = 0;
    this.EKr = paramg;
    this.EKi = eZf();
    this.EKh = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qHw, 10);
    this.EKt = Collections.synchronizedList(new ArrayList());
    this.EKu = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(195338);
  }
  
  private void Yg(int paramInt)
  {
    AppMethodBeat.i(195341);
    eZh();
    if (this.EKr != null) {
      this.EKr.a(this, this.EKs, paramInt);
    }
    AppMethodBeat.o(195341);
  }
  
  private boolean Yh(int paramInt)
  {
    AppMethodBeat.i(195342);
    if (!this.isRunning)
    {
      ad.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
      AppMethodBeat.o(195342);
      return false;
    }
    Object localObject;
    do
    {
      this.EKu.remove(0);
      this.EKt.add(localObject);
      ((f)localObject).eZj();
      ad.i("MicroMsg.CGIFileUploader", "start section idx = %s", new Object[] { Integer.valueOf(((f)localObject).EKN.EKJ) });
      if ((this.EKt.size() >= this.EKh) || (this.EKu.size() <= 1)) {
        break;
      }
      if (paramInt - 1 == this.EKw)
      {
        ad.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.EKw + 1) });
        Yg(-30004);
        AppMethodBeat.o(195342);
        return false;
      }
      localObject = (f)this.EKu.get(0);
    } while (((f)localObject).taskId <= this.EKw);
    ad.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
    AppMethodBeat.o(195342);
    return true;
    AppMethodBeat.o(195342);
    return true;
  }
  
  private static int eZf()
  {
    AppMethodBeat.i(195337);
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("ParallelUploadPartSize");
      if (bt.isNullOrNil(str)) {
        ad.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = bt.getInt(str, 32768);
        AppMethodBeat.o(195337);
        return i;
        ad.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 32768;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.CGIFileUploader", localThrowable, "getFileSizeLimit", new Object[0]);
      AppMethodBeat.o(195337);
    }
  }
  
  private void eZg()
  {
    AppMethodBeat.i(195340);
    if (this.EKu.size() <= 0)
    {
      ad.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", new Object[] { this.EKf });
      if (this.EKr != null) {
        this.EKr.a(this, this.EKs, -30003);
      }
      AppMethodBeat.o(195340);
      return;
    }
    f localf = (f)this.EKu.get(0);
    this.EKu.remove(0);
    this.EKt.add(localf);
    localf.eZj();
    AppMethodBeat.o(195340);
  }
  
  private void eZh()
  {
    AppMethodBeat.i(195343);
    this.isRunning = false;
    Iterator localIterator = this.EKt.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).eZk();
    }
    AppMethodBeat.o(195343);
  }
  
  public final void a(f paramf, chw paramchw)
  {
    AppMethodBeat.i(195344);
    this.successCount += 1;
    int i;
    if (paramchw != null)
    {
      i = paramchw.HbC;
      ad.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", new Object[] { Integer.valueOf(paramf.EKN.EKJ), Integer.valueOf(this.successCount), Integer.valueOf(i) });
      this.EKt.remove(paramf);
      if (i <= this.EKw) {
        break label181;
      }
    }
    for (;;)
    {
      this.EKw = i;
      if (this.EKv > 0) {
        this.EKr.a(this, this.successCount * 1.0F / this.EKv, paramf.EKN.EKK + paramf.EKN.EKi);
      }
      if (paramf.EKN.EKJ != 0) {
        break label235;
      }
      if (!bt.isNullOrNil(paramchw.Hbw)) {
        break label189;
      }
      ad.e("MicroMsg.CGIFileUploader", "no upload id return!");
      Yg(-30002);
      AppMethodBeat.o(195344);
      return;
      i = 0;
      break;
      label181:
      i = this.EKw;
    }
    label189:
    this.EKs = paramchw.Hbw;
    paramf = this.EKu.iterator();
    while (paramf.hasNext()) {
      ((f)paramf.next()).EKL = paramchw.Hbw;
    }
    label235:
    if (!Yh(this.successCount))
    {
      AppMethodBeat.o(195344);
      return;
    }
    if ((this.EKu.size() == 1) && (this.EKt.size() == 0)) {
      eZg();
    }
    if ((this.EKu.size() == 0) && (this.EKt.size() == 0))
    {
      paramf = new g.a();
      paramf.EKL = this.EKs;
      paramf.fileId = paramchw.Gjr;
      paramf.gjI = paramchw.AesKey;
      paramf.EKS = paramchw.HbB;
      paramf.iQl = this.EKg;
      eZh();
      if (this.EKr != null) {
        this.EKr.a(this, paramf);
      }
    }
    AppMethodBeat.o(195344);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(195345);
    ad.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", new Object[] { Integer.valueOf(paramf.EKN.EKJ), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.EKt.remove(paramf);
    if (paramBoolean)
    {
      paramf.retryCount += 1;
      if (paramf.EKN.EKJ == 0)
      {
        this.EKu.add(0, paramf);
        eZg();
        AppMethodBeat.o(195345);
        return;
      }
      if (paramf.EKN.EKJ == this.EKv - 1)
      {
        this.EKu.add(paramf);
        eZg();
        AppMethodBeat.o(195345);
        return;
      }
      this.EKu.add(0, paramf);
      Yh(this.successCount);
      AppMethodBeat.o(195345);
      return;
    }
    Yg(paramInt);
    AppMethodBeat.o(195345);
  }
  
  public final void bN(String paramString, long paramLong)
  {
    this.EKf = paramString;
    this.EKg = paramLong;
  }
  
  public final void cYf()
  {
    AppMethodBeat.i(195339);
    if (this.isRunning)
    {
      ad.d("MicroMsg.CGIFileUploader", "uploader is already running");
      AppMethodBeat.o(195339);
      return;
    }
    if (!i.fv(this.EKf))
    {
      ad.e("MicroMsg.CGIFileUploader", "file %s not exist", new Object[] { this.EKf });
      if (this.EKr != null) {
        this.EKr.a(this, this.EKs, -30001);
      }
      AppMethodBeat.o(195339);
      return;
    }
    long l = this.EKg;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = new e();
      ((e)localObject).filePath = this.EKf;
      ((e)localObject).fileSize = this.EKg;
      ((e)localObject).EKJ = i;
      ((e)localObject).EKK = j;
      if (this.EKi + j > l) {}
      for (((e)localObject).EKi = ((int)(l - j));; ((e)localObject).EKi = this.EKi)
      {
        j += this.EKi;
        f localf = new f();
        localf.EKP = this;
        localf.EKN = ((e)localObject);
        localf.taskId = ((e)localObject).EKJ;
        localf.retryCount = 0;
        localf.uEz = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qHx, 3);
        if (i == 0)
        {
          this.EKq = i.aPK(this.EKf);
          localObject = new chx();
          ((chx)localObject).Scene = this.scene;
          ((chx)localObject).Fyv = this.fileType;
          ((chx)localObject).FileSize = ((int)this.EKg);
          ((chx)localObject).HbD = this.EKq;
          ((chx)localObject).HbE = this.EKi;
          ((chx)localObject).HbF = this.EKk;
          ((chx)localObject).HbG = this.hAi;
          ((chx)localObject).HbI = this.EKl;
          ((chx)localObject).HbJ = this.EKm;
          ((chx)localObject).HbK = this.EKn;
          ((chx)localObject).HbH = this.EKj;
          ((chx)localObject).jdf = this.EKo;
          ((chx)localObject).HbL = this.EKp;
          localf.EKM = ((chx)localObject);
        }
        this.EKu.add(localf);
        if (j < l) {
          break;
        }
        this.EKv = this.EKu.size();
        ad.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", new Object[] { this.EKf, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.EKi), Integer.valueOf(this.EKu.size()) });
        this.isRunning = true;
        eZg();
        AppMethodBeat.o(195339);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.a
 * JD-Core Version:    0.7.0.1
 */