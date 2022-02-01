package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class MMWizardActivity
  extends MMActivity
{
  protected static final Map<String, Intent> JxE = new HashMap();
  
  public static void al(Context paramContext, Intent paramIntent)
  {
    ae.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
    Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + paramContext.toString(), paramContext instanceof Activity);
    String str2 = paramIntent.getStringExtra("WizardRootClass");
    String str1 = paramIntent.getStringExtra("WizardTransactionId");
    Intent localIntent = ((Activity)paramContext).getIntent();
    if ((bu.isNullOrNil(str2)) && (localIntent != null))
    {
      str2 = localIntent.getStringExtra("WizardRootClass");
      str1 = localIntent.getStringExtra("WizardTransactionId");
      if (localIntent.getComponent() != null) {
        ae.i("MicroMsg.MMWizardActivity", "start wizard, callerIntent class=%s", new Object[] { localIntent.getComponent().getClassName() });
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MMWizardActivity", "start wizard, root=%s", new Object[] { str2 });
      if (!bu.isNullOrNil(str2)) {
        paramIntent.putExtra("WizardRootClass", str2);
      }
      if (str1 != null) {
        paramIntent.putExtra("WizardTransactionId", str1);
      }
      if (paramIntent.getExtras() == null) {
        paramIntent.putExtras(new Bundle());
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/MMWizardActivity", "startWizardActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    try
    {
      String str = "trans." + bu.HQ() + "." + paramIntent2.hashCode();
      JxE.put(str, paramIntent2);
      paramIntent1.putExtra("WizardTransactionId", str);
      paramIntent2 = ((Activity)paramContext).getIntent();
      if (paramIntent2 != null) {
        paramIntent2.putExtra("WizardTransactionId", str);
      }
      al(paramContext, paramIntent1);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.MMWizardActivity", "%s", new Object[] { bu.o(paramContext) });
    }
  }
  
  public final void acs(int paramInt)
  {
    ae.i("MicroMsg.MMWizardActivity", "finishWizard()");
    exit(paramInt);
  }
  
  protected final void cancel()
  {
    ae.i("MicroMsg.MMWizardActivity", "cancel()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)JxE.get(str);
    JxE.remove(str);
    if (localIntent != null) {
      ae.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + str + ", intent=" + localIntent);
    }
  }
  
  public final void exit(int paramInt)
  {
    String str = getIntent().getStringExtra("WizardRootClass");
    Object localObject1 = getIntent().getStringExtra("WizardTransactionId");
    ae.i("MicroMsg.MMWizardActivity", "exit resultCode:%d, rootClass:%s, transaction:%s", new Object[] { Integer.valueOf(paramInt), str, localObject1 });
    Object localObject2 = (Intent)JxE.get(localObject1);
    JxE.remove(localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Intent();
    }
    localObject2 = str;
    if (bu.isNullOrNil(str))
    {
      localObject2 = str;
      if (((Intent)localObject1).getComponent() != null)
      {
        localObject2 = ((Intent)localObject1).getComponent().getClassName();
        ae.i("MicroMsg.MMWizardActivity", "exit component rootClass %s", new Object[] { localObject2 });
      }
    }
    if (!bu.isNullOrNil((String)localObject2)) {}
    try
    {
      ((Intent)localObject1).putExtra("wizard_activity_result_code", paramInt);
      ((Intent)localObject1).setClassName(this, (String)localObject2);
      ((Intent)localObject1).addFlags(67108864);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MMWizardActivity", "exit", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      label218:
      super.finish();
      return;
    }
    catch (Exception localException)
    {
      break label218;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ae.i("MicroMsg.MMWizardActivity", "onCreate()");
    if (z.l(getIntent().getExtras(), "WizardRootKillSelf"))
    {
      super.finish();
      ae.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
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