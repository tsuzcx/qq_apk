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
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
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
  private static final LruCache<String, d> Zdr;
  private static final HandlerThread Zds;
  private static Handler Zdt;
  private int CO;
  private int EK;
  private int FVT;
  private ColorStateList Hkc;
  private Spannable.Factory WoA;
  private TextUtils.TruncateAt WoB;
  private float WoH;
  private int Woy;
  private ColorStateList Yfd;
  private ColorStateList Yfe;
  private int Yff;
  private TextView.BufferType Yft;
  private CharSequence Yfu;
  private com.tencent.neattextview.textview.layout.c ZcY;
  private boolean ZdA;
  private c ZdB;
  private float[] ZdC;
  private com.tencent.neattextview.textview.layout.a ZdD;
  private TextView Zdu;
  private a Zdv;
  private c Zdw;
  private boolean Zdx;
  private NeatTextView.b Zdy;
  private float Zdz;
  private int lj;
  private CharSequence mText;
  private int sTC;
  public boolean sTK;
  private int uJ;
  private TextPaint wi;
  
  static
  {
    AppMethodBeat.i(39829);
    Zdr = new LruCache(800);
    Object localObject = new HandlerThread("PreMeasuredThread", -8);
    Zds = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = Zds.getLooper();
    if (localObject != null) {
      Zdt = new Handler((Looper)localObject);
    }
    AppMethodBeat.o(39829);
  }
  
  public NeatTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163503);
    this.Zdv = new a((byte)0);
    this.sTC = 2147483647;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.lj = 0;
    this.CO = 0;
    this.WoH = 0.0F;
    this.mText = "";
    this.Yft = TextView.BufferType.NORMAL;
    this.WoA = Spannable.Factory.getInstance();
    this.Zdx = true;
    this.FVT = 8388659;
    this.ZdA = true;
    d(paramContext, null, 0);
    AppMethodBeat.o(163503);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39785);
    this.Zdv = new a((byte)0);
    this.sTC = 2147483647;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.lj = 0;
    this.CO = 0;
    this.WoH = 0.0F;
    this.mText = "";
    this.Yft = TextView.BufferType.NORMAL;
    this.WoA = Spannable.Factory.getInstance();
    this.Zdx = true;
    this.FVT = 8388659;
    this.ZdA = true;
    d(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39785);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39786);
    this.Zdv = new a((byte)0);
    this.sTC = 2147483647;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.lj = 0;
    this.CO = 0;
    this.WoH = 0.0F;
    this.mText = "";
    this.Yft = TextView.BufferType.NORMAL;
    this.WoA = Spannable.Factory.getInstance();
    this.Zdx = true;
    this.FVT = 8388659;
    this.ZdA = true;
    d(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39786);
  }
  
  private void Ku()
  {
    AppMethodBeat.i(39817);
    this.ZcY = null;
    Handler localHandler;
    c localc;
    if (Zdt != null)
    {
      if ((this.mText != null) || (this.Yfu == null)) {
        break label80;
      }
      localHandler = Zdt;
      localc = new c(this.Yfu.toString(), this.wi);
      this.ZdB = localc;
      localHandler.post(localc);
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(39817);
      return;
      label80:
      if (this.mText == null) {
        break;
      }
      localHandler = Zdt;
      localc = new c(this.mText.toString(), this.wi);
      this.ZdB = localc;
      localHandler.post(localc);
    }
    AppMethodBeat.o(39817);
  }
  
  private String bib(String paramString)
  {
    AppMethodBeat.i(39816);
    paramString = paramString + "#" + this.wi.getTextSize();
    AppMethodBeat.o(39816);
    return paramString;
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(39787);
    this.Zdw = new c(getContext(), this);
    Object localObject = new AdaptedTextView(paramContext);
    ((AdaptedTextView)localObject).setClickable(true);
    ((AdaptedTextView)localObject).setFocusable(true);
    ((AdaptedTextView)localObject).ZdF = new NeatTextView.AdaptedTextView.a()
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
    this.Zdu = ((TextView)localObject);
    this.wi = getWrappedTextView().getPaint();
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
          break label1029;
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
        AppMethodBeat.o(39787);
      }
      int i1 = this.sTC;
      continue;
      if (i7 == a.a.NeatTextView_android_lines)
      {
        setLines(((TypedArray)localObject).getInt(i7, 2147483647));
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
        setMaxWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.uJ));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_lineSpacingExtra)
      {
        setSpacingAdd(((TypedArray)localObject).getDimensionPixelSize(i7, (int)this.WoH));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minWidth)
      {
        setMinWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.lj));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minHeight)
      {
        setMinHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.CO));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxHeight)
      {
        setMaxHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.EK));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxLines)
      {
        setMaxLines(((TypedArray)localObject).getInt(i7, 2147483647));
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
        i2 = ((TypedArray)localObject).getColor(i7, -7829368);
        paramAttributeSet = paramContext;
        i1 = n;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_textColorLink)
      {
        i3 = ((TypedArray)localObject).getColor(i7, -16776961);
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
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
          this.ZdA = ((TypedArray)localObject).getBoolean(i7, true);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          i5 = i;
          break label1159;
          label1029:
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
              aL(paramContext);
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
      label1159:
      paramInt += 1;
      paramContext = paramAttributeSet;
      n = i1;
      m = i2;
      k = i3;
      j = i4;
      i = i5;
    }
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
  
  private void ikD()
  {
    AppMethodBeat.i(39798);
    getWrappedTextView().setEllipsize(this.WoB);
    AppMethodBeat.o(39798);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(39822);
    if (paramFloat != this.wi.getTextSize())
    {
      this.wi.setTextSize(paramFloat);
      if (this.ZcY != null)
      {
        Ku();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39822);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(39818);
    int i = this.Hkc.getColorForState(getDrawableState(), 0);
    if (i != this.Woy) {
      this.Woy = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.Yfe != null)
      {
        k = this.Yfe.getColorForState(getDrawableState(), 0);
        i = j;
        if (k != this.wi.linkColor)
        {
          this.wi.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.Yfd != null)
      {
        k = this.Yfd.getColorForState(getDrawableState(), 0);
        j = i;
        if (k != this.Yff)
        {
          this.Yff = k;
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
  
  public final void a(TextUtils.TruncateAt paramTruncateAt, float paramFloat)
  {
    AppMethodBeat.i(39797);
    this.Zdz = paramFloat;
    this.WoB = paramTruncateAt;
    ikD();
    if (this.ZcY != null)
    {
      this.ZcY = null;
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(39797);
  }
  
  public void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    boolean bool2 = true;
    AppMethodBeat.i(39793);
    this.Yft = paramBufferType;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    boolean bool1;
    d locald;
    if (paramBufferType == TextView.BufferType.NORMAL)
    {
      paramCharSequence = TextUtils.stringOrSpannedString((CharSequence)localObject);
      this.mText = paramCharSequence;
      bool1 = bool2;
      if (hZE())
      {
        localObject = paramCharSequence.toString();
        locald = (d)Zdr.get(bib((String)localObject));
        if (locald != null) {
          break label253;
        }
        if (((String)localObject).matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$")) {
          break label248;
        }
        bool1 = true;
        label96:
        Zdr.put(bib((String)localObject), new d(bool1, null));
        label118:
        if (!bool1) {
          break label262;
        }
        bool1 = bool2;
      }
      label125:
      this.sTK = bool1;
      if (!this.sTK) {
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
        ((Spannable)this.mText).setSpan(this.Zdv, 0, paramCharSequence.length(), 18);
      }
      AppMethodBeat.o(39793);
      return;
      paramCharSequence = (CharSequence)localObject;
      if (paramBufferType != TextView.BufferType.SPANNABLE) {
        break;
      }
      paramCharSequence = this.WoA.newSpannable((CharSequence)localObject);
      break;
      label248:
      bool1 = false;
      break label96;
      label253:
      bool1 = locald.sTK;
      break label118;
      label262:
      bool1 = false;
      break label125;
      label267:
      Ku();
    }
  }
  
  public void aL(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39792);
    a(paramCharSequence, TextView.BufferType.NORMAL);
    AppMethodBeat.o(39792);
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.Yfd != null) {
      return this.Yff;
    }
    return this.Woy;
  }
  
  public final int getCurrentTextColor()
  {
    return this.Woy;
  }
  
  public float getExtraEllipsizeWidth()
  {
    return this.Zdz;
  }
  
  public CharSequence getHint()
  {
    return this.Yfu;
  }
  
  public float getHorizontalOffset()
  {
    AppMethodBeat.i(39795);
    if (((this.FVT & 0x7) != 3) && (this.ZcY != null))
    {
      f = (getMeasuredWidth() - this.ZcY.ikz()[0]) / 2.0F;
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
    if (this.ZdD != null)
    {
      localObject = this.ZdD;
      AppMethodBeat.o(39825);
      return localObject;
    }
    Object localObject = new com.tencent.neattextview.textview.layout.a()
    {
      public final int E(int paramAnonymousInt, float paramAnonymousFloat)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).E(paramAnonymousInt, paramAnonymousFloat);
        AppMethodBeat.o(39768);
        return paramAnonymousInt;
      }
      
      public final int Ji(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).Ji(paramAnonymousInt);
        AppMethodBeat.o(39766);
        return paramAnonymousInt;
      }
      
      public final int aAa(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aAa(paramAnonymousInt);
        AppMethodBeat.o(39776);
        return paramAnonymousInt;
      }
      
      public final int azR(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azR(paramAnonymousInt);
        AppMethodBeat.o(39763);
        return paramAnonymousInt;
      }
      
      public final int azS(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azS(paramAnonymousInt);
        AppMethodBeat.o(39764);
        return paramAnonymousInt;
      }
      
      public final int azT(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azT(paramAnonymousInt);
        AppMethodBeat.o(39765);
        return paramAnonymousInt;
      }
      
      public final float azU(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).azU(paramAnonymousInt);
        AppMethodBeat.o(39767);
        return f;
      }
      
      public final float azV(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).azV(paramAnonymousInt);
        AppMethodBeat.o(39769);
        return f;
      }
      
      public final int azW(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azW(paramAnonymousInt);
        AppMethodBeat.o(39770);
        return paramAnonymousInt;
      }
      
      public final int azX(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azX(paramAnonymousInt);
        AppMethodBeat.o(39771);
        return paramAnonymousInt;
      }
      
      public final float azY(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).azY(paramAnonymousInt);
        AppMethodBeat.o(39772);
        return f;
      }
      
      public final int azZ(int paramAnonymousInt)
      {
        AppMethodBeat.i(259899);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(259899);
            return -1;
          }
          paramAnonymousInt = localLayout.getEllipsisStart(paramAnonymousInt);
          AppMethodBeat.o(259899);
          return paramAnonymousInt;
        }
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(259899);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).azZ(paramAnonymousInt);
        AppMethodBeat.o(259899);
        return paramAnonymousInt;
      }
      
      public final int ikp()
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
        int i = NeatTextView.c(NeatTextView.this).Zcz.size();
        AppMethodBeat.o(39773);
        return i;
      }
      
      public final List<com.tencent.neattextview.textview.b.c> ikq()
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
        List localList = NeatTextView.c(NeatTextView.this).ikq();
        AppMethodBeat.o(39775);
        return localList;
      }
      
      public final int nE(int paramAnonymousInt1, int paramAnonymousInt2)
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
        paramAnonymousInt1 = NeatTextView.c(NeatTextView.this).nE(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(39774);
        return paramAnonymousInt1;
      }
    };
    this.ZdD = ((com.tencent.neattextview.textview.layout.a)localObject);
    AppMethodBeat.o(39825);
    return localObject;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(39801);
    if (this.ZcY != null)
    {
      int i = this.ZcY.Zcz.size();
      AppMethodBeat.o(39801);
      return i;
    }
    AppMethodBeat.o(39801);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(39826);
    int i = Math.round(this.wi.getFontMetricsInt(null) + this.WoH);
    AppMethodBeat.o(39826);
    return i;
  }
  
  public int getMaxHeight()
  {
    return this.EK;
  }
  
  public int getMaxLines()
  {
    return this.sTC;
  }
  
  public int getMaxWidth()
  {
    return this.uJ;
  }
  
  public NeatTextView.b getOnDoubleClickListener()
  {
    return this.Zdy;
  }
  
  public TextPaint getPaint()
  {
    return this.wi;
  }
  
  public int getTextGravity()
  {
    return this.FVT;
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
    if (((this.FVT & 0x70) != 48) && (this.ZcY != null))
    {
      f = (getMeasuredHeight() - this.ZcY.ikz()[1]) / 2.0F;
      AppMethodBeat.o(39794);
      return f;
    }
    float f = getPaddingTop();
    AppMethodBeat.o(39794);
    return f;
  }
  
  public TextView getWrappedTextView()
  {
    return this.Zdu;
  }
  
  public boolean hZE()
  {
    return this.Zdx;
  }
  
  public final boolean ikB()
  {
    return this.sTK;
  }
  
  public final CharSequence ikC()
  {
    if (this.mText == null) {
      return "";
    }
    return this.mText;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(39823);
    super.invalidate();
    AppMethodBeat.o(39823);
  }
  
  public final com.tencent.neattextview.textview.layout.a nH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163504);
    NeatLayout localNeatLayout;
    if (!TextUtils.isEmpty(this.mText))
    {
      localNeatLayout = new NeatLayout(this.mText, null);
      localNeatLayout.a(getPaint(), paramInt1, paramInt2, getPaddingLeft(), getPaddingTop(), this.WoH, this.sTC, this.WoB, this.Zdz, this.ZdA, this.FVT);
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
    int j = this.Woy;
    int i = j;
    if (!TextUtils.isEmpty(this.Yfu))
    {
      i = j;
      if (TextUtils.isEmpty(this.mText))
      {
        i = j;
        if (this.Yfd != null) {
          i = this.Yff;
        }
      }
    }
    this.wi.setColor(i);
    this.wi.drawableState = getDrawableState();
    if (this.sTK)
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
    if (this.ZcY != null)
    {
      if (this.ZcY.arx() != null) {
        this.ZcY.arx().set(this.wi);
      }
      this.ZcY.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
    }
    AppMethodBeat.o(39791);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39789);
    if (this.sTK)
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
    if ((this.uJ > 0) && (this.uJ < paramInt1)) {
      paramInt1 = this.uJ;
    }
    for (;;)
    {
      if ((this.EK > 0) && (this.EK < paramInt2)) {
        paramInt2 = this.EK;
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
          localObject1 = this.Yfu;
        }
        Object localObject2;
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (d)Zdr.get(bib(((CharSequence)localObject1).toString()));
            if (localObject2 != null)
            {
              localObject2 = ((d)localObject2).ZdH;
              i = 0;
              this.ZcY = new NeatLayout((CharSequence)localObject1, (float[])localObject2);
              if (this.ZdC != null) {
                break label575;
              }
              this.ZcY.a(getPaint(), f1, f2, getPaddingLeft(), getPaddingTop(), this.WoH, this.sTC, this.WoB, this.Zdz, this.ZdA, this.FVT);
              label331:
              if (i != 0) {
                Zdr.put(bib(this.ZcY.iky()), new d(this.sTK, this.ZcY.ikr()));
              }
              this.Zdv.ZdG = new WeakReference(this.ZcY);
              localObject1 = this.ZcY.ikz();
              if (m != 1073741824) {
                paramInt1 = (int)Math.min(localObject1[0] + getPaddingLeft() + getPaddingRight(), this.uJ);
              }
              if (k != 1073741824) {
                paramInt2 = (int)Math.min(localObject1[1] + getPaddingTop() + getPaddingBottom(), this.EK);
              }
              setMeasuredDimension(Math.max(paramInt1, this.lj), Math.max(paramInt2, this.CO));
              AppMethodBeat.o(39789);
              return;
              localObject1 = this.mText;
            }
            else
            {
              if (this.ZdB == null) {
                break label630;
              }
              localObject2 = this.ZdB;
              if ((this.wi.getTextSize() == ((c)localObject2).kgq.getTextSize()) && (((c)localObject2).lwF)) {
                localObject2 = ((c)localObject2).ZdH;
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
          label575:
          this.ZcY.a(getPaint(), this.ZdC, f1, f2, getPaddingLeft(), getPaddingTop(), this.WoH, this.sTC, this.WoB, this.Zdz, this.ZdA, this.FVT);
          break label331;
          label630:
          localObject2 = null;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39788);
    if ((this.Zdw != null) && (this.Zdw.onTouch(this, paramMotionEvent)))
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
    if (this.WoB != paramTruncateAt)
    {
      this.WoB = paramTruncateAt;
      ikD();
      if (this.ZcY != null)
      {
        this.ZcY = null;
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39796);
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(39805);
    this.EK = paramInt;
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
    this.Yfu = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.Yfu);
    if (TextUtils.isEmpty(this.mText)) {
      Ku();
    }
    AppMethodBeat.o(39803);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(39815);
    this.Yfd = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(39815);
  }
  
  public void setLineEndExtraWidths(float[] paramArrayOfFloat)
  {
    this.ZdC = paramArrayOfFloat;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(39812);
    this.sTC = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39812);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(39814);
    this.Yfe = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(39814);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(39807);
    this.EK = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39807);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(39811);
    this.sTC = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39811);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(39808);
    this.uJ = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39808);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(39806);
    this.CO = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39806);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(39810);
    this.lj = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39810);
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.Zdx = paramBoolean;
  }
  
  public void setOnDoubleClickListener(NeatTextView.b paramb)
  {
    this.Zdy = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39800);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.ZcY = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(39800);
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.ZdA = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    AppMethodBeat.i(39809);
    this.WoH = paramInt;
    getWrappedTextView().setLineSpacing(paramInt, 1.0F);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39809);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39813);
    this.Hkc = ColorStateList.valueOf(paramInt);
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
      this.FVT = i;
      if (i != this.FVT) {
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
    this.uJ = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39804);
  }
  
  static class AdaptedTextView
    extends AppCompatTextView
  {
    a ZdF;
    
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
      if (this.ZdF != null) {
        this.ZdF.invalidate();
      }
      AppMethodBeat.o(39777);
    }
    
    public void postInvalidate()
    {
      AppMethodBeat.i(39778);
      super.postInvalidate();
      if (this.ZdF != null) {
        this.ZdF.postInvalidate();
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
    WeakReference<com.tencent.neattextview.textview.layout.c> ZdG;
    
    private a() {}
    
    private void l(Spannable paramSpannable)
    {
      AppMethodBeat.i(39782);
      if (NeatTextView.a(NeatTextView.this))
      {
        NeatTextView.this.postInvalidate();
        AppMethodBeat.o(39782);
        return;
      }
      if (this.ZdG == null)
      {
        AppMethodBeat.o(39782);
        return;
      }
      com.tencent.neattextview.textview.layout.c localc = (com.tencent.neattextview.textview.layout.c)this.ZdG.get();
      if ((localc != null) && (localc.getText() == paramSpannable))
      {
        localc.aV(paramSpannable);
        NeatTextView.this.postInvalidate();
      }
      AppMethodBeat.o(39782);
    }
    
    public final void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(39779);
      l(paramSpannable);
      AppMethodBeat.o(39779);
    }
    
    public final void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(39781);
      l(paramSpannable);
      AppMethodBeat.o(39781);
    }
    
    public final void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(39780);
      l(paramSpannable);
      AppMethodBeat.o(39780);
    }
  }
  
  static final class c
    implements Runnable
  {
    float[] ZdH;
    TextPaint kgq;
    volatile boolean lwF;
    String text;
    
    c(String paramString, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(39783);
      this.kgq = new TextPaint();
      this.lwF = false;
      this.kgq.set(paramTextPaint);
      this.text = paramString;
      AppMethodBeat.o(39783);
    }
    
    public final void run()
    {
      AppMethodBeat.i(39784);
      this.ZdH = new float[this.text.length()];
      this.kgq.getTextWidths(this.text, this.ZdH);
      this.lwF = true;
      AppMethodBeat.o(39784);
    }
  }
  
  static final class d
  {
    public float[] ZdH;
    public boolean sTK;
    
    public d(boolean paramBoolean, float[] paramArrayOfFloat)
    {
      this.sTK = paramBoolean;
      this.ZdH = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.NeatTextView
 * JD-Core Version:    0.7.0.1
 */