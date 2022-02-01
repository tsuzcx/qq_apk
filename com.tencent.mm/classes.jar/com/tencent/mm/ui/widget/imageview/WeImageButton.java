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
import com.tencent.mm.ck.a.a;

public class WeImageButton
  extends AppCompatImageButton
{
  private int Kxl;
  private int QRf;
  private float QRg;
  private int QRh;
  private boolean QRi;
  private int mAlpha;
  
  public WeImageButton(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(159405);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    init(paramContext, null);
    AppMethodBeat.o(159405);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159406);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159406);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159407);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159407);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159409);
    this.QRf = paramContext.getResources().getColor(2131099746);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageBtn);
      this.Kxl = paramContext.getColor(1, this.QRf);
      paramContext.recycle();
      AppMethodBeat.o(159409);
      return;
    }
    this.Kxl = this.QRf;
    AppMethodBeat.o(159409);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159410);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.QRi))
    {
      paramCanvas = new PorterDuffColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.QRi = false;
    }
    AppMethodBeat.o(159410);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159408);
    this.Kxl = paramInt;
    this.QRi = true;
    invalidate();
    AppMethodBeat.o(159408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageButton
 * JD-Core Version:    0.7.0.1
 */