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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  List<String> LiR;
  List<com.tencent.mm.plugin.fts.a.a.a> LiS;
  List<a> LiT;
  private int count;
  aq handler;
  HashSet<String> iYq;
  l xfN;
  
  public a(com.tencent.mm.ui.contact.n paramn, List<String> paramList, int paramInt)
  {
    super(paramn, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new aq(Looper.getMainLooper());
    this.xfN = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.tCm.query;
        locala.tFe = paramAnonymousk.tFe;
        locala.tGc = paramAnonymousk.tGc;
        if ((locala.tGc == null) || (locala.tGc.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.tEY = "no_result​";
          locala.tGc = new ArrayList();
          locala.tGc.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.LiR = paramList;
    this.LiT = new ArrayList();
    this.iYq = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean afE(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.KJi.getContentLV().getHeaderViewsCount();
    int i = this.LiT.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.LiT.get(i);
      if (locala.tGG != j) {
        break label242;
      }
      if (locala.tGH)
      {
        paramInt = this.KJi.getContentLV().getSelectedItemPosition();
        locala.tGH = false;
        fPj();
        this.KJi.getContentLV().setSelection(paramInt);
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
    locala.tGH = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.tGc.size())
    {
      localm = (m)locala.tGc.get(i);
      if ((!localm.tEY.equals(locala.LiW)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.tGc.remove(i);
        locala.tGc.add(0, localm);
      }
      fPj();
      this.KJi.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.tGE)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.tGE)
      {
        paramInt = locala.tGE;
        localm = (m)locala.tGc.get(j - paramInt - 1);
        if (!localm.tEY.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.KJi;
          if (!bu.isNullOrNil(locala.LiW)) {
            if (locala.LiW.equals(localm.tEY))
            {
              localMMCreateChatroomUI.vUs.aNU(locala.LiW);
              this.iYq.remove(locala.LiW);
              locala.LiW = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.Zv();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.iYq.contains(localm.tEY)) {
              break label529;
            }
            this.iYq.remove(locala.LiW);
            localMMCreateChatroomUI.vUs.aNU(locala.LiW);
            locala.LiW = localm.tEY;
            localMMCreateChatroomUI.vUs.aNV(locala.LiW);
            this.iYq.add(locala.LiW);
            continue;
            if (this.iYq.contains(localm.tEY)) {
              break label529;
            }
            localMMCreateChatroomUI.vUs.aNV(localm.tEY);
            locala.LiW = localm.tEY;
            this.iYq.add(locala.LiW);
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
  
  public final boolean aeX(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = afE(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  final void fPj()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.LiT.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.tGc.size() <= 0) {
        break label142;
      }
      locala.tGE = i;
      i += 1;
      if (locala.tGc.size() > 3)
      {
        if (locala.tGH) {
          i += 3;
        }
        for (;;)
        {
          locala.tGG = i;
          i += 1;
          break;
          i += locala.tGc.size();
        }
      }
      i = locala.tGc.size() + i;
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
  
  public final List<String> fPk()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.LiT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!bu.isNullOrNil(locala.LiW)) {
        localHashSet.add(locala.LiW);
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
    Iterator localIterator = this.LiS.iterator();
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
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.LiT.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.LiT.get(i);
      if (locala.tGE == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject).header = this.KJi.getActivity().getString(2131763008, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).KJj = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.tGG == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).resId = 2131759682;
        ((com.tencent.mm.ui.contact.a.j)localObject).tdC = locala.tGH;
        break label90;
      }
      if (paramInt > locala.tGE)
      {
        int j = paramInt - locala.tGE - 1;
        m localm = (m)locala.tGc.get(j);
        if (localm.tEY.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).kno = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).tFe = locala.tFe;
        ((e)localObject).gxU = true;
        ((e)localObject).tGM = (j + 1);
        ((e)localObject).gf(((e)localObject).kno.type, ((e)localObject).kno.tEX);
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
    String LiW;
    String query;
    com.tencent.mm.plugin.fts.a.a.h tFe;
    int tGE = 2147483647;
    int tGG = 2147483647;
    boolean tGH = true;
    List<m> tGc;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */