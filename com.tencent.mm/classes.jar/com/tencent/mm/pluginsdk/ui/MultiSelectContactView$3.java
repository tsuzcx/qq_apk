package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.selectcontact.a.d;

final class MultiSelectContactView$3
  implements View.OnFocusChangeListener
{
  MultiSelectContactView$3(MultiSelectContactView paramMultiSelectContactView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MultiSelectContactView.e(this.saw).setBackgroundResource(a.d.input_bar_bg_active);
      MultiSelectContactView.e(this.saw).setPadding(MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw));
    }
    for (;;)
    {
      if (MultiSelectContactView.g(this.saw) != null) {
        MultiSelectContactView.g(this.saw).cmt();
      }
      return;
      MultiSelectContactView.e(this.saw).setBackgroundResource(a.d.input_bar_bg_normal);
      MultiSelectContactView.e(this.saw).setPadding(MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw), MultiSelectContactView.f(this.saw));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.3
 * JD-Core Version:    0.7.0.1
 */