package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.m.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class ah
{
  private boolean clear;
  private String dgg;
  private bpi dyS;
  long fnZ;
  private int hgr;
  int hlk;
  String hxP;
  String hxQ;
  int hxS;
  int hxT;
  int hxV;
  int hxW;
  boolean hxY;
  int hxZ;
  private int hya;
  boolean hyb;
  boolean hyc;
  int progress;
  HashMap<String, Integer> xqj;
  com.tencent.mm.plugin.a.i xqk;
  a xql;
  int xqm;
  private int xqn;
  long xqo;
  private long xqp;
  private long xqq;
  private int xqr;
  private b xqs;
  private final Object xqt;
  
  public ah(a parama)
  {
    AppMethodBeat.i(98119);
    this.hxS = 0;
    this.hxT = 0;
    this.xqj = null;
    this.hxZ = 0;
    this.hyb = false;
    this.hyc = false;
    this.xqn = 0;
    this.clear = false;
    this.xqt = new Object();
    this.xql = parama;
    this.xqk = new com.tencent.mm.plugin.a.i();
    this.xqj = new HashMap();
    this.xqs = new b((byte)0);
    this.xqs.hyj = g.Zd().getInt("SnsVideoPreloadSec", 5);
    this.xqs.hyk = g.Zd().getInt("SnsVideoDownloadSec", 1);
    this.xqs.xqv = g.Zd().getInt("SnsVideoFullDownloadPercent", 101);
    ad.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.xqs.hyj), Integer.valueOf(this.xqs.hyk), Integer.valueOf(this.xqs.xqv) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void Nn(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.xqt)
    {
      if (this.xql != null) {
        this.xql.GI(paramInt);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    if (this.hxT == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hya;
    }
    if (this.hxT == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hya + 8);
    }
    if ((this.hxT == 3) || (this.hxT == 4))
    {
      paramPInt1.value = this.hxZ;
      paramPInt2.value = (this.hya + paramInt + 1 + this.xqs.hyk);
    }
    if (paramPInt2.value >= this.hxV + 1) {
      paramPInt2.value = (this.hxV + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.xqs.hyk;
      AppMethodBeat.o(98129);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  private boolean dzP()
  {
    AppMethodBeat.i(98126);
    synchronized (this.xqt)
    {
      if (this.xql != null)
      {
        boolean bool = this.xql.dzE();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void dzR()
  {
    AppMethodBeat.i(98133);
    this.hxY = true;
    if (this.hxZ <= 0)
    {
      if (this.hxW == -1)
      {
        this.hxT = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.hxT = 2;
      AppMethodBeat.o(98133);
      return;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.hxP, Integer.valueOf(this.xqn), Integer.valueOf(this.hxT) });
    this.xqq = bt.eGO();
    if ((this.hxT != 2) && (this.hxT != 4))
    {
      this.hya += this.xqs.hyj;
      this.hya = Math.min(this.hya, 60);
      this.xqn += 1;
      this.hxT = 4;
    }
    this.xql.aCv();
    AppMethodBeat.o(98133);
  }
  
  private void dzS()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.hxY)
    {
      if ((this.xqn == 0) && (this.xqp == 0L)) {
        dzT();
      }
      for (;;)
      {
        ad.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.xqn), Integer.valueOf(this.xqr), this.hxP });
        this.hxT = 3;
        if (this.hxW == -1) {
          break;
        }
        Nn(this.hxW);
        this.hxW = -1;
        this.hxY = false;
        AppMethodBeat.o(98134);
        return;
        if (this.xqq > 0L) {
          this.xqr = ((int)(this.xqr + bt.vM(this.xqq)));
        }
      }
      if (dzP()) {}
      for (;;)
      {
        this.hxY = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.hxT != 3)
    {
      ad.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.hxT) });
      if (!dzP()) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = this.hxT)
    {
      this.hxT = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] dzU()
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
    if (this.xql != null)
    {
      n = this.xql.getPlayVideoDuration();
      m = this.xql.getUiStayTime();
      k = this.xql.getPlayErrorCode();
      j = this.xql.getRptStruct().scene;
      str4 = this.xql.getRptStruct().sessionId;
      l = this.xql.getRptStruct().xpP;
      str3 = this.xql.getRptStruct().dpC;
      str2 = this.xql.getRptStruct().dpz;
      str1 = this.xql.getRptStruct().filePath;
      i = this.xql.getPlayVideoDurationByResume();
    }
    arrayOfObject[0] = Integer.valueOf(n);
    if (this.xqp <= 0L) {
      this.xqp = bt.eGO();
    }
    int i1 = (int)(this.xqp - this.fnZ);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[1] = Integer.valueOf(n);
    if (this.xqo <= 0L) {
      this.xqo = bt.eGO();
    }
    i1 = (int)(this.xqo - this.fnZ);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[2] = Integer.valueOf(n);
    arrayOfObject[3] = Integer.valueOf(this.xqn);
    if (this.xqn > 0)
    {
      if (this.xqr == 0) {
        this.xqr = ((int)(this.xqr + bt.vM(this.xqq)));
      }
      arrayOfObject[4] = Integer.valueOf(this.xqr / this.xqn);
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
  
  private static void dzV()
  {
    AppMethodBeat.i(98138);
    h.vKh.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private boolean hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98131);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.xqk.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.aCJ().isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
        if (bool) {
          break label327;
        }
        if (!this.xqj.containsKey(this.hxP + 0 + "_-1"))
        {
          String str = this.hxP + localPInt1.value + "_" + localPInt2.value;
          ad.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.hyc), Boolean.FALSE });
          if ((this.xqj.containsKey(str)) || (this.hyc)) {
            break label308;
          }
          this.hyc = true;
          o.aCJ();
          com.tencent.mm.ao.e.q(this.hxP, localPInt1.value, localPInt2.value);
          this.xqj.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(98131);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label308:
        ad.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label327:
        ad.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
      }
    }
  }
  
  private boolean oS(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.hxS == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.hxZ - paramInt <= 1) && (this.hxZ < this.hxV))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.xqk.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = o.aCJ().isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.hxZ = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(98130);
    return bool1;
  }
  
  private static void qh(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      h.vKh.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    h.vKh.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.hxP = "";
    this.hxW = -1;
    this.hxZ = 0;
    this.hxV = 0;
    this.xqn = 0;
    this.hxT = 0;
    this.hxS = 0;
    this.hxY = false;
    this.hyb = false;
    this.hyc = false;
    this.xqj.clear();
    this.dyS = null;
    this.hgr = 0;
    this.dgg = null;
    if (this.xqs != null) {
      this.hya = this.xqs.hyj;
    }
    this.xqo = 0L;
    this.fnZ = 0L;
    this.xqr = 0;
    this.xqq = 0L;
    this.xqp = 0L;
    AppMethodBeat.o(98121);
  }
  
  public final boolean a(bpi parambpi, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.dyS = parambpi;
    this.hgr = paramInt1;
    this.dgg = paramString;
    this.hxQ = at.D(parambpi);
    this.hxP = at.bQ(paramInt1, parambpi.Url);
    if ((bt.isNullOrNil(this.hxQ)) || (bt.isNullOrNil(this.hxP)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { this.hxP, Boolean.valueOf(paramBoolean) });
    af.dts().a(parambpi, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.hxS = 1;
    this.fnZ = bt.eGO();
    qh(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  public final boolean aqu(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = bt.kU(this.hxP, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    ad.i("MicroMsg.OnlineVideoViewHelper", "clear");
    this.clear = true;
    reset();
    synchronized (this.xqt)
    {
      this.xql = null;
      this.xqk = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  public final boolean dzO()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!bt.isNullOrNil(this.hxP)) {
      if (this.hxS == 3)
      {
        bool = true;
        ad.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.hxP, Boolean.valueOf(bool), Integer.valueOf(this.xqm) });
        af.dts().r(this.hxP, dzU());
        if ((this.xqm >= this.xqs.xqv) && (!bool)) {
          af.dts().a(this.dyS, this.hgr, this.dgg, false, false, 36);
        }
        dzV();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      dzW();
    }
  }
  
  final void dzQ()
  {
    AppMethodBeat.i(98132);
    ad.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.hxP });
    dzT();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if (ah.this.xql != null) {
          ah.this.qg(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void dzT()
  {
    AppMethodBeat.i(98135);
    if (this.xqp == 0L) {
      this.xqp = bt.eGO();
    }
    AppMethodBeat.o(98135);
  }
  
  public final void dzW()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = dzU();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = ay.ix(aj.getContext());
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
    long l2 = com.tencent.mm.vfs.i.aMN(str3);
    localObject1 = new cq();
    ((cq)localObject1).dON = i;
    ((cq)localObject1).dIm = 0L;
    ((cq)localObject1).dIn = 0L;
    ((cq)localObject1).dOG = l2;
    ((cq)localObject1).ji(str1);
    ((cq)localObject1).jh(str2);
    ((cq)localObject1).dOI = l1;
    ((cq)localObject1).dOJ = j;
    ((cq)localObject1).dOK = k;
    ((cq)localObject1).dOL = m;
    ((cq)localObject1).dOM = n;
    ((cq)localObject1).dPg = i1;
    ((cq)localObject1).dPh = i2;
    ((cq)localObject1).dSk = i3;
    ((cq)localObject1).jj((String)localObject2);
    ((cq)localObject1).dSm = i4;
    ((cq)localObject1).aBj();
    AppMethodBeat.o(98139);
  }
  
  public final boolean oR(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.hxW != -1) {}
    for (int i = this.hxW;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      ad.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.hxZ), Integer.valueOf(this.hxV), Integer.valueOf(this.hxT), Integer.valueOf(this.hxS), this.hxP, Long.valueOf(this.xqp - this.fnZ), Boolean.valueOf(this.hyb) });
      if (this.xql == null)
      {
        ad.i("MicroMsg.OnlineVideoViewHelper", "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      switch (this.hxS)
      {
      default: 
        ad.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!oS(i))
        {
          dzR();
          bool1 = false;
        }
        for (;;)
        {
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label360;
          }
          if (!hm(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.hxZ = Math.max(this.hxZ, localPInt2.value);
          bool1 = true;
          break;
          dzT();
          if (this.hyb)
          {
            dzS();
          }
          else
          {
            ad.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.hxP });
            if (this.hxT == 5) {
              this.hxT = 1;
            }
            qg(true);
            this.hyb = true;
          }
        }
        label360:
        ad.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        o.aCJ();
        com.tencent.mm.ao.e.q(this.hxP, 0, -1);
        continue;
        dzT();
        if (this.hyb)
        {
          if (this.hxY)
          {
            if (this.hxW == -1) {
              break label442;
            }
            Nn(this.hxW);
            this.hxW = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.hxY = bool1;
            this.hxT = 3;
            bool1 = bool2;
            break;
            label442:
            if (dzP()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.hxT == 5) {
          this.hxT = 1;
        }
        qg(false);
        this.hyb = true;
        bool1 = bool2;
        continue;
        ad.w("MicroMsg.OnlineVideoViewHelper", "download error.");
        bool1 = bool2;
      }
    }
  }
  
  final void qg(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.xqt)
    {
      if (this.xql != null) {
        this.xql.bG(this.hxQ, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void GI(int paramInt);
    
    public abstract void aCv();
    
    public abstract void bG(String paramString, boolean paramBoolean);
    
    public abstract boolean dzE();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract ah.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int hyj;
    int hyk;
    int xqv;
  }
  
  public static final class c
  {
    public String dpC = "";
    public String dpz = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
    public long xpP = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ah
 * JD-Core Version:    0.7.0.1
 */