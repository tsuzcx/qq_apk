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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class s
  extends o
{
  private int PTA;
  protected int PTz;
  private List<String> PWD;
  private int PWE;
  private int PWF;
  private int PWG;
  private boolean PWH;
  private int PWI;
  private boolean PWJ;
  private int PWK;
  private List<m> PWL;
  private List<m> PWM;
  private List<Integer> PWN;
  protected l PWO;
  private int count;
  private List<m> gxh;
  private MMHandler handler;
  protected String query;
  private com.tencent.mm.plugin.fts.a.a.h wWd;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  protected List<m> wZw;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(102871);
    this.PWE = 2147483647;
    this.PWF = 2147483647;
    this.PWG = 2147483647;
    this.PWH = true;
    this.PWI = 2147483647;
    this.PTz = 2147483647;
    this.PWJ = true;
    this.PWK = 2147483647;
    this.PTA = 2147483647;
    this.PWL = null;
    this.gxh = null;
    this.wZw = null;
    this.PWM = null;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.PWO = new l()
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
          if ((s.a(s.this) != null) && (s.a(s.this).equals(s.a(s.this))))
          {
            s.a(s.this, paramAnonymousk.wWd);
            s.this.jJ(paramAnonymousk.wXb);
            if (paramAnonymousk.wXb.size() > 0) {
              switch (((m)paramAnonymousk.wXb.get(0)).type)
              {
              default: 
                Log.i("MicroMsg.MMSearchContactAdapter", "not support search");
              }
            }
            for (;;)
            {
              boolean bool = s.c(s.this);
              s.a(s.this, paramAnonymousk.wTn.query, bool);
              AppMethodBeat.o(102870);
              return;
              s.a(s.this, paramAnonymousk.wXb);
              continue;
              s.this.wZw = paramAnonymousk.wXb;
              continue;
              s.b(s.this, paramAnonymousk.wXb);
              continue;
              if (s.b(s.this) != null) {
                s.b(s.this).addAll(paramAnonymousk.wXb);
              } else {
                s.a(s.this, paramAnonymousk.wXb);
              }
            }
            if (!paramAnonymousk.wTn.query.equals(s.this.query))
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
    this.PWD = paramList;
    this.PWN = new ArrayList();
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    amZ();
    AppMethodBeat.o(102871);
  }
  
  private static com.tencent.mm.ui.contact.a.a L(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102883);
    com.tencent.mm.ui.contact.a.j localj = new com.tencent.mm.ui.contact.a.j(paramInt2);
    localj.resId = paramInt1;
    localj.wke = paramBoolean;
    AppMethodBeat.o(102883);
    return localj;
  }
  
  private void amZ()
  {
    AppMethodBeat.i(102876);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    gUZ();
    clearTask();
    clearCache();
    AppMethodBeat.o(102876);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(102874);
    if (this.wXa != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
      this.wXa = null;
    }
    AppMethodBeat.o(102874);
  }
  
  private void gUZ()
  {
    AppMethodBeat.i(102875);
    this.PWF = 2147483647;
    this.PWG = 2147483647;
    this.PWH = true;
    this.PWI = 2147483647;
    this.PTz = 2147483647;
    this.PWJ = true;
    this.PWK = 2147483647;
    this.PTA = 2147483647;
    this.PWL = null;
    this.gxh = null;
    this.wZw = null;
    this.PWM = null;
    this.wWd = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102875);
  }
  
  private boolean gVa()
  {
    AppMethodBeat.i(102878);
    if (this.PWN.size() > 0)
    {
      HashSet localHashSet = new HashSet();
      if (this.PWL != null)
      {
        localObject = this.PWL.iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(((m)((Iterator)localObject).next()).wVX);
        }
      }
      int i = ((Integer)this.PWN.remove(0)).intValue();
      Object localObject = new com.tencent.mm.plugin.fts.a.a.j();
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = this.query;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWU = new int[] { i };
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWX = localHashSet;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWZ = this.PWO;
      ((com.tencent.mm.plugin.fts.a.a.j)localObject).handler = this.handler;
      if (i == 131075) {
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).kXb = 32;
      }
      for (((com.tencent.mm.plugin.fts.a.a.j)localObject).wWY = com.tencent.mm.plugin.fts.a.c.a.wXx;; ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWY = b.wXy)
      {
        this.wXa = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        AppMethodBeat.o(102878);
        return false;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).kXb = 16;
      }
    }
    AppMethodBeat.o(102878);
    return true;
  }
  
  private static int jK(List<? extends Object> paramList)
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
  
  private com.tencent.mm.ui.contact.a.a lk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102884);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt2);
    localh.header = this.PWg.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(102884);
    return localh;
  }
  
  private void p(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(102879);
    int i = jK(this.PWL);
    int m = jK(this.gxh);
    int k = jK(this.wZw);
    int j = jK(this.PWM);
    if (i > 0)
    {
      this.PWF = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label322;
      }
      this.PWG = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label304;
      }
      if (!this.PWH) {
        break label280;
      }
      i += 4;
      this.PWI = i;
      i += 1;
      label112:
      if ((this.wWd == null) || (this.wWd.wWD.length <= 1) || (eWh())) {
        break label331;
      }
      this.PWE = i;
      i += 1;
      label150:
      if (k <= 0) {
        break label382;
      }
      this.PTz = i;
      if ((k <= 3) || (j <= 0)) {
        break label364;
      }
      if (!this.PWJ) {
        break label340;
      }
      i += 4;
      this.PWK = i;
      i += 1;
      label197:
      if (j <= 0) {
        break label391;
      }
      this.PTA = i;
      i += j + 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        ds(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(102879);
      return;
      this.PWF = 2147483647;
      i = 0;
      break;
      label280:
      i += m + 1;
      this.PWI = i;
      i += 1;
      break label112;
      label304:
      this.PWI = 2147483647;
      i += m + 1;
      break label112;
      label322:
      this.PWG = 2147483647;
      break label112;
      label331:
      this.PWE = 2147483647;
      break label150;
      label340:
      i += k + 1;
      this.PWK = i;
      i += 1;
      break label197;
      label364:
      this.PWK = 2147483647;
      i += k + 1;
      break label197;
      label382:
      this.PTz = 2147483647;
      break label197;
      label391:
      this.PTA = 2147483647;
    }
  }
  
  protected com.tencent.mm.ui.contact.a.a aab(int paramInt)
  {
    AppMethodBeat.i(102885);
    int i = paramInt - this.PTz - 1;
    c localc = new c(paramInt);
    localc.lqW = ((m)this.wZw.get(i));
    localc.PWh = eWh();
    localc.hkH = true;
    localc.wXL = (i + 1);
    localc.gE(localc.lqW.type, localc.lqW.wVW);
    AppMethodBeat.o(102885);
    return localc;
  }
  
  public final boolean anI(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(102887);
    paramInt -= this.PWg.getContentLV().getHeaderViewsCount();
    if (paramInt == this.PWI) {
      if (this.PWH)
      {
        paramInt = this.PWg.getContentLV().getSelectedItemPosition();
        this.PWH = false;
        p(this.query, true, false);
        this.PWg.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102887);
      return bool;
      this.PWH = true;
      p(this.query, true, false);
      this.PWg.getContentLV().setSelection(this.PWI);
      continue;
      if (paramInt == this.PWK)
      {
        if (this.PWJ)
        {
          paramInt = this.PWg.getContentLV().getSelectedItemPosition();
          this.PWJ = false;
          p(this.query, true, false);
          this.PWg.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.PWJ = true;
          p(this.query, true, false);
          this.PWg.getContentLV().setSelection(this.PWK);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = anH(paramInt);
        if ((locala != null) && (locala.hkH) && (this.PWE != 2147483647))
        {
          if (locala.position == this.PWE)
          {
            ac.anJ(1);
            bool = false;
          }
          else
          {
            ac.anJ(0);
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
    this.PWN.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.PWN.add(Integer.valueOf(k));
      i += 1;
    }
    Log.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    gVa();
    AppMethodBeat.o(102873);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.PWF;
    int m = this.PWG;
    int n = this.PTz;
    int i1 = this.PTA;
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
    amZ();
    AppMethodBeat.o(102877);
  }
  
  public void ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102872);
    if (this.PWf != null) {
      this.PWf.B(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102872);
  }
  
  public void finish()
  {
    AppMethodBeat.i(102886);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    amZ();
    AppMethodBeat.o(102886);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected void jJ(List<m> paramList)
  {
    AppMethodBeat.i(102880);
    if (this.PWD == null)
    {
      AppMethodBeat.o(102880);
      return;
    }
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      m localm = (m)paramList.get(i);
      if (!this.PWD.contains(localm.wVX))
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
  
  protected com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(102882);
    Object localObject = null;
    if (paramInt == this.PWE)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).hkH = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).wWd = this.wWd;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(102882);
      return localObject;
      if (paramInt == this.PWF)
      {
        localObject = lk(2131761019, paramInt);
      }
      else if (paramInt == this.PWG)
      {
        localObject = lk(2131761003, paramInt);
      }
      else if (paramInt == this.PTz)
      {
        localObject = lk(2131761002, paramInt);
      }
      else if (paramInt == this.PTA)
      {
        localObject = lk(2131761000, paramInt);
      }
      else if (paramInt == this.PWI)
      {
        localObject = L(2131761003, paramInt, this.PWH);
      }
      else if (paramInt == this.PWK)
      {
        localObject = L(2131761002, paramInt, this.PWJ);
      }
      else
      {
        int i;
        if (paramInt > this.PTA)
        {
          i = paramInt - this.PTA - 1;
          localObject = new e(paramInt);
          ((e)localObject).lqW = ((m)this.PWM.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
          ((e)localObject).hkH = true;
          ((e)localObject).wXL = (i + 1);
          ((e)localObject).gE(((e)localObject).lqW.type, ((e)localObject).lqW.wVW);
        }
        else if (paramInt > this.PTz)
        {
          localObject = aab(paramInt);
        }
        else if (paramInt > this.PWG)
        {
          i = paramInt - this.PWG - 1;
          localObject = new e(paramInt);
          ((e)localObject).lqW = ((m)this.gxh.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
          ((e)localObject).hkH = true;
          ((e)localObject).wXL = (i + 1);
          ((e)localObject).gE(((e)localObject).lqW.type, ((e)localObject).lqW.wVW);
        }
        else if (paramInt > this.PWF)
        {
          i = paramInt - this.PWF - 1;
          m localm = (m)this.PWL.get(i);
          if ((localm.type == 131072) || (localm.type == 131076) || (localm.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).lqW = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
            ((e)localObject).Qad = true;
            ((e)localObject).hkH = true;
            ((e)localObject).wXL = (i + 1);
            ((e)localObject).gE(((e)localObject).lqW.type, ((e)localObject).lqW.wVW);
          }
          else if (localm.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).lqW = localm;
            ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
            ((c)localObject).Qad = true;
            ((c)localObject).hkH = true;
            ((c)localObject).wXL = (i + 1);
            ((c)localObject).gE(((c)localObject).lqW.type, ((c)localObject).lqW.wVW);
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */