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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y
{
  List<b> Qxm;
  WeakReference<EditText> Qxn;
  ArrayList<String> Qxo;
  boolean Qxp;
  String mText;
  
  public y(EditText paramEditText)
  {
    AppMethodBeat.i(143290);
    this.Qxn = new WeakReference(paramEditText);
    AppMethodBeat.o(143290);
  }
  
  private static SpannableString a(Context paramContext, String paramString, Paint paramPaint)
  {
    AppMethodBeat.i(143293);
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new ImageSpan(new a(paramContext, paramString, paramPaint), 0), 0, paramString.length(), 33);
    AppMethodBeat.o(143293);
    return localSpannableString;
  }
  
  static boolean a(EditText paramEditText, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143292);
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = o(str, paramArrayList);
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
          Log.i("MicroMsg.WordsChecker", "start : %d, length : %d.", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        } else if (localb.Qxs) {
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
      AppMethodBeat.o(143292);
      return true;
    }
    AppMethodBeat.o(143292);
    return false;
  }
  
  static List<b> o(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143294);
    if ((Util.isNullOrNil(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(143294);
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
        if (!Util.isNullOrNil(str))
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
      AppMethodBeat.o(143294);
      return localArrayList;
    }
  }
  
  final b aoo(int paramInt)
  {
    AppMethodBeat.i(143291);
    if (this.Qxm != null)
    {
      Iterator localIterator = this.Qxm.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((paramInt <= localb.start + localb.length) && (paramInt > localb.start))
        {
          AppMethodBeat.o(143291);
          return localb;
        }
      }
    }
    AppMethodBeat.o(143291);
    return null;
  }
  
  public static final class a
    extends Drawable
  {
    private static int QoX;
    private RectF JkS;
    private float QoY;
    private float QoZ;
    private float Qxq;
    private float Qxr;
    private Paint hob;
    private String mText;
    private Paint zbt;
    
    public a(Context paramContext, String paramString, Paint paramPaint)
    {
      AppMethodBeat.i(143284);
      this.hob = new Paint(1);
      this.hob.setColor(-7829368);
      this.zbt = paramPaint;
      QoX = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 2.0F);
      this.Qxq = QoX;
      this.Qxr = QoX;
      this.mText = paramString;
      this.QoY = this.zbt.measureText(this.mText);
      paramContext = this.zbt.getFontMetrics();
      this.QoZ = ((float)Math.ceil(paramContext.bottom - paramContext.top));
      setBounds(0, 0, (int)(this.QoY + QoX * 2 + QoX * 2), (int)this.QoZ);
      Log.i("MicroMsg.TextDrawable", "setText(%s).", new Object[] { paramString });
      AppMethodBeat.o(143284);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(143285);
      paramCanvas.drawRoundRect(this.JkS, this.Qxq, this.Qxr, this.hob);
      Rect localRect = getBounds();
      int i = (int)((localRect.right - localRect.left - (this.JkS.right - this.JkS.left) + QoX * 2) / 2.0F);
      Paint.FontMetricsInt localFontMetricsInt = this.zbt.getFontMetricsInt();
      int j = localRect.top;
      int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
      int m = localFontMetricsInt.top;
      paramCanvas.drawText(this.mText, i, k + j - m, this.zbt);
      AppMethodBeat.o(143285);
    }
    
    public final int getOpacity()
    {
      AppMethodBeat.i(143288);
      if (this.hob.getAlpha() < 255)
      {
        AppMethodBeat.o(143288);
        return -3;
      }
      AppMethodBeat.o(143288);
      return -1;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(143286);
      if (paramInt != this.hob.getAlpha())
      {
        this.hob.setAlpha(paramInt);
        invalidateSelf();
      }
      AppMethodBeat.o(143286);
    }
    
    public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(143289);
      super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      Paint.FontMetrics localFontMetrics = this.zbt.getFontMetrics();
      float f1 = QoX + paramInt1;
      float f2 = paramInt2;
      this.JkS = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - QoX, paramInt4);
      invalidateSelf();
      AppMethodBeat.o(143289);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(143287);
      this.hob.setColorFilter(paramColorFilter);
      invalidateSelf();
      AppMethodBeat.o(143287);
    }
  }
  
  static final class b
  {
    boolean Qxs;
    int length;
    int start;
    
    b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.start = paramInt1;
      this.length = paramInt2;
      this.Qxs = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.y
 * JD-Core Version:    0.7.0.1
 */