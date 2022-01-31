package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements f
{
  public String TAG;
  private String cnI;
  private String fOI;
  private long jMt;
  private int mScene;
  private PayReq.Options options;
  private c pvT;
  private boolean qni;
  private PayReq uAJ;
  private PayResp uAK;
  private boolean uAL;
  private String uAM;
  private boolean uAN;
  private boolean uAO;
  private boolean uAP;
  private boolean uAQ;
  private boolean uAR;
  private c uAS;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(48232);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.uAL = false;
    this.mScene = 0;
    this.uAM = "";
    this.uAN = false;
    this.jMt = 0L;
    this.uAO = false;
    this.uAP = false;
    this.uAQ = false;
    this.qni = false;
    this.uAR = false;
    this.pvT = new OrderHandlerUI.1(this);
    this.uAS = new OrderHandlerUI.2(this);
    AppMethodBeat.o(48232);
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(48242);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131305682);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new OrderHandlerUI.5(this));
    AppMethodBeat.o(48242);
  }
  
  private void bK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48238);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.uAM)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        La(paramString);
        AppMethodBeat.o(48238);
        return;
      }
      be(this, this.uAM);
      finish();
      AppMethodBeat.o(48238);
      return;
    }
    e.a(this, this.fOI, this.uAK, this.options);
    finish();
    AppMethodBeat.o(48238);
  }
  
  private void be(Context paramContext, String paramString)
  {
    AppMethodBeat.i(48241);
    if (paramContext == null)
    {
      ab.e(this.TAG, "startOuterApp context == null");
      AppMethodBeat.o(48241);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ab.e(this.TAG, "startOuterApp callbackUrl is empty");
      AppMethodBeat.o(48241);
      return;
    }
    ab.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    if (bo.k(paramContext, paramString)) {
      paramContext.startActivity(paramString);
    }
    AppMethodBeat.o(48241);
  }
  
  private void cXh()
  {
    AppMethodBeat.i(142592);
    if (!((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).canOpenKindaCashier(this))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131305144), "", getString(2131297828), new OrderHandlerUI.3(this));
      AppMethodBeat.o(142592);
      return;
    }
    if (((Boolean)i.dpR().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131305144), "", getString(2131297828), new OrderHandlerUI.4(this));
      AppMethodBeat.o(142592);
      return;
    }
    ml localml = new ml();
    localml.cCz.ret = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localml);
    AppMethodBeat.o(142592);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48239);
    ab.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.qni), bo.dtY().toString() });
    if (this.qni)
    {
      AppMethodBeat.o(48239);
      return;
    }
    this.qni = true;
    super.finish();
    AppMethodBeat.o(48239);
  }
  
  public int getLayoutId()
  {
    return 2130970396;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48237);
    ab.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.uAK, Boolean.valueOf(this.uAL) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        ab.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.uAK, Boolean.valueOf(this.uAL), Integer.valueOf(paramInt1) });
        finish();
        AppMethodBeat.o(48237);
        return;
      }
      if (paramInt1 == 1001)
      {
        AppMethodBeat.o(48237);
        return;
      }
    }
    if ((this.uAK != null) && (!this.uAL))
    {
      ab.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.uAK.errCode = -2;
      bK("", false);
    }
    AppMethodBeat.o(48237);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(48240);
    super.onConfigurationChanged(paramConfiguration);
    ab.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(48240);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(48233);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.OrderHandlerUI@" + hashCode());
    this.jMt = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    z.dSt();
    com.tencent.mm.sdk.b.a.ymk.c(this.pvT);
    com.tencent.mm.sdk.b.a.ymk.c(this.uAS);
    com.tencent.mm.wallet_core.b.dRI();
    this.uAO = com.tencent.mm.wallet_core.b.dpQ();
    if ((this.uAO) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY")))
    {
      bool1 = true;
      this.uAP = bool1;
      if ((!this.uAO) || (!((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY"))) {
        break label174;
      }
    }
    label174:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uAQ = bool1;
      AppMethodBeat.o(48233);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48235);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(397, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(2655, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.pvT);
    com.tencent.mm.sdk.b.a.ymk.d(this.uAS);
    super.onDestroy();
    AppMethodBeat.o(48235);
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: ldc_w 421
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 423	com/tencent/mm/ui/MMActivity:onResume	()V
    //   10: new 425	com/tencent/mm/opensdk/modelpay/PayReq
    //   13: dup
    //   14: invokespecial 426	com/tencent/mm/opensdk/modelpay/PayReq:<init>	()V
    //   17: astore 11
    //   19: aload 11
    //   21: aload_0
    //   22: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   25: invokevirtual 430	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   28: invokevirtual 433	com/tencent/mm/opensdk/modelpay/PayReq:fromBundle	(Landroid/os/Bundle;)V
    //   31: aload_0
    //   32: getfield 435	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAJ	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   35: ifnull +29 -> 64
    //   38: aload 11
    //   40: getfield 438	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   43: ifnull +764 -> 807
    //   46: aload 11
    //   48: getfield 438	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 435	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAJ	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   55: getfield 438	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   58: invokevirtual 442	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +746 -> 807
    //   64: aload_0
    //   65: aload 11
    //   67: putfield 435	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAJ	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 444
    //   78: iconst_0
    //   79: invokevirtual 314	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   82: putfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   85: aload_0
    //   86: getfield 50	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:TAG	Ljava/lang/String;
    //   89: new 343	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 446
    //   96: invokespecial 347	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   103: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 167	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   116: ifne +55 -> 171
    //   119: aload_0
    //   120: aload_0
    //   121: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   124: ldc_w 448
    //   127: invokevirtual 451	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   130: putfield 133	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fOI	Ljava/lang/String;
    //   133: aload_0
    //   134: getfield 133	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fOI	Ljava/lang/String;
    //   137: ifnull +13 -> 150
    //   140: aload_0
    //   141: getfield 133	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fOI	Ljava/lang/String;
    //   144: invokevirtual 454	java/lang/String:length	()I
    //   147: ifne +24 -> 171
    //   150: aload_0
    //   151: getfield 50	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:TAG	Ljava/lang/String;
    //   154: ldc_w 456
    //   157: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: invokevirtual 131	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   164: ldc_w 421
    //   167: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: new 458	com/tencent/mm/opensdk/modelpay/PayReq$Options
    //   175: dup
    //   176: invokespecial 459	com/tencent/mm/opensdk/modelpay/PayReq$Options:<init>	()V
    //   179: putfield 137	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   182: aload_0
    //   183: getfield 137	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   186: aload_0
    //   187: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   190: invokevirtual 430	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   193: invokevirtual 460	com/tencent/mm/opensdk/modelpay/PayReq$Options:fromBundle	(Landroid/os/Bundle;)V
    //   196: aload_0
    //   197: new 325	com/tencent/mm/opensdk/modelpay/PayResp
    //   200: dup
    //   201: invokespecial 461	com/tencent/mm/opensdk/modelpay/PayResp:<init>	()V
    //   204: putfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   207: aload_0
    //   208: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   211: aload 11
    //   213: getfield 438	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   216: putfield 462	com/tencent/mm/opensdk/modelpay/PayResp:prepayId	Ljava/lang/String;
    //   219: aload_0
    //   220: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   223: aload 11
    //   225: getfield 465	com/tencent/mm/opensdk/modelpay/PayReq:extData	Ljava/lang/String;
    //   228: putfield 466	com/tencent/mm/opensdk/modelpay/PayResp:extData	Ljava/lang/String;
    //   231: ldc 56
    //   233: astore 7
    //   235: aload_0
    //   236: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   239: ifne +131 -> 370
    //   242: aload 11
    //   244: invokevirtual 469	com/tencent/mm/opensdk/modelpay/PayReq:checkArgs	()Z
    //   247: ifne +63 -> 310
    //   250: aload_0
    //   251: getfield 50	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:TAG	Ljava/lang/String;
    //   254: ldc_w 471
    //   257: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   264: iconst_m1
    //   265: putfield 328	com/tencent/mm/opensdk/modelpay/PayResp:errCode	I
    //   268: aload_0
    //   269: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   272: aload_0
    //   273: ldc_w 472
    //   276: invokevirtual 102	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getString	(I)Ljava/lang/String;
    //   279: putfield 475	com/tencent/mm/opensdk/modelpay/PayResp:errStr	Ljava/lang/String;
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 133	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fOI	Ljava/lang/String;
    //   287: aload_0
    //   288: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   291: aload_0
    //   292: getfield 137	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   295: invokestatic 142	com/tencent/mm/plugin/wallet_index/ui/e:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/opensdk/modelpay/PayResp;Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;)Z
    //   298: pop
    //   299: aload_0
    //   300: invokevirtual 131	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   303: ldc_w 421
    //   306: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: return
    //   310: aload_0
    //   311: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   314: ldc_w 477
    //   317: iconst_0
    //   318: invokevirtual 481	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   321: ifne +62 -> 383
    //   324: aload_0
    //   325: getfield 50	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:TAG	Ljava/lang/String;
    //   328: ldc_w 483
    //   331: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_0
    //   335: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   338: iconst_m1
    //   339: putfield 328	com/tencent/mm/opensdk/modelpay/PayResp:errCode	I
    //   342: aload_0
    //   343: aload_0
    //   344: getfield 133	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fOI	Ljava/lang/String;
    //   347: aload_0
    //   348: getfield 135	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAK	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   351: aload_0
    //   352: getfield 137	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   355: invokestatic 142	com/tencent/mm/plugin/wallet_index/ui/e:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/opensdk/modelpay/PayResp;Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;)Z
    //   358: pop
    //   359: aload_0
    //   360: invokevirtual 131	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   363: ldc_w 421
    //   366: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: return
    //   370: aload_0
    //   371: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   374: iconst_1
    //   375: if_icmpne +8 -> 383
    //   378: ldc_w 485
    //   381: astore 7
    //   383: aload_0
    //   384: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   387: ldc_w 448
    //   390: invokevirtual 451	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: ldc 56
    //   397: astore 6
    //   399: ldc 56
    //   401: astore 9
    //   403: aload_0
    //   404: invokevirtual 489	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   407: aload 12
    //   409: iconst_0
    //   410: invokevirtual 495	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   413: pop
    //   414: aload_0
    //   415: invokevirtual 489	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   418: aload 12
    //   420: iconst_0
    //   421: invokevirtual 495	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   424: getfield 501	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   427: aload_0
    //   428: invokevirtual 489	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   431: invokevirtual 507	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   434: checkcast 157	java/lang/String
    //   437: astore 8
    //   439: aload_0
    //   440: aload 12
    //   442: invokestatic 513	com/tencent/mm/pluginsdk/model/app/p:bv	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +9 -> 458
    //   452: aload 6
    //   454: arraylength
    //   455: ifne +191 -> 646
    //   458: ldc_w 515
    //   461: ldc_w 517
    //   464: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aconst_null
    //   468: astore 6
    //   470: aload 8
    //   472: astore 9
    //   474: aload 6
    //   476: astore 8
    //   478: aload 9
    //   480: astore 6
    //   482: new 425	com/tencent/mm/opensdk/modelpay/PayReq
    //   485: dup
    //   486: invokespecial 426	com/tencent/mm/opensdk/modelpay/PayReq:<init>	()V
    //   489: astore 9
    //   491: aload 9
    //   493: aload_0
    //   494: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   497: invokevirtual 430	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   500: invokevirtual 433	com/tencent/mm/opensdk/modelpay/PayReq:fromBundle	(Landroid/os/Bundle;)V
    //   503: aload 9
    //   505: getfield 438	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   508: astore 9
    //   510: aload 9
    //   512: ldc_w 519
    //   515: invokevirtual 522	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   518: istore_3
    //   519: aload 9
    //   521: ldc_w 524
    //   524: invokevirtual 522	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   527: istore 4
    //   529: aload 9
    //   531: ldc_w 526
    //   534: invokevirtual 522	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   537: istore 5
    //   539: iload_3
    //   540: ifne +13 -> 553
    //   543: iload 4
    //   545: ifne +8 -> 553
    //   548: iload 5
    //   550: ifeq +135 -> 685
    //   553: iconst_1
    //   554: istore_1
    //   555: aload_0
    //   556: getfield 68	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAQ	Z
    //   559: istore_3
    //   560: iload_1
    //   561: ifne +129 -> 690
    //   564: iconst_1
    //   565: istore_2
    //   566: aload_0
    //   567: iload_2
    //   568: iload_3
    //   569: iand
    //   570: putfield 68	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAQ	Z
    //   573: aload_0
    //   574: getfield 66	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAP	Z
    //   577: istore_3
    //   578: iload_1
    //   579: ifne +116 -> 695
    //   582: iconst_1
    //   583: istore_1
    //   584: aload_0
    //   585: iload_1
    //   586: iload_3
    //   587: iand
    //   588: putfield 66	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAP	Z
    //   591: aload_0
    //   592: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   595: iconst_1
    //   596: if_icmpne +104 -> 700
    //   599: aload_0
    //   600: getfield 68	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAQ	Z
    //   603: ifeq +97 -> 700
    //   606: aload_0
    //   607: invokespecial 528	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:cXh	()V
    //   610: ldc 205
    //   612: invokestatic 211	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   615: checkcast 205	com/tencent/mm/pluginsdk/wallet/b
    //   618: aload_0
    //   619: aload_0
    //   620: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   623: invokevirtual 430	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   626: aload 7
    //   628: aload 12
    //   630: aload 6
    //   632: aload 8
    //   634: invokeinterface 532 7 0
    //   639: ldc_w 421
    //   642: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   645: return
    //   646: aload 6
    //   648: iconst_0
    //   649: aaload
    //   650: invokevirtual 538	android/content/pm/Signature:toByteArray	()[B
    //   653: invokestatic 544	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   656: astore 6
    //   658: goto -188 -> 470
    //   661: astore 8
    //   663: aload_0
    //   664: getfield 50	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:TAG	Ljava/lang/String;
    //   667: aload 8
    //   669: ldc 56
    //   671: iconst_0
    //   672: anewarray 283	java/lang/Object
    //   675: invokestatic 548	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   678: aload 9
    //   680: astore 8
    //   682: goto -200 -> 482
    //   685: iconst_0
    //   686: istore_1
    //   687: goto -132 -> 555
    //   690: iconst_0
    //   691: istore_2
    //   692: goto -126 -> 566
    //   695: iconst_0
    //   696: istore_1
    //   697: goto -113 -> 584
    //   700: aload_0
    //   701: getfield 54	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:mScene	I
    //   704: ifne +50 -> 754
    //   707: aload_0
    //   708: getfield 66	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:uAP	Z
    //   711: ifeq +43 -> 754
    //   714: aload_0
    //   715: invokespecial 528	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:cXh	()V
    //   718: ldc 205
    //   720: invokestatic 211	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   723: checkcast 205	com/tencent/mm/pluginsdk/wallet/b
    //   726: aload_0
    //   727: aload_0
    //   728: invokevirtual 359	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   731: invokevirtual 430	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   734: aload 7
    //   736: aload 12
    //   738: aload 6
    //   740: aload 8
    //   742: invokeinterface 551 7 0
    //   747: ldc_w 421
    //   750: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   753: return
    //   754: invokestatic 398	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   757: pop
    //   758: invokestatic 402	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   761: getfield 408	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   764: sipush 397
    //   767: aload_0
    //   768: invokevirtual 553	com/tencent/mm/ai/p:a	(ILcom/tencent/mm/ai/f;)V
    //   771: new 555	com/tencent/mm/plugin/wallet_index/c/g
    //   774: dup
    //   775: aload 11
    //   777: aload 7
    //   779: aload 12
    //   781: aload 6
    //   783: aload 8
    //   785: invokespecial 558	com/tencent/mm/plugin/wallet_index/c/g:<init>	(Lcom/tencent/mm/opensdk/modelpay/PayReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   788: astore 6
    //   790: invokestatic 398	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   793: pop
    //   794: invokestatic 402	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   797: getfield 408	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   800: aload 6
    //   802: iconst_0
    //   803: invokevirtual 561	com/tencent/mm/ai/p:a	(Lcom/tencent/mm/ai/m;I)Z
    //   806: pop
    //   807: ldc_w 421
    //   810: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   813: return
    //   814: astore 10
    //   816: aload 8
    //   818: astore 6
    //   820: aload 10
    //   822: astore 8
    //   824: goto -161 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	827	0	this	OrderHandlerUI
    //   554	143	1	bool1	boolean
    //   565	127	2	bool2	boolean
    //   518	70	3	bool3	boolean
    //   527	17	4	bool4	boolean
    //   537	12	5	bool5	boolean
    //   397	422	6	localObject1	Object
    //   233	545	7	str1	String
    //   437	196	8	localObject2	Object
    //   661	7	8	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   680	143	8	localObject3	Object
    //   401	278	9	localObject4	Object
    //   814	7	10	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   17	759	11	localPayReq	PayReq
    //   393	387	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   403	439	661	android/content/pm/PackageManager$NameNotFoundException
    //   439	447	814	android/content/pm/PackageManager$NameNotFoundException
    //   452	458	814	android/content/pm/PackageManager$NameNotFoundException
    //   458	467	814	android/content/pm/PackageManager$NameNotFoundException
    //   646	658	814	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48236);
    if ((paramm.getType() != 397) && (paramm.getType() != 2655))
    {
      AppMethodBeat.o(48236);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.mScene == 1)
    {
      localPayInfo.cCD = 36;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(paramm.getType(), this);
      ab.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.g)paramm;
      paramm = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
      if (paramm != null) {
        break label222;
      }
      paramm = null;
      label143:
      this.uAM = paramm;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label243;
      }
      ab.e(this.TAG, "onSceneEnd, auth access denied");
      this.uAK.errCode = -1;
      bK(paramString, true);
      paramInt1 = localPayInfo.cCD;
      if (this.uAJ != null) {
        break label232;
      }
    }
    label222:
    label232:
    for (paramString = "";; paramString = this.uAJ.prepayId)
    {
      ad.q(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(48236);
      return;
      localPayInfo.cCD = 2;
      break;
      paramm = paramm.xzr;
      break label143;
    }
    label243:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.uAK.errCode = -1;
      bK(paramString, true);
      paramInt1 = localPayInfo.cCD;
      if (this.uAJ == null) {}
      for (paramString = "";; paramString = this.uAJ.prepayId)
      {
        ad.q(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(48236);
        return;
      }
    }
    paramm = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
    label362:
    Object localObject1;
    label386:
    Object localObject2;
    if (paramm == null)
    {
      paramInt1 = -1;
      paramm = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
      if (paramm != null) {
        break label518;
      }
      paramm = null;
      localObject1 = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
      if (localObject1 != null) {
        break label528;
      }
      localObject1 = null;
      localObject2 = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
      if (localObject2 != null) {
        break label538;
      }
      localObject2 = null;
      label410:
      localObject3 = (bkq)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.fsW.fta;
      if (localObject3 != null) {
        break label548;
      }
    }
    label518:
    label528:
    label538:
    label548:
    for (Object localObject3 = null;; localObject3 = ((bkq)localObject3).wXW)
    {
      ab.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramm, localObject1, localObject2 });
      if (!bo.isNullOrNil((String)localObject1)) {
        break label558;
      }
      ab.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.uAK.errCode = -1;
      bK(paramString, true);
      AppMethodBeat.o(48236);
      return;
      paramInt1 = paramm.lGK;
      break;
      paramm = paramm.lGL;
      break label362;
      localObject1 = ((bkq)localObject1).wXQ;
      break label386;
      localObject2 = ((bkq)localObject2).wXR;
      break label410;
    }
    label558:
    ad.q(localPayInfo.cCD, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bo.isNullOrNil(((cvm)localObject3).ydT)))
    {
      this.uAR = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((cvm)localObject3).ydT);
      paramString.putExtra("need_dialog", ((cvm)localObject3).ydV);
      paramString.putExtra("dialog_text", ((cvm)localObject3).ydW);
      paramString.putExtra("max_count", ((cvm)localObject3).ydU.wDy);
      paramString.putExtra("inteval_time", ((cvm)localObject3).ydU.wDx);
      paramString.putExtra("default_wording", ((cvm)localObject3).ydU.wDz);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.cnI = ((String)localObject1);
      this.uAL = false;
      AppMethodBeat.o(48236);
      return;
      localPayInfo.appId = this.uAJ.appId;
      localPayInfo.cnI = ((String)localObject1);
      localPayInfo.partnerId = this.uAJ.partnerId;
      localPayInfo.uAe = ((String)localObject2);
      localPayInfo.wgu = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramm;
      if (this.jMt > 0L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(641L, 2L, bo.hl(this.jMt), true);
        if (localPayInfo.wgv == null) {
          localPayInfo.wgv = new Bundle();
        }
        localPayInfo.wgv.putLong("wallet_pay_key_check_time", this.jMt);
      }
      com.tencent.mm.pluginsdk.wallet.h.a(this, localPayInfo, 123);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */