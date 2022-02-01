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
import com.tencent.mm.sdk.platformtools.Log;

public class MMPinProgressBtn
  extends CompoundButton
{
  private Paint DAX;
  private int HH;
  private int QCZ;
  private int QDa;
  private final float QDb;
  private Runnable QDc;
  private Paint ST;
  private RectF asb;
  private int style;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143384);
    this.asb = new RectF();
    this.QDb = 4.0F;
    this.QDc = new Runnable()
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
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(143384);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143385);
    this.asb = new RectF();
    this.QDb = 4.0F;
    this.QDc = new Runnable()
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
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(143385);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(143386);
    this.QCZ = 100;
    this.HH = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(2131100942);
    int k = localResources.getColor(2131100943);
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
        this.QCZ = paramAttributeSet.getInteger(2, this.QCZ);
        this.HH = paramAttributeSet.getInteger(4, this.HH);
        paramInt = paramAttributeSet.getColor(0, m);
        k = paramAttributeSet.getColor(5, k);
        this.style = paramAttributeSet.getInteger(6, 0);
        this.QDa = paramAttributeSet.getDimensionPixelSize(1, localResources.getDimensionPixelSize(2131166811));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.ST = new Paint();
        this.ST.setColor(j);
        this.ST.setStyle(Paint.Style.STROKE);
        this.ST.setStrokeWidth(4.0F);
        this.ST.setAntiAlias(true);
        this.DAX = new Paint();
        this.DAX.setColor(i);
        this.DAX.setAntiAlias(true);
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
  
  public final void gYN()
  {
    AppMethodBeat.i(143389);
    removeCallbacks(this.QDc);
    post(this.QDc);
    AppMethodBeat.o(143389);
  }
  
  public int getMax()
  {
    return this.QCZ;
  }
  
  public int getProgress()
  {
    return this.HH;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143391);
    super.onDraw(paramCanvas);
    this.asb.set(2.0F, 2.0F, this.QDa - 2.0F, this.QDa - 2.0F);
    this.asb.offset((getWidth() - this.QDa) / 2, (getHeight() - this.QDa) / 2);
    paramCanvas.drawArc(this.asb, 0.0F, 360.0F, true, this.ST);
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143391);
      return;
      this.asb.set(8.0F, 8.0F, this.QDa - 8.0F, this.QDa - 8.0F);
      this.asb.offset((getWidth() - this.QDa) / 2, (getHeight() - this.QDa) / 2);
      paramCanvas.drawArc(this.asb, -90.0F, 360.0F * (this.HH * 1.0F / this.QCZ), true, this.DAX);
      AppMethodBeat.o(143391);
      return;
      this.asb.set(2.0F, 2.0F, this.QDa - 2.0F, this.QDa - 2.0F);
      this.asb.offset((getWidth() - this.QDa) / 2, (getHeight() - this.QDa) / 2);
      paramCanvas.drawArc(this.asb, 270.0F, this.HH * 1.0F / this.QCZ * 360.0F - 360.0F, true, this.DAX);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143390);
    setMeasuredDimension(resolveSize(this.QDa, paramInt1), resolveSize(this.QDa, paramInt2));
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
    this.QCZ = SavedState.a(paramParcelable);
    this.HH = SavedState.b(paramParcelable);
    AppMethodBeat.o(143393);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143392);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.QCZ);
      SavedState.b((SavedState)localObject, this.HH);
      AppMethodBeat.o(143392);
      return localObject;
    }
    AppMethodBeat.o(143392);
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    AppMethodBeat.i(143387);
    this.QCZ = Math.max(0, paramInt);
    invalidate();
    AppMethodBeat.o(143387);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(143388);
    this.HH = Math.max(0, paramInt);
    this.HH = Math.min(paramInt, this.QCZ);
    invalidate();
    AppMethodBeat.o(143388);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int HH;
    private int QCZ;
    
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
      this.HH = paramParcel.readInt();
      this.QCZ = paramParcel.readInt();
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
      paramParcel.writeInt(this.HH);
      paramParcel.writeInt(this.QCZ);
      AppMethodBeat.o(143382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */