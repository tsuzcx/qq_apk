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
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.z;
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
    this.contentView = z.jO(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new AppBrandServiceConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
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
    implements n.e
  {
    private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
    private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
    private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
    private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
    private e adapter;
    private d appBrandServiceActionSheet;
    private ListView appbrandMessageLV;
    private l contextMenuHelper;
    private at conversation;
    private TextView emptyTipTv;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private String mAppId;
    private String mSceneId;
    private String superUsername;
    private String talker = "";
    private com.tencent.mm.ui.base.p tipDialog = null;
    
    private void asyncDelMsg(String paramString)
    {
      AppMethodBeat.i(38138);
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
      com.tencent.mm.model.ba.aBQ();
      Object localObject = com.tencent.mm.model.c.azs().apW(paramString);
      acy localacy = new acy();
      localacy.GbY = new cwt().aPy(bt.nullAsNil(paramString));
      localacy.xbt = ((ei)localObject).field_msgSvrId;
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(8, localacy));
      this.isDeleteCancel = false;
      localObject = thisActivity();
      getString(2131755906);
      localObject = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194628);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$902(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, true);
          AppMethodBeat.o(194628);
        }
      });
      customerMsgOperateReport(5);
      bj.a(paramString, new bj.a()
      {
        public final boolean YK()
        {
          AppMethodBeat.i(194629);
          boolean bool = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.isDeleteCancel;
          AppMethodBeat.o(194629);
          return bool;
        }
        
        public final void YL()
        {
          AppMethodBeat.i(194630);
          if (this.fNl != null) {
            this.fNl.dismiss();
          }
          AppMethodBeat.o(194630);
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
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "batchSyncForWxaContact, size:%d", new Object[] { Integer.valueOf(this.adapter.getCount()) });
      if ((this.adapter instanceof a))
      {
        List localList = ((a)this.adapter).gfd;
        if ((localList != null) && (localList.size() > 0)) {
          ((n)com.tencent.mm.kernel.g.ab(n.class)).bd(localList);
        }
      }
      AppMethodBeat.o(38129);
    }
    
    private void cleadAllServiceAppBrandUnreadCount()
    {
      AppMethodBeat.i(38125);
      com.tencent.mm.g.a.p localp = new com.tencent.mm.g.a.p();
      com.tencent.mm.sdk.b.a.IbL.l(localp);
      AppMethodBeat.o(38125);
    }
    
    private void delConversationAndMsg(String paramString)
    {
      AppMethodBeat.i(38137);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
        AppMethodBeat.o(38137);
        return;
      }
      asyncDelMsg(paramString);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().aTx(paramString);
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194627);
          ((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).c(null);
          AppMethodBeat.o(194627);
        }
      });
      AppMethodBeat.o(38137);
    }
    
    private void enterConversationReport()
    {
      AppMethodBeat.i(38131);
      if (this.adapter == null)
      {
        ad.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
        AppMethodBeat.o(38131);
        return;
      }
      com.tencent.mm.model.ba.aBQ();
      Object localObject1 = com.tencent.mm.model.c.azv().aTz("appbrandcustomerservicemsg");
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.g.c.ba)localObject1).field_username))) {}
      for (int j = ((com.tencent.mm.g.c.ba)localObject1).field_unReadCount;; j = 0)
      {
        localObject1 = (at)this.adapter.getItem(0);
        Object localObject2;
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.g.c.ba)localObject1).field_username)))
        {
          localObject2 = bt.nullAsNil(((com.tencent.mm.g.c.ba)localObject1).field_content);
          localObject1 = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt(((com.tencent.mm.g.c.ba)localObject1).field_username);
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
            localObject2 = (at)this.adapter.getItem(k);
            m = ((com.tencent.mm.g.c.ba)localObject2).field_unReadCount;
            if (((com.tencent.mm.g.c.ba)localObject2).field_unReadMuteCount + m <= 0) {
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
            ad.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[] { Integer.valueOf(13797), this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, localObject1 });
            com.tencent.mm.plugin.report.service.g.yhR.f(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(bt.aQJ()), Integer.valueOf(0), localObject1 });
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
      ad.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(paramInt), this.mAppId, this.mSceneId });
      com.tencent.mm.plugin.report.service.g.yhR.f(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bt.aQJ()) });
      AppMethodBeat.o(38132);
    }
    
    public void entryCustomerMsgDialogReport(String paramString, int paramInt)
    {
      AppMethodBeat.i(38133);
      com.tencent.mm.model.ba.aBQ();
      at localat = com.tencent.mm.model.c.azv().aTz(paramString);
      if (localat == null)
      {
        ad.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
        AppMethodBeat.o(38133);
        return;
      }
      int i = localat.field_unReadCount;
      paramString = bt.nullAsNil(this.mSceneId);
      ad.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.report.service.g.yhR.f(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(bt.aQJ()) });
      AppMethodBeat.o(38133);
    }
    
    public int getLayoutId()
    {
      return 2131495762;
    }
    
    public String getUserName()
    {
      return this.superUsername;
    }
    
    protected void initView()
    {
      AppMethodBeat.i(38134);
      setMMTitle(getString(2131755368));
      this.appbrandMessageLV = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131755397);
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
      this.adapter = new a(thisActivity(), this.superUsername, new r.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(38112);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount());
          AppMethodBeat.o(38112);
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
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
      this.contextMenuHelper = new l(thisActivity());
      this.appbrandMessageLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38115);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (at)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          paramAnonymousAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation;
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount()) });
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
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (at)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation.field_username);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.contextMenuHelper.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this);
          AppMethodBeat.o(38116);
          return true;
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
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
        public final void cP(Object paramAnonymousObject)
        {
          AppMethodBeat.i(38107);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
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
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
      super.onActivityCreated(paramBundle);
      this.superUsername = getStringExtra("Contact_User");
      if (TextUtils.isEmpty(this.superUsername)) {
        this.superUsername = "appbrandcustomerservicemsg";
      }
      this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      com.tencent.mm.model.ba.aBQ();
      paramBundle = intToString(com.tencent.mm.model.c.getUin());
      this.mSceneId = (System.currentTimeMillis() + paramBundle);
      initView();
      addIconOptionMenu(1, 2131689645, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38106);
          Object localObject = new Intent(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
          ((Intent)localObject).putExtra("mode", 1);
          ((Intent)localObject).putExtra("scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
          paramAnonymousMenuItem = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(38106);
          return true;
        }
      });
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().a(this.adapter);
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
      paramContextMenuInfo = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt(this.talker);
      int i;
      if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 1, 0, 2131755514);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 3, 0, 2131758038);
        AppMethodBeat.o(38140);
        return;
        i = 0;
        break;
        label103:
        paramContextMenu.add(paramView.position, 2, 0, 2131755516);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38126);
      if (com.tencent.mm.model.ba.ajx())
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().b(this.adapter);
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
      com.tencent.mm.model.ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(this.talker);
      if ((localam == null) || ((int)localam.gfj == 0))
      {
        ad.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.talker);
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
        this.appBrandServiceActionSheet.Jht = this.mSceneId;
        this.appBrandServiceActionSheet.nob = true;
        this.appBrandServiceActionSheet.show(3);
        AppMethodBeat.o(38139);
        return;
        this.appBrandServiceActionSheet.username = this.talker;
        this.appBrandServiceActionSheet.scene = this.fromScene;
        this.appBrandServiceActionSheet.Jht = this.mSceneId;
        this.appBrandServiceActionSheet.nob = true;
        this.appBrandServiceActionSheet.show(4);
        AppMethodBeat.o(38139);
        return;
        delConversationAndMsg(this.talker);
      }
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38128);
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().aTB(this.superUsername);
      if (this.adapter != null) {
        this.adapter.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38128);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38127);
      ad.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
      if (this.adapter != null) {
        this.adapter.onResume();
      }
      super.onResume();
      AppMethodBeat.o(38127);
    }
    
    static final class a
      extends e
    {
      private com.tencent.mm.sdk.b.c<nw> JOF;
      private HashMap<String, Boolean> Kry;
      private HashMap<String, String> Krz;
      List<String> gfd;
      private Paint paint;
      private String username;
      
      a(Context paramContext, String paramString, r.a parama)
      {
        super(parama);
        AppMethodBeat.i(38120);
        this.paint = new Paint();
        this.username = paramString;
        this.Kry = new HashMap();
        this.Krz = new HashMap();
        this.gfd = new ArrayList();
        this.JOF = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.1(this);
        com.tencent.mm.sdk.b.a.IbL.c(this.JOF);
        AppMethodBeat.o(38120);
      }
      
      public final void Zu()
      {
        AppMethodBeat.i(38121);
        com.tencent.mm.model.ba.aBQ();
        setCursor(com.tencent.mm.model.c.azv().c(w.hFj, this.fSL, this.username));
        if (this.JaF != null) {
          this.JaF.aSs();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38121);
      }
      
      protected final void a(String paramString, e.g paramg)
      {
        AppMethodBeat.i(38122);
        Object localObject1 = (Boolean)this.Kry.get(paramString);
        boolean bool;
        if (localObject1 == null)
        {
          Object localObject2 = ((n)com.tencent.mm.kernel.g.ab(n.class)).Nt(paramString);
          if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
          {
            bool = true;
            this.Kry.put(paramString, localObject1);
            label68:
            if (!bool) {
              break label598;
            }
            paramg.JuN.setVisibility(0);
            paramg.JuN.setImageResource(2131689881);
            label90:
            localObject2 = (String)this.Krz.get(paramString);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = com.tencent.mm.ui.appbrand.e.aVx(com.tencent.mm.ui.appbrand.e.aVw(paramString));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                this.Krz.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label686;
            }
            paramg.KsW.setVisibility(0);
            localObject1 = this.context.getString(2131755664, new Object[] { localObject1 });
            paramg.KsW.setText((CharSequence)localObject1);
            if (this.context.getResources().getDisplayMetrics() == null) {
              break label722;
            }
          }
        }
        label262:
        label328:
        label335:
        label722:
        for (int i = this.context.getResources().getDisplayMetrics().widthPixels;; i = 0)
        {
          int k;
          int j;
          float f1;
          float f2;
          if (com.tencent.mm.cc.a.im(this.context))
          {
            k = this.context.getResources().getDimensionPixelOffset(2131165509);
            j = this.context.getResources().getDimensionPixelOffset(2131165247);
            int m = this.context.getResources().getDimensionPixelOffset(2131165480);
            int n = this.context.getResources().getDimensionPixelOffset(2131165516);
            localObject1 = (e.d)this.JuD.get(paramString);
            if ((localObject1 == null) || (((e.d)localObject1).nickName == null)) {
              break label642;
            }
            localObject1 = ((e.d)localObject1).nickName.toString();
            if (localObject1 != null) {
              break label650;
            }
            f1 = 0.0F;
            f2 = 48.0F + f1;
            int i1 = this.context.getResources().getDimensionPixelOffset(2131165248);
            int i2 = this.context.getResources().getDimensionPixelOffset(2131165490);
            ad.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            f1 = 0.0F;
            if (i > 0) {
              f1 = i - k - m - n - j;
            }
            if ((f2 > f1) || (f2 >= f1) || (f1 <= 0.0F)) {
              break label674;
            }
            f1 = Math.min(f2 / f1, (f1 - i1 - i2 - 48.0F) / f1);
            f2 = 1.0F - f1;
            label477:
            localObject1 = (LinearLayout.LayoutParams)paramg.JuK.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f1;
            paramg.JuK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)paramg.KsW.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f2;
            paramg.KsW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          for (;;)
          {
            a.b.d(paramg.fOf, paramString);
            if (!this.gfd.contains(paramString)) {
              this.gfd.add(paramString);
            }
            AppMethodBeat.o(38122);
            return;
            bool = false;
            break;
            bool = ((Boolean)localObject1).booleanValue();
            break label68;
            label598:
            paramg.JuN.setVisibility(8);
            break label90;
            k = this.context.getResources().getDimensionPixelOffset(2131165510);
            j = this.context.getResources().getDimensionPixelOffset(2131165248);
            break label262;
            localObject1 = "";
            break label328;
            this.paint.setTextSize(this.Juz);
            f1 = this.paint.measureText((String)localObject1);
            break label335;
            f2 = 0.4F;
            f1 = 0.6F;
            break label477;
            localObject1 = (LinearLayout.LayoutParams)paramg.JuK.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
            paramg.JuK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      
      public final void detach()
      {
        AppMethodBeat.i(38123);
        this.Kry = null;
        com.tencent.mm.sdk.b.a.IbL.d(this.JOF);
        AppMethodBeat.o(38123);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */