package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$b$2
  implements View.OnClickListener
{
  a$b$2(ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152100);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = (View)paramView.getParent();
    for (;;)
    {
      if (paramView != null)
      {
        if (!paramView.isClickable()) {
          break label120;
        }
        if (!(paramView instanceof AdapterView)) {
          break label112;
        }
        localObject = this.qlp.getTag();
        if ((localObject instanceof Integer)) {
          ((AdapterView)paramView).performItemClick(null, ((Integer)localObject).intValue(), -1L);
        }
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(152100);
        return;
        label112:
        paramView.performClick();
      }
      label120:
      if ((paramView.getParent() instanceof View)) {
        paramView = (View)paramView.getParent();
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a.b.2
 * JD-Core Version:    0.7.0.1
 */