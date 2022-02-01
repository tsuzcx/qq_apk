package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import java.util.ArrayList;
import java.util.List;

public class TextViewMultilineEllipse
  extends View
{
  private a REX;
  private a REY;
  private int Riu;
  private String Riv;
  private String Riw;
  private boolean Rix;
  private int Riy;
  private boolean Riz;
  private Context context;
  private String mText;
  private int textSize;
  private boolean vYR;
  private int vYT;
  private TextPaint xe;
  
  public TextViewMultilineEllipse(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99707);
    this.textSize = -1;
    this.context = paramContext;
    this.vYR = false;
    this.Rix = true;
    this.Riz = false;
    this.vYT = -1;
    this.Riv = "...";
    this.Riw = "";
    this.Riy = -16776961;
    this.REX = new a();
    this.REY = new a();
    this.xe = new TextPaint();
    this.xe.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0F);
      this.xe.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.xe.setColor(-16777216);
      this.xe.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(99707);
      return;
      this.xe.setTextSize(13.0F);
    }
  }
  
  private int alQ(int paramInt)
  {
    AppMethodBeat.i(99713);
    if (this.vYR) {}
    for (paramInt = this.REX.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.xe);; paramInt = this.REY.a(this.mText, this.Riv, this.Riw, this.vYT, paramInt - getPaddingLeft() - getPaddingRight(), this.xe))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(99713);
      return paramInt + i + j;
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.vYR;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99712);
    super.onDraw(paramCanvas);
    a locala;
    ArrayList localArrayList;
    float f2;
    float f1;
    int i;
    label53:
    int j;
    if (this.vYR)
    {
      locala = this.REX;
      localArrayList = this.REX.RiF;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.Riu;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.xe);
      if ((i == localArrayList.size() - 1) && (locala.RiE))
      {
        paramCanvas.drawText(this.Riv, locala.RiG + f2, f1, this.xe);
        if (this.Rix)
        {
          j = this.xe.getColor();
          this.xe.setColor(this.Riy);
          if (!this.Riz) {
            break label278;
          }
          paramCanvas.drawText(this.Riw, paramCanvas.getWidth() - (locala.RiI + getPaddingRight() + getPaddingLeft()), f1, this.xe);
        }
      }
    }
    for (;;)
    {
      this.xe.setColor(j);
      f1 += -this.Riu + this.xe.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.REY;
      localArrayList = this.REY.RiF;
      break;
      label278:
      paramCanvas.drawText(this.Riw, locala.RiG + locala.RiH + f2, f1, this.xe);
    }
    label307:
    AppMethodBeat.o(99712);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99711);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      alQ(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.Riu = ((int)this.xe.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(99711);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(alQ(paramInt1), paramInt1);
      }
      else
      {
        alQ(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.vYR) {}
    for (paramInt2 = this.REX.RiF.size();; paramInt2 = this.REY.RiF.size())
    {
      int j = paramInt2 * (int)(-this.Riu + this.xe.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.Riy = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.Rix = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.Riv = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.Riw = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.vYT = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.Riz = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(99708);
    this.mText = paramString;
    requestLayout();
    invalidate();
    AppMethodBeat.o(99708);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(99710);
    this.xe.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(99710);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(99709);
    this.xe.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(99709);
  }
  
  static final class a
  {
    boolean RiE;
    ArrayList<int[]> RiF;
    float RiG;
    float RiH;
    float RiI;
    
    public a()
    {
      AppMethodBeat.i(99704);
      this.RiE = false;
      this.RiF = new ArrayList();
      AppMethodBeat.o(99704);
    }
    
    public final int a(String paramString, int paramInt, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(99705);
      paramInt = a(paramString, null, null, -1, paramInt, paramTextPaint);
      AppMethodBeat.o(99705);
      return paramInt;
    }
    
    public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(99706);
      this.RiF.clear();
      this.RiE = false;
      this.RiG = 0.0F;
      this.RiH = 0.0F;
      this.RiI = 0.0F;
      if (paramInt2 == -1)
      {
        this.RiF.add(new int[] { 0, paramString1.length() });
        paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
        AppMethodBeat.o(99706);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.RiH = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.RiI = paramTextPaint.measureText(paramString3);
      }
      int k = -1;
      float f1 = 0.0F;
      int n = 1;
      int i = 0;
      int m = paramInt2;
      paramInt2 = i;
      if (paramInt2 < paramString1.length())
      {
        i = k;
        if (k == -1) {
          i = paramInt2;
        }
        if (this.RiF.size() == paramInt1) {
          this.RiE = true;
        }
      }
      else
      {
        if (this.RiE)
        {
          paramString2 = (int[])this.RiF.get(this.RiF.size() - 1);
          this.RiG = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.RiF.size() != 0) {
          break label575;
        }
        AppMethodBeat.o(99706);
        return 0;
      }
      float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
      k = 0;
      int j;
      label303:
      int i2;
      int i1;
      if (paramString1.charAt(paramInt2) == '\n')
      {
        k = 1;
        this.RiF.add(new int[] { i, paramInt2 - 1 });
        j = paramInt2;
        if (k == 0) {
          break label501;
        }
        paramInt2 = -1;
        f2 = 0.0F;
        i2 = n;
        f1 = f2;
        k = paramInt2;
        i1 = m;
        if (this.RiF.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.RiH + this.RiI));
          i2 = 0;
          k = paramInt2;
          f1 = f2;
        }
      }
      for (;;)
      {
        paramInt2 = j + 1;
        n = i2;
        m = i1;
        break;
        j = paramInt2;
        if (f1 + f2 < m) {
          break label303;
        }
        k = 1;
        if (paramString1.charAt(paramInt2) != ' ')
        {
          j = paramInt2;
          if (n != 0) {}
        }
        else
        {
          j = paramInt2 - 1;
          this.RiF.add(new int[] { i, j });
          break label303;
        }
        while (paramString1.charAt(j) != ' ') {
          j -= 1;
        }
        this.RiF.add(new int[] { i, j });
        break label303;
        label501:
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
        if (j == paramString1.length() - 1)
        {
          this.RiF.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label575:
      if (this.RiF.size() == 1)
      {
        paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
        AppMethodBeat.o(99706);
        return paramInt1;
      }
      AppMethodBeat.o(99706);
      return m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse
 * JD-Core Version:    0.7.0.1
 */