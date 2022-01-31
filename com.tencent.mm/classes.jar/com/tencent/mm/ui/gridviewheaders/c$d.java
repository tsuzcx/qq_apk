package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$d
  extends FrameLayout
{
  private View[] AoF;
  private boolean AoK;
  private int mNumColumns;
  private int mPosition;
  
  public c$d(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(107339);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(107339);
    return localLayoutParams;
  }
  
  public final Object getTag()
  {
    AppMethodBeat.i(107334);
    Object localObject = getChildAt(0).getTag();
    AppMethodBeat.o(107334);
    return localObject;
  }
  
  public final Object getTag(int paramInt)
  {
    AppMethodBeat.i(107335);
    Object localObject = getChildAt(0).getTag(paramInt);
    AppMethodBeat.o(107335);
    return localObject;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(107336);
    View localView = getChildAt(0);
    AppMethodBeat.o(107336);
    return localView;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(107340);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mNumColumns == 1) || (c.b(this.AoG) == null))
    {
      AppMethodBeat.o(107340);
      return;
    }
    if ((this.mPosition % this.mNumColumns == 0) && (!this.AoK))
    {
      this.AoK = true;
      arrayOfView = this.AoF;
      k = arrayOfView.length;
      i = 0;
      while (i < k)
      {
        arrayOfView[i].measure(paramInt1, paramInt2);
        i += 1;
      }
      this.AoK = false;
    }
    int k = getMeasuredHeight();
    View[] arrayOfView = this.AoF;
    int m = arrayOfView.length;
    int i = k;
    paramInt2 = j;
    while (paramInt2 < m)
    {
      View localView = arrayOfView[paramInt2];
      j = i;
      if (localView != null) {
        j = Math.max(i, localView.getMeasuredHeight());
      }
      paramInt2 += 1;
      i = j;
    }
    if (i == k)
    {
      AppMethodBeat.o(107340);
      return;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    AppMethodBeat.o(107340);
  }
  
  public final void setNumColumns(int paramInt)
  {
    this.mNumColumns = paramInt;
  }
  
  public final void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public final void setRowSiblings(View[] paramArrayOfView)
  {
    this.AoF = paramArrayOfView;
  }
  
  public final void setTag(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(107337);
    getChildAt(0).setTag(paramInt, paramObject);
    AppMethodBeat.o(107337);
  }
  
  public final void setTag(Object paramObject)
  {
    AppMethodBeat.i(107338);
    getChildAt(0).setTag(paramObject);
    AppMethodBeat.o(107338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.d
 * JD-Core Version:    0.7.0.1
 */