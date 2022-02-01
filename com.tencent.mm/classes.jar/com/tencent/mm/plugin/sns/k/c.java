package com.tencent.mm.plugin.sns.k;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  com.tencent.mm.sdk.b.c fjL;
  int fkq;
  public int mUB;
  public boolean wOK;
  public long wOL;
  public long wOM;
  public int wON;
  int wOO;
  int wOP;
  int wOQ;
  public int wOR;
  public int wOS;
  int wOT;
  public int wOU;
  public int wOV;
  int wOW;
  public int wOX;
  public int wOY;
  public String wOZ;
  long wPA;
  long wPB;
  long wPC;
  long wPD;
  long wPE;
  long wPF;
  long wPG;
  long wPH;
  long wPI;
  long wPJ;
  long wPK;
  long wPL;
  long wPM;
  long wPN;
  long wPO;
  long wPP;
  long wPQ;
  long wPR;
  long wPS;
  long wPT;
  long wPU;
  long wPV;
  long wPW;
  long wPX;
  long wPY;
  String wPZ;
  public String wPa;
  String wPb;
  int wPc;
  public int wPd;
  public int wPe;
  public int wPf;
  public int wPg;
  public int wPh;
  public int wPi;
  public int wPj;
  public int wPk;
  int wPl;
  int wPm;
  int wPn;
  int wPo;
  int wPp;
  int wPq;
  public int wPr;
  public int wPs;
  int wPt;
  int wPu;
  public long wPv;
  public long wPw;
  long wPx;
  long wPy;
  long wPz;
  public HashSet<String> wQA;
  public HashSet<String> wQB;
  public HashSet<String> wQC;
  public HashSet<String> wQD;
  public HashSet<String> wQE;
  public HashSet<String> wQF;
  public HashSet<String> wQG;
  public HashSet<String> wQH;
  public long wQI;
  int wQa;
  String wQb;
  long wQc;
  private long wQd;
  long wQe;
  private long wQf;
  private HashSet<String> wQg;
  HashSet<String> wQh;
  public HashSet<String> wQi;
  HashSet<String> wQj;
  public HashSet<String> wQk;
  HashSet<String> wQl;
  HashSet<String> wQm;
  public HashSet<String> wQn;
  public HashSet<String> wQo;
  HashSet<String> wQp;
  public HashSet<String> wQq;
  private HashSet<String> wQr;
  public HashSet<String> wQs;
  public HashSet<String> wQt;
  public int wQu;
  public int wQv;
  public HashSet<String> wQw;
  public HashSet<String> wQx;
  public HashSet<String> wQy;
  public HashSet<String> wQz;
  
  public c()
  {
    AppMethodBeat.i(96195);
    this.wOK = false;
    this.wOL = -1L;
    this.wOM = 0L;
    this.wON = 0;
    this.wOO = 0;
    this.wOP = 0;
    this.wOQ = 0;
    this.wOR = 0;
    this.wOS = 0;
    this.wOT = 0;
    this.wOU = 0;
    this.wOV = 0;
    this.wOW = 0;
    this.wOX = 0;
    this.wOY = 0;
    this.wOZ = "";
    this.wPa = "";
    this.wPb = "";
    this.wPd = 0;
    this.wPe = 0;
    this.wPf = 0;
    this.wPg = 0;
    this.wPh = 0;
    this.wPi = 0;
    this.wPj = 0;
    this.mUB = 0;
    this.wPk = 0;
    this.wPl = 0;
    this.wPm = 0;
    this.wPn = 0;
    this.wPo = 0;
    this.wPp = 0;
    this.wPq = 0;
    this.wPr = 0;
    this.wPs = 0;
    this.wPt = 0;
    this.wPu = 0;
    this.wPv = 0L;
    this.wPw = 0L;
    this.wPx = 0L;
    this.wPy = 0L;
    this.wPz = 0L;
    this.wPA = 0L;
    this.wPB = 0L;
    this.wPC = 0L;
    this.wPD = 0L;
    this.wPE = 0L;
    this.wPF = 0L;
    this.wPG = 0L;
    this.wPH = 0L;
    this.wPI = 0L;
    this.wPJ = 0L;
    this.wPK = 0L;
    this.wPL = 0L;
    this.wPM = 0L;
    this.wPN = 0L;
    this.wPO = 0L;
    this.wPP = 0L;
    this.wPQ = 0L;
    this.wPR = 0L;
    this.wPS = 0L;
    this.wPT = 0L;
    this.wPU = 0L;
    this.wPV = 0L;
    this.wPW = 0L;
    this.wPX = 0L;
    this.wPY = 0L;
    this.wQc = 0L;
    this.wQd = 0L;
    this.wQe = 0L;
    this.wQf = 0L;
    this.wQg = new HashSet();
    this.wQh = new HashSet();
    this.wQi = new HashSet();
    this.wQj = new HashSet();
    this.wQk = new HashSet();
    this.wQl = new HashSet();
    this.wQm = new HashSet();
    this.wQn = new HashSet();
    this.wQo = new HashSet();
    this.wQp = new HashSet();
    this.wQq = new HashSet();
    this.wQr = new HashSet();
    this.wQs = new HashSet();
    this.wQt = new HashSet();
    this.wQu = 2147483647;
    this.wQv = 0;
    this.wQw = new HashSet();
    this.wQx = new HashSet();
    this.wQy = new HashSet();
    this.wQz = new HashSet();
    this.wQA = new HashSet();
    this.wQB = new HashSet();
    this.wQC = new HashSet();
    this.wQD = new HashSet();
    this.wQE = new HashSet();
    this.wQF = new HashSet();
    this.wQG = new HashSet();
    this.wQH = new HashSet();
    this.fjL = new com.tencent.mm.sdk.b.c() {};
    this.wQI = 0L;
    com.tencent.mm.sdk.b.a.ESL.c(this.fjL);
    AppMethodBeat.o(96195);
  }
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.fkq = paramInt1;
    this.wPZ = paramString1;
    this.wQa = paramInt2;
    this.wQb = paramString2;
  }
  
  static String g(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(96196);
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashSet = paramHashSet.iterator();
    int i = 1;
    while (paramHashSet.hasNext())
    {
      String str = (String)paramHashSet.next();
      if (i != 0)
      {
        localStringBuffer.append(str);
        i = 0;
      }
      else
      {
        localStringBuffer.append("|".concat(String.valueOf(str)));
      }
    }
    paramHashSet = localStringBuffer.toString();
    AppMethodBeat.o(96196);
    return paramHashSet;
  }
  
  public final void B(p paramp)
  {
    AppMethodBeat.i(96176);
    if (paramp == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.wQg.add(paramp.dxX());
    this.wOO = this.wQg.size();
    AppMethodBeat.o(96176);
  }
  
  public final void C(p paramp)
  {
    AppMethodBeat.i(96177);
    if (paramp == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramp.dxX();
    String str2 = q.l(paramp);
    if (this.wQh.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    ad.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.wOP += 1;
    this.wQh.add(str2);
    if (paramp.Nb(32)) {
      this.wPu += 1;
    }
    switch (paramp.field_type)
    {
    }
    while (paramp.Nb(32)) {
      if ((paramp.dxs() != null) && (paramp.dxs().dvh()))
      {
        pQ(true);
        AppMethodBeat.o(96177);
        return;
        this.wPn += 1;
        continue;
        this.wPp += 1;
        continue;
        this.wPo += 1;
        continue;
        this.wPq += 1;
        continue;
        this.wPt += 1;
        continue;
        if (!bt.isNullOrNil(paramp.dxy().Etn)) {
          this.wPl += 1;
        } else {
          this.wPm += 1;
        }
      }
      else
      {
        if (paramp.field_type == 1)
        {
          pV(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramp.field_type != 15) {
          break label444;
        }
        pW(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramp.dxy() != null) && (!bt.isNullOrNil(paramp.dxy().xpl)))
    {
      pR(true);
      AppMethodBeat.o(96177);
      return;
    }
    switch (paramp.field_type)
    {
    }
    for (;;)
    {
      label444:
      AppMethodBeat.o(96177);
      return;
      pP(true);
      AppMethodBeat.o(96177);
      return;
      pU(true);
      AppMethodBeat.o(96177);
      return;
      pS(true);
      AppMethodBeat.o(96177);
      return;
      pU(true);
      AppMethodBeat.o(96177);
      return;
      pY(true);
      AppMethodBeat.o(96177);
      return;
      if (!bt.isNullOrNil(paramp.dxy().Etn))
      {
        pT(true);
        AppMethodBeat.o(96177);
        return;
      }
      pU(true);
    }
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(96178);
    if (paramp == null)
    {
      AppMethodBeat.o(96178);
      return;
    }
    if (paramBoolean) {
      this.wQl.add(q.l(paramp));
    }
    for (;;)
    {
      this.wQp.add(paramp.field_userName);
      this.wOQ = this.wQp.size();
      if (!af.dta().equals(paramp.field_userName)) {
        break;
      }
      pL(true);
      AppMethodBeat.o(96178);
      return;
      this.wQm.add(q.l(paramp));
    }
    pM(true);
    AppMethodBeat.o(96178);
  }
  
  public final void iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.wQj.add(paramString2);
    this.wQr.add(paramString1);
    this.wOT = this.wQr.size();
    AppMethodBeat.o(96179);
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.wPy = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.wPy > 0L)
    {
      this.wPx += System.currentTimeMillis() - this.wPy;
      this.wPy = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.wPA = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.wPA > 0L)
    {
      this.wPz += System.currentTimeMillis() - this.wPA;
      this.wPA = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.wPC = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.wPC > 0L)
    {
      this.wPB += System.currentTimeMillis() - this.wPC;
      this.wPC = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void pN(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.wPE = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.wPE > 0L)
    {
      this.wPD += System.currentTimeMillis() - this.wPE;
      this.wPE = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void pO(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.wPG = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.wPG > 0L)
    {
      this.wPF += System.currentTimeMillis() - this.wPG;
      this.wPG = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void pP(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.wPI = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.wPI > 0L)
    {
      this.wPH += System.currentTimeMillis() - this.wPI;
      this.wPI = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void pQ(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.wQd = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.wQd > 0L)
    {
      this.wQc += System.currentTimeMillis() - this.wQd;
      this.wQd = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void pR(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.wQf = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.wQf > 0L)
    {
      this.wQe += System.currentTimeMillis() - this.wQf;
      this.wQf = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.wPK = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.wPK > 0L)
    {
      this.wPJ += System.currentTimeMillis() - this.wPK;
      this.wPK = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.wPM = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.wPM > 0L)
    {
      this.wPL += System.currentTimeMillis() - this.wPM;
      this.wPM = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void pU(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.wPO = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.wPO > 0L)
    {
      this.wPN += System.currentTimeMillis() - this.wPO;
      this.wPO = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void pV(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.wPQ = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.wPQ > 0L)
    {
      this.wPP += System.currentTimeMillis() - this.wPQ;
      this.wPQ = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.wPU = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.wPU > 0L)
    {
      this.wPT += System.currentTimeMillis() - this.wPU;
      this.wPU = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void pX(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.wPW = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.wPW > 0L)
    {
      this.wPV += System.currentTimeMillis() - this.wPW;
      this.wPW = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.wPY = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.wPY > 0L)
    {
      this.wPX += System.currentTimeMillis() - this.wPY;
      this.wPY = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void pZ(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.wPc = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.c
 * JD-Core Version:    0.7.0.1
 */