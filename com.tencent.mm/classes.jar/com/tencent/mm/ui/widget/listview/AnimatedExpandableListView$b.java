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
  List<View> JhV;
  private int JhW;
  private int dividerHeight;
  private Drawable iPH;
  
  private AnimatedExpandableListView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159420);
    this.JhV = new ArrayList();
    AppMethodBeat.o(159420);
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159423);
    paramCanvas.save();
    if (this.iPH != null) {
      this.iPH.setBounds(0, 0, this.JhW, this.dividerHeight);
    }
    int j = this.JhV.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.JhV.get(i);
      localView.draw(paramCanvas);
      paramCanvas.translate(0.0F, localView.getMeasuredHeight());
      if (this.iPH != null)
      {
        this.iPH.draw(paramCanvas);
        paramCanvas.translate(0.0F, this.dividerHeight);
      }
      i += 1;
    }
    paramCanvas.restore();
    AppMethodBeat.o(159423);
  }
  
  public final void gN(View paramView)
  {
    AppMethodBeat.i(159421);
    paramView.layout(0, 0, getWidth(), getHeight());
    this.JhV.add(paramView);
    AppMethodBeat.o(159421);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159422);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.JhV.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.JhV.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
    AppMethodBeat.o(159422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b
 * JD-Core Version:    0.7.0.1
 */