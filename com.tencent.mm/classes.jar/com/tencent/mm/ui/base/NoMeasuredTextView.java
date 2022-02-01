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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics OVU;
  private ColorStateList BpJ;
  private int Ku;
  private String OOd;
  private int OOe;
  private int OOf;
  private boolean OSP;
  private boolean OVA;
  private boolean OVB;
  private int OVC;
  private boolean OVD;
  private BoringLayout OVE;
  private boolean OVF;
  private int OVG;
  private Paint.FontMetricsInt OVH;
  private boolean OVI;
  private boolean OVJ;
  private b OVK;
  private boolean OVL;
  public boolean OVM;
  private boolean OVN;
  private boolean OVO;
  private int OVP;
  private int OVQ;
  private int OVR;
  private int OVS;
  private NoMeasuredTextView.c OVT;
  private int OVm;
  private Editable.Factory OVn;
  private Spannable.Factory OVo;
  private TextUtils.TruncateAt OVp;
  private CharSequence OVq;
  private NoMeasuredTextView.a OVr;
  private KeyListener OVs;
  private Layout OVt;
  private float OVu;
  private float OVv;
  private int OVw;
  private int OVx;
  private int OVy;
  private int OVz;
  private TextPaint ayn;
  private int mMaxWidth;
  private int mMinWidth;
  private CharSequence mText;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    OVU = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.OVn = Editable.Factory.getInstance();
    this.OVo = Spannable.Factory.getInstance();
    this.OVp = null;
    this.OVr = NoMeasuredTextView.a.OVV;
    this.Ku = 51;
    this.OVu = 1.0F;
    this.OVv = 0.0F;
    this.OVw = 2147483647;
    this.OVx = 1;
    this.OVy = 0;
    this.OVz = 1;
    this.mMaxWidth = 2147483647;
    this.OVA = false;
    this.mMinWidth = 0;
    this.OVB = false;
    this.OVC = -1;
    this.OVD = true;
    this.OVF = false;
    this.OVI = false;
    this.OVJ = false;
    this.OVL = false;
    this.OVM = false;
    this.OVN = false;
    this.OVO = false;
    this.OVP = -1;
    this.OVQ = -1;
    this.OVR = -1;
    this.OVS = -1;
    this.mText = "";
    this.OVq = "";
    this.ayn = new TextPaint(1);
    this.ayn.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.OVH = this.ayn.getFontMetricsInt();
    gLt();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.OVK;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).OWm != 0) {
          break label58;
        }
        this.OVK = null;
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
      if (((b)localObject2).OWc != null) {
        ((b)localObject2).OWc.setCallback(null);
      }
      ((b)localObject2).OWc = null;
      if (((b)localObject2).OWa != null) {
        ((b)localObject2).OWa.setCallback(null);
      }
      ((b)localObject2).OWa = null;
      if (((b)localObject2).OWd != null) {
        ((b)localObject2).OWd.setCallback(null);
      }
      ((b)localObject2).OWd = null;
      if (((b)localObject2).OWb != null) {
        ((b)localObject2).OWb.setCallback(null);
      }
      ((b)localObject2).OWb = null;
      ((b)localObject2).OWk = 0;
      ((b)localObject2).OWg = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.OWl = 0;
      paramDrawable1.OWh = 0;
      label175:
      paramDrawable1.OWi = 0;
      paramDrawable1.OWe = 0;
      paramDrawable1.OWj = 0;
      paramDrawable1.OWf = 0;
    }
    label198:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.OVK = ((b)localObject1);
    }
    if ((((b)localObject1).OWc != paramDrawable1) && (((b)localObject1).OWc != null)) {
      ((b)localObject1).OWc.setCallback(null);
    }
    ((b)localObject1).OWc = paramDrawable1;
    if ((((b)localObject1).OWa != null) && (((b)localObject1).OWa != null)) {
      ((b)localObject1).OWa.setCallback(null);
    }
    ((b)localObject1).OWa = null;
    if ((((b)localObject1).OWd != paramDrawable2) && (((b)localObject1).OWd != null)) {
      ((b)localObject1).OWd.setCallback(null);
    }
    ((b)localObject1).OWd = paramDrawable2;
    if ((((b)localObject1).OWb != null) && (((b)localObject1).OWb != null)) {
      ((b)localObject1).OWb.setCallback(null);
    }
    ((b)localObject1).OWb = null;
    localObject2 = ((b)localObject1).OVZ;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).OWg = ((Rect)localObject2).width();
      ((b)localObject1).OWk = ((Rect)localObject2).height();
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
      ((b)localObject1).OWh = ((Rect)localObject2).width();
      ((b)localObject1).OWl = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label175;
      ((b)localObject1).OWk = 0;
      ((b)localObject1).OWg = 0;
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
        if (this.OVT != null)
        {
          localCharSequence = paramCharSequence;
          if (!Util.isNullOrNil(this.OOd))
          {
            localCharSequence = this.OVT.a(this, paramCharSequence, this.OOd, this.OOe, this.OOf);
            this.OOd = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.OVF = false;
        if ((parama != NoMeasuredTextView.a.OVX) && (this.OVs == null)) {
          break label241;
        }
        paramCharSequence = this.OVn.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.OVJ)
        {
          if (!this.OVA) {
            break label264;
          }
          i = this.mMaxWidth;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.mMaxWidth, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.ayn, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.OVr = parama;
        this.mText = localCharSequence;
        this.OVq = localCharSequence;
        alB(j);
        AppMethodBeat.o(142424);
        return;
        this.OVF = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.OVW) {
          break label131;
        }
        paramCharSequence = this.OVo.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.ayn, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.OVI = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void alB(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.OVF)
    {
      gLt();
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
    if (this.OVt == null)
    {
      gLs();
      if (this.OVt.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.OVt.getHeight();
    int j = this.OVt.getWidth();
    kZ(j, j - paramInt);
    if (this.OVp != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.OVt.getHeight();
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
  
  private void gLr()
  {
    if (((this.OVt instanceof BoringLayout)) && (this.OVE == null)) {
      this.OVE = ((BoringLayout)this.OVt);
    }
    this.OVt = null;
  }
  
  private void gLs()
  {
    AppMethodBeat.i(142433);
    if (this.OVA) {}
    for (int i = this.mMaxWidth - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      kZ(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void gLt()
  {
    AppMethodBeat.i(142438);
    if (this.OVG == 0) {
      this.OVG = ((int)(Math.ceil(this.OVH.descent - this.OVH.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    AppMethodBeat.i(258464);
    int j = 0;
    int k = this.Ku & 0x70;
    Layout localLayout = this.OVt;
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
      AppMethodBeat.o(258464);
      return i;
    }
  }
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(142437);
    Layout localLayout = this.OVt;
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
    if (this.OVx == 1)
    {
      k = j;
      if (j > this.OVw)
      {
        i = localLayout.getLineTop(this.OVw) + localLayout.getBottomPadding() + m;
        k = this.OVw;
      }
      if (this.OVz != 1) {
        break label161;
      }
      j = i;
      if (k < this.OVy) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.OVy - k) * j;; j = Math.max(i, this.OVy))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.OVw);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.Ku & 0x70;
    Layout localLayout = this.OVt;
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
  
  private void kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.Ku & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.OVp == null) || (this.OVs != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.OVt = new StaticLayout(this.OVq, 0, this.OVq.length(), this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, this.OVD, this.OVp, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.OVt = new StaticLayout(this.OVq, this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, this.OVD);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.ayn.getTextSize())
    {
      this.ayn.setTextSize(paramFloat);
      this.OVH = this.ayn.getFontMetricsInt();
      this.OVG = ((int)(Math.ceil(this.OVH.descent - this.OVH.ascent) + 2.0D));
      if (this.OVt != null)
      {
        gLr();
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
    int j = this.BpJ.getColorForState(getDrawableState(), 0);
    if (j != this.OVm)
    {
      this.OVm = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void aR(String paramString, int paramInt1, int paramInt2)
  {
    this.OOd = paramString;
    this.OOe = paramInt1;
    this.OOf = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.OVt != null)
    {
      i = this.OVt.getWidth();
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
    if (this.OVt != null)
    {
      i = this.OVt.getHeight();
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
    if ((this.BpJ != null) && (this.BpJ.isStateful())) {
      updateTextColors();
    }
    b localb = this.OVK;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.OWa != null) && (localb.OWa.isStateful())) {
        localb.OWa.setState(arrayOfInt);
      }
      if ((localb.OWb != null) && (localb.OWb.isStateful())) {
        localb.OWb.setState(arrayOfInt);
      }
      if ((localb.OWc != null) && (localb.OWc.isStateful())) {
        localb.OWc.setState(arrayOfInt);
      }
      if ((localb.OWd != null) && (localb.OWd.isStateful())) {
        localb.OWd.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.OVt == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.Ku & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.OVt.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.OVK;
    if (localb != null) {
      return localb.OWm;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.OVK;
    if (localb != null) {
      return new Drawable[] { localb.OWc, localb.OWa, localb.OWd, localb.OWb };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.OVK;
    if ((localb == null) || (localb.OWb == null) || (!this.OVO))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.OWm;
    int k = localb.OWf;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.OVK;
    if ((localb == null) || (localb.OWc == null) || (!this.OVL))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.OWm;
    int k = localb.OWg;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.OVK;
    if ((localb == null) || (localb.OWd == null) || (!this.OVM))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.OWm;
    int k = localb.OWh;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.OVK;
    if ((localb == null) || (localb.OWa == null) || (!this.OVN))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.OWm;
    int k = localb.OWe;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.OVm;
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
    return this.OVp;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.OVt == null) || (this.OVx != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.OVt.getLineCount() <= this.OVw)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.OVt.getLineTop(this.OVw);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.Ku & 0x70;
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
    if ((this.OVt == null) || (this.OVx != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.OVt.getLineCount() <= this.OVw)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.OVt.getLineTop(this.OVw);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.Ku & 0x70;
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
    if (this.OVt == null)
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
    int j = this.OVt.getLineForOffset(i);
    paramRect.top = this.OVt.getLineTop(j);
    paramRect.bottom = this.OVt.getLineBottom(j);
    paramRect.left = ((int)this.OVt.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.Ku & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.Ku;
  }
  
  public final Layout getLayout()
  {
    return this.OVt;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.OVt != null)
    {
      int i = this.OVt.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.ayn.getFontMetricsInt(null) * this.OVu + this.OVv);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.ayn;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.ayn.getFlags();
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
    return this.BpJ;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.ayn.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.ayn.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(258013);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.Ku & 0x70;
    Layout localLayout = this.OVt;
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
      AppMethodBeat.o(258013);
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
    Typeface localTypeface = this.ayn.getTypeface();
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
      localb = this.OVK;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.OWc) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.OWk) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.OWd)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.OWh);
        i = k + ((i1 - i2 - n - i - localb.OWl) / 2 + i);
      }
      else if (paramDrawable == localb.OWa)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.OWi) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.OWb)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.OWj) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.OWf);
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
    Object localObject = this.OVK;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.OVL) && (((b)localObject).OWc != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).OWk) / 2);
        ((b)localObject).OWc.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.OVM)
      {
        f2 = f3;
        if (((b)localObject).OWd != null)
        {
          paramCanvas.save();
          if (!this.OVF) {
            break label694;
          }
          f1 = this.ayn.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).OWl) / 2);
          ((b)localObject).OWd.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.OVN) && (((b)localObject).OWa != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).OWi) / 2, getPaddingTop() + i2);
        ((b)localObject).OWa.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.OVO)
      {
        f1 = f2;
        if (((b)localObject).OWb != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).OWj) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).OWf);
          ((b)localObject).OWb.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.OVm;
    this.ayn.setColor(i1);
    this.ayn.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.Ku & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.OVF)
    {
      f3 = (n - (this.OVH.bottom - this.OVH.top)) / 2 - this.OVH.top;
      j = 0;
      i = j;
      if ((this.Ku & 0x7) != 3) {}
      switch (this.Ku & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.ayn);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.OVq, this.ayn));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.ayn.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.ayn.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.OVt == null) {
        gLs();
      }
      localObject = this.OVt;
      try
      {
        ((Layout)localObject).draw(paramCanvas, null, null, i - j);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.printErrStackTrace("TextView", localIndexOutOfBoundsException, "", new Object[0]);
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
    if (Util.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(142447);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142425);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.OVI) && (getMeasuredWidth() > 0))
    {
      if ((Util.isNullOrNil(this.OOd)) || (this.OVT == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.OVT.a(this, this.mText, this.OOd, this.OOe, this.OOf);
      this.OOd = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.OVI = false;
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
      setMeasuredDimension(j, this.OVG);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.OVF)
    {
      if (this.OVG == 0) {
        gLt();
      }
      setMeasuredDimension(j, this.OVG);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.OVA)
    {
      paramInt1 = this.mMaxWidth - paramInt1;
      if (this.OVt != null) {
        break label165;
      }
      kZ(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.OVC = -1;
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
      if (this.OVt.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        kZ(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.OVC = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.OVK;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.OWm = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.OVK = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.OVP)
    {
      this.OVP = paramInt;
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
    if ((this.OVK != null) && (this.OVK.OWc == paramDrawable))
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
    if (paramInt != this.OVQ)
    {
      this.OVQ = paramInt;
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
    if ((this.OVK != null) && (this.OVK.OWd == paramDrawable))
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
    if (this.OVO != paramBoolean) {
      invalidate();
    }
    this.OVO = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.OVL != paramBoolean) {
      invalidate();
    }
    this.OVL = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.OVM != paramBoolean) {
      invalidate();
    }
    this.OVM = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.OVN != paramBoolean) {
      invalidate();
    }
    this.OVN = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.OVn = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.OVp = paramTruncateAt;
    if (this.OVt != null)
    {
      gLr();
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
      if ((i & 0x7) != (this.Ku & 0x7)) {
        paramInt = 1;
      }
      if (i != this.Ku) {
        invalidate();
      }
      this.Ku = i;
      if ((this.OVt != null) && (paramInt != 0)) {
        kZ(this.OVt.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.OVy = paramInt;
    this.OVw = paramInt;
    this.OVz = 2;
    this.OVx = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.OVD = paramBoolean;
    if (this.OVt != null)
    {
      gLr();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.OVT = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.OVy = paramInt;
    this.OVw = paramInt;
    this.OVz = 1;
    this.OVx = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.OVw = paramInt;
    this.OVx = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.OVw = paramInt;
    this.OVx = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.mMaxWidth = paramInt;
    this.OVA = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.OVy = paramInt;
    this.OVz = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.OVy = paramInt;
    this.OVz = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.mMinWidth = paramInt;
    this.OVB = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      gLr();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.ayn.getFlags() != paramInt)
    {
      this.ayn.setFlags(paramInt);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.OVJ = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.OSP = paramBoolean;
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
    this.OVo = paramFactory;
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
    a(paramCharSequence, this.OVr);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.BpJ = ColorStateList.valueOf(paramInt);
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
    if (this.BpJ == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.BpJ = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.OVr;
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
    if (this.ayn.getTypeface() != paramTypeface)
    {
      this.ayn.setTypeface(paramTypeface);
      if (this.OVt != null)
      {
        gLr();
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
    this.OVB = true;
    this.OVA = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.OVK != null))
    {
      if ((paramDrawable == this.OVK.OWc) || (paramDrawable == this.OVK.OWa) || (paramDrawable == this.OVK.OWd) || (paramDrawable == this.OVK.OWb))
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
    final Rect OVZ;
    Drawable OWa;
    Drawable OWb;
    Drawable OWc;
    Drawable OWd;
    int OWe;
    int OWf;
    int OWg;
    int OWh;
    int OWi;
    int OWj;
    int OWk;
    int OWl;
    int OWm;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.OVZ = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */