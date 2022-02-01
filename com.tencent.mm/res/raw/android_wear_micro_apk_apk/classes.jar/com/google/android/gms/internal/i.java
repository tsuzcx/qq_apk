package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;

public abstract class i
  extends ay
  implements DialogInterface.OnCancelListener
{
  protected final b Ju;
  protected boolean NZ;
  private ConnectionResult Oa;
  private int Ob = -1;
  private final Handler Oc = new Handler(Looper.getMainLooper());
  protected boolean hO;
  
  protected i(az paramaz)
  {
    this(paramaz, b.gz());
  }
  
  private i(az paramaz, b paramb)
  {
    super(paramaz);
    this.Ju = paramb;
  }
  
  protected abstract void a(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void b(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!this.NZ)
    {
      this.NZ = true;
      this.Ob = paramInt;
      this.Oa = paramConnectionResult;
      this.Oc.post(new j(this, (byte)0));
    }
  }
  
  protected abstract void ig();
  
  protected final void im()
  {
    this.Ob = -1;
    this.NZ = false;
    this.Oa = null;
    ig();
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        im();
        return;
      }
      break;
    case 2: 
      label30:
      j = this.Ju.d(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (this.Oa.getErrorCode() != 18) {
        break label30;
      }
      paramInt1 = paramInt2;
      if (j != 18) {
        break label30;
      }
      return;
      paramInt1 = j;
      if (paramInt2 == -1) {
        break label30;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (paramIntent != null) {}
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);; paramInt1 = 13)
      {
        this.Oa = new ConnectionResult(paramInt1, null);
        break;
        a(this.Oa, this.Ob);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a(new ConnectionResult(13, null), this.Ob);
    im();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.NZ = paramBundle.getBoolean("resolving_error", false);
      if (this.NZ)
      {
        this.Ob = paramBundle.getInt("failed_client_id", -1);
        this.Oa = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.NZ);
    if (this.NZ)
    {
      paramBundle.putInt("failed_client_id", this.Ob);
      paramBundle.putInt("failed_status", this.Oa.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.Oa.gx());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.hO = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.hO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.i
 * JD-Core Version:    0.7.0.1
 */