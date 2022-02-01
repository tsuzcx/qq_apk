package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g
{
  private List<String> GTB;
  private List<com.tencent.mm.storage.w> GTC;
  List<com.tencent.mm.storage.w> GUi;
  private List<com.tencent.mm.storage.w> GUj;
  Map<String, Integer> GUk;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.GTB = null;
    this.GTC = null;
    this.GUi = new LinkedList();
    this.GUj = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<com.tencent.mm.storage.w> F(List<com.tencent.mm.storage.w> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      com.tencent.mm.storage.w localw;
      if (paramList.hasNext())
      {
        localw = (com.tencent.mm.storage.w)paramList.next();
        Object localObject = localw.awt();
        if (((List)localObject).size() == paramList1.size() + 1)
        {
          localObject = ((List)localObject).iterator();
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            str = (String)((Iterator)localObject).next();
          } while ((paramList1.contains(str)) || (u.se(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localw);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<com.tencent.mm.storage.w> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = u.aqG();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.storage.w)paramList.next();
      if (this.GUk.get(((com.tencent.mm.storage.w)localObject).field_chatroomname) != null)
      {
        boolean bool = ((com.tencent.mm.storage.w)localObject).ty(str1);
        localObject = ((com.tencent.mm.storage.w)localObject).awt().iterator();
        String str2;
        while (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if (localHashMap.get(str2) != null) {
            break label139;
          }
          i = 1;
          localHashMap.put(str2, Integer.valueOf(i));
        }
        continue;
        label139:
        int j = ((Integer)localHashMap.get(str2)).intValue();
        if (bool) {}
        for (int i = 2;; i = 1)
        {
          i += j;
          break;
        }
      }
    }
    paramList = paramList1.iterator();
    while (paramList.hasNext()) {
      localHashMap.remove((String)paramList.next());
    }
    localHashMap.remove(str1);
    paramList1 = new ArrayList(localHashMap.entrySet());
    Collections.sort(paramList1, new Comparator() {});
    paramList = new LinkedList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      paramList.add(((Map.Entry)paramList1.next()).getKey());
    }
    if (paramList.size() > paramInt) {}
    for (;;)
    {
      paramList = paramList.subList(0, paramInt);
      AppMethodBeat.o(102831);
      return paramList;
      paramInt = paramList.size();
    }
  }
  
  private void fbj()
  {
    AppMethodBeat.i(102833);
    if (this.GUj.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.g.afB().gda.eOh().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        com.tencent.mm.storage.w localw = new com.tencent.mm.storage.w();
        localw.convertFrom(localCursor);
        this.GUj.add(localw);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private static List<com.tencent.mm.storage.w> hR(List<String> paramList)
  {
    AppMethodBeat.i(102832);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(102832);
      return localLinkedList;
    }
    long l = bt.eGO();
    Object localObject = paramList.iterator();
    String str;
    for (paramList = "select chatroomname,memberlist from chatroom where memberCount < 50 "; ((Iterator)localObject).hasNext(); paramList = paramList + " and memberlist like \"%" + bt.aFQ(str) + "%\" ") {
      str = (String)((Iterator)localObject).next();
    }
    paramList = com.tencent.mm.kernel.g.afB().gda.eOh().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new com.tencent.mm.storage.w();
      ((com.tencent.mm.storage.w)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    ad.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(bt.vM(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  private List<String> hT(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(102835);
    if ((paramList == null) || (paramList.size() == 0))
    {
      paramList = new LinkedList();
      AppMethodBeat.o(102835);
      return paramList;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    Object localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(((com.tencent.mm.storage.w)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.g.afC();
    paramList = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().o((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      af localaf = new af();
      localaf.convertFrom(paramList);
      ((List)localObject).add(localaf);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (af)paramList.next();
      if (bt.isNullOrNil(((au)localObject).field_nickname)) {
        localLinkedList2.add(((au)localObject).field_username);
      } else {
        localLinkedList1.add(((au)localObject).field_username);
      }
    }
    Collections.sort(localLinkedList1, new Comparator() {});
    Collections.sort(localLinkedList2, new Comparator() {});
    if ((localLinkedList1.size() == 0) && (localLinkedList2.size() > 0))
    {
      paramList = localLinkedList2.subList(0, 1);
      AppMethodBeat.o(102835);
      return paramList;
    }
    int i;
    if ((localLinkedList2.size() == 0) && (localLinkedList1.size() > 0))
    {
      if (localLinkedList1.size() > 3) {}
      for (i = 3;; i = localLinkedList1.size())
      {
        paramList = localLinkedList1.subList(0, i);
        AppMethodBeat.o(102835);
        return paramList;
      }
    }
    paramList = new LinkedList();
    if ((localLinkedList1.size() > 0) && (localLinkedList2.size() > 0))
    {
      i = 0;
      while ((i < localLinkedList1.size()) && (i < 2))
      {
        paramList.add(localLinkedList1.get(i));
        i += 1;
      }
      paramList.add(localLinkedList2.get(0));
    }
    AppMethodBeat.o(102835);
    return paramList;
  }
  
  public final boolean aLp(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.GTB != null) && (this.GTB.contains(paramString)))
    {
      AppMethodBeat.o(102826);
      return true;
    }
    AppMethodBeat.o(102826);
    return false;
  }
  
  public final List<String> c(List<String> paramList, Map<String, List<m>> paramMap)
  {
    AppMethodBeat.i(102830);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    if (paramList.contains(u.aqG())) {
      paramList.remove(u.aqG());
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashMap.put((String)((Iterator)localObject).next(), Boolean.TRUE);
    }
    localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localIterator1 = ((List)((Iterator)localObject).next()).iterator();
      while (localIterator1.hasNext()) {
        localHashMap.put(((m)localIterator1.next()).roN, Boolean.TRUE);
      }
    }
    localHashMap.put(u.aqG(), Boolean.TRUE);
    localObject = new LinkedList();
    fbj();
    Iterator localIterator1 = this.GUj.iterator();
    label352:
    for (;;)
    {
      com.tencent.mm.storage.w localw;
      if (localIterator1.hasNext())
      {
        localw = (com.tencent.mm.storage.w)localIterator1.next();
        if (localw.awt().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localw.awt().iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (localHashMap.containsKey((String)localIterator2.next()));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label352;
          }
          ((List)localObject).add(localw);
          break;
          ad.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = hT((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor fbh()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.g.afC();
    android.database.Cursor localCursor2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().eLc();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.GTB != null)
    {
      localCursor1 = localCursor2;
      if (this.GTB.size() > 0)
      {
        com.tencent.mm.kernel.g.afC();
        localCursor1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().hc(this.GTB);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor fbi()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.g.afC();
    android.database.Cursor localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().eLc();
    if (this.GUi.size() > 0)
    {
      com.tencent.mm.kernel.g.afC();
      localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().gZ(hT(this.GUi));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void hQ(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.GTB == null)
    {
      if (paramList.contains(u.aqG())) {
        paramList.remove(u.aqG());
      }
      w.ib(paramList);
      w.hZ(paramList);
      List localList = hR(paramList);
      this.GTC = localList;
      if (localList.size() > 0)
      {
        this.GTB = a(localList, paramList, 10);
        this.GUi = F(this.GTC, paramList);
      }
      if ((this.GTB != null) && (this.GTB.size() < 10) && (paramList.size() > 1))
      {
        localList = hR(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.GTB);
          localLinkedList.addAll(paramList);
          this.GTB = a(localList, localLinkedList, 10 - this.GTB.size());
        }
      }
      if (this.GTB != null)
      {
        paramList = this.GTB;
        if (this.GTB.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        w.ia(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.GTB.size();
      }
    }
    if (this.GTC != null)
    {
      if (paramList.contains(u.aqG())) {
        paramList.remove(u.aqG());
      }
      this.GUi = F(this.GTC, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void hS(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.GUk != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.GUk = new HashMap();
    paramList = ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().f(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.GUk.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.GTB = null;
    this.GTC = null;
    this.GUi.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */