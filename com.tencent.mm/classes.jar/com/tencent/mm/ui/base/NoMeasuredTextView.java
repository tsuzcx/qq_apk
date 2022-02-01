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
  private static final BoringLayout.Metrics Wpg;
  private ColorStateList Hkc;
  private String Who;
  private int Whp;
  private int Whq;
  private boolean Wmc;
  private Spannable.Factory WoA;
  private TextUtils.TruncateAt WoB;
  private CharSequence WoC;
  private NoMeasuredTextView.a WoD;
  private KeyListener WoE;
  private Layout WoF;
  private float WoG;
  private float WoH;
  private int WoI;
  private int WoJ;
  private int WoK;
  private int WoL;
  private boolean WoM;
  private boolean WoN;
  private int WoO;
  private boolean WoP;
  private BoringLayout WoQ;
  private boolean WoR;
  private int WoS;
  private Paint.FontMetricsInt WoT;
  private boolean WoU;
  private boolean WoV;
  private b WoW;
  private boolean WoX;
  public boolean WoY;
  private boolean WoZ;
  private int Woy;
  private Editable.Factory Woz;
  private boolean Wpa;
  private int Wpb;
  private int Wpc;
  private int Wpd;
  private int Wpe;
  private NoMeasuredTextView.c Wpf;
  private int lj;
  private CharSequence mText;
  private int sK;
  private int uJ;
  private TextPaint wi;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    Wpg = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.Woz = Editable.Factory.getInstance();
    this.WoA = Spannable.Factory.getInstance();
    this.WoB = null;
    this.WoD = NoMeasuredTextView.a.Wph;
    this.sK = 51;
    this.WoG = 1.0F;
    this.WoH = 0.0F;
    this.WoI = 2147483647;
    this.WoJ = 1;
    this.WoK = 0;
    this.WoL = 1;
    this.uJ = 2147483647;
    this.WoM = false;
    this.lj = 0;
    this.WoN = false;
    this.WoO = -1;
    this.WoP = true;
    this.WoR = false;
    this.WoU = false;
    this.WoV = false;
    this.WoX = false;
    this.WoY = false;
    this.WoZ = false;
    this.Wpa = false;
    this.Wpb = -1;
    this.Wpc = -1;
    this.Wpd = -1;
    this.Wpe = -1;
    this.mText = "";
    this.WoC = "";
    this.wi = new TextPaint(1);
    this.wi.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.WoT = this.wi.getFontMetricsInt();
    hKu();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.WoW;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label198;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).Wpy != 0) {
          break label58;
        }
        this.WoW = null;
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
      if (((b)localObject2).Wpo != null) {
        ((b)localObject2).Wpo.setCallback(null);
      }
      ((b)localObject2).Wpo = null;
      if (((b)localObject2).Wpm != null) {
        ((b)localObject2).Wpm.setCallback(null);
      }
      ((b)localObject2).Wpm = null;
      if (((b)localObject2).Wpp != null) {
        ((b)localObject2).Wpp.setCallback(null);
      }
      ((b)localObject2).Wpp = null;
      if (((b)localObject2).Wpn != null) {
        ((b)localObject2).Wpn.setCallback(null);
      }
      ((b)localObject2).Wpn = null;
      ((b)localObject2).Wpw = 0;
      ((b)localObject2).Wps = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.Wpx = 0;
      paramDrawable1.Wpt = 0;
      label175:
      paramDrawable1.Wpu = 0;
      paramDrawable1.Wpq = 0;
      paramDrawable1.Wpv = 0;
      paramDrawable1.Wpr = 0;
    }
    label198:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.WoW = ((b)localObject1);
    }
    if ((((b)localObject1).Wpo != paramDrawable1) && (((b)localObject1).Wpo != null)) {
      ((b)localObject1).Wpo.setCallback(null);
    }
    ((b)localObject1).Wpo = paramDrawable1;
    if ((((b)localObject1).Wpm != null) && (((b)localObject1).Wpm != null)) {
      ((b)localObject1).Wpm.setCallback(null);
    }
    ((b)localObject1).Wpm = null;
    if ((((b)localObject1).Wpp != paramDrawable2) && (((b)localObject1).Wpp != null)) {
      ((b)localObject1).Wpp.setCallback(null);
    }
    ((b)localObject1).Wpp = paramDrawable2;
    if ((((b)localObject1).Wpn != null) && (((b)localObject1).Wpn != null)) {
      ((b)localObject1).Wpn.setCallback(null);
    }
    ((b)localObject1).Wpn = null;
    localObject2 = ((b)localObject1).Wpl;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).Wps = ((Rect)localObject2).width();
      ((b)localObject1).Wpw = ((Rect)localObject2).height();
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
      ((b)localObject1).Wpt = ((Rect)localObject2).width();
      ((b)localObject1).Wpx = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label175;
      ((b)localObject1).Wpw = 0;
      ((b)localObject1).Wps = 0;
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
        if (this.Wpf != null)
        {
          localCharSequence = paramCharSequence;
          if (!Util.isNullOrNil(this.Who))
          {
            localCharSequence = this.Wpf.a(this, paramCharSequence, this.Who, this.Whp, this.Whq);
            this.Who = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.WoR = false;
        if ((parama != NoMeasuredTextView.a.Wpj) && (this.WoE == null)) {
          break label241;
        }
        paramCharSequence = this.Woz.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.WoV)
        {
          if (!this.WoM) {
            break label264;
          }
          i = this.uJ;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.uJ, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.wi, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.WoD = parama;
        this.mText = localCharSequence;
        this.WoC = localCharSequence;
        auz(j);
        AppMethodBeat.o(142424);
        return;
        this.WoR = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.Wpi) {
          break label131;
        }
        paramCharSequence = this.WoA.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.wi, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.WoU = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void auz(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.WoR)
    {
      hKu();
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
    if (this.WoF == null)
    {
      hKt();
      if (this.WoF.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.WoF.getHeight();
    int j = this.WoF.getWidth();
    mr(j, j - paramInt);
    if (this.WoB != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.WoF.getHeight();
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
    Layout localLayout = this.WoF;
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
    if (this.WoJ == 1)
    {
      k = j;
      if (j > this.WoI)
      {
        i = localLayout.getLineTop(this.WoI) + localLayout.getBottomPadding() + m;
        k = this.WoI;
      }
      if (this.WoL != 1) {
        break label161;
      }
      j = i;
      if (k < this.WoK) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.WoK - k) * j;; j = Math.max(i, this.WoK))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.WoI);
      k = j;
      break;
    }
  }
  
  private int hKr()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.sK & 0x70;
    Layout localLayout = this.WoF;
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
  
  private void hKs()
  {
    if (((this.WoF instanceof BoringLayout)) && (this.WoQ == null)) {
      this.WoQ = ((BoringLayout)this.WoF);
    }
    this.WoF = null;
  }
  
  private void hKt()
  {
    AppMethodBeat.i(142433);
    if (this.WoM) {}
    for (int i = this.uJ - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      mr(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void hKu()
  {
    AppMethodBeat.i(142438);
    if (this.WoS == 0) {
      this.WoS = ((int)(Math.ceil(this.WoT.descent - this.WoT.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private void mr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.sK & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.WoB == null) || (this.WoE != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.WoF = new StaticLayout(this.WoC, 0, this.WoC.length(), this.wi, paramInt1, localAlignment, this.WoG, this.WoH, this.WoP, this.WoB, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.WoF = new StaticLayout(this.WoC, this.wi, paramInt1, localAlignment, this.WoG, this.WoH, this.WoP);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.wi.getTextSize())
    {
      this.wi.setTextSize(paramFloat);
      this.WoT = this.wi.getFontMetricsInt();
      this.WoS = ((int)(Math.ceil(this.WoT.descent - this.WoT.ascent) + 2.0D));
      if (this.WoF != null)
      {
        hKs();
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
    int j = this.Hkc.getColorForState(getDrawableState(), 0);
    if (j != this.Woy)
    {
      this.Woy = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void aT(String paramString, int paramInt1, int paramInt2)
  {
    this.Who = paramString;
    this.Whp = paramInt1;
    this.Whq = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.WoF != null)
    {
      i = this.WoF.getWidth();
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
    if (this.WoF != null)
    {
      i = this.WoF.getHeight();
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
    if ((this.Hkc != null) && (this.Hkc.isStateful())) {
      updateTextColors();
    }
    b localb = this.WoW;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.Wpm != null) && (localb.Wpm.isStateful())) {
        localb.Wpm.setState(arrayOfInt);
      }
      if ((localb.Wpn != null) && (localb.Wpn.isStateful())) {
        localb.Wpn.setState(arrayOfInt);
      }
      if ((localb.Wpo != null) && (localb.Wpo.isStateful())) {
        localb.Wpo.setState(arrayOfInt);
      }
      if ((localb.Wpp != null) && (localb.Wpp.isStateful())) {
        localb.Wpp.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.WoF == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.sK & 0x70) != 48) {}
    for (int i = hKr();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.WoF.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.WoW;
    if (localb != null) {
      return localb.Wpy;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.WoW;
    if (localb != null) {
      return new Drawable[] { localb.Wpo, localb.Wpm, localb.Wpp, localb.Wpn };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.WoW;
    if ((localb == null) || (localb.Wpn == null) || (!this.Wpa))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.Wpy;
    int k = localb.Wpr;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.WoW;
    if ((localb == null) || (localb.Wpo == null) || (!this.WoX))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.Wpy;
    int k = localb.Wps;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.WoW;
    if ((localb == null) || (localb.Wpp == null) || (!this.WoY))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.Wpy;
    int k = localb.Wpt;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.WoW;
    if ((localb == null) || (localb.Wpm == null) || (!this.WoZ))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.Wpy;
    int k = localb.Wpq;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.Woy;
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
    return this.WoB;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.WoF == null) || (this.WoJ != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.WoF.getLineCount() <= this.WoI)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.WoF.getLineTop(this.WoI);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.sK & 0x70;
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
    if ((this.WoF == null) || (this.WoJ != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.WoF.getLineCount() <= this.WoI)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.WoF.getLineTop(this.WoI);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.sK & 0x70;
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
    if (this.WoF == null)
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
    int j = this.WoF.getLineForOffset(i);
    paramRect.top = this.WoF.getLineTop(j);
    paramRect.bottom = this.WoF.getLineBottom(j);
    paramRect.left = ((int)this.WoF.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.sK & 0x70) != 48) {
      i = j + hKr();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.sK;
  }
  
  public final Layout getLayout()
  {
    return this.WoF;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.WoF != null)
    {
      int i = this.WoF.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.wi.getFontMetricsInt(null) * this.WoG + this.WoH);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.wi;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.wi.getFlags();
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
    return this.Hkc;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.wi.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.wi.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(142396);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.sK & 0x70;
    Layout localLayout = this.WoF;
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
    int j = hKr();
    AppMethodBeat.o(142395);
    return i + j;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(142404);
    Typeface localTypeface = this.wi.getTypeface();
    AppMethodBeat.o(142404);
    return localTypeface;
  }
  
  public final boolean hKq()
  {
    return this.WoY;
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
      localb = this.WoW;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.Wpo) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.Wpw) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.Wpp)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.Wpt);
        i = k + ((i1 - i2 - n - i - localb.Wpx) / 2 + i);
      }
      else if (paramDrawable == localb.Wpm)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.Wpu) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.Wpn)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.Wpv) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.Wpr);
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
    Object localObject = this.WoW;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.WoX) && (((b)localObject).Wpo != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).Wpw) / 2);
        ((b)localObject).Wpo.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.WoY)
      {
        f2 = f3;
        if (((b)localObject).Wpp != null)
        {
          paramCanvas.save();
          if (!this.WoR) {
            break label694;
          }
          f1 = this.wi.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).Wpx) / 2);
          ((b)localObject).Wpp.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.WoZ) && (((b)localObject).Wpm != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).Wpu) / 2, getPaddingTop() + i2);
        ((b)localObject).Wpm.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.Wpa)
      {
        f1 = f2;
        if (((b)localObject).Wpn != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).Wpv) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).Wpr);
          ((b)localObject).Wpn.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.Woy;
    this.wi.setColor(i1);
    this.wi.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.sK & 0x70) != 48)
    {
      j = hKr();
      i = hKr();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.WoR)
    {
      f3 = (n - (this.WoT.bottom - this.WoT.top)) / 2 - this.WoT.top;
      j = 0;
      i = j;
      if ((this.sK & 0x7) != 3) {}
      switch (this.sK & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.wi);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.WoC, this.wi));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.wi.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.wi.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.WoF == null) {
        hKt();
      }
      localObject = this.WoF;
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
    if ((this.WoU) && (getMeasuredWidth() > 0))
    {
      if ((Util.isNullOrNil(this.Who)) || (this.Wpf == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.Wpf.a(this, this.mText, this.Who, this.Whp, this.Whq);
      this.Who = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.WoU = false;
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
      setMeasuredDimension(j, this.WoS);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.WoR)
    {
      if (this.WoS == 0) {
        hKu();
      }
      setMeasuredDimension(j, this.WoS);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.WoM)
    {
      paramInt1 = this.uJ - paramInt1;
      if (this.WoF != null) {
        break label165;
      }
      mr(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.WoO = -1;
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
      if (this.WoF.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        mr(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.WoO = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.WoW;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.Wpy = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.WoW = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.Wpb)
    {
      this.Wpb = paramInt;
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
    if ((this.WoW != null) && (this.WoW.Wpo == paramDrawable))
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
    if (paramInt != this.Wpc)
    {
      this.Wpc = paramInt;
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
    if ((this.WoW != null) && (this.WoW.Wpp == paramDrawable))
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
    if (this.Wpa != paramBoolean) {
      invalidate();
    }
    this.Wpa = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.WoX != paramBoolean) {
      invalidate();
    }
    this.WoX = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.WoY != paramBoolean) {
      invalidate();
    }
    this.WoY = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.WoZ != paramBoolean) {
      invalidate();
    }
    this.WoZ = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.Woz = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.WoB = paramTruncateAt;
    if (this.WoF != null)
    {
      hKs();
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
      if ((i & 0x7) != (this.sK & 0x7)) {
        paramInt = 1;
      }
      if (i != this.sK) {
        invalidate();
      }
      this.sK = i;
      if ((this.WoF != null) && (paramInt != 0)) {
        mr(this.WoF.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.WoK = paramInt;
    this.WoI = paramInt;
    this.WoL = 2;
    this.WoJ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.WoP = paramBoolean;
    if (this.WoF != null)
    {
      hKs();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.Wpf = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.WoK = paramInt;
    this.WoI = paramInt;
    this.WoL = 1;
    this.WoJ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.WoI = paramInt;
    this.WoJ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.WoI = paramInt;
    this.WoJ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.uJ = paramInt;
    this.WoM = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.WoK = paramInt;
    this.WoL = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.WoK = paramInt;
    this.WoL = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.lj = paramInt;
    this.WoN = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      hKs();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.wi.getFlags() != paramInt)
    {
      this.wi.setFlags(paramInt);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.WoV = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.Wmc = paramBoolean;
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
    this.WoA = paramFactory;
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
    a(paramCharSequence, this.WoD);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.Hkc = ColorStateList.valueOf(paramInt);
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
    if (this.Hkc == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.Hkc = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.WoD;
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
    if (this.wi.getTypeface() != paramTypeface)
    {
      this.wi.setTypeface(paramTypeface);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142403);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(142418);
    this.lj = paramInt;
    this.uJ = paramInt;
    this.WoN = true;
    this.WoM = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.WoW != null))
    {
      if ((paramDrawable == this.WoW.Wpo) || (paramDrawable == this.WoW.Wpm) || (paramDrawable == this.WoW.Wpp) || (paramDrawable == this.WoW.Wpn))
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
    final Rect Wpl;
    Drawable Wpm;
    Drawable Wpn;
    Drawable Wpo;
    Drawable Wpp;
    int Wpq;
    int Wpr;
    int Wps;
    int Wpt;
    int Wpu;
    int Wpv;
    int Wpw;
    int Wpx;
    int Wpy;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.Wpl = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */