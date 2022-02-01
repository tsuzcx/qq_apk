package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
  private c HtE;
  private g afbU;
  private List<String> affN;
  private Map<String, List<com.tencent.mm.plugin.fts.a.a.o>> affO;
  private Map<String, Boolean> affP;
  private Map<String, com.tencent.mm.plugin.fts.a.a.j> affQ;
  private List<String> affR;
  private List<String> affS;
  private List<String> affT;
  protected int affU;
  private Map<String, LinkedList<String>> affV;
  private int[] affW;
  private Cursor affX;
  private Map<Integer, String> affY;
  private Map<String, Integer> affZ;
  private List<Integer> affj;
  protected com.tencent.mm.plugin.fts.a.l affk;
  private int afga;
  private int afgb;
  private int count;
  private MMHandler handler;
  private List<String> lMF;
  private int zJM;
  
  public x(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102893);
    this.affN = new LinkedList();
    this.affO = null;
    this.affP = new HashMap();
    this.affQ = null;
    this.affU = 0;
    this.affV = new HashMap();
    this.affY = new HashMap();
    this.affZ = new HashMap();
    this.afga = 0;
    this.afbU = new g();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.affk = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.m paramAnonymousm)
      {
        AppMethodBeat.i(102892);
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102892);
          return;
          if ((x.a(x.this) == null) || (paramAnonymousm.FWt == null))
          {
            AppMethodBeat.o(102892);
            return;
          }
          x.a(x.this, paramAnonymousm.HtF);
          String str = paramAnonymousm.FWt.Hte;
          if (x.b(x.this).get(str) == null)
          {
            x.b(x.this).put(str, new LinkedList());
            if (x.c(x.this).get(str) == null) {
              x.c(x.this).put(str, Boolean.FALSE);
            }
            x.d(x.this).put(str, paramAnonymousm.FWt);
          }
          if (paramAnonymousm.HtF.size() > 0) {
            switch (((com.tencent.mm.plugin.fts.a.a.o)paramAnonymousm.HtF.get(0)).type)
            {
            default: 
              Log.i("MicroMsg.MultiSearchContactAdapter", "not support search type");
            }
          }
          for (;;)
          {
            boolean bool = x.e(x.this);
            x.a(x.this, paramAnonymousm.HpM.query, bool);
            AppMethodBeat.o(102892);
            return;
            ((List)x.b(x.this).get(paramAnonymousm.FWt.Hte)).addAll(paramAnonymousm.HtF);
          }
          Log.i("MicroMsg.MultiSearchContactAdapter", "search query:%s, err:%s", new Object[] { paramAnonymousm.HpM.query, Integer.valueOf(paramAnonymousm.resultCode) });
          if (!paramAnonymousm.HpM.query.equals(x.f(x.this).get(x.this.affU)))
          {
            AppMethodBeat.o(102892);
            return;
          }
          x.e(x.this);
        }
      }
    };
    this.zJM = 1;
    this.afgb = 1;
    this.count = 0;
    this.affS = paramList1;
    this.affR = paramList2;
    this.lMF = paramList3;
    this.affj = new ArrayList();
    aNi();
    AppMethodBeat.o(102893);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(102898);
    this.affU = 0;
    jyT();
    clearTask();
    clearCache();
    AppMethodBeat.o(102898);
  }
  
  private List<String> bBP(String paramString)
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
    localLinkedList.addAll(this.affV.keySet());
    if (this.affT != null)
    {
      if (localLinkedList.size() != this.affT.size())
      {
        AppMethodBeat.o(102895);
        return localLinkedList;
      }
      paramString = localLinkedList.iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (!this.affT.contains(localObject))
        {
          AppMethodBeat.o(102895);
          return localLinkedList;
        }
      }
    }
    if (this.affT == null)
    {
      AppMethodBeat.o(102895);
      return localLinkedList;
    }
    paramString = this.affT;
    AppMethodBeat.o(102895);
    return paramString;
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102896);
    if (this.HtE != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.HtE);
      this.HtE = null;
    }
    AppMethodBeat.o(102896);
  }
  
  private static com.tencent.mm.ui.contact.a.a ja(String paramString, int paramInt)
  {
    AppMethodBeat.i(102910);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt);
    localj.header = paramString;
    AppMethodBeat.o(102910);
    return localj;
  }
  
  private void jyT()
  {
    AppMethodBeat.i(102897);
    this.affO = new HashMap();
    this.affQ = new HashMap();
    this.affN.clear();
    if (this.affX != null)
    {
      this.affX.close();
      this.affX = null;
      this.affY.clear();
      this.affZ.clear();
    }
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102897);
  }
  
  private boolean jyU()
  {
    AppMethodBeat.i(102900);
    Object localObject;
    int i;
    if ((this.affj.size() > 0) && (this.affT.size() > 0))
    {
      localObject = new HashSet();
      i = ((Integer)this.affj.remove(0)).intValue();
      com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
      locall.query = ((String)this.affT.get(this.affU));
      locall.Htx = new int[] { i };
      locall.HtA = ((HashSet)localObject);
      locall.HtC = this.affk;
      locall.handler = this.handler;
      if (i == 131075) {
        locall.qRb = 32;
      }
      for (locall.HtB = com.tencent.mm.plugin.fts.a.c.a.Hud;; locall.HtB = b.Hue)
      {
        this.HtE = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
        AppMethodBeat.o(102900);
        return false;
        locall.qRb = 16;
      }
    }
    if (this.affU < this.affT.size() - 1)
    {
      this.affU += 1;
      this.affj.clear();
      localObject = this.affW;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        int k = localObject[i];
        this.affj.add(Integer.valueOf(k));
        i += 1;
      }
      jyU();
      AppMethodBeat.o(102900);
      return false;
    }
    AppMethodBeat.o(102900);
    return true;
  }
  
  private void jza()
  {
    AppMethodBeat.i(102908);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    int i;
    int j;
    if (this.affS.size() < 41)
    {
      this.afbU.nP(this.lMF);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.affS);
      ((List)localObject).addAll(this.affR);
      this.afbU.nN((List)localObject);
      localObject = this.afbU.jyg();
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        localArrayList.add(localObject);
        this.affY.put(Integer.valueOf(0), this.afex.getActivity().getString(a.h.select_contact_recommend_contact_catalog_name));
        j = this.zJM;
        Log.i("MicroMsg.MultiSearchContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
        i = j + i + 0;
        h.baF();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mY(this.lMF);
        this.count = ((Cursor)localObject).getCount();
        if (this.count <= 0) {
          break label470;
        }
        localArrayList.add(localObject);
        this.affY.put(Integer.valueOf(i), this.afex.getActivity().getString(a.h.select_contact_favour_contact_catalog_name));
        this.affZ.put("☆", Integer.valueOf(i));
        i += this.zJM + this.count;
      }
    }
    for (;;)
    {
      h.baF();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().f("@all.contact.without.chatroom", "", this.lMF));
      localObject = ab.a(null, "@all.contact.without.chatroom", "", "", this.lMF);
      int[] arrayOfInt = ab.a(null, "@all.contact.without.chatroom", "", this.lMF, "");
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
          this.affY.put(Integer.valueOf(arrayOfInt[i] + j), localObject[i]);
          this.affZ.put(localObject[i], Integer.valueOf(arrayOfInt[i] + j));
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
    this.affX = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    AppMethodBeat.o(102908);
  }
  
  private void u(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102901);
    Object localObject;
    int i;
    if ((paramBoolean1) && (jyZ()) && (this.affS.size() < 3))
    {
      this.afbU.nP(this.lMF);
      localObject = new LinkedList();
      ((List)localObject).addAll(this.affS);
      ((List)localObject).addAll(this.affR);
      this.affN = this.afbU.d((List)localObject, this.affO);
      if (this.affN.size() > 0)
      {
        i = this.affN.size() + this.zJM + 0;
        Log.i("MicroMsg.MultiSearchContactAdapter", "recommend chatroom size:%d", new Object[] { Integer.valueOf(this.affN.size()) });
      }
    }
    for (;;)
    {
      int j;
      if (this.affT != null)
      {
        localObject = this.affT.iterator();
        String str;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label414;
          }
          str = (String)((Iterator)localObject).next();
          if (this.affO.get(str) != null)
          {
            if (((List)this.affO.get(str)).size() <= 0) {
              break;
            }
            j = ((List)this.affO.get(str)).size();
            if ((jyZ()) && (j > 3))
            {
              if (((Boolean)this.affP.get(str)).booleanValue()) {
                i = this.zJM + j + this.afgb + i;
              } else {
                i = this.zJM + 3 + this.afgb + i;
              }
            }
            else {
              i = this.zJM + j + i;
            }
          }
        }
        if ((!paramBoolean1) || (!jyZ())) {
          break label558;
        }
        ((List)this.affO.get(paramString)).add(new com.tencent.mm.plugin.fts.a.a.o());
        j = this.zJM;
        i += ((List)this.affO.get(str)).size() + j;
      }
      label414:
      label558:
      for (;;)
      {
        break;
        j = i;
        this.afga = j;
        if ((paramBoolean1) && (jyZ())) {
          jza();
        }
        i = j;
        if (this.affX != null) {
          i = j + (this.affX.getCount() + this.affY.size());
        }
        this.count = i;
        if ((paramBoolean2) && (this.afew != null)) {
          this.afew.h(paramString, getCount(), paramBoolean1);
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
    this.affO = new HashMap();
    this.affQ = new HashMap();
    this.affN.clear();
    if (this.affX != null)
    {
      this.affX.close();
      this.affX = null;
      this.affY.clear();
      this.affZ.clear();
    }
    this.count = 0;
    this.affT = bBP(paramString);
    this.affU = 0;
    this.affW = paramArrayOfInt;
    this.affj.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.affj.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MultiSearchContactAdapter", "doSearch: queryString:%s, queryWords:%s", new Object[] { paramString, this.affT });
    jyU();
    AppMethodBeat.o(102894);
  }
  
  public final boolean aDu(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(102913);
    com.tencent.mm.ui.contact.a.a locala = aDt(paramInt - this.afex.getContentLV().getHeaderViewsCount());
    boolean bool1;
    if ((locala instanceof com.tencent.mm.ui.contact.a.m))
    {
      Map localMap = this.affP;
      String str = locala.query;
      if (!((Boolean)this.affP.get(locala.query)).booleanValue())
      {
        bool1 = true;
        localMap.put(str, Boolean.valueOf(bool1));
        u(null, true, false);
        paramInt = this.afex.getContentLV().getSelectedItemPosition();
        this.afex.getContentLV().setSelection(paramInt);
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
    if (this.affR.contains(locala.contact.field_username)) {
      if (this.affV.get(locala.query) != null) {
        ((LinkedList)this.affV.get(locala.query)).remove(locala.contact.field_username);
      }
    }
    for (;;)
    {
      this.afbU.reset();
      bool1 = bool2;
      break;
      if (this.affV.get(locala.query) == null) {
        this.affV.put(locala.query, new LinkedList());
      }
      ((LinkedList)this.affV.get(locala.query)).add(locala.contact.field_username);
    }
  }
  
  public final int aJM(String paramString)
  {
    AppMethodBeat.i(102906);
    if (this.affZ.get(paramString) != null)
    {
      int i = ((Integer)this.affZ.get(paramString)).intValue();
      int j = this.afga;
      AppMethodBeat.o(102906);
      return i + j;
    }
    AppMethodBeat.o(102906);
    return 0;
  }
  
  public final int bBO(String paramString)
  {
    AppMethodBeat.i(102905);
    Iterator localIterator = this.affV.values().iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramString))
      {
        AppMethodBeat.o(102905);
        return 3;
      }
    }
    if (this.afbU.bBJ(paramString))
    {
      AppMethodBeat.o(102905);
      return 4;
    }
    AppMethodBeat.o(102905);
    return 0;
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102899);
    this.affV.clear();
    this.affP.clear();
    aNi();
    AppMethodBeat.o(102899);
  }
  
  protected final boolean d(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(102912);
    int i = parama.position + 1;
    if (i >= this.count)
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((i >= this.afga) && (this.affY.get(Integer.valueOf(i - this.afga)) != null))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if ((this.affN.size() > 0) && (i == this.affN.size() + this.zJM))
    {
      AppMethodBeat.o(102912);
      return true;
    }
    if (i < this.afga)
    {
      parama = yk(i);
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
  
  public final boolean jyB()
  {
    AppMethodBeat.i(102903);
    boolean bool = jyZ();
    AppMethodBeat.o(102903);
    return bool;
  }
  
  public final String jyC()
  {
    AppMethodBeat.i(102907);
    Object localObject1 = this.affV.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (String[])((LinkedList)this.affV.get(localObject2)).toArray(new String[0]);
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!this.affR.contains(localObject4)) {
          ((LinkedList)this.affV.get(localObject2)).remove(localObject4);
        }
        i += 1;
      }
    }
    localObject1 = this.affV.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (((LinkedList)this.affV.get(localObject2)).size() == 0) {
        this.affV.remove(localObject2);
      }
    }
    Object localObject2 = this.affT.iterator();
    localObject1 = "";
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.affV.containsKey(localObject3)) {
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
        if (jyZ()) {
          localObject2 = " ";
        }
      }
      Log.i("MicroMsg.MultiSearchContactAdapter", "getRealSearchText %s", new Object[] { localObject2 });
      AppMethodBeat.o(102907);
      return localObject2;
    }
  }
  
  final boolean jyZ()
  {
    AppMethodBeat.i(102902);
    if ((this.affT != null) && (this.affT.size() > 1))
    {
      AppMethodBeat.o(102902);
      return true;
    }
    AppMethodBeat.o(102902);
    return false;
  }
  
  public final int jyc()
  {
    AppMethodBeat.i(102904);
    int i = this.affN.size();
    AppMethodBeat.o(102904);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
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
    if ((this.affN != null) && (this.affN.size() > 0)) {
      if (paramInt < this.affN.size() + this.zJM)
      {
        if (paramInt == 0)
        {
          localObject1 = ja(this.afex.getActivity().getString(a.h.select_contact_recommend_group_catalog_name), paramInt);
          AppMethodBeat.o(102909);
          return localObject1;
        }
        h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)this.affN.get(paramInt - this.zJM));
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
        if (au.bwE(((az)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).afey = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afez = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afjA = false;
        }
        for (((f)localObject2).afjT = true;; ((f)localObject2).afjT = false)
        {
          AppMethodBeat.o(102909);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
          ((com.tencent.mm.ui.contact.a.a)localObject2).afez = jyD();
        }
      }
    }
    for (int i = this.affN.size() + this.zJM + 0;; i = 0)
    {
      localObject2 = null;
      Object localObject3;
      int j;
      if (paramInt < this.afga)
      {
        localObject3 = this.affT.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = (String)((Iterator)localObject3).next();
            if (this.affO.get(localObject1) == null)
            {
              Log.w("MicroMsg.MultiSearchContactAdapter", "word:%s, position:%d, count:%d", new Object[] { localObject1, Integer.valueOf(paramInt), Integer.valueOf(this.count) });
            }
            else
            {
              j = ((List)this.affO.get(localObject1)).size();
              if ((jyZ()) && (j > 3))
              {
                if (((Boolean)this.affP.get(localObject1)).booleanValue()) {
                  break label1150;
                }
                j = 3;
              }
            }
          }
        }
      }
      label1147:
      label1150:
      for (;;)
      {
        int k;
        if (paramInt < i + j + this.zJM + this.afgb)
        {
          j = paramInt - i;
          localObject2 = localObject1;
          k = i;
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if (this.affY.get(Integer.valueOf(paramInt - k)) != null)
            {
              localObject1 = ja((String)this.affY.get(Integer.valueOf(paramInt - k)), paramInt);
              AppMethodBeat.o(102909);
              return localObject1;
              i = this.zJM + j + this.afgb + i;
              break;
              if (paramInt < i + j + this.zJM)
              {
                j = paramInt - i;
                k = i;
                localObject2 = localObject1;
                continue;
              }
              i = this.zJM + j + i;
              break;
              j = 0;
              k = i;
              continue;
              k = this.afga;
              j = 0;
              continue;
            }
            localObject1 = this.affX;
            localObject2 = this.affY.keySet().iterator();
            i = 0;
            if (((Iterator)localObject2).hasNext())
            {
              if (paramInt - k <= ((Integer)((Iterator)localObject2).next()).intValue()) {
                break label1147;
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
            localObject1 = new au();
            ((au)localObject1).convertFrom(this.affX);
            localObject2 = new f(paramInt);
            ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
            if (au.bwE(((az)localObject1).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject2).afey = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).afez = false;
              ((com.tencent.mm.ui.contact.a.a)localObject2).afjA = false;
            }
            for (((f)localObject2).afjT = true;; ((f)localObject2).afjT = false)
            {
              AppMethodBeat.o(102909);
              return localObject2;
              ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
              ((com.tencent.mm.ui.contact.a.a)localObject2).afez = jyD();
            }
          }
          Log.e("MicroMsg.MultiSearchContactAdapter", "create contact item error: position=%d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.count) });
          AppMethodBeat.o(102909);
          return null;
          if (j == 0)
          {
            localObject1 = "\"" + (String)localObject2 + "\"";
            if (!jyZ()) {
              localObject1 = this.afex.getActivity().getResources().getString(a.h.fts_header_contact);
            }
            localObject1 = ja((String)localObject1, paramInt);
            if (localObject1 != null)
            {
              ((com.tencent.mm.ui.contact.a.a)localObject1).query = ((String)localObject2);
              ((com.tencent.mm.ui.contact.a.a)localObject1).FWt = ((com.tencent.mm.plugin.fts.a.a.j)this.affQ.get(localObject2));
              ((com.tencent.mm.ui.contact.a.a)localObject1).scene = getScene();
            }
            AppMethodBeat.o(102909);
            return localObject1;
          }
          i = ((List)this.affO.get(localObject2)).size();
          if ((jyZ()) && (!((Boolean)this.affP.get(localObject2)).booleanValue())) {
            i = m;
          }
          for (;;)
          {
            if (j > i)
            {
              i = a.h.fts_header_contact;
              if (!((Boolean)this.affP.get(localObject2)).booleanValue()) {
                bool = true;
              }
              localObject1 = new com.tencent.mm.ui.contact.a.m(paramInt);
              ((com.tencent.mm.ui.contact.a.m)localObject1).resId = i;
              ((com.tencent.mm.ui.contact.a.m)localObject1).Gxy = bool;
              break;
            }
            localObject3 = (com.tencent.mm.plugin.fts.a.a.o)((List)this.affO.get(localObject2)).get(j - 1);
            if (((com.tencent.mm.plugin.fts.a.a.o)localObject3).HtG > 0L)
            {
              localObject1 = new f(paramInt);
              ((f)localObject1).rpp = ((com.tencent.mm.plugin.fts.a.a.o)localObject3);
              ((com.tencent.mm.ui.contact.a.a)localObject1).afey = gZe();
              ((f)localObject1).mwk = true;
              ((f)localObject1).Huq = (j + 1);
              ((f)localObject1).iW(((f)localObject1).rpp.type, ((f)localObject1).rpp.subtype);
              break;
            }
            localObject1 = new com.tencent.mm.ui.contact.a.l(paramInt);
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