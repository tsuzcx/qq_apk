package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int MgX;
  public static int MgY;
  public static int MgZ;
  public static int Mha;
  public static int Mhb;
  public static int Mhc;
  public static c Mhd;
  public static c Mhe;
  private long Mhf;
  public int Mhg;
  private long Mhh;
  private Point Mhi;
  private String Mhj;
  private String Mhk;
  private String Mhl;
  private int Mhm;
  private String Mhn;
  private int Mho;
  private int Mhp;
  private int Mhq;
  public int Mhr;
  public float Mhs;
  public long Mht;
  int Mhu;
  boolean Mhv;
  private List<QbarNative.QBarCodeDetectInfo> Mhw;
  private int Mhx;
  private int Mhy;
  public float decodeScale;
  public int detectTime;
  private int djQ;
  private int dvm;
  private int pyramidLv;
  private int retryCount;
  private boolean sDg;
  public String scaleList;
  public int srTime;
  private Object yBn;
  public long yEl;
  private boolean yEn;
  private int yox;
  
  static
  {
    AppMethodBeat.i(91151);
    MgX = 0;
    MgY = 1;
    MgZ = 2;
    Mha = 1;
    Mhb = 2;
    Mhc = 3;
    Mhd = new c();
    Mhe = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.Mhf = 0L;
    this.yEn = false;
    this.Mhg = 0;
    this.Mhh = 0L;
    this.yox = -1;
    this.Mhi = null;
    this.retryCount = 0;
    this.djQ = 0;
    this.Mhp = 0;
    this.dvm = 0;
    this.yEl = 0L;
    this.Mhr = 0;
    this.Mhs = 1.0F;
    this.Mht = 0L;
    this.Mhu = 0;
    this.sDg = false;
    this.Mhx = 0;
    this.Mhy = 0;
    this.yBn = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void Fs(long paramLong)
  {
    AppMethodBeat.i(91142);
    ae.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.Mhf += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void Ft(long paramLong)
  {
    AppMethodBeat.i(91147);
    ae.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.Mhh = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.Mhj = paramString1;
    this.Mhk = paramString2;
    this.Mhl = paramString3;
    this.djQ = paramInt;
    this.Mho = 0;
    if (paramQBarReportMsg != null)
    {
      this.Mhm = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.Mhn = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.Mhx = 0;
    this.Mhy = 0;
    if (paramList != null)
    {
      paramQBarReportMsg = paramList.iterator();
      while (paramQBarReportMsg.hasNext())
      {
        paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
        if (paramList.inWhiteList) {
          this.Mhx += 1;
        } else if (paramList.inBlackList) {
          this.Mhy += 1;
        }
      }
    }
    ae.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.Mhm), Integer.valueOf(this.pyramidLv), this.Mhn, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.Mhx), Integer.valueOf(this.Mhy) });
    AppMethodBeat.o(91148);
  }
  
  public final void ahi(int paramInt)
  {
    AppMethodBeat.i(91145);
    ae.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.yox = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void ahj(int paramInt)
  {
    if (this.Mhq != 2) {
      this.Mhq = paramInt;
    }
  }
  
  public final void ahk(int paramInt)
  {
    AppMethodBeat.i(176205);
    ae.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.dvm = paramInt;
    AppMethodBeat.o(176205);
  }
  
  public final void byD()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.yBn)
      {
        if (this.sDg)
        {
          ae.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.Mhg;
        long l1 = this.Mhf;
        long l2 = this.Mhh;
        int k = this.yox;
        Object localObject1 = this.Mhi;
        int m = this.retryCount;
        boolean bool = this.yEn;
        str1 = this.Mhj;
        localObject3 = this.Mhk;
        Object localObject5 = this.Mhl;
        int n = this.Mhm;
        int i1 = this.pyramidLv;
        String str2 = this.Mhn;
        if (bu.isNullOrNil(this.Mhk)) {
          break label1059;
        }
        i = this.Mhk.length();
        ae.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.Mhp, Integer.valueOf(this.Mhq), Integer.valueOf(this.dvm), Integer.valueOf(this.Mhr), Long.valueOf(this.Mht), Float.valueOf(this.Mhs), Integer.valueOf(this.Mhu) });
        if (this.Mhi != null)
        {
          str1 = this.Mhi.x + "x" + this.Mhi.y;
          if ((this.yEn) || (this.Mhw == null)) {
            break label1064;
          }
          k = this.Mhw.size();
          ae.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.Mhw.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.Mhw.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = g.yxI;
          n = this.Mhg;
          l1 = this.Mhf;
          l2 = this.Mhh;
          i1 = this.yox;
          int i2 = this.retryCount;
          if (this.yEn)
          {
            j = 0;
            localObject5 = this.Mhj;
            str2 = this.Mhl;
            int i3 = this.Mhm;
            int i4 = this.pyramidLv;
            String str3 = this.Mhn;
            if (!bu.isNullOrNil(this.Mhk))
            {
              k = this.Mhk.length();
              String str4 = this.Mhp;
              int i5 = this.Mhq;
              if (!this.Mhv) {
                continue;
              }
              m = 1;
              ((g)localObject1).f(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.djQ), Integer.valueOf(this.Mho), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.Mhx), Integer.valueOf(this.Mhy), Integer.valueOf(this.dvm), Integer.valueOf(this.djQ), Integer.valueOf(this.Mhr), Long.valueOf(this.Mht), Integer.valueOf((int)(this.Mhs * 100.0F)), Integer.valueOf(this.Mhu) });
              this.sDg = true;
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
  
  public final void fXU()
  {
    AppMethodBeat.i(91143);
    ae.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.yEn = true;
    AppMethodBeat.o(91143);
  }
  
  public final void fXV()
  {
    AppMethodBeat.i(91144);
    ae.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.Mhg) });
    this.Mhg += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    ae.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.Mhi = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.yBn)
    {
      this.Mhf = 0L;
      this.yEn = false;
      this.Mhg = 0;
      this.yox = -1;
      this.Mhi = null;
      this.retryCount = 0;
      this.Mhj = "";
      this.Mhk = "";
      this.Mhl = "";
      this.Mhm = 0;
      this.pyramidLv = 0;
      this.Mhn = "";
      this.Mhh = 0L;
      this.sDg = false;
      this.Mhp = 0;
      this.Mhq = 0;
      this.Mhv = false;
      this.djQ = 0;
      this.Mho = 0;
      this.Mhw = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.Mhx = 0;
      this.Mhy = 0;
      this.dvm = 0;
      this.yEl = 0L;
      this.Mhr = 0;
      this.Mht = 0L;
      this.Mhu = 0;
      ae.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */