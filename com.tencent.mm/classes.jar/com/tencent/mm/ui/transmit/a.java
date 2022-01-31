package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a
  extends o
{
  private int count = 0;
  HashSet<String> eXT;
  com.tencent.mm.sdk.platformtools.ah handler = new com.tencent.mm.sdk.platformtools.ah(Looper.getMainLooper());
  com.tencent.mm.plugin.fts.a.l mVF = new a.1(this);
  List<String> wfS;
  List<com.tencent.mm.plugin.fts.a.a.a> wfT;
  List<a.a> wfU;
  
  public a(com.tencent.mm.ui.contact.l paraml, List<String> paramList, int paramInt)
  {
    super(paraml, null, true, true, paramInt);
    this.wfS = paramList;
    this.wfU = new ArrayList();
    this.eXT = new HashSet();
  }
  
  private boolean Ih(int paramInt)
  {
    boolean bool2 = false;
    int j = paramInt - this.vLI.getContentLV().getHeaderViewsCount();
    int i = this.wfU.size() - 1;
    boolean bool1 = bool2;
    a.a locala;
    if (i >= 0)
    {
      locala = (a.a)this.wfU.get(i);
      if (locala.kxM != j) {
        break label232;
      }
      if (locala.kxP)
      {
        paramInt = this.vLI.getContentLV().getSelectedItemPosition();
        locala.kxP = false;
        cJq();
        this.vLI.getContentLV().setSelection(paramInt);
        label106:
        notifyDataSetChanged();
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    locala.kxP = true;
    i = 0;
    label124:
    com.tencent.mm.plugin.fts.a.a.l locall;
    if (i < locala.kxh.size())
    {
      locall = (com.tencent.mm.plugin.fts.a.a.l)locala.kxh.get(i);
      if ((!locall.kwg.equals(locala.wfX)) || (i <= 2)) {}
    }
    for (;;)
    {
      if (locall != null)
      {
        locala.kxh.remove(i);
        locala.kxh.add(0, locall);
      }
      cJq();
      this.vLI.getContentLV().setSelection(paramInt);
      break label106;
      i += 1;
      break label124;
      label232:
      if (j == locala.kxK) {
        return true;
      }
      if (paramInt > locala.kxK)
      {
        paramInt = locala.kxK;
        locall = (com.tencent.mm.plugin.fts.a.a.l)locala.kxh.get(j - paramInt - 1);
        if (!locall.kwg.equals("no_result​"))
        {
          MMCreateChatroomUI localMMCreateChatroomUI = (MMCreateChatroomUI)this.vLI;
          if (!com.tencent.mm.platformtools.ah.bl(locala.wfX)) {
            if (locala.wfX.equals(locall.kwg))
            {
              localMMCreateChatroomUI.mbR.Ww(locala.wfX);
              this.eXT.remove(locala.wfX);
              locala.wfX = null;
            }
          }
          for (;;)
          {
            localMMCreateChatroomUI.xU();
            notifyDataSetChanged();
            return true;
            if (this.eXT.contains(locall.kwg)) {
              break;
            }
            this.eXT.remove(locala.wfX);
            localMMCreateChatroomUI.mbR.Ww(locala.wfX);
            locala.wfX = locall.kwg;
            localMMCreateChatroomUI.mbR.bz(locala.wfX, false);
            this.eXT.add(locala.wfX);
            continue;
            if (this.eXT.contains(locall.kwg)) {
              break;
            }
            localMMCreateChatroomUI.mbR.bz(locall.kwg, false);
            locala.wfX = locall.kwg;
            this.eXT.add(locala.wfX);
          }
        }
      }
      else
      {
        i -= 1;
        break;
      }
      return true;
      locall = null;
      i = 0;
    }
  }
  
  public final boolean HL(int paramInt)
  {
    return Ih(paramInt);
  }
  
  final void cJq()
  {
    Iterator localIterator = this.wfU.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.kxh.size() <= 0) {
        break label132;
      }
      locala.kxK = i;
      i += 1;
      if (locala.kxh.size() > 3)
      {
        if (locala.kxP) {
          i += 3;
        }
        for (;;)
        {
          locala.kxM = i;
          i += 1;
          break;
          i += locala.kxh.size();
        }
      }
      i = locala.kxh.size() + i;
    }
    label132:
    for (;;)
    {
      break;
      this.count = i;
      clearCache();
      notifyDataSetChanged();
      return;
    }
  }
  
  public final List<String> cJr()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = this.wfU.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.a locala = (a.a)((Iterator)localObject).next();
      if (!com.tencent.mm.platformtools.ah.bl(locala.wfX)) {
        localHashSet.add(locala.wfX);
      }
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(localHashSet);
    return localObject;
  }
  
  public final void finish()
  {
    super.finish();
    Iterator localIterator = this.wfT.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.a locala = (com.tencent.mm.plugin.fts.a.a.a)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(locala);
    }
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    Object localObject = null;
    int i = this.wfU.size() - 1;
    if (i >= 0)
    {
      a.a locala = (a.a)this.wfU.get(i);
      if (locala.kxK == paramInt)
      {
        localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
        ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getString(R.l.select_create_chatroom_query, new Object[] { locala.bVk });
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((com.tencent.mm.ui.contact.a.a)localObject).bVk = locala.bVk;
          ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
          ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = true;
          return localObject;
          if (locala.kxM == paramInt)
          {
            localObject = new i(paramInt);
            ((i)localObject).kCB = R.l.fts_header_contact;
            ((i)localObject).kCC = locala.kxP;
          }
          else if (paramInt > locala.kxK)
          {
            int j = paramInt - locala.kxK - 1;
            com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)locala.kxh.get(j);
            if (locall.kwg.equals("no_result​"))
            {
              localObject = new h(paramInt);
            }
            else
            {
              localObject = new d(paramInt);
              ((d)localObject).fYx = locall;
              ((com.tencent.mm.ui.contact.a.a)localObject).kwi = locala.kwi;
              ((d)localObject).dDQ = true;
              ((d)localObject).kxV = (j + 1);
              ((d)localObject).cU(((d)localObject).fYx.type, ((d)localObject).fYx.kwf);
            }
          }
        }
        else
        {
          i -= 1;
          break;
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a
 * JD-Core Version:    0.7.0.1
 */