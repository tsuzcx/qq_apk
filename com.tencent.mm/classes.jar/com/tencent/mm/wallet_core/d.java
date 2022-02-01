package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class d
{
  public WeakReference<Context> LTg = new WeakReference(null);
  protected WeakReference<d.a> Mt;
  public Bundle dyY = new Bundle();
  
  private static String eq(Object paramObject)
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
  
  private String u(Object... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("this %s, procname %s", new Object[] { this, cSH() }));
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ae.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
      return localStringBuilder.toString();
    }
    int j = paramVarArgs.length - 1;
    while (i < j)
    {
      localStringBuilder.append(eq(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(eq(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public final void J(Object... paramVarArgs)
  {
    ae.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[] { u(paramVarArgs) });
  }
  
  public void R(Activity paramActivity)
  {
    J(new Object[] { "finishActivity", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
  }
  
  public int a(MMActivity paramMMActivity, int paramInt)
  {
    return -1;
  }
  
  public com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    return null;
  }
  
  public d a(Activity paramActivity, Bundle paramBundle)
  {
    return this;
  }
  
  public abstract void a(Activity paramActivity, int paramInt, Bundle paramBundle);
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt)
  {
    b(paramActivity, paramClass, null, paramInt);
  }
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    J(new Object[] { "endProcess2", paramActivity, paramClass, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    if ((this.Mt != null) && (this.Mt.get() != null)) {
      paramIntent = ((d.a)this.Mt.get()).s(paramInt, this.dyY);
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
        paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.ahE(), "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramClass.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (this.dyY != null) {
          this.dyY.clear();
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
    J(new Object[] { "startActivityForResult1", paramActivity, paramClass, paramBundle, Integer.valueOf(paramInt) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    paramActivity.startActivityForResult(paramClass, paramInt);
    if (paramBundle != null) {
      this.dyY.putAll(paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle1, Bundle paramBundle2)
  {
    J(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle1 });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    if (paramBundle2 != null)
    {
      paramClass.putExtras(paramBundle2);
      ae.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[] { paramClass.getExtras().toString() });
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.ahE(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle1 != null) {
      this.dyY.putAll(paramBundle1);
    }
    ae.d("MicroMsg.ProcessManager", "bankcard tag :" + fVl());
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    J(new Object[] { "endProcess3", paramActivity, paramString1, paramString2, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    Intent localIntent1 = null;
    if (this.Mt.get() != null) {
      localIntent1 = ((d.a)this.Mt.get()).s(paramInt, this.dyY);
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
      com.tencent.mm.br.d.b(paramActivity, paramString1, paramString2, localIntent2);
      if (this.dyY != null) {
        this.dyY.clear();
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
    J(new Object[] { "startActivity3", paramActivity, paramString1, paramString2, paramBundle });
    Class localClass = com.tencent.mm.br.d.lK(paramString1, paramString2);
    if (localClass != null)
    {
      b(paramActivity, localClass, paramBundle);
      return;
    }
    ae.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + paramString1 + paramString2);
  }
  
  public final void a(d.a parama, Context paramContext)
  {
    this.Mt = new WeakReference(parama);
    this.LTg = new WeakReference(paramContext);
  }
  
  public void a(WalletBaseUI paramWalletBaseUI) {}
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public final void b(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    J(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.Mt.get() != null) {
      ((d.a)this.Mt.get()).s(paramInt, paramBundle);
    }
    if (paramBundle != null) {
      paramBundle.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public abstract void b(Activity paramActivity, Bundle paramBundle);
  
  public final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    J(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.ahE(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle != null) {
      this.dyY.putAll(paramBundle);
    }
    ae.d("MicroMsg.ProcessManager", "bankcard tag :" + fVl());
  }
  
  protected final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    J(new Object[] { "finishActivity", paramActivity, paramClass, "errCode ".concat(String.valueOf(paramInt)) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    if (paramBundle != null) {
      paramClass.putExtras(paramBundle);
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bc(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.ahE(), "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.dyY.putInt("key_err_code", paramInt);
  }
  
  public void b(WalletBaseUI paramWalletBaseUI) {}
  
  public final d bn(Bundle paramBundle)
  {
    this.dyY.putAll(paramBundle);
    return this;
  }
  
  public final void bt(Activity paramActivity)
  {
    J(new Object[] { "specEndProcess", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.dyY != null) {
      this.dyY.clear();
    }
    a.remove(getClass().hashCode());
    eGZ();
  }
  
  public final void bu(Activity paramActivity)
  {
    J(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.dyY != null) {
      this.dyY.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public final void c(Activity paramActivity, Class<?> paramClass)
  {
    a(paramActivity, paramClass, -1, null, true);
  }
  
  public abstract boolean c(Activity paramActivity, Bundle paramBundle);
  
  public abstract String cSH();
  
  protected final void e(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1, true);
  }
  
  public void eGZ() {}
  
  public final boolean eLI()
  {
    return this.dyY.getBoolean("key_is_oversea", false);
  }
  
  public final void fVk()
  {
    this.Mt = null;
    this.LTg = null;
  }
  
  public final int fVl()
  {
    return this.dyY.getInt("key_support_bankcard", 1);
  }
  
  public final boolean fVm()
  {
    boolean bool = false;
    if (this.dyY.getInt("key_pay_flag", 0) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean fVn()
  {
    return this.dyY.getInt("key_pay_flag", 0) == 1;
  }
  
  public final boolean fVo()
  {
    boolean bool = false;
    if (this.dyY.getInt("key_pay_flag", 0) == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean fVp()
  {
    boolean bool2 = false;
    String str = this.dyY.getString("key_bank_username");
    ae.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.dyY.getBoolean("key_is_follow_bank_username", false) + ", username : " + str);
    boolean bool1 = bool2;
    if (this.dyY.getBoolean("key_is_follow_bank_username", false))
    {
      bool1 = bool2;
      if (!bu.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(new t(str), 0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public abstract void g(Activity paramActivity, int paramInt);
  
  public boolean i(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d
 * JD-Core Version:    0.7.0.1
 */