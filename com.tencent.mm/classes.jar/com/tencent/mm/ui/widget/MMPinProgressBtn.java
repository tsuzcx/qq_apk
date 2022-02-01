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
import com.tencent.mm.sdk.platformtools.ae;

public class MMPinProgressBtn
  extends CompoundButton
{
  private int Hx;
  private int LnP;
  private int LnQ;
  private final float LnR;
  private Runnable LnS;
  private Paint SG;
  private RectF arQ;
  private int style;
  private Paint zsn;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143384);
    this.arQ = new RectF();
    this.LnR = 4.0F;
    this.LnS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ae.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ae.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
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
    this.arQ = new RectF();
    this.LnR = 4.0F;
    this.LnS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143379);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ae.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(143379);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ae.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
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
    this.LnP = 100;
    this.Hx = 0;
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
        this.LnP = paramAttributeSet.getInteger(2, this.LnP);
        this.Hx = paramAttributeSet.getInteger(4, this.Hx);
        paramInt = paramAttributeSet.getColor(0, m);
        k = paramAttributeSet.getColor(5, k);
        this.style = paramAttributeSet.getInteger(6, 0);
        this.LnQ = paramAttributeSet.getDimensionPixelSize(1, localResources.getDimensionPixelSize(2131166691));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.SG = new Paint();
        this.SG.setColor(j);
        this.SG.setStyle(Paint.Style.STROKE);
        this.SG.setStrokeWidth(4.0F);
        this.SG.setAntiAlias(true);
        this.zsn = new Paint();
        this.zsn.setColor(i);
        this.zsn.setAntiAlias(true);
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
  
  public final void fPL()
  {
    AppMethodBeat.i(143389);
    removeCallbacks(this.LnS);
    post(this.LnS);
    AppMethodBeat.o(143389);
  }
  
  public int getMax()
  {
    return this.LnP;
  }
  
  public int getProgress()
  {
    return this.Hx;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143391);
    super.onDraw(paramCanvas);
    this.arQ.set(2.0F, 2.0F, this.LnQ - 2.0F, this.LnQ - 2.0F);
    this.arQ.offset((getWidth() - this.LnQ) / 2, (getHeight() - this.LnQ) / 2);
    paramCanvas.drawArc(this.arQ, 0.0F, 360.0F, true, this.SG);
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143391);
      return;
      this.arQ.set(8.0F, 8.0F, this.LnQ - 8.0F, this.LnQ - 8.0F);
      this.arQ.offset((getWidth() - this.LnQ) / 2, (getHeight() - this.LnQ) / 2);
      paramCanvas.drawArc(this.arQ, -90.0F, 360.0F * (this.Hx * 1.0F / this.LnP), true, this.zsn);
      AppMethodBeat.o(143391);
      return;
      this.arQ.set(2.0F, 2.0F, this.LnQ - 2.0F, this.LnQ - 2.0F);
      this.arQ.offset((getWidth() - this.LnQ) / 2, (getHeight() - this.LnQ) / 2);
      paramCanvas.drawArc(this.arQ, 270.0F, this.Hx * 1.0F / this.LnP * 360.0F - 360.0F, true, this.zsn);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143390);
    setMeasuredDimension(resolveSize(this.LnQ, paramInt1), resolveSize(this.LnQ, paramInt2));
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
    this.LnP = SavedState.a(paramParcelable);
    this.Hx = SavedState.b(paramParcelable);
    AppMethodBeat.o(143393);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143392);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.LnP);
      SavedState.b((SavedState)localObject, this.Hx);
      AppMethodBeat.o(143392);
      return localObject;
    }
    AppMethodBeat.o(143392);
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    AppMethodBeat.i(143387);
    this.LnP = Math.max(0, paramInt);
    invalidate();
    AppMethodBeat.o(143387);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(143388);
    this.Hx = Math.max(0, paramInt);
    this.Hx = Math.min(paramInt, this.LnP);
    invalidate();
    AppMethodBeat.o(143388);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int Hx;
    private int LnP;
    
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
      this.Hx = paramParcel.readInt();
      this.LnP = paramParcel.readInt();
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
      paramParcel.writeInt(this.Hx);
      paramParcel.writeInt(this.LnP);
      AppMethodBeat.o(143382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */