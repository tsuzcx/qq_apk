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
  private boolean OSK;
  private boolean OSL = true;
  private boolean OSM;
  private a OSN;
  private a OSO;
  
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
    return this.OSM;
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
    this.OSL = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(142118);
    if (this.OSM != paramBoolean)
    {
      this.OSM = paramBoolean;
      setSelected(this.OSM);
      refreshDrawableState();
      if (this.OSK)
      {
        AppMethodBeat.o(142118);
        return;
      }
      this.OSK = true;
      if (this.OSN != null) {
        this.OSN.a(this);
      }
      if (this.OSO != null) {
        this.OSO.a(this);
      }
      this.OSK = false;
    }
    AppMethodBeat.o(142118);
  }
  
  public void setOnMMRadioButtonCheckedChangeListener(a parama)
  {
    this.OSN = parama;
  }
  
  public void setOnOtherMMRadioButtonCheckedChangeListener(a parama)
  {
    this.OSO = parama;
  }
  
  public void toggle()
  {
    AppMethodBeat.i(142116);
    if (this.OSL)
    {
      if (!isChecked())
      {
        if (!this.OSM) {}
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
      if (this.OSN != null) {
        this.OSN.b(this);
      }
      if (this.OSO != null) {
        this.OSO.b(this);
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