package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.f.b.a.kz;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;

public final class ap
{
  HashMap<String, Integer> KIf;
  j KIg;
  a KIh;
  int KIi;
  private int KIj;
  long KIk;
  private long KIl;
  private long KIm;
  private int KIn;
  private b KIo;
  private final Object KIp;
  final String TAG;
  private boolean clear;
  private int createTime;
  private String fAg;
  private cvt fVT;
  long iVa;
  int mfA;
  boolean mfC;
  int mfD;
  private int mfE;
  boolean mfF;
  boolean mfG;
  String mfu;
  String mfv;
  int mfw;
  int mfx;
  int mfz;
  int progress;
  int total;
  
  public ap(a parama)
  {
    AppMethodBeat.i(98119);
    this.TAG = ("MicroMsg.OnlineVideoViewHelper[" + hashCode() + ']');
    this.mfw = 0;
    this.mfx = 0;
    this.KIf = null;
    this.mfD = 0;
    this.mfF = false;
    this.mfG = false;
    this.KIj = 0;
    this.clear = false;
    this.KIp = new Object();
    this.KIh = parama;
    this.KIg = new j();
    this.KIf = new HashMap();
    this.KIo = new b((byte)0);
    this.KIo.mfN = com.tencent.mm.n.h.axc().getInt("SnsVideoPreloadSec", 5);
    this.KIo.mfO = com.tencent.mm.n.h.axc().getInt("SnsVideoDownloadSec", 1);
    this.KIo.KIr = com.tencent.mm.n.h.axc().getInt("SnsVideoFullDownloadPercent", 101);
    Log.i(this.TAG, "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.KIo.mfN), Integer.valueOf(this.KIo.mfO), Integer.valueOf(this.KIo.KIr) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void agV(int paramInt)
  {
    AppMethodBeat.i(196823);
    synchronized (this.KIp)
    {
      if (this.KIh != null) {
        this.KIh.agQ(paramInt * 1000);
      }
      AppMethodBeat.o(196823);
      return;
    }
  }
  
  private boolean fUD()
  {
    AppMethodBeat.i(98126);
    synchronized (this.KIp)
    {
      if (this.KIh != null)
      {
        boolean bool = this.KIh.fUl();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void fUF()
  {
    AppMethodBeat.i(98133);
    this.mfC = true;
    if (this.mfD <= 0)
    {
      if (this.mfA == -1)
      {
        this.mfx = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.mfx = 2;
      AppMethodBeat.o(98133);
      return;
    }
    Log.i(this.TAG, "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.mfu, Integer.valueOf(this.KIj), Integer.valueOf(this.mfx) });
    this.KIm = Util.nowMilliSecond();
    if ((this.mfx != 2) && (this.mfx != 4))
    {
      this.mfE += this.KIo.mfN;
      this.mfE = Math.min(this.mfE, 60);
      this.KIj += 1;
      this.mfx = 4;
    }
    this.KIh.bqn();
    AppMethodBeat.o(98133);
  }
  
  private void fUG()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.mfC)
    {
      if ((this.KIj == 0) && (this.KIl == 0L)) {
        fUH();
      }
      for (;;)
      {
        Log.i(this.TAG, "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.KIj), Integer.valueOf(this.KIn), this.mfu });
        this.mfx = 3;
        if (this.mfA == -1) {
          break;
        }
        agU(this.mfA);
        this.mfA = -1;
        this.mfC = false;
        AppMethodBeat.o(98134);
        return;
        if (this.KIm > 0L) {
          this.KIn = ((int)(this.KIn + Util.milliSecondsToNow(this.KIm)));
        }
      }
      if (fUD()) {}
      for (;;)
      {
        this.mfC = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.mfx != 3)
    {
      Log.i(this.TAG, "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.mfx) });
      if (!fUD()) {
        break label215;
      }
    }
    label215:
    for (int i = 3;; i = this.mfx)
    {
      this.mfx = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] fUI()
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
      synchronized (this.KIp)
      {
        if (this.KIh == null) {
          break label457;
        }
        n = this.KIh.getPlayVideoDuration();
        m = this.KIh.getUiStayTime();
        k = this.KIh.getPlayErrorCode();
        j = this.KIh.getRptStruct().scene;
        str4 = this.KIh.getRptStruct().sessionId;
        l = this.KIh.getRptStruct().KHs;
        str3 = this.KIh.getRptStruct().fLp;
        str2 = this.KIh.getRptStruct().fLm;
        str1 = this.KIh.getRptStruct().filePath;
        i = this.KIh.getPlayVideoDurationByResume();
        arrayOfObject[0] = Integer.valueOf(n);
        if (this.KIl <= 0L) {
          this.KIl = Util.nowMilliSecond();
        }
        int i1 = (int)(this.KIl - this.iVa);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[1] = Integer.valueOf(n);
        if (this.KIk <= 0L) {
          this.KIk = Util.nowMilliSecond();
        }
        i1 = (int)(this.KIk - this.iVa);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[2] = Integer.valueOf(n);
        arrayOfObject[3] = Integer.valueOf(this.KIj);
        if (this.KIj > 0)
        {
          if (this.KIn == 0) {
            this.KIn = ((int)(this.KIn + Util.milliSecondsToNow(this.KIm)));
          }
          arrayOfObject[4] = Integer.valueOf(this.KIn / this.KIj);
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
  
  private static void fUJ()
  {
    AppMethodBeat.i(98138);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private void fUK()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = fUI();
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
    long l2 = u.bBQ(str3);
    localObject1 = new kz();
    ((kz)localObject1).gHC = i;
    ((kz)localObject1).gki = 0L;
    ((kz)localObject1).gkj = 0L;
    ((kz)localObject1).gJD = l2;
    ((kz)localObject1).BN(str1);
    ((kz)localObject1).BM(str2);
    ((kz)localObject1).gIH = l1;
    ((kz)localObject1).gJF = j;
    ((kz)localObject1).gJG = k;
    ((kz)localObject1).gJH = m;
    ((kz)localObject1).gEV = n;
    ((kz)localObject1).gKa = i1;
    ((kz)localObject1).gKb = i2;
    ((kz)localObject1).gPR = i3;
    ((kz)localObject1).BO((String)localObject2);
    ((kz)localObject1).gPT = i4;
    ((kz)localObject1).bpa();
    AppMethodBeat.o(98139);
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.mfu = "";
    this.mfA = -1;
    this.mfD = 0;
    this.mfz = 0;
    this.KIj = 0;
    this.mfx = 0;
    this.mfw = 0;
    this.mfC = false;
    this.mfF = false;
    this.mfG = false;
    this.KIf.clear();
    this.fVT = null;
    this.createTime = 0;
    this.fAg = null;
    if (this.KIo != null) {
      this.mfE = this.KIo.mfN;
    }
    this.KIk = 0L;
    this.iVa = 0L;
    this.KIn = 0;
    this.KIm = 0L;
    this.KIl = 0L;
    AppMethodBeat.o(98121);
  }
  
  private boolean xb(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.mfw == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.mfD - paramInt <= 1) && (this.mfD < this.mfz))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.KIg.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = s.bqC().isVideoDataAvailable(this.mfu, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.mfD = paramInt;
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
  
  private static void yR(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.mfE;
    }
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
    }
    if ((this.mfx == 3) || (this.mfx == 4))
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (this.mfE + paramInt + 1 + this.KIo.mfO);
    }
    if (paramPInt2.value >= this.mfz + 1) {
      paramPInt2.value = (this.mfz + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.KIo.mfO;
      AppMethodBeat.o(98129);
      return false;
    }
    Log.i(this.TAG, "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  public final boolean a(cvt paramcvt, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.fVT = paramcvt;
    this.createTime = paramInt1;
    this.fAg = paramString;
    this.mfv = ax.E(paramcvt);
    this.mfu = ax.cs(paramInt1, paramcvt.Url);
    if ((Util.isNullOrNil(this.mfv)) || (Util.isNullOrNil(this.mfu)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    Log.i(this.TAG, "start online download video %s isPlayMode %b", new Object[] { this.mfu, Boolean.valueOf(paramBoolean) });
    aj.fOG().a(paramcvt, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.mfw = 1;
    this.iVa = Util.nowMilliSecond();
    yR(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  final void agU(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.KIp)
    {
      if (this.KIh != null) {
        this.KIh.bc(paramInt, true);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  public final boolean bbW(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = Util.isEqual(this.mfu, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    Log.i(this.TAG, "clear");
    this.clear = true;
    reset();
    synchronized (this.KIp)
    {
      this.KIh = null;
      this.KIg = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  public final boolean fUC()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!Util.isNullOrNil(this.mfu)) {
      if (this.mfw == 3)
      {
        bool = true;
        Log.i(this.TAG, "stop online download video %s isFinish %b percent %d", new Object[] { this.mfu, Boolean.valueOf(bool), Integer.valueOf(this.KIi) });
        aj.fOG().p(this.mfu, fUI());
        if ((this.KIi >= this.KIo.KIr) && (!bool)) {
          aj.fOG().a(this.fVT, this.createTime, this.fAg, false, false, 36);
        }
        fUJ();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      fUK();
    }
  }
  
  final void fUE()
  {
    AppMethodBeat.i(98132);
    Log.i(this.TAG, "play offline video %s ", new Object[] { this.mfu });
    fUH();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if ((ap.this.fUm()) && (ap.this.KIh != null)) {
          ap.this.yQ(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void fUH()
  {
    AppMethodBeat.i(98135);
    if (this.KIl == 0L) {
      this.KIl = Util.nowMilliSecond();
    }
    AppMethodBeat.o(98135);
  }
  
  final boolean fUm()
  {
    AppMethodBeat.i(196820);
    synchronized (this.KIp)
    {
      if (this.KIh != null)
      {
        boolean bool = this.KIh.fUm();
        Log.i(this.TAG, "isPlayAllowed: %s", new Object[] { Boolean.toString(bool) });
        bool = this.KIh.fUm();
        AppMethodBeat.o(196820);
        return bool;
      }
      AppMethodBeat.o(196820);
      return false;
    }
  }
  
  final boolean p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(196842);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.KIg.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = s.bqC().isVideoDataAvailable(this.mfu, localPInt1.value, localPInt2.value);
        if (bool) {
          break label382;
        }
        if (!this.KIf.containsKey(this.mfu + 0 + "_-1"))
        {
          String str = this.mfu + localPInt1.value + "_" + localPInt2.value;
          Log.i(this.TAG, "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.mfG), Boolean.valueOf(paramBoolean) });
          if ((this.KIf.containsKey(str)) || ((this.mfG) && (!paramBoolean))) {
            break label361;
          }
          this.mfG = true;
          this.KIf.put(str, Integer.valueOf(paramInt2));
          s.bqC();
          paramInt1 = e.s(this.mfu, localPInt1.value, localPInt2.value);
          if (paramInt1 != 0)
          {
            this.mfG = false;
            this.KIf.remove(str);
            Log.i(this.TAG, "requestVideoData not success %s", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        AppMethodBeat.o(196842);
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
        label361:
        Log.i(this.TAG, "already request video : ".concat(String.valueOf(localException)));
        continue;
        label382:
        Log.i(this.TAG, "already had video data.");
      }
    }
  }
  
  public final boolean xa(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.mfA != -1) {}
    for (int i = this.mfA;; i = paramInt)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      Log.i(this.TAG, "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.mfD), Integer.valueOf(this.mfz), Integer.valueOf(this.mfx), Integer.valueOf(this.mfw), this.mfu, Long.valueOf(this.KIl - this.iVa), Boolean.valueOf(this.mfF) });
      if (this.KIh == null)
      {
        Log.i(this.TAG, "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      boolean bool1;
      switch (this.mfw)
      {
      default: 
        Log.w(this.TAG, "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!xb(i))
        {
          fUF();
          bool1 = false;
        }
        for (;;)
        {
          agV(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label405;
          }
          if (!p(localPInt1.value, localPInt2.value, false)) {
            break;
          }
          this.mfD = Math.max(this.mfD, localPInt2.value);
          bool1 = true;
          break;
          fUH();
          if (this.mfF)
          {
            agV(i);
            bool1 = bool3;
            if (fUm())
            {
              fUG();
              bool1 = bool3;
            }
          }
          else
          {
            Log.i(this.TAG, "prepare cdnMediaId [%s]", new Object[] { this.mfu });
            if (this.mfx == 5) {
              this.mfx = 1;
            }
            bool1 = bool3;
            if (fUm())
            {
              yQ(true);
              this.mfF = true;
              bool1 = bool3;
            }
          }
        }
        label405:
        Log.d(this.TAG, "can not calc download.");
        s.bqC();
        e.s(this.mfu, 0, -1);
        continue;
        fUH();
        if (this.mfF)
        {
          if (this.mfC)
          {
            if (this.mfA == -1) {
              break label494;
            }
            agU(this.mfA);
            this.mfA = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.mfC = bool1;
            this.mfx = 3;
            agV(i);
            bool1 = bool2;
            break;
            label494:
            if (fUD()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.mfx == 5) {
          this.mfx = 1;
        }
        bool1 = bool2;
        if (fUm())
        {
          yQ(false);
          this.mfF = true;
          bool1 = bool2;
          continue;
          Log.w(this.TAG, "download error.");
          bool1 = bool2;
        }
      }
    }
  }
  
  final void yQ(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.KIp)
    {
      if (this.KIh != null) {
        this.KIh.cD(this.mfv, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void agQ(int paramInt);
    
    public abstract void bc(int paramInt, boolean paramBoolean);
    
    public abstract void bqn();
    
    public abstract void cD(String paramString, boolean paramBoolean);
    
    public abstract boolean fUl();
    
    public abstract boolean fUm();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract ap.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int KIr;
    int mfN;
    int mfO;
  }
  
  public static class c
  {
    public long KHs = 0L;
    public String fLm = "";
    public String fLp = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */