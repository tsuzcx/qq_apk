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
  List<String> KMt;
  List<com.tencent.mm.plugin.fts.a.a.a> KMu;
  List<a> KMv;
  private int count;
  ap handler;
  HashSet<String> iVx;
  l wPW;
  
  public a(com.tencent.mm.ui.contact.n paramn, List<String> paramList, int paramInt)
  {
    super(paramn, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new ap(Looper.getMainLooper());
    this.wPW = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.trv.query;
        locala.tun = paramAnonymousk.tun;
        locala.tvl = paramAnonymousk.tvl;
        if ((locala.tvl == null) || (locala.tvl.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.tuh = "no_result​";
          locala.tvl = new ArrayList();
          locala.tvl.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.KMt = paramList;
    this.KMv = new ArrayList();
    this.iVx = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean aeV(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.KmO.getContentLV().getHeaderViewsCount();
    int i = this.KMv.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.KMv.get(i);
      if (locala.tvP != j) {
        break label242;
      }
      if (locala.tvQ)
      {
        paramInt = this.KmO.getContentLV().getSelectedItemPosition();
        locala.tvQ = false;
        fKQ();
        this.KmO.getContentLV().setSelection(paramInt);
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
    locala.tvQ = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.tvl.size())
    {
      localm = (m)locala.tvl.get(i);
      if ((!localm.tuh.equals(locala.KMy)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.tvl.remove(i);
        locala.tvl.add(0, localm);
      }
      fKQ();
      this.KmO.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.tvN)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.tvN)
      {
        paramInt = locala.tvN;
        localm = (m)locala.tvl.get(j - paramInt - 1);
        if (!localm.tuh.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.KmO;
          if (!bt.isNullOrNil(locala.KMy)) {
            if (locala.KMy.equals(localm.tuh))
            {
              localMMCreateChatroomUI.vIo.aMy(locala.KMy);
              this.iVx.remove(locala.KMy);
              locala.KMy = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.Zm();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.iVx.contains(localm.tuh)) {
              break label529;
            }
            this.iVx.remove(locala.KMy);
            localMMCreateChatroomUI.vIo.aMy(locala.KMy);
            locala.KMy = localm.tuh;
            localMMCreateChatroomUI.vIo.aMz(locala.KMy);
            this.iVx.add(locala.KMy);
            continue;
            if (this.iVx.contains(localm.tuh)) {
              break label529;
            }
            localMMCreateChatroomUI.vIo.aMz(localm.tuh);
            locala.KMy = localm.tuh;
            this.iVx.add(locala.KMy);
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
  
  public final boolean aeo(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = aeV(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  final void fKQ()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.KMv.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.tvl.size() <= 0) {
        break label142;
      }
      locala.tvN = i;
      i += 1;
      if (locala.tvl.size() > 3)
      {
        if (locala.tvQ) {
          i += 3;
        }
        for (;;)
        {
          locala.tvP = i;
          i += 1;
          break;
          i += locala.tvl.size();
        }
      }
      i = locala.tvl.size() + i;
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
  
  public final List<String> fKR()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.KMv.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!bt.isNullOrNil(locala.KMy)) {
        localHashSet.add(locala.KMy);
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
    Iterator localIterator = this.KMu.iterator();
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
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.KMv.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.KMv.get(i);
      if (locala.tvN == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject).header = this.KmO.getActivity().getString(2131763008, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).KmP = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.tvP == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).resId = 2131759682;
        ((com.tencent.mm.ui.contact.a.j)localObject).sSq = locala.tvQ;
        break label90;
      }
      if (paramInt > locala.tvN)
      {
        int j = paramInt - locala.tvN - 1;
        m localm = (m)locala.tvl.get(j);
        if (localm.tuh.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).kjY = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).tun = locala.tun;
        ((e)localObject).gvn = true;
        ((e)localObject).tvV = (j + 1);
        ((e)localObject).gf(((e)localObject).kjY.type, ((e)localObject).kjY.tug);
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
    String KMy;
    String query;
    com.tencent.mm.plugin.fts.a.a.h tun;
    int tvN = 2147483647;
    int tvP = 2147483647;
    boolean tvQ = true;
    List<m> tvl;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */