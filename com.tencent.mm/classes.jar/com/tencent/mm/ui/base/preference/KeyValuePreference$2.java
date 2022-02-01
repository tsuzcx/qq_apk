package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class KeyValuePreference$2
  implements View.OnLongClickListener
{
  KeyValuePreference$2(KeyValuePreference paramKeyValuePreference) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(142577);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    boolean bool = this.JsV.Jtv.dBu();
    a.a(bool, this, "com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(142577);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference.2
 * JD-Core Version:    0.7.0.1
 */