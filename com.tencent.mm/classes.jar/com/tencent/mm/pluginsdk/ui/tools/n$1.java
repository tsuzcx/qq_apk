package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

final class n$1
  implements View.OnLayoutChangeListener
{
  n$1(View paramView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramInt4 - paramInt2;
    if ((paramInt1 > 0) && (paramInt8 - paramInt6 != paramInt1)) {
      paramView.post(new n.1.1(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.n.1
 * JD-Core Version:    0.7.0.1
 */