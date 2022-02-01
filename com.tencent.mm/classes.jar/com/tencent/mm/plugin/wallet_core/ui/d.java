package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public h BBG;
  private Map<String, t> BBH;
  private Map<String, j> BBI;
  
  public d(h paramh)
  {
    AppMethodBeat.i(70650);
    this.BBG = null;
    this.BBH = null;
    this.BBI = null;
    Assert.assertNotNull(paramh);
    this.BBG = paramh;
    WJ();
    AppMethodBeat.o(70650);
  }
  
  private void WJ()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.BBH = new HashMap();
    LinkedList localLinkedList = this.BBG.BgM;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (t)localLinkedList.get(i);
        this.BBH.put(((t)localObject).BgF, localObject);
        i += 1;
      }
    }
    ac.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.BBI = new HashMap();
    if ((this.BBG.BgN != null) && (this.BBG.BgN.BgZ != null))
    {
      localLinkedList = this.BBG.BgN.BgZ;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.BBI.put(((j)localObject).Bhb, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    ac.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(70664);
    if (paramBankcard == null)
    {
      ac.w("MicroMsg.FavorLogicHelper", "curBankcard null");
      AppMethodBeat.o(70664);
      return true;
    }
    if ((paramFavorPayInfo != null) && (!bs.isNullOrNil(paramFavorPayInfo.Bwv)))
    {
      if (paramFavorPayInfo.Bww != 0) {}
      for (i = 1; (i != 0) && (!bs.isNullOrNil(paramFavorPayInfo.Bwx)) && (paramFavorPayInfo.BwA != null) && (paramFavorPayInfo.BwA.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.Bww != 0) {}
    for (int i = 1; (i != 0) && (((!bs.isNullOrNil(paramFavorPayInfo.Bwx)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Bwx))) || ((bs.isNullOrNil(paramFavorPayInfo.Bwx)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  public static String[] azF(String paramString)
  {
    AppMethodBeat.i(70660);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70660);
      return null;
    }
    paramString = paramString.split("-");
    AppMethodBeat.o(70660);
    return paramString;
  }
  
  public static List<Bankcard> ci(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = s.ery().tD(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(70665);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size()) {
      if (bs.isNullOrNil(paramString))
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
  
  private static String gA(List<String> paramList)
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
  
  public final Map<String, a> azB(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = ca(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> azC(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.BBG.BgN != null) && (this.BBG.BgN.BgZ != null))
    {
      localLinkedList = this.BBG.BgN.BgZ;
      if (!this.BBI.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.BBI.get(paramString)).Bhc;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.Bhb;
          localObject = azF((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (t)this.BBH.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((t)localObject).BhI == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((t)localObject).BhL.size() <= 0)) {
            break label412;
          }
          localIterator = ((t)localObject).BhL.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.Bhc > locala.BBJ.Bhc))
            {
              locala = new a();
              locala.BBJ = localj;
              locala.vxj = ((t)localObject).vxj;
              locala.BBK = (localj.Bhc - d);
              locala.dlW = ((t)localObject).BhJ;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.Bhb.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.Bhb)) {
            break;
          }
          localObject = localj.Bhb.replace(paramString + "-", "");
          break;
        }
        i += 1;
        continue;
        ac.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70654);
      return localHashMap;
    }
  }
  
  public final List<t> azD(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.BBG.BgM != null)
    {
      paramString = azB(paramString);
      int i = 0;
      if (i < this.BBG.BgM.size())
      {
        t localt = (t)this.BBG.BgM.get(i);
        if (localt != null) {
          if (localt.BhI == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.BhJ))) {
            localLinkedList.add(localt);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      ac.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    AppMethodBeat.o(70656);
    return localLinkedList;
  }
  
  public final j azE(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.BBI.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String azG(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = cb(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo azH(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.BBI.get(paramString) == null)
    {
      localFavorPayInfo.Bwv = "0";
      if (this.BBG != null) {
        localFavorPayInfo.Bwy = this.BBG.BgL;
      }
      localFavorPayInfo.Bww = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.Bwv = paramString;
    if (this.BBG != null) {
      localFavorPayInfo.Bwy = this.BBG.BgL;
    }
    localFavorPayInfo.Bww = 0;
    paramString = azF(paramString);
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
        t localt = (t)this.BBH.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.BhI != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.Bww = 1;
            if ((localt.BhL != null) && (localt.BhL.size() > 0))
            {
              localFavorPayInfo.BwA = new LinkedList();
              Iterator localIterator = localt.BhL.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.BwA.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bs.isNullOrNil(localt.BhJ)) {
              break label286;
            }
            localFavorPayInfo.Bwx = localt.BhJ;
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
  
  public final String azI(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = s.ery().tD(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = azF(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        t localt = (t)this.BBH.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.BhI != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.BhJ)) || (bs.isNullOrNil(localt.BhJ))) {
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
    paramString = gA(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j bZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.BBI.containsKey(paramString)))
    {
      paramString = (j)this.BBI.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.BBI.keySet().iterator();
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
        localObject1 = (j)this.BBI.get(localObject1);
        if ((((j)localObject1).Bhd == null) || (((j)localObject1).Bhd.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).Bhd.size();
        Iterator localIterator = ((j)localObject1).Bhd.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.BBH.containsKey(((f)localObject2).BgF))
          {
            localObject2 = (t)this.BBH.get(((f)localObject2).BgF);
            if ((!((t)localObject2).BhJ.equals("")) || (((t)localObject2).BhL.size() != 0) || ((paramBoolean) && (((t)localObject2).BhI != 0))) {
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
  
  public final Map<String, a> ca(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.BBG.BgN != null) && (this.BBG.BgN.BgZ != null))
    {
      localLinkedList = this.BBG.BgN.BgZ;
      if (!this.BBI.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.BBI.get(paramString)).Bhc;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.Bhb;
          localObject = azF((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (t)this.BBH.get(localObject[0]);
            if (localObject != null) {
              if (((t)localObject).BhI == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bs.isNullOrNil(((t)localObject).BhJ)) && (((t)localObject).BhL.size() <= 0) && ((paramBoolean) || (!((t)localObject).BhJ.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((t)localObject).BhJ);
            if ((locala == null) || (localj.Bhc > locala.BBJ.Bhc))
            {
              locala = new a();
              locala.BBJ = localj;
              locala.vxj = ((t)localObject).vxj;
              locala.BBK = (localj.Bhc - d);
              locala.dlW = ((t)localObject).BhJ;
              localHashMap.put(((t)localObject).BhJ, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.Bhb.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.Bhb)) {
            break label138;
          }
          localObject = localj.Bhb.replace(paramString + "-", "");
          break label138;
        }
        ac.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String cb(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = azF(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        t localt = (t)this.BBH.get(paramString[i]);
        if (localt != null) {
          if (localt.BhI == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bs.isNullOrNil(localt.BhJ)) && (!paramBoolean)))
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
  
  public final boolean etd()
  {
    AppMethodBeat.i(70649);
    if ((this.BBH != null) && (this.BBH.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int ete()
  {
    AppMethodBeat.i(70657);
    int i = this.BBI.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j etf()
  {
    AppMethodBeat.i(70658);
    if (!this.BBI.isEmpty())
    {
      Object localObject = this.BBI.entrySet().iterator();
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
  
  public final List<t> etg()
  {
    AppMethodBeat.i(70668);
    Object localObject = s.ery().tD(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.BBG.BgM;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        t localt = (t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.BhI != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.BhJ)) || (bs.isNullOrNil(localt.BhJ))) {
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
    public j BBJ;
    public double BBK;
    public String dlW;
    public String vxj;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.BBJ != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.BBJ.Bhb);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.vxj);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.BBK);
      ((StringBuffer)localObject).append("|bankType: " + this.dlW);
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