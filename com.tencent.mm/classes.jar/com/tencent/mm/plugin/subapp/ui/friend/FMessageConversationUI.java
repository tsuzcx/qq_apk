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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r.a;

public class FMessageConversationUI
  extends MMActivity
{
  private n.d ntM;
  private String vTs;
  private b zQL;
  private ListView zRa;
  private a zRb;
  private View zRc;
  private View zRd;
  private TextView zRe;
  private long zRf;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.ntM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(29043);
        com.tencent.mm.bj.c.f(FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(29043);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.zQL.getCount() > 0)
    {
      this.zRc.findViewById(2131304452).setVisibility(0);
      this.zRd.findViewById(2131296459).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.zRc.findViewById(2131304452).setVisibility(8);
    this.zRd.findViewById(2131296459).setVisibility(0);
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
    if (com.tencent.mm.model.a.g.azO().yF("1") != null)
    {
      localObject = com.tencent.mm.model.a.g.azO().yF("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.yJ("1");
    }
    this.zQL = new b(getContext());
    com.tencent.mm.bj.d.aJe().add(this.zQL);
    this.zQL.a(new r.a()
    {
      public final void aPg()
      {
        AppMethodBeat.i(29037);
        FMessageConversationUI.a(FMessageConversationUI.this);
        AppMethodBeat.o(29037);
      }
    });
    this.zRa = ((ListView)findViewById(2131300165));
    this.zRc = LayoutInflater.from(getContext()).inflate(2131494157, null);
    this.zRc.findViewById(2131304452).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29038);
        Intent localIntent = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
        paramAnonymousView = null;
        if (Build.VERSION.SDK_INT >= 21) {
          paramAnonymousView = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
        }
        com.tencent.mm.plugin.fts.a.d.b(FMessageConversationUI.this.getContext(), ".ui.FTSAddFriendUI", localIntent, paramAnonymousView);
        AppMethodBeat.o(29038);
      }
    });
    this.zRa.addHeaderView(this.zRc);
    this.zRd = LayoutInflater.from(getContext()).inflate(2131494153, null);
    this.zRd.findViewById(2131296457).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29039);
        if (com.tencent.mm.plugin.account.friend.a.l.aPC() != l.a.iKF)
        {
          paramAnonymousView = new Intent(FMessageConversationUI.this.getContext(), BindMContactIntroUI.class);
          paramAnonymousView.putExtra("key_upload_scene", 5);
          MMWizardActivity.aj(FMessageConversationUI.this.getContext(), paramAnonymousView);
          AppMethodBeat.o(29039);
          return;
        }
        paramAnonymousView = FMessageConversationUI.this;
        Object localObject = new Intent(FMessageConversationUI.this.getContext(), MobileFriendUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29039);
      }
    });
    this.zRa.addHeaderView(this.zRd);
    this.zRa.setAdapter(this.zQL);
    updateStatus();
    Object localObject = new com.tencent.mm.ui.tools.l(this);
    this.zRa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29040);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(29040);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.ntP.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this));
        AppMethodBeat.o(29040);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.zQL;
    if (this.zRa.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zRb = new a((Context)localObject, localb, bool);
      this.zRa.setOnItemClickListener(this.zRb);
      addTextOptionMenu(0, getString(2131761217), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29041);
          Object localObject = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
          ((Intent)localObject).putExtra("invite_friend_scene", 3);
          paramAnonymousMenuItem = FMessageConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(29041);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(29042);
          FMessageConversationUI.this.finish();
          AppMethodBeat.o(29042);
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
      az.getNotification().UP();
      if (!az.agM())
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
        ac.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
      AppMethodBeat.o(29045);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29051);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bb)this.zQL.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ac.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!bs.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(k.c(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.zRf = paramContextMenuInfo.field_fmsgSysRowId;
    this.vTs = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.zQL != null) {
      com.tencent.mm.bj.d.aJe().remove(this.zQL);
    }
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      ac.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.yK("1");
    com.tencent.mm.bj.d.aJe().fbg();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    az.ayM();
    com.tencent.mm.model.c.agA().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!az.agM())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.zRe != null) && (bs.ja(this))) {
      this.zRe.setText(2131759475);
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