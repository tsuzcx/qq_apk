package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.pluginsdk.ui.applet.aa.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMCreateChatroomUI
  extends MMBaseSelectContactUI
{
  private List<String> XVV;
  private boolean XWe;
  a XWf;
  private b XWg;
  private boolean XWh;
  private boolean Xwb;
  private int scene;
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(39251);
    LinkedList localLinkedList = new LinkedList();
    if (!bh.aHB())
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
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.jxt != 0) {
          paramList = localas.ays();
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
    parama.a(this, getString(R.l.app_tip), getString(R.l.eKL), true, true, new DialogInterface.OnCancelListener()
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
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(291965);
    paramView = this.XWf;
    k localk = this.XWg.BIK;
    Object localObject = this.XWg.query;
    if ((localk.BIW.size() != 1) || (!((m)localk.BIW.get(0)).BHS.equals("no_result​")))
    {
      a.a locala = new a.a(paramView, (byte)0);
      locala.BIW = localk.BIW;
      locala.BHY = localk.BHY;
      locala.query = ((String)localObject);
      paramView.XVX.add(locala);
      int i = paramInt - paramView.XsW.getContentLV().getHeaderViewsCount();
      if (i >= 3)
      {
        localObject = (m)localk.BIW.remove(i);
        localk.BIW.add(0, localObject);
        paramInt = paramView.XsW.getContentLV().getHeaderViewsCount();
      }
      paramView.hYN();
      i = locala.BJz;
      paramView.XsW.getContentLV().post(new a.2(paramView, i + paramInt + 1));
    }
    hUZ();
    hVa();
    hideVKB();
    AppMethodBeat.o(291965);
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(39253);
    if (paramInt == 1)
    {
      a locala = this.XWf;
      locala.mNi.remove(paramString);
      Iterator localIterator = locala.XVX.iterator();
      while (localIterator.hasNext())
      {
        a.a locala1 = (a.a)localIterator.next();
        if (paramString.equals(locala1.XWa)) {
          locala1.XWa = null;
        }
      }
      locala.notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(39253);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39249);
    if ((parama instanceof f))
    {
      Object localObject = (f)parama;
      parama = this.XWf;
      localObject = ((f)localObject).olG.BHS;
      if (parama.mNi.contains(localObject))
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
  
  public final void ata()
  {
    AppMethodBeat.i(39241);
    super.ata();
    this.XVV = getIntent().getStringArrayListExtra("query_phrase_list");
    this.XWe = getIntent().getBooleanExtra("go_to_chatroom_direct", false);
    this.scene = getIntent().getIntExtra("scene_from", 0);
    AppMethodBeat.o(39241);
  }
  
  public final void atk()
  {
    AppMethodBeat.i(39243);
    List localList = this.XWf.hYO();
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
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39248);
    if ((parama instanceof f))
    {
      Object localObject = (f)parama;
      a locala = this.XWf;
      localObject = ((f)localObject).olG.BHS;
      int j = parama.position;
      if (locala.mNi.contains(localObject))
      {
        int i = locala.XVX.size() - 1;
        if (i >= 0)
        {
          parama = (a.a)locala.XVX.get(i);
          if (j < parama.BJz) {}
        }
        for (;;)
        {
          if (parama == null) {
            break label129;
          }
          if (((String)localObject).equals(parama.XWa)) {
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
  
  public final boolean bwH()
  {
    return false;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(39245);
    String str = getString(R.l.eRZ);
    AppMethodBeat.o(39245);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(39246);
    if (this.XWf == null) {
      this.XWf = new a(this, this.XVV, this.scene);
    }
    a locala = this.XWf;
    AppMethodBeat.o(39246);
    return locala;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(39247);
    if (this.XWg == null) {
      this.XWg = new b(this, this.scene);
    }
    b localb = this.XWg;
    AppMethodBeat.o(39247);
    return localb;
  }
  
  public final boolean hVc()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39242);
    super.initView();
    a locala = this.XWf;
    Iterator localIterator = locala.XVV.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      j localj = new j();
      localj.handler = locala.handler;
      localj.BIU = locala.GXs;
      localj.query = ((String)localObject);
      localj.BIT = com.tencent.mm.plugin.fts.a.c.b.BJu;
      localj.BIP = new int[] { 131072 };
      localj.BIS.add("filehelper");
      localj.BIS.add(z.bcZ());
      localObject = ((n)h.ag(n.class)).search(2, localj);
      locala.XVW = new ArrayList();
      locala.XVW.add(localObject);
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
            l.rQ(true);
          }
        }
        Log.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        AppMethodBeat.o(39237);
        return true;
      }
    }, null, w.b.Wao);
    atk();
    AppMethodBeat.o(39242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39244);
    this.XWf.finish();
    if ((!this.XWh) && (this.scene == 3)) {
      l.rQ(false);
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