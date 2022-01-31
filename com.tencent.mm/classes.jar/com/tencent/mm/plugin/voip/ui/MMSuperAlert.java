package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSuperAlert
  extends Activity
{
  public static void d(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, MMSuperAlert.class);
    localIntent.putExtra("MMSuperAlert_title", paramInt1);
    localIntent.putExtra("MMSuperAlert_msg", paramInt2);
    localIntent.putExtra("MMSuperAlert_cancelable", false);
    paramContext.startActivity(localIntent);
  }
  
  public Resources getResources()
  {
    if ((getAssets() != null) && (ae.getResources() != null)) {
      return ae.getResources();
    }
    return super.getResources();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.c.mm_super_alert_empty);
    int i = getIntent().getIntExtra("MMSuperAlert_msg", 0);
    int j = getIntent().getIntExtra("MMSuperAlert_title", 0);
    boolean bool = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
    new ah().postDelayed(new MMSuperAlert.1(this, i, j, bool), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert
 * JD-Core Version:    0.7.0.1
 */