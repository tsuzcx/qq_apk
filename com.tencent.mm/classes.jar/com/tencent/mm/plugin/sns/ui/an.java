package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class an
{
  HashMap<String, Integer> Euo;
  j Eup;
  a Euq;
  int Eur;
  private int Eus;
  long Eut;
  private long Euu;
  private long Euv;
  private int Euw;
  private b Eux;
  private final Object Euy;
  final String TAG;
  private boolean clear;
  private String dHp;
  private cnb ebR;
  long gqR;
  private int iXu;
  int jcu;
  String jpT;
  String jpU;
  int jpV;
  int jpW;
  int jpY;
  int jpZ;
  boolean jqb;
  int jqc;
  private int jqd;
  boolean jqe;
  boolean jqf;
  int progress;
  
  public an(a parama)
  {
    AppMethodBeat.i(98119);
    this.TAG = ("MicroMsg.OnlineVideoViewHelper[" + hashCode() + ']');
    this.jpV = 0;
    this.jpW = 0;
    this.Euo = null;
    this.jqc = 0;
    this.jqe = false;
    this.jqf = false;
    this.Eus = 0;
    this.clear = false;
    this.Euy = new Object();
    this.Euq = parama;
    this.Eup = new j();
    this.Euo = new HashMap();
    this.Eux = new b((byte)0);
    this.Eux.jqm = com.tencent.mm.n.h.aqJ().getInt("SnsVideoPreloadSec", 5);
    this.Eux.jqn = com.tencent.mm.n.h.aqJ().getInt("SnsVideoDownloadSec", 1);
    this.Eux.EuA = com.tencent.mm.n.h.aqJ().getInt("SnsVideoFullDownloadPercent", 101);
    Log.i(this.TAG, "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.Eux.jqm), Integer.valueOf(this.Eux.jqn), Integer.valueOf(this.Eux.EuA) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void ZB(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.Euy)
    {
      if (this.Euq != null) {
        this.Euq.aT(paramInt, true);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  private void ZC(int paramInt)
  {
    AppMethodBeat.i(203352);
    synchronized (this.Euy)
    {
      if (this.Euq != null) {
        this.Euq.Zz(paramInt);
      }
      AppMethodBeat.o(203352);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.jqd;
    }
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
    }
    if ((this.jpW == 3) || (this.jpW == 4))
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (this.jqd + paramInt + 1 + this.Eux.jqn);
    }
    if (paramPInt2.value >= this.jpY + 1) {
      paramPInt2.value = (this.jpY + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.Eux.jqn;
      AppMethodBeat.o(98129);
      return false;
    }
    Log.i(this.TAG, "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  private void fgA()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.jqb)
    {
      if ((this.Eus == 0) && (this.Euu == 0L)) {
        fgB();
      }
      for (;;)
      {
        Log.i(this.TAG, "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.Eus), Integer.valueOf(this.Euw), this.jpT });
        this.jpW = 3;
        if (this.jpZ == -1) {
          break;
        }
        ZB(this.jpZ);
        this.jpZ = -1;
        this.jqb = false;
        AppMethodBeat.o(98134);
        return;
        if (this.Euv > 0L) {
          this.Euw = ((int)(this.Euw + Util.milliSecondsToNow(this.Euv)));
        }
      }
      if (fgx()) {}
      for (;;)
      {
        this.jqb = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.jpW != 3)
    {
      Log.i(this.TAG, "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.jpW) });
      if (!fgx()) {
        break label215;
      }
    }
    label215:
    for (int i = 3;; i = this.jpW)
    {
      this.jpW = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] fgC()
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
    for (;;)
    {
      synchronized (this.Euy)
      {
        if (this.Euq == null) {
          break label457;
        }
        n = this.Euq.getPlayVideoDuration();
        m = this.Euq.getUiStayTime();
        k = this.Euq.getPlayErrorCode();
        j = this.Euq.getRptStruct().scene;
        str4 = this.Euq.getRptStruct().sessionId;
        l = this.Euq.getRptStruct().EtT;
        str3 = this.Euq.getRptStruct().dRS;
        str2 = this.Euq.getRptStruct().dRP;
        str1 = this.Euq.getRptStruct().filePath;
        i = this.Euq.getPlayVideoDurationByResume();
        arrayOfObject[0] = Integer.valueOf(n);
        if (this.Euu <= 0L) {
          this.Euu = Util.nowMilliSecond();
        }
        int i1 = (int)(this.Euu - this.gqR);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[1] = Integer.valueOf(n);
        if (this.Eut <= 0L) {
          this.Eut = Util.nowMilliSecond();
        }
        i1 = (int)(this.Eut - this.gqR);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[2] = Integer.valueOf(n);
        arrayOfObject[3] = Integer.valueOf(this.Eus);
        if (this.Eus > 0)
        {
          if (this.Euw == 0) {
            this.Euw = ((int)(this.Euw + Util.milliSecondsToNow(this.Euv)));
          }
          arrayOfObject[4] = Integer.valueOf(this.Euw / this.Eus);
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
        }
      }
      arrayOfObject[4] = Integer.valueOf(0);
      continue;
      label457:
      int i = 0;
    }
  }
  
  private static void fgD()
  {
    AppMethodBeat.i(98138);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private boolean fgx()
  {
    AppMethodBeat.i(98126);
    synchronized (this.Euy)
    {
      if (this.Euq != null)
      {
        boolean bool = this.Euq.fgn();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void fgz()
  {
    AppMethodBeat.i(98133);
    this.jqb = true;
    if (this.jqc <= 0)
    {
      if (this.jpZ == -1)
      {
        this.jpW = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.jpW = 2;
      AppMethodBeat.o(98133);
      return;
    }
    Log.i(this.TAG, "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.jpT, Integer.valueOf(this.Eus), Integer.valueOf(this.jpW) });
    this.Euv = Util.nowMilliSecond();
    if ((this.jpW != 2) && (this.jpW != 4))
    {
      this.jqd += this.Eux.jqm;
      this.jqd = Math.min(this.jqd, 60);
      this.Eus += 1;
      this.jpW = 4;
    }
    this.Euq.bgW();
    AppMethodBeat.o(98133);
  }
  
  private boolean iJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98131);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.Eup.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.bhk().isVideoDataAvailable(this.jpT, localPInt1.value, localPInt2.value);
        if (bool) {
          break label373;
        }
        if (!this.Euo.containsKey(this.jpT + 0 + "_-1"))
        {
          String str = this.jpT + localPInt1.value + "_" + localPInt2.value;
          Log.i(this.TAG, "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.jqf), Boolean.FALSE });
          if ((this.Euo.containsKey(str)) || (this.jqf)) {
            break label352;
          }
          this.jqf = true;
          this.Euo.put(str, Integer.valueOf(paramInt2));
          o.bhk();
          paramInt1 = e.r(this.jpT, localPInt1.value, localPInt2.value);
          if (paramInt1 != 0)
          {
            this.jqf = false;
            this.Euo.remove(str);
            Log.i(this.TAG, "requestVideoData not success %s", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        AppMethodBeat.o(98131);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label352:
        Log.i(this.TAG, "already request video : ".concat(String.valueOf(localException)));
        continue;
        label373:
        Log.i(this.TAG, "already had video data.");
      }
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.jpT = "";
    this.jpZ = -1;
    this.jqc = 0;
    this.jpY = 0;
    this.Eus = 0;
    this.jpW = 0;
    this.jpV = 0;
    this.jqb = false;
    this.jqe = false;
    this.jqf = false;
    this.Euo.clear();
    this.ebR = null;
    this.iXu = 0;
    this.dHp = null;
    if (this.Eux != null) {
      this.jqd = this.Eux.jqm;
    }
    this.Eut = 0L;
    this.gqR = 0L;
    this.Euw = 0;
    this.Euv = 0L;
    this.Euu = 0L;
    AppMethodBeat.o(98121);
  }
  
  private boolean uc(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.jpV == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.jqc - paramInt <= 1) && (this.jqc < this.jpY))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.Eup.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = o.bhk().isVideoDataAvailable(this.jpT, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.jqc = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(98130);
    return bool1;
  }
  
  private static void vn(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  public final boolean a(cnb paramcnb, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.ebR = paramcnb;
    this.iXu = paramInt1;
    this.dHp = paramString;
    this.jpU = ay.E(paramcnb);
    this.jpT = ay.cs(paramInt1, paramcnb.Url);
    if ((Util.isNullOrNil(this.jpU)) || (Util.isNullOrNil(this.jpT)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    Log.i(this.TAG, "start online download video %s isPlayMode %b", new Object[] { this.jpT, Boolean.valueOf(paramBoolean) });
    aj.faM().a(paramcnb, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.jpV = 1;
    this.gqR = Util.nowMilliSecond();
    vn(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  public final boolean aQW(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = Util.isEqual(this.jpT, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    Log.i(this.TAG, "clear");
    this.clear = true;
    reset();
    synchronized (this.Euy)
    {
      this.Euq = null;
      this.Eup = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  final void fgB()
  {
    AppMethodBeat.i(98135);
    if (this.Euu == 0L) {
      this.Euu = Util.nowMilliSecond();
    }
    AppMethodBeat.o(98135);
  }
  
  public final void fgE()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = fgC();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
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
    long l2 = s.boW(str3);
    localObject1 = new iq();
    ((iq)localObject1).eJb = i;
    ((iq)localObject1).eoV = 0L;
    ((iq)localObject1).eoW = 0L;
    ((iq)localObject1).eKb = l2;
    ((iq)localObject1).wo(str1);
    ((iq)localObject1).wn(str2);
    ((iq)localObject1).eJH = l1;
    ((iq)localObject1).eKd = j;
    ((iq)localObject1).eKe = k;
    ((iq)localObject1).eKf = m;
    ((iq)localObject1).eGx = n;
    ((iq)localObject1).eKy = i1;
    ((iq)localObject1).eKz = i2;
    ((iq)localObject1).ePv = i3;
    ((iq)localObject1).wp((String)localObject2);
    ((iq)localObject1).ePx = i4;
    ((iq)localObject1).bfK();
    AppMethodBeat.o(98139);
  }
  
  public final boolean fgw()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!Util.isNullOrNil(this.jpT)) {
      if (this.jpV == 3)
      {
        bool = true;
        Log.i(this.TAG, "stop online download video %s isFinish %b percent %d", new Object[] { this.jpT, Boolean.valueOf(bool), Integer.valueOf(this.Eur) });
        aj.faM().q(this.jpT, fgC());
        if ((this.Eur >= this.Eux.EuA) && (!bool)) {
          aj.faM().a(this.ebR, this.iXu, this.dHp, false, false, 36);
        }
        fgD();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      fgE();
    }
  }
  
  final void fgy()
  {
    AppMethodBeat.i(98132);
    Log.i(this.TAG, "play offline video %s ", new Object[] { this.jpT });
    fgB();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if (an.this.Euq != null) {
          an.this.vm(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  public final boolean ub(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.jpZ != -1) {}
    for (int i = this.jpZ;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      Log.i(this.TAG, "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jqc), Integer.valueOf(this.jpY), Integer.valueOf(this.jpW), Integer.valueOf(this.jpV), this.jpT, Long.valueOf(this.Euu - this.gqR), Boolean.valueOf(this.jqe) });
      if (this.Euq == null)
      {
        Log.i(this.TAG, "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      switch (this.jpV)
      {
      default: 
        Log.w(this.TAG, "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!uc(i))
        {
          fgz();
          bool1 = false;
        }
        for (;;)
        {
          ZC(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label378;
          }
          if (!iJ(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.jqc = Math.max(this.jqc, localPInt2.value);
          bool1 = true;
          break;
          fgB();
          if (this.jqe)
          {
            ZC(i);
            fgA();
          }
          else
          {
            Log.i(this.TAG, "prepare cdnMediaId [%s]", new Object[] { this.jpT });
            if (this.jpW == 5) {
              this.jpW = 1;
            }
            vm(true);
            this.jqe = true;
          }
        }
        label378:
        Log.d(this.TAG, "can not calc download.");
        o.bhk();
        e.r(this.jpT, 0, -1);
        continue;
        fgB();
        if (this.jqe)
        {
          if (this.jqb)
          {
            if (this.jpZ == -1) {
              break label467;
            }
            ZB(this.jpZ);
            this.jpZ = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.jqb = bool1;
            this.jpW = 3;
            ZC(i);
            bool1 = bool2;
            break;
            label467:
            if (fgx()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.jpW == 5) {
          this.jpW = 1;
        }
        vm(false);
        this.jqe = true;
        bool1 = bool2;
        continue;
        Log.w(this.TAG, "download error.");
        bool1 = bool2;
      }
    }
  }
  
  final void vm(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.Euy)
    {
      if (this.Euq != null) {
        this.Euq.cq(this.jpU, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Zz(int paramInt);
    
    public abstract void aT(int paramInt, boolean paramBoolean);
    
    public abstract void bgW();
    
    public abstract void cq(String paramString, boolean paramBoolean);
    
    public abstract boolean fgn();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract an.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int EuA;
    int jqm;
    int jqn;
  }
  
  public static final class c
  {
    public long EtT = 0L;
    public String dRP = "";
    public String dRS = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */