package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.bv.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
{
  public f qzX = null;
  Map<String, q> qzY = null;
  Map<String, h> qzZ = null;
  
  public a(f paramf)
  {
    Assert.assertNotNull(paramf);
    this.qzX = paramf;
    xK();
  }
  
  public static String[] QG(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return paramString.split("-");
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    if (paramBankcard == null) {
      y.w("MicroMsg.FavorLogicHelper", "curBankcard null");
    }
    for (;;)
    {
      return true;
      if ((paramFavorPayInfo != null) && (!bk.bl(paramFavorPayInfo.qvC)))
      {
        if (paramFavorPayInfo.qvD != 0) {}
        for (i = 1; (i != 0) && (!bk.bl(paramFavorPayInfo.qvE)) && (paramFavorPayInfo.qvH != null) && (paramFavorPayInfo.qvH.contains(paramBankcard.field_bindSerial)); i = 0) {
          return false;
        }
      }
      if (paramFavorPayInfo.qvD != 0) {}
      for (int i = 1; (i == 0) || (((bk.bl(paramFavorPayInfo.qvE)) || (paramBankcard.field_bankcardType == null) || (paramBankcard.field_bankcardType.equals(paramFavorPayInfo.qvE))) && ((!bk.bl(paramFavorPayInfo.qvE)) || (!paramBankcard.field_bankcardType.equals("CFT")))); i = 0) {
        return false;
      }
    }
  }
  
  private static String cW(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append((String)paramList.get(i));
      if (i < paramList.size() - 1) {
        localStringBuilder.append("-");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void xK()
  {
    int j = 0;
    this.qzY = new HashMap();
    LinkedList localLinkedList = this.qzX.qkX;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (q)localLinkedList.get(i);
        this.qzY.put(((q)localObject).qkQ, localObject);
        i += 1;
      }
    }
    y.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.qzZ = new HashMap();
    if ((this.qzX.qkY != null) && (this.qzX.qkY.qli != null))
    {
      localLinkedList = this.qzX.qkY.qli;
      i = j;
    }
    while (i < localLinkedList.size())
    {
      localObject = (h)localLinkedList.get(i);
      this.qzZ.put(((h)localObject).qlk, localObject);
      i += 1;
      continue;
      y.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    }
  }
  
  public final Map<String, a.a> QD(String paramString)
  {
    return bj(paramString, false);
  }
  
  public final List<q> QE(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.qzX.qkX != null)
    {
      paramString = QD(paramString);
      int i = 0;
      if (i < this.qzX.qkX.size())
      {
        q localq = (q)this.qzX.qkX.get(i);
        if (localq != null) {
          if (localq.qlR == 0) {
            break label107;
          }
        }
        label107:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localq.qlS))) {
            localLinkedList.add(localq);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      y.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    return localLinkedList;
  }
  
  public final h QF(String paramString)
  {
    return (h)this.qzZ.get(paramString);
  }
  
  public final String QH(String paramString)
  {
    return bk(paramString, false);
  }
  
  public final FavorPayInfo QI(String paramString)
  {
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.qzZ.get(paramString) == null)
    {
      localFavorPayInfo.qvC = "0";
      if (this.qzX != null) {
        localFavorPayInfo.qvF = this.qzX.qkW;
      }
      localFavorPayInfo.qvD = 0;
      return localFavorPayInfo;
    }
    localFavorPayInfo.qvC = paramString;
    if (this.qzX != null) {
      localFavorPayInfo.qvF = this.qzX.qkW;
    }
    localFavorPayInfo.qvD = 0;
    paramString = QG(paramString);
    if (paramString == null) {
      return localFavorPayInfo;
    }
    int i = paramString.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        q localq = (q)this.qzY.get(paramString[i]);
        if (localq != null)
        {
          int j;
          if (localq.qlR != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.qvD = 1;
            if ((localq.qlU != null) && (localq.qlU.size() > 0))
            {
              localFavorPayInfo.qvH = new LinkedList();
              Iterator localIterator = localq.qlU.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.qvH.add(aa.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bk.bl(localq.qlS)) {
              break label262;
            }
            localFavorPayInfo.qvE = localq.qlS;
          }
        }
      }
      else
      {
        return localFavorPayInfo;
      }
      label262:
      i -= 1;
    }
  }
  
  public final String QJ(String paramString)
  {
    ArrayList localArrayList2 = o.bVs().kt(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = QG(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        q localq = (q)this.qzY.get(localArrayList2);
        int j;
        if (localq != null) {
          if (localq.qlR != 0)
          {
            j = 1;
            label122:
            if (j == 0) {
              break label174;
            }
            if ((localHashMap.containsKey(localq.qlS)) || (bk.bl(localq.qlS))) {
              localArrayList1.add(localArrayList2);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label122;
          label174:
          localArrayList1.add(localArrayList2);
        }
      }
    }
    if (localArrayList1.size() == 0) {
      return "0";
    }
    return cW(localArrayList1);
  }
  
  public final List<q> bWr()
  {
    Object localObject = o.bVs().kt(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.qzX.qkX;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        q localq = (q)localLinkedList.get(i);
        int j;
        if (localq != null) {
          if (localq.qlR != 0)
          {
            j = 1;
            label122:
            if (j == 0) {
              break label173;
            }
            if ((localHashMap.containsKey(localq.qlS)) || (bk.bl(localq.qlS))) {
              ((List)localObject).add(localq);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label122;
          label173:
          ((List)localObject).add(localq);
        }
      }
    }
    return localObject;
  }
  
  public final h bi(String paramString, boolean paramBoolean)
  {
    if ((!"0".equals(paramString)) && (this.qzZ.containsKey(paramString))) {
      return (h)this.qzZ.get(paramString);
    }
    paramString = this.qzZ.keySet().iterator();
    label245:
    label246:
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      if (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject1 = (h)this.qzZ.get(localObject1);
        if ((((h)localObject1).qlm == null) || (((h)localObject1).qlm.size() == 0)) {
          continue;
        }
        j = ((h)localObject1).qlm.size();
        Iterator localIterator = ((h)localObject1).qlm.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (e)localIterator.next();
          if (this.qzY.containsKey(((e)localObject2).qkQ))
          {
            localObject2 = (q)this.qzY.get(((e)localObject2).qkQ);
            if ((!((q)localObject2).qlS.equals("")) || (((q)localObject2).qlU.size() != 0) || ((paramBoolean) && (((q)localObject2).qlR != 0))) {
              break label245;
            }
            i += 1;
          }
        }
      }
      for (;;)
      {
        break;
        if ((i <= 0) || (i != j)) {
          break label246;
        }
        return localObject1;
        return null;
      }
    }
  }
  
  public final Map<String, a.a> bj(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.qzX.qkY != null) && (this.qzX.qkY.qli != null))
    {
      localLinkedList = this.qzX.qkY.qli;
      if (!this.qzZ.containsKey(paramString)) {
        break label423;
      }
    }
    label132:
    label406:
    label423:
    for (double d = ((h)this.qzZ.get(paramString)).qll;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        h localh = (h)localLinkedList.get(i);
        a.a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localh.equals("0")))
        {
          localObject = localh.qlk;
          localObject = QG((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (q)this.qzY.get(localObject[0]);
            if (localObject != null) {
              if (((q)localObject).qlR == 0) {
                break label406;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bk.bl(((q)localObject).qlS)) && (((q)localObject).qlU.size() <= 0) && ((paramBoolean) || (!((q)localObject).qlS.equalsIgnoreCase("CFT"))))
          {
            locala = (a.a)localHashMap.get(((q)localObject).qlS);
            if ((locala == null) || (localh.qll > locala.qAa.qll))
            {
              locala = new a.a();
              locala.qAa = localh;
              locala.mOX = ((q)localObject).mOX;
              locala.qAb = (localh.qll - d);
              locala.qAc = ((q)localObject).qlS;
              localHashMap.put(((q)localObject).qlS, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localh.qlk.startsWith(paramString)) {
            break label132;
          }
          localObject = locala;
          if (paramString.equals(localh.qlk)) {
            break label132;
          }
          localObject = localh.qlk.replace(paramString + "-", "");
          break label132;
        }
        y.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      return localHashMap;
    }
  }
  
  public final String bk(String paramString, boolean paramBoolean)
  {
    paramString = QG(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        q localq = (q)this.qzY.get(paramString[i]);
        if (localq != null) {
          if (localq.qlR == 0) {
            break label116;
          }
        }
        label116:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bk.bl(localq.qlS)) && (!paramBoolean)))
          {
            localStringBuilder.append(paramString[i]);
            localStringBuilder.append("-");
          }
          i += 1;
          break;
        }
      }
      if (localStringBuilder.length() == 0) {
        return "0";
      }
      return localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length()).toString();
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.a
 * JD-Core Version:    0.7.0.1
 */