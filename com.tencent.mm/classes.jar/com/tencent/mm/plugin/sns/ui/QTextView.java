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
  private static HashMap<String, a> KIZ;
  private int KIT;
  private String KIU;
  private String KIV;
  private boolean KIW;
  private int KIX;
  private boolean KIY;
  private a KJa;
  private a KJb;
  int KJc;
  private Context context;
  private String mText;
  boolean sTA;
  private int sTC;
  private int textSize;
  private TextPaint wi;
  
  static
  {
    AppMethodBeat.i(98222);
    KIZ = new HashMap();
    AppMethodBeat.o(98222);
  }
  
  public QTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98214);
    this.mText = "";
    this.textSize = -1;
    this.KJc = 0;
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
    this.KJc = 0;
    this.context = paramContext;
    init();
    AppMethodBeat.o(98213);
  }
  
  private int agX(int paramInt)
  {
    AppMethodBeat.i(98221);
    if (this.sTA) {
      if (Util.isNullOrNil(a.a(this.KJa))) {
        this.KJc = this.KJa.a(this.mText, paramInt - getPaddingLeft() - getPaddingRight(), this.wi);
      }
    }
    for (;;)
    {
      paramInt = this.KJc;
      int i = getPaddingLeft();
      int j = getPaddingRight();
      AppMethodBeat.o(98221);
      return paramInt + i + j;
      if (Util.isNullOrNil(a.a(this.KJb))) {
        this.KJc = this.KJb.a(this.mText, this.KIU, this.KIV, this.sTC, paramInt - getPaddingLeft() - getPaddingRight(), this.wi);
      }
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(98215);
    this.sTA = false;
    this.KIW = true;
    this.KIY = false;
    this.sTC = -1;
    this.KIU = "...";
    this.KIV = "";
    this.KIX = -16776961;
    this.KJa = new a();
    this.KJb = new a();
    this.wi = new TextPaint();
    this.wi.setAntiAlias(true);
    if (this.textSize == -1)
    {
      this.textSize = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 12.0F);
      this.wi.setTextSize(this.textSize);
    }
    for (;;)
    {
      this.wi.setColor(-16777216);
      this.wi.setTextAlign(Paint.Align.LEFT);
      AppMethodBeat.o(98215);
      return;
      this.wi.setTextSize(13.0F);
    }
  }
  
  public boolean getIsExpanded()
  {
    return this.sTA;
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
    if (this.sTA)
    {
      locala = this.KJa;
      localArrayList = this.KJa.KJe;
      f2 = getPaddingLeft();
      f1 = getPaddingTop() + -this.KIT;
      i = 0;
      if (i >= localArrayList.size()) {
        break label307;
      }
      int[] arrayOfInt = (int[])localArrayList.get(i);
      paramCanvas.drawText(this.mText, arrayOfInt[0], arrayOfInt[1] + 1, f2, f1, this.wi);
      if ((i == localArrayList.size() - 1) && (locala.KJd))
      {
        paramCanvas.drawText(this.KIU, locala.KJf + f2, f1, this.wi);
        if (this.KIW)
        {
          j = this.wi.getColor();
          this.wi.setColor(this.KIX);
          if (!this.KIY) {
            break label278;
          }
          paramCanvas.drawText(this.KIV, paramCanvas.getWidth() - (locala.KJh + getPaddingRight() + getPaddingLeft()), f1, this.wi);
        }
      }
    }
    for (;;)
    {
      this.wi.setColor(j);
      f1 += -this.KIT + this.wi.descent();
      if (f1 > paramCanvas.getHeight()) {
        break label307;
      }
      i += 1;
      break label53;
      locala = this.KJb;
      localArrayList = this.KJb.KJe;
      break;
      label278:
      paramCanvas.drawText(this.KIV, locala.KJf + locala.KJg + f2, f1, this.wi);
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
      agX(paramInt1);
    }
    int k;
    for (;;)
    {
      k = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      this.KIT = ((int)this.wi.ascent());
      if (k != 1073741824) {
        break;
      }
      paramInt2 = i;
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(98219);
      return;
      if (i == -2147483648)
      {
        paramInt1 = Math.min(agX(paramInt1), paramInt1);
      }
      else
      {
        agX(paramInt1);
        paramInt1 = 0;
      }
    }
    if (this.sTA) {}
    for (paramInt2 = this.KJa.KJe.size();; paramInt2 = this.KJb.KJe.size())
    {
      int j = paramInt2 * (int)(-this.KIT + this.wi.descent()) + getPaddingTop() + getPaddingBottom();
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
    this.KIX = paramInt;
  }
  
  public void setDrawEllipsizeMoreString(boolean paramBoolean)
  {
    this.KIW = paramBoolean;
  }
  
  public void setEllipsis(String paramString)
  {
    this.KIU = paramString;
  }
  
  public void setEllipsisMore(String paramString)
  {
    this.KIV = paramString;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.sTC = paramInt;
  }
  
  public void setRightAlignEllipsizeMoreString(boolean paramBoolean)
  {
    this.KIY = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98216);
    if (Util.isNullOrNil(this.mText)) {
      this.mText = "";
    }
    this.mText = paramString;
    a.a(this.KJa, "");
    a.a(this.KJb, "");
    requestLayout();
    invalidate();
    AppMethodBeat.o(98216);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(98218);
    this.wi.setColor(paramInt);
    invalidate();
    AppMethodBeat.o(98218);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(98217);
    this.wi.setTextSize(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(98217);
  }
  
  static final class a
  {
    private static HashMap<String, Integer> KJi;
    private int KJc;
    boolean KJd;
    ArrayList<int[]> KJe;
    float KJf;
    float KJg;
    float KJh;
    private String key;
    
    static
    {
      AppMethodBeat.i(98212);
      KJi = new HashMap();
      AppMethodBeat.o(98212);
    }
    
    public a()
    {
      AppMethodBeat.i(98209);
      this.KJc = 0;
      this.key = "";
      this.KJd = false;
      this.KJe = new ArrayList();
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
        paramInt1 = this.KJc;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.key = str;
      this.KJe.clear();
      this.KJd = false;
      this.KJf = 0.0F;
      this.KJg = 0.0F;
      this.KJh = 0.0F;
      if (paramInt2 == -1)
      {
        this.KJe.add(new int[] { 0, paramString1.length() });
        this.KJc = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.KJc;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      if (paramString2 != null) {
        this.KJg = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.KJh = paramTextPaint.measureText(paramString3);
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
        if (this.KJe.size() == paramInt1) {
          this.KJd = true;
        }
      }
      else
      {
        if (this.KJd)
        {
          paramString2 = (int[])this.KJe.get(this.KJe.size() - 1);
          this.KJf = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.KJe.size() != 0) {
          break label675;
        }
        this.KJc = 0;
        paramInt1 = this.KJc;
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
        this.KJe.add(new int[] { i, paramInt2 - 1 });
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
        if (this.KJe.size() == paramInt1 - 1)
        {
          i1 = (int)(m - (this.KJg + this.KJh));
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
          this.KJe.add(new int[] { i, j });
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
        this.KJe.add(new int[] { i, paramInt2 });
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
          this.KJe.add(new int[] { i, j });
          i2 = n;
          f1 = f2;
          k = i;
          i1 = m;
        }
      }
      label675:
      if (this.KJe.size() == 1)
      {
        this.KJc = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
        paramInt1 = this.KJc;
        AppMethodBeat.o(98211);
        return paramInt1;
      }
      this.KJc = m;
      paramInt1 = this.KJc;
      AppMethodBeat.o(98211);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView
 * JD-Core Version:    0.7.0.1
 */