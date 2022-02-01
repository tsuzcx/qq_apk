package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class u
  extends p
{
  private com.tencent.mm.plugin.fts.a.a.h BHY;
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  protected List<m> BLv;
  protected int Xqk;
  private int Xql;
  private int XtA;
  private boolean XtB;
  private int XtC;
  private List<m> XtD;
  private List<m> XtE;
  private List<Integer> XtF;
  protected com.tencent.mm.plugin.fts.a.l XtG;
  private List<String> Xtt;
  private int Xtw;
  private int Xtx;
  private int Xty;
  private boolean Xtz;
  private int count;
  private MMHandler handler;
  private List<m> jbu;
  protected String query;
  private boolean xUe;
  
  public u(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.Xtw = 2147483647;
    this.Xtx = 2147483647;
    this.Xty = 2147483647;
    this.Xtz = true;
    this.XtA = 2147483647;
    this.Xqk = 2147483647;
    this.XtB = true;
    this.XtC = 2147483647;
    this.Xql = 2147483647;
    this.XtD = null;
    this.jbu = null;
    this.BLv = null;
    this.XtE = null;
    this.xUe = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XtG = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102870);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((u.a(u.this) != null) && (u.a(u.this).equals(u.a(u.this))))
          {
            u.a(u.this, paramAnonymousk.BHY);
            u.this.kE(paramAnonymousk.BIW);
            if (paramAnonymousk.BIW.size() > 0) {
              switch (((m)paramAnonymousk.BIW.get(0)).type)
              {
              default: 
                Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = u.c(u.this);
              u.a(u.this, paramAnonymousk.BFk.query, bool);
              AppMethodBeat.o(102870);
              return;
              u.a(u.this, paramAnonymousk.BIW);
              continue;
              u.this.BLv = paramAnonymousk.BIW;
              continue;
              u.b(u.this, paramAnonymousk.BIW);
              continue;
              if (u.b(u.this) != null) {
                u.b(u.this).addAll(paramAnonymousk.BIW);
              } else {
                u.a(u.this, paramAnonymousk.BIW);
              }
            }
            if (!paramAnonymousk.BFk.query.equals(u.this.query))
            {
              AppMethodBeat.o(102870);
              return;
            }
            u.c(u.this);
          }
        }
      }
    };
    this.count = 0;
    kD(paramList);
    AppMethodBeat.o(102871);
  }
  
  public u(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super(paramMMBaseSelectContactUI, paramBoolean1, paramInt);
    AppMethodBeat.i(186228);
    this.Xtw = 2147483647;
    this.Xtx = 2147483647;
    this.Xty = 2147483647;
    this.Xtz = true;
    this.XtA = 2147483647;
    this.Xqk = 2147483647;
    this.XtB = true;
    this.XtC = 2147483647;
    this.Xql = 2147483647;
    this.XtD = null;
    this.jbu = null;
    this.BLv = null;
    this.XtE = null;
    this.xUe = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XtG = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102870);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((u.a(u.this) != null) && (u.a(u.this).equals(u.a(u.this))))
          {
            u.a(u.this, paramAnonymousk.BHY);
            u.this.kE(paramAnonymousk.BIW);
            if (paramAnonymousk.BIW.size() > 0) {
              switch (((m)paramAnonymousk.BIW.get(0)).type)
              {
              default: 
                Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = u.c(u.this);
              u.a(u.this, paramAnonymousk.BFk.query, bool);
              AppMethodBeat.o(102870);
              return;
              u.a(u.this, paramAnonymousk.BIW);
              continue;
              u.this.BLv = paramAnonymousk.BIW;
              continue;
              u.b(u.this, paramAnonymousk.BIW);
              continue;
              if (u.b(u.this) != null) {
                u.b(u.this).addAll(paramAnonymousk.BIW);
              } else {
                u.a(u.this, paramAnonymousk.BIW);
              }
            }
            if (!paramAnonymousk.BFk.query.equals(u.this.query))
            {
              AppMethodBeat.o(102870);
              return;
            }
            u.c(u.this);
          }
        }
      }
    };
    this.count = 0;
    this.xUe = paramBoolean2;
    kD(paramList);
    AppMethodBeat.o(186228);
  }
  
  private static com.tencent.mm.ui.contact.a.a S(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.l locall = new com.tencent.mm.ui.contact.a.l(paramInt2);
    locall.resId = paramInt1;
    locall.AUY = paramBoolean;
    AppMethodBeat.o(102883);
    return locall;
  }
  
  private void ata()
  {
    AppMethodBeat.i(102876);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    hVf();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.BIV != null)
    {
      ((n)com.tencent.mm.kernel.h.ag(n.class)).cancelSearchTask(this.BIV);
      this.BIV = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void hVf()
  {
    AppMethodBeat.i(102875);
    this.Xtx = 2147483647;
    this.Xty = 2147483647;
    this.Xtz = true;
    this.XtA = 2147483647;
    this.Xqk = 2147483647;
    this.XtB = true;
    this.XtC = 2147483647;
    this.Xql = 2147483647;
    this.XtD = null;
    this.jbu = null;
    this.BLv = null;
    this.XtE = null;
    this.BHY = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean hVg()
  {
    AppMethodBeat.i(102878);
    if (this.XtF.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.XtD != null)
      {
        localObject = this.XtD.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).BHS);
        }
      }
      int i = ((Integer)this.XtF.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIP = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIS = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIU = this.XtG;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).nRn = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).BIT = com.tencent.mm.plugin.fts.a.c.a.BJt;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIT = b.BJu)
      {
        this.BIV = ((n)com.tencent.mm.kernel.h.ag(n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).nRn = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private void kD(List<String> paramList)
  {
    AppMethodBeat.i(186229);
    this.Xtt = paramList;
    this.XtF = new ArrayList();
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    ata();
    AppMethodBeat.o(186229);
  }
  
  private static int kF(List<? extends Object> paramList)
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
  
  private void q(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = kF(this.XtD);
    int m = kF(this.jbu);
    int k = kF(this.BLv);
    int j = kF(this.XtE);
    if (i > 0)
    {
      this.Xtx = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.Xty = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.Xtz) {
        break label280;
      }
      i += 4;
      this.XtA = i;
      i += 1;
      label112:
      if ((this.BHY == null) || (this.BHY.BIy.length <= 1) || (fJk())) {
        break label331;
      }
      this.Xtw = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.Xqk = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.XtB) {
        break label340;
      }
      i += 4;
      this.XtC = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.Xql = i;
      i += j + 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        dE(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.Xtx = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.XtA = i;
      i += 1;
      break label112;
      label304:
      this.XtA = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.Xty = 2147483647;
      break label112;
      label331:
      this.Xtw = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.XtC = i;
      i += 1;
      break label197;
      label364:
      this.XtC = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.Xqk = 2147483647;
      break label197;
      label391:
      this.Xql = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a NO(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.Xqk - 1;
    c localc = new c(paramInt);
    localc.olG = ((m)this.BLv.get(i));
    localc.XsX = fJk();
    localc.jWq = true;
    localc.BJH = (i + 1);
    localc.hx(localc.olG.type, localc.olG.BHR);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102873);
    clearTask();
    this.query = paramString;
    this.XtF.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.XtF.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    hVg();
    AppMethodBeat.o(102873);
  }
  
  public final boolean awN(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.XsW.getContentLV().getHeaderViewsCount();
    if (paramInt == this.XtA) {
      if (this.Xtz)
      {
        paramInt = this.XsW.getContentLV().getSelectedItemPosition();
        this.Xtz = false;
        q(this.query, true, false);
        this.XsW.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.Xtz = true;
      q(this.query, true, false);
      this.XsW.getContentLV().setSelection(this.XtA);
      continue;
      if (paramInt == this.XtC)
      {
        if (this.XtB)
        {
          paramInt = this.XsW.getContentLV().getSelectedItemPosition();
          this.XtB = false;
          q(this.query, true, false);
          this.XsW.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.XtB = true;
          q(this.query, true, false);
          this.XsW.getContentLV().setSelection(this.XtC);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = awM(paramInt);
        if ((locala != null) && (locala.jWq) && (this.Xtw != 2147483647))
        {
          if (locala.position == this.Xtw)
          {
            ae.awO(1);
            bool = false;
          }
          else
          {
            ae.awO(0);
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.Xtx;
    int m = this.Xty;
    int n = this.Xqk;
    int i1 = this.Xql;
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
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    ata();
    AppMethodBeat.o(102877);
  }
  
  public void dE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.XsV != null) {
      this.XsV.g(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    ata();
    AppMethodBeat.o(102886);
  }
  
  protected com.tencent.mm.ui.contact.a.a gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.header = this.XsW.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localj;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void kE(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.Xtt == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.Xtt.contains(localm.BHS))
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
  
  protected com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject;
    if (paramInt == this.Xtw)
    {
      localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
      ((com.tencent.mm.ui.contact.a.h)localObject).jWq = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).BHY = this.BHY;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.Xtx)
      {
        localObject = gJ(a.h.fts_header_top_hits, paramInt);
      }
      else if (paramInt == this.Xty)
      {
        localObject = gJ(a.h.fts_header_contact, paramInt);
      }
      else if (paramInt == this.Xqk)
      {
        localObject = gJ(a.h.fts_header_chatroom, paramInt);
      }
      else if (paramInt == this.Xql)
      {
        localObject = gJ(a.h.fts_header_biz, paramInt);
      }
      else if (paramInt == this.XtA)
      {
        localObject = S(a.h.fts_header_contact, paramInt, this.Xtz);
      }
      else if (paramInt == this.XtC)
      {
        localObject = S(a.h.fts_header_chatroom, paramInt, this.XtB);
      }
      else
      {
        int i;
        if (paramInt > this.Xql)
        {
          i = paramInt - this.Xql - 1;
          localObject = new f(paramInt);
          ((f)localObject).olG = ((m)this.XtE.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).XsX = fJk();
          ((f)localObject).jWq = true;
          ((f)localObject).BJH = (i + 1);
          ((f)localObject).hx(((f)localObject).olG.type, ((f)localObject).olG.BHR);
        }
        else if (paramInt > this.Xqk)
        {
          localObject = NO(paramInt);
        }
        else if (paramInt > this.Xty)
        {
          i = paramInt - this.Xty - 1;
          localObject = new f(paramInt);
          ((f)localObject).olG = ((m)this.jbu.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).XsX = fJk();
          ((f)localObject).jWq = true;
          ((f)localObject).BJH = (i + 1);
          ((f)localObject).hx(((f)localObject).olG.type, ((f)localObject).olG.BHR);
          ((f)localObject).xUe = this.xUe;
        }
        else if (paramInt > this.Xtx)
        {
          i = paramInt - this.Xtx - 1;
          m localm = (m)this.XtD.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new f(paramInt);
            ((f)localObject).olG = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).XsX = fJk();
            ((f)localObject).Xxv = true;
            ((f)localObject).jWq = true;
            ((f)localObject).BJH = (i + 1);
            ((f)localObject).hx(((f)localObject).olG.type, ((f)localObject).olG.BHR);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).olG = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).XsX = fJk();
            ((c)localObject).Xxv = true;
            ((c)localObject).jWq = true;
            ((c)localObject).BJH = (i + 1);
            ((c)localObject).hx(((c)localObject).olG.type, ((c)localObject).olG.BHR);
          }
          else
          {
            Log.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(localm.type) });
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