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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView
  extends View
{
  private static HashMap<String, a> xrd;
  private TextPaint avD;
  private Context context;
  private String mText;
  boolean nmL;
  private int nmN;
  private int textSize;
  private int xqX;
  private String xqY;
  private String xqZ;
  private boolean xra;
  private int xrb;
  private boolean xrc;
  private a xre;
  private a xrf;
  int xrg;
  
  static
  {
    AppMethodBeat.i(98222);
    xrd = new HashMap();
    AppMethodBeat.o(98222);
  }
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98214);
    this.mText = "";
    this.textSize = -1;
    this.xrg = 0;
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
    this.xrg = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98213);
  }
  
  private int Np(int paramInt)
  {
    AppMethodBeat.i(98221);
    if (this.nmL) {
      if (bt.isNullOrNil(a.a(this.xre))) {
        this.xrg = this.xre.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.avD);
      }
    }
    for (;;)
    {
      paramInt = this.xrg;
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(98221);
      return paramInt + i + j;
      if (bt.isNullOrNil(a.a(this.xrf))) {
        this.xrg = this.xrf.a(this.mText, this.xqY, this.xqZ, this.nmN, paramInt - getPaddingLeft() - getPaddingRight(), this.avD);
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(98215);
    this.nmL = false;
    this.xra = true;
    this.xrc = false;
    this.nmN = -1;
    this.xqY = "...";
    this.xqZ = "";
    this.xrb = -16776961;
    this.xre = new a();
    this.xrf = new a();
    this.avD = new TextPaint();
    this.avD.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.b.g(this.context, 12.0F);
      this.avD.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.avD.setColor(-16777216);
      this.avD.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(98215);
      return;
      this.avD.setTextSize(13.0F);
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.nmL;
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
    if (this.nmL)
    {
      locala = this.xre;
      localArrayList = this.xre.xri;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.xqX;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.avD);
      if ((i == localArrayList.size() - 1) && (locala.xrh))
      {
        paramCanvas.drawText(this.xqY, locala.xrj + f2, f1, this.avD);
        if (this.xra)
        {
          j = this.avD.getColor();
          this.avD.setColor(this.xrb);
          if (!this.xrc) {
            break label278;
          }
          paramCanvas.drawText(this.xqZ, paramCanvas.getWidth() - (locala.xrl + getPaddingRight() + getPaddingLeft()), f1, this.avD);
        }
      }
    }
    for (;;)
    {
      this.avD.setColor(j);
      f1 += -this.xqX + this.avD.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.xrf;
      localArrayList = this.xrf.xri;
      break;
      label278:
      paramCanvas.drawText(this.xqZ, locala.xrj + locala.xrk + f2, f1, this.avD);
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
      Np(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.xqX = ((int)this.avD.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(98219);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(Np(paramInt1), paramInt1);
      }
      else
      {
        Np(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.nmL) {}
    for (paramInt2 = this.xre.xri.size();; paramInt2 = this.xrf.xri.size())
    {
      int j = paramInt2 * (int)(-this.xqX + this.avD.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.xrb = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.xra = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.xqY = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.xqZ = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.nmN = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.xrc = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98216);
    if (bt.isNullOrNil(this.mText)) {
      this.mText = "";
    }
    this.mText = paramString;
    a.a(this.xre, "");
    a.a(this.xrf, "");
    requestLayout();
    invalidate();
    AppMethodBeat.o(98216);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(98218);
    this.avD.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(98218);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(98217);
    this.avD.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(98217);
  }
  
  static final class a
  {
    private static HashMap<String, Integer> xrm;
    private String key;
    private int xrg;
    boolean xrh;
    ArrayList<int[]> xri;
    float xrj;
    float xrk;
    float xrl;
    
    static
    {
      AppMethodBeat.i(98212);
      xrm = new HashMap();
      AppMethodBeat.o(98212);
    }
    
    public a()
    {
      AppMethodBeat.i(98209);
      this.xrg = 0;
      this.key = "";
      this.xrh = false;
      this.xri = new ArrayList();
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
        paramInt1 = this.xrg;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.key = str;
      this.xri.clear();
      this.xrh = false;
      this.xrj = 0.0F;
      this.xrk = 0.0F;
      this.xrl = 0.0F;
      if (paramInt2 == -1)
      {
        this.xri.add(new int[] { 0, paramString1.length() });
        this.xrg = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.xrg;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.xrk = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.xrl = paramTextPaint.measureText(paramString3);
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
        if (this.xri.size() == paramInt1) {
          this.xrh = true;
        }
      }
      else
      {
        if (this.xrh)
        {
          paramString2 = (int[])this.xri.get(this.xri.size() - 1);
          this.xrj = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.xri.size() != 0) {
          break label675;
        }
        this.xrg = 0;
        paramInt1 = this.xrg;
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
        this.xri.add(new int[] { i, paramInt2 - 1 });
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
        if (this.xri.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.xrk + this.xrl));
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
          this.xri.add(new int[] { i, j });
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
        this.xri.add(new int[] { i, paramInt2 });
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
          this.xri.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label675:
      if (this.xri.size() == 1)
      {
        this.xrg = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.xrg;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.xrg = m;
      paramInt1 = this.xrg;
      AppMethodBeat.o(98211);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */