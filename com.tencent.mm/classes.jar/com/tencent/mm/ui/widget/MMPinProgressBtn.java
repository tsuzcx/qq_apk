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
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMPinProgressBtn
  extends CompoundButton
{
  private int ADd;
  private Paint ADe;
  private int ADf;
  private final float ADg;
  private Runnable ADh;
  private Paint IW;
  private RectF ahV;
  private int style;
  private int ym;
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107903);
    this.ahV = new RectF();
    this.ADg = 4.0F;
    this.ADh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107898);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ab.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(107898);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ab.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(107898);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(107898);
      }
    };
    a(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(107903);
  }
  
  public MMPinProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107904);
    this.ahV = new RectF();
    this.ADg = 4.0F;
    this.ADh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107898);
        if (MMPinProgressBtn.this.getVisibility() != 0)
        {
          ab.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
          AppMethodBeat.o(107898);
          return;
        }
        MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) + 1);
        if (MMPinProgressBtn.a(MMPinProgressBtn.this) >= MMPinProgressBtn.b(MMPinProgressBtn.this))
        {
          MMPinProgressBtn.a(MMPinProgressBtn.this, MMPinProgressBtn.a(MMPinProgressBtn.this) - 1);
          ab.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
          AppMethodBeat.o(107898);
          return;
        }
        MMPinProgressBtn.this.invalidate();
        MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.c(MMPinProgressBtn.this), 200L);
        AppMethodBeat.o(107898);
      }
    };
    a(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(107904);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(107905);
    this.ADd = 100;
    this.ym = 0;
    Resources localResources = getResources();
    int m = localResources.getColor(2131690342);
    int k = localResources.getColor(2131690343);
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
        this.ADd = paramAttributeSet.getInteger(2, this.ADd);
        this.ym = paramAttributeSet.getInteger(1, this.ym);
        paramInt = paramAttributeSet.getColor(3, m);
        k = paramAttributeSet.getColor(4, k);
        this.style = paramAttributeSet.getInteger(6, 0);
        this.ADf = paramAttributeSet.getDimensionPixelSize(5, localResources.getDimensionPixelSize(2131428622));
        i = k;
        j = paramInt;
        if (paramAttributeSet != null)
        {
          paramAttributeSet.recycle();
          j = paramInt;
          i = k;
        }
        this.IW = new Paint();
        this.IW.setColor(j);
        this.IW.setStyle(Paint.Style.STROKE);
        this.IW.setStrokeWidth(4.0F);
        this.IW.setAntiAlias(true);
        this.ADe = new Paint();
        this.ADe.setColor(i);
        this.ADe.setAntiAlias(true);
        setClickable(false);
        AppMethodBeat.o(107905);
        return;
      }
      finally {}
      paramContext = finally;
      paramAttributeSet = null;
    }
    paramAttributeSet.recycle();
    label252:
    AppMethodBeat.o(107905);
    throw paramContext;
  }
  
  public final void dOF()
  {
    AppMethodBeat.i(107908);
    removeCallbacks(this.ADh);
    post(this.ADh);
    AppMethodBeat.o(107908);
  }
  
  public int getMax()
  {
    return this.ADd;
  }
  
  public int getProgress()
  {
    return this.ym;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107910);
    super.onDraw(paramCanvas);
    this.ahV.set(2.0F, 2.0F, this.ADf - 2.0F, this.ADf - 2.0F);
    this.ahV.offset((getWidth() - this.ADf) / 2, (getHeight() - this.ADf) / 2);
    paramCanvas.drawArc(this.ahV, 0.0F, 360.0F, true, this.IW);
    switch (this.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107910);
      return;
      this.ahV.set(8.0F, 8.0F, this.ADf - 8.0F, this.ADf - 8.0F);
      this.ahV.offset((getWidth() - this.ADf) / 2, (getHeight() - this.ADf) / 2);
      paramCanvas.drawArc(this.ahV, -90.0F, 360.0F * (this.ym * 1.0F / this.ADd), true, this.ADe);
      AppMethodBeat.o(107910);
      return;
      this.ahV.set(2.0F, 2.0F, this.ADf - 2.0F, this.ADf - 2.0F);
      this.ahV.offset((getWidth() - this.ADf) / 2, (getHeight() - this.ADf) / 2);
      paramCanvas.drawArc(this.ahV, 270.0F, this.ym * 1.0F / this.ADd * 360.0F - 360.0F, true, this.ADe);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107909);
    setMeasuredDimension(resolveSize(this.ADf, paramInt1), resolveSize(this.ADf, paramInt2));
    AppMethodBeat.o(107909);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(107912);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(107912);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.ADd = SavedState.a(paramParcelable);
    this.ym = SavedState.b(paramParcelable);
    AppMethodBeat.o(107912);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(107911);
    Object localObject = super.onSaveInstanceState();
    if (isSaveEnabled())
    {
      localObject = new SavedState((Parcelable)localObject);
      SavedState.a((SavedState)localObject, this.ADd);
      SavedState.b((SavedState)localObject, this.ym);
      AppMethodBeat.o(107911);
      return localObject;
    }
    AppMethodBeat.o(107911);
    return localObject;
  }
  
  public void setMax(int paramInt)
  {
    AppMethodBeat.i(107906);
    this.ADd = Math.max(0, paramInt);
    invalidate();
    AppMethodBeat.o(107906);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(107907);
    this.ym = Math.max(0, paramInt);
    this.ym = Math.min(paramInt, this.ADd);
    invalidate();
    AppMethodBeat.o(107907);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private int ADd;
    private int ym;
    
    static
    {
      AppMethodBeat.i(107902);
      CREATOR = new MMPinProgressBtn.SavedState.1();
      AppMethodBeat.o(107902);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(107900);
      this.ym = paramParcel.readInt();
      this.ADd = paramParcel.readInt();
      AppMethodBeat.o(107900);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(107901);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.ym);
      paramParcel.writeInt(this.ADd);
      AppMethodBeat.o(107901);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn
 * JD-Core Version:    0.7.0.1
 */