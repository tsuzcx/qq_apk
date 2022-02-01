package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private g GTA;
  private List<String> GWX;
  private Map<String, List<m>> GWY;
  private Map<String, Boolean> GWZ;
  private List<Integer> GWw;
  protected l GWx;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> GXa;
  private List<String> GXb;
  private List<String> GXc;
  private List<String> GXd;
  protected int GXe;
  private Map<String, LinkedList<String>> GXf;
  private int[] GXg;
  private Cursor GXh;
  private Map<Integer, String> GXi;
  private Map<String, Integer> GXj;
  private int GXk;
  private int GXl;
  private int count;
  private List<String> fvP;
  private ap handler;
  private int qui;
  private com.tencent.mm.plugin.fts.a.a.a rpP;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.GWX = new LinkedList();
    this.GWY = null;
    this.GWZ = new HashMap();
    this.GXa = null;
    this.GXe = 0;
    this.GXf = new HashMap();
    this.GXi = new HashMap();
    this.GXj = new HashMap();
    this.GXk = 0;
    this.GTA = new g();
    this.handler = new ap(Looper.getMainLooper());
    this.GWx = new l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.k paramAnonymousk)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousk.bRZ)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((v.a(v.this) == null) || (paramAnonymousk.roS == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.a(v.this, paramAnonymousk.rpQ);
          String str = paramAnonymousk.roS.rpq;
          if (v.b(v.this).get(str) == null)
          {
            v.b(v.this).put(str, new LinkedList());
            if (v.c(v.this).get(str) == null) {
              v.c(v.this).put(str, Boolean.FALSE);
            }
            v.d(v.this).put(str, paramAnonymousk.roS);
          }
          if (paramAnonymousk.rpQ.size() > 0) {
            switch (((m)paramAnonymousk.rpQ.get(0)).type)
            {
            default: 
              ad.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = v.e(v.this);
            v.a(v.this, paramAnonymousk.rma.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)v.b(v.this).get(paramAnonymousk.roS.rpq)).addAll(paramAnonymousk.rpQ);
          }
          ad.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.rma.query, Integer.valueOf(paramAnonymousk.bRZ) });
          if (!paramAnonymousk.rma.query.equals(v.f(v.this).get(v.this.GXe)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.e(v.this);
        }
      }
    };
    this.qui = 1;
    this.GXl = 1;
    this.count = 0;
    this.GXc = paramList1;
    this.GXb = paramList2;
    this.fvP = paramList3;
    this.GWw = new ArrayList();
    VL();
    AppMethodBeat.o(102893);
  }
  
  private void VL()
  {
    AppMethodBeat.i(102898);
    this.GXe = 0;
    fbJ();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> aLt(String paramString)
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
    localLinkedList.addAll(this.GXf.keySet());
    if (this.GXd != null)
    {
      if (localLinkedList.size() != this.GXd.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.GXd.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.GXd == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.GXd;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.rpP != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.rpP);
      this.rpP = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private void fbJ()
  {
    AppMethodBeat.i(102897);
    this.GWY = new HashMap();
    this.GXa = new HashMap();
    this.GWX.clear();
    if (this.GXh != null)
    {
      this.GXh.close();
      this.GXh = null;
      this.GXi.clear();
      this.GXj.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean fbK()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.GWw.size() > 0) && (this.GXd.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.GWw.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.GXd.get(this.GXe));
      localj.rpJ = new int[] { i };
      localj.rpM = ((HashSet)localObject);
      localj.rpO = this.GWx;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.iWB = 32;
      }
      for (localj.rpN = com.tencent.mm.plugin.fts.a.c.a.rqm;; localj.rpN = b.rqn)
      {
        this.rpP = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.iWB = 16;
      }
    }
    if (this.GXe < this.GXd.size() - 1)
    {
      this.GXe += 1;
      this.GWw.clear();
      localObject = this.GXg;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.GWw.add(Integer.valueOf(k));
        i += 1;
      }
      fbK();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void fbP()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.GXc.size() < 41)
    {
      this.GTA.hS(this.fvP);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.GXc);
      ((List)localObject).addAll(this.GXb);
      this.GTA.hQ((List)localObject);
      localObject = this.GTA.fbh();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.GXi.put(Integer.valueOf(0), this.GVS.getActivity().getString(2131762998));
        j = this.qui;
        ad.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.g.afC();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hg(this.fvP);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.GXi.put(Integer.valueOf(i), this.GVS.getActivity().getString(2131762985));
        this.GXj.put("☆", Integer.valueOf(i));
        i += this.qui + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c("@all.contact.without.chatroom", "", this.fvP));
      localObject = w.a(null, "@all.contact.without.chatroom", "", "", this.fvP);
      int[] arrayOfInt = w.a(null, "@all.contact.without.chatroom", "", this.fvP, "");
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
          this.GXi.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.GXj.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.GXh = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private static com.tencent.mm.ui.contact.a.a gg(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102910);
    return localh;
  }
  
  private void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (fbO()) && (this.GXc.size() < 3))
    {
      this.GTA.hS(this.fvP);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.GXc);
      ((List)localObject).addAll(this.GXb);
      this.GWX = this.GTA.c((List)localObject, this.GWY);
      if (this.GWX.size() > 0)
      {
        i = this.GWX.size() + this.qui + 0;
        ad.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.GWX.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.GXd != null)
      {
        localObject = this.GXd.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.GWY.get(str) != null)
          {
            if (((List)this.GWY.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.GWY.get(str)).size();
            if ((fbO()) && (j > 3))
            {
              if (((Boolean)this.GWZ.get(str)).booleanValue()) {
                i = this.qui + j + this.GXl + i;
              } else {
                i = this.qui + 3 + this.GXl + i;
              }
            }
            else {
              i = this.qui + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!fbO())) {
          break label558;
        }
        ((List)this.GWY.get(paramString)).add(new m());
        j = this.qui;
        i += ((List)this.GWY.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.GXk = j;
        if ((paramBoolean1) && (fbO())) {
          fbP();
        }
        i = j;
        if (this.GXh != null) {
          i = j + (this.GXh.getCount() + this.GXi.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.GVR != null)) {
          this.GVR.y(paramString, getCount(), paramBoolean1);
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
  
  public final boolean ZD(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = ZC(paramInt - this.GVS.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.j))
    {
      Map localMap = this.GWZ;
      String str = locala.query;
      if (!((Boolean)this.GWZ.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        k(null, true, false);
        paramInt = this.GVS.getContentLV().getSelectedItemPosition();
        this.GVS.getContentLV().setSelection(paramInt);
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
    if (this.GXb.contains(locala.contact.field_username)) {
      if (this.GXf.get(locala.query) != null) {
        ((LinkedList)this.GXf.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.GTA.reset();
      bool1 = bool2;
      break;
      if (this.GXf.get(locala.query) == null) {
        this.GXf.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.GXf.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final int aLn(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.GXj.get(paramString) != null)
    {
      int i = ((Integer)this.GXj.get(paramString)).intValue();
      int j = this.GXk;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int aLs(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.GXf.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.GTA.aLp(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.GWY = new HashMap();
    this.GXa = new HashMap();
    this.GWX.clear();
    if (this.GXh != null)
    {
      this.GXh.close();
      this.GXh = null;
      this.GXi.clear();
      this.GXj.clear();
    }
    this.count = 0;
    this.GXd = aLt(paramString);
    this.GXe = 0;
    this.GXg = paramArrayOfInt;
    this.GWw.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.GWw.add(Integer.valueOf(k));
      i += 1;
    }
    ad.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.GXd });
    fbK();
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
    if ((i >= this.GXk) && (this.GXi.get(Integer.valueOf(i - this.GXk)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.GWX.size() > 0) && (i == this.GWX.size() + this.qui))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.GXk)
    {
      parama = pU(i);
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
    this.GXf.clear();
    this.GWZ.clear();
    VL();
    AppMethodBeat.o(102899);
  }
  
  final boolean fbO()
  {
    AppMethodBeat.i(102902);
    if ((this.GXd != null) && (this.GXd.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final int fbd()
  {
    AppMethodBeat.i(102904);
    int i = this.GWX.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  public final boolean fbx()
  {
    AppMethodBeat.i(102903);
    boolean bool = fbO();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String fby()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.GXf.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.GXf.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.GXb.contains(localObject4)) {
          ((LinkedList)this.GXf.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.GXf.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.GXf.get(localObject2)).size() == 0) {
        this.GXf.remove(localObject2);
      }
    }
    Object localObject2 = this.GXd.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.GXf.containsKey(localObject3)) {
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
        if (fbO()) {
          localObject2 = " ";
        }
      }
      ad.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
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
  
  protected final com.tencent.mm.ui.contact.a.a pU(int paramInt)
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
    if ((this.GWX != null) && (this.GWX.size() > 0)) {
      if (paramInt < this.GWX.size() + this.qui)
      {
        if (paramInt == 0)
        {
          localObject1 = gg(this.GVS.getActivity().getString(2131762999), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)this.GWX.get(paramInt - this.qui));
        localObject2 = new e(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((af)localObject1);
        if (w.pF(((au)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).GVT = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).GVU = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).GZk = false;
        }
        for (((e)localObject2).GZx = true;; ((e)localObject2).GZx = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).GVT = dqZ();
          ((com.tencent.mm.ui.contact.a.a)localObject2).GVU = this.GVU;
        }
      }
    }
    for (int i = this.GWX.size() + this.qui + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.GXk)
      {
        localObject3 = this.GXd.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.GWY.get(localObject1) == null)
            {
              ad.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.GWY.get(localObject1)).size();
              if ((fbO()) && (j > 3))
              {
                if (((Boolean)this.GWZ.get(localObject1)).booleanValue()) {
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
        if (paramInt < i + j + this.qui + this.GXl)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.GXi.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = gg((String)this.GXi.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.qui + j + this.GXl + i;
              break;
              if (paramInt < i + j + this.qui)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.qui + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.GXk;
              j = 0;
              continue;
            }
            localObject1 = this.GXh;
            localObject2 = this.GXi.keySet().iterator();
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
            localObject1 = new af();
            ((af)localObject1).convertFrom(this.GXh);
            localObject2 = new e(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((af)localObject1);
            if (w.pF(((au)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).GVT = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).GVU = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).GZk = false;
            }
            for (((e)localObject2).GZx = true;; ((e)localObject2).GZx = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).GVT = dqZ();
              ((com.tencent.mm.ui.contact.a.a)localObject2).GVU = this.GVU;
            }
          }
          ad.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!fbO()) {
              localObject1 = this.GVS.getActivity().getResources().getString(2131759682);
            }
            localObject1 = gg((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).roS = ((com.tencent.mm.plugin.fts.a.a.h)this.GXa.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = this.scene;
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.GWY.get(localObject2)).size();
          if ((fbO()) && (!((Boolean)this.GWZ.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              if (!((Boolean)this.GWZ.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.j(paramInt);
              ((com.tencent.mm.ui.contact.a.j)localObject1).resId = 2131759682;
              ((com.tencent.mm.ui.contact.a.j)localObject1).qVx = bool;
              break;
            }
            localObject3 = (m)((List)this.GWY.get(localObject2)).get(j - 1);
            if (((m)localObject3).rpR > 0L)
            {
              localObject1 = new e(paramInt);
              ((e)localObject1).jpy = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).GVT = dqZ();
              ((e)localObject1).fWW = true;
              ((e)localObject1).rqA = (j + 1);
              ((e)localObject1).fI(((e)localObject1).jpy.type, ((e)localObject1).jpy.roM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */