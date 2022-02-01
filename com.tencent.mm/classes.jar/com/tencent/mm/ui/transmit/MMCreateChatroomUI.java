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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private b IVA;
  private boolean IVB;
  private List<String> IVp;
  private boolean IVy;
  a IVz;
  private boolean IyI;
  private int scene;
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!az.agM())
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
      az.ayM();
      ai localai = com.tencent.mm.model.c.awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
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
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.IVz;
      locala.iCn.remove(paramString);
      Iterator localIterator = locala.IVr.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.IVu)) {
          locala1.IVu = null;
        }
      }
      locala.notifyDataSetChanged();
      WT();
    }
    AppMethodBeat.o(39253);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(39241);
    super.WJ();
    this.IVp = getIntent().getStringArrayListExtra("query_phrase_list");
    this.IVy = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void WT()
  {
    AppMethodBeat.i(39243);
    List localList = this.IVz.fue();
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
      parama = this.IVz;
      localObject = ((e)localObject).jPN.sxG;
      if (parama.iCn.contains(localObject))
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
  
  public final boolean aOi()
  {
    return false;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(39245);
    String str = getString(2131763009);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(39246);
    if (this.IVz == null) {
      this.IVz = new a(this, this.IVp, this.scene);
    }
    a locala = this.IVz;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final o aOm()
  {
    AppMethodBeat.i(39247);
    if (this.IVA == null) {
      this.IVA = new b(this, this.scene);
    }
    b localb = this.IVA;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.IVz;
      localObject = ((e)localObject).jPN.sxG;
      int j = parama.position;
      if (locala.iCn.contains(localObject))
      {
        int i = locala.IVr.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.IVr.get(i);
          if (j < parama.szm) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.IVu)) {
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
  
  public final boolean frz()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.IVz;
    Iterator localIterator = locala.IVp.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.syI = locala.vIP;
      localj.query = ((String)localObject);
      localj.syH = com.tencent.mm.plugin.fts.a.c.b.szh;
      localj.syD = new int[] { 131072 };
      localj.syG.add("filehelper");
      localj.syG.add(u.axw());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      locala.IVq = new ArrayList();
      locala.IVq.add(localObject);
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
            com.tencent.mm.plugin.fts.ui.k.mt(true);
          }
        }
        ac.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, s.b.Hom);
    WT();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.IVz.finish();
    if ((!this.IVB) && (this.scene == 3)) {
      com.tencent.mm.plugin.fts.ui.k.mt(false);
    }
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(39252);
    a locala = this.IVz;
    com.tencent.mm.plugin.fts.a.a.k localk = this.IVA.syy;
    Object localObject = this.IVA.query;
    if ((localk.syK.size() != 1) || (!((m)localk.syK.get(0)).sxG.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.syK = localk.syK;
      locala1.sxM = localk.sxM;
      locala1.query = ((String)localObject);
      locala.IVr.add(locala1);
      int i = paramInt - locala.Iwg.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.syK.remove(i);
        localk.syK.add(0, localObject);
        paramInt = locala.Iwg.getContentLV().getHeaderViewsCount();
      }
      locala.fud();
      i = locala1.szm;
      locala.Iwg.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    frx();
    fry();
    hideVKB();
    AppMethodBeat.o(39252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */