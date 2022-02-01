package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
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

public final class d
{
  public h IcO;
  private Map<String, com.tencent.mm.plugin.wallet.a.t> IcP;
  private Map<String, j> IcQ;
  
  public d(h paramh)
  {
    AppMethodBeat.i(70650);
    this.IcO = null;
    this.IcP = null;
    this.IcQ = null;
    Assert.assertNotNull(paramh);
    this.IcO = paramh;
    amZ();
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
    if ((paramFavorPayInfo != null) && (!Util.isNullOrNil(paramFavorPayInfo.HXI)))
    {
      if (paramFavorPayInfo.HXJ != 0) {}
      for (i = 1; (i != 0) && (!Util.isNullOrNil(paramFavorPayInfo.HXK)) && (paramFavorPayInfo.HXN != null) && (paramFavorPayInfo.HXN.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.HXJ != 0) {}
    for (int i = 1; (i != 0) && (((!Util.isNullOrNil(paramFavorPayInfo.HXK)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.HXK))) || ((Util.isNullOrNil(paramFavorPayInfo.HXK)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  public static String[] aVK(String paramString)
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
  
  private void amZ()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.IcP = new HashMap();
    LinkedList localLinkedList = this.IcO.HEu;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        this.IcP.put(((com.tencent.mm.plugin.wallet.a.t)localObject).HEn, localObject);
        i += 1;
      }
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.IcQ = new HashMap();
    if ((this.IcO.HEv != null) && (this.IcO.HEv.HEH != null))
    {
      localLinkedList = this.IcO.HEv.HEH;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.IcQ.put(((j)localObject).HEJ, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static List<Bankcard> cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(70665);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size()) {
      if (Util.isNullOrNil(paramString))
      {
        if (((Bankcard)localArrayList1.get(i)).field_bankcardType.equals("CFT")) {
          break label140;
        }
        paramInt = 1;
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
        label140:
        paramInt = 0;
      }
    }
  }
  
  private static String ic(List<String> paramList)
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
  
  public final Map<String, a> aVG(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = cF(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> aVH(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.IcO.HEv != null) && (this.IcO.HEv.HEH != null))
    {
      localLinkedList = this.IcO.HEv.HEH;
      if (!this.IcQ.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.IcQ.get(paramString)).HEK;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.HEJ;
          localObject = aVK((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((com.tencent.mm.plugin.wallet.a.t)localObject).HFq == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((com.tencent.mm.plugin.wallet.a.t)localObject).HFt.size() <= 0)) {
            break label412;
          }
          localIterator = ((com.tencent.mm.plugin.wallet.a.t)localObject).HFt.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.HEK > locala.IcR.HEK))
            {
              locala = new a();
              locala.IcR = localj;
              locala.AOj = ((com.tencent.mm.plugin.wallet.a.t)localObject).AOj;
              locala.IcS = (localj.HEK - d);
              locala.dQl = ((com.tencent.mm.plugin.wallet.a.t)localObject).HFr;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.HEJ.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.HEJ)) {
            break;
          }
          localObject = localj.HEJ.replace(paramString + "-", "");
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
  
  public final List<com.tencent.mm.plugin.wallet.a.t> aVI(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.IcO.HEu != null)
    {
      paramString = aVG(paramString);
      int i = 0;
      if (i < this.IcO.HEu.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.IcO.HEu.get(i);
        if (localt != null) {
          if (localt.HFq == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.HFr))) {
            localLinkedList.add(localt);
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
  
  public final j aVJ(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.IcQ.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String aVL(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = cG(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo aVM(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.IcQ.get(paramString) == null)
    {
      localFavorPayInfo.HXI = "0";
      if (this.IcO != null) {
        localFavorPayInfo.HXL = this.IcO.HEt;
      }
      localFavorPayInfo.HXJ = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.HXI = paramString;
    if (this.IcO != null) {
      localFavorPayInfo.HXL = this.IcO.HEt;
    }
    localFavorPayInfo.HXJ = 0;
    paramString = aVK(paramString);
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
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.HFq != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.HXJ = 1;
            if ((localt.HFt != null) && (localt.HFt.size() > 0))
            {
              localFavorPayInfo.HXN = new LinkedList();
              Iterator localIterator = localt.HFt.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.HXN.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (Util.isNullOrNil(localt.HFr)) {
              break label286;
            }
            localFavorPayInfo.HXK = localt.HFr;
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
  
  public final String aVN(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = aVK(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.HFq != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.HFr)) || (Util.isNullOrNil(localt.HFr))) {
              localArrayList1.add(localArrayList2);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label128;
          label180:
          localArrayList1.add(localArrayList2);
        }
      }
    }
    if (localArrayList1.size() == 0)
    {
      AppMethodBeat.o(70667);
      return "0";
    }
    paramString = ic(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j cE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.IcQ.containsKey(paramString)))
    {
      paramString = (j)this.IcQ.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.IcQ.keySet().iterator();
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
        localObject1 = (j)this.IcQ.get(localObject1);
        if ((((j)localObject1).HEL == null) || (((j)localObject1).HEL.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).HEL.size();
        Iterator localIterator = ((j)localObject1).HEL.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.IcP.containsKey(((f)localObject2).HEn))
          {
            localObject2 = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(((f)localObject2).HEn);
            if ((!((com.tencent.mm.plugin.wallet.a.t)localObject2).HFr.equals("")) || (((com.tencent.mm.plugin.wallet.a.t)localObject2).HFt.size() != 0) || ((paramBoolean) && (((com.tencent.mm.plugin.wallet.a.t)localObject2).HFq != 0))) {
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
  
  public final Map<String, a> cF(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.IcO.HEv != null) && (this.IcO.HEv.HEH != null))
    {
      localLinkedList = this.IcO.HEv.HEH;
      if (!this.IcQ.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.IcQ.get(paramString)).HEK;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.HEJ;
          localObject = aVK((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(localObject[0]);
            if (localObject != null) {
              if (((com.tencent.mm.plugin.wallet.a.t)localObject).HFq == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!Util.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).HFr)) && (((com.tencent.mm.plugin.wallet.a.t)localObject).HFt.size() <= 0) && ((paramBoolean) || (!((com.tencent.mm.plugin.wallet.a.t)localObject).HFr.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((com.tencent.mm.plugin.wallet.a.t)localObject).HFr);
            if ((locala == null) || (localj.HEK > locala.IcR.HEK))
            {
              locala = new a();
              locala.IcR = localj;
              locala.AOj = ((com.tencent.mm.plugin.wallet.a.t)localObject).AOj;
              locala.IcS = (localj.HEK - d);
              locala.dQl = ((com.tencent.mm.plugin.wallet.a.t)localObject).HFr;
              localHashMap.put(((com.tencent.mm.plugin.wallet.a.t)localObject).HFr, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.HEJ.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.HEJ)) {
            break label138;
          }
          localObject = localj.HEJ.replace(paramString + "-", "");
          break label138;
        }
        Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String cG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = aVK(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.IcP.get(paramString[i]);
        if (localt != null) {
          if (localt.HFq == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((Util.isNullOrNil(localt.HFr)) && (!paramBoolean)))
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
  
  public final boolean fSw()
  {
    AppMethodBeat.i(70649);
    if ((this.IcP != null) && (this.IcP.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int fSx()
  {
    AppMethodBeat.i(70657);
    int i = this.IcQ.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j fSy()
  {
    AppMethodBeat.i(70658);
    if (!this.IcQ.isEmpty())
    {
      Object localObject = this.IcQ.entrySet().iterator();
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
  
  public final List<com.tencent.mm.plugin.wallet.a.t> fSz()
  {
    AppMethodBeat.i(70668);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.fQI().yj(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.IcO.HEu;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.HFq != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.HFr)) || (Util.isNullOrNil(localt.HFr))) {
              ((List)localObject).add(localt);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label128;
          label179:
          ((List)localObject).add(localt);
        }
      }
    }
    AppMethodBeat.o(70668);
    return localObject;
  }
  
  public static final class a
  {
    public String AOj;
    public j IcR;
    public double IcS;
    public String dQl;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.IcR != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.IcR.HEJ);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.AOj);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.IcS);
      ((StringBuffer)localObject).append("|bankType: " + this.dQl);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(70648);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */