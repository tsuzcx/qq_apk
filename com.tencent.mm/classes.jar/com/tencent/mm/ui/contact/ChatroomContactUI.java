package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.widget.b.a;

public class ChatroomContactUI
  extends MMActivity
  implements f, j.a
{
  private com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new ChatroomContactUI.6(this));
  private int idy = 0;
  private int idz = 0;
  private a iep;
  private n.d jEB = new ChatroomContactUI.1(this);
  private TextView kbb;
  private ListView lBK;
  private com.tencent.mm.ui.voicesearch.b vIV;
  private String vIX;
  private ContactCountView vJi;
  private VoiceSearchLayout vKe;
  private com.tencent.mm.modelvoiceaddr.ui.b vKf;
  private d vKg;
  
  private void bdJ()
  {
    if (this.vKg != null) {
      this.vKg.a(null, null);
    }
    if (this.vIV != null) {
      this.vIV.a(null, null);
    }
  }
  
  public final void a(String paramString, l paraml)
  {
    if (this.vJi != null)
    {
      this.vJi.setContactType(2);
      this.vJi.cHs();
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.chatroom_address;
  }
  
  public final void initView()
  {
    ((TextView)findViewById(R.h.empty_voicesearch_tip_tv)).setVisibility(8);
    this.lBK = ((ListView)findViewById(R.h.address_contactlist));
    this.lBK.setAdapter(null);
    this.kbb = ((TextView)findViewById(R.h.empty_voicesearch_tip_tv));
    this.kbb.setText(R.l.address_empty_chatroom_tip);
    this.vKg = new d(this, "@all.chatroom.contact");
    this.vKg.mR(true);
    this.vIV = new com.tencent.mm.ui.voicesearch.b(this.mController.uMN, 1);
    this.vIV.vIs = "@all.chatroom.contact";
    this.vKf = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.vKf.a(new ChatroomContactUI.7(this));
    a(this.vKf);
    this.vKg.setGetViewPositionCallback(new ChatroomContactUI.8(this));
    this.vKg.setPerformItemClickListener(new ChatroomContactUI.9(this));
    this.vKg.a(new ChatroomContactUI.10(this));
    this.lBK.setOnScrollListener(this.dnR);
    this.vKg.scN = this.dnR;
    this.iep = new a(this.mController.uMN);
    this.lBK.setOnItemClickListener(new ChatroomContactUI.11(this));
    this.lBK.setOnItemLongClickListener(new ChatroomContactUI.12(this));
    this.lBK.setOnTouchListener(new ChatroomContactUI.13(this));
    Object localObject = this.lBK;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.vJi = localContactCountView;
    ((ListView)localObject).addFooterView(localContactCountView, null, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ChatroomContactUI.this.finish();
        return false;
      }
    });
    addIconOptionMenu(0, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new Intent(ChatroomContactUI.this, SelectContactUI.class);
        paramAnonymousMenuItem.putExtra("titile", ChatroomContactUI.this.getString(R.l.address_title_launch_chatting));
        paramAnonymousMenuItem.putExtra("list_type", 0);
        paramAnonymousMenuItem.putExtra("list_attr", s.v(new int[] { s.vMt, 256, 512 }));
        ChatroomContactUI.this.mController.uMN.startActivity(paramAnonymousMenuItem);
        return false;
      }
    });
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        BackwardSupportUtil.c.a(ChatroomContactUI.b(ChatroomContactUI.this));
      }
    };
    this.lBK.setAdapter(this.vKg);
    this.vIV.nO(false);
    this.lBK.setVisibility(0);
    this.vKe = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.vKe.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vKe.setTopMargin(BackwardSupportUtil.b.b(this, 100.0F));
    this.vKe.setVisibility(8);
    ((ViewGroup)findViewById(R.h.voicesearch_view)).addView(this.vKe);
    if (this.vKe != null) {
      this.vKe.setOnVisibleChangeListener(new ChatroomContactUI.5(this));
    }
    if (this.vKg.getCount() == 0)
    {
      this.kbb.setSingleLine(false);
      this.kbb.setPadding(40, 0, 40, 0);
      this.kbb.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.address_chatroom_contact_nick);
    initView();
    au.Dk().a(138, this);
    au.Hx();
    c.Fw().a(this.vKg);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    au.Hx();
    if (c.Fw().abl(this.vIX) == null) {
      y.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.vIX);
    }
    while (!com.tencent.mm.model.s.hi(this.vIX)) {
      return;
    }
    paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), r.gV(this.vIX)));
    paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.address_delgroupcard);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(138, this);
    au.Hx();
    c.Fw().b(this.vKg);
    d locald = this.vKg;
    if (locald.ffG != null)
    {
      locald.ffG.detach();
      locald.ffG = null;
    }
    this.vKg.bcS();
    this.vKg.uMi = null;
    this.vIV.detach();
    this.vIV.bcS();
  }
  
  protected void onPause()
  {
    super.onPause();
    au.Hx();
    c.FF().d(this);
    if (this.vKf != null)
    {
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.vKf;
      localb.cJg();
      localb.cancel();
    }
    if (this.vIV != null) {
      this.vIV.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.vJi != null)
    {
      this.vJi.setContactType(2);
      this.vJi.cHs();
    }
    au.Hx();
    c.FF().c(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.vKf != null) && (this.vKe != null))
    {
      com.tencent.mm.br.d.coz();
      if ((com.tencent.mm.at.b.Pf()) || (!x.cqJ().equals("zh_CN"))) {
        break label137;
      }
      this.vKf.eNe = true;
      localb = this.vKf;
      localb.eNi = this.vKe;
      localb.eNg = 1;
      if (1 != localb.eNg) {
        break label129;
      }
      localb.eNf = 2;
    }
    for (;;)
    {
      if (this.vIV != null) {
        this.vIV.onResume();
      }
      return;
      label129:
      localb.eNf = 1;
      continue;
      label137:
      this.vKf.eNe = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (!ah.bU(this)) {}
    while ((w.a.a(this, paramInt1, paramInt2, paramString, 4)) || (paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    switch (paramm.getType())
    {
    default: 
      return;
    }
    bdJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */