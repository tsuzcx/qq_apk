package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

final class SnsUploadConfigView$1
  implements View.OnClickListener
{
  SnsUploadConfigView$1(SnsUploadConfigView paramSnsUploadConfigView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    if ((!SnsUploadConfigView.a(this.piZ)) && (SnsUploadConfigView.b(this.piZ)))
    {
      h.h(this.val$context, i.j.sns_tag_privacy_qzone_conflict_tip, i.j.app_tip);
      return;
    }
    paramView = this.piZ;
    if (SnsUploadConfigView.a(this.piZ)) {}
    for (boolean bool = false;; bool = true)
    {
      SnsUploadConfigView.a(paramView, bool);
      SnsUploadConfigView.c(this.piZ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.1
 * JD-Core Version:    0.7.0.1
 */