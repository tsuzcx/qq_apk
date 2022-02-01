package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.qz;
import com.tencent.mm.autogen.a.t;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x.a;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    this.contentView = af.mU(this).inflate(R.i.geL, null);
    setContentView(this.contentView);
    this.conversationFm = new AppBrandServiceConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(R.h.fOk, this.conversationFm).FW();
    com.tencent.mm.pluginsdk.h.b(this, this.contentView);
    AppMethodBeat.o(38143);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class AppBrandServiceConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements u.i
  {
    private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
    private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
    private static final int CONTEXT_MENU_LONGCLICK_DISMISS = 4;
    private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
    private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
    private g adapter;
    private com.tencent.mm.ui.appbrand.d appBrandServiceActionSheet;
    private ListView appbrandMessageLV;
    private l contextMenuHelper;
    private bb conversation;
    private TextView emptyTipTv;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private String mAppId;
    private String mSceneId;
    private String superUsername;
    private String talker = "";
    private w tipDialog = null;
    
    private void asyncDelMsg(String paramString)
    {
      AppMethodBeat.i(38138);
      Log.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
      bh.bCz();
      Object localObject = c.bzD().aLF(paramString);
      aig localaig = new aig();
      localaig.ZqL = new etl().btH(Util.nullAsNil(paramString));
      localaig.Njv = ((fi)localObject).field_msgSvrId;
      bh.bCz();
      c.bzz().d(new k.a(8, localaig));
      this.isDeleteCancel = false;
      localObject = thisActivity();
      getString(R.l.app_tip);
      localObject = k.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(256728);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$902(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, true);
          AppMethodBeat.o(256728);
        }
      });
      customerMsgOperateReport(5);
      br.a(paramString, new br.a()
      {
        public final boolean aMJ()
        {
          AppMethodBeat.i(256726);
          boolean bool = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.isDeleteCancel;
          AppMethodBeat.o(256726);
          return bool;
        }
        
        public final void aMK()
        {
          AppMethodBeat.i(256729);
          if (this.lAK != null) {
            this.lAK.dismiss();
          }
          AppMethodBeat.o(256729);
        }
      });
      ac.aY(paramString, 15);
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
        List localList = ((a)this.adapter).maB;
        if ((localList != null) && (localList.size() > 0)) {
          ((s)com.tencent.mm.kernel.h.ax(s.class)).cZ(localList);
        }
      }
      AppMethodBeat.o(38129);
    }
    
    private void cleadAllServiceAppBrandUnreadCount()
    {
      AppMethodBeat.i(38125);
      new t().publish();
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
      bh.bCz();
      c.bzG().bxK(paramString);
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256727);
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.f.class)).e(null);
          AppMethodBeat.o(256727);
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
      bh.bCz();
      Object localObject1 = c.bzG().bxM("appbrandcustomerservicemsg");
      if ((localObject1 != null) && (!Util.isNullOrNil(((bd)localObject1).field_username))) {}
      for (int j = ((bd)localObject1).field_unReadCount;; j = 0)
      {
        localObject1 = (bb)this.adapter.getItem(0);
        Object localObject2;
        if ((localObject1 != null) && (!Util.isNullOrNil(((bd)localObject1).field_username)))
        {
          localObject2 = Util.nullAsNil(((bd)localObject1).field_content);
          localObject1 = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(((bd)localObject1).field_username);
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
            localObject2 = (bb)this.adapter.getItem(k);
            m = ((bd)localObject2).field_unReadCount;
            if (((bd)localObject2).field_unReadMuteCount + m <= 0) {
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
            com.tencent.mm.plugin.report.service.h.OAn.b(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(Util.nowSecond()), Integer.valueOf(0), localObject1 });
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
      com.tencent.mm.plugin.report.service.h.OAn.b(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(Util.nowSecond()) });
      AppMethodBeat.o(38132);
    }
    
    public void entryCustomerMsgDialogReport(String paramString, int paramInt)
    {
      AppMethodBeat.i(38133);
      bh.bCz();
      bb localbb = c.bzG().bxM(paramString);
      if (localbb == null)
      {
        Log.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
        AppMethodBeat.o(38133);
        return;
      }
      int i = localbb.field_unReadCount;
      paramString = Util.nullAsNil(this.mSceneId);
      Log.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.report.service.h.OAn.b(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(Util.nowSecond()) });
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
      setMMTitle(getString(R.l.grm));
      this.appbrandMessageLV = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.grn);
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
      this.adapter = new a(thisActivity(), this.superUsername, new x.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(38112);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount());
          AppMethodBeat.o(38112);
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(38113);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38113);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
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
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousAdapterView);
          ((b)localObject).cH(paramAnonymousView);
          ((b)localObject).sc(paramAnonymousInt);
          ((b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (bb)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
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
          localObject = com.tencent.mm.plugin.appbrand.config.g.qWE;
          if (!com.tencent.mm.plugin.appbrand.config.g.ckz()) {
            paramAnonymousView.putBoolean("key_need_send_video", false);
          }
          paramAnonymousView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
          paramAnonymousView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene);
          paramAnonymousView.putInt("app_brand_chatting_from_scene_new", 3);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38115);
        }
      });
      this.appbrandMessageLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(38116);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$402(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, (bb)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getItem(paramAnonymousInt));
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$502(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.conversation.field_username);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.contextMenuHelper.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this);
          AppMethodBeat.o(38116);
          return true;
        }
      });
      this.adapter.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(38117);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(paramAnonymousView);
          AppMethodBeat.o(38117);
          return i;
        }
      });
      this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38118);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(38118);
        }
      });
      this.adapter.a(new MMSlideDelView.f()
      {
        public final void es(Object paramAnonymousObject)
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
      bh.bCz();
      paramBundle = intToString(c.getUin());
      this.mSceneId = (System.currentTimeMillis() + paramBundle);
      initView();
      addIconOptionMenu(1, R.l.actionbar_setting, R.k.app_brand_setting, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38106);
          Object localObject = new Intent(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
          ((Intent)localObject).putExtra("mode", 1);
          ((Intent)localObject).putExtra("scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.mSceneId);
          paramAnonymousMenuItem = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(38106);
          return true;
        }
      });
      bh.bCz();
      c.bzG().add(this.adapter);
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
      paramContextMenuInfo = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(this.talker);
      int i;
      if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 1, 0, R.l.gro);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 3, 0, R.l.gEg);
        AppMethodBeat.o(38140);
        return;
        i = 0;
        break;
        label103:
        paramContextMenu.add(paramView.position, 2, 0, R.l.grp);
      }
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38126);
      if (bh.baz())
      {
        bh.bCz();
        c.bzG().remove(this.adapter);
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
      bh.bCz();
      au localau = c.bzA().JE(this.talker);
      if ((localau == null) || ((int)localau.maN == 0))
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
        this.appBrandServiceActionSheet.xIc = this.mSceneId;
        this.appBrandServiceActionSheet.uQq = true;
        this.appBrandServiceActionSheet.Dk(3);
        AppMethodBeat.o(38139);
        return;
        this.appBrandServiceActionSheet.username = this.talker;
        this.appBrandServiceActionSheet.scene = this.fromScene;
        this.appBrandServiceActionSheet.xIc = this.mSceneId;
        this.appBrandServiceActionSheet.uQq = true;
        this.appBrandServiceActionSheet.Dk(4);
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
      bh.bCz();
      c.bzG().bxO(this.superUsername);
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
      extends g
    {
      private IListener<qz> aezD;
      private HashMap<String, Boolean> aflJ;
      private HashMap<String, String> aflK;
      List<String> maB;
      private Paint paint;
      private String username;
      
      a(Context paramContext, String paramString, x.a parama)
      {
        super(parama);
        AppMethodBeat.i(38120);
        this.paint = new Paint();
        this.username = paramString;
        this.aflJ = new HashMap();
        this.aflK = new HashMap();
        this.maB = new ArrayList();
        this.aezD = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.AppBrandConversationAdapter.1(this, com.tencent.mm.app.f.hfK);
        this.aezD.alive();
        AppMethodBeat.o(38120);
      }
      
      protected final void a(String paramString, final g.g paramg)
      {
        AppMethodBeat.i(38122);
        Object localObject1 = (Boolean)this.aflJ.get(paramString);
        Object localObject2;
        boolean bool;
        label68:
        final int j;
        int m;
        int n;
        final int i;
        int k;
        label275:
        float f1;
        label330:
        float f2;
        label357:
        float f4;
        int i1;
        int i2;
        if (localObject1 == null)
        {
          localObject2 = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramString);
          if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
          {
            bool = true;
            this.aflJ.put(paramString, localObject1);
            localObject2 = (String)this.aflK.get(paramString);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = e.bzV(e.bzU(paramString));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                this.aflK.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1072;
            }
            paramg.afno.setVisibility(0);
            localObject1 = this.context.getString(R.l.grA, new Object[] { localObject1 });
            paramg.afno.setText((CharSequence)localObject1);
            j = 0;
            if (this.context.getResources().getDisplayMetrics() != null) {
              j = this.context.getResources().getDisplayMetrics().widthPixels;
            }
            m = paramg.aebk.getLayoutParams().width;
            if (!com.tencent.mm.cd.a.mp(this.context)) {
              break label932;
            }
            n = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapLargeSize);
            i = m;
            k = n;
            if (m < 0)
            {
              i = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallWidth);
              k = n;
            }
            m = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
            n = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
            localObject1 = bCe(paramString);
            localObject2 = paramg.aebj;
            if ((localObject2 != null) && (localObject1 != null)) {
              break label982;
            }
            f1 = 0.0F;
            f2 = 48.0F + f1;
            localObject2 = paramg.aebj;
            if ((localObject2 != null) && (!Util.isNullOrNil((String)localObject1))) {
              break label996;
            }
            f1 = 0.0F;
            f4 = (int)Math.min(f2, f1 + 48.0F);
            Log.i("MicroMsg.ConversationAdapter", "nickNameMinWidth:%f", new Object[] { Float.valueOf(f4) });
            i1 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
            i2 = this.context.getResources().getDimensionPixelOffset(R.f.LittlePadding);
            Log.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
            if (j <= 0) {
              break label1207;
            }
          }
        }
        label527:
        label932:
        label1072:
        label1204:
        label1207:
        for (float f3 = j - k - m * 2 - i - n - i2;; f3 = 0.0F)
        {
          if ((f2 <= f3) && (f2 < f3) && (f3 > 0.0F))
          {
            f1 = Math.min(f2 / f3, (f3 - i1) / f3);
            f2 = 1.0F - f1;
            Log.i("MicroMsg.ConversationAdapter", "nickNameParentRemainWidth: %f, nicknameTVWeight:%f, sourceTVWeight:%f", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Float.valueOf(f2) });
            if (f3 <= 0.0F) {
              break label1204;
            }
            f4 = Math.min(1.0F, f4 / f3);
            if (f4 <= f1) {
              break label1204;
            }
            f2 = 1.0F - f4;
            f1 = f4;
          }
          for (;;)
          {
            Log.i("MicroMsg.ConversationAdapter", "weight fixed, nicknameTVWeight:%f, sourceTVWeight:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
            if (WeChatEnvironment.hasDebugger())
            {
              i = (int)(i2 + f3);
              j = (int)(f1 * f3);
              paramg.aebj.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(256714);
                  ViewParent localViewParent = paramg.aebj.getParent();
                  if ((localViewParent instanceof View)) {}
                  for (int i = ((View)localViewParent).getWidth();; i = 0)
                  {
                    Log.i("MicroMsg.ConversationAdapter", "expected nicknameParent width: %d, nicknameParent width:%d, expected nickname width: %d, nickname width:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramg.aebj.getWidth()) });
                    AppMethodBeat.o(256714);
                    return;
                  }
                }
              });
            }
            localObject1 = (LinearLayout.LayoutParams)paramg.aebj.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f1;
            paramg.aebj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)paramg.afno.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f2;
            paramg.afno.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            label733:
            if (bool)
            {
              paramg.aebm.setVisibility(0);
              localObject1 = paramg.aebm;
              if (aw.isDarkMode())
              {
                i = R.k.chat_reject_title_icon;
                label763:
                ((ImageView)localObject1).setImageResource(i);
                if (paramg.afno.getVisibility() != 0) {
                  break label1116;
                }
                localObject1 = paramg.aebj.getText() + ", " + paramg.afno.getText() + ", " + paramg.aebk.getText() + ", " + paramg.aebl.getText() + ", " + this.context.getString(R.l.grp);
                label869:
                paramg.TJN.setContentDescription((CharSequence)localObject1);
              }
            }
            for (;;)
            {
              a.b.h(paramg.lBC, paramString);
              if (!this.maB.contains(paramString)) {
                this.maB.add(paramString);
              }
              AppMethodBeat.o(38122);
              return;
              bool = false;
              break;
              bool = ((Boolean)localObject1).booleanValue();
              break label68;
              n = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapSize);
              i = m;
              k = n;
              if (m >= 0) {
                break label275;
              }
              i = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
              k = n;
              break label275;
              label982:
              f1 = ((NoMeasuredTextView)localObject2).getPaint().measureText((String)localObject1);
              break label330;
              label996:
              localObject1 = ((String)localObject1).substring(0, ((String)localObject1).offsetByCodePoints(0, 1)) + "…";
              Log.i("MicroMsg.ConversationAdapter", "getMinTextWidth, minText: ".concat(String.valueOf(localObject1)));
              f1 = ((NoMeasuredTextView)localObject2).getPaint().measureText((String)localObject1);
              break label357;
              f1 = 0.6F;
              f2 = 0.4F;
              break label527;
              localObject1 = (LinearLayout.LayoutParams)paramg.aebj.getLayoutParams();
              ((LinearLayout.LayoutParams)localObject1).width = -1;
              ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
              paramg.aebj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              break label733;
              i = R.k.chat_reject_icon;
              break label763;
              label1116:
              localObject1 = paramg.aebj.getText() + ", " + paramg.aebk.getText() + ", " + paramg.aebl.getText() + ", " + this.context.getString(R.l.grp);
              break label869;
              paramg.aebm.setVisibility(8);
            }
          }
        }
      }
      
      public final void aNy()
      {
        AppMethodBeat.i(38121);
        bh.bCz();
        w(c.bzG().a(4, this.lMF, this.username));
        if (this.adDx != null) {
          this.adDx.bWC();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38121);
      }
      
      public final void detach()
      {
        AppMethodBeat.i(38123);
        this.aflJ = null;
        this.aezD.dead();
        AppMethodBeat.o(38123);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */