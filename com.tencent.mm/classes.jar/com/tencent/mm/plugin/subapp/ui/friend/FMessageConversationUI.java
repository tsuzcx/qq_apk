package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.an;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class FMessageConversationUI
  extends MMActivity
{
  private n.d jSn;
  private String pIl;
  private b sXK;
  private ListView sYa;
  private a sYb;
  private View sYc;
  private View sYd;
  private TextView sYe;
  private long sYf;
  
  public FMessageConversationUI()
  {
    AppMethodBeat.i(25365);
    this.jSn = new FMessageConversationUI.7(this);
    AppMethodBeat.o(25365);
  }
  
  private void aMi()
  {
    AppMethodBeat.i(25371);
    if (this.sXK.getCount() > 0)
    {
      this.sYc.findViewById(2131823242).setVisibility(0);
      this.sYd.findViewById(2131824219).setVisibility(8);
      enableOptionMenu(0, true);
      AppMethodBeat.o(25371);
      return;
    }
    this.sYc.findViewById(2131823242).setVisibility(8);
    this.sYd.findViewById(2131824219).setVisibility(0);
    enableOptionMenu(0, false);
    AppMethodBeat.o(25371);
  }
  
  public int getLayoutId()
  {
    return 2130969611;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25370);
    if (com.tencent.mm.model.a.g.abw().pL("1") != null)
    {
      localObject = com.tencent.mm.model.a.g.abw().pL("1").value;
      if (!((String)localObject).equals("0")) {
        ((String)localObject).equals("1");
      }
      f.pP("1");
    }
    this.sXK = new b(getContext());
    d.ali().add(this.sXK);
    this.sXK.a(new FMessageConversationUI.1(this));
    this.sYa = ((ListView)findViewById(2131824216));
    this.sYc = LayoutInflater.from(getContext()).inflate(2130969616, null);
    this.sYc.findViewById(2131823242).setOnClickListener(new FMessageConversationUI.2(this));
    this.sYa.addHeaderView(this.sYc);
    this.sYd = LayoutInflater.from(getContext()).inflate(2130969612, null);
    this.sYd.findViewById(2131824220).setOnClickListener(new FMessageConversationUI.3(this));
    this.sYa.addHeaderView(this.sYd);
    this.sYa.setAdapter(this.sXK);
    aMi();
    Object localObject = new l(this);
    this.sYa.setOnItemLongClickListener(new FMessageConversationUI.4(this, (l)localObject));
    localObject = getContext();
    b localb = this.sXK;
    if (this.sYa.getHeaderViewsCount() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.sYb = new a((Context)localObject, localb, bool);
      this.sYa.setOnItemClickListener(this.sYb);
      addTextOptionMenu(0, getString(2131301547), new FMessageConversationUI.5(this));
      setBackBtn(new FMessageConversationUI.6(this));
      AppMethodBeat.o(25370);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25366);
    super.onCreate(paramBundle);
    setMMTitle(2131300003);
    try
    {
      com.tencent.mm.model.aw.getNotification().IG();
      if (!com.tencent.mm.model.aw.RG())
      {
        finish();
        AppMethodBeat.o(25366);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
      AppMethodBeat.o(25366);
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(25372);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (av)this.sXK.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ab.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(25372);
      return;
    }
    if (!bo.isNullOrNil(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(j.b(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, 2131296901);
    this.sYf = paramContextMenuInfo.field_fmsgSysRowId;
    this.pIl = paramContextMenuInfo.field_talker;
    AppMethodBeat.o(25372);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25369);
    super.onDestroy();
    if (this.sXK != null) {
      d.ali().remove(this.sXK);
    }
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      ab.w("MicroMsg.FMessageConversationUI", "account not init.");
      AppMethodBeat.o(25369);
      return;
    }
    f.pQ("1");
    d.ali().dxx();
    AppMethodBeat.o(25369);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25367);
    super.onPause();
    com.tencent.mm.model.aw.aaz();
    com.tencent.mm.model.c.Ru().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(25367);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25368);
    super.onResume();
    if (!com.tencent.mm.model.aw.RG())
    {
      finish();
      AppMethodBeat.o(25368);
      return;
    }
    if ((this.sYe != null) && (bo.hl(this))) {
      this.sYe.setText(2131300009);
    }
    AppMethodBeat.o(25368);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI
 * JD-Core Version:    0.7.0.1
 */