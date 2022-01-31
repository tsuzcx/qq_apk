package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MMRadioGroupView
  extends LinearLayout
{
  private MMRadioGroupView.b uXA;
  private MMRadioGroupView.c uXB = new MMRadioGroupView.c(this, (byte)0);
  private MMRadioImageButton uXC;
  private MMRadioGroupView.d uXD;
  private int uXx = -1;
  private int uXy = -1;
  private MMRadioImageButton.a uXz = new MMRadioGroupView.a(this);
  
  public MMRadioGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnHierarchyChangeListener(this.uXB);
  }
  
  private void aq(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof MMRadioImageButton))) {
      ((MMRadioImageButton)localView).setChecked(paramBoolean);
    }
  }
  
  private void setCheckedButton(MMRadioImageButton paramMMRadioImageButton)
  {
    this.uXC = paramMMRadioImageButton;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.uXx = paramInt;
  }
  
  private void setClickedId(int paramInt)
  {
    this.uXy = paramInt;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof MMRadioImageButton))
    {
      MMRadioImageButton localMMRadioImageButton = (MMRadioImageButton)paramView;
      if (localMMRadioImageButton.isChecked())
      {
        if (this.uXx != -1) {
          aq(this.uXx, false);
        }
        setCheckedId(localMMRadioImageButton.getId());
        setCheckedButton(localMMRadioImageButton);
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public MMRadioImageButton getCheckedRadioButton()
  {
    return this.uXC;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.uXx;
  }
  
  public int getClickedRadioButtonId()
  {
    return this.uXy;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.uXx != -1)
    {
      aq(this.uXx, true);
      setCheckedId(this.uXx);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (((paramInt1 > 0) || (paramInt2 > 0)) && (this.uXD != null)) {
      this.uXD.Gr(paramInt1);
    }
  }
  
  public void setOnMMRadioGroupCheckedChangeListener(MMRadioGroupView.b paramb)
  {
    this.uXA = paramb;
  }
  
  public void setOnSizeChangeObserver(MMRadioGroupView.d paramd)
  {
    this.uXD = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioGroupView
 * JD-Core Version:    0.7.0.1
 */