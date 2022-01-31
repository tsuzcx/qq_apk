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
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView
  extends View
{
  private static HashMap<String, QTextView.a> rKz;
  private Context context;
  private TextPaint hB;
  boolean kiY;
  private int kja;
  private String mText;
  private QTextView.a rKA;
  private QTextView.a rKB;
  int rKC;
  private int rKt;
  private String rKu;
  private String rKv;
  private boolean rKw;
  private int rKx;
  private boolean rKy;
  private int textSize;
  
  static
  {
    AppMethodBeat.i(38538);
    rKz = new HashMap();
    AppMethodBeat.o(38538);
  }
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38530);
    this.mText = "";
    this.textSize = -1;
    this.rKC = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(38530);
  }
  
  public QTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38529);
    this.mText = "";
    this.textSize = -1;
    this.rKC = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(38529);
  }
  
  private int EK(int paramInt)
  {
    AppMethodBeat.i(38537);
    if (this.kiY) {
      if (bo.isNullOrNil(QTextView.a.a(this.rKA))) {
        this.rKC = this.rKA.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.hB);
      }
    }
    for (;;)
    {
      paramInt = this.rKC;
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(38537);
      return paramInt + i + j;
      if (bo.isNullOrNil(QTextView.a.a(this.rKB))) {
        this.rKC = this.rKB.a(this.mText, this.rKu, this.rKv, this.kja, paramInt - getPaddingLeft() - getPaddingRight(), this.hB);
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(38531);
    this.kiY = false;
    this.rKw = true;
    this.rKy = false;
    this.kja = -1;
    this.rKu = "...";
    this.rKv = "";
    this.rKx = -16776961;
    this.rKA = new QTextView.a();
    this.rKB = new QTextView.a();
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
      AppMethodBeat.o(38531);
      return;
      this.hB.setTextSize(13.0F);
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.kiY;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38536);
    super.onDraw(paramCanvas);
    QTextView.a locala;
    ArrayList localArrayList;
    float f2;
    float f1;
    int i;
    label53:
    int j;
    if (this.kiY)
    {
      locala = this.rKA;
      localArrayList = this.rKA.rKE;
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
      locala = this.rKB;
      localArrayList = this.rKB.rKE;
      break;
      label278:
      paramCanvas.drawText(this.rKv, locala.rKF + locala.rKG + f2, f1, this.hB);
    }
    label307:
    AppMethodBeat.o(38536);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38535);
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
      AppMethodBeat.o(38535);
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
    for (paramInt2 = this.rKA.rKE.size();; paramInt2 = this.rKB.rKE.size())
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
    AppMethodBeat.i(38532);
    if (bo.isNullOrNil(this.mText)) {
      this.mText = "";
    }
    this.mText = paramString;
    QTextView.a.a(this.rKA, "");
    QTextView.a.a(this.rKB, "");
    requestLayout();
    invalidate();
    AppMethodBeat.o(38532);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(38534);
    this.hB.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(38534);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(38533);
    this.hB.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(38533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */