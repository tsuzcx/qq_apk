package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;
import java.util.Arrays;

public class CustomOptionPickNew
  extends FrameLayout
{
  private Context context;
  private int uNA;
  private int uNB;
  private String[] uNw;
  private b<String> uNz;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker));
    AppMethodBeat.i(252592);
    this.context = paramContext;
    this.uNz = new b(paramContext);
    init();
    AppMethodBeat.o(252592);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(252599);
    this.context = paramContext;
    this.uNz = new b(paramContext);
    init();
    AppMethodBeat.o(252599);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252605);
    this.context = paramContext;
    this.uNz = new b(paramContext);
    init();
    AppMethodBeat.o(252605);
  }
  
  private void init()
  {
    AppMethodBeat.i(252612);
    new com.tencent.mm.picker.b.a(this.context, new com.tencent.mm.picker.d.d()
    {
      public final void xY(int paramAnonymousInt)
      {
        AppMethodBeat.i(252569);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(252569);
      }
    }).xU(this.uNB).xT(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_1)).a(this.uNz);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(a.d.bottomsheet_dividing_line_height));
    setItemHeight(this.context.getResources().getDimensionPixelSize(a.d.Edge_3A));
    setDividerColor(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_1));
    this.uNz.pzu.eV(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    this.uNz.pzu.pzz.xS(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_9)).xR(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(androidx.core.content.a.w(this.context, a.c.BG_5));
    AppMethodBeat.o(252612);
  }
  
  public final void aFo(int paramInt)
  {
    AppMethodBeat.i(252630);
    this.uNz.bTf().setCurrentItem(paramInt);
    AppMethodBeat.o(252630);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(252653);
    this.uNz.bTe();
    String str = this.uNw[this.uNA];
    AppMethodBeat.o(252653);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(252638);
    this.uNz.bTe();
    int i = this.uNA;
    AppMethodBeat.o(252638);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(252656);
    WheelView localWheelView = this.uNz.bTf();
    AppMethodBeat.o(252656);
    return localWheelView;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(252635);
    this.uNz.pzu.setDividerColor(paramInt);
    AppMethodBeat.o(252635);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(252647);
    this.uNz.setDividerHeight(paramFloat);
    AppMethodBeat.o(252647);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(c paramc)
  {
    AppMethodBeat.i(252643);
    this.uNz.setOnValueChangedListener(paramc);
    AppMethodBeat.o(252643);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(252624);
    this.uNw = paramArrayOfString;
    this.uNz.cr(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(252624);
  }
  
  public void setValue(int paramInt)
  {
    this.uNB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */