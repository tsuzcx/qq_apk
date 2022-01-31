package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a;

final class SnsUploadConfigView$15
  implements DialogInterface.OnClickListener
{
  SnsUploadConfigView$15(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.piZ;
    Context localContext = this.piZ.getContext();
    this.piZ.getContext().getString(i.j.app_tip);
    SnsUploadConfigView.a(paramDialogInterface, h.b(localContext, this.piZ.getContext().getString(i.j.twitter_loading), true, new SnsUploadConfigView.15.1(this)));
    SnsUploadConfigView.l(this.piZ).a(this.piZ, this.piZ.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.15
 * JD-Core Version:    0.7.0.1
 */