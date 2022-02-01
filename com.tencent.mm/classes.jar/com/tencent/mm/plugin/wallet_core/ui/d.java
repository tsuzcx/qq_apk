package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public h DbY;
  private Map<String, com.tencent.mm.plugin.wallet.a.t> DbZ;
  private Map<String, j> Dca;
  
  public d(h paramh)
  {
    AppMethodBeat.i(70650);
    this.DbY = null;
    this.DbZ = null;
    this.Dca = null;
    Assert.assertNotNull(paramh);
    this.DbY = paramh;
    Zd();
    AppMethodBeat.o(70650);
  }
  
  private void Zd()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.DbZ = new HashMap();
    LinkedList localLinkedList = this.DbY.CHa;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        this.DbZ.put(((com.tencent.mm.plugin.wallet.a.t)localObject).CGT, localObject);
        i += 1;
      }
    }
    ad.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.Dca = new HashMap();
    if ((this.DbY.CHb != null) && (this.DbY.CHb.CHn != null))
    {
      localLinkedList = this.DbY.CHb.CHn;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.Dca.put(((j)localObject).CHp, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    ad.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(70664);
    if (paramBankcard == null)
    {
      ad.w("MicroMsg.FavorLogicHelper", "curBankcard null");
      AppMethodBeat.o(70664);
      return true;
    }
    if ((paramFavorPayInfo != null) && (!bt.isNullOrNil(paramFavorPayInfo.CWL)))
    {
      if (paramFavorPayInfo.CWM != 0) {}
      for (i = 1; (i != 0) && (!bt.isNullOrNil(paramFavorPayInfo.CWN)) && (paramFavorPayInfo.CWQ != null) && (paramFavorPayInfo.CWQ.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.CWM != 0) {}
    for (int i = 1; (i != 0) && (((!bt.isNullOrNil(paramFavorPayInfo.CWN)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.CWN))) || ((bt.isNullOrNil(paramFavorPayInfo.CWN)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  public static String[] aEP(String paramString)
  {
    AppMethodBeat.i(70660);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70660);
      return null;
    }
    paramString = paramString.split("-");
    AppMethodBeat.o(70660);
    return paramString;
  }
  
  public static List<Bankcard> cq(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = com.tencent.mm.plugin.wallet_core.model.t.eFy().un(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(70665);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size()) {
      if (bt.isNullOrNil(paramString))
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
  
  private static String gM(List<String> paramList)
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
  
  public final Map<String, a> aEL(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = ci(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> aEM(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.DbY.CHb != null) && (this.DbY.CHb.CHn != null))
    {
      localLinkedList = this.DbY.CHb.CHn;
      if (!this.Dca.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.Dca.get(paramString)).CHq;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.CHp;
          localObject = aEP((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((com.tencent.mm.plugin.wallet.a.t)localObject).CHW == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((com.tencent.mm.plugin.wallet.a.t)localObject).CHZ.size() <= 0)) {
            break label412;
          }
          localIterator = ((com.tencent.mm.plugin.wallet.a.t)localObject).CHZ.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.CHq > locala.Dcb.CHq))
            {
              locala = new a();
              locala.Dcb = localj;
              locala.wCD = ((com.tencent.mm.plugin.wallet.a.t)localObject).wCD;
              locala.Dcc = (localj.CHq - d);
              locala.dxK = ((com.tencent.mm.plugin.wallet.a.t)localObject).CHX;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.CHp.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.CHp)) {
            break;
          }
          localObject = localj.CHp.replace(paramString + "-", "");
          break;
        }
        i += 1;
        continue;
        ad.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70654);
      return localHashMap;
    }
  }
  
  public final List<com.tencent.mm.plugin.wallet.a.t> aEN(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.DbY.CHa != null)
    {
      paramString = aEL(paramString);
      int i = 0;
      if (i < this.DbY.CHa.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DbY.CHa.get(i);
        if (localt != null) {
          if (localt.CHW == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.CHX))) {
            localLinkedList.add(localt);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      ad.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    AppMethodBeat.o(70656);
    return localLinkedList;
  }
  
  public final j aEO(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.Dca.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String aEQ(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = cj(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo aER(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.Dca.get(paramString) == null)
    {
      localFavorPayInfo.CWL = "0";
      if (this.DbY != null) {
        localFavorPayInfo.CWO = this.DbY.CGZ;
      }
      localFavorPayInfo.CWM = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.CWL = paramString;
    if (this.DbY != null) {
      localFavorPayInfo.CWO = this.DbY.CGZ;
    }
    localFavorPayInfo.CWM = 0;
    paramString = aEP(paramString);
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
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.CHW != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.CWM = 1;
            if ((localt.CHZ != null) && (localt.CHZ.size() > 0))
            {
              localFavorPayInfo.CWQ = new LinkedList();
              Iterator localIterator = localt.CHZ.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.CWQ.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bt.isNullOrNil(localt.CHX)) {
              break label286;
            }
            localFavorPayInfo.CWN = localt.CHX;
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
  
  public final String aES(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.eFy().un(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = aEP(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.CHW != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.CHX)) || (bt.isNullOrNil(localt.CHX))) {
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
    paramString = gM(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j ch(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.Dca.containsKey(paramString)))
    {
      paramString = (j)this.Dca.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.Dca.keySet().iterator();
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
        localObject1 = (j)this.Dca.get(localObject1);
        if ((((j)localObject1).CHr == null) || (((j)localObject1).CHr.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).CHr.size();
        Iterator localIterator = ((j)localObject1).CHr.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.DbZ.containsKey(((f)localObject2).CGT))
          {
            localObject2 = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(((f)localObject2).CGT);
            if ((!((com.tencent.mm.plugin.wallet.a.t)localObject2).CHX.equals("")) || (((com.tencent.mm.plugin.wallet.a.t)localObject2).CHZ.size() != 0) || ((paramBoolean) && (((com.tencent.mm.plugin.wallet.a.t)localObject2).CHW != 0))) {
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
  
  public final Map<String, a> ci(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.DbY.CHb != null) && (this.DbY.CHb.CHn != null))
    {
      localLinkedList = this.DbY.CHb.CHn;
      if (!this.Dca.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.Dca.get(paramString)).CHq;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.CHp;
          localObject = aEP((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(localObject[0]);
            if (localObject != null) {
              if (((com.tencent.mm.plugin.wallet.a.t)localObject).CHW == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bt.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CHX)) && (((com.tencent.mm.plugin.wallet.a.t)localObject).CHZ.size() <= 0) && ((paramBoolean) || (!((com.tencent.mm.plugin.wallet.a.t)localObject).CHX.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((com.tencent.mm.plugin.wallet.a.t)localObject).CHX);
            if ((locala == null) || (localj.CHq > locala.Dcb.CHq))
            {
              locala = new a();
              locala.Dcb = localj;
              locala.wCD = ((com.tencent.mm.plugin.wallet.a.t)localObject).wCD;
              locala.Dcc = (localj.CHq - d);
              locala.dxK = ((com.tencent.mm.plugin.wallet.a.t)localObject).CHX;
              localHashMap.put(((com.tencent.mm.plugin.wallet.a.t)localObject).CHX, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.CHp.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.CHp)) {
            break label138;
          }
          localObject = localj.CHp.replace(paramString + "-", "");
          break label138;
        }
        ad.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = aEP(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DbZ.get(paramString[i]);
        if (localt != null) {
          if (localt.CHW == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bt.isNullOrNil(localt.CHX)) && (!paramBoolean)))
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
  
  public final boolean eHj()
  {
    AppMethodBeat.i(70649);
    if ((this.DbZ != null) && (this.DbZ.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int eHk()
  {
    AppMethodBeat.i(70657);
    int i = this.Dca.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j eHl()
  {
    AppMethodBeat.i(70658);
    if (!this.Dca.isEmpty())
    {
      Object localObject = this.Dca.entrySet().iterator();
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
  
  public final List<com.tencent.mm.plugin.wallet.a.t> eHm()
  {
    AppMethodBeat.i(70668);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.eFy().un(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.DbY.CHa;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.CHW != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.CHX)) || (bt.isNullOrNil(localt.CHX))) {
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
    public j Dcb;
    public double Dcc;
    public String dxK;
    public String wCD;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.Dcb != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.Dcb.CHp);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.wCD);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.Dcc);
      ((StringBuffer)localObject).append("|bankType: " + this.dxK);
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