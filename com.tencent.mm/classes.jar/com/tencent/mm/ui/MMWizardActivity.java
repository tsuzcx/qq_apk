package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public abstract class MMWizardActivity
  extends MMActivity
{
  protected static final Map<String, Intent> adGP = new HashMap();
  
  public static void aQ(Context paramContext, Intent paramIntent)
  {
    Log.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
    String str3 = paramIntent.getStringExtra("WizardRootClass");
    String str4 = paramIntent.getStringExtra("WizardTransactionId");
    if ((paramContext instanceof Activity)) {}
    for (Intent localIntent = ((Activity)paramContext).getIntent();; localIntent = null)
    {
      String str1 = str4;
      String str2 = str3;
      if (Util.isNullOrNil(str3))
      {
        str1 = str4;
        str2 = str3;
        if (localIntent != null)
        {
          str3 = localIntent.getStringExtra("WizardRootClass");
          str4 = localIntent.getStringExtra("WizardTransactionId");
          str1 = str4;
          str2 = str3;
          if (localIntent.getComponent() != null)
          {
            Log.i("MicroMsg.MMWizardActivity", "start wizard, callerIntent class=%s", new Object[] { localIntent.getComponent().getClassName() });
            str2 = str3;
            str1 = str4;
          }
        }
      }
      Log.i("MicroMsg.MMWizardActivity", "start wizard, root=%s", new Object[] { str2 });
      if (!Util.isNullOrNil(str2)) {
        paramIntent.putExtra("WizardRootClass", str2);
      }
      if (str1 != null) {
        paramIntent.putExtra("WizardTransactionId", str1);
      }
      if (paramIntent.getExtras() == null) {
        paramIntent.putExtras(new Bundle());
      }
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    try
    {
      String str = "trans." + Util.currentTicks() + "." + paramIntent2.hashCode();
      adGP.put(str, paramIntent2);
      paramIntent1.putExtra("WizardTransactionId", str);
      paramIntent2 = ((Activity)paramContext).getIntent();
      if (paramIntent2 != null) {
        paramIntent2.putExtra("WizardTransactionId", str);
      }
      aQ(paramContext, paramIntent1);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MMWizardActivity", "%s", new Object[] { Util.stackTraceToString(paramContext) });
    }
  }
  
  public final void aAp(int paramInt)
  {
    Log.i("MicroMsg.MMWizardActivity", "finishWizard()");
    exit(paramInt);
  }
  
  protected final void cancel()
  {
    Log.i("MicroMsg.MMWizardActivity", "cancel()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)adGP.get(str);
    adGP.remove(str);
    if (localIntent != null) {
      Log.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + str + ", intent=" + localIntent);
    }
  }
  
  public final void exit(int paramInt)
  {
    String str = getIntent().getStringExtra("WizardRootClass");
    Object localObject1 = getIntent().getStringExtra("WizardTransactionId");
    Log.i("MicroMsg.MMWizardActivity", "exit resultCode:%d, rootClass:%s, transaction:%s", new Object[] { Integer.valueOf(paramInt), str, localObject1 });
    Object localObject2 = (Intent)adGP.get(localObject1);
    adGP.remove(localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Intent();
    }
    localObject2 = str;
    if (Util.isNullOrNil(str))
    {
      localObject2 = str;
      if (((Intent)localObject1).getComponent() != null)
      {
        localObject2 = ((Intent)localObject1).getComponent().getClassName();
        Log.i("MicroMsg.MMWizardActivity", "exit component rootClass %s", new Object[] { localObject2 });
      }
    }
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      ((Intent)localObject1).putExtra("wizard_activity_result_code", paramInt);
      ((Intent)localObject1).setClassName(this, (String)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      if (((Intent)localObject1).getStringExtra("WizardRootClass") != null) {
        aQ(this, (Intent)localObject1);
      }
      for (;;)
      {
        label172:
        h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249576);
            MMWizardActivity.this.finish();
            AppMethodBeat.o(249576);
          }
        }, 200L);
        return;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    catch (Exception localException)
    {
      break label172;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("MicroMsg.MMWizardActivity", "onCreate()");
    if (IntentUtil.getBoolean(getIntent().getExtras(), "WizardRootKillSelf", false))
    {
      super.finish();
      Log.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
      exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMWizardActivity
 * JD-Core Version:    0.7.0.1
 */