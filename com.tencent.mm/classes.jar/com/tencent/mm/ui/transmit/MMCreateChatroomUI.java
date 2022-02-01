package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private boolean PZd;
  private List<String> QxQ;
  private boolean QxZ;
  a Qya;
  private b Qyb;
  private boolean Qyc;
  private int scene;
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!bg.aAc())
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
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.gMZ != 0) {
          paramList = localas.arJ();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(39251);
    return localLinkedList;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(39250);
    parama.d(new MMCreateChatroomUI.2(this, parama));
    parama.a(this, getString(2131755998), getString(2131762206), true, true, new MMCreateChatroomUI.3(this, parama));
    AppMethodBeat.o(39250);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234470);
    paramView = this.Qya;
    k localk = this.Qyb.wWP;
    Object localObject = this.Qyb.query;
    if ((localk.wXb.size() != 1) || (!((m)localk.wXb.get(0)).wVX.equals("no_result​")))
    {
      a.a locala = new a.a(paramView, (byte)0);
      locala.wXb = localk.wXb;
      locala.wWd = localk.wWd;
      locala.query = ((String)localObject);
      paramView.QxS.add(locala);
      int i = paramInt - paramView.PWg.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.wXb.remove(i);
        localk.wXb.add(0, localObject);
        paramInt = paramView.PWg.getContentLV().getHeaderViewsCount();
      }
      paramView.gYc();
      i = locala.wXD;
      paramView.PWg.getContentLV().post(new a.2(paramView, i + paramInt + 1));
    }
    gUW();
    gUX();
    hideVKB();
    AppMethodBeat.o(234470);
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.Qya;
      locala.jVV.remove(paramString);
      Iterator localIterator = locala.QxS.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.QxV)) {
          locala1.QxV = null;
        }
      }
      locala.notifyDataSetChanged();
      ani();
    }
    AppMethodBeat.o(39253);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39249);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      parama = this.Qya;
      localObject = ((e)localObject).lqW.wVX;
      if (parama.jVV.contains(localObject))
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
  
  public final void amZ()
  {
    AppMethodBeat.i(39241);
    super.amZ();
    this.QxQ = getIntent().getStringArrayListExtra("query_phrase_list");
    this.QxZ = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void ani()
  {
    AppMethodBeat.i(39243);
    List localList = this.Qya.gYd();
    if (localList.size() > 0)
    {
      updateOptionMenuText(1, getString(2131755921) + "(" + localList.size() + ")");
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
    updateOptionMenuText(1, getString(2131755921));
    enableOptionMenu(1, false);
    AppMethodBeat.o(39243);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.Qya;
      localObject = ((e)localObject).lqW.wVX;
      int j = parama.position;
      if (locala.jVV.contains(localObject))
      {
        int i = locala.QxS.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.QxS.get(i);
          if (j < parama.wXD) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.QxV)) {
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
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(39245);
    String str = getString(2131765146);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(39246);
    if (this.Qya == null) {
      this.Qya = new a(this, this.QxQ, this.scene);
    }
    a locala = this.Qya;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(39247);
    if (this.Qyb == null) {
      this.Qyb = new b(this, this.scene);
    }
    b localb = this.Qyb;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public final boolean gUY()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.Qya;
    Iterator localIterator = locala.QxQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.wWZ = locala.Bdt;
      localj.query = ((String)localObject);
      localj.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
      localj.wWU = new int[] { 131072 };
      localj.wWX.add("filehelper");
      localj.wWX.add(z.aTY());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      locala.QxR = new ArrayList();
      locala.QxR.add(localObject);
    }
    addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
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
            l.pv(true);
          }
        }
        Log.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, t.b.OGU);
    ani();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.Qya.finish();
    if ((!this.Qyc) && (this.scene == 3)) {
      l.pv(false);
    }
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */