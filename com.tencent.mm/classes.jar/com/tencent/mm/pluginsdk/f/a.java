package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements h
{
  String FcD;
  private long FcE;
  private int FcF;
  private int FcG;
  public String FcH;
  public String FcI;
  public String FcJ;
  public String FcK;
  public int FcL;
  public String FcM;
  public String FcN;
  public String FcO;
  private g FcP;
  private String FcQ;
  private List<f> FcR;
  private List<f> FcS;
  private int FcT;
  private int FcU;
  public int fileType;
  public String hCW;
  private boolean isRunning;
  public int scene;
  private int successCount;
  
  public a(g paramg)
  {
    AppMethodBeat.i(218791);
    this.FcU = 0;
    this.FcP = paramg;
    this.FcG = fcT();
    this.FcF = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qPc, 10);
    this.FcR = Collections.synchronizedList(new ArrayList());
    this.FcS = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(218791);
  }
  
  private void YM(int paramInt)
  {
    AppMethodBeat.i(218794);
    fcV();
    if (this.FcP != null) {
      this.FcP.a(this, this.FcQ, paramInt);
    }
    AppMethodBeat.o(218794);
  }
  
  private boolean YN(int paramInt)
  {
    AppMethodBeat.i(218795);
    if (!this.isRunning)
    {
      ae.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
      AppMethodBeat.o(218795);
      return false;
    }
    Object localObject;
    do
    {
      this.FcS.remove(0);
      this.FcR.add(localObject);
      ((f)localObject).fcX();
      ae.i("MicroMsg.CGIFileUploader", "start section idx = %s", new Object[] { Integer.valueOf(((f)localObject).Fdl.Fdh) });
      if ((this.FcR.size() >= this.FcF) || (this.FcS.size() <= 1)) {
        break;
      }
      if (paramInt - 1 == this.FcU)
      {
        ae.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.FcU + 1) });
        YM(-30004);
        AppMethodBeat.o(218795);
        return false;
      }
      localObject = (f)this.FcS.get(0);
    } while (((f)localObject).taskId <= this.FcU);
    ae.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
    AppMethodBeat.o(218795);
    return true;
    AppMethodBeat.o(218795);
    return true;
  }
  
  private static int fcT()
  {
    AppMethodBeat.i(218790);
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("ParallelUploadPartSize");
      if (bu.isNullOrNil(str)) {
        ae.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = bu.getInt(str, 32768);
        AppMethodBeat.o(218790);
        return i;
        ae.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 32768;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.CGIFileUploader", localThrowable, "getFileSizeLimit", new Object[0]);
      AppMethodBeat.o(218790);
    }
  }
  
  private void fcU()
  {
    AppMethodBeat.i(218793);
    if (this.FcS.size() <= 0)
    {
      ae.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", new Object[] { this.FcD });
      if (this.FcP != null) {
        this.FcP.a(this, this.FcQ, -30003);
      }
      AppMethodBeat.o(218793);
      return;
    }
    f localf = (f)this.FcS.get(0);
    this.FcS.remove(0);
    this.FcR.add(localf);
    localf.fcX();
    AppMethodBeat.o(218793);
  }
  
  private void fcV()
  {
    AppMethodBeat.i(218796);
    this.isRunning = false;
    Iterator localIterator = this.FcR.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).fcY();
    }
    AppMethodBeat.o(218796);
  }
  
  public final void a(f paramf, ciq paramciq)
  {
    AppMethodBeat.i(218797);
    this.successCount += 1;
    int i;
    if (paramciq != null)
    {
      i = paramciq.Hvc;
      ae.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", new Object[] { Integer.valueOf(paramf.Fdl.Fdh), Integer.valueOf(this.successCount), Integer.valueOf(i) });
      this.FcR.remove(paramf);
      if (i <= this.FcU) {
        break label181;
      }
    }
    for (;;)
    {
      this.FcU = i;
      if (this.FcT > 0) {
        this.FcP.a(this, this.successCount * 1.0F / this.FcT, paramf.Fdl.Fdi + paramf.Fdl.FcG);
      }
      if (paramf.Fdl.Fdh != 0) {
        break label235;
      }
      if (!bu.isNullOrNil(paramciq.HuW)) {
        break label189;
      }
      ae.e("MicroMsg.CGIFileUploader", "no upload id return!");
      YM(-30002);
      AppMethodBeat.o(218797);
      return;
      i = 0;
      break;
      label181:
      i = this.FcU;
    }
    label189:
    this.FcQ = paramciq.HuW;
    paramf = this.FcS.iterator();
    while (paramf.hasNext()) {
      ((f)paramf.next()).Fdj = paramciq.HuW;
    }
    label235:
    if (!YN(this.successCount))
    {
      AppMethodBeat.o(218797);
      return;
    }
    if ((this.FcS.size() == 1) && (this.FcR.size() == 0)) {
      fcU();
    }
    if ((this.FcS.size() == 0) && (this.FcR.size() == 0))
    {
      paramf = new g.a();
      paramf.Fdj = this.FcQ;
      paramf.fileId = paramciq.GCa;
      paramf.gmb = paramciq.AesKey;
      paramf.Fdq = paramciq.Hvb;
      paramf.iTe = this.FcE;
      fcV();
      if (this.FcP != null) {
        this.FcP.a(this, paramf);
      }
    }
    AppMethodBeat.o(218797);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(218798);
    ae.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", new Object[] { Integer.valueOf(paramf.Fdl.Fdh), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.FcR.remove(paramf);
    if (paramBoolean)
    {
      paramf.retryCount += 1;
      if (paramf.Fdl.Fdh == 0)
      {
        this.FcS.add(0, paramf);
        fcU();
        AppMethodBeat.o(218798);
        return;
      }
      if (paramf.Fdl.Fdh == this.FcT - 1)
      {
        this.FcS.add(paramf);
        fcU();
        AppMethodBeat.o(218798);
        return;
      }
      this.FcS.add(0, paramf);
      YN(this.successCount);
      AppMethodBeat.o(218798);
      return;
    }
    YM(paramInt);
    AppMethodBeat.o(218798);
  }
  
  public final void bO(String paramString, long paramLong)
  {
    this.FcD = paramString;
    this.FcE = paramLong;
  }
  
  public final void daP()
  {
    AppMethodBeat.i(218792);
    if (this.isRunning)
    {
      ae.d("MicroMsg.CGIFileUploader", "uploader is already running");
      AppMethodBeat.o(218792);
      return;
    }
    if (!o.fB(this.FcD))
    {
      ae.e("MicroMsg.CGIFileUploader", "file %s not exist", new Object[] { this.FcD });
      if (this.FcP != null) {
        this.FcP.a(this, this.FcQ, -30001);
      }
      AppMethodBeat.o(218792);
      return;
    }
    long l = this.FcE;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = new e();
      ((e)localObject).filePath = this.FcD;
      ((e)localObject).fileSize = this.FcE;
      ((e)localObject).Fdh = i;
      ((e)localObject).Fdi = j;
      if (this.FcG + j > l) {}
      for (((e)localObject).FcG = ((int)(l - j));; ((e)localObject).FcG = this.FcG)
      {
        j += this.FcG;
        f localf = new f();
        localf.Fdn = this;
        localf.Fdl = ((e)localObject);
        localf.taskId = ((e)localObject).Fdh;
        localf.retryCount = 0;
        localf.uQm = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qPd, 3);
        if (i == 0)
        {
          this.FcO = o.aRh(this.FcD);
          localObject = new cir();
          ((cir)localObject).Scene = this.scene;
          ((cir)localObject).FQT = this.fileType;
          ((cir)localObject).FileSize = ((int)this.FcE);
          ((cir)localObject).Hvd = this.FcO;
          ((cir)localObject).Hve = this.FcG;
          ((cir)localObject).Hvf = this.FcI;
          ((cir)localObject).Hvg = this.hCW;
          ((cir)localObject).Hvi = this.FcJ;
          ((cir)localObject).Hvj = this.FcK;
          ((cir)localObject).Hvk = this.FcL;
          ((cir)localObject).Hvh = this.FcH;
          ((cir)localObject).jfY = this.FcM;
          ((cir)localObject).Hvl = this.FcN;
          localf.Fdk = ((cir)localObject);
        }
        this.FcS.add(localf);
        if (j < l) {
          break;
        }
        this.FcT = this.FcS.size();
        ae.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", new Object[] { this.FcD, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.FcG), Integer.valueOf(this.FcS.size()) });
        this.isRunning = true;
        fcU();
        AppMethodBeat.o(218792);
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