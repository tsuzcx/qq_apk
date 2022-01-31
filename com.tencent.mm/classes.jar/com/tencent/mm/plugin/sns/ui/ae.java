package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class ae
{
  String bJQ;
  awd bZK;
  long dmd;
  boolean eFA = false;
  boolean eFB = false;
  String eFo;
  String eFp;
  int eFr = 0;
  int eFs = 0;
  f eFt;
  int eFu;
  int eFv;
  boolean eFx;
  int eFy = 0;
  private int eFz;
  int enw;
  HashMap<String, Integer> oRQ = null;
  ae.a oRR;
  int oRS;
  private int oRT = 0;
  long oRU;
  private long oRV;
  private long oRW;
  private int oRX;
  private b oRY;
  int progress;
  int total;
  
  public ae(ae.a parama)
  {
    this.oRR = parama;
    this.eFt = new f();
    this.oRQ = new HashMap();
    this.oRY = new b((byte)0);
    this.oRY.eFI = com.tencent.mm.m.g.AA().getInt("SnsVideoPreloadSec", 5);
    this.oRY.eFJ = com.tencent.mm.m.g.AA().getInt("SnsVideoDownloadSec", 1);
    this.oRY.oSa = com.tencent.mm.m.g.AA().getInt("SnsVideoFullDownloadPercent", 101);
    y.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.oRY.eFI), Integer.valueOf(this.oRY.eFJ), Integer.valueOf(this.oRY.oSa) });
    reset();
  }
  
  private boolean dU(int paramInt1, int paramInt2)
  {
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    boolean bool;
    try
    {
      if (this.eFt.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.Ss().isVideoDataAvailable(this.eFo, localPInt1.value, localPInt2.value);
        if (bool) {
          break label316;
        }
        if (!this.oRQ.containsKey(this.eFo + 0 + "_-1"))
        {
          String str = this.eFo + localPInt1.value + "_" + localPInt2.value;
          y.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.eFB), Boolean.valueOf(false) });
          if ((this.oRQ.containsKey(str)) || (this.eFB)) {
            break label292;
          }
          this.eFB = true;
          o.Ss();
          com.tencent.mm.ak.e.h(this.eFo, localPInt1.value, localPInt2.value);
          this.oRQ.put(str, Integer.valueOf(paramInt2));
        }
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        bool = false;
      }
      label292:
      y.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + localException);
      return bool;
    }
    label316:
    y.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
    return bool;
  }
  
  private boolean js(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if (this.eFr == 3) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (this.eFy - paramInt <= 1)
      {
        bool1 = bool2;
        if (this.eFy < this.eFu) {}
      }
      else
      {
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        bool1 = bool2;
        bool2 = bool3;
        try
        {
          if (this.eFt.a(paramInt, paramInt + 1, localPInt1, localPInt2))
          {
            bool2 = bool3;
            bool3 = o.Ss().isVideoDataAvailable(this.eFo, localPInt1.value, localPInt2.value);
            bool1 = bool3;
            if (!bool3)
            {
              bool2 = bool3;
              this.eFy = paramInt;
              return bool3;
            }
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        }
      }
    }
    return bool2;
  }
  
  private void reset()
  {
    this.eFo = "";
    this.eFv = -1;
    this.eFy = 0;
    this.eFu = 0;
    this.oRT = 0;
    this.eFs = 0;
    this.eFr = 0;
    this.eFx = false;
    this.eFA = false;
    this.eFB = false;
    this.oRQ.clear();
    this.bZK = null;
    this.enw = 0;
    this.bJQ = null;
    if (this.oRY != null) {
      this.eFz = this.oRY.eFI;
    }
    this.oRU = 0L;
    this.dmd = 0L;
    this.oRX = 0;
    this.oRW = 0L;
    this.oRV = 0L;
  }
  
  public final boolean Pi(String paramString)
  {
    return bk.isEqual(this.eFo, paramString);
  }
  
  public final boolean bHU()
  {
    boolean bool;
    ar localar;
    String str;
    Object[] arrayOfObject;
    if (!bk.bl(this.eFo))
    {
      if (this.eFr != 3) {
        break label356;
      }
      bool = true;
      y.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.eFo, Boolean.valueOf(bool), Integer.valueOf(this.oRS) });
      localar = af.bDD();
      str = this.eFo;
      arrayOfObject = new Object[7];
      arrayOfObject[0] = Integer.valueOf(this.oRR.getPlayVideoDuration());
      if (this.oRV <= 0L) {
        this.oRV = bk.UY();
      }
      int j = (int)(this.oRV - this.dmd);
      int i = j;
      if (j <= 0) {
        i = 0;
      }
      arrayOfObject[1] = Integer.valueOf(i);
      if (this.oRU <= 0L) {
        this.oRU = bk.UY();
      }
      j = (int)(this.oRU - this.dmd);
      i = j;
      if (j <= 0) {
        i = 0;
      }
      arrayOfObject[2] = Integer.valueOf(i);
      arrayOfObject[3] = Integer.valueOf(this.oRT);
      if (this.oRT <= 0) {
        break label361;
      }
      if (this.oRX == 0) {
        this.oRX = ((int)(this.oRX + bk.co(this.oRW)));
      }
      arrayOfObject[4] = Integer.valueOf(this.oRX / this.oRT);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(this.oRR.getUiStayTime());
      arrayOfObject[6] = Integer.valueOf(this.oRR.getPlayErrorCode());
      if (!bk.bl(str))
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DS().O(new ar.5(localar, str, arrayOfObject));
      }
      if ((this.oRS >= this.oRY.oSa) && (!bool)) {
        af.bDD().a(this.bZK, this.enw, this.bJQ, false, false, 36);
      }
      h.nFQ.a(354L, 203L, 1L, false);
      return true;
      label356:
      bool = false;
      break;
      label361:
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  final void bHV()
  {
    y.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.eFo });
    bHW();
    ai.d(new ae.2(this));
  }
  
  final void bHW()
  {
    if (this.oRV == 0L) {
      this.oRV = bk.UY();
    }
  }
  
  public final void clear()
  {
    y.i("MicroMsg.OnlineVideoViewHelper", "clear");
    reset();
    this.oRR = null;
    this.eFt = null;
  }
  
  public final boolean jr(int paramInt)
  {
    boolean bool = false;
    if (this.eFv != -1) {}
    for (int i = this.eFv;; i = paramInt)
    {
      y.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.eFy), Integer.valueOf(this.eFu), Integer.valueOf(this.eFs), Integer.valueOf(this.eFr), this.eFo, Long.valueOf(this.oRV - this.dmd), Boolean.valueOf(this.eFA) });
      switch (this.eFr)
      {
      default: 
        y.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        return true;
      case 1: 
        PInt localPInt1;
        PInt localPInt2;
        if (!js(i))
        {
          this.eFx = true;
          if (this.eFy <= 0) {
            if (this.eFv == -1)
            {
              this.eFs = 1;
              bool = false;
              localPInt1 = new PInt();
              localPInt2 = new PInt();
              localPInt1.value = Math.max(i, this.eFy);
              if (this.eFs == 1)
              {
                localPInt1.value = i;
                localPInt1.value += this.eFz;
              }
              if (this.eFs == 2)
              {
                localPInt1.value = (i - 8);
                if (localPInt1.value < 0) {
                  localPInt1.value = 0;
                }
                localPInt2.value = (localPInt1.value + this.eFz + 8);
              }
              if ((this.eFs == 3) || (this.eFs == 4))
              {
                localPInt1.value = this.eFy;
                localPInt2.value = (this.eFz + i + 1 + this.oRY.eFJ);
              }
              if (localPInt2.value >= this.eFu + 1) {
                localPInt2.value = (this.eFu + 1);
              }
              if (localPInt2.value >= localPInt1.value) {
                break label866;
              }
              localPInt1.value += this.oRY.eFJ;
            }
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          if (paramInt == 0) {
            break label943;
          }
          if (!dU(localPInt1.value, localPInt2.value)) {
            break label965;
          }
          this.eFy = Math.max(this.eFy, localPInt2.value);
          return true;
          this.eFs = 2;
          break;
          y.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.eFo, Integer.valueOf(this.oRT), Integer.valueOf(this.eFs) });
          this.oRW = bk.UY();
          if ((this.eFs != 2) && (this.eFs != 4))
          {
            this.eFz += this.oRY.eFI;
            this.eFz = Math.min(this.eFz, 60);
            this.oRT += 1;
            this.eFs = 4;
          }
          this.oRR.Sg();
          break;
          bHW();
          if (this.eFA)
          {
            if (this.eFx)
            {
              if ((this.oRT == 0) && (this.oRV == 0L)) {
                bHW();
              }
              for (;;)
              {
                y.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.oRT), Integer.valueOf(this.oRX), this.eFo });
                this.eFs = 3;
                if (this.eFv == -1) {
                  break label719;
                }
                this.oRR.tP(this.eFv);
                this.eFv = -1;
                this.eFx = false;
                bool = true;
                break;
                if (this.oRW > 0L) {
                  this.oRX = ((int)(this.oRX + bk.co(this.oRW)));
                }
              }
              if (this.oRR.bHP()) {}
              for (bool = false;; bool = true)
              {
                this.eFx = bool;
                bool = true;
                break;
              }
            }
            if (this.eFs != 3)
            {
              y.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.eFs) });
              if (!this.oRR.bHP()) {
                break label802;
              }
            }
            for (paramInt = 3;; paramInt = this.eFs)
            {
              this.eFs = paramInt;
              bool = true;
              break;
            }
          }
          y.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.eFo });
          if (this.eFs == 5) {
            this.eFs = 1;
          }
          this.oRR.bg(this.eFp, true);
          this.eFA = true;
          bool = true;
          break label193;
          y.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(i), Integer.valueOf(this.eFs), Integer.valueOf(this.eFy), Integer.valueOf(this.eFz) });
        }
        y.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        o.Ss();
        com.tencent.mm.ak.e.h(this.eFo, 0, -1);
        return bool;
      case 3: 
        label193:
        label719:
        label866:
        bHW();
        label802:
        label943:
        label965:
        if (this.eFA)
        {
          if (this.eFx)
          {
            if (this.eFv == -1) {
              break label1023;
            }
            this.oRR.tP(this.eFv);
            this.eFv = -1;
          }
          for (;;)
          {
            this.eFx = bool;
            this.eFs = 3;
            return true;
            label1023:
            if (!this.oRR.bHP()) {
              bool = true;
            }
          }
        }
        if (this.eFs == 5) {
          this.eFs = 1;
        }
        this.oRR.bg(this.eFp, false);
        this.eFA = true;
        return true;
      }
      y.w("MicroMsg.OnlineVideoViewHelper", "download error.");
      return true;
    }
  }
  
  private static final class b
  {
    int eFI;
    int eFJ;
    int oSa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */