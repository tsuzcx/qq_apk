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
  protected int GTr;
  private int GTs;
  private List<String> GWm;
  private int GWn;
  private int GWo;
  private int GWp;
  private boolean GWq;
  private int GWr;
  private boolean GWs;
  private int GWt;
  private List<m> GWu;
  private List<m> GWv;
  private List<Integer> GWw;
  protected l GWx;
  private int count;
  private List<m> fsY;
  private ap handler;
  protected String query;
  private com.tencent.mm.plugin.fts.a.a.h roS;
  private com.tencent.mm.plugin.fts.a.a.a rpP;
  protected List<m> rsl;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.GWn = 2147483647;
    this.GWo = 2147483647;
    this.GWp = 2147483647;
    this.GWq = true;
    this.GWr = 2147483647;
    this.GTr = 2147483647;
    this.GWs = true;
    this.GWt = 2147483647;
    this.GTs = 2147483647;
    this.GWu = null;
    this.fsY = null;
    this.rsl = null;
    this.GWv = null;
    this.handler = new ap(Looper.getMainLooper());
    this.GWx = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102870);
        switch (paramAnonymousk.bRZ)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((s.a(s.this) != null) && (s.a(s.this).equals(s.a(s.this))))
          {
            s.a(s.this, paramAnonymousk.roS);
            s.this.hX(paramAnonymousk.rpQ);
            if (paramAnonymousk.rpQ.size() > 0) {
              switch (((m)paramAnonymousk.rpQ.get(0)).type)
              {
              default: 
                ad.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = s.c(s.this);
              s.a(s.this, paramAnonymousk.rma.query, bool);
              AppMethodBeat.o(102870);
              return;
              s.a(s.this, paramAnonymousk.rpQ);
              continue;
              s.this.rsl = paramAnonymousk.rpQ;
              continue;
              s.b(s.this, paramAnonymousk.rpQ);
              continue;
              if (s.b(s.this) != null) {
                s.b(s.this).addAll(paramAnonymousk.rpQ);
              } else {
                s.a(s.this, paramAnonymousk.rpQ);
              }
            }
            if (!paramAnonymousk.rma.query.equals(s.this.query))
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
    this.GWm = paramList;
    this.GWw = new ArrayList();
    ad.i("MicroMsg.MMSearchContactAdapter", "Create!");
    VL();
    AppMethodBeat.o(102871);
  }
  
  private static com.tencent.mm.ui.contact.a.a H(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.resId = paramInt1;
    localj.qVx = paramBoolean;
    AppMethodBeat.o(102883);
    return localj;
  }
  
  private void VL()
  {
    AppMethodBeat.i(102876);
    ad.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    fbJ();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.rpP != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.rpP);
      this.rpP = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void fbJ()
  {
    AppMethodBeat.i(102875);
    this.GWo = 2147483647;
    this.GWp = 2147483647;
    this.GWq = true;
    this.GWr = 2147483647;
    this.GTr = 2147483647;
    this.GWs = true;
    this.GWt = 2147483647;
    this.GTs = 2147483647;
    this.GWu = null;
    this.fsY = null;
    this.rsl = null;
    this.GWv = null;
    this.roS = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean fbK()
  {
    AppMethodBeat.i(102878);
    if (this.GWw.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.GWu != null)
      {
        localObject = this.GWu.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).roN);
        }
      }
      int i = ((Integer)this.GWw.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpJ = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpM = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpO = this.GWx;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).iWB = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).rpN = com.tencent.mm.plugin.fts.a.c.a.rqm;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpN = b.rqn)
      {
        this.rpP = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).iWB = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private static int hY(List<? extends Object> paramList)
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
  
  private com.tencent.mm.ui.contact.a.a jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt2);
    localh.header = this.GVS.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localh;
  }
  
  private void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = hY(this.GWu);
    int m = hY(this.fsY);
    int k = hY(this.rsl);
    int j = hY(this.GWv);
    if (i > 0)
    {
      this.GWo = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.GWp = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.GWq) {
        break label280;
      }
      i += 4;
      this.GWr = i;
      i += 1;
      label112:
      if ((this.roS == null) || (this.roS.rps.length <= 1) || (dqZ())) {
        break label331;
      }
      this.GWn = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.GTr = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.GWs) {
        break label340;
      }
      i += 4;
      this.GWt = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.GTs = i;
      i += j + 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        cI(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.GWo = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.GWr = i;
      i += 1;
      break label112;
      label304:
      this.GWr = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.GWp = 2147483647;
      break label112;
      label331:
      this.GWn = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.GWt = i;
      i += 1;
      break label197;
      label364:
      this.GWt = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.GTr = 2147483647;
      break label197;
      label391:
      this.GTs = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a NK(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.GTr - 1;
    c localc = new c(paramInt);
    localc.jpy = ((m)this.rsl.get(i));
    localc.GVT = dqZ();
    localc.fWW = true;
    localc.rqA = (i + 1);
    localc.fI(localc.jpy.type, localc.jpy.roM);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public final boolean ZD(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.GVS.getContentLV().getHeaderViewsCount();
    if (paramInt == this.GWr) {
      if (this.GWq)
      {
        paramInt = this.GVS.getContentLV().getSelectedItemPosition();
        this.GWq = false;
        k(this.query, true, false);
        this.GVS.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.GWq = true;
      k(this.query, true, false);
      this.GVS.getContentLV().setSelection(this.GWr);
      continue;
      if (paramInt == this.GWt)
      {
        if (this.GWs)
        {
          paramInt = this.GVS.getContentLV().getSelectedItemPosition();
          this.GWs = false;
          k(this.query, true, false);
          this.GVS.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.GWs = true;
          k(this.query, true, false);
          this.GVS.getContentLV().setSelection(this.GWt);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = ZC(paramInt);
        if ((locala != null) && (locala.fWW) && (this.GWn != 2147483647))
        {
          if (locala.position == this.GWn)
          {
            ac.ZE(1);
            bool = false;
          }
          else
          {
            ac.ZE(0);
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
    this.GWw.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.GWw.add(Integer.valueOf(k));
      i += 1;
    }
    ad.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    fbK();
    AppMethodBeat.o(102873);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.GWo;
    int m = this.GWp;
    int n = this.GTr;
    int i1 = this.GTs;
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
  
  public void cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.GVR != null) {
      this.GVR.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    VL();
    AppMethodBeat.o(102877);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    ad.i("MicroMsg.MMSearchContactAdapter", "finish!");
    VL();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void hX(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.GWm == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.GWm.contains(localm.roN))
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
  
  protected com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject = null;
    if (paramInt == this.GWn)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).fWW = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).roS = this.roS;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.GWo)
      {
        localObject = jv(2131759698, paramInt);
      }
      else if (paramInt == this.GWp)
      {
        localObject = jv(2131759682, paramInt);
      }
      else if (paramInt == this.GTr)
      {
        localObject = jv(2131759681, paramInt);
      }
      else if (paramInt == this.GTs)
      {
        localObject = jv(2131759679, paramInt);
      }
      else if (paramInt == this.GWr)
      {
        localObject = H(2131759682, paramInt, this.GWq);
      }
      else if (paramInt == this.GWt)
      {
        localObject = H(2131759681, paramInt, this.GWs);
      }
      else
      {
        int i;
        if (paramInt > this.GTs)
        {
          i = paramInt - this.GTs - 1;
          localObject = new e(paramInt);
          ((e)localObject).jpy = ((m)this.GWv.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).GVT = dqZ();
          ((e)localObject).fWW = true;
          ((e)localObject).rqA = (i + 1);
          ((e)localObject).fI(((e)localObject).jpy.type, ((e)localObject).jpy.roM);
        }
        else if (paramInt > this.GTr)
        {
          localObject = NK(paramInt);
        }
        else if (paramInt > this.GWp)
        {
          i = paramInt - this.GWp - 1;
          localObject = new e(paramInt);
          ((e)localObject).jpy = ((m)this.fsY.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).GVT = dqZ();
          ((e)localObject).fWW = true;
          ((e)localObject).rqA = (i + 1);
          ((e)localObject).fI(((e)localObject).jpy.type, ((e)localObject).jpy.roM);
        }
        else if (paramInt > this.GWo)
        {
          i = paramInt - this.GWo - 1;
          m localm = (m)this.GWu.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).jpy = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).GVT = dqZ();
            ((e)localObject).GZl = true;
            ((e)localObject).fWW = true;
            ((e)localObject).rqA = (i + 1);
            ((e)localObject).fI(((e)localObject).jpy.type, ((e)localObject).jpy.roM);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).jpy = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).GVT = dqZ();
            ((c)localObject).GZl = true;
            ((c)localObject).fWW = true;
            ((c)localObject).rqA = (i + 1);
            ((c)localObject).fI(((c)localObject).jpy.type, ((c)localObject).jpy.roM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */