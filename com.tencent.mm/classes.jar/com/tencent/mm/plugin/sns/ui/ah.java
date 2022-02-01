package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.m.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class ah
{
  private boolean clear;
  private String ddB;
  private btz dwE;
  long frt;
  private int hGU;
  int hLN;
  int hYA;
  private int hYB;
  boolean hYC;
  boolean hYD;
  String hYq;
  String hYr;
  int hYt;
  int hYu;
  int hYw;
  int hYx;
  boolean hYz;
  int progress;
  HashMap<String, Integer> yCZ;
  j yDa;
  a yDb;
  int yDc;
  private int yDd;
  long yDe;
  private long yDf;
  private long yDg;
  private int yDh;
  private b yDi;
  private final Object yDj;
  
  public ah(a parama)
  {
    AppMethodBeat.i(98119);
    this.hYt = 0;
    this.hYu = 0;
    this.yCZ = null;
    this.hYA = 0;
    this.hYC = false;
    this.hYD = false;
    this.yDd = 0;
    this.clear = false;
    this.yDj = new Object();
    this.yDb = parama;
    this.yDa = new j();
    this.yCZ = new HashMap();
    this.yDi = new b((byte)0);
    this.yDi.hYK = g.ZY().getInt("SnsVideoPreloadSec", 5);
    this.yDi.hYL = g.ZY().getInt("SnsVideoDownloadSec", 1);
    this.yDi.yDl = g.ZY().getInt("SnsVideoFullDownloadPercent", 101);
    ac.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.yDi.hYK), Integer.valueOf(this.yDi.hYL), Integer.valueOf(this.yDi.yDl) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void Pq(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.yDj)
    {
      if (this.yDb != null) {
        this.yDb.IE(paramInt);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.hYA);
    if (this.hYu == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hYB;
    }
    if (this.hYu == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hYB + 8);
    }
    if ((this.hYu == 3) || (this.hYu == 4))
    {
      paramPInt1.value = this.hYA;
      paramPInt2.value = (this.hYB + paramInt + 1 + this.yDi.hYL);
    }
    if (paramPInt2.value >= this.hYw + 1) {
      paramPInt2.value = (this.hYw + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.yDi.hYL;
      AppMethodBeat.o(98129);
      return false;
    }
    ac.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  private boolean dOm()
  {
    AppMethodBeat.i(98126);
    synchronized (this.yDj)
    {
      if (this.yDb != null)
      {
        boolean bool = this.yDb.dOb();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void dOo()
  {
    AppMethodBeat.i(98133);
    this.hYz = true;
    if (this.hYA <= 0)
    {
      if (this.hYx == -1)
      {
        this.hYu = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.hYu = 2;
      AppMethodBeat.o(98133);
      return;
    }
    ac.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.hYq, Integer.valueOf(this.yDd), Integer.valueOf(this.hYu) });
    this.yDg = bs.eWj();
    if ((this.hYu != 2) && (this.hYu != 4))
    {
      this.hYB += this.yDi.hYK;
      this.hYB = Math.min(this.hYB, 60);
      this.yDd += 1;
      this.hYu = 4;
    }
    this.yDb.aJm();
    AppMethodBeat.o(98133);
  }
  
  private void dOp()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.hYz)
    {
      if ((this.yDd == 0) && (this.yDf == 0L)) {
        dOq();
      }
      for (;;)
      {
        ac.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.yDd), Integer.valueOf(this.yDh), this.hYq });
        this.hYu = 3;
        if (this.hYx == -1) {
          break;
        }
        Pq(this.hYx);
        this.hYx = -1;
        this.hYz = false;
        AppMethodBeat.o(98134);
        return;
        if (this.yDg > 0L) {
          this.yDh = ((int)(this.yDh + bs.Ap(this.yDg)));
        }
      }
      if (dOm()) {}
      for (;;)
      {
        this.hYz = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.hYu != 3)
    {
      ac.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.hYu) });
      if (!dOm()) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = this.hYu)
    {
      this.hYu = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] dOr()
  {
    AppMethodBeat.i(98136);
    Object[] arrayOfObject = new Object[14];
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    String str4 = "";
    long l = 0L;
    String str3 = "";
    String str2 = "";
    String str1 = "";
    int i = 0;
    if (this.yDb != null)
    {
      n = this.yDb.getPlayVideoDuration();
      m = this.yDb.getUiStayTime();
      k = this.yDb.getPlayErrorCode();
      j = this.yDb.getRptStruct().scene;
      str4 = this.yDb.getRptStruct().sessionId;
      l = this.yDb.getRptStruct().yCF;
      str3 = this.yDb.getRptStruct().dnn;
      str2 = this.yDb.getRptStruct().dnk;
      str1 = this.yDb.getRptStruct().filePath;
      i = this.yDb.getPlayVideoDurationByResume();
    }
    arrayOfObject[0] = Integer.valueOf(n);
    if (this.yDf <= 0L) {
      this.yDf = bs.eWj();
    }
    int i1 = (int)(this.yDf - this.frt);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[1] = Integer.valueOf(n);
    if (this.yDe <= 0L) {
      this.yDe = bs.eWj();
    }
    i1 = (int)(this.yDe - this.frt);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[2] = Integer.valueOf(n);
    arrayOfObject[3] = Integer.valueOf(this.yDd);
    if (this.yDd > 0)
    {
      if (this.yDh == 0) {
        this.yDh = ((int)(this.yDh + bs.Ap(this.yDg)));
      }
      arrayOfObject[4] = Integer.valueOf(this.yDh / this.yDd);
    }
    for (;;)
    {
      arrayOfObject[5] = Integer.valueOf(m);
      arrayOfObject[6] = Integer.valueOf(k);
      arrayOfObject[7] = Integer.valueOf(j);
      arrayOfObject[8] = str4;
      arrayOfObject[9] = Long.valueOf(l);
      arrayOfObject[10] = str3;
      arrayOfObject[11] = str2;
      arrayOfObject[12] = str1;
      arrayOfObject[13] = Integer.valueOf(i);
      AppMethodBeat.o(98136);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  private static void dOs()
  {
    AppMethodBeat.i(98138);
    h.wUl.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private boolean hv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98131);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.yDa.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.aJz().isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
        if (bool) {
          break label327;
        }
        if (!this.yCZ.containsKey(this.hYq + 0 + "_-1"))
        {
          String str = this.hYq + localPInt1.value + "_" + localPInt2.value;
          ac.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.hYD), Boolean.FALSE });
          if ((this.yCZ.containsKey(str)) || (this.hYD)) {
            break label308;
          }
          this.hYD = true;
          o.aJz();
          com.tencent.mm.an.e.p(this.hYq, localPInt1.value, localPInt2.value);
          this.yCZ.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(98131);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label308:
        ac.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label327:
        ac.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
      }
    }
  }
  
  private boolean pH(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.hYt == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.hYA - paramInt <= 1) && (this.hYA < this.hYw))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.yDa.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = o.aJz().isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.hYA = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(98130);
    return bool1;
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.hYq = "";
    this.hYx = -1;
    this.hYA = 0;
    this.hYw = 0;
    this.yDd = 0;
    this.hYu = 0;
    this.hYt = 0;
    this.hYz = false;
    this.hYC = false;
    this.hYD = false;
    this.yCZ.clear();
    this.dwE = null;
    this.hGU = 0;
    this.ddB = null;
    if (this.yDi != null) {
      this.hYB = this.yDi.hYK;
    }
    this.yDe = 0L;
    this.frt = 0L;
    this.yDh = 0;
    this.yDg = 0L;
    this.yDf = 0L;
    AppMethodBeat.o(98121);
  }
  
  private static void rg(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      h.wUl.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    h.wUl.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  public final boolean a(btz parambtz, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.dwE = parambtz;
    this.hGU = paramInt1;
    this.ddB = paramString;
    this.hYr = au.D(parambtz);
    this.hYq = au.bU(paramInt1, parambtz.Url);
    if ((bs.isNullOrNil(this.hYr)) || (bs.isNullOrNil(this.hYq)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    ac.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { this.hYq, Boolean.valueOf(paramBoolean) });
    af.dHP().a(parambtz, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.hYt = 1;
    this.frt = bs.eWj();
    rg(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  public final boolean avD(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = bs.lr(this.hYq, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    ac.i("MicroMsg.OnlineVideoViewHelper", "clear");
    this.clear = true;
    reset();
    synchronized (this.yDj)
    {
      this.yDb = null;
      this.yDa = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  public final boolean dOl()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!bs.isNullOrNil(this.hYq)) {
      if (this.hYt == 3)
      {
        bool = true;
        ac.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.hYq, Boolean.valueOf(bool), Integer.valueOf(this.yDc) });
        af.dHP().r(this.hYq, dOr());
        if ((this.yDc >= this.yDi.yDl) && (!bool)) {
          af.dHP().a(this.dwE, this.hGU, this.ddB, false, false, 36);
        }
        dOs();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      dOt();
    }
  }
  
  final void dOn()
  {
    AppMethodBeat.i(98132);
    ac.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.hYq });
    dOq();
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if (ah.this.yDb != null) {
          ah.this.rf(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void dOq()
  {
    AppMethodBeat.i(98135);
    if (this.yDf == 0L) {
      this.yDf = bs.eWj();
    }
    AppMethodBeat.o(98135);
  }
  
  public final void dOt()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = dOr();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = ax.iI(ai.getContext());
    int j = ((Integer)localObject1[1]).intValue();
    int k = ((Integer)localObject1[2]).intValue();
    int m = ((Integer)localObject1[3]).intValue();
    int n = ((Integer)localObject1[4]).intValue();
    int i1 = ((Integer)localObject1[5]).intValue();
    int i2 = ((Integer)localObject1[6]).intValue();
    int i3 = ((Integer)localObject1[7]).intValue();
    localObject2 = (String)localObject1[8];
    int i4 = ((Long)localObject1[9]).intValue();
    String str1 = (String)localObject1[10];
    String str2 = (String)localObject1[11];
    String str3 = (String)localObject1[12];
    long l1 = ((Integer)localObject1[13]).intValue() * 1000;
    long l2 = i.aSp(str3);
    localObject1 = new ee();
    ((ee)localObject1).dQE = i;
    ((ee)localObject1).dGo = 0L;
    ((ee)localObject1).dGp = 0L;
    ((ee)localObject1).dQx = l2;
    ((ee)localObject1).lY(str1);
    ((ee)localObject1).lX(str2);
    ((ee)localObject1).dQz = l1;
    ((ee)localObject1).dQA = j;
    ((ee)localObject1).dQB = k;
    ((ee)localObject1).dQC = m;
    ((ee)localObject1).dQD = n;
    ((ee)localObject1).dQX = i1;
    ((ee)localObject1).dQY = i2;
    ((ee)localObject1).dTY = i3;
    ((ee)localObject1).lZ((String)localObject2);
    ((ee)localObject1).dUa = i4;
    ((ee)localObject1).aHZ();
    AppMethodBeat.o(98139);
  }
  
  public final boolean pG(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.hYx != -1) {}
    for (int i = this.hYx;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      ac.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hYA), Integer.valueOf(this.hYw), Integer.valueOf(this.hYu), Integer.valueOf(this.hYt), this.hYq, Long.valueOf(this.yDf - this.frt), Boolean.valueOf(this.hYC) });
      if (this.yDb == null)
      {
        ac.i("MicroMsg.OnlineVideoViewHelper", "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      switch (this.hYt)
      {
      default: 
        ac.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!pH(i))
        {
          dOo();
          bool1 = false;
        }
        for (;;)
        {
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label360;
          }
          if (!hv(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.hYA = Math.max(this.hYA, localPInt2.value);
          bool1 = true;
          break;
          dOq();
          if (this.hYC)
          {
            dOp();
          }
          else
          {
            ac.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.hYq });
            if (this.hYu == 5) {
              this.hYu = 1;
            }
            rf(true);
            this.hYC = true;
          }
        }
        label360:
        ac.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        o.aJz();
        com.tencent.mm.an.e.p(this.hYq, 0, -1);
        continue;
        dOq();
        if (this.hYC)
        {
          if (this.hYz)
          {
            if (this.hYx == -1) {
              break label442;
            }
            Pq(this.hYx);
            this.hYx = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.hYz = bool1;
            this.hYu = 3;
            bool1 = bool2;
            break;
            label442:
            if (dOm()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.hYu == 5) {
          this.hYu = 1;
        }
        rf(false);
        this.hYC = true;
        bool1 = bool2;
        continue;
        ac.w("MicroMsg.OnlineVideoViewHelper", "download error.");
        bool1 = bool2;
      }
    }
  }
  
  final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.yDj)
    {
      if (this.yDb != null) {
        this.yDb.bN(this.hYr, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void IE(int paramInt);
    
    public abstract void aJm();
    
    public abstract void bN(String paramString, boolean paramBoolean);
    
    public abstract boolean dOb();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract ah.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int hYK;
    int hYL;
    int yDl;
  }
  
  public static final class c
  {
    public String dnk = "";
    public String dnn = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
    public long yCF = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ah
 * JD-Core Version:    0.7.0.1
 */