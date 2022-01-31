package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
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
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.Map;

public class NewBizConversationUI
  extends DrawStatusBarActivity
{
  private ak conversation;
  private String eeM;
  private TextView emptyTipTv;
  private int idy = 0;
  private int idz = 0;
  private com.tencent.mm.ui.widget.b.a iep;
  private n.d ifj = new NewBizConversationUI.9(this);
  private int igH;
  private long iha = 0L;
  private com.tencent.mm.sdk.b.c ihk = new NewBizConversationUI.10(this);
  private boolean isDeleteCancel = false;
  private String talker = "";
  private p tipDialog = null;
  private ListView vPr;
  private String vPt;
  private NewBizConversationUI.a vTE;
  private final int vTF = 1;
  
  protected final int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  protected final int getStatusBarColor()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return -1052684;
    }
    return super.getStatusBarColor();
  }
  
  protected final void initView()
  {
    ta(-1052684);
    setMMTitle(this.vPt);
    oX(-16777216);
    setBackBtn(new NewBizConversationUI.12(this), R.k.actionbar_icon_dark_back);
    setTitleBarDoubleClickListener(new NewBizConversationUI.13(this));
    this.vPr = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.empty_biz_msg_tip);
    this.vTE = new NewBizConversationUI.a(this, this.eeM, new NewBizConversationUI.15(this));
    this.vTE.setGetViewPositionCallback(new NewBizConversationUI.16(this));
    this.vTE.setPerformItemClickListener(new NewBizConversationUI.17(this));
    this.vPr.setAdapter(this.vTE);
    this.iep = new com.tencent.mm.ui.widget.b.a(this);
    this.vPr.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        NewBizConversationUI.a(NewBizConversationUI.this, (ak)NewBizConversationUI.e(NewBizConversationUI.this).getItem(paramAnonymousInt));
        NewBizConversationUI.a(NewBizConversationUI.this, NewBizConversationUI.g(NewBizConversationUI.this).field_username);
        paramAnonymousAdapterView = NewBizConversationUI.g(NewBizConversationUI.this);
        if (paramAnonymousAdapterView == null)
        {
          y.e("MicroMsg.NewBizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(NewBizConversationUI.e(NewBizConversationUI.this).getCount()) });
          NewBizConversationUI.e(NewBizConversationUI.this).notifyDataSetChanged();
          return;
        }
        paramAnonymousView = new Intent(NewBizConversationUI.this, ChattingUI.class);
        paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.field_username);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("biz_click_item_unread_count", NewBizConversationUI.g(NewBizConversationUI.this).field_unReadCount);
        paramAnonymousView.putExtra("biz_click_item_position", paramAnonymousInt + 1);
        paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 90);
        paramAnonymousView.putExtra("specific_chat_from_scene", 6);
        NewBizConversationUI.this.startActivity(paramAnonymousView);
        NewBizConversationUI.e(NewBizConversationUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
      }
    });
    this.vPr.setOnTouchListener(new NewBizConversationUI.2(this));
    this.vPr.setOnItemLongClickListener(new NewBizConversationUI.3(this));
    this.vTE.setGetViewPositionCallback(new NewBizConversationUI.4(this));
    this.vTE.setPerformItemClickListener(new NewBizConversationUI.5(this));
    this.vTE.a(new NewBizConversationUI.6(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!au.DK())
    {
      y.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      return;
    }
    this.igH = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.eeM = "officialaccounts";
    h.nFQ.f(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.igH), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
    this.vPt = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bk.bl(this.vPt)) {
      this.vPt = getString(R.l.biz_conversation_title);
    }
    initView();
    paramBundle = com.tencent.mm.model.c.c.IX().fJ("100045");
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.ctr().get("isOpenSearch")))) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new NewBizConversationUI.1(this));
      }
      a(getString(R.l.biz_time_line_new_msg_title), R.k.actionbar_icon_dark_more, new NewBizConversationUI.11(this));
      au.Hx();
      com.tencent.mm.model.c.FB().a(this.vTE);
      this.iha = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.udP.c(this.ihk);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abl(this.talker);
    if (localad == null)
    {
      y.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
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
    paramContextMenu.setHeaderTitle(j.b(this, paramView));
    if (com.tencent.mm.n.a.gR(localad.field_type))
    {
      if (!localad.Bl()) {
        break label187;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.biz_contact_unset_star);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.main_conversation_longclick_delete_biz_service);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_delete);
      return;
      label187:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.biz_contact_set_star);
    }
  }
  
  public void onDestroy()
  {
    au.DS().O(new NewBizConversationUI.14(this));
    com.tencent.mm.sdk.b.a.udP.d(this.ihk);
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this.vTE);
    }
    if (this.vTE != null) {
      this.vTE.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    y.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.vTE != null) {
      this.vTE.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    y.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.vTE != null) {
      this.vTE.onResume();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */