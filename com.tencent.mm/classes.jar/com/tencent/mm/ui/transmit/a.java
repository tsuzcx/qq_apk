package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a
  extends q
{
  l Bdt;
  List<String> QxQ;
  List<com.tencent.mm.plugin.fts.a.a.a> QxR;
  List<a> QxS;
  private int count;
  MMHandler handler;
  HashSet<String> jVV;
  
  public a(com.tencent.mm.ui.contact.n paramn, List<String> paramList, int paramInt)
  {
    super(paramn, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Bdt = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.wTn.query;
        locala.wWd = paramAnonymousk.wWd;
        locala.wXb = paramAnonymousk.wXb;
        if ((locala.wXb == null) || (locala.wXb.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.wVX = "no_result​";
          locala.wXb = new ArrayList();
          locala.wXb.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.QxQ = paramList;
    this.QxS = new ArrayList();
    this.jVV = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean aor(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.PWg.getContentLV().getHeaderViewsCount();
    int i = this.QxS.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.QxS.get(i);
      if (locala.wXF != j) {
        break label242;
      }
      if (locala.wXG)
      {
        paramInt = this.PWg.getContentLV().getSelectedItemPosition();
        locala.wXG = false;
        gYc();
        this.PWg.getContentLV().setSelection(paramInt);
        label111:
        notifyDataSetChanged();
        bool1 = true;
      }
    }
    else
    {
      label118:
      AppMethodBeat.o(39227);
      return bool1;
    }
    locala.wXG = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.wXb.size())
    {
      localm = (m)locala.wXb.get(i);
      if ((!localm.wVX.equals(locala.QxV)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.wXb.remove(i);
        locala.wXb.add(0, localm);
      }
      gYc();
      this.PWg.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.wXD)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.wXD)
      {
        paramInt = locala.wXD;
        localm = (m)locala.wXb.get(j - paramInt - 1);
        if (!localm.wVX.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.PWg;
          if (!Util.isNullOrNil(locala.QxV)) {
            if (locala.QxV.equals(localm.wVX))
            {
              localMMCreateChatroomUI.zoy.bew(locala.QxV);
              this.jVV.remove(locala.QxV);
              locala.QxV = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.ani();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.jVV.contains(localm.wVX)) {
              break label529;
            }
            this.jVV.remove(locala.QxV);
            localMMCreateChatroomUI.zoy.bew(locala.QxV);
            locala.QxV = localm.wVX;
            localMMCreateChatroomUI.zoy.bex(locala.QxV);
            this.jVV.add(locala.QxV);
            continue;
            if (this.jVV.contains(localm.wVX)) {
              break label529;
            }
            localMMCreateChatroomUI.zoy.bex(localm.wVX);
            locala.QxV = localm.wVX;
            this.jVV.add(locala.QxV);
          }
        }
      }
      else
      {
        i -= 1;
        break;
      }
      label529:
      bool1 = true;
      break label118;
      localm = null;
      i = 0;
    }
  }
  
  public final boolean anI(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = aor(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(39223);
    super.finish();
    Iterator localIterator = this.QxR.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(locala);
    }
    AppMethodBeat.o(39223);
  }
  
  final void gYc()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.QxS.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.wXb.size() <= 0) {
        break label142;
      }
      locala.wXD = i;
      i += 1;
      if (locala.wXb.size() > 3)
      {
        if (locala.wXG) {
          i += 3;
        }
        for (;;)
        {
          locala.wXF = i;
          i += 1;
          break;
          i += locala.wXb.size();
        }
      }
      i = locala.wXb.size() + i;
    }
    label142:
    for (;;)
    {
      break;
      this.count = i;
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(39225);
      return;
    }
  }
  
  public final List<String> gYd()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.QxS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!Util.isNullOrNil(locala.QxV)) {
        localHashSet.add(locala.QxV);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    AppMethodBeat.o(39228);
    return localObject;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.QxS.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.QxS.get(i);
      if (locala.wXD == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject).header = this.PWg.getActivity().getString(2131765145, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).PWh = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.wXF == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).resId = 2131761003;
        ((com.tencent.mm.ui.contact.a.j)localObject).wke = locala.wXG;
        break label90;
      }
      if (paramInt > locala.wXD)
      {
        int j = paramInt - locala.wXD - 1;
        m localm = (m)locala.wXb.get(j);
        if (localm.wVX.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).lqW = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).wWd = locala.wWd;
        ((e)localObject).hkH = true;
        ((e)localObject).wXL = (j + 1);
        ((e)localObject).gE(((e)localObject).lqW.type, ((e)localObject).lqW.wVW);
        break label90;
        label294:
        i -= 1;
        break;
      }
      break label90;
    }
  }
  
  final class a
  {
    String QxV;
    String query;
    com.tencent.mm.plugin.fts.a.a.h wWd;
    int wXD = 2147483647;
    int wXF = 2147483647;
    boolean wXG = true;
    List<m> wXb;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */