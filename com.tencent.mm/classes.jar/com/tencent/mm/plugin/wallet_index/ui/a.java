package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements b
{
  public static long qLy = 0L;
  BroadcastReceiver hWU = new a.1(this);
  String iZD;
  private com.tencent.mm.plugin.wallet_index.b.a.a qLA;
  private com.tencent.mm.plugin.wallet_index.b.a.b qLB;
  String qLC;
  private String qLe;
  String qLf;
  private d qLv = null;
  private d qLw = null;
  private c qLx;
  private d qLz;
  
  public a(Activity paramActivity, c paramc, d paramd)
  {
    this.qLz = paramd;
    qLy = 0L;
    this.qLx = paramc;
    paramc = new IntentFilter();
    paramc.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
    paramc.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
    paramActivity.registerReceiver(this.hWU, paramc);
    this.qLA = new com.tencent.mm.plugin.wallet_index.b.a.a();
  }
  
  private static void b(MMActivity paramMMActivity, int paramInt)
  {
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.aP(paramInt, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", localb.ljp);
    localIntent.putExtra("key_err_msg", localb.ljq);
    localIntent.putExtra("key_launch_ts", qLy);
    paramMMActivity.setResult(-1, localIntent);
    paramMMActivity.finish();
  }
  
  public final void a(MMActivity paramMMActivity, d paramd)
  {
    this.qLv = paramd;
    this.iZD = this.qLx.qLk.mSq;
    this.qLf = this.qLx.qLk.mQn;
    this.qLe = this.qLx.qLk.taz;
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("product_id", this.iZD);
    this.qLC = this.qLx.qLk.tme;
    Object localObject1 = this.qLC;
    Object localObject2 = this.qLf;
    String str = this.qLe;
    paramd = (d)localObject1;
    if (bk.bl((String)localObject1)) {
      paramd = "";
    }
    localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      localObject1 = "";
    }
    localObject2 = str;
    if (bk.bl(str)) {
      localObject2 = "";
    }
    localIntent.putExtra("developer_pay_load", paramd + "[#]" + (String)localObject1 + "[#]" + (String)localObject2);
    if (!paramMMActivity.getPackageManager().queryIntentActivities(localIntent, 65536).isEmpty())
    {
      qLy = bk.UY();
      y.i("MicroMsg.GoogleWallet", "GWallet Found!");
      paramMMActivity.startActivityForResult(localIntent, 10001);
    }
    do
    {
      return;
      y.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(3, "");
    } while (this.qLv == null);
    this.qLv.a(paramMMActivity, null);
  }
  
  public final void a(MMActivity paramMMActivity, ArrayList<String> paramArrayList, d paramd, boolean paramBoolean)
  {
    this.qLw = paramd;
    y.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
    com.tencent.mm.plugin.wallet_index.b.a.b localb = this.qLB;
    paramd = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      localObject = (com.tencent.mm.plugin.wallet_index.b.a.c)localb.qKX.get(localObject);
      if (localObject != null) {
        paramd.add(((com.tencent.mm.plugin.wallet_index.b.a.c)localObject).fdD);
      }
    }
    if (paramd.size() > 0)
    {
      paramArrayList = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
      paramArrayList.setPackage("com.tencent.mm");
      paramArrayList.putStringArrayListExtra("tokens", paramd);
      paramArrayList.putExtra("IS_FAILED_CONSUME", paramBoolean);
      paramMMActivity.sendBroadcast(paramArrayList);
    }
    do
    {
      return;
      paramMMActivity = com.tencent.mm.plugin.wallet_index.c.b.aP(0, "");
    } while (this.qLw == null);
    this.qLw.a(paramMMActivity, null);
  }
  
  public final boolean a(MMActivity paramMMActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10001)
    {
      y.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramIntent != null)
      {
        paramInt1 = paramIntent.getIntExtra("RESPONSE_CODE", 0);
        if ((paramInt1 == 3) || (paramInt1 == 105))
        {
          w.c(this.qLC, this.iZD, this.qLf, paramInt1, "");
          b(paramMMActivity, paramInt1);
        }
      }
    }
    do
    {
      return true;
      if (paramInt1 == 100000001)
      {
        b(paramMMActivity, paramInt1);
        return true;
        b(paramMMActivity, 1);
        return true;
      }
      paramMMActivity = this.qLw;
      String str1 = this.qLC;
      String str2 = this.iZD;
      String str3 = this.qLf;
      paramInt1 = com.tencent.mm.plugin.wallet_index.b.a.a.aa(paramIntent);
      y.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(paramInt1));
      paramIntent = com.tencent.mm.plugin.wallet_index.c.b.aP(paramInt1, "");
      w.c(str1, str2, str3, paramInt1, paramIntent.ljq);
    } while (paramMMActivity == null);
    paramMMActivity.a(paramIntent, null);
    return true;
  }
  
  public final int bXz()
  {
    return 3;
  }
  
  public final void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    y.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
    y.d("MicroMsg.GoogleWallet", "is direct? " + paramBoolean);
    Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
    localIntent.setPackage("com.tencent.mm");
    localIntent.putExtra("is_direct", paramBoolean);
    paramMMActivity.startActivityForResult(localIntent, 10001);
  }
  
  public final void j(MMActivity paramMMActivity)
  {
    try
    {
      paramMMActivity.unregisterReceiver(this.hWU);
      if (!bk.bU(paramMMActivity))
      {
        y.d("MicroMsg.GoogleWallet", "close front UI.");
        Intent localIntent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        localIntent.setPackage("com.tencent.mm");
        paramMMActivity.sendBroadcast(localIntent);
      }
      y.d("MicroMsg.GoogleWallet", "Destroying helper.");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        y.e("MicroMsg.GoogleWallet", localIllegalArgumentException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a
 * JD-Core Version:    0.7.0.1
 */