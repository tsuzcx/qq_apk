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
import com.tencent.mm.sdk.platformtools.bk;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics vaP = new BoringLayout.Metrics();
  private int An = 51;
  private int Un = 0;
  private ColorStateList dP;
  private int eg = 2147483647;
  private TextPaint gI = new TextPaint(1);
  private CharSequence mText = "";
  private String uSP;
  private int uSQ;
  private int uSR;
  private boolean uXI;
  private boolean vaA = false;
  private int vaB;
  private Paint.FontMetricsInt vaC;
  private boolean vaD = false;
  private boolean vaE = false;
  private NoMeasuredTextView.b vaF;
  private boolean vaG = false;
  private boolean vaH = false;
  private boolean vaI = false;
  private boolean vaJ = false;
  private int vaK = -1;
  private int vaL = -1;
  private int vaM = -1;
  private int vaN = -1;
  private NoMeasuredTextView.c vaO;
  private int vah;
  private Editable.Factory vai = Editable.Factory.getInstance();
  private Spannable.Factory vaj = Spannable.Factory.getInstance();
  private TextUtils.TruncateAt vak = null;
  private CharSequence val = "";
  private NoMeasuredTextView.a vam = NoMeasuredTextView.a.vaQ;
  private KeyListener van;
  private Layout vao;
  private float vap = 1.0F;
  private float vaq = 0.0F;
  private int var = 2147483647;
  private int vas = 1;
  private int vat = 0;
  private int vau = 1;
  private boolean vav = false;
  private boolean vaw = false;
  private int vax = -1;
  private boolean vay = true;
  private BoringLayout vaz;
  
  static
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gI.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.vaC = this.gI.getFontMetricsInt();
    cBo();
    setSingleLine(true);
    setEllipsize(null);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.vaF;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label188;
      }
      if (localObject2 != null)
      {
        if (((NoMeasuredTextView.b)localObject2).vbh != 0) {
          break label48;
        }
        this.vaF = null;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      i = 0;
      break;
      label48:
      if (((NoMeasuredTextView.b)localObject2).vaX != null) {
        ((NoMeasuredTextView.b)localObject2).vaX.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).vaX = null;
      if (((NoMeasuredTextView.b)localObject2).vaV != null) {
        ((NoMeasuredTextView.b)localObject2).vaV.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).vaV = null;
      if (((NoMeasuredTextView.b)localObject2).vaY != null) {
        ((NoMeasuredTextView.b)localObject2).vaY.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).vaY = null;
      if (((NoMeasuredTextView.b)localObject2).vaW != null) {
        ((NoMeasuredTextView.b)localObject2).vaW.setCallback(null);
      }
      ((NoMeasuredTextView.b)localObject2).vaW = null;
      ((NoMeasuredTextView.b)localObject2).vbf = 0;
      ((NoMeasuredTextView.b)localObject2).vbb = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.vbg = 0;
      paramDrawable1.vbc = 0;
      label165:
      paramDrawable1.vbd = 0;
      paramDrawable1.vaZ = 0;
      paramDrawable1.vbe = 0;
      paramDrawable1.vba = 0;
    }
    label188:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new NoMeasuredTextView.b(this);
      this.vaF = ((NoMeasuredTextView.b)localObject1);
    }
    if ((((NoMeasuredTextView.b)localObject1).vaX != paramDrawable1) && (((NoMeasuredTextView.b)localObject1).vaX != null)) {
      ((NoMeasuredTextView.b)localObject1).vaX.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).vaX = paramDrawable1;
    if ((((NoMeasuredTextView.b)localObject1).vaV != null) && (((NoMeasuredTextView.b)localObject1).vaV != null)) {
      ((NoMeasuredTextView.b)localObject1).vaV.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).vaV = null;
    if ((((NoMeasuredTextView.b)localObject1).vaY != paramDrawable2) && (((NoMeasuredTextView.b)localObject1).vaY != null)) {
      ((NoMeasuredTextView.b)localObject1).vaY.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).vaY = paramDrawable2;
    if ((((NoMeasuredTextView.b)localObject1).vaW != null) && (((NoMeasuredTextView.b)localObject1).vaW != null)) {
      ((NoMeasuredTextView.b)localObject1).vaW.setCallback(null);
    }
    ((NoMeasuredTextView.b)localObject1).vaW = null;
    localObject2 = ((NoMeasuredTextView.b)localObject1).vaU;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((NoMeasuredTextView.b)localObject1).vbb = ((Rect)localObject2).width();
      ((NoMeasuredTextView.b)localObject1).vbf = ((Rect)localObject2).height();
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
      ((NoMeasuredTextView.b)localObject1).vbc = ((Rect)localObject2).width();
      ((NoMeasuredTextView.b)localObject1).vbg = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label165;
      ((NoMeasuredTextView.b)localObject1).vbf = 0;
      ((NoMeasuredTextView.b)localObject1).vbb = 0;
    }
  }
  
  private void a(CharSequence paramCharSequence, NoMeasuredTextView.a parama)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    for (;;)
    {
      CharSequence localCharSequence;
      label118:
      int i;
      int j;
      if (!paramCharSequence.equals(this.mText))
      {
        localCharSequence = paramCharSequence;
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = paramCharSequence;
          if (this.vaO != null)
          {
            localCharSequence = paramCharSequence;
            if (!bk.bl(this.uSP))
            {
              localCharSequence = this.vaO.a(this, paramCharSequence, this.uSP, this.uSQ, this.uSR);
              this.uSP = null;
            }
          }
        }
        if (!(localCharSequence instanceof Spanned)) {
          break label223;
        }
        this.vaA = false;
        if ((parama != NoMeasuredTextView.a.vaS) && (this.van == null)) {
          break label231;
        }
        paramCharSequence = this.vai.newEditable(localCharSequence);
        i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localCharSequence = paramCharSequence;
        if (this.vaE)
        {
          if (!this.vav) {
            break label254;
          }
          i = this.eg;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.eg, getMeasuredWidth());
          }
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.gI, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.vam = parama;
        this.mText = localCharSequence;
        this.val = localCharSequence;
        if (!this.vaA) {
          break label296;
        }
        cBo();
        invalidate();
        return;
        label223:
        this.vaA = true;
        break;
        label231:
        paramCharSequence = localCharSequence;
        if (parama != NoMeasuredTextView.a.vaR) {
          break label118;
        }
        paramCharSequence = this.vaj.newSpannable(localCharSequence);
        break label118;
        label254:
        if (getMeasuredWidth() > 0)
        {
          localCharSequence = TextUtils.ellipsize(paramCharSequence, this.gI, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.vaD = true;
          localCharSequence = paramCharSequence;
        }
      }
      label296:
      if (getWidth() != 0)
      {
        if (this.vao == null)
        {
          cBn();
          if (this.vao.getHeight() != getHeight()) {
            requestLayout();
          }
          invalidate();
          return;
        }
        i = this.vao.getHeight();
        int k = this.vao.getWidth();
        fu(k, k - j);
        if (this.vak != TextUtils.TruncateAt.MARQUEE)
        {
          if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
          {
            invalidate();
            return;
          }
          j = this.vao.getHeight();
          if ((j == i) && (j == getHeight()))
          {
            invalidate();
            return;
          }
        }
      }
      requestLayout();
      invalidate();
      return;
    }
  }
  
  private void cBm()
  {
    if (((this.vao instanceof BoringLayout)) && (this.vaz == null)) {
      this.vaz = ((BoringLayout)this.vao);
    }
    this.vao = null;
  }
  
  private void cBn()
  {
    if (this.vav) {}
    for (int i = this.eg - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      fu(j, j);
      return;
    }
  }
  
  private void cBo()
  {
    if (this.vaB == 0) {
      this.vaB = ((int)(Math.ceil(this.vaC.descent - this.vaC.ascent) + 2.0D));
    }
  }
  
  private void fu(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.An & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.vak == null) || (this.van != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label136;
        }
        this.vao = new StaticLayout(this.val, 0, this.val.length(), this.gI, paramInt1, localAlignment, this.vap, this.vaq, this.vay, this.vak, paramInt2);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label136:
      this.vao = new StaticLayout(this.val, this.gI, paramInt1, localAlignment, this.vap, this.vaq, this.vay);
      return;
    }
  }
  
  private int getBottomVerticalOffset$1385f2()
  {
    int j = 0;
    int k = this.An & 0x70;
    Layout localLayout = this.vao;
    int i = j;
    int m;
    int n;
    if (k != 80)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m)
      {
        if (k != 48) {
          break label70;
        }
        i = m - n;
      }
    }
    return i;
    label70:
    return m - n >> 1;
  }
  
  private int getDesiredHeight()
  {
    Layout localLayout = this.vao;
    if (localLayout == null) {
      return 0;
    }
    int j = localLayout.getLineCount();
    int i = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + i;
    i = localLayout.getLineTop(j) + m;
    int k;
    if (this.vas == 1)
    {
      k = j;
      if (j > this.var)
      {
        i = localLayout.getLineTop(this.var) + localLayout.getBottomPadding() + m;
        k = this.var;
      }
      if (this.vau != 1) {
        break label141;
      }
      j = i;
      if (k < this.vat) {
        j = getLineHeight();
      }
    }
    label141:
    for (j = i + (this.vat - k) * j;; j = Math.max(i, this.vat))
    {
      return Math.max(j, getSuggestedMinimumHeight());
      i = Math.min(i, this.var);
      k = j;
      break;
    }
  }
  
  private int getVerticalOffset$1385f2()
  {
    int j = 0;
    int k = this.An & 0x70;
    Layout localLayout = this.vao;
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m)
      {
        if (k != 80) {
          break label70;
        }
        i = m - n;
      }
    }
    return i;
    label70:
    return m - n >> 1;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.gI.getTextSize())
    {
      this.gI.setTextSize(paramFloat);
      this.vaC = this.gI.getFontMetricsInt();
      this.vaB = ((int)(Math.ceil(this.vaC.descent - this.vaC.ascent) + 2.0D));
      if (this.vao != null)
      {
        cBm();
        requestLayout();
        invalidate();
      }
    }
  }
  
  private void updateTextColors()
  {
    int i = 0;
    int j = this.dP.getColorForState(getDrawableState(), 0);
    if (j != this.vah)
    {
      this.vah = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
  }
  
  public final void ao(String paramString, int paramInt1, int paramInt2)
  {
    this.uSP = paramString;
    this.uSQ = paramInt1;
    this.uSR = paramInt2;
  }
  
  protected int computeHorizontalScrollRange()
  {
    if (this.vao != null) {
      return this.vao.getWidth();
    }
    return super.computeHorizontalScrollRange();
  }
  
  protected int computeVerticalScrollExtent()
  {
    return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.vao != null) {
      return this.vao.getHeight();
    }
    return super.computeVerticalScrollRange();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.dP != null) && (this.dP.isStateful())) {
      updateTextColors();
    }
    NoMeasuredTextView.b localb = this.vaF;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.vaV != null) && (localb.vaV.isStateful())) {
        localb.vaV.setState(arrayOfInt);
      }
      if ((localb.vaW != null) && (localb.vaW.isStateful())) {
        localb.vaW.setState(arrayOfInt);
      }
      if ((localb.vaX != null) && (localb.vaX.isStateful())) {
        localb.vaX.setState(arrayOfInt);
      }
      if ((localb.vaY != null) && (localb.vaY.isStateful())) {
        localb.vaY.setState(arrayOfInt);
      }
    }
  }
  
  public int getBaseline()
  {
    if (this.vao == null) {
      return super.getBaseline();
    }
    if ((this.An & 0x70) != 48) {}
    for (int i = getVerticalOffset$1385f2();; i = 0) {
      return i + getExtendedPaddingTop() + this.vao.getLineBaseline(0);
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if (localb != null) {
      return localb.vbh;
    }
    return 0;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if (localb != null) {
      return new Drawable[] { localb.vaX, localb.vaV, localb.vaY, localb.vaW };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if ((localb == null) || (localb.vaW == null) || (!this.vaJ)) {
      return getPaddingBottom();
    }
    int i = getPaddingBottom();
    int j = localb.vbh;
    return localb.vba + (i + j);
  }
  
  public int getCompoundPaddingLeft()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if ((localb == null) || (localb.vaX == null) || (!this.vaG)) {
      return getPaddingLeft();
    }
    int i = getPaddingLeft();
    int j = localb.vbh;
    return localb.vbb + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if ((localb == null) || (localb.vaY == null) || (!this.vaH)) {
      return getPaddingRight();
    }
    int i = getPaddingRight();
    int j = localb.vbh;
    return localb.vbc + (i + j);
  }
  
  public int getCompoundPaddingTop()
  {
    NoMeasuredTextView.b localb = this.vaF;
    if ((localb == null) || (localb.vaV == null) || (!this.vaI)) {
      return getPaddingTop();
    }
    int i = getPaddingTop();
    int j = localb.vbh;
    return localb.vaZ + (i + j);
  }
  
  public final int getCurrentTextColor()
  {
    return this.vah;
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
    return this.vak;
  }
  
  public int getExtendedPaddingBottom()
  {
    int i;
    if ((this.vao == null) || (this.vas != 1)) {
      i = getCompoundPaddingBottom();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        if (this.vao.getLineCount() <= this.var) {
          return getCompoundPaddingBottom();
        }
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        k = getHeight() - i - j;
        m = this.vao.getLineTop(this.var);
        i = j;
      } while (m >= k);
      n = this.An & 0x70;
      if (n == 48) {
        return j + k - m;
      }
      i = j;
    } while (n == 80);
    return j + (k - m) / 2;
  }
  
  public int getExtendedPaddingTop()
  {
    int i;
    if ((this.vao == null) || (this.vas != 1)) {
      i = getCompoundPaddingTop();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        if (this.vao.getLineCount() <= this.var) {
          return getCompoundPaddingTop();
        }
        j = getCompoundPaddingTop();
        i = getCompoundPaddingBottom();
        k = getHeight() - j - i;
        m = this.vao.getLineTop(this.var);
        i = j;
      } while (m >= k);
      n = this.An & 0x70;
      i = j;
    } while (n == 48);
    if (n == 80) {
      return j + k - m;
    }
    return j + (k - m) / 2;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if (this.vao == null)
    {
      super.getFocusedRect(paramRect);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      return;
    }
    int j = this.vao.getLineForOffset(i);
    paramRect.top = this.vao.getLineTop(j);
    paramRect.bottom = this.vao.getLineBottom(j);
    paramRect.left = ((int)this.vao.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.An & 0x70) != 48) {
      i = j + getVerticalOffset$1385f2();
    }
    paramRect.offset(k, i);
  }
  
  public int getGravity()
  {
    return this.An;
  }
  
  public final Layout getLayout()
  {
    return this.vao;
  }
  
  public int getLineCount()
  {
    if (this.vao != null) {
      return this.vao.getLineCount();
    }
    return 0;
  }
  
  public int getLineHeight()
  {
    return Math.round(this.gI.getFontMetricsInt(null) * this.vap + this.vaq);
  }
  
  public TextPaint getPaint()
  {
    return this.gI;
  }
  
  public int getPaintFlags()
  {
    return this.gI.getFlags();
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionEnd()
  {
    return Selection.getSelectionEnd(getText());
  }
  
  @ViewDebug.ExportedProperty
  public int getSelectionStart()
  {
    return Selection.getSelectionStart(getText());
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.dP;
  }
  
  public float getTextScaleX()
  {
    return this.gI.getTextScaleX();
  }
  
  public float getTextSize()
  {
    return this.gI.getTextSize();
  }
  
  public int getTotalPaddingBottom()
  {
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.An & 0x70;
    Layout localLayout = this.vao;
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
          break label80;
        }
      }
    }
    label80:
    for (i = n - i1;; i = n - i1 >> 1) {
      return i + k;
    }
  }
  
  public int getTotalPaddingLeft()
  {
    return getCompoundPaddingLeft();
  }
  
  public int getTotalPaddingRight()
  {
    return getCompoundPaddingRight();
  }
  
  public int getTotalPaddingTop()
  {
    return getExtendedPaddingTop() + getVerticalOffset$1385f2();
  }
  
  public Typeface getTypeface()
  {
    return this.gI.getTypeface();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
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
      localb = this.vaF;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.vaX) {
          break label140;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.vbf) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      return;
      label140:
      if (paramDrawable == localb.vaY)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.vbc);
        i = k + ((i1 - i2 - n - i - localb.vbg) / 2 + i);
      }
      else if (paramDrawable == localb.vaV)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.vbd) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.vaW)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.vbe) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.vba);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
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
    NoMeasuredTextView.b localb = this.vaF;
    float f3 = -1.0F;
    float f1 = f3;
    float f2;
    if (localb != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.vaG) && (localb.vaX != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - localb.vbf) / 2);
        localb.vaX.draw(paramCanvas);
        paramCanvas.restore();
      }
      f2 = f3;
      if (this.vaH)
      {
        f2 = f3;
        if (localb.vaY != null)
        {
          paramCanvas.save();
          if (!this.vaA) {
            break label684;
          }
          f1 = this.gI.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f2 + j - getPaddingRight(), i2 + i1 + (i7 - localb.vbg) / 2);
          localb.vaY.draw(paramCanvas);
          paramCanvas.restore();
          f2 = f1;
        }
      }
      if ((this.vaI) && (localb.vaV != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - localb.vbd) / 2, getPaddingTop() + i2);
        localb.vaV.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f2;
      if (this.vaJ)
      {
        f1 = f2;
        if (localb.vaW != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - localb.vbe) / 2, i2 + i5 - i6 - getPaddingBottom() - localb.vba);
          localb.vaW.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f2;
        }
      }
    }
    i1 = this.vah;
    this.gI.setColor(i1);
    this.gI.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.An & 0x70) != 48)
    {
      j = getVerticalOffset$1385f2();
      i = getVerticalOffset$1385f2();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.vaA)
    {
      f3 = (n - (this.vaC.bottom - this.vaC.top)) / 2 - this.vaC.top;
      j = 0;
      i = j;
      if ((this.An & 0x7) != 3) {}
      switch (this.An & 0x7)
      {
      default: 
        i = j;
        label652:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.gI);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      label684:
      f2 = (float)Math.ceil(Layout.getDesiredWidth(this.val, this.gI));
      f1 = -1.0F;
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.gI.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label652;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.gI.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label652;
      if (this.vao == null) {
        cBn();
      }
      this.vao.draw(paramCanvas, null, null, i - j);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bk.bl((String)localCharSequence2)) {
      localCharSequence1 = getText();
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.vaD) && (getMeasuredWidth() > 0))
    {
      if ((bk.bl(this.uSP)) || (this.vaO == null)) {
        break label87;
      }
      CharSequence localCharSequence = this.vaO.a(this, this.mText, this.uSP, this.uSQ, this.uSR);
      this.uSP = null;
      setText(localCharSequence);
    }
    for (;;)
    {
      this.vaD = false;
      return;
      label87:
      setText(TextUtils.ellipsize(this.mText, getPaint(), getMeasuredWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 0)
    {
      setMeasuredDimension(j, this.vaB);
      return;
    }
    if (this.vaA)
    {
      if (this.vaB == 0) {
        cBo();
      }
      setMeasuredDimension(j, this.vaB);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.vav)
    {
      paramInt1 = this.eg - paramInt1;
      if (this.vao != null) {
        break label141;
      }
      fu(paramInt1, paramInt1);
      label104:
      if (k != 1073741824) {
        break label172;
      }
      this.vax = -1;
      paramInt1 = i;
    }
    for (;;)
    {
      scrollTo(0, 0);
      setMeasuredDimension(j, paramInt1);
      return;
      paramInt1 = j - paramInt1;
      break;
      label141:
      if (this.vao.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label170;
        }
        fu(paramInt1, paramInt1);
        break;
      }
      label170:
      break label104;
      label172:
      paramInt2 = getDesiredHeight();
      this.vax = paramInt2;
      paramInt1 = paramInt2;
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt2, i);
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    NoMeasuredTextView.b localb2 = this.vaF;
    NoMeasuredTextView.b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.vbh = paramInt;
      invalidate();
      requestLayout();
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new NoMeasuredTextView.b(this);
        this.vaF = localb1;
      }
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(int paramInt)
  {
    if (paramInt != this.vaK)
    {
      this.vaK = paramInt;
      setCompoundLeftDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
  }
  
  public void setCompoundLeftDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    while ((this.vaF != null) && (this.vaF.vaX == paramDrawable)) {
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(paramDrawable, null);
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(int paramInt)
  {
    if (paramInt != this.vaL)
    {
      this.vaL = paramInt;
      setCompoundRightDrawablesWithIntrinsicBounds(getResources().getDrawable(paramInt));
    }
  }
  
  public void setCompoundRightDrawablesWithIntrinsicBounds(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    while ((this.vaF != null) && (this.vaF.vaY == paramDrawable)) {
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    a(null, paramDrawable);
  }
  
  public void setDrawDownDrawable(boolean paramBoolean)
  {
    if (this.vaJ != paramBoolean) {
      invalidate();
    }
    this.vaJ = paramBoolean;
  }
  
  public void setDrawLeftDrawable(boolean paramBoolean)
  {
    if (this.vaG != paramBoolean) {
      invalidate();
    }
    this.vaG = paramBoolean;
  }
  
  public void setDrawRightDrawable(boolean paramBoolean)
  {
    if (this.vaH != paramBoolean) {
      invalidate();
    }
    this.vaH = paramBoolean;
  }
  
  public void setDrawTopDrawable(boolean paramBoolean)
  {
    if (this.vaI != paramBoolean) {
      invalidate();
    }
    this.vaI = paramBoolean;
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    this.vai = paramFactory;
    setText(this.mText);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.vak = paramTruncateAt;
    if (this.vao != null)
    {
      cBm();
      requestLayout();
      invalidate();
    }
  }
  
  public void setGravity(int paramInt)
  {
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
      if ((i & 0x7) != (this.An & 0x7)) {
        paramInt = 1;
      }
      if (i != this.An) {
        invalidate();
      }
      this.An = i;
      if ((this.vao != null) && (paramInt != 0)) {
        fu(this.vao.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      }
      return;
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.vat = paramInt;
    this.var = paramInt;
    this.vau = 2;
    this.vas = 2;
    requestLayout();
    invalidate();
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.vay = paramBoolean;
    if (this.vao != null)
    {
      cBm();
      requestLayout();
      invalidate();
    }
  }
  
  public void setLayoutCallback(NoMeasuredTextView.c paramc)
  {
    this.vaO = paramc;
  }
  
  public void setLines(int paramInt)
  {
    this.vat = paramInt;
    this.var = paramInt;
    this.vau = 1;
    this.vas = 1;
    requestLayout();
    invalidate();
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.var = paramInt;
    this.vas = 2;
    requestLayout();
    invalidate();
  }
  
  public void setMaxLines(int paramInt)
  {
    this.var = paramInt;
    this.vas = 1;
    requestLayout();
    invalidate();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.eg = paramInt;
    this.vav = true;
    requestLayout();
    invalidate();
  }
  
  public void setMinHeight(int paramInt)
  {
    this.vat = paramInt;
    this.vau = 2;
    requestLayout();
    invalidate();
  }
  
  public void setMinLines(int paramInt)
  {
    this.vat = paramInt;
    this.vau = 1;
    requestLayout();
    invalidate();
  }
  
  public void setMinWidth(int paramInt)
  {
    this.Un = paramInt;
    this.vaw = true;
    requestLayout();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      cBm();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
  }
  
  public void setPaintFlags(int paramInt)
  {
    if (this.gI.getFlags() != paramInt)
    {
      this.gI.setFlags(paramInt);
      if (this.vao != null)
      {
        cBm();
        requestLayout();
        invalidate();
      }
    }
  }
  
  public void setShouldEllipsize(boolean paramBoolean)
  {
    this.vaE = paramBoolean;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.uXI = paramBoolean;
    if (paramBoolean)
    {
      setLines(1);
      return;
    }
    setMaxLines(2147483647);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    this.vaj = paramFactory;
    setText(this.mText);
  }
  
  public final void setText(int paramInt)
  {
    setText(getContext().getResources().getText(paramInt));
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    a(paramCharSequence, this.vam);
  }
  
  public void setTextColor(int paramInt)
  {
    this.dP = ColorStateList.valueOf(paramInt);
    updateTextColors();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    if (this.dP == paramColorStateList) {
      return;
    }
    this.dP = paramColorStateList;
    updateTextColors();
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    NoMeasuredTextView.a locala = this.vam;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    a(paramCharSequence, locala);
    if (((i >= 0) || (j >= 0)) && ((this.mText instanceof Spannable))) {
      Selection.setSelection((Spannable)this.mText, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.gI.getTypeface() != paramTypeface)
    {
      this.gI.setTypeface(paramTypeface);
      if (this.vao != null)
      {
        cBm();
        requestLayout();
        invalidate();
      }
    }
  }
  
  public void setWidth(int paramInt)
  {
    this.Un = paramInt;
    this.eg = paramInt;
    this.vaw = true;
    this.vav = true;
    requestLayout();
    invalidate();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool2 = super.verifyDrawable(paramDrawable);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.vaF != null)
      {
        if ((paramDrawable != this.vaF.vaX) && (paramDrawable != this.vaF.vaV) && (paramDrawable != this.vaF.vaY) && (paramDrawable != this.vaF.vaW)) {
          break label69;
        }
        bool1 = true;
      }
    }
    return bool1;
    label69:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.NoMeasuredTextView
 * JD-Core Version:    0.7.0.1
 */