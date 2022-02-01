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
  private boolean Jnc;
  private boolean Jnd = true;
  private boolean Jne;
  private a Jnf;
  private a Jng;
  
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
    return this.Jne;
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
    this.Jnd = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(142118);
    if (this.Jne != paramBoolean)
    {
      this.Jne = paramBoolean;
      setSelected(this.Jne);
      refreshDrawableState();
      if (this.Jnc)
      {
        AppMethodBeat.o(142118);
        return;
      }
      this.Jnc = true;
      if (this.Jnf != null) {
        this.Jnf.a(this);
      }
      if (this.Jng != null) {
        this.Jng.a(this);
      }
      this.Jnc = false;
    }
    AppMethodBeat.o(142118);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(a parama)
  {
    this.Jnf = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(a parama)
  {
    this.Jng = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(142116);
    if (this.Jnd)
    {
      if (!isChecked())
      {
        if (!this.Jne) {}
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
      if (this.Jnf != null) {
        this.Jnf.b(this);
      }
      if (this.Jng != null) {
        this.Jng.b(this);
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