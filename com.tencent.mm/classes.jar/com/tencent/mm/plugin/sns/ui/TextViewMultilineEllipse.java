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
  private a EQO;
  private a EQP;
  private int Evc;
  private String Evd;
  private String Eve;
  private boolean Evf;
  private int Evg;
  private boolean Evh;
  private TextPaint ayn;
  private Context context;
  private String mText;
  private boolean pMC;
  private int pME;
  private int textSize;
  
  public TextViewMultilineEllipse(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99707);
    this.textSize = -1;
    this.context = paramContext;
    this.pMC = false;
    this.Evf = true;
    this.Evh = false;
    this.pME = -1;
    this.Evd = "...";
    this.Eve = "";
    this.Evg = -16776961;
    this.EQO = new a();
    this.EQP = new a();
    this.ayn = new TextPaint();
    this.ayn.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0F);
      this.ayn.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.ayn.setColor(-16777216);
      this.ayn.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(99707);
      return;
      this.ayn.setTextSize(13.0F);
    }
  }
  
  private int ZE(int paramInt)
  {
    AppMethodBeat.i(99713);
    if (this.pMC) {}
    for (paramInt = this.EQO.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.ayn);; paramInt = this.EQP.a(this.mText, this.Evd, this.Eve, this.pME, paramInt - getPaddingLeft() - getPaddingRight(), this.ayn))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(99713);
      return paramInt + i + j;
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.pMC;
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
    if (this.pMC)
    {
      locala = this.EQO;
      localArrayList = this.EQO.Evn;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.Evc;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.ayn);
      if ((i == localArrayList.size() - 1) && (locala.Evm))
      {
        paramCanvas.drawText(this.Evd, locala.Evo + f2, f1, this.ayn);
        if (this.Evf)
        {
          j = this.ayn.getColor();
          this.ayn.setColor(this.Evg);
          if (!this.Evh) {
            break label278;
          }
          paramCanvas.drawText(this.Eve, paramCanvas.getWidth() - (locala.Evq + getPaddingRight() + getPaddingLeft()), f1, this.ayn);
        }
      }
    }
    for (;;)
    {
      this.ayn.setColor(j);
      f1 += -this.Evc + this.ayn.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.EQP;
      localArrayList = this.EQP.Evn;
      break;
      label278:
      paramCanvas.drawText(this.Eve, locala.Evo + locala.Evp + f2, f1, this.ayn);
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
      ZE(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.Evc = ((int)this.ayn.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(99711);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(ZE(paramInt1), paramInt1);
      }
      else
      {
        ZE(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.pMC) {}
    for (paramInt2 = this.EQO.Evn.size();; paramInt2 = this.EQP.Evn.size())
    {
      int j = paramInt2 * (int)(-this.Evc + this.ayn.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.Evg = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.Evf = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.Evd = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.Eve = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.pME = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.Evh = paramBoolean;
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
    this.ayn.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(99710);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(99709);
    this.ayn.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(99709);
  }
  
  static final class a
  {
    boolean Evm;
    ArrayList<int[]> Evn;
    float Evo;
    float Evp;
    float Evq;
    
    public a()
    {
      AppMethodBeat.i(99704);
      this.Evm = false;
      this.Evn = new ArrayList();
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
      this.Evn.clear();
      this.Evm = false;
      this.Evo = 0.0F;
      this.Evp = 0.0F;
      this.Evq = 0.0F;
      if (paramInt2 == -1)
      {
        this.Evn.add(new int[] { 0, paramString1.length() });
        paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
        AppMethodBeat.o(99706);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.Evp = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.Evq = paramTextPaint.measureText(paramString3);
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
        if (this.Evn.size() == paramInt1) {
          this.Evm = true;
        }
      }
      else
      {
        if (this.Evm)
        {
          paramString2 = (int[])this.Evn.get(this.Evn.size() - 1);
          this.Evo = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.Evn.size() != 0) {
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
        this.Evn.add(new int[] { i, paramInt2 - 1 });
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
        if (this.Evn.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.Evp + this.Evq));
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
          this.Evn.add(new int[] { i, j });
          break label303;
        }
        while (paramString1.charAt(j) != ' ') {
          j -= 1;
        }
        this.Evn.add(new int[] { i, j });
        break label303;
        label501:
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
        if (j == paramString1.length() - 1)
        {
          this.Evn.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label575:
      if (this.Evn.size() == 1)
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