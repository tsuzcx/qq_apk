package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
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
  public h Ajk;
  private Map<String, t> Ajl;
  private Map<String, j> Ajm;
  
  public d(h paramh)
  {
    AppMethodBeat.i(70650);
    this.Ajk = null;
    this.Ajl = null;
    this.Ajm = null;
    Assert.assertNotNull(paramh);
    this.Ajk = paramh;
    VL();
    AppMethodBeat.o(70650);
  }
  
  private void VL()
  {
    int j = 0;
    AppMethodBeat.i(70651);
    this.Ajl = new HashMap();
    LinkedList localLinkedList = this.Ajk.zOs;
    int i;
    Object localObject;
    if (localLinkedList != null)
    {
      i = 0;
      while (i < localLinkedList.size())
      {
        localObject = (t)localLinkedList.get(i);
        this.Ajl.put(((t)localObject).zOl, localObject);
        i += 1;
      }
    }
    ad.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
    this.Ajm = new HashMap();
    if ((this.Ajk.zOt != null) && (this.Ajk.zOt.zOF != null))
    {
      localLinkedList = this.Ajk.zOt.zOF;
      i = j;
      while (i < localLinkedList.size())
      {
        localObject = (j)localLinkedList.get(i);
        this.Ajm.put(((j)localObject).zOH, localObject);
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
    if ((paramFavorPayInfo != null) && (!bt.isNullOrNil(paramFavorPayInfo.Aeb)))
    {
      if (paramFavorPayInfo.Aec != 0) {}
      for (i = 1; (i != 0) && (!bt.isNullOrNil(paramFavorPayInfo.Aed)) && (paramFavorPayInfo.Aeg != null) && (paramFavorPayInfo.Aeg.contains(paramBankcard.field_bindSerial)); i = 0)
      {
        AppMethodBeat.o(70664);
        return false;
      }
    }
    if (paramFavorPayInfo.Aec != 0) {}
    for (int i = 1; (i != 0) && (((!bt.isNullOrNil(paramFavorPayInfo.Aed)) && (paramBankcard.field_bankcardType != null) && (!paramBankcard.field_bankcardType.equals(paramFavorPayInfo.Aed))) || ((bt.isNullOrNil(paramFavorPayInfo.Aed)) && (paramBankcard.field_bankcardType.equals("CFT")))); i = 0)
    {
      AppMethodBeat.o(70664);
      return true;
    }
    AppMethodBeat.o(70664);
    return false;
  }
  
  public static String[] aun(String paramString)
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
  
  public static List<Bankcard> cf(int paramInt, String paramString)
  {
    AppMethodBeat.i(70665);
    ArrayList localArrayList1 = s.ecc().sC(true);
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
  
  private static String gp(List<String> paramList)
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
  
  public final Map<String, a> auj(String paramString)
  {
    AppMethodBeat.i(70652);
    paramString = bT(paramString, false);
    AppMethodBeat.o(70652);
    return paramString;
  }
  
  public final Map<String, a> auk(String paramString)
  {
    AppMethodBeat.i(70654);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.Ajk.zOt != null) && (this.Ajk.zOt.zOF != null))
    {
      localLinkedList = this.Ajk.zOt.zOF;
      if (!this.Ajm.containsKey(paramString)) {
        break label437;
      }
    }
    label406:
    label412:
    label437:
    for (double d = ((j)this.Ajm.get(paramString)).zOI;; d = 0.0D)
    {
      int i = 0;
      while (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        Iterator localIterator = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.zOH;
          localObject = aun((String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label412;
          }
          localObject = (t)this.Ajl.get(localObject[0]);
          if (localObject == null) {
            break label412;
          }
          if (((t)localObject).zPo == 0) {
            break label406;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (((t)localObject).zPr.size() <= 0)) {
            break label412;
          }
          localIterator = ((t)localObject).zPr.iterator();
          while (localIterator.hasNext())
          {
            String str = z.a((b)localIterator.next());
            a locala = (a)localHashMap.get(str);
            if ((locala == null) || (localj.zOI > locala.Ajn.zOI))
            {
              locala = new a();
              locala.Ajn = localj;
              locala.uon = ((t)localObject).uon;
              locala.Ajo = (localj.zOI - d);
              locala.don = ((t)localObject).zPp;
              localHashMap.put(str, locala);
            }
          }
          localObject = localIterator;
          if (!localj.zOH.startsWith(paramString)) {
            break;
          }
          localObject = localIterator;
          if (paramString.equals(localj.zOH)) {
            break;
          }
          localObject = localj.zOH.replace(paramString + "-", "");
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
  
  public final List<t> aul(String paramString)
  {
    AppMethodBeat.i(70656);
    LinkedList localLinkedList = new LinkedList();
    if (this.Ajk.zOs != null)
    {
      paramString = auj(paramString);
      int i = 0;
      if (i < this.Ajk.zOs.size())
      {
        t localt = (t)this.Ajk.zOs.get(i);
        if (localt != null) {
          if (localt.zPo == 0) {
            break label113;
          }
        }
        label113:
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (paramString.containsKey(localt.zPp))) {
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
  
  public final j aum(String paramString)
  {
    AppMethodBeat.i(70659);
    paramString = (j)this.Ajm.get(paramString);
    AppMethodBeat.o(70659);
    return paramString;
  }
  
  public final String auo(String paramString)
  {
    AppMethodBeat.i(70661);
    paramString = bU(paramString, false);
    AppMethodBeat.o(70661);
    return paramString;
  }
  
  public final FavorPayInfo aup(String paramString)
  {
    AppMethodBeat.i(70663);
    FavorPayInfo localFavorPayInfo = new FavorPayInfo();
    if (this.Ajm.get(paramString) == null)
    {
      localFavorPayInfo.Aeb = "0";
      if (this.Ajk != null) {
        localFavorPayInfo.Aee = this.Ajk.zOr;
      }
      localFavorPayInfo.Aec = 0;
      AppMethodBeat.o(70663);
      return localFavorPayInfo;
    }
    localFavorPayInfo.Aeb = paramString;
    if (this.Ajk != null) {
      localFavorPayInfo.Aee = this.Ajk.zOr;
    }
    localFavorPayInfo.Aec = 0;
    paramString = aun(paramString);
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
        t localt = (t)this.Ajl.get(paramString[i]);
        if (localt != null)
        {
          int j;
          if (localt.zPo != 0) {
            j = 1;
          }
          while (j != 0)
          {
            localFavorPayInfo.Aec = 1;
            if ((localt.zPr != null) && (localt.zPr.size() > 0))
            {
              localFavorPayInfo.Aeg = new LinkedList();
              Iterator localIterator = localt.zPr.iterator();
              for (;;)
              {
                if (localIterator.hasNext())
                {
                  b localb = (b)localIterator.next();
                  localFavorPayInfo.Aeg.add(z.a(localb));
                  continue;
                  j = 0;
                  break;
                }
              }
            }
            if (bt.isNullOrNil(localt.zPp)) {
              break label286;
            }
            localFavorPayInfo.Aed = localt.zPp;
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
  
  public final String auq(String paramString)
  {
    AppMethodBeat.i(70667);
    ArrayList localArrayList2 = s.ecc().sC(true);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < localArrayList2.size())
    {
      localHashMap.put(((Bankcard)localArrayList2.get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    paramString = aun(paramString);
    if (paramString != null)
    {
      i = 0;
      if (i < paramString.length)
      {
        localArrayList2 = paramString[i];
        t localt = (t)this.Ajl.get(localArrayList2);
        int j;
        if (localt != null) {
          if (localt.zPo != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label180;
            }
            if ((localHashMap.containsKey(localt.zPp)) || (bt.isNullOrNil(localt.zPp))) {
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
    paramString = gp(localArrayList1);
    AppMethodBeat.o(70667);
    return paramString;
  }
  
  public final j bS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70653);
    if ((!"0".equals(paramString)) && (this.Ajm.containsKey(paramString)))
    {
      paramString = (j)this.Ajm.get(paramString);
      AppMethodBeat.o(70653);
      return paramString;
    }
    paramString = this.Ajm.keySet().iterator();
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
        localObject1 = (j)this.Ajm.get(localObject1);
        if ((((j)localObject1).zOJ == null) || (((j)localObject1).zOJ.size() == 0)) {
          continue;
        }
        j = ((j)localObject1).zOJ.size();
        Iterator localIterator = ((j)localObject1).zOJ.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Object localObject2 = (f)localIterator.next();
          if (this.Ajl.containsKey(((f)localObject2).zOl))
          {
            localObject2 = (t)this.Ajl.get(((f)localObject2).zOl);
            if ((!((t)localObject2).zPp.equals("")) || (((t)localObject2).zPr.size() != 0) || ((paramBoolean) && (((t)localObject2).zPo != 0))) {
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
  
  public final Map<String, a> bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70655);
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList;
    if ((this.Ajk.zOt != null) && (this.Ajk.zOt.zOF != null))
    {
      localLinkedList = this.Ajk.zOt.zOF;
      if (!this.Ajm.containsKey(paramString)) {
        break label435;
      }
    }
    label138:
    label412:
    label435:
    for (double d = ((j)this.Ajm.get(paramString)).zOI;; d = 0.0D)
    {
      int i = 0;
      if (i < localLinkedList.size())
      {
        j localj = (j)localLinkedList.get(i);
        a locala = null;
        Object localObject;
        if ((paramString.equals("0")) && (!localj.equals("0")))
        {
          localObject = localj.zOH;
          localObject = aun((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            localObject = (t)this.Ajl.get(localObject[0]);
            if (localObject != null) {
              if (((t)localObject).zPo == 0) {
                break label412;
              }
            }
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j != 0) && (!bt.isNullOrNil(((t)localObject).zPp)) && (((t)localObject).zPr.size() <= 0) && ((paramBoolean) || (!((t)localObject).zPp.equalsIgnoreCase("CFT"))))
          {
            locala = (a)localHashMap.get(((t)localObject).zPp);
            if ((locala == null) || (localj.zOI > locala.Ajn.zOI))
            {
              locala = new a();
              locala.Ajn = localj;
              locala.uon = ((t)localObject).uon;
              locala.Ajo = (localj.zOI - d);
              locala.don = ((t)localObject).zPp;
              localHashMap.put(((t)localObject).zPp, locala);
            }
          }
          i += 1;
          break;
          localObject = locala;
          if (!localj.zOH.startsWith(paramString)) {
            break label138;
          }
          localObject = locala;
          if (paramString.equals(localj.zOH)) {
            break label138;
          }
          localObject = localj.zOH.replace(paramString + "-", "");
          break label138;
        }
        ad.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
      }
      AppMethodBeat.o(70655);
      return localHashMap;
    }
  }
  
  public final String bU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70662);
    paramString = aun(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length)
      {
        t localt = (t)this.Ajl.get(paramString[i]);
        if (localt != null) {
          if (localt.zPo == 0) {
            break label122;
          }
        }
        label122:
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || ((bt.isNullOrNil(localt.zPp)) && (!paramBoolean)))
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
  
  public final boolean edI()
  {
    AppMethodBeat.i(70649);
    if ((this.Ajl != null) && (this.Ajl.size() > 0))
    {
      AppMethodBeat.o(70649);
      return true;
    }
    AppMethodBeat.o(70649);
    return false;
  }
  
  public final int edJ()
  {
    AppMethodBeat.i(70657);
    int i = this.Ajm.size();
    AppMethodBeat.o(70657);
    return i;
  }
  
  public final j edK()
  {
    AppMethodBeat.i(70658);
    if (!this.Ajm.isEmpty())
    {
      Object localObject = this.Ajm.entrySet().iterator();
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
  
  public final List<t> edL()
  {
    AppMethodBeat.i(70668);
    Object localObject = s.ecc().sC(true);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localHashMap.put(((Bankcard)((ArrayList)localObject).get(i)).field_bankcardType, Integer.valueOf(0));
      i += 1;
    }
    localObject = new LinkedList();
    LinkedList localLinkedList = this.Ajk.zOs;
    if (localLinkedList != null)
    {
      i = 0;
      if (i < localLinkedList.size())
      {
        t localt = (t)localLinkedList.get(i);
        int j;
        if (localt != null) {
          if (localt.zPo != 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label179;
            }
            if ((localHashMap.containsKey(localt.zPp)) || (bt.isNullOrNil(localt.zPp))) {
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
    public j Ajn;
    public double Ajo;
    public String don;
    public String uon;
    
    public final String toString()
    {
      AppMethodBeat.i(70648);
      Object localObject = new StringBuffer();
      if (this.Ajn != null) {
        ((StringBuffer)localObject).append("|faovrComposeId: " + this.Ajn.zOH);
      }
      ((StringBuffer)localObject).append("|bankName: " + this.uon);
      ((StringBuffer)localObject).append("|bankFavorAmount: " + this.Ajo);
      ((StringBuffer)localObject).append("|bankType: " + this.don);
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