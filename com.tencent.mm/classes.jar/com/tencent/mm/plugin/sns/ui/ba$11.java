package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.ui.base.MMPullDownView.c;

final class ba$11
  implements MMPullDownView.c
{
  ba$11(ba paramba) {}
  
  public final boolean aEW()
  {
    View localView = this.piF.lwE.getChildAt(this.piF.lwE.getChildCount() - 1);
    return (localView != null) && (localView.getBottom() <= this.piF.lwE.getHeight()) && (this.piF.lwE.getLastVisiblePosition() == this.piF.lwE.getAdapter().getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.11
 * JD-Core Version:    0.7.0.1
 */