package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class KeyValuePreference$1
  implements View.OnClickListener
{
  KeyValuePreference$1(KeyValuePreference paramKeyValuePreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142576);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.OYM.OZp.a(this.OYM);
    a.a(this, "com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(142576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference.1
 * JD-Core Version:    0.7.0.1
 */