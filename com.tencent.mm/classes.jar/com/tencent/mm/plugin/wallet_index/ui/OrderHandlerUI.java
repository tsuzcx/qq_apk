package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.protocal.c.cia;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.w;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String bMX;
  private String eyT;
  private int fzn = 0;
  private long hSH = 0L;
  private c mTN = new OrderHandlerUI.1(this);
  private PayReq.Options options;
  private PayReq qLN;
  private PayResp qLO;
  private boolean qLP = false;
  private String qLQ = "";
  private boolean qLR = false;
  private boolean qLS = false;
  
  private static void aU(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      y.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        y.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        return;
      }
      y.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + paramString);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
    } while (!bk.i(paramContext, paramString));
    paramContext.startActivity(paramString);
  }
  
  private void bl(String paramString, boolean paramBoolean)
  {
    if (this.fzn == 1)
    {
      if ((TextUtils.isEmpty(this.qLQ)) && (paramBoolean))
      {
        vN(0);
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = getString(a.i.wallet_unknown_err);
        }
        com.tencent.mm.ui.base.h.a(this, str, null, false, new OrderHandlerUI.2(this));
        return;
      }
      aU(this, this.qLQ);
      finish();
      return;
    }
    e.a(this, this.eyT, this.qLO, this.options);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.order_handle_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.qLO != null) && (!this.qLP))
    {
      y.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
      this.qLO.errCode = -2;
      bl("", false);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.hSH = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    vN(8);
    w.cME();
    com.tencent.mm.sdk.b.a.udP.c(this.mTN);
  }
  
  protected void onDestroy()
  {
    g.DQ();
    g.DO().dJT.b(397, this);
    g.DQ();
    g.DO().dJT.b(2655, this);
    com.tencent.mm.sdk.b.a.udP.d(this.mTN);
    super.onDestroy();
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 262	com/tencent/mm/ui/MMActivity:onResume	()V
    //   4: new 264	com/tencent/mm/opensdk/modelpay/PayReq
    //   7: dup
    //   8: invokespecial 265	com/tencent/mm/opensdk/modelpay/PayReq:<init>	()V
    //   11: astore 6
    //   13: aload 6
    //   15: aload_0
    //   16: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   19: invokevirtual 269	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   22: invokevirtual 272	com/tencent/mm/opensdk/modelpay/PayReq:fromBundle	(Landroid/os/Bundle;)V
    //   25: aload_0
    //   26: getfield 274	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLN	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   29: ifnull +29 -> 58
    //   32: aload 6
    //   34: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   37: ifnull +117 -> 154
    //   40: aload 6
    //   42: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 274	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLN	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   49: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   52: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +99 -> 154
    //   58: aload_0
    //   59: aload 6
    //   61: putfield 274	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLN	Lcom/tencent/mm/opensdk/modelpay/PayReq;
    //   64: aload_0
    //   65: aload_0
    //   66: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   69: ldc_w 285
    //   72: iconst_0
    //   73: invokevirtual 289	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   76: putfield 37	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fzn	I
    //   79: ldc 62
    //   81: new 80	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 291
    //   88: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 37	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fzn	I
    //   95: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 96	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 37	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fzn	I
    //   108: ifne +47 -> 155
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 296
    //   119: invokevirtual 300	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   122: putfield 157	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:eyT	Ljava/lang/String;
    //   125: aload_0
    //   126: getfield 157	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:eyT	Ljava/lang/String;
    //   129: ifnull +13 -> 142
    //   132: aload_0
    //   133: getfield 157	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:eyT	Ljava/lang/String;
    //   136: invokevirtual 303	java/lang/String:length	()I
    //   139: ifne +16 -> 155
    //   142: ldc 62
    //   144: ldc_w 305
    //   147: invokestatic 70	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_0
    //   151: invokevirtual 155	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   154: return
    //   155: aload_0
    //   156: new 307	com/tencent/mm/opensdk/modelpay/PayReq$Options
    //   159: dup
    //   160: invokespecial 308	com/tencent/mm/opensdk/modelpay/PayReq$Options:<init>	()V
    //   163: putfield 161	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   166: aload_0
    //   167: getfield 161	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   170: aload_0
    //   171: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   174: invokevirtual 269	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   177: invokevirtual 309	com/tencent/mm/opensdk/modelpay/PayReq$Options:fromBundle	(Landroid/os/Bundle;)V
    //   180: aload_0
    //   181: new 191	com/tencent/mm/opensdk/modelpay/PayResp
    //   184: dup
    //   185: invokespecial 310	com/tencent/mm/opensdk/modelpay/PayResp:<init>	()V
    //   188: putfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   191: aload_0
    //   192: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   195: aload 6
    //   197: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   200: putfield 311	com/tencent/mm/opensdk/modelpay/PayResp:prepayId	Ljava/lang/String;
    //   203: aload_0
    //   204: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   207: aload 6
    //   209: getfield 314	com/tencent/mm/opensdk/modelpay/PayReq:extData	Ljava/lang/String;
    //   212: putfield 315	com/tencent/mm/opensdk/modelpay/PayResp:extData	Ljava/lang/String;
    //   215: ldc 39
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 37	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fzn	I
    //   222: ifne +115 -> 337
    //   225: aload 6
    //   227: invokevirtual 319	com/tencent/mm/opensdk/modelpay/PayReq:checkArgs	()Z
    //   230: ifne +55 -> 285
    //   233: ldc 62
    //   235: ldc_w 321
    //   238: invokestatic 70	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   245: iconst_m1
    //   246: putfield 194	com/tencent/mm/opensdk/modelpay/PayResp:errCode	I
    //   249: aload_0
    //   250: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   253: aload_0
    //   254: getstatic 324	com/tencent/mm/plugin/wxpay/a$i:pay_callback_errmsg_req_checkargs_fail	I
    //   257: invokevirtual 144	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getString	(I)Ljava/lang/String;
    //   260: putfield 327	com/tencent/mm/opensdk/modelpay/PayResp:errStr	Ljava/lang/String;
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 157	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:eyT	Ljava/lang/String;
    //   268: aload_0
    //   269: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   272: aload_0
    //   273: getfield 161	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   276: invokestatic 166	com/tencent/mm/plugin/wallet_index/ui/e:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/opensdk/modelpay/PayResp;Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;)Z
    //   279: pop
    //   280: aload_0
    //   281: invokevirtual 155	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   284: return
    //   285: aload_0
    //   286: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   289: ldc_w 329
    //   292: iconst_0
    //   293: invokevirtual 333	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   296: ifne +53 -> 349
    //   299: ldc 62
    //   301: ldc_w 335
    //   304: invokestatic 70	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_0
    //   308: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   311: iconst_m1
    //   312: putfield 194	com/tencent/mm/opensdk/modelpay/PayResp:errCode	I
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 157	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:eyT	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 159	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:qLO	Lcom/tencent/mm/opensdk/modelpay/PayResp;
    //   324: aload_0
    //   325: getfield 161	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:options	Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;
    //   328: invokestatic 166	com/tencent/mm/plugin/wallet_index/ui/e:a	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/opensdk/modelpay/PayResp;Lcom/tencent/mm/opensdk/modelpay/PayReq$Options;)Z
    //   331: pop
    //   332: aload_0
    //   333: invokevirtual 155	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:finish	()V
    //   336: return
    //   337: aload_0
    //   338: getfield 37	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:fzn	I
    //   341: iconst_1
    //   342: if_icmpne +7 -> 349
    //   345: ldc_w 337
    //   348: astore_2
    //   349: aload_0
    //   350: invokevirtual 209	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getIntent	()Landroid/content/Intent;
    //   353: ldc_w 296
    //   356: invokevirtual 300	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   359: astore 7
    //   361: ldc 39
    //   363: astore_1
    //   364: ldc 39
    //   366: astore 4
    //   368: aload_0
    //   369: invokevirtual 341	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   372: aload 7
    //   374: iconst_0
    //   375: invokevirtual 347	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   378: pop
    //   379: aload_0
    //   380: invokevirtual 341	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   383: aload 7
    //   385: iconst_0
    //   386: invokevirtual 347	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   389: getfield 353	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   392: aload_0
    //   393: invokevirtual 341	com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI:getPackageManager	()Landroid/content/pm/PackageManager;
    //   396: invokevirtual 359	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   399: checkcast 279	java/lang/String
    //   402: astore_3
    //   403: aload_0
    //   404: aload 7
    //   406: invokestatic 365	com/tencent/mm/pluginsdk/model/app/p:bj	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   409: astore_1
    //   410: aload_1
    //   411: ifnull +8 -> 419
    //   414: aload_1
    //   415: arraylength
    //   416: ifne +149 -> 565
    //   419: ldc_w 367
    //   422: ldc_w 369
    //   425: invokestatic 70	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: aconst_null
    //   429: astore_1
    //   430: aload_3
    //   431: astore 4
    //   433: aload_1
    //   434: astore_3
    //   435: aload 4
    //   437: astore_1
    //   438: ldc 62
    //   440: ldc_w 371
    //   443: iconst_3
    //   444: anewarray 373	java/lang/Object
    //   447: dup
    //   448: iconst_0
    //   449: aload 7
    //   451: aastore
    //   452: dup
    //   453: iconst_1
    //   454: aload_1
    //   455: aastore
    //   456: dup
    //   457: iconst_2
    //   458: aload_3
    //   459: aastore
    //   460: invokestatic 376	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: new 378	com/tencent/mm/plugin/wallet_index/c/f
    //   466: dup
    //   467: aload 6
    //   469: aload_2
    //   470: aload 7
    //   472: aload_1
    //   473: aload_3
    //   474: invokespecial 381	com/tencent/mm/plugin/wallet_index/c/f:<init>	(Lcom/tencent/mm/opensdk/modelpay/PayReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   477: astore 5
    //   479: aload 5
    //   481: astore 4
    //   483: aload 6
    //   485: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   488: invokestatic 384	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   491: ifne +37 -> 528
    //   494: aload 5
    //   496: astore 4
    //   498: aload 6
    //   500: getfield 277	com/tencent/mm/opensdk/modelpay/PayReq:prepayId	Ljava/lang/String;
    //   503: ldc_w 386
    //   506: invokevirtual 389	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   509: ifeq +19 -> 528
    //   512: new 391	com/tencent/mm/plugin/wallet_index/c/i
    //   515: dup
    //   516: aload 6
    //   518: aload_2
    //   519: aload 7
    //   521: aload_1
    //   522: aload_3
    //   523: invokespecial 392	com/tencent/mm/plugin/wallet_index/c/i:<init>	(Lcom/tencent/mm/opensdk/modelpay/PayReq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   526: astore 4
    //   528: invokestatic 238	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   531: pop
    //   532: invokestatic 242	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   535: getfield 248	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   538: aload 4
    //   540: invokevirtual 395	com/tencent/mm/plugin/wallet_index/c/f:getType	()I
    //   543: aload_0
    //   544: invokevirtual 397	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   547: invokestatic 238	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   550: pop
    //   551: invokestatic 242	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   554: getfield 248	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   557: aload 4
    //   559: iconst_0
    //   560: invokevirtual 400	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   563: pop
    //   564: return
    //   565: aload_1
    //   566: iconst_0
    //   567: aaload
    //   568: invokevirtual 406	android/content/pm/Signature:toByteArray	()[B
    //   571: invokestatic 412	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   574: astore_1
    //   575: goto -145 -> 430
    //   578: astore_3
    //   579: ldc 62
    //   581: aload_3
    //   582: ldc 39
    //   584: iconst_0
    //   585: anewarray 373	java/lang/Object
    //   588: invokestatic 416	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload 4
    //   593: astore_3
    //   594: goto -156 -> 438
    //   597: astore 5
    //   599: aload_3
    //   600: astore_1
    //   601: aload 5
    //   603: astore_3
    //   604: goto -25 -> 579
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	this	OrderHandlerUI
    //   363	238	1	localObject1	Object
    //   217	302	2	str1	String
    //   402	121	3	localObject2	Object
    //   578	4	3	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   593	11	3	localObject3	Object
    //   366	226	4	localObject4	Object
    //   477	18	5	localf	com.tencent.mm.plugin.wallet_index.c.f
    //   597	5	5	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   11	506	6	localPayReq	PayReq
    //   359	161	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   368	403	578	android/content/pm/PackageManager$NameNotFoundException
    //   403	410	597	android/content/pm/PackageManager$NameNotFoundException
    //   414	419	597	android/content/pm/PackageManager$NameNotFoundException
    //   419	428	597	android/content/pm/PackageManager$NameNotFoundException
    //   565	575	597	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm.getType() != 397) && (paramm.getType() != 2655)) {
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.fzn == 1)
    {
      localPayInfo.bUV = 36;
      g.DQ();
      g.DO().dJT.b(paramm.getType(), this);
      y.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.f)paramm;
      paramm = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
      if (paramm != null) {
        break label200;
      }
      paramm = null;
      label129:
      this.qLQ = paramm;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label221;
      }
      y.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
      this.qLO.errCode = -1;
      bl(paramString, true);
      paramInt1 = localPayInfo.bUV;
      if (this.qLN != null) {
        break label210;
      }
    }
    label200:
    label210:
    for (paramString = "";; paramString = this.qLN.prepayId)
    {
      aa.l(paramInt1, paramString, paramInt2);
      return;
      localPayInfo.bUV = 2;
      break;
      paramm = paramm.tyo;
      break label129;
    }
    label221:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
      this.qLO.errCode = -1;
      bl(paramString, true);
      paramInt1 = localPayInfo.bUV;
      if (this.qLN == null) {}
      for (paramString = "";; paramString = this.qLN.prepayId)
      {
        aa.l(paramInt1, paramString, paramInt2);
        return;
      }
    }
    paramm = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
    label332:
    Object localObject1;
    label356:
    Object localObject2;
    if (paramm == null)
    {
      paramInt1 = -1;
      paramm = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
      if (paramm != null) {
        break label478;
      }
      paramm = null;
      localObject1 = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
      if (localObject1 != null) {
        break label488;
      }
      localObject1 = null;
      localObject2 = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
      if (localObject2 != null) {
        break label498;
      }
      localObject2 = null;
      label380:
      localObject3 = (bcx)((com.tencent.mm.plugin.wallet_index.c.f)localObject3).dmK.ecF.ecN;
      if (localObject3 != null) {
        break label508;
      }
    }
    label478:
    label488:
    label498:
    label508:
    for (Object localObject3 = null;; localObject3 = ((bcx)localObject3).sZD)
    {
      y.i("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramm, localObject1, localObject2 });
      if (!bk.bl((String)localObject1)) {
        break label518;
      }
      y.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
      this.qLO.errCode = -1;
      bl(paramString, true);
      return;
      paramInt1 = paramm.jxl;
      break;
      paramm = paramm.jxm;
      break label332;
      localObject1 = ((bcx)localObject1).sZx;
      break label356;
      localObject2 = ((bcx)localObject2).sZy;
      break label380;
    }
    label518:
    aa.l(localPayInfo.bUV, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bk.bl(((cia)localObject3).tWB)))
    {
      this.qLS = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((cia)localObject3).tWB);
      paramString.putExtra("need_dialog", ((cia)localObject3).tWD);
      paramString.putExtra("dialog_text", ((cia)localObject3).tWE);
      paramString.putExtra("max_count", ((cia)localObject3).tWC.sHa);
      paramString.putExtra("inteval_time", ((cia)localObject3).tWC.sGZ);
      paramString.putExtra("default_wording", ((cia)localObject3).tWC.sHb);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.bMX = ((String)localObject1);
      this.qLP = false;
      return;
      localPayInfo.appId = this.qLN.appId;
      localPayInfo.bMX = ((String)localObject1);
      localPayInfo.partnerId = this.qLN.partnerId;
      localPayInfo.qLi = ((String)localObject2);
      localPayInfo.snW = String.valueOf(paramInt1);
      localPayInfo.aox = paramm;
      if (this.hSH > 0L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(641L, 2L, bk.co(this.hSH), true);
        if (localPayInfo.snX == null) {
          localPayInfo.snX = new Bundle();
        }
        localPayInfo.snX.putLong("wallet_pay_key_check_time", this.hSH);
      }
      com.tencent.mm.pluginsdk.wallet.h.a(this, localPayInfo, 123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */