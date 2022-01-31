package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import com.google.android.gms.internal.aq;

public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  protected int Hr = 0;
  
  public static PendingIntent a(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return PendingIntent.getActivity(paramContext, 0, a(paramContext, paramPendingIntent, paramInt, true), 134217728);
  }
  
  public static Intent a(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.Hr = 0;
      setResult(paramInt2);
      if (bool)
      {
        paramIntent = aq.s(this);
        switch (paramInt2)
        {
        }
      }
    }
    for (;;)
    {
      finish();
      return;
      paramIntent.a(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
      continue;
      paramIntent.hY();
      continue;
      if (paramInt1 == 2)
      {
        this.Hr = 0;
        setResult(paramInt2);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.Hr = 0;
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      this.Hr = paramBundle.getInt("resolution");
    }
    if (this.Hr != 1)
    {
      localObject = getIntent().getExtras();
      if (localObject == null)
      {
        Log.e("GoogleApiActivity", "Activity started without extras");
        finish();
      }
    }
    else
    {
      return;
    }
    paramBundle = (PendingIntent)((Bundle)localObject).get("pending_intent");
    Object localObject = (Integer)((Bundle)localObject).get("error_code");
    if ((paramBundle == null) && (localObject == null))
    {
      Log.e("GoogleApiActivity", "Activity started without resolution");
      finish();
      return;
    }
    if (paramBundle != null) {
      try
      {
        startIntentSenderForResult(paramBundle.getIntentSender(), 1, null, 0, 0, 0);
        this.Hr = 1;
        return;
      }
      catch (IntentSender.SendIntentException paramBundle)
      {
        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", paramBundle);
        finish();
        return;
      }
    }
    b.gp().a(this, ((Integer)localObject).intValue(), this);
    this.Hr = 1;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", this.Hr);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiActivity
 * JD-Core Version:    0.7.0.1
 */