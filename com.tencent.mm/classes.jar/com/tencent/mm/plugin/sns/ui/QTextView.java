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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView
  extends View
{
  private static HashMap<String, a> Evi;
  private int Evc;
  private String Evd;
  private String Eve;
  private boolean Evf;
  private int Evg;
  private boolean Evh;
  private a Evj;
  private a Evk;
  int Evl;
  private TextPaint ayn;
  private Context context;
  private String mText;
  boolean pMC;
  private int pME;
  private int textSize;
  
  static
  {
    AppMethodBeat.i(98222);
    Evi = new HashMap();
    AppMethodBeat.o(98222);
  }
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98214);
    this.mText = "";
    this.textSize = -1;
    this.Evl = 0;
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
    this.Evl = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98213);
  }
  
  private int ZE(int paramInt)
  {
    AppMethodBeat.i(98221);
    if (this.pMC) {
      if (Util.isNullOrNil(a.a(this.Evj))) {
        this.Evl = this.Evj.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.ayn);
      }
    }
    for (;;)
    {
      paramInt = this.Evl;
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(98221);
      return paramInt + i + j;
      if (Util.isNullOrNil(a.a(this.Evk))) {
        this.Evl = this.Evk.a(this.mText, this.Evd, this.Eve, this.pME, paramInt - getPaddingLeft() - getPaddingRight(), this.ayn);
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(98215);
    this.pMC = false;
    this.Evf = true;
    this.Evh = false;
    this.pME = -1;
    this.Evd = "...";
    this.Eve = "";
    this.Evg = -16776961;
    this.Evj = new a();
    this.Evk = new a();
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
      AppMethodBeat.o(98215);
      return;
      this.ayn.setTextSize(13.0F);
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.pMC;
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
    if (this.pMC)
    {
      locala = this.Evj;
      localArrayList = this.Evj.Evn;
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
      locala = this.Evk;
      localArrayList = this.Evk.Evn;
      break;
      label278:
      paramCanvas.drawText(this.Eve, locala.Evo + locala.Evp + f2, f1, this.ayn);
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
      AppMethodBeat.o(98219);
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
    for (paramInt2 = this.Evj.Evn.size();; paramInt2 = this.Evk.Evn.size())
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
    AppMethodBeat.i(98216);
    if (Util.isNullOrNil(this.mText)) {
      this.mText = "";
    }
    this.mText = paramString;
    a.a(this.Evj, "");
    a.a(this.Evk, "");
    requestLayout();
    invalidate();
    AppMethodBeat.o(98216);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(98218);
    this.ayn.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(98218);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(98217);
    this.ayn.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(98217);
  }
  
  static final class a
  {
    private static HashMap<String, Integer> Evr;
    private int Evl;
    boolean Evm;
    ArrayList<int[]> Evn;
    float Evo;
    float Evp;
    float Evq;
    private String key;
    
    static
    {
      AppMethodBeat.i(98212);
      Evr = new HashMap();
      AppMethodBeat.o(98212);
    }
    
    public a()
    {
      AppMethodBeat.i(98209);
      this.Evl = 0;
      this.key = "";
      this.Evm = false;
      this.Evn = new ArrayList();
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
        paramInt1 = this.Evl;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.key = str;
      this.Evn.clear();
      this.Evm = false;
      this.Evo = 0.0F;
      this.Evp = 0.0F;
      this.Evq = 0.0F;
      if (paramInt2 == -1)
      {
        this.Evn.add(new int[] { 0, paramString1.length() });
        this.Evl = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.Evl;
        AppMethodBeat.o(98211);
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
          break label675;
        }
        this.Evl = 0;
        paramInt1 = this.Evl;
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
        this.Evn.add(new int[] { i, paramInt2 - 1 });
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
          this.Evn.add(new int[] { i, j });
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
        this.Evn.add(new int[] { i, paramInt2 });
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
          this.Evn.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label675:
      if (this.Evn.size() == 1)
      {
        this.Evl = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.Evl;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.Evl = m;
      paramInt1 = this.Evl;
      AppMethodBeat.o(98211);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */