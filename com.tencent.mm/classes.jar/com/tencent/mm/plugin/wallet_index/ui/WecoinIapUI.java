package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.wallet_core.model.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "DEFAULT", "", "DEFAULT_PAT_TYPE_WECOIN", "FAILED", "OK", "ORDER", "PAYMENT", "REMEDY", "SCENECOUNT", "SHIP", "USERCANCEL", "mCurrentScene", "mCurrentState", "mIapData", "Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapData;", "mLoadingDialog", "Landroid/app/Dialog;", "mNetSceneCallback", "Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapUI$NetCallback;", "mPayConfirmDialog", "Lcom/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog;", "mPreChecking", "", "mRecharging", "mWeakSelf", "Ljava/lang/ref/WeakReference;", "checkAndPrepare", "", "clearListener", "consumeWecoin", "consumeWeCoinBuffer", "", "dismissPayDialog", "finish", "getLayoutId", "hideLoadingDialog", "makeTranslucent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onHandleIntent", "onResume", "onStop", "payFailed", "result", "Lcom/tencent/mm/plugin/wallet_index/model/IapResult;", "response_position", "payFinished", "iapData", "preCheck", "showLoadingDialog", "Companion", "NetCallback", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WecoinIapUI
  extends MMActivity
{
  public static final WecoinIapUI.a Wcd;
  private final int DEFAULT;
  private final int FAILED;
  private final int OK;
  private final int WbL;
  private final int WbM;
  private final int WbN;
  private final int WbO;
  private final int WbP;
  private final int WbQ;
  private f Wce;
  private int Wcf;
  private boolean Wcg;
  private boolean Wch;
  private com.tencent.mm.plugin.emoji.ui.widget.b Wci;
  private WeakReference<WecoinIapUI> Wcj;
  private b Wck;
  private int sEu;
  private Dialog ums;
  private int zRs;
  
  static
  {
    AppMethodBeat.i(263652);
    Wcd = new WecoinIapUI.a((byte)0);
    AppMethodBeat.o(263652);
  }
  
  public WecoinIapUI()
  {
    AppMethodBeat.i(263554);
    this.Wcf = 6;
    this.WbL = 4;
    this.WbN = 1;
    this.WbO = 2;
    this.WbP = 3;
    this.zRs = this.WbM;
    this.OK = 1000;
    this.WbQ = 1001;
    this.FAILED = 1002;
    this.DEFAULT = 1003;
    this.sEu = this.DEFAULT;
    this.Wcg = true;
    AppMethodBeat.o(263554);
  }
  
  private final void a(com.tencent.mm.plugin.wallet_index.model.c paramc, int paramInt)
  {
    AppMethodBeat.i(263561);
    if (paramc.mResponse == 1) {}
    for (this.sEu = this.WbQ;; this.sEu = this.FAILED)
    {
      Log.i("MicroMsg.WecoinIapUI", kotlin.g.b.s.X("Consume failed: ", Integer.valueOf(paramc.mResponse)));
      Intent localIntent = new Intent();
      localIntent.putExtra("key_err_code", paramc.mResponse);
      localIntent.putExtra("key_err_msg", paramc.mMessage);
      if (paramInt != -1) {
        localIntent.putExtra("key_response_position", paramInt);
      }
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(263561);
      return;
    }
  }
  
  private static final void a(WecoinIapUI paramWecoinIapUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(263583);
    kotlin.g.b.s.u(paramWecoinIapUI, "this$0");
    Log.i("MicroMsg.WecoinIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(paramWecoinIapUI.zRs) });
    if (paramWecoinIapUI.zRs == paramWecoinIapUI.WbO)
    {
      paramDialogInterface = com.tencent.mm.plugin.wallet_index.model.c.dA(7, "");
      kotlin.g.b.s.s(paramDialogInterface, "{\n                IapRes…ANCEL_SHIP)\n            }");
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_err_code", paramDialogInterface.mResponse);
      localIntent.putExtra("key_err_msg", paramDialogInterface.mMessage);
      paramWecoinIapUI.setResult(-1, localIntent);
      paramWecoinIapUI.finish();
      AppMethodBeat.o(263583);
      return;
      paramDialogInterface = com.tencent.mm.plugin.wallet_index.model.c.dA(1, "");
      kotlin.g.b.s.s(paramDialogInterface, "{\n                IapRes…SER_CANCEL)\n            }");
    }
  }
  
  private final void bWh()
  {
    int i = 1;
    AppMethodBeat.i(263576);
    Log.i("MicroMsg.WecoinIapUI", "hideLoadingDialog!");
    Dialog localDialog;
    if (this.ums != null)
    {
      localDialog = this.ums;
      if ((localDialog == null) || (localDialog.isShowing() != true)) {
        break label69;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localDialog = this.ums;
        if (localDialog != null) {
          localDialog.dismiss();
        }
        this.ums = null;
      }
      AppMethodBeat.o(263576);
      return;
      label69:
      i = 0;
    }
  }
  
  private final void showLoadingDialog()
  {
    AppMethodBeat.i(263572);
    Log.i("MicroMsg.WecoinIapUI", "showLoadingDialog!");
    WecoinIapUI..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new WecoinIapUI..ExternalSyntheticLambda0(this);
    this.ums = ((Dialog)com.tencent.mm.ui.base.w.a((Context)this, (CharSequence)getString(a.i.app_waiting), true, 0, localExternalSyntheticLambda0));
    AppMethodBeat.o(263572);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(263681);
    Log.i("MicroMsg.WecoinIapUI", "finish");
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(263681);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263665);
    super.onCreate(paramBundle);
    this.Wcj = new WeakReference(this);
    this.Wck = new b(this.Wcj);
    overridePendingTransition(0, 0);
    getWindow().addFlags(-2147483648);
    getWindow().setStatusBarColor(0);
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    Object localObject2 = com.tencent.mm.kernel.h.baD().mCm;
    Object localObject1 = this.Wck;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mNetSceneCallback");
      paramBundle = null;
    }
    ((com.tencent.mm.am.s)localObject2).a(422, (com.tencent.mm.am.h)paramBundle);
    localObject2 = com.tencent.mm.kernel.h.baD().mCm;
    localObject1 = this.Wck;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mNetSceneCallback");
      paramBundle = null;
    }
    ((com.tencent.mm.am.s)localObject2).a(414, (com.tencent.mm.am.h)paramBundle);
    this.Wce = new f();
    Log.i("MicroMsg.WecoinIapUI", "onHandleIntent");
    localObject2 = getIntent();
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    f localf = this.Wce;
    if (localf != null)
    {
      localObject1 = ((Intent)localObject2).getStringExtra("key_product_id");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      kotlin.g.b.s.u(paramBundle, "productId");
      localf.xOk = paramBundle;
      localf.Wbf.add(paramBundle);
      Log.i("MicroMsg.WecoinIapData", kotlin.g.b.s.X("prepare pay product: ", paramBundle));
      localf.Wah = ((Intent)localObject2).getStringExtra("key_price");
      localf.mCount = ((Intent)localObject2).getIntExtra("key_count", 1);
      localf.Wag = ((Intent)localObject2).getStringExtra("key_currency_type");
      localObject1 = ((Intent)localObject2).getStringExtra("key_desc");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      localf.ydi = paramBundle;
      localf.MGo = ((Intent)localObject2).getIntExtra("key_pay_type", this.Wcf);
    }
    AppMethodBeat.o(263665);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(263677);
    Log.i("MicroMsg.WecoinIapUI", "onDestroy");
    bWh();
    Log.i("MicroMsg.WecoinIapUI", "Dismiss PayConfirmDialog!");
    Object localObject1 = this.Wci;
    if ((localObject1 != null) && (!((com.tencent.mm.plugin.emoji.ui.widget.b)localObject1).ydr)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.Wci;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.emoji.ui.widget.b)localObject1).lCH;
          if (localObject2 != null) {
            ((j)localObject2).cyW();
          }
          ((com.tencent.mm.plugin.emoji.ui.widget.b)localObject1).ydr = true;
        }
      }
      com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
      Object localObject2 = this.Wck;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mNetSceneCallback");
        localObject1 = null;
      }
      locals.b(422, (com.tencent.mm.am.h)localObject1);
      locals = com.tencent.mm.kernel.h.baD().mCm;
      localObject2 = this.Wck;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mNetSceneCallback");
        localObject1 = null;
      }
      locals.b(414, (com.tencent.mm.am.h)localObject1);
      super.onDestroy();
      AppMethodBeat.o(263677);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(263672);
    Log.i("MicroMsg.WecoinIapUI", "onResume");
    super.onResume();
    Object localObject = this.Wce;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((f)localObject).imt())
    {
      if ((localObject != null) && (this.Wcg))
      {
        showLoadingDialog();
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      }
      AppMethodBeat.o(263672);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(263673);
    Log.i("MicroMsg.WecoinIapUI", "onStop");
    super.onStop();
    AppMethodBeat.o(263673);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapUI$NetCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "weakRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/wallet_index/ui/WecoinIapUI;", "(Ljava/lang/ref/WeakReference;)V", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    private final WeakReference<WecoinIapUI> vKQ;
    
    public b(WeakReference<WecoinIapUI> paramWeakReference)
    {
      this.vKQ = paramWeakReference;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      Object localObject1 = null;
      AppMethodBeat.i(263621);
      if (paramp == null)
      {
        AppMethodBeat.o(263621);
        return;
      }
      Log.i("MicroMsg.WecoinIapUI", "onSceneEnd type:" + paramp.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
      Object localObject3 = com.tencent.mm.plugin.wallet_index.model.c.dA(paramInt2, paramString);
      paramInt1 = ((com.tencent.mm.plugin.wallet_index.model.c)localObject3).mResponse;
      Object localObject2 = ((com.tencent.mm.plugin.wallet_index.model.c)localObject3).mMessage;
      int i = paramp.getType();
      Object localObject4 = this.vKQ;
      if (localObject4 != null)
      {
        localObject4 = (WecoinIapUI)((WeakReference)localObject4).get();
        if (localObject4 == null) {}
      }
      switch (i)
      {
      default: 
        Log.w("MicroMsg.WecoinIapUI", kotlin.g.b.s.X("get a wrong sceneType : ", Integer.valueOf(i)));
        AppMethodBeat.o(263621);
        return;
      case 422: 
        localf = WecoinIapUI.a((WecoinIapUI)localObject4);
        if (localf == null) {
          paramString = null;
        }
        while (paramString.mResponse == 0) {
          if (WecoinIapUI.d((WecoinIapUI)localObject4))
          {
            WecoinIapUI.e((WecoinIapUI)localObject4);
            WecoinIapUI.f((WecoinIapUI)localObject4);
            Log.i("MicroMsg.WecoinIapUI", "PreparePurchase success, go checkAndPrepare ");
            WecoinIapUI.g((WecoinIapUI)localObject4);
            AppMethodBeat.o(263621);
            return;
            kotlin.g.b.s.s(localObject2, "errorMsg");
            kotlin.g.b.s.u(localObject2, "errMsg");
            kotlin.g.b.s.u(paramp, "scene");
            localObject2 = com.tencent.mm.plugin.wallet_index.model.c.dA(paramInt1, (String)localObject2);
            paramInt1 = ((com.tencent.mm.plugin.wallet_index.model.c)localObject2).mResponse;
            if (((paramp instanceof com.tencent.mm.wallet_core.model.u)) && (paramInt1 == 0))
            {
              localObject3 = ((egt)c.c.b(((com.tencent.mm.wallet_core.model.u)paramp).rr.otC)).abmb;
              paramString = (String)localObject3;
              if (localObject3 == null) {
                paramString = "";
              }
              localf.Wcc = paramString;
              paramString = com.tencent.mm.platformtools.w.a(((egt)c.c.b(((com.tencent.mm.wallet_core.model.u)paramp).rr.otC)).abmf);
              kotlin.g.b.s.s(paramString, "preScene.buffer");
              localf.eTS = paramString;
            }
            kotlin.g.b.s.s(localObject2, "result");
            paramString = (String)localObject2;
          }
          else
          {
            Log.i("MicroMsg.WecoinIapUI", "PreparePurchase success, launch Wecoin Consume");
            paramString = WecoinIapUI.a((WecoinIapUI)localObject4);
            if (paramString == null) {}
            for (paramString = (String)localObject1;; paramString = paramString.eTS)
            {
              paramp = new com.tencent.mm.plugin.wallet.wecoin.a.a();
              paramp.VtQ = paramString;
              paramp.VtP = 5;
              paramp.FUP = MD5Util.getMD5String(kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis())));
              paramp.VtR = ((i)new WecoinIapUI.h((WecoinIapUI)localObject4));
              ((d)com.tencent.mm.kernel.h.ax(d.class)).a(MMApplicationContext.getContext(), paramp);
              WecoinIapUI.a((WecoinIapUI)localObject4, WecoinIapUI.h((WecoinIapUI)localObject4));
              AppMethodBeat.o(263621);
              return;
            }
          }
        }
        Log.i("MicroMsg.WecoinIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + paramString.mResponse + " , errMsg: " + paramString.mMessage);
        kotlin.g.b.s.s(paramString, "result");
        WecoinIapUI.a((WecoinIapUI)localObject4, paramString, 1);
        AppMethodBeat.o(263621);
        return;
      }
      f localf = WecoinIapUI.a((WecoinIapUI)localObject4);
      if (localf != null)
      {
        kotlin.g.b.s.u(paramp, "scene");
        if (!(paramp instanceof v)) {
          break label1139;
        }
        localObject1 = ((v)paramp).xOk;
        kotlin.g.b.s.s(localObject1, "scene.productId");
        localf.xOk = ((String)localObject1);
        localObject2 = ((v)paramp).xOm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localf.Wbd = ((String)localObject1);
        localf.Wbe = ((v)paramp).Wbe;
      }
      label721:
      label749:
      label1139:
      for (boolean bool = ((v)paramp).jOM();; bool = false)
      {
        localf.Wbf.remove(localf.xOk);
        if (bool)
        {
          Log.i("MicroMsg.WecoinIapData", "Verify " + localf.xOk + " OK");
          localf.Wbb.add(localf.xOk);
          localf.Wbc.add(localf.Wbd);
          paramp = WecoinIapUI.a((WecoinIapUI)localObject4);
          if ((paramp == null) || (true != paramp.Wbf.isEmpty())) {
            break label1045;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1048;
          }
          Log.d("MicroMsg.WecoinIapUI", "Verify All End... ");
          paramp = WecoinIapUI.a((WecoinIapUI)localObject4);
          if (paramp == null) {
            break label1055;
          }
          paramp = paramp.Wbb;
          if (paramp == null) {
            break label1055;
          }
          if (((Collection)paramp).isEmpty()) {
            break label1050;
          }
          paramInt1 = 1;
          if (1 != paramInt1) {
            break label1055;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label1086;
          }
          paramString = new StringBuilder("mResultProductIds size: ");
          paramp = WecoinIapUI.a((WecoinIapUI)localObject4);
          if (paramp != null) {
            break label1060;
          }
          paramInt1 = 0;
        }
        for (;;)
        {
          Log.i("MicroMsg.WecoinIapUI", paramInt1 + ", Consume ...");
          paramString = com.tencent.mm.plugin.wallet_index.model.c.dA(0, "");
          kotlin.g.b.s.s(paramString, "getIabResult(ConstantsUI.WalletIapUI.ERR_CODE_OK)");
          WecoinIapUI.a((WecoinIapUI)localObject4, paramString, WecoinIapUI.a((WecoinIapUI)localObject4));
          AppMethodBeat.o(263621);
          return;
          if (n.U(localf.xOk, "com.tencent.xin.wco", false))
          {
            if (localf.Wbe > 0)
            {
              localf.Wbb.add(localf.xOk);
              localf.Wbc.add(localf.Wbd);
              Log.i("MicroMsg.WecoinIapData", "Verify " + localf.xOk + " fail and consume");
              break label721;
            }
            Log.i("MicroMsg.WecoinIapData", "Verify " + localf.xOk + " fail");
            break label721;
          }
          Log.i("MicroMsg.WecoinIapData", "Verify " + localf.xOk + " fail");
          break label721;
          paramInt1 = 0;
          break label749;
          break;
          paramInt1 = 0;
          break label800;
          paramInt1 = 0;
          break label807;
          paramp = paramp.Wbb;
          if (paramp == null) {
            paramInt1 = 0;
          } else {
            paramInt1 = paramp.size();
          }
        }
        Log.i("MicroMsg.WecoinIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
        kotlin.g.b.s.s(localObject3, "result");
        WecoinIapUI.a((WecoinIapUI)localObject4, (com.tencent.mm.plugin.wallet_index.model.c)localObject3, 3);
        AppMethodBeat.o(263621);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(WeakReference<WecoinIapUI> paramWeakReference)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Object>
  {
    e(WeakReference<WecoinIapUI> paramWeakReference)
    {
      super();
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(263609);
      WecoinIapUI localWecoinIapUI = (WecoinIapUI)this.Wcl.get();
      if (localWecoinIapUI == null) {
        localObject = null;
      }
      while (localObject != null)
      {
        WecoinIapUI.b(localWecoinIapUI);
        boolean bool = com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
        AppMethodBeat.o(263609);
        return Boolean.valueOf(bool);
        localObject = WecoinIapUI.a(localWecoinIapUI);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((f)localObject).imt();
        }
      }
      Log.e("MicroMsg.WecoinIapUI", "getPrepareNetScene error , netScene is null");
      if (localWecoinIapUI == null)
      {
        AppMethodBeat.o(263609);
        return null;
      }
      Object localObject = com.tencent.mm.plugin.wallet_index.model.c.dA(8, "");
      kotlin.g.b.s.s(localObject, "getIabResult(ConstantsUI….ERR_CODE_PURCHASE_ERROR)");
      WecoinIapUI.a(localWecoinIapUI, (com.tencent.mm.plugin.wallet_index.model.c)localObject);
      localObject = ah.aiuX;
      AppMethodBeat.o(263609);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(WeakReference<WecoinIapUI> paramWeakReference)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet_index/ui/WecoinIapUI$consumeWecoin$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "(Ljava/lang/Long;)V", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i<Long>
  {
    h(WecoinIapUI paramWecoinIapUI) {}
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(263575);
      Log.i("MicroMsg.WecoinIapUI", "[WeCoin] consumeWecoin onFailed errorType:" + paramInt1 + ",errorCode:" + paramInt2 + ",msg:" + paramString);
      WecoinIapUI.b(this.Wcr, WecoinIapUI.j(this.Wcr));
      Intent localIntent = new Intent();
      localIntent.putExtra("key_err_code", paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localIntent.putExtra("key_err_msg", str);
      this.Wcr.setResult(-1, localIntent);
      this.Wcr.finish();
      AppMethodBeat.o(263575);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WecoinIapUI
 * JD-Core Version:    0.7.0.1
 */