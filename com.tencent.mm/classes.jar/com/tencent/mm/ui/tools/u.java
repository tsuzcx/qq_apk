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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class u
{
  List<b> Ayh;
  WeakReference<EditText> Ayi;
  ArrayList<String> Ayj;
  boolean Ayk;
  String mText;
  
  public u(EditText paramEditText)
  {
    AppMethodBeat.i(107819);
    this.Ayi = new WeakReference(paramEditText);
    AppMethodBeat.o(107819);
  }
  
  private static SpannableString a(Context paramContext, String paramString, Paint paramPaint)
  {
    AppMethodBeat.i(107822);
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new ImageSpan(new a(paramContext, paramString, paramPaint), 0), 0, paramString.length(), 33);
    AppMethodBeat.o(107822);
    return localSpannableString;
  }
  
  static boolean a(EditText paramEditText, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(107821);
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = m(str, paramArrayList);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramArrayList = paramEditText.getContext();
      TextPaint localTextPaint = paramEditText.getPaint();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        int k = localb.start;
        int m = localb.length;
        if ((k < 0) || (m <= 0) || (k + m > str.length())) {
          ab.i("MicroMsg.WordsChecker", "start : %d, length : %d.", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        } else if (localb.Ayn) {
          localSpannableStringBuilder.append(a(paramArrayList, str.substring(k, k + m), localTextPaint));
        } else {
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
      AppMethodBeat.o(107821);
      return true;
    }
    AppMethodBeat.o(107821);
    return false;
  }
  
  static List<b> m(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(107823);
    if ((bo.isNullOrNil(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(107823);
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
      label65:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!bo.isNullOrNil(str))
        {
          int n = paramString.indexOf(str, j);
          if ((n < 0) || ((n >= k) && ((n != k) || (str.length() <= i)))) {
            break label241;
          }
          i = str.length();
          k = n;
        }
      }
    }
    label241:
    for (;;)
    {
      break label65;
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
      AppMethodBeat.o(107823);
      return localArrayList;
    }
  }
  
  final b QQ(int paramInt)
  {
    AppMethodBeat.i(107820);
    if (this.Ayh != null)
    {
      Iterator localIterator = this.Ayh.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((paramInt <= localb.start + localb.length) && (paramInt > localb.start))
        {
          AppMethodBeat.o(107820);
          return localb;
        }
      }
    }
    AppMethodBeat.o(107820);
    return null;
  }
  
  public static final class a
    extends Drawable
  {
    private static int Aqi;
    private float Aqj;
    private float Aqk;
    private float Ayl;
    private float Aym;
    private Paint eFj;
    private RectF gM;
    private String mText;
    private Paint oqV;
    
    public a(Context paramContext, String paramString, Paint paramPaint)
    {
      AppMethodBeat.i(107813);
      this.eFj = new Paint(1);
      this.eFj.setColor(-7829368);
      this.oqV = paramPaint;
      Aqi = BackwardSupportUtil.b.b(paramContext, 2.0F);
      this.Ayl = Aqi;
      this.Aym = Aqi;
      this.mText = paramString;
      this.Aqj = this.oqV.measureText(this.mText);
      paramContext = this.oqV.getFontMetrics();
      this.Aqk = ((float)Math.ceil(paramContext.bottom - paramContext.top));
      setBounds(0, 0, (int)(this.Aqj + Aqi * 2 + Aqi * 2), (int)this.Aqk);
      ab.i("MicroMsg.TextDrawable", "setText(%s).", new Object[] { paramString });
      AppMethodBeat.o(107813);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(107814);
      paramCanvas.drawRoundRect(this.gM, this.Ayl, this.Aym, this.eFj);
      Rect localRect = getBounds();
      int i = (int)((localRect.right - localRect.left - (this.gM.right - this.gM.left) + Aqi * 2) / 2.0F);
      Paint.FontMetricsInt localFontMetricsInt = this.oqV.getFontMetricsInt();
      int j = localRect.top;
      int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int m = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, i, k + j - m, this.oqV);
      AppMethodBeat.o(107814);
    }
    
    public final int getOpacity()
    {
      AppMethodBeat.i(107817);
      if (this.eFj.getAlpha() < 255)
      {
        AppMethodBeat.o(107817);
        return -3;
      }
      AppMethodBeat.o(107817);
      return -1;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(107815);
      if (paramInt != this.eFj.getAlpha())
      {
        this.eFj.setAlpha(paramInt);
        invalidateSelf();
      }
      AppMethodBeat.o(107815);
    }
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(107818);
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.oqV.getFontMetrics();
      float f1 = Aqi + paramInt1;
      float f2 = paramInt2;
      this.gM = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - Aqi, paramInt4);
      invalidateSelf();
      AppMethodBeat.o(107818);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(107816);
      this.eFj.setColorFilter(paramColorFilter);
      invalidateSelf();
      AppMethodBeat.o(107816);
    }
  }
  
  static final class b
  {
    boolean Ayn;
    int length;
    int start;
    
    b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.start = paramInt1;
      this.length = paramInt2;
      this.Ayn = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */