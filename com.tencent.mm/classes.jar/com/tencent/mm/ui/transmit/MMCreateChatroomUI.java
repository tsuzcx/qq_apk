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
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private boolean GYs;
  private List<String> HuS;
  private boolean Hvb;
  a Hvc;
  private b Hvd;
  private boolean Hve;
  private int scene;
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!az.afw())
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
      az.arV();
      af localaf = com.tencent.mm.model.c.apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
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
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.Hvc;
      locala.icg.remove(paramString);
      Iterator localIterator = locala.HuU.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.HuX)) {
          locala1.HuX = null;
        }
      }
      locala.notifyDataSetChanged();
      VV();
    }
    AppMethodBeat.o(39253);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(39241);
    super.VL();
    this.HuS = getIntent().getStringArrayListExtra("query_phrase_list");
    this.Hvb = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void VV()
  {
    AppMethodBeat.i(39243);
    List localList = this.Hvc.fej();
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
      parama = this.Hvc;
      localObject = ((e)localObject).jpy.roN;
      if (parama.icg.contains(localObject))
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
  
  public final boolean aHt()
  {
    return false;
  }
  
  public final boolean aHu()
  {
    return false;
  }
  
  public final String aHv()
  {
    AppMethodBeat.i(39245);
    String str = getString(2131763009);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final q aHw()
  {
    AppMethodBeat.i(39246);
    if (this.Hvc == null) {
      this.Hvc = new a(this, this.HuS, this.scene);
    }
    a locala = this.Hvc;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final o aHx()
  {
    AppMethodBeat.i(39247);
    if (this.Hvd == null) {
      this.Hvd = new b(this, this.scene);
    }
    b localb = this.Hvd;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.Hvc;
      localObject = ((e)localObject).jpy.roN;
      int j = parama.position;
      if (locala.icg.contains(localObject))
      {
        int i = locala.HuU.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.HuU.get(i);
          if (j < parama.rqs) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.HuX)) {
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
  
  public final boolean fbI()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.Hvc;
    Iterator localIterator = locala.HuS.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.rpO = locala.uzW;
      localj.query = ((String)localObject);
      localj.rpN = com.tencent.mm.plugin.fts.a.c.b.rqn;
      localj.rpJ = new int[] { 131072 };
      localj.rpM.add("filehelper");
      localj.rpM.add(u.aqG());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      locala.HuT = new ArrayList();
      locala.HuT.add(localObject);
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
            com.tencent.mm.plugin.fts.ui.k.lB(true);
          }
        }
        ad.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, r.b.FOB);
    VV();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.Hvc.finish();
    if ((!this.Hve) && (this.scene == 3)) {
      com.tencent.mm.plugin.fts.ui.k.lB(false);
    }
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(39252);
    a locala = this.Hvc;
    com.tencent.mm.plugin.fts.a.a.k localk = this.Hvd.rpE;
    Object localObject = this.Hvd.query;
    if ((localk.rpQ.size() != 1) || (!((m)localk.rpQ.get(0)).roN.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.rpQ = localk.rpQ;
      locala1.roS = localk.roS;
      locala1.query = ((String)localObject);
      locala.HuU.add(locala1);
      int i = paramInt - locala.GVS.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.rpQ.remove(i);
        localk.rpQ.add(0, localObject);
        paramInt = locala.GVS.getContentLV().getHeaderViewsCount();
      }
      locala.fei();
      i = locala1.rqs;
      locala.GVS.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    fbG();
    fbH();
    hideVKB();
    AppMethodBeat.o(39252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */