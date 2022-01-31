package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
{
  private static int wfL = -1;
  
  public static void a(View paramView, VideoSightView paramVideoSightView)
  {
    AppMethodBeat.i(70414);
    if ((paramView == null) || (paramVideoSightView == null))
    {
      ab.e("VideoSightHelper", "null view object " + paramView + "," + paramVideoSightView);
      AppMethodBeat.o(70414);
      return;
    }
    if (paramView.getVisibility() == 0) {
      paramVideoSightView.addOnLayoutChangeListener(new p.1(paramView));
    }
    AppMethodBeat.o(70414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */