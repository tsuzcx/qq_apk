package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  c dZC;
  int eah;
  public int jUj;
  public int rmA;
  int rmB;
  int rmC;
  int rmD;
  public int rmE;
  public int rmF;
  int rmG;
  public int rmH;
  public int rmI;
  int rmJ;
  public int rmK;
  public int rmL;
  public String rmM;
  public String rmN;
  String rmO;
  int rmP;
  public int rmQ;
  public int rmR;
  public int rmS;
  public int rmT;
  public int rmU;
  public int rmV;
  public int rmW;
  public int rmX;
  int rmY;
  int rmZ;
  public boolean rmx;
  public long rmy;
  public long rmz;
  long rnA;
  long rnB;
  long rnC;
  long rnD;
  long rnE;
  long rnF;
  long rnG;
  long rnH;
  long rnI;
  long rnJ;
  long rnK;
  long rnL;
  String rnM;
  int rnN;
  String rnO;
  long rnP;
  private long rnQ;
  long rnR;
  private long rnS;
  private HashSet<String> rnT;
  HashSet<String> rnU;
  public HashSet<String> rnV;
  HashSet<String> rnW;
  public HashSet<String> rnX;
  HashSet<String> rnY;
  HashSet<String> rnZ;
  int rna;
  int rnb;
  int rnc;
  int rnd;
  public int rne;
  public int rnf;
  int rng;
  int rnh;
  public long rni;
  public long rnj;
  long rnk;
  long rnl;
  long rnm;
  long rnn;
  long rno;
  long rnp;
  long rnq;
  long rnr;
  long rns;
  long rnt;
  long rnu;
  long rnv;
  long rnw;
  long rnx;
  long rny;
  long rnz;
  public HashSet<String> roa;
  public HashSet<String> rob;
  HashSet<String> roc;
  public HashSet<String> rod;
  private HashSet<String> roe;
  public HashSet<String> rof;
  public HashSet<String> rog;
  public int roh;
  public int roi;
  public HashSet<String> roj;
  public HashSet<String> rok;
  public HashSet<String> rol;
  public HashSet<String> rom;
  public HashSet<String> ron;
  public HashSet<String> roo;
  public HashSet<String> rop;
  public HashSet<String> roq;
  public HashSet<String> ror;
  public HashSet<String> ros;
  public HashSet<String> rot;
  public HashSet<String> rou;
  public long rov;
  
  public b()
  {
    AppMethodBeat.i(36865);
    this.rmx = false;
    this.rmy = -1L;
    this.rmz = 0L;
    this.rmA = 0;
    this.rmB = 0;
    this.rmC = 0;
    this.rmD = 0;
    this.rmE = 0;
    this.rmF = 0;
    this.rmG = 0;
    this.rmH = 0;
    this.rmI = 0;
    this.rmJ = 0;
    this.rmK = 0;
    this.rmL = 0;
    this.rmM = "";
    this.rmN = "";
    this.rmO = "";
    this.rmQ = 0;
    this.rmR = 0;
    this.rmS = 0;
    this.rmT = 0;
    this.rmU = 0;
    this.rmV = 0;
    this.rmW = 0;
    this.jUj = 0;
    this.rmX = 0;
    this.rmY = 0;
    this.rmZ = 0;
    this.rna = 0;
    this.rnb = 0;
    this.rnc = 0;
    this.rnd = 0;
    this.rne = 0;
    this.rnf = 0;
    this.rng = 0;
    this.rnh = 0;
    this.rni = 0L;
    this.rnj = 0L;
    this.rnk = 0L;
    this.rnl = 0L;
    this.rnm = 0L;
    this.rnn = 0L;
    this.rno = 0L;
    this.rnp = 0L;
    this.rnq = 0L;
    this.rnr = 0L;
    this.rns = 0L;
    this.rnt = 0L;
    this.rnu = 0L;
    this.rnv = 0L;
    this.rnw = 0L;
    this.rnx = 0L;
    this.rny = 0L;
    this.rnz = 0L;
    this.rnA = 0L;
    this.rnB = 0L;
    this.rnC = 0L;
    this.rnD = 0L;
    this.rnE = 0L;
    this.rnF = 0L;
    this.rnG = 0L;
    this.rnH = 0L;
    this.rnI = 0L;
    this.rnJ = 0L;
    this.rnK = 0L;
    this.rnL = 0L;
    this.rnP = 0L;
    this.rnQ = 0L;
    this.rnR = 0L;
    this.rnS = 0L;
    this.rnT = new HashSet();
    this.rnU = new HashSet();
    this.rnV = new HashSet();
    this.rnW = new HashSet();
    this.rnX = new HashSet();
    this.rnY = new HashSet();
    this.rnZ = new HashSet();
    this.roa = new HashSet();
    this.rob = new HashSet();
    this.roc = new HashSet();
    this.rod = new HashSet();
    this.roe = new HashSet();
    this.rof = new HashSet();
    this.rog = new HashSet();
    this.roh = 2147483647;
    this.roi = 0;
    this.roj = new HashSet();
    this.rok = new HashSet();
    this.rol = new HashSet();
    this.rom = new HashSet();
    this.ron = new HashSet();
    this.roo = new HashSet();
    this.rop = new HashSet();
    this.roq = new HashSet();
    this.ror = new HashSet();
    this.ros = new HashSet();
    this.rot = new HashSet();
    this.rou = new HashSet();
    this.dZC = new b.1(this);
    this.rov = 0L;
    a.ymk.c(this.dZC);
    AppMethodBeat.o(36865);
  }
  
  public b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.eah = paramInt1;
    this.rnM = paramString1;
    this.rnN = paramInt2;
    this.rnO = paramString2;
  }
  
  static String f(HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(36866);
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
    AppMethodBeat.o(36866);
    return paramHashSet;
  }
  
  public final void a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(36848);
    if (paramn == null)
    {
      AppMethodBeat.o(36848);
      return;
    }
    if (paramBoolean) {
      this.rnY.add(i.j(paramn));
    }
    for (;;)
    {
      this.roc.add(paramn.field_userName);
      this.rmD = this.roc.size();
      if (!ag.coK().equals(paramn.field_userName)) {
        break;
      }
      ld(true);
      AppMethodBeat.o(36848);
      return;
      this.rnZ.add(i.j(paramn));
    }
    le(true);
    AppMethodBeat.o(36848);
  }
  
  public final void gs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36849);
    this.rnW.add(paramString2);
    this.roe.add(paramString1);
    this.rmG = this.roe.size();
    AppMethodBeat.o(36849);
  }
  
  public final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(36850);
    if (paramBoolean)
    {
      this.rnl = System.currentTimeMillis();
      AppMethodBeat.o(36850);
      return;
    }
    if (this.rnl > 0L)
    {
      this.rnk += System.currentTimeMillis() - this.rnl;
      this.rnl = 0L;
    }
    AppMethodBeat.o(36850);
  }
  
  public final void ld(boolean paramBoolean)
  {
    AppMethodBeat.i(36851);
    if (paramBoolean)
    {
      this.rnn = System.currentTimeMillis();
      AppMethodBeat.o(36851);
      return;
    }
    if (this.rnn > 0L)
    {
      this.rnm += System.currentTimeMillis() - this.rnn;
      this.rnn = 0L;
    }
    AppMethodBeat.o(36851);
  }
  
  public final void le(boolean paramBoolean)
  {
    AppMethodBeat.i(36852);
    if (paramBoolean)
    {
      this.rnp = System.currentTimeMillis();
      AppMethodBeat.o(36852);
      return;
    }
    if (this.rnp > 0L)
    {
      this.rno += System.currentTimeMillis() - this.rnp;
      this.rnp = 0L;
    }
    AppMethodBeat.o(36852);
  }
  
  public final void lf(boolean paramBoolean)
  {
    AppMethodBeat.i(36853);
    if (paramBoolean)
    {
      this.rnr = System.currentTimeMillis();
      AppMethodBeat.o(36853);
      return;
    }
    if (this.rnr > 0L)
    {
      this.rnq += System.currentTimeMillis() - this.rnr;
      this.rnr = 0L;
    }
    AppMethodBeat.o(36853);
  }
  
  public final void lg(boolean paramBoolean)
  {
    AppMethodBeat.i(36854);
    if (paramBoolean)
    {
      this.rnt = System.currentTimeMillis();
      AppMethodBeat.o(36854);
      return;
    }
    if (this.rnt > 0L)
    {
      this.rns += System.currentTimeMillis() - this.rnt;
      this.rnt = 0L;
    }
    AppMethodBeat.o(36854);
  }
  
  public final void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(36855);
    if (paramBoolean)
    {
      this.rnv = System.currentTimeMillis();
      AppMethodBeat.o(36855);
      return;
    }
    if (this.rnv > 0L)
    {
      this.rnu += System.currentTimeMillis() - this.rnv;
      this.rnv = 0L;
    }
    AppMethodBeat.o(36855);
  }
  
  public final void li(boolean paramBoolean)
  {
    AppMethodBeat.i(36856);
    if (paramBoolean)
    {
      this.rnQ = System.currentTimeMillis();
      AppMethodBeat.o(36856);
      return;
    }
    if (this.rnQ > 0L)
    {
      this.rnP += System.currentTimeMillis() - this.rnQ;
      this.rnQ = 0L;
    }
    AppMethodBeat.o(36856);
  }
  
  public final void lj(boolean paramBoolean)
  {
    AppMethodBeat.i(36857);
    if (paramBoolean)
    {
      this.rnS = System.currentTimeMillis();
      AppMethodBeat.o(36857);
      return;
    }
    if (this.rnS > 0L)
    {
      this.rnR += System.currentTimeMillis() - this.rnS;
      this.rnS = 0L;
    }
    AppMethodBeat.o(36857);
  }
  
  public final void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(36858);
    if (paramBoolean)
    {
      this.rnx = System.currentTimeMillis();
      AppMethodBeat.o(36858);
      return;
    }
    if (this.rnx > 0L)
    {
      this.rnw += System.currentTimeMillis() - this.rnx;
      this.rnx = 0L;
    }
    AppMethodBeat.o(36858);
  }
  
  public final void ll(boolean paramBoolean)
  {
    AppMethodBeat.i(36859);
    if (paramBoolean)
    {
      this.rnz = System.currentTimeMillis();
      AppMethodBeat.o(36859);
      return;
    }
    if (this.rnz > 0L)
    {
      this.rny += System.currentTimeMillis() - this.rnz;
      this.rnz = 0L;
    }
    AppMethodBeat.o(36859);
  }
  
  public final void lm(boolean paramBoolean)
  {
    AppMethodBeat.i(36860);
    if (paramBoolean)
    {
      this.rnB = System.currentTimeMillis();
      AppMethodBeat.o(36860);
      return;
    }
    if (this.rnB > 0L)
    {
      this.rnA += System.currentTimeMillis() - this.rnB;
      this.rnB = 0L;
    }
    AppMethodBeat.o(36860);
  }
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(36861);
    if (paramBoolean)
    {
      this.rnD = System.currentTimeMillis();
      AppMethodBeat.o(36861);
      return;
    }
    if (this.rnD > 0L)
    {
      this.rnC += System.currentTimeMillis() - this.rnD;
      this.rnD = 0L;
    }
    AppMethodBeat.o(36861);
  }
  
  public final void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(36862);
    if (paramBoolean)
    {
      this.rnH = System.currentTimeMillis();
      AppMethodBeat.o(36862);
      return;
    }
    if (this.rnH > 0L)
    {
      this.rnG += System.currentTimeMillis() - this.rnH;
      this.rnH = 0L;
    }
    AppMethodBeat.o(36862);
  }
  
  public final void lp(boolean paramBoolean)
  {
    AppMethodBeat.i(36863);
    if (paramBoolean)
    {
      this.rnJ = System.currentTimeMillis();
      AppMethodBeat.o(36863);
      return;
    }
    if (this.rnJ > 0L)
    {
      this.rnI += System.currentTimeMillis() - this.rnJ;
      this.rnJ = 0L;
    }
    AppMethodBeat.o(36863);
  }
  
  public final void lq(boolean paramBoolean)
  {
    AppMethodBeat.i(36864);
    if (paramBoolean)
    {
      this.rnL = System.currentTimeMillis();
      AppMethodBeat.o(36864);
      return;
    }
    if (this.rnL > 0L)
    {
      this.rnK += System.currentTimeMillis() - this.rnL;
      this.rnL = 0L;
    }
    AppMethodBeat.o(36864);
  }
  
  public final void lr(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.rmP = i;
      return;
    }
  }
  
  public final void w(n paramn)
  {
    AppMethodBeat.i(36846);
    if (paramn == null)
    {
      AppMethodBeat.o(36846);
      return;
    }
    this.rnT.add(paramn.csH());
    this.rmB = this.rnT.size();
    AppMethodBeat.o(36846);
  }
  
  public final void x(n paramn)
  {
    AppMethodBeat.i(36847);
    if (paramn == null)
    {
      AppMethodBeat.o(36847);
      return;
    }
    String str1 = paramn.csH();
    String str2 = i.j(paramn);
    if (this.rnU.contains(str2))
    {
      AppMethodBeat.o(36847);
      return;
    }
    ab.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.rmC += 1;
    this.rnU.add(str2);
    if (paramn.Ex(32)) {
      this.rnh += 1;
    }
    switch (paramn.field_type)
    {
    }
    while (paramn.Ex(32)) {
      if ((paramn.csb() != null) && (paramn.csb().cqk()))
      {
        li(true);
        AppMethodBeat.o(36847);
        return;
        this.rna += 1;
        continue;
        this.rnc += 1;
        continue;
        this.rnb += 1;
        continue;
        this.rnd += 1;
        continue;
        this.rng += 1;
        continue;
        if (!bo.isNullOrNil(paramn.csh().xTT)) {
          this.rmY += 1;
        } else {
          this.rmZ += 1;
        }
      }
      else
      {
        if (paramn.field_type == 1)
        {
          ln(true);
          AppMethodBeat.o(36847);
          return;
        }
        if (paramn.field_type != 15) {
          break label444;
        }
        lo(true);
        AppMethodBeat.o(36847);
        return;
      }
    }
    if ((paramn.csh() != null) && (!bo.isNullOrNil(paramn.csh().sbN)))
    {
      lj(true);
      AppMethodBeat.o(36847);
      return;
    }
    switch (paramn.field_type)
    {
    }
    for (;;)
    {
      label444:
      AppMethodBeat.o(36847);
      return;
      lh(true);
      AppMethodBeat.o(36847);
      return;
      lm(true);
      AppMethodBeat.o(36847);
      return;
      lk(true);
      AppMethodBeat.o(36847);
      return;
      lm(true);
      AppMethodBeat.o(36847);
      return;
      lq(true);
      AppMethodBeat.o(36847);
      return;
      if (!bo.isNullOrNil(paramn.csh().xTT))
      {
        ll(true);
        AppMethodBeat.o(36847);
        return;
      }
      lm(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b
 * JD-Core Version:    0.7.0.1
 */