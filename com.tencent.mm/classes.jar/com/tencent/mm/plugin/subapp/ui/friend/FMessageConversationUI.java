package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.s;

public class FMessageConversationUI
  extends MMActivity
{
  private n.d hZq = new n.d()
  {
    public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
    {
      com.tencent.mm.bh.c.g(FMessageConversationUI.d(FMessageConversationUI.this), FMessageConversationUI.e(FMessageConversationUI.this));
    }
  };
  private String ncT;
  private b pwe;
  private ListView pwt;
  private a pwu;
  private TextView pwv;
  private long pww;
  
  protected final int getLayoutId()
  {
    return R.i.fmessage_conversation;
  }
  
  protected final void initView()
  {
    boolean bool = true;
    Object localObject1;
    int i;
    if (com.tencent.mm.model.a.g.Iy().iX("1") != null)
    {
      localObject1 = com.tencent.mm.model.a.g.Iy().iX("1").value;
      if (((String)localObject1).equals("0"))
      {
        i = 0;
        f.jb("1");
      }
    }
    for (;;)
    {
      this.pwe = new b(this.mController.uMN);
      d.RY().c(this.pwe);
      this.pwe.uMi = new r.a()
      {
        public final void Wp()
        {
          if (FMessageConversationUI.a(FMessageConversationUI.this).getCount() >= 0)
          {
            FMessageConversationUI.this.enableOptionMenu(0, true);
            return;
          }
          FMessageConversationUI.this.enableOptionMenu(0, false);
        }
      };
      this.pwt = ((ListView)findViewById(R.h.fmessage_conversation_lv));
      if (i != 0)
      {
        localObject1 = LayoutInflater.from(this.mController.uMN).inflate(R.i.fmessage_conversation_header, null);
        ((View)localObject1).findViewById(R.h.fmsg_searchEt).setOnClickListener(new FMessageConversationUI.2(this));
        this.pwt.addHeaderView((View)localObject1);
      }
      this.pwt.setAdapter(this.pwe);
      localObject1 = new com.tencent.mm.ui.tools.j(this);
      this.pwt.setOnItemLongClickListener(new FMessageConversationUI.3(this, (com.tencent.mm.ui.tools.j)localObject1));
      localObject1 = this.mController.uMN;
      Object localObject2 = this.pwe;
      if (this.pwt.getHeaderViewsCount() > 0)
      {
        label206:
        this.pwu = new a((Context)localObject1, (b)localObject2, bool);
        this.pwt.setOnItemClickListener(this.pwu);
        if (i != 0) {
          break label330;
        }
        localObject1 = findViewById(R.h.fmessage_conversation_empty_a);
        ((View)localObject1).setVisibility(0);
        ((TextView)findViewById(R.h.empty_tip_recommend_bind_tv)).setOnClickListener(new FMessageConversationUI.4(this));
        this.pwt.setEmptyView((View)localObject1);
      }
      for (;;)
      {
        addTextOptionMenu(0, getString(R.l.menu_item_add_friend), new FMessageConversationUI.7(this));
        setBackBtn(new FMessageConversationUI.8(this));
        return;
        if (!((String)localObject1).equals("1")) {
          break label406;
        }
        i = 1;
        break;
        bool = false;
        break label206;
        label330:
        localObject1 = findViewById(R.h.fmessage_conversation_empty_b);
        ((View)localObject1).setVisibility(0);
        this.pwv = ((TextView)((View)localObject1).findViewById(R.h.fmsg_msg_content));
        localObject2 = (ListView)((View)localObject1).findViewById(R.h.fmsg_list);
        ((ListView)localObject2).setAdapter(new FMessageConversationUI.5(this));
        ((ListView)localObject2).setOnItemClickListener(new FMessageConversationUI.6(this));
        this.pwt.setEmptyView((View)localObject1);
      }
      label406:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.fmessage_conversation_title);
    try
    {
      au.getNotification().wp();
      if (!au.DK())
      {
        finish();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FMessageConversationUI", paramBundle, "try cancel notification fail", new Object[0]);
      }
      initView();
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (av)this.pwe.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      y.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + paramView.position);
      return;
    }
    if (!bk.bl(paramContextMenuInfo.field_displayName)) {
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(this, paramContextMenuInfo.field_displayName));
    }
    paramContextMenu.add(0, 0, 0, R.l.app_delete);
    this.pww = paramContextMenuInfo.field_fmsgSysRowId;
    this.ncT = paramContextMenuInfo.field_talker;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!com.tencent.mm.kernel.g.DN().Dc()) {
      y.w("MicroMsg.FMessageConversationUI", "account not init.");
    }
    do
    {
      return;
      f.jc("1");
      d.RY().cuT();
    } while (this.pwe == null);
    d.RY().d(this.pwe);
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Hx();
    com.tencent.mm.model.c.Dz().o(143618, Integer.valueOf(0));
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!au.DK()) {
      finish();
    }
    while ((this.pwv == null) || (!bk.fV(this))) {
      return;
    }
    this.pwv.setText(R.l.fmessage_no_recommend_msg_google);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI
 * JD-Core Version:    0.7.0.1
 */