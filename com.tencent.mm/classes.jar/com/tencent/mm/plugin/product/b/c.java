package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.asu;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public int mCount = 1;
  private d mRO = null;
  public m mRP;
  public List<n> mRQ;
  public String mRR;
  public String mRS;
  public String mRT;
  public wi mRU;
  public cm mRV;
  public bjm mRW;
  public String mRX;
  public String mRY;
  public int mRZ;
  public Map<String, e> mSa;
  public Map<String, String> mSb = new HashMap();
  public LinkedList<wi> mSc;
  public LinkedList<au> mSd;
  public e mSe;
  private com.tencent.mm.plugin.product.ui.e mSf;
  public Map<String, LinkedList<tz>> mSg = null;
  
  public static String G(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
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
    return paramMap.toString();
  }
  
  private int KP(String paramString)
  {
    int k = 0;
    int i = 0;
    int j = k;
    if (this.mSg != null)
    {
      j = k;
      if (this.mSg.size() > 0)
      {
        paramString = (LinkedList)this.mSg.get(paramString);
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
              i = ((tz)paramString.next()).sFS + i;
            }
          }
        }
      }
    }
    return j;
  }
  
  private void a(String[] paramArrayOfString, l paraml)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return;
    }
    int k = paramArrayOfString.length;
    int i = 1;
    label16:
    StringBuilder localStringBuilder;
    e locale;
    if (i <= -1 >>> 32 - k)
    {
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < k)
      {
        if (i << 31 - j >> 31 == -1) {
          localStringBuilder.append(paramArrayOfString[j]).append(";");
        }
        j += 1;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf(";"));
      locale = (e)this.mSa.get(localStringBuilder.toString());
      if (locale == null) {
        break label185;
      }
      if (locale.mSi < paraml.mSX) {
        locale.mSi = paraml.mSX;
      }
      if (locale.mSj > paraml.mSX) {
        locale.mSj = paraml.mSX;
      }
      locale.mSs += paraml.mSs;
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label185:
      locale = new e();
      locale.mSi = paraml.mSX;
      locale.mSj = paraml.mSX;
      locale.mSs = paraml.mSs;
      locale.mSY = paraml.mSY;
      locale.url = paraml.url;
      this.mSa.put(localStringBuilder.toString(), locale);
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.product.c.a> I(Activity paramActivity)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.mSd != null)
    {
      Iterator localIterator = this.mSd.iterator();
      while (localIterator.hasNext())
      {
        au localau = (au)localIterator.next();
        com.tencent.mm.plugin.product.c.a locala = new com.tencent.mm.plugin.product.c.a();
        locala.kRZ = localau.kRZ;
        locala.mSC = localau.mSC;
        locala.kVs = localau.kVs;
        locala.hQR = localau.hQR;
        locala.kSy = localau.kSy;
        if (locala.hQR == 1)
        {
          int i = KP(locala.kVs);
          if (i > 0) {
            locala.mSC = paramActivity.getString(a.i.mall_product_submit_preferential_summray, new Object[] { b.c(i, this.mRP.mSu.mOZ) });
          }
        }
        localLinkedList.add(locala);
      }
    }
    return localLinkedList;
  }
  
  public final void R(Intent paramIntent)
  {
    cm localcm = new cm();
    localcm.hPY = bk.aM(paramIntent.getStringExtra("userName"), "");
    localcm.svW = bk.aM(paramIntent.getStringExtra("telNumber"), "");
    localcm.svX = bk.aM(paramIntent.getStringExtra("addressPostalCode"), "");
    localcm.ffi = bk.aM(paramIntent.getStringExtra("proviceFirstStageName"), "");
    localcm.ffj = bk.aM(paramIntent.getStringExtra("addressCitySecondStageName"), "");
    localcm.ffq = bk.aM(paramIntent.getStringExtra("addressCountiesThirdStageName"), "");
    localcm.kSY = bk.aM(paramIntent.getStringExtra("addressDetailInfo"), "");
    if ((!bk.bl(localcm.hPY)) && (!bk.bl(localcm.svW))) {
      this.mRV = localcm;
    }
  }
  
  public final String a(m paramm)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<mallProductInfo>");
    localStringBuilder.append("<type>").append(paramm.mSr).append("</type>");
    localStringBuilder.append("<id>").append(paramm.mSq).append("</id>");
    localStringBuilder.append("<version>").append(paramm.mSu.version).append("</version>");
    localStringBuilder.append("<name>").append(bk.ZP(paramm.mSu.name)).append("</name>");
    localStringBuilder.append("<highPrice>").append(paramm.mSu.mSG).append("</highPrice>");
    localStringBuilder.append("<lowPrice>").append(paramm.mSu.mSH).append("</lowPrice>");
    localStringBuilder.append("<originPrice>").append(paramm.mSu.mSF).append("</originPrice>");
    localStringBuilder.append("<sourceUrl>").append(bk.ZP(this.mRP.mSy)).append("</sourceUrl>");
    if (paramm.mSu.mSI != null)
    {
      localStringBuilder.append("<imgCount>").append(paramm.mSu.mSI.size()).append("</imgCount>");
      localStringBuilder.append("<imgList>");
      Iterator localIterator = paramm.mSu.mSI.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("<imgUrl>").append(bk.ZP(str)).append("</imgUrl>");
      }
      localStringBuilder.append("</imgList>");
    }
    localStringBuilder.append("<shareInfo>");
    localStringBuilder.append("<shareUrl>").append(bk.ZP(brY())).append("</shareUrl>");
    localStringBuilder.append("<shareThumbUrl>").append(bk.ZP(paramm.bsj())).append("</shareThumbUrl>");
    localStringBuilder.append("</shareInfo>");
    if (this.mRP.mSv != null)
    {
      localStringBuilder.append("<sellerInfo>");
      localStringBuilder.append("<appID>").append(paramm.mSv.bOL).append("</appID>");
      localStringBuilder.append("<appName>").append(paramm.mSv.name).append("</appName>");
      localStringBuilder.append("<usrName>").append(paramm.mSv.username).append("</usrName>");
      localStringBuilder.append("</sellerInfo>");
    }
    localStringBuilder.append("</mallProductInfo>");
    return localStringBuilder.toString();
  }
  
  public final void a(m paramm, List<n> paramList)
  {
    int j = 0;
    clear();
    this.mRP = paramm;
    this.mRQ = paramList;
    if (bk.bl(this.mRP.mSy)) {
      this.mRP.mSy = this.mRS;
    }
    paramm = this.mRP.mSw;
    this.mSa = new HashMap();
    if ((paramm == null) || (paramm.size() <= 0))
    {
      if ((this.mRP.mSu != null) && (this.mRP.mSu.mSO != null)) {
        this.mRZ = this.mRP.mSu.mSO.size();
      }
      if ((this.mRP.mSu != null) && (this.mRP.mSu.mSI != null) && (this.mRP.mSu.mSI.size() > 0)) {
        this.mRX = ((String)this.mRP.mSu.mSI.get(0));
      }
      if (!bk.bl(this.mRP.bsj()))
      {
        x.a(new com.tencent.mm.plugin.product.ui.c(this.mRP.bsj()));
        y.d("MicroMsg.MallProductManager", "product img path : " + brX());
      }
      if ((this.mRP.mSx == null) || (this.mRP.mSx.mSS == null)) {
        break label353;
      }
    }
    label353:
    for (int i = this.mRP.mSx.mSS.bcw;; i = 0)
    {
      if (this.mRP.mSv != null) {
        j = this.mRP.mSv.bcw;
      }
      this.mSf = new com.tencent.mm.plugin.product.ui.e(i, j);
      return;
      int k = paramm.size();
      i = 0;
      while (i < k)
      {
        paramList = (l)paramm.get(i);
        a(paramList.mSW.split(";"), paramList);
        i += 1;
      }
      bsf();
      break;
    }
  }
  
  public final com.tencent.mm.plugin.product.ui.e brQ()
  {
    if (this.mSf == null) {
      this.mSf = new com.tencent.mm.plugin.product.ui.e(0, 0);
    }
    return this.mSf;
  }
  
  public final String brR()
  {
    if ((this.mSe != null) && (!bk.bl(this.mSe.url))) {
      return this.mSe.url;
    }
    return this.mRX;
  }
  
  public final String brS()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mRP.mSu.mSO.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label127;
      }
      Object localObject = (com.tencent.mm.plugin.product.c.m)localIterator.next();
      String str = (String)this.mSb.get(((com.tencent.mm.plugin.product.c.m)localObject).mSZ);
      if (str != null)
      {
        localObject = ((com.tencent.mm.plugin.product.c.m)localObject).mTb.iterator();
        if (((Iterator)localObject).hasNext())
        {
          h localh = (h)((Iterator)localObject).next();
          if (!str.equals(localh.id)) {
            break;
          }
          localStringBuilder.append(localh.name).append(" ");
        }
      }
    }
    label127:
    return localStringBuilder.toString();
  }
  
  public final int brT()
  {
    int j = 0;
    int i = j;
    if (!brQ().bsm())
    {
      i = j;
      if (this.mRU != null) {
        i = this.mRU.sFS + 0;
      }
    }
    if (this.mSe != null) {
      i += this.mSe.mSi * this.mCount;
    }
    for (;;)
    {
      return i - brU();
      i += this.mRP.mSu.mSG * this.mCount;
    }
  }
  
  public final int brU()
  {
    int j = 0;
    int i = j;
    if (this.mSg != null)
    {
      i = j;
      if (this.mSg.size() > 0)
      {
        Iterator localIterator = this.mSg.values().iterator();
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
                i += ((tz)((Iterator)localObject).next()).sFS;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  public final bjm brV()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mRW != null) {
      localObject1 = this.mRW;
    }
    cm localcm;
    do
    {
      do
      {
        return localObject1;
        if (this.mRO == null) {
          this.mRO = com.tencent.mm.plugin.product.a.a.brN().brP();
        }
        localObject1 = this.mRO;
        if ((((d)localObject1).mSh != null) && (((d)localObject1).mSh.size() > 0)) {}
        for (localObject1 = (String)((d)localObject1).mSh.get(0); !bk.bl((String)localObject1); localObject1 = null)
        {
          this.mRW = new bjm();
          this.mRW.kSY = ((String)localObject1);
          this.mRW.tDr = 1;
          return this.mRW;
        }
        localcm = this.mRV;
        localObject1 = localObject2;
      } while (localcm == null);
      localObject1 = localObject2;
    } while (bk.bl(localcm.hPY));
    this.mRW = new bjm();
    this.mRW.kSY = localcm.hPY;
    this.mRW.tDr = 1;
    return this.mRW;
  }
  
  public final String brW()
  {
    if (this.mRP.mSv != null) {
      return this.mRP.mSv.username;
    }
    return null;
  }
  
  public final String brX()
  {
    if (!bk.bl(this.mRP.bsj())) {
      return com.tencent.mm.plugin.product.ui.c.KR(this.mRP.bsj());
    }
    return null;
  }
  
  public final String brY()
  {
    if ((this.mRP.mSu != null) && (this.mRP.mSu.mSQ != null)) {
      return this.mRP.mSu.mSQ.url;
    }
    if (!bk.bl(this.mRP.mSy)) {
      return this.mRP.mSy;
    }
    return this.mRS;
  }
  
  public final int brZ()
  {
    int j = this.mRP.mSs;
    int i = j;
    if (this.mSe != null)
    {
      i = j;
      if (j > this.mSe.mSs) {
        i = this.mSe.mSs;
      }
    }
    return i;
  }
  
  public final boolean bsa()
  {
    return (this.mCount > 0) && (this.mRP != null) && (this.mCount <= brZ()) && (this.mRP.mSu != null) && (this.mRP.mSu.mSO != null);
  }
  
  public final boolean bsb()
  {
    if (!bsa()) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.mSb == null) || (this.mSb.size() != this.mRZ));
        if (this.mRZ <= 0) {
          break;
        }
      } while ((this.mSe == null) || (this.mCount <= 0) || (this.mCount > brZ()));
      return true;
    } while (this.mRZ != 0);
    return true;
  }
  
  public final boolean bsc()
  {
    if (!bsb()) {}
    while ((this.mRV == null) || ((!brQ().bsm()) && (this.mRU == null))) {
      return false;
    }
    return true;
  }
  
  public final LinkedList<bmq> bsd()
  {
    LinkedList localLinkedList = new LinkedList();
    bmq localbmq = new bmq();
    localbmq.hPS = this.mCount;
    localbmq.tfK = this.mRP.mSq;
    localbmq.tAs = this.mRP.mSy;
    localbmq.tAt = this.mRT;
    localLinkedList.add(localbmq);
    return localLinkedList;
  }
  
  public final bsn bse()
  {
    bsn localbsn = new bsn();
    localbsn.sHh = this.mRR;
    localbsn.mPW = 1;
    localbsn.tJa = new LinkedList();
    bfq localbfq = new bfq();
    localbfq.hPS = this.mCount;
    localbfq.tfK = this.mRP.mSq;
    localbfq.kRZ = this.mRP.mSu.name;
    if (this.mSe != null) {}
    Iterator localIterator;
    Object localObject;
    for (localbfq.tAr = this.mSe.mSi;; localbfq.tAr = this.mRP.mSu.mSG)
    {
      localbfq.tAs = this.mRP.mSy;
      localbfq.tAt = this.mRT;
      localbfq.hQR = this.mRP.mSr;
      localbfq.tAp = this.mRZ;
      localbfq.tAq = new LinkedList();
      localIterator = this.mSb.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        String str = (String)this.mSb.get(localObject);
        asu localasu = new asu();
        localasu.sCH = ((String)localObject);
        localasu.nFs = str;
        localbfq.tAq.add(localasu);
      }
    }
    localbfq.tAx = new LinkedList();
    localbfq.tAw = 0;
    if ((this.mSg != null) && (this.mSg.size() > 0))
    {
      localIterator = this.mSg.values().iterator();
      while (localIterator.hasNext())
      {
        localObject = (LinkedList)localIterator.next();
        localbfq.tAx.addAll((Collection)localObject);
        int i = localbfq.tAw;
        localbfq.tAw = (((LinkedList)localObject).size() + i);
      }
    }
    localbsn.tJa.add(localbfq);
    localbsn.tJc = new LinkedList();
    localbsn.tJd = 1;
    this.mRW = brV();
    if (this.mRW != null) {
      localbsn.tJc.add(this.mRW);
    }
    for (;;)
    {
      localbsn.tes = this.mRV;
      localbsn.tJb = this.mRU;
      return localbsn;
      this.mRW = new bjm();
      this.mRW.tDr = 0;
      localbsn.tJc.add(this.mRW);
    }
  }
  
  public final void bsf()
  {
    if (this.mSb == null) {}
    Iterator localIterator1;
    do
    {
      return;
      localIterator1 = this.mRP.mSu.mSO.iterator();
    } while (!localIterator1.hasNext());
    com.tencent.mm.plugin.product.c.m localm = (com.tencent.mm.plugin.product.c.m)localIterator1.next();
    Iterator localIterator2 = localm.mTb.iterator();
    label50:
    h localh;
    Object localObject;
    String str2;
    boolean bool;
    if (localIterator2.hasNext())
    {
      localh = (h)localIterator2.next();
      localObject = localm.mSZ;
      str2 = localh.id;
      if ((this.mSb != null) && (this.mSa != null)) {
        break label164;
      }
      bool = false;
    }
    for (;;)
    {
      localh.mSU = bool;
      y.d("MicroMsg.MallProductManager", "(" + localm.mSZ + " , " + localh.id + ") hasStock--> " + localh.mSU);
      break label50;
      break;
      label164:
      String str1;
      if (this.mSb.containsKey(localObject))
      {
        str1 = (String)this.mSb.get(localObject);
        this.mSb.put(localObject, str2);
        str2 = G(this.mSb);
        this.mSb.put(localObject, str1);
        localObject = (e)this.mSa.get(str2);
        if (localObject != null)
        {
          if (((e)localObject).mSs > 0) {
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
        this.mSb.put(localObject, str2);
        str1 = G(this.mSb);
        this.mSb.remove(localObject);
        localObject = (e)this.mSa.get(str1);
        if (localObject != null)
        {
          if (((e)localObject).mSs > 0) {
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
  
  public final String bsg()
  {
    g.a locala = new g.a();
    locala.title = this.mRP.mSu.name;
    locala.description = bsh();
    locala.type = 13;
    locala.url = brY();
    locala.thumburl = this.mRP.bsj();
    locala.dRe = this.mRP.mSr;
    locala.dRf = a(this.mRP);
    return g.a.a(locala, null, null);
  }
  
  public final String bsh()
  {
    return b.c(this.mRP.mSu.mSH, this.mRP.mSu.mOZ);
  }
  
  public final void clear()
  {
    this.mRP = null;
    if (this.mRQ != null)
    {
      this.mRQ.clear();
      this.mRQ = null;
    }
    this.mRR = null;
    this.mRS = null;
    this.mCount = 1;
    this.mRT = null;
    this.mRU = null;
    this.mRW = null;
    this.mRX = null;
    this.mRZ = 0;
    this.mSe = null;
    if (this.mSa != null)
    {
      this.mSa.clear();
      this.mSa = null;
    }
    if (this.mSb != null) {
      this.mSb.clear();
    }
    if (this.mSc != null)
    {
      this.mSc.clear();
      this.mSc = null;
    }
    if (this.mSg != null)
    {
      this.mSg.clear();
      this.mSg = null;
    }
  }
  
  public final String getAppId()
  {
    if (this.mRP.mSv != null) {
      return this.mRP.mSv.bOL;
    }
    return null;
  }
  
  public final void vM(int paramInt)
  {
    if (this.mSc == null) {}
    while ((paramInt >= this.mSc.size()) || (paramInt < 0)) {
      return;
    }
    this.mRU = ((wi)this.mSc.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */