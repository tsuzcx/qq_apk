package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
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
  private List<String> ItM;
  private List<x> ItN;
  List<x> Iuv;
  private List<x> Iuw;
  Map<String, Integer> Iux;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.ItM = null;
    this.ItN = null;
    this.Iuv = new LinkedList();
    this.Iuw = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<x> F(List<x> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      x localx;
      if (paramList.hasNext())
      {
        localx = (x)paramList.next();
        Object localObject = localx.aDl();
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
          } while ((paramList1.contains(str)) || (u.wh(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localx);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<x> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = u.axw();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (x)paramList.next();
      if (this.Iux.get(((x)localObject).field_chatroomname) != null)
      {
        boolean bool = ((x)localObject).xB(str1);
        localObject = ((x)localObject).aDl().iterator();
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
  
  private void fra()
  {
    AppMethodBeat.i(102833);
    if (this.Iuw.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.g.agR().ghG.fdL().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        x localx = new x();
        localx.convertFrom(localCursor);
        this.Iuw.add(localx);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private static List<x> ie(List<String> paramList)
  {
    AppMethodBeat.i(102832);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(102832);
      return localLinkedList;
    }
    long l = bs.eWj();
    Object localObject = paramList.iterator();
    String str;
    for (paramList = "select chatroomname,memberlist from chatroom where memberCount < 50 "; ((Iterator)localObject).hasNext(); paramList = paramList + " and memberlist like \"%" + bs.aLh(str) + "%\" ") {
      str = (String)((Iterator)localObject).next();
    }
    paramList = com.tencent.mm.kernel.g.agR().ghG.fdL().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new x();
      ((x)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    ac.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(bs.Ap(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  private List<String> ig(List<x> paramList)
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
      ((List)localObject).add(((x)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.g.agS();
    paramList = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().p((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      ai localai = new ai();
      localai.convertFrom(paramList);
      ((List)localObject).add(localai);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (ai)paramList.next();
      if (bs.isNullOrNil(((av)localObject).field_nickname)) {
        localLinkedList2.add(((av)localObject).field_username);
      } else {
        localLinkedList1.add(((av)localObject).field_username);
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
  
  public final boolean aQT(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.ItM != null) && (this.ItM.contains(paramString)))
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
    if (paramList.contains(u.axw())) {
      paramList.remove(u.axw());
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
        localHashMap.put(((m)localIterator1.next()).sxG, Boolean.TRUE);
      }
    }
    localHashMap.put(u.axw(), Boolean.TRUE);
    localObject = new LinkedList();
    fra();
    Iterator localIterator1 = this.Iuw.iterator();
    label352:
    for (;;)
    {
      x localx;
      if (localIterator1.hasNext())
      {
        localx = (x)localIterator1.next();
        if (localx.aDl().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localx.aDl().iterator();
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
          ((List)localObject).add(localx);
          break;
          ac.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = ig((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor fqY()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.g.agS();
    android.database.Cursor localCursor2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().faE();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.ItM != null)
    {
      localCursor1 = localCursor2;
      if (this.ItM.size() > 0)
      {
        com.tencent.mm.kernel.g.agS();
        localCursor1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().hp(this.ItM);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor fqZ()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.g.agS();
    android.database.Cursor localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().faE();
    if (this.Iuv.size() > 0)
    {
      com.tencent.mm.kernel.g.agS();
      localCursor = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().hm(ig(this.Iuv));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void id(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.ItM == null)
    {
      if (paramList.contains(u.axw())) {
        paramList.remove(u.axw());
      }
      w.io(paramList);
      w.im(paramList);
      List localList = ie(paramList);
      this.ItN = localList;
      if (localList.size() > 0)
      {
        this.ItM = a(localList, paramList, 10);
        this.Iuv = F(this.ItN, paramList);
      }
      if ((this.ItM != null) && (this.ItM.size() < 10) && (paramList.size() > 1))
      {
        localList = ie(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.ItM);
          localLinkedList.addAll(paramList);
          this.ItM = a(localList, localLinkedList, 10 - this.ItM.size());
        }
      }
      if (this.ItM != null)
      {
        paramList = this.ItM;
        if (this.ItM.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        w.in(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.ItM.size();
      }
    }
    if (this.ItN != null)
    {
      if (paramList.contains(u.axw())) {
        paramList.remove(u.axw());
      }
      this.Iuv = F(this.ItN, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void jdMethod_if(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.Iux != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.Iux = new HashMap();
    paramList = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().f(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.Iux.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.ItM = null;
    this.ItN = null;
    this.Iuv.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */