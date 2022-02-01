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
  private TextPaint awy;
  private Context context;
  private String mText;
  private boolean nPL;
  private int nPN;
  private int textSize;
  private int yDN;
  private String yDO;
  private String yDP;
  private boolean yDQ;
  private int yDR;
  private boolean yDS;
  private a yXZ;
  private a yYa;
  
  public TextViewMultilineEllipse(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99707);
    this.textSize = -1;
    this.context = paramContext;
    this.nPL = false;
    this.yDQ = true;
    this.yDS = false;
    this.nPN = -1;
    this.yDO = "...";
    this.yDP = "";
    this.yDR = -16776961;
    this.yXZ = new a();
    this.yYa = new a();
    this.awy = new TextPaint();
    this.awy.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.g(this.context, 12.0F);
      this.awy.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.awy.setColor(-16777216);
      this.awy.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(99707);
      return;
      this.awy.setTextSize(13.0F);
    }
  }
  
  private int Ps(int paramInt)
  {
    AppMethodBeat.i(99713);
    if (this.nPL) {}
    for (paramInt = this.yXZ.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.awy);; paramInt = this.yYa.a(this.mText, this.yDO, this.yDP, this.nPN, paramInt - getPaddingLeft() - getPaddingRight(), this.awy))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(99713);
      return paramInt + i + j;
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.nPL;
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
    if (this.nPL)
    {
      locala = this.yXZ;
      localArrayList = this.yXZ.yDY;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.yDN;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.awy);
      if ((i == localArrayList.size() - 1) && (locala.yDX))
      {
        paramCanvas.drawText(this.yDO, locala.yDZ + f2, f1, this.awy);
        if (this.yDQ)
        {
          j = this.awy.getColor();
          this.awy.setColor(this.yDR);
          if (!this.yDS) {
            break label278;
          }
          paramCanvas.drawText(this.yDP, paramCanvas.getWidth() - (locala.yEb + getPaddingRight() + getPaddingLeft()), f1, this.awy);
        }
      }
    }
    for (;;)
    {
      this.awy.setColor(j);
      f1 += -this.yDN + this.awy.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.yYa;
      localArrayList = this.yYa.yDY;
      break;
      label278:
      paramCanvas.drawText(this.yDP, locala.yDZ + locala.yEa + f2, f1, this.awy);
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
      Ps(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.yDN = ((int)this.awy.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(99711);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(Ps(paramInt1), paramInt1);
      }
      else
      {
        Ps(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.nPL) {}
    for (paramInt2 = this.yXZ.yDY.size();; paramInt2 = this.yYa.yDY.size())
    {
      int j = paramInt2 * (int)(-this.yDN + this.awy.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.yDR = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.yDQ = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.yDO = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.yDP = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.nPN = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.yDS = paramBoolean;
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
    this.awy.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(99710);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(99709);
    this.awy.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(99709);
  }
  
  static final class a
  {
    boolean yDX;
    ArrayList<int[]> yDY;
    float yDZ;
    float yEa;
    float yEb;
    
    public a()
    {
      AppMethodBeat.i(99704);
      this.yDX = false;
      this.yDY = new ArrayList();
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
      this.yDY.clear();
      this.yDX = false;
      this.yDZ = 0.0F;
      this.yEa = 0.0F;
      this.yEb = 0.0F;
      if (paramInt2 == -1)
      {
        this.yDY.add(new int[] { 0, paramString1.length() });
        paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
        AppMethodBeat.o(99706);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.yEa = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.yEb = paramTextPaint.measureText(paramString3);
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
        if (this.yDY.size() == paramInt1) {
          this.yDX = true;
        }
      }
      else
      {
        if (this.yDX)
        {
          paramString2 = (int[])this.yDY.get(this.yDY.size() - 1);
          this.yDZ = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.yDY.size() != 0) {
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
        this.yDY.add(new int[] { i, paramInt2 - 1 });
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
        if (this.yDY.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.yEa + this.yEb));
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
          this.yDY.add(new int[] { i, j });
          break label303;
        }
        while (paramString1.charAt(j) != ' ') {
          j -= 1;
        }
        this.yDY.add(new int[] { i, j });
        break label303;
        label501:
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
        if (j == paramString1.length() - 1)
        {
          this.yDY.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label575:
      if (this.yDY.size() == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse
 * JD-Core Version:    0.7.0.1
 */