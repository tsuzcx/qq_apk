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
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView
  extends View
{
  private static HashMap<String, a> Amw;
  private int Amq;
  private String Amr;
  private String Ams;
  private boolean Amt;
  private int Amu;
  private boolean Amv;
  private a Amx;
  private a Amy;
  int Amz;
  private TextPaint ayp;
  private Context context;
  private String mText;
  boolean oyT;
  private int oyV;
  private int textSize;
  
  static
  {
    AppMethodBeat.i(98222);
    Amw = new HashMap();
    AppMethodBeat.o(98222);
  }
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98214);
    this.mText = "";
    this.textSize = -1;
    this.Amz = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98214);
  }
  
  public QTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98213);
    this.mText = "";
    this.textSize = -1;
    this.Amz = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98213);
  }
  
  private int RI(int paramInt)
  {
    AppMethodBeat.i(98221);
    if (this.oyT) {
      if (bu.isNullOrNil(a.a(this.Amx))) {
        this.Amz = this.Amx.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.ayp);
      }
    }
    for (;;)
    {
      paramInt = this.Amz;
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(98221);
      return paramInt + i + j;
      if (bu.isNullOrNil(a.a(this.Amy))) {
        this.Amz = this.Amy.a(this.mText, this.Amr, this.Ams, this.oyV, paramInt - getPaddingLeft() - getPaddingRight(), this.ayp);
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(98215);
    this.oyT = false;
    this.Amt = true;
    this.Amv = false;
    this.oyV = -1;
    this.Amr = "...";
    this.Ams = "";
    this.Amu = -16776961;
    this.Amx = new a();
    this.Amy = new a();
    this.ayp = new TextPaint();
    this.ayp.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.h(this.context, 12.0F);
      this.ayp.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.ayp.setColor(-16777216);
      this.ayp.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(98215);
      return;
      this.ayp.setTextSize(13.0F);
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.oyT;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(98220);
    super.onDraw(paramCanvas);
    a locala;
    ArrayList localArrayList;
    float f2;
    float f1;
    int i;
    label53:
    int j;
    if (this.oyT)
    {
      locala = this.Amx;
      localArrayList = this.Amx.AmB;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.Amq;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.ayp);
      if ((i == localArrayList.size() - 1) && (locala.AmA))
      {
        paramCanvas.drawText(this.Amr, locala.AmC + f2, f1, this.ayp);
        if (this.Amt)
        {
          j = this.ayp.getColor();
          this.ayp.setColor(this.Amu);
          if (!this.Amv) {
            break label278;
          }
          paramCanvas.drawText(this.Ams, paramCanvas.getWidth() - (locala.AmE + getPaddingRight() + getPaddingLeft()), f1, this.ayp);
        }
      }
    }
    for (;;)
    {
      this.ayp.setColor(j);
      f1 += -this.Amq + this.ayp.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.Amy;
      localArrayList = this.Amy.AmB;
      break;
      label278:
      paramCanvas.drawText(this.Ams, locala.AmC + locala.AmD + f2, f1, this.ayp);
    }
    label307:
    AppMethodBeat.o(98220);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98219);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      RI(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.Amq = ((int)this.ayp.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(98219);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(RI(paramInt1), paramInt1);
      }
      else
      {
        RI(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.oyT) {}
    for (paramInt2 = this.Amx.AmB.size();; paramInt2 = this.Amy.AmB.size())
    {
      int j = paramInt2 * (int)(-this.Amq + this.ayp.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.Amu = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.Amt = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.Amr = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.Ams = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.oyV = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.Amv = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98216);
    if (bu.isNullOrNil(this.mText)) {
      this.mText = "";
    }
    this.mText = paramString;
    a.a(this.Amx, "");
    a.a(this.Amy, "");
    requestLayout();
    invalidate();
    AppMethodBeat.o(98216);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(98218);
    this.ayp.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(98218);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(98217);
    this.ayp.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(98217);
  }
  
  static final class a
  {
    private static HashMap<String, Integer> AmF;
    boolean AmA;
    ArrayList<int[]> AmB;
    float AmC;
    float AmD;
    float AmE;
    private int Amz;
    private String key;
    
    static
    {
      AppMethodBeat.i(98212);
      AmF = new HashMap();
      AppMethodBeat.o(98212);
    }
    
    public a()
    {
      AppMethodBeat.i(98209);
      this.Amz = 0;
      this.key = "";
      this.AmA = false;
      this.AmB = new ArrayList();
      AppMethodBeat.o(98209);
    }
    
    public final int a(String paramString, int paramInt, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98210);
      paramInt = a(paramString, null, null, -1, paramInt, paramTextPaint);
      AppMethodBeat.o(98210);
      return paramInt;
    }
    
    public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98211);
      String str = paramString1 + paramString2 + paramString3 + paramInt1 + paramInt2;
      if (str.equals(this.key))
      {
        paramInt1 = this.Amz;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.key = str;
      this.AmB.clear();
      this.AmA = false;
      this.AmC = 0.0F;
      this.AmD = 0.0F;
      this.AmE = 0.0F;
      if (paramInt2 == -1)
      {
        this.AmB.add(new int[] { 0, paramString1.length() });
        this.Amz = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.Amz;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.AmD = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.AmE = paramTextPaint.measureText(paramString3);
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
        if (this.AmB.size() == paramInt1) {
          this.AmA = true;
        }
      }
      else
      {
        if (this.AmA)
        {
          paramString2 = (int[])this.AmB.get(this.AmB.size() - 1);
          this.AmC = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.AmB.size() != 0) {
          break label675;
        }
        this.Amz = 0;
        paramInt1 = this.Amz;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
      k = 0;
      int j;
      label389:
      int i2;
      int i1;
      if (paramString1.charAt(paramInt2) == '\n')
      {
        k = 1;
        this.AmB.add(new int[] { i, paramInt2 - 1 });
        j = paramInt2;
        if (k == 0) {
          break label601;
        }
        paramInt2 = -1;
        f2 = 0.0F;
        i2 = n;
        f1 = f2;
        k = paramInt2;
        i1 = m;
        if (this.AmB.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.AmD + this.AmE));
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
          break label389;
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
          this.AmB.add(new int[] { i, j });
          break label389;
        }
        do
        {
          paramInt2 = j;
          if (paramString1.charAt(j) == ' ') {
            break;
          }
          paramInt2 = j - 1;
          j = paramInt2;
        } while (paramInt2 != 0);
        this.AmB.add(new int[] { i, paramInt2 });
        j = paramInt2;
        break label389;
        label601:
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
        if (j == paramString1.length() - 1)
        {
          this.AmB.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label675:
      if (this.AmB.size() == 1)
      {
        this.Amz = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.Amz;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.Amz = m;
      paramInt1 = this.Amz;
      AppMethodBeat.o(98211);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */