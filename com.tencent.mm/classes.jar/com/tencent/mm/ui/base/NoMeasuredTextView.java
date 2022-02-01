package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics JKY;
  private String JDl;
  private int JDm;
  private int JDn;
  private boolean JHW;
  private int JKA;
  private int JKB;
  private int JKC;
  private int JKD;
  private boolean JKE;
  private boolean JKF;
  private int JKG;
  private boolean JKH;
  private BoringLayout JKI;
  private boolean JKJ;
  private int JKK;
  private Paint.FontMetricsInt JKL;
  private boolean JKM;
  private boolean JKN;
  private b JKO;
  private boolean JKP;
  public boolean JKQ;
  private boolean JKR;
  private boolean JKS;
  private int JKT;
  private int JKU;
  private int JKV;
  private int JKW;
  private NoMeasuredTextView.c JKX;
  private int JKq;
  private Editable.Factory JKr;
  private Spannable.Factory JKs;
  private TextUtils.TruncateAt JKt;
  private CharSequence JKu;
  private NoMeasuredTextView.a JKv;
  private KeyListener JKw;
  private Layout JKx;
  private float JKy;
  private float JKz;
  private int Kk;
  private TextPaint ayp;
  private int mMaxWidth;
  private int mMinWidth;
  private CharSequence mText;
  private ColorStateList xpx;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    JKY = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.JKr = Editable.Factory.getInstance();
    this.JKs = Spannable.Factory.getInstance();
    this.JKt = null;
    this.JKv = NoMeasuredTextView.a.JKZ;
    this.Kk = 51;
    this.JKy = 1.0F;
    this.JKz = 0.0F;
    this.JKA = 2147483647;
    this.JKB = 1;
    this.JKC = 0;
    this.JKD = 1;
    this.mMaxWidth = 2147483647;
    this.JKE = false;
    this.mMinWidth = 0;
    this.JKF = false;
    this.JKG = -1;
    this.JKH = true;
    this.JKJ = false;
    this.JKM = false;
    this.JKN = false;
    this.JKP = false;
    this.JKQ = false;
    this.JKR = false;
    this.JKS = false;
    this.JKT = -1;
    this.JKU = -1;
    this.JKV = -1;
    this.JKW = -1;
    this.mText = "";
    this.JKu = "";
    this.ayp = new TextPaint(1);
    this.ayp.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.JKL = this.ayp.getFontMetricsInt();
    fDu();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.JKO;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).JLq != 0) {
          break label58;
        }
        this.JKO = null;
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142378);
      return;
      i = 0;
      break;
      label58:
      if (((b)localObject2).JLg != null) {
        ((b)localObject2).JLg.setCallback(null);
      }
      ((b)localObject2).JLg = null;
      if (((b)localObject2).JLe != null) {
        ((b)localObject2).JLe.setCallback(null);
      }
      ((b)localObject2).JLe = null;
      if (((b)localObject2).JLh != null) {
        ((b)localObject2).JLh.setCallback(null);
      }
      ((b)localObject2).JLh = null;
      if (((b)localObject2).JLf != null) {
        ((b)localObject2).JLf.setCallback(null);
      }
      ((b)localObject2).JLf = null;
      ((b)localObject2).JLo = 0;
      ((b)localObject2).JLk = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.JLp = 0;
      paramDrawable1.JLl = 0;
      label175:
      paramDrawable1.JLm = 0;
      paramDrawable1.JLi = 0;
      paramDrawable1.JLn = 0;
      paramDrawable1.JLj = 0;
    }
    label198:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.JKO = ((b)localObject1);
    }
    if ((((b)localObject1).JLg != paramDrawable1) && (((b)localObject1).JLg != null)) {
      ((b)localObject1).JLg.setCallback(null);
    }
    ((b)localObject1).JLg = paramDrawable1;
    if ((((b)localObject1).JLe != null) && (((b)localObject1).JLe != null)) {
      ((b)localObject1).JLe.setCallback(null);
    }
    ((b)localObject1).JLe = null;
    if ((((b)localObject1).JLh != paramDrawable2) && (((b)localObject1).JLh != null)) {
      ((b)localObject1).JLh.setCallback(null);
    }
    ((b)localObject1).JLh = paramDrawable2;
    if ((((b)localObject1).JLf != null) && (((b)localObject1).JLf != null)) {
      ((b)localObject1).JLf.setCallback(null);
    }
    ((b)localObject1).JLf = null;
    localObject2 = ((b)localObject1).JLd;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).JLk = ((Rect)localObject2).width();
      ((b)localObject1).JLo = ((Rect)localObject2).height();
    }
    for (;;)
    {
      paramDrawable1 = (Drawable)localObject1;
      if (paramDrawable2 == null) {
        break;
      }
      paramDrawable2.setState(arrayOfInt);
      paramDrawable2.copyBounds((Rect)localObject2);
      paramDrawable2.setCallback(this);
      ((b)localObject1).JLl = ((Rect)localObject2).width();
      ((b)localObject1).JLp = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label175;
      ((b)localObject1).JLo = 0;
      ((b)localObject1).JLk = 0;
    }
  }
  
  private void a(CharSequence paramCharSequence, NoMeasuredTextView.a parama)
  {
    AppMethodBeat.i(142424);
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      if (paramCharSequence.equals(this.mText))
      {
        AppMethodBeat.o(142424);
        return;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (getMeasuredWidth() > 0)
      {
        localCharSequence = paramCharSequence;
        if (this.JKX != null)
        {
          localCharSequence = paramCharSequence;
          if (!bu.isNullOrNil(this.JDl))
          {
            localCharSequence = this.JKX.a(this, paramCharSequence, this.JDl, this.JDm, this.JDn);
            this.JDl = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.JKJ = false;
        if ((parama != NoMeasuredTextView.a.JLb) && (this.JKw == null)) {
          break label241;
        }
        paramCharSequence = this.JKr.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.JKN)
        {
          if (!this.JKE) {
            break label264;
          }
          i = this.mMaxWidth;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.mMaxWidth, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.ayp, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.JKv = parama;
        this.mText = localCharSequence;
        this.JKu = localCharSequence;
        acR(j);
        AppMethodBeat.o(142424);
        return;
        this.JKJ = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.JLa) {
          break label131;
        }
        paramCharSequence = this.JKs.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.ayp, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.JKM = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void acR(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.JKJ)
    {
      fDu();
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    if (getWidth() == 0)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    if (this.JKx == null)
    {
      fDt();
      if (this.JKx.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.JKx.getHeight();
    int j = this.JKx.getWidth();
    jQ(j, j - paramInt);
    if (this.JKt != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.JKx.getHeight();
      if ((paramInt == i) && (paramInt == getHeight()))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
    }
    requestLayout();
    invalidate();
    AppMethodBeat.o(142439);
  }
  
  private void fDs()
  {
    if (((this.JKx instanceof BoringLayout)) && (this.JKI == null)) {
      this.JKI = ((BoringLayout)this.JKx);
    }
    this.JKx = null;
  }
  
  private void fDt()
  {
    AppMethodBeat.i(142433);
    if (this.JKE) {}
    for (int i = this.mMaxWidth - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      jQ(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void fDu()
  {
    AppMethodBeat.i(142438);
    if (this.JKK == 0) {
      this.JKK = ((int)(Math.ceil(this.JKL.descent - this.JKL.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    AppMethodBeat.i(224383);
    int j = 0;
    int k = this.Kk & 0x70;
    Layout localLayout = this.JKx;
    int i = j;
    int m;
    int n;
    if (k != 80)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m) {
        if (k != 48) {
          break label82;
        }
      }
    }
    label82:
    for (i = m - n;; i = m - n >> 1)
    {
      AppMethodBeat.o(224383);
      return i;
    }
  }
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(142437);
    Layout localLayout = this.JKx;
    if (localLayout == null)
    {
      AppMethodBeat.o(142437);
      return 0;
    }
    int j = localLayout.getLineCount();
    int i = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + i;
    i = localLayout.getLineTop(j) + m;
    int k;
    if (this.JKB == 1)
    {
      k = j;
      if (j > this.JKA)
      {
        i = localLayout.getLineTop(this.JKA) + localLayout.getBottomPadding() + m;
        k = this.JKA;
      }
      if (this.JKD != 1) {
        break label161;
      }
      j = i;
      if (k < this.JKC) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.JKC - k) * j;; j = Math.max(i, this.JKC))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.JKA);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.Kk & 0x70;
    Layout localLayout = this.JKx;
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m) {
        if (k != 80) {
          break label82;
        }
      }
    }
    label82:
    for (i = m - n;; i = m - n >> 1)
    {
      AppMethodBeat.o(142427);
      return i;
    }
  }
  
  private void jQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.Kk & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.JKt == null) || (this.JKw != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.JKx = new StaticLayout(this.JKu, 0, this.JKu.length(), this.ayp, paramInt1, localAlignment, this.JKy, this.JKz, this.JKH, this.JKt, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.JKx = new StaticLayout(this.JKu, this.ayp, paramInt1, localAlignment, this.JKy, this.JKz, this.JKH);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.ayp.getTextSize())
    {
      this.ayp.setTextSize(paramFloat);
      this.JKL = this.ayp.getFontMetricsInt();
      this.JKK = ((int)(Math.ceil(this.JKL.descent - this.JKL.ascent) + 2.0D));
      if (this.JKx != null)
      {
        fDs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142401);
  }
  
  private void updateTextColors()
  {
    int i = 0;
    AppMethodBeat.i(142419);
    int j = this.xpx.getColorForState(getDrawableState(), 0);
    if (j != this.JKq)
    {
      this.JKq = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void aW(String paramString, int paramInt1, int paramInt2)
  {
    this.JDl = paramString;
    this.JDm = paramInt1;
    this.JDn = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.JKx != null)
    {
      i = this.JKx.getWidth();
      AppMethodBeat.o(142444);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(142444);
    return i;
  }
  
  protected int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(142446);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    AppMethodBeat.o(142446);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    AppMethodBeat.i(142445);
    if (this.JKx != null)
    {
      i = this.JKx.getHeight();
      AppMethodBeat.o(142445);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    AppMethodBeat.o(142445);
    return i;
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(142383);
    super.drawableStateChanged();
    if ((this.xpx != null) && (this.xpx.isStateful())) {
      updateTextColors();
    }
    b localb = this.JKO;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.JLe != null) && (localb.JLe.isStateful())) {
        localb.JLe.setState(arrayOfInt);
      }
      if ((localb.JLf != null) && (localb.JLf.isStateful())) {
        localb.JLf.setState(arrayOfInt);
      }
      if ((localb.JLg != null) && (localb.JLg.isStateful())) {
        localb.JLg.setState(arrayOfInt);
      }
      if ((localb.JLh != null) && (localb.JLh.isStateful())) {
        localb.JLh.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.JKx == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.Kk & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.JKx.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.JKO;
    if (localb != null) {
      return localb.JLq;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.JKO;
    if (localb != null) {
      return new Drawable[] { localb.JLg, localb.JLe, localb.JLh, localb.JLf };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.JKO;
    if ((localb == null) || (localb.JLf == null) || (!this.JKS))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.JLq;
    int k = localb.JLj;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.JKO;
    if ((localb == null) || (localb.JLg == null) || (!this.JKP))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.JLq;
    int k = localb.JLk;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.JKO;
    if ((localb == null) || (localb.JLh == null) || (!this.JKQ))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.JLq;
    int k = localb.JLl;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.JKO;
    if ((localb == null) || (localb.JLe == null) || (!this.JKR))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.JLq;
    int k = localb.JLi;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.JKq;
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return null;
  }
  
  public Editable getEditableText()
  {
    if ((this.mText instanceof Editable)) {
      return (Editable)this.mText;
    }
    return null;
  }
  
  @ViewDebug.ExportedProperty
  public TextUtils.TruncateAt getEllipsize()
  {
    return this.JKt;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.JKx == null) || (this.JKB != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.JKx.getLineCount() <= this.JKA)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.JKx.getLineTop(this.JKA);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.Kk & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(142392);
      return i + j - k;
    }
    if (m == 80)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(142392);
    return i + j;
  }
  
  public int getExtendedPaddingTop()
  {
    AppMethodBeat.i(142391);
    if ((this.JKx == null) || (this.JKB != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.JKx.getLineCount() <= this.JKA)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.JKx.getLineTop(this.JKA);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.Kk & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    if (m == 80)
    {
      AppMethodBeat.o(142391);
      return i + j - k;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(142391);
    return i + j;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(142430);
    if (this.JKx == null)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(142430);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(142430);
      return;
    }
    int j = this.JKx.getLineForOffset(i);
    paramRect.top = this.JKx.getLineTop(j);
    paramRect.bottom = this.JKx.getLineBottom(j);
    paramRect.left = ((int)this.JKx.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.Kk & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.Kk;
  }
  
  public final Layout getLayout()
  {
    return this.JKx;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.JKx != null)
    {
      int i = this.JKx.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.ayp.getFontMetricsInt(null) * this.JKy + this.JKz);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.ayp;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.ayp.getFlags();
    AppMethodBeat.o(142408);
    return i;
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionEnd()
  {
    AppMethodBeat.i(142441);
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(142441);
    return i;
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionStart()
  {
    AppMethodBeat.i(142440);
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(142440);
    return i;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.xpx;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.ayp.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.ayp.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(193741);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.Kk & 0x70;
    Layout localLayout = this.JKx;
    int i = j;
    int n;
    int i1;
    if (m != 80)
    {
      n = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      i1 = localLayout.getHeight();
      i = j;
      if (i1 < n) {
        if (m != 48) {
          break label92;
        }
      }
    }
    label92:
    for (i = n - i1;; i = n - i1 >> 1)
    {
      AppMethodBeat.o(193741);
      return i + k;
    }
  }
  
  public int getTotalPaddingLeft()
  {
    AppMethodBeat.i(142393);
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(142393);
    return i;
  }
  
  public int getTotalPaddingRight()
  {
    AppMethodBeat.i(142394);
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(142394);
    return i;
  }
  
  public int getTotalPaddingTop()
  {
    AppMethodBeat.i(142395);
    int i = getExtendedPaddingTop();
    int j = getVerticalOffset$1385f2();
    AppMethodBeat.o(142395);
    return i + j;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(142404);
    Typeface localTypeface = this.ayp.getTypeface();
    AppMethodBeat.o(142404);
    return localTypeface;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142385);
    Rect localRect;
    int m;
    int k;
    b localb;
    int i;
    int j;
    int n;
    int i1;
    int i2;
    if (verifyDrawable(paramDrawable))
    {
      localRect = paramDrawable.getBounds();
      m = getScrollX();
      k = getScrollY();
      localb = this.JKO;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.JLg) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.JLo) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.JLh)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.JLl);
        i = k + ((i1 - i2 - n - i - localb.JLp) / 2 + i);
      }
      else if (paramDrawable == localb.JLe)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.JLm) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.JLf)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.JLn) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.JLj);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142429);
    super.onDraw(paramCanvas);
    int m = getCompoundPaddingLeft();
    int i1 = getCompoundPaddingTop();
    int i = getCompoundPaddingRight();
    int i7 = getCompoundPaddingBottom();
    int j = getScrollX();
    int i2 = getScrollY();
    int i3 = getRight();
    int i4 = getLeft();
    int i5 = getBottom();
    int i6 = getTop();
    int k = getWidth();
    int n = getHeight();
    Object localObject = this.JKO;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.JKP) && (((b)localObject).JLg != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).JLo) / 2);
        ((b)localObject).JLg.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.JKQ)
      {
        f2 = f3;
        if (((b)localObject).JLh != null)
        {
          paramCanvas.save();
          if (!this.JKJ) {
            break label694;
          }
          f1 = this.ayp.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).JLp) / 2);
          ((b)localObject).JLh.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.JKR) && (((b)localObject).JLe != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).JLm) / 2, getPaddingTop() + i2);
        ((b)localObject).JLe.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.JKS)
      {
        f1 = f2;
        if (((b)localObject).JLf != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).JLn) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).JLj);
          ((b)localObject).JLf.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.JKq;
    this.ayp.setColor(i1);
    this.ayp.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.Kk & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.JKJ)
    {
      f3 = (n - (this.JKL.bottom - this.JKL.top)) / 2 - this.JKL.top;
      j = 0;
      i = j;
      if ((this.Kk & 0x7) != 3) {}
      switch (this.Kk & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.ayp);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.JKu, this.ayp));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.ayp.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.ayp.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.JKx == null) {
        fDt();
      }
      localObject = this.JKx;
      try
      {
        ((Layout)localObject).draw(paramCanvas, null, null, i - j);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ae.printErrStackTrace("TextView", localIndexOutOfBoundsException, "", new Object[0]);
      }
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(142447);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bu.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(142447);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142425);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.JKM) && (getMeasuredWidth() > 0))
    {
      if ((bu.isNullOrNil(this.JDl)) || (this.JKX == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.JKX.a(this, this.mText, this.JDl, this.JDm, this.JDn);
      this.JDl = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.JKM = false;
      AppMethodBeat.o(142425);
      return;
      label99:
      setText(TextUtils.ellipsize(this.mText, getPaint(), getMeasuredWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142436);
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 0)
    {
      setMeasuredDimension(j, this.JKK);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.JKJ)
    {
      if (this.JKK == 0) {
        fDu();
      }
      setMeasuredDimension(j, this.JKK);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.JKE)
    {
      paramInt1 = this.mMaxWidth - paramInt1;
      if (this.JKx != null) {
        break label165;
      }
      jQ(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.JKG = -1;
      paramInt1 = i;
    }
    for (;;)
    {
      scrollTo(0, 0);
      setMeasuredDimension(j, paramInt1);
      AppMethodBeat.o(142436);
      return;
      paramInt1 = j - paramInt1;
      break;
      label165:
      if (this.JKx.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        jQ(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.JKG = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.JKO;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.JLq = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.JKO = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.JKT)
    {
      this.JKT = paramInt;
      setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(142381);
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    AppMethodBeat.i(142379);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(142379);
      return;
    }
    if ((this.JKO != null) && (this.JKO.JLg == paramDrawable))
    {
      AppMethodBeat.o(142379);
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(paramDrawable, null);
    AppMethodBeat.o(142379);
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142382);
    if (paramInt != this.JKU)
    {
      this.JKU = paramInt;
      setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(142382);
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    AppMethodBeat.i(142380);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(142380);
      return;
    }
    if ((this.JKO != null) && (this.JKO.JLh == paramDrawable))
    {
      AppMethodBeat.o(142380);
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(null, paramDrawable);
    AppMethodBeat.o(142380);
  }
  
  public void setDrawDownDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142375);
    if (this.JKS != paramBoolean) {
      invalidate();
    }
    this.JKS = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.JKP != paramBoolean) {
      invalidate();
    }
    this.JKP = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.JKQ != paramBoolean) {
      invalidate();
    }
    this.JKQ = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.JKR != paramBoolean) {
      invalidate();
    }
    this.JKR = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.JKr = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.JKt = paramTruncateAt;
    if (this.JKx != null)
    {
      fDs();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142443);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(142407);
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      paramInt = 0;
      if ((i & 0x7) != (this.Kk & 0x7)) {
        paramInt = 1;
      }
      if (i != this.Kk) {
        invalidate();
      }
      this.Kk = i;
      if ((this.JKx != null) && (paramInt != 0)) {
        jQ(this.JKx.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.JKC = paramInt;
    this.JKA = paramInt;
    this.JKD = 2;
    this.JKB = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.JKH = paramBoolean;
    if (this.JKx != null)
    {
      fDs();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.JKX = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.JKC = paramInt;
    this.JKA = paramInt;
    this.JKD = 1;
    this.JKB = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.JKA = paramInt;
    this.JKB = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.JKA = paramInt;
    this.JKB = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.mMaxWidth = paramInt;
    this.JKE = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.JKC = paramInt;
    this.JKD = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.JKC = paramInt;
    this.JKD = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.mMinWidth = paramInt;
    this.JKF = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      fDs();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.ayp.getFlags() != paramInt)
    {
      this.ayp.setFlags(paramInt);
      if (this.JKx != null)
      {
        fDs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.JKN = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.JHW = paramBoolean;
    if (paramBoolean)
    {
      setLines(1);
      AppMethodBeat.o(142442);
      return;
    }
    setMaxLines(2147483647);
    AppMethodBeat.o(142442);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(142421);
    this.JKs = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142421);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142426);
    setText(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(142426);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142422);
    a(paramCharSequence, this.JKv);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.xpx = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(142405);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(142406);
    if (paramColorStateList == null)
    {
      paramColorStateList = new NullPointerException();
      AppMethodBeat.o(142406);
      throw paramColorStateList;
    }
    if (this.xpx == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.xpx = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.JKv;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    a(paramCharSequence, locala);
    if (((i >= 0) || (j >= 0)) && ((this.mText instanceof Spannable))) {
      Selection.setSelection((Spannable)this.mText, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
    AppMethodBeat.o(142423);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(142399);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(142399);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(142400);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(142400);
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(142403);
    if (this.ayp.getTypeface() != paramTypeface)
    {
      this.ayp.setTypeface(paramTypeface);
      if (this.JKx != null)
      {
        fDs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142403);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(142418);
    this.mMinWidth = paramInt;
    this.mMaxWidth = paramInt;
    this.JKF = true;
    this.JKE = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.JKO != null))
    {
      if ((paramDrawable == this.JKO.JLg) || (paramDrawable == this.JKO.JLe) || (paramDrawable == this.JKO.JLh) || (paramDrawable == this.JKO.JLf))
      {
        AppMethodBeat.o(142384);
        return true;
      }
      AppMethodBeat.o(142384);
      return false;
    }
    AppMethodBeat.o(142384);
    return bool;
  }
  
  final class b
  {
    final Rect JLd;
    Drawable JLe;
    Drawable JLf;
    Drawable JLg;
    Drawable JLh;
    int JLi;
    int JLj;
    int JLk;
    int JLl;
    int JLm;
    int JLn;
    int JLo;
    int JLp;
    int JLq;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.JLd = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */