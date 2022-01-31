package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.o;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import java.math.BigInteger;
import java.util.List;

@Keep
public class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI
  extends BaseConversationUI.b
  implements n.d
{
  private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
  private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
  private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
  private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
  private e adapter;
  private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
  private ListView appbrandMessageLV;
  private j contextMenuHelper;
  private ak conversation;
  private TextView emptyTipTv;
  private int fromScene;
  private boolean isDeleteCancel = false;
  private String mAppId;
  private String mSceneId;
  private String superUsername;
  private String talker = "";
  private p tipDialog = null;
  
  private void asyncDelMsg(String paramString)
  {
    y.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().Hz(paramString);
    su localsu = new su();
    localsu.sQs = new bml().YI(bk.pm(paramString));
    localsu.ndp = ((cs)localObject).field_msgSvrId;
    au.Hx();
    com.tencent.mm.model.c.Fv().b(new i.a(8, localsu));
    this.isDeleteCancel = false;
    localObject = thisActivity();
    getString(R.l.app_tip);
    localObject = com.tencent.mm.ui.base.h.b((Context)localObject, getString(R.l.app_waiting), true, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.3(this));
    customerMsgOperateReport(5);
    com.tencent.mm.model.bd.a(paramString, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.4(this, (ProgressDialog)localObject));
  }
  
  private void batchSyncForWxaContact()
  {
    if ((this.adapter == null) || (this.adapter.getCount() == 0)) {}
    List localList;
    do
    {
      do
      {
        return;
        y.i("MicroMsg.AppBrandServiceConversationFmUI", "batchSyncForWxaContact, size:%d", new Object[] { Integer.valueOf(this.adapter.getCount()) });
      } while (!(this.adapter instanceof AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a));
      localList = ((AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a)this.adapter).dAY;
    } while ((localList == null) || (localList.size() <= 0));
    ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).at(localList);
  }
  
  private void cleadAllServiceAppBrandUnreadCount()
  {
    o localo = new o();
    com.tencent.mm.sdk.b.a.udP.m(localo);
  }
  
  private void delConversationAndMsg(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
      return;
    }
    asyncDelMsg(paramString);
    au.Hx();
    com.tencent.mm.model.c.FB().abu(paramString);
  }
  
  private void enterConversationReport()
  {
    if (this.adapter == null)
    {
      y.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
      return;
    }
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.FB().abv("appbrandcustomerservicemsg");
    if ((localObject1 != null) && (!bk.bl(((as)localObject1).field_username))) {}
    for (int j = ((as)localObject1).field_unReadCount;; j = 0)
    {
      localObject1 = (ak)this.adapter.getItem(0);
      Object localObject2;
      if ((localObject1 != null) && (!bk.bl(((as)localObject1).field_username)))
      {
        localObject2 = bk.pm(((as)localObject1).field_content);
        localObject1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(((as)localObject1).field_username);
        if (localObject1 == null)
        {
          localObject1 = null;
          this.mAppId = ((String)localObject1);
        }
      }
      for (localObject1 = localObject2;; localObject1 = "")
      {
        int k;
        label149:
        int m;
        if (j > 0)
        {
          int n = this.adapter.getCount();
          k = 0;
          int i = 0;
          m = i;
          if (k >= n) {
            break label213;
          }
          localObject2 = (ak)this.adapter.getItem(k);
          m = ((as)localObject2).field_unReadCount;
          if (((as)localObject2).field_unReadMuteCount + m <= 0) {
            break label335;
          }
          i += 1;
        }
        label335:
        for (;;)
        {
          k += 1;
          break label149;
          localObject1 = ((WxaAttributes)localObject1).field_appId;
          break;
          m = 0;
          label213:
          y.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[] { Integer.valueOf(13797), this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, localObject1 });
          com.tencent.mm.plugin.report.service.h.nFQ.f(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(bk.UX()), Integer.valueOf(0), localObject1 });
          return;
        }
      }
    }
  }
  
  private String intToString(int paramInt)
  {
    return new BigInteger(Integer.toBinaryString(paramInt), 2).toString();
  }
  
  private void setShowView(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.emptyTipTv.setVisibility(0);
      this.appbrandMessageLV.setVisibility(8);
      return;
    }
    this.emptyTipTv.setVisibility(8);
    this.appbrandMessageLV.setVisibility(0);
  }
  
  public void customerMsgOperateReport(int paramInt)
  {
    y.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(paramInt), this.mAppId, this.mSceneId });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bk.UX()) });
  }
  
  public void entryCustomerMsgDialogReport(String paramString, int paramInt)
  {
    au.Hx();
    ak localak = com.tencent.mm.model.c.FB().abv(paramString);
    if (localak == null)
    {
      y.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
      return;
    }
    int i = localak.field_unReadCount;
    paramString = bk.pm(this.mSceneId);
    y.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(bk.UX()) });
  }
  
  protected int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public String getUserName()
  {
    return this.superUsername;
  }
  
  protected void initView()
  {
    setMMTitle(getString(R.l.app_brand_customer_service_conversion_ui_title));
    this.appbrandMessageLV = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.app_brand_empty_service_msg_tip);
    setBackBtn(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.5(this));
    this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(thisActivity());
    this.adapter = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a(thisActivity(), this.superUsername, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.6(this));
    this.adapter.setGetViewPositionCallback(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.7(this));
    this.adapter.setPerformItemClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.8(this));
    this.appbrandMessageLV.setAdapter(this.adapter);
    this.contextMenuHelper = new j(thisActivity());
    this.appbrandMessageLV.setOnItemClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.9(this));
    this.appbrandMessageLV.setOnItemLongClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.10(this));
    this.adapter.setGetViewPositionCallback(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.11(this));
    this.adapter.setPerformItemClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.12(this));
    this.adapter.a(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.2(this));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    y.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.superUsername = getStringExtra("Contact_User");
    if (TextUtils.isEmpty(this.superUsername)) {
      this.superUsername = "appbrandcustomerservicemsg";
    }
    this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
    y.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    au.Hx();
    paramBundle = intToString(com.tencent.mm.model.c.CK());
    this.mSceneId = (System.currentTimeMillis() + paramBundle);
    initView();
    addIconOptionMenu(1, R.k.app_brand_setting, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.1(this));
    au.Hx();
    com.tencent.mm.model.c.FB().a(this.adapter);
    cleadAllServiceAppBrandUnreadCount();
    enterConversationReport();
    batchSyncForWxaContact();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1) {}
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(this.talker);
    int i;
    if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      paramContextMenu.add(paramView.position, 1, 0, R.l.app_brand_menu_accept_msg);
    }
    for (;;)
    {
      paramContextMenu.add(paramView.position, 3, 0, R.l.delete_message);
      return;
      i = 0;
      break;
      label90:
      paramContextMenu.add(paramView.position, 2, 0, R.l.app_brand_menu_refuse_msg);
    }
  }
  
  public void onDestroy()
  {
    if (au.DK())
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this.adapter);
    }
    batchSyncForWxaContact();
    if (this.adapter != null) {
      this.adapter.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abl(this.talker);
    if ((localad == null) || ((int)localad.dBe == 0))
    {
      y.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.talker);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.uRI = this.mSceneId;
      this.appBrandServiceActionSheet.hCQ = true;
      this.appBrandServiceActionSheet.show(3);
      return;
    case 2: 
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.uRI = this.mSceneId;
      this.appBrandServiceActionSheet.hCQ = true;
      this.appBrandServiceActionSheet.show(4);
      return;
    }
    delConversationAndMsg(this.talker);
  }
  
  public void onPause()
  {
    y.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
    au.Hx();
    com.tencent.mm.model.c.FB().abx(this.superUsername);
    if (this.adapter != null) {
      this.adapter.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    y.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
    if (this.adapter != null) {
      this.adapter.onResume();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI
 * JD-Core Version:    0.7.0.1
 */