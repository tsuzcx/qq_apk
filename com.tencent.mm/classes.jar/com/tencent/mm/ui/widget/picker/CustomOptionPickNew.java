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
  private com.tencent.mm.ui.widget.picker.g.a<String> Jjg;
  private Context context;
  private String[] mKp;
  private int mKt;
  private int mKu;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(199739);
    this.context = paramContext;
    this.Jjg = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(199739);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(199740);
    this.context = paramContext;
    this.Jjg = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(199740);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199741);
    this.context = paramContext;
    this.Jjg = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(199741);
  }
  
  private void init()
  {
    AppMethodBeat.i(199744);
    new com.tencent.mm.ui.widget.picker.b.a(this.context, new e()
    {
      public final void qu(int paramAnonymousInt)
      {
        AppMethodBeat.i(199738);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(199738);
      }
    }).adi(this.mKu).adh(android.support.v4.content.b.n(this.context, 2131099656)).a(this.Jjg);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    setItemHeight(this.context.getResources().getDimensionPixelSize(2131165292));
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.Jjg.JkR.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.Jjg.JkR.JkT.adg(android.support.v4.content.b.n(this.context, 2131099664)).adf(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(199744);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(199745);
    this.Jjg.JkR.setDividerColor(paramInt);
    AppMethodBeat.o(199745);
  }
  
  public final void adb(int paramInt)
  {
    AppMethodBeat.i(199743);
    this.Jjg.fwm().setCurrentItem(paramInt);
    AppMethodBeat.o(199743);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(199749);
    this.Jjg.aMR();
    String str = this.mKp[this.mKt];
    AppMethodBeat.o(199749);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(199746);
    this.Jjg.aMR();
    int i = this.mKt;
    AppMethodBeat.o(199746);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(199750);
    WheelView localWheelView = this.Jjg.fwm();
    AppMethodBeat.o(199750);
    return localWheelView;
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(199748);
    this.Jjg.JkR.JkT.setDividerHeight(paramFloat);
    AppMethodBeat.o(199748);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(d paramd)
  {
    AppMethodBeat.i(199747);
    this.Jjg.setOnValueChangedListener(paramd);
    AppMethodBeat.o(199747);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(199742);
    this.mKp = paramArrayOfString;
    com.tencent.mm.ui.widget.picker.g.a locala = this.Jjg;
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    com.tencent.mm.ui.widget.picker.g.b localb = locala.JkR;
    localb.itc = paramArrayOfString;
    localb.JkT.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(localb.itc));
    localb.JkT.setCurrentItem(0);
    localb.JkT.setIsOptions(true);
    b.1 local1 = new b.1(localb);
    if ((paramArrayOfString != null) && (localb.itd)) {
      localb.JkT.setOnItemSelectedListener(local1);
    }
    locala.fwl();
    AppMethodBeat.o(199742);
  }
  
  public void setValue(int paramInt)
  {
    this.mKu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */