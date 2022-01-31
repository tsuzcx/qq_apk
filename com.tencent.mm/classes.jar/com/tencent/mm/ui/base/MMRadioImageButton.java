package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;

public class MMRadioImageButton
  extends ImageButton
  implements Checkable
{
  private boolean dB = true;
  private boolean fQ;
  private boolean uXF;
  private MMRadioImageButton.a uXG;
  private MMRadioImageButton.a uXH;
  
  public MMRadioImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMRadioImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isChecked()
  {
    return this.fQ;
  }
  
  public boolean performClick()
  {
    toggle();
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.dB = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.fQ != paramBoolean)
    {
      this.fQ = paramBoolean;
      setSelected(this.fQ);
      refreshDrawableState();
      if (!this.uXF) {}
    }
    else
    {
      return;
    }
    this.uXF = true;
    if (this.uXG != null) {
      this.uXG.a(this);
    }
    if (this.uXH != null) {
      this.uXH.a(this);
    }
    this.uXF = false;
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(MMRadioImageButton.a parama)
  {
    this.uXG = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(MMRadioImageButton.a parama)
  {
    this.uXH = parama;
  }
  
  public void toggle()
  {
    boolean bool;
    if (this.dB) {
      if (!isChecked())
      {
        if (this.fQ) {
          break label29;
        }
        bool = true;
        setChecked(bool);
      }
    }
    label29:
    do
    {
      return;
      bool = false;
      break;
      if (this.uXG != null) {
        this.uXG.b(this);
      }
    } while (this.uXH == null);
    this.uXH.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioImageButton
 * JD-Core Version:    0.7.0.1
 */