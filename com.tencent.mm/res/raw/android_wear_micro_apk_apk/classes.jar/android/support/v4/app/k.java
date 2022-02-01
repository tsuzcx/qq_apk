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

public class k
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  int ch = 0;
  int ci = 0;
  boolean cj = true;
  boolean ck = true;
  int cl = -1;
  Dialog cm;
  boolean cn;
  boolean co;
  boolean cp;
  
  public final void F()
  {
    this.ck = false;
  }
  
  public Dialog G()
  {
    return new Dialog(I(), this.ci);
  }
  
  public void a(t paramt, String paramString)
  {
    this.co = false;
    this.cp = true;
    paramt = paramt.ao();
    paramt.a(this, paramString);
    paramt.commit();
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.ck) {}
    do
    {
      do
      {
        return;
        Object localObject = this.cZ;
        if (localObject != null)
        {
          if (((View)localObject).getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          }
          this.cm.setContentView((View)localObject);
        }
        localObject = I();
        if (localObject != null) {
          this.cm.setOwnerActivity((Activity)localObject);
        }
        this.cm.setCancelable(this.cj);
        this.cm.setOnCancelListener(this);
        this.cm.setOnDismissListener(this);
      } while (paramBundle == null);
      paramBundle = paramBundle.getBundle("android:savedDialogState");
    } while (paramBundle == null);
    this.cm.onRestoreInstanceState(paramBundle);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (!this.cp) {
      this.co = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.cP == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ck = bool;
      if (paramBundle != null)
      {
        this.ch = paramBundle.getInt("android:style", 0);
        this.ci = paramBundle.getInt("android:theme", 0);
        this.cj = paramBundle.getBoolean("android:cancelable", true);
        this.ck = paramBundle.getBoolean("android:showsDialog", this.ck);
        this.cl = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    if (this.cm != null)
    {
      this.cn = true;
      this.cm.dismiss();
      this.cm = null;
    }
  }
  
  public final void onDetach()
  {
    super.onDetach();
    if ((!this.cp) && (!this.co)) {
      this.co = true;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!this.cn) && (!this.co))
    {
      this.co = true;
      this.cp = false;
      if (this.cm != null) {
        this.cm.dismiss();
      }
      this.cn = true;
      if (this.cl >= 0)
      {
        this.cI.p(this.cl);
        this.cl = -1;
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = this.cI.ao();
    paramDialogInterface.a(this);
    paramDialogInterface.commitAllowingStateLoss();
  }
  
  public final LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    if (!this.ck) {
      return super.onGetLayoutInflater(paramBundle);
    }
    this.cm = G();
    if (this.cm != null)
    {
      paramBundle = this.cm;
      switch (this.ch)
      {
      }
      for (;;)
      {
        return (LayoutInflater)this.cm.getContext().getSystemService("layout_inflater");
        paramBundle.getWindow().addFlags(24);
        paramBundle.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)this.cJ.mContext.getSystemService("layout_inflater");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.cm != null)
    {
      Bundle localBundle = this.cm.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (this.ch != 0) {
      paramBundle.putInt("android:style", this.ch);
    }
    if (this.ci != 0) {
      paramBundle.putInt("android:theme", this.ci);
    }
    if (!this.cj) {
      paramBundle.putBoolean("android:cancelable", this.cj);
    }
    if (!this.ck) {
      paramBundle.putBoolean("android:showsDialog", this.ck);
    }
    if (this.cl != -1) {
      paramBundle.putInt("android:backStackId", this.cl);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    if (this.cm != null)
    {
      this.cn = false;
      this.cm.show();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    if (this.cm != null) {
      this.cm.hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.k
 * JD-Core Version:    0.7.0.1
 */