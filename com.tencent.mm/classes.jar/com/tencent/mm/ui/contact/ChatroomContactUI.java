package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.widget.c.a;

public class ChatroomContactUI
  extends MMActivity
  implements f, k.a
{
  private ContactCountView AaE;
  private com.tencent.mm.ui.voicesearch.b Aar;
  private String Aat;
  private VoiceSearchLayout AbE;
  private com.tencent.mm.modelvoiceaddr.ui.b AbF;
  private d AbG;
  private com.tencent.mm.pluginsdk.ui.d efo;
  private int jUm;
  private int jUn;
  private a jVd;
  private n.d lNZ;
  private TextView mvx;
  private ListView nYW;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(33586);
    this.jUm = 0;
    this.jUn = 0;
    this.lNZ = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(33571);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(33571);
          return;
        }
        ChatroomContactUI.auy(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(33571);
      }
    };
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new ChatroomContactUI.6(this));
    AppMethodBeat.o(33586);
  }
  
  private void bLd()
  {
    AppMethodBeat.i(33594);
    if (this.AbG != null) {
      this.AbG.a(null, null);
    }
    if (this.Aar != null) {
      this.Aar.a(null, null);
    }
    AppMethodBeat.o(33594);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(33596);
    if (this.AaE != null)
    {
      this.AaE.setContactType(2);
      this.AaE.dLJ();
    }
    AppMethodBeat.o(33596);
  }
  
  public int getLayoutId()
  {
    return 2130969020;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33590);
    ((TextView)findViewById(2131821075)).setVisibility(8);
    this.nYW = ((ListView)findViewById(2131821074));
    this.nYW.setAdapter(null);
    this.mvx = ((TextView)findViewById(2131821075));
    this.mvx.setText(2131296462);
    this.AbG = new d(this, "@all.chatroom.contact");
    this.AbG.qp(true);
    this.Aar = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Aar.zZK = "@all.chatroom.contact";
    this.AbF = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.AbF.a(new b.a()
    {
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(33579);
        ab.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
          localIntent.putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          localIntent.putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          localIntent.putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          ChatroomContactUI.this.getContext().startActivity(localIntent);
          AppMethodBeat.o(33579);
          return;
        }
        paramAnonymousArrayOfString = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.getContext().getString(2131300044));
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
        ChatroomContactUI.this.getContext().startActivity(paramAnonymousArrayOfString);
        AppMethodBeat.o(33579);
      }
      
      public final void anc()
      {
        AppMethodBeat.i(33578);
        ab.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(33578);
      }
      
      public final void apN() {}
      
      public final void apO() {}
      
      public final void apP() {}
      
      public final void apQ() {}
      
      public final boolean wR(String paramAnonymousString)
      {
        return false;
      }
      
      public final void wS(String paramAnonymousString)
      {
        AppMethodBeat.i(33577);
        ab.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = ah.wC(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(33577);
      }
    });
    addSearchMenu(true, this.AbF);
    this.AbG.setGetViewPositionCallback(new ChatroomContactUI.8(this));
    this.AbG.setPerformItemClickListener(new ChatroomContactUI.9(this));
    this.AbG.a(new ChatroomContactUI.10(this));
    this.nYW.setOnScrollListener(this.efo);
    this.AbG.vTR = this.efo;
    this.jVd = new a(getContext());
    this.nYW.setOnItemClickListener(new ChatroomContactUI.11(this));
    this.nYW.setOnItemLongClickListener(new ChatroomContactUI.12(this));
    this.nYW.setOnTouchListener(new ChatroomContactUI.13(this));
    Object localObject = this.nYW;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.AaE = localContactCountView;
    ((ListView)localObject).addFooterView(localContactCountView, null, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33572);
        ChatroomContactUI.this.finish();
        AppMethodBeat.o(33572);
        return false;
      }
    });
    addIconOptionMenu(0, 2131296407, 2131230736, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(33573);
        paramAnonymousMenuItem = new Intent(ChatroomContactUI.this, SelectContactUI.class);
        paramAnonymousMenuItem.putExtra("titile", ChatroomContactUI.this.getString(2131296500));
        paramAnonymousMenuItem.putExtra("list_type", 0);
        paramAnonymousMenuItem.putExtra("list_attr", t.F(new int[] { t.AdV, 256, 512 }));
        ChatroomContactUI.this.getContext().startActivity(paramAnonymousMenuItem);
        AppMethodBeat.o(33573);
        return false;
      }
    });
    setToTop(new ChatroomContactUI.4(this));
    this.nYW.setAdapter(this.AbG);
    this.Aar.ry(false);
    this.nYW.setVisibility(0);
    this.AbE = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.AbE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.AbE.setTopMargin(BackwardSupportUtil.b.b(this, 100.0F));
    this.AbE.setVisibility(8);
    ((ViewGroup)findViewById(2131822421)).addView(this.AbE);
    if (this.AbE != null) {
      this.AbE.setOnVisibleChangeListener(new ChatroomContactUI.5(this));
    }
    if (this.AbG.getCount() == 0)
    {
      this.mvx.setSingleLine(false);
      this.mvx.setPadding(40, 0, 40, 0);
      this.mvx.setVisibility(0);
    }
    AppMethodBeat.o(33590);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33587);
    super.onCreate(paramBundle);
    setMMTitle(2131296450);
    initView();
    aw.Rc().a(138, this);
    aw.aaz();
    c.YA().a(this.AbG);
    AppMethodBeat.o(33587);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33589);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    aw.aaz();
    if (c.YA().arw(this.Aat) == null)
    {
      ab.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.Aat);
      AppMethodBeat.o(33589);
      return;
    }
    if (com.tencent.mm.model.t.nR(this.Aat))
    {
      paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), s.nE(this.Aat)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131296458);
      AppMethodBeat.o(33589);
      return;
    }
    AppMethodBeat.o(33589);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33593);
    super.onDestroy();
    aw.Rc().b(138, this);
    aw.aaz();
    c.YA().b(this.AbG);
    d locald = this.AbG;
    if (locald.gxo != null)
    {
      locald.gxo.detach();
      locald.gxo = null;
    }
    this.AbG.bKb();
    this.AbG.dAW();
    this.Aar.detach();
    this.Aar.bKb();
    AppMethodBeat.o(33593);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33592);
    super.onPause();
    aw.aaz();
    c.YJ().remove(this);
    if (this.AbF != null)
    {
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.AbF;
      localb.dNV();
      localb.cancel();
    }
    if (this.Aar != null) {
      this.Aar.onPause();
    }
    AppMethodBeat.o(33592);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33591);
    super.onResume();
    if (this.AaE != null)
    {
      this.AaE.setContactType(2);
      this.AaE.dLJ();
    }
    aw.aaz();
    c.YJ().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.AbF != null) && (this.AbE != null))
    {
      com.tencent.mm.bq.d.dpU();
      if ((com.tencent.mm.au.b.aih()) || (!aa.dsG().equals("zh_CN"))) {
        break label149;
      }
      this.AbF.gcJ = true;
      localb = this.AbF;
      localb.gcN = this.AbE;
      localb.gcL = 1;
      if (1 != localb.gcL) {
        break label141;
      }
      localb.gcK = 2;
    }
    for (;;)
    {
      if (this.Aar != null) {
        this.Aar.onResume();
      }
      AppMethodBeat.o(33591);
      return;
      label141:
      localb.gcK = 1;
      continue;
      label149:
      this.AbF.gcJ = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(33595);
    if (!ah.cB(this))
    {
      AppMethodBeat.o(33595);
      return;
    }
    if (v.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(33595);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(33595);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33595);
      return;
      bLd();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */