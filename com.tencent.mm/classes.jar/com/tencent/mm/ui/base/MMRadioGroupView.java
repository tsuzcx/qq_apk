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
  private int FZp;
  private int FZq;
  private MMRadioImageButton.a FZr;
  private b FZs;
  private c FZt;
  private MMRadioImageButton FZu;
  private d FZv;
  
  public MMRadioGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142106);
    this.FZp = -1;
    this.FZq = -1;
    this.FZr = new a();
    this.FZt = new c((byte)0);
    super.setOnHierarchyChangeListener(this.FZt);
    AppMethodBeat.o(142106);
  }
  
  private void c(int paramInt, boolean paramBoolean)
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
    this.FZu = paramMMRadioImageButton;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.FZp = paramInt;
  }
  
  private void setClickedId(int paramInt)
  {
    this.FZq = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(142108);
    if ((paramView instanceof MMRadioImageButton))
    {
      MMRadioImageButton localMMRadioImageButton = (MMRadioImageButton)paramView;
      if (localMMRadioImageButton.isChecked())
      {
        if (this.FZp != -1) {
          c(this.FZp, false);
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
    return this.FZu;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.FZp;
  }
  
  public int getClickedRadioButtonId()
  {
    return this.FZq;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(142107);
    super.onFinishInflate();
    if (this.FZp != -1)
    {
      c(this.FZp, true);
      setCheckedId(this.FZp);
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
    this.FZs = paramb;
  }
  
  public void setOnSizeChangeObserver(d paramd)
  {
    this.FZv = paramd;
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
    private ViewGroup.OnHierarchyChangeListener nC;
    
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
      if (this.nC != null) {
        this.nC.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(142104);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(142105);
      if ((paramView1 == MMRadioGroupView.this) && ((paramView2 instanceof MMRadioImageButton))) {
        ((MMRadioImageButton)paramView2).setOnOtherMMRadioButtonCheckedChangeListener(null);
      }
      if (this.nC != null) {
        this.nC.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(142105);
    }
  }
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView
 * JD-Core Version:    0.7.0.1
 */