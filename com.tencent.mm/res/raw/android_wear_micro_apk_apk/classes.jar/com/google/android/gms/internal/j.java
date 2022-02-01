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
    if (!this.Od.hO) {
      return;
    }
    if (i.a(this.Od).gv())
    {
      this.Od.QG.startActivityForResult(GoogleApiActivity.a(this.Od.getActivity(), i.a(this.Od).gx(), i.b(this.Od), false), 1);
      return;
    }
    if (this.Od.Ju.bt(i.a(this.Od).getErrorCode()))
    {
      this.Od.Ju.a(this.Od.getActivity(), this.Od.QG, i.a(this.Od).getErrorCode(), this.Od);
      return;
    }
    if (i.a(this.Od).getErrorCode() == 18)
    {
      final Dialog localDialog = b.a(this.Od.getActivity(), this.Od);
      b.a(this.Od.getActivity().getApplicationContext(), new au()
      {
        public final void in()
        {
          j.this.Od.im();
          if (localDialog.isShowing()) {
            localDialog.dismiss();
          }
        }
      });
      return;
    }
    this.Od.a(i.a(this.Od), i.b(this.Od));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.j
 * JD-Core Version:    0.7.0.1
 */