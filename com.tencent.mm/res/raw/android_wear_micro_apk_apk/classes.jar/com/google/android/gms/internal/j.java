package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.b;

final class j
  implements Runnable
{
  private j(i parami) {}
  
  public final void run()
  {
    if (!this.Mo.ej) {
      return;
    }
    if (i.a(this.Mo).gl())
    {
      this.Mo.OR.startActivityForResult(GoogleApiActivity.a(this.Mo.getActivity(), i.a(this.Mo).gn(), i.b(this.Mo), false), 1);
      return;
    }
    if (this.Mo.HF.aZ(i.a(this.Mo).getErrorCode()))
    {
      this.Mo.HF.a(this.Mo.getActivity(), this.Mo.OR, i.a(this.Mo).getErrorCode(), this.Mo);
      return;
    }
    if (i.a(this.Mo).getErrorCode() == 18)
    {
      final Dialog localDialog = b.a(this.Mo.getActivity(), this.Mo);
      b.a(this.Mo.getActivity().getApplicationContext(), new au()
      {
        public final void jdMethod_if()
        {
          j.this.Mo.ie();
          if (localDialog.isShowing()) {
            localDialog.dismiss();
          }
        }
      });
      return;
    }
    this.Mo.a(i.a(this.Mo), i.b(this.Mo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.j
 * JD-Core Version:    0.7.0.1
 */