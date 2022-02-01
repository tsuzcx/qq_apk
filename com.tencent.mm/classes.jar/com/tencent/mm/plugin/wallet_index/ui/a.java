package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b
{
  public static long BPT = 0L;
  private d BPQ;
  private d BPR;
  private c BPS;
  private d BPU;
  private com.tencent.mm.plugin.wallet_index.b.a.a BPV;
  private com.tencent.mm.plugin.wallet_index.b.a.b BPW;
  String BPX;
  private String BPw;
  String BPx;
  BroadcastReceiver mReceiver;
  String pbW;
  
  public a(Activity paramActivity, c paramc, d paramd)
  {
    AppMethodBeat.i(71854);
    this.BPQ = null;
    this.BPR = null;
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
              ac.d("MicroMsg.GoogleWallet", "Query inventory finished.");
              if ((paramAnonymous2b.euT()) || (paramAnonymous2b1 == null))
              {
                ac.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(paramAnonymous2b)));
                AppMethodBeat.o(71852);
                return;
              }
              ac.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
              a.a(a.this, paramAnonymous2b1);
              paramAnonymous2b = a.c(a.this);
              ArrayList localArrayList = new ArrayList(paramAnonymous2b1.BPp.keySet());
              paramAnonymous2b.BQe.clear();
              paramAnonymous2b.BQe.addAll(localArrayList);
              paramAnonymous2b = new ArrayList(paramAnonymous2b1.BPp.values());
              if (paramAnonymous2b.size() > 0)
              {
                paramAnonymous2b = paramAnonymous2b.iterator();
                while (paramAnonymous2b.hasNext())
                {
                  paramAnonymous2b1 = (com.tencent.mm.plugin.wallet_index.b.a.c)paramAnonymous2b.next();
                  ac.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + paramAnonymous2b1.pbW + ",billNo:" + paramAnonymous2b1.BPu);
                  g.agS();
                  g.agQ().ghe.a(a.c(a.this).a(paramAnonymous2b1, true), 0);
                }
                AppMethodBeat.o(71852);
                return;
              }
              ac.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
              if (!bool) {
                ac.d("MicroMsg.GoogleWallet", "unknown_purchase");
              }
              for (paramAnonymous2b = com.tencent.mm.plugin.wallet_index.c.b.cj(5, "");; paramAnonymous2b = com.tencent.mm.plugin.wallet_index.c.b.cj(0, ""))
              {
                if (a.d(a.this) != null) {
                  a.d(a.this).a(paramAnonymous2b, null);
                }
                AppMethodBeat.o(71852);
                return;
                ac.d("MicroMsg.GoogleWallet", "result ok");
              }
            }
          });
        }
        AppMethodBeat.o(71853);
      }
    };
    this.BPU = paramd;
    BPT = 0L;
    this.BPS = paramc;
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
    paramc.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
    paramActivity.registerReceiver(this.mReceiver, paramc);
    this.BPV = new com.tencent.mm.plugin.wallet_index.b.a.a();
    AppMethodBeat.o(71854);
  }
  
  private static void b(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(71857);
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cj(paramInt, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", localb.tAT);
    localIntent.putExtra("key_err_msg", localb.tAU);
    localIntent.putExtra("key_launch_ts", BPT);
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
    AppMethodBeat.o(71857);
  }
  
  public final int a(MMActivity paramMMActivity, d paramd)
  {
    AppMethodBeat.i(71855);
    this.BPQ = paramd;
    this.pbW = this.BPS.BPD.vFb;
    this.BPx = this.BPS.BPD.vyy;
    this.BPw = this.BPS.BPD.ELE;
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("product_id", this.pbW);
    this.BPX = this.BPS.BPD.FaE;
    Object localObject1 = this.BPX;
    Object localObject2 = this.BPx;
    String str = this.BPw;
    paramd = (d)localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      paramd = "";
    }
    localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2)) {
      localObject1 = "";
    }
    localObject2 = str;
    if (bs.isNullOrNil(str)) {
      localObject2 = "";
    }
    localIntent.putExtra("developer_pay_load", paramd + "[#]" + (String)localObject1 + "[#]" + (String)localObject2);
    if (!paramMMActivity.getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty())
    {
      BPT = bs.eWj();
      ac.i("MicroMsg.GoogleWallet", "GWallet Found!");
      paramMMActivity.startActivityForResult(localIntent, 10001);
    }
    for (;;)
    {
      AppMethodBeat.o(71855);
      return 10001;
      ac.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(3, "");
      if (this.BPQ != null) {
        this.BPQ.a(paramMMActivity, null);
      }
    }
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(71860);
    this.BPR = paramd;
    ac.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
    com.tencent.mm.plugin.wallet_index.b.a.b localb = this.BPW;
    paramd = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      localObject = (com.tencent.mm.plugin.wallet_index.b.a.c)localb.BPp.get(localObject);
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
    paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.cj(0, "");
    if (this.BPR != null) {
      this.BPR.a(paramMMActivity, null);
    }
    AppMethodBeat.o(71860);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71858);
    if (paramInt1 == 10001)
    {
      ac.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("RESPONSE_CODE", 0);
        if ((paramInt1 == 3) || (paramInt1 == 105))
        {
          ab.e(this.BPX, this.pbW, this.BPx, paramInt1, "");
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
    paramMMActivity = this.BPR;
    String str1 = this.BPX;
    String str2 = this.pbW;
    String str3 = this.BPx;
    paramInt1 = com.tencent.mm.plugin.wallet_index.b.a.a.aQ(paramIntent);
    ac.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(paramInt1));
    paramIntent = com.tencent.mm.plugin.wallet_index.c.b.cj(paramInt1, "");
    ab.e(str1, str2, str3, paramInt1, paramIntent.tAU);
    if (paramMMActivity != null) {
      paramMMActivity.a(paramIntent, null);
    }
    AppMethodBeat.o(71858);
    return true;
  }
  
  public final void d(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(71859);
    ac.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
    ac.d("MicroMsg.GoogleWallet", "is direct? ".concat(String.valueOf(paramBoolean)));
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("is_direct", paramBoolean);
    paramMMActivity.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(71859);
  }
  
  public final int euU()
  {
    return 3;
  }
  
  public final void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(71856);
    try
    {
      paramMMActivity.unregisterReceiver(this.mReceiver);
      if (!bs.iX(paramMMActivity))
      {
        ac.d("MicroMsg.GoogleWallet", "close front UI.");
        Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        localIntent.setPackage("com.tencent.mm");
        paramMMActivity.sendBroadcast(localIntent);
      }
      ac.d("MicroMsg.GoogleWallet", "Destroying helper.");
      AppMethodBeat.o(71856);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ac.e("MicroMsg.GoogleWallet", localIllegalArgumentException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a
 * JD-Core Version:    0.7.0.1
 */