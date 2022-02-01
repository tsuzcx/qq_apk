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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private boolean KMc;
  private List<String> LiR;
  private boolean Lja;
  a Ljb;
  private b Ljc;
  private boolean Ljd;
  private int scene;
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!bc.ajM())
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
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(str);
      paramList = str;
      if (localan != null)
      {
        paramList = str;
        if ((int)localan.ght != 0) {
          paramList = localan.adG();
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
      a locala = this.Ljb;
      locala.iYq.remove(paramString);
      Iterator localIterator = locala.LiT.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.LiW)) {
          locala1.LiW = null;
        }
      }
      locala.notifyDataSetChanged();
      Zv();
    }
    AppMethodBeat.o(39253);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(39241);
    super.Zm();
    this.LiR = getIntent().getStringArrayListExtra("query_phrase_list");
    this.Lja = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(39243);
    List localList = this.Ljb.fPk();
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
      parama = this.Ljb;
      localObject = ((e)localObject).kno.tEY;
      if (parama.iYq.contains(localObject))
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
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(39245);
    String str = getString(2131763009);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final q aRW()
  {
    AppMethodBeat.i(39246);
    if (this.Ljb == null) {
      this.Ljb = new a(this, this.LiR, this.scene);
    }
    a locala = this.Ljb;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final o aRX()
  {
    AppMethodBeat.i(39247);
    if (this.Ljc == null) {
      this.Ljc = new b(this, this.scene);
    }
    b localb = this.Ljc;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof e))
    {
      Object localObject = (e)parama;
      a locala = this.Ljb;
      localObject = ((e)localObject).kno.tEY;
      int j = parama.position;
      if (locala.iYq.contains(localObject))
      {
        int i = locala.LiT.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.LiT.get(i);
          if (j < parama.tGE) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.LiW)) {
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
  
  public final boolean fME()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.Ljb;
    Iterator localIterator = locala.LiR.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.tGa = locala.xfN;
      localj.query = ((String)localObject);
      localj.tFZ = com.tencent.mm.plugin.fts.a.c.b.tGz;
      localj.tFV = new int[] { 131072 };
      localj.tFY.add("filehelper");
      localj.tFY.add(v.aAC());
      localObject = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      locala.LiS = new ArrayList();
      locala.LiS.add(localObject);
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
            l.mO(true);
          }
        }
        ae.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, s.b.JwA);
    Zv();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.Ljb.finish();
    if ((!this.Ljd) && (this.scene == 3)) {
      l.mO(false);
    }
    super.onDestroy();
    AppMethodBeat.o(39244);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(39252);
    a locala = this.Ljb;
    k localk = this.Ljc.tFQ;
    Object localObject = this.Ljc.query;
    if ((localk.tGc.size() != 1) || (!((m)localk.tGc.get(0)).tEY.equals("no_result​")))
    {
      a.a locala1 = new a.a(locala, (byte)0);
      locala1.tGc = localk.tGc;
      locala1.tFe = localk.tFe;
      locala1.query = ((String)localObject);
      locala.LiT.add(locala1);
      int i = paramInt - locala.KJi.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.tGc.remove(i);
        localk.tGc.add(0, localObject);
        paramInt = locala.KJi.getContentLV().getHeaderViewsCount();
      }
      locala.fPj();
      i = locala1.tGE;
      locala.KJi.getContentLV().post(new a.2(locala, i + paramInt + 1));
    }
    fMC();
    fMD();
    hideVKB();
    AppMethodBeat.o(39252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */