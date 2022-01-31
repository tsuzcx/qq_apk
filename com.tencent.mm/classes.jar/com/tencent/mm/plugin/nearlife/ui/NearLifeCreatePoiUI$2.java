package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearLifeCreatePoiUI$2
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$2(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22972);
    paramView = new Intent();
    paramView.setClass(this.pfL.getContext(), SelectPoiCategoryUI.class);
    this.pfL.startActivityForResult(paramView, 2);
    AppMethodBeat.o(22972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.2
 * JD-Core Version:    0.7.0.1
 */