package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class ai$1
  implements View.OnClickListener
{
  ai$1(ai paramai) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(268227);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (this.KFZ.KFY != null)
    {
      localObject = new Rect();
      int[] arrayOfInt = new int[2];
      this.KFZ.KCQ.getLocationOnScreen(arrayOfInt);
      ((Rect)localObject).set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + this.KFZ.KCQ.getMeasuredWidth(), arrayOfInt[1] + this.KFZ.KCQ.getMeasuredHeight());
      i.a(paramView.getContext(), this.KFZ.KFY, (Rect)localObject);
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/MPVideoWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ai.1
 * JD-Core Version:    0.7.0.1
 */