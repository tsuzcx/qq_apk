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
  private com.tencent.mm.ui.widget.picker.g.a<String> Lxb;
  private Context context;
  private String[] npT;
  private int npX;
  private int npY;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(200455);
    this.context = paramContext;
    this.Lxb = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(200455);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(200456);
    this.context = paramContext;
    this.Lxb = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(200456);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200457);
    this.context = paramContext;
    this.Lxb = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(200457);
  }
  
  private void init()
  {
    AppMethodBeat.i(200460);
    new com.tencent.mm.ui.widget.picker.b.a(this.context, new e()
    {
      public final void qX(int paramAnonymousInt)
      {
        AppMethodBeat.i(200454);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(200454);
      }
    }).agr(this.npY).agq(android.support.v4.content.b.n(this.context, 2131099656)).a(this.Lxb);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    setItemHeight(this.context.getResources().getDimensionPixelSize(2131165292));
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.Lxb.LyP.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.Lxb.LyP.LyR.agp(android.support.v4.content.b.n(this.context, 2131099664)).ago(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(200460);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(200461);
    this.Lxb.LyP.setDividerColor(paramInt);
    AppMethodBeat.o(200461);
  }
  
  public final void agl(int paramInt)
  {
    AppMethodBeat.i(200459);
    this.Lxb.fRv().setCurrentItem(paramInt);
    AppMethodBeat.o(200459);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(200465);
    this.Lxb.aQB();
    String str = this.npT[this.npX];
    AppMethodBeat.o(200465);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(200462);
    this.Lxb.aQB();
    int i = this.npX;
    AppMethodBeat.o(200462);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(200466);
    WheelView localWheelView = this.Lxb.fRv();
    AppMethodBeat.o(200466);
    return localWheelView;
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(200464);
    this.Lxb.LyP.LyR.setDividerHeight(paramFloat);
    AppMethodBeat.o(200464);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(d paramd)
  {
    AppMethodBeat.i(200463);
    this.Lxb.setOnValueChangedListener(paramd);
    AppMethodBeat.o(200463);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(200458);
    this.npT = paramArrayOfString;
    com.tencent.mm.ui.widget.picker.g.a locala = this.Lxb;
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    com.tencent.mm.ui.widget.picker.g.b localb = locala.LyP;
    localb.iOY = paramArrayOfString;
    localb.LyR.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(localb.iOY));
    localb.LyR.setCurrentItem(0);
    localb.LyR.setIsOptions(true);
    b.1 local1 = new b.1(localb);
    if ((paramArrayOfString != null) && (localb.iOZ)) {
      localb.LyR.setOnItemSelectedListener(local1);
    }
    locala.fRu();
    AppMethodBeat.o(200458);
  }
  
  public void setValue(int paramInt)
  {
    this.npY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */