package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b
{
  private static final String Ire;
  public static long Iri;
  private String IqF;
  String IqG;
  private d Irf;
  private d Irg;
  private c Irh;
  private d Irj;
  private com.tencent.mm.plugin.wallet_index.b.a.a Irk;
  private com.tencent.mm.plugin.wallet_index.b.a.b Irl;
  String Irm;
  BroadcastReceiver mReceiver;
  String rcD;
  
  static
  {
    AppMethodBeat.i(214276);
    Ire = MMApplicationContext.getApplicationId();
    Iri = 0L;
    AppMethodBeat.o(214276);
  }
  
  public a(Activity paramActivity, c paramc, d paramd)
  {
    AppMethodBeat.i(71854);
    this.Irf = null;
    this.Irg = null;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(71853);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(paramAnonymousContext))
        {
          paramAnonymousContext = a.this;
          a.b(a.this);
          a.a(paramAnonymousContext, com.tencent.mm.plugin.wallet_index.b.a.a.a(paramAnonymousIntent, a.a(a.this)));
          AppMethodBeat.o(71853);
          return;
        }
        if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(paramAnonymousContext))
        {
          final boolean bool = paramAnonymousIntent.getBooleanExtra("is_direct", true);
          a.b(a.this);
          com.tencent.mm.plugin.wallet_index.b.a.a.a(paramAnonymousIntent, new a.a()
          {
            public final void a(com.tencent.mm.plugin.wallet_index.c.c paramAnonymous2c, com.tencent.mm.plugin.wallet_index.b.a.b paramAnonymous2b)
            {
              AppMethodBeat.i(71852);
              Log.d("MicroMsg.GoogleWallet", "Query inventory finished.");
              if ((paramAnonymous2c.isFailure()) || (paramAnonymous2b == null))
              {
                Log.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(paramAnonymous2c)));
                AppMethodBeat.o(71852);
                return;
              }
              Log.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
              a.a(a.this, paramAnonymous2b);
              paramAnonymous2c = a.c(a.this);
              ArrayList localArrayList = new ArrayList(paramAnonymous2b.mPurchaseMap.keySet());
              paramAnonymous2c.Irt.clear();
              paramAnonymous2c.Irt.addAll(localArrayList);
              paramAnonymous2c = new ArrayList(paramAnonymous2b.mPurchaseMap.values());
              if (paramAnonymous2c.size() > 0)
              {
                paramAnonymous2c = paramAnonymous2c.iterator();
                while (paramAnonymous2c.hasNext())
                {
                  paramAnonymous2b = (com.tencent.mm.plugin.wallet_index.b.a.c)paramAnonymous2c.next();
                  Log.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + paramAnonymous2b.rcD + ",billNo:" + paramAnonymous2b.IqE);
                  g.aAi();
                  g.aAg().hqi.a(a.c(a.this).a(paramAnonymous2b, true), 0);
                }
                AppMethodBeat.o(71852);
                return;
              }
              Log.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
              if (!bool) {
                Log.d("MicroMsg.GoogleWallet", "unknown_purchase");
              }
              for (paramAnonymous2c = com.tencent.mm.plugin.wallet_index.c.c.cJ(5, "");; paramAnonymous2c = com.tencent.mm.plugin.wallet_index.c.c.cJ(0, ""))
              {
                if (a.d(a.this) != null) {
                  a.d(a.this).a(paramAnonymous2c, null);
                }
                AppMethodBeat.o(71852);
                return;
                Log.d("MicroMsg.GoogleWallet", "result ok");
              }
            }
          });
        }
        AppMethodBeat.o(71853);
      }
    };
    this.Irj = paramd;
    Iri = 0L;
    this.Irh = paramc;
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
    paramc.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
    paramActivity.registerReceiver(this.mReceiver, paramc);
    this.Irk = new com.tencent.mm.plugin.wallet_index.b.a.a();
    AppMethodBeat.o(71854);
  }
  
  private static void b(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(71857);
    com.tencent.mm.plugin.wallet_index.c.c localc = com.tencent.mm.plugin.wallet_index.c.c.cJ(paramInt, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", localc.mResponse);
    localIntent.putExtra("key_err_msg", localc.mMessage);
    localIntent.putExtra("key_launch_ts", Iri);
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71857);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71855);
    this.Irf = paramd;
    this.rcD = this.Irh.IqP.AZx;
    this.IqG = this.Irh.IqP.price;
    this.IqF = this.Irh.IqP.LSm;
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
    localIntent.setPackage(Ire);
    localIntent.putExtra("product_id", this.rcD);
    this.Irm = this.Irh.IqP.MiH;
    Object localObject1 = this.Irm;
    Object localObject2 = this.IqG;
    String str = this.IqF;
    paramd = (d)localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      paramd = "";
    }
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    localObject2 = str;
    if (Util.isNullOrNil(str)) {
      localObject2 = "";
    }
    localIntent.putExtra("developer_pay_load", paramd + "[#]" + (String)localObject1 + "[#]" + (String)localObject2);
    if (!paramMMActivity.getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty())
    {
      Iri = Util.nowMilliSecond();
      Log.i("MicroMsg.GoogleWallet", "GWallet Found!");
      paramMMActivity.startActivityForResult(localIntent, 10001);
    }
    for (;;)
    {
      AppMethodBeat.o(71855);
      return 10001;
      Log.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(3, "");
      if (this.Irf != null) {
        this.Irf.a(paramMMActivity, null);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71860);
    this.Irg = paramd;
    Log.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
    com.tencent.mm.plugin.wallet_index.b.a.b localb = this.Irl;
    paramd = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      localObject = (com.tencent.mm.plugin.wallet_index.b.a.c)localb.mPurchaseMap.get(localObject);
      if (localObject != null) {
        paramd.add(((com.tencent.mm.plugin.wallet_index.b.a.c)localObject).mToken);
      }
    }
    if (paramd.size() > 0)
    {
      paramArrayList = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
      paramArrayList.setPackage(Ire);
      paramArrayList.putStringArrayListExtra("tokens", paramd);
      paramArrayList.putExtra("IS_FAILED_CONSUME", paramBoolean);
      paramMMActivity.sendBroadcast(paramArrayList);
      AppMethodBeat.o(71860);
      return;
    }
    paramMMActivity = com.tencent.mm.plugin.wallet_index.c.c.cJ(0, "");
    if (this.Irg != null) {
      this.Irg.a(paramMMActivity, null);
    }
    AppMethodBeat.o(71860);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71858);
    if (paramInt1 == 10001)
    {
      Log.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("RESPONSE_CODE", 0);
        if ((paramInt1 == 3) || (paramInt1 == 105))
        {
          ab.e(this.Irm, this.rcD, this.IqG, paramInt1, "");
          b(paramMMActivity, paramInt1);
          AppMethodBeat.o(71858);
          return true;
        }
        if (paramInt1 == 100000001)
        {
          b(paramMMActivity, paramInt1);
          AppMethodBeat.o(71858);
          return true;
        }
      }
      else
      {
        b(paramMMActivity, 1);
        AppMethodBeat.o(71858);
        return true;
      }
    }
    paramMMActivity = this.Irg;
    String str1 = this.Irm;
    String str2 = this.rcD;
    String str3 = this.IqG;
    paramInt1 = com.tencent.mm.plugin.wallet_index.b.a.a.bh(paramIntent);
    Log.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(paramInt1));
    paramIntent = com.tencent.mm.plugin.wallet_index.c.c.cJ(paramInt1, "");
    ab.e(str1, str2, str3, paramInt1, paramIntent.mMessage);
    if (paramMMActivity != null) {
      paramMMActivity.a(paramIntent, null);
    }
    AppMethodBeat.o(71858);
    return true;
  }
  
  public final void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71859);
    Log.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
    Log.d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(paramBoolean)));
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
    localIntent.setPackage(Ire);
    localIntent.putExtra("is_direct", paramBoolean);
    paramMMActivity.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(71859);
  }
  
  public final int fUr()
  {
    return 3;
  }
  
  public final void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71856);
    try
    {
      paramMMActivity.unregisterReceiver(this.mReceiver);
      if (!Util.isTopActivity(paramMMActivity))
      {
        Log.d("MicroMsg.GoogleWallet", "close front UI.");
        Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        localIntent.setPackage(Ire);
        paramMMActivity.sendBroadcast(localIntent);
      }
      Log.d("MicroMsg.GoogleWallet", "Destroying helper.");
      AppMethodBeat.o(71856);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GoogleWallet", localIllegalArgumentException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a
 * JD-Core Version:    0.7.0.1
 */