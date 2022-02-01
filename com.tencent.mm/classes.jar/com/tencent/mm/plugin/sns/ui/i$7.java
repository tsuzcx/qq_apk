package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;

final class i$7
  implements View.OnLongClickListener
{
  i$7(i parami) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(97815);
    g.agS();
    if (!((Boolean)g.agR().agA().get(7490, Boolean.TRUE)).booleanValue())
    {
      paramView = new Intent();
      paramView.setClass(i.c(this.yyl), SnsCommentUI.class);
      paramView.putExtra("sns_comment_type", 1);
      ((MMActivity)i.c(this.yyl)).startActivityForResult(paramView, 9);
    }
    for (;;)
    {
      AppMethodBeat.o(97815);
      return true;
      paramView = i.c(this.yyl);
      Object localObject = new Intent().setClass(i.c(this.yyl), SnsLongMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      g.agS();
      g.agR().agA().set(7490, Boolean.FALSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.7
 * JD-Core Version:    0.7.0.1
 */