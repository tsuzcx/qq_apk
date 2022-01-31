package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.layout.NeatLayout;
import java.util.ArrayList;

public class NeatTextView
  extends View
  implements a
{
  private static final LruCache<String, Boolean> wEB = new LruCache(500);
  private static final LruCache<a, com.tencent.neattextview.textview.layout.b> wEC = new LruCache(500);
  private static final HandlerThread wED;
  private static Handler wEE;
  private int Un = 0;
  private ColorStateList dP;
  private int eg = 2147483647;
  private TextPaint gI;
  private int lgJ = 2147483647;
  private CharSequence lq;
  public CharSequence mText;
  private int sfR = 2147483647;
  private int vah;
  private Spannable.Factory vaj = Spannable.Factory.getInstance();
  private TextUtils.TruncateAt vak;
  private float vaq = 0.0F;
  private boolean wEF = false;
  public boolean wEG;
  private TextView wEH;
  private ColorStateList wEI;
  private ColorStateList wEJ;
  private int wEK;
  private int wEL = 0;
  private TextView.BufferType wEM = TextView.BufferType.NORMAL;
  private b wEN;
  private boolean wEO = true;
  private b wEP;
  private int wEQ = 8388659;
  private boolean wER = true;
  private d wES;
  private com.tencent.neattextview.textview.layout.b wEm;
  
  static
  {
    Object localObject = new HandlerThread("PreMeasuredThread", -8);
    wED = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = wED.getLooper();
    if (localObject != null) {
      wEE = new Handler((Looper)localObject);
    }
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext, paramAttributeSet, 0);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.wEN = new b(getContext(), this);
    Object localObject = new TextView(paramContext);
    ((TextView)localObject).setClickable(true);
    ((TextView)localObject).setFocusable(true);
    this.wEH = ((TextView)localObject);
    this.gI = getWrappedTextView().getPaint();
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.NeatTextView, paramInt, 0);
    int i = 15;
    int j = -16777216;
    int k = -7829368;
    int m = -16776961;
    int n = -1;
    paramContext = null;
    for (;;)
    {
      int i7;
      int i5;
      int i2;
      int i3;
      int i4;
      try
      {
        int i6 = ((TypedArray)localObject).getIndexCount();
        paramInt = 0;
        if (paramInt >= i6) {
          break label983;
        }
        i7 = ((TypedArray)localObject).getIndex(paramInt);
        if (i7 == a.a.NeatTextView_android_textSize)
        {
          i5 = ((TypedArray)localObject).getDimensionPixelSize(i7, 15);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (i7 == a.a.NeatTextView_android_textColor)
        {
          i4 = ((TypedArray)localObject).getColor(i7, -16777216);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i5 = i;
        }
        else if (i7 == a.a.NeatTextView_android_singleLine)
        {
          if (((TypedArray)localObject).getBoolean(i7, false))
          {
            i1 = 1;
            setMaxLines(i1);
            paramAttributeSet = paramContext;
            i1 = n;
            i2 = m;
            i3 = k;
            i4 = j;
            i5 = i;
          }
        }
      }
      finally
      {
        ((TypedArray)localObject).recycle();
      }
      int i1 = -1;
      continue;
      if (i7 == a.a.NeatTextView_android_lines)
      {
        setLines(((TypedArray)localObject).getInt(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_gravity)
      {
        setTextGravity(((TypedArray)localObject).getInt(i7, 16));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxWidth)
      {
        setMaxWidth(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_lineSpacingExtra)
      {
        setSpacingAdd(((TypedArray)localObject).getDimensionPixelSize(i7, (int)this.vaq));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minWidth)
      {
        setMinWidth(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minHeight)
      {
        setMinHeight(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxHeight)
      {
        setMaxHeight(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxLines)
      {
        setMaxLines(((TypedArray)localObject).getInt(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_text)
      {
        paramAttributeSet = ((TypedArray)localObject).getString(i7);
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_width)
      {
        setWidth(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_height)
      {
        setHeight(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_hint)
      {
        setHint(((TypedArray)localObject).getText(i7));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_textColorHint)
      {
        i3 = ((TypedArray)localObject).getColor(i7, -7829368);
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_textColorLink)
      {
        i2 = ((TypedArray)localObject).getColor(i7, -16776961);
        paramAttributeSet = paramContext;
        i1 = n;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_ellipsize)
      {
        i1 = ((TypedArray)localObject).getInt(i7, n);
        paramAttributeSet = paramContext;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else
      {
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
        if (i7 == a.a.NeatTextView_smartLetter)
        {
          this.wER = ((TypedArray)localObject).getBoolean(i7, true);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          i5 = i;
          break label1106;
          label983:
          ((TypedArray)localObject).recycle();
          setTextColor(j);
          setRawTextSize(i);
          setLinkTextColor(m);
          setHintTextColor(k);
          switch (n)
          {
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramContext)) {
              R(paramContext);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            return;
            setEllipsize(TextUtils.TruncateAt.START);
            continue;
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
            continue;
            setEllipsize(TextUtils.TruncateAt.END);
          }
        }
      }
      label1106:
      paramInt += 1;
      paramContext = paramAttributeSet;
      n = i1;
      m = i2;
      k = i3;
      j = i4;
      i = i5;
    }
  }
  
  private void cNQ()
  {
    this.wEm = null;
    Handler localHandler;
    d locald;
    if (wEE != null)
    {
      if ((this.mText != null) || (this.lq == null)) {
        break label70;
      }
      localHandler = wEE;
      locald = new d(this.lq.toString(), this.gI);
      this.wES = locald;
      localHandler.post(locald);
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      label70:
      do
      {
        return;
      } while (this.mText == null);
      localHandler = wEE;
      locald = new d(this.mText.toString(), this.gI);
      this.wES = locald;
      localHandler.post(locald);
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.gI.getTextSize())
    {
      this.gI.setTextSize(paramFloat);
      if (this.wEm != null)
      {
        cNQ();
        requestLayout();
        invalidate();
      }
    }
  }
  
  private void updateTextColors()
  {
    int i = this.dP.getColorForState(getDrawableState(), 0);
    if (i != this.vah) {
      this.vah = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.wEJ != null)
      {
        k = this.wEJ.getColorForState(getDrawableState(), 0);
        i = j;
        if (k != this.gI.linkColor)
        {
          this.gI.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.wEI != null)
      {
        k = this.wEI.getColorForState(getDrawableState(), 0);
        j = i;
        if (k != this.wEK)
        {
          this.wEK = k;
          if (this.mText != null)
          {
            j = i;
            if (this.mText.length() != 0) {}
          }
          else
          {
            j = 1;
          }
        }
      }
      if (j != 0) {
        invalidate();
      }
      return;
    }
  }
  
  public final com.tencent.neattextview.textview.layout.b Je(int paramInt)
  {
    if (!TextUtils.isEmpty(this.mText))
    {
      NeatLayout localNeatLayout = new NeatLayout(this.mText, null);
      localNeatLayout.a(getPaint(), paramInt, 2.147484E+009F, getPaddingLeft(), getPaddingTop(), this.vaq, this.lgJ, this.vak, this.wER);
      return localNeatLayout;
    }
    return null;
  }
  
  public void R(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    Object localObject2 = TextView.BufferType.NORMAL;
    this.wEM = ((TextView.BufferType)localObject2);
    Object localObject1 = paramCharSequence;
    if (paramCharSequence == null) {
      localObject1 = "";
    }
    boolean bool1;
    if (localObject2 == TextView.BufferType.NORMAL)
    {
      paramCharSequence = TextUtils.stringOrSpannedString((CharSequence)localObject1);
      this.mText = paramCharSequence;
      if (cJN())
      {
        localObject1 = paramCharSequence.toString();
        localObject2 = (Boolean)wEB.get(localObject1);
        if (localObject2 != null) {
          break label185;
        }
        if (((String)localObject1).matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$")) {
          break label180;
        }
        bool1 = true;
        label90:
        wEB.put(localObject1, Boolean.valueOf(bool1));
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      this.wEG = bool2;
      if (!this.wEG) {
        break label194;
      }
      if (getLayoutParams() != null) {
        getWrappedTextView().setLayoutParams(getLayoutParams());
      }
      getWrappedTextView().setText(paramCharSequence);
      requestLayout();
      invalidate();
      return;
      paramCharSequence = (CharSequence)localObject1;
      if (localObject2 != TextView.BufferType.SPANNABLE) {
        break;
      }
      paramCharSequence = this.vaj.newSpannable((CharSequence)localObject1);
      break;
      label180:
      bool1 = false;
      break label90;
      label185:
      bool1 = ((Boolean)localObject2).booleanValue();
    }
    label194:
    cNQ();
  }
  
  public boolean cJN()
  {
    return this.wEO;
  }
  
  public final boolean cNP()
  {
    return this.wEG;
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.wEI != null) {
      return this.wEK;
    }
    return this.vah;
  }
  
  public final int getCurrentTextColor()
  {
    return this.vah;
  }
  
  public CharSequence getHint()
  {
    return this.lq;
  }
  
  public float getHorizontalOffset()
  {
    if (((this.wEQ & 0x7) != 3) && (this.wEm != null)) {
      return (getMeasuredHeight() - this.wEm.cNM()[0]) / 2.0F;
    }
    return getPaddingLeft();
  }
  
  public com.tencent.neattextview.textview.layout.b getLayout()
  {
    return this.wEm;
  }
  
  public int getLineCount()
  {
    if (this.wEm != null) {
      return this.wEm.wDJ.size();
    }
    return 0;
  }
  
  public b getOnDoubleClickListener()
  {
    return this.wEP;
  }
  
  public TextPaint getPaint()
  {
    return this.gI;
  }
  
  public int getTextGravity()
  {
    return this.wEQ;
  }
  
  public float getTextSize()
  {
    return getPaint().getTextSize();
  }
  
  public float getVerticalOffset()
  {
    if (((this.wEQ & 0x70) != 48) && (this.wEm != null)) {
      return (getMeasuredHeight() - this.wEm.cNM()[1]) / 2.0F;
    }
    return getPaddingTop();
  }
  
  public TextView getWrappedTextView()
  {
    return this.wEH;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.vah;
    int i = j;
    if (!TextUtils.isEmpty(this.lq))
    {
      i = j;
      if (TextUtils.isEmpty(this.mText))
      {
        i = j;
        if (this.wEI != null) {
          i = this.wEK;
        }
      }
    }
    this.gI.setColor(i);
    this.gI.drawableState = getDrawableState();
    if (this.wEG)
    {
      paramCanvas.save();
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      localLayout = getWrappedTextView().getLayout();
      if (localLayout != null) {
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
    while (this.wEm == null)
    {
      Layout localLayout;
      return;
    }
    if (this.wEm.cNN() != null) {
      this.wEm.cNN().set(this.gI);
    }
    this.wEm.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(this.mText)) && (TextUtils.isEmpty(this.lq)))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (this.wEG)
    {
      getWrappedTextView().measure(paramInt1, paramInt2);
      setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
      return;
    }
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = j;
    if (j <= 0)
    {
      paramInt1 = j;
      if (k == 0) {
        paramInt1 = getResources().getDisplayMetrics().widthPixels;
      }
    }
    paramInt2 = i;
    if (i <= 0)
    {
      paramInt2 = i;
      if (k == 0) {
        paramInt2 = 2147483647;
      }
    }
    if ((this.eg > 0) && (this.eg < paramInt1)) {
      paramInt1 = this.eg;
    }
    for (;;)
    {
      if ((this.sfR > 0) && (this.sfR < paramInt2)) {
        paramInt2 = this.sfR;
      }
      for (;;)
      {
        i = getPaddingLeft();
        j = getPaddingRight();
        int n = getPaddingTop();
        int i1 = getPaddingBottom();
        float f1 = getResources().getConfiguration().fontScale;
        int i2 = getResources().getConfiguration().orientation;
        Object localObject1 = this.mText;
        float f2 = getTextSize();
        Object localObject2 = getPaint().getFontMetricsInt();
        localObject2 = new a((CharSequence)localObject1, new int[] { paramInt1 - i - j, paramInt2 - n - i1 }, f2, (Paint.FontMetricsInt)localObject2, f1, i2);
        if (this.wEF)
        {
          this.wEm = null;
          this.wEF = false;
          if (this.wEm == null)
          {
            if ((!TextUtils.isEmpty(this.mText)) || (TextUtils.isEmpty(this.lq))) {
              break label554;
            }
            localCharSequence = this.lq;
            if (this.wES != null) {
              break label538;
            }
          }
        }
        label538:
        for (localObject1 = null;; localObject1 = this.wES.d(this.gI))
        {
          this.wEm = new NeatLayout(localCharSequence, (float[])localObject1);
          this.wEm.a(getPaint(), localObject2.wEV[0], localObject2.wEV[1], getPaddingLeft(), getPaddingTop(), this.vaq, this.lgJ, this.vak, this.wER);
          wEC.put(localObject2, this.wEm);
          localObject1 = this.wEm.cNM();
          if (m != 1073741824) {
            paramInt1 = (int)Math.min(localObject1[0] + getPaddingLeft() + getPaddingRight(), this.eg);
          }
          if (k != 1073741824) {
            paramInt2 = (int)Math.min(localObject1[1] + getPaddingTop() + getPaddingBottom(), this.sfR);
          }
          setMeasuredDimension(Math.max(paramInt1, this.Un), Math.max(paramInt2, this.wEL));
          return;
          this.wEm = ((com.tencent.neattextview.textview.layout.b)wEC.get(localObject2));
          break;
        }
        label554:
        CharSequence localCharSequence = this.mText;
        if (this.wES == null) {}
        for (localObject1 = null;; localObject1 = this.wES.d(this.gI))
        {
          this.wEm = new NeatLayout(localCharSequence, (float[])localObject1);
          break;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.wEN != null) && (this.wEN.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.vak != paramTruncateAt)
    {
      this.vak = paramTruncateAt;
      if (this.wEm != null)
      {
        this.wEm = null;
        requestLayout();
        invalidate();
      }
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.wEF = true;
    this.sfR = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public final void setHint(int paramInt)
  {
    setHint(getContext().getResources().getText(paramInt));
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    this.lq = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.lq);
    if (TextUtils.isEmpty(this.mText)) {
      cNQ();
    }
  }
  
  public final void setHintTextColor(int paramInt)
  {
    this.wEI = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    updateTextColors();
  }
  
  public void setLines(int paramInt)
  {
    this.wEF = true;
    this.lgJ = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    this.wEJ = ColorStateList.valueOf(paramInt);
    updateTextColors();
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.wEF = true;
    this.sfR = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMaxLines(int paramInt)
  {
    this.wEF = true;
    this.lgJ = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.wEF = true;
    this.eg = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMinHeight(int paramInt)
  {
    this.wEF = true;
    this.wEL = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMinWidth(int paramInt)
  {
    this.wEF = true;
    this.Un = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.wEO = paramBoolean;
  }
  
  public void setOnDoubleClickListener(b paramb)
  {
    this.wEP = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.wEm = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.wER = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    this.wEF = true;
    this.vaq = paramInt;
    getWrappedTextView().setLineSpacing(paramInt, 1.0F);
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.dP = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setTextColor(paramInt);
    updateTextColors();
  }
  
  public void setTextGravity(int paramInt)
  {
    getWrappedTextView().setGravity(paramInt);
    if ((0x800007 & paramInt) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.wEQ = i;
      if (i != this.wEQ) {
        invalidate();
      }
      return;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
  
  public void setWidth(int paramInt)
  {
    this.wEF = true;
    this.eg = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
  }
  
  private static final class a
  {
    float dOB;
    float fontScale;
    int orientation;
    CharSequence text;
    int wET = 1;
    Paint.FontMetricsInt wEU;
    int[] wEV;
    
    a(CharSequence paramCharSequence, int[] paramArrayOfInt, float paramFloat1, Paint.FontMetricsInt paramFontMetricsInt, float paramFloat2, int paramInt)
    {
      this.wEV = paramArrayOfInt;
      if (TextUtils.isEmpty(paramCharSequence)) {}
      for (paramArrayOfInt = "";; paramArrayOfInt = paramCharSequence)
      {
        this.text = paramArrayOfInt;
        this.dOB = paramFloat1;
        this.wEU = paramFontMetricsInt;
        this.fontScale = paramFloat2;
        this.orientation = paramInt;
        if (!(paramCharSequence instanceof Spannable)) {
          break;
        }
        paramCharSequence = (CharacterStyle[])((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), CharacterStyle.class);
        int j = paramCharSequence.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramArrayOfInt = paramCharSequence[paramInt];
          i = this.wET;
          this.wET = (paramArrayOfInt.hashCode() + i);
          paramInt += 1;
        }
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        return (this.dOB == paramObject.dOB) && (this.fontScale == paramObject.fontScale) && (this.wEV[0] == paramObject.wEV[0]) && (this.wEV[1] == paramObject.wEV[1]) && (this.wEU.descent == paramObject.wEU.descent) && (this.wEU.top == paramObject.wEU.top) && (this.wEU.bottom == paramObject.wEU.bottom) && (this.wEU.ascent == paramObject.wEU.ascent) && (this.wEU.leading == paramObject.wEU.leading) && (this.text.equals(paramObject.text));
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (int)(this.wET + this.text.hashCode() + this.dOB * this.fontScale * this.orientation + this.wEV[0] + this.wEV[1]);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean eb(View paramView);
  }
  
  public static abstract interface c
    extends View.OnTouchListener
  {}
  
  static final class d
    implements Runnable
  {
    TextPaint dNW = new TextPaint();
    volatile boolean dYj = false;
    String text;
    float[] wEW;
    
    d(String paramString, TextPaint paramTextPaint)
    {
      this.dNW.set(paramTextPaint);
      this.text = paramString;
    }
    
    public final float[] d(Paint paramPaint)
    {
      if (paramPaint.getTextSize() != this.dNW.getTextSize()) {}
      while (!this.dYj) {
        return null;
      }
      return this.wEW;
    }
    
    public final void run()
    {
      this.wEW = new float[this.text.length()];
      this.dNW.getTextWidths(this.text, this.wEW);
      this.dYj = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.NeatTextView
 * JD-Core Version:    0.7.0.1
 */