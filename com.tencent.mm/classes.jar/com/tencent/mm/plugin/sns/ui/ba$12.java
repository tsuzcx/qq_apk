package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.d;

final class ba$12
  implements MMPullDownView.d
{
  ba$12(ba paramba) {}
  
  public final boolean aEV()
  {
    View localView = this.piF.lwE.getChildAt(this.piF.lwE.getFirstVisiblePosition());
    return (localView != null) && (localView.getTop() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.12
 * JD-Core Version:    0.7.0.1
 */