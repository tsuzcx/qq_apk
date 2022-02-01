package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int LJY;
  public static int LJZ;
  public static int LKa;
  public static int LKb;
  public static int LKc;
  public static int LKd;
  public static c LKe;
  public static c LKf;
  private long LKg;
  public int LKh;
  private long LKi;
  private Point LKj;
  private String LKk;
  private String LKl;
  private String LKm;
  private int LKn;
  private String LKo;
  private int LKp;
  private int LKq;
  private int LKr;
  public int LKs;
  public float LKt;
  public long LKu;
  int LKv;
  boolean LKw;
  private List<QbarNative.QBarCodeDetectInfo> LKx;
  private int LKy;
  private int LKz;
  public float decodeScale;
  public int detectTime;
  private int diO;
  private int duh;
  private int pyramidLv;
  private int retryCount;
  public String scaleList;
  public int srTime;
  private boolean ssW;
  private int xYF;
  private Object ylo;
  public long yom;
  private boolean yoo;
  
  static
  {
    AppMethodBeat.i(91151);
    LJY = 0;
    LJZ = 1;
    LKa = 2;
    LKb = 1;
    LKc = 2;
    LKd = 3;
    LKe = new c();
    LKf = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.LKg = 0L;
    this.yoo = false;
    this.LKh = 0;
    this.LKi = 0L;
    this.xYF = -1;
    this.LKj = null;
    this.retryCount = 0;
    this.diO = 0;
    this.LKq = 0;
    this.duh = 0;
    this.yom = 0L;
    this.LKs = 0;
    this.LKt = 1.0F;
    this.LKu = 0L;
    this.LKv = 0;
    this.ssW = false;
    this.LKy = 0;
    this.LKz = 0;
    this.ylo = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void EQ(long paramLong)
  {
    AppMethodBeat.i(91142);
    ad.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.LKg += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void ER(long paramLong)
  {
    AppMethodBeat.i(91147);
    ad.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.LKi = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.LKk = paramString1;
    this.LKl = paramString2;
    this.LKm = paramString3;
    this.diO = paramInt;
    this.LKp = 0;
    if (paramQBarReportMsg != null)
    {
      this.LKn = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.LKo = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.LKy = 0;
    this.LKz = 0;
    if (paramList != null)
    {
      paramQBarReportMsg = paramList.iterator();
      while (paramQBarReportMsg.hasNext())
      {
        paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
        if (paramList.inWhiteList) {
          this.LKy += 1;
        } else if (paramList.inBlackList) {
          this.LKz += 1;
        }
      }
    }
    ad.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.LKn), Integer.valueOf(this.pyramidLv), this.LKo, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.LKy), Integer.valueOf(this.LKz) });
    AppMethodBeat.o(91148);
  }
  
  public final void agA(int paramInt)
  {
    if (this.LKr != 2) {
      this.LKr = paramInt;
    }
  }
  
  public final void agB(int paramInt)
  {
    AppMethodBeat.i(176205);
    ad.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.duh = paramInt;
    AppMethodBeat.o(176205);
  }
  
  public final void agz(int paramInt)
  {
    AppMethodBeat.i(91145);
    ad.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.xYF = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void bxK()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.ylo)
      {
        if (this.ssW)
        {
          ad.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.LKh;
        long l1 = this.LKg;
        long l2 = this.LKi;
        int k = this.xYF;
        Object localObject1 = this.LKj;
        int m = this.retryCount;
        boolean bool = this.yoo;
        str1 = this.LKk;
        localObject3 = this.LKl;
        Object localObject5 = this.LKm;
        int n = this.LKn;
        int i1 = this.pyramidLv;
        String str2 = this.LKo;
        if (bt.isNullOrNil(this.LKl)) {
          break label1059;
        }
        i = this.LKl.length();
        ad.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.LKq, Integer.valueOf(this.LKr), Integer.valueOf(this.duh), Integer.valueOf(this.LKs), Long.valueOf(this.LKu), Float.valueOf(this.LKt), Integer.valueOf(this.LKv) });
        if (this.LKj != null)
        {
          str1 = this.LKj.x + "x" + this.LKj.y;
          if ((this.yoo) || (this.LKx == null)) {
            break label1064;
          }
          k = this.LKx.size();
          ad.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.LKx.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.LKx.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = g.yhR;
          n = this.LKh;
          l1 = this.LKg;
          l2 = this.LKi;
          i1 = this.xYF;
          int i2 = this.retryCount;
          if (this.yoo)
          {
            j = 0;
            localObject5 = this.LKk;
            str2 = this.LKm;
            int i3 = this.LKn;
            int i4 = this.pyramidLv;
            String str3 = this.LKo;
            if (!bt.isNullOrNil(this.LKl))
            {
              k = this.LKl.length();
              String str4 = this.LKq;
              int i5 = this.LKr;
              if (!this.LKw) {
                continue;
              }
              m = 1;
              ((g)localObject1).f(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.diO), Integer.valueOf(this.LKp), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.LKy), Integer.valueOf(this.LKz), Integer.valueOf(this.duh), Integer.valueOf(this.diO), Integer.valueOf(this.LKs), Long.valueOf(this.LKu), Integer.valueOf((int)(this.LKt * 100.0F)), Integer.valueOf(this.LKv) });
              this.ssW = true;
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
  
  public final void fTu()
  {
    AppMethodBeat.i(91143);
    ad.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.yoo = true;
    AppMethodBeat.o(91143);
  }
  
  public final void fTv()
  {
    AppMethodBeat.i(91144);
    ad.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.LKh) });
    this.LKh += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void kL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    ad.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.LKj = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.ylo)
    {
      this.LKg = 0L;
      this.yoo = false;
      this.LKh = 0;
      this.xYF = -1;
      this.LKj = null;
      this.retryCount = 0;
      this.LKk = "";
      this.LKl = "";
      this.LKm = "";
      this.LKn = 0;
      this.pyramidLv = 0;
      this.LKo = "";
      this.LKi = 0L;
      this.ssW = false;
      this.LKq = 0;
      this.LKr = 0;
      this.LKw = false;
      this.diO = 0;
      this.LKp = 0;
      this.LKx = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.LKy = 0;
      this.LKz = 0;
      this.duh = 0;
      this.yom = 0L;
      this.LKs = 0;
      this.LKu = 0L;
      this.LKv = 0;
      ad.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */