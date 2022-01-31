package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$4
  implements DynamicGridView.f
{
  e$4(e parame, DynamicGridView paramDynamicGridView, View paramView) {}
  
  public final void cxd()
  {
    AppMethodBeat.i(40324);
    DynamicGridView localDynamicGridView = this.skM;
    localDynamicGridView.lNb = false;
    localDynamicGridView.requestDisallowInterceptTouchEvent(false);
    if ((DynamicGridView.cxj()) && (localDynamicGridView.slj)) {
      localDynamicGridView.lH(true);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.skM.setElevation(this.skN.skF);
      AppMethodBeat.o(40324);
      return;
    }
    this.skO.bringToFront();
    AppMethodBeat.o(40324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.4
 * JD-Core Version:    0.7.0.1
 */