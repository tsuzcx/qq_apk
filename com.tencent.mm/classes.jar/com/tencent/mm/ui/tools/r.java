package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
{
  String hnV;
  List<b> wfr;
  WeakReference<EditText> wfs;
  ArrayList<String> wft;
  boolean wfu;
  
  public r(EditText paramEditText)
  {
    this.wfs = new WeakReference(paramEditText);
  }
  
  static boolean a(EditText paramEditText, ArrayList<String> paramArrayList)
  {
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject1 = k(str, paramArrayList);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramArrayList = paramEditText.getContext();
      TextPaint localTextPaint = paramEditText.getPaint();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (b)((Iterator)localObject1).next();
        int k = ((b)localObject2).start;
        int m = ((b)localObject2).length;
        if ((k < 0) || (m <= 0) || (k + m > str.length()))
        {
          y.i("MicroMsg.WordsChecker", "start : %d, length : %d.", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        }
        else if (((b)localObject2).wfx)
        {
          localObject2 = str.substring(k, k + m);
          SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
          localSpannableString.setSpan(new ImageSpan(new a(paramArrayList, (String)localObject2, localTextPaint), 0), 0, ((String)localObject2).length(), 33);
          localSpannableStringBuilder.append(localSpannableString);
        }
        else
        {
          localSpannableStringBuilder.append(str.substring(k, k + m));
        }
      }
      if (localSpannableStringBuilder.length() > 0)
      {
        paramEditText.setText(localSpannableStringBuilder);
        paramEditText.setTextKeepState(localSpannableStringBuilder);
        if ((i == j) && (i >= 0)) {
          paramEditText.setSelection(i);
        }
      }
      return true;
    }
    return false;
  }
  
  static List<b> k(String paramString, ArrayList<String> paramArrayList)
  {
    if ((bk.bl(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int m = paramString.length();
    int j = 0;
    int i;
    int k;
    if (j <= m)
    {
      Iterator localIterator = paramArrayList.iterator();
      i = 0;
      k = m;
      label55:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!bk.bl(str))
        {
          int n = paramString.indexOf(str, j);
          if ((n < 0) || ((n >= k) && ((n != k) || (str.length() <= i)))) {
            break label226;
          }
          i = str.length();
          k = n;
        }
      }
    }
    label226:
    for (;;)
    {
      break label55;
      if (k < m)
      {
        if (k > j) {
          localArrayList.add(new b(j, k - j, false));
        }
        localArrayList.add(new b(k, i, true));
        j = k + i;
        break;
      }
      if (k > j) {
        localArrayList.add(new b(j, k - j, false));
      }
      return localArrayList;
    }
  }
  
  final b Ie(int paramInt)
  {
    if (this.wfr != null)
    {
      Iterator localIterator = this.wfr.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((paramInt <= localb.start + localb.length) && (paramInt > localb.start)) {
          return localb;
        }
      }
    }
    return null;
  }
  
  public static final class a
    extends Drawable
  {
    private static int vXW;
    private Paint dHE = new Paint(1);
    private RectF fS;
    private String hnV;
    private Paint vXV;
    private float vXX;
    private float vXY;
    private float wfv;
    private float wfw;
    
    public a(Context paramContext, String paramString, Paint paramPaint)
    {
      this.dHE.setColor(-7829368);
      this.vXV = paramPaint;
      vXW = BackwardSupportUtil.b.b(paramContext, 2.0F);
      this.wfv = vXW;
      this.wfw = vXW;
      this.hnV = paramString;
      this.vXX = this.vXV.measureText(this.hnV);
      paramContext = this.vXV.getFontMetrics();
      this.vXY = ((float)Math.ceil(paramContext.bottom - paramContext.top));
      setBounds(0, 0, (int)(this.vXX + vXW * 2 + vXW * 2), (int)this.vXY);
      y.i("MicroMsg.TextDrawable", "setText(%s).", new Object[] { paramString });
    }
    
    public final void draw(Canvas paramCanvas)
    {
      paramCanvas.drawRoundRect(this.fS, this.wfv, this.wfw, this.dHE);
      Rect localRect = getBounds();
      int i = (int)((localRect.right - localRect.left - (this.fS.right - this.fS.left) + vXW * 2) / 2.0F);
      Paint.FontMetricsInt localFontMetricsInt = this.vXV.getFontMetricsInt();
      int j = localRect.top;
      int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int m = localFontMetricsInt.top;
      paramCanvas.drawText(this.hnV, i, k + j - m, this.vXV);
    }
    
    public final int getOpacity()
    {
      if (this.dHE.getAlpha() < 255) {
        return -3;
      }
      return -1;
    }
    
    public final void setAlpha(int paramInt)
    {
      if (paramInt != this.dHE.getAlpha())
      {
        this.dHE.setAlpha(paramInt);
        invalidateSelf();
      }
    }
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.vXV.getFontMetrics();
      float f1 = vXW + paramInt1;
      float f2 = paramInt2;
      this.fS = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - vXW, paramInt4);
      invalidateSelf();
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      this.dHE.setColorFilter(paramColorFilter);
      invalidateSelf();
    }
  }
  
  private static final class b
  {
    int length;
    int start;
    boolean wfx;
    
    b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.start = paramInt1;
      this.length = paramInt2;
      this.wfx = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */