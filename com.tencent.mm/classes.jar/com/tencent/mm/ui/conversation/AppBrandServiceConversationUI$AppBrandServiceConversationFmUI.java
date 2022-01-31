package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.tools.l;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
  implements n.d
{
  private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
  private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
  private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
  private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
  private e adapter;
  private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
  private ListView appbrandMessageLV;
  private l contextMenuHelper;
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
    AppMethodBeat.i(34018);
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().Tl(paramString);
    wu localwu = new wu();
    localwu.wOT = new bwc().aoF(bo.nullAsNil(paramString));
    localwu.pIG = ((dd)localObject).field_msgSvrId;
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new j.a(8, localwu));
    this.isDeleteCancel = false;
    localObject = thisActivity();
    getString(2131297087);
    localObject = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131297112), true, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.3(this));
    customerMsgOperateReport(5);
    bf.a(paramString, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.4(this, (ProgressDialog)localObject));
    AppMethodBeat.o(34018);
  }
  
  private void batchSyncForWxaContact()
  {
    AppMethodBeat.i(34009);
    if ((this.adapter == null) || (this.adapter.getCount() == 0))
    {
      AppMethodBeat.o(34009);
      return;
    }
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "batchSyncForWxaContact, size:%d", new Object[] { Integer.valueOf(this.adapter.getCount()) });
    if ((this.adapter instanceof a))
    {
      List localList = ((a)this.adapter).euz;
      if ((localList != null) && (localList.size() > 0)) {
        ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).aC(localList);
      }
    }
    AppMethodBeat.o(34009);
  }
  
  private void cleadAllServiceAppBrandUnreadCount()
  {
    AppMethodBeat.i(34005);
    o localo = new o();
    com.tencent.mm.sdk.b.a.ymk.l(localo);
    AppMethodBeat.o(34005);
  }
  
  private void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(34017);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(34017);
      return;
    }
    asyncDelMsg(paramString);
    aw.aaz();
    com.tencent.mm.model.c.YF().arF(paramString);
    AppMethodBeat.o(34017);
  }
  
  private void enterConversationReport()
  {
    AppMethodBeat.i(34011);
    if (this.adapter == null)
    {
      ab.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
      AppMethodBeat.o(34011);
      return;
    }
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.YF().arH("appbrandcustomerservicemsg");
    if ((localObject1 != null) && (!bo.isNullOrNil(((au)localObject1).field_username))) {}
    for (int j = ((au)localObject1).field_unReadCount;; j = 0)
    {
      localObject1 = (ak)this.adapter.getItem(0);
      Object localObject2;
      if ((localObject1 != null) && (!bo.isNullOrNil(((au)localObject1).field_username)))
      {
        localObject2 = bo.nullAsNil(((au)localObject1).field_content);
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(((au)localObject1).field_username);
        if (localObject1 == null)
        {
          localObject1 = null;
          this.mAppId = ((String)localObject1);
        }
      }
      for (localObject1 = localObject2;; localObject1 = "")
      {
        int k;
        label161:
        int m;
        if (j > 0)
        {
          int n = this.adapter.getCount();
          k = 0;
          int i = 0;
          m = i;
          if (k >= n) {
            break label225;
          }
          localObject2 = (ak)this.adapter.getItem(k);
          m = ((au)localObject2).field_unReadCount;
          if (((au)localObject2).field_unReadMuteCount + m <= 0) {
            break label353;
          }
          i += 1;
        }
        label353:
        for (;;)
        {
          k += 1;
          break label161;
          localObject1 = ((WxaAttributes)localObject1).field_appId;
          break;
          m = 0;
          label225:
          ab.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[] { Integer.valueOf(13797), this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, localObject1 });
          com.tencent.mm.plugin.report.service.h.qsU.e(13797, new Object[] { this.mSceneId, Integer.valueOf(j), Integer.valueOf(m), this.mAppId, Long.valueOf(bo.aox()), Integer.valueOf(0), localObject1 });
          AppMethodBeat.o(34011);
          return;
        }
      }
    }
  }
  
  private String intToString(int paramInt)
  {
    AppMethodBeat.i(34010);
    String str = new BigInteger(Integer.toBinaryString(paramInt), 2).toString();
    AppMethodBeat.o(34010);
    return str;
  }
  
  private void setShowView(int paramInt)
  {
    AppMethodBeat.i(34016);
    if (paramInt <= 0)
    {
      this.emptyTipTv.setVisibility(0);
      this.appbrandMessageLV.setVisibility(8);
      AppMethodBeat.o(34016);
      return;
    }
    this.emptyTipTv.setVisibility(8);
    this.appbrandMessageLV.setVisibility(0);
    AppMethodBeat.o(34016);
  }
  
  public void customerMsgOperateReport(int paramInt)
  {
    AppMethodBeat.i(34012);
    ab.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(paramInt), this.mAppId, this.mSceneId });
    com.tencent.mm.plugin.report.service.h.qsU.e(13798, new Object[] { Integer.valueOf(paramInt), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bo.aox()) });
    AppMethodBeat.o(34012);
  }
  
  public void entryCustomerMsgDialogReport(String paramString, int paramInt)
  {
    AppMethodBeat.i(34013);
    aw.aaz();
    ak localak = com.tencent.mm.model.c.YF().arH(paramString);
    if (localak == null)
    {
      ab.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramString });
      AppMethodBeat.o(34013);
      return;
    }
    int i = localak.field_unReadCount;
    paramString = bo.nullAsNil(this.mSceneId);
    ab.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
    com.tencent.mm.plugin.report.service.h.qsU.e(13799, new Object[] { this.mAppId, Integer.valueOf(paramInt), Integer.valueOf(i), paramString, Long.valueOf(bo.aox()) });
    AppMethodBeat.o(34013);
  }
  
  public int getLayoutId()
  {
    return 2130971000;
  }
  
  public String getUserName()
  {
    return this.superUsername;
  }
  
  protected void initView()
  {
    AppMethodBeat.i(34014);
    setMMTitle(getString(2131296602));
    this.appbrandMessageLV = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131296627);
    setBackBtn(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.5(this));
    this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(thisActivity());
    this.adapter = new a(thisActivity(), this.superUsername, new p.a()
    {
      public final void apT()
      {
        AppMethodBeat.i(33991);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.adapter.getCount());
        AppMethodBeat.o(33991);
      }
    });
    this.adapter.setGetViewPositionCallback(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.7(this));
    this.adapter.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(33993);
        AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(33993);
      }
    });
    this.appbrandMessageLV.setAdapter(this.adapter);
    this.contextMenuHelper = new l(thisActivity());
    this.appbrandMessageLV.setOnItemClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.9(this));
    this.appbrandMessageLV.setOnItemLongClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.10(this));
    this.adapter.setGetViewPositionCallback(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.11(this));
    this.adapter.setPerformItemClickListener(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.12(this));
    this.adapter.a(new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.2(this));
    AppMethodBeat.o(34014);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(34004);
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    this.superUsername = getStringExtra("Contact_User");
    if (TextUtils.isEmpty(this.superUsername)) {
      this.superUsername = "appbrandcustomerservicemsg";
    }
    this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    aw.aaz();
    paramBundle = intToString(com.tencent.mm.model.c.getUin());
    this.mSceneId = (System.currentTimeMillis() + paramBundle);
    initView();
    addIconOptionMenu(1, 2131230884, new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.1(this));
    aw.aaz();
    com.tencent.mm.model.c.YF().a(this.adapter);
    cleadAllServiceAppBrandUnreadCount();
    enterConversationReport();
    batchSyncForWxaContact();
    AppMethodBeat.o(34004);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34015);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34015);
      return;
    }
    AppMethodBeat.o(34015);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(34020);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(this.talker);
    int i;
    if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
      paramContextMenu.add(paramView.position, 1, 0, 2131296732);
    }
    for (;;)
    {
      paramContextMenu.add(paramView.position, 3, 0, 2131298950);
      AppMethodBeat.o(34020);
      return;
      i = 0;
      break;
      label102:
      paramContextMenu.add(paramView.position, 2, 0, 2131296733);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34006);
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this.adapter);
    }
    batchSyncForWxaContact();
    if (this.adapter != null) {
      this.adapter.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(34006);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34019);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(this.talker);
    if ((localad == null) || ((int)localad.euF == 0))
    {
      ab.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.talker);
      AppMethodBeat.o(34019);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34019);
      return;
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.zgj = this.mSceneId;
      this.appBrandServiceActionSheet.jvs = true;
      this.appBrandServiceActionSheet.show(3);
      AppMethodBeat.o(34019);
      return;
      this.appBrandServiceActionSheet.username = this.talker;
      this.appBrandServiceActionSheet.scene = this.fromScene;
      this.appBrandServiceActionSheet.zgj = this.mSceneId;
      this.appBrandServiceActionSheet.jvs = true;
      this.appBrandServiceActionSheet.show(4);
      AppMethodBeat.o(34019);
      return;
      delConversationAndMsg(this.talker);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34008);
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
    aw.aaz();
    com.tencent.mm.model.c.YF().arJ(this.superUsername);
    if (this.adapter != null) {
      this.adapter.onPause();
    }
    super.onPause();
    AppMethodBeat.o(34008);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34007);
    ab.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
    if (this.adapter != null) {
      this.adapter.onResume();
    }
    super.onResume();
    AppMethodBeat.o(34007);
  }
  
  static final class a
    extends e
  {
    private HashMap<String, Boolean> AgC;
    private HashMap<String, String> AgD;
    List<String> euz;
    private Paint paint;
    private String username;
    private com.tencent.mm.sdk.b.c<lt> zJp;
    
    a(Context paramContext, String paramString, p.a parama)
    {
      super(parama);
      AppMethodBeat.i(34000);
      this.paint = new Paint();
      this.username = paramString;
      this.AgC = new HashMap();
      this.AgD = new HashMap();
      this.euz = new ArrayList();
      this.zJp = new AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.a.1(this);
      com.tencent.mm.sdk.b.a.ymk.c(this.zJp);
      AppMethodBeat.o(34000);
    }
    
    public final void Ku()
    {
      AppMethodBeat.i(34001);
      aw.aaz();
      setCursor(com.tencent.mm.model.c.YF().c(t.fli, this.ejc, this.username));
      if (this.zaq != null) {
        this.zaq.apT();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(34001);
    }
    
    protected final void a(String paramString, e.g paramg)
    {
      AppMethodBeat.i(34002);
      Object localObject1 = (Boolean)this.AgC.get(paramString);
      boolean bool;
      if (localObject1 == null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.appbrand.service.i)g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(paramString);
        if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
        {
          bool = true;
          this.AgC.put(paramString, localObject1);
          label68:
          if (!bool) {
            break label598;
          }
          paramg.ztl.setVisibility(0);
          paramg.ztl.setImageResource(2131231090);
          label90:
          localObject2 = (String)this.AgD.get(paramString);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = b.att(b.ats(paramString));
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              this.AgD.put(paramString, localObject2);
              localObject1 = localObject2;
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label686;
          }
          paramg.Aii.setVisibility(0);
          localObject1 = this.context.getString(2131296864, new Object[] { localObject1 });
          paramg.Aii.setText((CharSequence)localObject1);
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
        if (com.tencent.mm.cb.a.gt(this.context))
        {
          k = this.context.getResources().getDimensionPixelOffset(2131427801);
          j = this.context.getResources().getDimensionPixelOffset(2131427554);
          int m = this.context.getResources().getDimensionPixelOffset(2131427772);
          int n = this.context.getResources().getDimensionPixelOffset(2131427808);
          localObject1 = (e.d)this.zte.get(paramString);
          if ((localObject1 == null) || (((e.d)localObject1).nickName == null)) {
            break label642;
          }
          localObject1 = ((e.d)localObject1).nickName.toString();
          if (localObject1 != null) {
            break label650;
          }
          f1 = 0.0F;
          f2 = 48.0F + f1;
          int i1 = this.context.getResources().getDimensionPixelOffset(2131427555);
          int i2 = this.context.getResources().getDimensionPixelOffset(2131427782);
          ab.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
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
          localObject1 = (LinearLayout.LayoutParams)paramg.zti.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).width = 0;
          ((LinearLayout.LayoutParams)localObject1).weight = f1;
          paramg.zti.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = (LinearLayout.LayoutParams)paramg.Aii.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).width = 0;
          ((LinearLayout.LayoutParams)localObject1).weight = f2;
          paramg.Aii.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        for (;;)
        {
          a.b.s(paramg.egq, paramString);
          if (!this.euz.contains(paramString)) {
            this.euz.add(paramString);
          }
          AppMethodBeat.o(34002);
          return;
          bool = false;
          break;
          bool = ((Boolean)localObject1).booleanValue();
          break label68;
          label598:
          paramg.ztl.setVisibility(8);
          break label90;
          k = this.context.getResources().getDimensionPixelOffset(2131427802);
          j = this.context.getResources().getDimensionPixelOffset(2131427555);
          break label262;
          localObject1 = "";
          break label328;
          this.paint.setTextSize(this.ztb);
          f1 = this.paint.measureText((String)localObject1);
          break label335;
          f2 = 0.4F;
          f1 = 0.6F;
          break label477;
          localObject1 = (LinearLayout.LayoutParams)paramg.zti.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).width = -1;
          ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
          paramg.zti.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
      }
    }
    
    public final void detach()
    {
      AppMethodBeat.i(34003);
      this.AgC = null;
      com.tencent.mm.sdk.b.a.ymk.d(this.zJp);
      AppMethodBeat.o(34003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI
 * JD-Core Version:    0.7.0.1
 */