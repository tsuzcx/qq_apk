package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public int mCount;
  private d wLG;
  public m wLH;
  public List<n> wLI;
  public String wLJ;
  public String wLK;
  public String wLL;
  public ahk wLM;
  public di wLN;
  public crm wLO;
  public String wLP;
  public String wLQ;
  public int wLR;
  public Map<String, e> wLS;
  public Map<String, String> wLT;
  public LinkedList<ahk> wLU;
  public LinkedList<az> wLV;
  public e wLW;
  private com.tencent.mm.plugin.product.ui.e wLX;
  public Map<String, LinkedList<aew>> wLY;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.wLG = null;
    this.mCount = 1;
    this.wLT = new HashMap();
    this.wLY = null;
    AppMethodBeat.o(66858);
  }
  
  private void a(String[] paramArrayOfString, l paraml)
  {
    AppMethodBeat.i(66881);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      AppMethodBeat.o(66881);
      return;
    }
    int k = paramArrayOfString.length;
    int i = 1;
    if (i <= -1 >>> 32 - k)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < k)
      {
        if (i << 31 - j >> 31 == -1) {
          localStringBuilder.append(paramArrayOfString[j]).append(";");
        }
        j += 1;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf(";"));
      e locale = (e)this.wLS.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.wMa < paraml.wMM) {
          locale.wMa = paraml.wMM;
        }
        if (locale.wMb > paraml.wMM) {
          locale.wMb = paraml.wMM;
        }
        locale.wMj += paraml.wMj;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.wMa = paraml.wMM;
        locale.wMb = paraml.wMM;
        locale.wMj = paraml.wMj;
        locale.wMN = paraml.wMN;
        locale.url = paraml.url;
        this.wLS.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  private void aJ(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.wLS = new HashMap();
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(66880);
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    while (i < j)
    {
      l locall = (l)paramLinkedList.get(i);
      a(locall.wML.split(";"), locall);
      i += 1;
    }
    dzK();
    AppMethodBeat.o(66880);
  }
  
  private int auA(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.wLY != null)
    {
      j = k;
      if (this.wLY.size() > 0)
      {
        paramString = (LinkedList)this.wLY.get(paramString);
        j = k;
        if (paramString != null)
        {
          j = k;
          if (paramString.size() > 0)
          {
            paramString = paramString.iterator();
            for (;;)
            {
              j = i;
              if (!paramString.hasNext()) {
                break;
              }
              i = ((aew)paramString.next()).FMH + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  public static String az(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66879);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(66879);
      return null;
    }
    Object localObject = new ArrayList(paramMap.entrySet());
    Collections.sort((List)localObject, new c.1());
    paramMap = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramMap.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(";");
    }
    paramMap.deleteCharAt(paramMap.lastIndexOf(";"));
    paramMap = paramMap.toString();
    AppMethodBeat.o(66879);
    return paramMap;
  }
  
  public final void MA(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.wLU == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.wLU.size()) && (paramInt >= 0)) {
      this.wLM = ((ahk)this.wLU.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.wMi).append("</type>");
    localStringBuilder.append("<id>").append(paramm.wMh).append("</id>");
    localStringBuilder.append("<version>").append(paramm.wMl.version).append("</version>");
    localStringBuilder.append("<name>").append(bt.aRc(paramm.wMl.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.wMl.wMw).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.wMl.wMx).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.wMl.wMv).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bt.aRc(this.wLH.lox)).append("</sourceUrl>");
    if (paramm.wMl.wMy != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.wMl.wMy.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.wMl.wMy.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bt.aRc(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bt.aRc(dzD())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bt.aRc(paramm.dzO())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.wLH.wMm != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.wMm.duW).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.wMm.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.wMm.username).append("</usrName>");
      localStringBuilder.append("</sellerInfo>");
    }
    localStringBuilder.append("</mallProductInfo>");
    paramm = localStringBuilder.toString();
    AppMethodBeat.o(66884);
    return paramm;
  }
  
  public final void a(m paramm, List<n> paramList)
  {
    int j = 0;
    AppMethodBeat.i(66860);
    clear();
    this.wLH = paramm;
    this.wLI = paramList;
    if (bt.isNullOrNil(this.wLH.lox)) {
      this.wLH.lox = this.wLK;
    }
    aJ(this.wLH.wMn);
    if ((this.wLH.wMl != null) && (this.wLH.wMl.wME != null)) {
      this.wLR = this.wLH.wMl.wME.size();
    }
    if ((this.wLH.wMl != null) && (this.wLH.wMl.wMy != null) && (this.wLH.wMl.wMy.size() > 0)) {
      this.wLP = ((String)this.wLH.wMl.wMy.get(0));
    }
    if (!bt.isNullOrNil(this.wLH.dzO()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.wLH.dzO()));
      ad.d("MicroMsg.MallProductManager", "product img path : " + dzC());
    }
    if ((this.wLH.wMo != null) && (this.wLH.wMo.wMI != null)) {}
    for (int i = this.wLH.wMo.wMI.dDp;; i = 0)
    {
      if (this.wLH.wMm != null) {
        j = this.wLH.wMm.dDp;
      }
      this.wLX = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final void aF(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    di localdi = new di();
    localdi.nDo = bt.bI(paramIntent.getStringExtra("userName"), "");
    localdi.FvB = bt.bI(paramIntent.getStringExtra("telNumber"), "");
    localdi.FvC = bt.bI(paramIntent.getStringExtra("addressPostalCode"), "");
    localdi.jdd = bt.bI(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdi.jde = bt.bI(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdi.jdl = bt.bI(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdi.ugo = bt.bI(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bt.isNullOrNil(localdi.nDo)) && (!bt.isNullOrNil(localdi.FvB))) {
      this.wLN = localdi;
    }
    AppMethodBeat.o(66864);
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> az(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.wLV != null)
    {
      Iterator localIterator = this.wLV.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localaz.Name;
        locala.wMs = localaz.wMs;
        locala.hDa = localaz.hDa;
        locala.nEf = localaz.nEf;
        locala.IconUrl = localaz.IconUrl;
        if (locala.nEf == 1)
        {
          int i = auA(locala.hDa);
          if (i > 0) {
            locala.wMs = paramActivity.getString(2131761140, new Object[] { b.c(i, this.wLH.wMl.wCF) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.wLH = null;
    if (this.wLI != null)
    {
      this.wLI.clear();
      this.wLI = null;
    }
    this.wLJ = null;
    this.wLK = null;
    this.mCount = 1;
    this.wLL = null;
    this.wLM = null;
    this.wLO = null;
    this.wLP = null;
    this.wLR = 0;
    this.wLW = null;
    if (this.wLS != null)
    {
      this.wLS.clear();
      this.wLS = null;
    }
    if (this.wLT != null) {
      this.wLT.clear();
    }
    if (this.wLU != null)
    {
      this.wLU.clear();
      this.wLU = null;
    }
    if (this.wLY != null)
    {
      this.wLY.clear();
      this.wLY = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final crm dzA()
  {
    AppMethodBeat.i(66870);
    if (this.wLO != null)
    {
      localObject = this.wLO;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.wLG == null) {
      this.wLG = com.tencent.mm.plugin.product.a.a.dzs().dzu();
    }
    Object localObject = this.wLG;
    if ((((d)localObject).wLZ != null) && (((d)localObject).wLZ.size() > 0)) {}
    for (localObject = (String)((d)localObject).wLZ.get(0); !bt.isNullOrNil((String)localObject); localObject = null)
    {
      this.wLO = new crm();
      this.wLO.ugo = ((String)localObject);
      this.wLO.HjU = 1;
      localObject = this.wLO;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.wLN;
    if ((localObject != null) && (!bt.isNullOrNil(((di)localObject).nDo)))
    {
      this.wLO = new crm();
      this.wLO.ugo = ((di)localObject).nDo;
      this.wLO.HjU = 1;
      localObject = this.wLO;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String dzB()
  {
    if (this.wLH.wMm != null) {
      return this.wLH.wMm.username;
    }
    return null;
  }
  
  public final String dzC()
  {
    AppMethodBeat.i(66871);
    if (!bt.isNullOrNil(this.wLH.dzO()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.auC(this.wLH.dzO());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String dzD()
  {
    AppMethodBeat.i(66872);
    if ((this.wLH.wMl != null) && (this.wLH.wMl.wMG != null))
    {
      str = this.wLH.wMl.wMG.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!bt.isNullOrNil(this.wLH.lox))
    {
      str = this.wLH.lox;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.wLK;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int dzE()
  {
    int j = this.wLH.wMj;
    int i = j;
    if (this.wLW != null)
    {
      i = j;
      if (j > this.wLW.wMj) {
        i = this.wLW.wMj;
      }
    }
    return i;
  }
  
  public final boolean dzF()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.wLH != null) && (this.mCount <= dzE()) && (this.wLH.wMl != null) && (this.wLH.wMl.wME != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean dzG()
  {
    AppMethodBeat.i(66874);
    if (!dzF())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.wLT != null) && (this.wLT.size() == this.wLR)) {
      if (this.wLR > 0)
      {
        if ((this.wLW != null) && (this.mCount > 0) && (this.mCount <= dzE()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.wLR == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean dzH()
  {
    AppMethodBeat.i(66875);
    if (!dzG())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.wLN == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!dzv().dzR()) && (this.wLM == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<cwy> dzI()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    cwy localcwy = new cwy();
    localcwy.nDi = this.mCount;
    localcwy.GBF = this.wLH.wMh;
    localcwy.HfF = this.wLH.lox;
    localcwy.HfG = this.wLL;
    localLinkedList.add(localcwy);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final dex dzJ()
  {
    AppMethodBeat.i(66877);
    dex localdex = new dex();
    localdex.FOY = this.wLJ;
    localdex.wDB = 1;
    localdex.Htn = new LinkedList();
    cmh localcmh = new cmh();
    localcmh.nDi = this.mCount;
    localcmh.GBF = this.wLH.wMh;
    localcmh.Name = this.wLH.wMl.name;
    if (this.wLW != null) {}
    Iterator localIterator;
    Object localObject;
    for (localcmh.HfE = this.wLW.wMa;; localcmh.HfE = this.wLH.wMl.wMw)
    {
      localcmh.HfF = this.wLH.lox;
      localcmh.HfG = this.wLL;
      localcmh.nEf = this.wLH.wMi;
      localcmh.HfC = this.wLR;
      localcmh.HfD = new LinkedList();
      localIterator = this.wLT.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.wLT.get(localObject);
        bsj localbsj = new bsj();
        localbsj.ujy = ((String)localObject);
        localbsj.yhw = str;
        localcmh.HfD.add(localbsj);
      }
    }
    localcmh.HfK = new LinkedList();
    localcmh.HfJ = 0;
    if ((this.wLY != null) && (this.wLY.size() > 0))
    {
      localIterator = this.wLY.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localcmh.HfK.addAll((Collection)localObject);
        int i = localcmh.HfJ;
        localcmh.HfJ = (((LinkedList)localObject).size() + i);
      }
    }
    localdex.Htn.add(localcmh);
    localdex.Htp = new LinkedList();
    localdex.Htq = 1;
    this.wLO = dzA();
    if (this.wLO != null) {
      localdex.Htp.add(this.wLO);
    }
    for (;;)
    {
      localdex.Gzn = this.wLN;
      localdex.Hto = this.wLM;
      AppMethodBeat.o(66877);
      return localdex;
      this.wLO = new crm();
      this.wLO.HjU = 0;
      localdex.Htp.add(this.wLO);
    }
  }
  
  public final void dzK()
  {
    AppMethodBeat.i(66878);
    if (this.wLT == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.wLH.wMl.wME.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.wMQ.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.wMO;
        str2 = localh.id;
        if ((this.wLT != null) && (this.wLS != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.iH = bool;
        ad.d("MicroMsg.MallProductManager", "(" + localm.wMO + " , " + localh.id + ") hasStock--> " + localh.iH);
        break label62;
        break;
        label176:
        String str1;
        if (this.wLT.containsKey(localObject))
        {
          str1 = (String)this.wLT.get(localObject);
          this.wLT.put(localObject, str2);
          str2 = az(this.wLT);
          this.wLT.put(localObject, str1);
          localObject = (e)this.wLS.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).wMj > 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
        }
        else
        {
          this.wLT.put(localObject, str2);
          str1 = az(this.wLT);
          this.wLT.remove(localObject);
          localObject = (e)this.wLS.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).wMj > 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
        }
      }
    }
    AppMethodBeat.o(66878);
  }
  
  public final String dzL()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.wLH.wMl.name;
    ((k.b)localObject).description = dzM();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = dzD();
    ((k.b)localObject).thumburl = this.wLH.dzO();
    ((k.b)localObject).hAt = this.wLH.wMi;
    ((k.b)localObject).hAu = a(this.wLH);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String dzM()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.wLH.wMl.wMx, this.wLH.wMl.wCF);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final com.tencent.mm.plugin.product.ui.e dzv()
  {
    AppMethodBeat.i(66861);
    if (this.wLX == null) {
      this.wLX = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.wLX;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String dzw()
  {
    AppMethodBeat.i(66862);
    if ((this.wLW != null) && (!bt.isNullOrNil(this.wLW.url)))
    {
      str = this.wLW.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.wLP;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String dzx()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.wLH.wMl.wME.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.wLT.get(((com.tencent.mm.plugin.product.c.m)localObject2).wMO);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).wMQ.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          h localh = (h)((Iterator)localObject2).next();
          if (!str.equals(localh.id)) {
            break;
          }
          ((StringBuilder)localObject1).append(localh.name).append(" ");
        }
      }
    }
    label133:
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(66863);
    return localObject1;
  }
  
  public final int dzy()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!dzv().dzR())
    {
      i = j;
      if (this.wLM != null) {
        i = this.wLM.FMH + 0;
      }
    }
    if (this.wLW != null) {
      i += this.wLW.wMa * this.mCount;
    }
    for (;;)
    {
      j = dzz();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.wLH.wMl.wMw * this.mCount;
    }
  }
  
  public final int dzz()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.wLY != null)
    {
      i = j;
      if (this.wLY.size() > 0)
      {
        Iterator localIterator = this.wLY.values().iterator();
        for (i = 0; localIterator.hasNext(); i = j)
        {
          Object localObject = (LinkedList)localIterator.next();
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((LinkedList)localObject).size() > 0)
            {
              localObject = ((LinkedList)localObject).iterator();
              for (;;)
              {
                j = i;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                i += ((aew)((Iterator)localObject).next()).FMH;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final String getAppId()
  {
    if (this.wLH.wMm != null) {
      return this.wLH.wMm.duW;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */