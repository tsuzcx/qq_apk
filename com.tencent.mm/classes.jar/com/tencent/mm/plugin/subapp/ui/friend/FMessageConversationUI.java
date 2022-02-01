package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;

public class FMessageConversationUI
  extends MMActivity
{
  private ListView BAa;
  private a BAb;
  private View BAc;
  private View BAd;
  private TextView BAe;
  private long BAf;
  private b BzL;
  private n.e oao;
  private int oef;
  private int oeg;
  private String xqt;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.oef = 0;
    this.oeg = 0;
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(186640);
        com.tencent.mm.bj.c.f(FMessageConversationUI.f(FMessageConversationUI.this), FMessageConversationUI.g(FMessageConversationUI.this));
        AppMethodBeat.o(186640);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.BzL.getCount() > 0)
    {
      this.BAc.findViewById(2131304452).setVisibility(0);
      this.BAd.findViewById(2131296459).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.BAc.findViewById(2131304452).setVisibility(8);
    this.BAd.findViewById(2131296459).setVisibility(0);
    enableOptionMenu(0, false);
    AppMethodBeat.o(29050);
  }
  
  public int getLayoutId()
  {
    return 2131494152;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29049);
    if (com.tencent.mm.model.a.g.aDh().Cg("1") != null)
    {
      localObject = com.tencent.mm.model.a.g.aDh().Cg("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.Ck("1");
    }
    this.BzL = new b(getContext());
    com.tencent.mm.bj.d.aMM().add(this.BzL);
    this.BzL.a(new r.a()
    {
      public final void aSR()
      {
        AppMethodBeat.i(29037);
        FMessageConversationUI.a(FMessageConversationUI.this);
        AppMethodBeat.o(29037);
      }
    });
    this.BAa = ((ListView)findViewById(2131300165));
    this.BAc = LayoutInflater.from(getContext()).inflate(2131494157, null);
    this.BAc.findViewById(2131304452).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29038);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
        paramAnonymousView = null;
        if (Build.VERSION.SDK_INT >= 21) {
          paramAnonymousView = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
        }
        com.tencent.mm.plugin.fts.a.d.b(FMessageConversationUI.this.getContext(), ".ui.FTSAddFriendUI", (Intent)localObject, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29038);
      }
    });
    this.BAa.addHeaderView(this.BAc);
    this.BAd = LayoutInflater.from(getContext()).inflate(2131494153, null);
    this.BAd.findViewById(2131296457).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29039);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (l.aTn() != l.a.jgH)
        {
          paramAnonymousView = new Intent(FMessageConversationUI.this.getContext(), BindMContactIntroUI.class);
          paramAnonymousView.putExtra("key_upload_scene", 5);
          MMWizardActivity.al(FMessageConversationUI.this.getContext(), paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29039);
          return;
          paramAnonymousView = FMessageConversationUI.this;
          localObject = new Intent(FMessageConversationUI.this.getContext(), MobileFriendUI.class);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    this.BAa.addHeaderView(this.BAd);
    this.BAa.setAdapter(this.BzL);
    updateStatus();
    this.BAa.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186637);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(186637);
          return false;
          FMessageConversationUI.a(FMessageConversationUI.this, (int)paramAnonymousMotionEvent.getRawX());
          FMessageConversationUI.b(FMessageConversationUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    Object localObject = new com.tencent.mm.ui.widget.b.a(this);
    this.BAa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(186638);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(186638);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.BAh.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this), FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(186638);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.BzL;
    if (this.BAa.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.BAb = new a((Context)localObject, localb, bool);
      this.BAa.setOnItemClickListener(this.BAb);
      addTextOptionMenu(0, getString(2131761217), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29042);
          Object localObject = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
          ((Intent)localObject).putExtra("invite_friend_scene", 3);
          paramAnonymousMenuItem = FMessageConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(29042);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(186639);
          FMessageConversationUI.this.finish();
          AppMethodBeat.o(186639);
          return true;
        }
      });
      AppMethodBeat.o(29049);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29045);
    super.onCreate(paramBundle);
    setMMTitle(2131759469);
    hideActionbarLine();
    try
    {
      bc.getNotification().Xo();
      if (!bc.ajM())
      {
        finish();
        AppMethodBeat.o(29045);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
      AppMethodBeat.o(29045);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29051);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bg)this.BzL.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ae.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!bu.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(k.c(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.BAf = paramContextMenuInfo.field_fmsgSysRowId;
    this.xqt = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.BzL != null) {
      com.tencent.mm.bj.d.aMM().remove(this.BzL);
    }
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ae.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.Cl("1");
    com.tencent.mm.bj.d.aMM().fvj();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!bc.ajM())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.BAe != null) && (bu.jq(this))) {
      this.BAe.setText(2131759475);
    }
    AppMethodBeat.o(29047);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI
 * JD-Core Version:    0.7.0.1
 */