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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.g;

public class FMessageConversationUI
  extends MMActivity
{
  private String HkY;
  private ListView MeI;
  private a MeJ;
  private View MeK;
  private View MeL;
  private TextView MeM;
  private long MeN;
  private b Met;
  private q.g snt;
  private int syc;
  private int syd;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(29044);
    this.syc = 0;
    this.syd = 0;
    this.snt = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(282001);
        com.tencent.mm.bl.c.g(FMessageConversationUI.f(FMessageConversationUI.this), FMessageConversationUI.g(FMessageConversationUI.this));
        AppMethodBeat.o(282001);
      }
    };
    AppMethodBeat.o(29044);
  }
  
  private void updateStatus()
  {
    AppMethodBeat.i(29050);
    if (this.Met.getCount() > 0)
    {
      this.MeK.findViewById(R.h.dTs).setVisibility(0);
      this.MeL.findViewById(R.h.dqg).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(29050);
      return;
    }
    this.MeK.findViewById(R.h.dTs).setVisibility(8);
    this.MeL.findViewById(R.h.dqg).setVisibility(0);
    enableOptionMenu(0, false);
    AppMethodBeat.o(29050);
  }
  
  public int getLayoutId()
  {
    return R.i.ehn;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29049);
    if (g.bga().Sk("1") != null)
    {
      localObject = g.bga().Sk("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.So("1");
    }
    this.Met = new b(getContext());
    d.bqc().add(this.Met);
    this.Met.a(new FMessageConversationUI.1(this));
    this.MeI = ((ListView)findViewById(R.h.dHx));
    this.MeK = LayoutInflater.from(getContext()).inflate(R.i.ehp, null);
    this.MeK.findViewById(R.h.dTs).setOnClickListener(new FMessageConversationUI.2(this));
    this.MeI.addHeaderView(this.MeK);
    this.MeL = LayoutInflater.from(getContext()).inflate(R.i.eho, null);
    this.MeL.findViewById(R.h.dqe).setOnClickListener(new FMessageConversationUI.3(this));
    this.MeI.addHeaderView(this.MeL);
    this.MeI.setAdapter(this.Met);
    updateStatus();
    this.MeI.setOnTouchListener(new FMessageConversationUI.4(this));
    Object localObject = new com.tencent.mm.ui.widget.b.a(this);
    this.MeI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(229317);
        if (paramAnonymousInt < FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
          AppMethodBeat.o(229317);
          return true;
        }
        int i = FMessageConversationUI.b(FMessageConversationUI.this).getHeaderViewsCount();
        this.MeP.a(paramAnonymousView, paramAnonymousInt - i, paramAnonymousLong, FMessageConversationUI.this, FMessageConversationUI.c(FMessageConversationUI.this), FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
        AppMethodBeat.o(229317);
        return true;
      }
    });
    localObject = getContext();
    b localb = this.Met;
    if (this.MeI.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.MeJ = new a((Context)localObject, localb, bool);
      this.MeI.setOnItemClickListener(this.MeJ);
      addTextOptionMenu(0, getString(R.l.eLP), new FMessageConversationUI.6(this));
      setBackBtn(new FMessageConversationUI.7(this));
      AppMethodBeat.o(29049);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29045);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eFk);
    hideActionbarLine();
    try
    {
      bh.getNotification().aqY();
      if (!bh.aHB())
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
    paramContextMenuInfo = (bl)this.Met.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(29051);
      return;
    }
    if (!Util.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(l.c(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, R.l.app_delete);
    this.MeN = paramContextMenuInfo.field_fmsgSysRowId;
    this.HkY = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(29051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29048);
    super.onDestroy();
    if (this.Met != null) {
      d.bqc().remove(this.Met);
    }
    if (!h.aHE().aGM())
    {
      Log.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(29048);
      return;
    }
    f.Sp("1");
    d.bqc().hzd();
    AppMethodBeat.o(29048);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29046);
    super.onPause();
    bh.beI();
    com.tencent.mm.model.c.aHp().i(143618, Integer.valueOf(0));
    AppMethodBeat.o(29046);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29047);
    super.onResume();
    if (!bh.aHB())
    {
      finish();
      AppMethodBeat.o(29047);
      return;
    }
    if ((this.MeM != null) && (Util.isOverseasUser(this))) {
      this.MeM.setText(R.l.eFn);
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