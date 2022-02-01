package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.model.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class e
{
  protected WeakReference<Context> agRC = new WeakReference(null);
  protected WeakReference<e.a> dv;
  public Bundle hPH = new Bundle();
  
  private static String gW(Object paramObject)
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
  
  private String w(Object... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("this %s, procname %s", new Object[] { this, fud() }));
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      Log.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
      return localStringBuilder.toString();
    }
    int j = paramVarArgs.length - 1;
    while (i < j)
    {
      localStringBuilder.append(gW(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(gW(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public final void P(Object... paramVarArgs)
  {
    Log.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[] { w(paramVarArgs) });
  }
  
  public void Z(Activity paramActivity)
  {
    P(new Object[] { "finishActivity", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
  }
  
  public int a(MMActivity paramMMActivity, int paramInt)
  {
    return -1;
  }
  
  public g a(MMActivity paramMMActivity, i parami)
  {
    return null;
  }
  
  public e a(Activity paramActivity, Bundle paramBundle)
  {
    return this;
  }
  
  public abstract void a(Activity paramActivity, int paramInt, Bundle paramBundle);
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt)
  {
    b(paramActivity, paramClass, null, paramInt);
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    P(new Object[] { "endProcess2", paramActivity, paramClass, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    if ((this.dv != null) && (this.dv.get() != null)) {
      paramIntent = ((e.a)this.dv.get()).v(paramInt, this.hPH);
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
        paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramClass.aYi(), "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramClass.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (this.hPH != null) {
          this.hPH.clear();
        }
        a.remove(getClass().hashCode());
        return;
        localIntent = new Intent(paramActivity, paramClass);
        localIntent.putExtra("key_process_is_stay", paramBoolean);
      }
    }
  }
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramClass, paramInt, null, paramBoolean);
  }
  
  protected final void a(Activity paramActivity, Class<?> paramClass, Intent paramIntent)
  {
    a(paramActivity, paramClass, -1, paramIntent, true);
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    P(new Object[] { "startActivityForResult1", paramActivity, paramClass, paramBundle, Integer.valueOf(paramInt) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramClass).aYi(), "com/tencent/mm/wallet_core/WalletProcess", "startActivityForResult", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    if (paramBundle != null) {
      this.hPH.putAll(paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle1, Bundle paramBundle2)
  {
    P(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle1 });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    if (paramBundle2 != null)
    {
      paramClass.putExtras(paramBundle2);
      Log.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[] { paramClass.getExtras().toString() });
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramClass.aYi(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle1 != null) {
      this.hPH.putAll(paramBundle1);
    }
    Log.d("MicroMsg.ProcessManager", "bankcard tag :" + jOf());
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    P(new Object[] { "endProcess3", paramActivity, paramString1, paramString2, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    Intent localIntent1 = null;
    if (this.dv.get() != null) {
      localIntent1 = ((e.a)this.dv.get()).v(paramInt, this.hPH);
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
      com.tencent.mm.br.c.b(paramActivity, paramString1, paramString2, localIntent2);
      if (this.hPH != null) {
        this.hPH.clear();
      }
      a.remove(getClass().hashCode());
      return;
      localIntent2 = new Intent();
      localIntent2.putExtra("key_process_is_stay", paramBoolean);
    }
  }
  
  protected final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt, null, paramBoolean);
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    P(new Object[] { "startActivity3", paramActivity, paramString1, paramString2, paramBundle });
    Class localClass = com.tencent.mm.br.c.pu(paramString1, paramString2);
    if (localClass != null)
    {
      b(paramActivity, localClass, paramBundle);
      return;
    }
    Log.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + paramString1 + paramString2);
  }
  
  public final void a(e.a parama, Context paramContext)
  {
    this.dv = new WeakReference(parama);
    this.agRC = new WeakReference(paramContext);
  }
  
  public void a(WalletBaseUI paramWalletBaseUI) {}
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public final void b(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    P(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.dv.get() != null) {
      ((e.a)this.dv.get()).v(paramInt, paramBundle);
    }
    if (paramBundle != null) {
      paramBundle.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public abstract void b(Activity paramActivity, Bundle paramBundle);
  
  public final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    P(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramClass.aYi(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle != null) {
      this.hPH.putAll(paramBundle);
    }
    Log.d("MicroMsg.ProcessManager", "bankcard tag :" + jOf());
  }
  
  protected final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    P(new Object[] { "finishActivity", paramActivity, paramClass, "errCode ".concat(String.valueOf(paramInt)) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    if (paramBundle != null) {
      paramClass.putExtras(paramBundle);
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramClass.aYi(), "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.hPH.putInt("key_err_code", paramInt);
  }
  
  public void b(WalletBaseUI paramWalletBaseUI) {}
  
  protected final void c(Activity paramActivity, Class<?> paramClass)
  {
    a(paramActivity, paramClass, -1, null, true);
  }
  
  public abstract boolean c(Activity paramActivity, Bundle paramBundle);
  
  public final e cg(Bundle paramBundle)
  {
    this.hPH.putAll(paramBundle);
    return this;
  }
  
  public final void cn(Activity paramActivity)
  {
    P(new Object[] { "specEndProcess", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.hPH != null) {
      this.hPH.clear();
    }
    a.remove(getClass().hashCode());
    ifR();
  }
  
  public final void co(Activity paramActivity)
  {
    P(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.hPH != null) {
      this.hPH.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public abstract String fud();
  
  protected final void g(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1, true);
  }
  
  public abstract void i(Activity paramActivity, int paramInt);
  
  public void ifR() {}
  
  public final boolean ill()
  {
    return this.hPH.getBoolean("key_is_oversea", false);
  }
  
  public boolean j(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void jOd()
  {
    this.dv = null;
    this.agRC = null;
  }
  
  public final Context jOe()
  {
    if (this.agRC != null) {
      return (Context)this.agRC.get();
    }
    return null;
  }
  
  public final int jOf()
  {
    return this.hPH.getInt("key_support_bankcard", 1);
  }
  
  public final boolean jOg()
  {
    boolean bool = false;
    if (this.hPH.getInt("key_pay_flag", 0) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean jOh()
  {
    return this.hPH.getInt("key_pay_flag", 0) == 1;
  }
  
  public final boolean jOi()
  {
    boolean bool = false;
    if (this.hPH.getInt("key_pay_flag", 0) == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean jOj()
  {
    boolean bool2 = false;
    String str = this.hPH.getString("key_bank_username");
    Log.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.hPH.getBoolean("key_is_follow_bank_username", false) + ", username : " + str);
    boolean bool1 = bool2;
    if (this.hPH.getBoolean("key_is_follow_bank_username", false))
    {
      bool1 = bool2;
      if (!Util.isNullOrNil(str))
      {
        h.baF();
        h.baD().mCm.a(new t(str), 0);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.e
 * JD-Core Version:    0.7.0.1
 */