package com.tencent.mm.plugin.sns.k;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  public boolean DSC;
  public long DSD;
  public long DSE;
  public int DSF;
  int DSG;
  int DSH;
  int DSI;
  public int DSJ;
  public int DSK;
  int DSL;
  public int DSM;
  public int DSN;
  int DSO;
  public int DSP;
  public int DSQ;
  public String DSR;
  public String DSS;
  String DST;
  int DSU;
  public int DSV;
  public int DSW;
  public int DSX;
  public int DSY;
  public int DSZ;
  long DTA;
  long DTB;
  long DTC;
  long DTD;
  long DTE;
  long DTF;
  long DTG;
  long DTH;
  long DTI;
  long DTJ;
  long DTK;
  long DTL;
  long DTM;
  long DTN;
  long DTO;
  long DTP;
  long DTQ;
  String DTR;
  int DTS;
  String DTT;
  long DTU;
  private long DTV;
  long DTW;
  private long DTX;
  private HashSet<String> DTY;
  HashSet<String> DTZ;
  public int DTa;
  public int DTb;
  public int DTc;
  int DTd;
  int DTe;
  int DTf;
  int DTg;
  int DTh;
  int DTi;
  public int DTj;
  public int DTk;
  int DTl;
  int DTm;
  public long DTn;
  public long DTo;
  long DTp;
  long DTq;
  long DTr;
  long DTs;
  long DTt;
  long DTu;
  long DTv;
  long DTw;
  long DTx;
  long DTy;
  long DTz;
  public long DUA;
  public HashSet<String> DUa;
  HashSet<String> DUb;
  public HashSet<String> DUc;
  HashSet<String> DUd;
  HashSet<String> DUe;
  public HashSet<String> DUf;
  public HashSet<String> DUg;
  HashSet<String> DUh;
  public HashSet<String> DUi;
  private HashSet<String> DUj;
  public HashSet<String> DUk;
  public HashSet<String> DUl;
  public int DUm;
  public int DUn;
  public HashSet<String> DUo;
  public HashSet<String> DUp;
  public HashSet<String> DUq;
  public HashSet<String> DUr;
  public HashSet<String> DUs;
  public HashSet<String> DUt;
  public HashSet<String> DUu;
  public HashSet<String> DUv;
  public HashSet<String> DUw;
  public HashSet<String> DUx;
  public HashSet<String> DUy;
  public HashSet<String> DUz;
  IListener gmC;
  int gni;
  public int ppa;
  
  public b()
  {
    AppMethodBeat.i(96195);
    this.DSC = false;
    this.DSD = -1L;
    this.DSE = 0L;
    this.DSF = 0;
    this.DSG = 0;
    this.DSH = 0;
    this.DSI = 0;
    this.DSJ = 0;
    this.DSK = 0;
    this.DSL = 0;
    this.DSM = 0;
    this.DSN = 0;
    this.DSO = 0;
    this.DSP = 0;
    this.DSQ = 0;
    this.DSR = "";
    this.DSS = "";
    this.DST = "";
    this.DSV = 0;
    this.DSW = 0;
    this.DSX = 0;
    this.DSY = 0;
    this.DSZ = 0;
    this.DTa = 0;
    this.DTb = 0;
    this.ppa = 0;
    this.DTc = 0;
    this.DTd = 0;
    this.DTe = 0;
    this.DTf = 0;
    this.DTg = 0;
    this.DTh = 0;
    this.DTi = 0;
    this.DTj = 0;
    this.DTk = 0;
    this.DTl = 0;
    this.DTm = 0;
    this.DTn = 0L;
    this.DTo = 0L;
    this.DTp = 0L;
    this.DTq = 0L;
    this.DTr = 0L;
    this.DTs = 0L;
    this.DTt = 0L;
    this.DTu = 0L;
    this.DTv = 0L;
    this.DTw = 0L;
    this.DTx = 0L;
    this.DTy = 0L;
    this.DTz = 0L;
    this.DTA = 0L;
    this.DTB = 0L;
    this.DTC = 0L;
    this.DTD = 0L;
    this.DTE = 0L;
    this.DTF = 0L;
    this.DTG = 0L;
    this.DTH = 0L;
    this.DTI = 0L;
    this.DTJ = 0L;
    this.DTK = 0L;
    this.DTL = 0L;
    this.DTM = 0L;
    this.DTN = 0L;
    this.DTO = 0L;
    this.DTP = 0L;
    this.DTQ = 0L;
    this.DTU = 0L;
    this.DTV = 0L;
    this.DTW = 0L;
    this.DTX = 0L;
    this.DTY = new HashSet();
    this.DTZ = new HashSet();
    this.DUa = new HashSet();
    this.DUb = new HashSet();
    this.DUc = new HashSet();
    this.DUd = new HashSet();
    this.DUe = new HashSet();
    this.DUf = new HashSet();
    this.DUg = new HashSet();
    this.DUh = new HashSet();
    this.DUi = new HashSet();
    this.DUj = new HashSet();
    this.DUk = new HashSet();
    this.DUl = new HashSet();
    this.DUm = 2147483647;
    this.DUn = 0;
    this.DUo = new HashSet();
    this.DUp = new HashSet();
    this.DUq = new HashSet();
    this.DUr = new HashSet();
    this.DUs = new HashSet();
    this.DUt = new HashSet();
    this.DUu = new HashSet();
    this.DUv = new HashSet();
    this.DUw = new HashSet();
    this.DUx = new HashSet();
    this.DUy = new HashSet();
    this.DUz = new HashSet();
    this.gmC = new IListener() {};
    this.DUA = 0L;
    EventCenter.instance.addListener(this.gmC);
    AppMethodBeat.o(96195);
  }
  
  public b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this();
    this.gni = paramInt1;
    this.DTR = paramString1;
    this.DTS = paramInt2;
    this.DTT = paramString2;
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
  
  public final void L(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96176);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96176);
      return;
    }
    this.DTY.add(paramSnsInfo.getLocalid());
    this.DSG = this.DTY.size();
    AppMethodBeat.o(96176);
  }
  
  public final void M(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96177);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(96177);
      return;
    }
    String str1 = paramSnsInfo.getLocalid();
    String str2 = r.v(paramSnsInfo);
    if (this.DTZ.contains(str2))
    {
      AppMethodBeat.o(96177);
      return;
    }
    Log.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[] { str1, str2 });
    this.DSH += 1;
    this.DTZ.add(str2);
    if (paramSnsInfo.isAd()) {
      this.DTm += 1;
    }
    switch (paramSnsInfo.field_type)
    {
    }
    while (paramSnsInfo.isAd()) {
      if ((paramSnsInfo.getAdXml() != null) && (paramSnsInfo.getAdXml().isLandingPagesAd()))
      {
        uV(true);
        AppMethodBeat.o(96177);
        return;
        this.DTf += 1;
        continue;
        this.DTh += 1;
        continue;
        this.DTg += 1;
        continue;
        this.DTi += 1;
        continue;
        this.DTl += 1;
        continue;
        if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName)) {
          this.DTd += 1;
        } else {
          this.DTe += 1;
        }
      }
      else
      {
        if (paramSnsInfo.field_type == 1)
        {
          va(true);
          AppMethodBeat.o(96177);
          return;
        }
        if (paramSnsInfo.field_type != 15) {
          break label456;
        }
        vb(true);
        AppMethodBeat.o(96177);
        return;
      }
    }
    if ((paramSnsInfo.getTimeLine() != null) && (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo)))
    {
      uW(true);
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
      uU(true);
      AppMethodBeat.o(96177);
      return;
      uZ(true);
      AppMethodBeat.o(96177);
      return;
      uX(true);
      AppMethodBeat.o(96177);
      return;
      uZ(true);
      AppMethodBeat.o(96177);
      return;
      vd(true);
      AppMethodBeat.o(96177);
      return;
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().publicUserName))
      {
        uY(true);
        AppMethodBeat.o(96177);
        return;
      }
      uZ(true);
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
      this.DUd.add(r.v(paramSnsInfo));
    }
    for (;;)
    {
      this.DUh.add(paramSnsInfo.getUserName());
      this.DSI = this.DUh.size();
      if (!aj.fau().equals(paramSnsInfo.getUserName())) {
        break;
      }
      uQ(true);
      AppMethodBeat.o(96178);
      return;
      this.DUe.add(r.v(paramSnsInfo));
    }
    uR(true);
    AppMethodBeat.o(96178);
  }
  
  public final void kp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96179);
    this.DUb.add(paramString2);
    this.DUj.add(paramString1);
    this.DSL = this.DUj.size();
    AppMethodBeat.o(96179);
  }
  
  public final void uP(boolean paramBoolean)
  {
    AppMethodBeat.i(96180);
    if (paramBoolean)
    {
      this.DTq = System.currentTimeMillis();
      AppMethodBeat.o(96180);
      return;
    }
    if (this.DTq > 0L)
    {
      this.DTp += System.currentTimeMillis() - this.DTq;
      this.DTq = 0L;
    }
    AppMethodBeat.o(96180);
  }
  
  public final void uQ(boolean paramBoolean)
  {
    AppMethodBeat.i(96181);
    if (paramBoolean)
    {
      this.DTs = System.currentTimeMillis();
      AppMethodBeat.o(96181);
      return;
    }
    if (this.DTs > 0L)
    {
      this.DTr += System.currentTimeMillis() - this.DTs;
      this.DTs = 0L;
    }
    AppMethodBeat.o(96181);
  }
  
  public final void uR(boolean paramBoolean)
  {
    AppMethodBeat.i(96182);
    if (paramBoolean)
    {
      this.DTu = System.currentTimeMillis();
      AppMethodBeat.o(96182);
      return;
    }
    if (this.DTu > 0L)
    {
      this.DTt += System.currentTimeMillis() - this.DTu;
      this.DTu = 0L;
    }
    AppMethodBeat.o(96182);
  }
  
  public final void uS(boolean paramBoolean)
  {
    AppMethodBeat.i(96183);
    if (paramBoolean)
    {
      this.DTw = System.currentTimeMillis();
      AppMethodBeat.o(96183);
      return;
    }
    if (this.DTw > 0L)
    {
      this.DTv += System.currentTimeMillis() - this.DTw;
      this.DTw = 0L;
    }
    AppMethodBeat.o(96183);
  }
  
  public final void uT(boolean paramBoolean)
  {
    AppMethodBeat.i(96184);
    if (paramBoolean)
    {
      this.DTy = System.currentTimeMillis();
      AppMethodBeat.o(96184);
      return;
    }
    if (this.DTy > 0L)
    {
      this.DTx += System.currentTimeMillis() - this.DTy;
      this.DTy = 0L;
    }
    AppMethodBeat.o(96184);
  }
  
  public final void uU(boolean paramBoolean)
  {
    AppMethodBeat.i(96185);
    if (paramBoolean)
    {
      this.DTA = System.currentTimeMillis();
      AppMethodBeat.o(96185);
      return;
    }
    if (this.DTA > 0L)
    {
      this.DTz += System.currentTimeMillis() - this.DTA;
      this.DTA = 0L;
    }
    AppMethodBeat.o(96185);
  }
  
  public final void uV(boolean paramBoolean)
  {
    AppMethodBeat.i(96186);
    if (paramBoolean)
    {
      this.DTV = System.currentTimeMillis();
      AppMethodBeat.o(96186);
      return;
    }
    if (this.DTV > 0L)
    {
      this.DTU += System.currentTimeMillis() - this.DTV;
      this.DTV = 0L;
    }
    AppMethodBeat.o(96186);
  }
  
  public final void uW(boolean paramBoolean)
  {
    AppMethodBeat.i(96187);
    if (paramBoolean)
    {
      this.DTX = System.currentTimeMillis();
      AppMethodBeat.o(96187);
      return;
    }
    if (this.DTX > 0L)
    {
      this.DTW += System.currentTimeMillis() - this.DTX;
      this.DTX = 0L;
    }
    AppMethodBeat.o(96187);
  }
  
  public final void uX(boolean paramBoolean)
  {
    AppMethodBeat.i(96188);
    if (paramBoolean)
    {
      this.DTC = System.currentTimeMillis();
      AppMethodBeat.o(96188);
      return;
    }
    if (this.DTC > 0L)
    {
      this.DTB += System.currentTimeMillis() - this.DTC;
      this.DTC = 0L;
    }
    AppMethodBeat.o(96188);
  }
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(96189);
    if (paramBoolean)
    {
      this.DTE = System.currentTimeMillis();
      AppMethodBeat.o(96189);
      return;
    }
    if (this.DTE > 0L)
    {
      this.DTD += System.currentTimeMillis() - this.DTE;
      this.DTE = 0L;
    }
    AppMethodBeat.o(96189);
  }
  
  public final void uZ(boolean paramBoolean)
  {
    AppMethodBeat.i(96190);
    if (paramBoolean)
    {
      this.DTG = System.currentTimeMillis();
      AppMethodBeat.o(96190);
      return;
    }
    if (this.DTG > 0L)
    {
      this.DTF += System.currentTimeMillis() - this.DTG;
      this.DTG = 0L;
    }
    AppMethodBeat.o(96190);
  }
  
  public final void va(boolean paramBoolean)
  {
    AppMethodBeat.i(96191);
    if (paramBoolean)
    {
      this.DTI = System.currentTimeMillis();
      AppMethodBeat.o(96191);
      return;
    }
    if (this.DTI > 0L)
    {
      this.DTH += System.currentTimeMillis() - this.DTI;
      this.DTI = 0L;
    }
    AppMethodBeat.o(96191);
  }
  
  public final void vb(boolean paramBoolean)
  {
    AppMethodBeat.i(96192);
    if (paramBoolean)
    {
      this.DTM = System.currentTimeMillis();
      AppMethodBeat.o(96192);
      return;
    }
    if (this.DTM > 0L)
    {
      this.DTL += System.currentTimeMillis() - this.DTM;
      this.DTM = 0L;
    }
    AppMethodBeat.o(96192);
  }
  
  public final void vc(boolean paramBoolean)
  {
    AppMethodBeat.i(96193);
    if (paramBoolean)
    {
      this.DTO = System.currentTimeMillis();
      AppMethodBeat.o(96193);
      return;
    }
    if (this.DTO > 0L)
    {
      this.DTN += System.currentTimeMillis() - this.DTO;
      this.DTO = 0L;
    }
    AppMethodBeat.o(96193);
  }
  
  public final void vd(boolean paramBoolean)
  {
    AppMethodBeat.i(96194);
    if (paramBoolean)
    {
      this.DTQ = System.currentTimeMillis();
      AppMethodBeat.o(96194);
      return;
    }
    if (this.DTQ > 0L)
    {
      this.DTP += System.currentTimeMillis() - this.DTQ;
      this.DTQ = 0L;
    }
    AppMethodBeat.o(96194);
  }
  
  public final void ve(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.DSU = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.b
 * JD-Core Version:    0.7.0.1
 */