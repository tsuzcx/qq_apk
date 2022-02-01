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
  private a ApK;
  private a ApL;
  private TextPaint ayp;
  private Context context;
  private String mText;
  private boolean oss;
  private int osu;
  private int textSize;
  private int zVi;
  private String zVj;
  private String zVk;
  private boolean zVl;
  private int zVm;
  private boolean zVn;
  
  public TextViewMultilineEllipse(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99707);
    this.textSize = -1;
    this.context = paramContext;
    this.oss = false;
    this.zVl = true;
    this.zVn = false;
    this.osu = -1;
    this.zVj = "...";
    this.zVk = "";
    this.zVm = -16776961;
    this.ApK = new a();
    this.ApL = new a();
    this.ayp = new TextPaint();
    this.ayp.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.g(this.context, 12.0F);
      this.ayp.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.ayp.setColor(-16777216);
      this.ayp.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(99707);
      return;
      this.ayp.setTextSize(13.0F);
    }
  }
  
  private int Rb(int paramInt)
  {
    AppMethodBeat.i(99713);
    if (this.oss) {}
    for (paramInt = this.ApK.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.ayp);; paramInt = this.ApL.a(this.mText, this.zVj, this.zVk, this.osu, paramInt - getPaddingLeft() - getPaddingRight(), this.ayp))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(99713);
      return paramInt + i + j;
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.oss;
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
    if (this.oss)
    {
      locala = this.ApK;
      localArrayList = this.ApK.zVt;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.zVi;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.ayp);
      if ((i == localArrayList.size() - 1) && (locala.zVs))
      {
        paramCanvas.drawText(this.zVj, locala.zVu + f2, f1, this.ayp);
        if (this.zVl)
        {
          j = this.ayp.getColor();
          this.ayp.setColor(this.zVm);
          if (!this.zVn) {
            break label278;
          }
          paramCanvas.drawText(this.zVk, paramCanvas.getWidth() - (locala.zVw + getPaddingRight() + getPaddingLeft()), f1, this.ayp);
        }
      }
    }
    for (;;)
    {
      this.ayp.setColor(j);
      f1 += -this.zVi + this.ayp.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.ApL;
      localArrayList = this.ApL.zVt;
      break;
      label278:
      paramCanvas.drawText(this.zVk, locala.zVu + locala.zVv + f2, f1, this.ayp);
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
      Rb(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.zVi = ((int)this.ayp.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(99711);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(Rb(paramInt1), paramInt1);
      }
      else
      {
        Rb(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.oss) {}
    for (paramInt2 = this.ApK.zVt.size();; paramInt2 = this.ApL.zVt.size())
    {
      int j = paramInt2 * (int)(-this.zVi + this.ayp.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.zVm = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.zVl = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.zVj = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.zVk = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.osu = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.zVn = paramBoolean;
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
    this.ayp.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(99710);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(99709);
    this.ayp.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(99709);
  }
  
  static final class a
  {
    boolean zVs;
    ArrayList<int[]> zVt;
    float zVu;
    float zVv;
    float zVw;
    
    public a()
    {
      AppMethodBeat.i(99704);
      this.zVs = false;
      this.zVt = new ArrayList();
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
      this.zVt.clear();
      this.zVs = false;
      this.zVu = 0.0F;
      this.zVv = 0.0F;
      this.zVw = 0.0F;
      if (paramInt2 == -1)
      {
        this.zVt.add(new int[] { 0, paramString1.length() });
        paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
        AppMethodBeat.o(99706);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.zVv = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.zVw = paramTextPaint.measureText(paramString3);
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
        if (this.zVt.size() == paramInt1) {
          this.zVs = true;
        }
      }
      else
      {
        if (this.zVs)
        {
          paramString2 = (int[])this.zVt.get(this.zVt.size() - 1);
          this.zVu = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.zVt.size() != 0) {
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
        this.zVt.add(new int[] { i, paramInt2 - 1 });
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
        if (this.zVt.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.zVv + this.zVw));
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
          this.zVt.add(new int[] { i, j });
          break label303;
        }
        while (paramString1.charAt(j) != ' ') {
          j -= 1;
        }
        this.zVt.add(new int[] { i, j });
        break label303;
        label501:
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
        if (j == paramString1.length() - 1)
        {
          this.zVt.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label575:
      if (this.zVt.size() == 1)
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