package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.az;

public abstract class aa
  implements DialogInterface.OnClickListener
{
  public static aa a(final Activity paramActivity, Intent paramIntent, int paramInt)
  {
    new aa()
    {
      public final void hu()
      {
        if (aa.this != null) {
          paramActivity.startActivityForResult(aa.this, this.P);
        }
      }
    };
  }
  
  public static aa a(final az paramaz, Intent paramIntent, int paramInt)
  {
    new aa()
    {
      public final void hu()
      {
        if (aa.this != null) {
          paramaz.startActivityForResult(aa.this, this.P);
        }
      }
    };
  }
  
  protected abstract void hu();
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      hu();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
      return;
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.aa
 * JD-Core Version:    0.7.0.1
 */