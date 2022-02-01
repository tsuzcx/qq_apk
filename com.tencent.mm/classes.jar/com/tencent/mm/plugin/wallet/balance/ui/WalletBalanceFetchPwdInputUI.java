package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletBalanceFetchPwdInputUI
  extends WalletBaseUI
{
  private String Cyy = "";
  private WcPayCashierDialog Cyz;
  private String jXQ;
  private String mTitle = "";
  
  /* Error */
  private void showDialog()
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   9: ifnull +20 -> 29
    //   12: aload_0
    //   13: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   16: invokevirtual 52	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:isShowing	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   26: invokevirtual 55	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:dismiss	()V
    //   29: aload_0
    //   30: invokevirtual 59	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:getInput	()Landroid/os/Bundle;
    //   33: ldc 61
    //   35: invokevirtual 67	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   38: checkcast 69	com/tencent/mm/plugin/wallet_core/model/Orders
    //   41: astore 4
    //   43: aload_0
    //   44: invokevirtual 59	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:getInput	()Landroid/os/Bundle;
    //   47: ldc 71
    //   49: invokevirtual 75	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: new 77	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 78	java/util/ArrayList:<init>	()V
    //   60: astore_3
    //   61: aload_2
    //   62: invokestatic 84	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +367 -> 432
    //   68: new 86	org/json/JSONObject
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: new 91	com/tencent/mm/protocal/protobuf/ala
    //   81: dup
    //   82: invokespecial 92	com/tencent/mm/protocal/protobuf/ala:<init>	()V
    //   85: astore_2
    //   86: aload_2
    //   87: aload 5
    //   89: ldc 94
    //   91: iconst_0
    //   92: invokevirtual 98	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   95: putfield 102	com/tencent/mm/protocal/protobuf/ala:CYH	I
    //   98: aload_2
    //   99: aload 5
    //   101: ldc 104
    //   103: invokevirtual 107	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: putfield 110	com/tencent/mm/protocal/protobuf/ala:GkS	Ljava/lang/String;
    //   109: aload_2
    //   110: aload 5
    //   112: ldc 112
    //   114: invokevirtual 107	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 115	com/tencent/mm/protocal/protobuf/ala:GkT	Ljava/lang/String;
    //   120: aload_2
    //   121: getfield 102	com/tencent/mm/protocal/protobuf/ala:CYH	I
    //   124: istore_1
    //   125: iload_1
    //   126: iconst_1
    //   127: if_icmpne +305 -> 432
    //   130: aload_2
    //   131: getfield 110	com/tencent/mm/protocal/protobuf/ala:GkS	Ljava/lang/String;
    //   134: invokestatic 84	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   137: ifne +31 -> 168
    //   140: aload_0
    //   141: new 117	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   148: aload_2
    //   149: getfield 115	com/tencent/mm/protocal/protobuf/ala:GkT	Ljava/lang/String;
    //   152: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_2
    //   156: getfield 110	com/tencent/mm/protocal/protobuf/ala:GkS	Ljava/lang/String;
    //   159: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: putfield 27	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyy	Ljava/lang/String;
    //   168: aload 5
    //   170: ldc 128
    //   172: invokevirtual 107	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 5
    //   177: aload 5
    //   179: invokestatic 84	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   182: ifne +44 -> 226
    //   185: aload 5
    //   187: iconst_0
    //   188: invokestatic 134	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   191: astore 5
    //   193: aload_2
    //   194: new 136	com/tencent/mm/protocal/protobuf/alb
    //   197: dup
    //   198: invokespecial 137	com/tencent/mm/protocal/protobuf/alb:<init>	()V
    //   201: aload 5
    //   203: invokevirtual 141	com/tencent/mm/protocal/protobuf/alb:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   206: checkcast 136	com/tencent/mm/protocal/protobuf/alb
    //   209: putfield 145	com/tencent/mm/protocal/protobuf/ala:field_area_info	Lcom/tencent/mm/protocal/protobuf/alb;
    //   212: aload_3
    //   213: aload_2
    //   214: getfield 145	com/tencent/mm/protocal/protobuf/ala:field_area_info	Lcom/tencent/mm/protocal/protobuf/alb;
    //   217: getfield 149	com/tencent/mm/protocal/protobuf/alb:field_info	Ljava/util/LinkedList;
    //   220: invokeinterface 155 2 0
    //   225: pop
    //   226: iconst_1
    //   227: istore_1
    //   228: aload 4
    //   230: ifnull +196 -> 426
    //   233: aload 4
    //   235: getfield 159	com/tencent/mm/plugin/wallet_core/model/Orders:xYr	D
    //   238: dconst_0
    //   239: dcmpl
    //   240: ifle +186 -> 426
    //   243: iload_1
    //   244: ifne +182 -> 426
    //   247: aload_0
    //   248: invokevirtual 59	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:getInput	()Landroid/os/Bundle;
    //   251: ldc 161
    //   253: invokevirtual 75	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   256: astore_2
    //   257: aload_2
    //   258: invokestatic 84	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   261: ifne +114 -> 375
    //   264: aload_2
    //   265: iconst_1
    //   266: anewarray 163	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: aload 4
    //   273: getfield 159	com/tencent/mm/plugin/wallet_core/model/Orders:xYr	D
    //   276: aload 4
    //   278: getfield 166	com/tencent/mm/plugin/wallet_core/model/Orders:wCF	Ljava/lang/String;
    //   281: invokestatic 172	com/tencent/mm/wallet_core/ui/e:d	(DLjava/lang/String;)Ljava/lang/String;
    //   284: aastore
    //   285: invokestatic 178	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   288: astore_2
    //   289: aload_0
    //   290: new 48	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog
    //   293: dup
    //   294: aload_0
    //   295: invokevirtual 182	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   298: invokespecial 185	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:<init>	(Landroid/content/Context;)V
    //   301: putfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   304: aload_0
    //   305: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   308: aload_0
    //   309: getfield 25	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:mTitle	Ljava/lang/String;
    //   312: aload_0
    //   313: getfield 27	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyy	Ljava/lang/String;
    //   316: aload_2
    //   317: aload_3
    //   318: invokevirtual 188	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    //   321: aload_0
    //   322: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   325: new 8	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI$2
    //   328: dup
    //   329: aload_0
    //   330: invokespecial 191	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI$2:<init>	(Lcom/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI;)V
    //   333: putfield 195	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:Dlh	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog$a;
    //   336: aload_0
    //   337: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   340: invokevirtual 198	com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog:show	()V
    //   343: aload_0
    //   344: aload_0
    //   345: getfield 46	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:Cyz	Lcom/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierDialog;
    //   348: invokevirtual 202	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:addDialog	(Landroid/app/Dialog;)V
    //   351: ldc 38
    //   353: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: astore_2
    //   358: iconst_0
    //   359: istore_1
    //   360: ldc 207
    //   362: aload_2
    //   363: ldc 23
    //   365: iconst_0
    //   366: anewarray 163	java/lang/Object
    //   369: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: goto -144 -> 228
    //   375: aload_0
    //   376: invokevirtual 217	com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchPwdInputUI:getResources	()Landroid/content/res/Resources;
    //   379: ldc 218
    //   381: iconst_1
    //   382: anewarray 163	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 4
    //   389: getfield 159	com/tencent/mm/plugin/wallet_core/model/Orders:xYr	D
    //   392: aload 4
    //   394: getfield 166	com/tencent/mm/plugin/wallet_core/model/Orders:wCF	Ljava/lang/String;
    //   397: invokestatic 172	com/tencent/mm/wallet_core/ui/e:d	(DLjava/lang/String;)Ljava/lang/String;
    //   400: aastore
    //   401: invokevirtual 223	android/content/res/Resources:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   404: astore_2
    //   405: goto -116 -> 289
    //   408: astore_2
    //   409: iconst_1
    //   410: istore_1
    //   411: goto -51 -> 360
    //   414: astore_2
    //   415: iconst_0
    //   416: istore_1
    //   417: goto -57 -> 360
    //   420: astore_2
    //   421: iconst_1
    //   422: istore_1
    //   423: goto -63 -> 360
    //   426: ldc 23
    //   428: astore_2
    //   429: goto -140 -> 289
    //   432: iconst_0
    //   433: istore_1
    //   434: goto -206 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	WalletBalanceFetchPwdInputUI
    //   124	310	1	i	int
    //   52	265	2	localObject1	Object
    //   357	6	2	localJSONException1	org.json.JSONException
    //   404	1	2	str1	String
    //   408	1	2	localJSONException2	org.json.JSONException
    //   414	1	2	localIOException1	java.io.IOException
    //   420	1	2	localIOException2	java.io.IOException
    //   428	1	2	str2	String
    //   60	258	3	localArrayList	java.util.ArrayList
    //   41	352	4	localOrders	com.tencent.mm.plugin.wallet_core.model.Orders
    //   76	126	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   68	125	357	org/json/JSONException
    //   130	168	408	org/json/JSONException
    //   168	226	408	org/json/JSONException
    //   68	125	414	java/io/IOException
    //   130	168	420	java/io/IOException
    //   168	226	420	java/io/IOException
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(68562);
    if (paramInt == 0)
    {
      finish();
      AppMethodBeat.o(68562);
      return;
    }
    if (paramInt == 1) {
      showDialog();
    }
    AppMethodBeat.o(68562);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(68559);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.mTitle = getInput().getString("key_pwd_cash_title");
    this.Cyy = getInput().getString("key_pwd_cash_money");
    this.jXQ = getInput().getString("key_report_session_id");
    ad.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[] { bt.nullAsNil(this.Cyy), bt.nullAsNil(this.mTitle) });
    if ((!bt.isNullOrNil(this.mTitle)) && (!bt.isNullOrNil(this.Cyy))) {}
    while (i == 0)
    {
      h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68556);
          WalletBalanceFetchPwdInputUI.this.finish();
          AppMethodBeat.o(68556);
        }
      });
      AppMethodBeat.o(68559);
      return;
      i = 0;
    }
    d.yBQ.asyncReportPaySecurityInfoThroughCgi();
    showDialog();
    AppMethodBeat.o(68559);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(68560);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn, paramBoolean);
    if ((paramn instanceof b)) {
      setAuthState(false);
    }
    AppMethodBeat.o(68560);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI
 * JD-Core Version:    0.7.0.1
 */