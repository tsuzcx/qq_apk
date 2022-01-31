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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics zpf;
  private int AZ;
  private ColorStateList eR;
  private TextPaint hB;
  private int mMaxWidth;
  private int mMinWidth;
  private boolean mSingleLine;
  private CharSequence mText;
  private String zhp;
  private int zhq;
  private int zhr;
  private TextUtils.TruncateAt zoA;
  private CharSequence zoB;
  private NoMeasuredTextView.a zoC;
  private KeyListener zoD;
  private Layout zoE;
  private float zoF;
  private float zoG;
  private int zoH;
  private int zoI;
  private int zoJ;
  private int zoK;
  private boolean zoL;
  private boolean zoM;
  private int zoN;
  private boolean zoO;
  private BoringLayout zoP;
  private boolean zoQ;
  private int zoR;
  private Paint.FontMetricsInt zoS;
  private boolean zoT;
  private boolean zoU;
  private NoMeasuredTextView.b zoV;
  private boolean zoW;
  public boolean zoX;
  private boolean zoY;
  private boolean zoZ;
  private int zox;
  private Editable.Factory zoy;
  private Spannable.Factory zoz;
  private int zpa;
  private int zpb;
  private int zpc;
  private int zpd;
  private NoMeasuredTextView.c zpe;
  
  static
  {
    AppMethodBeat.i(107081);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    zpf = new BoringLayout.Metrics();
    AppMethodBeat.o(107081);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107009);
    this.zoy = Editable.Factory.getInstance();
    this.zoz = Spannable.Factory.getInstance();
    this.zoA = null;
    this.zoC = NoMeasuredTextView.a.zpg;
    this.AZ = 51;
    this.zoF = 1.0F;
    this.zoG = 0.0F;
    this.zoH = 2147483647;
    this.zoI = 1;
    this.zoJ = 0;
    this.zoK = 1;
    this.mMaxWidth = 2147483647;
    this.zoL = false;
    this.mMinWidth = 0;
    this.zoM = false;
    this.zoN = -1;
    this.zoO = true;
    this.zoQ = false;
    this.zoT = false;
    this.zoU = false;
    this.zoW = false;
    this.zoX = false;
    this.zoY = false;
    this.zoZ = false;
    this.zpa = -1;
    this.zpb = -1;
    this.zpc = -1;
    this.zpd = -1;
    this.mText = "";
    this.zoB = "";
    this.hB = new TextPaint(1);
    this.hB.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.zoS = this.hB.getFontMetricsInt();
    dED();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(107009);
  }
  
  private void OK(int paramInt)
  {
    AppMethodBeat.i(107072);
    if (this.zoQ)
    {
      dED();
      invalidate();
      AppMethodBeat.o(107072);
      return;
    }
    if (getWidth() == 0)
    {
      requestLayout();
      invalidate();
      AppMethodBeat.o(107072);
      return;
    }
    if (this.zoE == null)
    {
      dEC();
      if (this.zoE.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(107072);
      return;
    }
    int i = this.zoE.getHeight();
    int j = this.zoE.getWidth();
    hA(j, j - paramInt);
    if (this.zoA != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(107072);
        return;
      }
      paramInt = this.zoE.getHeight();
      if ((paramInt == i) && (paramInt == getHeight()))
      {
        invalidate();
        AppMethodBeat.o(107072);
        return;
      }
    }
    requestLayout();
    invalidate();
    AppMethodBeat.o(107072);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(107011);
    Object localObject2 = this.zoV;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label200;
      }
      if (localObject2 != null)
      {
        if (((NoMeasuredTextView.b)localObject2).zpx != 0) {
          break label60;
        }
        this.zoV = null;
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(107011);
      return;
      i = 0;
      break;
      label60:
      if (((NoMeasuredTextView.b)localObject2).zpn != null) {
        ((NoMeasuredTextView.b)localObject2).zpn.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).zpn = null;
      if (((NoMeasuredTextView.b)localObject2).zpl != null) {
        ((NoMeasuredTextView.b)localObject2).zpl.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).zpl = null;
      if (((NoMeasuredTextView.b)localObject2).zpo != null) {
        ((NoMeasuredTextView.b)localObject2).zpo.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).zpo = null;
      if (((NoMeasuredTextView.b)localObject2).zpm != null) {
        ((NoMeasuredTextView.b)localObject2).zpm.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).zpm = null;
      ((NoMeasuredTextView.b)localObject2).zpv = 0;
      ((NoMeasuredTextView.b)localObject2).zpr = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.zpw = 0;
      paramDrawable1.zps = 0;
      label177:
      paramDrawable1.zpt = 0;
      paramDrawable1.zpp = 0;
      paramDrawable1.zpu = 0;
      paramDrawable1.zpq = 0;
    }
    label200:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new NoMeasuredTextView.b(this);
      this.zoV = ((NoMeasuredTextView.b)localObject1);
    }
    if ((((NoMeasuredTextView.b)localObject1).zpn != paramDrawable1) && (((NoMeasuredTextView.b)localObject1).zpn != null)) {
      ((NoMeasuredTextView.b)localObject1).zpn.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).zpn = paramDrawable1;
    if ((((NoMeasuredTextView.b)localObject1).zpl != null) && (((NoMeasuredTextView.b)localObject1).zpl != null)) {
      ((NoMeasuredTextView.b)localObject1).zpl.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).zpl = null;
    if ((((NoMeasuredTextView.b)localObject1).zpo != paramDrawable2) && (((NoMeasuredTextView.b)localObject1).zpo != null)) {
      ((NoMeasuredTextView.b)localObject1).zpo.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).zpo = paramDrawable2;
    if ((((NoMeasuredTextView.b)localObject1).zpm != null) && (((NoMeasuredTextView.b)localObject1).zpm != null)) {
      ((NoMeasuredTextView.b)localObject1).zpm.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).zpm = null;
    localObject2 = ((NoMeasuredTextView.b)localObject1).zpk;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((NoMeasuredTextView.b)localObject1).zpr = ((Rect)localObject2).width();
      ((NoMeasuredTextView.b)localObject1).zpv = ((Rect)localObject2).height();
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
      ((NoMeasuredTextView.b)localObject1).zps = ((Rect)localObject2).width();
      ((NoMeasuredTextView.b)localObject1).zpw = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label177;
      ((NoMeasuredTextView.b)localObject1).zpv = 0;
      ((NoMeasuredTextView.b)localObject1).zpr = 0;
    }
  }
  
  private void a(CharSequence paramCharSequence, NoMeasuredTextView.a parama)
  {
    AppMethodBeat.i(107057);
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      if (paramCharSequence.equals(this.mText))
      {
        AppMethodBeat.o(107057);
        return;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (getMeasuredWidth() > 0)
      {
        localCharSequence = paramCharSequence;
        if (this.zpe != null)
        {
          localCharSequence = paramCharSequence;
          if (!bo.isNullOrNil(this.zhp))
          {
            localCharSequence = this.zpe.a(this, paramCharSequence, this.zhp, this.zhq, this.zhr);
            this.zhp = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.zoQ = false;
        if ((parama != NoMeasuredTextView.a.zpi) && (this.zoD == null)) {
          break label241;
        }
        paramCharSequence = this.zoy.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.zoU)
        {
          if (!this.zoL) {
            break label264;
          }
          i = this.mMaxWidth;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.mMaxWidth, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.hB, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.zoC = parama;
        this.mText = localCharSequence;
        this.zoB = localCharSequence;
        OK(j);
        AppMethodBeat.o(107057);
        return;
        this.zoQ = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.zph) {
          break label131;
        }
        paramCharSequence = this.zoz.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.hB, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.zoT = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void dEB()
  {
    if (((this.zoE instanceof BoringLayout)) && (this.zoP == null)) {
      this.zoP = ((BoringLayout)this.zoE);
    }
    this.zoE = null;
  }
  
  private void dEC()
  {
    AppMethodBeat.i(107066);
    if (this.zoL) {}
    for (int i = this.mMaxWidth - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      hA(j, j);
      AppMethodBeat.o(107066);
      return;
    }
  }
  
  private void dED()
  {
    AppMethodBeat.i(107071);
    if (this.zoR == 0) {
      this.zoR = ((int)(Math.ceil(this.zoS.descent - this.zoS.ascent) + 2.0D));
    }
    AppMethodBeat.o(107071);
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    AppMethodBeat.i(156785);
    int j = 0;
    int k = this.AZ & 0x70;
    Layout localLayout = this.zoE;
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
      AppMethodBeat.o(156785);
      return i;
    }
  }
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(107070);
    Layout localLayout = this.zoE;
    if (localLayout == null)
    {
      AppMethodBeat.o(107070);
      return 0;
    }
    int j = localLayout.getLineCount();
    int i = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + i;
    i = localLayout.getLineTop(j) + m;
    int k;
    if (this.zoI == 1)
    {
      k = j;
      if (j > this.zoH)
      {
        i = localLayout.getLineTop(this.zoH) + localLayout.getBottomPadding() + m;
        k = this.zoH;
      }
      if (this.zoK != 1) {
        break label161;
      }
      j = i;
      if (k < this.zoJ) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.zoJ - k) * j;; j = Math.max(i, this.zoJ))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(107070);
      return i;
      i = Math.min(i, this.zoH);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    AppMethodBeat.i(107060);
    int j = 0;
    int k = this.AZ & 0x70;
    Layout localLayout = this.zoE;
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
      AppMethodBeat.o(107060);
      return i;
    }
  }
  
  private void hA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107067);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.AZ & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.zoA == null) || (this.zoD != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.zoE = new StaticLayout(this.zoB, 0, this.zoB.length(), this.hB, paramInt1, localAlignment, this.zoF, this.zoG, this.zoO, this.zoA, paramInt2);
        AppMethodBeat.o(107067);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.zoE = new StaticLayout(this.zoB, this.hB, paramInt1, localAlignment, this.zoF, this.zoG, this.zoO);
      AppMethodBeat.o(107067);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(107034);
    if (paramFloat != this.hB.getTextSize())
    {
      this.hB.setTextSize(paramFloat);
      this.zoS = this.hB.getFontMetricsInt();
      this.zoR = ((int)(Math.ceil(this.zoS.descent - this.zoS.ascent) + 2.0D));
      if (this.zoE != null)
      {
        dEB();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(107034);
  }
  
  private void updateTextColors()
  {
    int i = 0;
    AppMethodBeat.i(107052);
    int j = this.eR.getColorForState(getDrawableState(), 0);
    if (j != this.zox)
    {
      this.zox = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(107052);
  }
  
  public final void aF(String paramString, int paramInt1, int paramInt2)
  {
    this.zhp = paramString;
    this.zhq = paramInt1;
    this.zhr = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(107077);
    if (this.zoE != null)
    {
      i = this.zoE.getWidth();
      AppMethodBeat.o(107077);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(107077);
    return i;
  }
  
  protected int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(107079);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    AppMethodBeat.o(107079);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    AppMethodBeat.i(107078);
    if (this.zoE != null)
    {
      i = this.zoE.getHeight();
      AppMethodBeat.o(107078);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    AppMethodBeat.o(107078);
    return i;
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(107016);
    super.drawableStateChanged();
    if ((this.eR != null) && (this.eR.isStateful())) {
      updateTextColors();
    }
    NoMeasuredTextView.b localb = this.zoV;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.zpl != null) && (localb.zpl.isStateful())) {
        localb.zpl.setState(arrayOfInt);
      }
      if ((localb.zpm != null) && (localb.zpm.isStateful())) {
        localb.zpm.setState(arrayOfInt);
      }
      if ((localb.zpn != null) && (localb.zpn.isStateful())) {
        localb.zpn.setState(arrayOfInt);
      }
      if ((localb.zpo != null) && (localb.zpo.isStateful())) {
        localb.zpo.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(107016);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(107065);
    if (this.zoE == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(107065);
      return i;
    }
    if ((this.AZ & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.zoE.getLineBaseline(0);
      AppMethodBeat.o(107065);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    NoMeasuredTextView.b localb = this.zoV;
    if (localb != null) {
      return localb.zpx;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    NoMeasuredTextView.b localb = this.zoV;
    if (localb != null) {
      return new Drawable[] { localb.zpn, localb.zpl, localb.zpo, localb.zpm };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(107021);
    NoMeasuredTextView.b localb = this.zoV;
    if ((localb == null) || (localb.zpm == null) || (!this.zoZ))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(107021);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.zpx;
    int k = localb.zpq;
    AppMethodBeat.o(107021);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(107022);
    NoMeasuredTextView.b localb = this.zoV;
    if ((localb == null) || (localb.zpn == null) || (!this.zoW))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(107022);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.zpx;
    int k = localb.zpr;
    AppMethodBeat.o(107022);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(107023);
    NoMeasuredTextView.b localb = this.zoV;
    if ((localb == null) || (localb.zpo == null) || (!this.zoX))
    {
      i = getPaddingRight();
      AppMethodBeat.o(107023);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.zpx;
    int k = localb.zps;
    AppMethodBeat.o(107023);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(107020);
    NoMeasuredTextView.b localb = this.zoV;
    if ((localb == null) || (localb.zpl == null) || (!this.zoY))
    {
      i = getPaddingTop();
      AppMethodBeat.o(107020);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.zpx;
    int k = localb.zpp;
    AppMethodBeat.o(107020);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.zox;
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
    return this.zoA;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(107025);
    if ((this.zoE == null) || (this.zoI != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(107025);
      return i;
    }
    if (this.zoE.getLineCount() <= this.zoH)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(107025);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.zoE.getLineTop(this.zoH);
    if (k >= j)
    {
      AppMethodBeat.o(107025);
      return i;
    }
    int m = this.AZ & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(107025);
      return i + j - k;
    }
    if (m == 80)
    {
      AppMethodBeat.o(107025);
      return i;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(107025);
    return i + j;
  }
  
  public int getExtendedPaddingTop()
  {
    AppMethodBeat.i(107024);
    if ((this.zoE == null) || (this.zoI != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(107024);
      return i;
    }
    if (this.zoE.getLineCount() <= this.zoH)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(107024);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.zoE.getLineTop(this.zoH);
    if (k >= j)
    {
      AppMethodBeat.o(107024);
      return i;
    }
    int m = this.AZ & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(107024);
      return i;
    }
    if (m == 80)
    {
      AppMethodBeat.o(107024);
      return i + j - k;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(107024);
    return i + j;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(107063);
    if (this.zoE == null)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(107063);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(107063);
      return;
    }
    int j = this.zoE.getLineForOffset(i);
    paramRect.top = this.zoE.getLineTop(j);
    paramRect.bottom = this.zoE.getLineBottom(j);
    paramRect.left = ((int)this.zoE.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.AZ & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(107063);
  }
  
  public int getGravity()
  {
    return this.AZ;
  }
  
  public final Layout getLayout()
  {
    return this.zoE;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(107064);
    if (this.zoE != null)
    {
      int i = this.zoE.getLineCount();
      AppMethodBeat.o(107064);
      return i;
    }
    AppMethodBeat.o(107064);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(107010);
    int i = Math.round(this.hB.getFontMetricsInt(null) * this.zoF + this.zoG);
    AppMethodBeat.o(107010);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.hB;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(107041);
    int i = this.hB.getFlags();
    AppMethodBeat.o(107041);
    return i;
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionEnd()
  {
    AppMethodBeat.i(107074);
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(107074);
    return i;
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionStart()
  {
    AppMethodBeat.i(107073);
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(107073);
    return i;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.eR;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(107035);
    float f = this.hB.getTextScaleX();
    AppMethodBeat.o(107035);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(107031);
    float f = this.hB.getTextSize();
    AppMethodBeat.o(107031);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(107029);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.AZ & 0x70;
    Layout localLayout = this.zoE;
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
      AppMethodBeat.o(107029);
      return i + k;
    }
  }
  
  public int getTotalPaddingLeft()
  {
    AppMethodBeat.i(107026);
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(107026);
    return i;
  }
  
  public int getTotalPaddingRight()
  {
    AppMethodBeat.i(107027);
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(107027);
    return i;
  }
  
  public int getTotalPaddingTop()
  {
    AppMethodBeat.i(107028);
    int i = getExtendedPaddingTop();
    int j = getVerticalOffset$1385f2();
    AppMethodBeat.o(107028);
    return i + j;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(107037);
    Typeface localTypeface = this.hB.getTypeface();
    AppMethodBeat.o(107037);
    return localTypeface;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(107018);
    Rect localRect;
    int m;
    int k;
    NoMeasuredTextView.b localb;
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
      localb = this.zoV;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.zpn) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.zpv) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(107018);
      return;
      label152:
      if (paramDrawable == localb.zpo)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.zps);
        i = k + ((i1 - i2 - n - i - localb.zpw) / 2 + i);
      }
      else if (paramDrawable == localb.zpl)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.zpt) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.zpm)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.zpu) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.zpq);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107062);
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
    Object localObject = this.zoV;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.zoW) && (((NoMeasuredTextView.b)localObject).zpn != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((NoMeasuredTextView.b)localObject).zpv) / 2);
        ((NoMeasuredTextView.b)localObject).zpn.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.zoX)
      {
        f2 = f3;
        if (((NoMeasuredTextView.b)localObject).zpo != null)
        {
          paramCanvas.save();
          if (!this.zoQ) {
            break label694;
          }
          f1 = this.hB.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((NoMeasuredTextView.b)localObject).zpw) / 2);
          ((NoMeasuredTextView.b)localObject).zpo.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.zoY) && (((NoMeasuredTextView.b)localObject).zpl != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((NoMeasuredTextView.b)localObject).zpt) / 2, getPaddingTop() + i2);
        ((NoMeasuredTextView.b)localObject).zpl.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.zoZ)
      {
        f1 = f2;
        if (((NoMeasuredTextView.b)localObject).zpm != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((NoMeasuredTextView.b)localObject).zpu) / 2, i2 + i5 - i6 - getPaddingBottom() - ((NoMeasuredTextView.b)localObject).zpq);
          ((NoMeasuredTextView.b)localObject).zpm.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.zox;
    this.hB.setColor(i1);
    this.hB.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.AZ & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.zoQ)
    {
      f3 = (n - (this.zoS.bottom - this.zoS.top)) / 2 - this.zoS.top;
      j = 0;
      i = j;
      if ((this.AZ & 0x7) != 3) {}
      switch (this.AZ & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.hB);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(107062);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.zoB, this.hB));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.hB.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.hB.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.zoE == null) {
        dEC();
      }
      localObject = this.zoE;
      try
      {
        ((Layout)localObject).draw(paramCanvas, null, null, i - j);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ab.printErrStackTrace("TextView", localIndexOutOfBoundsException, "", new Object[0]);
      }
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(107080);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bo.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(107080);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107058);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.zoT) && (getMeasuredWidth() > 0))
    {
      if ((bo.isNullOrNil(this.zhp)) || (this.zpe == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.zpe.a(this, this.mText, this.zhp, this.zhq, this.zhr);
      this.zhp = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.zoT = false;
      AppMethodBeat.o(107058);
      return;
      label99:
      setText(TextUtils.ellipsize(this.mText, getPaint(), getMeasuredWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107069);
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 0)
    {
      setMeasuredDimension(j, this.zoR);
      AppMethodBeat.o(107069);
      return;
    }
    if (this.zoQ)
    {
      if (this.zoR == 0) {
        dED();
      }
      setMeasuredDimension(j, this.zoR);
      AppMethodBeat.o(107069);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.zoL)
    {
      paramInt1 = this.mMaxWidth - paramInt1;
      if (this.zoE != null) {
        break label165;
      }
      hA(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.zoN = -1;
      paramInt1 = i;
    }
    for (;;)
    {
      scrollTo(0, 0);
      setMeasuredDimension(j, paramInt1);
      AppMethodBeat.o(107069);
      return;
      paramInt1 = j - paramInt1;
      break;
      label165:
      if (this.zoE.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        hA(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.zoN = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(107019);
    NoMeasuredTextView.b localb2 = this.zoV;
    NoMeasuredTextView.b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.zpx = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(107019);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new NoMeasuredTextView.b(this);
        this.zoV = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(107014);
    if (paramInt != this.zpa)
    {
      this.zpa = paramInt;
      setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(107014);
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    AppMethodBeat.i(107012);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(107012);
      return;
    }
    if ((this.zoV != null) && (this.zoV.zpn == paramDrawable))
    {
      AppMethodBeat.o(107012);
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(paramDrawable, null);
    AppMethodBeat.o(107012);
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(107015);
    if (paramInt != this.zpb)
    {
      this.zpb = paramInt;
      setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
    AppMethodBeat.o(107015);
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    AppMethodBeat.i(107013);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(107013);
      return;
    }
    if ((this.zoV != null) && (this.zoV.zpo == paramDrawable))
    {
      AppMethodBeat.o(107013);
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(null, paramDrawable);
    AppMethodBeat.o(107013);
  }
  
  public void setDrawDownDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(107008);
    if (this.zoZ != paramBoolean) {
      invalidate();
    }
    this.zoZ = paramBoolean;
    AppMethodBeat.o(107008);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(107005);
    if (this.zoW != paramBoolean) {
      invalidate();
    }
    this.zoW = paramBoolean;
    AppMethodBeat.o(107005);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(107006);
    if (this.zoX != paramBoolean) {
      invalidate();
    }
    this.zoX = paramBoolean;
    AppMethodBeat.o(107006);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(107007);
    if (this.zoY != paramBoolean) {
      invalidate();
    }
    this.zoY = paramBoolean;
    AppMethodBeat.o(107007);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(107053);
    this.zoy = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(107053);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(107076);
    this.zoA = paramTruncateAt;
    if (this.zoE != null)
    {
      dEB();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(107076);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(107040);
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
      if ((i & 0x7) != (this.AZ & 0x7)) {
        paramInt = 1;
      }
      if (i != this.AZ) {
        invalidate();
      }
      this.AZ = i;
      if ((this.zoE != null) && (paramInt != 0)) {
        hA(this.zoE.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(107040);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(107048);
    this.zoJ = paramInt;
    this.zoH = paramInt;
    this.zoK = 2;
    this.zoI = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107048);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(107068);
    this.zoO = paramBoolean;
    if (this.zoE != null)
    {
      dEB();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(107068);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.zpe = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(107047);
    this.zoJ = paramInt;
    this.zoH = paramInt;
    this.zoK = 1;
    this.zoI = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107047);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(107046);
    this.zoH = paramInt;
    this.zoI = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107046);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(107045);
    this.zoH = paramInt;
    this.zoI = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107045);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(107050);
    this.mMaxWidth = paramInt;
    this.zoL = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107050);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(107044);
    this.zoJ = paramInt;
    this.zoK = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107044);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(107043);
    this.zoJ = paramInt;
    this.zoK = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107043);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(107049);
    this.mMinWidth = paramInt;
    this.zoM = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107049);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107030);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      dEB();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(107030);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(107042);
    if (this.hB.getFlags() != paramInt)
    {
      this.hB.setFlags(paramInt);
      if (this.zoE != null)
      {
        dEB();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(107042);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.zoU = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(107075);
    this.mSingleLine = paramBoolean;
    if (paramBoolean)
    {
      setLines(1);
      AppMethodBeat.o(107075);
      return;
    }
    setMaxLines(2147483647);
    AppMethodBeat.o(107075);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(107054);
    this.zoz = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(107054);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(107059);
    setText(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(107059);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107055);
    a(paramCharSequence, this.zoC);
    AppMethodBeat.o(107055);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(107038);
    this.eR = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(107038);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(107039);
    if (paramColorStateList == null)
    {
      paramColorStateList = new NullPointerException();
      AppMethodBeat.o(107039);
      throw paramColorStateList;
    }
    if (this.eR == paramColorStateList)
    {
      AppMethodBeat.o(107039);
      return;
    }
    this.eR = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(107039);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107056);
    NoMeasuredTextView.a locala = this.zoC;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    a(paramCharSequence, locala);
    if (((i >= 0) || (j >= 0)) && ((this.mText instanceof Spannable))) {
      Selection.setSelection((Spannable)this.mText, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
    AppMethodBeat.o(107056);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(107032);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(107032);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(107033);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(107033);
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(107036);
    if (this.hB.getTypeface() != paramTypeface)
    {
      this.hB.setTypeface(paramTypeface);
      if (this.zoE != null)
      {
        dEB();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(107036);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(107051);
    this.mMinWidth = paramInt;
    this.mMaxWidth = paramInt;
    this.zoM = true;
    this.zoL = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(107051);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(107017);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.zoV != null))
    {
      if ((paramDrawable == this.zoV.zpn) || (paramDrawable == this.zoV.zpl) || (paramDrawable == this.zoV.zpo) || (paramDrawable == this.zoV.zpm))
      {
        AppMethodBeat.o(107017);
        return true;
      }
      AppMethodBeat.o(107017);
      return false;
    }
    AppMethodBeat.o(107017);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */