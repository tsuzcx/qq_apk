package com.tencent.mm.plugin.sns.j;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uk;
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
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Iterator;

public final class c
{
  int fnK;
  com.tencent.mm.sdk.b.c fnf;
  public int nwV;
  public int ybA;
  public int ybB;
  int ybC;
  public int ybD;
  public int ybE;
  public String ybF;
  public String ybG;
  String ybH;
  int ybI;
  public int ybJ;
  public int ybK;
  public int ybL;
  public int ybM;
  public int ybN;
  public int ybO;
  public int ybP;
  public int ybQ;
  int ybR;
  int ybS;
  int ybT;
  int ybU;
  int ybV;
  int ybW;
  public int ybX;
  public int ybY;
  int ybZ;
  public boolean ybq;
  public long ybr;
  public long ybs;
  public int ybt;
  int ybu;
  int ybv;
  int ybw;
  public int ybx;
  public int yby;
  int ybz;
  long ycA;
  long ycB;
  long ycC;
  long ycD;
  long ycE;
  String ycF;
  int ycG;
  String ycH;
  long ycI;
  private long ycJ;
  long ycK;
  private long ycL;
  private HashSet<String> ycM;
  HashSet<String> ycN;
  public HashSet<String> ycO;
  HashSet<String> ycP;
  public HashSet<String> ycQ;
  HashSet<String> ycR;
  HashSet<String> ycS;
  public HashSet<String> ycT;
  public HashSet<String> ycU;
  HashSet<String> ycV;
  public HashSet<String> ycW;
  private HashSet<String> ycX;
  public HashSet<String> ycY;
  public HashSet<String> ycZ;
  int yca;
  public long ycb;
  public long ycc;
  long ycd;
  long yce;
  long ycf;
  long ycg;
  long ych;
  long yci;
  long ycj;
  long yck;
  long ycl;
  long ycm;
  long ycn;
  long yco;
  long ycp;
  long ycq;
  long ycr;
  long ycs;
  long yct;
  long ycu;
  long ycv;
  long ycw;
  long ycx;
  long ycy;
  long ycz;
  public int yda;
  public int ydb;
  public HashSet<String> ydc;
  public HashSet<String> ydd;
  public HashSet<String> yde;
  public HashSet<String> ydf;
  public HashSet<String> ydg;
  public HashSet<String> ydh;
  public HashSet<String> ydi;
  public HashSet<String> ydj;
  public HashSet<String> ydk;
  public HashSet<String> ydl;
  public HashSet<String> ydm;
  public HashSet<String> ydn;
  public long ydo;
  
  public c()
  {
    AppMethodBeat.i(96195);
    this.ybq = false;
    this.ybr = -1L;
    this.ybs = 0L;
    this.ybt = 0;
    this.ybu = 0;
    this.ybv = 0;
    this.ybw = 0;
    this.ybx = 0;
    this.yby = 0;
    this.ybz = 0;
    this.ybA = 0;
    this.ybB = 0;
    this.ybC = 0;
    this.ybD = 0;
    this.ybE = 0;
    this.ybF = "";
    this.ybG = "";
    this.ybH = "";
    this.ybJ = 0;
    this.ybK = 0;
    this.ybL = 0;
    this.ybM = 0;
    this.ybN = 0;
    this.ybO = 0;
    this.ybP = 0;
    this.nwV = 0;
    this.ybQ = 0;
    this.ybR = 0;
    this.ybS = 0;
    this.ybT = 0;
    this.ybU = 0;
    this.ybV = 0;
    this.ybW = 0;
    this.ybX = 0;
    this.ybY = 0;
    this.ybZ = 0;
    this.yca = 0;
    this.ycb = 0L;
    this.ycc = 0L;
    this.ycd = 0L;
    this.yce = 0L;
    this.ycf = 0L;
    this.ycg = 0L;
    this.ych = 0L;
    this.yci = 0L;
    this.ycj = 0L;
    this.yck = 0L;
    this.ycl = 0L;
    this.ycm = 0L;
    this.ycn = 0L;
    this.yco = 0L;
    this.ycp = 0L;
    this.ycq = 0L;
    this.ycr = 0L;
    this.ycs = 0L;
    this.yct = 0L;
    this.ycu = 0L;
    this.ycv = 0L;
    this.ycw = 0L;
    this.ycx = 0L;
    this.ycy = 0L;
    this.ycz = 0L;
    this.ycA = 0L;
    this.ycB = 0L;
    this.ycC = 0L;
    this.ycD = 0L;
    this.ycE = 0L;
    this.ycI = 0L;
    this.ycJ = 0L;
    this.ycK = 0L;
    this.ycL = 0L;
    this.ycM = new HashSet();
    this.ycN = new HashSet();
    this.ycO = new HashSet();
    this.ycP = new HashSet();
    this.ycQ = new HashSet();
    this.ycR = new HashSet();
    this.ycS = new HashSet();
    this.ycT = new HashSet();
    this.ycU = new HashSet();
    this.ycV = new HashSet();
    this.ycW = new HashSet();
    this.ycX = new HashSet();
    this.ycY = new HashSet();
    this.ycZ = new HashSet();
    this.yda = 2147483647;
    this.ydb = 0;
    this.ydc = new HashSet();
    this.ydd = new HashSet();
    this.yde = new HashSet();
    this.ydf = new HashSet();
    this.ydg = new HashSet();
    this.ydh = new HashSet();
    this.ydi = new HashSet();
    this.ydj = new HashSet();
    this.ydk = new HashSet();
    this.ydl = new HashSet();
    this.ydm = new HashSet();
    this.ydn = new HashSet();
    this.fnf = new com.tencent.mm.sdk.b.c() {};
    this.ydo = 0L;
    com.tencent.mm.sdk.b.a.GpY.c(this.fnf);
    AppMethodBeat.o(96195);
  }
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.fnK = paramInt1;
    this.ycF = paramString1;
    this.ycG = paramInt2;
    this.ycH = paramString2;
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
  
  public final void C(p paramp)
  {
    AppMethodBeat.i(96176);
    if (paramp == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.ycM.add(paramp.dMu());
    this.ybu = this.ycM.size();
    AppMethodBeat.o(96176);
  }
  
  public final void D(p paramp)
  {
    AppMethodBeat.i(96177);
    if (paramp == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramp.dMu();
    String str2 = q.l(paramp);
    if (this.ycN.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    ac.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.ybv += 1;
    this.ycN.add(str2);
    if (paramp.Pe(32)) {
      this.yca += 1;
    }
    switch (paramp.field_type)
    {
    }
    while (paramp.Pe(32)) {
      if ((paramp.dFR() != null) && (paramp.dFR().dJG()))
      {
        qP(true);
        AppMethodBeat.o(96177);
        return;
        this.ybT += 1;
        continue;
        this.ybV += 1;
        continue;
        this.ybU += 1;
        continue;
        this.ybW += 1;
        continue;
        this.ybZ += 1;
        continue;
        if (!bs.isNullOrNil(paramp.dLV().FQp)) {
          this.ybR += 1;
        } else {
          this.ybS += 1;
        }
      }
      else
      {
        if (paramp.field_type == 1)
        {
          qU(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramp.field_type != 15) {
          break label444;
        }
        qV(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramp.dLV() != null) && (!bs.isNullOrNil(paramp.dLV().yCb)))
    {
      qQ(true);
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
      qO(true);
      AppMethodBeat.o(96177);
      return;
      qT(true);
      AppMethodBeat.o(96177);
      return;
      qR(true);
      AppMethodBeat.o(96177);
      return;
      qT(true);
      AppMethodBeat.o(96177);
      return;
      qX(true);
      AppMethodBeat.o(96177);
      return;
      if (!bs.isNullOrNil(paramp.dLV().FQp))
      {
        qS(true);
        AppMethodBeat.o(96177);
        return;
      }
      qT(true);
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
      this.ycR.add(q.l(paramp));
    }
    for (;;)
    {
      this.ycV.add(paramp.field_userName);
      this.ybw = this.ycV.size();
      if (!af.dHx().equals(paramp.field_userName)) {
        break;
      }
      qK(true);
      AppMethodBeat.o(96178);
      return;
      this.ycS.add(q.l(paramp));
    }
    qL(true);
    AppMethodBeat.o(96178);
  }
  
  public final void jj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.ycP.add(paramString2);
    this.ycX.add(paramString1);
    this.ybz = this.ycX.size();
    AppMethodBeat.o(96179);
  }
  
  public final void qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.yce = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.yce > 0L)
    {
      this.ycd += System.currentTimeMillis() - this.yce;
      this.yce = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void qK(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.ycg = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.ycg > 0L)
    {
      this.ycf += System.currentTimeMillis() - this.ycg;
      this.ycg = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void qL(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.yci = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.yci > 0L)
    {
      this.ych += System.currentTimeMillis() - this.yci;
      this.yci = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void qM(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.yck = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.yck > 0L)
    {
      this.ycj += System.currentTimeMillis() - this.yck;
      this.yck = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void qN(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.ycm = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.ycm > 0L)
    {
      this.ycl += System.currentTimeMillis() - this.ycm;
      this.ycm = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void qO(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.yco = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.yco > 0L)
    {
      this.ycn += System.currentTimeMillis() - this.yco;
      this.yco = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void qP(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.ycJ = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.ycJ > 0L)
    {
      this.ycI += System.currentTimeMillis() - this.ycJ;
      this.ycJ = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void qQ(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.ycL = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.ycL > 0L)
    {
      this.ycK += System.currentTimeMillis() - this.ycL;
      this.ycL = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void qR(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.ycq = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.ycq > 0L)
    {
      this.ycp += System.currentTimeMillis() - this.ycq;
      this.ycq = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void qS(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.ycs = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.ycs > 0L)
    {
      this.ycr += System.currentTimeMillis() - this.ycs;
      this.ycs = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.ycu = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.ycu > 0L)
    {
      this.yct += System.currentTimeMillis() - this.ycu;
      this.ycu = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.ycw = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.ycw > 0L)
    {
      this.ycv += System.currentTimeMillis() - this.ycw;
      this.ycw = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void qV(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.ycA = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.ycA > 0L)
    {
      this.ycz += System.currentTimeMillis() - this.ycA;
      this.ycA = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.ycC = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.ycC > 0L)
    {
      this.ycB += System.currentTimeMillis() - this.ycC;
      this.ycC = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void qX(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.ycE = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.ycE > 0L)
    {
      this.ycD += System.currentTimeMillis() - this.ycE;
      this.ycE = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void qY(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.ybI = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.c
 * JD-Core Version:    0.7.0.1
 */