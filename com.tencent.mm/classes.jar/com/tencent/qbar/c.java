package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int IoA;
  public static int IoB;
  public static int IoC;
  public static int IoD;
  public static int IoE;
  public static int IoF;
  public static c IoG;
  public static c IoH;
  private long IoI;
  public int IoJ;
  private long IoK;
  private Point IoL;
  private String IoM;
  private String IoN;
  private String IoO;
  private int IoP;
  private String IoQ;
  private int IoR;
  private int IoS;
  private int IoT;
  private int IoU;
  public int IoV;
  public float IoW;
  public long IoX;
  int IoY;
  boolean IoZ;
  private List<QbarNative.QBarCodeDetectInfo> Ipa;
  private int Ipb;
  private int Ipc;
  private int daa;
  public float decodeScale;
  public int detectTime;
  private int pyramidLv;
  private boolean qHI;
  private int retryCount;
  public String scaleList;
  public int srTime;
  private int vAT;
  private Object vNi;
  public long vPG;
  private boolean vPI;
  
  static
  {
    AppMethodBeat.i(91151);
    IoA = 0;
    IoB = 1;
    IoC = 2;
    IoD = 1;
    IoE = 2;
    IoF = 3;
    IoG = new c();
    IoH = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.IoI = 0L;
    this.vPI = false;
    this.IoJ = 0;
    this.IoK = 0L;
    this.vAT = -1;
    this.IoL = null;
    this.retryCount = 0;
    this.daa = 0;
    this.IoS = 0;
    this.IoU = 0;
    this.vPG = 0L;
    this.IoV = 0;
    this.IoW = 1.0F;
    this.IoX = 0L;
    this.IoY = 0;
    this.qHI = false;
    this.Ipb = 0;
    this.Ipc = 0;
    this.vNi = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.IoM = paramString1;
    this.IoN = paramString2;
    this.IoO = paramString3;
    this.daa = paramInt;
    this.IoR = 0;
    if (paramQBarReportMsg != null)
    {
      this.IoP = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.IoQ = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.Ipb = 0;
    this.Ipc = 0;
    paramQBarReportMsg = paramList.iterator();
    while (paramQBarReportMsg.hasNext())
    {
      paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
      if (paramList.inWhiteList) {
        this.Ipb += 1;
      } else if (paramList.inBlackList) {
        this.Ipc += 1;
      }
    }
    ad.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.IoP), Integer.valueOf(this.pyramidLv), this.IoQ, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.Ipb), Integer.valueOf(this.Ipc) });
    AppMethodBeat.o(91148);
  }
  
  public final void abG(int paramInt)
  {
    AppMethodBeat.i(91145);
    ad.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.vAT = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void abH(int paramInt)
  {
    if (this.IoT != 2) {
      this.IoT = paramInt;
    }
  }
  
  public final void abI(int paramInt)
  {
    AppMethodBeat.i(176205);
    ad.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.IoU = paramInt;
    AppMethodBeat.o(176205);
  }
  
  public final void bmJ()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.vNi)
      {
        if (this.qHI)
        {
          ad.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.IoJ;
        long l1 = this.IoI;
        long l2 = this.IoK;
        int k = this.vAT;
        Object localObject1 = this.IoL;
        int m = this.retryCount;
        boolean bool = this.vPI;
        str1 = this.IoM;
        localObject3 = this.IoN;
        Object localObject5 = this.IoO;
        int n = this.IoP;
        int i1 = this.pyramidLv;
        String str2 = this.IoQ;
        if (bt.isNullOrNil(this.IoN)) {
          break label1059;
        }
        i = this.IoN.length();
        ad.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.IoS, Integer.valueOf(this.IoT), Integer.valueOf(this.IoU), Integer.valueOf(this.IoV), Long.valueOf(this.IoX), Float.valueOf(this.IoW), Integer.valueOf(this.IoY) });
        if (this.IoL != null)
        {
          str1 = this.IoL.x + "x" + this.IoL.y;
          if ((this.vPI) || (this.Ipa == null)) {
            break label1064;
          }
          k = this.Ipa.size();
          ad.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.Ipa.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.Ipa.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = h.vKh;
          n = this.IoJ;
          l1 = this.IoI;
          l2 = this.IoK;
          i1 = this.vAT;
          int i2 = this.retryCount;
          if (this.vPI)
          {
            j = 0;
            localObject5 = this.IoM;
            str2 = this.IoO;
            int i3 = this.IoP;
            int i4 = this.pyramidLv;
            String str3 = this.IoQ;
            if (!bt.isNullOrNil(this.IoN))
            {
              k = this.IoN.length();
              String str4 = this.IoS;
              int i5 = this.IoT;
              if (!this.IoZ) {
                continue;
              }
              m = 1;
              ((h)localObject1).f(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.daa), Integer.valueOf(this.IoR), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.Ipb), Integer.valueOf(this.Ipc), Integer.valueOf(this.IoU), Integer.valueOf(this.daa), Integer.valueOf(this.IoV), Long.valueOf(this.IoX), Integer.valueOf((int)(this.IoW * 100.0F)), Integer.valueOf(this.IoY) });
              this.qHI = true;
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
  
  public final void flO()
  {
    AppMethodBeat.i(91143);
    ad.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.vPI = true;
    AppMethodBeat.o(91143);
  }
  
  public final void flP()
  {
    AppMethodBeat.i(91144);
    ad.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.IoJ) });
    this.IoJ += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void kj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    ad.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.IoL = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.vNi)
    {
      this.IoI = 0L;
      this.vPI = false;
      this.IoJ = 0;
      this.vAT = -1;
      this.IoL = null;
      this.retryCount = 0;
      this.IoM = "";
      this.IoN = "";
      this.IoO = "";
      this.IoP = 0;
      this.pyramidLv = 0;
      this.IoQ = "";
      this.IoK = 0L;
      this.qHI = false;
      this.IoS = 0;
      this.IoT = 0;
      this.IoZ = false;
      this.daa = 0;
      this.IoR = 0;
      this.Ipa = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.Ipb = 0;
      this.Ipc = 0;
      this.IoU = 0;
      this.vPG = 0L;
      this.IoV = 0;
      this.IoX = 0L;
      this.IoY = 0;
      ad.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
  
  public final void xe(long paramLong)
  {
    AppMethodBeat.i(91142);
    ad.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.IoI += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void xf(long paramLong)
  {
    AppMethodBeat.i(91147);
    ad.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.IoK = paramLong;
    AppMethodBeat.o(91147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */