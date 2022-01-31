package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static int quu;
  public static int quv;
  public static int quw;
  public static n qux;
  public float decodeScale;
  public int detectTime;
  private int pyramidLv;
  private int qjR;
  public int quA;
  private long quB;
  private Point quC;
  private String quD;
  private String quE;
  private String quF;
  private int quG;
  private String quH;
  private int quI;
  private int quJ;
  public int quK;
  private int quL;
  private boolean quM;
  public boolean quN;
  public List<QbarNative.QBarCodeDetectInfo> quO;
  private int quP;
  private int quQ;
  private Object quR;
  private long quy;
  public boolean quz;
  private int retryCount;
  public String scaleList;
  public int srTime;
  
  static
  {
    AppMethodBeat.i(80872);
    quu = 0;
    quv = 1;
    quw = 2;
    qux = new n();
    AppMethodBeat.o(80872);
  }
  
  public n()
  {
    AppMethodBeat.i(80861);
    this.quy = 0L;
    this.quz = false;
    this.quA = 0;
    this.quB = 0L;
    this.qjR = -1;
    this.quC = null;
    this.retryCount = 0;
    this.quI = 0;
    this.quK = 0;
    this.quM = false;
    this.quP = 0;
    this.quQ = 0;
    this.quR = new Object();
    AppMethodBeat.o(80861);
  }
  
  public final void CE(int paramInt)
  {
    AppMethodBeat.i(80865);
    ab.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.qjR = paramInt;
    AppMethodBeat.o(80865);
  }
  
  public final void CF(int paramInt)
  {
    if (this.quL != 2) {
      this.quL = paramInt;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, QbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<QbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(80869);
    this.quD = paramString1;
    this.quE = paramString2;
    this.quF = paramString3;
    this.quI = paramInt;
    this.quJ = 0;
    if (paramQBarReportMsg != null)
    {
      this.quG = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.quH = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.quP = 0;
    this.quQ = 0;
    paramQBarReportMsg = paramList.iterator();
    while (paramQBarReportMsg.hasNext())
    {
      paramList = (QbarNative.QBarReportMsg)paramQBarReportMsg.next();
      if (paramList.inWhiteList) {
        this.quP += 1;
      } else if (paramList.inBlackList) {
        this.quQ += 1;
      }
    }
    ab.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.quG), Integer.valueOf(this.pyramidLv), this.quH, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.quP), Integer.valueOf(this.quQ) });
    AppMethodBeat.o(80869);
  }
  
  public final void bJP()
  {
    AppMethodBeat.i(80870);
    for (;;)
    {
      int j;
      synchronized (this.quR)
      {
        if (this.quM)
        {
          ab.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(80870);
          return;
        }
        j = this.quA;
        long l1 = this.quy;
        long l2 = this.quB;
        int k = this.qjR;
        Object localObject1 = this.quC;
        int m = this.retryCount;
        boolean bool = this.quz;
        str1 = this.quD;
        localObject3 = this.quE;
        Object localObject5 = this.quF;
        int n = this.quG;
        int i1 = this.pyramidLv;
        String str2 = this.quH;
        if (bo.isNullOrNil(this.quE)) {
          break label928;
        }
        i = this.quE.length();
        ab.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.quK, Integer.valueOf(this.quL) });
        if (this.quC != null)
        {
          str1 = this.quC.x + "x" + this.quC.y;
          if ((this.quz) || (this.quO == null)) {
            break label933;
          }
          k = this.quO.size();
          ab.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.quO.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.quO.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label921;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label921;
          }
          localObject1 = h.qsU;
          n = this.quA;
          l1 = this.quy;
          l2 = this.quB;
          i1 = this.qjR;
          int i2 = this.retryCount;
          if (this.quz)
          {
            j = 0;
            localObject5 = this.quD;
            str2 = this.quF;
            int i3 = this.quG;
            int i4 = this.pyramidLv;
            String str3 = this.quH;
            if (!bo.isNullOrNil(this.quE))
            {
              k = this.quE.length();
              String str4 = this.quK;
              int i5 = this.quL;
              if (!this.quN) {
                continue;
              }
              m = 1;
              ((h)localObject1).e(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), QbarNative.getVersion(), Integer.valueOf(this.quI), Integer.valueOf(this.quJ), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.quP), Integer.valueOf(this.quQ) });
              this.quM = true;
              AppMethodBeat.o(80870);
            }
          }
          else
          {
            j = 1;
            continue;
          }
          k = 0;
          continue;
          m = 0;
        }
      }
      String str1 = "";
      continue;
      label921:
      j += 1;
      continue;
      label928:
      int i = 0;
      continue;
      label933:
      Object localObject3 = "";
      i = 0;
    }
  }
  
  public final void cig()
  {
    AppMethodBeat.i(80863);
    ab.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.quz = true;
    AppMethodBeat.o(80863);
  }
  
  public final void cih()
  {
    AppMethodBeat.i(80864);
    ab.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.quA) });
    this.quA += 1;
    AppMethodBeat.o(80864);
  }
  
  public final void cii()
  {
    AppMethodBeat.i(80867);
    ab.i("MicroMsg.QBarEngineReporter", "addRetryTime, current retry count: %s", new Object[] { Integer.valueOf(this.retryCount) });
    this.retryCount += 1;
    AppMethodBeat.o(80867);
  }
  
  public final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80866);
    ab.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.quC = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(80866);
  }
  
  public final void lc(long paramLong)
  {
    AppMethodBeat.i(80862);
    ab.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.quy += paramLong;
    AppMethodBeat.o(80862);
  }
  
  public final void ld(long paramLong)
  {
    AppMethodBeat.i(80868);
    ab.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.quB = paramLong;
    AppMethodBeat.o(80868);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(80871);
    synchronized (this.quR)
    {
      this.quy = 0L;
      this.quz = false;
      this.quA = 0;
      this.qjR = -1;
      this.quC = null;
      this.retryCount = 0;
      this.quD = "";
      this.quE = "";
      this.quF = "";
      this.quG = 0;
      this.pyramidLv = 0;
      this.quH = "";
      this.quB = 0L;
      this.quM = false;
      this.quK = 0;
      this.quL = 0;
      this.quN = false;
      this.quI = 0;
      this.quJ = 0;
      this.quO = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.quP = 0;
      this.quQ = 0;
      ab.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(80871);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.n
 * JD-Core Version:    0.7.0.1
 */