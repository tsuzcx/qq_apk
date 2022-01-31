package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText
  extends PasterEditText
  implements SpanWatcher
{
  public int UL = 0;
  private am fjC = null;
  public boolean rGv = false;
  public int rGx = 0;
  private int rIA = -1;
  private Paint rIB = null;
  private com.tencent.mm.plugin.wenote.model.nativenote.c.b rIC = null;
  private boolean rID = false;
  private Path rIE = null;
  private int rIF = -1;
  private int rIG = -1;
  private int rIH = -1;
  private boolean rII = false;
  TextWatcher rIJ = new WXRTEditText.2(this);
  int rIK = 0;
  c rId;
  private int rIe = -1;
  private int rIf = -1;
  private boolean rIg = false;
  private boolean rIh;
  private int rIi;
  private int rIj;
  private String rIk;
  public String rIl = "";
  private Spannable rIm;
  int rIn = 0;
  private WXRTEditText rIo = null;
  public RecyclerView.v rIp;
  private boolean rIq;
  private boolean rIr;
  private boolean rIs;
  private boolean rIt;
  private boolean rIu;
  private boolean rIv = false;
  private boolean rIw;
  private j rIx;
  public boolean rIy = false;
  public boolean rIz = false;
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void b(Spannable paramSpannable)
  {
    int i = getSelectionStart();
    com.tencent.mm.cd.g localg = com.tencent.mm.cd.g.csM();
    getContext();
    setSpannableText(localg.a(paramSpannable, getTextSize()));
    int j = getText().length() - paramSpannable.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      return;
    }
    setSelection(i);
  }
  
  private void ciA()
  {
    if (this.fjC == null)
    {
      this.fjC = new am(new WXRTEditText.3(this), false);
      return;
    }
    this.fjC.stopTimer();
  }
  
  private void ciB()
  {
    if (this.rIC == null)
    {
      this.rIC = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
      return;
    }
    this.rIC.reset();
  }
  
  private void ciz()
  {
    Editable localEditable = getText();
    if (localEditable.getSpans(0, localEditable.length(), getClass()) != null) {
      localEditable.setSpan(this, 0, localEditable.length(), 18);
    }
  }
  
  private void eS(int paramInt1, int paramInt2)
  {
    if (this.rIn == 2)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().A(this.rIA, 1, this.rIA, 1);
      return;
    }
    if (this.rIn == 1)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().A(this.rIA, 0, this.rIA, 0);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().A(this.rIA, paramInt1, this.rIA, paramInt2);
  }
  
  private j getRTLayout()
  {
    try
    {
      if ((this.rIx == null) || (this.rIw))
      {
        this.rIx = new j(getText());
        this.rIw = false;
      }
      j localj = this.rIx;
      return localj;
    }
    finally {}
  }
  
  private void init()
  {
    this.rIo = this;
    removeTextChangedListener(this.rIJ);
    addTextChangedListener(this.rIJ);
    setMovementMethod(com.tencent.mm.plugin.wenote.model.nativenote.spans.i.cjd());
    this.rIA = -1;
    this.rIB = new Paint(1);
    this.rIB.setColor(1347529272);
    this.rIC = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
    this.rIE = new Path();
    this.rIF = -1;
    this.rIG = -1;
    this.rIH = -1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      setHighlightColor(0);
      setCustomSelectionActionModeCallback(new WXRTEditText.1(this));
    }
  }
  
  private void setParagraphsAreUp2Date(boolean paramBoolean)
  {
    try
    {
      if (!this.rIu) {
        this.rIt = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a(i parami)
  {
    if (parami == i.rIN) {
      return getText().toString();
    }
    if (parami == i.rIO) {
      return com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
    }
    return "";
  }
  
  public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> paramt, V paramV)
  {
    if ((!this.rIv) && (!this.rIs)) {
      if (!this.rIh) {
        break label91;
      }
    }
    for (Spannable localSpannable = null;; localSpannable = ciu())
    {
      paramt.a(this, paramV);
      label91:
      try
      {
        if ((this.rId != null) && (!this.rIh))
        {
          paramt = ciu();
          paramV = this.rId;
          getSelectionStart();
          getSelectionEnd();
          getSelectionStart();
          paramV.a(this, localSpannable, paramt, getSelectionEnd());
        }
        this.rIw = true;
        return;
      }
      finally {}
    }
  }
  
  public final void aj(int paramInt, boolean paramBoolean)
  {
    Editable localEditable = getText();
    if (localEditable == null) {}
    for (;;)
    {
      return;
      Layout localLayout = getLayout();
      if (localLayout != null)
      {
        int k = localEditable.length();
        if ((paramInt >= 0) && (paramInt <= k))
        {
          int i;
          if (k == 0)
          {
            paramInt = 0;
            i = 0;
          }
          while ((i >= 0) && (i <= k) && (paramInt >= 0) && (paramInt <= k))
          {
            if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().isEditable())
            {
              requestFocus();
              setIgnoreSelectChangeByMultiSelect(true);
              setSelection(i, paramInt);
              setIgnoreSelectChangeByMultiSelect(false);
              if (this.rId != null)
              {
                this.rId.f(true, 50L);
                this.rId.Dn(1);
              }
            }
            eS(i, paramInt);
            com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().S(true, true);
            return;
            if (paramInt < k)
            {
              if ((paramBoolean) || (localEditable.charAt(paramInt) != '\n'))
              {
                j = localLayout.getOffsetToRightOf(paramInt);
                i = paramInt;
                paramInt = j;
              }
            }
            else if ((paramInt == k) && (paramBoolean))
            {
              i = localLayout.getOffsetToLeftOf(paramInt);
              continue;
            }
            i = paramInt;
            int j = paramInt;
            paramInt = i;
            i = j;
          }
        }
      }
    }
  }
  
  public final void cit()
  {
    if (this.rId != null)
    {
      this.rId.f(true, 50L);
      this.rId.Dn(1);
    }
  }
  
  public final Spannable ciu()
  {
    Object localObject = super.getText();
    if (localObject != null) {}
    for (;;)
    {
      return new a((CharSequence)localObject);
      localObject = "";
    }
  }
  
  public final void civ()
  {
    try
    {
      this.rIh = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ciw()
  {
    try
    {
      this.rIh = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cix()
  {
    try
    {
      this.rIg = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ciy()
  {
    try
    {
      this.rIg = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public m[] getCurrentEditorCursorNumberSpan()
  {
    e locale = getParagraphsInSelection();
    return (m[])getText().getSpans(locale.aiH, locale.Eo, m.class);
  }
  
  public String getCurrentEditorCursorParagraphStr()
  {
    e locale = getParagraphsInSelection();
    return getText().subSequence(locale.aiH, locale.Eo).toString().trim();
  }
  
  public int getEditTextType()
  {
    return this.rIn;
  }
  
  public ArrayList<n> getParagraphs()
  {
    return getRTLayout().rIR;
  }
  
  public e getParagraphsInSelection()
  {
    int k = 0;
    j localj = getRTLayout();
    e locale = new e(this);
    int j = localj.getLineForOffset(locale.aiH);
    int i;
    int m;
    if (locale.isEmpty())
    {
      i = locale.Eo;
      m = localj.getLineForOffset(i);
      if ((localj.rIQ != 0) && (j >= 0)) {
        break label103;
      }
      i = 0;
      label65:
      j = k;
      if (localj.rIQ != 0)
      {
        if (m >= 0) {
          break label158;
        }
        j = k;
      }
    }
    for (;;)
    {
      return new e(i, j);
      i = locale.Eo - 1;
      break;
      label103:
      if (j < localj.rIQ)
      {
        i = ((n)localj.rIR.get(j)).aiH;
        break label65;
      }
      i = ((n)localj.rIR.get(localj.rIQ - 1)).Eo - 1;
      break label65;
      label158:
      if (m < localj.rIQ) {
        j = ((n)localj.rIR.get(m)).Eo;
      } else {
        j = ((n)localj.rIR.get(localj.rIQ - 1)).Eo - 1;
      }
    }
  }
  
  public int getPosInDataList()
  {
    return this.rIA;
  }
  
  public int getRecyclerItemPosition()
  {
    if (this.rIp.ic() == -1) {
      return 0;
    }
    return this.rIp.ic();
  }
  
  public String getSelectedText()
  {
    Editable localEditable = getText();
    e locale = getSelection();
    if ((locale.aiH >= 0) && (locale.Eo >= 0) && (locale.Eo <= localEditable.length())) {
      return localEditable.subSequence(locale.aiH, locale.Eo).toString();
    }
    return null;
  }
  
  public e getSelection()
  {
    return new e(getSelectionStart(), getSelectionEnd());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    d locald;
    int j;
    int m;
    int k;
    int i;
    if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) && (this.rIn == 0))
    {
      localObject = getText();
      if (localObject != null)
      {
        locald = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciL();
        j = -1;
        m = 0;
        switch (com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().Ds(this.rIA))
        {
        default: 
          k = 0;
          i = 0;
          if ((j >= 0) && (i <= ((Editable)localObject).length()) && (j <= i)) {
            break;
          }
        }
      }
    }
    do
    {
      do
      {
        super.onDraw(paramCanvas);
        return;
      } while (locald.startOffset == locald.rJE);
      j = locald.startOffset;
      i = locald.rJE;
      k = 0;
      break;
      j = 0;
      i = ((Editable)localObject).length();
      m = 1;
      k = 1;
      break;
      j = locald.startOffset;
      i = ((Editable)localObject).length();
      m = 1;
      k = 0;
      break;
      j = 0;
      i = locald.rJE;
      k = 1;
      break;
      localObject = getLayout();
    } while (localObject == null);
    if (this.rIF == -1) {
      this.rIF = getPaddingLeft();
    }
    if (this.rIG == -1) {
      this.rIG = getPaddingTop();
    }
    if (this.rIH == -1) {
      this.rIH = getPaddingBottom();
    }
    if (this.rIE == null) {
      this.rIE = new Path();
    }
    this.rIE.reset();
    label534:
    label822:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      try
      {
        n = ((Layout)localObject).getLineForOffset(j);
        i1 = ((Layout)localObject).getLineForOffset(i);
        if (n > i1) {
          break;
        }
        i2 = ((Layout)localObject).getWidth();
        f1 = ((Layout)localObject).getPrimaryHorizontal(j) + this.rIF;
        f2 = ((Layout)localObject).getLineTop(n) + this.rIG;
        f3 = ((Layout)localObject).getLineBottom(n) + this.rIG;
        f4 = ((Layout)localObject).getPrimaryHorizontal(i) + this.rIF;
        f5 = ((Layout)localObject).getLineTop(i1) + this.rIG;
        f6 = ((Layout)localObject).getLineBottom(i1) + this.rIG;
        if ((k == 0) || (m == 0)) {
          break label534;
        }
        this.rIE.addRect(this.rIF, 0.0F, this.rIF + i2, f6 + this.rIH, Path.Direction.CW);
        if (this.rIE.isEmpty()) {
          break;
        }
        if (this.rIB == null)
        {
          this.rIB = new Paint(1);
          this.rIB.setColor(1347529272);
        }
        paramCanvas.drawPath(this.rIE, this.rIB);
      }
      catch (Exception localException)
      {
        y.e("noteeditor.WXRTEditText", "tryDrawCover: ", new Object[] { localException });
      }
      break;
      if (n == i1)
      {
        if (k != 0) {
          this.rIE.addRect(this.rIF, 0.0F, f4, f6, Path.Direction.CW);
        } else if (m != 0) {
          this.rIE.addRect(f1, f2, this.rIF + i2, f6 + this.rIH, Path.Direction.CW);
        } else {
          this.rIE.addRect(f1, f2, f4, f6, Path.Direction.CW);
        }
      }
      else
      {
        if (k != 0)
        {
          this.rIE.addRect(this.rIF, 0.0F, this.rIF + i2, f3, Path.Direction.CW);
          this.rIE.addRect(this.rIF, f5, f4, f6, Path.Direction.CW);
        }
        for (;;)
        {
          if (i1 - n <= 1) {
            break label822;
          }
          this.rIE.addRect(this.rIF, f3, this.rIF + i2, f5, Path.Direction.CW);
          break;
          if (m != 0)
          {
            this.rIE.addRect(f1, f2, this.rIF + i2, f3, Path.Direction.CW);
            this.rIE.addRect(this.rIF, f5, this.rIF + i2, f6 + this.rIH, Path.Direction.CW);
          }
          else
          {
            this.rIE.addRect(f1, f2, this.rIF + i2, f3, Path.Direction.CW);
            this.rIE.addRect(this.rIF, f5, f4, f6, Path.Direction.CW);
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    this.rII = false;
    this.rIe = -1;
    this.rIf = -1;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (this.rId != null) {
      this.rId.a(this, paramBoolean, getRecyclerItemPosition());
    }
    if ((paramBoolean) && (!this.rII)) {
      onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (this.rIg) {
          return;
        }
        this.rII = true;
        if (paramInt1 < 0) {
          break;
        }
        if ((this.rIe != paramInt1) || (this.rIf != paramInt2))
        {
          this.rIe = paramInt1;
          this.rIf = paramInt2;
          super.onSelectionChanged(paramInt1, paramInt2);
          if (paramInt2 <= paramInt1) {
            break label216;
          }
          bool = true;
          this.rIr = bool;
          if ((!this.rIs) && (!this.rIt))
          {
            this.rIu = true;
            u.a(this, new t[0]);
            this.rIu = false;
            setParagraphsAreUp2Date(true);
          }
          if (this.rId != null)
          {
            this.rIv = true;
            this.rId.a(this, paramInt1, paramInt2);
            this.rIv = false;
          }
        }
        if ((!com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) || (this.rID) || (!hasFocus()) || (this.rIA < 0)) {
          break;
        }
        eS(paramInt1, paramInt2);
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().Ds(this.rIA) != 1) {
          break;
        }
        com.tencent.mm.plugin.wenote.model.nativenote.c.e locale = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ();
        if (!com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit) {
          break;
        }
        locale.g(true, 0L);
        locale.ciR();
        locale.ciP();
        return;
      }
      finally {}
      label216:
      boolean bool = false;
    }
  }
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    this.rIq = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.rIq = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    this.rIq = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ldc_w 619
    //   4: if_icmpne +14 -> 18
    //   7: aload_0
    //   8: getfield 242	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rId	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   11: invokeinterface 622 1 0
    //   16: iconst_1
    //   17: ireturn
    //   18: iload_1
    //   19: ldc_w 623
    //   22: if_icmpeq +10 -> 32
    //   25: iload_1
    //   26: ldc_w 624
    //   29: if_icmpne +85 -> 114
    //   32: invokestatic 629	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:adg	()V
    //   35: aload_0
    //   36: iload_1
    //   37: invokespecial 631	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   40: istore_3
    //   41: iload_1
    //   42: ldc_w 632
    //   45: if_icmpne +20 -> 65
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIK	I
    //   53: aload_0
    //   54: invokevirtual 170	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   57: astore 4
    //   59: aload_0
    //   60: aload 4
    //   62: invokespecial 634	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   65: iload_1
    //   66: ldc_w 632
    //   69: if_icmpne +43 -> 112
    //   72: aload_0
    //   73: getfield 79	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rGv	Z
    //   76: ifeq +36 -> 112
    //   79: aload_0
    //   80: getfield 242	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rId	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   83: ifnull +24 -> 107
    //   86: aload_0
    //   87: getfield 242	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rId	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   90: iconst_0
    //   91: lconst_0
    //   92: invokeinterface 380 4 0
    //   97: aload_0
    //   98: getfield 242	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rId	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   101: iconst_0
    //   102: invokeinterface 383 2 0
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 79	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rGv	Z
    //   112: iload_3
    //   113: ireturn
    //   114: iload_1
    //   115: ldc_w 632
    //   118: if_icmpne -83 -> 35
    //   121: aload_0
    //   122: invokevirtual 155	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getContext	()Landroid/content/Context;
    //   125: invokestatic 638	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:eE	(Landroid/content/Context;)I
    //   128: istore_2
    //   129: iload_2
    //   130: iconst_2
    //   131: if_icmpne +9 -> 140
    //   134: invokestatic 629	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:adg	()V
    //   137: goto -102 -> 35
    //   140: iload_2
    //   141: iconst_3
    //   142: if_icmpne -107 -> 35
    //   145: aload_0
    //   146: getfield 242	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rId	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   149: aload_0
    //   150: invokeinterface 640 2 0
    //   155: iconst_1
    //   156: ireturn
    //   157: astore 4
    //   159: ldc_w 559
    //   162: ldc_w 642
    //   165: iconst_1
    //   166: anewarray 207	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload 4
    //   173: aastore
    //   174: invokestatic 566	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore 5
    //   181: ldc_w 559
    //   184: ldc_w 644
    //   187: iconst_1
    //   188: anewarray 207	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: getfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIK	I
    //   197: invokestatic 650	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: invokestatic 566	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_0
    //   205: getfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIK	I
    //   208: iconst_3
    //   209: if_icmpge +45 -> 254
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIK	I
    //   217: iconst_1
    //   218: iadd
    //   219: putfield 116	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIK	I
    //   222: aload_0
    //   223: new 652	android/text/SpannableStringBuilder
    //   226: dup
    //   227: iconst_2
    //   228: anewarray 443	java/lang/CharSequence
    //   231: dup
    //   232: iconst_0
    //   233: ldc_w 654
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload 4
    //   241: aastore
    //   242: invokestatic 660	android/text/TextUtils:concat	([Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   245: invokespecial 661	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   248: invokespecial 634	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   251: goto -186 -> 65
    //   254: aload 5
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	WXRTEditText
    //   0	257	1	paramInt	int
    //   128	15	2	i	int
    //   40	73	3	bool	boolean
    //   57	4	4	localEditable	Editable
    //   157	83	4	localNullPointerException	java.lang.NullPointerException
    //   179	76	5	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   35	41	157	java/lang/NullPointerException
    //   59	65	179	java/lang/IndexOutOfBoundsException
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    Object localObject1;
    int i;
    label366:
    boolean bool1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      localObject1 = getText();
      if (localObject1 == null) {
        ciB();
      }
      int j;
      do
      {
        do
        {
          return true;
          j = ((Editable)localObject1).length();
          i = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
          if ((j < 0) || (i < 0) || (i > j))
          {
            ciB();
            return true;
          }
          switch (paramMotionEvent.getAction())
          {
          case 2: 
          default: 
            return true;
          case 0: 
            j = (int)paramMotionEvent.getX();
            int k = (int)paramMotionEvent.getY();
            Object localObject2 = getLayout();
            k = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k), j);
            localObject2 = (k[])getText().getSpans(k, k + 1, k.class);
            if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().isEditable()) && (j < b.chW()) && (localObject2.length != 0))
            {
              y.i("noteeditor.WXRTEditText", "clicked todo");
              this.rId.chR();
              localObject2[0].a(this, (Spannable)localObject1, paramMotionEvent, localObject2[0]);
              return true;
            }
            ciB();
            this.rIC.a(1, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), i);
            ciA();
            this.fjC.S(500L, 0L);
            return true;
          case 3: 
            ciB();
            ciA();
            return true;
          }
          ciA();
        } while (this.rIC == null);
        localObject1 = this.rIC;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJw = f1;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJx = f2;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJy = f3;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJz = f4;
        if (((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).ivk != 1) {
          break;
        }
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJA = i;
        j = this.rIC.getType();
        ciB();
      } while (j != 2);
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().isEditable()) {
        if (hasFocus())
        {
          if ((getSelectionStart() != getSelectionEnd()) || (i != getSelectionStart())) {
            break label670;
          }
          bool1 = true;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      setIgnoreSelectChangeByMultiSelect(true);
      setSelection(i);
      setIgnoreSelectChangeByMultiSelect(false);
      if (this.rId != null)
      {
        this.rId.f(true, 50L);
        this.rId.Dn(1);
      }
      eS(i, i);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().S(bool2, bool1);
      return true;
      ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).rJA = 0;
      break label366;
      requestFocus();
      bool1 = false;
      bool2 = false;
      continue;
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciL();
      bool1 = bool2;
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ().ciQ())
      {
        bool1 = bool2;
        if (paramMotionEvent.ciI() == 1)
        {
          bool1 = bool2;
          if (paramMotionEvent.ebL == this.rIA)
          {
            bool1 = bool2;
            if (paramMotionEvent.startOffset == i) {
              bool1 = true;
            }
          }
        }
      }
      eS(i, i);
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.ciJ();
      if (!com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit) {
        break;
      }
      paramMotionEvent.ciR();
      paramMotionEvent.ciP();
      paramMotionEvent.g(true, 50L);
      paramMotionEvent.lI(true);
      paramMotionEvent.lH(bool1);
      return true;
      if ((paramMotionEvent.getAction() == 1) && (this.rId != null))
      {
        this.rId.f(true, 300L);
        this.rId.Dn(1);
      }
      return super.onTouchEvent(paramMotionEvent);
      label670:
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void setEditTextType(int paramInt)
  {
    this.rIn = paramInt;
  }
  
  public void setIgnoreSelectChangeByMultiSelect(boolean paramBoolean)
  {
    this.rID = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    super.setMaxHeight(paramInt);
  }
  
  public void setPosInDataList(int paramInt)
  {
    this.rIA = paramInt;
  }
  
  public void setRichTextEditing(String paramString)
  {
    civ();
    if (!bk.bl(paramString)) {
      setSpannableText(com.tencent.mm.plugin.wenote.model.nativenote.a.a.Uw(paramString));
    }
    for (;;)
    {
      ciw();
      return;
      setText("");
    }
  }
  
  public void setSpannableText(Spanned paramSpanned)
  {
    civ();
    cix();
    super.setText(paramSpanned, TextView.BufferType.EDITABLE);
    ciy();
    ciz();
    u.a(this, new t[0]);
    ciw();
  }
  
  public void setText(String paramString)
  {
    civ();
    super.setText(paramString);
    ciw();
  }
  
  public void setTextWithoutIgnore(String paramString)
  {
    super.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText
 * JD-Core Version:    0.7.0.1
 */