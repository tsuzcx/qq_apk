package com.tencent.mm.plugin.sns.j;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  int fHW;
  c fHr;
  public int oec;
  public boolean zIA;
  public long zIB;
  public long zIC;
  public int zID;
  int zIE;
  int zIF;
  int zIG;
  public int zIH;
  public int zII;
  int zIJ;
  public int zIK;
  public int zIL;
  int zIM;
  public int zIN;
  public int zIO;
  public String zIP;
  public String zIQ;
  String zIR;
  int zIS;
  public int zIT;
  public int zIU;
  public int zIV;
  public int zIW;
  public int zIX;
  public int zIY;
  public int zIZ;
  long zJA;
  long zJB;
  long zJC;
  long zJD;
  long zJE;
  long zJF;
  long zJG;
  long zJH;
  long zJI;
  long zJJ;
  long zJK;
  long zJL;
  long zJM;
  long zJN;
  long zJO;
  String zJP;
  int zJQ;
  String zJR;
  long zJS;
  private long zJT;
  long zJU;
  private long zJV;
  private HashSet<String> zJW;
  HashSet<String> zJX;
  public HashSet<String> zJY;
  HashSet<String> zJZ;
  public int zJa;
  int zJb;
  int zJc;
  int zJd;
  int zJe;
  int zJf;
  int zJg;
  public int zJh;
  public int zJi;
  int zJj;
  int zJk;
  public long zJl;
  public long zJm;
  long zJn;
  long zJo;
  long zJp;
  long zJq;
  long zJr;
  long zJs;
  long zJt;
  long zJu;
  long zJv;
  long zJw;
  long zJx;
  long zJy;
  long zJz;
  public HashSet<String> zKa;
  HashSet<String> zKb;
  HashSet<String> zKc;
  public HashSet<String> zKd;
  public HashSet<String> zKe;
  HashSet<String> zKf;
  public HashSet<String> zKg;
  private HashSet<String> zKh;
  public HashSet<String> zKi;
  public HashSet<String> zKj;
  public int zKk;
  public int zKl;
  public HashSet<String> zKm;
  public HashSet<String> zKn;
  public HashSet<String> zKo;
  public HashSet<String> zKp;
  public HashSet<String> zKq;
  public HashSet<String> zKr;
  public HashSet<String> zKs;
  public HashSet<String> zKt;
  public HashSet<String> zKu;
  public HashSet<String> zKv;
  public HashSet<String> zKw;
  public HashSet<String> zKx;
  public long zKy;
  
  public b()
  {
    AppMethodBeat.i(96195);
    this.zIA = false;
    this.zIB = -1L;
    this.zIC = 0L;
    this.zID = 0;
    this.zIE = 0;
    this.zIF = 0;
    this.zIG = 0;
    this.zIH = 0;
    this.zII = 0;
    this.zIJ = 0;
    this.zIK = 0;
    this.zIL = 0;
    this.zIM = 0;
    this.zIN = 0;
    this.zIO = 0;
    this.zIP = "";
    this.zIQ = "";
    this.zIR = "";
    this.zIT = 0;
    this.zIU = 0;
    this.zIV = 0;
    this.zIW = 0;
    this.zIX = 0;
    this.zIY = 0;
    this.zIZ = 0;
    this.oec = 0;
    this.zJa = 0;
    this.zJb = 0;
    this.zJc = 0;
    this.zJd = 0;
    this.zJe = 0;
    this.zJf = 0;
    this.zJg = 0;
    this.zJh = 0;
    this.zJi = 0;
    this.zJj = 0;
    this.zJk = 0;
    this.zJl = 0L;
    this.zJm = 0L;
    this.zJn = 0L;
    this.zJo = 0L;
    this.zJp = 0L;
    this.zJq = 0L;
    this.zJr = 0L;
    this.zJs = 0L;
    this.zJt = 0L;
    this.zJu = 0L;
    this.zJv = 0L;
    this.zJw = 0L;
    this.zJx = 0L;
    this.zJy = 0L;
    this.zJz = 0L;
    this.zJA = 0L;
    this.zJB = 0L;
    this.zJC = 0L;
    this.zJD = 0L;
    this.zJE = 0L;
    this.zJF = 0L;
    this.zJG = 0L;
    this.zJH = 0L;
    this.zJI = 0L;
    this.zJJ = 0L;
    this.zJK = 0L;
    this.zJL = 0L;
    this.zJM = 0L;
    this.zJN = 0L;
    this.zJO = 0L;
    this.zJS = 0L;
    this.zJT = 0L;
    this.zJU = 0L;
    this.zJV = 0L;
    this.zJW = new HashSet();
    this.zJX = new HashSet();
    this.zJY = new HashSet();
    this.zJZ = new HashSet();
    this.zKa = new HashSet();
    this.zKb = new HashSet();
    this.zKc = new HashSet();
    this.zKd = new HashSet();
    this.zKe = new HashSet();
    this.zKf = new HashSet();
    this.zKg = new HashSet();
    this.zKh = new HashSet();
    this.zKi = new HashSet();
    this.zKj = new HashSet();
    this.zKk = 2147483647;
    this.zKl = 0;
    this.zKm = new HashSet();
    this.zKn = new HashSet();
    this.zKo = new HashSet();
    this.zKp = new HashSet();
    this.zKq = new HashSet();
    this.zKr = new HashSet();
    this.zKs = new HashSet();
    this.zKt = new HashSet();
    this.zKu = new HashSet();
    this.zKv = new HashSet();
    this.zKw = new HashSet();
    this.zKx = new HashSet();
    this.fHr = new c() {};
    this.zKy = 0L;
    com.tencent.mm.sdk.b.a.IvT.c(this.fHr);
    AppMethodBeat.o(96195);
  }
  
  public b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.fHW = paramInt1;
    this.zJP = paramString1;
    this.zJQ = paramInt2;
    this.zJR = paramString2;
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
    this.zJW.add(paramp.eco());
    this.zIE = this.zJW.size();
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
    String str1 = paramp.eco();
    String str2 = r.o(paramp);
    if (this.zJX.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    ae.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.zIF += 1;
    this.zJX.add(str2);
    if (paramp.Rt(32)) {
      this.zJk += 1;
    }
    switch (paramp.field_type)
    {
    }
    while (paramp.Rt(32)) {
      if ((paramp.dVj() != null) && (paramp.dVj().dZv()))
      {
        rz(true);
        AppMethodBeat.o(96177);
        return;
        this.zJd += 1;
        continue;
        this.zJf += 1;
        continue;
        this.zJe += 1;
        continue;
        this.zJg += 1;
        continue;
        this.zJj += 1;
        continue;
        if (!bu.isNullOrNil(paramp.ebP().HUH)) {
          this.zJb += 1;
        } else {
          this.zJc += 1;
        }
      }
      else
      {
        if (paramp.field_type == 1)
        {
          rE(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramp.field_type != 15) {
          break label444;
        }
        rF(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramp.ebP() != null) && (!bu.isNullOrNil(paramp.ebP().AkC)))
    {
      rA(true);
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
      ry(true);
      AppMethodBeat.o(96177);
      return;
      rD(true);
      AppMethodBeat.o(96177);
      return;
      rB(true);
      AppMethodBeat.o(96177);
      return;
      rD(true);
      AppMethodBeat.o(96177);
      return;
      rH(true);
      AppMethodBeat.o(96177);
      return;
      if (!bu.isNullOrNil(paramp.ebP().HUH))
      {
        rC(true);
        AppMethodBeat.o(96177);
        return;
      }
      rD(true);
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
      this.zKb.add(r.o(paramp));
    }
    for (;;)
    {
      this.zKf.add(paramp.field_userName);
      this.zIG = this.zKf.size();
      if (!ah.dXj().equals(paramp.field_userName)) {
        break;
      }
      ru(true);
      AppMethodBeat.o(96178);
      return;
      this.zKc.add(r.o(paramp));
    }
    rv(true);
    AppMethodBeat.o(96178);
  }
  
  public final void jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.zJZ.add(paramString2);
    this.zKh.add(paramString1);
    this.zIJ = this.zKh.size();
    AppMethodBeat.o(96179);
  }
  
  public final void rA(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.zJV = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.zJV > 0L)
    {
      this.zJU += System.currentTimeMillis() - this.zJV;
      this.zJV = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void rB(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.zJA = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.zJA > 0L)
    {
      this.zJz += System.currentTimeMillis() - this.zJA;
      this.zJA = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void rC(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.zJC = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.zJC > 0L)
    {
      this.zJB += System.currentTimeMillis() - this.zJC;
      this.zJC = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void rD(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.zJE = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.zJE > 0L)
    {
      this.zJD += System.currentTimeMillis() - this.zJE;
      this.zJE = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.zJG = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.zJG > 0L)
    {
      this.zJF += System.currentTimeMillis() - this.zJG;
      this.zJG = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void rF(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.zJK = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.zJK > 0L)
    {
      this.zJJ += System.currentTimeMillis() - this.zJK;
      this.zJK = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void rG(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.zJM = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.zJM > 0L)
    {
      this.zJL += System.currentTimeMillis() - this.zJM;
      this.zJM = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void rH(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.zJO = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.zJO > 0L)
    {
      this.zJN += System.currentTimeMillis() - this.zJO;
      this.zJO = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void rI(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.zIS = i;
      return;
    }
  }
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.zJo = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.zJo > 0L)
    {
      this.zJn += System.currentTimeMillis() - this.zJo;
      this.zJo = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.zJq = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.zJq > 0L)
    {
      this.zJp += System.currentTimeMillis() - this.zJq;
      this.zJq = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.zJs = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.zJs > 0L)
    {
      this.zJr += System.currentTimeMillis() - this.zJs;
      this.zJs = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void rw(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.zJu = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.zJu > 0L)
    {
      this.zJt += System.currentTimeMillis() - this.zJu;
      this.zJu = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.zJw = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.zJw > 0L)
    {
      this.zJv += System.currentTimeMillis() - this.zJw;
      this.zJw = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.zJy = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.zJy > 0L)
    {
      this.zJx += System.currentTimeMillis() - this.zJy;
      this.zJy = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.zJT = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.zJT > 0L)
    {
      this.zJS += System.currentTimeMillis() - this.zJT;
      this.zJT = 0L;
    }
    AppMethodBeat.o(96186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b
 * JD-Core Version:    0.7.0.1
 */