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
import com.tencent.mm.bj.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s.a;

public class FMessageConversationUI
  extends MMActivity
{
  private String BqF;
  private ListView FKL;
  private a FKM;
  private View FKN;
  private View FKO;
  private TextView FKP;
  private long FKQ;
  private b FKw;
  private o.g plk;
  private int ppd;
  private int ppe;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.ppd = 0;
    this.ppe = 0;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(232075);
        com.tencent.mm.bj.c.f(FMessageConversationUI.f(FMessageConversationUI.this), FMessageConversationUI.g(FMessageConversationUI.this));
        AppMethodBeat.o(232075);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.FKw.getCount() > 0)
    {
      this.FKN.findViewById(2131307428).setVisibility(0);
      this.FKO.findViewById(2131296532).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.FKN.findViewById(2131307428).setVisibility(8);
    this.FKO.findViewById(2131296532).setVisibility(0);
    enableOptionMenu(0, false);
    AppMethodBeat.o(29050);
  }
  
  public int getLayoutId()
  {
    return 2131494707;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29049);
    if (com.tencent.mm.model.a.g.aWT().KR("1") != null)
    {
      localObject = com.tencent.mm.model.a.g.aWT().KR("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.KV("1");
    }
    this.FKw = new b(getContext());
    d.bgN().add(this.FKw);
    this.FKw.a(new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(29037);
        FMessageConversationUI.a(FMessageConversationUI.this);
        AppMethodBeat.o(29037);
      }
    });
    this.FKL = ((ListView)findViewById(2131301616));
    this.FKN = LayoutInflater.from(getContext()).inflate(2131494712, null);
    this.FKN.findViewById(2131307428).setOnClickListener(new FMessageConversationUI.2(this));
    this.FKL.addHeaderView(this.FKN);
    this.FKO = LayoutInflater.from(getContext()).inflate(2131494708, null);
    this.FKO.findViewById(2131296530).setOnClickListener(new FMessageConversationUI.3(this));
    this.FKL.addHeaderView(this.FKO);
    this.FKL.setAdapter(this.FKw);
    updateStatus();
    this.FKL.setOnTouchListener(new FMessageConversationUI.4(this));
    Object localObject = new com.tencent.mm.ui.widget.b.a(this);
    this.FKL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(232073);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(232073);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.FKS.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this), FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(232073);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.FKw;
    if (this.FKL.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.FKM = new a((Context)localObject, localb, bool);
      this.FKL.setOnItemClickListener(this.FKM);
      addTextOptionMenu(0, getString(2131763026), new FMessageConversationUI.6(this));
      setBackBtn(new FMessageConversationUI.7(this));
      AppMethodBeat.o(29049);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29045);
    super.onCreate(paramBundle);
    setMMTitle(2131760784);
    hideActionbarLine();
    try
    {
      bg.getNotification().alb();
      if (!bg.aAc())
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
      AppMethodBeat.o(29045);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(29051);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bl)this.FKw.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!Util.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(l.c(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, 2131755778);
    this.FKQ = paramContextMenuInfo.field_fmsgSysRowId;
    this.BqF = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.FKw != null) {
      d.bgN().remove(this.FKw);
    }
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      Log.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.KW("1");
    d.bgN().gCQ();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!bg.aAc())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.FKP != null) && (Util.isOverseasUser(this))) {
      this.FKP.setText(2131760790);
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