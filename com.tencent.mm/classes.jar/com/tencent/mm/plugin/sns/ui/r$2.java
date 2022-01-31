package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;

final class r$2
  implements View.OnClickListener
{
  r$2(r paramr, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38236);
    ab.d("MicroMsg.GalleryFooter", "comment cmd");
    if (r.a(this.rGQ) == null)
    {
      AppMethodBeat.o(38236);
      return;
    }
    int i = r.a(this.rGQ).rCV;
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_comment_localId", i);
    localIntent.putExtra("sns_source", r.b(this.rGQ));
    localIntent.setClass(this.val$context, SnsCommentUI.class);
    if (r.a(this.rGQ).field_snsId == 0L) {}
    for (paramView = "";; paramView = i.lq(r.a(this.rGQ).field_snsId))
    {
      h.qsU.e(11989, new Object[] { Integer.valueOf(2), paramView, Integer.valueOf(0) });
      this.val$context.startActivity(localIntent);
      AppMethodBeat.o(38236);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.2
 * JD-Core Version:    0.7.0.1
 */