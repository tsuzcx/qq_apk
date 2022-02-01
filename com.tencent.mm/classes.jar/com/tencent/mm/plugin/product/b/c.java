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
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.df;
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
  private d uvH;
  public m uvI;
  public List<n> uvJ;
  public String uvK;
  public String uvL;
  public String uvM;
  public aec uvN;
  public df uvO;
  public chi uvP;
  public String uvQ;
  public String uvR;
  public int uvS;
  public Map<String, e> uvT;
  public Map<String, String> uvU;
  public LinkedList<aec> uvV;
  public LinkedList<ax> uvW;
  public e uvX;
  private com.tencent.mm.plugin.product.ui.e uvY;
  public Map<String, LinkedList<abw>> uvZ;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.uvH = null;
    this.mCount = 1;
    this.uvU = new HashMap();
    this.uvZ = null;
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
      e locale = (e)this.uvT.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.uwb < paraml.uwN) {
          locale.uwb = paraml.uwN;
        }
        if (locale.uwc > paraml.uwN) {
          locale.uwc = paraml.uwN;
        }
        locale.uwk += paraml.uwk;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.uwb = paraml.uwN;
        locale.uwc = paraml.uwN;
        locale.uwk = paraml.uwk;
        locale.uwO = paraml.uwO;
        locale.url = paraml.url;
        this.uvT.put(localStringBuilder.toString(), locale);
      }
    }
    AppMethodBeat.o(66881);
  }
  
  private void aB(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.uvT = new HashMap();
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
      a(locall.uwM.split(";"), locall);
      i += 1;
    }
    dbA();
    AppMethodBeat.o(66880);
  }
  
  private int akv(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.uvZ != null)
    {
      j = k;
      if (this.uvZ.size() > 0)
      {
        paramString = (LinkedList)this.uvZ.get(paramString);
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
              i = ((abw)paramString.next()).CNG + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  public static String ar(Map<String, String> paramMap)
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
  
  public final void IY(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.uvV == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.uvV.size()) && (paramInt >= 0)) {
      this.uvN = ((aec)this.uvV.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.uwj).append("</type>");
    localStringBuilder.append("<id>").append(paramm.uwi).append("</id>");
    localStringBuilder.append("<version>").append(paramm.uwm.version).append("</version>");
    localStringBuilder.append("<name>").append(bt.aGf(paramm.uwm.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.uwm.uwx).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.uwm.uwy).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.uwm.uww).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bt.aGf(this.uvI.kqB)).append("</sourceUrl>");
    if (paramm.uwm.uwz != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.uwm.uwz.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.uwm.uwz.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bt.aGf(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bt.aGf(dbt())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bt.aGf(paramm.dbE())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.uvI.uwn != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.uwn.dlB).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.uwn.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.uwn.username).append("</usrName>");
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
    this.uvI = paramm;
    this.uvJ = paramList;
    if (bt.isNullOrNil(this.uvI.kqB)) {
      this.uvI.kqB = this.uvL;
    }
    aB(this.uvI.uwo);
    if ((this.uvI.uwm != null) && (this.uvI.uwm.uwF != null)) {
      this.uvS = this.uvI.uwm.uwF.size();
    }
    if ((this.uvI.uwm != null) && (this.uvI.uwm.uwz != null) && (this.uvI.uwm.uwz.size() > 0)) {
      this.uvQ = ((String)this.uvI.uwm.uwz.get(0));
    }
    if (!bt.isNullOrNil(this.uvI.dbE()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.uvI.dbE()));
      ad.d("MicroMsg.MallProductManager", "product img path : " + dbs());
    }
    if ((this.uvI.uwp != null) && (this.uvI.uwp.uwJ != null)) {}
    for (int i = this.uvI.uwp.uwJ.dtM;; i = 0)
    {
      if (this.uvI.uwn != null) {
        j = this.uvI.uwn.dtM;
      }
      this.uvY = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> av(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.uvW != null)
    {
      Iterator localIterator = this.uvW.iterator();
      while (localIterator.hasNext())
      {
        ax localax = (ax)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localax.Name;
        locala.uwt = localax.uwt;
        locala.gKr = localax.gKr;
        locala.mBH = localax.mBH;
        locala.IconUrl = localax.IconUrl;
        if (locala.mBH == 1)
        {
          int i = akv(locala.gKr);
          if (i > 0) {
            locala.uwt = paramActivity.getString(2131761140, new Object[] { b.c(i, this.uvI.uwm.uop) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void az(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    df localdf = new df();
    localdf.mAQ = bt.by(paramIntent.getStringExtra("userName"), "");
    localdf.CxQ = bt.by(paramIntent.getStringExtra("telNumber"), "");
    localdf.CxR = bt.by(paramIntent.getStringExtra("addressPostalCode"), "");
    localdf.ijN = bt.by(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdf.ijO = bt.by(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdf.ijV = bt.by(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdf.saB = bt.by(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bt.isNullOrNil(localdf.mAQ)) && (!bt.isNullOrNil(localdf.CxQ))) {
      this.uvO = localdf;
    }
    AppMethodBeat.o(66864);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.uvI = null;
    if (this.uvJ != null)
    {
      this.uvJ.clear();
      this.uvJ = null;
    }
    this.uvK = null;
    this.uvL = null;
    this.mCount = 1;
    this.uvM = null;
    this.uvN = null;
    this.uvP = null;
    this.uvQ = null;
    this.uvS = 0;
    this.uvX = null;
    if (this.uvT != null)
    {
      this.uvT.clear();
      this.uvT = null;
    }
    if (this.uvU != null) {
      this.uvU.clear();
    }
    if (this.uvV != null)
    {
      this.uvV.clear();
      this.uvV = null;
    }
    if (this.uvZ != null)
    {
      this.uvZ.clear();
      this.uvZ = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final void dbA()
  {
    AppMethodBeat.i(66878);
    if (this.uvU == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.uvI.uwm.uwF.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.uwR.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.uwP;
        str2 = localh.id;
        if ((this.uvU != null) && (this.uvT != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.fN = bool;
        ad.d("MicroMsg.MallProductManager", "(" + localm.uwP + " , " + localh.id + ") hasStock--> " + localh.fN);
        break label62;
        break;
        label176:
        String str1;
        if (this.uvU.containsKey(localObject))
        {
          str1 = (String)this.uvU.get(localObject);
          this.uvU.put(localObject, str2);
          str2 = ar(this.uvU);
          this.uvU.put(localObject, str1);
          localObject = (e)this.uvT.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).uwk > 0) {
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
          this.uvU.put(localObject, str2);
          str1 = ar(this.uvU);
          this.uvU.remove(localObject);
          localObject = (e)this.uvT.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).uwk > 0) {
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
  
  public final String dbB()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.uvI.uwm.name;
    ((k.b)localObject).description = dbC();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = dbt();
    ((k.b)localObject).thumburl = this.uvI.dbE();
    ((k.b)localObject).gHJ = this.uvI.uwj;
    ((k.b)localObject).gHK = a(this.uvI);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String dbC()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.uvI.uwm.uwy, this.uvI.uwm.uop);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final com.tencent.mm.plugin.product.ui.e dbl()
  {
    AppMethodBeat.i(66861);
    if (this.uvY == null) {
      this.uvY = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.uvY;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String dbm()
  {
    AppMethodBeat.i(66862);
    if ((this.uvX != null) && (!bt.isNullOrNil(this.uvX.url)))
    {
      str = this.uvX.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.uvQ;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String dbn()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.uvI.uwm.uwF.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.uvU.get(((com.tencent.mm.plugin.product.c.m)localObject2).uwP);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).uwR.iterator();
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
  
  public final int dbo()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!dbl().dbH())
    {
      i = j;
      if (this.uvN != null) {
        i = this.uvN.CNG + 0;
      }
    }
    if (this.uvX != null) {
      i += this.uvX.uwb * this.mCount;
    }
    for (;;)
    {
      j = dbp();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.uvI.uwm.uwx * this.mCount;
    }
  }
  
  public final int dbp()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.uvZ != null)
    {
      i = j;
      if (this.uvZ.size() > 0)
      {
        Iterator localIterator = this.uvZ.values().iterator();
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
                i += ((abw)((Iterator)localObject).next()).CNG;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final chi dbq()
  {
    AppMethodBeat.i(66870);
    if (this.uvP != null)
    {
      localObject = this.uvP;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.uvH == null) {
      this.uvH = com.tencent.mm.plugin.product.a.a.dbi().dbk();
    }
    Object localObject = this.uvH;
    if ((((d)localObject).uwa != null) && (((d)localObject).uwa.size() > 0)) {}
    for (localObject = (String)((d)localObject).uwa.get(0); !bt.isNullOrNil((String)localObject); localObject = null)
    {
      this.uvP = new chi();
      this.uvP.saB = ((String)localObject);
      this.uvP.EcR = 1;
      localObject = this.uvP;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.uvO;
    if ((localObject != null) && (!bt.isNullOrNil(((df)localObject).mAQ)))
    {
      this.uvP = new chi();
      this.uvP.saB = ((df)localObject).mAQ;
      this.uvP.EcR = 1;
      localObject = this.uvP;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String dbr()
  {
    if (this.uvI.uwn != null) {
      return this.uvI.uwn.username;
    }
    return null;
  }
  
  public final String dbs()
  {
    AppMethodBeat.i(66871);
    if (!bt.isNullOrNil(this.uvI.dbE()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.akx(this.uvI.dbE());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String dbt()
  {
    AppMethodBeat.i(66872);
    if ((this.uvI.uwm != null) && (this.uvI.uwm.uwH != null))
    {
      str = this.uvI.uwm.uwH.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!bt.isNullOrNil(this.uvI.kqB))
    {
      str = this.uvI.kqB;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.uvL;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int dbu()
  {
    int j = this.uvI.uwk;
    int i = j;
    if (this.uvX != null)
    {
      i = j;
      if (j > this.uvX.uwk) {
        i = this.uvX.uwk;
      }
    }
    return i;
  }
  
  public final boolean dbv()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.uvI != null) && (this.mCount <= dbu()) && (this.uvI.uwm != null) && (this.uvI.uwm.uwF != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean dbw()
  {
    AppMethodBeat.i(66874);
    if (!dbv())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.uvU != null) && (this.uvU.size() == this.uvS)) {
      if (this.uvS > 0)
      {
        if ((this.uvX != null) && (this.mCount > 0) && (this.mCount <= dbu()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.uvS == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean dbx()
  {
    AppMethodBeat.i(66875);
    if (!dbw())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.uvO == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!dbl().dbH()) && (this.uvN == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<cmk> dby()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    cmk localcmk = new cmk();
    localcmk.mAK = this.mCount;
    localcmk.DwS = this.uvI.uwi;
    localcmk.DYG = this.uvI.kqB;
    localcmk.DYH = this.uvM;
    localLinkedList.add(localcmk);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final cty dbz()
  {
    AppMethodBeat.i(66877);
    cty localcty = new cty();
    localcty.CPg = this.uvK;
    localcty.upl = 1;
    localcty.ElG = new LinkedList();
    ccg localccg = new ccg();
    localccg.mAK = this.mCount;
    localccg.DwS = this.uvI.uwi;
    localccg.Name = this.uvI.uwm.name;
    if (this.uvX != null) {}
    Iterator localIterator;
    Object localObject;
    for (localccg.DYF = this.uvX.uwb;; localccg.DYF = this.uvI.uwm.uwx)
    {
      localccg.DYG = this.uvI.kqB;
      localccg.DYH = this.uvM;
      localccg.mBH = this.uvI.uwj;
      localccg.DYD = this.uvS;
      localccg.DYE = new LinkedList();
      localIterator = this.uvU.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.uvU.get(localObject);
        bkd localbkd = new bkd();
        localbkd.sdv = ((String)localObject);
        localbkd.vJI = str;
        localccg.DYE.add(localbkd);
      }
    }
    localccg.DYL = new LinkedList();
    localccg.DYK = 0;
    if ((this.uvZ != null) && (this.uvZ.size() > 0))
    {
      localIterator = this.uvZ.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localccg.DYL.addAll((Collection)localObject);
        int i = localccg.DYK;
        localccg.DYK = (((LinkedList)localObject).size() + i);
      }
    }
    localcty.ElG.add(localccg);
    localcty.ElI = new LinkedList();
    localcty.ElJ = 1;
    this.uvP = dbq();
    if (this.uvP != null) {
      localcty.ElI.add(this.uvP);
    }
    for (;;)
    {
      localcty.DuN = this.uvO;
      localcty.ElH = this.uvN;
      AppMethodBeat.o(66877);
      return localcty;
      this.uvP = new chi();
      this.uvP.EcR = 0;
      localcty.ElI.add(this.uvP);
    }
  }
  
  public final String getAppId()
  {
    if (this.uvI.uwn != null) {
      return this.uvI.uwn.dlB;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */