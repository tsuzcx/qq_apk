package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private g PTI;
  private List<Integer> PWN;
  protected com.tencent.mm.plugin.fts.a.l PWO;
  private Map<String, Integer> PXA;
  private int PXB;
  private int PXC;
  private List<String> PXo;
  private Map<String, List<m>> PXp;
  private Map<String, Boolean> PXq;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> PXr;
  private List<String> PXs;
  private List<String> PXt;
  private List<String> PXu;
  protected int PXv;
  private Map<String, LinkedList<String>> PXw;
  private int[] PXx;
  private Cursor PXy;
  private Map<Integer, String> PXz;
  private int count;
  private List<String> gzY;
  private MMHandler handler;
  private int sHN;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.PXo = new LinkedList();
    this.PXp = null;
    this.PXq = new HashMap();
    this.PXr = null;
    this.PXv = 0;
    this.PXw = new HashMap();
    this.PXz = new HashMap();
    this.PXA = new HashMap();
    this.PXB = 0;
    this.PTI = new g();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.PWO = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((v.a(v.this) == null) || (paramAnonymousk.wWd == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.a(v.this, paramAnonymousk.wXb);
          String str = paramAnonymousk.wWd.wWB;
          if (v.b(v.this).get(str) == null)
          {
            v.b(v.this).put(str, new LinkedList());
            if (v.c(v.this).get(str) == null) {
              v.c(v.this).put(str, Boolean.FALSE);
            }
            v.d(v.this).put(str, paramAnonymousk.wWd);
          }
          if (paramAnonymousk.wXb.size() > 0) {
            switch (((m)paramAnonymousk.wXb.get(0)).type)
            {
            default: 
              Log.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = v.e(v.this);
            v.a(v.this, paramAnonymousk.wTn.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)v.b(v.this).get(paramAnonymousk.wWd.wWB)).addAll(paramAnonymousk.wXb);
          }
          Log.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.wTn.query, Integer.valueOf(paramAnonymousk.resultCode) });
          if (!paramAnonymousk.wTn.query.equals(v.f(v.this).get(v.this.PXv)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.e(v.this);
        }
      }
    };
    this.sHN = 1;
    this.PXC = 1;
    this.count = 0;
    this.PXt = paramList1;
    this.PXs = paramList2;
    this.gzY = paramList3;
    this.PWN = new ArrayList();
    amZ();
    AppMethodBeat.o(102893);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(102898);
    this.PXv = 0;
    gUZ();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> bnx(String paramString)
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
      if (!Util.isNullOrNil(((String)localObject).trim())) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
    localLinkedList.addAll(this.PXw.keySet());
    if (this.PXu != null)
    {
      if (localLinkedList.size() != this.PXu.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.PXu.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.PXu == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.PXu;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.wXa != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
      this.wXa = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private void gUZ()
  {
    AppMethodBeat.i(102897);
    this.PXp = new HashMap();
    this.PXr = new HashMap();
    this.PXo.clear();
    if (this.PXy != null)
    {
      this.PXy.close();
      this.PXy = null;
      this.PXz.clear();
      this.PXA.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean gVa()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.PWN.size() > 0) && (this.PXu.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.PWN.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.PXu.get(this.PXv));
      localj.wWU = new int[] { i };
      localj.wWX = ((HashSet)localObject);
      localj.wWZ = this.PWO;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.kXb = 32;
      }
      for (localj.wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;; localj.wWY = b.wXy)
      {
        this.wXa = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.kXb = 16;
      }
    }
    if (this.PXv < this.PXu.size() - 1)
    {
      this.PXv += 1;
      this.PWN.clear();
      localObject = this.PXx;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.PWN.add(Integer.valueOf(k));
        i += 1;
      }
      gVa();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void gVf()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.PXt.size() < 41)
    {
      this.PTI.jE(this.gzY);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.PXt);
      ((List)localObject).addAll(this.PXs);
      this.PTI.jC((List)localObject);
      localObject = this.PTI.gUx();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.PXz.put(Integer.valueOf(0), this.PWg.getActivity().getString(2131765135));
        j = this.sHN;
        Log.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.g.aAi();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().iT(this.gzY);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.PXz.put(Integer.valueOf(i), this.PWg.getActivity().getString(2131765122));
        this.PXA.put("☆", Integer.valueOf(i));
        i += this.sHN + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c("@all.contact.without.chatroom", "", this.gzY));
      localObject = ab.a(null, "@all.contact.without.chatroom", "", "", this.gzY);
      int[] arrayOfInt = ab.a(null, "@all.contact.without.chatroom", "", this.gzY, "");
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
          this.PXz.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.PXA.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.PXy = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private static com.tencent.mm.ui.contact.a.a hj(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102910);
    return localh;
  }
  
  private void p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (gVe()) && (this.PXt.size() < 3))
    {
      this.PTI.jE(this.gzY);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.PXt);
      ((List)localObject).addAll(this.PXs);
      this.PXo = this.PTI.c((List)localObject, this.PXp);
      if (this.PXo.size() > 0)
      {
        i = this.PXo.size() + this.sHN + 0;
        Log.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.PXo.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.PXu != null)
      {
        localObject = this.PXu.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.PXp.get(str) != null)
          {
            if (((List)this.PXp.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.PXp.get(str)).size();
            if ((gVe()) && (j > 3))
            {
              if (((Boolean)this.PXq.get(str)).booleanValue()) {
                i = this.sHN + j + this.PXC + i;
              } else {
                i = this.sHN + 3 + this.PXC + i;
              }
            }
            else {
              i = this.sHN + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!gVe())) {
          break label558;
        }
        ((List)this.PXp.get(paramString)).add(new m());
        j = this.sHN;
        i += ((List)this.PXp.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.PXB = j;
        if ((paramBoolean1) && (gVe())) {
          gVf();
        }
        i = j;
        if (this.PXy != null) {
          i = j + (this.PXy.getCount() + this.PXz.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.PWf != null)) {
          this.PWf.B(paramString, getCount(), paramBoolean1);
        }
        Log.i("MicroMsg.MultiSearchContactAdapter", "updateHeaderPosition, query:%s, isFinish:%b, searchEnd:%b, count:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(getCount()) });
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
  
  public final boolean anI(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = anH(paramInt - this.PWg.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.j))
    {
      Map localMap = this.PXq;
      String str = locala.query;
      if (!((Boolean)this.PXq.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        p(null, true, false);
        paramInt = this.PWg.getContentLV().getSelectedItemPosition();
        this.PWg.getContentLV().setSelection(paramInt);
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
      } while (Util.isNullOrNil(locala.query));
      bool1 = bool2;
    } while (!(locala instanceof e));
    if (this.PXs.contains(locala.contact.field_username)) {
      if (this.PXw.get(locala.query) != null) {
        ((LinkedList)this.PXw.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.PTI.reset();
      bool1 = bool2;
      break;
      if (this.PXw.get(locala.query) == null) {
        this.PXw.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.PXw.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.PXp = new HashMap();
    this.PXr = new HashMap();
    this.PXo.clear();
    if (this.PXy != null)
    {
      this.PXy.close();
      this.PXy = null;
      this.PXz.clear();
      this.PXA.clear();
    }
    this.count = 0;
    this.PXu = bnx(paramString);
    this.PXv = 0;
    this.PXx = paramArrayOfInt;
    this.PWN.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.PWN.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.PXu });
    gVa();
    AppMethodBeat.o(102894);
  }
  
  public final int bnr(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.PXA.get(paramString) != null)
    {
      int i = ((Integer)this.PXA.get(paramString)).intValue();
      int j = this.PXB;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int bnw(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.PXw.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.PTI.bnt(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
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
    if ((i >= this.PXB) && (this.PXz.get(Integer.valueOf(i - this.PXB)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.PXo.size() > 0) && (i == this.PXo.size() + this.sHN))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.PXB)
    {
      parama = va(i);
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
    this.PXw.clear();
    this.PXq.clear();
    amZ();
    AppMethodBeat.o(102899);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102911);
    super.finish();
    Log.i("MicroMsg.MultiSearchContactAdapter", "finish!");
    clearData();
    AppMethodBeat.o(102911);
  }
  
  public final boolean gUN()
  {
    AppMethodBeat.i(102903);
    boolean bool = gVe();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String gUO()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.PXw.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.PXw.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.PXs.contains(localObject4)) {
          ((LinkedList)this.PXw.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.PXw.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.PXw.get(localObject2)).size() == 0) {
        this.PXw.remove(localObject2);
      }
    }
    Object localObject2 = this.PXu.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.PXw.containsKey(localObject3)) {
        break label322;
      }
      localObject1 = (String)localObject1 + (String)localObject3 + " ";
    }
    label322:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (gVe()) {
          localObject2 = " ";
        }
      }
      Log.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  public final int gUt()
  {
    AppMethodBeat.i(102904);
    int i = this.PXo.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  final boolean gVe()
  {
    AppMethodBeat.i(102902);
    if ((this.PXu != null) && (this.PXu.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  protected final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    int m = 3;
    boolean bool = false;
    AppMethodBeat.i(102909);
    if (paramInt >= this.count)
    {
      Log.e("MicroMsg.MultiSearchContactAdapter", "createDataItem err %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
      AppMethodBeat.o(102909);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if ((this.PXo != null) && (this.PXo.size() > 0)) {
      if (paramInt < this.PXo.size() + this.sHN)
      {
        if (paramInt == 0)
        {
          localObject1 = hj(this.PWg.getActivity().getString(2131765136), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)this.PXo.get(paramInt - this.sHN));
        localObject2 = new e(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
        if (ab.Eq(((ax)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).PWi = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Qaa = false;
        }
        for (((e)localObject2).Qap = true;; ((e)localObject2).Qap = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = eWh();
          ((com.tencent.mm.ui.contact.a.a)localObject2).PWi = this.PWi;
        }
      }
    }
    for (int i = this.PXo.size() + this.sHN + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.PXB)
      {
        localObject3 = this.PXu.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.PXp.get(localObject1) == null)
            {
              Log.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.PXp.get(localObject1)).size();
              if ((gVe()) && (j > 3))
              {
                if (((Boolean)this.PXq.get(localObject1)).booleanValue()) {
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
        if (paramInt < i + j + this.sHN + this.PXC)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.PXz.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = hj((String)this.PXz.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.sHN + j + this.PXC + i;
              break;
              if (paramInt < i + j + this.sHN)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.sHN + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.PXB;
              j = 0;
              continue;
            }
            localObject1 = this.PXy;
            localObject2 = this.PXz.keySet().iterator();
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
            localObject1 = new as();
            ((as)localObject1).convertFrom(this.PXy);
            localObject2 = new e(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
            if (ab.Eq(((ax)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).PWi = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).Qaa = false;
            }
            for (((e)localObject2).Qap = true;; ((e)localObject2).Qap = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = eWh();
              ((com.tencent.mm.ui.contact.a.a)localObject2).PWi = this.PWi;
            }
          }
          Log.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!gVe()) {
              localObject1 = this.PWg.getActivity().getResources().getString(2131761003);
            }
            localObject1 = hj((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).wWd = ((com.tencent.mm.plugin.fts.a.a.h)this.PXr.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = this.scene;
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.PXp.get(localObject2)).size();
          if ((gVe()) && (!((Boolean)this.PXq.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              if (!((Boolean)this.PXq.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.j(paramInt);
              ((com.tencent.mm.ui.contact.a.j)localObject1).resId = 2131761003;
              ((com.tencent.mm.ui.contact.a.j)localObject1).wke = bool;
              break;
            }
            localObject3 = (m)((List)this.PXp.get(localObject2)).get(j - 1);
            if (((m)localObject3).wXc > 0L)
            {
              localObject1 = new e(paramInt);
              ((e)localObject1).lqW = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).PWh = eWh();
              ((e)localObject1).hkH = true;
              ((e)localObject1).wXL = (j + 1);
              ((e)localObject1).gE(((e)localObject1).lqW.type, ((e)localObject1).lqW.wVW);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */