package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int RJA;
  public static int RJB;
  public static int RJC;
  public static int RJD;
  public static c RJE;
  public static c RJF;
  public static int RJy;
  public static int RJz;
  private Object CCt;
  public long CHf;
  private boolean CHh;
  private int Cpn;
  private long RJG;
  public int RJH;
  private long RJI;
  private Point RJJ;
  private String RJK;
  private String RJL;
  private String RJM;
  private int RJN;
  private String RJO;
  private int RJP;
  private int RJQ;
  private int RJR;
  public int RJS;
  public float RJT;
  public long RJU;
  int RJV;
  boolean RJW;
  private List<QbarNative.QBarCodeDetectInfo> RJX;
  private int RJY;
  private int RJZ;
  private int dBa;
  private int dLS;
  public float decodeScale;
  public int detectTime;
  private int pyramidLv;
  private int retryCount;
  public String scaleList;
  public int srTime;
  private boolean vtY;
  
  static
  {
    AppMethodBeat.i(91151);
    RJy = 0;
    RJz = 1;
    RJA = 2;
    RJB = 1;
    RJC = 2;
    RJD = 3;
    RJE = new c();
    RJF = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.RJG = 0L;
    this.CHh = false;
    this.RJH = 0;
    this.RJI = 0L;
    this.Cpn = -1;
    this.RJJ = null;
    this.retryCount = 0;
    this.dBa = 0;
    this.RJQ = 0;
    this.dLS = 0;
    this.CHf = 0L;
    this.RJS = 0;
    this.RJT = 1.0F;
    this.RJU = 0L;
    this.RJV = 0;
    this.vtY = false;
    this.RJY = 0;
    this.RJZ = 0;
    this.CCt = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void Ov(long paramLong)
  {
    AppMethodBeat.i(91142);
    Log.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.RJG += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void Ow(long paramLong)
  {
    AppMethodBeat.i(91147);
    Log.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.RJI = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.RJK = paramString1;
    this.RJL = paramString2;
    this.RJM = paramString3;
    this.dBa = paramInt;
    this.RJP = 0;
    if (paramQBarReportMsg != null)
    {
      this.RJN = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.RJO = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.RJY = 0;
    this.RJZ = 0;
    if (paramList != null)
    {
      paramQBarReportMsg = paramList.iterator();
      while (paramQBarReportMsg.hasNext())
      {
        paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
        if (paramList.inWhiteList) {
          this.RJY += 1;
        } else if (paramList.inBlackList) {
          this.RJZ += 1;
        }
      }
    }
    Log.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.RJN), Integer.valueOf(this.pyramidLv), this.RJO, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.RJY), Integer.valueOf(this.RJZ) });
    AppMethodBeat.o(91148);
  }
  
  public final void aqw(int paramInt)
  {
    AppMethodBeat.i(91145);
    Log.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Cpn = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void aqx(int paramInt)
  {
    if (this.RJR != 2) {
      this.RJR = paramInt;
    }
  }
  
  public final void bUV()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.CCt)
      {
        if (this.vtY)
        {
          Log.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.RJH;
        long l1 = this.RJG;
        long l2 = this.RJI;
        int k = this.Cpn;
        Object localObject1 = this.RJJ;
        int m = this.retryCount;
        boolean bool = this.CHh;
        str1 = this.RJK;
        localObject3 = this.RJL;
        Object localObject5 = this.RJM;
        int n = this.RJN;
        int i1 = this.pyramidLv;
        String str2 = this.RJO;
        if (Util.isNullOrNil(this.RJL)) {
          break label1059;
        }
        i = this.RJL.length();
        Log.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.RJQ, Integer.valueOf(this.RJR), Integer.valueOf(this.dLS), Integer.valueOf(this.RJS), Long.valueOf(this.RJU), Float.valueOf(this.RJT), Integer.valueOf(this.RJV) });
        if (this.RJJ != null)
        {
          str1 = this.RJJ.x + "x" + this.RJJ.y;
          if ((this.CHh) || (this.RJX == null)) {
            break label1064;
          }
          k = this.RJX.size();
          Log.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.RJX.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.RJX.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = h.CyF;
          n = this.RJH;
          l1 = this.RJG;
          l2 = this.RJI;
          i1 = this.Cpn;
          int i2 = this.retryCount;
          if (this.CHh)
          {
            j = 0;
            localObject5 = this.RJK;
            str2 = this.RJM;
            int i3 = this.RJN;
            int i4 = this.pyramidLv;
            String str3 = this.RJO;
            if (!Util.isNullOrNil(this.RJL))
            {
              k = this.RJL.length();
              String str4 = this.RJQ;
              int i5 = this.RJR;
              if (!this.RJW) {
                continue;
              }
              m = 1;
              ((h)localObject1).a(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.dBa), Integer.valueOf(this.RJP), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.RJY), Integer.valueOf(this.RJZ), Integer.valueOf(this.dLS), Integer.valueOf(this.dBa), Integer.valueOf(this.RJS), Long.valueOf(this.RJU), Integer.valueOf((int)(this.RJT * 100.0F)), Integer.valueOf(this.RJV) });
              this.vtY = true;
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
      label1052:
      j += 1;
      continue;
      label1059:
      int i = 0;
      continue;
      label1064:
      Object localObject3 = "";
      i = 0;
    }
  }
  
  public final void hkg()
  {
    AppMethodBeat.i(91143);
    Log.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.CHh = true;
    AppMethodBeat.o(91143);
  }
  
  public final void hkh()
  {
    AppMethodBeat.i(91144);
    Log.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.RJH) });
    this.RJH += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void mr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    Log.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.RJJ = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.CCt)
    {
      this.RJG = 0L;
      this.CHh = false;
      this.RJH = 0;
      this.Cpn = -1;
      this.RJJ = null;
      this.retryCount = 0;
      this.RJK = "";
      this.RJL = "";
      this.RJM = "";
      this.RJN = 0;
      this.pyramidLv = 0;
      this.RJO = "";
      this.RJI = 0L;
      this.vtY = false;
      this.RJQ = 0;
      this.RJR = 0;
      this.RJW = false;
      this.dBa = 0;
      this.RJP = 0;
      this.RJX = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.RJY = 0;
      this.RJZ = 0;
      this.dLS = 0;
      this.CHf = 0L;
      this.RJS = 0;
      this.RJU = 0L;
      this.RJV = 0;
      Log.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
  
  public final void setTabType(int paramInt)
  {
    AppMethodBeat.i(176205);
    Log.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.dLS = paramInt;
    AppMethodBeat.o(176205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */