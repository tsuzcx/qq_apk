package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.pluginsdk.ui.applet.s.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private int scene;
  private boolean vNx;
  private List<String> wfS;
  private boolean wgb;
  a wgc;
  private b wgd;
  private boolean wge;
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!au.DK()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      au.Hx();
      ad localad = c.Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    parama.d(new MMCreateChatroomUI.2(this, parama));
    getString(R.l.app_tip);
    parama.a(this, getString(R.l.launchchatting_creating_chatroom), true, new MMCreateChatroomUI.3(this, parama));
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    return getString(R.l.select_create_chatroom_title);
  }
  
  protected final o VF()
  {
    if (this.wgc == null) {
      this.wgc = new a(this, this.wfS, this.scene);
    }
    return this.wgc;
  }
  
  protected final m VG()
  {
    if (this.wgd == null) {
      this.wgd = new b(this, this.scene);
    }
    return this.wgd;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((parama instanceof d))
    {
      Object localObject = (d)parama;
      parama = this.wgc;
      localObject = ((d)localObject).fYx.kwg;
      bool1 = bool2;
      if (parama.eXT.contains(localObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama instanceof d))
    {
      Object localObject = (d)parama;
      a locala = this.wgc;
      localObject = ((d)localObject).fYx.kwg;
      int j = parama.position;
      if (locala.eXT.contains(localObject))
      {
        int i = locala.wfU.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.wfU.get(i);
          if (j < parama.kxK) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label117;
          }
          if (((String)localObject).equals(parama.wfX)) {
            break label119;
          }
          return true;
          i -= 1;
          break;
          parama = null;
        }
        label117:
        return false;
      }
      label119:
      return false;
    }
    return false;
  }
  
  public final boolean cHM()
  {
    return true;
  }
  
  protected final void initView()
  {
    super.initView();
    a locala = this.wgc;
    Iterator localIterator = locala.wfS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      i locali = new i();
      locali.handler = locala.handler;
      locali.kxf = locala.mVF;
      locali.bVk = ((String)localObject);
      locali.kxe = com.tencent.mm.plugin.fts.a.c.b.kxE;
      locali.kxa = new int[] { 131072 };
      locali.kxd.add("filehelper");
      locali.kxd.add(q.Gj());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.t(com.tencent.mm.plugin.fts.a.n.class)).search(2, locali);
      locala.wfT = new ArrayList();
      locala.wfT.add(localObject);
    }
    a(1, getString(R.l.app_ok), new MMCreateChatroomUI.1(this), s.b.uNx);
    xU();
  }
  
  public final void jP(int paramInt)
  {
    a locala = this.wgc;
    j localj = this.wgd.kwU;
    Object localObject = this.wgd.bVk;
    if ((localj.kxh.size() != 1) || (!((com.tencent.mm.plugin.fts.a.a.l)localj.kxh.get(0)).kwg.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.kxh = localj.kxh;
      locala1.kwi = localj.kwi;
      locala1.bVk = ((String)localObject);
      locala.wfU.add(locala1);
      int i = paramInt - locala.vLI.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.l)localj.kxh.remove(i);
        localj.kxh.add(0, localObject);
        paramInt = locala.vLI.getContentLV().getHeaderViewsCount();
      }
      locala.cJq();
      i = locala1.kxK;
      locala.vLI.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    cHK();
    cHL();
    XM();
  }
  
  protected void onDestroy()
  {
    this.wgc.finish();
    if ((!this.wge) && (this.scene == 3)) {
      k.go(false);
    }
    super.onDestroy();
  }
  
  public final void pw(String paramString)
  {
    a locala = this.wgc;
    locala.eXT.remove(paramString);
    Iterator localIterator = locala.wfU.iterator();
    while (localIterator.hasNext())
    {
      a.a locala1 = (a.a)localIterator.next();
      if (paramString.equals(locala1.wfX)) {
        locala1.wfX = null;
      }
    }
    locala.notifyDataSetChanged();
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.wfS = getIntent().getStringArrayListExtra("query_phrase_list");
    this.wgb = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
  }
  
  public final void xU()
  {
    List localList = this.wgc.cJr();
    if (localList.size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + localList.size() + ")");
      if (localList.size() > 1)
      {
        enableOptionMenu(1, true);
        return;
      }
      enableOptionMenu(1, false);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */