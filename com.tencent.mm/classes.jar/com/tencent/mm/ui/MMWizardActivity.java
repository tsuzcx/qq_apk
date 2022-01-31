package com.tencent.mm.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class MMWizardActivity
  extends MMActivity
{
  public static final Map<String, Intent> uOD = new HashMap();
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    y.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
    Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + paramContext.toString(), paramContext instanceof Activity);
    Object localObject = ((Activity)paramContext).getIntent();
    String str1;
    if (localObject != null)
    {
      str1 = ((Intent)localObject).getStringExtra("WizardRootClass");
      localObject = ((Intent)localObject).getStringExtra("WizardTransactionId");
    }
    for (;;)
    {
      String str2 = str1;
      if (bk.bl(str1)) {}
      try
      {
        str2 = paramIntent.getComponent().getClassName();
        Assert.assertFalse("startWizardActivity: ERROR in Get Root Class :[" + paramIntent + "][ " + paramIntent.getComponent() + " ]", bk.bl(str2));
        paramIntent.putExtra("WizardRootClass", str2);
        if (localObject != null) {
          paramIntent.putExtra("WizardTransactionId", (String)localObject);
        }
        paramContext.startActivity(paramIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.MMWizardActivity", localException, "", new Object[0]);
          String str3 = str1;
        }
      }
      localObject = null;
      str1 = null;
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent1, Intent paramIntent2)
  {
    try
    {
      String str = "trans." + bk.UZ() + "." + paramIntent2.hashCode();
      uOD.put(str, paramIntent2);
      paramIntent1.putExtra("WizardTransactionId", str);
      paramIntent2 = ((Activity)paramContext).getIntent();
      if (paramIntent2 != null) {
        paramIntent2.putExtra("WizardTransactionId", str);
      }
      C(paramContext, paramIntent1);
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MMWizardActivity", "%s", new Object[] { bk.j(paramContext) });
    }
  }
  
  public final void FW(int paramInt)
  {
    y.i("MicroMsg.MMWizardActivity", "finishWizard()");
    Object localObject = getIntent().getExtras().getString("WizardRootClass");
    Assert.assertFalse("finishWizard: ERROR in Get Root Class :[" + (String)localObject + "]", bk.bl((String)localObject));
    localObject = new Intent().setClassName(this, (String)localObject);
    ((Intent)localObject).putExtra("WizardRootClass", getIntent().getStringExtra("WizardRootClass"));
    ((Intent)localObject).putExtra("WizardTransactionId", getIntent().getStringExtra("WizardTransactionId"));
    ((Intent)localObject).putExtra("WizardRootKillSelf", true);
    ((Intent)localObject).putExtra("wizard_activity_result_code", paramInt);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.MMWizardActivity", "cancel()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)uOD.get(str);
    uOD.remove(str);
    if (localIntent != null) {
      y.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + str + ", intent=" + localIntent);
    }
  }
  
  public final void exit(int paramInt)
  {
    y.i("MicroMsg.MMWizardActivity", "exit()");
    String str = getIntent().getStringExtra("WizardTransactionId");
    Intent localIntent = (Intent)uOD.get(str);
    uOD.remove(str);
    if (localIntent != null)
    {
      y.d("MicroMsg.MMWizardActivity", "doing post exit for transaction=" + str + ", intent=" + localIntent);
      localIntent.putExtra("wizard_activity_result_code", paramInt);
      startActivity(localIntent);
    }
  }
  
  public void finish()
  {
    y.i("MicroMsg.MMWizardActivity", "finish()");
    String str = getIntent().getStringExtra("WizardRootClass");
    if (getComponentName().getClassName().equals(str))
    {
      y.d("MicroMsg.MMWizardActivity", "root wizard activity");
      exit(-1);
    }
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.MMWizardActivity", "onCreate()");
    Assert.assertFalse("MMWizardActivity Should Start By startWizardActivity or startWizardNextStep", bk.bl(getIntent().getExtras().getString("WizardRootClass")));
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      super.finish();
      y.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
      exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMWizardActivity
 * JD-Core Version:    0.7.0.1
 */