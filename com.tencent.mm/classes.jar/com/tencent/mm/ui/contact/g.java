package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  private List<String> Kks;
  private List<ab> Kkt;
  List<ab> Klb;
  private List<ab> Klc;
  Map<String, Integer> Kld;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.Kks = null;
    this.Kkt = null;
    this.Klb = new LinkedList();
    this.Klc = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<ab> H(List<ab> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      ab localab;
      if (paramList.hasNext())
      {
        localab = (ab)paramList.next();
        Object localObject = localab.aGo();
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
          } while ((paramList1.contains(str)) || (u.za(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localab);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<ab> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = u.aAm();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ab)paramList.next();
      if (this.Kld.get(((ab)localObject).field_chatroomname) != null)
      {
        boolean bool = ((ab)localObject).Az(str1);
        localObject = ((ab)localObject).aGo().iterator();
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
  
  private void fHN()
  {
    AppMethodBeat.i(102833);
    if (this.Klc.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.g.ajC().gBq.ftT().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        ab localab = new ab();
        localab.convertFrom(localCursor);
        this.Klc.add(localab);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private static List<ab> iq(List<String> paramList)
  {
    AppMethodBeat.i(102832);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(102832);
      return localLinkedList;
    }
    long l = bt.flT();
    Object localObject = paramList.iterator();
    String str;
    for (paramList = "select chatroomname,memberlist from chatroom where memberCount < 50 "; ((Iterator)localObject).hasNext(); paramList = paramList + " and memberlist like \"%" + bt.aQN(str) + "%\" ") {
      str = (String)((Iterator)localObject).next();
    }
    paramList = com.tencent.mm.kernel.g.ajC().gBq.ftT().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new ab();
      ((ab)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    ad.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(bt.Df(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  private List<String> is(List<ab> paramList)
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
      ((List)localObject).add(((ab)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.g.ajD();
    paramList = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().r((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      am localam = new am();
      localam.convertFrom(paramList);
      ((List)localObject).add(localam);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (am)paramList.next();
      if (bt.isNullOrNil(((aw)localObject).field_nickname)) {
        localLinkedList2.add(((aw)localObject).field_username);
      } else {
        localLinkedList1.add(((aw)localObject).field_username);
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
  
  public final boolean aWO(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.Kks != null) && (this.Kks.contains(paramString)))
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
    if (paramList.contains(u.aAm())) {
      paramList.remove(u.aAm());
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
        localHashMap.put(((m)localIterator1.next()).tuh, Boolean.TRUE);
      }
    }
    localHashMap.put(u.aAm(), Boolean.TRUE);
    localObject = new LinkedList();
    fHN();
    Iterator localIterator1 = this.Klc.iterator();
    label352:
    for (;;)
    {
      ab localab;
      if (localIterator1.hasNext())
      {
        localab = (ab)localIterator1.next();
        if (localab.aGo().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localab.aGo().iterator();
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
          ((List)localObject).add(localab);
          break;
          ad.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = is((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor fHL()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.g.ajD();
    android.database.Cursor localCursor2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().fqH();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.Kks != null)
    {
      localCursor1 = localCursor2;
      if (this.Kks.size() > 0)
      {
        com.tencent.mm.kernel.g.ajD();
        localCursor1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hB(this.Kks);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor fHM()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.g.ajD();
    android.database.Cursor localCursor = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().fqH();
    if (this.Klb.size() > 0)
    {
      com.tencent.mm.kernel.g.ajD();
      localCursor = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hy(is(this.Klb));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void ip(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.Kks == null)
    {
      if (paramList.contains(u.aAm())) {
        paramList.remove(u.aAm());
      }
      w.iA(paramList);
      w.iy(paramList);
      List localList = iq(paramList);
      this.Kkt = localList;
      if (localList.size() > 0)
      {
        this.Kks = a(localList, paramList, 10);
        this.Klb = H(this.Kkt, paramList);
      }
      if ((this.Kks != null) && (this.Kks.size() < 10) && (paramList.size() > 1))
      {
        localList = iq(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.Kks);
          localLinkedList.addAll(paramList);
          this.Kks = a(localList, localLinkedList, 10 - this.Kks.size());
        }
      }
      if (this.Kks != null)
      {
        paramList = this.Kks;
        if (this.Kks.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        w.iz(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.Kks.size();
      }
    }
    if (this.Kkt != null)
    {
      if (paramList.contains(u.aAm())) {
        paramList.remove(u.aAm());
      }
      this.Klb = H(this.Kkt, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void ir(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.Kld != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.Kld = new HashMap();
    paramList = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().f(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.Kld.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.Kks = null;
    this.Kkt = null;
    this.Klb.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */