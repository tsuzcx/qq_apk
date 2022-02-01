package com.tencent.mm.plugin.product.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.protocal.protobuf.fdf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

public final class b
{
  public List<m> MQA;
  public String MQB;
  public String MQC;
  public String MQD;
  public aou MQE;
  public ee MQF;
  public ems MQG;
  public String MQH;
  public String MQI;
  public int MQJ;
  public Map<String, d> MQK;
  public Map<String, String> MQL;
  public LinkedList<aou> MQM;
  public LinkedList<be> MQN;
  public d MQO;
  private e MQP;
  public Map<String, LinkedList<akn>> MQQ;
  private c MQy;
  public l MQz;
  public int mCount;
  
  public b()
  {
    AppMethodBeat.i(66858);
    this.MQy = null;
    this.mCount = 1;
    this.MQL = new HashMap();
    this.MQQ = null;
    AppMethodBeat.o(66858);
  }
  
  private void a(String[] paramArrayOfString, com.tencent.mm.plugin.product.b.l paraml)
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
      d locald = (d)this.MQK.get(localStringBuilder.toString());
      if (locald != null)
      {
        if (locald.MQS < paraml.MRD) {
          locald.MQS = paraml.MRD;
        }
        if (locald.MQT > paraml.MRD) {
          locald.MQT = paraml.MRD;
        }
        locald.MRb += paraml.MRb;
      }
      for (;;)
      {
        i += 1;
        break;
        locald = new d();
        locald.MQS = paraml.MRD;
        locald.MQT = paraml.MRD;
        locald.MRb = paraml.MRb;
        locald.MRE = paraml.MRE;
        locald.url = paraml.url;
        this.MQK.put(localStringBuilder.toString(), locald);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  public static String aP(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66879);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(66879);
      return null;
    }
    Object localObject = new ArrayList(paramMap.entrySet());
    Collections.sort((List)localObject, new b.1());
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
  
  private int aRN(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.MQQ != null)
    {
      j = k;
      if (this.MQQ.size() > 0)
      {
        paramString = (LinkedList)this.MQQ.get(paramString);
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
              i = ((akn)paramString.next()).YYF + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  private void bK(LinkedList<com.tencent.mm.plugin.product.b.l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.MQK = new HashMap();
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(66880);
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.product.b.l locall = (com.tencent.mm.plugin.product.b.l)paramLinkedList.get(i);
      a(locall.MRC.split(";"), locall);
      i += 1;
    }
    gAq();
    AppMethodBeat.o(66880);
  }
  
  public final String a(l paraml)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paraml.MRa).append("</type>");
    localStringBuilder.append("<id>").append(paraml.MQZ).append("</id>");
    localStringBuilder.append("<version>").append(paraml.MRd.version).append("</version>");
    localStringBuilder.append("<name>").append(Util.escapeStringForXml(paraml.MRd.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paraml.MRd.MRn).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paraml.MRd.MRo).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paraml.MRd.MRm).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(Util.escapeStringForXml(this.MQz.ibx)).append("</sourceUrl>");
    if (paraml.MRd.MRp != null)
    {
      localStringBuilder.append("<imgCount>").append(paraml.MRd.MRp.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paraml.MRd.MRp.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(Util.escapeStringForXml(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(Util.escapeStringForXml(gAj())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(Util.escapeStringForXml(paraml.gAu())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.MQz.MRe != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paraml.MRe.appid).append("</appID>");
      localStringBuilder.append("<appName>").append(paraml.MRe.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paraml.MRe.username).append("</usrName>");
      localStringBuilder.append("</sellerInfo>");
    }
    localStringBuilder.append("</mallProductInfo>");
    paraml = localStringBuilder.toString();
    AppMethodBeat.o(66884);
    return paraml;
  }
  
  public final void a(l paraml, List<m> paramList)
  {
    int j = 0;
    AppMethodBeat.i(66860);
    clear();
    this.MQz = paraml;
    this.MQA = paramList;
    if (Util.isNullOrNil(this.MQz.ibx)) {
      this.MQz.ibx = this.MQC;
    }
    bK(this.MQz.MRf);
    if ((this.MQz.MRd != null) && (this.MQz.MRd.MRv != null)) {
      this.MQJ = this.MQz.MRd.MRv.size();
    }
    if ((this.MQz.MRd != null) && (this.MQz.MRd.MRp != null) && (this.MQz.MRd.MRp.size() > 0)) {
      this.MQH = ((String)this.MQz.MRd.MRp.get(0));
    }
    if (!Util.isNullOrNil(this.MQz.gAu()))
    {
      r.a(new com.tencent.mm.plugin.product.ui.c(this.MQz.gAu()));
      Log.d("MicroMsg.MallProductManager", "product img path : " + gAi());
    }
    if ((this.MQz.MRg != null) && (this.MQz.MRg.MRz != null)) {}
    for (int i = this.MQz.MRg.MRz.eQp;; i = 0)
    {
      if (this.MQz.MRe != null) {
        j = this.MQz.MRe.eQp;
      }
      this.MQP = new e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final void afy(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.MQM == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.MQM.size()) && (paramInt >= 0)) {
      this.MQE = ((aou)this.MQM.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.b.a> bj(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.MQN != null)
    {
      Iterator localIterator = this.MQN.iterator();
      while (localIterator.hasNext())
      {
        be localbe = (be)localIterator.next();
        com.tencent.mm.plugin.product.b.a locala = new com.tencent.mm.plugin.product.b.a();
        locala.IGU = localbe.IGU;
        locala.MRj = localbe.MRj;
        locala.nUB = localbe.nUB;
        locala.vhJ = localbe.vhJ;
        locala.IHo = localbe.IHo;
        if (locala.vhJ == 1)
        {
          int i = aRN(locala.nUB);
          if (i > 0) {
            locala.MRj = paramActivity.getString(a.i.mall_product_submit_preferential_summray, new Object[] { a.d(i, this.MQz.MRd.MEq) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void bm(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    ee localee = new ee();
    localee.UserName = Util.nullAs(paramIntent.getStringExtra("userName"), "");
    localee.YGl = Util.nullAs(paramIntent.getStringExtra("telNumber"), "");
    localee.YGm = Util.nullAs(paramIntent.getStringExtra("addressPostalCode"), "");
    localee.pSg = Util.nullAs(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localee.pSh = Util.nullAs(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localee.pSo = Util.nullAs(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localee.IIu = Util.nullAs(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!Util.isNullOrNil(localee.UserName)) && (!Util.isNullOrNil(localee.YGl))) {
      this.MQF = localee;
    }
    AppMethodBeat.o(66864);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.MQz = null;
    if (this.MQA != null)
    {
      this.MQA.clear();
      this.MQA = null;
    }
    this.MQB = null;
    this.MQC = null;
    this.mCount = 1;
    this.MQD = null;
    this.MQE = null;
    this.MQG = null;
    this.MQH = null;
    this.MQJ = 0;
    this.MQO = null;
    if (this.MQK != null)
    {
      this.MQK.clear();
      this.MQK = null;
    }
    if (this.MQL != null) {
      this.MQL.clear();
    }
    if (this.MQM != null)
    {
      this.MQM.clear();
      this.MQM = null;
    }
    if (this.MQQ != null)
    {
      this.MQQ.clear();
      this.MQQ = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final e gAb()
  {
    AppMethodBeat.i(66861);
    if (this.MQP == null) {
      this.MQP = new e(0, 0);
    }
    e locale = this.MQP;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String gAc()
  {
    AppMethodBeat.i(66862);
    if ((this.MQO != null) && (!Util.isNullOrNil(this.MQO.url)))
    {
      str = this.MQO.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.MQH;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String gAd()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.MQz.MRd.MRv.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.b.m)localIterator.next();
      String str = (String)this.MQL.get(((com.tencent.mm.plugin.product.b.m)localObject2).MRF);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.b.m)localObject2).MRH.iterator();
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
  
  public final int gAe()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!gAb().gAx())
    {
      i = j;
      if (this.MQE != null) {
        i = this.MQE.YYF + 0;
      }
    }
    if (this.MQO != null) {
      i += this.MQO.MQS * this.mCount;
    }
    for (;;)
    {
      j = gAf();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.MQz.MRd.MRn * this.mCount;
    }
  }
  
  public final int gAf()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.MQQ != null)
    {
      i = j;
      if (this.MQQ.size() > 0)
      {
        Iterator localIterator = this.MQQ.values().iterator();
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
                i += ((akn)((Iterator)localObject).next()).YYF;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final ems gAg()
  {
    AppMethodBeat.i(66870);
    if (this.MQG != null)
    {
      localObject = this.MQG;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.MQy == null) {
      this.MQy = com.tencent.mm.plugin.product.a.a.gzY().gAa();
    }
    Object localObject = this.MQy;
    if ((((c)localObject).MQR != null) && (((c)localObject).MQR.size() > 0)) {}
    for (localObject = (String)((c)localObject).MQR.get(0); !Util.isNullOrNil((String)localObject); localObject = null)
    {
      this.MQG = new ems();
      this.MQG.IIu = ((String)localObject);
      this.MQG.abrc = 1;
      localObject = this.MQG;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.MQF;
    if ((localObject != null) && (!Util.isNullOrNil(((ee)localObject).UserName)))
    {
      this.MQG = new ems();
      this.MQG.IIu = ((ee)localObject).UserName;
      this.MQG.abrc = 1;
      localObject = this.MQG;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String gAh()
  {
    if (this.MQz.MRe != null) {
      return this.MQz.MRe.username;
    }
    return null;
  }
  
  public final String gAi()
  {
    AppMethodBeat.i(66871);
    if (!Util.isNullOrNil(this.MQz.gAu()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.aRP(this.MQz.gAu());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String gAj()
  {
    AppMethodBeat.i(66872);
    if ((this.MQz.MRd != null) && (this.MQz.MRd.MRx != null))
    {
      str = this.MQz.MRd.MRx.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!Util.isNullOrNil(this.MQz.ibx))
    {
      str = this.MQz.ibx;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.MQC;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int gAk()
  {
    int j = this.MQz.MRb;
    int i = j;
    if (this.MQO != null)
    {
      i = j;
      if (j > this.MQO.MRb) {
        i = this.MQO.MRb;
      }
    }
    return i;
  }
  
  public final boolean gAl()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.MQz != null) && (this.mCount <= gAk()) && (this.MQz.MRd != null) && (this.MQz.MRd.MRv != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean gAm()
  {
    AppMethodBeat.i(66874);
    if (!gAl())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.MQL != null) && (this.MQL.size() == this.MQJ)) {
      if (this.MQJ > 0)
      {
        if ((this.MQO != null) && (this.mCount > 0) && (this.mCount <= gAk()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.MQJ == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean gAn()
  {
    AppMethodBeat.i(66875);
    if (!gAm())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.MQF == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!gAb().gAx()) && (this.MQE == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<etr> gAo()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    etr localetr = new etr();
    localetr.vgN = this.mCount;
    localetr.aawr = this.MQz.MQZ;
    localetr.abmy = this.MQz.ibx;
    localetr.abmz = this.MQD;
    localLinkedList.add(localetr);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final fdf gAp()
  {
    AppMethodBeat.i(66877);
    fdf localfdf = new fdf();
    localfdf.Zbg = this.MQB;
    localfdf.MFk = 1;
    localfdf.abCI = new LinkedList();
    ehh localehh = new ehh();
    localehh.vgN = this.mCount;
    localehh.aawr = this.MQz.MQZ;
    localehh.IGU = this.MQz.MRd.name;
    if (this.MQO != null) {}
    Iterator localIterator;
    Object localObject;
    for (localehh.abmx = this.MQO.MQS;; localehh.abmx = this.MQz.MRd.MRn)
    {
      localehh.abmy = this.MQz.ibx;
      localehh.abmz = this.MQD;
      localehh.vhJ = this.MQz.MRa;
      localehh.abmv = this.MQJ;
      localehh.abmw = new LinkedList();
      localIterator = this.MQL.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.MQL.get(localObject);
        dfm localdfm = new dfm();
        localdfm.ILw = ((String)localObject);
        localdfm.OzQ = str;
        localehh.abmw.add(localdfm);
      }
    }
    localehh.abmD = new LinkedList();
    localehh.abmC = 0;
    if ((this.MQQ != null) && (this.MQQ.size() > 0))
    {
      localIterator = this.MQQ.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localehh.abmD.addAll((Collection)localObject);
        int i = localehh.abmC;
        localehh.abmC = (((LinkedList)localObject).size() + i);
      }
    }
    localfdf.abCI.add(localehh);
    localfdf.abCK = new LinkedList();
    localfdf.abCL = 1;
    this.MQG = gAg();
    if (this.MQG != null) {
      localfdf.abCK.add(this.MQG);
    }
    for (;;)
    {
      localfdf.aatN = this.MQF;
      localfdf.abCJ = this.MQE;
      AppMethodBeat.o(66877);
      return localfdf;
      this.MQG = new ems();
      this.MQG.abrc = 0;
      localfdf.abCK.add(this.MQG);
    }
  }
  
  public final void gAq()
  {
    AppMethodBeat.i(66878);
    if (this.MQL == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.MQz.MRd.MRv.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.b.m localm = (com.tencent.mm.plugin.product.b.m)localIterator1.next();
      Iterator localIterator2 = localm.MRH.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.MRF;
        str2 = localh.id;
        if ((this.MQL != null) && (this.MQK != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.dsb = bool;
        Log.d("MicroMsg.MallProductManager", "(" + localm.MRF + " , " + localh.id + ") hasStock--> " + localh.dsb);
        break label62;
        break;
        label176:
        String str1;
        if (this.MQL.containsKey(localObject))
        {
          str1 = (String)this.MQL.get(localObject);
          this.MQL.put(localObject, str2);
          str2 = aP(this.MQL);
          this.MQL.put(localObject, str1);
          localObject = (d)this.MQK.get(str2);
          if (localObject != null)
          {
            if (((d)localObject).MRb > 0) {
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
          this.MQL.put(localObject, str2);
          str1 = aP(this.MQL);
          this.MQL.remove(localObject);
          localObject = (d)this.MQK.get(str1);
          if (localObject != null)
          {
            if (((d)localObject).MRb > 0) {
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
  
  public final String gAr()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.MQz.MRd.name;
    ((k.b)localObject).description = gAs();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = gAj();
    ((k.b)localObject).thumburl = this.MQz.gAu();
    ((k.b)localObject).nRG = this.MQz.MRa;
    ((k.b)localObject).nRH = a(this.MQz);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String gAs()
  {
    AppMethodBeat.i(66883);
    String str = a.d(this.MQz.MRd.MRo, this.MQz.MRd.MEq);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final String getAppId()
  {
    if (this.MQz.MRe != null) {
      return this.MQz.MRe.appid;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.b
 * JD-Core Version:    0.7.0.1
 */