package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class ak
{
  HashMap<String, Integer> AlC;
  j AlD;
  a AlE;
  int AlF;
  private int AlG;
  long AlH;
  private long AlI;
  private long AlJ;
  private int AlK;
  private b AlL;
  private final Object AlM;
  private boolean clear;
  private bzh dKe;
  private String dqc;
  long fLF;
  private int icw;
  int ihz;
  String iuG;
  String iuH;
  int iuJ;
  int iuK;
  int iuM;
  int iuN;
  boolean iuP;
  int iuQ;
  private int iuR;
  boolean iuS;
  boolean iuT;
  int progress;
  
  public ak(a parama)
  {
    AppMethodBeat.i(98119);
    this.iuJ = 0;
    this.iuK = 0;
    this.AlC = null;
    this.iuQ = 0;
    this.iuS = false;
    this.iuT = false;
    this.AlG = 0;
    this.clear = false;
    this.AlM = new Object();
    this.AlE = parama;
    this.AlD = new j();
    this.AlC = new HashMap();
    this.AlL = new b((byte)0);
    this.AlL.iva = com.tencent.mm.n.g.acL().getInt("SnsVideoPreloadSec", 5);
    this.AlL.ivb = com.tencent.mm.n.g.acL().getInt("SnsVideoDownloadSec", 1);
    this.AlL.AlO = com.tencent.mm.n.g.acL().getInt("SnsVideoFullDownloadPercent", 101);
    ae.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.AlL.iva), Integer.valueOf(this.AlL.ivb), Integer.valueOf(this.AlL.AlO) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private void RF(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.AlM)
    {
      if (this.AlE != null) {
        this.AlE.aE(paramInt, true);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  private void RG(int paramInt)
  {
    AppMethodBeat.i(219742);
    synchronized (this.AlM)
    {
      if (this.AlE != null) {
        this.AlE.RD(paramInt);
      }
      AppMethodBeat.o(219742);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    if (this.iuK == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.iuR;
    }
    if (this.iuK == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.iuR + 8);
    }
    if ((this.iuK == 3) || (this.iuK == 4))
    {
      paramPInt1.value = this.iuQ;
      paramPInt2.value = (this.iuR + paramInt + 1 + this.AlL.ivb);
    }
    if (paramPInt2.value >= this.iuM + 1) {
      paramPInt2.value = (this.iuM + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.AlL.ivb;
      AppMethodBeat.o(98129);
      return false;
    }
    ae.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  private boolean eeg()
  {
    AppMethodBeat.i(98126);
    synchronized (this.AlM)
    {
      if (this.AlE != null)
      {
        boolean bool = this.AlE.edV();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void eei()
  {
    AppMethodBeat.i(98133);
    this.iuP = true;
    if (this.iuQ <= 0)
    {
      if (this.iuN == -1)
      {
        this.iuK = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.iuK = 2;
      AppMethodBeat.o(98133);
      return;
    }
    ae.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.iuG, Integer.valueOf(this.AlG), Integer.valueOf(this.iuK) });
    this.AlJ = bu.fpO();
    if ((this.iuK != 2) && (this.iuK != 4))
    {
      this.iuR += this.AlL.iva;
      this.iuR = Math.min(this.iuR, 60);
      this.AlG += 1;
      this.iuK = 4;
    }
    this.AlE.aMU();
    AppMethodBeat.o(98133);
  }
  
  private void eej()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.iuP)
    {
      if ((this.AlG == 0) && (this.AlI == 0L)) {
        eek();
      }
      for (;;)
      {
        ae.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.AlG), Integer.valueOf(this.AlK), this.iuG });
        this.iuK = 3;
        if (this.iuN == -1) {
          break;
        }
        RF(this.iuN);
        this.iuN = -1;
        this.iuP = false;
        AppMethodBeat.o(98134);
        return;
        if (this.AlJ > 0L) {
          this.AlK = ((int)(this.AlK + bu.DD(this.AlJ)));
        }
      }
      if (eeg()) {}
      for (;;)
      {
        this.iuP = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.iuK != 3)
    {
      ae.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.iuK) });
      if (!eeg()) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = this.iuK)
    {
      this.iuK = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] eel()
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
      synchronized (this.AlM)
      {
        if (this.AlE == null) {
          break label457;
        }
        n = this.AlE.getPlayVideoDuration();
        m = this.AlE.getUiStayTime();
        k = this.AlE.getPlayErrorCode();
        j = this.AlE.getRptStruct().scene;
        str4 = this.AlE.getRptStruct().sessionId;
        l = this.AlE.getRptStruct().Alh;
        str3 = this.AlE.getRptStruct().dAg;
        str2 = this.AlE.getRptStruct().dAd;
        str1 = this.AlE.getRptStruct().filePath;
        i = this.AlE.getPlayVideoDurationByResume();
        arrayOfObject[0] = Integer.valueOf(n);
        if (this.AlI <= 0L) {
          this.AlI = bu.fpO();
        }
        int i1 = (int)(this.AlI - this.fLF);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[1] = Integer.valueOf(n);
        if (this.AlH <= 0L) {
          this.AlH = bu.fpO();
        }
        i1 = (int)(this.AlH - this.fLF);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[2] = Integer.valueOf(n);
        arrayOfObject[3] = Integer.valueOf(this.AlG);
        if (this.AlG > 0)
        {
          if (this.AlK == 0) {
            this.AlK = ((int)(this.AlK + bu.DD(this.AlJ)));
          }
          arrayOfObject[4] = Integer.valueOf(this.AlK / this.AlG);
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
  
  private static void eem()
  {
    AppMethodBeat.i(98138);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private boolean hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98131);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.AlD.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(this.iuG, localPInt1.value, localPInt2.value);
        if (bool) {
          break label365;
        }
        if (!this.AlC.containsKey(this.iuG + 0 + "_-1"))
        {
          String str = this.iuG + localPInt1.value + "_" + localPInt2.value;
          ae.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.iuT), Boolean.FALSE });
          if ((this.AlC.containsKey(str)) || (this.iuT)) {
            break label346;
          }
          this.iuT = true;
          this.AlC.put(str, Integer.valueOf(paramInt2));
          com.tencent.mm.modelvideo.o.aNi();
          paramInt1 = com.tencent.mm.an.e.r(this.iuG, localPInt1.value, localPInt2.value);
          if (paramInt1 != 0)
          {
            this.iuT = false;
            this.AlC.remove(str);
            ae.i("MicroMsg.OnlineVideoViewHelper", "requestVideoData not success %s", new Object[] { Integer.valueOf(paramInt1) });
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
        ae.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label346:
        ae.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label365:
        ae.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
      }
    }
  }
  
  private boolean qm(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.iuJ == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.iuQ - paramInt <= 1) && (this.iuQ < this.iuM))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.AlD.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(this.iuG, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.iuQ = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(98130);
    return bool1;
  }
  
  private static void rR(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.iuG = "";
    this.iuN = -1;
    this.iuQ = 0;
    this.iuM = 0;
    this.AlG = 0;
    this.iuK = 0;
    this.iuJ = 0;
    this.iuP = false;
    this.iuS = false;
    this.iuT = false;
    this.AlC.clear();
    this.dKe = null;
    this.icw = 0;
    this.dqc = null;
    if (this.AlL != null) {
      this.iuR = this.AlL.iva;
    }
    this.AlH = 0L;
    this.fLF = 0L;
    this.AlK = 0;
    this.AlJ = 0L;
    this.AlI = 0L;
    AppMethodBeat.o(98121);
  }
  
  public final boolean a(bzh parambzh, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.dKe = parambzh;
    this.icw = paramInt1;
    this.dqc = paramString;
    this.iuH = aw.D(parambzh);
    this.iuG = aw.cb(paramInt1, parambzh.Url);
    if ((bu.isNullOrNil(this.iuH)) || (bu.isNullOrNil(this.iuG)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    ae.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { this.iuG, Boolean.valueOf(paramBoolean) });
    ah.dXC().a(parambzh, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.iuJ = 1;
    this.fLF = bu.fpO();
    rR(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  public final boolean aCb(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = bu.lX(this.iuG, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    ae.i("MicroMsg.OnlineVideoViewHelper", "clear");
    this.clear = true;
    reset();
    synchronized (this.AlM)
    {
      this.AlE = null;
      this.AlD = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  public final boolean eef()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!bu.isNullOrNil(this.iuG)) {
      if (this.iuJ == 3)
      {
        bool = true;
        ae.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.iuG, Boolean.valueOf(bool), Integer.valueOf(this.AlF) });
        ah.dXC().s(this.iuG, eel());
        if ((this.AlF >= this.AlL.AlO) && (!bool)) {
          ah.dXC().a(this.dKe, this.icw, this.dqc, false, false, 36);
        }
        eem();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      een();
    }
  }
  
  final void eeh()
  {
    AppMethodBeat.i(98132);
    ae.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.iuG });
    eek();
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if (ak.this.AlE != null) {
          ak.this.rQ(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void eek()
  {
    AppMethodBeat.i(98135);
    if (this.AlI == 0L) {
      this.AlI = bu.fpO();
    }
    AppMethodBeat.o(98135);
  }
  
  public final void een()
  {
    AppMethodBeat.i(98139);
    Object localObject1 = eel();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = az.iX(com.tencent.mm.sdk.platformtools.ak.getContext());
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
    long l2 = com.tencent.mm.vfs.o.aZR(str3);
    localObject1 = new ff();
    ((ff)localObject1).ehL = i;
    ((ff)localObject1).dUJ = 0L;
    ((ff)localObject1).dUK = 0L;
    ((ff)localObject1).ehE = l2;
    ((ff)localObject1).oG(str1);
    ((ff)localObject1).oF(str2);
    ((ff)localObject1).ehG = l1;
    ((ff)localObject1).ehH = j;
    ((ff)localObject1).ehI = k;
    ((ff)localObject1).ehJ = m;
    ((ff)localObject1).ehK = n;
    ((ff)localObject1).eie = i1;
    ((ff)localObject1).eif = i2;
    ((ff)localObject1).elX = i3;
    ((ff)localObject1).oH((String)localObject2);
    ((ff)localObject1).elZ = i4;
    ((ff)localObject1).aLH();
    AppMethodBeat.o(98139);
  }
  
  public final boolean ql(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.iuN != -1) {}
    for (int i = this.iuN;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      ae.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuM), Integer.valueOf(this.iuK), Integer.valueOf(this.iuJ), this.iuG, Long.valueOf(this.AlI - this.fLF), Boolean.valueOf(this.iuS) });
      if (this.AlE == null)
      {
        ae.i("MicroMsg.OnlineVideoViewHelper", "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      switch (this.iuJ)
      {
      default: 
        ae.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!qm(i))
        {
          eei();
          bool1 = false;
        }
        for (;;)
        {
          RG(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label370;
          }
          if (!hP(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.iuQ = Math.max(this.iuQ, localPInt2.value);
          bool1 = true;
          break;
          eek();
          if (this.iuS)
          {
            RG(i);
            eej();
          }
          else
          {
            ae.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.iuG });
            if (this.iuK == 5) {
              this.iuK = 1;
            }
            rQ(true);
            this.iuS = true;
          }
        }
        label370:
        ae.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        com.tencent.mm.modelvideo.o.aNi();
        com.tencent.mm.an.e.r(this.iuG, 0, -1);
        continue;
        eek();
        if (this.iuS)
        {
          if (this.iuP)
          {
            if (this.iuN == -1) {
              break label457;
            }
            RF(this.iuN);
            this.iuN = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.iuP = bool1;
            this.iuK = 3;
            RG(i);
            bool1 = bool2;
            break;
            label457:
            if (eeg()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.iuK == 5) {
          this.iuK = 1;
        }
        rQ(false);
        this.iuS = true;
        bool1 = bool2;
        continue;
        ae.w("MicroMsg.OnlineVideoViewHelper", "download error.");
        bool1 = bool2;
      }
    }
  }
  
  final void rQ(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.AlM)
    {
      if (this.AlE != null) {
        this.AlE.bY(this.iuH, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void RD(int paramInt);
    
    public abstract void aE(int paramInt, boolean paramBoolean);
    
    public abstract void aMU();
    
    public abstract void bY(String paramString, boolean paramBoolean);
    
    public abstract boolean edV();
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract ak.c getRptStruct();
    
    public abstract int getUiStayTime();
  }
  
  static final class b
  {
    int AlO;
    int iva;
    int ivb;
  }
  
  public static final class c
  {
    public long Alh = 0L;
    public String dAd = "";
    public String dAg = "";
    public String filePath = "";
    public int scene = 0;
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak
 * JD-Core Version:    0.7.0.1
 */