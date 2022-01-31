package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public abstract class c
{
  public WeakReference<Context> AVC = new WeakReference(null);
  protected WeakReference<c.a> CT;
  public Bundle mEJ = new Bundle();
  
  private static String cR(Object paramObject)
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
    localStringBuilder.append(String.format("this %s, procname %s", new Object[] { this, bzC() }));
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      ab.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
      return localStringBuilder.toString();
    }
    int j = paramVarArgs.length - 1;
    while (i < j)
    {
      localStringBuilder.append(cR(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(cR(paramVarArgs[j]));
    return localStringBuilder.toString();
  }
  
  public void B(Activity paramActivity)
  {
    G(new Object[] { "finishActivity", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
  }
  
  public final void G(Object... paramVarArgs)
  {
    ab.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[] { t(paramVarArgs) });
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
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt)
  {
    b(paramActivity, paramClass, null, paramInt);
  }
  
  protected final void a(Activity paramActivity, Class<?> paramClass, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    G(new Object[] { "endProcess2", paramActivity, paramClass, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    if (this.CT.get() != null) {
      paramIntent = ((c.a)this.CT.get()).p(paramInt, this.mEJ);
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
        if (this.mEJ != null) {
          this.mEJ.clear();
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
    G(new Object[] { "startActivityForResult1", paramActivity, paramClass, paramBundle, Integer.valueOf(paramInt) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    paramActivity.startActivityForResult(paramClass, paramInt);
    if (paramBundle != null) {
      this.mEJ.putAll(paramBundle);
    }
  }
  
  public final void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle1, Bundle paramBundle2)
  {
    G(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle1 });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    if (paramBundle2 != null)
    {
      paramClass.putExtras(paramBundle2);
      ab.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[] { paramClass.getExtras().toString() });
    }
    paramActivity.startActivity(paramClass);
    if (paramBundle1 != null) {
      this.mEJ.putAll(paramBundle1);
    }
    ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dRO());
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    G(new Object[] { "endProcess3", paramActivity, paramString1, paramString2, Integer.valueOf(paramInt), paramIntent, Boolean.valueOf(paramBoolean) });
    Intent localIntent1 = null;
    if (this.CT.get() != null) {
      localIntent1 = ((c.a)this.CT.get()).p(paramInt, this.mEJ);
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
      if (this.mEJ != null) {
        this.mEJ.clear();
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
    G(new Object[] { "startActivity3", paramActivity, paramString1, paramString2, paramBundle });
    Class localClass = d.ia(paramString1, paramString2);
    if (localClass != null)
    {
      b(paramActivity, localClass, paramBundle);
      return;
    }
    ab.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + paramString1 + paramString2);
  }
  
  public final void a(c.a parama, Context paramContext)
  {
    this.CT = new WeakReference(parama);
    this.AVC = new WeakReference(paramContext);
  }
  
  public void a(WalletBaseUI paramWalletBaseUI) {}
  
  public boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    return false;
  }
  
  public final c aM(Bundle paramBundle)
  {
    this.mEJ.putAll(paramBundle);
    return this;
  }
  
  public final void aN(Activity paramActivity)
  {
    G(new Object[] { "specEndProcess", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.mEJ != null) {
      this.mEJ.clear();
    }
    a.remove(getClass().hashCode());
    cRJ();
  }
  
  public final void aO(Activity paramActivity)
  {
    G(new Object[] { "endProcess1", paramActivity });
    if ((!paramActivity.isFinishing()) && ((paramActivity instanceof MMActivity))) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.mEJ != null) {
      this.mEJ.clear();
    }
    a.remove(getClass().hashCode());
  }
  
  public abstract void b(Activity paramActivity, Bundle paramBundle);
  
  public final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle)
  {
    G(new Object[] { "startActivity1", paramActivity, paramClass, paramBundle });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramActivity.startActivity(paramClass);
    if (paramBundle != null) {
      this.mEJ.putAll(paramBundle);
    }
    ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dRO());
  }
  
  protected final void b(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt)
  {
    G(new Object[] { "finishActivity", paramActivity, paramClass, "errCode ".concat(String.valueOf(paramInt)) });
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("process_id", getClass().hashCode());
    paramClass.addFlags(67108864);
    if (paramBundle != null) {
      paramClass.putExtras(paramBundle);
    }
    paramActivity.startActivity(paramClass);
    this.mEJ.putInt("key_err_code", paramInt);
  }
  
  public void b(WalletBaseUI paramWalletBaseUI) {}
  
  public abstract String bzC();
  
  protected final void c(Activity paramActivity, Class<?> paramClass)
  {
    a(paramActivity, paramClass, -1, null, true);
  }
  
  public abstract boolean c(Activity paramActivity, Bundle paramBundle);
  
  public void cRJ() {}
  
  public final boolean cWe()
  {
    return this.mEJ.getBoolean("key_is_oversea", false);
  }
  
  protected final void d(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1, true);
  }
  
  public final void dRN()
  {
    this.CT = null;
    this.AVC = null;
  }
  
  public final int dRO()
  {
    return this.mEJ.getInt("key_support_bankcard", 1);
  }
  
  public final boolean dRP()
  {
    boolean bool = false;
    if (this.mEJ.getInt("key_pay_flag", 0) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean dRQ()
  {
    return this.mEJ.getInt("key_pay_flag", 0) == 1;
  }
  
  public final boolean dRR()
  {
    boolean bool = false;
    if (this.mEJ.getInt("key_pay_flag", 0) == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean dRS()
  {
    boolean bool2 = false;
    String str = this.mEJ.getString("key_bank_username");
    ab.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.mEJ.getBoolean("key_is_follow_bank_username", false) + ", username : " + str);
    boolean bool1 = bool2;
    if (this.mEJ.getBoolean("key_is_follow_bank_username", false))
    {
      bool1 = bool2;
      if (!bo.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new r(str), 0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public abstract void e(Activity paramActivity, int paramInt);
  
  public boolean h(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void l(Activity paramActivity, Bundle paramBundle)
  {
    G(new Object[] { "endProcess1", paramActivity });
    if (!paramActivity.isFinishing()) {
      ((MMActivity)paramActivity).finish();
    }
    if (this.CT.get() != null) {
      ((c.a)this.CT.get()).p(0, paramBundle);
    }
    paramBundle.clear();
    a.remove(getClass().hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c
 * JD-Core Version:    0.7.0.1
 */