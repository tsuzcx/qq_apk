package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class SnsStrangerCommentDetailUI$1
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$1(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99139);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = SnsStrangerCommentDetailUI.a(this.AAw);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)paramView.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.1
 * JD-Core Version:    0.7.0.1
 */