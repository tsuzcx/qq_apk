package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements h
{
  String MFQ;
  private long QSB;
  private int QSC;
  private int QSD;
  public String QSE;
  public String QSF;
  public String QSG;
  public String QSH;
  public int QSI;
  public String QSJ;
  public String QSK;
  public String QSL;
  private g QSM;
  private String QSN;
  private List<f> QSO;
  private List<f> QSP;
  private int QSQ;
  private int QSR;
  public int fileType;
  private boolean isRunning;
  public String lmq;
  public int scene;
  private int successCount;
  
  public a(g paramg)
  {
    AppMethodBeat.i(197599);
    this.QSR = 0;
    this.QSM = paramg;
    this.QSD = hfU();
    this.QSC = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vWY, 10);
    this.QSO = Collections.synchronizedList(new ArrayList());
    this.QSP = Collections.synchronizedList(new ArrayList());
    AppMethodBeat.o(197599);
  }
  
  private void apv(int paramInt)
  {
    AppMethodBeat.i(197628);
    hfW();
    if (this.QSM != null) {
      this.QSM.a(this, this.QSN, paramInt);
    }
    AppMethodBeat.o(197628);
  }
  
  private boolean apw(int paramInt)
  {
    AppMethodBeat.i(197640);
    if (!this.isRunning)
    {
      Log.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
      AppMethodBeat.o(197640);
      return false;
    }
    Object localObject;
    do
    {
      this.QSP.remove(0);
      this.QSO.add(localObject);
      ((f)localObject).hfY();
      Log.i("MicroMsg.CGIFileUploader", "start section idx = %s", new Object[] { Integer.valueOf(((f)localObject).QTh.QTd) });
      if ((this.QSO.size() >= this.QSC) || (this.QSP.size() <= 1)) {
        break;
      }
      if (paramInt - 1 == this.QSR)
      {
        Log.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.QSR + 1) });
        apv(-30004);
        AppMethodBeat.o(197640);
        return false;
      }
      localObject = (f)this.QSP.get(0);
    } while (((f)localObject).taskId <= this.QSR);
    Log.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
    AppMethodBeat.o(197640);
    return true;
    AppMethodBeat.o(197640);
    return true;
  }
  
  private static int hfU()
  {
    AppMethodBeat.i(197594);
    try
    {
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("ParallelUploadPartSize");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
      }
      for (;;)
      {
        int i = Util.getInt(str, 32768);
        AppMethodBeat.o(197594);
        return i;
        Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(str)));
      }
      return 32768;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.CGIFileUploader", localThrowable, "getFileSizeLimit", new Object[0]);
      AppMethodBeat.o(197594);
    }
  }
  
  private void hfV()
  {
    AppMethodBeat.i(197624);
    if (this.QSP.size() <= 0)
    {
      Log.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", new Object[] { this.MFQ });
      if (this.QSM != null) {
        this.QSM.a(this, this.QSN, -30003);
      }
      AppMethodBeat.o(197624);
      return;
    }
    f localf = (f)this.QSP.get(0);
    this.QSP.remove(0);
    this.QSO.add(localf);
    localf.hfY();
    AppMethodBeat.o(197624);
  }
  
  private void hfW()
  {
    AppMethodBeat.i(197643);
    this.isRunning = false;
    Iterator localIterator = this.QSO.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).hfZ();
    }
    AppMethodBeat.o(197643);
  }
  
  public final void a(f paramf, dij paramdij)
  {
    AppMethodBeat.i(197660);
    this.successCount += 1;
    int i;
    if (paramdij != null)
    {
      i = paramdij.TPJ;
      Log.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", new Object[] { Integer.valueOf(paramf.QTh.QTd), Integer.valueOf(this.successCount), Integer.valueOf(i) });
      this.QSO.remove(paramf);
      if (i <= this.QSR) {
        break label181;
      }
    }
    for (;;)
    {
      this.QSR = i;
      if (this.QSQ > 0) {
        this.QSM.a(this, this.successCount * 1.0F / this.QSQ, paramf.QTh.QTe + paramf.QTh.QSD);
      }
      if (paramf.QTh.QTd != 0) {
        break label235;
      }
      if (!Util.isNullOrNil(paramdij.TPD)) {
        break label189;
      }
      Log.e("MicroMsg.CGIFileUploader", "no upload id return!");
      apv(-30002);
      AppMethodBeat.o(197660);
      return;
      i = 0;
      break;
      label181:
      i = this.QSR;
    }
    label189:
    this.QSN = paramdij.TPD;
    paramf = this.QSP.iterator();
    while (paramf.hasNext()) {
      ((f)paramf.next()).QTf = paramdij.TPD;
    }
    label235:
    if (!apw(this.successCount))
    {
      AppMethodBeat.o(197660);
      return;
    }
    if ((this.QSP.size() == 1) && (this.QSO.size() == 0)) {
      hfV();
    }
    if ((this.QSP.size() == 0) && (this.QSO.size() == 0))
    {
      paramf = new g.a();
      paramf.QTf = this.QSN;
      paramf.fileId = paramdij.SAx;
      paramf.aesKey = paramdij.AesKey;
      paramf.QTm = paramdij.TPI;
      paramf.mHi = this.QSB;
      hfW();
      if (this.QSM != null) {
        this.QSM.a(this, paramf);
      }
    }
    AppMethodBeat.o(197660);
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(197671);
    Log.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", new Object[] { Integer.valueOf(paramf.QTh.QTd), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    this.QSO.remove(paramf);
    if (paramBoolean)
    {
      paramf.retryCount += 1;
      if (paramf.QTh.QTd == 0)
      {
        this.QSP.add(0, paramf);
        hfV();
        AppMethodBeat.o(197671);
        return;
      }
      if (paramf.QTh.QTd == this.QSQ - 1)
      {
        this.QSP.add(paramf);
        hfV();
        AppMethodBeat.o(197671);
        return;
      }
      this.QSP.add(0, paramf);
      apw(this.successCount);
      AppMethodBeat.o(197671);
      return;
    }
    apv(paramInt);
    AppMethodBeat.o(197671);
  }
  
  public final void bW(String paramString, long paramLong)
  {
    this.MFQ = paramString;
    this.QSB = paramLong;
  }
  
  public final void exE()
  {
    AppMethodBeat.i(197617);
    if (this.isRunning)
    {
      Log.d("MicroMsg.CGIFileUploader", "uploader is already running");
      AppMethodBeat.o(197617);
      return;
    }
    if (!u.agG(this.MFQ))
    {
      Log.e("MicroMsg.CGIFileUploader", "file %s not exist", new Object[] { this.MFQ });
      if (this.QSM != null) {
        this.QSM.a(this, this.QSN, -30001);
      }
      AppMethodBeat.o(197617);
      return;
    }
    long l = this.QSB;
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject = new e();
      ((e)localObject).filePath = this.MFQ;
      ((e)localObject).fileSize = this.QSB;
      ((e)localObject).QTd = i;
      ((e)localObject).QTe = j;
      if (this.QSD + j > l) {}
      for (((e)localObject).QSD = ((int)(l - j));; ((e)localObject).QSD = this.QSD)
      {
        j += this.QSD;
        f localf = new f();
        localf.QTj = this;
        localf.QTh = ((e)localObject);
        localf.taskId = ((e)localObject).QTd;
        localf.retryCount = 0;
        localf.DsT = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vWZ, 3);
        if (i == 0)
        {
          this.QSL = u.buc(this.MFQ);
          localObject = new dik();
          ((dik)localObject).CPw = this.scene;
          ((dik)localObject).RLs = this.fileType;
          ((dik)localObject).HlG = ((int)this.QSB);
          ((dik)localObject).TPK = this.QSL;
          ((dik)localObject).TPL = this.QSD;
          ((dik)localObject).TPM = this.QSF;
          ((dik)localObject).TPN = this.lmq;
          ((dik)localObject).TPP = this.QSG;
          ((dik)localObject).TPQ = this.QSH;
          ((dik)localObject).TPR = this.QSI;
          ((dik)localObject).TPO = this.QSE;
          ((dik)localObject).mVB = this.QSJ;
          ((dik)localObject).TPS = this.QSK;
          localf.QTg = ((dik)localObject);
        }
        this.QSP.add(localf);
        if (j < l) {
          break;
        }
        this.QSQ = this.QSP.size();
        Log.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", new Object[] { this.MFQ, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.QSD), Integer.valueOf(this.QSP.size()) });
        this.isRunning = true;
        hfV();
        AppMethodBeat.o(197617);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a
 * JD-Core Version:    0.7.0.1
 */