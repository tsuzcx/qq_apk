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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class s
  extends o
{
  protected int ItC;
  private int ItD;
  private List<String> IwA;
  private int IwB;
  private int IwC;
  private int IwD;
  private boolean IwE;
  private int IwF;
  private boolean IwG;
  private int IwH;
  private List<m> IwI;
  private List<m> IwJ;
  private List<Integer> IwK;
  protected l IwL;
  private int count;
  private List<m> fwF;
  private ao handler;
  protected String query;
  protected List<m> sBf;
  private com.tencent.mm.plugin.fts.a.a.h sxM;
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.IwB = 2147483647;
    this.IwC = 2147483647;
    this.IwD = 2147483647;
    this.IwE = true;
    this.IwF = 2147483647;
    this.ItC = 2147483647;
    this.IwG = true;
    this.IwH = 2147483647;
    this.ItD = 2147483647;
    this.IwI = null;
    this.fwF = null;
    this.sBf = null;
    this.IwJ = null;
    this.handler = new ao(Looper.getMainLooper());
    this.IwL = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(102870);
        switch (paramAnonymousk.bPH)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(102870);
          return;
          if ((s.a(s.this) != null) && (s.a(s.this).equals(s.a(s.this))))
          {
            s.a(s.this, paramAnonymousk.sxM);
            s.this.ik(paramAnonymousk.syK);
            if (paramAnonymousk.syK.size() > 0) {
              switch (((m)paramAnonymousk.syK.get(0)).type)
              {
              default: 
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = s.c(s.this);
              s.a(s.this, paramAnonymousk.suU.query, bool);
              AppMethodBeat.o(102870);
              return;
              s.a(s.this, paramAnonymousk.syK);
              continue;
              s.this.sBf = paramAnonymousk.syK;
              continue;
              s.b(s.this, paramAnonymousk.syK);
              continue;
              if (s.b(s.this) != null) {
                s.b(s.this).addAll(paramAnonymousk.syK);
              } else {
                s.a(s.this, paramAnonymousk.syK);
              }
            }
            if (!paramAnonymousk.suU.query.equals(s.this.query))
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
    this.IwA = paramList;
    this.IwK = new ArrayList();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "Create!");
    WJ();
    AppMethodBeat.o(102871);
  }
  
  private static com.tencent.mm.ui.contact.a.a G(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.resId = paramInt1;
    localj.rVH = paramBoolean;
    AppMethodBeat.o(102883);
    return localj;
  }
  
  private void WJ()
  {
    AppMethodBeat.i(102876);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    frA();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.syJ != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.syJ);
      this.syJ = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void frA()
  {
    AppMethodBeat.i(102875);
    this.IwC = 2147483647;
    this.IwD = 2147483647;
    this.IwE = true;
    this.IwF = 2147483647;
    this.ItC = 2147483647;
    this.IwG = true;
    this.IwH = 2147483647;
    this.ItD = 2147483647;
    this.IwI = null;
    this.fwF = null;
    this.sBf = null;
    this.IwJ = null;
    this.sxM = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean frB()
  {
    AppMethodBeat.i(102878);
    if (this.IwK.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.IwI != null)
      {
        localObject = this.IwI.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).sxG);
        }
      }
      int i = ((Integer)this.IwK.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).syD = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).syG = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).syI = this.IwL;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jwR = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).syH = com.tencent.mm.plugin.fts.a.c.a.szg;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).syH = b.szh)
      {
        this.syJ = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jwR = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private static int il(List<? extends Object> paramList)
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
  
  private com.tencent.mm.ui.contact.a.a jH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt2);
    localh.header = this.Iwg.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localh;
  }
  
  private void l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = il(this.IwI);
    int m = il(this.fwF);
    int k = il(this.sBf);
    int j = il(this.IwJ);
    if (i > 0)
    {
      this.IwC = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.IwD = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.IwE) {
        break label280;
      }
      i += 4;
      this.IwF = i;
      i += 1;
      label112:
      if ((this.sxM == null) || (this.sxM.sym.length <= 1) || (dFi())) {
        break label331;
      }
      this.IwB = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.ItC = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.IwG) {
        break label340;
      }
      i += 4;
      this.IwH = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.ItD = i;
      i += j + 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        cO(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.IwC = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.IwF = i;
      i += 1;
      break label112;
      label304:
      this.IwF = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.IwD = 2147483647;
      break label112;
      label331:
      this.IwB = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.IwH = i;
      i += 1;
      break label197;
      label364:
      this.IwH = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.ItC = 2147483647;
      break label197;
      label391:
      this.ItD = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a PO(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.ItC - 1;
    c localc = new c(paramInt);
    localc.jPN = ((m)this.sBf.get(i));
    localc.Iwh = dFi();
    localc.gbD = true;
    localc.szu = (i + 1);
    localc.fP(localc.jPN.type, localc.jPN.sxF);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public final boolean abR(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.Iwg.getContentLV().getHeaderViewsCount();
    if (paramInt == this.IwF) {
      if (this.IwE)
      {
        paramInt = this.Iwg.getContentLV().getSelectedItemPosition();
        this.IwE = false;
        l(this.query, true, false);
        this.Iwg.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.IwE = true;
      l(this.query, true, false);
      this.Iwg.getContentLV().setSelection(this.IwF);
      continue;
      if (paramInt == this.IwH)
      {
        if (this.IwG)
        {
          paramInt = this.Iwg.getContentLV().getSelectedItemPosition();
          this.IwG = false;
          l(this.query, true, false);
          this.Iwg.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.IwG = true;
          l(this.query, true, false);
          this.Iwg.getContentLV().setSelection(this.IwH);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = abQ(paramInt);
        if ((locala != null) && (locala.gbD) && (this.IwB != 2147483647))
        {
          if (locala.position == this.IwB)
          {
            ac.abS(1);
            bool = false;
          }
          else
          {
            ac.abS(0);
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
    this.IwK.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.IwK.add(Integer.valueOf(k));
      i += 1;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    frB();
    AppMethodBeat.o(102873);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.IwC;
    int m = this.IwD;
    int n = this.ItC;
    int i1 = this.ItD;
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
  
  public void cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.Iwf != null) {
      this.Iwf.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    WJ();
    AppMethodBeat.o(102877);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMSearchContactAdapter", "finish!");
    WJ();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void ik(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.IwA == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.IwA.contains(localm.sxG))
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
  
  protected com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject = null;
    if (paramInt == this.IwB)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).gbD = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).sxM = this.sxM;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.IwC)
      {
        localObject = jH(2131759698, paramInt);
      }
      else if (paramInt == this.IwD)
      {
        localObject = jH(2131759682, paramInt);
      }
      else if (paramInt == this.ItC)
      {
        localObject = jH(2131759681, paramInt);
      }
      else if (paramInt == this.ItD)
      {
        localObject = jH(2131759679, paramInt);
      }
      else if (paramInt == this.IwF)
      {
        localObject = G(2131759682, paramInt, this.IwE);
      }
      else if (paramInt == this.IwH)
      {
        localObject = G(2131759681, paramInt, this.IwG);
      }
      else
      {
        int i;
        if (paramInt > this.ItD)
        {
          i = paramInt - this.ItD - 1;
          localObject = new e(paramInt);
          ((e)localObject).jPN = ((m)this.IwJ.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = dFi();
          ((e)localObject).gbD = true;
          ((e)localObject).szu = (i + 1);
          ((e)localObject).fP(((e)localObject).jPN.type, ((e)localObject).jPN.sxF);
        }
        else if (paramInt > this.ItC)
        {
          localObject = PO(paramInt);
        }
        else if (paramInt > this.IwD)
        {
          i = paramInt - this.IwD - 1;
          localObject = new e(paramInt);
          ((e)localObject).jPN = ((m)this.fwF.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = dFi();
          ((e)localObject).gbD = true;
          ((e)localObject).szu = (i + 1);
          ((e)localObject).fP(((e)localObject).jPN.type, ((e)localObject).jPN.sxF);
        }
        else if (paramInt > this.IwC)
        {
          i = paramInt - this.IwC - 1;
          m localm = (m)this.IwI.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).jPN = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = dFi();
            ((e)localObject).IzD = true;
            ((e)localObject).gbD = true;
            ((e)localObject).szu = (i + 1);
            ((e)localObject).fP(((e)localObject).jPN.type, ((e)localObject).jPN.sxF);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).jPN = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = dFi();
            ((c)localObject).IzD = true;
            ((c)localObject).gbD = true;
            ((c)localObject).szu = (i + 1);
            ((c)localObject).fP(((c)localObject).jPN.type, ((c)localObject).jPN.sxF);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(localm.type) });
            localObject = null;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */