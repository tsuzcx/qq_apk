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
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public ahu xbA;
  public di xbB;
  public csg xbC;
  public String xbD;
  public String xbE;
  public int xbF;
  public Map<String, e> xbG;
  public Map<String, String> xbH;
  public LinkedList<ahu> xbI;
  public LinkedList<az> xbJ;
  public e xbK;
  private com.tencent.mm.plugin.product.ui.e xbL;
  public Map<String, LinkedList<aff>> xbM;
  private d xbu;
  public m xbv;
  public List<n> xbw;
  public String xbx;
  public String xby;
  public String xbz;
  
  public c()
  {
    AppMethodBeat.i(66858);
    this.xbu = null;
    this.mCount = 1;
    this.xbH = new HashMap();
    this.xbM = null;
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
      e locale = (e)this.xbG.get(localStringBuilder.toString());
      if (locale != null)
      {
        if (locale.xbO < paraml.xcA) {
          locale.xbO = paraml.xcA;
        }
        if (locale.xbP > paraml.xcA) {
          locale.xbP = paraml.xcA;
        }
        locale.xbX += paraml.xbX;
      }
      for (;;)
      {
        i += 1;
        break;
        locale = new e();
        locale.xbO = paraml.xcA;
        locale.xbP = paraml.xcA;
        locale.xbX = paraml.xbX;
        locale.xcB = paraml.xcB;
        locale.url = paraml.url;
        this.xbG.put(localStringBuilder.toString(), locale);
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
  
  private void aK(LinkedList<l> paramLinkedList)
  {
    AppMethodBeat.i(66880);
    this.xbG = new HashMap();
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
      a(locall.xcz.split(";"), locall);
      i += 1;
    }
    dDb();
    AppMethodBeat.o(66880);
  }
  
  private int avP(String paramString)
  {
    AppMethodBeat.i(66869);
    int k = 0;
    int i = 0;
    int j = k;
    if (this.xbM != null)
    {
      j = k;
      if (this.xbM.size() > 0)
      {
        paramString = (LinkedList)this.xbM.get(paramString);
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
              i = ((aff)paramString.next()).Gfg + i;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66869);
    return j;
  }
  
  public final void Ng(int paramInt)
  {
    AppMethodBeat.i(66866);
    if (this.xbI == null)
    {
      AppMethodBeat.o(66866);
      return;
    }
    if ((paramInt < this.xbI.size()) && (paramInt >= 0)) {
      this.xbA = ((ahu)this.xbI.get(paramInt));
    }
    AppMethodBeat.o(66866);
  }
  
  public final String a(m paramm)
  {
    AppMethodBeat.i(66884);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.xbW).append("</type>");
    localStringBuilder.append("<id>").append(paramm.xbV).append("</id>");
    localStringBuilder.append("<version>").append(paramm.xbZ.version).append("</version>");
    localStringBuilder.append("<name>").append(bu.aSz(paramm.xbZ.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.xbZ.xck).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.xbZ.xcl).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.xbZ.xcj).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bu.aSz(this.xbv.dJL)).append("</sourceUrl>");
    if (paramm.xbZ.xcm != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.xbZ.xcm.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.xbZ.xcm.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bu.aSz(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bu.aSz(dCU())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bu.aSz(paramm.dDf())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.xbv.xca != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.xca.dwb).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.xca.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.xca.username).append("</usrName>");
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
    this.xbv = paramm;
    this.xbw = paramList;
    if (bu.isNullOrNil(this.xbv.dJL)) {
      this.xbv.dJL = this.xby;
    }
    aK(this.xbv.xcb);
    if ((this.xbv.xbZ != null) && (this.xbv.xbZ.xcs != null)) {
      this.xbF = this.xbv.xbZ.xcs.size();
    }
    if ((this.xbv.xbZ != null) && (this.xbv.xbZ.xcm != null) && (this.xbv.xbZ.xcm.size() > 0)) {
      this.xbD = ((String)this.xbv.xbZ.xcm.get(0));
    }
    if (!bu.isNullOrNil(this.xbv.dDf()))
    {
      u.a(new com.tencent.mm.plugin.product.ui.c(this.xbv.dDf()));
      ae.d("MicroMsg.MallProductManager", "product img path : " + dCT());
    }
    if ((this.xbv.xcc != null) && (this.xbv.xcc.xcw != null)) {}
    for (int i = this.xbv.xcc.xcw.dEu;; i = 0)
    {
      if (this.xbv.xca != null) {
        j = this.xbv.xca.dEu;
      }
      this.xbL = new com.tencent.mm.plugin.product.ui.e(i, j);
      AppMethodBeat.o(66860);
      return;
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> aA(Activity paramActivity)
  {
    AppMethodBeat.i(66865);
    LinkedList localLinkedList = new LinkedList();
    if (this.xbJ != null)
    {
      Iterator localIterator = this.xbJ.iterator();
      while (localIterator.hasNext())
      {
        az localaz = (az)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.Name = localaz.Name;
        locala.xcg = localaz.xcg;
        locala.hFS = localaz.hFS;
        locala.nJA = localaz.nJA;
        locala.IconUrl = localaz.IconUrl;
        if (locala.nJA == 1)
        {
          int i = avP(locala.hFS);
          if (i > 0) {
            locala.xcg = paramActivity.getString(2131761140, new Object[] { b.c(i, this.xbv.xbZ.wSq) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    AppMethodBeat.o(66865);
    return localLinkedList;
  }
  
  public final void aG(Intent paramIntent)
  {
    AppMethodBeat.i(66864);
    di localdi = new di();
    localdi.nIJ = bu.bI(paramIntent.getStringExtra("userName"), "");
    localdi.FNZ = bu.bI(paramIntent.getStringExtra("telNumber"), "");
    localdi.FOa = bu.bI(paramIntent.getStringExtra("addressPostalCode"), "");
    localdi.jfW = bu.bI(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localdi.jfX = bu.bI(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localdi.jge = bu.bI(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localdi.urL = bu.bI(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bu.isNullOrNil(localdi.nIJ)) && (!bu.isNullOrNil(localdi.FNZ))) {
      this.xbB = localdi;
    }
    AppMethodBeat.o(66864);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(66859);
    this.xbv = null;
    if (this.xbw != null)
    {
      this.xbw.clear();
      this.xbw = null;
    }
    this.xbx = null;
    this.xby = null;
    this.mCount = 1;
    this.xbz = null;
    this.xbA = null;
    this.xbC = null;
    this.xbD = null;
    this.xbF = 0;
    this.xbK = null;
    if (this.xbG != null)
    {
      this.xbG.clear();
      this.xbG = null;
    }
    if (this.xbH != null) {
      this.xbH.clear();
    }
    if (this.xbI != null)
    {
      this.xbI.clear();
      this.xbI = null;
    }
    if (this.xbM != null)
    {
      this.xbM.clear();
      this.xbM = null;
    }
    AppMethodBeat.o(66859);
  }
  
  public final com.tencent.mm.plugin.product.ui.e dCM()
  {
    AppMethodBeat.i(66861);
    if (this.xbL == null) {
      this.xbL = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    com.tencent.mm.plugin.product.ui.e locale = this.xbL;
    AppMethodBeat.o(66861);
    return locale;
  }
  
  public final String dCN()
  {
    AppMethodBeat.i(66862);
    if ((this.xbK != null) && (!bu.isNullOrNil(this.xbK.url)))
    {
      str = this.xbK.url;
      AppMethodBeat.o(66862);
      return str;
    }
    String str = this.xbD;
    AppMethodBeat.o(66862);
    return str;
  }
  
  public final String dCO()
  {
    AppMethodBeat.i(66863);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = this.xbv.xbZ.xcs.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label133;
      }
      Object localObject2 = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.xbH.get(((com.tencent.mm.plugin.product.c.m)localObject2).xcC);
      if (str != null)
      {
        localObject2 = ((com.tencent.mm.plugin.product.c.m)localObject2).xcE.iterator();
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
  
  public final int dCP()
  {
    AppMethodBeat.i(66867);
    int j = 0;
    int i = j;
    if (!dCM().dDi())
    {
      i = j;
      if (this.xbA != null) {
        i = this.xbA.Gfg + 0;
      }
    }
    if (this.xbK != null) {
      i += this.xbK.xbO * this.mCount;
    }
    for (;;)
    {
      j = dCQ();
      AppMethodBeat.o(66867);
      return i - j;
      i += this.xbv.xbZ.xck * this.mCount;
    }
  }
  
  public final int dCQ()
  {
    AppMethodBeat.i(66868);
    int j = 0;
    int i = j;
    if (this.xbM != null)
    {
      i = j;
      if (this.xbM.size() > 0)
      {
        Iterator localIterator = this.xbM.values().iterator();
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
                i += ((aff)((Iterator)localObject).next()).Gfg;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(66868);
    return i;
  }
  
  public final csg dCR()
  {
    AppMethodBeat.i(66870);
    if (this.xbC != null)
    {
      localObject = this.xbC;
      AppMethodBeat.o(66870);
      return localObject;
    }
    if (this.xbu == null) {
      this.xbu = com.tencent.mm.plugin.product.a.a.dCJ().dCL();
    }
    Object localObject = this.xbu;
    if ((((d)localObject).xbN != null) && (((d)localObject).xbN.size() > 0)) {}
    for (localObject = (String)((d)localObject).xbN.get(0); !bu.isNullOrNil((String)localObject); localObject = null)
    {
      this.xbC = new csg();
      this.xbC.urL = ((String)localObject);
      this.xbC.HDu = 1;
      localObject = this.xbC;
      AppMethodBeat.o(66870);
      return localObject;
    }
    localObject = this.xbB;
    if ((localObject != null) && (!bu.isNullOrNil(((di)localObject).nIJ)))
    {
      this.xbC = new csg();
      this.xbC.urL = ((di)localObject).nIJ;
      this.xbC.HDu = 1;
      localObject = this.xbC;
      AppMethodBeat.o(66870);
      return localObject;
    }
    AppMethodBeat.o(66870);
    return null;
  }
  
  public final String dCS()
  {
    if (this.xbv.xca != null) {
      return this.xbv.xca.username;
    }
    return null;
  }
  
  public final String dCT()
  {
    AppMethodBeat.i(66871);
    if (!bu.isNullOrNil(this.xbv.dDf()))
    {
      String str = com.tencent.mm.plugin.product.ui.c.avR(this.xbv.dDf());
      AppMethodBeat.o(66871);
      return str;
    }
    AppMethodBeat.o(66871);
    return null;
  }
  
  public final String dCU()
  {
    AppMethodBeat.i(66872);
    if ((this.xbv.xbZ != null) && (this.xbv.xbZ.xcu != null))
    {
      str = this.xbv.xbZ.xcu.url;
      AppMethodBeat.o(66872);
      return str;
    }
    if (!bu.isNullOrNil(this.xbv.dJL))
    {
      str = this.xbv.dJL;
      AppMethodBeat.o(66872);
      return str;
    }
    String str = this.xby;
    AppMethodBeat.o(66872);
    return str;
  }
  
  public final int dCV()
  {
    int j = this.xbv.xbX;
    int i = j;
    if (this.xbK != null)
    {
      i = j;
      if (j > this.xbK.xbX) {
        i = this.xbK.xbX;
      }
    }
    return i;
  }
  
  public final boolean dCW()
  {
    AppMethodBeat.i(66873);
    if ((this.mCount > 0) && (this.xbv != null) && (this.mCount <= dCV()) && (this.xbv.xbZ != null) && (this.xbv.xbZ.xcs != null))
    {
      AppMethodBeat.o(66873);
      return true;
    }
    AppMethodBeat.o(66873);
    return false;
  }
  
  public final boolean dCX()
  {
    AppMethodBeat.i(66874);
    if (!dCW())
    {
      AppMethodBeat.o(66874);
      return false;
    }
    if ((this.xbH != null) && (this.xbH.size() == this.xbF)) {
      if (this.xbF > 0)
      {
        if ((this.xbK != null) && (this.mCount > 0) && (this.mCount <= dCV()))
        {
          AppMethodBeat.o(66874);
          return true;
        }
      }
      else if (this.xbF == 0)
      {
        AppMethodBeat.o(66874);
        return true;
      }
    }
    AppMethodBeat.o(66874);
    return false;
  }
  
  public final boolean dCY()
  {
    AppMethodBeat.i(66875);
    if (!dCX())
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if (this.xbB == null)
    {
      AppMethodBeat.o(66875);
      return false;
    }
    if ((!dCM().dDi()) && (this.xbA == null))
    {
      AppMethodBeat.o(66875);
      return false;
    }
    AppMethodBeat.o(66875);
    return true;
  }
  
  public final LinkedList<cxs> dCZ()
  {
    AppMethodBeat.i(66876);
    LinkedList localLinkedList = new LinkedList();
    cxs localcxs = new cxs();
    localcxs.nID = this.mCount;
    localcxs.GVf = this.xbv.xbV;
    localcxs.Hzf = this.xbv.dJL;
    localcxs.Hzg = this.xbz;
    localLinkedList.add(localcxs);
    AppMethodBeat.o(66876);
    return localLinkedList;
  }
  
  public final dfr dDa()
  {
    AppMethodBeat.i(66877);
    dfr localdfr = new dfr();
    localdfr.Ghx = this.xbx;
    localdfr.wTm = 1;
    localdfr.HMQ = new LinkedList();
    cnb localcnb = new cnb();
    localcnb.nID = this.mCount;
    localcnb.GVf = this.xbv.xbV;
    localcnb.Name = this.xbv.xbZ.name;
    if (this.xbK != null) {}
    Iterator localIterator;
    Object localObject;
    for (localcnb.Hze = this.xbK.xbO;; localcnb.Hze = this.xbv.xbZ.xck)
    {
      localcnb.Hzf = this.xbv.dJL;
      localcnb.Hzg = this.xbz;
      localcnb.nJA = this.xbv.xbW;
      localcnb.Hzc = this.xbF;
      localcnb.Hzd = new LinkedList();
      localIterator = this.xbH.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.xbH.get(localObject);
        btd localbtd = new btd();
        localbtd.uuW = ((String)localObject);
        localbtd.yxn = str;
        localcnb.Hzd.add(localbtd);
      }
    }
    localcnb.Hzk = new LinkedList();
    localcnb.Hzj = 0;
    if ((this.xbM != null) && (this.xbM.size() > 0))
    {
      localIterator = this.xbM.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localcnb.Hzk.addAll((Collection)localObject);
        int i = localcnb.Hzj;
        localcnb.Hzj = (((LinkedList)localObject).size() + i);
      }
    }
    localdfr.HMQ.add(localcnb);
    localdfr.HMS = new LinkedList();
    localdfr.HMT = 1;
    this.xbC = dCR();
    if (this.xbC != null) {
      localdfr.HMS.add(this.xbC);
    }
    for (;;)
    {
      localdfr.GSN = this.xbB;
      localdfr.HMR = this.xbA;
      AppMethodBeat.o(66877);
      return localdfr;
      this.xbC = new csg();
      this.xbC.HDu = 0;
      localdfr.HMS.add(this.xbC);
    }
  }
  
  public final void dDb()
  {
    AppMethodBeat.i(66878);
    if (this.xbH == null)
    {
      AppMethodBeat.o(66878);
      return;
    }
    Iterator localIterator1 = this.xbv.xbZ.xcs.iterator();
    if (localIterator1.hasNext())
    {
      com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
      Iterator localIterator2 = localm.xcE.iterator();
      label62:
      h localh;
      Object localObject;
      String str2;
      boolean bool;
      if (localIterator2.hasNext())
      {
        localh = (h)localIterator2.next();
        localObject = localm.xcC;
        str2 = localh.id;
        if ((this.xbH != null) && (this.xbG != null)) {
          break label176;
        }
        bool = false;
      }
      for (;;)
      {
        localh.iH = bool;
        ae.d("MicroMsg.MallProductManager", "(" + localm.xcC + " , " + localh.id + ") hasStock--> " + localh.iH);
        break label62;
        break;
        label176:
        String str1;
        if (this.xbH.containsKey(localObject))
        {
          str1 = (String)this.xbH.get(localObject);
          this.xbH.put(localObject, str2);
          str2 = aF(this.xbH);
          this.xbH.put(localObject, str1);
          localObject = (e)this.xbG.get(str2);
          if (localObject != null)
          {
            if (((e)localObject).xbX > 0) {
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
          this.xbH.put(localObject, str2);
          str1 = aF(this.xbH);
          this.xbH.remove(localObject);
          localObject = (e)this.xbG.get(str1);
          if (localObject != null)
          {
            if (((e)localObject).xbX > 0) {
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
  
  public final String dDc()
  {
    AppMethodBeat.i(66882);
    Object localObject = new k.b();
    ((k.b)localObject).title = this.xbv.xbZ.name;
    ((k.b)localObject).description = dDd();
    ((k.b)localObject).type = 13;
    ((k.b)localObject).url = dCU();
    ((k.b)localObject).thumburl = this.xbv.dDf();
    ((k.b)localObject).hDh = this.xbv.xbW;
    ((k.b)localObject).hDi = a(this.xbv);
    localObject = k.b.a((k.b)localObject, null, null);
    AppMethodBeat.o(66882);
    return localObject;
  }
  
  public final String dDd()
  {
    AppMethodBeat.i(66883);
    String str = b.c(this.xbv.xbZ.xcl, this.xbv.xbZ.wSq);
    AppMethodBeat.o(66883);
    return str;
  }
  
  public final String getAppId()
  {
    if (this.xbv.xca != null) {
      return this.xbv.xca.dwb;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */