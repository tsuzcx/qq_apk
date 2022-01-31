package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioImageButton
  extends ImageButton
  implements Checkable
{
  private boolean eD = true;
  private boolean gK;
  private boolean zlX;
  private MMRadioImageButton.a zlY;
  private MMRadioImageButton.a zlZ;
  
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
    return this.gK;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(106761);
    toggle();
    AppMethodBeat.o(106761);
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.eD = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(106762);
    if (this.gK != paramBoolean)
    {
      this.gK = paramBoolean;
      setSelected(this.gK);
      refreshDrawableState();
      if (this.zlX)
      {
        AppMethodBeat.o(106762);
        return;
      }
      this.zlX = true;
      if (this.zlY != null) {
        this.zlY.a(this);
      }
      if (this.zlZ != null) {
        this.zlZ.a(this);
      }
      this.zlX = false;
    }
    AppMethodBeat.o(106762);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(MMRadioImageButton.a parama)
  {
    this.zlY = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(MMRadioImageButton.a parama)
  {
    this.zlZ = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(106760);
    if (this.eD)
    {
      if (!isChecked())
      {
        if (!this.gK) {}
        for (boolean bool = true;; bool = false)
        {
          setChecked(bool);
          AppMethodBeat.o(106760);
          return;
        }
      }
    }
    else
    {
      if (this.zlY != null) {
        this.zlY.b(this);
      }
      if (this.zlZ != null) {
        this.zlZ.b(this);
      }
    }
    AppMethodBeat.o(106760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioImageButton
 * JD-Core Version:    0.7.0.1
 */