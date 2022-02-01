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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics GcF;
  private String FUT;
  private int FUU;
  private int FUV;
  private boolean FZC;
  private int GbX;
  private Editable.Factory GbY;
  private Spannable.Factory GbZ;
  private int GcA;
  private int GcB;
  private int GcC;
  private int GcD;
  private NoMeasuredTextView.c GcE;
  private TextUtils.TruncateAt Gca;
  private CharSequence Gcb;
  private NoMeasuredTextView.a Gcc;
  private KeyListener Gcd;
  private Layout Gce;
  private float Gcf;
  private float Gcg;
  private int Gch;
  private int Gci;
  private int Gcj;
  private int Gck;
  private boolean Gcl;
  private boolean Gcm;
  private int Gcn;
  private boolean Gco;
  private BoringLayout Gcp;
  private boolean Gcq;
  private int Gcr;
  private Paint.FontMetricsInt Gcs;
  private boolean Gct;
  private boolean Gcu;
  private b Gcv;
  private boolean Gcw;
  public boolean Gcx;
  private boolean Gcy;
  private boolean Gcz;
  private int Hu;
  private TextPaint avD;
  private int mMaxWidth;
  private int mMinWidth;
  private CharSequence mText;
  private ColorStateList uJF;
  
  static
  {
    AppMethodBeat.i(142448);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    GcF = new BoringLayout.Metrics();
    AppMethodBeat.o(142448);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142376);
    this.GbY = Editable.Factory.getInstance();
    this.GbZ = Spannable.Factory.getInstance();
    this.Gca = null;
    this.Gcc = NoMeasuredTextView.a.GcG;
    this.Hu = 51;
    this.Gcf = 1.0F;
    this.Gcg = 0.0F;
    this.Gch = 2147483647;
    this.Gci = 1;
    this.Gcj = 0;
    this.Gck = 1;
    this.mMaxWidth = 2147483647;
    this.Gcl = false;
    this.mMinWidth = 0;
    this.Gcm = false;
    this.Gcn = -1;
    this.Gco = true;
    this.Gcq = false;
    this.Gct = false;
    this.Gcu = false;
    this.Gcw = false;
    this.Gcx = false;
    this.Gcy = false;
    this.Gcz = false;
    this.GcA = -1;
    this.GcB = -1;
    this.GcC = -1;
    this.GcD = -1;
    this.mText = "";
    this.Gcb = "";
    this.avD = new TextPaint(1);
    this.avD.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.Gcs = this.avD.getFontMetricsInt();
    eTs();
    setSingleLine(true);
    setEllipsize(null);
    AppMethodBeat.o(142376);
  }
  
  private void XP(int paramInt)
  {
    AppMethodBeat.i(142439);
    if (this.Gcq)
    {
      eTs();
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
    if (this.Gce == null)
    {
      eTr();
      if (this.Gce.getHeight() != getHeight()) {
        requestLayout();
      }
      invalidate();
      AppMethodBeat.o(142439);
      return;
    }
    int i = this.Gce.getHeight();
    int j = this.Gce.getWidth();
    jn(j, j - paramInt);
    if (this.Gca != TextUtils.TruncateAt.MARQUEE)
    {
      if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
      {
        invalidate();
        AppMethodBeat.o(142439);
        return;
      }
      paramInt = this.Gce.getHeight();
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
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    AppMethodBeat.i(142378);
    Object localObject2 = this.Gcv;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label200;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).GcX != 0) {
          break label60;
        }
        this.Gcv = null;
      }
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(142378);
      return;
      i = 0;
      break;
      label60:
      if (((b)localObject2).GcN != null) {
        ((b)localObject2).GcN.setCallback(null);
      }
      ((b)localObject2).GcN = null;
      if (((b)localObject2).GcL != null) {
        ((b)localObject2).GcL.setCallback(null);
      }
      ((b)localObject2).GcL = null;
      if (((b)localObject2).GcO != null) {
        ((b)localObject2).GcO.setCallback(null);
      }
      ((b)localObject2).GcO = null;
      if (((b)localObject2).GcM != null) {
        ((b)localObject2).GcM.setCallback(null);
      }
      ((b)localObject2).GcM = null;
      ((b)localObject2).GcV = 0;
      ((b)localObject2).GcR = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.GcW = 0;
      paramDrawable1.GcS = 0;
      label177:
      paramDrawable1.GcT = 0;
      paramDrawable1.GcP = 0;
      paramDrawable1.GcU = 0;
      paramDrawable1.GcQ = 0;
    }
    label200:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.Gcv = ((b)localObject1);
    }
    if ((((b)localObject1).GcN != paramDrawable1) && (((b)localObject1).GcN != null)) {
      ((b)localObject1).GcN.setCallback(null);
    }
    ((b)localObject1).GcN = paramDrawable1;
    if ((((b)localObject1).GcL != null) && (((b)localObject1).GcL != null)) {
      ((b)localObject1).GcL.setCallback(null);
    }
    ((b)localObject1).GcL = null;
    if ((((b)localObject1).GcO != paramDrawable2) && (((b)localObject1).GcO != null)) {
      ((b)localObject1).GcO.setCallback(null);
    }
    ((b)localObject1).GcO = paramDrawable2;
    if ((((b)localObject1).GcM != null) && (((b)localObject1).GcM != null)) {
      ((b)localObject1).GcM.setCallback(null);
    }
    ((b)localObject1).GcM = null;
    localObject2 = ((b)localObject1).GcK;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).GcR = ((Rect)localObject2).width();
      ((b)localObject1).GcV = ((Rect)localObject2).height();
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
      ((b)localObject1).GcS = ((Rect)localObject2).width();
      ((b)localObject1).GcW = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label177;
      ((b)localObject1).GcV = 0;
      ((b)localObject1).GcR = 0;
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
        if (this.GcE != null)
        {
          localCharSequence = paramCharSequence;
          if (!bt.isNullOrNil(this.FUT))
          {
            localCharSequence = this.GcE.a(this, paramCharSequence, this.FUT, this.FUU, this.FUV);
            this.FUT = null;
          }
        }
      }
      label131:
      int j;
      if ((localCharSequence instanceof Spanned))
      {
        this.Gcq = false;
        if ((parama != NoMeasuredTextView.a.GcI) && (this.Gcd == null)) {
          break label241;
        }
        paramCharSequence = this.GbY.newEditable(localCharSequence);
        int i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.Gcu)
        {
          if (!this.Gcl) {
            break label264;
          }
          i = this.mMaxWidth;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.mMaxWidth, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.avD, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.Gcc = parama;
        this.mText = localCharSequence;
        this.Gcb = localCharSequence;
        XP(j);
        AppMethodBeat.o(142424);
        return;
        this.Gcq = true;
        break;
        label241:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.GcH) {
          break label131;
        }
        paramCharSequence = this.GbZ.newSpannable(localCharSequence);
        break label131;
        label264:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.avD, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.Gct = true;
          localCharSequence = paramCharSequence;
        }
      }
    }
  }
  
  private void eTq()
  {
    if (((this.Gce instanceof BoringLayout)) && (this.Gcp == null)) {
      this.Gcp = ((BoringLayout)this.Gce);
    }
    this.Gce = null;
  }
  
  private void eTr()
  {
    AppMethodBeat.i(142433);
    if (this.Gcl) {}
    for (int i = this.mMaxWidth - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      jn(j, j);
      AppMethodBeat.o(142433);
      return;
    }
  }
  
  private void eTs()
  {
    AppMethodBeat.i(142438);
    if (this.Gcr == 0) {
      this.Gcr = ((int)(Math.ceil(this.Gcs.descent - this.Gcs.ascent) + 2.0D));
    }
    AppMethodBeat.o(142438);
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    AppMethodBeat.i(204018);
    int j = 0;
    int k = this.Hu & 0x70;
    Layout localLayout = this.Gce;
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
      AppMethodBeat.o(204018);
      return i;
    }
  }
  
  private int getDesiredHeight()
  {
    AppMethodBeat.i(142437);
    Layout localLayout = this.Gce;
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
    if (this.Gci == 1)
    {
      k = j;
      if (j > this.Gch)
      {
        i = localLayout.getLineTop(this.Gch) + localLayout.getBottomPadding() + m;
        k = this.Gch;
      }
      if (this.Gck != 1) {
        break label161;
      }
      j = i;
      if (k < this.Gcj) {
        j = getLineHeight();
      }
    }
    label161:
    for (j = i + (this.Gcj - k) * j;; j = Math.max(i, this.Gcj))
    {
      i = Math.max(j, getSuggestedMinimumHeight());
      AppMethodBeat.o(142437);
      return i;
      i = Math.min(i, this.Gch);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    AppMethodBeat.i(142427);
    int j = 0;
    int k = this.Hu & 0x70;
    Layout localLayout = this.Gce;
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
  
  private void jn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142434);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.Hu & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.Gca == null) || (this.Gcd != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label146;
        }
        this.Gce = new StaticLayout(this.Gcb, 0, this.Gcb.length(), this.avD, paramInt1, localAlignment, this.Gcf, this.Gcg, this.Gco, this.Gca, paramInt2);
        AppMethodBeat.o(142434);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label146:
      this.Gce = new StaticLayout(this.Gcb, this.avD, paramInt1, localAlignment, this.Gcf, this.Gcg, this.Gco);
      AppMethodBeat.o(142434);
      return;
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    AppMethodBeat.i(142401);
    if (paramFloat != this.avD.getTextSize())
    {
      this.avD.setTextSize(paramFloat);
      this.Gcs = this.avD.getFontMetricsInt();
      this.Gcr = ((int)(Math.ceil(this.Gcs.descent - this.Gcs.ascent) + 2.0D));
      if (this.Gce != null)
      {
        eTq();
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
    int j = this.uJF.getColorForState(getDrawableState(), 0);
    if (j != this.GbX)
    {
      this.GbX = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    AppMethodBeat.o(142419);
  }
  
  public final void aM(String paramString, int paramInt1, int paramInt2)
  {
    this.FUT = paramString;
    this.FUU = paramInt1;
    this.FUV = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(142444);
    if (this.Gce != null)
    {
      i = this.Gce.getWidth();
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
    if (this.Gce != null)
    {
      i = this.Gce.getHeight();
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
    if ((this.uJF != null) && (this.uJF.isStateful())) {
      updateTextColors();
    }
    b localb = this.Gcv;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.GcL != null) && (localb.GcL.isStateful())) {
        localb.GcL.setState(arrayOfInt);
      }
      if ((localb.GcM != null) && (localb.GcM.isStateful())) {
        localb.GcM.setState(arrayOfInt);
      }
      if ((localb.GcN != null) && (localb.GcN.isStateful())) {
        localb.GcN.setState(arrayOfInt);
      }
      if ((localb.GcO != null) && (localb.GcO.isStateful())) {
        localb.GcO.setState(arrayOfInt);
      }
    }
    AppMethodBeat.o(142383);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(142432);
    if (this.Gce == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(142432);
      return i;
    }
    if ((this.Hu & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.Gce.getLineBaseline(0);
      AppMethodBeat.o(142432);
      return i + j + k;
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.Gcv;
    if (localb != null) {
      return localb.GcX;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    b localb = this.Gcv;
    if (localb != null) {
      return new Drawable[] { localb.GcN, localb.GcL, localb.GcO, localb.GcM };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(142388);
    b localb = this.Gcv;
    if ((localb == null) || (localb.GcM == null) || (!this.Gcz))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(142388);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.GcX;
    int k = localb.GcQ;
    AppMethodBeat.o(142388);
    return k + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(142389);
    b localb = this.Gcv;
    if ((localb == null) || (localb.GcN == null) || (!this.Gcw))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(142389);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.GcX;
    int k = localb.GcR;
    AppMethodBeat.o(142389);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(142390);
    b localb = this.Gcv;
    if ((localb == null) || (localb.GcO == null) || (!this.Gcx))
    {
      i = getPaddingRight();
      AppMethodBeat.o(142390);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.GcX;
    int k = localb.GcS;
    AppMethodBeat.o(142390);
    return k + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(142387);
    b localb = this.Gcv;
    if ((localb == null) || (localb.GcL == null) || (!this.Gcy))
    {
      i = getPaddingTop();
      AppMethodBeat.o(142387);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.GcX;
    int k = localb.GcP;
    AppMethodBeat.o(142387);
    return k + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.GbX;
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
    return this.Gca;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(142392);
    if ((this.Gce == null) || (this.Gci != 1))
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    if (this.Gce.getLineCount() <= this.Gch)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(142392);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.Gce.getLineTop(this.Gch);
    if (k >= j)
    {
      AppMethodBeat.o(142392);
      return i;
    }
    int m = this.Hu & 0x70;
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
    if ((this.Gce == null) || (this.Gci != 1))
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    if (this.Gce.getLineCount() <= this.Gch)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(142391);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.Gce.getLineTop(this.Gch);
    if (k >= j)
    {
      AppMethodBeat.o(142391);
      return i;
    }
    int m = this.Hu & 0x70;
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
    if (this.Gce == null)
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
    int j = this.Gce.getLineForOffset(i);
    paramRect.top = this.Gce.getLineTop(j);
    paramRect.bottom = this.Gce.getLineBottom(j);
    paramRect.left = ((int)this.Gce.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.Hu & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
    AppMethodBeat.o(142430);
  }
  
  public int getGravity()
  {
    return this.Hu;
  }
  
  public final Layout getLayout()
  {
    return this.Gce;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(142431);
    if (this.Gce != null)
    {
      int i = this.Gce.getLineCount();
      AppMethodBeat.o(142431);
      return i;
    }
    AppMethodBeat.o(142431);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(142377);
    int i = Math.round(this.avD.getFontMetricsInt(null) * this.Gcf + this.Gcg);
    AppMethodBeat.o(142377);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.avD;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(142408);
    int i = this.avD.getFlags();
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
    return this.uJF;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(142402);
    float f = this.avD.getTextScaleX();
    AppMethodBeat.o(142402);
    return f;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(142398);
    float f = this.avD.getTextSize();
    AppMethodBeat.o(142398);
    return f;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(142396);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.Hu & 0x70;
    Layout localLayout = this.Gce;
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
    int j = getVerticalOffset$1385f2();
    AppMethodBeat.o(142395);
    return i + j;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(142404);
    Typeface localTypeface = this.avD.getTypeface();
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
      localb = this.Gcv;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.GcN) {
          break label152;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.GcV) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      AppMethodBeat.o(142385);
      return;
      label152:
      if (paramDrawable == localb.GcO)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.GcS);
        i = k + ((i1 - i2 - n - i - localb.GcW) / 2 + i);
      }
      else if (paramDrawable == localb.GcL)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.GcT) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.GcM)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.GcU) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.GcQ);
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
    Object localObject = this.Gcv;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localObject != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.Gcw) && (((b)localObject).GcN != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - ((b)localObject).GcV) / 2);
        ((b)localObject).GcN.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.Gcx)
      {
        f2 = f3;
        if (((b)localObject).GcO != null)
        {
          paramCanvas.save();
          if (!this.Gcq) {
            break label694;
          }
          f1 = this.avD.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - ((b)localObject).GcW) / 2);
          ((b)localObject).GcO.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.Gcy) && (((b)localObject).GcL != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - ((b)localObject).GcT) / 2, getPaddingTop() + i2);
        ((b)localObject).GcL.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.Gcz)
      {
        f1 = f2;
        if (((b)localObject).GcM != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - ((b)localObject).GcU) / 2, i2 + i5 - i6 - getPaddingBottom() - ((b)localObject).GcQ);
          ((b)localObject).GcM.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.GbX;
    this.avD.setColor(i1);
    this.avD.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.Hu & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.Gcq)
    {
      f3 = (n - (this.Gcs.bottom - this.Gcs.top)) / 2 - this.Gcs.top;
      j = 0;
      i = j;
      if ((this.Hu & 0x7) != 3) {}
      switch (this.Hu & 0x7)
      {
      default: 
        i = j;
        label656:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.avD);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(142429);
      return;
      label694:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.Gcb, this.avD));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.avD.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label656;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.avD.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label656;
      if (this.Gce == null) {
        eTr();
      }
      localObject = this.Gce;
      try
      {
        ((Layout)localObject).draw(paramCanvas, null, null, i - j);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ad.printErrStackTrace("TextView", localIndexOutOfBoundsException, "", new Object[0]);
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
    if (bt.isNullOrNil((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    AppMethodBeat.o(142447);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142425);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.Gct) && (getMeasuredWidth() > 0))
    {
      if ((bt.isNullOrNil(this.FUT)) || (this.GcE == null)) {
        break label99;
      }
      CharSequence localCharSequence = this.GcE.a(this, this.mText, this.FUT, this.FUU, this.FUV);
      this.FUT = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.Gct = false;
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
      setMeasuredDimension(j, this.Gcr);
      AppMethodBeat.o(142436);
      return;
    }
    if (this.Gcq)
    {
      if (this.Gcr == 0) {
        eTs();
      }
      setMeasuredDimension(j, this.Gcr);
      AppMethodBeat.o(142436);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.Gcl)
    {
      paramInt1 = this.mMaxWidth - paramInt1;
      if (this.Gce != null) {
        break label165;
      }
      jn(paramInt1, paramInt1);
      label122:
      if (k != 1073741824) {
        break label196;
      }
      this.Gcn = -1;
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
      if (this.Gce.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label194;
        }
        jn(paramInt1, paramInt1);
        break;
      }
      label194:
      break label122;
      label196:
      paramInt2 = getDesiredHeight();
      this.Gcn = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(142386);
    b localb2 = this.Gcv;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.GcX = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(142386);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        this.Gcv = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    AppMethodBeat.i(142381);
    if (paramInt != this.GcA)
    {
      this.GcA = paramInt;
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
    if ((this.Gcv != null) && (this.Gcv.GcN == paramDrawable))
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
    if (paramInt != this.GcB)
    {
      this.GcB = paramInt;
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
    if ((this.Gcv != null) && (this.Gcv.GcO == paramDrawable))
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
    if (this.Gcz != paramBoolean) {
      invalidate();
    }
    this.Gcz = paramBoolean;
    AppMethodBeat.o(142375);
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142372);
    if (this.Gcw != paramBoolean) {
      invalidate();
    }
    this.Gcw = paramBoolean;
    AppMethodBeat.o(142372);
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142373);
    if (this.Gcx != paramBoolean) {
      invalidate();
    }
    this.Gcx = paramBoolean;
    AppMethodBeat.o(142373);
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    AppMethodBeat.i(142374);
    if (this.Gcy != paramBoolean) {
      invalidate();
    }
    this.Gcy = paramBoolean;
    AppMethodBeat.o(142374);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(142420);
    this.GbY = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(142420);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(142443);
    this.Gca = paramTruncateAt;
    if (this.Gce != null)
    {
      eTq();
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
      if ((i & 0x7) != (this.Hu & 0x7)) {
        paramInt = 1;
      }
      if (i != this.Hu) {
        invalidate();
      }
      this.Hu = i;
      if ((this.Gce != null) && (paramInt != 0)) {
        jn(this.Gce.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      AppMethodBeat.o(142407);
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(142415);
    this.Gcj = paramInt;
    this.Gch = paramInt;
    this.Gck = 2;
    this.Gci = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142415);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142435);
    this.Gco = paramBoolean;
    if (this.Gce != null)
    {
      eTq();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(142435);
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.GcE = paramc;
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(142414);
    this.Gcj = paramInt;
    this.Gch = paramInt;
    this.Gck = 1;
    this.Gci = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142414);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(142413);
    this.Gch = paramInt;
    this.Gci = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142413);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(142412);
    this.Gch = paramInt;
    this.Gci = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142412);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(142417);
    this.mMaxWidth = paramInt;
    this.Gcl = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142417);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(142411);
    this.Gcj = paramInt;
    this.Gck = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142411);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(142410);
    this.Gcj = paramInt;
    this.Gck = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142410);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(142416);
    this.mMinWidth = paramInt;
    this.Gcm = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142416);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142397);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      eTq();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(142397);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(142409);
    if (this.avD.getFlags() != paramInt)
    {
      this.avD.setFlags(paramInt);
      if (this.Gce != null)
      {
        eTq();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(142409);
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.Gcu = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(142442);
    this.FZC = paramBoolean;
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
    this.GbZ = paramFactory;
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
    a(paramCharSequence, this.Gcc);
    AppMethodBeat.o(142422);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(142405);
    this.uJF = ColorStateList.valueOf(paramInt);
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
    if (this.uJF == paramColorStateList)
    {
      AppMethodBeat.o(142406);
      return;
    }
    this.uJF = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(142406);
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142423);
    NoMeasuredTextView.a locala = this.Gcc;
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
    if (this.avD.getTypeface() != paramTypeface)
    {
      this.avD.setTypeface(paramTypeface);
      if (this.Gce != null)
      {
        eTq();
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
    this.Gcm = true;
    this.Gcl = true;
    requestLayout();
    invalidate();
    AppMethodBeat.o(142418);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142384);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.Gcv != null))
    {
      if ((paramDrawable == this.Gcv.GcN) || (paramDrawable == this.Gcv.GcL) || (paramDrawable == this.Gcv.GcO) || (paramDrawable == this.Gcv.GcM))
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
    final Rect GcK;
    Drawable GcL;
    Drawable GcM;
    Drawable GcN;
    Drawable GcO;
    int GcP;
    int GcQ;
    int GcR;
    int GcS;
    int GcT;
    int GcU;
    int GcV;
    int GcW;
    int GcX;
    
    b()
    {
      AppMethodBeat.i(142371);
      this.GcK = new Rect();
      AppMethodBeat.o(142371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */