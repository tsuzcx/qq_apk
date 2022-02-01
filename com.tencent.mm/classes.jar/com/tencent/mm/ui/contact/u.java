package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class u
  extends p
{
  private boolean Bva;
  private com.tencent.mm.plugin.fts.a.a.j FWt;
  private com.tencent.mm.plugin.fts.a.a.c HtE;
  protected List<com.tencent.mm.plugin.fts.a.a.o> Hwr;
  protected int afbN;
  private int afbO;
  private List<String> afeX;
  private int affa;
  private int affb;
  private int affc;
  private boolean affd;
  private int affe;
  private boolean afff;
  private int affg;
  private List<com.tencent.mm.plugin.fts.a.a.o> affh;
  private List<com.tencent.mm.plugin.fts.a.a.o> affi;
  private List<Integer> affj;
  protected com.tencent.mm.plugin.fts.a.l affk;
  private int count;
  private MMHandler handler;
  private List<com.tencent.mm.plugin.fts.a.a.o> lDu;
  protected String query;
  
  public u(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.affa = 2147483647;
    this.affb = 2147483647;
    this.affc = 2147483647;
    this.affd = true;
    this.affe = 2147483647;
    this.afbN = 2147483647;
    this.afff = true;
    this.affg = 2147483647;
    this.afbO = 2147483647;
    this.affh = null;
    this.lDu = null;
    this.Hwr = null;
    this.affi = null;
    this.Bva = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.affk = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.m paramAnonymousm)
      {
        int j = 0;
        AppMethodBeat.i(102870);
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((u.a(u.this) != null) && (u.a(u.this).equals(u.a(u.this))))
          {
            u.a(u.this, paramAnonymousm.FWt);
            u.this.nV(paramAnonymousm.HtF);
            int i = j;
            if (paramAnonymousm.HpM.Htx != null)
            {
              i = j;
              if (paramAnonymousm.HpM.Htx.length > 0) {
                i = paramAnonymousm.HpM.Htx[0];
              }
            }
            if (paramAnonymousm.HtF.size() > 0) {
              switch (i)
              {
              default: 
                Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = u.b(u.this);
              u.a(u.this, paramAnonymousm.HpM.query, bool);
              AppMethodBeat.o(102870);
              return;
              u.a(u.this, paramAnonymousm.HtF, i);
              continue;
              u.this.Hwr = paramAnonymousm.HtF;
              continue;
              u.a(u.this, paramAnonymousm.HtF);
              continue;
              switch (i)
              {
              default: 
                break;
              case 131072: 
              case 131081: 
                u.a(u.this, null, i);
                break;
              case 131075: 
                u.this.Hwr = null;
                break;
              case 131076: 
                u.a(u.this, null);
              }
            }
            if (!paramAnonymousm.HpM.query.equals(u.this.query))
            {
              AppMethodBeat.o(102870);
              return;
            }
            u.b(u.this);
          }
        }
      }
    };
    this.count = 0;
    nU(paramList);
    AppMethodBeat.o(102871);
  }
  
  public u(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super(paramMMBaseSelectContactUI, paramBoolean1, paramInt);
    AppMethodBeat.i(252866);
    this.affa = 2147483647;
    this.affb = 2147483647;
    this.affc = 2147483647;
    this.affd = true;
    this.affe = 2147483647;
    this.afbN = 2147483647;
    this.afff = true;
    this.affg = 2147483647;
    this.afbO = 2147483647;
    this.affh = null;
    this.lDu = null;
    this.Hwr = null;
    this.affi = null;
    this.Bva = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.affk = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.m paramAnonymousm)
      {
        int j = 0;
        AppMethodBeat.i(102870);
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((u.a(u.this) != null) && (u.a(u.this).equals(u.a(u.this))))
          {
            u.a(u.this, paramAnonymousm.FWt);
            u.this.nV(paramAnonymousm.HtF);
            int i = j;
            if (paramAnonymousm.HpM.Htx != null)
            {
              i = j;
              if (paramAnonymousm.HpM.Htx.length > 0) {
                i = paramAnonymousm.HpM.Htx[0];
              }
            }
            if (paramAnonymousm.HtF.size() > 0) {
              switch (i)
              {
              default: 
                Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = u.b(u.this);
              u.a(u.this, paramAnonymousm.HpM.query, bool);
              AppMethodBeat.o(102870);
              return;
              u.a(u.this, paramAnonymousm.HtF, i);
              continue;
              u.this.Hwr = paramAnonymousm.HtF;
              continue;
              u.a(u.this, paramAnonymousm.HtF);
              continue;
              switch (i)
              {
              default: 
                break;
              case 131072: 
              case 131081: 
                u.a(u.this, null, i);
                break;
              case 131075: 
                u.this.Hwr = null;
                break;
              case 131076: 
                u.a(u.this, null);
              }
            }
            if (!paramAnonymousm.HpM.query.equals(u.this.query))
            {
              AppMethodBeat.o(102870);
              return;
            }
            u.b(u.this);
          }
        }
      }
    };
    this.count = 0;
    this.Bva = paramBoolean2;
    nU(paramList);
    AppMethodBeat.o(252866);
  }
  
  private static com.tencent.mm.ui.contact.a.a W(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.m localm = new com.tencent.mm.ui.contact.a.m(paramInt2);
    localm.resId = paramInt1;
    localm.Gxy = paramBoolean;
    AppMethodBeat.o(102883);
    return localm;
  }
  
  private void aNi()
  {
    AppMethodBeat.i(102876);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    jyT();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.HtE != null)
    {
      ((n)com.tencent.mm.kernel.h.az(n.class)).cancelSearchTask(this.HtE);
      this.HtE = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void jyT()
  {
    AppMethodBeat.i(102875);
    this.affb = 2147483647;
    this.affc = 2147483647;
    this.affd = true;
    this.affe = 2147483647;
    this.afbN = 2147483647;
    this.afff = true;
    this.affg = 2147483647;
    this.afbO = 2147483647;
    this.affh = null;
    this.lDu = null;
    this.Hwr = null;
    this.affi = null;
    this.FWt = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean jyU()
  {
    AppMethodBeat.i(102878);
    if (this.affj.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.affh != null)
      {
        localObject = this.affh.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((com.tencent.mm.plugin.fts.a.a.o)((Iterator)localObject).next()).Hsz);
        }
      }
      int i = ((Integer)this.affj.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.l();
      ((com.tencent.mm.plugin.fts.a.a.l)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject).Htx = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtA = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtC = this.affk;
      ((com.tencent.mm.plugin.fts.a.a.l)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).qRb = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.l)localObject).HtB = com.tencent.mm.plugin.fts.a.c.a.Hud;; ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtB = b.Hue)
      {
        this.HtE = ((n)com.tencent.mm.kernel.h.az(n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.l)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).qRb = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private void nU(List<String> paramList)
  {
    AppMethodBeat.i(252870);
    this.afeX = paramList;
    this.affj = new ArrayList();
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    aNi();
    AppMethodBeat.o(252870);
  }
  
  private static int nW(List<? extends Object> paramList)
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
  
  private void u(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = nW(this.affh);
    int m = nW(this.lDu);
    int k = nW(this.Hwr);
    int j = nW(this.affi);
    if (i > 0)
    {
      this.affb = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.affc = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.affd) {
        break label280;
      }
      i += 4;
      this.affe = i;
      i += 1;
      label112:
      if ((this.FWt == null) || (this.FWt.Htg.length <= 1) || (gZe())) {
        break label331;
      }
      this.affa = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.afbN = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.afff) {
        break label340;
      }
      i += 4;
      this.affg = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.afbO = i;
      i += j + 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        eo(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.affb = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.affe = i;
      i += 1;
      break label112;
      label304:
      this.affe = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.affc = 2147483647;
      break label112;
      label331:
      this.affa = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.affg = i;
      i += 1;
      break label197;
      label364:
      this.affg = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.afbN = 2147483647;
      break label197;
      label391:
      this.afbO = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a Py(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.afbN - 1;
    com.tencent.mm.ui.contact.a.c localc = new com.tencent.mm.ui.contact.a.c(paramInt);
    localc.rpp = ((com.tencent.mm.plugin.fts.a.a.o)this.Hwr.get(i));
    localc.afey = gZe();
    localc.mwk = true;
    localc.Huq = (i + 1);
    localc.iW(localc.rpp.type, localc.rpp.subtype);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102873);
    clearTask();
    this.query = paramString;
    this.affj.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.affj.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    jyU();
    AppMethodBeat.o(102873);
  }
  
  public final boolean aDu(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.afex.getContentLV().getHeaderViewsCount();
    if (paramInt == this.affe) {
      if (this.affd)
      {
        paramInt = this.afex.getContentLV().getSelectedItemPosition();
        this.affd = false;
        u(this.query, true, false);
        this.afex.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.affd = true;
      u(this.query, true, false);
      this.afex.getContentLV().setSelection(this.affe);
      continue;
      if (paramInt == this.affg)
      {
        if (this.afff)
        {
          paramInt = this.afex.getContentLV().getSelectedItemPosition();
          this.afff = false;
          u(this.query, true, false);
          this.afex.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.afff = true;
          u(this.query, true, false);
          this.afex.getContentLV().setSelection(this.affg);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = aDt(paramInt);
        if ((locala != null) && (locala.mwk) && (this.affa != 2147483647))
        {
          if (locala.position == this.affa)
          {
            aj.aDv(1);
            bool = false;
          }
          else
          {
            aj.aDv(0);
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    aNi();
    AppMethodBeat.o(102877);
  }
  
  protected boolean d(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.affb;
    int m = this.affc;
    int n = this.afbN;
    int i1 = this.afbO;
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
  
  public void eo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.afew != null) {
      this.afew.h(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    aNi();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected com.tencent.mm.ui.contact.a.a hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.header = this.afex.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localj;
  }
  
  protected void nV(List<com.tencent.mm.plugin.fts.a.a.o> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.afeX == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      com.tencent.mm.plugin.fts.a.a.o localo = (com.tencent.mm.plugin.fts.a.a.o)paramList.get(i);
      if (!this.afeX.contains(localo.Hsz))
      {
        j = localo.type;
        if ((j != 131072) && (j != 131075) && (j != 131076) && (j != 131081)) {
          break label117;
        }
      }
      label117:
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
  
  protected com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject;
    if (paramInt == this.affa)
    {
      localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
      ((com.tencent.mm.ui.contact.a.h)localObject).mwk = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).FWt = this.FWt;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.affb)
      {
        localObject = hM(a.h.fts_header_top_hits, paramInt);
      }
      else if (paramInt == this.affc)
      {
        localObject = hM(a.h.fts_header_contact, paramInt);
      }
      else if (paramInt == this.afbN)
      {
        localObject = hM(a.h.fts_header_chatroom, paramInt);
      }
      else if (paramInt == this.afbO)
      {
        localObject = hM(a.h.fts_header_biz, paramInt);
      }
      else if (paramInt == this.affe)
      {
        localObject = W(a.h.fts_header_contact, paramInt, this.affd);
      }
      else if (paramInt == this.affg)
      {
        localObject = W(a.h.fts_header_chatroom, paramInt, this.afff);
      }
      else
      {
        int i;
        if (paramInt > this.afbO)
        {
          i = paramInt - this.afbO - 1;
          localObject = new f(paramInt);
          ((f)localObject).rpp = ((com.tencent.mm.plugin.fts.a.a.o)this.affi.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).afey = gZe();
          ((f)localObject).mwk = true;
          ((f)localObject).Huq = (i + 1);
          ((f)localObject).iW(((f)localObject).rpp.type, ((f)localObject).rpp.subtype);
        }
        else if (paramInt > this.afbN)
        {
          localObject = Py(paramInt);
        }
        else if (paramInt > this.affc)
        {
          i = paramInt - this.affc - 1;
          localObject = new f(paramInt);
          ((f)localObject).rpp = ((com.tencent.mm.plugin.fts.a.a.o)this.lDu.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).afey = gZe();
          ((f)localObject).mwk = true;
          ((f)localObject).Huq = (i + 1);
          ((f)localObject).iW(((f)localObject).rpp.type, ((f)localObject).rpp.subtype);
          ((f)localObject).Bva = this.Bva;
        }
        else if (paramInt > this.affb)
        {
          i = paramInt - this.affb - 1;
          com.tencent.mm.plugin.fts.a.a.o localo = (com.tencent.mm.plugin.fts.a.a.o)this.affh.get(i);
          if ((localo.type == 131072) || (localo.type == 131076) || (localo.type == 131081))
          {
            localObject = new f(paramInt);
            ((f)localObject).rpp = localo;
            ((com.tencent.mm.ui.contact.a.a)localObject).afey = gZe();
            ((f)localObject).afjE = true;
            ((f)localObject).mwk = true;
            ((f)localObject).Huq = (i + 1);
            ((f)localObject).iW(((f)localObject).rpp.type, ((f)localObject).rpp.subtype);
          }
          else if (localo.type == 131075)
          {
            localObject = new com.tencent.mm.ui.contact.a.c(paramInt);
            ((com.tencent.mm.ui.contact.a.c)localObject).rpp = localo;
            ((com.tencent.mm.ui.contact.a.a)localObject).afey = gZe();
            ((com.tencent.mm.ui.contact.a.c)localObject).afjE = true;
            ((com.tencent.mm.ui.contact.a.c)localObject).mwk = true;
            ((com.tencent.mm.ui.contact.a.c)localObject).Huq = (i + 1);
            ((com.tencent.mm.ui.contact.a.c)localObject).iW(((com.tencent.mm.ui.contact.a.c)localObject).rpp.type, ((com.tencent.mm.ui.contact.a.c)localObject).rpp.subtype);
          }
          else
          {
            Log.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(localo.type) });
            localObject = null;
          }
        }
        else
        {
          Log.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.u
 * JD-Core Version:    0.7.0.1
 */