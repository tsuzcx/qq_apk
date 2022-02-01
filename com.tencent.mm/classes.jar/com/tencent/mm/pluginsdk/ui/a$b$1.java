package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class a$b$1
  implements View.OnLongClickListener
{
  a$b$1(ImageView paramImageView, String paramString) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(152099);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    ClipboardHelper.setText(this.ytT.getContext(), "UserName:", this.oiH);
    Toast.makeText(this.ytT.getContext(), c.h.app_copy_ok, 0).show();
    a.a(true, this, "com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(152099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.a.b.1
 * JD-Core Version:    0.7.0.1
 */