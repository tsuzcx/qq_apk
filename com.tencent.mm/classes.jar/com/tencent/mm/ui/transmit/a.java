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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  List<String> HuS;
  List<com.tencent.mm.plugin.fts.a.a.a> HuT;
  List<a> HuU;
  private int count;
  ap handler;
  HashSet<String> icg;
  l uzW;
  
  public a(com.tencent.mm.ui.contact.n paramn, List<String> paramList, int paramInt)
  {
    super(paramn, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new ap(Looper.getMainLooper());
    this.uzW = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.rma.query;
        locala.roS = paramAnonymousk.roS;
        locala.rpQ = paramAnonymousk.rpQ;
        if ((locala.rpQ == null) || (locala.rpQ.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.roN = "no_result​";
          locala.rpQ = new ArrayList();
          locala.rpQ.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.HuS = paramList;
    this.HuU = new ArrayList();
    this.icg = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean aak(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.GVS.getContentLV().getHeaderViewsCount();
    int i = this.HuU.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.HuU.get(i);
      if (locala.rqu != j) {
        break label242;
      }
      if (locala.rqv)
      {
        paramInt = this.GVS.getContentLV().getSelectedItemPosition();
        locala.rqv = false;
        fei();
        this.GVS.getContentLV().setSelection(paramInt);
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
    locala.rqv = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.rpQ.size())
    {
      localm = (m)locala.rpQ.get(i);
      if ((!localm.roN.equals(locala.HuX)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.rpQ.remove(i);
        locala.rpQ.add(0, localm);
      }
      fei();
      this.GVS.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.rqs)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.rqs)
      {
        paramInt = locala.rqs;
        localm = (m)locala.rpQ.get(j - paramInt - 1);
        if (!localm.roN.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.GVS;
          if (!bt.isNullOrNil(locala.HuX)) {
            if (locala.HuX.equals(localm.roN))
            {
              localMMCreateChatroomUI.twW.aBD(locala.HuX);
              this.icg.remove(locala.HuX);
              locala.HuX = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.VV();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.icg.contains(localm.roN)) {
              break label529;
            }
            this.icg.remove(locala.HuX);
            localMMCreateChatroomUI.twW.aBD(locala.HuX);
            locala.HuX = localm.roN;
            localMMCreateChatroomUI.twW.aBE(locala.HuX);
            this.icg.add(locala.HuX);
            continue;
            if (this.icg.contains(localm.roN)) {
              break label529;
            }
            localMMCreateChatroomUI.twW.aBE(localm.roN);
            locala.HuX = localm.roN;
            this.icg.add(locala.HuX);
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
  
  public final boolean ZD(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = aak(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  final void fei()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.HuU.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.rpQ.size() <= 0) {
        break label142;
      }
      locala.rqs = i;
      i += 1;
      if (locala.rpQ.size() > 3)
      {
        if (locala.rqv) {
          i += 3;
        }
        for (;;)
        {
          locala.rqu = i;
          i += 1;
          break;
          i += locala.rpQ.size();
        }
      }
      i = locala.rpQ.size() + i;
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
  
  public final List<String> fej()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.HuU.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!bt.isNullOrNil(locala.HuX)) {
        localHashSet.add(locala.HuX);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    AppMethodBeat.o(39228);
    return localObject;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(39223);
    super.finish();
    Iterator localIterator = this.HuT.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(locala);
    }
    AppMethodBeat.o(39223);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.HuU.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.HuU.get(i);
      if (locala.rqs == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject).header = this.GVS.getActivity().getString(2131763008, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).GVT = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.rqu == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).resId = 2131759682;
        ((com.tencent.mm.ui.contact.a.j)localObject).qVx = locala.rqv;
        break label90;
      }
      if (paramInt > locala.rqs)
      {
        int j = paramInt - locala.rqs - 1;
        m localm = (m)locala.rpQ.get(j);
        if (localm.roN.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).jpy = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).roS = locala.roS;
        ((e)localObject).fWW = true;
        ((e)localObject).rqA = (j + 1);
        ((e)localObject).fI(((e)localObject).jpy.type, ((e)localObject).jpy.roM);
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
    String HuX;
    String query;
    com.tencent.mm.plugin.fts.a.a.h roS;
    List<m> rpQ;
    int rqs = 2147483647;
    int rqu = 2147483647;
    boolean rqv = true;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */