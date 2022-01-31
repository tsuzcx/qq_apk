package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  public static void a(Context paramContext, ScrollView paramScrollView, View paramView1, View paramView2, View paramView3)
  {
    AppMethodBeat.i(107752);
    a(paramContext, paramScrollView, paramView1, paramView2, paramView3, 72, 0.0F);
    AppMethodBeat.o(107752);
  }
  
  public static void a(Context paramContext, ScrollView paramScrollView, View paramView1, View paramView2, View paramView3, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(142773);
    if (paramView3 == null)
    {
      AppMethodBeat.o(142773);
      return;
    }
    paramScrollView.post(new o.1(paramView3, paramContext, paramInt, paramView1, paramFloat, paramView2, paramScrollView));
    AppMethodBeat.o(142773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */