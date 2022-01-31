package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  int diO;
  c dii = new b.1(this);
  public int idv = 0;
  public boolean oxB = false;
  public long oxC = -1L;
  public long oxD = 0L;
  public int oxE = 0;
  int oxF = 0;
  int oxG = 0;
  int oxH = 0;
  public int oxI = 0;
  public int oxJ = 0;
  int oxK = 0;
  public int oxL = 0;
  public int oxM = 0;
  int oxN = 0;
  public int oxO = 0;
  public int oxP = 0;
  public String oxQ = "";
  public String oxR = "";
  String oxS = "";
  int oxT;
  public int oxU = 0;
  public int oxV = 0;
  public int oxW = 0;
  public int oxX = 0;
  public int oxY = 0;
  public int oxZ = 0;
  long oyA = 0L;
  long oyB = 0L;
  long oyC = 0L;
  long oyD = 0L;
  long oyE = 0L;
  long oyF = 0L;
  long oyG = 0L;
  long oyH = 0L;
  long oyI = 0L;
  long oyJ = 0L;
  long oyK = 0L;
  long oyL = 0L;
  long oyM = 0L;
  long oyN = 0L;
  long oyO = 0L;
  long oyP = 0L;
  String oyQ;
  int oyR;
  long oyS = 0L;
  private long oyT = 0L;
  long oyU = 0L;
  private long oyV = 0L;
  private HashSet<String> oyW = new HashSet();
  HashSet<String> oyX = new HashSet();
  public HashSet<String> oyY = new HashSet();
  HashSet<String> oyZ = new HashSet();
  public int oya = 0;
  public int oyb = 0;
  int oyc = 0;
  int oyd = 0;
  int oye = 0;
  int oyf = 0;
  int oyg = 0;
  int oyh = 0;
  public int oyi = 0;
  public int oyj = 0;
  int oyk = 0;
  int oyl = 0;
  public long oym = 0L;
  public long oyn = 0L;
  long oyo = 0L;
  long oyp = 0L;
  long oyq = 0L;
  long oyr = 0L;
  long oys = 0L;
  long oyt = 0L;
  long oyu = 0L;
  long oyv = 0L;
  long oyw = 0L;
  long oyx = 0L;
  long oyy = 0L;
  long oyz = 0L;
  public HashSet<String> oza = new HashSet();
  HashSet<String> ozb = new HashSet();
  HashSet<String> ozc = new HashSet();
  public HashSet<String> ozd = new HashSet();
  public HashSet<String> oze = new HashSet();
  HashSet<String> ozf = new HashSet();
  public HashSet<String> ozg = new HashSet();
  private HashSet<String> ozh = new HashSet();
  public HashSet<String> ozi = new HashSet();
  public HashSet<String> ozj = new HashSet();
  public int ozk = 2147483647;
  public int ozl = 0;
  public HashSet<String> ozm = new HashSet();
  public HashSet<String> ozn = new HashSet();
  public HashSet<String> ozo = new HashSet();
  public HashSet<String> ozp = new HashSet();
  public HashSet<String> ozq = new HashSet();
  public HashSet<String> ozr = new HashSet();
  public HashSet<String> ozs = new HashSet();
  public HashSet<String> ozt = new HashSet();
  public HashSet<String> ozu = new HashSet();
  public HashSet<String> ozv = new HashSet();
  public HashSet<String> ozw = new HashSet();
  public HashSet<String> ozx = new HashSet();
  public long ozy = 0L;
  
  public b()
  {
    a.udP.c(this.dii);
  }
  
  public b(int paramInt1, String paramString, int paramInt2)
  {
    this();
    this.diO = paramInt1;
    this.oyQ = paramString;
    this.oyR = paramInt2;
  }
  
  static String f(HashSet<String> paramHashSet)
  {
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
        localStringBuffer.append("|" + str);
      }
    }
    return localStringBuffer.toString();
  }
  
  public final void a(n paramn, boolean paramBoolean)
  {
    if (paramn == null) {
      return;
    }
    if (paramBoolean) {
      this.ozb.add(i.j(paramn));
    }
    for (;;)
    {
      this.ozf.add(paramn.field_userName);
      this.oxH = this.ozf.size();
      if (!af.bDl().equals(paramn.field_userName)) {
        break;
      }
      iX(true);
      return;
      this.ozc.add(i.j(paramn));
    }
    iY(true);
  }
  
  public final void eP(String paramString1, String paramString2)
  {
    this.oyZ.add(paramString2);
    this.ozh.add(paramString1);
    this.oxK = this.ozh.size();
  }
  
  public final void iW(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyp = System.currentTimeMillis();
    }
    while (this.oyp <= 0L) {
      return;
    }
    this.oyo += System.currentTimeMillis() - this.oyp;
    this.oyp = 0L;
  }
  
  public final void iX(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyr = System.currentTimeMillis();
    }
    while (this.oyr <= 0L) {
      return;
    }
    this.oyq += System.currentTimeMillis() - this.oyr;
    this.oyr = 0L;
  }
  
  public final void iY(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyt = System.currentTimeMillis();
    }
    while (this.oyt <= 0L) {
      return;
    }
    this.oys += System.currentTimeMillis() - this.oyt;
    this.oyt = 0L;
  }
  
  public final void iZ(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyv = System.currentTimeMillis();
    }
    while (this.oyv <= 0L) {
      return;
    }
    this.oyu += System.currentTimeMillis() - this.oyv;
    this.oyv = 0L;
  }
  
  public final void ja(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyx = System.currentTimeMillis();
    }
    while (this.oyx <= 0L) {
      return;
    }
    this.oyw += System.currentTimeMillis() - this.oyx;
    this.oyx = 0L;
  }
  
  public final void jb(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyz = System.currentTimeMillis();
    }
    while (this.oyz <= 0L) {
      return;
    }
    this.oyy += System.currentTimeMillis() - this.oyz;
    this.oyz = 0L;
  }
  
  public final void jc(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyT = System.currentTimeMillis();
    }
    while (this.oyT <= 0L) {
      return;
    }
    this.oyS += System.currentTimeMillis() - this.oyT;
    this.oyT = 0L;
  }
  
  public final void jd(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyV = System.currentTimeMillis();
    }
    while (this.oyV <= 0L) {
      return;
    }
    this.oyU += System.currentTimeMillis() - this.oyV;
    this.oyV = 0L;
  }
  
  public final void je(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyB = System.currentTimeMillis();
    }
    while (this.oyB <= 0L) {
      return;
    }
    this.oyA += System.currentTimeMillis() - this.oyB;
    this.oyB = 0L;
  }
  
  public final void jf(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyD = System.currentTimeMillis();
    }
    while (this.oyD <= 0L) {
      return;
    }
    this.oyC += System.currentTimeMillis() - this.oyD;
    this.oyD = 0L;
  }
  
  public final void jg(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyF = System.currentTimeMillis();
    }
    while (this.oyF <= 0L) {
      return;
    }
    this.oyE += System.currentTimeMillis() - this.oyF;
    this.oyF = 0L;
  }
  
  public final void jh(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyH = System.currentTimeMillis();
    }
    while (this.oyH <= 0L) {
      return;
    }
    this.oyG += System.currentTimeMillis() - this.oyH;
    this.oyH = 0L;
  }
  
  public final void ji(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyL = System.currentTimeMillis();
    }
    while (this.oyL <= 0L) {
      return;
    }
    this.oyK += System.currentTimeMillis() - this.oyL;
    this.oyL = 0L;
  }
  
  public final void jj(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyN = System.currentTimeMillis();
    }
    while (this.oyN <= 0L) {
      return;
    }
    this.oyM += System.currentTimeMillis() - this.oyN;
    this.oyN = 0L;
  }
  
  public final void jk(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oyP = System.currentTimeMillis();
    }
    while (this.oyP <= 0L) {
      return;
    }
    this.oyO += System.currentTimeMillis() - this.oyP;
    this.oyP = 0L;
  }
  
  public final void jl(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.oxT = i;
      return;
    }
  }
  
  public final void x(n paramn)
  {
    if (paramn == null) {
      return;
    }
    this.oyW.add(paramn.bGE());
    this.oxF = this.oyW.size();
  }
  
  public final void y(n paramn)
  {
    if (paramn == null) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = paramn.bGE();
        str2 = i.j(paramn);
      } while (this.oyX.contains(str2));
      y.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
      this.oxG += 1;
      this.oyX.add(str2);
      if (paramn.yr(32)) {
        this.oyl += 1;
      }
      switch (paramn.field_type)
      {
      }
      for (;;)
      {
        if (!paramn.yr(32)) {
          break label313;
        }
        if ((paramn.bFZ() == null) || (!paramn.bFZ().bEE())) {
          break;
        }
        jc(true);
        return;
        this.oye += 1;
        continue;
        this.oyg += 1;
        continue;
        this.oyf += 1;
        continue;
        this.oyh += 1;
        continue;
        this.oyk += 1;
        continue;
        if (!bk.bl(paramn.bGe().tNs)) {
          this.oyc += 1;
        } else {
          this.oyd += 1;
        }
      }
      if (paramn.field_type == 1)
      {
        jh(true);
        return;
      }
    } while (paramn.field_type != 15);
    ji(true);
    return;
    label313:
    if ((paramn.bGe() != null) && (!bk.bl(paramn.bGe().pjl)))
    {
      jd(true);
      return;
    }
    switch (paramn.field_type)
    {
    default: 
      return;
    case 1: 
      jb(true);
      return;
    case 4: 
      jg(true);
      return;
    case 15: 
      je(true);
      return;
    case 5: 
      jg(true);
      return;
    case 18: 
      jk(true);
      return;
    }
    if (!bk.bl(paramn.bGe().tNs))
    {
      jf(true);
      return;
    }
    jg(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */