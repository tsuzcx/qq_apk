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
  private a FZA;
  private a FZB;
  private boolean FZx;
  private boolean FZy = true;
  private boolean FZz;
  
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
    return this.FZz;
  }
  
  public boolean performClick()
  {
    AppMethodBeat.i(142117);
    toggle();
    AppMethodBeat.o(142117);
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.FZy = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(142118);
    if (this.FZz != paramBoolean)
    {
      this.FZz = paramBoolean;
      setSelected(this.FZz);
      refreshDrawableState();
      if (this.FZx)
      {
        AppMethodBeat.o(142118);
        return;
      }
      this.FZx = true;
      if (this.FZA != null) {
        this.FZA.a(this);
      }
      if (this.FZB != null) {
        this.FZB.a(this);
      }
      this.FZx = false;
    }
    AppMethodBeat.o(142118);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(a parama)
  {
    this.FZA = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(a parama)
  {
    this.FZB = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(142116);
    if (this.FZy)
    {
      if (!isChecked())
      {
        if (!this.FZz) {}
        for (boolean bool = true;; bool = false)
        {
          setChecked(bool);
          AppMethodBeat.o(142116);
          return;
        }
      }
    }
    else
    {
      if (this.FZA != null) {
        this.FZA.b(this);
      }
      if (this.FZB != null) {
        this.FZB.b(this);
      }
    }
    AppMethodBeat.o(142116);
  }
  
  public static abstract interface a
  {
    public abstract void a(MMRadioImageButton paramMMRadioImageButton);
    
    public abstract void b(MMRadioImageButton paramMMRadioImageButton);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioImageButton
 * JD-Core Version:    0.7.0.1
 */