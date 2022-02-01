package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.dyy;
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

public final class c
{
  private d AYW;
  public m AYX;
  public List<n> AYY;
  public String AYZ;
  public String AZa;
  public String AZb;
  public akg AZc;
  public dr AZd;
  public dki AZe;
  public String AZf;
  public String AZg;
  public int AZh;
  public Map<String, e> AZi;
  public Map<String, String> AZj;
  public LinkedList<akg> AZk;
  public LinkedList<bd> AZl;
  public e AZm;
  private com.tencent.mm.plugin.product.ui.e AZn;
  public Map<String, LinkedList<ahl>> AZo;
  public int mCount;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.AYW = null;
    this.mCount = 1;
    this.AZj = new HashMap();
    this.AZo = null;
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
      e locale = (e)this.AZi.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.AZq < paraml.Bac) {
          locale.AZq = paraml.Bac;
        }
        if (locale.AZr > paraml.Bac) {
          locale.AZr = paraml.Bac;
        }
        locale.AZz += paraml.AZz;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.AZq = paraml.Bac;
        locale.AZr = paraml.Bac;
        locale.AZz = paraml.AZz;
        locale.Bad = paraml.Bad;
        locale.url = paraml.url;
        this.AZi.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  public static String aF(Map<String, String> paramMap)
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
  
  private int aKh(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.AZo != null)
    {
      j = k;
      if (this.AZo.size() > 0)
      {
        paramString = (LinkedList)this.AZo.get(paramString);
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
              i = ((ahl)paramString.next()).KZx + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  private void bh(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.AZi = new HashMap();
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
      a(locall.Bab.split(";"), locall);
      i += 1;
    }
    eDt();
    AppMethodBeat.o(66880);
  }
  
  public final void Ut(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.AZk == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.AZk.size()) && (paramInt >= 0)) {
      this.AZc = ((akg)this.AZk.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.AZy).append("</type>");
    localStringBuilder.append("<id>").append(paramm.AZx).append("</id>");
    localStringBuilder.append("<version>").append(paramm.AZB.version).append("</version>");
    localStringBuilder.append("<name>").append(Util.escapeStringForXml(paramm.AZB.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.AZB.AZM).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.AZB.AZN).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.AZB.AZL).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(Util.escapeStringForXml(this.AYX.eby)).append("</sourceUrl>");
    if (paramm.AZB.AZO != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.AZB.AZO.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.AZB.AZO.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(Util.escapeStringForXml(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(Util.escapeStringForXml(eDm())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(Util.escapeStringForXml(paramm.eDx())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.AYX.AZC != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.AZC.dNI).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.AZC.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.AZC.username).append("</usrName>");
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
    this.AYX = paramm;
    this.AYY = paramList;
    if (Util.isNullOrNil(this.AYX.eby)) {
      this.AYX.eby = this.AZa;
    }
    bh(this.AYX.AZD);
    if ((this.AYX.AZB != null) && (this.AYX.AZB.AZU != null)) {
      this.AZh = this.AYX.AZB.AZU.size();
    }
    if ((this.AYX.AZB != null) && (this.AYX.AZB.AZO != null) && (this.AYX.AZB.AZO.size() > 0)) {
      this.AZf = ((String)this.AYX.AZB.AZO.get(0));
    }
    if (!Util.isNullOrNil(this.AYX.eDx()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.AYX.eDx()));
      Log.d("MicroMsg.MallProductManager", "product img path : " + eDl());
    }
    if ((this.AYX.AZE != null) && (this.AYX.AZE.AZY != null)) {}
    for (int i = this.AYX.AZE.AZY.cSx;; i = 0)
    {
      if (this.AYX.AZC != null) {
        j = this.AYX.AZC.cSx;
      }
      this.AZn = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> aB(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.AZl != null)
    {
      Iterator localIterator = this.AZl.iterator();
      while (localIterator.hasNext())
      {
        bd localbd = (bd)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localbd.Name;
        locala.AZI = localbd.AZI;
        locala.iAc = localbd.iAc;
        locala.oUv = localbd.oUv;
        locala.IconUrl = localbd.IconUrl;
        if (locala.oUv == 1)
        {
          int i = aKh(locala.iAc);
          if (i > 0) {
            locala.AZI = paramActivity.getString(2131762927, new Object[] { b.c(i, this.AYX.AZB.AOl) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void aO(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    dr localdr = new dr();
    localdr.UserName = Util.nullAs(paramIntent.getStringExtra("userName"), "");
    localdr.KHE = Util.nullAs(paramIntent.getStringExtra("telNumber"), "");
    localdr.KHF = Util.nullAs(paramIntent.getStringExtra("addressPostalCode"), "");
    localdr.kdZ = Util.nullAs(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdr.kea = Util.nullAs(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdr.keh = Util.nullAs(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdr.xKd = Util.nullAs(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!Util.isNullOrNil(localdr.UserName)) && (!Util.isNullOrNil(localdr.KHE))) {
      this.AZd = localdr;
    }
    AppMethodBeat.o(66864);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.AYX = null;
    if (this.AYY != null)
    {
      this.AYY.clear();
      this.AYY = null;
    }
    this.AYZ = null;
    this.AZa = null;
    this.mCount = 1;
    this.AZb = null;
    this.AZc = null;
    this.AZe = null;
    this.AZf = null;
    this.AZh = 0;
    this.AZm = null;
    if (this.AZi != null)
    {
      this.AZi.clear();
      this.AZi = null;
    }
    if (this.AZj != null) {
      this.AZj.clear();
    }
    if (this.AZk != null)
    {
      this.AZk.clear();
      this.AZk = null;
    }
    if (this.AZo != null)
    {
      this.AZo.clear();
      this.AZo = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final com.tencent.mm.plugin.product.ui.e eDe()
  {
    AppMethodBeat.i(66861);
    if (this.AZn == null) {
      this.AZn = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.AZn;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String eDf()
  {
    AppMethodBeat.i(66862);
    if ((this.AZm != null) && (!Util.isNullOrNil(this.AZm.url)))
    {
      str = this.AZm.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.AZf;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String eDg()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.AYX.AZB.AZU.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.AZj.get(((com.tencent.mm.plugin.product.c.m)localObject2).Bae);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).Bag.iterator();
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
  
  public final int eDh()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!eDe().eDA())
    {
      i = j;
      if (this.AZc != null) {
        i = this.AZc.KZx + 0;
      }
    }
    if (this.AZm != null) {
      i += this.AZm.AZq * this.mCount;
    }
    for (;;)
    {
      j = eDi();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.AYX.AZB.AZM * this.mCount;
    }
  }
  
  public final int eDi()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.AZo != null)
    {
      i = j;
      if (this.AZo.size() > 0)
      {
        Iterator localIterator = this.AZo.values().iterator();
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
                i += ((ahl)((Iterator)localObject).next()).KZx;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final dki eDj()
  {
    AppMethodBeat.i(66870);
    if (this.AZe != null)
    {
      localObject = this.AZe;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.AYW == null) {
      this.AYW = com.tencent.mm.plugin.product.a.a.eDb().eDd();
    }
    Object localObject = this.AYW;
    if ((((d)localObject).AZp != null) && (((d)localObject).AZp.size() > 0)) {}
    for (localObject = (String)((d)localObject).AZp.get(0); !Util.isNullOrNil((String)localObject); localObject = null)
    {
      this.AZe = new dki();
      this.AZe.xKd = ((String)localObject);
      this.AZe.MOm = 1;
      localObject = this.AZe;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.AZd;
    if ((localObject != null) && (!Util.isNullOrNil(((dr)localObject).UserName)))
    {
      this.AZe = new dki();
      this.AZe.xKd = ((dr)localObject).UserName;
      this.AZe.MOm = 1;
      localObject = this.AZe;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String eDk()
  {
    if (this.AYX.AZC != null) {
      return this.AYX.AZC.username;
    }
    return null;
  }
  
  public final String eDl()
  {
    AppMethodBeat.i(66871);
    if (!Util.isNullOrNil(this.AYX.eDx()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.aKj(this.AYX.eDx());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String eDm()
  {
    AppMethodBeat.i(66872);
    if ((this.AYX.AZB != null) && (this.AYX.AZB.AZW != null))
    {
      str = this.AYX.AZB.AZW.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!Util.isNullOrNil(this.AYX.eby))
    {
      str = this.AYX.eby;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.AZa;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int eDn()
  {
    int j = this.AYX.AZz;
    int i = j;
    if (this.AZm != null)
    {
      i = j;
      if (j > this.AZm.AZz) {
        i = this.AZm.AZz;
      }
    }
    return i;
  }
  
  public final boolean eDo()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.AYX != null) && (this.mCount <= eDn()) && (this.AYX.AZB != null) && (this.AYX.AZB.AZU != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean eDp()
  {
    AppMethodBeat.i(66874);
    if (!eDo())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.AZj != null) && (this.AZj.size() == this.AZh)) {
      if (this.AZh > 0)
      {
        if ((this.AZm != null) && (this.mCount > 0) && (this.mCount <= eDn()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.AZh == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean eDq()
  {
    AppMethodBeat.i(66875);
    if (!eDp())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.AZd == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!eDe().eDA()) && (this.AZc == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<dqn> eDr()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    dqn localdqn = new dqn();
    localdqn.oTz = this.mCount;
    localdqn.LZy = this.AYX.AZx;
    localdqn.MJR = this.AYX.eby;
    localdqn.MJS = this.AZb;
    localLinkedList.add(localdqn);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final dyy eDs()
  {
    AppMethodBeat.i(66877);
    dyy localdyy = new dyy();
    localdyy.Lca = this.AYZ;
    localdyy.APg = 1;
    localdyy.MYz = new LinkedList();
    dev localdev = new dev();
    localdev.oTz = this.mCount;
    localdev.LZy = this.AYX.AZx;
    localdev.Name = this.AYX.AZB.name;
    if (this.AZm != null) {}
    Iterator localIterator;
    Object localObject;
    for (localdev.MJQ = this.AZm.AZq;; localdev.MJQ = this.AYX.AZB.AZM)
    {
      localdev.MJR = this.AYX.eby;
      localdev.MJS = this.AZb;
      localdev.oUv = this.AYX.AZy;
      localdev.MJO = this.AZh;
      localdev.MJP = new LinkedList();
      localIterator = this.AZj.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.AZj.get(localObject);
        cfw localcfw = new cfw();
        localcfw.xMX = ((String)localObject);
        localcfw.Cyk = str;
        localdev.MJP.add(localcfw);
      }
    }
    localdev.MJW = new LinkedList();
    localdev.MJV = 0;
    if ((this.AZo != null) && (this.AZo.size() > 0))
    {
      localIterator = this.AZo.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localdev.MJW.addAll((Collection)localObject);
        int i = localdev.MJV;
        localdev.MJV = (((LinkedList)localObject).size() + i);
      }
    }
    localdyy.MYz.add(localdev);
    localdyy.MYB = new LinkedList();
    localdyy.MYC = 1;
    this.AZe = eDj();
    if (this.AZe != null) {
      localdyy.MYB.add(this.AZe);
    }
    for (;;)
    {
      localdyy.LWZ = this.AZd;
      localdyy.MYA = this.AZc;
      AppMethodBeat.o(66877);
      return localdyy;
      this.AZe = new dki();
      this.AZe.MOm = 0;
      localdyy.MYB.add(this.AZe);
    }
  }
  
  public final void eDt()
  {
    AppMethodBeat.i(66878);
    if (this.AZj == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.AYX.AZB.AZU.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.Bag.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.Bae;
        str2 = localh.id;
        if ((this.AZj != null) && (this.AZi != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.iJ = bool;
        Log.d("MicroMsg.MallProductManager", "(" + localm.Bae + " , " + localh.id + ") hasStock--> " + localh.iJ);
        break label62;
        break;
        label176:
        String str1;
        if (this.AZj.containsKey(localObject))
        {
          str1 = (String)this.AZj.get(localObject);
          this.AZj.put(localObject, str2);
          str2 = aF(this.AZj);
          this.AZj.put(localObject, str1);
          localObject = (e)this.AZi.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).AZz > 0) {
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
          this.AZj.put(localObject, str2);
          str1 = aF(this.AZj);
          this.AZj.remove(localObject);
          localObject = (e)this.AZi.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).AZz > 0) {
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
  
  public final String eDu()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.AYX.AZB.name;
    ((k.b)localObject).description = eDv();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = eDm();
    ((k.b)localObject).thumburl = this.AYX.eDx();
    ((k.b)localObject).ixm = this.AYX.AZy;
    ((k.b)localObject).ixn = a(this.AYX);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String eDv()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.AYX.AZB.AZN, this.AYX.AZB.AOl);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final String getAppId()
  {
    if (this.AYX.AZC != null) {
      return this.AYX.AZC.dNI;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */