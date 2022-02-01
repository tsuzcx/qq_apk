package com.tencent.mm.plugin.sns.j;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  int fFS;
  c fFn;
  public int nYt;
  public String zrA;
  public String zrB;
  String zrC;
  int zrD;
  public int zrE;
  public int zrF;
  public int zrG;
  public int zrH;
  public int zrI;
  public int zrJ;
  public int zrK;
  public int zrL;
  int zrM;
  int zrN;
  int zrO;
  int zrP;
  int zrQ;
  int zrR;
  public int zrS;
  public int zrT;
  int zrU;
  int zrV;
  public long zrW;
  public long zrX;
  long zrY;
  long zrZ;
  public boolean zrl;
  public long zrm;
  public long zrn;
  public int zro;
  int zrp;
  int zrq;
  int zrr;
  public int zrs;
  public int zrt;
  int zru;
  public int zrv;
  public int zrw;
  int zrx;
  public int zry;
  public int zrz;
  String zsA;
  int zsB;
  String zsC;
  long zsD;
  private long zsE;
  long zsF;
  private long zsG;
  private HashSet<String> zsH;
  HashSet<String> zsI;
  public HashSet<String> zsJ;
  HashSet<String> zsK;
  public HashSet<String> zsL;
  HashSet<String> zsM;
  HashSet<String> zsN;
  public HashSet<String> zsO;
  public HashSet<String> zsP;
  HashSet<String> zsQ;
  public HashSet<String> zsR;
  private HashSet<String> zsS;
  public HashSet<String> zsT;
  public HashSet<String> zsU;
  public int zsV;
  public int zsW;
  public HashSet<String> zsX;
  public HashSet<String> zsY;
  public HashSet<String> zsZ;
  long zsa;
  long zsb;
  long zsc;
  long zsd;
  long zse;
  long zsf;
  long zsg;
  long zsh;
  long zsi;
  long zsj;
  long zsk;
  long zsl;
  long zsm;
  long zsn;
  long zso;
  long zsp;
  long zsq;
  long zsr;
  long zss;
  long zst;
  long zsu;
  long zsv;
  long zsw;
  long zsx;
  long zsy;
  long zsz;
  public HashSet<String> zta;
  public HashSet<String> ztb;
  public HashSet<String> ztc;
  public HashSet<String> ztd;
  public HashSet<String> zte;
  public HashSet<String> ztf;
  public HashSet<String> ztg;
  public HashSet<String> zth;
  public HashSet<String> zti;
  public long ztj;
  
  public b()
  {
    AppMethodBeat.i(96195);
    this.zrl = false;
    this.zrm = -1L;
    this.zrn = 0L;
    this.zro = 0;
    this.zrp = 0;
    this.zrq = 0;
    this.zrr = 0;
    this.zrs = 0;
    this.zrt = 0;
    this.zru = 0;
    this.zrv = 0;
    this.zrw = 0;
    this.zrx = 0;
    this.zry = 0;
    this.zrz = 0;
    this.zrA = "";
    this.zrB = "";
    this.zrC = "";
    this.zrE = 0;
    this.zrF = 0;
    this.zrG = 0;
    this.zrH = 0;
    this.zrI = 0;
    this.zrJ = 0;
    this.zrK = 0;
    this.nYt = 0;
    this.zrL = 0;
    this.zrM = 0;
    this.zrN = 0;
    this.zrO = 0;
    this.zrP = 0;
    this.zrQ = 0;
    this.zrR = 0;
    this.zrS = 0;
    this.zrT = 0;
    this.zrU = 0;
    this.zrV = 0;
    this.zrW = 0L;
    this.zrX = 0L;
    this.zrY = 0L;
    this.zrZ = 0L;
    this.zsa = 0L;
    this.zsb = 0L;
    this.zsc = 0L;
    this.zsd = 0L;
    this.zse = 0L;
    this.zsf = 0L;
    this.zsg = 0L;
    this.zsh = 0L;
    this.zsi = 0L;
    this.zsj = 0L;
    this.zsk = 0L;
    this.zsl = 0L;
    this.zsm = 0L;
    this.zsn = 0L;
    this.zso = 0L;
    this.zsp = 0L;
    this.zsq = 0L;
    this.zsr = 0L;
    this.zss = 0L;
    this.zst = 0L;
    this.zsu = 0L;
    this.zsv = 0L;
    this.zsw = 0L;
    this.zsx = 0L;
    this.zsy = 0L;
    this.zsz = 0L;
    this.zsD = 0L;
    this.zsE = 0L;
    this.zsF = 0L;
    this.zsG = 0L;
    this.zsH = new HashSet();
    this.zsI = new HashSet();
    this.zsJ = new HashSet();
    this.zsK = new HashSet();
    this.zsL = new HashSet();
    this.zsM = new HashSet();
    this.zsN = new HashSet();
    this.zsO = new HashSet();
    this.zsP = new HashSet();
    this.zsQ = new HashSet();
    this.zsR = new HashSet();
    this.zsS = new HashSet();
    this.zsT = new HashSet();
    this.zsU = new HashSet();
    this.zsV = 2147483647;
    this.zsW = 0;
    this.zsX = new HashSet();
    this.zsY = new HashSet();
    this.zsZ = new HashSet();
    this.zta = new HashSet();
    this.ztb = new HashSet();
    this.ztc = new HashSet();
    this.ztd = new HashSet();
    this.zte = new HashSet();
    this.ztf = new HashSet();
    this.ztg = new HashSet();
    this.zth = new HashSet();
    this.zti = new HashSet();
    this.fFn = new c() {};
    this.ztj = 0L;
    com.tencent.mm.sdk.b.a.IbL.c(this.fFn);
    AppMethodBeat.o(96195);
  }
  
  public b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.fFS = paramInt1;
    this.zsA = paramString1;
    this.zsB = paramInt2;
    this.zsC = paramString2;
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
  
  public final void E(p paramp)
  {
    AppMethodBeat.i(96176);
    if (paramp == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.zsH.add(paramp.dYK());
    this.zrp = this.zsH.size();
    AppMethodBeat.o(96176);
  }
  
  public final void F(p paramp)
  {
    AppMethodBeat.i(96177);
    if (paramp == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramp.dYK();
    String str2 = q.n(paramp);
    if (this.zsI.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    ad.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.zrq += 1;
    this.zsI.add(str2);
    if (paramp.QM(32)) {
      this.zrV += 1;
    }
    switch (paramp.field_type)
    {
    }
    while (paramp.QM(32)) {
      if ((paramp.dRL() != null) && (paramp.dRL().dVU()))
      {
        rs(true);
        AppMethodBeat.o(96177);
        return;
        this.zrO += 1;
        continue;
        this.zrQ += 1;
        continue;
        this.zrP += 1;
        continue;
        this.zrR += 1;
        continue;
        this.zrU += 1;
        continue;
        if (!bt.isNullOrNil(paramp.dYl().HAU)) {
          this.zrM += 1;
        } else {
          this.zrN += 1;
        }
      }
      else
      {
        if (paramp.field_type == 1)
        {
          rx(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramp.field_type != 15) {
          break label444;
        }
        ry(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramp.dYl() != null) && (!bt.isNullOrNil(paramp.dYl().zTv)))
    {
      rt(true);
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
      rr(true);
      AppMethodBeat.o(96177);
      return;
      rw(true);
      AppMethodBeat.o(96177);
      return;
      ru(true);
      AppMethodBeat.o(96177);
      return;
      rw(true);
      AppMethodBeat.o(96177);
      return;
      rA(true);
      AppMethodBeat.o(96177);
      return;
      if (!bt.isNullOrNil(paramp.dYl().HAU))
      {
        rv(true);
        AppMethodBeat.o(96177);
        return;
      }
      rw(true);
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
      this.zsM.add(q.n(paramp));
    }
    for (;;)
    {
      this.zsQ.add(paramp.field_userName);
      this.zrr = this.zsQ.size();
      if (!ag.dTJ().equals(paramp.field_userName)) {
        break;
      }
      rn(true);
      AppMethodBeat.o(96178);
      return;
      this.zsN.add(q.n(paramp));
    }
    ro(true);
    AppMethodBeat.o(96178);
  }
  
  public final void jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.zsK.add(paramString2);
    this.zsS.add(paramString1);
    this.zru = this.zsS.size();
    AppMethodBeat.o(96179);
  }
  
  public final void rA(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.zsz = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.zsz > 0L)
    {
      this.zsy += System.currentTimeMillis() - this.zsz;
      this.zsz = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void rB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.zrD = i;
      return;
    }
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.zrZ = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.zrZ > 0L)
    {
      this.zrY += System.currentTimeMillis() - this.zrZ;
      this.zrZ = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.zsb = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.zsb > 0L)
    {
      this.zsa += System.currentTimeMillis() - this.zsb;
      this.zsb = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.zsd = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.zsd > 0L)
    {
      this.zsc += System.currentTimeMillis() - this.zsd;
      this.zsd = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.zsf = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.zsf > 0L)
    {
      this.zse += System.currentTimeMillis() - this.zsf;
      this.zsf = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.zsh = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.zsh > 0L)
    {
      this.zsg += System.currentTimeMillis() - this.zsh;
      this.zsh = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void rr(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.zsj = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.zsj > 0L)
    {
      this.zsi += System.currentTimeMillis() - this.zsj;
      this.zsj = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.zsE = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.zsE > 0L)
    {
      this.zsD += System.currentTimeMillis() - this.zsE;
      this.zsE = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.zsG = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.zsG > 0L)
    {
      this.zsF += System.currentTimeMillis() - this.zsG;
      this.zsG = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.zsl = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.zsl > 0L)
    {
      this.zsk += System.currentTimeMillis() - this.zsl;
      this.zsl = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.zsn = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.zsn > 0L)
    {
      this.zsm += System.currentTimeMillis() - this.zsn;
      this.zsn = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void rw(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.zsp = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.zsp > 0L)
    {
      this.zso += System.currentTimeMillis() - this.zsp;
      this.zsp = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.zsr = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.zsr > 0L)
    {
      this.zsq += System.currentTimeMillis() - this.zsr;
      this.zsr = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.zsv = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.zsv > 0L)
    {
      this.zsu += System.currentTimeMillis() - this.zsv;
      this.zsv = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.zsx = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.zsx > 0L)
    {
      this.zsw += System.currentTimeMillis() - this.zsx;
      this.zsx = 0L;
    }
    AppMethodBeat.o(96193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b
 * JD-Core Version:    0.7.0.1
 */