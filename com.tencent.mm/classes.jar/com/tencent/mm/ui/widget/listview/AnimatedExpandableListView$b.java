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
  List<View> AHJ;
  private int AHK;
  private int dividerHeight;
  private Drawable gCg;
  
  private AnimatedExpandableListView$b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112712);
    this.AHJ = new ArrayList();
    AppMethodBeat.o(112712);
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112715);
    paramCanvas.save();
    if (this.gCg != null) {
      this.gCg.setBounds(0, 0, this.AHK, this.dividerHeight);
    }
    int j = this.AHJ.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.AHJ.get(i);
      localView.draw(paramCanvas);
      paramCanvas.translate(0.0F, localView.getMeasuredHeight());
      if (this.gCg != null)
      {
        this.gCg.draw(paramCanvas);
        paramCanvas.translate(0.0F, this.dividerHeight);
      }
      i += 1;
    }
    paramCanvas.restore();
    AppMethodBeat.o(112715);
  }
  
  public final void fw(View paramView)
  {
    AppMethodBeat.i(112713);
    paramView.layout(0, 0, getWidth(), getHeight());
    this.AHJ.add(paramView);
    AppMethodBeat.o(112713);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(112714);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.AHJ.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.AHJ.get(i)).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
    AppMethodBeat.o(112714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b
 * JD-Core Version:    0.7.0.1
 */