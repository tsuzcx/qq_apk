package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class x
  extends p
{
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  private g Xqt;
  private List<Integer> XtF;
  protected com.tencent.mm.plugin.fts.a.l XtG;
  private List<String> Xuh;
  private Map<String, List<m>> Xui;
  private Map<String, Boolean> Xuj;
  private Map<String, com.tencent.mm.plugin.fts.a.a.h> Xuk;
  private List<String> Xul;
  private List<String> Xum;
  private List<String> Xun;
  protected int Xuo;
  private Map<String, LinkedList<String>> Xup;
  private int[] Xuq;
  private Cursor Xur;
  private Map<Integer, String> Xus;
  private Map<String, Integer> Xut;
  private int Xuu;
  private int Xuv;
  private int count;
  private MMHandler handler;
  private List<String> jkb;
  private int wnI;
  
  public x(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.Xuh = new LinkedList();
    this.Xui = null;
    this.Xuj = new HashMap();
    this.Xuk = null;
    this.Xuo = 0;
    this.Xup = new HashMap();
    this.Xus = new HashMap();
    this.Xut = new HashMap();
    this.Xuu = 0;
    this.Xqt = new g();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XtG = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.k paramAnonymousk)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((x.a(x.this) == null) || (paramAnonymousk.BHY == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          x.a(x.this, paramAnonymousk.BIW);
          String str = paramAnonymousk.BHY.BIw;
          if (x.b(x.this).get(str) == null)
          {
            x.b(x.this).put(str, new LinkedList());
            if (x.c(x.this).get(str) == null) {
              x.c(x.this).put(str, Boolean.FALSE);
            }
            x.d(x.this).put(str, paramAnonymousk.BHY);
          }
          if (paramAnonymousk.BIW.size() > 0) {
            switch (((m)paramAnonymousk.BIW.get(0)).type)
            {
            default: 
              Log.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = x.e(x.this);
            x.a(x.this, paramAnonymousk.BFk.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)x.b(x.this).get(paramAnonymousk.BHY.BIw)).addAll(paramAnonymousk.BIW);
          }
          Log.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousk.BFk.query, Integer.valueOf(paramAnonymousk.resultCode) });
          if (!paramAnonymousk.BFk.query.equals(x.f(x.this).get(x.this.Xuo)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          x.e(x.this);
        }
      }
    };
    this.wnI = 1;
    this.Xuv = 1;
    this.count = 0;
    this.Xum = paramList1;
    this.Xul = paramList2;
    this.jkb = paramList3;
    this.XtF = new ArrayList();
    ata();
    AppMethodBeat.o(102893);
  }
  
  private void ata()
  {
    AppMethodBeat.i(102898);
    this.Xuo = 0;
    hVf();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> bAa(String paramString)
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
    localLinkedList.addAll(this.Xup.keySet());
    if (this.Xun != null)
    {
      if (localLinkedList.size() != this.Xun.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.Xun.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.Xun == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.Xun;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.BIV != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.BIV);
      this.BIV = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private static com.tencent.mm.ui.contact.a.a hS(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt);
    localj.header = paramString;
    AppMethodBeat.o(102910);
    return localj;
  }
  
  private void hVf()
  {
    AppMethodBeat.i(102897);
    this.Xui = new HashMap();
    this.Xuk = new HashMap();
    this.Xuh.clear();
    if (this.Xur != null)
    {
      this.Xur.close();
      this.Xur = null;
      this.Xus.clear();
      this.Xut.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean hVg()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.XtF.size() > 0) && (this.Xun.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.XtF.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
      localj.query = ((String)this.Xun.get(this.Xuo));
      localj.BIP = new int[] { i };
      localj.BIS = ((HashSet)localObject);
      localj.BIU = this.XtG;
      localj.handler = this.handler;
      if (i == 131075) {
        localj.nRn = 32;
      }
      for (localj.BIT = com.tencent.mm.plugin.fts.a.c.a.BJt;; localj.BIT = b.BJu)
      {
        this.BIV = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(102900);
        return false;
        localj.nRn = 16;
      }
    }
    if (this.Xuo < this.Xun.size() - 1)
    {
      this.Xuo += 1;
      this.XtF.clear();
      localObject = this.Xuq;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.XtF.add(Integer.valueOf(k));
        i += 1;
      }
      hVg();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void hVl()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.Xum.size() < 41)
    {
      this.Xqt.kz(this.jkb);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.Xum);
      ((List)localObject).addAll(this.Xul);
      this.Xqt.kx((List)localObject);
      localObject = this.Xqt.hUq();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.Xus.put(Integer.valueOf(0), this.XsW.getActivity().getString(a.h.select_contact_recommend_contact_catalog_name));
        j = this.wnI;
        Log.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        com.tencent.mm.kernel.h.aHH();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().jL(this.jkb);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.Xus.put(Integer.valueOf(i), this.XsW.getActivity().getString(a.h.select_contact_favour_contact_catalog_name));
        this.Xut.put("☆", Integer.valueOf(i));
        i += this.wnI + this.count;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().d("@all.contact.without.chatroom", "", this.jkb));
      localObject = ab.a(null, "@all.contact.without.chatroom", "", "", this.jkb);
      int[] arrayOfInt = ab.a(null, "@all.contact.without.chatroom", "", this.jkb, "");
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
          this.Xus.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.Xut.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.Xur = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private void q(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (hVk()) && (this.Xum.size() < 3))
    {
      this.Xqt.kz(this.jkb);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.Xum);
      ((List)localObject).addAll(this.Xul);
      this.Xuh = this.Xqt.c((List)localObject, this.Xui);
      if (this.Xuh.size() > 0)
      {
        i = this.Xuh.size() + this.wnI + 0;
        Log.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.Xuh.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.Xun != null)
      {
        localObject = this.Xun.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.Xui.get(str) != null)
          {
            if (((List)this.Xui.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.Xui.get(str)).size();
            if ((hVk()) && (j > 3))
            {
              if (((Boolean)this.Xuj.get(str)).booleanValue()) {
                i = this.wnI + j + this.Xuv + i;
              } else {
                i = this.wnI + 3 + this.Xuv + i;
              }
            }
            else {
              i = this.wnI + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!hVk())) {
          break label558;
        }
        ((List)this.Xui.get(paramString)).add(new m());
        j = this.wnI;
        i += ((List)this.Xui.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.Xuu = j;
        if ((paramBoolean1) && (hVk())) {
          hVl();
        }
        i = j;
        if (this.Xur != null) {
          i = j + (this.Xur.getCount() + this.Xus.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.XsV != null)) {
          this.XsV.g(paramString, getCount(), paramBoolean1);
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
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102894);
    this.Xui = new HashMap();
    this.Xuk = new HashMap();
    this.Xuh.clear();
    if (this.Xur != null)
    {
      this.Xur.close();
      this.Xur = null;
      this.Xus.clear();
      this.Xut.clear();
    }
    this.count = 0;
    this.Xun = bAa(paramString);
    this.Xuo = 0;
    this.Xuq = paramArrayOfInt;
    this.XtF.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.XtF.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.Xun });
    hVg();
    AppMethodBeat.o(102894);
  }
  
  public final boolean awN(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = awM(paramInt - this.XsW.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.l))
    {
      Map localMap = this.Xuj;
      String str = locala.query;
      if (!((Boolean)this.Xuj.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        q(null, true, false);
        paramInt = this.XsW.getContentLV().getSelectedItemPosition();
        this.XsW.getContentLV().setSelection(paramInt);
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
    } while (!(locala instanceof f));
    if (this.Xul.contains(locala.contact.field_username)) {
      if (this.Xup.get(locala.query) != null) {
        ((LinkedList)this.Xup.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.Xqt.reset();
      bool1 = bool2;
      break;
      if (this.Xup.get(locala.query) == null) {
        this.Xup.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.Xup.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final int bzR(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.Xut.get(paramString) != null)
    {
      int i = ((Integer)this.Xut.get(paramString)).intValue();
      int j = this.Xuu;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int bzZ(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.Xup.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.Xqt.bzT(paramString))
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
    if ((i >= this.Xuu) && (this.Xus.get(Integer.valueOf(i - this.Xuu)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.Xuh.size() > 0) && (i == this.Xuh.size() + this.wnI))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.Xuu)
    {
      parama = ye(i);
      if ((parama == null) && ((parama instanceof com.tencent.mm.ui.contact.a.j)))
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
    this.Xup.clear();
    this.Xuj.clear();
    ata();
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
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final boolean hUK()
  {
    AppMethodBeat.i(102903);
    boolean bool = hVk();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String hUL()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.Xup.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.Xup.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.Xul.contains(localObject4)) {
          ((LinkedList)this.Xup.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.Xup.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.Xup.get(localObject2)).size() == 0) {
        this.Xup.remove(localObject2);
      }
    }
    Object localObject2 = this.Xun.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.Xup.containsKey(localObject3)) {
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
        if (hVk()) {
          localObject2 = " ";
        }
      }
      Log.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  public final int hUm()
  {
    AppMethodBeat.i(102904);
    int i = this.Xuh.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  final boolean hVk()
  {
    AppMethodBeat.i(102902);
    if ((this.Xun != null) && (this.Xun.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
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
    if ((this.Xuh != null) && (this.Xuh.size() > 0)) {
      if (paramInt < this.Xuh.size() + this.wnI)
      {
        if (paramInt == 0)
        {
          localObject1 = hS(this.XsW.getActivity().getString(a.h.select_contact_recommend_group_catalog_name), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)this.Xuh.get(paramInt - this.wnI));
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
        if (ab.Lj(((ax)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Xxs = false;
        }
        for (((f)localObject2).XxM = true;; ((f)localObject2).XxM = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = hUO();
        }
      }
    }
    for (int i = this.Xuh.size() + this.wnI + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.Xuu)
      {
        localObject3 = this.Xun.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.Xui.get(localObject1) == null)
            {
              Log.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.Xui.get(localObject1)).size();
              if ((hVk()) && (j > 3))
              {
                if (((Boolean)this.Xuj.get(localObject1)).booleanValue()) {
                  break label1145;
                }
                j = 3;
              }
            }
          }
        }
      }
      label1142:
      label1145:
      for (;;)
      {
        int k;
        if (paramInt < i + j + this.wnI + this.Xuv)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.Xus.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = hS((String)this.Xus.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.wnI + j + this.Xuv + i;
              break;
              if (paramInt < i + j + this.wnI)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.wnI + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.Xuu;
              j = 0;
              continue;
            }
            localObject1 = this.Xur;
            localObject2 = this.Xus.keySet().iterator();
            i = 0;
            if (((Iterator)localObject2).hasNext())
            {
              if (paramInt - k <= ((Integer)((Iterator)localObject2).next()).intValue()) {
                break label1142;
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
            ((as)localObject1).convertFrom(this.Xur);
            localObject2 = new f(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
            if (ab.Lj(((ax)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).Xxs = false;
            }
            for (((f)localObject2).XxM = true;; ((f)localObject2).XxM = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
              ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = hUO();
            }
          }
          Log.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!hVk()) {
              localObject1 = this.XsW.getActivity().getResources().getString(a.h.fts_header_contact);
            }
            localObject1 = hS((String)localObject1, paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
            ((com.tencent.mm.ui.contact.a.a)localObject1).BHY = ((com.tencent.mm.plugin.fts.a.a.h)this.Xuk.get(localObject2));
            ((com.tencent.mm.ui.contact.a.a)localObject1).scene = getScene();
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.Xui.get(localObject2)).size();
          if ((hVk()) && (!((Boolean)this.Xuj.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              i = a.h.fts_header_contact;
              if (!((Boolean)this.Xuj.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.l(paramInt);
              ((com.tencent.mm.ui.contact.a.l)localObject1).resId = i;
              ((com.tencent.mm.ui.contact.a.l)localObject1).AUY = bool;
              break;
            }
            localObject3 = (m)((List)this.Xui.get(localObject2)).get(j - 1);
            if (((m)localObject3).BIX > 0L)
            {
              localObject1 = new f(paramInt);
              ((f)localObject1).olG = ((m)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).XsX = fJk();
              ((f)localObject1).jWq = true;
              ((f)localObject1).BJH = (j + 1);
              ((f)localObject1).hx(((f)localObject1).olG.type, ((f)localObject1).olG.BHR);
              break;
            }
            localObject1 = new com.tencent.mm.ui.contact.a.k(paramInt);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */