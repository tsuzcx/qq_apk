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
  private com.tencent.mm.ui.widget.picker.g.a<String> LaD;
  private Context context;
  private String[] nkL;
  private int nkP;
  private int nkQ;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(192685);
    this.context = paramContext;
    this.LaD = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(192685);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(192686);
    this.context = paramContext;
    this.LaD = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(192686);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192687);
    this.context = paramContext;
    this.LaD = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(192687);
  }
  
  private void init()
  {
    AppMethodBeat.i(192690);
    new com.tencent.mm.ui.widget.picker.b.a(this.context, new e()
    {
      public final void qU(int paramAnonymousInt)
      {
        AppMethodBeat.i(192684);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(192684);
      }
    }).afI(this.nkQ).afH(android.support.v4.content.b.n(this.context, 2131099656)).a(this.LaD);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    setItemHeight(this.context.getResources().getDimensionPixelSize(2131165292));
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099656));
    this.LaD.Lco.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    this.LaD.Lco.Lcq.afG(android.support.v4.content.b.n(this.context, 2131099664)).afF(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(192690);
  }
  
  private void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(192691);
    this.LaD.Lco.setDividerColor(paramInt);
    AppMethodBeat.o(192691);
  }
  
  public final void afC(int paramInt)
  {
    AppMethodBeat.i(192689);
    this.LaD.fNa().setCurrentItem(paramInt);
    AppMethodBeat.o(192689);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(192695);
    this.LaD.aQc();
    String str = this.nkL[this.nkP];
    AppMethodBeat.o(192695);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(192692);
    this.LaD.aQc();
    int i = this.nkP;
    AppMethodBeat.o(192692);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(192696);
    WheelView localWheelView = this.LaD.fNa();
    AppMethodBeat.o(192696);
    return localWheelView;
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(192694);
    this.LaD.Lco.Lcq.setDividerHeight(paramFloat);
    AppMethodBeat.o(192694);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(d paramd)
  {
    AppMethodBeat.i(192693);
    this.LaD.setOnValueChangedListener(paramd);
    AppMethodBeat.o(192693);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(192688);
    this.nkL = paramArrayOfString;
    com.tencent.mm.ui.widget.picker.g.a locala = this.LaD;
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    com.tencent.mm.ui.widget.picker.g.b localb = locala.Lco;
    localb.iMf = paramArrayOfString;
    localb.Lcq.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(localb.iMf));
    localb.Lcq.setCurrentItem(0);
    localb.Lcq.setIsOptions(true);
    b.1 local1 = new b.1(localb);
    if ((paramArrayOfString != null) && (localb.iMg)) {
      localb.Lcq.setOnItemSelectedListener(local1);
    }
    locala.fMZ();
    AppMethodBeat.o(192688);
  }
  
  public void setValue(int paramInt)
  {
    this.nkQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */