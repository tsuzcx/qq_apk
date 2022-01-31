package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.c.a;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bwk;
import com.tencent.mm.protocal.c.bwl;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.k;
import java.util.HashMap;

public final class EnterpriseConversationUI$a
  extends BaseConversationUI.b
  implements com.tencent.mm.ah.f, m.b
{
  private com.tencent.mm.ui.tools.j contextMenuHelper;
  private long diQ = 0L;
  long eCu = 0L;
  private String eeM;
  private TextView emptyTipTv;
  private int fromScene;
  private long hFF = 0L;
  private String idB = "";
  private n.d ifj;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ui.base.p tipDialog;
  private ListView vPr;
  private String vPt;
  private k vSP;
  private View vSQ = null;
  private i vSR;
  private String vSS = null;
  private ah vST;
  private int vSU = -2;
  private String vSV = null;
  private LinearLayout veP = null;
  private int veS = 0;
  private c.a veV = new EnterpriseConversationUI.a.10(this);
  
  private void cBA()
  {
    this.veS = com.tencent.mm.ui.g.bw(getContext(), this.eeM);
    Object localObject;
    int i;
    label340:
    int j;
    label351:
    long l1;
    if ((this.veS == 2) && (this.veP == null))
    {
      this.veP = ((LinearLayout)findViewById(R.h.bottom_bar));
      localObject = this.veP.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.cb.a.aa(getContext(), R.f.DefaultTabbarHeight);
      this.veP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.vSQ = com.tencent.mm.ui.y.gt(getContext()).inflate(R.i.enterprise_wework_view, this.veP, false);
      float f = com.tencent.mm.cb.a.cJ(getContext());
      localObject = (ImageView)this.vSQ.findViewById(R.h.icon_iv);
      i = ((ImageView)localObject).getLayoutParams().height;
      ((ImageView)localObject).getLayoutParams().height = ((int)(i * f));
      ((ImageView)localObject).getLayoutParams().width = ((int)(f * i));
      ((ImageView)localObject).requestLayout();
      localObject = (TextView)this.vSQ.findViewById(R.h.title_tv);
      com.tencent.mm.ai.b localb = z.MH().kD(this.eeM);
      z.MH();
      z.MH();
      String str = com.tencent.mm.ai.c.ik(0);
      if ((localb != null) && (!localb.field_chatOpen) && (!localb.field_use_preset_banner_tips) && (str != null))
      {
        ((TextView)localObject).setText(str);
        com.tencent.mm.ui.g.an(this.eeM, 1, 2);
        this.veP.addView(this.vSQ);
        this.vSQ.setOnClickListener(new EnterpriseConversationUI.a.13(this));
        com.tencent.mm.ui.g.m(getContext(), this.eeM, 3);
        com.tencent.mm.ui.g.bx(getContext(), this.eeM);
      }
    }
    else if (this.veP != null)
    {
      if (this.veS != 2) {
        break label526;
      }
      this.veP.setVisibility(0);
      localObject = z.MH().kD(this.eeM);
      if (localObject == null) {
        break label504;
      }
      i = ((com.tencent.mm.ai.b)localObject).field_qyUin;
      if (localObject == null) {
        break label509;
      }
      j = ((com.tencent.mm.ai.b)localObject).field_userUin;
      if (localObject == null) {
        break label514;
      }
      l1 = ((com.tencent.mm.ai.b)localObject).field_wwCorpId;
      label363:
      if (localObject == null) {
        break label520;
      }
    }
    label514:
    label520:
    for (long l2 = ((com.tencent.mm.ai.b)localObject).field_wwUserVid;; l2 = 0L)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
      return;
      ((TextView)localObject).setText(R.l.enterprise_wework_open);
      break;
      label504:
      i = 0;
      break label340;
      label509:
      j = 0;
      break label351;
      l1 = 0L;
      break label363;
    }
    label526:
    this.veP.setVisibility(8);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject) {}
  
  protected final int getLayoutId()
  {
    return R.i.enterprise_conversation;
  }
  
  public final String getUserName()
  {
    return this.eeM;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.eeM = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    this.vPt = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
    setMMTitle(this.vPt);
    this.vPr = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.enterprise_empty_msg_tip);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        EnterpriseConversationUI.a.this.finish();
        return true;
      }
    });
    setToTop(new EnterpriseConversationUI.a.11(this));
    if (com.tencent.mm.ai.f.kX(this.eeM) != null)
    {
      cBA();
      if (this.eeM != null)
      {
        paramBundle = new EnterpriseConversationUI.a.12(this);
        z.MH();
        com.tencent.mm.ai.c.a(this.eeM, paramBundle);
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.eeM });
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new EnterpriseConversationUI.a.14(this));
        addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new EnterpriseConversationUI.a.15(this));
        this.vSR = new i(thisActivity(), this.eeM, new EnterpriseConversationUI.a.16(this));
        this.vSR.setGetViewPositionCallback(new EnterpriseConversationUI.a.17(this));
        this.vSR.setPerformItemClickListener(new EnterpriseConversationUI.a.18(this));
        this.vSR.a(new MMSlideDelView.f()
        {
          public final void bg(Object paramAnonymousObject)
          {
            if (paramAnonymousObject == null)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
              return;
            }
            paramAnonymousObject = paramAnonymousObject.toString();
            EnterpriseConversationUI.a.a(EnterpriseConversationUI.a.this, paramAnonymousObject);
          }
        });
        this.vPr.setAdapter(this.vSR);
        this.vPr.setOnItemClickListener(new EnterpriseConversationUI.a.3(this));
        this.contextMenuHelper = new com.tencent.mm.ui.tools.j(thisActivity());
        this.ifj = new EnterpriseConversationUI.a.4(this);
        this.vPr.setOnItemLongClickListener(new EnterpriseConversationUI.a.5(this));
      }
    }
    else
    {
      this.diQ = (System.currentTimeMillis() / 1000L);
      au.Hx();
      paramBundle = com.tencent.mm.model.c.FB().abv(this.eeM);
      if (paramBundle != null)
      {
        this.vSU = paramBundle.field_unReadCount;
        if ((this.vSU == 0) && (paramBundle.field_unReadMuteCount > 0)) {
          this.vSU = -1;
        }
        this.hFF = (paramBundle.field_conversationTime / 1000L);
        if (paramBundle.field_isSend != 1) {
          break label546;
        }
        paramBundle = null;
        label448:
        this.vSV = paramBundle;
      }
      z.MH().a(this.veV, thisActivity().getMainLooper());
      au.Hx();
      com.tencent.mm.model.c.FB().a(this);
      au.Hx();
      com.tencent.mm.model.c.Fw().a(this);
      if (this.vSR != null)
      {
        if (this.vST != null) {
          break label554;
        }
        this.vST = new EnterpriseConversationUI.a.9(this);
      }
    }
    for (;;)
    {
      this.vST.sendEmptyMessageDelayed(1, 500L);
      return;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
      break;
      label546:
      paramBundle = paramBundle.field_digestUser;
      break label448;
      label554:
      this.vST.removeMessages(1);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    com.tencent.mm.plugin.messenger.a.g.bhI().o(str1, str2, bool);
    com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramIntent, str2);
    com.tencent.mm.ui.widget.snackbar.b.h(thisActivity(), getContext().getString(R.l.finish_sent));
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abl(this.idB);
    if (localad == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.idB);
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
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(thisActivity(), paramView));
    if (localad.Bl()) {
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_conversation_longclick_unplacedtop);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 1, R.l.enterprise_longclick_disable_sub);
      paramContextMenu.add(paramContextMenuInfo.position, 1, 2, R.l.main_delete);
      return;
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.enterprise_sub_placetop);
    }
  }
  
  public final void onDestroy()
  {
    z.MH().a(this.veV);
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this);
      au.Hx();
      com.tencent.mm.model.c.Fw().b(this);
    }
    if (this.vSR != null)
    {
      localObject = this.vSR;
      ((i)localObject).vQg.stopTimer();
      if (((i)localObject).veF != null)
      {
        ((i)localObject).veF.clear();
        ((i)localObject).veF = null;
      }
      ((i)localObject).bcS();
      ((r)localObject).uMi = null;
      au.Hx();
      com.tencent.mm.model.c.FB().b((m.b)localObject);
    }
    au.Dk().b(1394, this);
    if ((this.diQ <= 0L) || (this.eCu <= 0L))
    {
      super.onDestroy();
      return;
    }
    long l = this.eCu - this.diQ;
    Object localObject = z.MH().kD(this.eeM);
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.ai.b)localObject).field_qyUin;
      label176:
      if (localObject == null) {
        break label296;
      }
    }
    label296:
    for (int j = ((com.tencent.mm.ai.b)localObject).field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
      break;
      i = 0;
      break label176;
    }
  }
  
  public final void onPause()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.EnterpriseConversationUI", "on pause");
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.eeM);
    if (this.vSR != null) {
      this.vSR.onPause();
    }
    super.onPause();
  }
  
  public final void onResume()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.EnterpriseConversationUI", "on resume");
    if (this.vSR != null) {
      this.vSR.onResume();
    }
    super.onResume();
    if (!s.hk(this.eeM)) {
      finish();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    do
    {
      do
      {
        return;
      } while (paramm.getType() != 1394);
      paramString = ((com.tencent.mm.plugin.profile.a.c)paramm).bst();
      localObject = ((com.tencent.mm.plugin.profile.a.c)paramm).bss();
      if ((localObject == null) || (((bwl)localObject).sCU == null) || (((bwl)localObject).sCU.ret != 0))
      {
        if ((localObject != null) && (((bwl)localObject).sCU != null))
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(((bwl)localObject).sCU.ret) });
          return;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramm.getType()) });
        return;
      }
    } while (!paramString.tMS);
    paramm = com.tencent.mm.ai.f.kX(paramString.sCO);
    paramm.field_brandFlag |= 0x1;
    Object localObject = new aww();
    ((aww)localObject).ffv = paramm.field_brandFlag;
    ((aww)localObject).hPY = paramString.sCO;
    au.Hx();
    com.tencent.mm.model.c.Fv().b(new i.a(47, (com.tencent.mm.bv.a)localObject));
    z.My().c(paramm, new String[0]);
    au.Hx();
    com.tencent.mm.model.c.FB().abu(paramm.field_username);
    au.Hx();
    if (com.tencent.mm.model.c.FB().abI(paramm.field_enterpriseFather) <= 0)
    {
      au.Hx();
      com.tencent.mm.model.c.FB().abu(paramm.field_enterpriseFather);
      return;
    }
    au.Hx();
    com.tencent.mm.model.c.FA().aaG(paramm.field_enterpriseFather);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a
 * JD-Core Version:    0.7.0.1
 */