package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
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
  private List<String> Xqu;
  private List<ah> Xqv;
  List<ah> Xre;
  private List<ah> Xrf;
  Map<String, Integer> Xrg;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.Xqu = null;
    this.Xqv = null;
    this.Xre = new LinkedList();
    this.Xrf = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<ah> I(List<ah> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      ah localah;
      if (paramList.hasNext())
      {
        localah = (ah)paramList.next();
        Object localObject = localah.bjL();
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
          } while ((paramList1.contains(str)) || (z.PD(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localah);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<ah> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = z.bcZ();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ah)paramList.next();
      if (this.Xrg.get(((ah)localObject).field_chatroomname) != null)
      {
        boolean bool = ((ah)localObject).Rh(str1);
        localObject = ((ah)localObject).bjL().iterator();
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
  
  private void hUs()
  {
    AppMethodBeat.i(102833);
    if (this.Xrf.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.h.aHG().kcF.hBZ().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        ah localah = new ah();
        localah.convertFrom(localCursor);
        this.Xrf.add(localah);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private List<String> kA(List<ah> paramList)
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
      ((List)localObject).add(((ah)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.h.aHH();
    paramList = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().z((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      as localas = new as();
      localas.convertFrom(paramList);
      ((List)localObject).add(localas);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (as)paramList.next();
      if (Util.isNullOrNil(((ax)localObject).field_nickname)) {
        localLinkedList2.add(((ax)localObject).field_username);
      } else {
        localLinkedList1.add(((ax)localObject).field_username);
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
  
  private static List<ah> ky(List<String> paramList)
  {
    AppMethodBeat.i(102832);
    LinkedList localLinkedList = new LinkedList();
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(102832);
      return localLinkedList;
    }
    long l = Util.nowMilliSecond();
    Object localObject = paramList.iterator();
    String str;
    for (paramList = "select chatroomname,memberlist from chatroom where memberCount < 50 "; ((Iterator)localObject).hasNext(); paramList = paramList + " and memberlist like \"%" + Util.escapeSqlValue(str) + "%\" ") {
      str = (String)((Iterator)localObject).next();
    }
    paramList = com.tencent.mm.kernel.h.aHG().kcF.hBZ().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new ah();
      ((ah)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    Log.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  public final boolean bzT(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.Xqu != null) && (this.Xqu.contains(paramString)))
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
    if (paramList.contains(z.bcZ())) {
      paramList.remove(z.bcZ());
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
        localHashMap.put(((m)localIterator1.next()).BHS, Boolean.TRUE);
      }
    }
    localHashMap.put(z.bcZ(), Boolean.TRUE);
    localObject = new LinkedList();
    hUs();
    Iterator localIterator1 = this.Xrf.iterator();
    label353:
    for (;;)
    {
      ah localah;
      if (localIterator1.hasNext())
      {
        localah = (ah)localIterator1.next();
        if (localah.bjL().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localah.bjL().iterator();
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
            break label353;
          }
          ((List)localObject).add(localah);
          break;
          Log.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = kA((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor hUq()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.h.aHH();
    android.database.Cursor localCursor2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().hyA();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.Xqu != null)
    {
      localCursor1 = localCursor2;
      if (this.Xqu.size() > 0)
      {
        com.tencent.mm.kernel.h.aHH();
        localCursor1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jH(this.Xqu);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor hUr()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.h.aHH();
    android.database.Cursor localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().hyA();
    if (this.Xre.size() > 0)
    {
      com.tencent.mm.kernel.h.aHH();
      localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jE(kA(this.Xre));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void kx(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.Xqu == null)
    {
      if (paramList.contains(z.bcZ())) {
        paramList.remove(z.bcZ());
      }
      y.kI(paramList);
      y.kG(paramList);
      List localList = ky(paramList);
      this.Xqv = localList;
      if (localList.size() > 0)
      {
        this.Xqu = a(localList, paramList, 10);
        this.Xre = I(this.Xqv, paramList);
      }
      if ((this.Xqu != null) && (this.Xqu.size() < 10) && (paramList.size() > 1))
      {
        localList = ky(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.Xqu);
          localLinkedList.addAll(paramList);
          this.Xqu = a(localList, localLinkedList, 10 - this.Xqu.size());
        }
      }
      if (this.Xqu != null)
      {
        paramList = this.Xqu;
        if (this.Xqu.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        y.kH(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.Xqu.size();
      }
    }
    if (this.Xqv != null)
    {
      if (paramList.contains(z.bcZ())) {
        paramList.remove(z.bcZ());
      }
      this.Xre = I(this.Xqv, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void kz(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.Xrg != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.Xrg = new HashMap();
    paramList = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().h(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.Xrg.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.Xqu = null;
    this.Xqv = null;
    this.Xre.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */