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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.k;

public class WeImageButton
  extends AppCompatImageButton
{
  private int Yvv;
  private int agid;
  private float agie;
  private int agif;
  private boolean agig;
  private int mAlpha;
  
  public WeImageButton(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(159405);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    init(paramContext, null);
    AppMethodBeat.o(159405);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159406);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159406);
  }
  
  public WeImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159407);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159407);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159409);
    this.agid = paramContext.getResources().getColor(a.c.FG_0);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WeImageBtn);
      this.Yvv = paramContext.getColor(a.k.WeImageBtn_btnIconColor, this.agid);
      paramContext.recycle();
      AppMethodBeat.o(159409);
      return;
    }
    this.Yvv = this.agid;
    AppMethodBeat.o(159409);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159410);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.agig))
    {
      paramCanvas = new PorterDuffColorFilter(this.Yvv, PorterDuff.Mode.SRC_ATOP);
      getDrawable().setColorFilter(paramCanvas);
      this.agig = false;
    }
    AppMethodBeat.o(159410);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159408);
    this.Yvv = paramInt;
    this.agig = true;
    invalidate();
    AppMethodBeat.o(159408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageButton
 * JD-Core Version:    0.7.0.1
 */