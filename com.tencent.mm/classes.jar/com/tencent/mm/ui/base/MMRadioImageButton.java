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
  private boolean JHR;
  private boolean JHS = true;
  private boolean JHT;
  private a JHU;
  private a JHV;
  
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
    return this.JHT;
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
    this.JHS = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(142118);
    if (this.JHT != paramBoolean)
    {
      this.JHT = paramBoolean;
      setSelected(this.JHT);
      refreshDrawableState();
      if (this.JHR)
      {
        AppMethodBeat.o(142118);
        return;
      }
      this.JHR = true;
      if (this.JHU != null) {
        this.JHU.a(this);
      }
      if (this.JHV != null) {
        this.JHV.a(this);
      }
      this.JHR = false;
    }
    AppMethodBeat.o(142118);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(a parama)
  {
    this.JHU = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(a parama)
  {
    this.JHV = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(142116);
    if (this.JHS)
    {
      if (!isChecked())
      {
        if (!this.JHT) {}
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
      if (this.JHU != null) {
        this.JHU.b(this);
      }
      if (this.JHV != null) {
        this.JHV.b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMRadioImageButton
 * JD-Core Version:    0.7.0.1
 */