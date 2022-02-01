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
  private boolean Hzl;
  private boolean Hzm = true;
  private boolean Hzn;
  private a Hzo;
  private a Hzp;
  
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
    return this.Hzn;
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
    this.Hzm = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(142118);
    if (this.Hzn != paramBoolean)
    {
      this.Hzn = paramBoolean;
      setSelected(this.Hzn);
      refreshDrawableState();
      if (this.Hzl)
      {
        AppMethodBeat.o(142118);
        return;
      }
      this.Hzl = true;
      if (this.Hzo != null) {
        this.Hzo.a(this);
      }
      if (this.Hzp != null) {
        this.Hzp.a(this);
      }
      this.Hzl = false;
    }
    AppMethodBeat.o(142118);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(a parama)
  {
    this.Hzo = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(a parama)
  {
    this.Hzp = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(142116);
    if (this.Hzm)
    {
      if (!isChecked())
      {
        if (!this.Hzn) {}
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
      if (this.Hzo != null) {
        this.Hzo.b(this);
      }
      if (this.Hzp != null) {
        this.Hzp.b(this);
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