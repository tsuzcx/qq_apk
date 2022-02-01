package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class AnimatedExpandableListView$b
  extends View
{
  List<View> KZk;
  private int KZl;
  private int dividerHeight;
  private Drawable jiP;
  
  private AnimatedExpandableListView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159420);
    this.KZk = new ArrayList();
    AppMethodBeat.o(159420);
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159423);
    paramCanvas.save();
    if (this.jiP != null) {
      this.jiP.setBounds(0, 0, this.KZl, this.dividerHeight);
    }
    int j = this.KZk.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.KZk.get(i);
      localView.draw(paramCanvas);
      paramCanvas.translate(0.0F, localView.getMeasuredHeight());
      if (this.jiP != null)
      {
        this.jiP.draw(paramCanvas);
        paramCanvas.translate(0.0F, this.dividerHeight);
      }
      i += 1;
    }
    paramCanvas.restore();
    AppMethodBeat.o(159423);
  }
  
  public final void he(View paramView)
  {
    AppMethodBeat.i(159421);
    paramView.layout(0, 0, getWidth(), getHeight());
    this.KZk.add(paramView);
    AppMethodBeat.o(159421);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159422);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.KZk.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.KZk.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
    AppMethodBeat.o(159422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b
 * JD-Core Version:    0.7.0.1
 */