package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.a.a;
import com.tencent.neattextview.textview.layout.NeatLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NeatTextView
  extends View
  implements a
{
  private static final LruCache<String, e> Bcf;
  private static Handler Bcg;
  private static final HandlerThread psj;
  private com.tencent.neattextview.textview.layout.c BbM;
  private int Bbx;
  private TextView Bch;
  private a Bci;
  private ColorStateList Bcj;
  private ColorStateList Bck;
  private int Bcl;
  private TextView.BufferType Bcm;
  private b Bcn;
  private boolean Bco;
  private b Bcp;
  private float Bcq;
  private boolean Bcr;
  private d Bcs;
  private com.tencent.neattextview.textview.layout.a Bct;
  private ColorStateList eR;
  private TextPaint hB;
  private int kja;
  public boolean kji;
  private int mMaxHeight;
  private int mMaxWidth;
  private int mMinHeight;
  private int mMinWidth;
  private CharSequence mText;
  private CharSequence ml;
  private TextUtils.TruncateAt zoA;
  private float zoG;
  private int zox;
  private Spannable.Factory zoz;
  
  static
  {
    AppMethodBeat.i(3319);
    Bcf = new LruCache(800);
    Object localObject = new HandlerThread("PreMeasuredThread", -8);
    psj = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = psj.getLooper();
    if (localObject != null) {
      Bcg = new Handler((Looper)localObject);
    }
    AppMethodBeat.o(3319);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3278);
    this.Bci = new a((byte)0);
    this.kja = 2147483647;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.zoG = 0.0F;
    this.mText = "";
    this.Bcm = TextView.BufferType.NORMAL;
    this.zoz = Spannable.Factory.getInstance();
    this.Bco = true;
    this.Bbx = 8388659;
    this.Bcr = true;
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(3278);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3279);
    this.Bci = new a((byte)0);
    this.kja = 2147483647;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.zoG = 0.0F;
    this.mText = "";
    this.Bcm = TextView.BufferType.NORMAL;
    this.zoz = Spannable.Factory.getInstance();
    this.Bco = true;
    this.Bbx = 8388659;
    this.Bcr = true;
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(3279);
  }
  
  private String awr(String paramString)
  {
    AppMethodBeat.i(3308);
    paramString = paramString + "#" + this.hB.getTextSize();
    AppMethodBeat.o(3308);
    return paramString;
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(3280);
    this.Bcn = new b(getContext(), this);
    Object localObject = new TextView(paramContext);
    ((TextView)localObject).setClickable(true);
    ((TextView)localObject).setFocusable(true);
    this.Bch = ((TextView)localObject);
    this.hB = getWrappedTextView().getPaint();
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
          break label988;
        }
        i7 = ((TypedArray)localObject).getIndex(paramInt);
        if (i7 == 0)
        {
          i5 = ((TypedArray)localObject).getDimensionPixelSize(i7, 15);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
        }
        else if (i7 == 3)
        {
          i4 = ((TypedArray)localObject).getColor(i7, -16777216);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i5 = i;
        }
        else if (i7 == 23)
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
        AppMethodBeat.o(3280);
      }
      int i1 = this.kja;
      continue;
      if (i7 == 20)
      {
        setLines(((TypedArray)localObject).getInt(i7, 2147483647));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 7)
      {
        setTextGravity(((TypedArray)localObject).getInt(i7, 16));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 13)
      {
        setMaxWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.mMaxWidth));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 24)
      {
        setSpacingAdd(((TypedArray)localObject).getDimensionPixelSize(i7, (int)this.zoG));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 15)
      {
        setMinWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.mMinWidth));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 16)
      {
        setMinHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.mMinHeight));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 14)
      {
        setMaxHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.mMaxHeight));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 19)
      {
        setMaxLines(((TypedArray)localObject).getInt(i7, 2147483647));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 17)
      {
        paramAttributeSet = ((TypedArray)localObject).getString(i7);
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 22)
      {
        setWidth(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 21)
      {
        setHeight(((TypedArray)localObject).getDimensionPixelSize(i7, -1));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 18)
      {
        setHint(((TypedArray)localObject).getText(i7));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 4)
      {
        i3 = ((TypedArray)localObject).getColor(i7, -7829368);
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 5)
      {
        i2 = ((TypedArray)localObject).getColor(i7, -16776961);
        paramAttributeSet = paramContext;
        i1 = n;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 6)
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
        if (i7 == 26)
        {
          this.Bcr = ((TypedArray)localObject).getBoolean(i7, true);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          i5 = i;
          break label1120;
          label988:
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
              af(paramContext);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            AppMethodBeat.o(3280);
            return;
            setEllipsize(TextUtils.TruncateAt.START);
            continue;
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
            continue;
            setEllipsize(TextUtils.TruncateAt.END);
          }
        }
      }
      label1120:
      paramInt += 1;
      paramContext = paramAttributeSet;
      n = i1;
      m = i2;
      k = i3;
      j = i4;
      i = i5;
    }
  }
  
  private void dTC()
  {
    AppMethodBeat.i(3309);
    this.BbM = null;
    Handler localHandler;
    d locald;
    if (Bcg != null)
    {
      if ((this.mText != null) || (this.ml == null)) {
        break label82;
      }
      localHandler = Bcg;
      locald = new d(this.ml.toString(), this.hB);
      this.Bcs = locald;
      localHandler.post(locald);
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(3309);
      return;
      label82:
      if (this.mText == null) {
        break;
      }
      localHandler = Bcg;
      locald = new d(this.mText.toString(), this.hB);
      this.Bcs = locald;
      localHandler.post(locald);
    }
    AppMethodBeat.o(3309);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(3314);
    if (paramFloat != this.hB.getTextSize())
    {
      this.hB.setTextSize(paramFloat);
      if (this.BbM != null)
      {
        dTC();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(3314);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(3310);
    int i = this.eR.getColorForState(getDrawableState(), 0);
    if (i != this.zox) {
      this.zox = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.Bck != null)
      {
        k = this.Bck.getColorForState(getDrawableState(), 0);
        i = j;
        if (k != this.hB.linkColor)
        {
          this.hB.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.Bcj != null)
      {
        k = this.Bcj.getColorForState(getDrawableState(), 0);
        j = i;
        if (k != this.Bcl)
        {
          this.Bcl = k;
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
      AppMethodBeat.o(3310);
      return;
    }
  }
  
  public final com.tencent.neattextview.textview.layout.a Sa(int paramInt)
  {
    AppMethodBeat.i(3283);
    NeatLayout localNeatLayout;
    if (!TextUtils.isEmpty(this.mText))
    {
      localNeatLayout = new NeatLayout(this.mText, null);
      localNeatLayout.a(getPaint(), paramInt, 2.147484E+009F, getPaddingLeft(), getPaddingTop(), this.zoG, this.kja, this.zoA, this.Bcq, this.Bcr, this.Bbx);
    }
    for (;;)
    {
      AppMethodBeat.o(3283);
      return localNeatLayout;
      localNeatLayout = null;
    }
  }
  
  public final void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat)
  {
    AppMethodBeat.i(3290);
    this.Bcq = paramFloat;
    setEllipsize(paramTruncateAt);
    AppMethodBeat.o(3290);
  }
  
  public void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    boolean bool2 = true;
    AppMethodBeat.i(3286);
    this.Bcm = paramBufferType;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    boolean bool1;
    e locale;
    if (paramBufferType == TextView.BufferType.NORMAL)
    {
      paramCharSequence = TextUtils.stringOrSpannedString((CharSequence)localObject);
      this.mText = paramCharSequence;
      bool1 = bool2;
      if (dOE())
      {
        localObject = paramCharSequence.toString();
        locale = (e)Bcf.get(awr((String)localObject));
        if (locale != null) {
          break label253;
        }
        if (((String)localObject).matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$")) {
          break label248;
        }
        bool1 = true;
        label96:
        Bcf.put(awr((String)localObject), new e(bool1, null));
        label118:
        if (!bool1) {
          break label262;
        }
        bool1 = bool2;
      }
      label125:
      this.kji = bool1;
      if (!this.kji) {
        break label267;
      }
      if (getLayoutParams() != null) {
        getWrappedTextView().setLayoutParams(getLayoutParams());
      }
      getWrappedTextView().setText(paramCharSequence, paramBufferType);
      this.mText = getWrappedTextView().getText();
      requestLayout();
      invalidate();
    }
    for (;;)
    {
      if ((this.mText instanceof Spannable)) {
        ((Spannable)this.mText).setSpan(this.Bci, 0, paramCharSequence.length(), 18);
      }
      AppMethodBeat.o(3286);
      return;
      paramCharSequence = (CharSequence)localObject;
      if (paramBufferType != TextView.BufferType.SPANNABLE) {
        break;
      }
      paramCharSequence = this.zoz.newSpannable((CharSequence)localObject);
      break;
      label248:
      bool1 = false;
      break label96;
      label253:
      bool1 = locale.kji;
      break label118;
      label262:
      bool1 = false;
      break label125;
      label267:
      dTC();
    }
  }
  
  public void af(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(3285);
    a(paramCharSequence, TextView.BufferType.NORMAL);
    AppMethodBeat.o(3285);
  }
  
  public boolean dOE()
  {
    return this.Bco;
  }
  
  public final boolean dTA()
  {
    return this.kji;
  }
  
  public final CharSequence dTB()
  {
    if (this.mText == null) {
      return "";
    }
    return this.mText;
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.Bcj != null) {
      return this.Bcl;
    }
    return this.zox;
  }
  
  public final int getCurrentTextColor()
  {
    return this.zox;
  }
  
  public CharSequence getHint()
  {
    return this.ml;
  }
  
  public float getHorizontalOffset()
  {
    AppMethodBeat.i(3288);
    if (((this.Bbx & 0x7) != 3) && (this.BbM != null))
    {
      f = (getMeasuredWidth() - this.BbM.dTy()[0]) / 2.0F;
      AppMethodBeat.o(3288);
      return f;
    }
    float f = getPaddingLeft();
    AppMethodBeat.o(3288);
    return f;
  }
  
  public com.tencent.neattextview.textview.layout.a getLayout()
  {
    AppMethodBeat.i(3317);
    if (this.Bct != null)
    {
      localObject = this.Bct;
      AppMethodBeat.o(3317);
      return localObject;
    }
    Object localObject = new com.tencent.neattextview.textview.layout.a()
    {
      public final int dTo()
      {
        AppMethodBeat.i(3269);
        if (NeatTextView.a(NeatTextView.this))
        {
          i = NeatTextView.this.getWrappedTextView().getLayout().getLineCount();
          AppMethodBeat.o(3269);
          return i;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3269);
          return -1;
        }
        int i = NeatTextView.b(NeatTextView.this).dTo();
        AppMethodBeat.o(3269);
        return i;
      }
      
      public final List<com.tencent.neattextview.textview.b.c> dTp()
      {
        AppMethodBeat.i(3271);
        if (NeatTextView.a(NeatTextView.this))
        {
          AppMethodBeat.o(3271);
          return null;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3271);
          return null;
        }
        List localList = NeatTextView.b(NeatTextView.this).dTp();
        AppMethodBeat.o(3271);
        return localList;
      }
      
      public final int getLineBaseline(int paramAnonymousInt)
      {
        AppMethodBeat.i(3259);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineBaseline(paramAnonymousInt);
          AppMethodBeat.o(3259);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3259);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineBaseline(paramAnonymousInt);
        AppMethodBeat.o(3259);
        return paramAnonymousInt;
      }
      
      public final int getLineBottom(int paramAnonymousInt)
      {
        AppMethodBeat.i(3261);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineBottom(paramAnonymousInt);
          AppMethodBeat.o(3261);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3261);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineBottom(paramAnonymousInt);
        AppMethodBeat.o(3261);
        return paramAnonymousInt;
      }
      
      public final int getLineForOffset(int paramAnonymousInt)
      {
        AppMethodBeat.i(3262);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineForOffset(paramAnonymousInt);
          AppMethodBeat.o(3262);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3262);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineForOffset(paramAnonymousInt);
        AppMethodBeat.o(3262);
        return paramAnonymousInt;
      }
      
      public final int getLineForVertical(int paramAnonymousInt)
      {
        AppMethodBeat.i(3267);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineForVertical(paramAnonymousInt);
          AppMethodBeat.o(3267);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3267);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineForVertical(paramAnonymousInt);
        AppMethodBeat.o(3267);
        return paramAnonymousInt;
      }
      
      public final float getLineRight(int paramAnonymousInt)
      {
        AppMethodBeat.i(3268);
        if (NeatTextView.a(NeatTextView.this))
        {
          f = NeatTextView.this.getWrappedTextView().getLayout().getLineRight(paramAnonymousInt);
          AppMethodBeat.o(3268);
          return f;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3268);
          return -1.0F;
        }
        float f = NeatTextView.b(NeatTextView.this).getLineRight(paramAnonymousInt);
        AppMethodBeat.o(3268);
        return f;
      }
      
      public final int getLineStart(int paramAnonymousInt)
      {
        AppMethodBeat.i(3266);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineStart(paramAnonymousInt);
          AppMethodBeat.o(3266);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3266);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineStart(paramAnonymousInt);
        AppMethodBeat.o(3266);
        return paramAnonymousInt;
      }
      
      public final int getLineTop(int paramAnonymousInt)
      {
        AppMethodBeat.i(3260);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getLineTop(paramAnonymousInt);
          AppMethodBeat.o(3260);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3260);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getLineTop(paramAnonymousInt);
        AppMethodBeat.o(3260);
        return paramAnonymousInt;
      }
      
      public final float getLineWidth(int paramAnonymousInt)
      {
        AppMethodBeat.i(3265);
        if (NeatTextView.a(NeatTextView.this))
        {
          f = NeatTextView.this.getWrappedTextView().getLayout().getLineWidth(paramAnonymousInt);
          AppMethodBeat.o(3265);
          return f;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3265);
          return -1.0F;
        }
        float f = NeatTextView.b(NeatTextView.this).getLineWidth(paramAnonymousInt);
        AppMethodBeat.o(3265);
        return f;
      }
      
      public final int getOffsetForHorizontal(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(3264);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt = NeatTextView.this.getWrappedTextView().getLayout().getOffsetForHorizontal(paramAnonymousInt, paramAnonymousFloat);
          AppMethodBeat.o(3264);
          return paramAnonymousInt;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3264);
          return -1;
        }
        paramAnonymousInt = NeatTextView.b(NeatTextView.this).getOffsetForHorizontal(paramAnonymousInt, paramAnonymousFloat);
        AppMethodBeat.o(3264);
        return paramAnonymousInt;
      }
      
      public final float getPrimaryHorizontal(int paramAnonymousInt)
      {
        AppMethodBeat.i(3263);
        float f;
        if (NeatTextView.a(NeatTextView.this))
        {
          TextView localTextView = NeatTextView.this.getWrappedTextView();
          if ((localTextView != null) && (localTextView.getLayout() != null))
          {
            f = localTextView.getLayout().getPrimaryHorizontal(paramAnonymousInt);
            AppMethodBeat.o(3263);
            return f;
          }
        }
        else if (NeatTextView.b(NeatTextView.this) != null)
        {
          f = NeatTextView.b(NeatTextView.this).getPrimaryHorizontal(paramAnonymousInt);
          AppMethodBeat.o(3263);
          return f;
        }
        AppMethodBeat.o(3263);
        return -1.0F;
      }
      
      public final int ii(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(3270);
        if (NeatTextView.a(NeatTextView.this))
        {
          paramAnonymousInt1 -= NeatTextView.this.getPaddingLeft();
          int i = NeatTextView.this.getPaddingTop();
          Layout localLayout = NeatTextView.this.getWrappedTextView().getLayout();
          if (localLayout != null)
          {
            paramAnonymousInt2 = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(paramAnonymousInt2 - i), paramAnonymousInt1);
            if ((int)localLayout.getPrimaryHorizontal(paramAnonymousInt2) > paramAnonymousInt1)
            {
              paramAnonymousInt1 = localLayout.getOffsetToLeftOf(paramAnonymousInt2);
              AppMethodBeat.o(3270);
              return paramAnonymousInt1;
            }
            AppMethodBeat.o(3270);
            return paramAnonymousInt2;
          }
          AppMethodBeat.o(3270);
          return -1;
        }
        if (NeatTextView.b(NeatTextView.this) == null)
        {
          AppMethodBeat.o(3270);
          return -1;
        }
        paramAnonymousInt1 = NeatTextView.b(NeatTextView.this).ii(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(3270);
        return paramAnonymousInt1;
      }
    };
    this.Bct = ((com.tencent.neattextview.textview.layout.a)localObject);
    AppMethodBeat.o(3317);
    return localObject;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(3293);
    if (this.BbM != null)
    {
      int i = this.BbM.Bbt.size();
      AppMethodBeat.o(3293);
      return i;
    }
    AppMethodBeat.o(3293);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(3318);
    int i = Math.round(this.hB.getFontMetricsInt(null) + this.zoG);
    AppMethodBeat.o(3318);
    return i;
  }
  
  public b getOnDoubleClickListener()
  {
    return this.Bcp;
  }
  
  public TextPaint getPaint()
  {
    return this.hB;
  }
  
  public int getTextGravity()
  {
    return this.Bbx;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(3311);
    float f = getPaint().getTextSize();
    AppMethodBeat.o(3311);
    return f;
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(3287);
    if (((this.Bbx & 0x70) != 48) && (this.BbM != null))
    {
      f = (getMeasuredHeight() - this.BbM.dTy()[1]) / 2.0F;
      AppMethodBeat.o(3287);
      return f;
    }
    float f = getPaddingTop();
    AppMethodBeat.o(3287);
    return f;
  }
  
  public TextView getWrappedTextView()
  {
    return this.Bch;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(3315);
    super.invalidate();
    AppMethodBeat.o(3315);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(3284);
    super.onDraw(paramCanvas);
    int j = this.zox;
    int i = j;
    if (!TextUtils.isEmpty(this.ml))
    {
      i = j;
      if (TextUtils.isEmpty(this.mText))
      {
        i = j;
        if (this.Bcj != null) {
          i = this.Bcl;
        }
      }
    }
    this.hB.setColor(i);
    this.hB.drawableState = getDrawableState();
    if (this.kji)
    {
      paramCanvas.save();
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      Layout localLayout = getWrappedTextView().getLayout();
      if (localLayout != null) {
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
      AppMethodBeat.o(3284);
      return;
    }
    if (this.BbM != null)
    {
      if (this.BbM.getTextPaint() != null) {
        this.BbM.getTextPaint().set(this.hB);
      }
      this.BbM.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
    }
    AppMethodBeat.o(3284);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3282);
    if (this.kji)
    {
      getWrappedTextView().measure(paramInt1, paramInt2);
      setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
      AppMethodBeat.o(3282);
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
    if ((this.mMaxWidth > 0) && (this.mMaxWidth < paramInt1)) {
      paramInt1 = this.mMaxWidth;
    }
    for (;;)
    {
      if ((this.mMaxHeight > 0) && (this.mMaxHeight < paramInt2)) {
        paramInt2 = this.mMaxHeight;
      }
      for (;;)
      {
        i = getPaddingLeft();
        j = getPaddingRight();
        int n = getPaddingTop();
        int i1 = getPaddingBottom();
        float f1 = paramInt1 - i - j;
        float f2 = paramInt2 - n - i1;
        Object localObject1;
        if (TextUtils.isEmpty(this.mText)) {
          localObject1 = this.ml;
        }
        Object localObject2;
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (e)Bcf.get(awr(((CharSequence)localObject1).toString()));
            if (localObject2 != null)
            {
              localObject2 = ((e)localObject2).Bcw;
              i = 0;
              this.BbM = new NeatLayout((CharSequence)localObject1, (float[])localObject2);
              this.BbM.a(getPaint(), f1, f2, getPaddingLeft(), getPaddingTop(), this.zoG, this.kja, this.zoA, this.Bcq, this.Bcr, this.Bbx);
              if (i != 0) {
                Bcf.put(awr(this.BbM.dTx()), new e(this.kji, this.BbM.dTq()));
              }
              this.Bci.Bcv = new WeakReference(this.BbM);
              localObject1 = this.BbM.dTy();
              if (m != 1073741824) {
                paramInt1 = (int)Math.min(localObject1[0] + getPaddingLeft() + getPaddingRight(), this.mMaxWidth);
              }
              if (k != 1073741824) {
                paramInt2 = (int)Math.min(localObject1[1] + getPaddingTop() + getPaddingBottom(), this.mMaxHeight);
              }
              setMeasuredDimension(Math.max(paramInt1, this.mMinWidth), Math.max(paramInt2, this.mMinHeight));
              AppMethodBeat.o(3282);
              return;
              localObject1 = this.mText;
            }
            else
            {
              if (this.Bcs == null) {
                break label568;
              }
              localObject2 = this.Bcs;
              if ((this.hB.getTextSize() == ((d)localObject2).eLE.getTextSize()) && (((d)localObject2).fon)) {
                localObject2 = ((d)localObject2).Bcw;
              }
            }
          }
        }
        for (;;)
        {
          i = 1;
          break;
          localObject2 = null;
          continue;
          localObject2 = null;
          i = 0;
          localObject1 = "";
          break;
          label568:
          localObject2 = null;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3281);
    if ((this.Bcn != null) && (this.Bcn.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(3281);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3281);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(3316);
    super.postInvalidate();
    AppMethodBeat.o(3316);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(3289);
    if (this.zoA != paramTruncateAt)
    {
      this.zoA = paramTruncateAt;
      if (this.BbM != null)
      {
        this.BbM = null;
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(3289);
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(3297);
    this.mMaxHeight = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3297);
  }
  
  public final void setHint(int paramInt)
  {
    AppMethodBeat.i(3294);
    setHint(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(3294);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(3295);
    this.ml = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.ml);
    if (TextUtils.isEmpty(this.mText)) {
      dTC();
    }
    AppMethodBeat.o(3295);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(3307);
    this.Bcj = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(3307);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(3304);
    this.kja = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3304);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(3306);
    this.Bck = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(3306);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(3299);
    this.mMaxHeight = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3299);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(3303);
    this.kja = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3303);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(3300);
    this.mMaxWidth = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3300);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(3298);
    this.mMinHeight = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3298);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(3302);
    this.mMinWidth = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3302);
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.Bco = paramBoolean;
  }
  
  public void setOnDoubleClickListener(b paramb)
  {
    this.Bcp = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(3292);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.BbM = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(3292);
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.Bcr = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    AppMethodBeat.i(3301);
    this.zoG = paramInt;
    getWrappedTextView().setLineSpacing(paramInt, 1.0F);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3301);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(3305);
    this.eR = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(3305);
  }
  
  public void setTextGravity(int paramInt)
  {
    AppMethodBeat.i(3291);
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
      this.Bbx = i;
      if (i != this.Bbx) {
        invalidate();
      }
      AppMethodBeat.o(3291);
      return;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(3312);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(3312);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(3313);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(3313);
      return;
    }
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(3296);
    this.mMaxWidth = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(3296);
  }
  
  final class a
    implements SpanWatcher
  {
    WeakReference<com.tencent.neattextview.textview.layout.c> Bcv;
    
    private a() {}
    
    private void g(Spannable paramSpannable)
    {
      AppMethodBeat.i(3275);
      if (NeatTextView.a(NeatTextView.this))
      {
        NeatTextView.this.postInvalidate();
        AppMethodBeat.o(3275);
        return;
      }
      if (this.Bcv == null)
      {
        AppMethodBeat.o(3275);
        return;
      }
      com.tencent.neattextview.textview.layout.c localc = (com.tencent.neattextview.textview.layout.c)this.Bcv.get();
      if ((localc != null) && (localc.getText() == paramSpannable))
      {
        localc.al(paramSpannable);
        NeatTextView.this.postInvalidate();
      }
      AppMethodBeat.o(3275);
    }
    
    public final void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(3272);
      g(paramSpannable);
      AppMethodBeat.o(3272);
    }
    
    public final void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(3274);
      g(paramSpannable);
      AppMethodBeat.o(3274);
    }
    
    public final void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(3273);
      g(paramSpannable);
      AppMethodBeat.o(3273);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean fp(View paramView);
  }
  
  public static abstract interface c
    extends View.OnTouchListener
  {}
  
  static final class d
    implements Runnable
  {
    float[] Bcw;
    TextPaint eLE;
    volatile boolean fon;
    String text;
    
    d(String paramString, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(3276);
      this.eLE = new TextPaint();
      this.fon = false;
      this.eLE.set(paramTextPaint);
      this.text = paramString;
      AppMethodBeat.o(3276);
    }
    
    public final void run()
    {
      AppMethodBeat.i(3277);
      this.Bcw = new float[this.text.length()];
      this.eLE.getTextWidths(this.text, this.Bcw);
      this.fon = true;
      AppMethodBeat.o(3277);
    }
  }
  
  static final class e
  {
    public float[] Bcw;
    public boolean kji;
    
    public e(boolean paramBoolean, float[] paramArrayOfFloat)
    {
      this.kji = paramBoolean;
      this.Bcw = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.NeatTextView
 * JD-Core Version:    0.7.0.1
 */