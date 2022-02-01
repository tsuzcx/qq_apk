package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class ak
{
  private boolean clear;
  private byn dIQ;
  private String doX;
  long fJC;
  private int hZE;
  int ieH;
  String irM;
  String irN;
  int irP;
  int irQ;
  int irS;
  int irT;
  boolean irV;
  int irW;
  private int irX;
  boolean irY;
  boolean irZ;
  int progress;
  private long zUA;
  private long zUB;
  private int zUC;
  private b zUD;
  private final Object zUE;
  HashMap<String, Integer> zUu;
  j zUv;
  a zUw;
  int zUx;
  private int zUy;
  long zUz;
  
  public ak(a parama)
  {
    AppMethodBeat.i(98119);
    this.irP = 0;
    this.irQ = 0;
    this.zUu = null;
    this.irW = 0;
    this.irY = false;
    this.irZ = false;
    this.zUy = 0;
    this.clear = false;
    this.zUE = new Object();
    this.zUw = parama;
    this.zUv = new j();
    this.zUu = new HashMap();
    this.zUD = new b((byte)0);
    this.zUD.isg = com.tencent.mm.n.g.acA().getInt("SnsVideoPreloadSec", 5);
    this.zUD.ish = com.tencent.mm.n.g.acA().getInt("SnsVideoDownloadSec", 1);
    this.zUD.zUG = com.tencent.mm.n.g.acA().getInt("SnsVideoFullDownloadPercent", 101);
    ad.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.zUD.isg), Integer.valueOf(this.zUD.ish), Integer.valueOf(this.zUD.zUG) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void QY(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.zUE)
    {
      if (this.zUw != null) {
        this.zUw.aB(paramInt, true);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  private void QZ(int paramInt)
  {
    AppMethodBeat.i(198214);
    synchronized (this.zUE)
    {
      if (this.zUw != null) {
        this.zUw.QW(paramInt);
      }
      AppMethodBeat.o(198214);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.irW);
    if (this.irQ == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.irX;
    }
    if (this.irQ == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.irX + 8);
    }
    if ((this.irQ == 3) || (this.irQ == 4))
    {
      paramPInt1.value = this.irW;
      paramPInt2.value = (this.irX + paramInt + 1 + this.zUD.ish);
    }
    if (paramPInt2.value >= this.irS + 1) {
      paramPInt2.value = (this.irS + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.zUD.ish;
      AppMethodBeat.o(98129);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  private boolean eaA()
  {
    AppMethodBeat.i(98126);
    synchronized (this.zUE)
    {
      if (this.zUw != null)
      {
        boolean bool = this.zUw.eap();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void eaC()
  {
    AppMethodBeat.i(98133);
    this.irV = true;
    if (this.irW <= 0)
    {
      if (this.irT == -1)
      {
        this.irQ = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.irQ = 2;
      AppMethodBeat.o(98133);
      return;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.irM, Integer.valueOf(this.zUy), Integer.valueOf(this.irQ) });
    this.zUB = bt.flT();
    if ((this.irQ != 2) && (this.irQ != 4))
    {
      this.irX += this.zUD.isg;
      this.irX = Math.min(this.irX, 60);
      this.zUy += 1;
      this.irQ = 4;
    }
    this.zUw.aMw();
    AppMethodBeat.o(98133);
  }
  
  private void eaD()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.irV)
    {
      if ((this.zUy == 0) && (this.zUA == 0L)) {
        eaE();
      }
      for (;;)
      {
        ad.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.zUy), Integer.valueOf(this.zUC), this.irM });
        this.irQ = 3;
        if (this.irT == -1) {
          break;
        }
        QY(this.irT);
        this.irT = -1;
        this.irV = false;
        AppMethodBeat.o(98134);
        return;
        if (this.zUB > 0L) {
          this.zUC = ((int)(this.zUC + bt.Df(this.zUB)));
        }
      }
      if (eaA()) {}
      for (;;)
      {
        this.irV = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.irQ != 3)
    {
      ad.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.irQ) });
      if (!eaA()) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = this.irQ)
    {
      this.irQ = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] eaF()
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
      synchronized (this.zUE)
      {
        if (this.zUw == null) {
          break label457;
        }
        n = this.zUw.getPlayVideoDuration();
        m = this.zUw.getUiStayTime();
        k = this.zUw.getPlayErrorCode();
        j = this.zUw.getRptStruct().scene;
        str4 = this.zUw.getRptStruct().sessionId;
        l = this.zUw.getRptStruct().zUa;
        str3 = this.zUw.getRptStruct().dzb;
        str2 = this.zUw.getRptStruct().dyY;
        str1 = this.zUw.getRptStruct().filePath;
        i = this.zUw.getPlayVideoDurationByResume();
        arrayOfObject[0] = Integer.valueOf(n);
        if (this.zUA <= 0L) {
          this.zUA = bt.flT();
        }
        int i1 = (int)(this.zUA - this.fJC);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[1] = Integer.valueOf(n);
        if (this.zUz <= 0L) {
          this.zUz = bt.flT();
        }
        i1 = (int)(this.zUz - this.fJC);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[2] = Integer.valueOf(n);
        arrayOfObject[3] = Integer.valueOf(this.zUy);
        if (this.zUy > 0)
        {
          if (this.zUC == 0) {
            this.zUC = ((int)(this.zUC + bt.Df(this.zUB)));
          }
          arrayOfObject[4] = Integer.valueOf(this.zUC / this.zUy);
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
  
  private static void eaG()
  {
    AppMethodBeat.i(98138);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private boolean hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98131);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.zUv.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.aMK().isVideoDataAvailable(this.irM, localPInt1.value, localPInt2.value);
        if (bool) {
          break label365;
        }
        if (!this.zUu.containsKey(this.irM + 0 + "_-1"))
        {
          String str = this.irM + localPInt1.value + "_" + localPInt2.value;
          ad.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.irZ), Boolean.FALSE });
          if ((this.zUu.containsKey(str)) || (this.irZ)) {
            break label346;
          }
          this.irZ = true;
          this.zUu.put(str, Integer.valueOf(paramInt2));
          o.aMK();
          paramInt1 = com.tencent.mm.ao.e.r(this.irM, localPInt1.value, localPInt2.value);
          if (paramInt1 != 0)
          {
            this.irZ = false;
            this.zUu.remove(str);
            ad.i("MicroMsg.OnlineVideoViewHelper", "requestVideoData not success %s", new Object[] { Integer.valueOf(paramInt1) });
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
        ad.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label346:
        ad.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label365:
        ad.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
      }
    }
  }
  
  private boolean qj(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.irP == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.irW - paramInt <= 1) && (this.irW < this.irS))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.zUv.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = o.aMK().isVideoDataAvailable(this.irM, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.irW = paramInt;
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
  
  private static void rK(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.irM = "";
    this.irT = -1;
    this.irW = 0;
    this.irS = 0;
    this.zUy = 0;
    this.irQ = 0;
    this.irP = 0;
    this.irV = false;
    this.irY = false;
    this.irZ = false;
    this.zUu.clear();
    this.dIQ = null;
    this.hZE = 0;
    this.doX = null;
    if (this.zUD != null) {
      this.irX = this.zUD.isg;
    }
    this.zUz = 0L;
    this.fJC = 0L;
    this.zUC = 0;
    this.zUB = 0L;
    this.zUA = 0L;
    AppMethodBeat.o(98121);
  }
  
  public final boolean a(byn parambyn, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.dIQ = parambyn;
    this.hZE = paramInt1;
    this.doX = paramString;
    this.irN = av.D(parambyn);
    this.irM = av.cb(paramInt1, parambyn.Url);
    if ((bt.isNullOrNil(this.irN)) || (bt.isNullOrNil(this.irM)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    ad.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { this.irM, Boolean.valueOf(paramBoolean) });
    ag.dUc().a(parambyn, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.irP = 1;
    this.fJC = bt.flT();
    rK(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  public final boolean aAK(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = bt.lQ(this.irM, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    ad.i("MicroMsg.OnlineVideoViewHelper", "clear");
    this.clear = true;
    reset();
    synchronized (this.zUE)
    {
      this.zUw = null;
      this.zUv = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  final void eaB()
  {
    AppMethodBeat.i(98132);
    ad.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.irM });
    eaE();
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if (ak.this.zUw != null) {
          ak.this.rJ(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void eaE()
  {
    AppMethodBeat.i(98135);
    if (this.zUA == 0L) {
      this.zUA = bt.flT();
    }
    AppMethodBeat.o(98135);
  }
  
  public final void eaH()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = eaF();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = ay.iS(aj.getContext());
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
    long l2 = i.aYo(str3);
    localObject1 = new fd();
    ((fd)localObject1).ega = i;
    ((fd)localObject1).dTt = 0L;
    ((fd)localObject1).dTu = 0L;
    ((fd)localObject1).efT = l2;
    ((fd)localObject1).ol(str1);
    ((fd)localObject1).ok(str2);
    ((fd)localObject1).efV = l1;
    ((fd)localObject1).efW = j;
    ((fd)localObject1).efX = k;
    ((fd)localObject1).efY = m;
    ((fd)localObject1).efZ = n;
    ((fd)localObject1).egu = i1;
    ((fd)localObject1).egv = i2;
    ((fd)localObject1).ekq = i3;
    ((fd)localObject1).om((String)localObject2);
    ((fd)localObject1).eks = i4;
    ((fd)localObject1).aLk();
    AppMethodBeat.o(98139);
  }
  
  public final boolean eaz()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!bt.isNullOrNil(this.irM)) {
      if (this.irP == 3)
      {
        bool = true;
        ad.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.irM, Boolean.valueOf(bool), Integer.valueOf(this.zUx) });
        ag.dUc().s(this.irM, eaF());
        if ((this.zUx >= this.zUD.zUG) && (!bool)) {
          ag.dUc().a(this.dIQ, this.hZE, this.doX, false, false, 36);
        }
        eaG();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      eaH();
    }
  }
  
  public final boolean qi(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.irT != -1) {}
    for (int i = this.irT;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      ad.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.irW), Integer.valueOf(this.irS), Integer.valueOf(this.irQ), Integer.valueOf(this.irP), this.irM, Long.valueOf(this.zUA - this.fJC), Boolean.valueOf(this.irY) });
      if (this.zUw == null)
      {
        ad.i("MicroMsg.OnlineVideoViewHelper", "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      switch (this.irP)
      {
      default: 
        ad.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!qj(i))
        {
          eaC();
          bool1 = false;
        }
        for (;;)
        {
          QZ(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label370;
          }
          if (!hM(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.irW = Math.max(this.irW, localPInt2.value);
          bool1 = true;
          break;
          eaE();
          if (this.irY)
          {
            QZ(i);
            eaD();
          }
          else
          {
            ad.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.irM });
            if (this.irQ == 5) {
              this.irQ = 1;
            }
            rJ(true);
            this.irY = true;
          }
        }
        label370:
        ad.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        o.aMK();
        com.tencent.mm.ao.e.r(this.irM, 0, -1);
        continue;
        eaE();
        if (this.irY)
        {
          if (this.irV)
          {
            if (this.irT == -1) {
              break label457;
            }
            QY(this.irT);
            this.irT = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.irV = bool1;
            this.irQ = 3;
            QZ(i);
            bool1 = bool2;
            break;
            label457:
            if (eaA()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.irQ == 5) {
          this.irQ = 1;
        }
        rJ(false);
        this.irY = true;
        bool1 = bool2;
        continue;
        ad.w("MicroMsg.OnlineVideoViewHelper", "download error.");
        bool1 = bool2;
      }
    }
  }
  
  final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.zUE)
    {
      if (this.zUw != null) {
        this.zUw.bU(this.irN, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void QW(int paramInt);
    
    public abstract void aB(int paramInt, boolean paramBoolean);
    
    public abstract void aMw();
    
    public abstract void bU(String paramString, boolean paramBoolean);
    
    public abstract boolean eap();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract ak.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int isg;
    int ish;
    int zUG;
  }
  
  public static final class c
  {
    public String dyY = "";
    public String dzb = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
    public long zUa = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */