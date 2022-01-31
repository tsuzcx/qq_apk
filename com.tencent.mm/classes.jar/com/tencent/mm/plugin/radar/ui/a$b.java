package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.view.View;
import android.view.View.OnClickListener;

final class a$b
  implements View.OnClickListener
{
  a$b(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    RadarSpecialGridView.a locala = this.nlK.nlI.getOnItemClickListener();
    if (locala != null)
    {
      int i = this.hgx;
      g.j(paramView, "v");
      locala.e(i, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a.b
 * JD-Core Version:    0.7.0.1
 */