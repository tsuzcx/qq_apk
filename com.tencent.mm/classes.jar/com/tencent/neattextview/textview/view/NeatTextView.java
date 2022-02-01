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
import android.support.v7.widget.AppCompatTextView;
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
  private static final LruCache<String, e> Mbw;
  private static final HandlerThread Mbx;
  private static Handler Mby;
  private int JKq;
  private Spannable.Factory JKs;
  private TextUtils.TruncateAt JKt;
  private float JKz;
  private int MaL;
  private a MbA;
  private ColorStateList MbB;
  private ColorStateList MbC;
  private int MbD;
  private TextView.BufferType MbE;
  private CharSequence MbF;
  private b MbG;
  private boolean MbH;
  private b MbI;
  private float MbJ;
  private boolean MbK;
  private d MbL;
  private com.tencent.neattextview.textview.layout.a MbM;
  private com.tencent.neattextview.textview.layout.c Mbd;
  private TextView Mbz;
  private TextPaint ayp;
  private int mMaxHeight;
  private int mMaxWidth;
  private int mMinHeight;
  private int mMinWidth;
  private CharSequence mText;
  private int oyV;
  public boolean ozd;
  private ColorStateList xpx;
  
  static
  {
    AppMethodBeat.i(39829);
    Mbw = new LruCache(800);
    Object localObject = new HandlerThread("PreMeasuredThread", -8);
    Mbx = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = Mbx.getLooper();
    if (localObject != null) {
      Mby = new Handler((Looper)localObject);
    }
    AppMethodBeat.o(39829);
  }
  
  public NeatTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163503);
    this.MbA = new a((byte)0);
    this.oyV = 2147483647;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.JKz = 0.0F;
    this.mText = "";
    this.MbE = TextView.BufferType.NORMAL;
    this.JKs = Spannable.Factory.getInstance();
    this.MbH = true;
    this.MaL = 8388659;
    this.MbK = true;
    e(paramContext, null, 0);
    AppMethodBeat.o(163503);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39785);
    this.MbA = new a((byte)0);
    this.oyV = 2147483647;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.JKz = 0.0F;
    this.mText = "";
    this.MbE = TextView.BufferType.NORMAL;
    this.JKs = Spannable.Factory.getInstance();
    this.MbH = true;
    this.MaL = 8388659;
    this.MbK = true;
    e(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39785);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39786);
    this.MbA = new a((byte)0);
    this.oyV = 2147483647;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mMinWidth = 0;
    this.mMinHeight = 0;
    this.JKz = 0.0F;
    this.mText = "";
    this.MbE = TextView.BufferType.NORMAL;
    this.JKs = Spannable.Factory.getInstance();
    this.MbH = true;
    this.MaL = 8388659;
    this.MbK = true;
    e(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39786);
  }
  
  private String baB(String paramString)
  {
    AppMethodBeat.i(39816);
    paramString = paramString + "#" + this.ayp.getTextSize();
    AppMethodBeat.o(39816);
    return paramString;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(39787);
    this.MbG = new b(getContext(), this);
    Object localObject = new AdaptedTextView(paramContext);
    ((AdaptedTextView)localObject).setClickable(true);
    ((AdaptedTextView)localObject).setFocusable(true);
    ((AdaptedTextView)localObject).MbO = new NeatTextView.AdaptedTextView.a()
    {
      public final void invalidate()
      {
        AppMethodBeat.i(39761);
        NeatTextView.this.invalidate();
        AppMethodBeat.o(39761);
      }
      
      public final void postInvalidate()
      {
        AppMethodBeat.i(39762);
        NeatTextView.this.postInvalidate();
        AppMethodBeat.o(39762);
      }
    };
    this.Mbz = ((TextView)localObject);
    this.ayp = getWrappedTextView().getPaint();
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.NeatTextView, paramInt, 0);
    int i = 15;
    int j = -16777216;
    int m = -7829368;
    int k = -16776961;
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
          break label1005;
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
        AppMethodBeat.o(39787);
      }
      int i1 = this.oyV;
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
        setSpacingAdd(((TypedArray)localObject).getDimensionPixelSize(i7, (int)this.JKz));
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
        i2 = ((TypedArray)localObject).getColor(i7, -7829368);
        paramAttributeSet = paramContext;
        i1 = n;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == 5)
      {
        i3 = ((TypedArray)localObject).getColor(i7, -16776961);
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
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
          this.MbK = ((TypedArray)localObject).getBoolean(i7, true);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          i5 = i;
          break label1135;
          label1005:
          ((TypedArray)localObject).recycle();
          setTextColor(j);
          setRawTextSize(i);
          setLinkTextColor(k);
          setHintTextColor(m);
          switch (n)
          {
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramContext)) {
              aq(paramContext);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            AppMethodBeat.o(39787);
            return;
            setEllipsize(TextUtils.TruncateAt.START);
            continue;
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
            continue;
            setEllipsize(TextUtils.TruncateAt.END);
          }
        }
      }
      label1135:
      paramInt += 1;
      paramContext = paramAttributeSet;
      n = i1;
      m = i2;
      k = i3;
      j = i4;
      i = i5;
    }
  }
  
  private void fXp()
  {
    AppMethodBeat.i(39798);
    getWrappedTextView().setEllipsize(this.JKt);
    AppMethodBeat.o(39798);
  }
  
  private Layout getWrappedTxtLayout()
  {
    AppMethodBeat.i(39827);
    Object localObject = getWrappedTextView();
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getLayout();
      AppMethodBeat.o(39827);
      return localObject;
    }
    AppMethodBeat.o(39827);
    return null;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(39822);
    if (paramFloat != this.ayp.getTextSize())
    {
      this.ayp.setTextSize(paramFloat);
      if (this.Mbd != null)
      {
        zY();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39822);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(39818);
    int i = this.xpx.getColorForState(getDrawableState(), 0);
    if (i != this.JKq) {
      this.JKq = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.MbC != null)
      {
        k = this.MbC.getColorForState(getDrawableState(), 0);
        i = j;
        if (k != this.ayp.linkColor)
        {
          this.ayp.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.MbB != null)
      {
        k = this.MbB.getColorForState(getDrawableState(), 0);
        j = i;
        if (k != this.MbD)
        {
          this.MbD = k;
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
      AppMethodBeat.o(39818);
      return;
    }
  }
  
  private void zY()
  {
    AppMethodBeat.i(39817);
    this.Mbd = null;
    Handler localHandler;
    d locald;
    if (Mby != null)
    {
      if ((this.mText != null) || (this.MbF == null)) {
        break label82;
      }
      localHandler = Mby;
      locald = new d(this.MbF.toString(), this.ayp);
      this.MbL = locald;
      localHandler.post(locald);
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(39817);
      return;
      label82:
      if (this.mText == null) {
        break;
      }
      localHandler = Mby;
      locald = new d(this.mText.toString(), this.ayp);
      this.MbL = locald;
      localHandler.post(locald);
    }
    AppMethodBeat.o(39817);
  }
  
  public final void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat)
  {
    AppMethodBeat.i(39797);
    this.MbJ = paramFloat;
    this.JKt = paramTruncateAt;
    fXp();
    if (this.Mbd != null)
    {
      this.Mbd = null;
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(39797);
  }
  
  public void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    boolean bool2 = true;
    AppMethodBeat.i(39793);
    this.MbE = paramBufferType;
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
      if (fPK())
      {
        localObject = paramCharSequence.toString();
        locale = (e)Mbw.get(baB((String)localObject));
        if (locale != null) {
          break label253;
        }
        if (((String)localObject).matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$")) {
          break label248;
        }
        bool1 = true;
        label96:
        Mbw.put(baB((String)localObject), new e(bool1, null));
        label118:
        if (!bool1) {
          break label262;
        }
        bool1 = bool2;
      }
      label125:
      this.ozd = bool1;
      if (!this.ozd) {
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
        ((Spannable)this.mText).setSpan(this.MbA, 0, paramCharSequence.length(), 18);
      }
      AppMethodBeat.o(39793);
      return;
      paramCharSequence = (CharSequence)localObject;
      if (paramBufferType != TextView.BufferType.SPANNABLE) {
        break;
      }
      paramCharSequence = this.JKs.newSpannable((CharSequence)localObject);
      break;
      label248:
      bool1 = false;
      break label96;
      label253:
      bool1 = locale.ozd;
      break label118;
      label262:
      bool1 = false;
      break label125;
      label267:
      zY();
    }
  }
  
  public void aq(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39792);
    a(paramCharSequence, TextView.BufferType.NORMAL);
    AppMethodBeat.o(39792);
  }
  
  public boolean fPK()
  {
    return this.MbH;
  }
  
  public final boolean fXn()
  {
    return this.ozd;
  }
  
  public final CharSequence fXo()
  {
    if (this.mText == null) {
      return "";
    }
    return this.mText;
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.MbB != null) {
      return this.MbD;
    }
    return this.JKq;
  }
  
  public final int getCurrentTextColor()
  {
    return this.JKq;
  }
  
  public CharSequence getHint()
  {
    return this.MbF;
  }
  
  public float getHorizontalOffset()
  {
    AppMethodBeat.i(39795);
    if (((this.MaL & 0x7) != 3) && (this.Mbd != null))
    {
      f = (getMeasuredWidth() - this.Mbd.fXl()[0]) / 2.0F;
      AppMethodBeat.o(39795);
      return f;
    }
    float f = getPaddingLeft();
    AppMethodBeat.o(39795);
    return f;
  }
  
  public com.tencent.neattextview.textview.layout.a getLayout()
  {
    AppMethodBeat.i(39825);
    if (this.MbM != null)
    {
      localObject = this.MbM;
      AppMethodBeat.o(39825);
      return localObject;
    }
    Object localObject = new com.tencent.neattextview.textview.layout.a()
    {
      public final int fXb()
      {
        AppMethodBeat.i(39773);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39773);
            return -1;
          }
          i = localLayout.getLineCount();
          AppMethodBeat.o(39773);
          return i;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39773);
          return -1;
        }
        int i = NeatTextView.c(NeatTextView.this).MaE.size();
        AppMethodBeat.o(39773);
        return i;
      }
      
      public final List<com.tencent.neattextview.textview.b.c> fXc()
      {
        AppMethodBeat.i(39775);
        if (NeatTextView.a(NeatTextView.this))
        {
          AppMethodBeat.o(39775);
          return null;
        }
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39775);
          return null;
        }
        List localList = NeatTextView.c(NeatTextView.this).fXc();
        AppMethodBeat.o(39775);
        return localList;
      }
      
      public final int getEllipsisCount(int paramAnonymousInt)
      {
        AppMethodBeat.i(39776);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39776);
            return -1;
          }
          paramAnonymousInt = localLayout.getEllipsisCount(paramAnonymousInt);
          AppMethodBeat.o(39776);
          return paramAnonymousInt;
        }
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39776);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getEllipsisCount(paramAnonymousInt);
        AppMethodBeat.o(39776);
        return paramAnonymousInt;
      }
      
      public final int getLineBaseline(int paramAnonymousInt)
      {
        AppMethodBeat.i(39763);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39763);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineBaseline(paramAnonymousInt);
          AppMethodBeat.o(39763);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39763);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineBaseline(paramAnonymousInt);
        AppMethodBeat.o(39763);
        return paramAnonymousInt;
      }
      
      public final int getLineBottom(int paramAnonymousInt)
      {
        AppMethodBeat.i(39765);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39765);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineBottom(paramAnonymousInt);
          AppMethodBeat.o(39765);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39765);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineBottom(paramAnonymousInt);
        AppMethodBeat.o(39765);
        return paramAnonymousInt;
      }
      
      public final int getLineForOffset(int paramAnonymousInt)
      {
        AppMethodBeat.i(39766);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39766);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineForOffset(paramAnonymousInt);
          AppMethodBeat.o(39766);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39766);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineForOffset(paramAnonymousInt);
        AppMethodBeat.o(39766);
        return paramAnonymousInt;
      }
      
      public final int getLineForVertical(int paramAnonymousInt)
      {
        AppMethodBeat.i(39771);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39771);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineForVertical(paramAnonymousInt);
          AppMethodBeat.o(39771);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39771);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineForVertical(paramAnonymousInt);
        AppMethodBeat.o(39771);
        return paramAnonymousInt;
      }
      
      public final float getLineRight(int paramAnonymousInt)
      {
        AppMethodBeat.i(39772);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39772);
            return -1.0F;
          }
          f = localLayout.getLineRight(paramAnonymousInt);
          AppMethodBeat.o(39772);
          return f;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39772);
          return -1.0F;
        }
        float f = NeatTextView.c(NeatTextView.this).getLineRight(paramAnonymousInt);
        AppMethodBeat.o(39772);
        return f;
      }
      
      public final int getLineStart(int paramAnonymousInt)
      {
        AppMethodBeat.i(39770);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39770);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineStart(paramAnonymousInt);
          AppMethodBeat.o(39770);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39770);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineStart(paramAnonymousInt);
        AppMethodBeat.o(39770);
        return paramAnonymousInt;
      }
      
      public final int getLineTop(int paramAnonymousInt)
      {
        AppMethodBeat.i(39764);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39764);
            return -1;
          }
          paramAnonymousInt = localLayout.getLineTop(paramAnonymousInt);
          AppMethodBeat.o(39764);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39764);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getLineTop(paramAnonymousInt);
        AppMethodBeat.o(39764);
        return paramAnonymousInt;
      }
      
      public final float getLineWidth(int paramAnonymousInt)
      {
        AppMethodBeat.i(39769);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39769);
            return -1.0F;
          }
          f = localLayout.getLineWidth(paramAnonymousInt);
          AppMethodBeat.o(39769);
          return f;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39769);
          return -1.0F;
        }
        float f = NeatTextView.c(NeatTextView.this).getLineWidth(paramAnonymousInt);
        AppMethodBeat.o(39769);
        return f;
      }
      
      public final int getOffsetForHorizontal(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(39768);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39768);
            return -1;
          }
          paramAnonymousInt = localLayout.getOffsetForHorizontal(paramAnonymousInt, paramAnonymousFloat);
          AppMethodBeat.o(39768);
          return paramAnonymousInt;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39768);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).getOffsetForHorizontal(paramAnonymousInt, paramAnonymousFloat);
        AppMethodBeat.o(39768);
        return paramAnonymousInt;
      }
      
      public final float getPrimaryHorizontal(int paramAnonymousInt)
      {
        AppMethodBeat.i(39767);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(39767);
            return -1.0F;
          }
          f = localLayout.getPrimaryHorizontal(paramAnonymousInt);
          AppMethodBeat.o(39767);
          return f;
        }
        NeatTextView.c(NeatTextView.this);
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39767);
          return -1.0F;
        }
        float f = NeatTextView.c(NeatTextView.this).getPrimaryHorizontal(paramAnonymousInt);
        AppMethodBeat.o(39767);
        return f;
      }
      
      public final int kO(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39774);
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
              AppMethodBeat.o(39774);
              return paramAnonymousInt1;
            }
            AppMethodBeat.o(39774);
            return paramAnonymousInt2;
          }
          AppMethodBeat.o(39774);
          return -1;
        }
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(39774);
          return -1;
        }
        paramAnonymousInt1 = NeatTextView.c(NeatTextView.this).kO(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(39774);
        return paramAnonymousInt1;
      }
    };
    this.MbM = ((com.tencent.neattextview.textview.layout.a)localObject);
    AppMethodBeat.o(39825);
    return localObject;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(39801);
    if (this.Mbd != null)
    {
      int i = this.Mbd.MaE.size();
      AppMethodBeat.o(39801);
      return i;
    }
    AppMethodBeat.o(39801);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(39826);
    int i = Math.round(this.ayp.getFontMetricsInt(null) + this.JKz);
    AppMethodBeat.o(39826);
    return i;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxLines()
  {
    return this.oyV;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public b getOnDoubleClickListener()
  {
    return this.MbI;
  }
  
  public TextPaint getPaint()
  {
    return this.ayp;
  }
  
  public int getTextGravity()
  {
    return this.MaL;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(39819);
    float f = getPaint().getTextSize();
    AppMethodBeat.o(39819);
    return f;
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(39794);
    if (((this.MaL & 0x70) != 48) && (this.Mbd != null))
    {
      f = (getMeasuredHeight() - this.Mbd.fXl()[1]) / 2.0F;
      AppMethodBeat.o(39794);
      return f;
    }
    float f = getPaddingTop();
    AppMethodBeat.o(39794);
    return f;
  }
  
  public TextView getWrappedTextView()
  {
    return this.Mbz;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(39823);
    super.invalidate();
    AppMethodBeat.o(39823);
  }
  
  public final com.tencent.neattextview.textview.layout.a kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163504);
    NeatLayout localNeatLayout;
    if (!TextUtils.isEmpty(this.mText))
    {
      localNeatLayout = new NeatLayout(this.mText, null);
      localNeatLayout.a(getPaint(), paramInt1, paramInt2, getPaddingLeft(), getPaddingTop(), this.JKz, this.oyV, this.JKt, this.MbJ, this.MbK, this.MaL);
    }
    for (;;)
    {
      AppMethodBeat.o(163504);
      return localNeatLayout;
      localNeatLayout = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39791);
    super.onDraw(paramCanvas);
    int j = this.JKq;
    int i = j;
    if (!TextUtils.isEmpty(this.MbF))
    {
      i = j;
      if (TextUtils.isEmpty(this.mText))
      {
        i = j;
        if (this.MbB != null) {
          i = this.MbD;
        }
      }
    }
    this.ayp.setColor(i);
    this.ayp.drawableState = getDrawableState();
    if (this.ozd)
    {
      paramCanvas.save();
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      Layout localLayout = getWrappedTextView().getLayout();
      if (localLayout != null) {
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
      AppMethodBeat.o(39791);
      return;
    }
    if (this.Mbd != null)
    {
      if (this.Mbd.getTextPaint() != null) {
        this.Mbd.getTextPaint().set(this.ayp);
      }
      this.Mbd.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
    }
    AppMethodBeat.o(39791);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39789);
    if (this.ozd)
    {
      getWrappedTextView().measure(paramInt1, paramInt2);
      setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
      AppMethodBeat.o(39789);
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
          localObject1 = this.MbF;
        }
        Object localObject2;
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (e)Mbw.get(baB(((CharSequence)localObject1).toString()));
            if (localObject2 != null)
            {
              localObject2 = ((e)localObject2).MbQ;
              i = 0;
              this.Mbd = new NeatLayout((CharSequence)localObject1, (float[])localObject2);
              this.Mbd.a(getPaint(), f1, f2, getPaddingLeft(), getPaddingTop(), this.JKz, this.oyV, this.JKt, this.MbJ, this.MbK, this.MaL);
              if (i != 0) {
                Mbw.put(baB(this.Mbd.fXk()), new e(this.ozd, this.Mbd.fXd()));
              }
              this.MbA.MbP = new WeakReference(this.Mbd);
              localObject1 = this.Mbd.fXl();
              if (m != 1073741824) {
                paramInt1 = (int)Math.min(localObject1[0] + getPaddingLeft() + getPaddingRight(), this.mMaxWidth);
              }
              if (k != 1073741824) {
                paramInt2 = (int)Math.min(localObject1[1] + getPaddingTop() + getPaddingBottom(), this.mMaxHeight);
              }
              setMeasuredDimension(Math.max(paramInt1, this.mMinWidth), Math.max(paramInt2, this.mMinHeight));
              AppMethodBeat.o(39789);
              return;
              localObject1 = this.mText;
            }
            else
            {
              if (this.MbL == null) {
                break label568;
              }
              localObject2 = this.MbL;
              if ((this.ayp.getTextSize() == ((d)localObject2).gHH.getTextSize()) && (((d)localObject2).hLB)) {
                localObject2 = ((d)localObject2).MbQ;
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
    AppMethodBeat.i(39788);
    if ((this.MbG != null) && (this.MbG.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(39788);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(39788);
    return bool;
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(39824);
    super.postInvalidate();
    AppMethodBeat.o(39824);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(39796);
    if (this.JKt != paramTruncateAt)
    {
      this.JKt = paramTruncateAt;
      fXp();
      if (this.Mbd != null)
      {
        this.Mbd = null;
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39796);
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(39805);
    this.mMaxHeight = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39805);
  }
  
  public final void setHint(int paramInt)
  {
    AppMethodBeat.i(39802);
    setHint(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(39802);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39803);
    this.MbF = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.MbF);
    if (TextUtils.isEmpty(this.mText)) {
      zY();
    }
    AppMethodBeat.o(39803);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(39815);
    this.MbB = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(39815);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(39812);
    this.oyV = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39812);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(39814);
    this.MbC = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(39814);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(39807);
    this.mMaxHeight = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39807);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(39811);
    this.oyV = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39811);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(39808);
    this.mMaxWidth = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39808);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(39806);
    this.mMinHeight = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39806);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(39810);
    this.mMinWidth = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39810);
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.MbH = paramBoolean;
  }
  
  public void setOnDoubleClickListener(b paramb)
  {
    this.MbI = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39800);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.Mbd = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(39800);
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.MbK = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    AppMethodBeat.i(39809);
    this.JKz = paramInt;
    getWrappedTextView().setLineSpacing(paramInt, 1.0F);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39809);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39813);
    this.xpx = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(39813);
  }
  
  public void setTextGravity(int paramInt)
  {
    AppMethodBeat.i(39799);
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
      this.MaL = i;
      if (i != this.MaL) {
        invalidate();
      }
      AppMethodBeat.o(39799);
      return;
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(39820);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(39820);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(39821);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(39821);
      return;
    }
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(39804);
    this.mMaxWidth = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39804);
  }
  
  static class AdaptedTextView
    extends AppCompatTextView
  {
    a MbO;
    
    public AdaptedTextView(Context paramContext)
    {
      super();
    }
    
    public AdaptedTextView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public AdaptedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    public void invalidate()
    {
      AppMethodBeat.i(39777);
      super.invalidate();
      if (this.MbO != null) {
        this.MbO.invalidate();
      }
      AppMethodBeat.o(39777);
    }
    
    public void postInvalidate()
    {
      AppMethodBeat.i(39778);
      super.postInvalidate();
      if (this.MbO != null) {
        this.MbO.postInvalidate();
      }
      AppMethodBeat.o(39778);
    }
    
    public static abstract interface a
    {
      public abstract void invalidate();
      
      public abstract void postInvalidate();
    }
  }
  
  final class a
    implements SpanWatcher
  {
    WeakReference<com.tencent.neattextview.textview.layout.c> MbP;
    
    private a() {}
    
    private void h(Spannable paramSpannable)
    {
      AppMethodBeat.i(39782);
      if (NeatTextView.a(NeatTextView.this))
      {
        NeatTextView.this.postInvalidate();
        AppMethodBeat.o(39782);
        return;
      }
      if (this.MbP == null)
      {
        AppMethodBeat.o(39782);
        return;
      }
      com.tencent.neattextview.textview.layout.c localc = (com.tencent.neattextview.textview.layout.c)this.MbP.get();
      if ((localc != null) && (localc.getText() == paramSpannable))
      {
        localc.ay(paramSpannable);
        NeatTextView.this.postInvalidate();
      }
      AppMethodBeat.o(39782);
    }
    
    public final void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(39779);
      h(paramSpannable);
      AppMethodBeat.o(39779);
    }
    
    public final void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(39781);
      h(paramSpannable);
      AppMethodBeat.o(39781);
    }
    
    public final void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(39780);
      h(paramSpannable);
      AppMethodBeat.o(39780);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean gC(View paramView);
  }
  
  public static abstract interface c
    extends View.OnTouchListener
  {}
  
  static final class d
    implements Runnable
  {
    float[] MbQ;
    TextPaint gHH;
    volatile boolean hLB;
    String text;
    
    d(String paramString, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(39783);
      this.gHH = new TextPaint();
      this.hLB = false;
      this.gHH.set(paramTextPaint);
      this.text = paramString;
      AppMethodBeat.o(39783);
    }
    
    public final void run()
    {
      AppMethodBeat.i(39784);
      this.MbQ = new float[this.text.length()];
      this.gHH.getTextWidths(this.text, this.MbQ);
      this.hLB = true;
      AppMethodBeat.o(39784);
    }
  }
  
  static final class e
  {
    public float[] MbQ;
    public boolean ozd;
    
    public e(boolean paramBoolean, float[] paramArrayOfFloat)
    {
      this.ozd = paramBoolean;
      this.MbQ = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.NeatTextView
 * JD-Core Version:    0.7.0.1
 */