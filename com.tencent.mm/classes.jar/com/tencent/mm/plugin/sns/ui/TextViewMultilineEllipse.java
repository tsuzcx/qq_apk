package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import java.util.ArrayList;
import java.util.List;

public class TextViewMultilineEllipse
  extends View
{
  private Context context;
  private TextPaint hB;
  private boolean kiY;
  private int kja;
  private String mText;
  private int rKt;
  private String rKu;
  private String rKv;
  private boolean rKw;
  private int rKx;
  private boolean rKy;
  private TextViewMultilineEllipse.a scj;
  private TextViewMultilineEllipse.a sck;
  private int textSize;
  
  public TextViewMultilineEllipse(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39846);
    this.textSize = -1;
    this.context = paramContext;
    this.kiY = false;
    this.rKw = true;
    this.rKy = false;
    this.kja = -1;
    this.rKu = "...";
    this.rKv = "";
    this.rKx = -16776961;
    this.scj = new TextViewMultilineEllipse.a();
    this.sck = new TextViewMultilineEllipse.a();
    this.hB = new TextPaint();
    this.hB.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.b(this.context, 12.0F);
      this.hB.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.hB.setColor(-16777216);
      this.hB.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(39846);
      return;
      this.hB.setTextSize(13.0F);
    }
  }
  
  private int EK(int paramInt)
  {
    AppMethodBeat.i(39852);
    if (this.kiY) {}
    for (paramInt = this.scj.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.hB);; paramInt = this.sck.a(this.mText, this.rKu, this.rKv, this.kja, paramInt - getPaddingLeft() - getPaddingRight(), this.hB))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(39852);
      return paramInt + i + j;
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.kiY;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39851);
    super.onDraw(paramCanvas);
    TextViewMultilineEllipse.a locala;
    ArrayList localArrayList;
    float f2;
    float f1;
    int i;
    label53:
    int j;
    if (this.kiY)
    {
      locala = this.scj;
      localArrayList = this.scj.rKE;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.rKt;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.hB);
      if ((i == localArrayList.size() - 1) && (locala.rKD))
      {
        paramCanvas.drawText(this.rKu, locala.rKF + f2, f1, this.hB);
        if (this.rKw)
        {
          j = this.hB.getColor();
          this.hB.setColor(this.rKx);
          if (!this.rKy) {
            break label278;
          }
          paramCanvas.drawText(this.rKv, paramCanvas.getWidth() - (locala.rKH + getPaddingRight() + getPaddingLeft()), f1, this.hB);
        }
      }
    }
    for (;;)
    {
      this.hB.setColor(j);
      f1 += -this.rKt + this.hB.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.sck;
      localArrayList = this.sck.rKE;
      break;
      label278:
      paramCanvas.drawText(this.rKv, locala.rKF + locala.rKG + f2, f1, this.hB);
    }
    label307:
    AppMethodBeat.o(39851);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39850);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      EK(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.rKt = ((int)this.hB.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(39850);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(EK(paramInt1), paramInt1);
      }
      else
      {
        EK(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.kiY) {}
    for (paramInt2 = this.scj.rKE.size();; paramInt2 = this.sck.rKE.size())
    {
      int j = paramInt2 * (int)(-this.rKt + this.hB.descent()) + getPaddingTop() + getPaddingBottom();
      paramInt2 = j;
      if (k != -2147483648) {
        break;
      }
      paramInt2 = Math.min(j, i);
      break;
    }
  }
  
  public void setColorEllpsizeMore(int paramInt)
  {
    this.rKx = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.rKw = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.rKu = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.rKv = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.kja = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.rKy = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(39847);
    this.mText = paramString;
    requestLayout();
    invalidate();
    AppMethodBeat.o(39847);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39849);
    this.hB.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(39849);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(39848);
    this.hB.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse
 * JD-Core Version:    0.7.0.1
 */