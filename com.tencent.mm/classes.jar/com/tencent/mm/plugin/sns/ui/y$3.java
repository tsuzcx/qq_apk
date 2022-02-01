package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.ui.MMActivity;

final class y$3
  implements View.OnClickListener
{
  y$3(y paramy, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97883);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (y.a(this.RdA) == null)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97883);
      return;
    }
    if (y.a(this.RdA).field_snsId == 0L) {}
    for (paramView = "";; paramView = t.uA(y.a(this.RdA).field_snsId))
    {
      h.OAn.b(11989, new Object[] { Integer.valueOf(3), paramView, Integer.valueOf(0) });
      int i = y.a(this.RdA).localid;
      paramView = new Intent();
      paramView.setClass(this.val$context, SnsCommentDetailUI.class);
      paramView.putExtra("INTENT_TALKER", y.a(this.RdA).getUserName());
      paramView.putExtra("INTENT_SNS_LOCAL_ID", ai.bF("sns_table_", i));
      paramView.putExtra("INTENT_FROMGALLERY", true);
      ((MMActivity)this.val$context).startActivityForResult(paramView, 1);
      j.QFS.hip().jeO = 1L;
      a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(97883);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.y.3
 * JD-Core Version:    0.7.0.1
 */