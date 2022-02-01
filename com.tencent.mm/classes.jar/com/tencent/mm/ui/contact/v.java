package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private g Kkr;
  private List<String> KnT;
  private Map<String, List<m>> KnU;
  private Map<String, Boolean> KnV;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> KnW;
  private List<String> KnX;
  private List<String> KnY;
  private List<String> KnZ;
  private List<Integer> Kns;
  protected com.tencent.mm.plugin.fts.a.l Knt;
  protected int Koa;
  private Map<String, LinkedList<String>> Kob;
  private int[] Koc;
  private Cursor Kod;
  private Map<Integer, String> Koe;
  private Map<String, Integer> Kof;
  private int Kog;
  private int Koh;
  private int count;
  private List<String> fSL;
  private ap handler;
  private int qYl;
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.KnT = new LinkedList();
    this.KnU = null;
    this.KnV = new HashMap();
    this.KnW = null;
    this.Koa = 0;
    this.Kob = new HashMap();
    this.Koe = new HashMap();
    this.Kof = new HashMap();
    this.Kog = 0;
    this.Kkr = new g();
    this.handler = new ap(Looper.getMainLooper());
    this.Knt = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousk.bZU)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((v.a(v.this) == null) || (paramAnonymousk.tun == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.a(v.this, paramAnonymousk.tvl);
          String str = paramAnonymousk.tun.tuL;
          if (v.b(v.this).get(str) == null)
          {
            v.b(v.this).put(str, new LinkedList());
            if (v.c(v.this).get(str) == null) {
              v.c(v.this).put(str, Boolean.FALSE);
            }
            v.d(v.this).put(str, paramAnonymousk.tun);
          }
          if (paramAnonymousk.tvl.size() > 0) {
            switch (((m)paramAnonymousk.tvl.get(0)).type)
            {
            default: 
              ad.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = v.e(v.this);
            v.a(v.this, paramAnonymousk.trv.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)v.b(v.this).get(paramAnonymousk.tun.tuL)).addAll(paramAnonymousk.tvl);
          }
          ad.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.trv.query, Integer.valueOf(paramAnonymousk.bZU) });
          if (!paramAnonymousk.trv.query.equals(v.f(v.this).get(v.this.Koa)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.e(v.this);
        }
      }
    };
    this.qYl = 1;
    this.Koh = 1;
    this.count = 0;
    this.KnY = paramList1;
    this.KnX = paramList2;
    this.fSL = paramList3;
    this.Kns = new ArrayList();
    Zd();
    AppMethodBeat.o(102893);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(102898);
    this.Koa = 0;
    fIn();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> aWS(String paramString)
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
      if (!bt.isNullOrNil(((String)localObject).trim())) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
    localLinkedList.addAll(this.Kob.keySet());
    if (this.KnZ != null)
    {
      if (localLinkedList.size() != this.KnZ.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.KnZ.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.KnZ == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.KnZ;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.tvk != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tvk);
      this.tvk = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private void fIn()
  {
    AppMethodBeat.i(102897);
    this.KnU = new HashMap();
    this.KnW = new HashMap();
    this.KnT.clear();
    if (this.Kod != null)
    {
      this.Kod.close();
      this.Kod = null;
      this.Koe.clear();
      this.Kof.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean fIo()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.Kns.size() > 0) && (this.KnZ.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.Kns.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.KnZ.get(this.Koa));
      localj.tve = new int[] { i };
      localj.tvh = ((HashSet)localObject);
      localj.tvj = this.Knt;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.jQN = 32;
      }
      for (localj.tvi = com.tencent.mm.plugin.fts.a.c.a.tvH;; localj.tvi = b.tvI)
      {
        this.tvk = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.jQN = 16;
      }
    }
    if (this.Koa < this.KnZ.size() - 1)
    {
      this.Koa += 1;
      this.Kns.clear();
      localObject = this.Koc;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.Kns.add(Integer.valueOf(k));
        i += 1;
      }
      fIo();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void fIt()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.KnY.size() < 41)
    {
      this.Kkr.ir(this.fSL);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.KnY);
      ((List)localObject).addAll(this.KnX);
      this.Kkr.ip((List)localObject);
      localObject = this.Kkr.fHL();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.Koe.put(Integer.valueOf(0), this.KmO.getActivity().getString(2131762998));
        j = this.qYl;
        ad.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.g.ajD();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().hF(this.fSL);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.Koe.put(Integer.valueOf(i), this.KmO.getActivity().getString(2131762985));
        this.Kof.put("☆", Integer.valueOf(i));
        i += this.qYl + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().c("@all.contact.without.chatroom", "", this.fSL));
      localObject = w.a(null, "@all.contact.without.chatroom", "", "", this.fSL);
      int[] arrayOfInt = w.a(null, "@all.contact.without.chatroom", "", this.fSL, "");
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
          this.Koe.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.Kof.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.Kod = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private static com.tencent.mm.ui.contact.a.a gH(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102910);
    return localh;
  }
  
  private void n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (fIs()) && (this.KnY.size() < 3))
    {
      this.Kkr.ir(this.fSL);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.KnY);
      ((List)localObject).addAll(this.KnX);
      this.KnT = this.Kkr.c((List)localObject, this.KnU);
      if (this.KnT.size() > 0)
      {
        i = this.KnT.size() + this.qYl + 0;
        ad.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.KnT.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.KnZ != null)
      {
        localObject = this.KnZ.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.KnU.get(str) != null)
          {
            if (((List)this.KnU.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.KnU.get(str)).size();
            if ((fIs()) && (j > 3))
            {
              if (((Boolean)this.KnV.get(str)).booleanValue()) {
                i = this.qYl + j + this.Koh + i;
              } else {
                i = this.qYl + 3 + this.Koh + i;
              }
            }
            else {
              i = this.qYl + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!fIs())) {
          break label558;
        }
        ((List)this.KnU.get(paramString)).add(new m());
        j = this.qYl;
        i += ((List)this.KnU.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.Kog = j;
        if ((paramBoolean1) && (fIs())) {
          fIt();
        }
        i = j;
        if (this.Kod != null) {
          i = j + (this.Kod.getCount() + this.Koe.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.KmN != null)) {
          this.KmN.y(paramString, getCount(), paramBoolean1);
        }
        ad.i("MicroMsg.MultiSearchContactAdapter", "updateHeaderPosition, query:%s, isFinish:%b, searchEnd:%b, count:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(getCount()) });
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
  
  public final int aWM(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.Kof.get(paramString) != null)
    {
      int i = ((Integer)this.Kof.get(paramString)).intValue();
      int j = this.Kog;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int aWR(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.Kob.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.Kkr.aWO(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
  }
  
  public final boolean aeo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = aen(paramInt - this.KmO.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.j))
    {
      Map localMap = this.KnV;
      String str = locala.query;
      if (!((Boolean)this.KnV.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        n(null, true, false);
        paramInt = this.KmO.getContentLV().getSelectedItemPosition();
        this.KmO.getContentLV().setSelection(paramInt);
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
      } while (bt.isNullOrNil(locala.query));
      bool1 = bool2;
    } while (!(locala instanceof e));
    if (this.KnX.contains(locala.contact.field_username)) {
      if (this.Kob.get(locala.query) != null) {
        ((LinkedList)this.Kob.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.Kkr.reset();
      bool1 = bool2;
      break;
      if (this.Kob.get(locala.query) == null) {
        this.Kob.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.Kob.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.KnU = new HashMap();
    this.KnW = new HashMap();
    this.KnT.clear();
    if (this.Kod != null)
    {
      this.Kod.close();
      this.Kod = null;
      this.Koe.clear();
      this.Kof.clear();
    }
    this.count = 0;
    this.KnZ = aWS(paramString);
    this.Koa = 0;
    this.Koc = paramArrayOfInt;
    this.Kns.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.Kns.add(Integer.valueOf(k));
      i += 1;
    }
    ad.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.KnZ });
    fIo();
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
    if ((i >= this.Kog) && (this.Koe.get(Integer.valueOf(i - this.Kog)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.KnT.size() > 0) && (i == this.KnT.size() + this.qYl))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.Kog)
    {
      parama = rh(i);
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
    this.Kob.clear();
    this.KnV.clear();
    Zd();
    AppMethodBeat.o(102899);
  }
  
  public final int fHH()
  {
    AppMethodBeat.i(102904);
    int i = this.KnT.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  public final boolean fIb()
  {
    AppMethodBeat.i(102903);
    boolean bool = fIs();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String fIc()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.Kob.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.Kob.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.KnX.contains(localObject4)) {
          ((LinkedList)this.Kob.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.Kob.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.Kob.get(localObject2)).size() == 0) {
        this.Kob.remove(localObject2);
      }
    }
    Object localObject2 = this.KnZ.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.Kob.containsKey(localObject3)) {
        break label322;
      }
      localObject1 = (String)localObject1 + (String)localObject3 + " ";
    }
    label322:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (fIs()) {
          localObject2 = " ";
        }
      }
      ad.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  final boolean fIs()
  {
    AppMethodBeat.i(102902);
    if ((this.KnZ != null) && (this.KnZ.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102911);
    super.finish();
    ad.i("MicroMsg.MultiSearchContactAdapter", "finish!");
    clearData();
    AppMethodBeat.o(102911);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  protected final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    int m = 3;
    boolean bool = false;
    AppMethodBeat.i(102909);
    if (paramInt >= this.count)
    {
      ad.e("MicroMsg.MultiSearchContactAdapter", "createDataItem err %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
      AppMethodBeat.o(102909);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if ((this.KnT != null) && (this.KnT.size() > 0)) {
      if (paramInt < this.KnT.size() + this.qYl)
      {
        if (paramInt == 0)
        {
          localObject1 = gH(this.KmO.getActivity().getString(2131762999), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)this.KnT.get(paramInt - this.qYl));
        localObject2 = new e(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((am)localObject1);
        if (w.vF(((aw)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).KmP = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KmQ = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KqG = false;
        }
        for (((e)localObject2).KqV = true;; ((e)localObject2).KqV = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KmP = dQK();
          ((com.tencent.mm.ui.contact.a.a)localObject2).KmQ = this.KmQ;
        }
      }
    }
    for (int i = this.KnT.size() + this.qYl + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.Kog)
      {
        localObject3 = this.KnZ.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.KnU.get(localObject1) == null)
            {
              ad.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.KnU.get(localObject1)).size();
              if ((fIs()) && (j > 3))
              {
                if (((Boolean)this.KnV.get(localObject1)).booleanValue()) {
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
        if (paramInt < i + j + this.qYl + this.Koh)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.Koe.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = gH((String)this.Koe.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.qYl + j + this.Koh + i;
              break;
              if (paramInt < i + j + this.qYl)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.qYl + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.Kog;
              j = 0;
              continue;
            }
            localObject1 = this.Kod;
            localObject2 = this.Koe.keySet().iterator();
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
            localObject1 = new am();
            ((am)localObject1).convertFrom(this.Kod);
            localObject2 = new e(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((am)localObject1);
            if (w.vF(((aw)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).KmP = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KmQ = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KqG = false;
            }
            for (((e)localObject2).KqV = true;; ((e)localObject2).KqV = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KmP = dQK();
              ((com.tencent.mm.ui.contact.a.a)localObject2).KmQ = this.KmQ;
            }
          }
          ad.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!fIs()) {
              localObject1 = this.KmO.getActivity().getResources().getString(2131759682);
            }
            localObject1 = gH((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).tun = ((com.tencent.mm.plugin.fts.a.a.h)this.KnW.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = this.scene;
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.KnU.get(localObject2)).size();
          if ((fIs()) && (!((Boolean)this.KnV.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              if (!((Boolean)this.KnV.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.j(paramInt);
              ((com.tencent.mm.ui.contact.a.j)localObject1).resId = 2131759682;
              ((com.tencent.mm.ui.contact.a.j)localObject1).sSq = bool;
              break;
            }
            localObject3 = (m)((List)this.KnU.get(localObject2)).get(j - 1);
            if (((m)localObject3).tvm > 0L)
            {
              localObject1 = new e(paramInt);
              ((e)localObject1).kjY = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).KmP = dQK();
              ((e)localObject1).gvn = true;
              ((e)localObject1).tvV = (j + 1);
              ((e)localObject1).gf(((e)localObject1).kjY.type, ((e)localObject1).kjY.tug);
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