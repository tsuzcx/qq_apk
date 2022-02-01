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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class s
  extends o
{
  protected int KGC;
  private int KGD;
  private List<String> KJC;
  private int KJD;
  private int KJE;
  private int KJF;
  private boolean KJG;
  private int KJH;
  private boolean KJI;
  private int KJJ;
  private List<m> KJK;
  private List<m> KJL;
  private List<Integer> KJM;
  protected l KJN;
  private int count;
  private List<m> fRY;
  private aq handler;
  protected String query;
  private com.tencent.mm.plugin.fts.a.a.h tFe;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  protected List<m> tIx;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.KJD = 2147483647;
    this.KJE = 2147483647;
    this.KJF = 2147483647;
    this.KJG = true;
    this.KJH = 2147483647;
    this.KGC = 2147483647;
    this.KJI = true;
    this.KJJ = 2147483647;
    this.KGD = 2147483647;
    this.KJK = null;
    this.fRY = null;
    this.tIx = null;
    this.KJL = null;
    this.handler = new aq(Looper.getMainLooper());
    this.KJN = new l()
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
            s.a(s.this, paramAnonymousk.tFe);
            s.this.iG(paramAnonymousk.tGc);
            if (paramAnonymousk.tGc.size() > 0) {
              switch (((m)paramAnonymousk.tGc.get(0)).type)
              {
              default: 
                ae.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = s.c(s.this);
              s.a(s.this, paramAnonymousk.tCm.query, bool);
              AppMethodBeat.o(102870);
              return;
              s.a(s.this, paramAnonymousk.tGc);
              continue;
              s.this.tIx = paramAnonymousk.tGc;
              continue;
              s.b(s.this, paramAnonymousk.tGc);
              continue;
              if (s.b(s.this) != null) {
                s.b(s.this).addAll(paramAnonymousk.tGc);
              } else {
                s.a(s.this, paramAnonymousk.tGc);
              }
            }
            if (!paramAnonymousk.tCm.query.equals(s.this.query))
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
    this.KJC = paramList;
    this.KJM = new ArrayList();
    ae.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Zm();
    AppMethodBeat.o(102871);
  }
  
  private static com.tencent.mm.ui.contact.a.a H(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.resId = paramInt1;
    localj.tdC = paramBoolean;
    AppMethodBeat.o(102883);
    return localj;
  }
  
  private void Zm()
  {
    AppMethodBeat.i(102876);
    ae.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    fMF();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.tGb != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tGb);
      this.tGb = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void fMF()
  {
    AppMethodBeat.i(102875);
    this.KJE = 2147483647;
    this.KJF = 2147483647;
    this.KJG = true;
    this.KJH = 2147483647;
    this.KGC = 2147483647;
    this.KJI = true;
    this.KJJ = 2147483647;
    this.KGD = 2147483647;
    this.KJK = null;
    this.fRY = null;
    this.tIx = null;
    this.KJL = null;
    this.tFe = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean fMG()
  {
    AppMethodBeat.i(102878);
    if (this.KJM.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.KJK != null)
      {
        localObject = this.KJK.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).tEY);
        }
      }
      int i = ((Integer)this.KJM.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFV = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFY = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).tGa = this.KJN;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jUf = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).tFZ = com.tencent.mm.plugin.fts.a.c.a.tGy;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFZ = b.tGz)
      {
        this.tGb = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jUf = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private static int iH(List<? extends Object> paramList)
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
  
  private com.tencent.mm.ui.contact.a.a ka(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt2);
    localh.header = this.KJi.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localh;
  }
  
  private void n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = iH(this.KJK);
    int m = iH(this.fRY);
    int k = iH(this.tIx);
    int j = iH(this.KJL);
    if (i > 0)
    {
      this.KJE = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.KJF = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.KJG) {
        break label280;
      }
      i += 4;
      this.KJH = i;
      i += 1;
      label112:
      if ((this.tFe == null) || (this.tFe.tFE.length <= 1) || (dUh())) {
        break label331;
      }
      this.KJD = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.KGC = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.KJI) {
        break label340;
      }
      i += 4;
      this.KJJ = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.KGD = i;
      i += j + 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        cX(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.KJE = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.KJH = i;
      i += 1;
      break label112;
      label304:
      this.KJH = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.KJF = 2147483647;
      break label112;
      label331:
      this.KJD = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.KJJ = i;
      i += 1;
      break label197;
      label364:
      this.KJJ = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.KGC = 2147483647;
      break label197;
      label391:
      this.KGD = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a Se(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.KGC - 1;
    c localc = new c(paramInt);
    localc.kno = ((m)this.tIx.get(i));
    localc.KJj = dUh();
    localc.gxU = true;
    localc.tGM = (i + 1);
    localc.gf(localc.kno.type, localc.kno.tEX);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public final boolean aeX(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.KJi.getContentLV().getHeaderViewsCount();
    if (paramInt == this.KJH) {
      if (this.KJG)
      {
        paramInt = this.KJi.getContentLV().getSelectedItemPosition();
        this.KJG = false;
        n(this.query, true, false);
        this.KJi.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.KJG = true;
      n(this.query, true, false);
      this.KJi.getContentLV().setSelection(this.KJH);
      continue;
      if (paramInt == this.KJJ)
      {
        if (this.KJI)
        {
          paramInt = this.KJi.getContentLV().getSelectedItemPosition();
          this.KJI = false;
          n(this.query, true, false);
          this.KJi.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.KJI = true;
          n(this.query, true, false);
          this.KJi.getContentLV().setSelection(this.KJJ);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = aeW(paramInt);
        if ((locala != null) && (locala.gxU) && (this.KJD != 2147483647))
        {
          if (locala.position == this.KJD)
          {
            ac.aeY(1);
            bool = false;
          }
          else
          {
            ac.aeY(0);
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
    this.KJM.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.KJM.add(Integer.valueOf(k));
      i += 1;
    }
    ae.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    fMG();
    AppMethodBeat.o(102873);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.KJE;
    int m = this.KJF;
    int n = this.KGC;
    int i1 = this.KGD;
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
  
  public void cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.KJh != null) {
      this.KJh.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(102877);
    Zm();
    AppMethodBeat.o(102877);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    ae.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Zm();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void iG(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.KJC == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.KJC.contains(localm.tEY))
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
  
  protected com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject = null;
    if (paramInt == this.KJD)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).gxU = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).tFe = this.tFe;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.KJE)
      {
        localObject = ka(2131759698, paramInt);
      }
      else if (paramInt == this.KJF)
      {
        localObject = ka(2131759682, paramInt);
      }
      else if (paramInt == this.KGC)
      {
        localObject = ka(2131759681, paramInt);
      }
      else if (paramInt == this.KGD)
      {
        localObject = ka(2131759679, paramInt);
      }
      else if (paramInt == this.KJH)
      {
        localObject = H(2131759682, paramInt, this.KJG);
      }
      else if (paramInt == this.KJJ)
      {
        localObject = H(2131759681, paramInt, this.KJI);
      }
      else
      {
        int i;
        if (paramInt > this.KGD)
        {
          i = paramInt - this.KGD - 1;
          localObject = new e(paramInt);
          ((e)localObject).kno = ((m)this.KJL.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).KJj = dUh();
          ((e)localObject).gxU = true;
          ((e)localObject).tGM = (i + 1);
          ((e)localObject).gf(((e)localObject).kno.type, ((e)localObject).kno.tEX);
        }
        else if (paramInt > this.KGC)
        {
          localObject = Se(paramInt);
        }
        else if (paramInt > this.KJF)
        {
          i = paramInt - this.KJF - 1;
          localObject = new e(paramInt);
          ((e)localObject).kno = ((m)this.fRY.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).KJj = dUh();
          ((e)localObject).gxU = true;
          ((e)localObject).tGM = (i + 1);
          ((e)localObject).gf(((e)localObject).kno.type, ((e)localObject).kno.tEX);
        }
        else if (paramInt > this.KJE)
        {
          i = paramInt - this.KJE - 1;
          m localm = (m)this.KJK.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).kno = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).KJj = dUh();
            ((e)localObject).KNd = true;
            ((e)localObject).gxU = true;
            ((e)localObject).tGM = (i + 1);
            ((e)localObject).gf(((e)localObject).kno.type, ((e)localObject).kno.tEX);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).kno = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).KJj = dUh();
            ((c)localObject).KNd = true;
            ((c)localObject).gxU = true;
            ((c)localObject).tGM = (i + 1);
            ((c)localObject).gf(((c)localObject).kno.type, ((c)localObject).kno.tEX);
          }
          else
          {
            ae.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(localm.type) });
            localObject = null;
          }
        }
        else
        {
          ae.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */