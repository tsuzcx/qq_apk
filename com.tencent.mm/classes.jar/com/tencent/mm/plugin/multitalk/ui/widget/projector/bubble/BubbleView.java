package com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;

public class BubbleView
  extends RelativeLayout
  implements Runnable
{
  protected a FDW;
  protected float FDX;
  protected RelativeLayout FDY;
  protected ImageView FDZ;
  protected int FEa;
  protected int FEb;
  float FEc;
  float FEd;
  float FEe;
  int arrowRes;
  protected int backgroundColor;
  private TextView iXU;
  protected Context mContext;
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202095);
    this.FEc = 0.0F;
    this.FEd = 0.0F;
    this.FEe = 0.0F;
    this.arrowRes = -1;
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(202095);
  }
  
  public BubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202097);
    this.FEc = 0.0F;
    this.FEd = 0.0F;
    this.FEe = 0.0F;
    this.arrowRes = -1;
    d(paramContext, paramAttributeSet);
    AppMethodBeat.o(202097);
  }
  
  private void a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, String paramString)
  {
    AppMethodBeat.i(202115);
    this.FDY = new RelativeLayout(this.mContext);
    this.FDY.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, (int)this.FEe);
    Object localObject = new a(paramInt1, paramFloat1);
    this.FDY.setBackground((Drawable)localObject);
    a(paramInt2, paramFloat2, paramString);
    this.FDZ = new ImageView(this.mContext);
    this.FDZ.setId(View.generateViewId());
    paramString = new RelativeLayout.LayoutParams((int)this.FEc, (int)this.FEd);
    switch (1.FEf[this.FDW.ordinal()])
    {
    default: 
      paramInt1 = 270;
      paramString.addRule(17, this.FDY.getId());
    }
    for (;;)
    {
      localObject = new BitmapDrawable(BitmapUtil.rotate(b(au.o(this.mContext, this.arrowRes, this.mContext.getResources().getColor(a.b.White)), this.FEc, this.FEd), paramInt1));
      this.FDZ.setImageDrawable((Drawable)localObject);
      addView(this.FDZ, paramString);
      addView(this.FDY, localLayoutParams);
      this.FDY.post(this);
      setClickable(true);
      AppMethodBeat.o(202115);
      return;
      paramInt1 = 90;
      localLayoutParams.addRule(17, this.FDZ.getId());
      continue;
      paramInt1 = 180;
      localLayoutParams.addRule(3, this.FDZ.getId());
      continue;
      paramInt1 = 0;
      paramString.addRule(3, this.FDY.getId());
    }
  }
  
  private void a(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(202120);
    b(paramInt, paramFloat, paramString);
    this.FDY.addView(this.iXU);
    AppMethodBeat.o(202120);
  }
  
  private static Bitmap b(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202118);
    Bitmap localBitmap = Bitmap.createBitmap((int)paramFloat1, (int)paramFloat2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, (int)paramFloat1, (int)paramFloat2);
    paramDrawable.draw(localCanvas);
    AppMethodBeat.o(202118);
    return localBitmap;
  }
  
  private void b(int paramInt, float paramFloat, String paramString)
  {
    AppMethodBeat.i(202127);
    this.iXU = new TextView(this.mContext);
    this.iXU.setId(View.generateViewId());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(17);
    localLayoutParams.setMarginStart(f.FxG);
    localLayoutParams.setMarginEnd(f.FxG);
    localLayoutParams.topMargin = f.FxG;
    localLayoutParams.bottomMargin = f.FxG;
    this.iXU.setLayoutParams(localLayoutParams);
    this.iXU.setTextColor(paramInt);
    this.iXU.setTextSize(aw.H(this.mContext, (int)paramFloat));
    this.iXU.setText(paramString);
    AppMethodBeat.o(202127);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(202102);
    this.mContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.BubbleTextView);
    float f1 = paramContext.getDimension(a.i.BubbleTextView_bubbleCornerRadius, 0.0F);
    this.backgroundColor = paramContext.getColor(a.i.BubbleTextView_bubbleBackgroundColor, 0);
    this.FEc = paramContext.getDimension(a.i.BubbleTextView_arrowWidth, 0.0F);
    this.FEd = paramContext.getDimension(a.i.BubbleTextView_arrowHeight, 0.0F);
    int i = paramContext.getColor(a.i.BubbleTextView_bubbleTextColor, 0);
    float f2 = paramContext.getDimension(a.i.BubbleTextView_bubbleTextSize, 0.0F);
    paramAttributeSet = paramContext.getString(a.i.BubbleTextView_bubbleText);
    this.arrowRes = paramContext.getResourceId(a.i.BubbleTextView_arrowRes, -1);
    setCurDirection(paramContext.getInt(a.i.BubbleTextView_bubbleArrowDirection, 3));
    setRelativePosition(paramContext.getFraction(a.i.BubbleTextView_relativePosition, 1, 1, 0.3F));
    setCurThemeStyle(i);
    this.FEe = paramContext.getDimension(a.i.BubbleTextView_contentHeight, 0.0F);
    paramContext.recycle();
    a(f1, this.backgroundColor, i, f2, paramAttributeSet);
    AppMethodBeat.o(202102);
  }
  
  private void setCurDirection(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.FDW = a.FEg;
      return;
    case 2: 
      this.FDW = a.FEh;
      return;
    case 3: 
      this.FDW = a.FEi;
      return;
    }
    this.FDW = a.FEj;
  }
  
  private void setRelativePosition(float paramFloat)
  {
    if (paramFloat < 0.2F)
    {
      this.FDX = 0.2F;
      return;
    }
    if (paramFloat > 0.8F)
    {
      this.FDX = 0.8F;
      return;
    }
    this.FDX = paramFloat;
  }
  
  public float getRelative()
  {
    return this.FDX;
  }
  
  public void run()
  {
    AppMethodBeat.i(202133);
    int i = this.FDY.getWidth();
    int j = this.FDY.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.FDZ.getLayoutParams();
    switch (1.FEf[this.FDW.ordinal()])
    {
    default: 
      this.FEa = ((int)(j * this.FDX - this.FDZ.getHeight() / 2));
      localLayoutParams.setMargins(0, this.FEa, 0, 0);
    }
    for (;;)
    {
      this.FDZ.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(202133);
      return;
      this.FEa = ((int)(i * this.FDX - this.FDZ.getWidth() / 2));
      localLayoutParams.setMargins(this.FEa, 0, 0, 0);
    }
  }
  
  public void setCurThemeStyle(int paramInt)
  {
    this.FEb = 3;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(204250);
      FEg = new a("LEFT", 0);
      FEh = new a("TOP", 1);
      FEi = new a("RIGHT", 2);
      FEj = new a("BOTTOM", 3);
      FEk = new a[] { FEg, FEh, FEi, FEj };
      AppMethodBeat.o(204250);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble.BubbleView
 * JD-Core Version:    0.7.0.1
 */