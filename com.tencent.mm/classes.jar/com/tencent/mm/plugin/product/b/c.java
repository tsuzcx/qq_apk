package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private d vEA;
  public m vEB;
  public List<n> vEC;
  public String vED;
  public String vEE;
  public String vEF;
  public afb vEG;
  public dh vEH;
  public cml vEI;
  public String vEJ;
  public String vEK;
  public int vEL;
  public Map<String, e> vEM;
  public Map<String, String> vEN;
  public LinkedList<afb> vEO;
  public LinkedList<az> vEP;
  public e vEQ;
  private com.tencent.mm.plugin.product.ui.e vER;
  public Map<String, LinkedList<acv>> vES;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.vEA = null;
    this.mCount = 1;
    this.vEN = new HashMap();
    this.vES = null;
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
      e locale = (e)this.vEM.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.vEU < paraml.vFG) {
          locale.vEU = paraml.vFG;
        }
        if (locale.vEV > paraml.vFG) {
          locale.vEV = paraml.vFG;
        }
        locale.vFd += paraml.vFd;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.vEU = paraml.vFG;
        locale.vEV = paraml.vFG;
        locale.vFd = paraml.vFd;
        locale.vFH = paraml.vFH;
        locale.url = paraml.url;
        this.vEM.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  private void aI(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.vEM = new HashMap();
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
      a(locall.vFF.split(";"), locall);
      i += 1;
    }
    dpi();
    AppMethodBeat.o(66880);
  }
  
  private int apu(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.vES != null)
    {
      j = k;
      if (this.vES.size() > 0)
      {
        paramString = (LinkedList)this.vES.get(paramString);
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
              i = ((acv)paramString.next()).Egi + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  public static String at(Map<String, String> paramMap)
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
  
  public final void KX(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.vEO == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.vEO.size()) && (paramInt >= 0)) {
      this.vEG = ((afb)this.vEO.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.vFc).append("</type>");
    localStringBuilder.append("<id>").append(paramm.vFb).append("</id>");
    localStringBuilder.append("<version>").append(paramm.vFf.version).append("</version>");
    localStringBuilder.append("<name>").append(bs.aLw(paramm.vFf.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.vFf.vFq).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.vFf.vFr).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.vFf.vFp).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bs.aLw(this.vEB.kRU)).append("</sourceUrl>");
    if (paramm.vFf.vFs != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.vFf.vFs.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.vFf.vFs.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bs.aLw(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bs.aLw(dpb())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bs.aLw(paramm.dpm())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.vEB.vFg != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.vFg.djj).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.vFg.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.vFg.username).append("</usrName>");
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
    this.vEB = paramm;
    this.vEC = paramList;
    if (bs.isNullOrNil(this.vEB.kRU)) {
      this.vEB.kRU = this.vEE;
    }
    aI(this.vEB.vFh);
    if ((this.vEB.vFf != null) && (this.vEB.vFf.vFy != null)) {
      this.vEL = this.vEB.vFf.vFy.size();
    }
    if ((this.vEB.vFf != null) && (this.vEB.vFf.vFs != null) && (this.vEB.vFf.vFs.size() > 0)) {
      this.vEJ = ((String)this.vEB.vFf.vFs.get(0));
    }
    if (!bs.isNullOrNil(this.vEB.dpm()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.vEB.dpm()));
      ac.d("MicroMsg.MallProductManager", "product img path : " + dpa());
    }
    if ((this.vEB.vFi != null) && (this.vEB.vFi.vFC != null)) {}
    for (int i = this.vEB.vFi.vFC.drx;; i = 0)
    {
      if (this.vEB.vFg != null) {
        j = this.vEB.vFg.drx;
      }
      this.vER = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final void aA(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    dh localdh = new dh();
    localdh.ncR = bs.bG(paramIntent.getStringExtra("userName"), "");
    localdh.DQm = bs.bG(paramIntent.getStringExtra("telNumber"), "");
    localdh.DQn = bs.bG(paramIntent.getStringExtra("addressPostalCode"), "");
    localdh.iJU = bs.bG(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdh.iJV = bs.bG(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdh.iKc = bs.bG(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdh.tiv = bs.bG(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bs.isNullOrNil(localdh.ncR)) && (!bs.isNullOrNil(localdh.DQm))) {
      this.vEH = localdh;
    }
    AppMethodBeat.o(66864);
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> az(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.vEP != null)
    {
      Iterator localIterator = this.vEP.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localaz.Name;
        locala.vFm = localaz.vFm;
        locala.hkR = localaz.hkR;
        locala.ndI = localaz.ndI;
        locala.IconUrl = localaz.IconUrl;
        if (locala.ndI == 1)
        {
          int i = apu(locala.hkR);
          if (i > 0) {
            locala.vFm = paramActivity.getString(2131761140, new Object[] { b.c(i, this.vEB.vFf.vxl) });
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
    this.vEB = null;
    if (this.vEC != null)
    {
      this.vEC.clear();
      this.vEC = null;
    }
    this.vED = null;
    this.vEE = null;
    this.mCount = 1;
    this.vEF = null;
    this.vEG = null;
    this.vEI = null;
    this.vEJ = null;
    this.vEL = 0;
    this.vEQ = null;
    if (this.vEM != null)
    {
      this.vEM.clear();
      this.vEM = null;
    }
    if (this.vEN != null) {
      this.vEN.clear();
    }
    if (this.vEO != null)
    {
      this.vEO.clear();
      this.vEO = null;
    }
    if (this.vES != null)
    {
      this.vES.clear();
      this.vES = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final com.tencent.mm.plugin.product.ui.e doT()
  {
    AppMethodBeat.i(66861);
    if (this.vER == null) {
      this.vER = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.vER;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String doU()
  {
    AppMethodBeat.i(66862);
    if ((this.vEQ != null) && (!bs.isNullOrNil(this.vEQ.url)))
    {
      str = this.vEQ.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.vEJ;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String doV()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.vEB.vFf.vFy.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.vEN.get(((com.tencent.mm.plugin.product.c.m)localObject2).vFI);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).vFK.iterator();
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
  
  public final int doW()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!doT().dpp())
    {
      i = j;
      if (this.vEG != null) {
        i = this.vEG.Egi + 0;
      }
    }
    if (this.vEQ != null) {
      i += this.vEQ.vEU * this.mCount;
    }
    for (;;)
    {
      j = doX();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.vEB.vFf.vFq * this.mCount;
    }
  }
  
  public final int doX()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.vES != null)
    {
      i = j;
      if (this.vES.size() > 0)
      {
        Iterator localIterator = this.vES.values().iterator();
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
                i += ((acv)((Iterator)localObject).next()).Egi;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final cml doY()
  {
    AppMethodBeat.i(66870);
    if (this.vEI != null)
    {
      localObject = this.vEI;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.vEA == null) {
      this.vEA = com.tencent.mm.plugin.product.a.a.doQ().doS();
    }
    Object localObject = this.vEA;
    if ((((d)localObject).vET != null) && (((d)localObject).vET.size() > 0)) {}
    for (localObject = (String)((d)localObject).vET.get(0); !bs.isNullOrNil((String)localObject); localObject = null)
    {
      this.vEI = new cml();
      this.vEI.tiv = ((String)localObject);
      this.vEI.FzM = 1;
      localObject = this.vEI;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.vEH;
    if ((localObject != null) && (!bs.isNullOrNil(((dh)localObject).ncR)))
    {
      this.vEI = new cml();
      this.vEI.tiv = ((dh)localObject).ncR;
      this.vEI.FzM = 1;
      localObject = this.vEI;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String doZ()
  {
    if (this.vEB.vFg != null) {
      return this.vEB.vFg.username;
    }
    return null;
  }
  
  public final String dpa()
  {
    AppMethodBeat.i(66871);
    if (!bs.isNullOrNil(this.vEB.dpm()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.apw(this.vEB.dpm());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String dpb()
  {
    AppMethodBeat.i(66872);
    if ((this.vEB.vFf != null) && (this.vEB.vFf.vFA != null))
    {
      str = this.vEB.vFf.vFA.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!bs.isNullOrNil(this.vEB.kRU))
    {
      str = this.vEB.kRU;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.vEE;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int dpc()
  {
    int j = this.vEB.vFd;
    int i = j;
    if (this.vEQ != null)
    {
      i = j;
      if (j > this.vEQ.vFd) {
        i = this.vEQ.vFd;
      }
    }
    return i;
  }
  
  public final boolean dpd()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.vEB != null) && (this.mCount <= dpc()) && (this.vEB.vFf != null) && (this.vEB.vFf.vFy != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean dpe()
  {
    AppMethodBeat.i(66874);
    if (!dpd())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.vEN != null) && (this.vEN.size() == this.vEL)) {
      if (this.vEL > 0)
      {
        if ((this.vEQ != null) && (this.mCount > 0) && (this.mCount <= dpc()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.vEL == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean dpf()
  {
    AppMethodBeat.i(66875);
    if (!dpe())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.vEH == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!doT().dpp()) && (this.vEG == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<crr> dpg()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    crr localcrr = new crr();
    localcrr.ncL = this.mCount;
    localcrr.ESn = this.vEB.vFb;
    localcrr.FvA = this.vEB.kRU;
    localcrr.FvB = this.vEF;
    localLinkedList.add(localcrr);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final czk dph()
  {
    AppMethodBeat.i(66877);
    czk localczk = new czk();
    localczk.EhR = this.vED;
    localczk.vyh = 1;
    localczk.FIF = new LinkedList();
    chi localchi = new chi();
    localchi.ncL = this.mCount;
    localchi.ESn = this.vEB.vFb;
    localchi.Name = this.vEB.vFf.name;
    if (this.vEQ != null) {}
    Iterator localIterator;
    Object localObject;
    for (localchi.Fvz = this.vEQ.vEU;; localchi.Fvz = this.vEB.vFf.vFq)
    {
      localchi.FvA = this.vEB.kRU;
      localchi.FvB = this.vEF;
      localchi.ndI = this.vEB.vFc;
      localchi.Fvx = this.vEL;
      localchi.Fvy = new LinkedList();
      localIterator = this.vEN.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.vEN.get(localObject);
        bnx localbnx = new bnx();
        localbnx.tlp = ((String)localObject);
        localbnx.wTM = str;
        localchi.Fvy.add(localbnx);
      }
    }
    localchi.FvF = new LinkedList();
    localchi.FvE = 0;
    if ((this.vES != null) && (this.vES.size() > 0))
    {
      localIterator = this.vES.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localchi.FvF.addAll((Collection)localObject);
        int i = localchi.FvE;
        localchi.FvE = (((LinkedList)localObject).size() + i);
      }
    }
    localczk.FIF.add(localchi);
    localczk.FIH = new LinkedList();
    localczk.FII = 1;
    this.vEI = doY();
    if (this.vEI != null) {
      localczk.FIH.add(this.vEI);
    }
    for (;;)
    {
      localczk.EPW = this.vEH;
      localczk.FIG = this.vEG;
      AppMethodBeat.o(66877);
      return localczk;
      this.vEI = new cml();
      this.vEI.FzM = 0;
      localczk.FIH.add(this.vEI);
    }
  }
  
  public final void dpi()
  {
    AppMethodBeat.i(66878);
    if (this.vEN == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.vEB.vFf.vFy.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.vFK.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.vFI;
        str2 = localh.id;
        if ((this.vEN != null) && (this.vEM != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.gM = bool;
        ac.d("MicroMsg.MallProductManager", "(" + localm.vFI + " , " + localh.id + ") hasStock--> " + localh.gM);
        break label62;
        break;
        label176:
        String str1;
        if (this.vEN.containsKey(localObject))
        {
          str1 = (String)this.vEN.get(localObject);
          this.vEN.put(localObject, str2);
          str2 = at(this.vEN);
          this.vEN.put(localObject, str1);
          localObject = (e)this.vEM.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).vFd > 0) {
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
          this.vEN.put(localObject, str2);
          str1 = at(this.vEN);
          this.vEN.remove(localObject);
          localObject = (e)this.vEM.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).vFd > 0) {
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
  
  public final String dpj()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.vEB.vFf.name;
    ((k.b)localObject).description = dpk();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = dpb();
    ((k.b)localObject).thumburl = this.vEB.dpm();
    ((k.b)localObject).hik = this.vEB.vFc;
    ((k.b)localObject).hil = a(this.vEB);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String dpk()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.vEB.vFf.vFr, this.vEB.vFf.vxl);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final String getAppId()
  {
    if (this.vEB.vFg != null) {
      return this.vEB.vFg.djj;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */