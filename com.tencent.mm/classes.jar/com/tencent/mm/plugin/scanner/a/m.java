package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.Iterator;
import java.util.List;

public final class m
{
  public static int nGY = 0;
  public static int nGZ = 1;
  public static int nHa = 2;
  public static m nHb = new m();
  public float decodeScale;
  public int detectTime;
  private long nHc = 0L;
  public boolean nHd = false;
  public int nHe = 0;
  private long nHf = 0L;
  private Point nHg = null;
  private String nHh;
  private String nHi;
  private String nHj;
  private int nHk;
  private String nHl;
  private int nHm = 0;
  private int nHn;
  public int nHo = 0;
  private int nHp;
  private boolean nHq = false;
  public boolean nHr;
  public List<QbarNative.QBarCodeDetectInfo> nHs;
  public int nyR = -1;
  private int pyramidLv;
  private int retryCount = 0;
  public String scaleList;
  public int srTime;
  
  public final void a(String paramString1, String paramString2, String paramString3, QbarNative.QBarReportMsg paramQBarReportMsg, int paramInt1, int paramInt2)
  {
    this.nHh = paramString1;
    this.nHi = paramString2;
    this.nHj = paramString3;
    this.nHm = paramInt1;
    this.nHn = paramInt2;
    if (paramQBarReportMsg != null)
    {
      this.nHk = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.nHl = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    y.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.nHk), Integer.valueOf(this.pyramidLv), this.nHl, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime) });
  }
  
  public final void bcI()
  {
    if (this.nHq)
    {
      y.i("MicroMsg.QBarEngineReporter", "doReport, already report");
      return;
    }
    int j = this.nHe;
    long l1 = this.nHc;
    long l2 = this.nHf;
    int k = this.nyR;
    Object localObject1 = this.nHg;
    int m = this.retryCount;
    boolean bool = this.nHd;
    String str1 = this.nHh;
    Object localObject2 = this.nHi;
    Object localObject3 = this.nHj;
    int n = this.nHk;
    int i1 = this.pyramidLv;
    String str2 = this.nHl;
    int i;
    if (!bk.bl(this.nHi))
    {
      i = this.nHi.length();
      y.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject2, localObject3, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.nHo, Integer.valueOf(this.nHp) });
      if (this.nHg == null) {
        break label861;
      }
    }
    label563:
    label845:
    label850:
    label861:
    for (str1 = this.nHg.x + "x" + this.nHg.y;; str1 = "")
    {
      localObject1 = "";
      if ((!this.nHd) && (this.nHs != null))
      {
        j = this.nHs.size();
        y.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(j) });
        localObject2 = this.nHs.iterator();
        i = 0;
        localObject1 = "";
        label362:
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject2).next();
          if (i < this.nHs.size() - 1) {}
          for (localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";; localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob)
          {
            i += 1;
            break label362;
            i = 0;
            break;
          }
        }
      }
      for (i = j;; i = 0)
      {
        localObject2 = h.nFQ;
        n = this.nHe;
        l1 = this.nHc;
        l2 = this.nHf;
        i1 = this.nyR;
        int i2 = this.retryCount;
        int i3;
        int i4;
        String str3;
        String str4;
        int i5;
        if (this.nHd)
        {
          j = 0;
          localObject3 = this.nHh;
          str2 = this.nHj;
          i3 = this.nHk;
          i4 = this.pyramidLv;
          str3 = this.nHl;
          if (bk.bl(this.nHi)) {
            break label845;
          }
          k = this.nHi.length();
          str4 = this.nHo;
          i5 = this.nHp;
          if (!this.nHr) {
            break label850;
          }
        }
        for (m = 1;; m = 0)
        {
          ((h)localObject2).f(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject3, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), QbarNative.getVersion(), Integer.valueOf(this.nHm), Integer.valueOf(this.nHn), Integer.valueOf(i), localObject1, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime) });
          this.nHq = true;
          return;
          j = 1;
          break;
          k = 0;
          break label563;
        }
      }
    }
  }
  
  public final void bxi()
  {
    y.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.nHd = true;
  }
  
  public final void bxj()
  {
    y.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.nHe) });
    this.nHe += 1;
  }
  
  public final void bxk()
  {
    y.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[] { Integer.valueOf(this.retryCount) });
    this.retryCount += 1;
  }
  
  public final void dF(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.nHg = new Point(paramInt1, paramInt2);
  }
  
  public final void fA(long paramLong)
  {
    y.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.nHf = paramLong;
  }
  
  public final void fz(long paramLong)
  {
    y.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.nHc += paramLong;
  }
  
  public final void reset()
  {
    this.nHc = 0L;
    this.nHd = false;
    this.nHe = 0;
    this.nyR = -1;
    this.nHg = null;
    this.retryCount = 0;
    this.nHh = "";
    this.nHi = "";
    this.nHj = "";
    this.nHk = 0;
    this.pyramidLv = 0;
    this.nHl = "";
    this.nHf = 0L;
    this.nHq = false;
    this.nHo = 0;
    this.nHp = 0;
    this.nHr = false;
    this.nHm = 0;
    this.nHn = 0;
    this.nHs = null;
    this.scaleList = "";
    this.decodeScale = 0.0F;
    this.detectTime = 0;
    this.srTime = 0;
    y.i("MicroMsg.QBarEngineReporter", "reset");
  }
  
  public final void wO(int paramInt)
  {
    y.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nyR = paramInt;
  }
  
  public final void wP(int paramInt)
  {
    if (this.nHp != 2) {
      this.nHp = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.m
 * JD-Core Version:    0.7.0.1
 */