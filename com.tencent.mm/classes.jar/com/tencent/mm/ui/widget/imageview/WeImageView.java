package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;

public class WeImageView
  extends AppCompatImageView
{
  private boolean AHB;
  private int zsg;
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112705);
    this.AHB = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(112705);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112706);
    this.AHB = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(112706);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(112708);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
    this.zsg = paramContext.getColor(0, 0);
    paramContext.recycle();
    AppMethodBeat.o(112708);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112709);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.AHB))
    {
      paramCanvas = new PorterDuffColorFilter(this.zsg, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.AHB = false;
    }
    AppMethodBeat.o(112709);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(112707);
    this.zsg = paramInt;
    this.AHB = true;
    invalidate();
    AppMethodBeat.o(112707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */