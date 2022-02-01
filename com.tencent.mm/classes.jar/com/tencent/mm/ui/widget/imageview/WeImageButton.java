package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.k;

public class WeImageButton
  extends AppCompatImageButton
{
  private int RyZ;
  private int YpQ;
  private float YpR;
  private int YpS;
  private boolean YpT;
  private int mAlpha;
  
  public WeImageButton(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(159405);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    init(paramContext, null);
    AppMethodBeat.o(159405);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159406);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159406);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159407);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159407);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159409);
    this.YpQ = paramContext.getResources().getColor(a.c.FG_0);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WeImageBtn);
      this.RyZ = paramContext.getColor(a.k.WeImageBtn_btnIconColor, this.YpQ);
      paramContext.recycle();
      AppMethodBeat.o(159409);
      return;
    }
    this.RyZ = this.YpQ;
    AppMethodBeat.o(159409);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159410);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.YpT))
    {
      paramCanvas = new PorterDuffColorFilter(this.RyZ, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.YpT = false;
    }
    AppMethodBeat.o(159410);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159408);
    this.RyZ = paramInt;
    this.YpT = true;
    invalidate();
    AppMethodBeat.o(159408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageButton
 * JD-Core Version:    0.7.0.1
 */