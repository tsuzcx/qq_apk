package com.tencent.mm.plugin.sns.k;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xm;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class d
{
  public boolean KfM;
  public long KfN;
  public long KfO;
  public int KfP;
  int KfQ;
  int KfR;
  int KfS;
  public int KfT;
  public int KfU;
  int KfV;
  public int KfW;
  public int KfX;
  int KfY;
  public int KfZ;
  long KgA;
  long KgB;
  long KgC;
  long KgD;
  long KgE;
  long KgF;
  long KgG;
  long KgH;
  long KgI;
  long KgJ;
  long KgK;
  long KgL;
  long KgM;
  long KgN;
  long KgO;
  long KgP;
  long KgQ;
  long KgR;
  long KgS;
  long KgT;
  long KgU;
  long KgV;
  long KgW;
  long KgX;
  long KgY;
  long KgZ;
  public int Kga;
  public String Kgb;
  public String Kgc;
  String Kgd;
  int Kge;
  public int Kgf;
  public int Kgg;
  public int Kgh;
  public int Kgi;
  public int Kgj;
  public int Kgk;
  public int Kgl;
  public int Kgm;
  int Kgn;
  int Kgo;
  int Kgp;
  int Kgq;
  int Kgr;
  int Kgs;
  public int Kgt;
  public int Kgu;
  int Kgv;
  int Kgw;
  public long Kgx;
  public long Kgy;
  long Kgz;
  public HashSet<String> KhA;
  public HashSet<String> KhB;
  public HashSet<String> KhC;
  public HashSet<String> KhD;
  public HashSet<String> KhE;
  public HashSet<String> KhF;
  public HashSet<String> KhG;
  public HashSet<String> KhH;
  public HashSet<String> KhI;
  public HashSet<String> KhJ;
  public long KhK;
  long Kha;
  String Khb;
  int Khc;
  String Khd;
  long Khe;
  private long Khf;
  long Khg;
  private long Khh;
  private HashSet<String> Khi;
  HashSet<String> Khj;
  public HashSet<String> Khk;
  HashSet<String> Khl;
  public HashSet<String> Khm;
  HashSet<String> Khn;
  HashSet<String> Kho;
  public HashSet<String> Khp;
  public HashSet<String> Khq;
  HashSet<String> Khr;
  public HashSet<String> Khs;
  private HashSet<String> Kht;
  public HashSet<String> Khu;
  public HashSet<String> Khv;
  public int Khw;
  public int Khx;
  public HashSet<String> Khy;
  public HashSet<String> Khz;
  IListener iQL;
  int iRr;
  public int sxZ;
  
  public d()
  {
    AppMethodBeat.i(96195);
    this.KfM = false;
    this.KfN = -1L;
    this.KfO = 0L;
    this.KfP = 0;
    this.KfQ = 0;
    this.KfR = 0;
    this.KfS = 0;
    this.KfT = 0;
    this.KfU = 0;
    this.KfV = 0;
    this.KfW = 0;
    this.KfX = 0;
    this.KfY = 0;
    this.KfZ = 0;
    this.Kga = 0;
    this.Kgb = "";
    this.Kgc = "";
    this.Kgd = "";
    this.Kgf = 0;
    this.Kgg = 0;
    this.Kgh = 0;
    this.Kgi = 0;
    this.Kgj = 0;
    this.Kgk = 0;
    this.Kgl = 0;
    this.sxZ = 0;
    this.Kgm = 0;
    this.Kgn = 0;
    this.Kgo = 0;
    this.Kgp = 0;
    this.Kgq = 0;
    this.Kgr = 0;
    this.Kgs = 0;
    this.Kgt = 0;
    this.Kgu = 0;
    this.Kgv = 0;
    this.Kgw = 0;
    this.Kgx = 0L;
    this.Kgy = 0L;
    this.Kgz = 0L;
    this.KgA = 0L;
    this.KgB = 0L;
    this.KgC = 0L;
    this.KgD = 0L;
    this.KgE = 0L;
    this.KgF = 0L;
    this.KgG = 0L;
    this.KgH = 0L;
    this.KgI = 0L;
    this.KgJ = 0L;
    this.KgK = 0L;
    this.KgL = 0L;
    this.KgM = 0L;
    this.KgN = 0L;
    this.KgO = 0L;
    this.KgP = 0L;
    this.KgQ = 0L;
    this.KgR = 0L;
    this.KgS = 0L;
    this.KgT = 0L;
    this.KgU = 0L;
    this.KgV = 0L;
    this.KgW = 0L;
    this.KgX = 0L;
    this.KgY = 0L;
    this.KgZ = 0L;
    this.Kha = 0L;
    this.Khe = 0L;
    this.Khf = 0L;
    this.Khg = 0L;
    this.Khh = 0L;
    this.Khi = new HashSet();
    this.Khj = new HashSet();
    this.Khk = new HashSet();
    this.Khl = new HashSet();
    this.Khm = new HashSet();
    this.Khn = new HashSet();
    this.Kho = new HashSet();
    this.Khp = new HashSet();
    this.Khq = new HashSet();
    this.Khr = new HashSet();
    this.Khs = new HashSet();
    this.Kht = new HashSet();
    this.Khu = new HashSet();
    this.Khv = new HashSet();
    this.Khw = 2147483647;
    this.Khx = 0;
    this.Khy = new HashSet();
    this.Khz = new HashSet();
    this.KhA = new HashSet();
    this.KhB = new HashSet();
    this.KhC = new HashSet();
    this.KhD = new HashSet();
    this.KhE = new HashSet();
    this.KhF = new HashSet();
    this.KhG = new HashSet();
    this.KhH = new HashSet();
    this.KhI = new HashSet();
    this.KhJ = new HashSet();
    this.iQL = new IListener() {};
    this.KhK = 0L;
    EventCenter.instance.addListener(this.iQL);
    AppMethodBeat.o(96195);
  }
  
  public d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.iRr = paramInt1;
    this.Khb = paramString1;
    this.Khc = paramInt2;
    this.Khd = paramString2;
  }
  
  static String f(HashSet<String> paramHashSet)
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
  
  public final void M(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96176);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.Khi.add(paramSnsInfo.getLocalid());
    this.KfQ = this.Khi.size();
    AppMethodBeat.o(96176);
  }
  
  public final void N(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96177);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramSnsInfo.getLocalid();
    String str2 = t.w(paramSnsInfo);
    if (this.Khj.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    Log.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.KfR += 1;
    this.Khj.add(str2);
    if (paramSnsInfo.isAd()) {
      this.Kgw += 1;
    }
    switch (paramSnsInfo.field_type)
    {
    }
    while (paramSnsInfo.isAd()) {
      if ((paramSnsInfo.getAdXml() != null) && (paramSnsInfo.getAdXml().isLandingPagesAd()))
      {
        yC(true);
        AppMethodBeat.o(96177);
        return;
        this.Kgp += 1;
        continue;
        this.Kgr += 1;
        continue;
        this.Kgq += 1;
        continue;
        this.Kgs += 1;
        continue;
        this.Kgv += 1;
        continue;
        if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName)) {
          this.Kgn += 1;
        } else {
          this.Kgo += 1;
        }
      }
      else
      {
        if (paramSnsInfo.field_type == 1)
        {
          yH(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramSnsInfo.field_type != 15) {
          break label456;
        }
        yI(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramSnsInfo.getTimeLine() != null) && (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo)))
    {
      yD(true);
      AppMethodBeat.o(96177);
      return;
    }
    switch (paramSnsInfo.field_type)
    {
    }
    for (;;)
    {
      label456:
      AppMethodBeat.o(96177);
      return;
      yB(true);
      AppMethodBeat.o(96177);
      return;
      yG(true);
      AppMethodBeat.o(96177);
      return;
      yE(true);
      AppMethodBeat.o(96177);
      return;
      yG(true);
      AppMethodBeat.o(96177);
      return;
      yK(true);
      AppMethodBeat.o(96177);
      return;
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName))
      {
        yF(true);
        AppMethodBeat.o(96177);
        return;
      }
      yG(true);
    }
  }
  
  public final void e(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(96178);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96178);
      return;
    }
    if (paramBoolean) {
      this.Khn.add(t.w(paramSnsInfo));
    }
    for (;;)
    {
      this.Khr.add(paramSnsInfo.getUserName());
      this.KfS = this.Khr.size();
      if (!aj.fOo().equals(paramSnsInfo.getUserName())) {
        break;
      }
      yx(true);
      AppMethodBeat.o(96178);
      return;
      this.Kho.add(t.w(paramSnsInfo));
    }
    yy(true);
    AppMethodBeat.o(96178);
  }
  
  public final void kK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.Khl.add(paramString2);
    this.Kht.add(paramString1);
    this.KfV = this.Kht.size();
    AppMethodBeat.o(96179);
  }
  
  public final void yA(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.KgI = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.KgI > 0L)
    {
      this.KgH += System.currentTimeMillis() - this.KgI;
      this.KgI = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.KgK = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.KgK > 0L)
    {
      this.KgJ += System.currentTimeMillis() - this.KgK;
      this.KgK = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.Khf = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.Khf > 0L)
    {
      this.Khe += System.currentTimeMillis() - this.Khf;
      this.Khf = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void yD(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.Khh = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.Khh > 0L)
    {
      this.Khg += System.currentTimeMillis() - this.Khh;
      this.Khh = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void yE(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.KgM = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.KgM > 0L)
    {
      this.KgL += System.currentTimeMillis() - this.KgM;
      this.KgM = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.KgO = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.KgO > 0L)
    {
      this.KgN += System.currentTimeMillis() - this.KgO;
      this.KgO = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void yG(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.KgQ = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.KgQ > 0L)
    {
      this.KgP += System.currentTimeMillis() - this.KgQ;
      this.KgQ = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void yH(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.KgS = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.KgS > 0L)
    {
      this.KgR += System.currentTimeMillis() - this.KgS;
      this.KgS = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.KgW = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.KgW > 0L)
    {
      this.KgV += System.currentTimeMillis() - this.KgW;
      this.KgW = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.KgY = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.KgY > 0L)
    {
      this.KgX += System.currentTimeMillis() - this.KgY;
      this.KgY = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void yK(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.Kha = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.Kha > 0L)
    {
      this.KgZ += System.currentTimeMillis() - this.Kha;
      this.Kha = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void yw(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.KgA = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.KgA > 0L)
    {
      this.Kgz += System.currentTimeMillis() - this.KgA;
      this.KgA = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void yx(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.KgC = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.KgC > 0L)
    {
      this.KgB += System.currentTimeMillis() - this.KgC;
      this.KgC = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void yy(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.KgE = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.KgE > 0L)
    {
      this.KgD += System.currentTimeMillis() - this.KgE;
      this.KgE = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void yz(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.KgG = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.KgG > 0L)
    {
      this.KgF += System.currentTimeMillis() - this.KgG;
      this.KgG = 0L;
    }
    AppMethodBeat.o(96183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.d
 * JD-Core Version:    0.7.0.1
 */