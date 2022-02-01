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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public h DtC;
  private Map<String, com.tencent.mm.plugin.wallet.a.t> DtD;
  private Map<String, j> DtE;
  
  public d(h paramh)
  {
    AppMethodBeat.i(70650);
    this.DtC = null;
    this.DtD = null;
    this.DtE = null;
    Assert.assertNotNull(paramh);
    this.DtC = paramh;
    Zm();
    AppMethodBeat.o(70650);
  }
  
  private void Zm()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.DtD = new HashMap();
    LinkedList localLinkedList = this.DtC.CYG;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        this.DtD.put(((com.tencent.mm.plugin.wallet.a.t)localObject).CYz, localObject);
        i += 1;
      }
    }
    ae.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.DtE = new HashMap();
    if ((this.DtC.CYH != null) && (this.DtC.CYH.CYT != null))
    {
      localLinkedList = this.DtC.CYH.CYT;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.DtE.put(((j)localObject).CYV, localObject);
        i += 1;
      }
      AppMethodBeat.o(70651);
      return;
    }
    ae.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(70651);
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(70664);
    if (paramBankcard == null)
    {
      ae.w("MicroMsg.FavorLogicHelper", "curBankcard null");
      AppMethodBeat.o(70664);
      return true;
    }
    if ((paramFavorPayInfo != null) && (!bu.isNullOrNil(paramFavorPayInfo.Doq)))
    {
      if (paramFavorPayInfo.Dor != 0) {}
      for (i = 1; (i != 0) && (!bu.isNullOrNil(paramFavorPayInfo.Dos)) && (paramFavorPayInfo.Dov != null) && (paramFavorPayInfo.Dov.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.Dor != 0) {}
    for (int i = 1; (i != 0) && (((!bu.isNullOrNil(paramFavorPayInfo.Dos)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Dos))) || ((bu.isNullOrNil(paramFavorPayInfo.Dos)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  public static String[] aGj(String paramString)
  {
    AppMethodBeat.i(70660);
    if (bu.isNullOrNil(paramString))
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
    ArrayList localArrayList1 = com.tencent.mm.plugin.wallet_core.model.t.eJf().uv(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(70665);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size()) {
      if (bu.isNullOrNil(paramString))
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
  
  private static String gW(List<String> paramList)
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
  
  public final Map<String, a> aGf(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = cm(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> aGg(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.DtC.CYH != null) && (this.DtC.CYH.CYT != null))
    {
      localLinkedList = this.DtC.CYH.CYT;
      if (!this.DtE.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.DtE.get(paramString)).CYW;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.CYV;
          localObject = aGj((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((com.tencent.mm.plugin.wallet.a.t)localObject).CZC == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((com.tencent.mm.plugin.wallet.a.t)localObject).CZF.size() <= 0)) {
            break label412;
          }
          localIterator = ((com.tencent.mm.plugin.wallet.a.t)localObject).CZF.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.CYW > locala.DtF.CYW))
            {
              locala = new a();
              locala.DtF = localj;
              locala.wSo = ((com.tencent.mm.plugin.wallet.a.t)localObject).wSo;
              locala.DtG = (localj.CYW - d);
              locala.dyP = ((com.tencent.mm.plugin.wallet.a.t)localObject).CZD;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.CYV.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.CYV)) {
            break;
          }
          localObject = localj.CYV.replace(paramString + "-", "");
          break;
        }
        i += 1;
        continue;
        ae.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70654);
      return localHashMap;
    }
  }
  
  public final List<com.tencent.mm.plugin.wallet.a.t> aGh(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.DtC.CYG != null)
    {
      paramString = aGf(paramString);
      int i = 0;
      if (i < this.DtC.CYG.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DtC.CYG.get(i);
        if (localt != null) {
          if (localt.CZC == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.CZD))) {
            localLinkedList.add(localt);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      ae.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    AppMethodBeat.o(70656);
    return localLinkedList;
  }
  
  public final j aGi(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.DtE.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String aGk(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = cn(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo aGl(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.DtE.get(paramString) == null)
    {
      localFavorPayInfo.Doq = "0";
      if (this.DtC != null) {
        localFavorPayInfo.Dot = this.DtC.CYF;
      }
      localFavorPayInfo.Dor = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.Doq = paramString;
    if (this.DtC != null) {
      localFavorPayInfo.Dot = this.DtC.CYF;
    }
    localFavorPayInfo.Dor = 0;
    paramString = aGj(paramString);
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
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.CZC != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.Dor = 1;
            if ((localt.CZF != null) && (localt.CZF.size() > 0))
            {
              localFavorPayInfo.Dov = new LinkedList();
              Iterator localIterator = localt.CZF.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.Dov.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bu.isNullOrNil(localt.CZD)) {
              break label286;
            }
            localFavorPayInfo.Dos = localt.CZD;
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
  
  public final String aGm(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.eJf().uv(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = aGj(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.CZC != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.CZD)) || (bu.isNullOrNil(localt.CZD))) {
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
    paramString = gW(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j cl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.DtE.containsKey(paramString)))
    {
      paramString = (j)this.DtE.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.DtE.keySet().iterator();
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
        localObject1 = (j)this.DtE.get(localObject1);
        if ((((j)localObject1).CYX == null) || (((j)localObject1).CYX.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).CYX.size();
        Iterator localIterator = ((j)localObject1).CYX.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.DtD.containsKey(((f)localObject2).CYz))
          {
            localObject2 = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(((f)localObject2).CYz);
            if ((!((com.tencent.mm.plugin.wallet.a.t)localObject2).CZD.equals("")) || (((com.tencent.mm.plugin.wallet.a.t)localObject2).CZF.size() != 0) || ((paramBoolean) && (((com.tencent.mm.plugin.wallet.a.t)localObject2).CZC != 0))) {
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
  
  public final Map<String, a> cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.DtC.CYH != null) && (this.DtC.CYH.CYT != null))
    {
      localLinkedList = this.DtC.CYH.CYT;
      if (!this.DtE.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.DtE.get(paramString)).CYW;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.CYV;
          localObject = aGj((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(localObject[0]);
            if (localObject != null) {
              if (((com.tencent.mm.plugin.wallet.a.t)localObject).CZC == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bu.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).CZD)) && (((com.tencent.mm.plugin.wallet.a.t)localObject).CZF.size() <= 0) && ((paramBoolean) || (!((com.tencent.mm.plugin.wallet.a.t)localObject).CZD.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((com.tencent.mm.plugin.wallet.a.t)localObject).CZD);
            if ((locala == null) || (localj.CYW > locala.DtF.CYW))
            {
              locala = new a();
              locala.DtF = localj;
              locala.wSo = ((com.tencent.mm.plugin.wallet.a.t)localObject).wSo;
              locala.DtG = (localj.CYW - d);
              locala.dyP = ((com.tencent.mm.plugin.wallet.a.t)localObject).CZD;
              localHashMap.put(((com.tencent.mm.plugin.wallet.a.t)localObject).CZD, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.CYV.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.CYV)) {
            break label138;
          }
          localObject = localj.CYV.replace(paramString + "-", "");
          break label138;
        }
        ae.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String cn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = aGj(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.DtD.get(paramString[i]);
        if (localt != null) {
          if (localt.CZC == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bu.isNullOrNil(localt.CZD)) && (!paramBoolean)))
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
  
  public final boolean eKR()
  {
    AppMethodBeat.i(70649);
    if ((this.DtD != null) && (this.DtD.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int eKS()
  {
    AppMethodBeat.i(70657);
    int i = this.DtE.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j eKT()
  {
    AppMethodBeat.i(70658);
    if (!this.DtE.isEmpty())
    {
      Object localObject = this.DtE.entrySet().iterator();
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
  
  public final List<com.tencent.mm.plugin.wallet.a.t> eKU()
  {
    AppMethodBeat.i(70668);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.eJf().uv(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.DtC.CYG;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.CZC != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.CZD)) || (bu.isNullOrNil(localt.CZD))) {
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
    public j DtF;
    public double DtG;
    public String dyP;
    public String wSo;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.DtF != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.DtF.CYV);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.wSo);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.DtG);
      ((StringBuffer)localObject).append("|bankType: " + this.dyP);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(70648);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */