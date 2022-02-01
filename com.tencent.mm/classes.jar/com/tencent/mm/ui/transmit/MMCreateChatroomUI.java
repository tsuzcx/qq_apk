package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.ab.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private List<String> afMm;
  private boolean afMv;
  a afMw;
  private b afMx;
  private boolean afMy;
  private boolean afhY;
  private int scene;
  
  private void a(final com.tencent.mm.roomsdk.model.factory.a parama)
  {
    AppMethodBeat.i(39250);
    parama.d(new com.tencent.mm.roomsdk.model.b.c() {});
    parama.a(this, getString(R.l.app_tip), getString(R.l.gME), true, true, new DialogInterface.OnCancelListener()
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
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!bh.baz())
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
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(str);
      paramList = str;
      if (localau != null)
      {
        paramList = str;
        if ((int)localau.maN != 0) {
          paramList = localau.aSV();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(39251);
    return localLinkedList;
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250953);
    paramAdapterView = this.afMw;
    paramView = this.afMx.Hts;
    Object localObject = this.afMx.query;
    if ((paramView.HtF.size() != 1) || (!((com.tencent.mm.plugin.fts.a.a.o)paramView.HtF.get(0)).Hsz.equals("no_result​")))
    {
      a.a locala = new a.a(paramAdapterView, (byte)0);
      locala.HtF = paramView.HtF;
      locala.FWt = paramView.FWt;
      locala.query = ((String)localObject);
      paramAdapterView.afMo.add(locala);
      int i = paramInt - paramAdapterView.afex.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (com.tencent.mm.plugin.fts.a.a.o)paramView.HtF.remove(i);
        paramView.HtF.add(0, localObject);
        paramInt = paramAdapterView.afex.getContentLV().getHeaderViewsCount();
      }
      paramAdapterView.jDx();
      i = locala.Huj;
      paramAdapterView.afex.getContentLV().post(new a.2(paramAdapterView, i + paramInt + 1));
    }
    iKA();
    jyN();
    hideVKB();
    AppMethodBeat.o(250953);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39249);
    if ((parama instanceof f))
    {
      Object localObject = (f)parama;
      parama = this.afMw;
      localObject = ((f)localObject).rpp.Hsz;
      if (parama.pJQ.contains(localObject))
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
  
  public final void aNi()
  {
    AppMethodBeat.i(39241);
    super.aNi();
    this.afMm = getIntent().getStringArrayListExtra("query_phrase_list");
    this.afMv = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void aNr()
  {
    AppMethodBeat.i(39243);
    List localList = this.afMw.jDy();
    if (localList.size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + localList.size() + ")");
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
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
    AppMethodBeat.o(39243);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.afMw;
      locala.pJQ.remove(paramString);
      Iterator localIterator = locala.afMo.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.afMr)) {
          locala1.afMr = null;
        }
      }
      locala.notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(39253);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof f))
    {
      Object localObject = (f)parama;
      a locala = this.afMw;
      localObject = ((f)localObject).rpp.Hsz;
      int j = parama.position;
      if (locala.pJQ.contains(localObject))
      {
        int i = locala.afMo.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.afMo.get(i);
          if (j < parama.Huj) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.afMr)) {
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
  
  public final r bVA()
  {
    AppMethodBeat.i(39246);
    if (this.afMw == null) {
      this.afMw = new a(this, this.afMm, this.scene);
    }
    a locala = this.afMw;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(39247);
    if (this.afMx == null) {
      this.afMx = new b(this, this.scene);
    }
    b localb = this.afMx;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(39245);
    String str = getString(R.l.gUJ);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.afMw;
    Iterator localIterator = locala.afMm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
      locall.handler = locala.handler;
      locall.HtC = locala.MVp;
      locall.query = ((String)localObject);
      locall.HtB = com.tencent.mm.plugin.fts.a.c.b.Hue;
      locall.Htx = new int[] { 131072 };
      locall.HtA.add("filehelper");
      locall.HtA.add(z.bAM());
      localObject = ((n)h.az(n.class)).search(2, locall);
      locala.afMn = new ArrayList();
      locala.afMn.add(localObject);
    }
    addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
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
            com.tencent.mm.plugin.fts.ui.l.vP(true);
          }
        }
        Log.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, y.b.adEJ);
    aNr();
    AppMethodBeat.o(39242);
  }
  
  public final boolean jyP()
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.afMw.finish();
    if ((!this.afMy) && (this.scene == 3)) {
      com.tencent.mm.plugin.fts.ui.l.vP(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MMCreateChatroomUI
 * JD-Core Version:    0.7.0.1
 */