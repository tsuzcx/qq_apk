package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.i;

final class ArtistHeader$1$1
  implements View.OnClickListener
{
  ArtistHeader$1$1(ArtistHeader.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97726);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ArtistHeader.a(this.EnZ.EnY).dismiss();
    a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistHeader$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(97726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistHeader.1.1
 * JD-Core Version:    0.7.0.1
 */