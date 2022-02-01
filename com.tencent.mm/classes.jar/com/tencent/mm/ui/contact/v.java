package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v
  extends o
{
  private g ItL;
  private List<Integer> IwK;
  protected l IwL;
  private List<String> Ixl;
  private Map<String, List<m>> Ixm;
  private Map<String, Boolean> Ixn;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> Ixo;
  private List<String> Ixp;
  private List<String> Ixq;
  private List<String> Ixr;
  protected int Ixs;
  private Map<String, LinkedList<String>> Ixt;
  private int[] Ixu;
  private Cursor Ixv;
  private Map<Integer, String> Ixw;
  private Map<String, Integer> Ixx;
  private int Ixy;
  private int Ixz;
  private int count;
  private List<String> fzw;
  private ao handler;
  private int qpm;
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.Ixl = new LinkedList();
    this.Ixm = null;
    this.Ixn = new HashMap();
    this.Ixo = null;
    this.Ixs = 0;
    this.Ixt = new HashMap();
    this.Ixw = new HashMap();
    this.Ixx = new HashMap();
    this.Ixy = 0;
    this.ItL = new g();
    this.handler = new ao(Looper.getMainLooper());
    this.IwL = new l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.k paramAnonymousk)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousk.bPH)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((v.a(v.this) == null) || (paramAnonymousk.sxM == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.a(v.this, paramAnonymousk.syK);
          String str = paramAnonymousk.sxM.syk;
          if (v.b(v.this).get(str) == null)
          {
            v.b(v.this).put(str, new LinkedList());
            if (v.c(v.this).get(str) == null) {
              v.c(v.this).put(str, Boolean.FALSE);
            }
            v.d(v.this).put(str, paramAnonymousk.sxM);
          }
          if (paramAnonymousk.syK.size() > 0) {
            switch (((m)paramAnonymousk.syK.get(0)).type)
            {
            default: 
              ac.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = v.e(v.this);
            v.a(v.this, paramAnonymousk.suU.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)v.b(v.this).get(paramAnonymousk.sxM.syk)).addAll(paramAnonymousk.syK);
          }
          ac.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.suU.query, Integer.valueOf(paramAnonymousk.bPH) });
          if (!paramAnonymousk.suU.query.equals(v.f(v.this).get(v.this.Ixs)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.e(v.this);
        }
      }
    };
    this.qpm = 1;
    this.Ixz = 1;
    this.count = 0;
    this.Ixq = paramList1;
    this.Ixp = paramList2;
    this.fzw = paramList3;
    this.IwK = new ArrayList();
    WJ();
    AppMethodBeat.o(102893);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(102898);
    this.Ixs = 0;
    frA();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> aQX(String paramString)
  {
    AppMethodBeat.i(102895);
    LinkedList localLinkedList = new LinkedList();
    paramString = paramString.split(" ");
    int j = paramString.length;
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = paramString[i];
      if (!bs.isNullOrNil(((String)localObject).trim())) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
    localLinkedList.addAll(this.Ixt.keySet());
    if (this.Ixr != null)
    {
      if (localLinkedList.size() != this.Ixr.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.Ixr.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.Ixr == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.Ixr;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.syJ != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.syJ);
      this.syJ = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private void frA()
  {
    AppMethodBeat.i(102897);
    this.Ixm = new HashMap();
    this.Ixo = new HashMap();
    this.Ixl.clear();
    if (this.Ixv != null)
    {
      this.Ixv.close();
      this.Ixv = null;
      this.Ixw.clear();
      this.Ixx.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean frB()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.IwK.size() > 0) && (this.Ixr.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.IwK.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.Ixr.get(this.Ixs));
      localj.syD = new int[] { i };
      localj.syG = ((HashSet)localObject);
      localj.syI = this.IwL;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.jwR = 32;
      }
      for (localj.syH = com.tencent.mm.plugin.fts.a.c.a.szg;; localj.syH = b.szh)
      {
        this.syJ = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.jwR = 16;
      }
    }
    if (this.Ixs < this.Ixr.size() - 1)
    {
      this.Ixs += 1;
      this.IwK.clear();
      localObject = this.Ixu;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.IwK.add(Integer.valueOf(k));
        i += 1;
      }
      frB();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void frG()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.Ixq.size() < 41)
    {
      this.ItL.jdMethod_if(this.fzw);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.Ixq);
      ((List)localObject).addAll(this.Ixp);
      this.ItL.id((List)localObject);
      localObject = this.ItL.fqY();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.Ixw.put(Integer.valueOf(0), this.Iwg.getActivity().getString(2131762998));
        j = this.qpm;
        ac.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.g.agS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ht(this.fzw);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.Ixw.put(Integer.valueOf(i), this.Iwg.getActivity().getString(2131762985));
        this.Ixx.put("☆", Integer.valueOf(i));
        i += this.qpm + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c("@all.contact.without.chatroom", "", this.fzw));
      localObject = w.a(null, "@all.contact.without.chatroom", "", "", this.fzw);
      int[] arrayOfInt = w.a(null, "@all.contact.without.chatroom", "", this.fzw, "");
      if ((localObject == null) || (arrayOfInt == null)) {
        break label480;
      }
      int k = 0;
      j = i;
      i = k;
      while (i < localObject.length)
      {
        k = j;
        if (i < arrayOfInt.length)
        {
          this.Ixw.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.Ixx.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      ((Cursor)localObject).close();
      i = 0;
      break;
      label470:
      ((Cursor)localObject).close();
    }
    label480:
    this.Ixv = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private static com.tencent.mm.ui.contact.a.a gk(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102910);
    return localh;
  }
  
  private void l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (frF()) && (this.Ixq.size() < 3))
    {
      this.ItL.jdMethod_if(this.fzw);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.Ixq);
      ((List)localObject).addAll(this.Ixp);
      this.Ixl = this.ItL.c((List)localObject, this.Ixm);
      if (this.Ixl.size() > 0)
      {
        i = this.Ixl.size() + this.qpm + 0;
        ac.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.Ixl.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.Ixr != null)
      {
        localObject = this.Ixr.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.Ixm.get(str) != null)
          {
            if (((List)this.Ixm.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.Ixm.get(str)).size();
            if ((frF()) && (j > 3))
            {
              if (((Boolean)this.Ixn.get(str)).booleanValue()) {
                i = this.qpm + j + this.Ixz + i;
              } else {
                i = this.qpm + 3 + this.Ixz + i;
              }
            }
            else {
              i = this.qpm + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!frF())) {
          break label558;
        }
        ((List)this.Ixm.get(paramString)).add(new m());
        j = this.qpm;
        i += ((List)this.Ixm.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.Ixy = j;
        if ((paramBoolean1) && (frF())) {
          frG();
        }
        i = j;
        if (this.Ixv != null) {
          i = j + (this.Ixv.getCount() + this.Ixw.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.Iwf != null)) {
          this.Iwf.y(paramString, getCount(), paramBoolean1);
        }
        ac.i("MicroMsg.MultiSearchContactAdapter", "updateHeaderPosition, query:%s, isFinish:%b, searchEnd:%b, count:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(getCount()) });
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(102901);
        return;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final int aQR(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.Ixx.get(paramString) != null)
    {
      int i = ((Integer)this.Ixx.get(paramString)).intValue();
      int j = this.Ixy;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int aQW(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.Ixt.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.ItL.aQT(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
  }
  
  public final boolean abR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = abQ(paramInt - this.Iwg.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.j))
    {
      Map localMap = this.Ixn;
      String str = locala.query;
      if (!((Boolean)this.Ixn.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        l(null, true, false);
        paramInt = this.Iwg.getContentLV().getSelectedItemPosition();
        this.Iwg.getContentLV().setSelection(paramInt);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(102913);
        return bool1;
        bool1 = false;
        break;
        bool1 = bool2;
      } while (bs.isNullOrNil(locala.query));
      bool1 = bool2;
    } while (!(locala instanceof e));
    if (this.Ixp.contains(locala.contact.field_username)) {
      if (this.Ixt.get(locala.query) != null) {
        ((LinkedList)this.Ixt.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.ItL.reset();
      bool1 = bool2;
      break;
      if (this.Ixt.get(locala.query) == null) {
        this.Ixt.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.Ixt.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.Ixm = new HashMap();
    this.Ixo = new HashMap();
    this.Ixl.clear();
    if (this.Ixv != null)
    {
      this.Ixv.close();
      this.Ixv = null;
      this.Ixw.clear();
      this.Ixx.clear();
    }
    this.count = 0;
    this.Ixr = aQX(paramString);
    this.Ixs = 0;
    this.Ixu = paramArrayOfInt;
    this.IwK.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.IwK.add(Integer.valueOf(k));
      i += 1;
    }
    ac.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.Ixr });
    frB();
    AppMethodBeat.o(102894);
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(102912);
    int i = parama.position + 1;
    if (i >= this.count)
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((i >= this.Ixy) && (this.Ixw.get(Integer.valueOf(i - this.Ixy)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.Ixl.size() > 0) && (i == this.Ixl.size() + this.qpm))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.Ixy)
    {
      parama = qH(i);
      if ((parama == null) && ((parama instanceof com.tencent.mm.ui.contact.a.h)))
      {
        AppMethodBeat.o(102912);
        return true;
      }
      AppMethodBeat.o(102912);
      return false;
    }
    AppMethodBeat.o(102912);
    return false;
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102899);
    this.Ixt.clear();
    this.Ixn.clear();
    WJ();
    AppMethodBeat.o(102899);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102911);
    super.finish();
    ac.i("MicroMsg.MultiSearchContactAdapter", "finish!");
    clearData();
    AppMethodBeat.o(102911);
  }
  
  public final int fqU()
  {
    AppMethodBeat.i(102904);
    int i = this.Ixl.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  final boolean frF()
  {
    AppMethodBeat.i(102902);
    if ((this.Ixr != null) && (this.Ixr.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final boolean fro()
  {
    AppMethodBeat.i(102903);
    boolean bool = frF();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String frp()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.Ixt.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.Ixt.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.Ixp.contains(localObject4)) {
          ((LinkedList)this.Ixt.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.Ixt.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.Ixt.get(localObject2)).size() == 0) {
        this.Ixt.remove(localObject2);
      }
    }
    Object localObject2 = this.Ixr.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.Ixt.containsKey(localObject3)) {
        break label322;
      }
      localObject1 = (String)localObject1 + (String)localObject3 + " ";
    }
    label322:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (frF()) {
          localObject2 = " ";
        }
      }
      ac.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  protected final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    int m = 3;
    boolean bool = false;
    AppMethodBeat.i(102909);
    if (paramInt >= this.count)
    {
      ac.e("MicroMsg.MultiSearchContactAdapter", "createDataItem err %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
      AppMethodBeat.o(102909);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if ((this.Ixl != null) && (this.Ixl.size() > 0)) {
      if (paramInt < this.Ixl.size() + this.qpm)
      {
        if (paramInt == 0)
        {
          localObject1 = gk(this.Iwg.getActivity().getString(2131762999), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)this.Ixl.get(paramInt - this.qpm));
        localObject2 = new e(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((ai)localObject1);
        if (w.sQ(((av)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).Iwh = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Iwi = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).IzA = false;
        }
        for (((e)localObject2).IzP = true;; ((e)localObject2).IzP = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Iwh = dFi();
          ((com.tencent.mm.ui.contact.a.a)localObject2).Iwi = this.Iwi;
        }
      }
    }
    for (int i = this.Ixl.size() + this.qpm + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.Ixy)
      {
        localObject3 = this.Ixr.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.Ixm.get(localObject1) == null)
            {
              ac.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.Ixm.get(localObject1)).size();
              if ((frF()) && (j > 3))
              {
                if (((Boolean)this.Ixn.get(localObject1)).booleanValue()) {
                  break label1143;
                }
                j = 3;
              }
            }
          }
        }
      }
      label1140:
      label1143:
      for (;;)
      {
        int k;
        if (paramInt < i + j + this.qpm + this.Ixz)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.Ixw.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = gk((String)this.Ixw.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.qpm + j + this.Ixz + i;
              break;
              if (paramInt < i + j + this.qpm)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.qpm + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.Ixy;
              j = 0;
              continue;
            }
            localObject1 = this.Ixv;
            localObject2 = this.Ixw.keySet().iterator();
            i = 0;
            if (((Iterator)localObject2).hasNext())
            {
              if (paramInt - k <= ((Integer)((Iterator)localObject2).next()).intValue()) {
                break label1140;
              }
              i += 1;
            }
          }
        }
        for (;;)
        {
          break;
          if (((Cursor)localObject1).moveToPosition(paramInt - k - i))
          {
            localObject1 = new ai();
            ((ai)localObject1).convertFrom(this.Ixv);
            localObject2 = new e(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((ai)localObject1);
            if (w.sQ(((av)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).Iwh = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).Iwi = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).IzA = false;
            }
            for (((e)localObject2).IzP = true;; ((e)localObject2).IzP = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).Iwh = dFi();
              ((com.tencent.mm.ui.contact.a.a)localObject2).Iwi = this.Iwi;
            }
          }
          ac.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!frF()) {
              localObject1 = this.Iwg.getActivity().getResources().getString(2131759682);
            }
            localObject1 = gk((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).sxM = ((com.tencent.mm.plugin.fts.a.a.h)this.Ixo.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = this.scene;
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.Ixm.get(localObject2)).size();
          if ((frF()) && (!((Boolean)this.Ixn.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              if (!((Boolean)this.Ixn.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.j(paramInt);
              ((com.tencent.mm.ui.contact.a.j)localObject1).resId = 2131759682;
              ((com.tencent.mm.ui.contact.a.j)localObject1).rVH = bool;
              break;
            }
            localObject3 = (m)((List)this.Ixm.get(localObject2)).get(j - 1);
            if (((m)localObject3).syL > 0L)
            {
              localObject1 = new e(paramInt);
              ((e)localObject1).jPN = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).Iwh = dFi();
              ((e)localObject1).gbD = true;
              ((e)localObject1).szu = (j + 1);
              ((e)localObject1).fP(((e)localObject1).jPN.type, ((e)localObject1).jPN.sxF);
              break;
            }
            localObject1 = new i(paramInt);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */