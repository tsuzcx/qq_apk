package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private d GSU;
  public m GSV;
  public List<n> GSW;
  public String GSX;
  public String GSY;
  public String GSZ;
  public alj GTa;
  public dp GTb;
  public dtx GTc;
  public String GTd;
  public String GTe;
  public int GTf;
  public Map<String, e> GTg;
  public Map<String, String> GTh;
  public LinkedList<alj> GTi;
  public LinkedList<bb> GTj;
  public e GTk;
  private com.tencent.mm.plugin.product.ui.e GTl;
  public Map<String, LinkedList<ahw>> GTm;
  public int mCount;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.GSU = null;
    this.mCount = 1;
    this.GTh = new HashMap();
    this.GTm = null;
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
      e locale = (e)this.GTg.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.GTo < paraml.GUa) {
          locale.GTo = paraml.GUa;
        }
        if (locale.GTp > paraml.GUa) {
          locale.GTp = paraml.GUa;
        }
        locale.GTx += paraml.GTx;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.GTo = paraml.GUa;
        locale.GTp = paraml.GUa;
        locale.GTx = paraml.GTx;
        locale.GUb = paraml.GUb;
        locale.url = paraml.url;
        this.GTg.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  private int aUF(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.GTm != null)
    {
      j = k;
      if (this.GTm.size() > 0)
      {
        paramString = (LinkedList)this.GTm.get(paramString);
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
              i = ((ahw)paramString.next()).SaG + i;
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
    Collections.sort((List)localObject, new Comparator() {});
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
  
  private void bB(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.GTg = new HashMap();
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
      a(locall.GTZ.split(";"), locall);
      i += 1;
    }
    fpm();
    AppMethodBeat.o(66880);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.GTw).append("</type>");
    localStringBuilder.append("<id>").append(paramm.GTv).append("</id>");
    localStringBuilder.append("<version>").append(paramm.GTz.version).append("</version>");
    localStringBuilder.append("<name>").append(Util.escapeStringForXml(paramm.GTz.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.GTz.GTK).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.GTz.GTL).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.GTz.GTJ).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(Util.escapeStringForXml(this.GSV.fVx)).append("</sourceUrl>");
    if (paramm.GTz.GTM != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.GTz.GTM.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.GTz.GTM.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(Util.escapeStringForXml(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(Util.escapeStringForXml(fpf())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(Util.escapeStringForXml(paramm.fpq())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.GSV.GTA != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.GTA.appid).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.GTA.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.GTA.username).append("</usrName>");
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
    this.GSV = paramm;
    this.GSW = paramList;
    if (Util.isNullOrNil(this.GSV.fVx)) {
      this.GSV.fVx = this.GSY;
    }
    bB(this.GSV.GTB);
    if ((this.GSV.GTz != null) && (this.GSV.GTz.GTS != null)) {
      this.GTf = this.GSV.GTz.GTS.size();
    }
    if ((this.GSV.GTz != null) && (this.GSV.GTz.GTM != null) && (this.GSV.GTz.GTM.size() > 0)) {
      this.GTd = ((String)this.GSV.GTz.GTM.get(0));
    }
    if (!Util.isNullOrNil(this.GSV.fpq()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.GSV.fpq()));
      Log.d("MicroMsg.MallProductManager", "product img path : " + fpe());
    }
    if ((this.GSV.GTC != null) && (this.GSV.GTC.GTW != null)) {}
    for (int i = this.GSV.GTC.GTW.cUP;; i = 0)
    {
      if (this.GSV.GTA != null) {
        j = this.GSV.GTA.cUP;
      }
      this.GTl = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> aH(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.GTj != null)
    {
      Iterator localIterator = this.GTj.iterator();
      while (localIterator.hasNext())
      {
        bb localbb = (bb)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.CMP = localbb.CMP;
        locala.GTG = localbb.GTG;
        locala.lpy = localbb.lpy;
        locala.rWu = localbb.rWu;
        locala.CNj = localbb.CNj;
        if (locala.rWu == 1)
        {
          int i = aUF(locala.lpy);
          if (i > 0) {
            locala.GTG = paramActivity.getString(a.i.mall_product_submit_preferential_summray, new Object[] { b.c(i, this.GSV.GTz.GHz) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void aN(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    dp localdp = new dp();
    localdp.UserName = Util.nullAs(paramIntent.getStringExtra("userName"), "");
    localdp.RIX = Util.nullAs(paramIntent.getStringExtra("telNumber"), "");
    localdp.RIY = Util.nullAs(paramIntent.getStringExtra("addressPostalCode"), "");
    localdp.mVz = Util.nullAs(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdp.mVA = Util.nullAs(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdp.mVH = Util.nullAs(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdp.COk = Util.nullAs(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!Util.isNullOrNil(localdp.UserName)) && (!Util.isNullOrNil(localdp.RIX))) {
      this.GTb = localdp;
    }
    AppMethodBeat.o(66864);
  }
  
  public final void abf(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.GTi == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.GTi.size()) && (paramInt >= 0)) {
      this.GTa = ((alj)this.GTi.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.GSV = null;
    if (this.GSW != null)
    {
      this.GSW.clear();
      this.GSW = null;
    }
    this.GSX = null;
    this.GSY = null;
    this.mCount = 1;
    this.GSZ = null;
    this.GTa = null;
    this.GTc = null;
    this.GTd = null;
    this.GTf = 0;
    this.GTk = null;
    if (this.GTg != null)
    {
      this.GTg.clear();
      this.GTg = null;
    }
    if (this.GTh != null) {
      this.GTh.clear();
    }
    if (this.GTi != null)
    {
      this.GTi.clear();
      this.GTi = null;
    }
    if (this.GTm != null)
    {
      this.GTm.clear();
      this.GTm = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final com.tencent.mm.plugin.product.ui.e foX()
  {
    AppMethodBeat.i(66861);
    if (this.GTl == null) {
      this.GTl = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.GTl;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String foY()
  {
    AppMethodBeat.i(66862);
    if ((this.GTk != null) && (!Util.isNullOrNil(this.GTk.url)))
    {
      str = this.GTk.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.GTd;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String foZ()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.GSV.GTz.GTS.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.GTh.get(((com.tencent.mm.plugin.product.c.m)localObject2).GUc);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).GUe.iterator();
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
  
  public final int fpa()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!foX().fpt())
    {
      i = j;
      if (this.GTa != null) {
        i = this.GTa.SaG + 0;
      }
    }
    if (this.GTk != null) {
      i += this.GTk.GTo * this.mCount;
    }
    for (;;)
    {
      j = fpb();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.GSV.GTz.GTK * this.mCount;
    }
  }
  
  public final int fpb()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.GTm != null)
    {
      i = j;
      if (this.GTm.size() > 0)
      {
        Iterator localIterator = this.GTm.values().iterator();
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
                i += ((ahw)((Iterator)localObject).next()).SaG;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final dtx fpc()
  {
    AppMethodBeat.i(66870);
    if (this.GTc != null)
    {
      localObject = this.GTc;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.GSU == null) {
      this.GSU = com.tencent.mm.plugin.product.a.a.foU().foW();
    }
    Object localObject = this.GSU;
    if ((((d)localObject).GTn != null) && (((d)localObject).GTn.size() > 0)) {}
    for (localObject = (String)((d)localObject).GTn.get(0); !Util.isNullOrNil((String)localObject); localObject = null)
    {
      this.GTc = new dtx();
      this.GTc.COk = ((String)localObject);
      this.GTc.Uaf = 1;
      localObject = this.GTc;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.GTb;
    if ((localObject != null) && (!Util.isNullOrNil(((dp)localObject).UserName)))
    {
      this.GTc = new dtx();
      this.GTc.COk = ((dp)localObject).UserName;
      this.GTc.Uaf = 1;
      localObject = this.GTc;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String fpd()
  {
    if (this.GSV.GTA != null) {
      return this.GSV.GTA.username;
    }
    return null;
  }
  
  public final String fpe()
  {
    AppMethodBeat.i(66871);
    if (!Util.isNullOrNil(this.GSV.fpq()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.aUH(this.GSV.fpq());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String fpf()
  {
    AppMethodBeat.i(66872);
    if ((this.GSV.GTz != null) && (this.GSV.GTz.GTU != null))
    {
      str = this.GSV.GTz.GTU.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!Util.isNullOrNil(this.GSV.fVx))
    {
      str = this.GSV.fVx;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.GSY;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int fpg()
  {
    int j = this.GSV.GTx;
    int i = j;
    if (this.GTk != null)
    {
      i = j;
      if (j > this.GTk.GTx) {
        i = this.GTk.GTx;
      }
    }
    return i;
  }
  
  public final boolean fph()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.GSV != null) && (this.mCount <= fpg()) && (this.GSV.GTz != null) && (this.GSV.GTz.GTS != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean fpi()
  {
    AppMethodBeat.i(66874);
    if (!fph())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.GTh != null) && (this.GTh.size() == this.GTf)) {
      if (this.GTf > 0)
      {
        if ((this.GTk != null) && (this.mCount > 0) && (this.mCount <= fpg()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.GTf == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean fpj()
  {
    AppMethodBeat.i(66875);
    if (!fpi())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.GTb == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!foX().fpt()) && (this.GTa == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<eak> fpk()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    eak localeak = new eak();
    localeak.rVx = this.mCount;
    localeak.TiR = this.GSV.GTv;
    localeak.TVK = this.GSV.fVx;
    localeak.TVL = this.GSZ;
    localLinkedList.add(localeak);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final eiy fpl()
  {
    AppMethodBeat.i(66877);
    eiy localeiy = new eiy();
    localeiy.Sdn = this.GSX;
    localeiy.GIu = 1;
    localeiy.UkR = new LinkedList();
    doo localdoo = new doo();
    localdoo.rVx = this.mCount;
    localdoo.TiR = this.GSV.GTv;
    localdoo.CMP = this.GSV.GTz.name;
    if (this.GTk != null) {}
    Iterator localIterator;
    Object localObject;
    for (localdoo.TVJ = this.GTk.GTo;; localdoo.TVJ = this.GSV.GTz.GTK)
    {
      localdoo.TVK = this.GSV.fVx;
      localdoo.TVL = this.GSZ;
      localdoo.rWu = this.GSV.GTw;
      localdoo.TVH = this.GTf;
      localdoo.TVI = new LinkedList();
      localIterator = this.GTh.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.GTh.get(localObject);
        cos localcos = new cos();
        localcos.CRg = ((String)localObject);
        localcos.Izj = str;
        localdoo.TVI.add(localcos);
      }
    }
    localdoo.TVP = new LinkedList();
    localdoo.TVO = 0;
    if ((this.GTm != null) && (this.GTm.size() > 0))
    {
      localIterator = this.GTm.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localdoo.TVP.addAll((Collection)localObject);
        int i = localdoo.TVO;
        localdoo.TVO = (((LinkedList)localObject).size() + i);
      }
    }
    localeiy.UkR.add(localdoo);
    localeiy.UkT = new LinkedList();
    localeiy.UkU = 1;
    this.GTc = fpc();
    if (this.GTc != null) {
      localeiy.UkT.add(this.GTc);
    }
    for (;;)
    {
      localeiy.Tgx = this.GTb;
      localeiy.UkS = this.GTa;
      AppMethodBeat.o(66877);
      return localeiy;
      this.GTc = new dtx();
      this.GTc.Uaf = 0;
      localeiy.UkT.add(this.GTc);
    }
  }
  
  public final void fpm()
  {
    AppMethodBeat.i(66878);
    if (this.GTh == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.GSV.GTz.GTS.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.GUe.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.GUc;
        str2 = localh.id;
        if ((this.GTh != null) && (this.GTg != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.bzb = bool;
        Log.d("MicroMsg.MallProductManager", "(" + localm.GUc + " , " + localh.id + ") hasStock--> " + localh.bzb);
        break label62;
        break;
        label176:
        String str1;
        if (this.GTh.containsKey(localObject))
        {
          str1 = (String)this.GTh.get(localObject);
          this.GTh.put(localObject, str2);
          str2 = az(this.GTh);
          this.GTh.put(localObject, str1);
          localObject = (e)this.GTg.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).GTx > 0) {
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
          this.GTh.put(localObject, str2);
          str1 = az(this.GTh);
          this.GTh.remove(localObject);
          localObject = (e)this.GTg.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).GTx > 0) {
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
  
  public final String fpn()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.GSV.GTz.name;
    ((k.b)localObject).description = fpo();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = fpf();
    ((k.b)localObject).thumburl = this.GSV.fpq();
    ((k.b)localObject).lmB = this.GSV.GTw;
    ((k.b)localObject).lmC = a(this.GSV);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String fpo()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.GSV.GTz.GTL, this.GSV.GTz.GHz);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final String getAppId()
  {
    if (this.GSV.GTA != null) {
      return this.GSV.GTA.appid;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */