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
  private com.tencent.mm.ui.widget.picker.g.a<String> QSN;
  private Context context;
  private String[] ozA;
  private int ozE;
  private int ozF;
  
  public CustomOptionPickNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727));
    AppMethodBeat.i(198401);
    this.context = paramContext;
    this.QSN = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(198401);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727), paramAttributeSet);
    AppMethodBeat.i(198402);
    this.context = paramContext;
    this.QSN = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(198402);
  }
  
  public CustomOptionPickNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198403);
    this.context = paramContext;
    this.QSN = new com.tencent.mm.ui.widget.picker.g.a(paramContext);
    init();
    AppMethodBeat.o(198403);
  }
  
  private void init()
  {
    AppMethodBeat.i(198406);
    new com.tencent.mm.ui.widget.picker.b.a(this.context, new e()
    {
      public final void uP(int paramAnonymousInt)
      {
        AppMethodBeat.i(198400);
        CustomOptionPickNew.a(CustomOptionPickNew.this, paramAnonymousInt);
        AppMethodBeat.o(198400);
      }
    }).apu(this.ozF).apt(android.support.v4.content.b.n(this.context, 2131099657)).a(this.QSN);
    setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165950));
    setItemHeight(this.context.getResources().getDimensionPixelSize(2131165299));
    setDividerColor(android.support.v4.content.b.n(this.context, 2131099657));
    this.QSN.QUF.dE(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
    this.QSN.QUF.QUH.aps(android.support.v4.content.b.n(this.context, 2131099669)).apr(this.context.getResources().getDimensionPixelSize(2131165296)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    AppMethodBeat.o(198406);
  }
  
  public final void apo(int paramInt)
  {
    AppMethodBeat.i(198405);
    this.QSN.hcx().setCurrentItem(paramInt);
    AppMethodBeat.o(198405);
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(198411);
    this.QSN.blg();
    String str = this.ozA[this.ozE];
    AppMethodBeat.o(198411);
    return str;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(198408);
    this.QSN.blg();
    int i = this.ozE;
    AppMethodBeat.o(198408);
    return i;
  }
  
  public WheelView getView()
  {
    AppMethodBeat.i(198412);
    WheelView localWheelView = this.QSN.hcx();
    AppMethodBeat.o(198412);
    return localWheelView;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(198407);
    this.QSN.QUF.setDividerColor(paramInt);
    AppMethodBeat.o(198407);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(198410);
    this.QSN.QUF.QUH.setDividerHeight(paramFloat);
    AppMethodBeat.o(198410);
  }
  
  public void setItemHeight(int paramInt) {}
  
  public void setOnValueChangedListener(d paramd)
  {
    AppMethodBeat.i(198409);
    this.QSN.setOnValueChangedListener(paramd);
    AppMethodBeat.o(198409);
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    AppMethodBeat.i(198404);
    this.ozA = paramArrayOfString;
    com.tencent.mm.ui.widget.picker.g.a locala = this.QSN;
    paramArrayOfString = Arrays.asList(paramArrayOfString);
    com.tencent.mm.ui.widget.picker.g.b localb = locala.QUF;
    localb.jLN = paramArrayOfString;
    localb.QUH.setAdapter(new com.tencent.mm.ui.widget.picker.a.a(localb.jLN));
    localb.QUH.setCurrentItem(0);
    localb.QUH.setIsOptions(true);
    b.1 local1 = new b.1(localb);
    if ((paramArrayOfString != null) && (localb.jLO)) {
      localb.QUH.setOnItemSelectedListener(local1);
    }
    locala.hcw();
    AppMethodBeat.o(198404);
  }
  
  public void setValue(int paramInt)
  {
    this.ozF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomOptionPickNew
 * JD-Core Version:    0.7.0.1
 */