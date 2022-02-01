package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$2
  extends ViewOutlineProvider
{
  h$2(h paramh) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(310682);
    try
    {
      paramOutline.setOval(0, 0, paramView.getWidth(), paramView.getHeight());
      return;
    }
    finally
    {
      AppMethodBeat.o(310682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.h.2
 * JD-Core Version:    0.7.0.1
 */