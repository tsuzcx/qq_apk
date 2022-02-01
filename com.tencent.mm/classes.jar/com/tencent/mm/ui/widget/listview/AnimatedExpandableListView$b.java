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
  private int jau;
  private Drawable nbH;
  private int zEU;
  List<View> zPZ;
  
  private AnimatedExpandableListView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159420);
    this.zPZ = new ArrayList();
    AppMethodBeat.o(159420);
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159423);
    paramCanvas.save();
    if (this.nbH != null) {
      this.nbH.setBounds(0, 0, this.zEU, this.jau);
    }
    int j = this.zPZ.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.zPZ.get(i);
      localView.draw(paramCanvas);
      paramCanvas.translate(0.0F, localView.getMeasuredHeight());
      if (this.nbH != null)
      {
        this.nbH.draw(paramCanvas);
        paramCanvas.translate(0.0F, this.jau);
      }
      i += 1;
    }
    paramCanvas.restore();
    AppMethodBeat.o(159423);
  }
  
  public final void iO(View paramView)
  {
    AppMethodBeat.i(159421);
    paramView.layout(0, 0, getWidth(), getHeight());
    this.zPZ.add(paramView);
    AppMethodBeat.o(159421);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159422);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.zPZ.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.zPZ.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
    AppMethodBeat.o(159422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b
 * JD-Core Version:    0.7.0.1
 */