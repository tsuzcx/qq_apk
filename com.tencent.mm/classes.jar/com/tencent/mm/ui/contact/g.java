package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
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
  private List<String> afbV;
  private List<aj> afbW;
  List<aj> afcE;
  private List<aj> afcF;
  Map<String, Integer> afcG;
  
  public g()
  {
    AppMethodBeat.i(102824);
    this.afbV = null;
    this.afbW = null;
    this.afcE = new LinkedList();
    this.afcF = new LinkedList();
    AppMethodBeat.o(102824);
  }
  
  private static List<aj> V(List<aj> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(102836);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label143:
    for (;;)
    {
      aj localaj;
      if (paramList.hasNext())
      {
        localaj = (aj)paramList.next();
        Object localObject = localaj.bHw();
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
          } while ((paramList1.contains(str)) || (z.Iy(str)));
        }
      }
      else
      {
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label143;
          }
          localLinkedList.add(localaj);
          break;
          AppMethodBeat.o(102836);
          return localLinkedList;
        }
      }
    }
  }
  
  private List<String> a(List<aj> paramList, List<String> paramList1, int paramInt)
  {
    AppMethodBeat.i(102831);
    HashMap localHashMap = new HashMap();
    String str1 = z.bAM();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (aj)paramList.next();
      if (this.afcG.get(((aj)localObject).field_chatroomname) != null)
      {
        boolean bool = ((aj)localObject).Jf(str1);
        localObject = ((aj)localObject).bHw().iterator();
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
      paramList.add((String)((Map.Entry)paramList1.next()).getKey());
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
  
  private void jyi()
  {
    AppMethodBeat.i(102833);
    if (this.afcF.size() == 0)
    {
      com.tencent.wcdb.Cursor localCursor = com.tencent.mm.kernel.h.baE().mCN.jef().rawQuery("select chatroomname,memberlist from chatroom where chatroomname like '%@chatroom'", null);
      while (localCursor.moveToNext())
      {
        aj localaj = new aj();
        localaj.convertFrom(localCursor);
        this.afcF.add(localaj);
      }
      localCursor.close();
    }
    AppMethodBeat.o(102833);
  }
  
  private static List<aj> nO(List<String> paramList)
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
    paramList = com.tencent.mm.kernel.h.baE().mCN.jef().rawQuery(paramList, null);
    while (paramList.moveToNext())
    {
      localObject = new aj();
      ((aj)localObject).convertFrom(paramList);
      localLinkedList.add(localObject);
    }
    paramList.close();
    Log.i("MicroMsg.ContactRecommendHelper", "getChatroomByMembername cnt:%d time:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(Util.milliSecondsToNow(l)) });
    AppMethodBeat.o(102832);
    return localLinkedList;
  }
  
  private List<String> nQ(List<aj> paramList)
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
      ((List)localObject).add(((aj)paramList.next()).field_chatroomname);
    }
    com.tencent.mm.kernel.h.baF();
    paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().O((List)localObject, false);
    localObject = new LinkedList();
    while (paramList.moveToNext())
    {
      au localau = new au();
      localau.convertFrom(paramList);
      ((List)localObject).add(localau);
    }
    paramList.close();
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      localObject = (au)paramList.next();
      if (Util.isNullOrNil(((az)localObject).field_nickname)) {
        localLinkedList2.add(((az)localObject).field_username);
      } else {
        localLinkedList1.add(((az)localObject).field_username);
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
        paramList.add((String)localLinkedList1.get(i));
        i += 1;
      }
      paramList.add((String)localLinkedList2.get(0));
    }
    AppMethodBeat.o(102835);
    return paramList;
  }
  
  public final boolean bBJ(String paramString)
  {
    AppMethodBeat.i(102826);
    if ((this.afbV != null) && (this.afbV.contains(paramString)))
    {
      AppMethodBeat.o(102826);
      return true;
    }
    AppMethodBeat.o(102826);
    return false;
  }
  
  public final List<String> d(List<String> paramList, Map<String, List<o>> paramMap)
  {
    AppMethodBeat.i(102830);
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    if (paramList.contains(z.bAM())) {
      paramList.remove(z.bAM());
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
        localHashMap.put(((o)localIterator1.next()).Hsz, Boolean.TRUE);
      }
    }
    localHashMap.put(z.bAM(), Boolean.TRUE);
    localObject = new LinkedList();
    jyi();
    Iterator localIterator1 = this.afcF.iterator();
    label352:
    for (;;)
    {
      aj localaj;
      if (localIterator1.hasNext())
      {
        localaj = (aj)localIterator1.next();
        if (localaj.bHw().size() == paramMap.size() + paramList.size() + 1)
        {
          Iterator localIterator2 = localaj.bHw().iterator();
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
          ((List)localObject).add(localaj);
          break;
          Log.i("MicroMsg.ContactRecommendHelper", "getSearchRecommendChatroom, time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          paramList = nQ((List)localObject);
          AppMethodBeat.o(102830);
          return paramList;
        }
      }
    }
  }
  
  public final android.database.Cursor jyg()
  {
    AppMethodBeat.i(102828);
    com.tencent.mm.kernel.h.baF();
    android.database.Cursor localCursor2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().jaF();
    android.database.Cursor localCursor1 = localCursor2;
    if (this.afbV != null)
    {
      localCursor1 = localCursor2;
      if (this.afbV.size() > 0)
      {
        com.tencent.mm.kernel.h.baF();
        localCursor1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().mU(this.afbV);
      }
    }
    AppMethodBeat.o(102828);
    return localCursor1;
  }
  
  public final android.database.Cursor jyh()
  {
    AppMethodBeat.i(102829);
    com.tencent.mm.kernel.h.baF();
    android.database.Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().jaF();
    if (this.afcE.size() > 0)
    {
      com.tencent.mm.kernel.h.baF();
      localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().mR(nQ(this.afcE));
    }
    AppMethodBeat.o(102829);
    return localCursor;
  }
  
  public final void nN(List<String> paramList)
  {
    int i = 6;
    AppMethodBeat.i(102827);
    if (this.afbV == null)
    {
      if (paramList.contains(z.bAM())) {
        paramList.remove(z.bAM());
      }
      y.nZ(paramList);
      y.nX(paramList);
      List localList = nO(paramList);
      this.afbW = localList;
      if (localList.size() > 0)
      {
        this.afbV = a(localList, paramList, 10);
        this.afcE = V(this.afbW, paramList);
      }
      if ((this.afbV != null) && (this.afbV.size() < 10) && (paramList.size() > 1))
      {
        localList = nO(paramList.subList(paramList.size() - 1, paramList.size()));
        if (localList.size() > 0)
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.addAll(this.afbV);
          localLinkedList.addAll(paramList);
          this.afbV = a(localList, localLinkedList, 10 - this.afbV.size());
        }
      }
      if (this.afbV != null)
      {
        paramList = this.afbV;
        if (this.afbV.size() <= 6) {
          break label246;
        }
      }
      for (;;)
      {
        y.nY(paramList.subList(0, i));
        AppMethodBeat.o(102827);
        return;
        label246:
        i = this.afbV.size();
      }
    }
    if (this.afbW != null)
    {
      if (paramList.contains(z.bAM())) {
        paramList.remove(z.bAM());
      }
      this.afcE = V(this.afbW, paramList);
    }
    AppMethodBeat.o(102827);
  }
  
  public final void nP(List<String> paramList)
  {
    AppMethodBeat.i(102834);
    if (this.afcG != null)
    {
      AppMethodBeat.o(102834);
      return;
    }
    this.afcG = new HashMap();
    paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().p(paramList, 0, 200);
    int i = 1;
    int j = paramList.getColumnIndex("username");
    while (paramList.moveToNext())
    {
      this.afcG.put(paramList.getString(j), Integer.valueOf(i));
      i += 1;
    }
    paramList.close();
    AppMethodBeat.o(102834);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(102825);
    this.afbV = null;
    this.afbW = null;
    this.afcE.clear();
    AppMethodBeat.o(102825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.g
 * JD-Core Version:    0.7.0.1
 */