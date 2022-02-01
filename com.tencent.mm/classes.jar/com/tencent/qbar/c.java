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
  public static int Zmg;
  public static int Zmh;
  public static int Zmi;
  public static int Zmj;
  public static int Zmk;
  public static int Zml;
  public static c Zmm;
  public static c Zmn;
  private boolean Aaj;
  private Object Brg;
  public long IMq;
  private boolean IMt;
  private int ImC;
  public int ZmA;
  public float ZmB;
  public long ZmC;
  int ZmD;
  boolean ZmE;
  private List<QbarNative.QBarCodeDetectInfo> ZmF;
  private int ZmG;
  private int ZmH;
  private long Zmo;
  public int Zmp;
  private long Zmq;
  private Point Zmr;
  private String Zms;
  private String Zmt;
  private String Zmu;
  private int Zmv;
  private String Zmw;
  private int Zmx;
  private int Zmy;
  private int Zmz;
  public float decodeScale;
  public int detectTime;
  private int fEH;
  private int ftP;
  private int pyramidLv;
  private int retryCount;
  public String scaleList;
  public int srTime;
  
  static
  {
    AppMethodBeat.i(91151);
    Zmg = 0;
    Zmh = 1;
    Zmi = 2;
    Zmj = 1;
    Zmk = 2;
    Zml = 3;
    Zmm = new c();
    Zmn = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.Zmo = 0L;
    this.IMt = false;
    this.Zmp = 0;
    this.Zmq = 0L;
    this.ImC = -1;
    this.Zmr = null;
    this.retryCount = 0;
    this.ftP = 0;
    this.Zmy = 0;
    this.fEH = 0;
    this.IMq = 0L;
    this.ZmA = 0;
    this.ZmB = 1.0F;
    this.ZmC = 0L;
    this.ZmD = 0;
    this.Aaj = false;
    this.ZmG = 0;
    this.ZmH = 0;
    this.Brg = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void WL(long paramLong)
  {
    AppMethodBeat.i(91142);
    Log.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.Zmo += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void WM(long paramLong)
  {
    AppMethodBeat.i(91147);
    Log.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.Zmq = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.Zms = paramString1;
    this.Zmt = paramString2;
    this.Zmu = paramString3;
    this.ftP = paramInt;
    this.Zmx = 0;
    if (paramQBarReportMsg != null)
    {
      this.Zmv = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.Zmw = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.ZmG = 0;
    this.ZmH = 0;
    if (paramList != null)
    {
      paramQBarReportMsg = paramList.iterator();
      while (paramQBarReportMsg.hasNext())
      {
        paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
        if (paramList.inWhiteList) {
          this.ZmG += 1;
        } else if (paramList.inBlackList) {
          this.ZmH += 1;
        }
      }
    }
    Log.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.Zmv), Integer.valueOf(this.pyramidLv), this.Zmw, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.ZmG), Integer.valueOf(this.ZmH) });
    AppMethodBeat.o(91148);
  }
  
  public final void aAj(int paramInt)
  {
    AppMethodBeat.i(91145);
    Log.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.ImC = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void aAk(int paramInt)
  {
    if (this.Zmz != 2) {
      this.Zmz = paramInt;
    }
  }
  
  public final void cig()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.Brg)
      {
        if (this.Aaj)
        {
          Log.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.Zmp;
        long l1 = this.Zmo;
        long l2 = this.Zmq;
        int k = this.ImC;
        Object localObject1 = this.Zmr;
        int m = this.retryCount;
        boolean bool = this.IMt;
        str1 = this.Zms;
        localObject3 = this.Zmt;
        Object localObject5 = this.Zmu;
        int n = this.Zmv;
        int i1 = this.pyramidLv;
        String str2 = this.Zmw;
        if (Util.isNullOrNil(this.Zmt)) {
          break label1059;
        }
        i = this.Zmt.length();
        Log.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.Zmy, Integer.valueOf(this.Zmz), Integer.valueOf(this.fEH), Integer.valueOf(this.ZmA), Long.valueOf(this.ZmC), Float.valueOf(this.ZmB), Integer.valueOf(this.ZmD) });
        if (this.Zmr != null)
        {
          str1 = this.Zmr.x + "x" + this.Zmr.y;
          if ((this.IMt) || (this.ZmF == null)) {
            break label1064;
          }
          k = this.ZmF.size();
          Log.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.ZmF.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.ZmF.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = h.IzE;
          n = this.Zmp;
          l1 = this.Zmo;
          l2 = this.Zmq;
          i1 = this.ImC;
          int i2 = this.retryCount;
          if (this.IMt)
          {
            j = 0;
            localObject5 = this.Zms;
            str2 = this.Zmu;
            int i3 = this.Zmv;
            int i4 = this.pyramidLv;
            String str3 = this.Zmw;
            if (!Util.isNullOrNil(this.Zmt))
            {
              k = this.Zmt.length();
              String str4 = this.Zmy;
              int i5 = this.Zmz;
              if (!this.ZmE) {
                continue;
              }
              m = 1;
              ((h)localObject1).a(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.ftP), Integer.valueOf(this.Zmx), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.ZmG), Integer.valueOf(this.ZmH), Integer.valueOf(this.fEH), Integer.valueOf(this.ftP), Integer.valueOf(this.ZmA), Long.valueOf(this.ZmC), Integer.valueOf((int)(this.ZmB * 100.0F)), Integer.valueOf(this.ZmD) });
              this.Aaj = true;
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
  
  public final void inC()
  {
    AppMethodBeat.i(91143);
    Log.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.IMt = true;
    AppMethodBeat.o(91143);
  }
  
  public final void inD()
  {
    AppMethodBeat.i(91144);
    Log.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.Zmp) });
    this.Zmp += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void nI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    Log.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Zmr = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.Brg)
    {
      this.Zmo = 0L;
      this.IMt = false;
      this.Zmp = 0;
      this.ImC = -1;
      this.Zmr = null;
      this.retryCount = 0;
      this.Zms = "";
      this.Zmt = "";
      this.Zmu = "";
      this.Zmv = 0;
      this.pyramidLv = 0;
      this.Zmw = "";
      this.Zmq = 0L;
      this.Aaj = false;
      this.Zmy = 0;
      this.Zmz = 0;
      this.ZmE = false;
      this.ftP = 0;
      this.Zmx = 0;
      this.ZmF = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.ZmG = 0;
      this.ZmH = 0;
      this.fEH = 0;
      this.IMq = 0L;
      this.ZmA = 0;
      this.ZmC = 0L;
      this.ZmD = 0;
      Log.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
  
  public final void setTabType(int paramInt)
  {
    AppMethodBeat.i(176205);
    Log.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.fEH = paramInt;
    AppMethodBeat.o(176205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */