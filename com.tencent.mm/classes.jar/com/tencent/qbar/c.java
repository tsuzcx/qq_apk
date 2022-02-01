package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static int JQl;
  public static int JQm;
  public static int JQn;
  public static int JQo;
  public static int JQp;
  public static int JQq;
  public static c JQr;
  public static c JQs;
  private int JQA;
  private String JQB;
  private int JQC;
  private int JQD;
  private int JQE;
  public int JQF;
  public float JQG;
  public long JQH;
  int JQI;
  boolean JQJ;
  private List<QbarNative.QBarCodeDetectInfo> JQK;
  private int JQL;
  private int JQM;
  private long JQt;
  public int JQu;
  private long JQv;
  private Point JQw;
  private String JQx;
  private String JQy;
  private String JQz;
  private int cXw;
  public float decodeScale;
  public int detectTime;
  private int diw;
  private int pyramidLv;
  private boolean rAJ;
  private int retryCount;
  public String scaleList;
  public int srTime;
  private int wKY;
  private Object wXD;
  public long xan;
  private boolean xap;
  
  static
  {
    AppMethodBeat.i(91151);
    JQl = 0;
    JQm = 1;
    JQn = 2;
    JQo = 1;
    JQp = 2;
    JQq = 3;
    JQr = new c();
    JQs = new c();
    AppMethodBeat.o(91151);
  }
  
  public c()
  {
    AppMethodBeat.i(91141);
    this.JQt = 0L;
    this.xap = false;
    this.JQu = 0;
    this.JQv = 0L;
    this.wKY = -1;
    this.JQw = null;
    this.retryCount = 0;
    this.cXw = 0;
    this.JQD = 0;
    this.diw = 0;
    this.xan = 0L;
    this.JQF = 0;
    this.JQG = 1.0F;
    this.JQH = 0L;
    this.JQI = 0;
    this.rAJ = false;
    this.JQL = 0;
    this.JQM = 0;
    this.wXD = new Object();
    AppMethodBeat.o(91141);
  }
  
  public final void BO(long paramLong)
  {
    AppMethodBeat.i(91142);
    ac.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", new Object[] { Long.valueOf(paramLong) });
    this.JQt += paramLong;
    AppMethodBeat.o(91142);
  }
  
  public final void BP(long paramLong)
  {
    AppMethodBeat.i(91147);
    ac.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", new Object[] { Long.valueOf(paramLong) });
    this.JQv = paramLong;
    AppMethodBeat.o(91147);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, WxQbarNative.QBarReportMsg paramQBarReportMsg, int paramInt, List<WxQbarNative.QBarReportMsg> paramList)
  {
    AppMethodBeat.i(91148);
    this.JQx = paramString1;
    this.JQy = paramString2;
    this.JQz = paramString3;
    this.cXw = paramInt;
    this.JQC = 0;
    if (paramQBarReportMsg != null)
    {
      this.JQA = paramQBarReportMsg.qrcodeVersion;
      this.pyramidLv = paramQBarReportMsg.pyramidLv;
      this.JQB = paramQBarReportMsg.binaryMethod;
      this.scaleList = paramQBarReportMsg.scaleList;
      this.decodeScale = paramQBarReportMsg.decodeScale;
      this.detectTime = paramQBarReportMsg.detectTime;
      this.srTime = paramQBarReportMsg.srTime;
    }
    this.JQL = 0;
    this.JQM = 0;
    paramQBarReportMsg = paramList.iterator();
    while (paramQBarReportMsg.hasNext())
    {
      paramList = (WxQbarNative.QBarReportMsg)paramQBarReportMsg.next();
      if (paramList.inWhiteList) {
        this.JQL += 1;
      } else if (paramList.inBlackList) {
        this.JQM += 1;
      }
    }
    ac.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(this.JQA), Integer.valueOf(this.pyramidLv), this.JQB, Integer.valueOf(paramInt), Integer.valueOf(0), this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.JQL), Integer.valueOf(this.JQM) });
    AppMethodBeat.o(91148);
  }
  
  public final void adZ(int paramInt)
  {
    AppMethodBeat.i(91145);
    ac.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", new Object[] { Integer.valueOf(paramInt) });
    this.wKY = paramInt;
    AppMethodBeat.o(91145);
  }
  
  public final void aea(int paramInt)
  {
    if (this.JQE != 2) {
      this.JQE = paramInt;
    }
  }
  
  public final void aeb(int paramInt)
  {
    AppMethodBeat.i(176205);
    ac.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.diw = paramInt;
    AppMethodBeat.o(176205);
  }
  
  public final void btF()
  {
    AppMethodBeat.i(91149);
    for (;;)
    {
      int j;
      synchronized (this.wXD)
      {
        if (this.rAJ)
        {
          ac.i("MicroMsg.QBarEngineReporter", "doReport, already report");
          AppMethodBeat.o(91149);
          return;
        }
        j = this.JQu;
        long l1 = this.JQt;
        long l2 = this.JQv;
        int k = this.wKY;
        Object localObject1 = this.JQw;
        int m = this.retryCount;
        boolean bool = this.xap;
        str1 = this.JQx;
        localObject3 = this.JQy;
        Object localObject5 = this.JQz;
        int n = this.JQA;
        int i1 = this.pyramidLv;
        String str2 = this.JQB;
        if (bs.isNullOrNil(this.JQy)) {
          break label1059;
        }
        i = this.JQy.length();
        ac.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(k), localObject1, Integer.valueOf(m), Boolean.valueOf(bool), str1, localObject3, localObject5, Integer.valueOf(n), Integer.valueOf(i1), str2, Integer.valueOf(i), this.JQD, Integer.valueOf(this.JQE), Integer.valueOf(this.diw), Integer.valueOf(this.JQF), Long.valueOf(this.JQH), Float.valueOf(this.JQG), Integer.valueOf(this.JQI) });
        if (this.JQw != null)
        {
          str1 = this.JQw.x + "x" + this.JQw.y;
          if ((this.xap) || (this.JQK == null)) {
            break label1064;
          }
          k = this.JQK.size();
          ac.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", new Object[] { Integer.valueOf(k) });
          localObject5 = this.JQK.iterator();
          j = 0;
          localObject1 = "";
          localObject3 = localObject1;
          i = k;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (QbarNative.QBarCodeDetectInfo)((Iterator)localObject5).next();
            if (j < this.JQK.size() - 1)
            {
              localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob + "|";
              break label1052;
            }
            localObject1 = (String)localObject1 + ((QbarNative.QBarCodeDetectInfo)localObject3).prob;
            break label1052;
          }
          localObject1 = h.wUl;
          n = this.JQu;
          l1 = this.JQt;
          l2 = this.JQv;
          i1 = this.wKY;
          int i2 = this.retryCount;
          if (this.xap)
          {
            j = 0;
            localObject5 = this.JQx;
            str2 = this.JQz;
            int i3 = this.JQA;
            int i4 = this.pyramidLv;
            String str3 = this.JQB;
            if (!bs.isNullOrNil(this.JQy))
            {
              k = this.JQy.length();
              String str4 = this.JQD;
              int i5 = this.JQE;
              if (!this.JQJ) {
                continue;
              }
              m = 1;
              ((h)localObject1).f(13233, new Object[] { Integer.valueOf(n), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i1), str1, Integer.valueOf(i2), Integer.valueOf(j), localObject5, "", str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Integer.valueOf(k), str4, Integer.valueOf(i5), Integer.valueOf(m), Integer.valueOf(0), a.getVersion(), Integer.valueOf(this.cXw), Integer.valueOf(this.JQC), Integer.valueOf(i), localObject3, this.scaleList, Integer.valueOf((int)(this.decodeScale * 10.0F)), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.JQL), Integer.valueOf(this.JQM), Integer.valueOf(this.diw), Integer.valueOf(this.cXw), Integer.valueOf(this.JQF), Long.valueOf(this.JQH), Integer.valueOf((int)(this.JQG * 100.0F)), Integer.valueOf(this.JQI) });
              this.rAJ = true;
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
  
  public final void fCf()
  {
    AppMethodBeat.i(91143);
    ac.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
    this.xap = true;
    AppMethodBeat.o(91143);
  }
  
  public final void fCg()
  {
    AppMethodBeat.i(91144);
    ac.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", new Object[] { Integer.valueOf(this.JQu) });
    this.JQu += 1;
    AppMethodBeat.o(91144);
  }
  
  public final void kw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91146);
    ac.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.JQw = new Point(paramInt1, paramInt2);
    AppMethodBeat.o(91146);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(91150);
    synchronized (this.wXD)
    {
      this.JQt = 0L;
      this.xap = false;
      this.JQu = 0;
      this.wKY = -1;
      this.JQw = null;
      this.retryCount = 0;
      this.JQx = "";
      this.JQy = "";
      this.JQz = "";
      this.JQA = 0;
      this.pyramidLv = 0;
      this.JQB = "";
      this.JQv = 0L;
      this.rAJ = false;
      this.JQD = 0;
      this.JQE = 0;
      this.JQJ = false;
      this.cXw = 0;
      this.JQC = 0;
      this.JQK = null;
      this.scaleList = "";
      this.decodeScale = 0.0F;
      this.detectTime = 0;
      this.srTime = 0;
      this.JQL = 0;
      this.JQM = 0;
      this.diw = 0;
      this.xan = 0L;
      this.JQF = 0;
      this.JQH = 0L;
      this.JQI = 0;
      ac.i("MicroMsg.QBarEngineReporter", "reset");
      AppMethodBeat.o(91150);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.c
 * JD-Core Version:    0.7.0.1
 */