package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class j
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  boolean aA = true;
  boolean aB = true;
  int aC = -1;
  Dialog aD;
  boolean aE;
  boolean aF;
  boolean aG;
  int ay = 0;
  int az = 0;
  
  public void a(s params, String paramString)
  {
    this.aF = false;
    this.aG = true;
    params = params.Z();
    params.a(this, paramString);
    params.commit();
  }
  
  public final void l()
  {
    this.aB = false;
  }
  
  public Dialog m()
  {
    return new Dialog(o(), this.az);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.aB) {}
    do
    {
      do
      {
        return;
        Object localObject = this.bo;
        if (localObject != null)
        {
          if (((View)localObject).getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          }
          this.aD.setContentView((View)localObject);
        }
        localObject = o();
        if (localObject != null) {
          this.aD.setOwnerActivity((Activity)localObject);
        }
        this.aD.setCancelable(this.aA);
        this.aD.setOnCancelListener(this);
        this.aD.setOnDismissListener(this);
      } while (paramBundle == null);
      paramBundle = paramBundle.getBundle("android:savedDialogState");
    } while (paramBundle == null);
    this.aD.onRestoreInstanceState(paramBundle);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (!this.aG) {
      this.aF = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.be == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aB = bool;
      if (paramBundle != null)
      {
        this.ay = paramBundle.getInt("android:style", 0);
        this.az = paramBundle.getInt("android:theme", 0);
        this.aA = paramBundle.getBoolean("android:cancelable", true);
        this.aB = paramBundle.getBoolean("android:showsDialog", this.aB);
        this.aC = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    if (this.aD != null)
    {
      this.aE = true;
      this.aD.dismiss();
      this.aD = null;
    }
  }
  
  public final void onDetach()
  {
    super.onDetach();
    if ((!this.aG) && (!this.aF)) {
      this.aF = true;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!this.aE) && (!this.aF))
    {
      this.aF = true;
      this.aG = false;
      if (this.aD != null)
      {
        this.aD.dismiss();
        this.aD = null;
      }
      this.aE = true;
      if (this.aC >= 0)
      {
        this.aY.g(this.aC);
        this.aC = -1;
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = this.aY.Z();
    paramDialogInterface.a(this);
    paramDialogInterface.commitAllowingStateLoss();
  }
  
  public final LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (!this.aB) {
      return super.onGetLayoutInflater(paramBundle);
    }
    this.aD = m();
    if (this.aD != null)
    {
      paramBundle = this.aD;
      switch (this.ay)
      {
      }
      for (;;)
      {
        return (LayoutInflater)this.aD.getContext().getSystemService("layout_inflater");
        paramBundle.getWindow().addFlags(24);
        paramBundle.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)this.aZ.mContext.getSystemService("layout_inflater");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.aD != null)
    {
      Bundle localBundle = this.aD.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (this.ay != 0) {
      paramBundle.putInt("android:style", this.ay);
    }
    if (this.az != 0) {
      paramBundle.putInt("android:theme", this.az);
    }
    if (!this.aA) {
      paramBundle.putBoolean("android:cancelable", this.aA);
    }
    if (!this.aB) {
      paramBundle.putBoolean("android:showsDialog", this.aB);
    }
    if (this.aC != -1) {
      paramBundle.putInt("android:backStackId", this.aC);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    if (this.aD != null)
    {
      this.aE = false;
      this.aD.show();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    if (this.aD != null) {
      this.aD.hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.j
 * JD-Core Version:    0.7.0.1
 */