package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;

final class i$7
  implements View.OnLongClickListener
{
  i$7(i parami) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(97815);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
    g.ajS();
    if (!((Boolean)g.ajR().ajA().get(7490, Boolean.TRUE)).booleanValue())
    {
      paramView = new Intent();
      paramView.setClass(i.c(this.AgE), SnsCommentUI.class);
      paramView.putExtra("sns_comment_type", 1);
      ((MMActivity)i.c(this.AgE)).startActivityForResult(paramView, 9);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(97815);
      return true;
      paramView = i.c(this.AgE);
      localObject = new Intent().setClass(i.c(this.AgE), SnsLongMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      g.ajS();
      g.ajR().ajA().set(7490, Boolean.FALSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.7
 * JD-Core Version:    0.7.0.1
 */