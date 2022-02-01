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
  private static final LruCache<String, d> ahbV;
  private static final HandlerThread ahbW;
  private static Handler ahbX;
  private int LQR;
  private ColorStateList NhP;
  private int adVN;
  private Spannable.Factory adVP;
  private TextUtils.TruncateAt adVQ;
  private float adVU;
  private float adVV;
  private ColorStateList afXd;
  private ColorStateList afXe;
  private int afXf;
  private TextView.BufferType afXt;
  private CharSequence afXu;
  private com.tencent.neattextview.textview.layout.c ahbC;
  private TextView ahbY;
  private a ahbZ;
  private c ahca;
  private boolean ahcb;
  private b ahcc;
  private float ahcd;
  private boolean ahce;
  private c ahcf;
  private float[] ahcg;
  private com.tencent.neattextview.textview.layout.a ahch;
  private int biW;
  private int bkR;
  private CharSequence mText;
  private int mf;
  private int vF;
  private int vYT;
  public boolean vZb;
  private TextPaint xe;
  
  static
  {
    AppMethodBeat.i(39829);
    ahbV = new LruCache(800);
    Object localObject = new HandlerThread("PreMeasuredThread", -8);
    ahbW = (HandlerThread)localObject;
    ((HandlerThread)localObject).start();
    localObject = ahbW.getLooper();
    if (localObject != null) {
      ahbX = new Handler((Looper)localObject);
    }
    AppMethodBeat.o(39829);
  }
  
  public NeatTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163503);
    this.ahbZ = new a((byte)0);
    this.vYT = 2147483647;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.mf = 0;
    this.biW = 0;
    this.adVV = 0.0F;
    this.adVU = 1.0F;
    this.mText = "";
    this.afXt = TextView.BufferType.NORMAL;
    this.adVP = Spannable.Factory.getInstance();
    this.ahcb = true;
    this.LQR = 8388659;
    this.ahce = true;
    d(paramContext, null, 0);
    AppMethodBeat.o(163503);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39785);
    this.ahbZ = new a((byte)0);
    this.vYT = 2147483647;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.mf = 0;
    this.biW = 0;
    this.adVV = 0.0F;
    this.adVU = 1.0F;
    this.mText = "";
    this.afXt = TextView.BufferType.NORMAL;
    this.adVP = Spannable.Factory.getInstance();
    this.ahcb = true;
    this.LQR = 8388659;
    this.ahce = true;
    d(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(39785);
  }
  
  public NeatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39786);
    this.ahbZ = new a((byte)0);
    this.vYT = 2147483647;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.mf = 0;
    this.biW = 0;
    this.adVV = 0.0F;
    this.adVU = 1.0F;
    this.mText = "";
    this.afXt = TextView.BufferType.NORMAL;
    this.adVP = Spannable.Factory.getInstance();
    this.ahcb = true;
    this.LQR = 8388659;
    this.ahce = true;
    d(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(39786);
  }
  
  private void akv()
  {
    AppMethodBeat.i(39817);
    this.ahbC = null;
    Handler localHandler;
    c localc;
    if (ahbX != null)
    {
      if ((this.mText != null) || (this.afXu == null)) {
        break label80;
      }
      localHandler = ahbX;
      localc = new c(this.afXu.toString(), this.xe);
      this.ahcf = localc;
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
      localHandler = ahbX;
      localc = new c(this.mText.toString(), this.xe);
      this.ahcf = localc;
      localHandler.post(localc);
    }
    AppMethodBeat.o(39817);
  }
  
  private String bhK(String paramString)
  {
    AppMethodBeat.i(39816);
    paramString = paramString + "#" + this.xe.getTextSize();
    AppMethodBeat.o(39816);
    return paramString;
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(39787);
    this.ahca = new c(getContext(), this);
    Object localObject = new AdaptedTextView(paramContext);
    ((AdaptedTextView)localObject).setClickable(true);
    ((AdaptedTextView)localObject).setFocusable(true);
    ((AdaptedTextView)localObject).ahcj = new NeatTextView.AdaptedTextView.a()
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
    this.ahbY = ((TextView)localObject);
    this.xe = getWrappedTextView().getPaint();
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
          break label1079;
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
      int i1 = this.vYT;
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
        setMaxWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.vF));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_lineSpacingExtra)
      {
        setSpacingAdd(((TypedArray)localObject).getDimensionPixelSize(i7, (int)this.adVV));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_lineSpacingMultiplier)
      {
        br(((TypedArray)localObject).getDimensionPixelSize(i7, 1), this.adVV);
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minWidth)
      {
        setMinWidth(((TypedArray)localObject).getDimensionPixelSize(i7, this.mf));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_minHeight)
      {
        setMinHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.biW));
        paramAttributeSet = paramContext;
        i1 = n;
        i2 = m;
        i3 = k;
        i4 = j;
        i5 = i;
      }
      else if (i7 == a.a.NeatTextView_android_maxHeight)
      {
        setMaxHeight(((TypedArray)localObject).getDimensionPixelSize(i7, this.bkR));
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
          this.ahce = ((TypedArray)localObject).getBoolean(i7, true);
          paramAttributeSet = paramContext;
          i1 = n;
          i2 = m;
          i3 = k;
          i4 = j;
          i5 = i;
          break label1207;
          label1079:
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
              aZ(paramContext);
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
      label1207:
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
  
  private void jQU()
  {
    AppMethodBeat.i(39798);
    getWrappedTextView().setEllipsize(this.adVQ);
    AppMethodBeat.o(39798);
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(39822);
    if (paramFloat != this.xe.getTextSize())
    {
      this.xe.setTextSize(paramFloat);
      if (this.ahbC != null)
      {
        akv();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39822);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(39818);
    int i = this.NhP.getColorForState(getDrawableState(), 0);
    if (i != this.adVN) {
      this.adVN = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.afXe != null)
      {
        k = this.afXe.getColorForState(getDrawableState(), 0);
        i = j;
        if (k != this.xe.linkColor)
        {
          this.xe.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.afXd != null)
      {
        k = this.afXd.getColorForState(getDrawableState(), 0);
        j = i;
        if (k != this.afXf)
        {
          this.afXf = k;
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
    this.ahcd = paramFloat;
    this.adVQ = paramTruncateAt;
    jQU();
    if (this.ahbC != null)
    {
      this.ahbC = null;
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(39797);
  }
  
  public void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    boolean bool2 = true;
    AppMethodBeat.i(39793);
    this.afXt = paramBufferType;
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
      if (jEM())
      {
        localObject = paramCharSequence.toString();
        locald = (d)ahbV.get(bhK((String)localObject));
        if (locald != null) {
          break label253;
        }
        if (((String)localObject).matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$")) {
          break label248;
        }
        bool1 = true;
        label96:
        ahbV.put(bhK((String)localObject), new d(bool1, null));
        label118:
        if (!bool1) {
          break label262;
        }
        bool1 = bool2;
      }
      label125:
      this.vZb = bool1;
      if (!this.vZb) {
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
        ((Spannable)this.mText).setSpan(this.ahbZ, 0, paramCharSequence.length(), 18);
      }
      AppMethodBeat.o(39793);
      return;
      paramCharSequence = (CharSequence)localObject;
      if (paramBufferType != TextView.BufferType.SPANNABLE) {
        break;
      }
      paramCharSequence = this.adVP.newSpannable((CharSequence)localObject);
      break;
      label248:
      bool1 = false;
      break label96;
      label253:
      bool1 = locald.vZb;
      break label118;
      label262:
      bool1 = false;
      break label125;
      label267:
      akv();
    }
  }
  
  public void aZ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39792);
    a(paramCharSequence, TextView.BufferType.NORMAL);
    AppMethodBeat.o(39792);
  }
  
  public final void br(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(210465);
    this.adVV = paramFloat1;
    this.adVU = paramFloat2;
    getWrappedTextView().setLineSpacing(paramFloat1, paramFloat2);
    requestLayout();
    invalidate();
    AppMethodBeat.o(210465);
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.afXd != null) {
      return this.afXf;
    }
    return this.adVN;
  }
  
  public final int getCurrentTextColor()
  {
    return this.adVN;
  }
  
  public float getExtraEllipsizeWidth()
  {
    return this.ahcd;
  }
  
  public CharSequence getHint()
  {
    return this.afXu;
  }
  
  public float getHorizontalOffset()
  {
    AppMethodBeat.i(39795);
    if (((this.LQR & 0x7) != 3) && (this.ahbC != null))
    {
      f = (getMeasuredWidth() - this.ahbC.jQR()[0]) / 2.0F;
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
    if (this.ahch != null)
    {
      localObject = this.ahch;
      AppMethodBeat.o(39825);
      return localObject;
    }
    Object localObject = new com.tencent.neattextview.textview.layout.a()
    {
      public final int H(int paramAnonymousInt, float paramAnonymousFloat)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).H(paramAnonymousInt, paramAnonymousFloat);
        AppMethodBeat.o(39768);
        return paramAnonymousInt;
      }
      
      public final int aGH(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aGH(paramAnonymousInt);
        AppMethodBeat.o(39763);
        return paramAnonymousInt;
      }
      
      public final int aGI(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aGI(paramAnonymousInt);
        AppMethodBeat.o(39764);
        return paramAnonymousInt;
      }
      
      public final int aGJ(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aGJ(paramAnonymousInt);
        AppMethodBeat.o(39765);
        return paramAnonymousInt;
      }
      
      public final float aGK(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).aGK(paramAnonymousInt);
        AppMethodBeat.o(39769);
        return f;
      }
      
      public final float aGL(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).aGL(paramAnonymousInt);
        AppMethodBeat.o(39772);
        return f;
      }
      
      public final int aGM(int paramAnonymousInt)
      {
        AppMethodBeat.i(210458);
        if (NeatTextView.a(NeatTextView.this))
        {
          Layout localLayout = NeatTextView.b(NeatTextView.this);
          if (localLayout == null)
          {
            AppMethodBeat.o(210458);
            return -1;
          }
          paramAnonymousInt = localLayout.getEllipsisStart(paramAnonymousInt);
          AppMethodBeat.o(210458);
          return paramAnonymousInt;
        }
        if (NeatTextView.c(NeatTextView.this) == null)
        {
          AppMethodBeat.o(210458);
          return -1;
        }
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aGM(paramAnonymousInt);
        AppMethodBeat.o(210458);
        return paramAnonymousInt;
      }
      
      public final int aGN(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).aGN(paramAnonymousInt);
        AppMethodBeat.o(39776);
        return paramAnonymousInt;
      }
      
      public final int di(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).di(paramAnonymousInt);
        AppMethodBeat.o(39766);
        return paramAnonymousInt;
      }
      
      public final int dk(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).dk(paramAnonymousInt);
        AppMethodBeat.o(39770);
        return paramAnonymousInt;
      }
      
      public final int du(int paramAnonymousInt)
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
        paramAnonymousInt = NeatTextView.c(NeatTextView.this).du(paramAnonymousInt);
        AppMethodBeat.o(39771);
        return paramAnonymousInt;
      }
      
      public final float dv(int paramAnonymousInt)
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
        float f = NeatTextView.c(NeatTextView.this).dv(paramAnonymousInt);
        AppMethodBeat.o(39767);
        return f;
      }
      
      public final int jQH()
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
        int i = NeatTextView.c(NeatTextView.this).ahbd.size();
        AppMethodBeat.o(39773);
        return i;
      }
      
      public final List<com.tencent.neattextview.textview.b.c> jQI()
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
        List localList = NeatTextView.c(NeatTextView.this).jQI();
        AppMethodBeat.o(39775);
        return localList;
      }
      
      public final int pB(int paramAnonymousInt1, int paramAnonymousInt2)
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
        paramAnonymousInt1 = NeatTextView.c(NeatTextView.this).pB(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(39774);
        return paramAnonymousInt1;
      }
    };
    this.ahch = ((com.tencent.neattextview.textview.layout.a)localObject);
    AppMethodBeat.o(39825);
    return localObject;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(39801);
    if (this.ahbC != null)
    {
      int i = this.ahbC.ahbd.size();
      AppMethodBeat.o(39801);
      return i;
    }
    AppMethodBeat.o(39801);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(39826);
    int i = Math.round(this.xe.getFontMetricsInt(null) * this.adVU + this.adVV);
    AppMethodBeat.o(39826);
    return i;
  }
  
  public float getLineSpacingExtra()
  {
    return this.adVV;
  }
  
  public float getLineSpacingMultiplier()
  {
    return this.adVU;
  }
  
  public int getMaxHeight()
  {
    return this.bkR;
  }
  
  public int getMaxLines()
  {
    return this.vYT;
  }
  
  public int getMaxWidth()
  {
    return this.vF;
  }
  
  public b getOnDoubleClickListener()
  {
    return this.ahcc;
  }
  
  public TextPaint getPaint()
  {
    return this.xe;
  }
  
  public int getTextGravity()
  {
    return this.LQR;
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
    if (((this.LQR & 0x70) != 48) && (this.ahbC != null))
    {
      f = (getMeasuredHeight() - this.ahbC.jQR()[1]) / 2.0F;
      AppMethodBeat.o(39794);
      return f;
    }
    float f = getPaddingTop();
    AppMethodBeat.o(39794);
    return f;
  }
  
  public TextView getWrappedTextView()
  {
    return this.ahbY;
  }
  
  public void invalidate()
  {
    AppMethodBeat.i(39823);
    super.invalidate();
    AppMethodBeat.o(39823);
  }
  
  public boolean jEM()
  {
    return this.ahcb;
  }
  
  public final CharSequence jPy()
  {
    if (this.mText == null) {
      return "";
    }
    return this.mText;
  }
  
  public final boolean jQT()
  {
    return this.vZb;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39791);
    super.onDraw(paramCanvas);
    int j = this.adVN;
    int i = j;
    if (!TextUtils.isEmpty(this.afXu))
    {
      i = j;
      if (TextUtils.isEmpty(this.mText))
      {
        i = j;
        if (this.afXd != null) {
          i = this.afXf;
        }
      }
    }
    this.xe.setColor(i);
    this.xe.drawableState = getDrawableState();
    if (this.vZb)
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
    if (this.ahbC != null)
    {
      if (this.ahbC.aLt() != null) {
        this.ahbC.aLt().set(this.xe);
      }
      this.ahbC.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
    }
    AppMethodBeat.o(39791);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39789);
    if (this.vZb)
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
    if ((this.vF > 0) && (this.vF < paramInt1)) {
      paramInt1 = this.vF;
    }
    for (;;)
    {
      if ((this.bkR > 0) && (this.bkR < paramInt2)) {
        paramInt2 = this.bkR;
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
          localObject1 = this.afXu;
        }
        Object localObject2;
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = (d)ahbV.get(bhK(((CharSequence)localObject1).toString()));
            if (localObject2 != null)
            {
              localObject2 = ((d)localObject2).ahcl;
              i = 0;
              this.ahbC = new NeatLayout((CharSequence)localObject1, (float[])localObject2);
              if (this.ahcg != null) {
                break label576;
              }
              this.ahbC.a(getPaint(), f1, f2, getPaddingLeft(), getPaddingTop(), getLineHeight(), this.vYT, this.adVQ, this.ahcd, this.ahce, this.LQR);
              label332:
              if (i != 0) {
                ahbV.put(bhK(this.ahbC.jQQ()), new d(this.vZb, this.ahbC.jQJ()));
              }
              this.ahbZ.ahck = new WeakReference(this.ahbC);
              localObject1 = this.ahbC.jQR();
              if (m != 1073741824) {
                paramInt1 = (int)Math.min(localObject1[0] + getPaddingLeft() + getPaddingRight(), this.vF);
              }
              if (k != 1073741824) {
                paramInt2 = (int)Math.min(localObject1[1] + getPaddingTop() + getPaddingBottom(), this.bkR);
              }
              setMeasuredDimension(Math.max(paramInt1, this.mf), Math.max(paramInt2, this.biW));
              AppMethodBeat.o(39789);
              return;
              localObject1 = this.mText;
            }
            else
            {
              if (this.ahcf == null) {
                break label632;
              }
              localObject2 = this.ahcf;
              if ((this.xe.getTextSize() == ((c)localObject2).bbb.getTextSize()) && (((c)localObject2).ooe)) {
                localObject2 = ((c)localObject2).ahcl;
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
          label576:
          this.ahbC.a(getPaint(), this.ahcg, f1, f2, getPaddingLeft(), getPaddingTop(), getLineHeight(), this.vYT, this.adVQ, this.ahcd, this.ahce, this.LQR);
          break label332;
          label632:
          localObject2 = null;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39788);
    if ((this.ahca != null) && (this.ahca.onTouch(this, paramMotionEvent)))
    {
      AppMethodBeat.o(39788);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(39788);
    return bool;
  }
  
  public final com.tencent.neattextview.textview.layout.a pE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163504);
    NeatLayout localNeatLayout;
    if (!TextUtils.isEmpty(this.mText))
    {
      localNeatLayout = new NeatLayout(this.mText, null);
      localNeatLayout.a(getPaint(), paramInt1, paramInt2, getPaddingLeft(), getPaddingTop(), getLineHeight(), this.vYT, this.adVQ, this.ahcd, this.ahce, this.LQR);
    }
    for (;;)
    {
      AppMethodBeat.o(163504);
      return localNeatLayout;
      localNeatLayout = null;
    }
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
    if (this.adVQ != paramTruncateAt)
    {
      this.adVQ = paramTruncateAt;
      jQU();
      if (this.ahbC != null)
      {
        this.ahbC = null;
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(39796);
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(39805);
    this.bkR = paramInt;
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
    this.afXu = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.afXu);
    if (TextUtils.isEmpty(this.mText)) {
      akv();
    }
    AppMethodBeat.o(39803);
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(39815);
    this.afXd = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    updateTextColors();
    AppMethodBeat.o(39815);
  }
  
  public void setLineEndExtraWidths(float[] paramArrayOfFloat)
  {
    this.ahcg = paramArrayOfFloat;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(39812);
    this.vYT = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39812);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(39814);
    this.afXe = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(39814);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(39807);
    this.bkR = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39807);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(39811);
    this.vYT = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39811);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(39808);
    this.vF = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39808);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(39806);
    this.biW = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39806);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(39810);
    this.mf = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39810);
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.ahcb = paramBoolean;
  }
  
  public void setOnDoubleClickListener(b paramb)
  {
    this.ahcc = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39800);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.ahbC = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(39800);
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.ahce = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    AppMethodBeat.i(39809);
    this.adVV = paramInt;
    getWrappedTextView().setLineSpacing(paramInt, this.adVU);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39809);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(39813);
    this.NhP = ColorStateList.valueOf(paramInt);
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
      this.LQR = i;
      if (i != this.LQR) {
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
    this.vF = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
    AppMethodBeat.o(39804);
  }
  
  static class AdaptedTextView
    extends AppCompatTextView
  {
    a ahcj;
    
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
      if (this.ahcj != null) {
        this.ahcj.invalidate();
      }
      AppMethodBeat.o(39777);
    }
    
    public void postInvalidate()
    {
      AppMethodBeat.i(39778);
      super.postInvalidate();
      if (this.ahcj != null) {
        this.ahcj.postInvalidate();
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
    WeakReference<com.tencent.neattextview.textview.layout.c> ahck;
    
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
      if (this.ahck == null)
      {
        AppMethodBeat.o(39782);
        return;
      }
      com.tencent.neattextview.textview.layout.c localc = (com.tencent.neattextview.textview.layout.c)this.ahck.get();
      if ((localc != null) && (localc.getText() == paramSpannable))
      {
        localc.bj(paramSpannable);
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
  
  public static abstract interface b
  {
    public abstract boolean lA(View paramView);
  }
  
  static final class c
    implements Runnable
  {
    float[] ahcl;
    TextPaint bbb;
    volatile boolean ooe;
    String text;
    
    c(String paramString, TextPaint paramTextPaint)
    {
      AppMethodBeat.i(39783);
      this.bbb = new TextPaint();
      this.ooe = false;
      this.bbb.set(paramTextPaint);
      this.text = paramString;
      AppMethodBeat.o(39783);
    }
    
    public final void run()
    {
      AppMethodBeat.i(39784);
      this.ahcl = new float[this.text.length()];
      this.bbb.getTextWidths(this.text, this.ahcl);
      this.ooe = true;
      AppMethodBeat.o(39784);
    }
  }
  
  static final class d
  {
    public float[] ahcl;
    public boolean vZb;
    
    public d(boolean paramBoolean, float[] paramArrayOfFloat)
    {
      this.vZb = paramBoolean;
      this.ahcl = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.neattextview.textview.view.NeatTextView
 * JD-Core Version:    0.7.0.1
 */