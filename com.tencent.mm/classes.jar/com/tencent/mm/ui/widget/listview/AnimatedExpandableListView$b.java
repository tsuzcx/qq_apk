package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class AnimatedExpandableListView$b
  extends View
{
  private int dividerHeight;
  private Drawable fkP;
  List<View> wnQ = new ArrayList();
  private int wnR;
  
  private AnimatedExpandableListView$b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.fkP != null) {
      this.fkP.setBounds(0, 0, this.wnR, this.dividerHeight);
    }
    int j = this.wnQ.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.wnQ.get(i);
      localView.draw(paramCanvas);
      paramCanvas.translate(0.0F, localView.getMeasuredHeight());
      if (this.fkP != null)
      {
        this.fkP.draw(paramCanvas);
        paramCanvas.translate(0.0F, this.dividerHeight);
      }
      i += 1;
    }
    paramCanvas.restore();
  }
  
  public final void el(View paramView)
  {
    paramView.layout(0, 0, getWidth(), getHeight());
    this.wnQ.add(paramView);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.wnQ.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.wnQ.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b
 * JD-Core Version:    0.7.0.1
 */