package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsStrangerCommentDetailUI$a$1
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$a$1(SnsStrangerCommentDetailUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99150);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$CommentListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = (String)paramView.getTag();
    Log.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramView)));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", paramView);
    com.tencent.mm.plugin.sns.d.a.pFn.c((Intent)localObject, SnsStrangerCommentDetailUI.a.a(this.RxW));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$CommentListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.1
 * JD-Core Version:    0.7.0.1
 */