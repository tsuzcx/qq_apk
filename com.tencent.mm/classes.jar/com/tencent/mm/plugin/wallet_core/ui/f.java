package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.wallet.model.h;
import com.tencent.mm.plugin.wallet.model.i;
import com.tencent.mm.plugin.wallet.model.j;
import com.tencent.mm.plugin.wallet.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class f
{
  public h VLs;
  private Map<String, q> VLt;
  private Map<String, j> VLu;
  
  public f(h paramh)
  {
    AppMethodBeat.i(70650);
    this.VLs = null;
    this.VLt = null;
    this.VLu = null;
    Assert.assertNotNull(paramh);
    this.VLs = paramh;
    aNi();
    AppMethodBeat.o(70650);
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(70664);
    if (paramBankcard == null)
    {
      Log.w("MicroMsg.FavorLogicHelper", "curBankcard null");
      AppMethodBeat.o(70664);
      return true;
    }
    if ((paramFavorPayInfo != null) && (!Util.isNullOrNil(paramFavorPayInfo.VFC)))
    {
      if (paramFavorPayInfo.VFD != 0) {}
      for (i = 1; (i != 0) && (!Util.isNullOrNil(paramFavorPayInfo.VFE)) && (paramFavorPayInfo.VFH != null) && (paramFavorPayInfo.VFH.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.VFD != 0) {}
    for (int i = 1; (i != 0) && (((!Util.isNullOrNil(paramFavorPayInfo.VFE)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.VFE))) || ((Util.isNullOrNil(paramFavorPayInfo.VFE)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  private void aNi()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.VLt = new HashMap();
    LinkedList localLinkedList = this.VLs.Vly;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (q)localLinkedList.get(i);
        this.VLt.put(((q)localObject).Vlr, localObject);
        i += 1;
      }
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.VLu = new HashMap();
    if ((this.VLs.Vlz != null) && (this.VLs.Vlz.VlL != null))
    {
      localLinkedList = this.VLs.Vlz.VlL;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.VLu.put(((j)localObject).VlN, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static String[] bhc(String paramString)
  {
    AppMethodBeat.i(70660);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70660);
      return null;
    }
    paramString = paramString.split("-");
    AppMethodBeat.o(70660);
    return paramString;
  }
  
  public static List<Bankcard> dz(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = u.iiC().HJ(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(70665);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i;
    if (localArrayList1 != null)
    {
      i = 0;
      if (i < localArrayList1.size()) {
        if (Util.isNullOrNil(paramString))
        {
          if (((Bankcard)localArrayList1.get(i)).field_bankcardType.equals("CFT")) {
            break label144;
          }
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        localArrayList2.add((Bankcard)localArrayList1.get(i));
      }
      i += 1;
      break;
      if (((Bankcard)localArrayList1.get(i)).field_bankcardType.equals(paramString))
      {
        paramInt = 1;
        continue;
        AppMethodBeat.o(70665);
        return localArrayList2;
      }
      else
      {
        label144:
        paramInt = 0;
      }
    }
  }
  
  private static String ma(List<String> paramList)
  {
    AppMethodBeat.i(70666);
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
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(70666);
    return paramList;
  }
  
  public final Map<String, a> bgY(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = dB(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> bgZ(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.VLs.Vlz != null) && (this.VLs.Vlz.VlL != null))
    {
      localLinkedList = this.VLs.Vlz.VlL;
      if (!this.VLu.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.VLu.get(paramString)).VlO;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.VlN;
          localObject = bhc((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (q)this.VLt.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((q)localObject).Vmu == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((q)localObject).Vmx.size() <= 0)) {
            break label412;
          }
          localIterator = ((q)localObject).Vmx.iterator();
          while (localIterator.hasNext())
          {
            String str = w.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.VlO > locala.VLv.VlO))
            {
              locala = new a();
              locala.VLv = localj;
              locala.MEo = ((q)localObject).MEo;
              locala.VLw = (localj.VlO - d);
              locala.hPf = ((q)localObject).Vmv;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.VlN.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.VlN)) {
            break;
          }
          localObject = localj.VlN.replace(paramString + "-", "");
          break;
        }
        i += 1;
        continue;
        Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70654);
      return localHashMap;
    }
  }
  
  public final List<q> bha(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.VLs.Vly != null)
    {
      paramString = bgY(paramString);
      int i = 0;
      if (i < this.VLs.Vly.size())
      {
        q localq = (q)this.VLs.Vly.get(i);
        if (localq != null) {
          if (localq.Vmu == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localq.Vmv))) {
            localLinkedList.add(localq);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      Log.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    AppMethodBeat.o(70656);
    return localLinkedList;
  }
  
  public final j bhb(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.VLu.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String bhd(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = dC(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo bhe(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.VLu.get(paramString) == null)
    {
      localFavorPayInfo.VFC = "0";
      if (this.VLs != null) {
        localFavorPayInfo.VFF = this.VLs.Vlx;
      }
      localFavorPayInfo.VFD = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.VFC = paramString;
    if (this.VLs != null) {
      localFavorPayInfo.VFF = this.VLs.Vlx;
    }
    localFavorPayInfo.VFD = 0;
    paramString = bhc(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    int i = paramString.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        q localq = (q)this.VLt.get(paramString[i]);
        if (localq != null)
        {
          int j;
          if (localq.Vmu != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.VFD = 1;
            if ((localq.Vmx != null) && (localq.Vmx.size() > 0))
            {
              localFavorPayInfo.VFH = new LinkedList();
              Iterator localIterator = localq.Vmx.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.VFH.add(w.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (Util.isNullOrNil(localq.Vmv)) {
              break label286;
            }
            localFavorPayInfo.VFE = localq.Vmv;
          }
        }
      }
      else
      {
        AppMethodBeat.o(70663);
        return localFavorPayInfo;
      }
      label286:
      i -= 1;
    }
  }
  
  public final String bhf(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = u.iiC().HJ(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if (localArrayList2 != null)
    {
      i = 0;
      while (i < localArrayList2.size())
      {
        localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
        i += 1;
      }
    }
    paramString = bhc(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        q localq = (q)this.VLt.get(localArrayList2);
        int j;
        if (localq != null) {
          if (localq.Vmu != 0)
          {
            j = 1;
            label133:
            if (j == 0) {
              break label185;
            }
            if ((localHashMap.containsKey(localq.Vmv)) || (Util.isNullOrNil(localq.Vmv))) {
              localArrayList1.add(localArrayList2);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label133;
          label185:
          localArrayList1.add(localArrayList2);
        }
      }
    }
    if (localArrayList1.size() == 0)
    {
      AppMethodBeat.o(70667);
      return "0";
    }
    paramString = ma(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j dA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.VLu.containsKey(paramString)))
    {
      paramString = (j)this.VLu.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.VLu.keySet().iterator();
    label271:
    label272:
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      if (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject1 = (j)this.VLu.get(localObject1);
        if ((((j)localObject1).VlP == null) || (((j)localObject1).VlP.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).VlP.size();
        Iterator localIterator = ((j)localObject1).VlP.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.wallet.model.f)localIterator.next();
          if (this.VLt.containsKey(((com.tencent.mm.plugin.wallet.model.f)localObject2).Vlr))
          {
            localObject2 = (q)this.VLt.get(((com.tencent.mm.plugin.wallet.model.f)localObject2).Vlr);
            if ((!((q)localObject2).Vmv.equals("")) || (((q)localObject2).Vmx.size() != 0) || ((paramBoolean) && (((q)localObject2).Vmu != 0))) {
              break label271;
            }
            i += 1;
          }
        }
      }
      for (;;)
      {
        break;
        if ((i <= 0) || (i != j)) {
          break label272;
        }
        AppMethodBeat.o(70653);
        return localObject1;
        AppMethodBeat.o(70653);
        return null;
      }
    }
  }
  
  public final Map<String, a> dB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.VLs.Vlz != null) && (this.VLs.Vlz.VlL != null))
    {
      localLinkedList = this.VLs.Vlz.VlL;
      if (!this.VLu.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.VLu.get(paramString)).VlO;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.VlN;
          localObject = bhc((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (q)this.VLt.get(localObject[0]);
            if (localObject != null) {
              if (((q)localObject).Vmu == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!Util.isNullOrNil(((q)localObject).Vmv)) && (((q)localObject).Vmx.size() <= 0) && ((paramBoolean) || (!((q)localObject).Vmv.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((q)localObject).Vmv);
            if ((locala == null) || (localj.VlO > locala.VLv.VlO))
            {
              locala = new a();
              locala.VLv = localj;
              locala.MEo = ((q)localObject).MEo;
              locala.VLw = (localj.VlO - d);
              locala.hPf = ((q)localObject).Vmv;
              localHashMap.put(((q)localObject).Vmv, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.VlN.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.VlN)) {
            break label138;
          }
          localObject = localj.VlN.replace(paramString + "-", "");
          break label138;
        }
        Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String dC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = bhc(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        q localq = (q)this.VLt.get(paramString[i]);
        if (localq != null) {
          if (localq.Vmu == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((Util.isNullOrNil(localq.Vmv)) && (!paramBoolean)))
          {
            localStringBuilder.append(paramString[i]);
            localStringBuilder.append("-");
          }
          i += 1;
          break;
        }
      }
      if (localStringBuilder.length() == 0)
      {
        AppMethodBeat.o(70662);
        return "0";
      }
      paramString = localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length()).toString();
      AppMethodBeat.o(70662);
      return paramString;
    }
    AppMethodBeat.o(70662);
    return "0";
  }
  
  public final boolean iku()
  {
    AppMethodBeat.i(70649);
    if ((this.VLt != null) && (this.VLt.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int ikv()
  {
    AppMethodBeat.i(70657);
    int i = this.VLu.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j ikw()
  {
    AppMethodBeat.i(70658);
    if (!this.VLu.isEmpty())
    {
      Object localObject = this.VLu.entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (j)((Map.Entry)((Iterator)localObject).next()).getValue();
        AppMethodBeat.o(70658);
        return localObject;
      }
    }
    AppMethodBeat.o(70658);
    return null;
  }
  
  public final List<q> ikx()
  {
    AppMethodBeat.i(70668);
    Object localObject = u.iiC().HJ(true);
    HashMap localHashMap = new HashMap();
    int i;
    if (localObject != null)
    {
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
        i += 1;
      }
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.VLs.Vly;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        q localq = (q)localLinkedList.get(i);
        int j;
        if (localq != null) {
          if (localq.Vmu != 0)
          {
            j = 1;
            label133:
            if (j == 0) {
              break label184;
            }
            if ((localHashMap.containsKey(localq.Vmv)) || (Util.isNullOrNil(localq.Vmv))) {
              ((List)localObject).add(localq);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label133;
          label184:
          ((List)localObject).add(localq);
        }
      }
    }
    AppMethodBeat.o(70668);
    return localObject;
  }
  
  public static final class a
  {
    public String MEo;
    public j VLv;
    public double VLw;
    public String hPf;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.VLv != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.VLv.VlN);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.MEo);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.VLw);
      ((StringBuffer)localObject).append("|bankType: " + this.hPf);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(70648);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */