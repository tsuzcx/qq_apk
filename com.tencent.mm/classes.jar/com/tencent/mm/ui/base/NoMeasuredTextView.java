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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics HCu;
  private int HBM;
  private Editable.Factory HBN;
  private Spannable.Factory HBO;
  private TextUtils.TruncateAt HBP;
  private CharSequence HBQ;
  private NoMeasuredTextView.a HBR;
  private KeyListener HBS;
  private Layout HBT;
  private float HBU;
  private float HBV;
  private int HBW;
  private int HBX;
  private int HBY;
  private int HBZ;
  private boolean HCa;
  private boolean HCb;
  private int HCc;
  private boolean HCd;
  private BoringLayout HCe;
  private boolean HCf;
  private int HCg;
  private Paint.FontMetricsInt HCh;
  private boolean HCi;
  private boolean HCj;
  private b HCk;
  private boolean HCl;
  public boolean HCm;
  private boolean HCn;
  private boolean HCo;
  private int HCp;
  private int HCq;
  private int HCr;
  private int HCs;
  private NoMeasuredTextView.c HCt;
  private String HuH;
  private int HuI;
  private int HuJ;
  private boolean Hzq;
  private int Is;
  private TextPaint awy;
  private int mMaxWidth;
  private int mMinWidth;
  private CharSequence mText;
  private ColorStateList vSw;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    HCu = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.HBN = Editable.Factory.getInstance();
    this.HBO = Spannable.Factory.getInstance();
    this.HBP = null;
    this.HBR = NoMeasuredTextView.a.HCv;
    this.Is = 51;
    this.HBU = 1.0F;
    this.HBV = 0.0F;
    this.HBW = 2147483647;
    this.HBX = 1;
    this.HBY = 0;
    this.HBZ = 1;
    this.mMaxWidth = 2147483647;
    this.HCa = false;
    this.mMinWidth = 0;
    this.HCb = false;
    this.HCc = -1;
    this.HCd = true;
    this.HCf = false;
    this.HCi = false;
    this.HCj = false;
    this.HCl = false;
    this.HCm = false;
    this.HCn = false;
    this.HCo = false;
    this.HCp = -1;
    this.HCq = -1;
    this.HCr = -1;
    this.HCs = -1;
    this.mText = "";
    this.HBQ = "";
    this.awy = new TextPaint(1);
    this.awy.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.HCh = this.awy.getFontMetricsInt();
    fjd();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.HCk;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).HCM != 0) {
          break label58;
        }
        this.HCk = null;
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
      if (((b)localObject2).HCC != null) {
        ((b)localObject2).HCC.setCallback(null);
      }
      ((b)localObject2).HCC = null;
      if (((b)localObject2).HCA != null) {
        ((b)localObject2).HCA.setCallback(null);
      }
      ((b)localObject2).HCA = null;
      if (((b)localObject2).HCD != null) {
        ((b)localObject2).HCD.setCallback(null);
      }
      ((b)localObject2).HCD = null;
      if (((b)localObject2).HCB != null) {
        ((b)localObject2).HCB.setCallback(null);
      }
      ((b)localObject2).HCB = null;
      ((b)localObject2).HCK = 0;
      ((b)localObject2).HCG = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.HCL = 0;
      paramDrawable1.HCH = 0;
      label175:
      paramDrawable1.HCI = 0;
      paramDrawable1.HCE = 0;
      paramDrawable1.HCJ = 0;
      paramDrawable1.HCF = 0;
    }
    label198:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.HCk = ((b)localObject1);
    }
    if ((((b)localObject1).HCC != paramDrawable1) && (((b)localObject1).HCC != null)) {
      ((b)localObject1).HCC.setCallback(null);
    }
    ((b)localObject1).HCC = paramDrawable1;
    if ((((b)localObject1).HCA != null) && (((b)localObject1).HCA != null)) {
      ((b)localObject1).HCA.setCallback(null);
    }
    ((b)localObject1).HCA = null;
    if ((((b)localObject1).HCD != paramDrawable2) && (((b)localObject1).HCD != null)) {
      ((b)localObject1).HCD.setCallback(null);
    }
    ((b)localObject1).HCD = paramDrawable2;
    if ((((b)localObject1).HCB != null) && (((b)localObject1).HCB != null)) {
      ((b)localObject1).HCB.setCallback(null);
    }
    ((b)localObject1).HCB = null;
    localObject2 = ((b)localObject1).HCz;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).HCG = ((Rect)localObject2).width();
      ((b)localObject1).HCK = ((Rect)localObject2).height();
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
      ((b)localObject1).HCH = ((Rect)localObject2).width();
      ((b)localObject1).HCL = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label175;
      ((b)localObject1).HCK = 0;
      ((b)localObject1).HCG = 0;
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
        if (this.HCt != null)
        {
          localCharSequence = paramCharSequence;
          if (!bs.isNullOrNil(this.HuH))
          {
            localCharSequence = this.HCt.a(this, paramCharSequence, this.HuH, this.HuI, this.HuJ);
            this.HuH = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.HCf = false;
        if ((parama != NoMeasuredTextView.a.HCx) && (this.HBS == null)) {
          break label241;
        }
        paramCharSequence = this.HBN.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.HCj)
        {
          if (!this.HCa) {
            break label264;
          }
          i = this.mMaxWidth;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.mMaxWidth, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.awy, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.HBR = parama;
        this.mText = localCharSequence;
        this.HBQ = localCharSequence;
        aaa(j);
        AppMethodBeat.o(142424);
        return;
        this.HCf = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.HCw) {
          break label131;
        }
        paramCharSequence = this.HBO.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.awy, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.HCi = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void aaa(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.HCf)
    {
      fjd();
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
    if (this.HBT == null)
    {
      fjc();
      if (this.HBT.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.HBT.getHeight();
    int j = this.HBT.getWidth();
    jA(j, j - paramInt);
    if (this.HBP != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.HBT.getHeight();
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
  
  private void fjb()
  {
    if (((this.HBT instanceof BoringLayout)) && (this.HCe == null)) {
      this.HCe = ((BoringLayout)this.HBT);
    }
    this.HBT = null;
  }
  
  private void fjc()
  {
    AppMethodBeat.i(142433);
    if (this.HCa) {}
    for (int i = this.mMaxWidth - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      jA(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void fjd()
  {
    AppMethodBeat.i(142438);
    if (this.HCg == 0) {
      this.HCg = ((int)(Math.ceil(this.HCh.descent - this.HCh.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    AppMethodBeat.i(210325);
    int j = 0;
    int k = this.Is & 0x70;
    Layout localLayout = this.HBT;
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
      AppMethodBeat.o(210325);
      return i;
    }
  }
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(142437);
    Layout localLayout = this.HBT;
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
    if (this.HBX == 1)
    {
      k = j;
      if (j > this.HBW)
      {
        i = localLayout.getLineTop(this.HBW) + localLayout.getBottomPadding() + m;
        k = this.HBW;
      }
      if (this.HBZ != 1) {
        break label161;
      }
      j = i;
      if (k < this.HBY) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.HBY - k) * j;; j = Math.max(i, this.HBY))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.HBW);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.Is & 0x70;
    Layout localLayout = this.HBT;
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
  
  private void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.Is & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.HBP == null) || (this.HBS != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.HBT = new StaticLayout(this.HBQ, 0, this.HBQ.length(), this.awy, paramInt1, localAlignment, this.HBU, this.HBV, this.HCd, this.HBP, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.HBT = new StaticLayout(this.HBQ, this.awy, paramInt1, localAlignment, this.HBU, this.HBV, this.HCd);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.awy.getTextSize())
    {
      this.awy.setTextSize(paramFloat);
      this.HCh = this.awy.getFontMetricsInt();
      this.HCg = ((int)(Math.ceil(this.HCh.descent - this.HCh.ascent) + 2.0D));
      if (this.HBT != null)
      {
        fjb();
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
    int j = this.vSw.getColorForState(getDrawableState(), 0);
    if (j != this.HBM)
    {
      this.HBM = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void aP(String paramString, int paramInt1, int paramInt2)
  {
    this.HuH = paramString;
    this.HuI = paramInt1;
    this.HuJ = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.HBT != null)
    {
      i = this.HBT.getWidth();
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
    if (this.HBT != null)
    {
      i = this.HBT.getHeight();
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
    if ((this.vSw != null) && (this.vSw.isStateful())) {
      updateTextColors();
    }
    b localb = this.HCk;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.HCA != null) && (localb.HCA.isStateful())) {
        localb.HCA.setState(arrayOfInt);
      }
      if ((localb.HCB != null) && (localb.HCB.isStateful())) {
        localb.HCB.setState(arrayOfInt);
      }
      if ((localb.HCC != null) && (localb.HCC.isStateful())) {
        localb.HCC.setState(arrayOfInt);
      }
      if ((localb.HCD != null) && (localb.HCD.isStateful())) {
        localb.HCD.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.HBT == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.Is & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.HBT.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.HCk;
    if (localb != null) {
      return localb.HCM;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.HCk;
    if (localb != null) {
      return new Drawable[] { localb.HCC, localb.HCA, localb.HCD, localb.HCB };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.HCk;
    if ((localb == null) || (localb.HCB == null) || (!this.HCo))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.HCM;
    int k = localb.HCF;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.HCk;
    if ((localb == null) || (localb.HCC == null) || (!this.HCl))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.HCM;
    int k = localb.HCG;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.HCk;
    if ((localb == null) || (localb.HCD == null) || (!this.HCm))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.HCM;
    int k = localb.HCH;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.HCk;
    if ((localb == null) || (localb.HCA == null) || (!this.HCn))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.HCM;
    int k = localb.HCE;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.HBM;
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
    return this.HBP;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.HBT == null) || (this.HBX != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.HBT.getLineCount() <= this.HBW)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.HBT.getLineTop(this.HBW);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.Is & 0x70;
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
    if ((this.HBT == null) || (this.HBX != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.HBT.getLineCount() <= this.HBW)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.HBT.getLineTop(this.HBW);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.Is & 0x70;
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
    if (this.HBT == null)
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
    int j = this.HBT.getLineForOffset(i);
    paramRect.top = this.HBT.getLineTop(j);
    paramRect.bottom = this.HBT.getLineBottom(j);
    paramRect.left = ((int)this.HBT.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.Is & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.Is;
  }
  
  public final Layout getLayout()
  {
    return this.HBT;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.HBT != null)
    {
      int i = this.HBT.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.awy.getFontMetricsInt(null) * this.HBU + this.HBV);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.awy;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.awy.getFlags();
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
    return this.vSw;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.awy.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.awy.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(197196);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.Is & 0x70;
    Layout localLayout = this.HBT;
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
      AppMethodBeat.o(197196);
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
    Typeface localTypeface = this.awy.getTypeface();
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
      localb = this.HCk;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.HCC) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.HCK) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.HCD)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.HCH);
        i = k + ((i1 - i2 - n - i - localb.HCL) / 2 + i);
      }
      else if (paramDrawable == localb.HCA)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.HCI) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.HCB)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.HCJ) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.HCF);
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
    Object localObject = this.HCk;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.HCl) && (((b)localObject).HCC != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).HCK) / 2);
        ((b)localObject).HCC.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.HCm)
      {
        f2 = f3;
        if (((b)localObject).HCD != null)
        {
          paramCanvas.save();
          if (!this.HCf) {
            break label694;
          }
          f1 = this.awy.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).HCL) / 2);
          ((b)localObject).HCD.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.HCn) && (((b)localObject).HCA != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).HCI) / 2, getPaddingTop() + i2);
        ((b)localObject).HCA.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.HCo)
      {
        f1 = f2;
        if (((b)localObject).HCB != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).HCJ) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).HCF);
          ((b)localObject).HCB.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.HBM;
    this.awy.setColor(i1);
    this.awy.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.Is & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.HCf)
    {
      f3 = (n - (this.HCh.bottom - this.HCh.top)) / 2 - this.HCh.top;
      j = 0;
      i = j;
      if ((this.Is & 0x7) != 3) {}
      switch (this.Is & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.awy);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.HBQ, this.awy));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.awy.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.awy.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.HBT == null) {
        fjc();
      }
      localObject = this.HBT;
      try
      {
        ((Layout)localObject).draw(paramCanvas, null, null, i - j);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ac.printErrStackTrace("TextView", localIndexOutOfBoundsException, "", new Object[0]);
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
    if (bs.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(142447);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142425);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.HCi) && (getMeasuredWidth() > 0))
    {
      if ((bs.isNullOrNil(this.HuH)) || (this.HCt == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.HCt.a(this, this.mText, this.HuH, this.HuI, this.HuJ);
      this.HuH = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.HCi = false;
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
      setMeasuredDimension(j, this.HCg);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.HCf)
    {
      if (this.HCg == 0) {
        fjd();
      }
      setMeasuredDimension(j, this.HCg);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.HCa)
    {
      paramInt1 = this.mMaxWidth - paramInt1;
      if (this.HBT != null) {
        break label165;
      }
      jA(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.HCc = -1;
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
      if (this.HBT.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        jA(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.HCc = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.HCk;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.HCM = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.HCk = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.HCp)
    {
      this.HCp = paramInt;
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
    if ((this.HCk != null) && (this.HCk.HCC == paramDrawable))
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
    if (paramInt != this.HCq)
    {
      this.HCq = paramInt;
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
    if ((this.HCk != null) && (this.HCk.HCD == paramDrawable))
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
    if (this.HCo != paramBoolean) {
      invalidate();
    }
    this.HCo = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.HCl != paramBoolean) {
      invalidate();
    }
    this.HCl = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.HCm != paramBoolean) {
      invalidate();
    }
    this.HCm = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.HCn != paramBoolean) {
      invalidate();
    }
    this.HCn = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.HBN = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.HBP = paramTruncateAt;
    if (this.HBT != null)
    {
      fjb();
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
      if ((i & 0x7) != (this.Is & 0x7)) {
        paramInt = 1;
      }
      if (i != this.Is) {
        invalidate();
      }
      this.Is = i;
      if ((this.HBT != null) && (paramInt != 0)) {
        jA(this.HBT.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.HBY = paramInt;
    this.HBW = paramInt;
    this.HBZ = 2;
    this.HBX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.HCd = paramBoolean;
    if (this.HBT != null)
    {
      fjb();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.HCt = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.HBY = paramInt;
    this.HBW = paramInt;
    this.HBZ = 1;
    this.HBX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.HBW = paramInt;
    this.HBX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.HBW = paramInt;
    this.HBX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.mMaxWidth = paramInt;
    this.HCa = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.HBY = paramInt;
    this.HBZ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.HBY = paramInt;
    this.HBZ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.mMinWidth = paramInt;
    this.HCb = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      fjb();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.awy.getFlags() != paramInt)
    {
      this.awy.setFlags(paramInt);
      if (this.HBT != null)
      {
        fjb();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.HCj = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.Hzq = paramBoolean;
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
    this.HBO = paramFactory;
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
    a(paramCharSequence, this.HBR);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.vSw = ColorStateList.valueOf(paramInt);
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
    if (this.vSw == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.vSw = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.HBR;
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
    if (this.awy.getTypeface() != paramTypeface)
    {
      this.awy.setTypeface(paramTypeface);
      if (this.HBT != null)
      {
        fjb();
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
    this.HCb = true;
    this.HCa = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.HCk != null))
    {
      if ((paramDrawable == this.HCk.HCC) || (paramDrawable == this.HCk.HCA) || (paramDrawable == this.HCk.HCD) || (paramDrawable == this.HCk.HCB))
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
    Drawable HCA;
    Drawable HCB;
    Drawable HCC;
    Drawable HCD;
    int HCE;
    int HCF;
    int HCG;
    int HCH;
    int HCI;
    int HCJ;
    int HCK;
    int HCL;
    int HCM;
    final Rect HCz;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.HCz = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */