package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements h
{
  String GaX;
  public String JTA;
  public String JTB;
  public int JTC;
  public String JTD;
  public String JTE;
  public String JTF;
  private g JTG;
  private String JTH;
  private List<f> JTI;
  private List<f> JTJ;
  private int JTK;
  private int JTL;
  private long JTv;
  private int JTw;
  private int JTx;
  public String JTy;
  public String JTz;
  public int fileType;
  private boolean isRunning;
  public String ixb;
  public int scene;
  private int successCount;
  
  public a(g paramg)
  {
    AppMethodBeat.i(223722);
    this.JTL = 0;
    this.JTG = paramg;
    this.JTx = gmd();
    this.JTw = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.smj, 10);
    this.JTI = Collections.synchronizedList(new ArrayList());
    this.JTJ = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(223722);
  }
  
  private void ahy(int paramInt)
  {
    AppMethodBeat.i(223725);
    gmf();
    if (this.JTG != null) {
      this.JTG.a(this, this.JTH, paramInt);
    }
    AppMethodBeat.o(223725);
  }
  
  private boolean ahz(int paramInt)
  {
    AppMethodBeat.i(223726);
    if (!this.isRunning)
    {
      Log.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
      AppMethodBeat.o(223726);
      return false;
    }
    Object localObject;
    do
    {
      this.JTJ.remove(0);
      this.JTI.add(localObject);
      ((f)localObject).gmh();
      Log.i("MicroMsg.CGIFileUploader", "start section idx = %s", new Object[] { Integer.valueOf(((f)localObject).JUb.JTX) });
      if ((this.JTI.size() >= this.JTw) || (this.JTJ.size() <= 1)) {
        break;
      }
      if (paramInt - 1 == this.JTL)
      {
        Log.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JTL + 1) });
        ahy(-30004);
        AppMethodBeat.o(223726);
        return false;
      }
      localObject = (f)this.JTJ.get(0);
    } while (((f)localObject).taskId <= this.JTL);
    Log.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
    AppMethodBeat.o(223726);
    return true;
    AppMethodBeat.o(223726);
    return true;
  }
  
  private static int gmd()
  {
    AppMethodBeat.i(223721);
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ParallelUploadPartSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = Util.getInt(str, 32768);
        AppMethodBeat.o(223721);
        return i;
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 32768;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.CGIFileUploader", localThrowable, "getFileSizeLimit", new Object[0]);
      AppMethodBeat.o(223721);
    }
  }
  
  private void gme()
  {
    AppMethodBeat.i(223724);
    if (this.JTJ.size() <= 0)
    {
      Log.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", new Object[] { this.GaX });
      if (this.JTG != null) {
        this.JTG.a(this, this.JTH, -30003);
      }
      AppMethodBeat.o(223724);
      return;
    }
    f localf = (f)this.JTJ.get(0);
    this.JTJ.remove(0);
    this.JTI.add(localf);
    localf.gmh();
    AppMethodBeat.o(223724);
  }
  
  private void gmf()
  {
    AppMethodBeat.i(223727);
    this.isRunning = false;
    Iterator localIterator = this.JTI.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).gmi();
    }
    AppMethodBeat.o(223727);
  }
  
  public final void a(f paramf, cyx paramcyx)
  {
    AppMethodBeat.i(223728);
    this.successCount += 1;
    int i;
    if (paramcyx != null)
    {
      i = paramcyx.MEa;
      Log.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", new Object[] { Integer.valueOf(paramf.JUb.JTX), Integer.valueOf(this.successCount), Integer.valueOf(i) });
      this.JTI.remove(paramf);
      if (i <= this.JTL) {
        break label181;
      }
    }
    for (;;)
    {
      this.JTL = i;
      if (this.JTK > 0) {
        this.JTG.a(this, this.successCount * 1.0F / this.JTK, paramf.JUb.JTY + paramf.JUb.JTx);
      }
      if (paramf.JUb.JTX != 0) {
        break label235;
      }
      if (!Util.isNullOrNil(paramcyx.MDU)) {
        break label189;
      }
      Log.e("MicroMsg.CGIFileUploader", "no upload id return!");
      ahy(-30002);
      AppMethodBeat.o(223728);
      return;
      i = 0;
      break;
      label181:
      i = this.JTL;
    }
    label189:
    this.JTH = paramcyx.MDU;
    paramf = this.JTJ.iterator();
    while (paramf.hasNext()) {
      ((f)paramf.next()).JTZ = paramcyx.MDU;
    }
    label235:
    if (!ahz(this.successCount))
    {
      AppMethodBeat.o(223728);
      return;
    }
    if ((this.JTJ.size() == 1) && (this.JTI.size() == 0)) {
      gme();
    }
    if ((this.JTJ.size() == 0) && (this.JTI.size() == 0))
    {
      paramf = new g.a();
      paramf.JTZ = this.JTH;
      paramf.fileId = paramcyx.LxW;
      paramf.aesKey = paramcyx.AesKey;
      paramf.JUg = paramcyx.MDZ;
      paramf.jPY = this.JTv;
      gmf();
      if (this.JTG != null) {
        this.JTG.a(this, paramf);
      }
    }
    AppMethodBeat.o(223728);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(223729);
    Log.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", new Object[] { Integer.valueOf(paramf.JUb.JTX), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.JTI.remove(paramf);
    if (paramBoolean)
    {
      paramf.retryCount += 1;
      if (paramf.JUb.JTX == 0)
      {
        this.JTJ.add(0, paramf);
        gme();
        AppMethodBeat.o(223729);
        return;
      }
      if (paramf.JUb.JTX == this.JTK - 1)
      {
        this.JTJ.add(paramf);
        gme();
        AppMethodBeat.o(223729);
        return;
      }
      this.JTJ.add(0, paramf);
      ahz(this.successCount);
      AppMethodBeat.o(223729);
      return;
    }
    ahy(paramInt);
    AppMethodBeat.o(223729);
  }
  
  public final void bP(String paramString, long paramLong)
  {
    this.GaX = paramString;
    this.JTv = paramLong;
  }
  
  public final void dUx()
  {
    AppMethodBeat.i(223723);
    if (this.isRunning)
    {
      Log.d("MicroMsg.CGIFileUploader", "uploader is already running");
      AppMethodBeat.o(223723);
      return;
    }
    if (!s.YS(this.GaX))
    {
      Log.e("MicroMsg.CGIFileUploader", "file %s not exist", new Object[] { this.GaX });
      if (this.JTG != null) {
        this.JTG.a(this, this.JTH, -30001);
      }
      AppMethodBeat.o(223723);
      return;
    }
    long l = this.JTv;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = new e();
      ((e)localObject).filePath = this.GaX;
      ((e)localObject).fileSize = this.JTv;
      ((e)localObject).JTX = i;
      ((e)localObject).JTY = j;
      if (this.JTx + j > l) {}
      for (((e)localObject).JTx = ((int)(l - j));; ((e)localObject).JTx = this.JTx)
      {
        j += this.JTx;
        f localf = new f();
        localf.JUd = this;
        localf.JUb = ((e)localObject);
        localf.taskId = ((e)localObject).JTX;
        localf.retryCount = 0;
        localf.yiR = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.smk, 3);
        if (i == 0)
        {
          this.JTF = s.bhK(this.GaX);
          localObject = new cyy();
          ((cyy)localObject).Scene = this.scene;
          ((cyy)localObject).KKA = this.fileType;
          ((cyy)localObject).FileSize = ((int)this.JTv);
          ((cyy)localObject).MEb = this.JTF;
          ((cyy)localObject).MEc = this.JTx;
          ((cyy)localObject).MEd = this.JTz;
          ((cyy)localObject).MEe = this.ixb;
          ((cyy)localObject).MEg = this.JTA;
          ((cyy)localObject).MEh = this.JTB;
          ((cyy)localObject).MEi = this.JTC;
          ((cyy)localObject).MEf = this.JTy;
          ((cyy)localObject).keb = this.JTD;
          ((cyy)localObject).MEj = this.JTE;
          localf.JUa = ((cyy)localObject);
        }
        this.JTJ.add(localf);
        if (j < l) {
          break;
        }
        this.JTK = this.JTJ.size();
        Log.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", new Object[] { this.GaX, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.JTx), Integer.valueOf(this.JTJ.size()) });
        this.isRunning = true;
        gme();
        AppMethodBeat.o(223723);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.a
 * JD-Core Version:    0.7.0.1
 */