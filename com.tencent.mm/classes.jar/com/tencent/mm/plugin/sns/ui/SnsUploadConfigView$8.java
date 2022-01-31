package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class SnsUploadConfigView$8
  implements View.OnClickListener
{
  SnsUploadConfigView$8(SnsUploadConfigView paramSnsUploadConfigView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = true;
    AppMethodBeat.i(39695);
    if ((!SnsUploadConfigView.d(this.sbB)) && (SnsUploadConfigView.b(this.sbB)))
    {
      h.h(this.val$context, 2131303993, 2131297087);
      AppMethodBeat.o(39695);
      return;
    }
    g.RM();
    if (g.RL().Ru().getBoolean(ac.a.yzY, true))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yzY, Boolean.FALSE);
      h.a(this.val$context, 2131303978, 2131297087, new SnsUploadConfigView.8.1(this));
      AppMethodBeat.o(39695);
      return;
    }
    paramView = this.sbB;
    if (SnsUploadConfigView.d(this.sbB)) {
      bool = false;
    }
    SnsUploadConfigView.b(paramView, bool);
    SnsUploadConfigView.e(this.sbB);
    AppMethodBeat.o(39695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.8
 * JD-Core Version:    0.7.0.1
 */