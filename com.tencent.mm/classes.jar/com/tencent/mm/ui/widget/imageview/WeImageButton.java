package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a.a;

public class WeImageButton
  extends AppCompatImageButton
{
  private int DGC;
  private int JhK;
  private float JhL;
  private int JhM;
  private boolean JhN;
  private int mAlpha;
  
  public WeImageButton(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(159405);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, null);
    AppMethodBeat.o(159405);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159406);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159406);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159407);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159407);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159409);
    this.JhK = paramContext.getResources().getColor(2131099732);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageBtn);
      this.DGC = paramContext.getColor(0, this.JhK);
      paramContext.recycle();
      AppMethodBeat.o(159409);
      return;
    }
    this.DGC = this.JhK;
    AppMethodBeat.o(159409);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159410);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.JhN))
    {
      paramCanvas = new PorterDuffColorFilter(this.DGC, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.JhN = false;
    }
    AppMethodBeat.o(159410);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159408);
    this.DGC = paramInt;
    this.JhN = true;
    invalidate();
    AppMethodBeat.o(159408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageButton
 * JD-Core Version:    0.7.0.1
 */