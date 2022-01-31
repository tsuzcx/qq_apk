package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class SnsUploadConfigView$8
  implements View.OnClickListener
{
  SnsUploadConfigView$8(SnsUploadConfigView paramSnsUploadConfigView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    if ((!SnsUploadConfigView.d(this.piZ)) && (SnsUploadConfigView.b(this.piZ)))
    {
      h.h(this.val$context, i.j.sns_tag_privacy_weishi_conflict_tip, i.j.app_tip);
      return;
    }
    g.DQ();
    if (g.DP().Dz().getBoolean(ac.a.upY, true))
    {
      g.DQ();
      g.DP().Dz().c(ac.a.upY, Boolean.valueOf(false));
      h.a(this.val$context, i.j.sns_tag_first_show_weishi_tip, i.j.app_tip, new SnsUploadConfigView.8.1(this));
      return;
    }
    paramView = this.piZ;
    if (SnsUploadConfigView.d(this.piZ)) {}
    for (;;)
    {
      SnsUploadConfigView.b(paramView, bool);
      SnsUploadConfigView.e(this.piZ);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.8
 * JD-Core Version:    0.7.0.1
 */