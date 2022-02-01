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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPinProgressBtn
  extends CompoundButton
{
  private int IB;
  private Paint JMJ;
  private int YbC;
  private int YbD;
  private final float YbE;
  private Runnable YbF;
  private RectF ajW;
  private Paint aoq;
  private int style;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143384);
    this.ajW = new RectF();
    this.YbE = 4.0F;
    this.YbF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          Log.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          Log.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(143379);
      }
    };
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(143384);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143385);
    this.ajW = new RectF();
    this.YbE = 4.0F;
    this.YbF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          Log.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          Log.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(143379);
      }
    };
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(143385);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(143386);
    this.YbC = 100;
    this.IB = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(a.d.pin_progress_default_circle_color);
    int k = localResources.getColor(a.d.pin_progress_default_progress_color);
    int i = k;
    int j = m;
    if (paramAttributeSet != null) {}
    try
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMPinProgressBtn, paramInt, 0);
      if (paramAttributeSet == null) {
        break label266;
      }
    }
    finally
    {
      try
      {
        this.YbC = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_max, this.YbC);
        this.IB = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_progress, this.IB);
        paramInt = paramAttributeSet.getColor(a.m.MMPinProgressBtn_circleColor, m);
        k = paramAttributeSet.getColor(a.m.MMPinProgressBtn_progressColor, k);
        this.style = paramAttributeSet.getInteger(a.m.MMPinProgressBtn_style, 0);
        this.YbD = paramAttributeSet.getDimensionPixelSize(a.m.MMPinProgressBtn_innerSize, localResources.getDimensionPixelSize(a.e.pin_progress_inner_size));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.aoq = new Paint();
        this.aoq.setColor(j);
        this.aoq.setStyle(Paint.Style.STROKE);
        this.aoq.setStrokeWidth(4.0F);
        this.aoq.setAntiAlias(true);
        this.JMJ = new Paint();
        this.JMJ.setColor(i);
        this.JMJ.setAntiAlias(true);
        setClickable(false);
        AppMethodBeat.o(143386);
        return;
      }
      finally {}
      paramContext = finally;
      paramAttributeSet = null;
    }
    paramAttributeSet.recycle();
    label266:
    AppMethodBeat.o(143386);
    throw paramContext;
  }
  
  public int getMax()
  {
    return this.YbC;
  }
  
  public int getProgress()
  {
    return this.IB;
  }
  
  public final void hZF()
  {
    AppMethodBeat.i(143389);
    removeCallbacks(this.YbF);
    post(this.YbF);
    AppMethodBeat.o(143389);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143391);
    super.onDraw(paramCanvas);
    this.ajW.set(2.0F, 2.0F, this.YbD - 2.0F, this.YbD - 2.0F);
    this.ajW.offset((getWidth() - this.YbD) / 2, (getHeight() - this.YbD) / 2);
    paramCanvas.drawArc(this.ajW, 0.0F, 360.0F, true, this.aoq);
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143391);
      return;
      this.ajW.set(8.0F, 8.0F, this.YbD - 8.0F, this.YbD - 8.0F);
      this.ajW.offset((getWidth() - this.YbD) / 2, (getHeight() - this.YbD) / 2);
      paramCanvas.drawArc(this.ajW, -90.0F, 360.0F * (this.IB * 1.0F / this.YbC), true, this.JMJ);
      AppMethodBeat.o(143391);
      return;
      this.ajW.set(2.0F, 2.0F, this.YbD - 2.0F, this.YbD - 2.0F);
      this.ajW.offset((getWidth() - this.YbD) / 2, (getHeight() - this.YbD) / 2);
      paramCanvas.drawArc(this.ajW, 270.0F, this.IB * 1.0F / this.YbC * 360.0F - 360.0F, true, this.JMJ);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143390);
    setMeasuredDimension(resolveSize(this.YbD, paramInt1), resolveSize(this.YbD, paramInt2));
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
    this.YbC = SavedState.a(paramParcelable);
    this.IB = SavedState.b(paramParcelable);
    AppMethodBeat.o(143393);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143392);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.YbC);
      SavedState.b((SavedState)localObject, this.IB);
      AppMethodBeat.o(143392);
      return localObject;
    }
    AppMethodBeat.o(143392);
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    AppMethodBeat.i(143387);
    this.YbC = Math.max(0, paramInt);
    invalidate();
    AppMethodBeat.o(143387);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(143388);
    this.IB = Math.max(0, paramInt);
    this.IB = Math.min(paramInt, this.YbC);
    invalidate();
    AppMethodBeat.o(143388);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int IB;
    private int YbC;
    
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
      this.IB = paramParcel.readInt();
      this.YbC = paramParcel.readInt();
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
      paramParcel.writeInt(this.IB);
      paramParcel.writeInt(this.YbC);
      AppMethodBeat.o(143382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */