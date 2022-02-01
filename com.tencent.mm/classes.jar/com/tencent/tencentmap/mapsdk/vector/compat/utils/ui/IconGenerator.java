package com.tencent.tencentmap.mapsdk.vector.compat.utils.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

public class IconGenerator
{
  public static final int SQUARE_TEXT_VIEW_ID;
  public static final int STYLE_BLUE = 4;
  public static final int STYLE_DEFAULT = 1;
  public static final int STYLE_GREEN = 5;
  public static final int STYLE_ORANGE = 7;
  public static final int STYLE_PURPLE = 6;
  public static final int STYLE_RED = 3;
  public static final int STYLE_WHITE = 2;
  private final Context a;
  private ViewGroup b;
  private RotationLayout c;
  private TextView d;
  private View e;
  private int f;
  private float g;
  private float h;
  
  static
  {
    AppMethodBeat.i(190547);
    SQUARE_TEXT_VIEW_ID = new AtomicInteger(1).get();
    AppMethodBeat.o(190547);
  }
  
  public IconGenerator(Context paramContext)
  {
    AppMethodBeat.i(190533);
    this.g = 0.5F;
    this.h = 1.0F;
    this.a = paramContext;
    this.b = a();
    this.c = ((RotationLayout)this.b.getChildAt(0));
    this.e = this.d;
    setStyle(1);
    AppMethodBeat.o(190533);
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(190541);
    switch (this.f)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(190541);
      throw localIllegalStateException;
    case 0: 
      AppMethodBeat.o(190541);
      return paramFloat1;
    case 1: 
      AppMethodBeat.o(190541);
      return 1.0F - paramFloat2;
    case 2: 
      AppMethodBeat.o(190541);
      return 1.0F - paramFloat1;
    }
    AppMethodBeat.o(190541);
    return paramFloat2;
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    }
    return 1;
  }
  
  private ViewGroup a()
  {
    AppMethodBeat.i(190534);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.c = new RotationLayout(this.a);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.d = new TextView(this.a);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 1;
    this.d.setLayoutParams(localLayoutParams);
    this.d.setPadding(10, 5, 10, 5);
    this.d.setId(SQUARE_TEXT_VIEW_ID);
    this.c.addView(this.d);
    localLinearLayout.addView(this.c);
    AppMethodBeat.o(190534);
    return localLinearLayout;
  }
  
  public float getAnchorU()
  {
    AppMethodBeat.i(190539);
    float f1 = a(this.g, this.h);
    AppMethodBeat.o(190539);
    return f1;
  }
  
  public float getAnchorV()
  {
    AppMethodBeat.i(190540);
    float f1 = a(this.h, this.g);
    AppMethodBeat.o(190540);
    return f1;
  }
  
  public Bitmap makeIcon()
  {
    AppMethodBeat.i(190536);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.b.measure(i, i);
    int j = this.b.getMeasuredWidth();
    i = this.b.getMeasuredHeight();
    this.b.layout(0, 0, j, i);
    if ((this.f == 1) || (this.f == 3))
    {
      i = this.b.getMeasuredWidth();
      j = this.b.getMeasuredHeight();
    }
    Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    localBitmap.eraseColor(0);
    Canvas localCanvas = new Canvas(localBitmap);
    if (this.f != 0)
    {
      if (this.f != 1) {
        break label149;
      }
      localCanvas.translate(j, 0.0F);
      localCanvas.rotate(90.0F);
    }
    for (;;)
    {
      this.b.draw(localCanvas);
      AppMethodBeat.o(190536);
      return localBitmap;
      label149:
      if (this.f == 2)
      {
        localCanvas.rotate(180.0F, j / 2, i / 2);
      }
      else
      {
        localCanvas.translate(0.0F, i);
        localCanvas.rotate(270.0F);
      }
    }
  }
  
  public Bitmap makeIcon(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190535);
    if (this.d != null) {
      this.d.setText(paramCharSequence);
    }
    paramCharSequence = makeIcon();
    AppMethodBeat.o(190535);
    return paramCharSequence;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(190545);
    this.b.setBackgroundDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      Rect localRect = new Rect();
      paramDrawable.getPadding(localRect);
      this.b.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(190545);
      return;
    }
    this.b.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(190545);
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190546);
    this.e.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(190546);
  }
  
  public void setContentRotation(int paramInt)
  {
    AppMethodBeat.i(190538);
    this.c.setViewRotation(paramInt);
    AppMethodBeat.o(190538);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(190537);
    this.c.removeAllViews();
    this.c.addView(paramView);
    this.e = paramView;
    paramView = this.c.findViewById(SQUARE_TEXT_VIEW_ID);
    if ((paramView instanceof TextView)) {}
    for (paramView = (TextView)paramView;; paramView = null)
    {
      this.d = paramView;
      AppMethodBeat.o(190537);
      return;
    }
  }
  
  public void setRotation(int paramInt)
  {
    this.f = ((paramInt + 360) % 360 / 90);
  }
  
  public void setStyle(int paramInt)
  {
    AppMethodBeat.i(190544);
    setTextAppearance(this.a, a(paramInt));
    if (paramInt == 0)
    {
      setTextAppearance(16973892, -8421505, 14.0F, 0);
      AppMethodBeat.o(190544);
      return;
    }
    if (paramInt == 1) {
      setTextAppearance(16973892, -1118482, 14.0F, 0);
    }
    AppMethodBeat.o(190544);
  }
  
  public void setTextAppearance(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    AppMethodBeat.i(190543);
    setTextAppearance(this.a, paramInt1);
    this.d.setTextColor(paramInt2);
    this.d.setTextSize(paramFloat);
    this.d.setTypeface(this.d.getTypeface(), paramInt3);
    AppMethodBeat.o(190543);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(190542);
    if (this.d != null) {
      this.d.setTextAppearance(paramContext, paramInt);
    }
    AppMethodBeat.o(190542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.ui.IconGenerator
 * JD-Core Version:    0.7.0.1
 */