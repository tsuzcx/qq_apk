package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.d;
import java.util.Arrays;

public class CustomOptionPickNew
  extends FrameLayout
{
  private Context context;
  private String[] rCh;
  private com.tencent.mm.picker.f.b<String> rCk;
  private int rCl;
  private int rCm;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker));
    AppMethodBeat.i(250897);
    this.context = paramContext;
    this.rCk = new com.tencent.mm.picker.f.b(paramContext);
    init();
    AppMethodBeat.o(250897);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(250899);
    this.context = paramContext;
    this.rCk = new com.tencent.mm.picker.f.b(paramContext);
    init();
    AppMethodBeat.o(250899);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(250900);
    this.context = paramContext;
    this.rCk = new com.tencent.mm.picker.f.b(paramContext);
    init();
    AppMethodBeat.o(250900);
  }
  
  private void init()
  {
    AppMethodBeat.i(250905);
    new com.tencent.mm.picker.b.a(this.context, new c()
    {
      public final void xT(int paramAnonymousInt)
      {
        AppMethodBeat.i(251039);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(251039);
      }
    }).xP(this.rCm).xO(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_1)).a(this.rCk);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(a.d.bottomsheet_dividing_line_height));
    setItemHeight(this.context.getResources().getDimensionPixelSize(a.d.Edge_3A));
    setDividerColor(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_1));
    this.rCk.mCM.ec(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    this.rCk.mCM.mCR.xN(androidx.core.content.a.w(this.context, a.c.BW_0_Alpha_0_9)).xM(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(androidx.core.content.a.w(this.context, a.c.BG_5));
    AppMethodBeat.o(250905);
  }
  
  public final void ayI(int paramInt)
  {
    AppMethodBeat.i(250904);
    this.rCk.buW().setCurrentItem(paramInt);
    AppMethodBeat.o(250904);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(250919);
    this.rCk.buV();
    String str = this.rCh[this.rCl];
    AppMethodBeat.o(250919);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(250907);
    this.rCk.buV();
    int i = this.rCl;
    AppMethodBeat.o(250907);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(250922);
    WheelView localWheelView = this.rCk.buW();
    AppMethodBeat.o(250922);
    return localWheelView;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(250906);
    this.rCk.mCM.setDividerColor(paramInt);
    AppMethodBeat.o(250906);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(250912);
    this.rCk.setDividerHeight(paramFloat);
    AppMethodBeat.o(250912);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(com.tencent.mm.picker.d.b paramb)
  {
    AppMethodBeat.i(250910);
    this.rCk.setOnValueChangedListener(paramb);
    AppMethodBeat.o(250910);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(250901);
    this.rCh = paramArrayOfString;
    this.rCk.aM(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(250901);
  }
  
  public void setValue(int paramInt)
  {
    this.rCm = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */