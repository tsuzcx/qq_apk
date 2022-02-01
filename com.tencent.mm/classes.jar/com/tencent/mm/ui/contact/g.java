package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  private List<String> KGM;
  private List<ac> KGN;
  List<ac> KHv;
  private List<ac> KHw;
  Map<String, Integer> KHx;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.KGM = null;
    this.KGN = null;
    this.KHv = new LinkedList();
    this.KHw = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<ac> G(List<ac> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      ac localac;
      if (paramList.hasNext())
      {
        localac = (ac)paramList.next();
        Object localObject = localac.aGE();
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
          } while ((paramList1.contains(str)) || (v.zK(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localac);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<ac> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = v.aAC();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ac)paramList.next();
      if (this.KHx.get(((ac)localObject).field_chatroomname) != null)
      {
        boolean bool = ((ac)localObject).Bj(str1);
        localObject = ((ac)localObject).aGE().iterator();
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
  
  private void fMf()
  {
    AppMethodBeat.i(102833);
    if (this.KHw.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.g.ajR().gDX.fxU().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        ac localac = new ac();
        localac.convertFrom(localCursor);
        this.KHw.add(localac);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private static List<ac> iA(List<String> paramList)
  {
    AppMethodBeat.i(102832);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(102832);
      return localLinkedList;
    }
    long l = bu.fpO();
    Object localObject = paramList.iterator();
    String str;
    for (paramList = "select chatroomname,memberlist from chatroom where memberCount < 50 "; ((Iterator)localObject).hasNext(); paramList = paramList + " and memberlist like \"%" + bu.aSk(str) + "%\" ") {
      str = (String)((Iterator)localObject).next();
    }
    paramList = com.tencent.mm.kernel.g.ajR().gDX.fxU().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new ac();
      ((ac)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    ae.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(bu.DD(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  private List<String> iC(List<ac> paramList)
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
      ((List)localObject).add(((ac)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.g.ajS();
    paramList = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().r((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      an localan = new an();
      localan.convertFrom(paramList);
      ((List)localObject).add(localan);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (an)paramList.next();
      if (bu.isNullOrNil(((aw)localObject).field_nickname)) {
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
  
  public final boolean aYp(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.KGM != null) && (this.KGM.contains(paramString)))
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
    if (paramList.contains(v.aAC())) {
      paramList.remove(v.aAC());
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
        localHashMap.put(((m)localIterator1.next()).tEY, Boolean.TRUE);
      }
    }
    localHashMap.put(v.aAC(), Boolean.TRUE);
    localObject = new LinkedList();
    fMf();
    Iterator localIterator1 = this.KHw.iterator();
    label352:
    for (;;)
    {
      ac localac;
      if (localIterator1.hasNext())
      {
        localac = (ac)localIterator1.next();
        if (localac.aGE().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localac.aGE().iterator();
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
          ((List)localObject).add(localac);
          break;
          ae.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = iC((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor fMd()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.g.ajS();
    android.database.Cursor localCursor2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().fuH();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.KGM != null)
    {
      localCursor1 = localCursor2;
      if (this.KGM.size() > 0)
      {
        com.tencent.mm.kernel.g.ajS();
        localCursor1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hL(this.KGM);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor fMe()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.g.ajS();
    android.database.Cursor localCursor = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().fuH();
    if (this.KHv.size() > 0)
    {
      com.tencent.mm.kernel.g.ajS();
      localCursor = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hI(iC(this.KHv));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void iB(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.KHx != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.KHx = new HashMap();
    paramList = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().f(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.KHx.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void iz(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.KGM == null)
    {
      if (paramList.contains(v.aAC())) {
        paramList.remove(v.aAC());
      }
      w.iK(paramList);
      w.iI(paramList);
      List localList = iA(paramList);
      this.KGN = localList;
      if (localList.size() > 0)
      {
        this.KGM = a(localList, paramList, 10);
        this.KHv = G(this.KGN, paramList);
      }
      if ((this.KGM != null) && (this.KGM.size() < 10) && (paramList.size() > 1))
      {
        localList = iA(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.KGM);
          localLinkedList.addAll(paramList);
          this.KGM = a(localList, localLinkedList, 10 - this.KGM.size());
        }
      }
      if (this.KGM != null)
      {
        paramList = this.KGM;
        if (this.KGM.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        w.iJ(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.KGM.size();
      }
    }
    if (this.KGN != null)
    {
      if (paramList.contains(v.aAC())) {
        paramList.remove(v.aAC());
      }
      this.KHv = G(this.KGN, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.KGM = null;
    this.KGN = null;
    this.KHv.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */