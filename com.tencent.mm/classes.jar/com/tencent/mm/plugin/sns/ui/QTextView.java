package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView
  extends View
{
  private static HashMap<String, QTextView.a> oSH = new HashMap();
  private Context context;
  private TextPaint gI;
  private String hnV = "";
  private int lgJ;
  private int oSA;
  private String oSB;
  private String oSC;
  private boolean oSD;
  private int oSE;
  private boolean oSF;
  boolean oSG;
  private QTextView.a oSI;
  private QTextView.a oSJ;
  int oSK = 0;
  private int textSize = -1;
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public QTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    this.oSG = false;
    this.oSD = true;
    this.oSF = false;
    this.lgJ = -1;
    this.oSB = "...";
    this.oSC = "";
    this.oSE = -16776961;
    this.oSI = new QTextView.a();
    this.oSJ = new QTextView.a();
    this.gI = new TextPaint();
    this.gI.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.b(this.context, 12.0F);
      this.gI.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.gI.setColor(-16777216);
      this.gI.setTextAlign(Paint.Align.LEFT);
      return;
      this.gI.setTextSize(13.0F);
    }
  }
  
  private int yE(int paramInt)
  {
    if (this.oSG) {
      if (bk.bl(QTextView.a.a(this.oSI))) {
        this.oSK = this.oSI.a(this.hnV, null, null, -1, paramInt - getPaddingLeft() - getPaddingRight(), this.gI);
      }
    }
    for (;;)
    {
      return this.oSK + getPaddingLeft() + getPaddingRight();
      if (bk.bl(QTextView.a.a(this.oSJ))) {
        this.oSK = this.oSJ.a(this.hnV, this.oSB, this.oSC, this.lgJ, paramInt - getPaddingLeft() - getPaddingRight(), this.gI);
      }
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.oSG;
  }
  
  public String getText()
  {
    return this.hnV;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    QTextView.a locala;
    ArrayList localArrayList;
    float f2;
    float f1;
    int i;
    label48:
    int j;
    if (this.oSG)
    {
      locala = this.oSI;
      localArrayList = this.oSI.oSM;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.oSA;
      i = 0;
      if (i >= localArrayList.size()) {
        return;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.hnV, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.gI);
      if ((i == localArrayList.size() - 1) && (locala.oSL))
      {
        paramCanvas.drawText(this.oSB, locala.oSN + f2, f1, this.gI);
        if (this.oSD)
        {
          j = this.gI.getColor();
          this.gI.setColor(this.oSE);
          if (!this.oSF) {
            break label273;
          }
          paramCanvas.drawText(this.oSC, paramCanvas.getWidth() - (locala.oSP + getPaddingRight() + getPaddingLeft()), f1, this.gI);
        }
      }
    }
    for (;;)
    {
      this.gI.setColor(j);
      f1 += -this.oSA + this.gI.descent();
      if (f1 > paramCanvas.getHeight()) {
        return;
      }
      i += 1;
      break label48;
      locala = this.oSJ;
      localArrayList = this.oSJ.oSM;
      break;
      label273:
      paramCanvas.drawText(this.oSC, locala.oSN + locala.oSO + f2, f1, this.gI);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      yE(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.oSA = ((int)this.gI.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(yE(paramInt1), paramInt1);
      }
      else
      {
        yE(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.oSG) {}
    for (paramInt2 = this.oSI.oSM.size();; paramInt2 = this.oSJ.oSM.size())
    {
      int j = paramInt2 * (int)(-this.oSA + this.gI.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.oSE = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.oSD = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.oSB = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.oSC = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.lgJ = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.oSF = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    if (bk.bl(this.hnV)) {
      this.hnV = "";
    }
    this.hnV = paramString;
    QTextView.a.a(this.oSI, "");
    QTextView.a.a(this.oSJ, "");
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.gI.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.gI.setTextSize(paramInt);
    requestLayout();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */