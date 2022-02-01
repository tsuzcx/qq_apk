package com.tencent.mm.plugin.subapp.ui.friend;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;

public class FMessageConversationUI
  extends MMActivity
{
  private String NiL;
  private b SFJ;
  private ListView SGb;
  private a SGc;
  private View SGd;
  private View SGe;
  private TextView SGf;
  private long SGg;
  private u.i vzr;
  private int x_down;
  private int y_down;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.x_down = 0;
    this.y_down = 0;
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(292039);
        com.tencent.mm.modelverify.c.h(FMessageConversationUI.f(FMessageConversationUI.this), FMessageConversationUI.g(FMessageConversationUI.this));
        AppMethodBeat.o(292039);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.SFJ.getCount() > 0)
    {
      this.SGd.findViewById(R.h.search_view).setVisibility(0);
      this.SGe.findViewById(R.h.fqu).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.SGd.findViewById(R.h.search_view).setVisibility(8);
    this.SGe.findViewById(R.h.fqu).setVisibility(0);
    enableOptionMenu(0, false);
    AppMethodBeat.o(29050);
  }
  
  public int getLayoutId()
  {
    return R.i.gki;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29049);
    if (g.bDR().Km("1") != null)
    {
      localObject = g.bDR().Km("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.Kq("1");
    }
    this.SFJ = new b(getContext());
    d.bNI().add(this.SFJ);
    this.SFJ.a(new FMessageConversationUI.1(this));
    this.SGb = ((ListView)findViewById(R.h.fIG));
    this.SGd = LayoutInflater.from(getContext()).inflate(R.i.gkk, null);
    this.SGd.findViewById(R.h.search_view).setOnClickListener(new FMessageConversationUI.2(this));
    this.SGb.addHeaderView(this.SGd);
    this.SGe = LayoutInflater.from(getContext()).inflate(R.i.gkj, null);
    this.SGe.findViewById(R.h.fqs).setOnClickListener(new FMessageConversationUI.3(this));
    this.SGb.addHeaderView(this.SGe);
    this.SGb.setAdapter(this.SFJ);
    updateStatus();
    this.SGb.setOnTouchListener(new FMessageConversationUI.4(this));
    Object localObject = new com.tencent.mm.ui.widget.b.a(this);
    this.SGb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(292038);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(292038);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.SGi.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this), FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(292038);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.SFJ;
    if (this.SGb.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.SGc = new a((Context)localObject, localb, bool);
      this.SGb.setOnItemClickListener(this.SGc);
      addTextOptionMenu(0, getString(R.l.gNN), new FMessageConversationUI.6(this));
      setBackBtn(new FMessageConversationUI.7(this));
      AppMethodBeat.o(29049);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29045);
    super.onCreate(paramBundle);
    setMMTitle(R.l.gIe);
    hideActionbarLine();
    try
    {
      bh.getNotification().aKV();
      if (!bh.baz())
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
        Log.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
      if (!h.baz()) {
        break label133;
      }
    }
    if ((i.bWY()) && (!i.bWV()) && (com.tencent.mm.platformtools.a.bTo())) {
      if ((z.bAQ() & 0x100) != 0) {
        break label140;
      }
    }
    label133:
    label140:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FMessageConversationUI", "mark addr book had update. %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        com.tencent.mm.platformtools.a.bTl();
      }
      AppMethodBeat.o(29045);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29051);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bn)this.SFJ.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!Util.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(p.b(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, R.l.app_delete);
    this.SGg = paramContextMenuInfo.field_fmsgSysRowId;
    this.NiL = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.SFJ != null) {
      d.bNI().remove(this.SFJ);
    }
    if (!h.baC().aZN())
    {
      Log.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.Kr("1");
    d.bNI().jbd();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    bh.bCz();
    com.tencent.mm.model.c.ban().B(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!bh.baz())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.SGf != null) && (Util.isOverseasUser(this))) {
      this.SGf.setText(R.l.gIh);
    }
    AppMethodBeat.o(29047);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI
 * JD-Core Version:    0.7.0.1
 */