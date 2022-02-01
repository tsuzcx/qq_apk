package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioGroupView
  extends LinearLayout
{
  private int WlQ;
  private MMRadioImageButton.a WlR;
  private b WlS;
  private c WlT;
  private MMRadioImageButton WlU;
  private d WlV;
  private int kqc;
  
  public MMRadioGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142106);
    this.kqc = -1;
    this.WlQ = -1;
    this.WlR = new a();
    this.WlT = new c((byte)0);
    super.setOnHierarchyChangeListener(this.WlT);
    AppMethodBeat.o(142106);
  }
  
  private void r(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(142109);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof MMRadioImageButton))) {
      ((MMRadioImageButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(142109);
  }
  
  private void setCheckedButton(MMRadioImageButton paramMMRadioImageButton)
  {
    this.WlU = paramMMRadioImageButton;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.kqc = paramInt;
  }
  
  private void setClickedId(int paramInt)
  {
    this.WlQ = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(142108);
    if ((paramView instanceof MMRadioImageButton))
    {
      MMRadioImageButton localMMRadioImageButton = (MMRadioImageButton)paramView;
      if (localMMRadioImageButton.isChecked())
      {
        if (this.kqc != -1) {
          r(this.kqc, false);
        }
        setCheckedId(localMMRadioImageButton.getId());
        setCheckedButton(localMMRadioImageButton);
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(142108);
  }
  
  public MMRadioImageButton getCheckedRadioButton()
  {
    return this.WlU;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.kqc;
  }
  
  public int getClickedRadioButtonId()
  {
    return this.WlQ;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(142107);
    super.onFinishInflate();
    if (this.kqc != -1)
    {
      r(this.kqc, true);
      setCheckedId(this.kqc);
    }
    AppMethodBeat.o(142107);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142110);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(142110);
  }
  
  public void setOnMMRadioGroupCheckedChangeListener(b paramb)
  {
    this.WlS = paramb;
  }
  
  public void setOnSizeChangeObserver(d paramd)
  {
    this.WlV = paramd;
  }
  
  final class a
    implements MMRadioImageButton.a
  {
    a() {}
    
    public final void a(MMRadioImageButton paramMMRadioImageButton)
    {
      AppMethodBeat.i(142102);
      if (MMRadioGroupView.a(MMRadioGroupView.this) != -1) {
        MMRadioGroupView.a(MMRadioGroupView.this, MMRadioGroupView.a(MMRadioGroupView.this));
      }
      int i = paramMMRadioImageButton.getId();
      MMRadioGroupView.a(MMRadioGroupView.this, paramMMRadioImageButton);
      MMRadioGroupView.b(MMRadioGroupView.this, i);
      AppMethodBeat.o(142102);
    }
    
    public final void b(MMRadioImageButton paramMMRadioImageButton)
    {
      AppMethodBeat.i(142103);
      MMRadioGroupView.c(MMRadioGroupView.this, paramMMRadioImageButton.getId());
      AppMethodBeat.o(142103);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener Hm;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(142104);
      if ((paramView1 == MMRadioGroupView.this) && ((paramView2 instanceof MMRadioImageButton)))
      {
        if (paramView2.getId() == -1)
        {
          int j = paramView2.hashCode();
          int i = j;
          if (j < 0) {
            i = j & 0x7FFFFFFF;
          }
          paramView2.setId(i);
        }
        ((MMRadioImageButton)paramView2).setOnOtherMMRadioButtonCheckedChangeListener(MMRadioGroupView.b(MMRadioGroupView.this));
      }
      if (this.Hm != null) {
        this.Hm.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(142104);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(142105);
      if ((paramView1 == MMRadioGroupView.this) && ((paramView2 instanceof MMRadioImageButton))) {
        ((MMRadioImageButton)paramView2).setOnOtherMMRadioButtonCheckedChangeListener(null);
      }
      if (this.Hm != null) {
        this.Hm.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(142105);
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView
 * JD-Core Version:    0.7.0.1
 */