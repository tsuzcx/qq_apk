package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class TopStoryCommentFloatDialog$2
  implements View.OnClickListener
{
  TopStoryCommentFloatDialog$2(TopStoryCommentFloatDialog paramTopStoryCommentFloatDialog, MMActivity paramMMActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2244);
    if (System.currentTimeMillis() - this.tmJ.sbQ < 500L)
    {
      AppMethodBeat.o(2244);
      return;
    }
    this.tmJ.sbQ = System.currentTimeMillis();
    paramView = this.tmJ.thv.getText().toString();
    if (paramView.length() > 200)
    {
      AppMethodBeat.o(2244);
      return;
    }
    if ((paramView.length() <= 0) || (paramView.trim().length() <= 0))
    {
      AppMethodBeat.o(2244);
      return;
    }
    if (!TopStoryCommentFloatDialog.bDC())
    {
      h.b(this.val$activity, this.val$activity.getString(2131300044), "", true);
      AppMethodBeat.o(2244);
      return;
    }
    this.tmJ.tipDialog = h.b(this.val$activity, this.val$activity.getString(2131297069), false, null);
    f localf = new f(this.tmJ.tmA);
    ((ckq)localf.rr.fsV.fta).ntu = paramView;
    g.Rc().a(localf, 0);
    AppMethodBeat.o(2244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.2
 * JD-Core Version:    0.7.0.1
 */