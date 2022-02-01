package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b
{
  public static long Dql = 0L;
  private String DpO;
  String DpP;
  private d Dqi;
  private d Dqj;
  private c Dqk;
  private d Dqm;
  private com.tencent.mm.plugin.wallet_index.b.a.a Dqn;
  private com.tencent.mm.plugin.wallet_index.b.a.b Dqo;
  String Dqp;
  BroadcastReceiver mReceiver;
  String pFG;
  
  public a(Activity paramActivity, c paramc, d paramd)
  {
    AppMethodBeat.i(71854);
    this.Dqi = null;
    this.Dqj = null;
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
            public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymous2b, com.tencent.mm.plugin.wallet_index.b.a.b paramAnonymous2b1)
            {
              AppMethodBeat.i(71852);
              ad.d("MicroMsg.GoogleWallet", "Query inventory finished.");
              if ((paramAnonymous2b.eIZ()) || (paramAnonymous2b1 == null))
              {
                ad.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(paramAnonymous2b)));
                AppMethodBeat.o(71852);
                return;
              }
              ad.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
              a.a(a.this, paramAnonymous2b1);
              paramAnonymous2b = a.c(a.this);
              ArrayList localArrayList = new ArrayList(paramAnonymous2b1.DpH.keySet());
              paramAnonymous2b.Dqw.clear();
              paramAnonymous2b.Dqw.addAll(localArrayList);
              paramAnonymous2b = new ArrayList(paramAnonymous2b1.DpH.values());
              if (paramAnonymous2b.size() > 0)
              {
                paramAnonymous2b = paramAnonymous2b.iterator();
                while (paramAnonymous2b.hasNext())
                {
                  paramAnonymous2b1 = (com.tencent.mm.plugin.wallet_index.b.a.c)paramAnonymous2b.next();
                  ad.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + paramAnonymous2b1.pFG + ",billNo:" + paramAnonymous2b1.DpM);
                  g.ajD();
                  g.ajB().gAO.a(a.c(a.this).a(paramAnonymous2b1, true), 0);
                }
                AppMethodBeat.o(71852);
                return;
              }
              ad.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
              if (!bool) {
                ad.d("MicroMsg.GoogleWallet", "unknown_purchase");
              }
              for (paramAnonymous2b = com.tencent.mm.plugin.wallet_index.c.b.cr(5, "");; paramAnonymous2b = com.tencent.mm.plugin.wallet_index.c.b.cr(0, ""))
              {
                if (a.d(a.this) != null) {
                  a.d(a.this).a(paramAnonymous2b, null);
                }
                AppMethodBeat.o(71852);
                return;
                ad.d("MicroMsg.GoogleWallet", "result ok");
              }
            }
          });
        }
        AppMethodBeat.o(71853);
      }
    };
    this.Dqm = paramd;
    Dql = 0L;
    this.Dqk = paramc;
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
    paramc.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
    paramActivity.registerReceiver(this.mReceiver, paramc);
    this.Dqn = new com.tencent.mm.plugin.wallet_index.b.a.a();
    AppMethodBeat.o(71854);
  }
  
  private static void b(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(71857);
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", localb.uDC);
    localIntent.putExtra("key_err_msg", localb.uDD);
    localIntent.putExtra("key_launch_ts", Dql);
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71857);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71855);
    this.Dqi = paramd;
    this.pFG = this.Dqk.DpV.wMh;
    this.DpP = this.Dqk.DpV.wDS;
    this.DpO = this.Dqk.DpV.GuI;
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("product_id", this.pFG);
    this.Dqp = this.Dqk.DpV.GKd;
    Object localObject1 = this.Dqp;
    Object localObject2 = this.DpP;
    String str = this.DpO;
    paramd = (d)localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      paramd = "";
    }
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    localObject2 = str;
    if (bt.isNullOrNil(str)) {
      localObject2 = "";
    }
    localIntent.putExtra("developer_pay_load", paramd + "[#]" + (String)localObject1 + "[#]" + (String)localObject2);
    if (!paramMMActivity.getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty())
    {
      Dql = bt.flT();
      ad.i("MicroMsg.GoogleWallet", "GWallet Found!");
      paramMMActivity.startActivityForResult(localIntent, 10001);
    }
    for (;;)
    {
      AppMethodBeat.o(71855);
      return 10001;
      ad.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(3, "");
      if (this.Dqi != null) {
        this.Dqi.a(paramMMActivity, null);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71860);
    this.Dqj = paramd;
    ad.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
    com.tencent.mm.plugin.wallet_index.b.a.b localb = this.Dqo;
    paramd = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      localObject = (com.tencent.mm.plugin.wallet_index.b.a.c)localb.DpH.get(localObject);
      if (localObject != null) {
        paramd.add(((com.tencent.mm.plugin.wallet_index.b.a.c)localObject).mToken);
      }
    }
    if (paramd.size() > 0)
    {
      paramArrayList = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
      paramArrayList.setPackage("com.tencent.mm");
      paramArrayList.putStringArrayListExtra("tokens", paramd);
      paramArrayList.putExtra("IS_FAILED_CONSUME", paramBoolean);
      paramMMActivity.sendBroadcast(paramArrayList);
      AppMethodBeat.o(71860);
      return;
    }
    paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cr(0, "");
    if (this.Dqj != null) {
      this.Dqj.a(paramMMActivity, null);
    }
    AppMethodBeat.o(71860);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71858);
    if (paramInt1 == 10001)
    {
      ad.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("RESPONSE_CODE", 0);
        if ((paramInt1 == 3) || (paramInt1 == 105))
        {
          ab.e(this.Dqp, this.pFG, this.DpP, paramInt1, "");
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
    paramMMActivity = this.Dqj;
    String str1 = this.Dqp;
    String str2 = this.pFG;
    String str3 = this.DpP;
    paramInt1 = com.tencent.mm.plugin.wallet_index.b.a.a.aV(paramIntent);
    ad.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(paramInt1));
    paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt1, "");
    ab.e(str1, str2, str3, paramInt1, paramIntent.uDD);
    if (paramMMActivity != null) {
      paramMMActivity.a(paramIntent, null);
    }
    AppMethodBeat.o(71858);
    return true;
  }
  
  public final void d(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71859);
    ad.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
    ad.d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(paramBoolean)));
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("is_direct", paramBoolean);
    paramMMActivity.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(71859);
  }
  
  public final int eJa()
  {
    return 3;
  }
  
  public final void p(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71856);
    try
    {
      paramMMActivity.unregisterReceiver(this.mReceiver);
      if (!bt.jh(paramMMActivity))
      {
        ad.d("MicroMsg.GoogleWallet", "close front UI.");
        Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        localIntent.setPackage("com.tencent.mm");
        paramMMActivity.sendBroadcast(localIntent);
      }
      ad.d("MicroMsg.GoogleWallet", "Destroying helper.");
      AppMethodBeat.o(71856);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ad.e("MicroMsg.GoogleWallet", localIllegalArgumentException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a
 * JD-Core Version:    0.7.0.1
 */