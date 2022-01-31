package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a
  extends p
{
  List<String> AyJ;
  List<com.tencent.mm.plugin.fts.a.a.a> AyK;
  List<a> AyL;
  private int count;
  HashSet<String> gpQ;
  ak handler;
  com.tencent.mm.plugin.fts.a.l pym;
  
  public a(m paramm, List<String> paramList, int paramInt)
  {
    super(paramm, null, true, true, paramInt);
    AppMethodBeat.i(35025);
    this.handler = new ak(Looper.getMainLooper());
    this.pym = new a.1(this);
    this.count = 0;
    this.AyJ = paramList;
    this.AyL = new ArrayList();
    this.gpQ = new HashSet();
    AppMethodBeat.o(35025);
  }
  
  private boolean QT(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(35030);
    int j = paramInt - this.Adk.getContentLV().getHeaderViewsCount();
    int i = this.AyL.size() - 1;
    boolean bool1 = bool2;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.AyL.get(i);
      if (locala.mTA != j) {
        break label242;
      }
      if (locala.mTD)
      {
        paramInt = this.Adk.getContentLV().getSelectedItemPosition();
        locala.mTD = false;
        dOg();
        this.Adk.getContentLV().setSelection(paramInt);
        label111:
        notifyDataSetChanged();
        bool1 = true;
      }
    }
    else
    {
      label118:
      AppMethodBeat.o(35030);
      return bool1;
    }
    locala.mTD = true;
    i = 0;
    label134:
    com.tencent.mm.plugin.fts.a.a.l locall;
    if (i < locala.mSW.size())
    {
      locall = (com.tencent.mm.plugin.fts.a.a.l)locala.mSW.get(i);
      if ((!locall.mRV.equals(locala.AyO)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (locall != null)
      {
        locala.mSW.remove(i);
        locala.mSW.add(0, locall);
      }
      dOg();
      this.Adk.getContentLV().setSelection(paramInt);
      break label111;
      i += 1;
      break label134;
      label242:
      if (j == locala.mTy)
      {
        bool1 = true;
        break label118;
      }
      if (paramInt > locala.mTy)
      {
        paramInt = locala.mTy;
        locall = (com.tencent.mm.plugin.fts.a.a.l)locala.mSW.get(j - paramInt - 1);
        if (!locall.mRV.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.Adk;
          if (!ah.isNullOrNil(locala.AyO)) {
            if (locala.AyO.equals(locall.mRV))
            {
              localMMCreateChatroomUI.oCs.amb(locala.AyO);
              this.gpQ.remove(locala.AyO);
              locala.AyO = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.Km();
            notifyDataSetChanged();
            bool1 = true;
            break;
            if (this.gpQ.contains(locall.mRV)) {
              break label529;
            }
            this.gpQ.remove(locala.AyO);
            localMMCreateChatroomUI.oCs.amb(locala.AyO);
            locala.AyO = locall.mRV;
            localMMCreateChatroomUI.oCs.amc(locala.AyO);
            this.gpQ.add(locala.AyO);
            continue;
            if (this.gpQ.contains(locall.mRV)) {
              break label529;
            }
            localMMCreateChatroomUI.oCs.amc(locall.mRV);
            locala.AyO = locall.mRV;
            this.gpQ.add(locala.AyO);
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
      locall = null;
      i = 0;
    }
  }
  
  public final boolean Qu(int paramInt)
  {
    AppMethodBeat.i(35029);
    boolean bool = QT(paramInt);
    AppMethodBeat.o(35029);
    return bool;
  }
  
  final void dOg()
  {
    AppMethodBeat.i(35028);
    Iterator localIterator = this.AyL.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.mSW.size() <= 0) {
        break label142;
      }
      locala.mTy = i;
      i += 1;
      if (locala.mSW.size() > 3)
      {
        if (locala.mTD) {
          i += 3;
        }
        for (;;)
        {
          locala.mTA = i;
          i += 1;
          break;
          i += locala.mSW.size();
        }
      }
      i = locala.mSW.size() + i;
    }
    label142:
    for (;;)
    {
      break;
      this.count = i;
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(35028);
      return;
    }
  }
  
  public final List<String> dOh()
  {
    AppMethodBeat.i(35031);
    HashSet localHashSet = new HashSet();
    Object localObject = this.AyL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (!ah.isNullOrNil(locala.AyO)) {
        localHashSet.add(locala.AyO);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    AppMethodBeat.o(35031);
    return localObject;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(35026);
    super.finish();
    Iterator localIterator = this.AyK.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((n)com.tencent.mm.kernel.g.G(n.class)).cancelSearchTask(locala);
    }
    AppMethodBeat.o(35026);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(35027);
    Object localObject = null;
    int i = this.AyL.size() - 1;
    a locala;
    if (i >= 0)
    {
      locala = (a)this.AyL.get(i);
      if (locala.mTy == paramInt)
      {
        localObject = new h(paramInt);
        ((h)localObject).mZq = this.Adk.getActivity().getString(2131303062, new Object[] { locala.query });
        label90:
        if (localObject == null) {
          break label294;
        }
        ((com.tencent.mm.ui.contact.a.a)localObject).query = locala.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
        ((com.tencent.mm.ui.contact.a.a)localObject).Adl = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35027);
      return localObject;
      if (locala.mTA == paramInt)
      {
        localObject = new j(paramInt);
        ((j)localObject).resId = 2131300209;
        ((j)localObject).mYy = locala.mTD;
        break label90;
      }
      if (paramInt > locala.mTy)
      {
        int j = paramInt - locala.mTy - 1;
        com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)locala.mSW.get(j);
        if (locall.mRV.equals("no_result​"))
        {
          localObject = new i(paramInt);
          break label90;
        }
        localObject = new e(paramInt);
        ((e)localObject).hrL = locall;
        ((com.tencent.mm.ui.contact.a.a)localObject).mRX = locala.mRX;
        ((e)localObject).eBr = true;
        ((e)localObject).mTI = (j + 1);
        ((e)localObject).es(((e)localObject).hrL.type, ((e)localObject).hrL.mRU);
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
    String AyO;
    com.tencent.mm.plugin.fts.a.a.g mRX;
    List<com.tencent.mm.plugin.fts.a.a.l> mSW;
    int mTA = 2147483647;
    boolean mTD = true;
    int mTy = 2147483647;
    String query;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */