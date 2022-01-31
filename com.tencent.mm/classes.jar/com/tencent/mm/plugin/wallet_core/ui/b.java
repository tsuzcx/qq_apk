package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.i;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class b
{
  public h umI;
  private Map<String, com.tencent.mm.plugin.wallet.a.t> umJ;
  private Map<String, j> umK;
  
  public b(h paramh)
  {
    AppMethodBeat.i(47100);
    this.umI = null;
    this.umJ = null;
    this.umK = null;
    Assert.assertNotNull(paramh);
    this.umI = paramh;
    Kc();
    AppMethodBeat.o(47100);
  }
  
  private void Kc()
  {
    int j = 0;
    AppMethodBeat.i(47101);
    this.umJ = new HashMap();
    LinkedList localLinkedList = this.umI.tUg;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        this.umJ.put(((com.tencent.mm.plugin.wallet.a.t)localObject).tTZ, localObject);
        i += 1;
      }
    }
    ab.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.umK = new HashMap();
    if ((this.umI.tUh != null) && (this.umI.tUh.tUt != null))
    {
      localLinkedList = this.umI.tUh.tUt;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.umK.put(((j)localObject).tUv, localObject);
        i += 1;
      }
      AppMethodBeat.o(47101);
      return;
    }
    ab.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
    AppMethodBeat.o(47101);
  }
  
  public static boolean a(FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(47114);
    if (paramBankcard == null)
    {
      ab.w("MicroMsg.FavorLogicHelper", "curBankcard null");
      AppMethodBeat.o(47114);
      return true;
    }
    if ((paramFavorPayInfo != null) && (!bo.isNullOrNil(paramFavorPayInfo.uhU)))
    {
      if (paramFavorPayInfo.uhV != 0) {}
      for (i = 1; (i != 0) && (!bo.isNullOrNil(paramFavorPayInfo.uhW)) && (paramFavorPayInfo.uhZ != null) && (paramFavorPayInfo.uhZ.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(47114);
        return false;
      }
    }
    if (paramFavorPayInfo.uhV != 0) {}
    for (int i = 1; (i != 0) && (((!bo.isNullOrNil(paramFavorPayInfo.uhW)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.uhW))) || ((bo.isNullOrNil(paramFavorPayInfo.uhW)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(47114);
      return true;
    }
    AppMethodBeat.o(47114);
    return false;
  }
  
  public static String[] afE(String paramString)
  {
    AppMethodBeat.i(47110);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47110);
      return null;
    }
    paramString = paramString.split("-");
    AppMethodBeat.o(47110);
    return paramString;
  }
  
  public static List<Bankcard> bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(47115);
    ArrayList localArrayList1 = com.tencent.mm.plugin.wallet_core.model.t.cTN().nH(true);
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      AppMethodBeat.o(47115);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < localArrayList1.size()) {
      if (bo.isNullOrNil(paramString))
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
        AppMethodBeat.o(47115);
        return localArrayList2;
      }
      else
      {
        label140:
        paramInt = 0;
      }
    }
  }
  
  private static String dZ(List<String> paramList)
  {
    AppMethodBeat.i(47116);
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
    AppMethodBeat.o(47116);
    return paramList;
  }
  
  public final Map<String, b.a> afA(String paramString)
  {
    AppMethodBeat.i(47102);
    paramString = bI(paramString, false);
    AppMethodBeat.o(47102);
    return paramString;
  }
  
  public final Map<String, b.a> afB(String paramString)
  {
    AppMethodBeat.i(47104);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.umI.tUh != null) && (this.umI.tUh.tUt != null))
    {
      localLinkedList = this.umI.tUh.tUt;
      if (!this.umK.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.umK.get(paramString)).tUw;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.tUv;
          localObject = afE((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((com.tencent.mm.plugin.wallet.a.t)localObject).tVc == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((com.tencent.mm.plugin.wallet.a.t)localObject).tVf.size() <= 0)) {
            break label412;
          }
          localIterator = ((com.tencent.mm.plugin.wallet.a.t)localObject).tVf.iterator();
          while (localIterator.hasNext())
          {
            String str = aa.a((com.tencent.mm.bv.b)localIterator.next());
            b.a locala = (b.a)localHashMap.get(str);
            if ((locala == null) || (localj.tUw > locala.umL.tUw))
            {
              locala = new b.a();
              locala.umL = localj;
              locala.ppn = ((com.tencent.mm.plugin.wallet.a.t)localObject).ppn;
              locala.umM = (localj.tUw - d);
              locala.umN = ((com.tencent.mm.plugin.wallet.a.t)localObject).tVd;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.tUv.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.tUv)) {
            break;
          }
          localObject = localj.tUv.replace(paramString + "-", "");
          break;
        }
        i += 1;
        continue;
        ab.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(47104);
      return localHashMap;
    }
  }
  
  public final List<com.tencent.mm.plugin.wallet.a.t> afC(String paramString)
  {
    AppMethodBeat.i(47106);
    LinkedList localLinkedList = new LinkedList();
    if (this.umI.tUg != null)
    {
      paramString = afA(paramString);
      int i = 0;
      if (i < this.umI.tUg.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.umI.tUg.get(i);
        if (localt != null) {
          if (localt.tVc == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.tVd))) {
            localLinkedList.add(localt);
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      ab.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
    }
    AppMethodBeat.o(47106);
    return localLinkedList;
  }
  
  public final j afD(String paramString)
  {
    AppMethodBeat.i(47109);
    paramString = (j)this.umK.get(paramString);
    AppMethodBeat.o(47109);
    return paramString;
  }
  
  public final String afF(String paramString)
  {
    AppMethodBeat.i(47111);
    paramString = bJ(paramString, false);
    AppMethodBeat.o(47111);
    return paramString;
  }
  
  public final FavorPayInfo afG(String paramString)
  {
    AppMethodBeat.i(47113);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.umK.get(paramString) == null)
    {
      localFavorPayInfo.uhU = "0";
      if (this.umI != null) {
        localFavorPayInfo.uhX = this.umI.tUf;
      }
      localFavorPayInfo.uhV = 0;
      AppMethodBeat.o(47113);
      return localFavorPayInfo;
    }
    localFavorPayInfo.uhU = paramString;
    if (this.umI != null) {
      localFavorPayInfo.uhX = this.umI.tUf;
    }
    localFavorPayInfo.uhV = 0;
    paramString = afE(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(47113);
      return localFavorPayInfo;
    }
    int i = paramString.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.tVc != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.uhV = 1;
            if ((localt.tVf != null) && (localt.tVf.size() > 0))
            {
              localFavorPayInfo.uhZ = new LinkedList();
              Iterator localIterator = localt.tVf.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  com.tencent.mm.bv.b localb = (com.tencent.mm.bv.b)localIterator.next();
                  localFavorPayInfo.uhZ.add(aa.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bo.isNullOrNil(localt.tVd)) {
              break label286;
            }
            localFavorPayInfo.uhW = localt.tVd;
          }
        }
      }
      else
      {
        AppMethodBeat.o(47113);
        return localFavorPayInfo;
      }
      label286:
      i -= 1;
    }
  }
  
  public final String afH(String paramString)
  {
    AppMethodBeat.i(47117);
    ArrayList localArrayList2 = com.tencent.mm.plugin.wallet_core.model.t.cTN().nH(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = afE(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.tVc != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.tVd)) || (bo.isNullOrNil(localt.tVd))) {
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
      AppMethodBeat.o(47117);
      return "0";
    }
    paramString = dZ(localArrayList1);
    AppMethodBeat.o(47117);
    return paramString;
  }
  
  public final j bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47103);
    if ((!"0".equals(paramString)) && (this.umK.containsKey(paramString)))
    {
      paramString = (j)this.umK.get(paramString);
      AppMethodBeat.o(47103);
      return paramString;
    }
    paramString = this.umK.keySet().iterator();
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
        localObject1 = (j)this.umK.get(localObject1);
        if ((((j)localObject1).tUx == null) || (((j)localObject1).tUx.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).tUx.size();
        Iterator localIterator = ((j)localObject1).tUx.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.umJ.containsKey(((f)localObject2).tTZ))
          {
            localObject2 = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(((f)localObject2).tTZ);
            if ((!((com.tencent.mm.plugin.wallet.a.t)localObject2).tVd.equals("")) || (((com.tencent.mm.plugin.wallet.a.t)localObject2).tVf.size() != 0) || ((paramBoolean) && (((com.tencent.mm.plugin.wallet.a.t)localObject2).tVc != 0))) {
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
        AppMethodBeat.o(47103);
        return localObject1;
        AppMethodBeat.o(47103);
        return null;
      }
    }
  }
  
  public final Map<String, b.a> bI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47105);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.umI.tUh != null) && (this.umI.tUh.tUt != null))
    {
      localLinkedList = this.umI.tUh.tUt;
      if (!this.umK.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.umK.get(paramString)).tUw;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        b.a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.tUv;
          localObject = afE((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(localObject[0]);
            if (localObject != null) {
              if (((com.tencent.mm.plugin.wallet.a.t)localObject).tVc == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bo.isNullOrNil(((com.tencent.mm.plugin.wallet.a.t)localObject).tVd)) && (((com.tencent.mm.plugin.wallet.a.t)localObject).tVf.size() <= 0) && ((paramBoolean) || (!((com.tencent.mm.plugin.wallet.a.t)localObject).tVd.equalsIgnoreCase("CFT"))))
          {
            locala = (b.a)localHashMap.get(((com.tencent.mm.plugin.wallet.a.t)localObject).tVd);
            if ((locala == null) || (localj.tUw > locala.umL.tUw))
            {
              locala = new b.a();
              locala.umL = localj;
              locala.ppn = ((com.tencent.mm.plugin.wallet.a.t)localObject).ppn;
              locala.umM = (localj.tUw - d);
              locala.umN = ((com.tencent.mm.plugin.wallet.a.t)localObject).tVd;
              localHashMap.put(((com.tencent.mm.plugin.wallet.a.t)localObject).tVd, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.tUv.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.tUv)) {
            break label138;
          }
          localObject = localj.tUv.replace(paramString + "-", "");
          break label138;
        }
        ab.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(47105);
      return localHashMap;
    }
  }
  
  public final String bJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47112);
    paramString = afE(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)this.umJ.get(paramString[i]);
        if (localt != null) {
          if (localt.tVc == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bo.isNullOrNil(localt.tVd)) && (!paramBoolean)))
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
        AppMethodBeat.o(47112);
        return "0";
      }
      paramString = localStringBuilder.delete(localStringBuilder.length() - 1, localStringBuilder.length()).toString();
      AppMethodBeat.o(47112);
      return paramString;
    }
    AppMethodBeat.o(47112);
    return "0";
  }
  
  public final boolean cVm()
  {
    AppMethodBeat.i(47099);
    if ((this.umJ != null) && (this.umJ.size() > 0))
    {
      AppMethodBeat.o(47099);
      return true;
    }
    AppMethodBeat.o(47099);
    return false;
  }
  
  public final int cVn()
  {
    AppMethodBeat.i(47107);
    int i = this.umK.size();
    AppMethodBeat.o(47107);
    return i;
  }
  
  public final j cVo()
  {
    AppMethodBeat.i(47108);
    if (!this.umK.isEmpty())
    {
      Object localObject = this.umK.entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (j)((Map.Entry)((Iterator)localObject).next()).getValue();
        AppMethodBeat.o(47108);
        return localObject;
      }
    }
    AppMethodBeat.o(47108);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.wallet.a.t> cVp()
  {
    AppMethodBeat.i(47118);
    Object localObject = com.tencent.mm.plugin.wallet_core.model.t.cTN().nH(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.umI.tUg;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        com.tencent.mm.plugin.wallet.a.t localt = (com.tencent.mm.plugin.wallet.a.t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.tVc != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.tVd)) || (bo.isNullOrNil(localt.tVd))) {
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
    AppMethodBeat.o(47118);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.b
 * JD-Core Version:    0.7.0.1
 */