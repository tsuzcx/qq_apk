package com.tencent.mm.plugin.sns.statistics;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class e
{
  int QDA;
  int QDB;
  int QDC;
  public int QDD;
  public int QDE;
  int QDF;
  public int QDG;
  public int QDH;
  int QDI;
  public int QDJ;
  public int QDK;
  public String QDL;
  public String QDM;
  String QDN;
  int QDO;
  public int QDP;
  public int QDQ;
  public int QDR;
  public int QDS;
  public int QDT;
  public int QDU;
  public int QDV;
  public int QDW;
  int QDX;
  int QDY;
  int QDZ;
  public boolean QDw;
  public long QDx;
  public long QDy;
  public int QDz;
  long QEA;
  long QEB;
  long QEC;
  long QED;
  long QEE;
  long QEF;
  long QEG;
  long QEH;
  long QEI;
  long QEJ;
  long QEK;
  String QEL;
  int QEM;
  String QEN;
  long QEO;
  private long QEP;
  long QEQ;
  private long QER;
  public long QES;
  public long QET;
  public long QEU;
  public HashSet<String> QEV;
  public HashSet<String> QEW;
  public HashSet<String> QEX;
  HashSet<String> QEY;
  public HashSet<String> QEZ;
  int QEa;
  int QEb;
  int QEc;
  public int QEd;
  public int QEe;
  int QEf;
  int QEg;
  public long QEh;
  public long QEi;
  long QEj;
  long QEk;
  long QEl;
  long QEm;
  long QEn;
  long QEo;
  long QEp;
  long QEq;
  long QEr;
  long QEs;
  long QEt;
  long QEu;
  long QEv;
  long QEw;
  long QEx;
  long QEy;
  long QEz;
  HashSet<String> QFa;
  public HashSet<String> QFb;
  HashSet<String> QFc;
  HashSet<String> QFd;
  public HashSet<String> QFe;
  public HashSet<String> QFf;
  HashSet<String> QFg;
  public HashSet<String> QFh;
  private HashSet<String> QFi;
  public HashSet<String> QFj;
  public HashSet<String> QFk;
  public int QFl;
  public int QFm;
  public HashSet<String> QFn;
  public HashSet<String> QFo;
  public HashSet<String> QFp;
  public HashSet<String> QFq;
  public HashSet<String> QFr;
  public HashSet<String> QFs;
  public HashSet<String> QFt;
  public HashSet<String> QFu;
  public HashSet<String> QFv;
  public HashSet<String> QFw;
  public HashSet<String> QFx;
  public HashSet<String> QFy;
  public long QFz;
  IListener lsH;
  int ltn;
  public int vDI;
  
  public e()
  {
    AppMethodBeat.i(96195);
    this.QDw = false;
    this.QDx = -1L;
    this.QDy = 0L;
    this.QDz = 0;
    this.QDA = 0;
    this.QDB = 0;
    this.QDC = 0;
    this.QDD = 0;
    this.QDE = 0;
    this.QDF = 0;
    this.QDG = 0;
    this.QDH = 0;
    this.QDI = 0;
    this.QDJ = 0;
    this.QDK = 0;
    this.QDL = "";
    this.QDM = "";
    this.QDN = "";
    this.QDP = 0;
    this.QDQ = 0;
    this.QDR = 0;
    this.QDS = 0;
    this.QDT = 0;
    this.QDU = 0;
    this.QDV = 0;
    this.vDI = 0;
    this.QDW = 0;
    this.QDX = 0;
    this.QDY = 0;
    this.QDZ = 0;
    this.QEa = 0;
    this.QEb = 0;
    this.QEc = 0;
    this.QEd = 0;
    this.QEe = 0;
    this.QEf = 0;
    this.QEg = 0;
    this.QEh = 0L;
    this.QEi = 0L;
    this.QEj = 0L;
    this.QEk = 0L;
    this.QEl = 0L;
    this.QEm = 0L;
    this.QEn = 0L;
    this.QEo = 0L;
    this.QEp = 0L;
    this.QEq = 0L;
    this.QEr = 0L;
    this.QEs = 0L;
    this.QEt = 0L;
    this.QEu = 0L;
    this.QEv = 0L;
    this.QEw = 0L;
    this.QEx = 0L;
    this.QEy = 0L;
    this.QEz = 0L;
    this.QEA = 0L;
    this.QEB = 0L;
    this.QEC = 0L;
    this.QED = 0L;
    this.QEE = 0L;
    this.QEF = 0L;
    this.QEG = 0L;
    this.QEH = 0L;
    this.QEI = 0L;
    this.QEJ = 0L;
    this.QEK = 0L;
    this.QEO = 0L;
    this.QEP = 0L;
    this.QEQ = 0L;
    this.QER = 0L;
    this.QES = 0L;
    this.QET = 0L;
    this.QEU = 0L;
    this.QEV = new HashSet();
    this.QEW = new HashSet();
    this.QEX = new HashSet();
    this.QEY = new HashSet();
    this.QEZ = new HashSet();
    this.QFa = new HashSet();
    this.QFb = new HashSet();
    this.QFc = new HashSet();
    this.QFd = new HashSet();
    this.QFe = new HashSet();
    this.QFf = new HashSet();
    this.QFg = new HashSet();
    this.QFh = new HashSet();
    this.QFi = new HashSet();
    this.QFj = new HashSet();
    this.QFk = new HashSet();
    this.QFl = 2147483647;
    this.QFm = 0;
    this.QFn = new HashSet();
    this.QFo = new HashSet();
    this.QFp = new HashSet();
    this.QFq = new HashSet();
    this.QFr = new HashSet();
    this.QFs = new HashSet();
    this.QFt = new HashSet();
    this.QFu = new HashSet();
    this.QFv = new HashSet();
    this.QFw = new HashSet();
    this.QFx = new HashSet();
    this.QFy = new HashSet();
    this.lsH = new SnsBrowseInfoHelper.1(this, f.hfK);
    this.QFz = 0L;
    this.lsH.alive();
    AppMethodBeat.o(96195);
  }
  
  public e(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.ltn = paramInt1;
    this.QEL = paramString1;
    this.QEM = paramInt2;
    this.QEN = paramString2;
  }
  
  static String h(HashSet<String> paramHashSet)
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
  
  public final void DE(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.QEk = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.QEk > 0L)
    {
      this.QEj += System.currentTimeMillis() - this.QEk;
      this.QEk = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void DF(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.QEm = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.QEm > 0L)
    {
      this.QEl += System.currentTimeMillis() - this.QEm;
      this.QEm = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void DG(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.QEo = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.QEo > 0L)
    {
      this.QEn += System.currentTimeMillis() - this.QEo;
      this.QEo = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void DH(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.QEq = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.QEq > 0L)
    {
      this.QEp += System.currentTimeMillis() - this.QEq;
      this.QEq = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void DI(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.QEs = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.QEs > 0L)
    {
      this.QEr += System.currentTimeMillis() - this.QEs;
      this.QEs = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void DJ(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.QEu = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.QEu > 0L)
    {
      this.QEt += System.currentTimeMillis() - this.QEu;
      this.QEu = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void DK(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.QEP = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.QEP > 0L)
    {
      this.QEO += System.currentTimeMillis() - this.QEP;
      this.QEP = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void DL(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.QER = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.QER > 0L)
    {
      this.QEQ += System.currentTimeMillis() - this.QER;
      this.QER = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void DM(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.QEw = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.QEw > 0L)
    {
      this.QEv += System.currentTimeMillis() - this.QEw;
      this.QEw = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void DN(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.QEy = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.QEy > 0L)
    {
      this.QEx += System.currentTimeMillis() - this.QEy;
      this.QEy = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void DO(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.QEA = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.QEA > 0L)
    {
      this.QEz += System.currentTimeMillis() - this.QEA;
      this.QEA = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void DP(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.QEC = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.QEC > 0L)
    {
      this.QEB += System.currentTimeMillis() - this.QEC;
      this.QEC = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void DQ(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.QEG = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.QEG > 0L)
    {
      this.QEF += System.currentTimeMillis() - this.QEG;
      this.QEG = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void DR(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.QEI = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.QEI > 0L)
    {
      this.QEH += System.currentTimeMillis() - this.QEI;
      this.QEI = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void DS(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.QEK = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.QEK > 0L)
    {
      this.QEJ += System.currentTimeMillis() - this.QEK;
      this.QEK = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void O(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96176);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.QEV.add(paramSnsInfo.getLocalid());
    this.QDA = this.QEV.size();
    AppMethodBeat.o(96176);
  }
  
  public final void P(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96177);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramSnsInfo.getLocalid();
    String str2 = t.x(paramSnsInfo);
    if (this.QEY.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    Log.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.QDB += 1;
    this.QEY.add(str2);
    if (paramSnsInfo.isAd()) {
      this.QEg += 1;
    }
    switch (paramSnsInfo.field_type)
    {
    }
    while (paramSnsInfo.isAd()) {
      if ((paramSnsInfo.getAdXml() != null) && (paramSnsInfo.getAdXml().isLandingPagesAd()))
      {
        DK(true);
        AppMethodBeat.o(96177);
        return;
        this.QDZ += 1;
        continue;
        this.QEb += 1;
        continue;
        this.QEa += 1;
        continue;
        this.QEc += 1;
        continue;
        this.QEf += 1;
        continue;
        if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName)) {
          this.QDX += 1;
        } else {
          this.QDY += 1;
        }
      }
      else
      {
        if (paramSnsInfo.field_type == 1)
        {
          DP(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramSnsInfo.field_type != 15) {
          break label456;
        }
        DQ(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramSnsInfo.getTimeLine() != null) && (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo)))
    {
      DL(true);
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
      DJ(true);
      AppMethodBeat.o(96177);
      return;
      DO(true);
      AppMethodBeat.o(96177);
      return;
      DM(true);
      AppMethodBeat.o(96177);
      return;
      DO(true);
      AppMethodBeat.o(96177);
      return;
      DS(true);
      AppMethodBeat.o(96177);
      return;
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName))
      {
        DN(true);
        AppMethodBeat.o(96177);
        return;
      }
      DO(true);
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
      this.QFc.add(t.x(paramSnsInfo));
    }
    for (;;)
    {
      this.QFg.add(paramSnsInfo.getUserName());
      this.QDC = this.QFg.size();
      if (!al.hgg().equals(paramSnsInfo.getUserName())) {
        break;
      }
      DF(true);
      AppMethodBeat.o(96178);
      return;
      this.QFd.add(t.x(paramSnsInfo));
    }
    DG(true);
    AppMethodBeat.o(96178);
  }
  
  public final void mr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.QFa.add(paramString2);
    this.QFi.add(paramString1);
    this.QDF = this.QFi.size();
    AppMethodBeat.o(96179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.e
 * JD-Core Version:    0.7.0.1
 */