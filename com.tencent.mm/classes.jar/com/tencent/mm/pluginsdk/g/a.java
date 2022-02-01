package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements h
{
  String Tql;
  private boolean Uz;
  private int XOA;
  private int XOB;
  public String XOC;
  public String XOD;
  public String XOE;
  public String XOF;
  public int XOG;
  public String XOH;
  public String XOI;
  public String XOJ;
  public boolean XOK;
  private g XOL;
  private String XOM;
  private List<f> XON;
  private List<f> XOO;
  private int XOP;
  private int XOQ;
  private long XOz;
  public int fileType;
  public String nRv;
  public int scene;
  private int successCount;
  
  public a(g paramg)
  {
    AppMethodBeat.i(244964);
    this.XOQ = 0;
    this.XOL = paramg;
    this.XOB = iGN();
    this.XOA = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpD, 10);
    this.XON = Collections.synchronizedList(new ArrayList());
    this.XOO = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(244964);
  }
  
  private boolean avA(int paramInt)
  {
    AppMethodBeat.i(244975);
    if (!this.Uz)
    {
      Log.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
      AppMethodBeat.o(244975);
      return false;
    }
    Object localObject;
    do
    {
      this.XOO.remove(0);
      this.XON.add(localObject);
      ((f)localObject).iGR();
      Log.i("MicroMsg.CGIFileUploader", "start section idx = %s", new Object[] { Integer.valueOf(((f)localObject).XPi.XPe) });
      if ((this.XON.size() >= this.XOA) || (this.XOO.size() <= 1)) {
        break;
      }
      if (paramInt - 1 == this.XOQ)
      {
        Log.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.XOQ + 1) });
        avz(-30004);
        AppMethodBeat.o(244975);
        return false;
      }
      localObject = (f)this.XOO.get(0);
    } while (((f)localObject).taskId <= this.XOQ);
    Log.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
    AppMethodBeat.o(244975);
    return true;
    AppMethodBeat.o(244975);
    return true;
  }
  
  private void avz(int paramInt)
  {
    AppMethodBeat.i(244973);
    iGP();
    if (this.XOL != null) {
      this.XOL.a(this, this.XOM, paramInt);
    }
    AppMethodBeat.o(244973);
  }
  
  private static int iGN()
  {
    AppMethodBeat.i(244960);
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("ParallelUploadPartSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = Util.getInt(str, 32768);
        AppMethodBeat.o(244960);
        return i;
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 32768;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.CGIFileUploader", localThrowable, "getFileSizeLimit", new Object[0]);
      AppMethodBeat.o(244960);
    }
  }
  
  private void iGO()
  {
    AppMethodBeat.i(244969);
    if (this.XOO.size() <= 0)
    {
      Log.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", new Object[] { this.Tql });
      if (this.XOL != null) {
        this.XOL.a(this, this.XOM, -30003);
      }
      AppMethodBeat.o(244969);
      return;
    }
    f localf = (f)this.XOO.get(0);
    this.XOO.remove(0);
    this.XON.add(localf);
    localf.iGR();
    AppMethodBeat.o(244969);
  }
  
  public final void a(f paramf, eat parameat)
  {
    AppMethodBeat.i(244990);
    this.successCount += 1;
    int i;
    if (parameat != null)
    {
      i = parameat.abgf;
      Log.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", new Object[] { Integer.valueOf(paramf.XPi.XPe), Integer.valueOf(this.successCount), Integer.valueOf(i) });
      this.XON.remove(paramf);
      if (i <= this.XOQ) {
        break label180;
      }
    }
    for (;;)
    {
      this.XOQ = i;
      if (this.XOP > 0) {
        this.XOL.a(this, this.successCount * 1.0F / this.XOP, paramf.XPi.XPf + paramf.XPi.XOB);
      }
      if (paramf.XPi.XPe != 0) {
        break label234;
      }
      if (!Util.isNullOrNil(parameat.abfZ)) {
        break label188;
      }
      Log.e("MicroMsg.CGIFileUploader", "no upload id return!");
      avz(-30002);
      AppMethodBeat.o(244990);
      return;
      i = 0;
      break;
      label180:
      i = this.XOQ;
    }
    label188:
    this.XOM = parameat.abfZ;
    paramf = this.XOO.iterator();
    while (paramf.hasNext()) {
      ((f)paramf.next()).XPg = parameat.abfZ;
    }
    label234:
    if (!avA(this.successCount))
    {
      AppMethodBeat.o(244990);
      return;
    }
    if ((this.XOO.size() == 1) && (this.XON.size() == 0)) {
      iGO();
    }
    if ((this.XOO.size() == 0) && (this.XON.size() == 0))
    {
      paramf = new g.a();
      paramf.XPg = this.XOM;
      paramf.fileId = parameat.ZBp;
      paramf.aesKey = parameat.AesKey;
      paramf.XPn = parameat.abge;
      paramf.fileLength = this.XOz;
      iGP();
      if (this.XOL != null) {
        this.XOL.a(this, paramf);
      }
    }
    AppMethodBeat.o(244990);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(244991);
    Log.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", new Object[] { Integer.valueOf(paramf.XPi.XPe), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.XON.remove(paramf);
    if (paramBoolean)
    {
      paramf.retryCount += 1;
      if (paramf.XPi.XPe == 0)
      {
        this.XOO.add(0, paramf);
        iGO();
        AppMethodBeat.o(244991);
        return;
      }
      if (paramf.XPi.XPe == this.XOP - 1)
      {
        this.XOO.add(paramf);
        iGO();
        AppMethodBeat.o(244991);
        return;
      }
      this.XOO.add(0, paramf);
      avA(this.successCount);
      AppMethodBeat.o(244991);
      return;
    }
    avz(paramInt);
    AppMethodBeat.o(244991);
  }
  
  public final void ch(String paramString, long paramLong)
  {
    this.Tql = paramString;
    this.XOz = paramLong;
  }
  
  public final void fFA()
  {
    AppMethodBeat.i(244981);
    if (this.Uz)
    {
      Log.d("MicroMsg.CGIFileUploader", "uploader is already running");
      AppMethodBeat.o(244981);
      return;
    }
    if (!y.ZC(this.Tql))
    {
      Log.e("MicroMsg.CGIFileUploader", "file %s not exist", new Object[] { this.Tql });
      if (this.XOL != null) {
        this.XOL.a(this, this.XOM, -30001);
      }
      AppMethodBeat.o(244981);
      return;
    }
    long l = this.XOz;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = new e();
      ((e)localObject).filePath = this.Tql;
      ((e)localObject).fileSize = this.XOz;
      ((e)localObject).XPe = i;
      ((e)localObject).XPf = j;
      if (this.XOB + j > l) {}
      for (((e)localObject).XOB = ((int)(l - j));; ((e)localObject).XOB = this.XOB)
      {
        j += this.XOB;
        f localf = new f();
        localf.XPk = this;
        localf.XPi = ((e)localObject);
        localf.taskId = ((e)localObject).XPe;
        localf.retryCount = 0;
        localf.Jmi = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpE, 3);
        if (i == 0)
        {
          this.XOJ = y.bub(this.Tql);
          localObject = new eau();
          ((eau)localObject).IJG = this.scene;
          ((eau)localObject).YIE = this.fileType;
          ((eau)localObject).Nju = ((int)this.XOz);
          ((eau)localObject).abgg = this.XOJ;
          ((eau)localObject).abgh = this.XOB;
          ((eau)localObject).abgi = this.XOD;
          ((eau)localObject).abgj = this.nRv;
          ((eau)localObject).abgl = this.XOE;
          ((eau)localObject).abgm = this.XOF;
          ((eau)localObject).abgn = this.XOG;
          ((eau)localObject).abgk = this.XOC;
          ((eau)localObject).pSi = this.XOH;
          ((eau)localObject).abgo = this.XOI;
          if (this.XOK) {
            ((eau)localObject).abgp = "HDVideo:1";
          }
          localf.XPh = ((eau)localObject);
        }
        this.XOO.add(localf);
        if (j < l) {
          break;
        }
        this.XOP = this.XOO.size();
        Log.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", new Object[] { this.Tql, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.XOB), Integer.valueOf(this.XOO.size()) });
        this.Uz = true;
        iGO();
        AppMethodBeat.o(244981);
        return;
      }
      i += 1;
    }
  }
  
  public final void iGP()
  {
    AppMethodBeat.i(244985);
    this.Uz = false;
    Iterator localIterator = this.XON.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).iGS();
    }
    AppMethodBeat.o(244985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a
 * JD-Core Version:    0.7.0.1
 */