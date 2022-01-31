package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.ui.MMActivity;

final class r$3
  implements View.OnClickListener
{
  r$3(r paramr, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38237);
    if (r.a(this.rGQ) == null)
    {
      AppMethodBeat.o(38237);
      return;
    }
    if (r.a(this.rGQ).field_snsId == 0L) {}
    for (paramView = "";; paramView = i.lq(r.a(this.rGQ).field_snsId))
    {
      h.qsU.e(11989, new Object[] { Integer.valueOf(3), paramView, Integer.valueOf(0) });
      int i = r.a(this.rGQ).rCV;
      paramView = new Intent();
      paramView.setClass(this.val$context, SnsCommentDetailUI.class);
      paramView.putExtra("INTENT_TALKER", r.a(this.rGQ).field_userName);
      paramView.putExtra("INTENT_SNS_LOCAL_ID", v.aF("sns_table_", i));
      paramView.putExtra("INTENT_FROMGALLERY", true);
      ((MMActivity)this.val$context).startActivityForResult(paramView, 1);
      AppMethodBeat.o(38237);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.3
 * JD-Core Version:    0.7.0.1
 */