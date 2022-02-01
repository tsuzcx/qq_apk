package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class d
{
  public WeakReference<Context> IbL = new WeakReference(null);
  protected WeakReference<d.a> JI;
  public Bundle dow = new Bundle();
  
  private static String ej(Object paramObject)
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
  
  private String t(Object... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("this %s, procname %s", new Object[] { this, cuB() }));
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ad.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
      return localStringBuilder.toString();
    }
    int j = paramVarArgs.length - 1;
    while (i < j)
    {
      localStringBuilder.append(ej(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(ej(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public final void H(Object... paramVarArgs)
  {
    ad.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[] { t(paramVarArgs) });
  }
  
  public void P(Activity paramActivity)
  {
    H(new Object[] { "finishActivity", paramActivity });
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
    H(new Object[] { "endProcess2", paramActivity, paramClass, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    if ((this.JI != null) && (this.JI.get() != null)) {
      paramIntent = ((d.a)this.JI.get()).q(paramInt, this.dow);
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
        paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.adn(), "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramClass.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "endProcess", "(Landroid/app/Activity;Ljava/lang/Class;ILandroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (this.dow != null) {
          this.dow.clear();
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
    H(new Object[] { "startActivityForResult1", paramActivity, paramClass, paramBundle, Integer.valueOf(paramInt) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    paramActivity.startActivityForResult(paramClass, paramInt);
    if (paramBundle != null) {
      this.dow.putAll(paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle1, Bundle paramBundle2)
  {
    H(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle1 });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    if (paramBundle2 != null)
    {
      paramClass.putExtras(paramBundle2);
      ad.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[] { paramClass.getExtras().toString() });
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.adn(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle1 != null) {
      this.dow.putAll(paramBundle1);
    }
    ad.d("MicroMsg.ProcessManager", "bankcard tag :" + fjq());
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    H(new Object[] { "endProcess3", paramActivity, paramString1, paramString2, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    Intent localIntent1 = null;
    if (this.JI.get() != null) {
      localIntent1 = ((d.a)this.JI.get()).q(paramInt, this.dow);
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
      com.tencent.mm.bs.d.b(paramActivity, paramString1, paramString2, localIntent2);
      if (this.dow != null) {
        this.dow.clear();
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
    H(new Object[] { "startActivity3", paramActivity, paramString1, paramString2, paramBundle });
    Class localClass = com.tencent.mm.bs.d.kH(paramString1, paramString2);
    if (localClass != null)
    {
      b(paramActivity, localClass, paramBundle);
      return;
    }
    ad.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + paramString1 + paramString2);
  }
  
  public final void a(d.a parama, Context paramContext)
  {
    this.JI = new WeakReference(parama);
    this.IbL = new WeakReference(paramContext);
  }
  
  public void a(WalletBaseUI paramWalletBaseUI) {}
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public final void b(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    H(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.JI.get() != null) {
      ((d.a)this.JI.get()).q(paramInt, paramBundle);
    }
    if (paramBundle != null) {
      paramBundle.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public abstract void b(Activity paramActivity, Bundle paramBundle);
  
  public final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    H(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.adn(), "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "startActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramBundle != null) {
      this.dow.putAll(paramBundle);
    }
    ad.d("MicroMsg.ProcessManager", "bankcard tag :" + fjq());
  }
  
  protected final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    H(new Object[] { "finishActivity", paramActivity, paramClass, "errCode ".concat(String.valueOf(paramInt)) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    if (paramBundle != null) {
      paramClass.putExtras(paramBundle);
    }
    paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramClass.adn(), "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramClass.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/wallet_core/WalletProcess", "backActivity", "(Landroid/app/Activity;Ljava/lang/Class;Landroid/os/Bundle;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.dow.putInt("key_err_code", paramInt);
  }
  
  public void b(WalletBaseUI paramWalletBaseUI) {}
  
  public final d bd(Bundle paramBundle)
  {
    this.dow.putAll(paramBundle);
    return this;
  }
  
  public final void bp(Activity paramActivity)
  {
    H(new Object[] { "specEndProcess", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.dow != null) {
      this.dow.clear();
    }
    a.remove(getClass().hashCode());
    dZW();
  }
  
  public final void bq(Activity paramActivity)
  {
    H(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.dow != null) {
      this.dow.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public final void c(Activity paramActivity, Class<?> paramClass)
  {
    a(paramActivity, paramClass, -1, null, true);
  }
  
  public abstract boolean c(Activity paramActivity, Bundle paramBundle);
  
  public abstract String cuB();
  
  public void dZW() {}
  
  protected final void e(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1, true);
  }
  
  public final boolean eez()
  {
    return this.dow.getBoolean("key_is_oversea", false);
  }
  
  public final void fjp()
  {
    this.JI = null;
    this.IbL = null;
  }
  
  public final int fjq()
  {
    return this.dow.getInt("key_support_bankcard", 1);
  }
  
  public final boolean fjr()
  {
    boolean bool = false;
    if (this.dow.getInt("key_pay_flag", 0) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean fjs()
  {
    return this.dow.getInt("key_pay_flag", 0) == 1;
  }
  
  public final boolean fjt()
  {
    boolean bool = false;
    if (this.dow.getInt("key_pay_flag", 0) == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean fju()
  {
    boolean bool2 = false;
    String str = this.dow.getString("key_bank_username");
    ad.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.dow.getBoolean("key_is_follow_bank_username", false) + ", username : " + str);
    boolean bool1 = bool2;
    if (this.dow.getBoolean("key_is_follow_bank_username", false))
    {
      bool1 = bool2;
      if (!bt.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(new t(str), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d
 * JD-Core Version:    0.7.0.1
 */