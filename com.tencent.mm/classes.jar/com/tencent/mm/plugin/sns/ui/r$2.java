package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.y;

final class r$2
  implements View.OnClickListener
{
  r$2(r paramr, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.GalleryFooter", "comment cmd");
    if (r.a(this.oPe) == null) {
      return;
    }
    int i = r.a(this.oPe).oLk;
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_comment_localId", i);
    localIntent.putExtra("sns_source", r.b(this.oPe));
    localIntent.setClass(this.val$context, SnsCommentUI.class);
    if (r.a(this.oPe).field_snsId == 0L) {}
    for (paramView = "";; paramView = i.fN(r.a(this.oPe).field_snsId))
    {
      h.nFQ.f(11989, new Object[] { Integer.valueOf(2), paramView, Integer.valueOf(0) });
      this.val$context.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.2
 * JD-Core Version:    0.7.0.1
 */