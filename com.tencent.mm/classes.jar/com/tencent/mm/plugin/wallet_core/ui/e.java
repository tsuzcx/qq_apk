package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ao;
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

public final class e
{
  public h OVf;
  private Map<String, t> OVg;
  private Map<String, j> OVh;
  
  public e(h paramh)
  {
    AppMethodBeat.i(70650);
    this.OVf = null;
    this.OVg = null;
    this.OVh = null;
    Assert.assertNotNull(paramh);
    this.OVf = paramh;
    ata();
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
    if ((paramFavorPayInfo != null) && (!Util.isNullOrNil(paramFavorPayInfo.OPI)))
    {
      if (paramFavorPayInfo.OPJ != 0) {}
      for (i = 1; (i != 0) && (!Util.isNullOrNil(paramFavorPayInfo.OPK)) && (paramFavorPayInfo.OPN != null) && (paramFavorPayInfo.OPN.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.OPJ != 0) {}
    for (int i = 1; (i != 0) && (((!Util.isNullOrNil(paramFavorPayInfo.OPK)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.OPK))) || ((Util.isNullOrNil(paramFavorPayInfo.OPK)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  private void ata()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.OVg = new HashMap();
    LinkedList localLinkedList = this.OVf.Own;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (t)localLinkedList.get(i);
        this.OVg.put(((t)localObject).Owg, localObject);
        i += 1;
      }
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.OVh = new HashMap();
    if ((this.OVf.Owo != null) && (this.OVf.Owo.OwA != null))
    {
      localLinkedList = this.OVf.Owo.OwA;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.OVh.put(((j)localObject).OwC, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    Log.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static String[] bht(String paramString)
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
  
  public static List<Bankcard> cJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = u.gJo().Ce(true);
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
  
  private static String iS(List<String> paramList)
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
  
  public final Map<String, a> bhp(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = cT(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> bhq(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.OVf.Owo != null) && (this.OVf.Owo.OwA != null))
    {
      localLinkedList = this.OVf.Owo.OwA;
      if (!this.OVh.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.OVh.get(paramString)).OwD;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.OwC;
          localObject = bht((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (t)this.OVg.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((t)localObject).Oxj == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((t)localObject).Oxm.size() <= 0)) {
            break label412;
          }
          localIterator = ((t)localObject).Oxm.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.OwD > locala.OVi.OwD))
            {
              locala = new a();
              locala.OVi = localj;
              locala.GHx = ((t)localObject).GHx;
              locala.OVj = (localj.OwD - d);
              locala.fJC = ((t)localObject).Oxk;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.OwC.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.OwC)) {
            break;
          }
          localObject = localj.OwC.replace(paramString + "-", "");
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
  
  public final List<t> bhr(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.OVf.Own != null)
    {
      paramString = bhp(paramString);
      int i = 0;
      if (i < this.OVf.Own.size())
      {
        t localt = (t)this.OVf.Own.get(i);
        if (localt != null) {
          if (localt.Oxj == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.Oxk))) {
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
  
  public final j bhs(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.OVh.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String bhu(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = cU(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo bhv(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.OVh.get(paramString) == null)
    {
      localFavorPayInfo.OPI = "0";
      if (this.OVf != null) {
        localFavorPayInfo.OPL = this.OVf.Owm;
      }
      localFavorPayInfo.OPJ = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.OPI = paramString;
    if (this.OVf != null) {
      localFavorPayInfo.OPL = this.OVf.Owm;
    }
    localFavorPayInfo.OPJ = 0;
    paramString = bht(paramString);
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
        t localt = (t)this.OVg.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.Oxj != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.OPJ = 1;
            if ((localt.Oxm != null) && (localt.Oxm.size() > 0))
            {
              localFavorPayInfo.OPN = new LinkedList();
              Iterator localIterator = localt.Oxm.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.OPN.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (Util.isNullOrNil(localt.Oxk)) {
              break label286;
            }
            localFavorPayInfo.OPK = localt.Oxk;
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
  
  public final String bhw(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = u.gJo().Ce(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = bht(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        t localt = (t)this.OVg.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.Oxj != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.Oxk)) || (Util.isNullOrNil(localt.Oxk))) {
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
    paramString = iS(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j cS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.OVh.containsKey(paramString)))
    {
      paramString = (j)this.OVh.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.OVh.keySet().iterator();
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
        localObject1 = (j)this.OVh.get(localObject1);
        if ((((j)localObject1).OwE == null) || (((j)localObject1).OwE.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).OwE.size();
        Iterator localIterator = ((j)localObject1).OwE.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.OVg.containsKey(((f)localObject2).Owg))
          {
            localObject2 = (t)this.OVg.get(((f)localObject2).Owg);
            if ((!((t)localObject2).Oxk.equals("")) || (((t)localObject2).Oxm.size() != 0) || ((paramBoolean) && (((t)localObject2).Oxj != 0))) {
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
  
  public final Map<String, a> cT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.OVf.Owo != null) && (this.OVf.Owo.OwA != null))
    {
      localLinkedList = this.OVf.Owo.OwA;
      if (!this.OVh.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.OVh.get(paramString)).OwD;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.OwC;
          localObject = bht((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (t)this.OVg.get(localObject[0]);
            if (localObject != null) {
              if (((t)localObject).Oxj == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!Util.isNullOrNil(((t)localObject).Oxk)) && (((t)localObject).Oxm.size() <= 0) && ((paramBoolean) || (!((t)localObject).Oxk.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((t)localObject).Oxk);
            if ((locala == null) || (localj.OwD > locala.OVi.OwD))
            {
              locala = new a();
              locala.OVi = localj;
              locala.GHx = ((t)localObject).GHx;
              locala.OVj = (localj.OwD - d);
              locala.fJC = ((t)localObject).Oxk;
              localHashMap.put(((t)localObject).Oxk, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.OwC.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.OwC)) {
            break label138;
          }
          localObject = localj.OwC.replace(paramString + "-", "");
          break label138;
        }
        Log.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String cU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = bht(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        t localt = (t)this.OVg.get(paramString[i]);
        if (localt != null) {
          if (localt.Oxj == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((Util.isNullOrNil(localt.Oxk)) && (!paramBoolean)))
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
  
  public final boolean gLd()
  {
    AppMethodBeat.i(70649);
    if ((this.OVg != null) && (this.OVg.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int gLe()
  {
    AppMethodBeat.i(70657);
    int i = this.OVh.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j gLf()
  {
    AppMethodBeat.i(70658);
    if (!this.OVh.isEmpty())
    {
      Object localObject = this.OVh.entrySet().iterator();
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
  
  public final List<t> gLg()
  {
    AppMethodBeat.i(70668);
    Object localObject = u.gJo().Ce(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.OVf.Own;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        t localt = (t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.Oxj != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.Oxk)) || (Util.isNullOrNil(localt.Oxk))) {
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
    public String GHx;
    public j OVi;
    public double OVj;
    public String fJC;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.OVi != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.OVi.OwC);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.GHx);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.OVj);
      ((StringBuffer)localObject).append("|bankType: " + this.fJC);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(70648);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */