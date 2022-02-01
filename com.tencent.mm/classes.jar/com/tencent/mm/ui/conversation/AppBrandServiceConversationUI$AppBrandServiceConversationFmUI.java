package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.r;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.v.a;
import java.math.BigInteger;
import java.util.List;

@Keep
public class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
  implements q.g
{
  private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
  private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
  private static final int CONTEXT_MENU_LONGCLICK_DISMISS = 4;
  private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
  private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
  private f adapter;
  private com.tencent.mm.ui.appbrand.d appBrandServiceActionSheet;
  private ListView appbrandMessageLV;
  private m contextMenuHelper;
  private az conversation;
  private TextView emptyTipTv;
  private int fromScene;
  private boolean isDeleteCancel = false;
  private String mAppId;
  private String mSceneId;
  private String superUsername;
  private String talker = "";
  private s tipDialog = null;
  
  private void asyncDelMsg(String paramString)
  {
    AppMethodBeat.i(38138);
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
    bh.beI();
    Object localObject = c.bbO().aOG(paramString);
    aft localaft = new aft();
    localaft.SrH = new eaf().btQ(Util.nullAsNil(paramString));
    localaft.HlH = ((et)localObject).field_msgSvrId;
    bh.beI();
    c.bbK().d(new k.a(8, localaft));
    this.isDeleteCancel = false;
    localObject = thisActivity();
    getString(R.l.app_tip);
    localObject = com.tencent.mm.ui.base.h.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(269205);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$902(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, true);
        AppMethodBeat.o(269205);
      }
    });
    customerMsgOperateReport(5);
    bq.a(paramString, new bq.a()
    {
      public final boolean asH()
      {
        AppMethodBeat.i(277460);
        boolean bool = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.isDeleteCancel;
        AppMethodBeat.o(277460);
        return bool;
      }
      
      public final void asI()
      {
        AppMethodBeat.i(277461);
        if (this.iYO != null) {
          this.iYO.dismiss();
        }
        AppMethodBeat.o(277461);
      }
    });
    AppMethodBeat.o(38138);
  }
  
  private void batchSyncForWxaContact()
  {
    AppMethodBeat.i(38129);
    if ((this.adapter == null) || (this.adapter.getCount() == 0))
    {
      AppMethodBeat.o(38129);
      return;
    }
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "batchSyncForWxaContact, size:%d", new Object[] { Integer.valueOf(this.adapter.getCount()) });
    if ((this.adapter instanceof AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a))
    {
      List localList = ((AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a)this.adapter).jxh;
      if ((localList != null) && (localList.size() > 0)) {
        ((q)com.tencent.mm.kernel.h.ae(q.class)).bo(localList);
      }
    }
    AppMethodBeat.o(38129);
  }
  
  private void cleadAllServiceAppBrandUnreadCount()
  {
    AppMethodBeat.i(38125);
    r localr = new r();
    EventCenter.instance.publish(localr);
    AppMethodBeat.o(38125);
  }
  
  private void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(38137);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(38137);
      return;
    }
    asyncDelMsg(paramString);
    bh.beI();
    c.bbR().bwv(paramString);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292238);
        ((e)com.tencent.mm.kernel.h.ae(e.class)).c(null);
        AppMethodBeat.o(292238);
      }
    });
    AppMethodBeat.o(38137);
  }
  
  private void enterConversationReport()
  {
    AppMethodBeat.i(38131);
    if (this.adapter == null)
    {
      Log.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
      AppMethodBeat.o(38131);
      return;
    }
    bh.beI();
    Object localObject1 = c.bbR().bwx("appbrandcustomerservicemsg");
    if ((localObject1 != null) && (!Util.isNullOrNil(((bb)localObject1).field_username))) {}
    for (int j = ((bb)localObject1).field_unReadCount;; j = 0)
    {
      localObject1 = (az)this.adapter.getItem(0);
      Object localObject2;
      if ((localObject1 != null) && (!Util.isNullOrNil(((bb)localObject1).field_username)))
      {
        localObject2 = Util.nullAsNil(((bb)localObject1).field_content);
        localObject1 = ((q)com.tencent.mm.kernel.h.ae(q.class)).aeW(((bb)localObject1).field_username);
        if (localObject1 == null)
        {
          localObject1 = null;
          this.mAppId = ((String)localObject1);
        }
      }
      for (localObject1 = localObject2;; localObject1 = "")
      {
        int k;
        label162:
        int m;
        if (j > 0)
        {
          int n = this.adapter.getCount();
          k = 0;
          int i = 0;
          m = i;
          if (k >= n) {
            break label226;
          }
          localObject2 = (az)this.adapter.getItem(k);
          m = ((bb)localObject2).field_unReadCount;
          if (((bb)localObject2).field_unReadMuteCount + m <= 0) {
            break label354;
          }
          i += 1;
        }
        label354:
        for (;;)
        {
          k += 1;
          break label162;
          localObject1 = ((WxaAttributes)localObject1).field_appId;
          break;
          m = 0;
          label226:
          Log.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[] { Integer.valueOf(13797), this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, localObject1 });
          com.tencent.mm.plugin.report.service.h.IzE.a(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(Util.nowSecond()), Integer.valueOf(0), localObject1 });
          AppMethodBeat.o(38131);
          return;
        }
      }
    }
  }
  
  private String intToString(int paramInt)
  {
    AppMethodBeat.i(38130);
    String str = new BigInteger(Integer.toBinaryString(paramInt), 2).toString();
    AppMethodBeat.o(38130);
    return str;
  }
  
  private void setShowView(int paramInt)
  {
    AppMethodBeat.i(38136);
    if (paramInt <= 0)
    {
      this.emptyTipTv.setVisibility(0);
      this.appbrandMessageLV.setVisibility(8);
      AppMethodBeat.o(38136);
      return;
    }
    this.emptyTipTv.setVisibility(8);
    this.appbrandMessageLV.setVisibility(0);
    AppMethodBeat.o(38136);
  }
  
  public void customerMsgOperateReport(int paramInt)
  {
    AppMethodBeat.i(38132);
    Log.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(paramInt), this.mAppId, this.mSceneId });
    com.tencent.mm.plugin.report.service.h.IzE.a(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(38132);
  }
  
  public void entryCustomerMsgDialogReport(String paramString, int paramInt)
  {
    AppMethodBeat.i(38133);
    bh.beI();
    az localaz = c.bbR().bwx(paramString);
    if (localaz == null)
    {
      Log.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
      AppMethodBeat.o(38133);
      return;
    }
    int i = localaz.field_unReadCount;
    paramString = Util.nullAsNil(this.mSceneId);
    Log.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
    com.tencent.mm.plugin.report.service.h.IzE.a(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(Util.nowSecond()) });
    AppMethodBeat.o(38133);
  }
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public String getUserName()
  {
    return this.superUsername;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(38134);
    setMMTitle(getString(R.l.eoo));
    this.appbrandMessageLV = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eop);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38111);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.finish();
        AppMethodBeat.o(38111);
        return true;
      }
    });
    this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.d(thisActivity());
    this.adapter = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a(thisActivity(), this.superUsername, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(38112);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount());
        AppMethodBeat.o(38112);
      }
    });
    this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38113);
        int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38113);
        return i;
      }
    });
    this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38114);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38114);
      }
    });
    this.appbrandMessageLV.setAdapter(this.adapter);
    this.contextMenuHelper = new m(thisActivity());
    this.appbrandMessageLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38115);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (az)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
        paramAnonymousAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation;
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount()) });
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
          a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38115);
          return;
        }
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, paramAnonymousAdapterView.field_username);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putBoolean("finish_direct", false);
        paramAnonymousView.putBoolean("key_need_send_video", false);
        paramAnonymousView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
        paramAnonymousView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene);
        paramAnonymousView.putInt("app_brand_chatting_from_scene_new", 3);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
        a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38115);
      }
    });
    this.appbrandMessageLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38116);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (az)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation.field_username);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.contextMenuHelper.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this);
        AppMethodBeat.o(38116);
        return true;
      }
    });
    this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38117);
        int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38117);
        return i;
      }
    });
    this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38118);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38118);
      }
    });
    this.adapter.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(38107);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
          AppMethodBeat.o(38107);
          return;
        }
        paramAnonymousObject = paramAnonymousObject.toString();
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$800(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, paramAnonymousObject);
        AppMethodBeat.o(38107);
      }
    });
    AppMethodBeat.o(38134);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(38124);
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.superUsername = getStringExtra("Contact_User");
    if (TextUtils.isEmpty(this.superUsername)) {
      this.superUsername = "appbrandcustomerservicemsg";
    }
    this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    bh.beI();
    paramBundle = intToString(c.getUin());
    this.mSceneId = (System.currentTimeMillis() + paramBundle);
    initView();
    addIconOptionMenu(1, R.k.app_brand_setting, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.1(this));
    bh.beI();
    c.bbR().add(this.adapter);
    cleadAllServiceAppBrandUnreadCount();
    enterConversationReport();
    batchSyncForWxaContact();
    AppMethodBeat.o(38124);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38135);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38135);
      return;
    }
    AppMethodBeat.o(38135);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38140);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((q)com.tencent.mm.kernel.h.ae(q.class)).aeW(this.talker);
    int i;
    if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
    {
      i = 1;
      if (i == 0) {
        break label103;
      }
      paramContextMenu.add(paramView.position, 1, 0, R.l.eoq);
    }
    for (;;)
    {
      paramContextMenu.add(paramView.position, 3, 0, R.l.eBd);
      AppMethodBeat.o(38140);
      return;
      i = 0;
      break;
      label103:
      paramContextMenu.add(paramView.position, 2, 0, R.l.eor);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38126);
    if (bh.aHB())
    {
      bh.beI();
      c.bbR().remove(this.adapter);
    }
    batchSyncForWxaContact();
    if (this.adapter != null) {
      this.adapter.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38126);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38139);
    bh.beI();
    as localas = c.bbL().RG(this.talker);
    if ((localas == null) || ((int)localas.jxt == 0))
    {
      Log.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38139);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38139);
      return;
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.UJN = this.mSceneId;
      this.appBrandServiceActionSheet.rFe = true;
      this.appBrandServiceActionSheet.CR(3);
      AppMethodBeat.o(38139);
      return;
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.UJN = this.mSceneId;
      this.appBrandServiceActionSheet.rFe = true;
      this.appBrandServiceActionSheet.CR(4);
      AppMethodBeat.o(38139);
      return;
      AppMethodBeat.o(38139);
      return;
      delConversationAndMsg(this.talker);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38128);
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
    bh.beI();
    c.bbR().bwz(this.superUsername);
    if (this.adapter != null) {
      this.adapter.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38128);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38127);
    Log.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
    if (this.adapter != null) {
      this.adapter.onResume();
    }
    super.onResume();
    AppMethodBeat.o(38127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI
 * JD-Core Version:    0.7.0.1
 */