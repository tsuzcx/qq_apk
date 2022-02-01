package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.tools.l;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public final class AppBrandServiceConversationUI
  extends BaseConversationUI
{
  private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
  private View contentView;
  
  public final void finish()
  {
    AppMethodBeat.i(38144);
    super.finish();
    AppMethodBeat.o(38144);
  }
  
  protected final ChattingUIFragment getChattingUIFragment()
  {
    AppMethodBeat.i(38145);
    AppBrandServiceChattingUI.AppBrandServiceChattingFmUI localAppBrandServiceChattingFmUI = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI();
    AppMethodBeat.o(38145);
    return localAppBrandServiceChattingFmUI;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38143);
    super.onCreate(paramBundle);
    this.contentView = aa.jQ(this).inflate(2131493308, null);
    setContentView(this.contentView);
    this.conversationFm = new AppBrandServiceConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131304736, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.h.a(this, this.contentView);
    AppMethodBeat.o(38143);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Keep
  public static class AppBrandServiceConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements o.g
  {
    private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
    private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
    private static final int CONTEXT_MENU_LONGCLICK_DISMISS = 4;
    private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
    private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
    private e adapter;
    private d appBrandServiceActionSheet;
    private ListView appbrandMessageLV;
    private l contextMenuHelper;
    private az conversation;
    private TextView emptyTipTv;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private String mAppId;
    private String mSceneId;
    private String superUsername;
    private String talker = "";
    private com.tencent.mm.ui.base.q tipDialog = null;
    
    private void asyncDelMsg(String paramString)
    {
      AppMethodBeat.i(38138);
      Log.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
      bg.aVF();
      Object localObject = com.tencent.mm.model.c.aSQ().aEw(paramString);
      afk localafk = new afk();
      localafk.Lqk = new dqi().bhy(Util.nullAsNil(paramString));
      localafk.Brn = ((eo)localObject).field_msgSvrId;
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(8, localafk));
      this.isDeleteCancel = false;
      localObject = thisActivity();
      getString(2131755998);
      localObject = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(234096);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$902(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, true);
          AppMethodBeat.o(234096);
        }
      });
      customerMsgOperateReport(5);
      bp.a(paramString, new bp.a()
      {
        public final boolean amG()
        {
          AppMethodBeat.i(234097);
          boolean bool = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.isDeleteCancel;
          AppMethodBeat.o(234097);
          return bool;
        }
        
        public final void amH()
        {
          AppMethodBeat.i(234098);
          if (this.guD != null) {
            this.guD.dismiss();
          }
          AppMethodBeat.o(234098);
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
      if ((this.adapter instanceof a))
      {
        List localList = ((a)this.adapter).gMT;
        if ((localList != null) && (localList.size() > 0)) {
          ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).bq(localList);
        }
      }
      AppMethodBeat.o(38129);
    }
    
    private void cleadAllServiceAppBrandUnreadCount()
    {
      AppMethodBeat.i(38125);
      com.tencent.mm.g.a.q localq = new com.tencent.mm.g.a.q();
      EventCenter.instance.publish(localq);
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
      bg.aVF();
      com.tencent.mm.model.c.aST().bjW(paramString);
      com.tencent.f.h.RTc.aX(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.3(this));
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
      bg.aVF();
      Object localObject1 = com.tencent.mm.model.c.aST().bjY("appbrandcustomerservicemsg");
      if ((localObject1 != null) && (!Util.isNullOrNil(((bb)localObject1).field_username))) {}
      for (int j = ((bb)localObject1).field_unReadCount;; j = 0)
      {
        localObject1 = (az)this.adapter.getItem(0);
        Object localObject2;
        if ((localObject1 != null) && (!Util.isNullOrNil(((bb)localObject1).field_username)))
        {
          localObject2 = Util.nullAsNil(((bb)localObject1).field_content);
          localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(((bb)localObject1).field_username);
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
            com.tencent.mm.plugin.report.service.h.CyF.a(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(Util.nowSecond()), Integer.valueOf(0), localObject1 });
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
      com.tencent.mm.plugin.report.service.h.CyF.a(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
      AppMethodBeat.o(38132);
    }
    
    public void entryCustomerMsgDialogReport(String paramString, int paramInt)
    {
      AppMethodBeat.i(38133);
      bg.aVF();
      az localaz = com.tencent.mm.model.c.aST().bjY(paramString);
      if (localaz == null)
      {
        Log.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
        AppMethodBeat.o(38133);
        return;
      }
      int i = localaz.field_unReadCount;
      paramString = Util.nullAsNil(this.mSceneId);
      Log.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.report.service.h.CyF.a(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(Util.nowSecond()) });
      AppMethodBeat.o(38133);
    }
    
    public int getLayoutId()
    {
      return 2131496720;
    }
    
    public String getUserName()
    {
      return this.superUsername;
    }
    
    protected void initView()
    {
      AppMethodBeat.i(38134);
      setMMTitle(getString(2131755406));
      this.appbrandMessageLV = ((ListView)findViewById(2131309254));
      this.emptyTipTv = ((TextView)findViewById(2131300096));
      this.emptyTipTv.setText(2131755436);
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
      this.appBrandServiceActionSheet = new d(thisActivity());
      this.adapter = new a(thisActivity(), this.superUsername, new s.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(38112);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount());
          AppMethodBeat.o(38112);
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(38113);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38113);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38114);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38114);
        }
      });
      this.appbrandMessageLV.setAdapter(this.adapter);
      this.contextMenuHelper = new l(thisActivity());
      this.appbrandMessageLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38115);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (az)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          paramAnonymousAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation;
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount()) });
            AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(38115);
            return;
          }
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("finish_direct", false);
          paramAnonymousView.putBoolean("key_need_send_video", false);
          paramAnonymousView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
          paramAnonymousView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.entryCustomerMsgDialogReport(paramAnonymousAdapterView.field_username, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(38117);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38117);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38118);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38118);
        }
      });
      this.adapter.a(new MMSlideDelView.f()
      {
        public final void cZ(Object paramAnonymousObject)
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
      bg.aVF();
      paramBundle = intToString(com.tencent.mm.model.c.getUin());
      this.mSceneId = (System.currentTimeMillis() + paramBundle);
      initView();
      addIconOptionMenu(1, 2131689651, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38106);
          Object localObject = new Intent(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
          ((Intent)localObject).putExtra("mode", 1);
          ((Intent)localObject).putExtra("scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
          paramAnonymousMenuItem = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(38106);
          return true;
        }
      });
      bg.aVF();
      com.tencent.mm.model.c.aST().add(this.adapter);
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
      paramContextMenuInfo = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(this.talker);
      int i;
      if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 1, 0, 2131755552);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 3, 0, 2131758290);
        AppMethodBeat.o(38140);
        return;
        i = 0;
        break;
        label103:
        paramContextMenu.add(paramView.position, 2, 0, 2131755554);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38126);
      if (bg.aAc())
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(this.adapter);
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
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(this.talker);
      if ((localas == null) || ((int)localas.gMZ == 0))
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
        this.appBrandServiceActionSheet.OMW = this.mSceneId;
        this.appBrandServiceActionSheet.oDm = true;
        this.appBrandServiceActionSheet.show(3);
        AppMethodBeat.o(38139);
        return;
        this.appBrandServiceActionSheet.username = this.talker;
        this.appBrandServiceActionSheet.scene = this.fromScene;
        this.appBrandServiceActionSheet.OMW = this.mSceneId;
        this.appBrandServiceActionSheet.oDm = true;
        this.appBrandServiceActionSheet.show(4);
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
      bg.aVF();
      com.tencent.mm.model.c.aST().bka(this.superUsername);
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
    
    static final class a
      extends e
    {
      private IListener<op> PvR;
      private HashMap<String, Boolean> QaS;
      private HashMap<String, String> QaT;
      List<String> gMT;
      private Paint paint;
      private String username;
      
      a(Context paramContext, String paramString, s.a parama)
      {
        super(parama);
        AppMethodBeat.i(38120);
        this.paint = new Paint();
        this.username = paramString;
        this.QaS = new HashMap();
        this.QaT = new HashMap();
        this.gMT = new ArrayList();
        this.PvR = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.1(this);
        EventCenter.instance.addListener(this.PvR);
        AppMethodBeat.o(38120);
      }
      
      protected final void a(String paramString, e.g paramg)
      {
        AppMethodBeat.i(38122);
        Object localObject1 = (Boolean)this.QaS.get(paramString);
        boolean bool;
        if (localObject1 == null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString);
          if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
          {
            bool = true;
            this.QaS.put(paramString, localObject1);
            label68:
            if (!bool) {
              break label595;
            }
            paramg.PaH.setVisibility(0);
            paramg.PaH.setImageResource(2131689896);
            label90:
            localObject2 = (String)this.QaT.get(paramString);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = com.tencent.mm.ui.appbrand.e.blY(com.tencent.mm.ui.appbrand.e.blX(paramString));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                this.QaT.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label683;
            }
            paramg.Qcr.setVisibility(0);
            localObject1 = this.context.getString(2131755714, new Object[] { localObject1 });
            paramg.Qcr.setText((CharSequence)localObject1);
            if (this.context.getResources().getDisplayMetrics() == null) {
              break label719;
            }
          }
        }
        label262:
        label328:
        label719:
        for (int i = this.context.getResources().getDisplayMetrics().widthPixels;; i = 0)
        {
          int k;
          int j;
          float f1;
          label335:
          float f2;
          if (com.tencent.mm.cb.a.jk(this.context))
          {
            k = this.context.getResources().getDimensionPixelOffset(2131165527);
            j = this.context.getResources().getDimensionPixelOffset(2131165251);
            int m = this.context.getResources().getDimensionPixelOffset(2131165498);
            int n = this.context.getResources().getDimensionPixelOffset(2131165534);
            localObject1 = (e.d)this.Pax.get(paramString);
            if ((localObject1 == null) || (((e.d)localObject1).nickName == null)) {
              break label639;
            }
            localObject1 = ((e.d)localObject1).nickName.toString();
            if (localObject1 != null) {
              break label647;
            }
            f1 = 0.0F;
            f2 = 48.0F + f1;
            int i1 = this.context.getResources().getDimensionPixelOffset(2131165252);
            int i2 = this.context.getResources().getDimensionPixelOffset(2131165508);
            Log.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            f1 = 0.0F;
            if (i > 0) {
              f1 = i - k - m - n - j;
            }
            if ((f2 > f1) || (f2 >= f1) || (f1 <= 0.0F)) {
              break label671;
            }
            f1 = Math.min(f2 / f1, (f1 - i1 - i2 - 48.0F) / f1);
            f2 = 1.0F - f1;
            label474:
            localObject1 = (LinearLayout.LayoutParams)paramg.PaE.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f1;
            paramg.PaE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)paramg.Qcr.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f2;
            paramg.Qcr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          for (;;)
          {
            a.b.d(paramg.gvv, paramString);
            if (!this.gMT.contains(paramString)) {
              this.gMT.add(paramString);
            }
            AppMethodBeat.o(38122);
            return;
            bool = false;
            break;
            bool = ((Boolean)localObject1).booleanValue();
            break label68;
            label595:
            paramg.PaH.setVisibility(8);
            break label90;
            k = this.context.getResources().getDimensionPixelOffset(2131165528);
            j = this.context.getResources().getDimensionPixelOffset(2131165252);
            break label262;
            label639:
            localObject1 = "";
            break label328;
            this.paint.setTextSize(this.Pat);
            f1 = this.paint.measureText((String)localObject1);
            break label335;
            f2 = 0.4F;
            f1 = 0.6F;
            break label474;
            localObject1 = (LinearLayout.LayoutParams)paramg.PaE.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
            paramg.PaE.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      
      public final void anp()
      {
        AppMethodBeat.i(38121);
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aST().c(ab.iCL, this.gzY, this.username));
        if (this.OFI != null) {
          this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38121);
      }
      
      public final void detach()
      {
        AppMethodBeat.i(38123);
        this.QaS = null;
        EventCenter.instance.removeListener(this.PvR);
        AppMethodBeat.o(38123);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */