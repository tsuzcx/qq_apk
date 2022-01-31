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
  protected final b HF;
  protected boolean Mk;
  private ConnectionResult Ml;
  private int Mm = -1;
  private final Handler Mn = new Handler(Looper.getMainLooper());
  protected boolean ej;
  
  protected i(az paramaz)
  {
    this(paramaz, b.gp());
  }
  
  private i(az paramaz, b paramb)
  {
    super(paramaz);
    this.HF = paramb;
  }
  
  protected abstract void a(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void b(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!this.Mk)
    {
      this.Mk = true;
      this.Mm = paramInt;
      this.Ml = paramConnectionResult;
      this.Mn.post(new j(this, (byte)0));
    }
  }
  
  protected abstract void hY();
  
  protected final void ie()
  {
    this.Mm = -1;
    this.Mk = false;
    this.Ml = null;
    hY();
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
        ie();
        return;
      }
      break;
    case 2: 
      label30:
      j = this.HF.d(getActivity());
      if (j != 0) {}
      break;
    }
    for (paramInt2 = i;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (this.Ml.getErrorCode() != 18) {
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
        this.Ml = new ConnectionResult(paramInt1, null);
        break;
        a(this.Ml, this.Mm);
        return;
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    a(new ConnectionResult(13, null), this.Mm);
    ie();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.Mk = paramBundle.getBoolean("resolving_error", false);
      if (this.Mk)
      {
        this.Mm = paramBundle.getInt("failed_client_id", -1);
        this.Ml = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.Mk);
    if (this.Mk)
    {
      paramBundle.putInt("failed_client_id", this.Mm);
      paramBundle.putInt("failed_status", this.Ml.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.Ml.gn());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.ej = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.ej = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.i
 * JD-Core Version:    0.7.0.1
 */