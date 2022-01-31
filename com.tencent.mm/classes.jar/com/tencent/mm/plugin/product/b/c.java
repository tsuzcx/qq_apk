package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private d ptT;
  public m ptU;
  public List<n> ptV;
  public String ptW;
  public String ptZ;
  public String pua;
  public aan pub;
  public cx puc;
  public bse pud;
  public String pue;
  public String puf;
  public int pug;
  public Map<String, e> puh;
  public Map<String, String> pui;
  public LinkedList<aan> puj;
  public LinkedList<au> puk;
  public e pul;
  private com.tencent.mm.plugin.product.ui.e pum;
  public Map<String, LinkedList<ym>> pun;
  
  public c()
  {
    AppMethodBeat.i(43952);
    this.ptT = null;
    this.mCount = 1;
    this.pui = new HashMap();
    this.pun = null;
    AppMethodBeat.o(43952);
  }
  
  public static String V(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43973);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(43973);
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
    AppMethodBeat.o(43973);
    return paramMap;
  }
  
  private int WV(String paramString)
  {
    AppMethodBeat.i(43963);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.pun != null)
    {
      j = k;
      if (this.pun.size() > 0)
      {
        paramString = (LinkedList)this.pun.get(paramString);
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
              i = ((ym)paramString.next()).wCm + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(43963);
    return j;
  }
  
  private void a(String[] paramArrayOfString, l paraml)
  {
    AppMethodBeat.i(43975);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      AppMethodBeat.o(43975);
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
      e locale = (e)this.puh.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.pup < paraml.pvd) {
          locale.pup = paraml.pvd;
        }
        if (locale.puq > paraml.pvd) {
          locale.puq = paraml.pvd;
        }
        locale.puy += paraml.puy;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.pup = paraml.pvd;
        locale.puq = paraml.pvd;
        locale.puy = paraml.puy;
        locale.pve = paraml.pve;
        locale.url = paraml.url;
        this.puh.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(43975);
  }
  
  private void am(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(43974);
    this.puh = new HashMap();
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      AppMethodBeat.o(43974);
      return;
    }
    int j = paramLinkedList.size();
    int i = 0;
    while (i < j)
    {
      l locall = (l)paramLinkedList.get(i);
      a(locall.pvc.split(";"), locall);
      i += 1;
    }
    cbl();
    AppMethodBeat.o(43974);
  }
  
  public final void Bm(int paramInt)
  {
    AppMethodBeat.i(43960);
    if (this.puj == null)
    {
      AppMethodBeat.o(43960);
      return;
    }
    if ((paramInt < this.puj.size()) && (paramInt >= 0)) {
      this.pub = ((aan)this.puj.get(paramInt));
    }
    AppMethodBeat.o(43960);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(43978);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.pux).append("</type>");
    localStringBuilder.append("<id>").append(paramm.puw).append("</id>");
    localStringBuilder.append("<version>").append(paramm.puA.version).append("</version>");
    localStringBuilder.append("<name>").append(bo.apT(paramm.puA.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.puA.puM).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.puA.puN).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.puA.puL).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bo.apT(this.ptU.puE)).append("</sourceUrl>");
    if (paramm.puA.puO != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.puA.puO.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.puA.puO.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bo.apT(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bo.apT(cbe())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bo.apT(paramm.cbp())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.ptU.puB != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.puB.cwc).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.puB.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.puB.username).append("</usrName>");
      localStringBuilder.append("</sellerInfo>");
    }
    localStringBuilder.append("</mallProductInfo>");
    paramm = localStringBuilder.toString();
    AppMethodBeat.o(43978);
    return paramm;
  }
  
  public final void a(m paramm, List<n> paramList)
  {
    int j = 0;
    AppMethodBeat.i(43954);
    clear();
    this.ptU = paramm;
    this.ptV = paramList;
    if (bo.isNullOrNil(this.ptU.puE)) {
      this.ptU.puE = this.ptZ;
    }
    am(this.ptU.puC);
    if ((this.ptU.puA != null) && (this.ptU.puA.puU != null)) {
      this.pug = this.ptU.puA.puU.size();
    }
    if ((this.ptU.puA != null) && (this.ptU.puA.puO != null) && (this.ptU.puA.puO.size() > 0)) {
      this.pue = ((String)this.ptU.puA.puO.get(0));
    }
    if (!bo.isNullOrNil(this.ptU.cbp()))
    {
      x.a(new com.tencent.mm.plugin.product.ui.c(this.ptU.cbp()));
      ab.d("MicroMsg.MallProductManager", "product img path : " + cbd());
    }
    if ((this.ptU.puD != null) && (this.ptU.puD.puY != null)) {}
    for (int i = this.ptU.puD.puY.bsY;; i = 0)
    {
      if (this.ptU.puB != null) {
        j = this.ptU.puB.bsY;
      }
      this.pum = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(43954);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> ad(Activity paramActivity)
  {
    AppMethodBeat.i(43959);
    LinkedList localLinkedList = new LinkedList();
    if (this.puk != null)
    {
      Iterator localIterator = this.puk.iterator();
      while (localIterator.hasNext())
      {
        au localau = (au)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localau.Name;
        locala.puI = localau.puI;
        locala.ntu = localau.ntu;
        locala.jKs = localau.jKs;
        locala.IconUrl = localau.IconUrl;
        if (locala.jKs == 1)
        {
          int i = WV(locala.ntu);
          if (i > 0) {
            locala.puI = paramActivity.getString(2131301493, new Object[] { b.d(i, this.ptU.puA.ppp) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(43959);
    return localLinkedList;
  }
  
  public final void ak(Intent paramIntent)
  {
    AppMethodBeat.i(43958);
    cx localcx = new cx();
    localcx.jJA = bo.bf(paramIntent.getStringExtra("userName"), "");
    localcx.wpj = bo.bf(paramIntent.getStringExtra("telNumber"), "");
    localcx.wpk = bo.bf(paramIntent.getStringExtra("addressPostalCode"), "");
    localcx.gwQ = bo.bf(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localcx.gwR = bo.bf(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localcx.gwY = bo.bf(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localcx.nqY = bo.bf(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bo.isNullOrNil(localcx.jJA)) && (!bo.isNullOrNil(localcx.wpj))) {
      this.puc = localcx;
    }
    AppMethodBeat.o(43958);
  }
  
  public final com.tencent.mm.plugin.product.ui.e caW()
  {
    AppMethodBeat.i(43955);
    if (this.pum == null) {
      this.pum = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.pum;
    AppMethodBeat.o(43955);
    return locale;
  }
  
  public final String caX()
  {
    AppMethodBeat.i(43956);
    if ((this.pul != null) && (!bo.isNullOrNil(this.pul.url)))
    {
      str = this.pul.url;
      AppMethodBeat.o(43956);
      return str;
    }
    String str = this.pue;
    AppMethodBeat.o(43956);
    return str;
  }
  
  public final String caY()
  {
    AppMethodBeat.i(43957);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.ptU.puA.puU.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.pui.get(((com.tencent.mm.plugin.product.c.m)localObject2).pvf);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).pvh.iterator();
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
    AppMethodBeat.o(43957);
    return localObject1;
  }
  
  public final int caZ()
  {
    AppMethodBeat.i(43961);
    int j = 0;
    int i = j;
    if (!caW().cbs())
    {
      i = j;
      if (this.pub != null) {
        i = this.pub.wCm + 0;
      }
    }
    if (this.pul != null) {
      i += this.pul.pup * this.mCount;
    }
    for (;;)
    {
      j = cba();
      AppMethodBeat.o(43961);
      return i - j;
      i += this.ptU.puA.puM * this.mCount;
    }
  }
  
  public final int cba()
  {
    AppMethodBeat.i(43962);
    int j = 0;
    int i = j;
    if (this.pun != null)
    {
      i = j;
      if (this.pun.size() > 0)
      {
        Iterator localIterator = this.pun.values().iterator();
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
                i += ((ym)((Iterator)localObject).next()).wCm;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(43962);
    return i;
  }
  
  public final bse cbb()
  {
    AppMethodBeat.i(43964);
    if (this.pud != null)
    {
      localObject = this.pud;
      AppMethodBeat.o(43964);
      return localObject;
    }
    if (this.ptT == null) {
      this.ptT = com.tencent.mm.plugin.product.a.a.caT().caV();
    }
    Object localObject = this.ptT;
    if ((((d)localObject).puo != null) && (((d)localObject).puo.size() > 0)) {}
    for (localObject = (String)((d)localObject).puo.get(0); !bo.isNullOrNil((String)localObject); localObject = null)
    {
      this.pud = new bse();
      this.pud.nqY = ((String)localObject);
      this.pud.xFH = 1;
      localObject = this.pud;
      AppMethodBeat.o(43964);
      return localObject;
    }
    localObject = this.puc;
    if ((localObject != null) && (!bo.isNullOrNil(((cx)localObject).jJA)))
    {
      this.pud = new bse();
      this.pud.nqY = ((cx)localObject).jJA;
      this.pud.xFH = 1;
      localObject = this.pud;
      AppMethodBeat.o(43964);
      return localObject;
    }
    AppMethodBeat.o(43964);
    return null;
  }
  
  public final String cbc()
  {
    if (this.ptU.puB != null) {
      return this.ptU.puB.username;
    }
    return null;
  }
  
  public final String cbd()
  {
    AppMethodBeat.i(43965);
    if (!bo.isNullOrNil(this.ptU.cbp()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.WX(this.ptU.cbp());
      AppMethodBeat.o(43965);
      return str;
    }
    AppMethodBeat.o(43965);
    return null;
  }
  
  public final String cbe()
  {
    AppMethodBeat.i(43966);
    if ((this.ptU.puA != null) && (this.ptU.puA.puW != null))
    {
      str = this.ptU.puA.puW.url;
      AppMethodBeat.o(43966);
      return str;
    }
    if (!bo.isNullOrNil(this.ptU.puE))
    {
      str = this.ptU.puE;
      AppMethodBeat.o(43966);
      return str;
    }
    String str = this.ptZ;
    AppMethodBeat.o(43966);
    return str;
  }
  
  public final int cbf()
  {
    int j = this.ptU.puy;
    int i = j;
    if (this.pul != null)
    {
      i = j;
      if (j > this.pul.puy) {
        i = this.pul.puy;
      }
    }
    return i;
  }
  
  public final boolean cbg()
  {
    AppMethodBeat.i(43967);
    if ((this.mCount > 0) && (this.ptU != null) && (this.mCount <= cbf()) && (this.ptU.puA != null) && (this.ptU.puA.puU != null))
    {
      AppMethodBeat.o(43967);
      return true;
    }
    AppMethodBeat.o(43967);
    return false;
  }
  
  public final boolean cbh()
  {
    AppMethodBeat.i(43968);
    if (!cbg())
    {
      AppMethodBeat.o(43968);
      return false;
    }
    if ((this.pui != null) && (this.pui.size() == this.pug)) {
      if (this.pug > 0)
      {
        if ((this.pul != null) && (this.mCount > 0) && (this.mCount <= cbf()))
        {
          AppMethodBeat.o(43968);
          return true;
        }
      }
      else if (this.pug == 0)
      {
        AppMethodBeat.o(43968);
        return true;
      }
    }
    AppMethodBeat.o(43968);
    return false;
  }
  
  public final boolean cbi()
  {
    AppMethodBeat.i(43969);
    if (!cbh())
    {
      AppMethodBeat.o(43969);
      return false;
    }
    if (this.puc == null)
    {
      AppMethodBeat.o(43969);
      return false;
    }
    if ((!caW().cbs()) && (this.pub == null))
    {
      AppMethodBeat.o(43969);
      return false;
    }
    AppMethodBeat.o(43969);
    return true;
  }
  
  public final LinkedList<bwh> cbj()
  {
    AppMethodBeat.i(43970);
    LinkedList localLinkedList = new LinkedList();
    bwh localbwh = new bwh();
    localbwh.jJu = this.mCount;
    localbwh.xec = this.ptU.puw;
    localbwh.xBY = this.ptU.puE;
    localbwh.xBZ = this.pua;
    localLinkedList.add(localbwh);
    AppMethodBeat.o(43970);
    return localLinkedList;
  }
  
  public final cdc cbk()
  {
    AppMethodBeat.i(43971);
    cdc localcdc = new cdc();
    localcdc.wDF = this.ptW;
    localcdc.pql = 1;
    localcdc.xNE = new LinkedList();
    bnt localbnt = new bnt();
    localbnt.jJu = this.mCount;
    localbnt.xec = this.ptU.puw;
    localbnt.Name = this.ptU.puA.name;
    if (this.pul != null) {}
    Iterator localIterator;
    Object localObject;
    for (localbnt.xBX = this.pul.pup;; localbnt.xBX = this.ptU.puA.puM)
    {
      localbnt.xBY = this.ptU.puE;
      localbnt.xBZ = this.pua;
      localbnt.jKs = this.ptU.pux;
      localbnt.xBV = this.pug;
      localbnt.xBW = new LinkedList();
      localIterator = this.pui.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.pui.get(localObject);
        ayv localayv = new ayv();
        localayv.wxP = ((String)localObject);
        localayv.qsu = str;
        localbnt.xBW.add(localayv);
      }
    }
    localbnt.xCd = new LinkedList();
    localbnt.xCc = 0;
    if ((this.pun != null) && (this.pun.size() > 0))
    {
      localIterator = this.pun.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localbnt.xCd.addAll((Collection)localObject);
        int i = localbnt.xCc;
        localbnt.xCc = (((LinkedList)localObject).size() + i);
      }
    }
    localcdc.xNE.add(localbnt);
    localcdc.xNG = new LinkedList();
    localcdc.xNH = 1;
    this.pud = cbb();
    if (this.pud != null) {
      localcdc.xNG.add(this.pud);
    }
    for (;;)
    {
      localcdc.xcr = this.puc;
      localcdc.xNF = this.pub;
      AppMethodBeat.o(43971);
      return localcdc;
      this.pud = new bse();
      this.pud.xFH = 0;
      localcdc.xNG.add(this.pud);
    }
  }
  
  public final void cbl()
  {
    AppMethodBeat.i(43972);
    if (this.pui == null)
    {
      AppMethodBeat.o(43972);
      return;
    }
    Iterator localIterator1 = this.ptU.puA.puU.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.pvh.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.pvf;
        str2 = localh.id;
        if ((this.pui != null) && (this.puh != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.pva = bool;
        ab.d("MicroMsg.MallProductManager", "(" + localm.pvf + " , " + localh.id + ") hasStock--> " + localh.pva);
        break label62;
        break;
        label176:
        String str1;
        if (this.pui.containsKey(localObject))
        {
          str1 = (String)this.pui.get(localObject);
          this.pui.put(localObject, str2);
          str2 = V(this.pui);
          this.pui.put(localObject, str1);
          localObject = (e)this.puh.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).puy > 0) {
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
          this.pui.put(localObject, str2);
          str1 = V(this.pui);
          this.pui.remove(localObject);
          localObject = (e)this.puh.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).puy > 0) {
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
    AppMethodBeat.o(43972);
  }
  
  public final String cbm()
  {
    AppMethodBeat.i(43976);
    Object localObject = new j.b();
    ((j.b)localObject).title = this.ptU.puA.name;
    ((j.b)localObject).description = cbn();
    ((j.b)localObject).type = 13;
    ((j.b)localObject).url = cbe();
    ((j.b)localObject).thumburl = this.ptU.cbp();
    ((j.b)localObject).fhd = this.ptU.pux;
    ((j.b)localObject).fhe = a(this.ptU);
    localObject = j.b.a((j.b)localObject, null, null);
    AppMethodBeat.o(43976);
    return localObject;
  }
  
  public final String cbn()
  {
    AppMethodBeat.i(43977);
    String str = b.d(this.ptU.puA.puN, this.ptU.puA.ppp);
    AppMethodBeat.o(43977);
    return str;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(43953);
    this.ptU = null;
    if (this.ptV != null)
    {
      this.ptV.clear();
      this.ptV = null;
    }
    this.ptW = null;
    this.ptZ = null;
    this.mCount = 1;
    this.pua = null;
    this.pub = null;
    this.pud = null;
    this.pue = null;
    this.pug = 0;
    this.pul = null;
    if (this.puh != null)
    {
      this.puh.clear();
      this.puh = null;
    }
    if (this.pui != null) {
      this.pui.clear();
    }
    if (this.puj != null)
    {
      this.puj.clear();
      this.puj = null;
    }
    if (this.pun != null)
    {
      this.pun.clear();
      this.pun = null;
    }
    AppMethodBeat.o(43953);
  }
  
  public final String getAppId()
  {
    if (this.ptU.puB != null) {
      return this.ptU.puB.cwc;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */