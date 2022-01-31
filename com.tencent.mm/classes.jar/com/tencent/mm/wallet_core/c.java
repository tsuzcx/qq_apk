package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class c
{
  public Bundle kke = new Bundle();
  protected c.a wAe;
  
  private static String cl(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof Bundle)) {
      return String.format("Bundle: %s, ", new Object[] { paramObject.toString() });
    }
    if ((paramObject instanceof Context)) {
      return String.format("Context: %s, ", new Object[] { paramObject.toString() });
    }
    if ((paramObject instanceof Class)) {
      return String.format("Class: %s, ", new Object[] { ((Class)paramObject).getSimpleName() });
    }
    return String.format("Value: %s, ", new Object[] { paramObject.toString() });
  }
  
  public final void A(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("this %s, procname %s", new Object[] { this, aTh() }));
    if (paramVarArgs.length <= 0) {
      y.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
    }
    for (paramVarArgs = localStringBuilder.toString();; paramVarArgs = localStringBuilder.toString())
    {
      y.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[] { paramVarArgs });
      return;
      int j = paramVarArgs.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(cl(paramVarArgs[i])).append(',');
        i += 1;
      }
      localStringBuilder.append(cl(paramVarArgs[j]));
    }
  }
  
  public void E(Activity paramActivity)
  {
    A(new Object[] { "finishActivity", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
  }
  
  public int a(MMActivity paramMMActivity, int paramInt)
  {
    return -1;
  }
  
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    return this;
  }
  
  public com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    return null;
  }
  
  public abstract void a(Activity paramActivity, int paramInt, Bundle paramBundle);
  
  public final void a(Activity paramActivity, Class<?> paramClass, int paramInt)
  {
    A(new Object[] { "finishActivity", paramActivity, paramClass, "errCode " + paramInt });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    paramActivity.startActivity(paramClass);
    this.kke.putInt("key_err_code", paramInt);
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    A(new Object[] { "endProcess2", paramActivity, paramClass, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    if (this.wAe != null) {
      paramIntent = this.wAe.m(paramInt, this.kke);
    }
    for (;;)
    {
      Intent localIntent;
      if (paramIntent != null)
      {
        localIntent = paramIntent;
        if (paramIntent.getExtras() != null)
        {
          localIntent = paramIntent;
          if (!paramIntent.getExtras().containsKey("key_process_is_stay"))
          {
            paramIntent.putExtra("key_process_is_stay", true);
            localIntent = paramIntent;
          }
        }
      }
      for (;;)
      {
        if (paramClass != null) {
          localIntent.setClass(paramActivity, paramClass);
        }
        localIntent.addFlags(67108864);
        localIntent.putExtra("key_process_is_end", true);
        paramActivity.startActivity(localIntent);
        if (this.kke != null) {
          this.kke.clear();
        }
        a.remove(getClass().hashCode());
        return;
        localIntent = new Intent(paramActivity, paramClass);
        localIntent.putExtra("key_process_is_stay", paramBoolean);
      }
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramClass, paramInt, null, paramBoolean);
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Intent paramIntent)
  {
    a(paramActivity, paramClass, -1, paramIntent, true);
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    A(new Object[] { "startActivityForResult1", paramActivity, paramClass, paramBundle, Integer.valueOf(paramInt) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    paramActivity.startActivityForResult(paramClass, paramInt);
    if (paramBundle != null) {
      this.kke.putAll(paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle1, Bundle paramBundle2)
  {
    A(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle1 });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    if (paramBundle2 != null)
    {
      paramClass.putExtras(paramBundle2);
      y.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[] { paramClass.getExtras().toString() });
    }
    paramActivity.startActivity(paramClass);
    if (paramBundle1 != null) {
      this.kke.putAll(paramBundle1);
    }
    y.d("MicroMsg.ProcessManager", "bankcard tag :" + cMm());
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    A(new Object[] { "endProcess3", paramActivity, paramString1, paramString2, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    Intent localIntent1 = null;
    if (this.wAe != null) {
      localIntent1 = this.wAe.m(paramInt, this.kke);
    }
    Intent localIntent2;
    if (paramIntent != null)
    {
      localIntent2 = paramIntent;
      if (paramIntent.getExtras() != null)
      {
        localIntent2 = paramIntent;
        if (!paramIntent.getExtras().containsKey("key_process_is_stay"))
        {
          paramIntent.putExtra("key_process_is_stay", true);
          localIntent2 = paramIntent;
        }
      }
    }
    for (;;)
    {
      if (localIntent1 != null) {
        localIntent2.putExtras(localIntent1);
      }
      localIntent2.addFlags(67108864);
      localIntent2.putExtra("key_process_is_end", true);
      d.b(paramActivity, paramString1, paramString2, localIntent2);
      if (this.kke != null) {
        this.kke.clear();
      }
      a.remove(getClass().hashCode());
      return;
      localIntent2 = new Intent();
      localIntent2.putExtra("key_process_is_stay", paramBoolean);
    }
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt, null, paramBoolean);
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    A(new Object[] { "startActivity3", paramActivity, paramString1, paramString2, paramBundle });
    Class localClass = d.fZ(paramString1, paramString2);
    if (localClass != null)
    {
      b(paramActivity, localClass, paramBundle);
      return;
    }
    y.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + paramString1 + paramString2);
  }
  
  public final void a(c.a parama)
  {
    this.wAe = parama;
  }
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public abstract String aTh();
  
  public final void ak(Activity paramActivity)
  {
    A(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.kke != null) {
      this.kke.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public final c au(Bundle paramBundle)
  {
    this.kke.putAll(paramBundle);
    return this;
  }
  
  public abstract void b(Activity paramActivity, int paramInt);
  
  public abstract void b(Activity paramActivity, Bundle paramBundle);
  
  public final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    A(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramActivity.startActivity(paramClass);
    if (paramBundle != null) {
      this.kke.putAll(paramBundle);
    }
    y.d("MicroMsg.ProcessManager", "bankcard tag :" + cMm());
  }
  
  public final boolean bXd()
  {
    return this.kke.getBoolean("key_is_oversea", false);
  }
  
  public final void c(Activity paramActivity, Class<?> paramClass)
  {
    a(paramActivity, paramClass, -1, null, true);
  }
  
  public abstract boolean c(Activity paramActivity, Bundle paramBundle);
  
  public final int cMm()
  {
    return this.kke.getInt("key_support_bankcard", 1);
  }
  
  public final boolean cMn()
  {
    boolean bool = false;
    if (this.kke.getInt("key_pay_flag", 0) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean cMo()
  {
    return this.kke.getInt("key_pay_flag", 0) == 1;
  }
  
  public final boolean cMp()
  {
    boolean bool = false;
    if (this.kke.getInt("key_pay_flag", 0) == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean cMq()
  {
    boolean bool2 = false;
    String str = this.kke.getString("key_bank_username");
    y.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.kke.getBoolean("key_is_follow_bank_username", false) + ", username : " + str);
    boolean bool1 = bool2;
    if (this.kke.getBoolean("key_is_follow_bank_username", false))
    {
      bool1 = bool2;
      if (!bk.bl(str))
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.wallet_core.c.p(str), 0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void d(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1, true);
  }
  
  public boolean h(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void l(Activity paramActivity, Bundle paramBundle)
  {
    A(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.wAe != null) {
      this.wAe.m(0, paramBundle);
    }
    paramBundle.clear();
    a.remove(getClass().hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c
 * JD-Core Version:    0.7.0.1
 */