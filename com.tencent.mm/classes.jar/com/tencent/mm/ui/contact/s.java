package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class s
  extends o
{
  protected int Kki;
  private int Kkj;
  private List<String> Kni;
  private int Knj;
  private int Knk;
  private int Knl;
  private boolean Knm;
  private int Knn;
  private boolean Kno;
  private int Knp;
  private List<m> Knq;
  private List<m> Knr;
  private List<Integer> Kns;
  protected l Knt;
  private int count;
  private List<m> fPS;
  private ap handler;
  protected String query;
  private com.tencent.mm.plugin.fts.a.a.h tun;
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  protected List<m> txG;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.Knj = 2147483647;
    this.Knk = 2147483647;
    this.Knl = 2147483647;
    this.Knm = true;
    this.Knn = 2147483647;
    this.Kki = 2147483647;
    this.Kno = true;
    this.Knp = 2147483647;
    this.Kkj = 2147483647;
    this.Knq = null;
    this.fPS = null;
    this.txG = null;
    this.Knr = null;
    this.handler = new ap(Looper.getMainLooper());
    this.Knt = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102870);
        switch (paramAnonymousk.bZU)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((s.a(s.this) != null) && (s.a(s.this).equals(s.a(s.this))))
          {
            s.a(s.this, paramAnonymousk.tun);
            s.this.iw(paramAnonymousk.tvl);
            if (paramAnonymousk.tvl.size() > 0) {
              switch (((m)paramAnonymousk.tvl.get(0)).type)
              {
              default: 
                ad.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = s.c(s.this);
              s.a(s.this, paramAnonymousk.trv.query, bool);
              AppMethodBeat.o(102870);
              return;
              s.a(s.this, paramAnonymousk.tvl);
              continue;
              s.this.txG = paramAnonymousk.tvl;
              continue;
              s.b(s.this, paramAnonymousk.tvl);
              continue;
              if (s.b(s.this) != null) {
                s.b(s.this).addAll(paramAnonymousk.tvl);
              } else {
                s.a(s.this, paramAnonymousk.tvl);
              }
            }
            if (!paramAnonymousk.trv.query.equals(s.this.query))
            {
              AppMethodBeat.o(102870);
              return;
            }
            s.c(s.this);
          }
        }
      }
    };
    this.count = 0;
    this.Kni = paramList;
    this.Kns = new ArrayList();
    ad.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Zd();
    AppMethodBeat.o(102871);
  }
  
  private static com.tencent.mm.ui.contact.a.a H(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.resId = paramInt1;
    localj.sSq = paramBoolean;
    AppMethodBeat.o(102883);
    return localj;
  }
  
  private void Zd()
  {
    AppMethodBeat.i(102876);
    ad.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    fIn();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.tvk != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tvk);
      this.tvk = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void fIn()
  {
    AppMethodBeat.i(102875);
    this.Knk = 2147483647;
    this.Knl = 2147483647;
    this.Knm = true;
    this.Knn = 2147483647;
    this.Kki = 2147483647;
    this.Kno = true;
    this.Knp = 2147483647;
    this.Kkj = 2147483647;
    this.Knq = null;
    this.fPS = null;
    this.txG = null;
    this.Knr = null;
    this.tun = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean fIo()
  {
    AppMethodBeat.i(102878);
    if (this.Kns.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.Knq != null)
      {
        localObject = this.Knq.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).tuh);
        }
      }
      int i = ((Integer)this.Kns.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tve = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvh = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvj = this.Knt;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jQN = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).tvi = com.tencent.mm.plugin.fts.a.c.a.tvH;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvi = b.tvI)
      {
        this.tvk = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jQN = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private static int ix(List<? extends Object> paramList)
  {
    AppMethodBeat.i(102881);
    if (paramList == null)
    {
      AppMethodBeat.o(102881);
      return 0;
    }
    int i = paramList.size();
    AppMethodBeat.o(102881);
    return i;
  }
  
  private com.tencent.mm.ui.contact.a.a jT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt2);
    localh.header = this.KmO.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localh;
  }
  
  private void n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = ix(this.Knq);
    int m = ix(this.fPS);
    int k = ix(this.txG);
    int j = ix(this.Knr);
    if (i > 0)
    {
      this.Knk = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.Knl = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.Knm) {
        break label280;
      }
      i += 4;
      this.Knn = i;
      i += 1;
      label112:
      if ((this.tun == null) || (this.tun.tuN.length <= 1) || (dQK())) {
        break label331;
      }
      this.Knj = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.Kki = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.Kno) {
        break label340;
      }
      i += 4;
      this.Knp = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.Kkj = i;
      i += j + 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        cT(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.Knk = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.Knn = i;
      i += 1;
      break label112;
      label304:
      this.Knn = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.Knl = 2147483647;
      break label112;
      label331:
      this.Knj = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.Knp = i;
      i += 1;
      break label197;
      label364:
      this.Knp = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.Kki = 2147483647;
      break label197;
      label391:
      this.Kkj = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a Rx(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.Kki - 1;
    c localc = new c(paramInt);
    localc.kjY = ((m)this.txG.get(i));
    localc.KmP = dQK();
    localc.gvn = true;
    localc.tvV = (i + 1);
    localc.gf(localc.kjY.type, localc.kjY.tug);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public final boolean aeo(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.KmO.getContentLV().getHeaderViewsCount();
    if (paramInt == this.Knn) {
      if (this.Knm)
      {
        paramInt = this.KmO.getContentLV().getSelectedItemPosition();
        this.Knm = false;
        n(this.query, true, false);
        this.KmO.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.Knm = true;
      n(this.query, true, false);
      this.KmO.getContentLV().setSelection(this.Knn);
      continue;
      if (paramInt == this.Knp)
      {
        if (this.Kno)
        {
          paramInt = this.KmO.getContentLV().getSelectedItemPosition();
          this.Kno = false;
          n(this.query, true, false);
          this.KmO.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.Kno = true;
          n(this.query, true, false);
          this.KmO.getContentLV().setSelection(this.Knp);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = aen(paramInt);
        if ((locala != null) && (locala.gvn) && (this.Knj != 2147483647))
        {
          if (locala.position == this.Knj)
          {
            ac.aep(1);
            bool = false;
          }
          else
          {
            ac.aep(0);
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  public void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102873);
    clearTask();
    this.query = paramString;
    this.Kns.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.Kns.add(Integer.valueOf(k));
      i += 1;
    }
    ad.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    fIo();
    AppMethodBeat.o(102873);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.Knk;
    int m = this.Knl;
    int n = this.Kki;
    int i1 = this.Kkj;
    int i = 0;
    while (i < 4)
    {
      if (j + 1 == new int[] { k, m, n, i1 }[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void cT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.KmN != null) {
      this.KmN.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    Zd();
    AppMethodBeat.o(102877);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    ad.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Zd();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void iw(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.Kni == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.Kni.contains(localm.tuh))
      {
        j = localm.type;
        if ((j != 131072) && (j != 131075) && (j != 131076) && (j != 131081)) {
          break label116;
        }
      }
      label116:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          paramList.remove(i);
        }
        i -= 1;
        break;
      }
    }
    AppMethodBeat.o(102880);
  }
  
  protected com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject = null;
    if (paramInt == this.Knj)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).gvn = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).tun = this.tun;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.Knk)
      {
        localObject = jT(2131759698, paramInt);
      }
      else if (paramInt == this.Knl)
      {
        localObject = jT(2131759682, paramInt);
      }
      else if (paramInt == this.Kki)
      {
        localObject = jT(2131759681, paramInt);
      }
      else if (paramInt == this.Kkj)
      {
        localObject = jT(2131759679, paramInt);
      }
      else if (paramInt == this.Knn)
      {
        localObject = H(2131759682, paramInt, this.Knm);
      }
      else if (paramInt == this.Knp)
      {
        localObject = H(2131759681, paramInt, this.Kno);
      }
      else
      {
        int i;
        if (paramInt > this.Kkj)
        {
          i = paramInt - this.Kkj - 1;
          localObject = new e(paramInt);
          ((e)localObject).kjY = ((m)this.Knr.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).KmP = dQK();
          ((e)localObject).gvn = true;
          ((e)localObject).tvV = (i + 1);
          ((e)localObject).gf(((e)localObject).kjY.type, ((e)localObject).kjY.tug);
        }
        else if (paramInt > this.Kki)
        {
          localObject = Rx(paramInt);
        }
        else if (paramInt > this.Knl)
        {
          i = paramInt - this.Knl - 1;
          localObject = new e(paramInt);
          ((e)localObject).kjY = ((m)this.fPS.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).KmP = dQK();
          ((e)localObject).gvn = true;
          ((e)localObject).tvV = (i + 1);
          ((e)localObject).gf(((e)localObject).kjY.type, ((e)localObject).kjY.tug);
        }
        else if (paramInt > this.Knk)
        {
          i = paramInt - this.Knk - 1;
          m localm = (m)this.Knq.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).kjY = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).KmP = dQK();
            ((e)localObject).KqJ = true;
            ((e)localObject).gvn = true;
            ((e)localObject).tvV = (i + 1);
            ((e)localObject).gf(((e)localObject).kjY.type, ((e)localObject).kjY.tug);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).kjY = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).KmP = dQK();
            ((c)localObject).KqJ = true;
            ((c)localObject).gvn = true;
            ((c)localObject).tvV = (i + 1);
            ((c)localObject).gf(((c)localObject).kjY.type, ((c)localObject).kjY.tug);
          }
          else
          {
            ad.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(localm.type) });
            localObject = null;
          }
        }
        else
        {
          ad.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */