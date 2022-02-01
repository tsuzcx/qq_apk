package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;

final class SnsStrangerCommentDetailUI$1
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$1(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99139);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = SnsStrangerCommentDetailUI.a(this.RxU);
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.1
 * JD-Core Version:    0.7.0.1
 */