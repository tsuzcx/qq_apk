package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

public final class n
{
  private static int snq = -1;
  
  public static void a(View paramView, VideoSightView paramVideoSightView)
  {
    if ((paramView == null) || (paramVideoSightView == null)) {
      y.e("VideoSightHelper", "null view object " + paramView + "," + paramVideoSightView);
    }
    while (paramView.getVisibility() != 0) {
      return;
    }
    paramVideoSightView.addOnLayoutChangeListener(new n.1(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */