package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.l;

public class FMessageConversationUI
  extends MMActivity
{
  private ListView BiC;
  private a BiD;
  private View BiE;
  private View BiF;
  private TextView BiG;
  private long BiH;
  private b Bin;
  private n.e nUI;
  private String xaC;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.nUI = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(29043);
        com.tencent.mm.bk.c.f(FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(29043);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.Bin.getCount() > 0)
    {
      this.BiE.findViewById(2131304452).setVisibility(0);
      this.BiF.findViewById(2131296459).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.BiE.findViewById(2131304452).setVisibility(8);
    this.BiF.findViewById(2131296459).setVisibility(0);
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
    if (com.tencent.mm.model.a.g.aCR().BE("1") != null)
    {
      localObject = com.tencent.mm.model.a.g.aCR().BE("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.BI("1");
    }
    this.Bin = new b(getContext());
    d.aMo().add(this.Bin);
    this.Bin.a(new r.a()
    {
      public final void aSs()
      {
        AppMethodBeat.i(29037);
        FMessageConversationUI.a(FMessageConversationUI.this);
        AppMethodBeat.o(29037);
      }
    });
    this.BiC = ((ListView)findViewById(2131300165));
    this.BiE = LayoutInflater.from(getContext()).inflate(2131494157, null);
    this.BiE.findViewById(2131304452).setOnClickListener(new FMessageConversationUI.2(this));
    this.BiC.addHeaderView(this.BiE);
    this.BiF = LayoutInflater.from(getContext()).inflate(2131494153, null);
    this.BiF.findViewById(2131296457).setOnClickListener(new FMessageConversationUI.3(this));
    this.BiC.addHeaderView(this.BiF);
    this.BiC.setAdapter(this.Bin);
    updateStatus();
    Object localObject = new l(this);
    this.BiC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29040);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(29040);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.nUL.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this));
        AppMethodBeat.o(29040);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.Bin;
    if (this.BiC.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.BiD = new a((Context)localObject, localb, bool);
      this.BiC.setOnItemClickListener(this.BiD);
      addTextOptionMenu(0, getString(2131761217), new FMessageConversationUI.5(this));
      setBackBtn(new FMessageConversationUI.6(this));
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
      ba.getNotification().Xg();
      if (!ba.ajx())
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
        ad.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
      AppMethodBeat.o(29045);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29051);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bf)this.Bin.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ad.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!bt.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(k.c(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.BiH = paramContextMenuInfo.field_fmsgSysRowId;
    this.xaC = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.Bin != null) {
      d.aMo().remove(this.Bin);
    }
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      ad.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.BJ("1");
    d.aMo().frj();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!ba.ajx())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.BiG != null) && (bt.jk(this))) {
      this.BiG.setText(2131759475);
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