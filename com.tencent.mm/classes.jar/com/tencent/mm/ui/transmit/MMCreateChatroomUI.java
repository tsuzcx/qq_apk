package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private boolean KMC;
  a KMD;
  private b KME;
  private boolean KMF;
  private List<String> KMt;
  private boolean KpI;
  private int scene;
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!ba.ajx())
    {
      AppMethodBeat.o(39251);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(39251);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(str);
      paramList = str;
      if (localam != null)
      {
        paramList = str;
        if ((int)localam.gfj != 0) {
          paramList = localam.adv();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(39251);
    return localLinkedList;
  }
  
  private void a(final com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(39250);
    parama.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    parama.a(this, getString(2131760674), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39239);
        MMCreateChatroomUI.a(MMCreateChatroomUI.this, false);
        parama.cancel();
        AppMethodBeat.o(39239);
      }
    });
    AppMethodBeat.o(39250);
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.KMD;
      locala.iVx.remove(paramString);
      Iterator localIterator = locala.KMv.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.KMy)) {
          locala1.KMy = null;
        }
      }
      locala.notifyDataSetChanged();
      Zm();
    }
    AppMethodBeat.o(39253);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(39241);
    super.Zd();
    this.KMt = getIntent().getStringArrayListExtra("query_phrase_list");
    this.KMC = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(39243);
    List localList = this.KMD.fKR();
    if (localList.size() > 0)
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + localList.size() + ")");
      if (localList.size() > 1)
      {
        enableOptionMenu(1, true);
        AppMethodBeat.o(39243);
        return;
      }
      enableOptionMenu(1, false);
      AppMethodBeat.o(39243);
      return;
    }
    updateOptionMenuText(1, getString(2131755835));
    enableOptionMenu(1, false);
    AppMethodBeat.o(39243);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39249);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      parama = this.KMD;
      localObject = ((e)localObject).kjY.tuh;
      if (parama.iVx.contains(localObject))
      {
        AppMethodBeat.o(39249);
        return true;
      }
      AppMethodBeat.o(39249);
      return false;
    }
    AppMethodBeat.o(39249);
    return false;
  }
  
  public final boolean aRu()
  {
    return false;
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(39245);
    String str = getString(2131763009);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final q aRx()
  {
    AppMethodBeat.i(39246);
    if (this.KMD == null) {
      this.KMD = new a(this, this.KMt, this.scene);
    }
    a locala = this.KMD;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final o aRy()
  {
    AppMethodBeat.i(39247);
    if (this.KME == null) {
      this.KME = new b(this, this.scene);
    }
    b localb = this.KME;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.KMD;
      localObject = ((e)localObject).kjY.tuh;
      int j = parama.position;
      if (locala.iVx.contains(localObject))
      {
        int i = locala.KMv.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.KMv.get(i);
          if (j < parama.tvN) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.KMy)) {
            break label137;
          }
          AppMethodBeat.o(39248);
          return true;
          i -= 1;
          break;
          parama = null;
        }
        label129:
        AppMethodBeat.o(39248);
        return false;
      }
      label137:
      AppMethodBeat.o(39248);
      return false;
    }
    AppMethodBeat.o(39248);
    return false;
  }
  
  public final boolean fIm()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.KMD;
    Iterator localIterator = locala.KMt.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.tvj = locala.wPW;
      localj.query = ((String)localObject);
      localj.tvi = com.tencent.mm.plugin.fts.a.c.b.tvI;
      localj.tve = new int[] { 131072 };
      localj.tvh.add("filehelper");
      localj.tvh.add(u.aAm());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      locala.KMu = new ArrayList();
      locala.KMu.add(localObject);
    }
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39237);
        if (!MMCreateChatroomUI.a(MMCreateChatroomUI.this))
        {
          MMCreateChatroomUI.a(MMCreateChatroomUI.this, true);
          MMCreateChatroomUI.b(MMCreateChatroomUI.this);
          if (MMCreateChatroomUI.c(MMCreateChatroomUI.this) == 3)
          {
            MMCreateChatroomUI.d(MMCreateChatroomUI.this);
            l.mK(true);
          }
        }
        ad.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, s.b.JbS);
    Zm();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.KMD.finish();
    if ((!this.KMF) && (this.scene == 3)) {
      l.mK(false);
    }
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(39252);
    a locala = this.KMD;
    k localk = this.KME.tuZ;
    Object localObject = this.KME.query;
    if ((localk.tvl.size() != 1) || (!((m)localk.tvl.get(0)).tuh.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.tvl = localk.tvl;
      locala1.tun = localk.tun;
      locala1.query = ((String)localObject);
      locala.KMv.add(locala1);
      int i = paramInt - locala.KmO.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.tvl.remove(i);
        localk.tvl.add(0, localObject);
        paramInt = locala.KmO.getContentLV().getHeaderViewsCount();
      }
      locala.fKQ();
      i = locala1.tvN;
      locala.KmO.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    fIk();
    fIl();
    hideVKB();
    AppMethodBeat.o(39252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */