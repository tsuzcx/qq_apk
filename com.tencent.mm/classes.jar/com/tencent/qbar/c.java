package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int ahqA;
  public static int ahqB;
  public static int ahqC;
  public static int ahqD;
  public static int ahqE;
  public static int ahqF;
  public static int ahqG;
  public static c ahqH;
  public static c ahqI;
  private Object GXz;
  public long OTD;
  private boolean OTG;
  private String OTx;
  private String OTy;
  private int OjS;
  private long ahqJ;
  public int ahqK;
  private long ahqL;
  private Point ahqM;
  private String ahqN;
  private String ahqO;
  private String ahqP;
  private int ahqQ;
  private String ahqR;
  private int ahqS;
  private int ahqT;
  private int ahqU;
  public int ahqV;
  public float ahqW;
  public long ahqX;
  int ahqY;
  boolean ahqZ;
  private List<QbarNative.QBarCodeDetectInfo> ahra;
  private int ahrb;
  private int ahrc;
  public float decodeScale;
  public int detectTime;
  private int hJx;
  private int hyf;
  private boolean lAr;
  private int pyramidLv;
  private int retryCount;
  public String scaleList;
  public int srTime;
  
  static
  {
    AppMethodBeat.i(91151);
    ahqA = 0;
    ahqB = 1;
    ahqC = 2;
    ahqD = 1;
    ahqE = 2;
    ahqF = 3;
    ahqG = 4;
    ahqH = new c();
    ahqI = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.ahqJ = 0L;
    this.OTG = false;
    this.ahqK = 0;
    this.ahqL = 0L;
    this.OjS = -1;
    this.ahqM = null;
    this.retryCount = 0;
    this.hyf = 0;
    this.ahqT = 0;
    this.hJx = 0;
    this.OTD = 0L;
    this.ahqV = 0;
    this.ahqW = 1.0F;
    this.ahqX = 0L;
    this.ahqY = 0;
    this.lAr = false;
    this.ahrb = 0;
    this.ahrc = 0;
    this.OTx = "";
    this.OTy = "";
    this.GXz = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void AW(long paramLong)
  {
    AppMethodBeat.i(91142);
    Log.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.ahqJ += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void AX(long paramLong)
  {
    AppMethodBeat.i(91147);
    Log.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.ahqL = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(h.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.OTx = paramd.OTx;
    this.OTy = paramd.OTy;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.ahqN = paramString1;
    this.ahqO = paramString2;
    this.ahqP = paramString3;
    this.hyf = paramInt;
    this.ahqS = 0;
    if (paramQBarReportMsg != null)
    {
      this.ahqQ = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.ahqR = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.ahrb = 0;
    this.ahrc = 0;
    if (paramList != null)
    {
      paramQBarReportMsg = paramList.iterator();
      while (paramQBarReportMsg.hasNext())
      {
        paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
        if (paramList.inWhiteList) {
          this.ahrb += 1;
        } else if (paramList.inBlackList) {
          this.ahrc += 1;
        }
      }
    }
    Log.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.ahqQ), Integer.valueOf(this.pyramidLv), this.ahqR, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.ahrb), Integer.valueOf(this.ahrc) });
    AppMethodBeat.o(91148);
  }
  
  public final void aGV(int paramInt)
  {
    AppMethodBeat.i(91145);
    Log.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.OjS = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void aGW(int paramInt)
  {
    if (this.ahqU != 2) {
      this.ahqU = paramInt;
    }
  }
  
  public final void cIX()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.GXz)
      {
        if (this.lAr)
        {
          Log.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        int n = e.gTX();
        j = this.ahqK;
        long l1 = this.ahqJ;
        long l2 = this.ahqL;
        int k = this.OjS;
        Object localObject1 = this.ahqM;
        int m = this.retryCount;
        boolean bool = this.OTG;
        str1 = this.ahqN;
        localObject3 = this.ahqO;
        Object localObject5 = this.ahqP;
        int i1 = this.ahqQ;
        int i2 = this.pyramidLv;
        String str2 = this.ahqR;
        if (Util.isNullOrNil(this.ahqO)) {
          break label1112;
        }
        i = this.ahqO.length();
        Log.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s, qbarBackend:%d, tabSession:%s, scanSession:%s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(i1), Integer.valueOf(i2), str2, Integer.valueOf(i), this.ahqT, Integer.valueOf(this.ahqU), Integer.valueOf(this.hJx), Integer.valueOf(this.ahqV), Long.valueOf(this.ahqX), Float.valueOf(this.ahqW), Integer.valueOf(this.ahqY), Integer.valueOf(n), this.OTx, this.OTy });
        if (this.ahqM != null)
        {
          str1 = this.ahqM.x + "x" + this.ahqM.y;
          if ((this.OTG) || (this.ahra == null)) {
            break label1117;
          }
          k = this.ahra.size();
          Log.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.ahra.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.ahra.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1105;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1105;
          }
          localObject1 = h.OAn;
          i1 = this.ahqK;
          l1 = this.ahqJ;
          l2 = this.ahqL;
          i2 = this.OjS;
          int i3 = this.retryCount;
          if (this.OTG)
          {
            j = 0;
            localObject5 = this.ahqN;
            str2 = this.ahqP;
            int i4 = this.ahqQ;
            int i5 = this.pyramidLv;
            String str3 = this.ahqR;
            if (!Util.isNullOrNil(this.ahqO))
            {
              k = this.ahqO.length();
              String str4 = this.ahqT;
              int i6 = this.ahqU;
              if (!this.ahqZ) {
                continue;
              }
              m = 1;
              ((h)localObject1).b(13233, new Object[] { Integer.valueOf(i1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i2), str1, Integer.valueOf(i3), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i4), Integer.valueOf(i5), str3, Integer.valueOf(k), str4, Integer.valueOf(i6), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.hyf), Integer.valueOf(this.ahqS), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.ahrb), Integer.valueOf(this.ahrc), Integer.valueOf(this.hJx), Integer.valueOf(this.hyf), Integer.valueOf(this.ahqV), Long.valueOf(this.ahqX), Integer.valueOf((int)(this.ahqW * 100.0F)), Integer.valueOf(this.ahqY), Integer.valueOf(n), this.OTx, this.OTy });
              this.lAr = true;
              AppMethodBeat.o(91149);
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
      label1105:
      j += 1;
      continue;
      label1112:
      int i = 0;
      continue;
      label1117:
      Object localObject3 = "";
      i = 0;
    }
  }
  
  public final void jWK()
  {
    AppMethodBeat.i(91143);
    Log.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.OTG = true;
    AppMethodBeat.o(91143);
  }
  
  public final void jWL()
  {
    AppMethodBeat.i(91144);
    Log.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.ahqK) });
    this.ahqK += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void pF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    Log.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ahqM = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.GXz)
    {
      this.ahqJ = 0L;
      this.OTG = false;
      this.ahqK = 0;
      this.OjS = -1;
      this.ahqM = null;
      this.retryCount = 0;
      this.ahqN = "";
      this.ahqO = "";
      this.ahqP = "";
      this.ahqQ = 0;
      this.pyramidLv = 0;
      this.ahqR = "";
      this.ahqL = 0L;
      this.lAr = false;
      this.ahqT = 0;
      this.ahqU = 0;
      this.ahqZ = false;
      this.hyf = 0;
      this.ahqS = 0;
      this.ahra = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.ahrb = 0;
      this.ahrc = 0;
      this.hJx = 0;
      this.OTD = 0L;
      this.ahqV = 0;
      this.ahqX = 0L;
      this.ahqY = 0;
      this.OTx = "";
      this.OTy = "";
      Log.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
  
  public final void setTabType(int paramInt)
  {
    AppMethodBeat.i(176205);
    Log.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.hJx = paramInt;
    AppMethodBeat.o(176205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */