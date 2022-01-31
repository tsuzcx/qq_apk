package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.util.Map;

public final class BizConversationUI$a
  extends BaseConversationUI.b
{
  private ak conversation;
  private String eeM;
  private TextView emptyTipTv;
  private int idy = 0;
  private int idz = 0;
  private com.tencent.mm.ui.widget.b.a iep;
  private n.d ifj = new BizConversationUI.a.8(this);
  private long iha = 0L;
  private com.tencent.mm.sdk.b.c ihk = new BizConversationUI.a.9(this);
  private boolean isDeleteCancel = false;
  private String talker = "";
  private p tipDialog = null;
  private ListView vPr;
  private BizConversationUI.a.a vPs;
  private String vPt;
  
  protected final int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public final String getUserName()
  {
    return this.eeM;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.eeM = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    if (bk.bl(this.eeM)) {
      this.eeM = "officialaccounts";
    }
    if (bk.pm(this.eeM).equals("officialaccounts")) {
      h.nFQ.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
    }
    this.vPt = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    if (bk.bl(this.vPt)) {
      this.vPt = getString(R.l.biz_conversation_title);
    }
    setMMTitle(this.vPt);
    this.vPr = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.empty_biz_msg_tip);
    setBackBtn(new BizConversationUI.a.11(this));
    setToTop(new BizConversationUI.a.12(this));
    this.vPs = new BizConversationUI.a.a(thisActivity(), this.eeM, new BizConversationUI.a.13(this));
    this.vPs.setGetViewPositionCallback(new BizConversationUI.a.14(this));
    this.vPs.setPerformItemClickListener(new BizConversationUI.a.15(this));
    this.vPr.setAdapter(this.vPs);
    this.iep = new com.tencent.mm.ui.widget.b.a(thisActivity());
    this.vPr.setOnItemClickListener(new BizConversationUI.a.16(this));
    this.vPr.setOnTouchListener(new BizConversationUI.a.17(this));
    this.vPr.setOnItemLongClickListener(new BizConversationUI.a.2(this));
    this.vPs.setGetViewPositionCallback(new BizConversationUI.a.3(this));
    this.vPs.setPerformItemClickListener(new BizConversationUI.a.4(this));
    this.vPs.a(new BizConversationUI.a.5(this));
    if ("officialaccounts".equals(this.eeM))
    {
      paramBundle = com.tencent.mm.model.c.c.IX().fJ("100045");
      if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.ctr().get("isOpenSearch")))) {
        break label534;
      }
    }
    label534:
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new BizConversationUI.a.1(this));
      }
      au.Hx();
      com.tencent.mm.model.c.FB().a(this.vPs);
      this.iha = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.udP.c(this.ihk);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1) {}
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abl(this.talker);
    if (localad == null)
    {
      y.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      return;
    }
    String str = localad.Bq();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bk.bl(localad.field_nickname)) {
        paramView = getString(R.l.chatting_roominfo_noname);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(j.b(thisActivity(), paramView));
    if (com.tencent.mm.n.a.gR(localad.field_type))
    {
      if (!localad.Bl()) {
        break label190;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.main_conversation_longclick_unplacedtop);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.main_conversation_longclick_delete_biz_service);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_delete);
      return;
      label190:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.contact_info_stick_biz);
    }
  }
  
  public final void onDestroy()
  {
    au.DS().O(new BizConversationUI.a.10(this));
    com.tencent.mm.sdk.b.a.udP.d(this.ihk);
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this.vPs);
    }
    if (this.vPs != null) {
      this.vPs.onDestroy();
    }
    super.onDestroy();
  }
  
  public final void onPause()
  {
    y.i("MicroMsg.BizConversationUI", "on pause");
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.eeM);
    if (this.vPs != null) {
      this.vPs.onPause();
    }
    super.onPause();
  }
  
  public final void onResume()
  {
    y.v("MicroMsg.BizConversationUI", "on resume");
    if (this.vPs != null) {
      this.vPs.onResume();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a
 * JD-Core Version:    0.7.0.1
 */