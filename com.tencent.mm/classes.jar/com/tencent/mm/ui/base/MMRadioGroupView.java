package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioGroupView
  extends LinearLayout
{
  private int zlP;
  private int zlQ;
  private MMRadioImageButton.a zlR;
  private MMRadioGroupView.b zlS;
  private MMRadioGroupView.c zlT;
  private MMRadioImageButton zlU;
  private MMRadioGroupView.d zlV;
  
  public MMRadioGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106751);
    this.zlP = -1;
    this.zlQ = -1;
    this.zlR = new MMRadioGroupView.a(this);
    this.zlT = new MMRadioGroupView.c(this, (byte)0);
    super.setOnHierarchyChangeListener(this.zlT);
    AppMethodBeat.o(106751);
  }
  
  private void aG(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(106754);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof MMRadioImageButton))) {
      ((MMRadioImageButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(106754);
  }
  
  private void setCheckedButton(MMRadioImageButton paramMMRadioImageButton)
  {
    this.zlU = paramMMRadioImageButton;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.zlP = paramInt;
  }
  
  private void setClickedId(int paramInt)
  {
    this.zlQ = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(106753);
    if ((paramView instanceof MMRadioImageButton))
    {
      MMRadioImageButton localMMRadioImageButton = (MMRadioImageButton)paramView;
      if (localMMRadioImageButton.isChecked())
      {
        if (this.zlP != -1) {
          aG(this.zlP, false);
        }
        setCheckedId(localMMRadioImageButton.getId());
        setCheckedButton(localMMRadioImageButton);
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(106753);
  }
  
  public MMRadioImageButton getCheckedRadioButton()
  {
    return this.zlU;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.zlP;
  }
  
  public int getClickedRadioButtonId()
  {
    return this.zlQ;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106752);
    super.onFinishInflate();
    if (this.zlP != -1)
    {
      aG(this.zlP, true);
      setCheckedId(this.zlP);
    }
    AppMethodBeat.o(106752);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106755);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (((paramInt1 > 0) || (paramInt2 > 0)) && (this.zlV != null)) {
      this.zlV.OJ(paramInt1);
    }
    AppMethodBeat.o(106755);
  }
  
  public void setOnMMRadioGroupCheckedChangeListener(MMRadioGroupView.b paramb)
  {
    this.zlS = paramb;
  }
  
  public void setOnSizeChangeObserver(MMRadioGroupView.d paramd)
  {
    this.zlV = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView
 * JD-Core Version:    0.7.0.1
 */