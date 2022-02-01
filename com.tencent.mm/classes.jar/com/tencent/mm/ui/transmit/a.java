package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a
  extends r
{
  com.tencent.mm.plugin.fts.a.l MVp;
  List<String> afMm;
  List<c> afMn;
  List<a> afMo;
  private int count;
  MMHandler handler;
  HashSet<String> pJQ;
  
  public a(com.tencent.mm.ui.contact.o paramo, List<String> paramList, int paramInt)
  {
    super(paramo, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.MVp = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.m paramAnonymousm)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousm.HpM.query;
        locala.FWt = paramAnonymousm.FWt;
        locala.HtF = paramAnonymousm.HtF;
        if ((locala.HtF == null) || (locala.HtF.size() == 0))
        {
          paramAnonymousm = new com.tencent.mm.plugin.fts.a.a.o();
          paramAnonymousm.Hsz = "no_result​";
          locala.HtF = new ArrayList();
          locala.HtF.add(paramAnonymousm);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.afMm = paramList;
    this.afMo = new ArrayList();
    this.pJQ = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean aEh(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.afex.getContentLV().getHeaderViewsCount();
    int i = this.afMo.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.afMo.get(i);
      if (locala.Hul != j) {
        break label242;
      }
      if (locala.vpw)
      {
        paramInt = this.afex.getContentLV().getSelectedItemPosition();
        locala.vpw = false;
        jDx();
        this.afex.getContentLV().setSelection(paramInt);
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
    locala.vpw = true;
    i = 0;
    label134:
    com.tencent.mm.plugin.fts.a.a.o localo;
    if (i < locala.HtF.size())
    {
      localo = (com.tencent.mm.plugin.fts.a.a.o)locala.HtF.get(i);
      if ((!localo.Hsz.equals(locala.afMr)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localo != null)
      {
        locala.HtF.remove(i);
        locala.HtF.add(0, localo);
      }
      jDx();
      this.afex.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.Huj)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.Huj)
      {
        paramInt = locala.Huj;
        localo = (com.tencent.mm.plugin.fts.a.a.o)locala.HtF.get(j - paramInt - 1);
        if (!localo.Hsz.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.afex;
          if (!Util.isNullOrNil(locala.afMr)) {
            if (locala.afMr.equals(localo.Hsz))
            {
              localMMCreateChatroomUI.KOt.bqH(locala.afMr);
              this.pJQ.remove(locala.afMr);
              locala.afMr = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.aNr();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.pJQ.contains(localo.Hsz)) {
              break label529;
            }
            this.pJQ.remove(locala.afMr);
            localMMCreateChatroomUI.KOt.bqH(locala.afMr);
            locala.afMr = localo.Hsz;
            localMMCreateChatroomUI.KOt.bqI(locala.afMr);
            this.pJQ.add(locala.afMr);
            continue;
            if (this.pJQ.contains(localo.Hsz)) {
              break label529;
            }
            localMMCreateChatroomUI.KOt.bqI(localo.Hsz);
            locala.afMr = localo.Hsz;
            this.pJQ.add(locala.afMr);
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
      localo = null;
      i = 0;
    }
  }
  
  public final boolean aDu(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = aEh(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(39223);
    super.finish();
    Iterator localIterator = this.afMn.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      ((n)h.az(n.class)).cancelSearchTask(localc);
    }
    AppMethodBeat.o(39223);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  final void jDx()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.afMo.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.HtF.size() <= 0) {
        break label142;
      }
      locala.Huj = i;
      i += 1;
      if (locala.HtF.size() > 3)
      {
        if (locala.vpw) {
          i += 3;
        }
        for (;;)
        {
          locala.Hul = i;
          i += 1;
          break;
          i += locala.HtF.size();
        }
      }
      i = locala.HtF.size() + i;
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
  
  public final List<String> jDy()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.afMo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!Util.isNullOrNil(locala.afMr)) {
        localHashSet.add(locala.afMr);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    AppMethodBeat.o(39228);
    return localObject;
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.afMo.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.afMo.get(i);
      if (locala.Huj == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).header = this.afex.getActivity().getString(R.l.gUI, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
        ((com.tencent.mm.ui.contact.a.a)localObject).afey = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.Hul == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.m(paramInt);
        ((com.tencent.mm.ui.contact.a.m)localObject).resId = R.l.fts_header_contact;
        ((com.tencent.mm.ui.contact.a.m)localObject).Gxy = locala.vpw;
        break label90;
      }
      if (paramInt > locala.Huj)
      {
        int j = paramInt - locala.Huj - 1;
        com.tencent.mm.plugin.fts.a.a.o localo = (com.tencent.mm.plugin.fts.a.a.o)locala.HtF.get(j);
        if (localo.Hsz.equals("no_result​"))
        {
          localObject = new com.tencent.mm.ui.contact.a.l(paramInt);
          break label90;
        }
        localObject = new f(paramInt);
        ((f)localObject).rpp = localo;
        ((com.tencent.mm.ui.contact.a.a)localObject).FWt = locala.FWt;
        ((f)localObject).mwk = true;
        ((f)localObject).Huq = (j + 1);
        ((f)localObject).iW(((f)localObject).rpp.type, ((f)localObject).rpp.subtype);
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
    com.tencent.mm.plugin.fts.a.a.j FWt;
    List<com.tencent.mm.plugin.fts.a.a.o> HtF;
    int Huj = 2147483647;
    int Hul = 2147483647;
    String afMr;
    String query;
    boolean vpw = true;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */