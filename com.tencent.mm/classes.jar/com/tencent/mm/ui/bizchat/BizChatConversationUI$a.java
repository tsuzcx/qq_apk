package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.b.a;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.c.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import java.util.HashMap;

public final class BizChatConversationUI$a
  extends BaseConversationUI.b
  implements com.tencent.mm.ai.n, m.b
{
  private String efK;
  private TextView emptyTipTv;
  private ListView hZn;
  private n.d hZq;
  private long idK;
  private String idQ;
  private com.tencent.mm.ui.tools.k idp;
  private int idy = 0;
  private int idz = 0;
  private boolean isCurrentActivity;
  private boolean isDeleteCancel = false;
  private p tipDialog;
  private LinearLayout veP;
  private b veQ;
  private com.tencent.mm.ai.a.j veR;
  private int veS = 0;
  private b.a veT = new BizChatConversationUI.a.11(this);
  private d.a veU = new BizChatConversationUI.a.13(this);
  private c.a veV = new BizChatConversationUI.a.14(this);
  
  private void cBA()
  {
    String str = cBC();
    this.veS = com.tencent.mm.ui.g.bw(getContext(), str);
    if ((this.veS == 2) && (this.veP == null))
    {
      this.veP = ((LinearLayout)findViewById(R.h.bottom_bar));
      Object localObject = this.veP.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.aa(getContext(), R.f.DefaultTabbarHeight);
      this.veP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = com.tencent.mm.ui.y.gt(getContext()).inflate(R.i.enterprise_wework_view, this.veP, false);
      float f = com.tencent.mm.cb.a.cJ(getContext());
      ImageView localImageView = (ImageView)((View)localObject).findViewById(R.h.icon_iv);
      int i = localImageView.getLayoutParams().height;
      localImageView.getLayoutParams().height = ((int)(i * f));
      localImageView.getLayoutParams().width = ((int)(f * i));
      localImageView.requestLayout();
      ((TextView)((View)localObject).findViewById(R.h.title_tv)).setText(R.l.enterprise_wework_create_chat);
      this.veP.addView((View)localObject);
      ((View)localObject).setOnClickListener(new BizChatConversationUI.a.12(this));
      com.tencent.mm.ui.g.m(getContext(), this.idQ, 4);
      com.tencent.mm.ui.g.bx(getContext(), str);
    }
    if (this.veP != null)
    {
      if (this.veS == 2) {
        this.veP.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.veP.setVisibility(8);
  }
  
  private void cBB()
  {
    boolean bool = false;
    Object localObject = z.MC().bZ(this.idQ);
    this.veR = z.MC().bY((String)localObject);
    String str = this.idQ;
    if (this.veR == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, localObject, Boolean.valueOf(bool) });
    if ((bk.bl((String)localObject)) || (this.veR == null) || (this.veR.MO()) || (bk.bl(this.veR.field_addMemberUrl)))
    {
      z.MG();
      com.tencent.mm.ai.a.h.a(this.idQ, this);
      localObject = thisActivity();
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.app_waiting), true, new BizChatConversationUI.a.9(this));
    }
  }
  
  private String cBC()
  {
    if (bk.bl(this.efK)) {
      this.efK = z.My().kQ(this.idQ).LG();
    }
    return this.efK;
  }
  
  private void hL(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_biz_chat_id", paramLong);
    localBundle.putBoolean("finish_direct", false);
    localBundle.putBoolean("key_need_send_video", false);
    localBundle.putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(this.idQ, localBundle, true);
  }
  
  public final void a(int paramInt, com.tencent.mm.ah.m paramm)
  {
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramm.getType() == 1355)
    {
      paramm = ((com.tencent.mm.ai.a.n)paramm).MT();
      paramm = z.MA().lp(paramm.sPX.sYQ.sCI);
      if (paramm == null) {
        Toast.makeText(ae.getContext(), getString(R.l.room_create_fail), 0).show();
      }
    }
    else
    {
      return;
    }
    hL(paramm.field_bizChatLocalId);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject) {}
  
  protected final int getLayoutId()
  {
    return R.i.enterprise_conversation;
  }
  
  public final String getUserName()
  {
    if (bk.bl(this.efK)) {
      return this.idQ;
    }
    return this.efK;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.idQ = thisActivity().getIntent().getStringExtra("Contact_User");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
    z.MB().a(this.veT, thisActivity().getMainLooper());
    z.MA().a(this.veU, thisActivity().getMainLooper());
    z.MH().a(this.veV, thisActivity().getMainLooper());
    au.Hx();
    com.tencent.mm.model.c.FB().a(this);
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.main_empty_conversation);
    this.hZn = ((ListView)findViewById(R.h.tmessage_lv));
    cBA();
    this.veQ = new b(thisActivity(), new BizChatConversationUI.a.19(this), this.idQ);
    this.veQ.setGetViewPositionCallback(new BizChatConversationUI.a.20(this));
    this.veQ.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void D(View paramAnonymousView, int paramAnonymousInt)
      {
        BizChatConversationUI.a.j(BizChatConversationUI.a.this).performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
      }
    });
    this.veQ.a(new MMSlideDelView.f()
    {
      public final void bg(Object paramAnonymousObject)
      {
        if (paramAnonymousObject == null) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
        }
      }
    });
    this.hZn.setAdapter(this.veQ);
    this.hZq = new BizChatConversationUI.a.15(this);
    paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
    this.hZn.setOnTouchListener(new BizChatConversationUI.a.16(this));
    this.hZn.setOnItemLongClickListener(new BizChatConversationUI.a.17(this, paramBundle));
    this.hZn.setOnItemClickListener(new BizChatConversationUI.a.18(this));
    setBackBtn(new BizChatConversationUI.a.3(this));
    addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new BizChatConversationUI.a.4(this));
    addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new BizChatConversationUI.a.5(this));
    cBB();
    au.DS().k(new BizChatConversationUI.a.10(this), 300L);
    paramBundle = cBC();
    if (paramBundle != null)
    {
      z.MH();
      com.tencent.mm.ai.c.a(paramBundle, null);
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
    }
    for (;;)
    {
      Looper.myQueue().addIdleHandler(new BizChatConversationUI.a.1(this));
      paramBundle = thisActivity().getIntent();
      if (t.a(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
      {
        long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
        if (l != -1L) {
          hL(l);
        }
      }
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    label174:
    label234:
    label242:
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      Object localObject;
      zp localzp;
      if (paramIntent != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localzp = new zp();
        com.tencent.mm.ai.a.c localc = new com.tencent.mm.ai.a.c();
        if (this.veR != null)
        {
          paramIntent = this.veR.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.idQ;
          if (!com.tencent.mm.ai.a.e.a(localc, (String)localObject, null, localzp)) {
            break label234;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label174;
          }
          hL(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label242;
        }
        Toast.makeText(thisActivity(), getString(R.l.room_create_fail), 0).show();
        return;
        paramIntent = null;
        break;
        z.MG();
        paramIntent = com.tencent.mm.ai.a.h.a(this.idQ, localzp, this);
        localObject = thisActivity();
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.app_waiting), true, new BizChatConversationUI.a.6(this, paramIntent));
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (com.tencent.mm.ai.a.a)this.veQ.getItem(paramView.position);
    this.idK = paramContextMenuInfo.field_bizChatId;
    if (paramContextMenuInfo.field_unReadCount <= 0)
    {
      paramContextMenu.add(paramView.position, 1, 0, R.l.main_conversation_longclick_setUnRead);
      z.MB();
      if (!com.tencent.mm.ai.a.b.c(paramContextMenuInfo)) {
        break label114;
      }
      paramContextMenu.add(paramView.position, 3, 1, R.l.main_conversation_longclick_unplacedtop);
    }
    for (;;)
    {
      paramContextMenu.add(paramView.position, 0, 2, R.l.main_delete);
      return;
      paramContextMenu.add(paramView.position, 2, 0, R.l.main_conversation_longclick_markRead);
      break;
      label114:
      paramContextMenu.add(paramView.position, 3, 1, R.l.main_conversation_longclick_placedtop);
    }
  }
  
  public final void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
    z.MB().a(this.veT);
    z.MA().a(this.veU);
    z.MH().a(this.veV);
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this);
    }
    this.veQ.bcS();
    b localb = this.veQ;
    if (localb.veF != null)
    {
      localb.veF.clear();
      localb.veF = null;
    }
    super.onDestroy();
  }
  
  public final void onPause()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatConversationFmUI", "on pause");
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.idQ);
    com.tencent.mm.ai.a.b localb = z.MB();
    String str = this.idQ;
    if (bk.bl(str)) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizConversationStorage", "brandUserName is null");
    }
    for (;;)
    {
      if (this.veQ != null) {
        this.veQ.onPause();
      }
      this.isCurrentActivity = false;
      au.getNotification().ew("");
      super.onPause();
      return;
      str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.dXw.gk("BizChatConversation", str)), str });
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.idQ);
    if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type)))
    {
      finish();
      return;
    }
    com.tencent.mm.ai.d locald = f.kX(this.idQ);
    if ((locald == null) || (locald.field_enterpriseFather == null) || (!s.hk(locald.field_enterpriseFather)))
    {
      finish();
      return;
    }
    if (localad.Bj()) {
      setTitleMuteIconVisibility(0);
    }
    for (;;)
    {
      this.isCurrentActivity = true;
      this.veQ.a(null, null);
      au.getNotification().ew(this.idQ);
      return;
      setTitleMuteIconVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a
 * JD-Core Version:    0.7.0.1
 */