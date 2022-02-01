package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private g KGL;
  private List<Integer> KJM;
  protected com.tencent.mm.plugin.fts.a.l KJN;
  private int KKA;
  private int KKB;
  private List<String> KKn;
  private Map<String, List<m>> KKo;
  private Map<String, Boolean> KKp;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> KKq;
  private List<String> KKr;
  private List<String> KKs;
  private List<String> KKt;
  protected int KKu;
  private Map<String, LinkedList<String>> KKv;
  private int[] KKw;
  private Cursor KKx;
  private Map<Integer, String> KKy;
  private Map<String, Integer> KKz;
  private int count;
  private List<String> fUR;
  private aq handler;
  private int rgr;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.KKn = new LinkedList();
    this.KKo = null;
    this.KKp = new HashMap();
    this.KKq = null;
    this.KKu = 0;
    this.KKv = new HashMap();
    this.KKy = new HashMap();
    this.KKz = new HashMap();
    this.KKA = 0;
    this.KGL = new g();
    this.handler = new aq(Looper.getMainLooper());
    this.KJN = new com.tencent.mm.plugin.fts.a.l()
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
          if ((v.a(v.this) == null) || (paramAnonymousk.tFe == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.a(v.this, paramAnonymousk.tGc);
          String str = paramAnonymousk.tFe.tFC;
          if (v.b(v.this).get(str) == null)
          {
            v.b(v.this).put(str, new LinkedList());
            if (v.c(v.this).get(str) == null) {
              v.c(v.this).put(str, Boolean.FALSE);
            }
            v.d(v.this).put(str, paramAnonymousk.tFe);
          }
          if (paramAnonymousk.tGc.size() > 0) {
            switch (((m)paramAnonymousk.tGc.get(0)).type)
            {
            default: 
              ae.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = v.e(v.this);
            v.a(v.this, paramAnonymousk.tCm.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)v.b(v.this).get(paramAnonymousk.tFe.tFC)).addAll(paramAnonymousk.tGc);
          }
          ae.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.tCm.query, Integer.valueOf(paramAnonymousk.bZU) });
          if (!paramAnonymousk.tCm.query.equals(v.f(v.this).get(v.this.KKu)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          v.e(v.this);
        }
      }
    };
    this.rgr = 1;
    this.KKB = 1;
    this.count = 0;
    this.KKs = paramList1;
    this.KKr = paramList2;
    this.fUR = paramList3;
    this.KJM = new ArrayList();
    Zm();
    AppMethodBeat.o(102893);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(102898);
    this.KKu = 0;
    fMF();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> aYt(String paramString)
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
      if (!bu.isNullOrNil(((String)localObject).trim())) {
        localLinkedList.add(localObject);
      }
      i += 1;
    }
    localLinkedList.addAll(this.KKv.keySet());
    if (this.KKt != null)
    {
      if (localLinkedList.size() != this.KKt.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.KKt.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.KKt == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.KKt;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.tGb != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tGb);
      this.tGb = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private void fMF()
  {
    AppMethodBeat.i(102897);
    this.KKo = new HashMap();
    this.KKq = new HashMap();
    this.KKn.clear();
    if (this.KKx != null)
    {
      this.KKx.close();
      this.KKx = null;
      this.KKy.clear();
      this.KKz.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean fMG()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.KJM.size() > 0) && (this.KKt.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.KJM.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.KKt.get(this.KKu));
      localj.tFV = new int[] { i };
      localj.tFY = ((HashSet)localObject);
      localj.tGa = this.KJN;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.jUf = 32;
      }
      for (localj.tFZ = com.tencent.mm.plugin.fts.a.c.a.tGy;; localj.tFZ = b.tGz)
      {
        this.tGb = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.jUf = 16;
      }
    }
    if (this.KKu < this.KKt.size() - 1)
    {
      this.KKu += 1;
      this.KJM.clear();
      localObject = this.KKw;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.KJM.add(Integer.valueOf(k));
        i += 1;
      }
      fMG();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void fML()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.KKs.size() < 41)
    {
      this.KGL.iB(this.fUR);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.KKs);
      ((List)localObject).addAll(this.KKr);
      this.KGL.iz((List)localObject);
      localObject = this.KGL.fMd();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.KKy.put(Integer.valueOf(0), this.KJi.getActivity().getString(2131762998));
        j = this.rgr;
        ae.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.g.ajS();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hP(this.fUR);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.KKy.put(Integer.valueOf(i), this.KJi.getActivity().getString(2131762985));
        this.KKz.put("☆", Integer.valueOf(i));
        i += this.rgr + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().c("@all.contact.without.chatroom", "", this.fUR));
      localObject = x.a(null, "@all.contact.without.chatroom", "", "", this.fUR);
      int[] arrayOfInt = x.a(null, "@all.contact.without.chatroom", "", this.fUR, "");
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
          this.KKy.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.KKz.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.KKx = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private static com.tencent.mm.ui.contact.a.a gQ(String paramString, int paramInt)
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
    if ((paramBoolean1) && (fMK()) && (this.KKs.size() < 3))
    {
      this.KGL.iB(this.fUR);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.KKs);
      ((List)localObject).addAll(this.KKr);
      this.KKn = this.KGL.c((List)localObject, this.KKo);
      if (this.KKn.size() > 0)
      {
        i = this.KKn.size() + this.rgr + 0;
        ae.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.KKn.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.KKt != null)
      {
        localObject = this.KKt.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.KKo.get(str) != null)
          {
            if (((List)this.KKo.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.KKo.get(str)).size();
            if ((fMK()) && (j > 3))
            {
              if (((Boolean)this.KKp.get(str)).booleanValue()) {
                i = this.rgr + j + this.KKB + i;
              } else {
                i = this.rgr + 3 + this.KKB + i;
              }
            }
            else {
              i = this.rgr + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!fMK())) {
          break label558;
        }
        ((List)this.KKo.get(paramString)).add(new m());
        j = this.rgr;
        i += ((List)this.KKo.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.KKA = j;
        if ((paramBoolean1) && (fMK())) {
          fML();
        }
        i = j;
        if (this.KKx != null) {
          i = j + (this.KKx.getCount() + this.KKy.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.KJh != null)) {
          this.KJh.y(paramString, getCount(), paramBoolean1);
        }
        ae.i("MicroMsg.MultiSearchContactAdapter", "updateHeaderPosition, query:%s, isFinish:%b, searchEnd:%b, count:%d", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(getCount()) });
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
  
  public final int aYn(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.KKz.get(paramString) != null)
    {
      int i = ((Integer)this.KKz.get(paramString)).intValue();
      int j = this.KKA;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int aYs(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.KKv.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.KGL.aYp(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
  }
  
  public final boolean aeX(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = aeW(paramInt - this.KJi.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.j))
    {
      Map localMap = this.KKp;
      String str = locala.query;
      if (!((Boolean)this.KKp.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        n(null, true, false);
        paramInt = this.KJi.getContentLV().getSelectedItemPosition();
        this.KJi.getContentLV().setSelection(paramInt);
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
      } while (bu.isNullOrNil(locala.query));
      bool1 = bool2;
    } while (!(locala instanceof e));
    if (this.KKr.contains(locala.contact.field_username)) {
      if (this.KKv.get(locala.query) != null) {
        ((LinkedList)this.KKv.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.KGL.reset();
      bool1 = bool2;
      break;
      if (this.KKv.get(locala.query) == null) {
        this.KKv.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.KKv.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.KKo = new HashMap();
    this.KKq = new HashMap();
    this.KKn.clear();
    if (this.KKx != null)
    {
      this.KKx.close();
      this.KKx = null;
      this.KKy.clear();
      this.KKz.clear();
    }
    this.count = 0;
    this.KKt = aYt(paramString);
    this.KKu = 0;
    this.KKw = paramArrayOfInt;
    this.KJM.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.KJM.add(Integer.valueOf(k));
      i += 1;
    }
    ae.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.KKt });
    fMG();
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
    if ((i >= this.KKA) && (this.KKy.get(Integer.valueOf(i - this.KKA)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.KKn.size() > 0) && (i == this.KKn.size() + this.rgr))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.KKA)
    {
      parama = rk(i);
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
    this.KKv.clear();
    this.KKp.clear();
    Zm();
    AppMethodBeat.o(102899);
  }
  
  public final int fLZ()
  {
    AppMethodBeat.i(102904);
    int i = this.KKn.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  final boolean fMK()
  {
    AppMethodBeat.i(102902);
    if ((this.KKt != null) && (this.KKt.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final boolean fMt()
  {
    AppMethodBeat.i(102903);
    boolean bool = fMK();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String fMu()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.KKv.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.KKv.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.KKr.contains(localObject4)) {
          ((LinkedList)this.KKv.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.KKv.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.KKv.get(localObject2)).size() == 0) {
        this.KKv.remove(localObject2);
      }
    }
    Object localObject2 = this.KKt.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.KKv.containsKey(localObject3)) {
        break label322;
      }
      localObject1 = (String)localObject1 + (String)localObject3 + " ";
    }
    label322:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (fMK()) {
          localObject2 = " ";
        }
      }
      ae.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102911);
    super.finish();
    ae.i("MicroMsg.MultiSearchContactAdapter", "finish!");
    clearData();
    AppMethodBeat.o(102911);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  protected final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    int m = 3;
    boolean bool = false;
    AppMethodBeat.i(102909);
    if (paramInt >= this.count)
    {
      ae.e("MicroMsg.MultiSearchContactAdapter", "createDataItem err %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
      AppMethodBeat.o(102909);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if ((this.KKn != null) && (this.KKn.size() > 0)) {
      if (paramInt < this.KKn.size() + this.rgr)
      {
        if (paramInt == 0)
        {
          localObject1 = gQ(this.KJi.getActivity().getString(2131762999), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)this.KKn.get(paramInt - this.rgr));
        localObject2 = new e(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((an)localObject1);
        if (x.wb(((aw)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KJk = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KNa = false;
        }
        for (((e)localObject2).KNp = true;; ((e)localObject2).KNp = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = dUh();
          ((com.tencent.mm.ui.contact.a.a)localObject2).KJk = this.KJk;
        }
      }
    }
    for (int i = this.KKn.size() + this.rgr + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.KKA)
      {
        localObject3 = this.KKt.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.KKo.get(localObject1) == null)
            {
              ae.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.KKo.get(localObject1)).size();
              if ((fMK()) && (j > 3))
              {
                if (((Boolean)this.KKp.get(localObject1)).booleanValue()) {
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
        if (paramInt < i + j + this.rgr + this.KKB)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.KKy.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = gQ((String)this.KKy.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.rgr + j + this.KKB + i;
              break;
              if (paramInt < i + j + this.rgr)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.rgr + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.KKA;
              j = 0;
              continue;
            }
            localObject1 = this.KKx;
            localObject2 = this.KKy.keySet().iterator();
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
            localObject1 = new an();
            ((an)localObject1).convertFrom(this.KKx);
            localObject2 = new e(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((an)localObject1);
            if (x.wb(((aw)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KJk = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KNa = false;
            }
            for (((e)localObject2).KNp = true;; ((e)localObject2).KNp = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = dUh();
              ((com.tencent.mm.ui.contact.a.a)localObject2).KJk = this.KJk;
            }
          }
          ae.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!fMK()) {
              localObject1 = this.KJi.getActivity().getResources().getString(2131759682);
            }
            localObject1 = gQ((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).tFe = ((com.tencent.mm.plugin.fts.a.a.h)this.KKq.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = this.scene;
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.KKo.get(localObject2)).size();
          if ((fMK()) && (!((Boolean)this.KKp.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              if (!((Boolean)this.KKp.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.j(paramInt);
              ((com.tencent.mm.ui.contact.a.j)localObject1).resId = 2131759682;
              ((com.tencent.mm.ui.contact.a.j)localObject1).tdC = bool;
              break;
            }
            localObject3 = (m)((List)this.KKo.get(localObject2)).get(j - 1);
            if (((m)localObject3).tGd > 0L)
            {
              localObject1 = new e(paramInt);
              ((e)localObject1).kno = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).KJj = dUh();
              ((e)localObject1).gxU = true;
              ((e)localObject1).tGM = (j + 1);
              ((e)localObject1).gf(((e)localObject1).kno.type, ((e)localObject1).kno.tEX);
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