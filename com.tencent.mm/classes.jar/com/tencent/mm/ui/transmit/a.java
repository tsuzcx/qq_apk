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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  List<String> IVp;
  List<com.tencent.mm.plugin.fts.a.a.a> IVq;
  List<a> IVr;
  private int count;
  ao handler;
  HashSet<String> iCn;
  l vIP;
  
  public a(com.tencent.mm.ui.contact.n paramn, List<String> paramList, int paramInt)
  {
    super(paramn, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new ao(Looper.getMainLooper());
    this.vIP = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.suU.query;
        locala.sxM = paramAnonymousk.sxM;
        locala.syK = paramAnonymousk.syK;
        if ((locala.syK == null) || (locala.syK.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.sxG = "no_result​";
          locala.syK = new ArrayList();
          locala.syK.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.IVp = paramList;
    this.IVr = new ArrayList();
    this.iCn = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean acx(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.Iwg.getContentLV().getHeaderViewsCount();
    int i = this.IVr.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.IVr.get(i);
      if (locala.szo != j) {
        break label242;
      }
      if (locala.szp)
      {
        paramInt = this.Iwg.getContentLV().getSelectedItemPosition();
        locala.szp = false;
        fud();
        this.Iwg.getContentLV().setSelection(paramInt);
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
    locala.szp = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.syK.size())
    {
      localm = (m)locala.syK.get(i);
      if ((!localm.sxG.equals(locala.IVu)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.syK.remove(i);
        locala.syK.add(0, localm);
      }
      fud();
      this.Iwg.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.szm)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.szm)
      {
        paramInt = locala.szm;
        localm = (m)locala.syK.get(j - paramInt - 1);
        if (!localm.sxG.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.Iwg;
          if (!bs.isNullOrNil(locala.IVu)) {
            if (locala.IVu.equals(localm.sxG))
            {
              localMMCreateChatroomUI.uFo.aGV(locala.IVu);
              this.iCn.remove(locala.IVu);
              locala.IVu = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.WT();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.iCn.contains(localm.sxG)) {
              break label529;
            }
            this.iCn.remove(locala.IVu);
            localMMCreateChatroomUI.uFo.aGV(locala.IVu);
            locala.IVu = localm.sxG;
            localMMCreateChatroomUI.uFo.aGW(locala.IVu);
            this.iCn.add(locala.IVu);
            continue;
            if (this.iCn.contains(localm.sxG)) {
              break label529;
            }
            localMMCreateChatroomUI.uFo.aGW(localm.sxG);
            locala.IVu = localm.sxG;
            this.iCn.add(locala.IVu);
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
  
  public final boolean abR(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = acx(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(39223);
    super.finish();
    Iterator localIterator = this.IVq.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(locala);
    }
    AppMethodBeat.o(39223);
  }
  
  final void fud()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.IVr.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.syK.size() <= 0) {
        break label142;
      }
      locala.szm = i;
      i += 1;
      if (locala.syK.size() > 3)
      {
        if (locala.szp) {
          i += 3;
        }
        for (;;)
        {
          locala.szo = i;
          i += 1;
          break;
          i += locala.syK.size();
        }
      }
      i = locala.syK.size() + i;
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
  
  public final List<String> fue()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.IVr.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!bs.isNullOrNil(locala.IVu)) {
        localHashSet.add(locala.IVu);
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
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.IVr.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.IVr.get(i);
      if (locala.szm == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject).header = this.Iwg.getActivity().getString(2131763008, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).Iwh = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.szo == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).resId = 2131759682;
        ((com.tencent.mm.ui.contact.a.j)localObject).rVH = locala.szp;
        break label90;
      }
      if (paramInt > locala.szm)
      {
        int j = paramInt - locala.szm - 1;
        m localm = (m)locala.syK.get(j);
        if (localm.sxG.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).jPN = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).sxM = locala.sxM;
        ((e)localObject).gbD = true;
        ((e)localObject).szu = (j + 1);
        ((e)localObject).fP(((e)localObject).jPN.type, ((e)localObject).jPN.sxF);
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
    String IVu;
    String query;
    com.tencent.mm.plugin.fts.a.a.h sxM;
    List<m> syK;
    int szm = 2147483647;
    int szo = 2147483647;
    boolean szp = true;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */