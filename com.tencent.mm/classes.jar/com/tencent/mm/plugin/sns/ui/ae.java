package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.m.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class ae
{
  private bcs cIc;
  private boolean clear;
  private String crk;
  long edG;
  private int fDT;
  String fVf;
  String fVg;
  int fVi;
  int fVj;
  f fVk;
  int fVl;
  int fVm;
  boolean fVo;
  int fVp;
  private int fVq;
  boolean fVr;
  boolean fVs;
  int progress;
  HashMap<String, Integer> rJI;
  ae.a rJJ;
  int rJK;
  private int rJL;
  long rJM;
  private long rJN;
  private long rJO;
  private int rJP;
  private ae.b rJQ;
  private final Object rJR;
  int total;
  
  public ae(ae.a parama)
  {
    AppMethodBeat.i(38451);
    this.fVi = 0;
    this.fVj = 0;
    this.rJI = null;
    this.fVp = 0;
    this.fVr = false;
    this.fVs = false;
    this.rJL = 0;
    this.clear = false;
    this.rJR = new Object();
    this.rJJ = parama;
    this.fVk = new f();
    this.rJI = new HashMap();
    this.rJQ = new ae.b((byte)0);
    this.rJQ.fVz = g.Nq().getInt("SnsVideoPreloadSec", 5);
    this.rJQ.fVA = g.Nq().getInt("SnsVideoDownloadSec", 1);
    this.rJQ.rJT = g.Nq().getInt("SnsVideoFullDownloadPercent", 101);
    ab.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.rJQ.fVz), Integer.valueOf(this.rJQ.fVA), Integer.valueOf(this.rJQ.rJT) });
    reset();
    this.clear = false;
    AppMethodBeat.o(38451);
  }
  
  private void EI(int paramInt)
  {
    AppMethodBeat.i(155726);
    synchronized (this.rJR)
    {
      if (this.rJJ != null) {
        this.rJJ.zi(paramInt);
      }
      AppMethodBeat.o(155726);
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(38458);
    paramPInt1.value = Math.max(paramInt, this.fVp);
    if (this.fVj == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.fVq;
    }
    if (this.fVj == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.fVq + 8);
    }
    if ((this.fVj == 3) || (this.fVj == 4))
    {
      paramPInt1.value = this.fVp;
      paramPInt2.value = (this.fVq + paramInt + 1 + this.rJQ.fVA);
    }
    if (paramPInt2.value >= this.fVl + 1) {
      paramPInt2.value = (this.fVl + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.rJQ.fVA;
      AppMethodBeat.o(38458);
      return false;
    }
    ab.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.fVj), Integer.valueOf(this.fVp), Integer.valueOf(this.fVq) });
    AppMethodBeat.o(38458);
    return true;
  }
  
  private boolean cug()
  {
    AppMethodBeat.i(155725);
    synchronized (this.rJR)
    {
      if (this.rJJ != null)
      {
        boolean bool = this.rJJ.ctX();
        AppMethodBeat.o(155725);
        return bool;
      }
      AppMethodBeat.o(155725);
      return true;
    }
  }
  
  private void cui()
  {
    AppMethodBeat.i(38462);
    this.fVo = true;
    if (this.fVp <= 0)
    {
      if (this.fVm == -1)
      {
        this.fVj = 1;
        AppMethodBeat.o(38462);
        return;
      }
      this.fVj = 2;
      AppMethodBeat.o(38462);
      return;
    }
    ab.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.fVf, Integer.valueOf(this.rJL), Integer.valueOf(this.fVj) });
    this.rJO = bo.aoy();
    if ((this.fVj != 2) && (this.fVj != 4))
    {
      this.fVq += this.rJQ.fVz;
      this.fVq = Math.min(this.fVq, 60);
      this.rJL += 1;
      this.fVj = 4;
    }
    this.rJJ.alq();
    AppMethodBeat.o(38462);
  }
  
  private void cuj()
  {
    boolean bool = false;
    AppMethodBeat.i(38463);
    if (this.fVo)
    {
      if ((this.rJL == 0) && (this.rJN == 0L)) {
        cuk();
      }
      for (;;)
      {
        ab.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.rJL), Integer.valueOf(this.rJP), this.fVf });
        this.fVj = 3;
        if (this.fVm == -1) {
          break;
        }
        EI(this.fVm);
        this.fVm = -1;
        this.fVo = false;
        AppMethodBeat.o(38463);
        return;
        if (this.rJO > 0L) {
          this.rJP = ((int)(this.rJP + bo.hl(this.rJO)));
        }
      }
      if (cug()) {}
      for (;;)
      {
        this.fVo = bool;
        AppMethodBeat.o(38463);
        return;
        bool = true;
      }
    }
    if (this.fVj != 3)
    {
      ab.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.fVj) });
      if (!cug()) {
        break label211;
      }
    }
    label211:
    for (int i = 3;; i = this.fVj)
    {
      this.fVj = i;
      AppMethodBeat.o(38463);
      return;
    }
  }
  
  private Object[] cul()
  {
    AppMethodBeat.i(38465);
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
    if (this.rJJ != null)
    {
      n = this.rJJ.getPlayVideoDuration();
      m = this.rJJ.getUiStayTime();
      k = this.rJJ.getPlayErrorCode();
      j = this.rJJ.getRptStruct().scene;
      str4 = this.rJJ.getRptStruct().cpW;
      l = this.rJJ.getRptStruct().rJq;
      str3 = this.rJJ.getRptStruct().czw;
      str2 = this.rJJ.getRptStruct().czt;
      str1 = this.rJJ.getRptStruct().filePath;
      i = this.rJJ.getPlayVideoDurationByResume();
    }
    arrayOfObject[0] = Integer.valueOf(n);
    if (this.rJN <= 0L) {
      this.rJN = bo.aoy();
    }
    int i1 = (int)(this.rJN - this.edG);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[1] = Integer.valueOf(n);
    if (this.rJM <= 0L) {
      this.rJM = bo.aoy();
    }
    i1 = (int)(this.rJM - this.edG);
    n = i1;
    if (i1 <= 0) {
      n = 0;
    }
    arrayOfObject[2] = Integer.valueOf(n);
    arrayOfObject[3] = Integer.valueOf(this.rJL);
    if (this.rJL > 0)
    {
      if (this.rJP == 0) {
        this.rJP = ((int)(this.rJP + bo.hl(this.rJO)));
      }
      arrayOfObject[4] = Integer.valueOf(this.rJP / this.rJL);
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
      AppMethodBeat.o(38465);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
    }
  }
  
  private static void cum()
  {
    AppMethodBeat.i(38467);
    h.qsU.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(38467);
  }
  
  private boolean fG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38460);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.fVk.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = o.alF().isVideoDataAvailable(this.fVf, localPInt1.value, localPInt2.value);
        if (bool) {
          break label327;
        }
        if (!this.rJI.containsKey(this.fVf + 0 + "_-1"))
        {
          String str = this.fVf + localPInt1.value + "_" + localPInt2.value;
          ab.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.fVs), Boolean.FALSE });
          if ((this.rJI.containsKey(str)) || (this.fVs)) {
            break label308;
          }
          this.fVs = true;
          o.alF();
          com.tencent.mm.al.e.r(this.fVf, localPInt1.value, localPInt2.value);
          this.rJI.put(str, Integer.valueOf(paramInt2));
        }
        AppMethodBeat.o(38460);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label308:
        ab.i("MicroMsg.OnlineVideoViewHelper", "already request video : ".concat(String.valueOf(localException)));
        continue;
        label327:
        ab.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
      }
    }
  }
  
  private static void lx(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (paramBoolean)
    {
      h.qsU.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(38466);
      return;
    }
    h.qsU.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(38466);
  }
  
  private boolean mk(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(38459);
    if (this.fVi == 3)
    {
      AppMethodBeat.o(38459);
      return true;
    }
    if ((this.fVp - paramInt <= 1) && (this.fVp < this.fVl))
    {
      AppMethodBeat.o(38459);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.fVk.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = o.alF().isVideoDataAvailable(this.fVf, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.fVp = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(38459);
    return bool1;
  }
  
  private void reset()
  {
    AppMethodBeat.i(38453);
    this.fVf = "";
    this.fVm = -1;
    this.fVp = 0;
    this.fVl = 0;
    this.rJL = 0;
    this.fVj = 0;
    this.fVi = 0;
    this.fVo = false;
    this.fVr = false;
    this.fVs = false;
    this.rJI.clear();
    this.cIc = null;
    this.fDT = 0;
    this.crk = null;
    if (this.rJQ != null) {
      this.fVq = this.rJQ.fVz;
    }
    this.rJM = 0L;
    this.edG = 0L;
    this.rJP = 0;
    this.rJO = 0L;
    this.rJN = 0L;
    AppMethodBeat.o(38453);
  }
  
  public final boolean a(bcs parambcs, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(38454);
    if (this.clear)
    {
      AppMethodBeat.o(38454);
      return false;
    }
    this.cIc = parambcs;
    this.fDT = paramInt1;
    this.crk = paramString;
    this.fVg = ar.D(parambcs);
    this.fVf = ar.be(paramInt1, parambcs.Url);
    if ((bo.isNullOrNil(this.fVg)) || (bo.isNullOrNil(this.fVf)))
    {
      AppMethodBeat.o(38454);
      return false;
    }
    ab.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { this.fVf, Boolean.valueOf(paramBoolean) });
    ag.cpd().a(parambcs, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.fVi = 1;
    this.edG = bo.aoy();
    lx(paramBoolean);
    AppMethodBeat.o(38454);
    return true;
  }
  
  public final boolean acc(String paramString)
  {
    AppMethodBeat.i(38456);
    boolean bool = bo.isEqual(this.fVf, paramString);
    AppMethodBeat.o(38456);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(38452);
    ab.i("MicroMsg.OnlineVideoViewHelper", "clear");
    this.clear = true;
    reset();
    synchronized (this.rJR)
    {
      this.rJJ = null;
      this.fVk = null;
      AppMethodBeat.o(38452);
      return;
    }
  }
  
  public final boolean cuf()
  {
    AppMethodBeat.i(38455);
    boolean bool;
    if (!bo.isNullOrNil(this.fVf)) {
      if (this.fVi == 3)
      {
        bool = true;
        ab.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[] { this.fVf, Boolean.valueOf(bool), Integer.valueOf(this.rJK) });
        ag.cpd().o(this.fVf, cul());
        if ((this.rJK >= this.rJQ.rJT) && (!bool)) {
          ag.cpd().a(this.cIc, this.fDT, this.crk, false, false, 36);
        }
        cum();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38455);
      return true;
      bool = false;
      break;
      cun();
    }
  }
  
  final void cuh()
  {
    AppMethodBeat.i(38461);
    ab.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[] { this.fVf });
    cuk();
    al.d(new ae.2(this));
    AppMethodBeat.o(38461);
  }
  
  final void cuk()
  {
    AppMethodBeat.i(38464);
    if (this.rJN == 0L) {
      this.rJN = bo.aoy();
    }
    AppMethodBeat.o(38464);
  }
  
  public final void cun()
  {
    AppMethodBeat.i(145490);
    Object localObject1 = cul();
    Object localObject2 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject2).value = 0;
    int i = at.gV(ah.getContext());
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
    long l2 = com.tencent.mm.vfs.e.avI(str3);
    localObject1 = new ap();
    ((ap)localObject1).cTb = i;
    ((ap)localObject1).cQH = 0L;
    ((ap)localObject1).cQI = 0L;
    ((ap)localObject1).cSU = l2;
    ((ap)localObject1).fV(str1);
    ((ap)localObject1).fU(str2);
    ((ap)localObject1).cSW = l1;
    ((ap)localObject1).cSX = j;
    ((ap)localObject1).cSY = k;
    ((ap)localObject1).cSZ = m;
    ((ap)localObject1).cTa = n;
    ((ap)localObject1).cTu = i1;
    ((ap)localObject1).cTv = i2;
    ((ap)localObject1).cUW = i3;
    ((ap)localObject1).fW((String)localObject2);
    ((ap)localObject1).cUY = i4;
    ((ap)localObject1).ake();
    AppMethodBeat.o(145490);
  }
  
  final void lw(boolean paramBoolean)
  {
    AppMethodBeat.i(155727);
    synchronized (this.rJR)
    {
      if (this.rJJ != null) {
        this.rJJ.bw(this.fVg, paramBoolean);
      }
      AppMethodBeat.o(155727);
      return;
    }
  }
  
  public final boolean mj(int paramInt)
  {
    AppMethodBeat.i(38457);
    if (this.clear)
    {
      AppMethodBeat.o(38457);
      return false;
    }
    if (this.fVm != -1) {}
    for (int i = this.fVm;; i = paramInt)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      ab.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.fVp), Integer.valueOf(this.fVl), Integer.valueOf(this.fVj), Integer.valueOf(this.fVi), this.fVf, Long.valueOf(this.rJN - this.edG), Boolean.valueOf(this.fVr) });
      if (this.rJJ == null)
      {
        ab.i("MicroMsg.OnlineVideoViewHelper", "ui is null, checkTimer false");
        AppMethodBeat.o(38457);
        return false;
      }
      switch (this.fVi)
      {
      default: 
        ab.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(38457);
        return bool1;
        if (!mk(i))
        {
          cui();
          bool1 = false;
        }
        for (;;)
        {
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label360;
          }
          if (!fG(localPInt1.value, localPInt2.value)) {
            break;
          }
          this.fVp = Math.max(this.fVp, localPInt2.value);
          bool1 = true;
          break;
          cuk();
          if (this.fVr)
          {
            cuj();
          }
          else
          {
            ab.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[] { this.fVf });
            if (this.fVj == 5) {
              this.fVj = 1;
            }
            lw(true);
            this.fVr = true;
          }
        }
        label360:
        ab.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
        o.alF();
        com.tencent.mm.al.e.r(this.fVf, 0, -1);
        continue;
        cuk();
        if (this.fVr)
        {
          if (this.fVo)
          {
            if (this.fVm == -1) {
              break label442;
            }
            EI(this.fVm);
            this.fVm = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.fVo = bool1;
            this.fVj = 3;
            bool1 = bool2;
            break;
            label442:
            if (cug()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.fVj == 5) {
          this.fVj = 1;
        }
        lw(false);
        this.fVr = true;
        bool1 = bool2;
        continue;
        ab.w("MicroMsg.OnlineVideoViewHelper", "download error.");
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */