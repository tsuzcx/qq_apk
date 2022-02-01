package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NearLifeCreatePoiUI$2
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$2(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26598);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.setClass(this.wHk.getContext(), SelectPoiCategoryUI.class);
    this.wHk.startActivityForResult(paramView, 2);
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.2
 * JD-Core Version:    0.7.0.1
 */