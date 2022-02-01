package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a
  extends r
{
  com.tencent.mm.plugin.fts.a.l GXs;
  List<String> XVV;
  List<com.tencent.mm.plugin.fts.a.a.a> XVW;
  List<a> XVX;
  private int count;
  MMHandler handler;
  HashSet<String> mNi;
  
  public a(o paramo, List<String> paramList, int paramInt)
  {
    super(paramo, null, true, true, paramInt);
    AppMethodBeat.i(39222);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.GXs = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(com.tencent.mm.plugin.fts.a.a.k paramAnonymousk)
      {
        AppMethodBeat.i(39220);
        a.a locala = new a.a(a.this, (byte)0);
        locala.query = paramAnonymousk.BFk.query;
        locala.BHY = paramAnonymousk.BHY;
        locala.BIW = paramAnonymousk.BIW;
        if ((locala.BIW == null) || (locala.BIW.size() == 0))
        {
          paramAnonymousk = new m();
          paramAnonymousk.BHS = "no_result​";
          locala.BIW = new ArrayList();
          locala.BIW.add(paramAnonymousk);
        }
        a.a(a.this).add(locala);
        a.b(a.this);
        AppMethodBeat.o(39220);
      }
    };
    this.count = 0;
    this.XVV = paramList;
    this.XVX = new ArrayList();
    this.mNi = new HashSet();
    AppMethodBeat.o(39222);
  }
  
  private boolean axy(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(39227);
    int j = paramInt - this.XsW.getContentLV().getHeaderViewsCount();
    int i = this.XVX.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.XVX.get(i);
      if (locala.BJB != j) {
        break label242;
      }
      if (locala.BJC)
      {
        paramInt = this.XsW.getContentLV().getSelectedItemPosition();
        locala.BJC = false;
        hYN();
        this.XsW.getContentLV().setSelection(paramInt);
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
    locala.BJC = true;
    i = 0;
    label134:
    m localm;
    if (i < locala.BIW.size())
    {
      localm = (m)locala.BIW.get(i);
      if ((!localm.BHS.equals(locala.XWa)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (localm != null)
      {
        locala.BIW.remove(i);
        locala.BIW.add(0, localm);
      }
      hYN();
      this.XsW.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.BJz)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.BJz)
      {
        paramInt = locala.BJz;
        localm = (m)locala.BIW.get(j - paramInt - 1);
        if (!localm.BHS.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.XsW;
          if (!Util.isNullOrNil(locala.XWa)) {
            if (locala.XWa.equals(localm.BHS))
            {
              localMMCreateChatroomUI.ETP.bqS(locala.XWa);
              this.mNi.remove(locala.XWa);
              locala.XWa = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.atk();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.mNi.contains(localm.BHS)) {
              break label529;
            }
            this.mNi.remove(locala.XWa);
            localMMCreateChatroomUI.ETP.bqS(locala.XWa);
            locala.XWa = localm.BHS;
            localMMCreateChatroomUI.ETP.bqT(locala.XWa);
            this.mNi.add(locala.XWa);
            continue;
            if (this.mNi.contains(localm.BHS)) {
              break label529;
            }
            localMMCreateChatroomUI.ETP.bqT(localm.BHS);
            locala.XWa = localm.BHS;
            this.mNi.add(locala.XWa);
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
  
  public final boolean awN(int paramInt)
  {
    AppMethodBeat.i(39226);
    boolean bool = axy(paramInt);
    AppMethodBeat.o(39226);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(39223);
    super.finish();
    Iterator localIterator = this.XVW.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((n)com.tencent.mm.kernel.h.ag(n.class)).cancelSearchTask(locala);
    }
    AppMethodBeat.o(39223);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  final void hYN()
  {
    AppMethodBeat.i(39225);
    Iterator localIterator = this.XVX.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.BIW.size() <= 0) {
        break label142;
      }
      locala.BJz = i;
      i += 1;
      if (locala.BIW.size() > 3)
      {
        if (locala.BJC) {
          i += 3;
        }
        for (;;)
        {
          locala.BJB = i;
          i += 1;
          break;
          i += locala.BIW.size();
        }
      }
      i = locala.BIW.size() + i;
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
  
  public final List<String> hYO()
  {
    AppMethodBeat.i(39228);
    HashSet localHashSet = new HashSet();
    Object localObject = this.XVX.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!Util.isNullOrNil(locala.XWa)) {
        localHashSet.add(locala.XWa);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    AppMethodBeat.o(39228);
    return localObject;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(39224);
    Object localObject = null;
    int i = this.XVX.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.XVX.get(i);
      if (locala.BJz == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.j(paramInt);
        ((com.tencent.mm.ui.contact.a.j)localObject).header = this.XsW.getActivity().getString(R.l.eRY, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = getScene();
        ((com.tencent.mm.ui.contact.a.a)localObject).XsX = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(39224);
      return localObject;
      if (locala.BJB == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.l(paramInt);
        ((com.tencent.mm.ui.contact.a.l)localObject).resId = R.l.fts_header_contact;
        ((com.tencent.mm.ui.contact.a.l)localObject).AUY = locala.BJC;
        break label90;
      }
      if (paramInt > locala.BJz)
      {
        int j = paramInt - locala.BJz - 1;
        m localm = (m)locala.BIW.get(j);
        if (localm.BHS.equals("no_result​"))
        {
          localObject = new com.tencent.mm.ui.contact.a.k(paramInt);
          break label90;
        }
        localObject = new f(paramInt);
        ((f)localObject).olG = localm;
        ((com.tencent.mm.ui.contact.a.a)localObject).BHY = locala.BHY;
        ((f)localObject).jWq = true;
        ((f)localObject).BJH = (j + 1);
        ((f)localObject).hx(((f)localObject).olG.type, ((f)localObject).olG.BHR);
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
    com.tencent.mm.plugin.fts.a.a.h BHY;
    List<m> BIW;
    int BJB = 2147483647;
    boolean BJC = true;
    int BJz = 2147483647;
    String XWa;
    String query;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */