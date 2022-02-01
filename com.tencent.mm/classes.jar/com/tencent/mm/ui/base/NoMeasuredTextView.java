package com.tencent.mm.ui.base;

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

public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics adWu;
  private ColorStateList NhP;
  private String adOl;
  private int adOm;
  private int adOn;
  private boolean adTq;
  private int adVN;
  private Editable.Factory adVO;
  private Spannable.Factory adVP;
  private TextUtils.TruncateAt adVQ;
  private CharSequence adVR;
  private NoMeasuredTextView.a adVS;
  private KeyListener adVT;
  private float adVU;
  private float adVV;
  private int adVW;
  private int adVX;
  private int adVY;
  private int adVZ;
  private boolean adWa;
  private boolean adWb;
  private int adWc;
  private boolean adWd;
  private BoringLayout adWe;
  private boolean adWf;
  private int adWg;
  private Paint.FontMetricsInt adWh;
  private boolean adWi;
  private boolean adWj;
  private b adWk;
  private boolean adWl;
  public boolean adWm;
  private boolean adWn;
  private boolean adWo;
  private int adWp;
  private int adWq;
  private int adWr;
  private int adWs;
  private NoMeasuredTextView.c adWt;
  private Layout mLayout;
  private CharSequence mText;
  private int mf;
  private int tJ;
  private int vF;
  private TextPaint xe;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    adWu = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.adVO = Editable.Factory.getInstance();
    this.adVP = Spannable.Factory.getInstance();
    this.adVQ = null;
    this.adVS = NoMeasuredTextView.a.adWv;
    this.tJ = 51;
    this.adVU = 1.0F;
    this.adVV = 0.0F;
    this.adVW = 2147483647;
    this.adVX = 1;
    this.adVY = 0;
    this.adVZ = 1;
    this.vF = 2147483647;
    this.adWa = false;
    this.mf = 0;
    this.adWb = false;
    this.adWc = -1;
    this.adWd = true;
    this.adWf = false;
    this.adWi = false;
    this.adWj = false;
    this.adWl = false;
    this.adWm = false;
    this.adWn = false;
    this.adWo = false;
    this.adWp = -1;
    this.adWq = -1;
    this.adWr = -1;
    this.adWs = -1;
    this.mText = "";
    this.adVR = "";
    this.xe = new TextPaint(1);
    this.xe.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.adWh = this.xe.getFontMetricsInt();
    jmZ();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.adWk;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).adWM != 0) {
          break label58;
        }
        this.adWk = null;
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
      if (((b)localObject2).adWC != null) {
        ((b)localObject2).adWC.setCallback(null);
      }
      ((b)localObject2).adWC = null;
      if (((b)localObject2).adWA != null) {
        ((b)localObject2).adWA.setCallback(null);
      }
      ((b)localObject2).adWA = null;
      if (((b)localObject2).adWD != null) {
        ((b)localObject2).adWD.setCallback(null);
      }
      ((b)localObject2).adWD = null;
      if (((b)localObject2).adWB != null) {
        ((b)localObject2).adWB.setCallback(null);
      }
      ((b)localObject2).adWB = null;
      ((b)localObject2).adWK = 0;
      ((b)localObject2).adWG = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.adWL = 0;
      paramDrawable1.adWH = 0;
      label175:
      paramDrawable1.adWI = 0;
      paramDrawable1.adWE = 0;
      paramDrawable1.adWJ = 0;
      paramDrawable1.adWF = 0;
    }
    label198:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.adWk = ((b)localObject1);
    }
    if ((((b)localObject1).adWC != paramDrawable1) && (((b)localObject1).adWC != null)) {
      ((b)localObject1).adWC.setCallback(null);
    }
    ((b)localObject1).adWC = paramDrawable1;
    if ((((b)localObject1).adWA != null) && (((b)localObject1).adWA != null)) {
      ((b)localObject1).adWA.setCallback(null);
    }
    ((b)localObject1).adWA = null;
    if ((((b)localObject1).adWD != paramDrawable2) && (((b)localObject1).adWD != null)) {
      ((b)localObject1).adWD.setCallback(null);
    }
    ((b)localObject1).adWD = paramDrawable2;
    if ((((b)localObject1).adWB != null) && (((b)localObject1).adWB != null)) {
      ((b)localObject1).adWB.setCallback(null);
    }
    ((b)localObject1).adWB = null;
    localObject2 = ((b)localObject1).adWz;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).adWG = ((Rect)localObject2).width();
      ((b)localObject1).adWK = ((Rect)localObject2).height();
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
      ((b)localObject1).adWH = ((Rect)localObject2).width();
      ((b)localObject1).adWL = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label175;
      ((b)localObject1).adWK = 0;
      ((b)localObject1).adWG = 0;
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
        if (this.adWt != null)
        {
          localCharSequence = paramCharSequence;
          if (!Util.isNullOrNil(this.adOl))
          {
            localCharSequence = this.adWt.a(this, paramCharSequence, this.adOl, this.adOm, this.adOn);
            this.adOl = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.adWf = false;
        if ((parama != NoMeasuredTextView.a.adWx) && (this.adVT == null)) {
          break label241;
        }
        paramCharSequence = this.adVO.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.adWj)
        {
          if (!this.adWa) {
            break label264;
          }
          i = this.vF;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.vF, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.xe, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.adVS = parama;
        this.mText = localCharSequence;
        this.adVR = localCharSequence;
        aBa(j);
        AppMethodBeat.o(142424);
        return;
        this.adWf = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.adWw) {
          break label131;
        }
        paramCharSequence = this.adVP.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.xe, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.adWi = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void aBa(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.adWf)
    {
      jmZ();
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
    if (this.mLayout == null)
    {
      jmY();
      if (this.mLayout.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.mLayout.getHeight();
    int j = this.mLayout.getWidth();
    ol(j, j - paramInt);
    if (this.adVQ != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.mLayout.getHeight();
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
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(142437);
    Layout localLayout = this.mLayout;
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
    if (this.adVX == 1)
    {
      k = j;
      if (j > this.adVW)
      {
        i = localLayout.getLineTop(this.adVW) + localLayout.getBottomPadding() + m;
        k = this.adVW;
      }
      if (this.adVZ != 1) {
        break label161;
      }
      j = i;
      if (k < this.adVY) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.adVY - k) * j;; j = Math.max(i, this.adVY))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.adVW);
      k = j;
      break;
    }
  }
  
  private int jmW()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.tJ & 0x70;
    Layout localLayout = this.mLayout;
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
  
  private void jmX()
  {
    if (((this.mLayout instanceof BoringLayout)) && (this.adWe == null)) {
      this.adWe = ((BoringLayout)this.mLayout);
    }
    this.mLayout = null;
  }
  
  private void jmY()
  {
    AppMethodBeat.i(142433);
    if (this.adWa) {}
    for (int i = this.vF - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      ol(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void jmZ()
  {
    AppMethodBeat.i(142438);
    if (this.adWg == 0) {
      this.adWg = ((int)(Math.ceil(this.adWh.descent - this.adWh.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private void ol(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.tJ & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.adVQ == null) || (this.adVT != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.mLayout = new StaticLayout(this.adVR, 0, this.adVR.length(), this.xe, paramInt1, localAlignment, this.adVU, this.adVV, this.adWd, this.adVQ, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.mLayout = new StaticLayout(this.adVR, this.xe, paramInt1, localAlignment, this.adVU, this.adVV, this.adWd);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.xe.getTextSize())
    {
      this.xe.setTextSize(paramFloat);
      this.adWh = this.xe.getFontMetricsInt();
      this.adWg = ((int)(Math.ceil(this.adWh.descent - this.adWh.ascent) + 2.0D));
      if (this.mLayout != null)
      {
        jmX();
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
    int j = this.NhP.getColorForState(getDrawableState(), 0);
    if (j != this.adVN)
    {
      this.adVN = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void bc(String paramString, int paramInt1, int paramInt2)
  {
    this.adOl = paramString;
    this.adOm = paramInt1;
    this.adOn = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.mLayout != null)
    {
      i = this.mLayout.getWidth();
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
    if (this.mLayout != null)
    {
      i = this.mLayout.getHeight();
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
    if ((this.NhP != null) && (this.NhP.isStateful())) {
      updateTextColors();
    }
    b localb = this.adWk;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.adWA != null) && (localb.adWA.isStateful())) {
        localb.adWA.setState(arrayOfInt);
      }
      if ((localb.adWB != null) && (localb.adWB.isStateful())) {
        localb.adWB.setState(arrayOfInt);
      }
      if ((localb.adWC != null) && (localb.adWC.isStateful())) {
        localb.adWC.setState(arrayOfInt);
      }
      if ((localb.adWD != null) && (localb.adWD.isStateful())) {
        localb.adWD.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.mLayout == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.tJ & 0x70) != 48) {}
    for (int i = jmW();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.mLayout.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.adWk;
    if (localb != null) {
      return localb.adWM;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.adWk;
    if (localb != null) {
      return new Drawable[] { localb.adWC, localb.adWA, localb.adWD, localb.adWB };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.adWk;
    if ((localb == null) || (localb.adWB == null) || (!this.adWo))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.adWM;
    int k = localb.adWF;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.adWk;
    if ((localb == null) || (localb.adWC == null) || (!this.adWl))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.adWM;
    int k = localb.adWG;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.adWk;
    if ((localb == null) || (localb.adWD == null) || (!this.adWm))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.adWM;
    int k = localb.adWH;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.adWk;
    if ((localb == null) || (localb.adWA == null) || (!this.adWn))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.adWM;
    int k = localb.adWE;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.adVN;
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
    return this.adVQ;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.mLayout == null) || (this.adVX != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.mLayout.getLineCount() <= this.adVW)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.mLayout.getLineTop(this.adVW);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.tJ & 0x70;
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
    if ((this.mLayout == null) || (this.adVX != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.mLayout.getLineCount() <= this.adVW)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.mLayout.getLineTop(this.adVW);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.tJ & 0x70;
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
    if (this.mLayout == null)
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
    int j = this.mLayout.getLineForOffset(i);
    paramRect.top = this.mLayout.getLineTop(j);
    paramRect.bottom = this.mLayout.getLineBottom(j);
    paramRect.left = ((int)this.mLayout.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.tJ & 0x70) != 48) {
      i = j + jmW();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.tJ;
  }
  
  public final Layout getLayout()
  {
    return this.mLayout;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.mLayout != null)
    {
      int i = this.mLayout.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.xe.getFontMetricsInt(null) * this.adVU + this.adVV);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.xe;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.xe.getFlags();
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
    return this.NhP;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.xe.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.xe.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(142396);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.tJ & 0x70;
    Layout localLayout = this.mLayout;
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
      AppMethodBeat.o(142396);
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
    int j = jmW();
    AppMethodBeat.o(142395);
    return i + j;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(142404);
    Typeface localTypeface = this.xe.getTypeface();
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
      localb = this.adWk;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.adWC) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.adWK) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.adWD)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.adWH);
        i = k + ((i1 - i2 - n - i - localb.adWL) / 2 + i);
      }
      else if (paramDrawable == localb.adWA)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.adWI) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.adWB)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.adWJ) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.adWF);
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
    Object localObject = this.adWk;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.adWl) && (((b)localObject).adWC != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).adWK) / 2);
        ((b)localObject).adWC.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.adWm)
      {
        f2 = f3;
        if (((b)localObject).adWD != null)
        {
          paramCanvas.save();
          if (!this.adWf) {
            break label694;
          }
          f1 = this.xe.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).adWL) / 2);
          ((b)localObject).adWD.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.adWn) && (((b)localObject).adWA != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).adWI) / 2, getPaddingTop() + i2);
        ((b)localObject).adWA.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.adWo)
      {
        f1 = f2;
        if (((b)localObject).adWB != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).adWJ) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).adWF);
          ((b)localObject).adWB.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.adVN;
    this.xe.setColor(i1);
    this.xe.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.tJ & 0x70) != 48)
    {
      j = jmW();
      i = jmW();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.adWf)
    {
      f3 = (n - (this.adWh.bottom - this.adWh.top)) / 2 - this.adWh.top;
      j = 0;
      i = j;
      if ((this.tJ & 0x7) != 3) {}
      switch (this.tJ & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.xe);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.adVR, this.xe));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.xe.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.xe.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.mLayout == null) {
        jmY();
      }
      localObject = this.mLayout;
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
    if ((this.adWi) && (getMeasuredWidth() > 0))
    {
      if ((Util.isNullOrNil(this.adOl)) || (this.adWt == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.adWt.a(this, this.mText, this.adOl, this.adOm, this.adOn);
      this.adOl = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.adWi = false;
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
      setMeasuredDimension(j, this.adWg);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.adWf)
    {
      if (this.adWg == 0) {
        jmZ();
      }
      setMeasuredDimension(j, this.adWg);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.adWa)
    {
      paramInt1 = this.vF - paramInt1;
      if (this.mLayout != null) {
        break label165;
      }
      ol(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.adWc = -1;
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
      if (this.mLayout.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        ol(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.adWc = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.adWk;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.adWM = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.adWk = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.adWp)
    {
      this.adWp = paramInt;
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
    if ((this.adWk != null) && (this.adWk.adWC == paramDrawable))
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
    if (paramInt != this.adWq)
    {
      this.adWq = paramInt;
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
    if ((this.adWk != null) && (this.adWk.adWD == paramDrawable))
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
    if (this.adWo != paramBoolean) {
      invalidate();
    }
    this.adWo = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.adWl != paramBoolean) {
      invalidate();
    }
    this.adWl = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.adWm != paramBoolean) {
      invalidate();
    }
    this.adWm = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.adWn != paramBoolean) {
      invalidate();
    }
    this.adWn = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.adVO = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.adVQ = paramTruncateAt;
    if (this.mLayout != null)
    {
      jmX();
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
      if ((i & 0x7) != (this.tJ & 0x7)) {
        paramInt = 1;
      }
      if (i != this.tJ) {
        invalidate();
      }
      this.tJ = i;
      if ((this.mLayout != null) && (paramInt != 0)) {
        ol(this.mLayout.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.adVY = paramInt;
    this.adVW = paramInt;
    this.adVZ = 2;
    this.adVX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.adWd = paramBoolean;
    if (this.mLayout != null)
    {
      jmX();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.adWt = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.adVY = paramInt;
    this.adVW = paramInt;
    this.adVZ = 1;
    this.adVX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.adVW = paramInt;
    this.adVX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.adVW = paramInt;
    this.adVX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.vF = paramInt;
    this.adWa = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.adVY = paramInt;
    this.adVZ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.adVY = paramInt;
    this.adVZ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.mf = paramInt;
    this.adWb = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      jmX();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.xe.getFlags() != paramInt)
    {
      this.xe.setFlags(paramInt);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.adWj = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.adTq = paramBoolean;
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
    this.adVP = paramFactory;
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
    a(paramCharSequence, this.adVS);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.NhP = ColorStateList.valueOf(paramInt);
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
    if (this.NhP == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.NhP = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.adVS;
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
    if (this.xe.getTypeface() != paramTypeface)
    {
      this.xe.setTypeface(paramTypeface);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142403);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(142418);
    this.mf = paramInt;
    this.vF = paramInt;
    this.adWb = true;
    this.adWa = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.adWk != null))
    {
      if ((paramDrawable == this.adWk.adWC) || (paramDrawable == this.adWk.adWA) || (paramDrawable == this.adWk.adWD) || (paramDrawable == this.adWk.adWB))
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
    Drawable adWA;
    Drawable adWB;
    Drawable adWC;
    Drawable adWD;
    int adWE;
    int adWF;
    int adWG;
    int adWH;
    int adWI;
    int adWJ;
    int adWK;
    int adWL;
    int adWM;
    final Rect adWz;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.adWz = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */