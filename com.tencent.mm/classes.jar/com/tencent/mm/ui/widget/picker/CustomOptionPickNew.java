package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.d;
import com.tencent.mm.ui.widget.picker.d.e;
import com.tencent.mm.ui.widget.picker.g.b.1;
import java.util.Arrays;

public class CustomOptionPickNew
  extends FrameLayout
{
  private com.tencent.mm.ui.widget.picker.g.a<String> HIJ;
  private Context context;
  private String[] mip;
  private int mit;
  private int miu;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(195269);
    this.context = paramContext;
    this.HIJ = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(195269);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(195270);
    this.context = paramContext;
    this.HIJ = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(195270);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195271);
    this.context = paramContext;
    this.HIJ = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(195271);
  }
  
  private void init()
  {
    AppMethodBeat.i(195274);
    new com.tencent.mm.ui.widget.picker.b.a(this.context, new e()
    {
      public final void pH(int paramAnonymousInt)
      {
        AppMethodBeat.i(195268);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(195268);
      }
    }).aaW(this.miu).aaV(android.support.v4.content.b.n(this.context, 2131099656)).a(this.HIJ);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    setItemHeight(this.context.getResources().getDimensionPixelSize(2131165292));
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.HIJ.HKu.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.HIJ.HKu.HKw.aaU(android.support.v4.content.b.n(this.context, 2131099664)).aaT(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(195274);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(195275);
    this.HIJ.HKu.setDividerColor(paramInt);
    AppMethodBeat.o(195275);
  }
  
  public final void aaQ(int paramInt)
  {
    AppMethodBeat.i(195273);
    this.HIJ.fgm().setCurrentItem(paramInt);
    AppMethodBeat.o(195273);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(195279);
    this.HIJ.aGe();
    String str = this.mip[this.mit];
    AppMethodBeat.o(195279);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(195276);
    this.HIJ.aGe();
    int i = this.mit;
    AppMethodBeat.o(195276);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(195280);
    WheelView localWheelView = this.HIJ.fgm();
    AppMethodBeat.o(195280);
    return localWheelView;
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(195278);
    this.HIJ.HKu.HKw.setDividerHeight(paramFloat);
    AppMethodBeat.o(195278);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(d paramd)
  {
    AppMethodBeat.i(195277);
    this.HIJ.setOnValueChangedListener(paramd);
    AppMethodBeat.o(195277);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(195272);
    this.mip = paramArrayOfString;
    com.tencent.mm.ui.widget.picker.g.a locala = this.HIJ;
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    com.tencent.mm.ui.widget.picker.g.b localb = locala.HKu;
    localb.hSX = paramArrayOfString;
    localb.HKw.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(localb.hSX));
    localb.HKw.setCurrentItem(0);
    localb.HKw.setIsOptions(true);
    b.1 local1 = new b.1(localb);
    if ((paramArrayOfString != null) && (localb.hSY)) {
      localb.HKw.setOnItemSelectedListener(local1);
    }
    locala.fgl();
    AppMethodBeat.o(195272);
  }
  
  public void setValue(int paramInt)
  {
    this.miu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */