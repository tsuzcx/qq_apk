package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.ac;

public class MMPinProgressBtn
  extends CompoundButton
{
  private int FG;
  private int Jaf;
  private Paint Jag;
  private int Jah;
  private final float Jai;
  private Runnable Jaj;
  private Paint QR;
  private RectF apY;
  private int style;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143384);
    this.apY = new RectF();
    this.Jai = 4.0F;
    this.Jaj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ac.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ac.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(143379);
      }
    };
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(143384);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143385);
    this.apY = new RectF();
    this.Jai = 4.0F;
    this.Jaj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ac.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ac.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(143379);
      }
    };
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(143385);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(143386);
    this.Jaf = 100;
    this.FG = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(2131100748);
    int k = localResources.getColor(2131100749);
    int i = k;
    int j = m;
    if (paramAttributeSet != null) {}
    try
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMPinProgressBtn, paramInt, 0);
      if (paramAttributeSet == null) {
        break label252;
      }
    }
    finally
    {
      try
      {
        this.Jaf = paramAttributeSet.getInteger(2, this.Jaf);
        this.FG = paramAttributeSet.getInteger(4, this.FG);
        paramInt = paramAttributeSet.getColor(0, m);
        k = paramAttributeSet.getColor(5, k);
        this.style = paramAttributeSet.getInteger(6, 0);
        this.Jah = paramAttributeSet.getDimensionPixelSize(1, localResources.getDimensionPixelSize(2131166691));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.QR = new Paint();
        this.QR.setColor(j);
        this.QR.setStyle(Paint.Style.STROKE);
        this.QR.setStrokeWidth(4.0F);
        this.QR.setAntiAlias(true);
        this.Jag = new Paint();
        this.Jag.setColor(i);
        this.Jag.setAntiAlias(true);
        setClickable(false);
        AppMethodBeat.o(143386);
        return;
      }
      finally {}
      paramContext = finally;
      paramAttributeSet = null;
    }
    paramAttributeSet.recycle();
    label252:
    AppMethodBeat.o(143386);
    throw paramContext;
  }
  
  public final void fuE()
  {
    AppMethodBeat.i(143389);
    removeCallbacks(this.Jaj);
    post(this.Jaj);
    AppMethodBeat.o(143389);
  }
  
  public int getMax()
  {
    return this.Jaf;
  }
  
  public int getProgress()
  {
    return this.FG;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143391);
    super.onDraw(paramCanvas);
    this.apY.set(2.0F, 2.0F, this.Jah - 2.0F, this.Jah - 2.0F);
    this.apY.offset((getWidth() - this.Jah) / 2, (getHeight() - this.Jah) / 2);
    paramCanvas.drawArc(this.apY, 0.0F, 360.0F, true, this.QR);
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143391);
      return;
      this.apY.set(8.0F, 8.0F, this.Jah - 8.0F, this.Jah - 8.0F);
      this.apY.offset((getWidth() - this.Jah) / 2, (getHeight() - this.Jah) / 2);
      paramCanvas.drawArc(this.apY, -90.0F, 360.0F * (this.FG * 1.0F / this.Jaf), true, this.Jag);
      AppMethodBeat.o(143391);
      return;
      this.apY.set(2.0F, 2.0F, this.Jah - 2.0F, this.Jah - 2.0F);
      this.apY.offset((getWidth() - this.Jah) / 2, (getHeight() - this.Jah) / 2);
      paramCanvas.drawArc(this.apY, 270.0F, this.FG * 1.0F / this.Jaf * 360.0F - 360.0F, true, this.Jag);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143390);
    setMeasuredDimension(resolveSize(this.Jah, paramInt1), resolveSize(this.Jah, paramInt2));
    AppMethodBeat.o(143390);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(143393);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(143393);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Jaf = SavedState.a(paramParcelable);
    this.FG = SavedState.b(paramParcelable);
    AppMethodBeat.o(143393);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143392);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.Jaf);
      SavedState.b((SavedState)localObject, this.FG);
      AppMethodBeat.o(143392);
      return localObject;
    }
    AppMethodBeat.o(143392);
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    AppMethodBeat.i(143387);
    this.Jaf = Math.max(0, paramInt);
    invalidate();
    AppMethodBeat.o(143387);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(143388);
    this.FG = Math.max(0, paramInt);
    this.FG = Math.min(paramInt, this.Jaf);
    invalidate();
    AppMethodBeat.o(143388);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int FG;
    private int Jaf;
    
    static
    {
      AppMethodBeat.i(143383);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(143383);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(143381);
      this.FG = paramParcel.readInt();
      this.Jaf = paramParcel.readInt();
      AppMethodBeat.o(143381);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(143382);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.FG);
      paramParcel.writeInt(this.Jaf);
      AppMethodBeat.o(143382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */