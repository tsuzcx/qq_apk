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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText
  extends PasterEditText
  implements SpanWatcher
{
  public int Vy;
  private ap bAz;
  public boolean vxe;
  public int vxg;
  c vyJ;
  private int vyK;
  private int vyL;
  private boolean vyM;
  private boolean vyN;
  private int vyO;
  private int vyP;
  private String vyQ;
  public String vyR;
  private Spannable vyS;
  int vyT;
  private WXRTEditText vyU;
  public RecyclerView.v vyV;
  private boolean vyW;
  private boolean vyX;
  private boolean vyY;
  private boolean vyZ;
  private boolean vza;
  private boolean vzb;
  private boolean vzc;
  private j vzd;
  public boolean vze;
  public boolean vzf;
  private int vzg;
  private Paint vzh;
  private com.tencent.mm.plugin.wenote.model.nativenote.c.b vzi;
  private boolean vzj;
  private Path vzk;
  private int vzl;
  private int vzm;
  private int vzn;
  private boolean vzo;
  TextWatcher vzp;
  int vzq;
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26789);
    this.vyK = -1;
    this.vyL = -1;
    this.vyM = false;
    this.vyR = "";
    this.vyT = 0;
    this.vyU = null;
    this.Vy = 0;
    this.vxe = false;
    this.vzb = false;
    this.vze = false;
    this.vxg = 0;
    this.vzf = false;
    this.vzg = -1;
    this.vzh = null;
    this.bAz = null;
    this.vzi = null;
    this.vzj = false;
    this.vzk = null;
    this.vzl = -1;
    this.vzm = -1;
    this.vzn = -1;
    this.vzo = false;
    this.vzp = new WXRTEditText.2(this);
    this.vzq = 0;
    init();
    AppMethodBeat.o(26789);
  }
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26790);
    this.vyK = -1;
    this.vyL = -1;
    this.vyM = false;
    this.vyR = "";
    this.vyT = 0;
    this.vyU = null;
    this.Vy = 0;
    this.vxe = false;
    this.vzb = false;
    this.vze = false;
    this.vxg = 0;
    this.vzf = false;
    this.vzg = -1;
    this.vzh = null;
    this.bAz = null;
    this.vzi = null;
    this.vzj = false;
    this.vzk = null;
    this.vzl = -1;
    this.vzm = -1;
    this.vzn = -1;
    this.vzo = false;
    this.vzp = new WXRTEditText.2(this);
    this.vzq = 0;
    init();
    AppMethodBeat.o(26790);
  }
  
  private void b(Spannable paramSpannable)
  {
    AppMethodBeat.i(26807);
    int i = getSelectionStart();
    com.tencent.mm.cd.g localg = com.tencent.mm.cd.g.dvk();
    getContext();
    setSpannableText(localg.b(paramSpannable, getTextSize()));
    int j = getText().length() - paramSpannable.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(26807);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(26807);
  }
  
  private void diQ()
  {
    AppMethodBeat.i(26812);
    Editable localEditable = getText();
    if (localEditable.getSpans(0, localEditable.length(), getClass()) != null) {
      localEditable.setSpan(this, 0, localEditable.length(), 18);
    }
    AppMethodBeat.o(26812);
  }
  
  private void diR()
  {
    AppMethodBeat.i(26820);
    if (this.bAz == null)
    {
      this.bAz = new ap(new WXRTEditText.3(this), false);
      AppMethodBeat.o(26820);
      return;
    }
    this.bAz.stopTimer();
    AppMethodBeat.o(26820);
  }
  
  private void diS()
  {
    AppMethodBeat.i(26822);
    if (this.vzi == null)
    {
      this.vzi = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
      AppMethodBeat.o(26822);
      return;
    }
    this.vzi.reset();
    AppMethodBeat.o(26822);
  }
  
  private void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26823);
    if (this.vyT == 2)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().G(this.vzg, 1, this.vzg, 1);
      AppMethodBeat.o(26823);
      return;
    }
    if (this.vyT == 1)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().G(this.vzg, 0, this.vzg, 0);
      AppMethodBeat.o(26823);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.c.e locale = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc();
    int i = this.vzg;
    locale.G(i, paramInt1, i, paramInt2);
    AppMethodBeat.o(26823);
  }
  
  private j getRTLayout()
  {
    AppMethodBeat.i(26815);
    try
    {
      if ((this.vzd == null) || (this.vzc))
      {
        this.vzd = new j(getText());
        this.vzc = false;
      }
      j localj = this.vzd;
      return localj;
    }
    finally
    {
      AppMethodBeat.o(26815);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(26792);
    this.vyU = this;
    removeTextChangedListener(this.vzp);
    addTextChangedListener(this.vzp);
    setMovementMethod(com.tencent.mm.plugin.wenote.model.nativenote.spans.i.djE());
    this.vzg = -1;
    this.vzh = new Paint(1);
    this.vzh.setColor(1347529272);
    this.vzi = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
    this.vzk = new Path();
    this.vzl = -1;
    this.vzm = -1;
    this.vzn = -1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      setHighlightColor(0);
      setCustomSelectionActionModeCallback(new WXRTEditText.1(this));
    }
    AppMethodBeat.o(26792);
  }
  
  private void setParagraphsAreUp2Date(boolean paramBoolean)
  {
    try
    {
      if (!this.vza) {
        this.vyZ = paramBoolean;
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
    AppMethodBeat.i(26804);
    if (parami == i.vzt)
    {
      parami = getText().toString();
      AppMethodBeat.o(26804);
      return parami;
    }
    if (parami == i.vzu)
    {
      parami = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
      AppMethodBeat.o(26804);
      return parami;
    }
    AppMethodBeat.o(26804);
    return "";
  }
  
  public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(26811);
    if ((!this.vzb) && (!this.vyY))
    {
      if (this.vyN) {}
      for (Spannable localSpannable = null;; localSpannable = diL())
      {
        paramt.a(this, paramV);
        try
        {
          if ((this.vyJ != null) && (!this.vyN))
          {
            paramt = diL();
            paramV = this.vyJ;
            getSelectionStart();
            getSelectionEnd();
            getSelectionStart();
            paramV.a(this, localSpannable, paramt, getSelectionEnd());
          }
          this.vzc = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(26811);
        }
      }
    }
    AppMethodBeat.o(26811);
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26821);
    Editable localEditable = getText();
    if (localEditable == null)
    {
      AppMethodBeat.o(26821);
      return;
    }
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(26821);
      return;
    }
    int k = localEditable.length();
    if ((paramInt < 0) || (paramInt > k))
    {
      AppMethodBeat.o(26821);
      return;
    }
    int i;
    if (k == 0)
    {
      paramInt = 0;
      i = 0;
    }
    for (;;)
    {
      if ((i < 0) || (i > k) || (paramInt < 0) || (paramInt > k))
      {
        AppMethodBeat.o(26821);
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
        else if ((paramInt == k) && (paramBoolean)) {
          i = localLayout.getOffsetToLeftOf(paramInt);
        }
      }
      else
      {
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().isEditable())
        {
          requestFocus();
          setIgnoreSelectChangeByMultiSelect(true);
          setSelection(i, paramInt);
          setIgnoreSelectChangeByMultiSelect(false);
          if (this.vyJ != null)
          {
            this.vyJ.h(true, 50L);
            this.vyJ.Lg(1);
          }
        }
        gY(i, paramInt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().ac(true, true);
        AppMethodBeat.o(26821);
        return;
      }
      i = paramInt;
      int j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public final void diK()
  {
    AppMethodBeat.i(26797);
    if (this.vyJ != null)
    {
      this.vyJ.h(true, 50L);
      this.vyJ.Lg(1);
    }
    AppMethodBeat.o(26797);
  }
  
  public final Spannable diL()
  {
    AppMethodBeat.i(26801);
    Object localObject = super.getText();
    if (localObject != null) {}
    for (;;)
    {
      localObject = new a((CharSequence)localObject);
      AppMethodBeat.o(26801);
      return localObject;
      localObject = "";
    }
  }
  
  public final void diM()
  {
    try
    {
      this.vyN = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void diN()
  {
    try
    {
      this.vyN = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void diO()
  {
    try
    {
      this.vyM = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void diP()
  {
    try
    {
      this.vyM = false;
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
    AppMethodBeat.i(26798);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(26798);
    return bool;
  }
  
  public m[] getCurrentEditorCursorNumberSpan()
  {
    AppMethodBeat.i(26817);
    Object localObject = getParagraphsInSelection();
    localObject = (m[])getText().getSpans(((e)localObject).akX, ((e)localObject).Fe, m.class);
    AppMethodBeat.o(26817);
    return localObject;
  }
  
  public String getCurrentEditorCursorParagraphStr()
  {
    AppMethodBeat.i(26816);
    Object localObject = getParagraphsInSelection();
    localObject = getText().subSequence(((e)localObject).akX, ((e)localObject).Fe).toString().trim();
    AppMethodBeat.o(26816);
    return localObject;
  }
  
  public int getEditTextType()
  {
    return this.vyT;
  }
  
  public ArrayList<n> getParagraphs()
  {
    AppMethodBeat.i(26814);
    ArrayList localArrayList = getRTLayout().vzx;
    AppMethodBeat.o(26814);
    return localArrayList;
  }
  
  public e getParagraphsInSelection()
  {
    int k = 0;
    AppMethodBeat.i(26813);
    Object localObject = getRTLayout();
    e locale = new e(this);
    int j = ((j)localObject).getLineForOffset(locale.akX);
    int i;
    int m;
    if (locale.isEmpty())
    {
      i = locale.Fe;
      m = ((j)localObject).getLineForOffset(i);
      if ((((j)localObject).vzw != 0) && (j >= 0)) {
        break label119;
      }
      i = 0;
      label71:
      j = k;
      if (((j)localObject).vzw != 0)
      {
        if (m >= 0) {
          break label174;
        }
        j = k;
      }
    }
    for (;;)
    {
      localObject = new e(i, j);
      AppMethodBeat.o(26813);
      return localObject;
      i = locale.Fe - 1;
      break;
      label119:
      if (j < ((j)localObject).vzw)
      {
        i = ((n)((j)localObject).vzx.get(j)).akX;
        break label71;
      }
      i = ((n)((j)localObject).vzx.get(((j)localObject).vzw - 1)).Fe - 1;
      break label71;
      label174:
      if (m < ((j)localObject).vzw) {
        j = ((n)((j)localObject).vzx.get(m)).Fe;
      } else {
        j = ((n)((j)localObject).vzx.get(((j)localObject).vzw - 1)).Fe - 1;
      }
    }
  }
  
  public int getPosInDataList()
  {
    return this.vzg;
  }
  
  public int getRecyclerItemPosition()
  {
    AppMethodBeat.i(26805);
    if (this.vyV.jM() == -1)
    {
      AppMethodBeat.o(26805);
      return 0;
    }
    int i = this.vyV.jM();
    AppMethodBeat.o(26805);
    return i;
  }
  
  public String getSelectedText()
  {
    AppMethodBeat.i(26802);
    Object localObject = getText();
    e locale = getSelection();
    if ((locale.akX >= 0) && (locale.Fe >= 0) && (locale.Fe <= ((Spannable)localObject).length()))
    {
      localObject = ((Spannable)localObject).subSequence(locale.akX, locale.Fe).toString();
      AppMethodBeat.o(26802);
      return localObject;
    }
    AppMethodBeat.o(26802);
    return null;
  }
  
  public e getSelection()
  {
    AppMethodBeat.i(26803);
    e locale = new e(getSelectionStart(), getSelectionEnd());
    AppMethodBeat.o(26803);
    return locale;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(26818);
    Object localObject;
    d locald;
    int j;
    int m;
    int k;
    int i;
    if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) && (this.vyT == 0))
    {
      localObject = getText();
      if (localObject != null)
      {
        locald = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dje();
        j = -1;
        m = 0;
        switch (com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().Lm(this.vzg))
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
        AppMethodBeat.o(26818);
        return;
      } while (locald.startOffset == locald.vAi);
      j = locald.startOffset;
      i = locald.vAi;
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
      i = locald.vAi;
      k = 1;
      break;
      localObject = getLayout();
    } while (localObject == null);
    if (this.vzl == -1) {
      this.vzl = getPaddingLeft();
    }
    if (this.vzm == -1) {
      this.vzm = getPaddingTop();
    }
    if (this.vzn == -1) {
      this.vzn = getPaddingBottom();
    }
    if (this.vzk == null) {
      this.vzk = new Path();
    }
    this.vzk.reset();
    label544:
    label832:
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
        f1 = ((Layout)localObject).getPrimaryHorizontal(j) + this.vzl;
        f2 = ((Layout)localObject).getLineTop(n) + this.vzm;
        f3 = ((Layout)localObject).getLineBottom(n) + this.vzm;
        f4 = ((Layout)localObject).getPrimaryHorizontal(i) + this.vzl;
        f5 = ((Layout)localObject).getLineTop(i1) + this.vzm;
        f6 = ((Layout)localObject).getLineBottom(i1) + this.vzm;
        if ((k == 0) || (m == 0)) {
          break label544;
        }
        this.vzk.addRect(this.vzl, 0.0F, this.vzl + i2, f6 + this.vzn, Path.Direction.CW);
        if (this.vzk.isEmpty()) {
          break;
        }
        if (this.vzh == null)
        {
          this.vzh = new Paint(1);
          this.vzh.setColor(1347529272);
        }
        paramCanvas.drawPath(this.vzk, this.vzh);
      }
      catch (Exception localException)
      {
        ab.e("noteeditor.WXRTEditText", "tryDrawCover: ", new Object[] { localException });
      }
      break;
      if (n == i1)
      {
        if (k != 0) {
          this.vzk.addRect(this.vzl, 0.0F, f4, f6, Path.Direction.CW);
        } else if (m != 0) {
          this.vzk.addRect(f1, f2, this.vzl + i2, f6 + this.vzn, Path.Direction.CW);
        } else {
          this.vzk.addRect(f1, f2, f4, f6, Path.Direction.CW);
        }
      }
      else
      {
        if (k != 0)
        {
          this.vzk.addRect(this.vzl, 0.0F, this.vzl + i2, f3, Path.Direction.CW);
          this.vzk.addRect(this.vzl, f5, f4, f6, Path.Direction.CW);
        }
        for (;;)
        {
          if (i1 - n <= 1) {
            break label832;
          }
          this.vzk.addRect(this.vzl, f3, this.vzl + i2, f5, Path.Direction.CW);
          break;
          if (m != 0)
          {
            this.vzk.addRect(f1, f2, this.vzl + i2, f3, Path.Direction.CW);
            this.vzk.addRect(this.vzl, f5, this.vzl + i2, f6 + this.vzn, Path.Direction.CW);
          }
          else
          {
            this.vzk.addRect(f1, f2, this.vzl + i2, f3, Path.Direction.CW);
            this.vzk.addRect(this.vzl, f5, f4, f6, Path.Direction.CW);
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(26799);
    this.vzo = false;
    this.vyK = -1;
    this.vyL = -1;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (this.vyJ != null) {
      this.vyJ.a(this, paramBoolean, getRecyclerItemPosition());
    }
    if ((paramBoolean) && (!this.vzo)) {
      onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }
    AppMethodBeat.o(26799);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26800);
    try
    {
      if (this.vyM) {
        return;
      }
      this.vzo = true;
      if (paramInt1 < 0)
      {
        AppMethodBeat.o(26800);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(26800);
    }
    if ((this.vyK != paramInt1) || (this.vyL != paramInt2))
    {
      this.vyK = paramInt1;
      this.vyL = paramInt2;
      super.onSelectionChanged(paramInt1, paramInt2);
      if (paramInt2 <= paramInt1) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      this.vyX = bool;
      if ((!this.vyY) && (!this.vyZ))
      {
        this.vza = true;
        u.a(this, new t[0]);
        this.vza = false;
        setParagraphsAreUp2Date(true);
      }
      if (this.vyJ != null)
      {
        this.vzb = true;
        this.vyJ.a(this, paramInt1, paramInt2);
        this.vzb = false;
      }
      if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) && (!this.vzj) && (hasFocus()) && (this.vzg >= 0))
      {
        gY(paramInt1, paramInt2);
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().Lm(this.vzg) == 1)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.c.e locale = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc();
          if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit)
          {
            locale.i(true, 0L);
            locale.djk();
            locale.dji();
          }
        }
      }
      AppMethodBeat.o(26800);
      return;
    }
  }
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26808);
    this.vyW = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(26808);
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(26810);
    this.vyW = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(26810);
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26809);
    this.vyW = true;
    if (((paramObject instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(26809);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: sipush 26806
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: ldc_w 627
    //   10: if_icmpne +20 -> 30
    //   13: aload_0
    //   14: getfield 238	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyJ	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   17: invokeinterface 630 1 0
    //   22: sipush 26806
    //   25: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_1
    //   29: ireturn
    //   30: iload_1
    //   31: ldc_w 631
    //   34: if_icmpeq +10 -> 44
    //   37: iload_1
    //   38: ldc_w 632
    //   41: if_icmpne +91 -> 132
    //   44: invokestatic 637	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:clearData	()V
    //   47: aload_0
    //   48: iload_1
    //   49: invokespecial 639	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   52: istore_3
    //   53: iload_1
    //   54: ldc_w 640
    //   57: if_icmpne +20 -> 77
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vzq	I
    //   65: aload_0
    //   66: invokevirtual 179	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   69: astore 4
    //   71: aload_0
    //   72: aload 4
    //   74: invokespecial 642	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   77: iload_1
    //   78: ldc_w 640
    //   81: if_icmpne +43 -> 124
    //   84: aload_0
    //   85: getfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vxe	Z
    //   88: ifeq +36 -> 124
    //   91: aload_0
    //   92: getfield 238	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyJ	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   95: ifnull +24 -> 119
    //   98: aload_0
    //   99: getfield 238	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyJ	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   102: iconst_0
    //   103: lconst_0
    //   104: invokeinterface 401 4 0
    //   109: aload_0
    //   110: getfield 238	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyJ	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   113: iconst_0
    //   114: invokeinterface 404 2 0
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vxe	Z
    //   124: sipush 26806
    //   127: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iload_3
    //   131: ireturn
    //   132: iload_1
    //   133: ldc_w 640
    //   136: if_icmpne -89 -> 47
    //   139: aload_0
    //   140: invokevirtual 164	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getContext	()Landroid/content/Context;
    //   143: pop
    //   144: invokestatic 645	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:diD	()I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_2
    //   150: if_icmpne +9 -> 159
    //   153: invokestatic 637	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:clearData	()V
    //   156: goto -109 -> 47
    //   159: iload_2
    //   160: iconst_3
    //   161: if_icmpne -114 -> 47
    //   164: aload_0
    //   165: getfield 238	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyJ	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   168: aload_0
    //   169: invokeinterface 647 2 0
    //   174: sipush 26806
    //   177: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore 4
    //   184: ldc_w 567
    //   187: ldc_w 649
    //   190: iconst_1
    //   191: anewarray 197	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 4
    //   198: aastore
    //   199: invokestatic 574	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: sipush 26806
    //   205: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore 5
    //   212: ldc_w 567
    //   215: ldc_w 651
    //   218: iconst_1
    //   219: anewarray 197	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: getfield 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vzq	I
    //   228: invokestatic 657	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 574	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_0
    //   236: getfield 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vzq	I
    //   239: iconst_3
    //   240: if_icmpge +45 -> 285
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vzq	I
    //   248: iconst_1
    //   249: iadd
    //   250: putfield 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vzq	I
    //   253: aload_0
    //   254: new 659	android/text/SpannableStringBuilder
    //   257: dup
    //   258: iconst_2
    //   259: anewarray 451	java/lang/CharSequence
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 661
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: aastore
    //   273: invokestatic 667	android/text/TextUtils:concat	([Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   276: invokespecial 668	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   279: invokespecial 642	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   282: goto -205 -> 77
    //   285: sipush 26806
    //   288: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 5
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	WXRTEditText
    //   0	294	1	paramInt	int
    //   147	15	2	i	int
    //   52	79	3	bool	boolean
    //   69	4	4	localEditable	Editable
    //   182	89	4	localNullPointerException	java.lang.NullPointerException
    //   210	82	5	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   47	53	182	java/lang/NullPointerException
    //   71	77	210	java/lang/IndexOutOfBoundsException
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(26819);
    Object localObject1;
    int i;
    label391:
    boolean bool1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      localObject1 = getText();
      if (localObject1 == null)
      {
        diS();
        AppMethodBeat.o(26819);
        return true;
      }
      int j = ((Editable)localObject1).length();
      i = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((j < 0) || (i < 0) || (i > j))
      {
        diS();
        AppMethodBeat.o(26819);
        return true;
      }
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(26819);
            return true;
            j = (int)paramMotionEvent.getX();
            int k = (int)paramMotionEvent.getY();
            Object localObject2 = getLayout();
            k = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k), j);
            localObject2 = (k[])getText().getSpans(k, k + 1, k.class);
            if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().isEditable()) && (j < b.dim()) && (localObject2.length != 0))
            {
              ab.i("noteeditor.WXRTEditText", "clicked todo");
              this.vyJ.dih();
              localObject2[0].a(this, (Spannable)localObject1, paramMotionEvent, localObject2[0]);
            }
            else
            {
              diS();
              this.vzi.a(1, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), i);
              diR();
              this.bAz.ag(500L, 0L);
              continue;
              diS();
              diR();
            }
          }
          diR();
        } while (this.vzi == null);
        localObject1 = this.vzi;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAa = f1;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAb = f2;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAc = f3;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAd = f4;
        if (((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).kwo != 1) {
          break;
        }
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAe = i;
        j = this.vzi.getType();
        diS();
      } while (j != 2);
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().isEditable()) {
        if (hasFocus())
        {
          if ((getSelectionStart() != getSelectionEnd()) || (i != getSelectionStart())) {
            break label707;
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
      if (this.vyJ != null)
      {
        this.vyJ.h(true, 50L);
        this.vyJ.Lg(1);
      }
      gY(i, i);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().ac(bool2, bool1);
      break;
      ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).vAe = 0;
      break label391;
      requestFocus();
      bool1 = false;
      bool2 = false;
      continue;
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().dje();
      bool1 = bool2;
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc().djj())
      {
        bool1 = bool2;
        if (paramMotionEvent.djb() == 1)
        {
          bool1 = bool2;
          if (paramMotionEvent.chT == this.vzg)
          {
            bool1 = bool2;
            if (paramMotionEvent.startOffset == i) {
              bool1 = true;
            }
          }
        }
      }
      gY(i, i);
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.djc();
      if (!com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit) {
        break;
      }
      paramMotionEvent.djk();
      paramMotionEvent.dji();
      paramMotionEvent.i(true, 50L);
      paramMotionEvent.oT(true);
      paramMotionEvent.oS(bool1);
      break;
      if ((paramMotionEvent.getAction() == 1) && (this.vyJ != null))
      {
        this.vyJ.h(true, 300L);
        this.vyJ.Lg(1);
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(26819);
      return bool1;
      label707:
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void setEditTextType(int paramInt)
  {
    this.vyT = paramInt;
  }
  
  public void setIgnoreSelectChangeByMultiSelect(boolean paramBoolean)
  {
    this.vzj = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(26791);
    super.setMaxHeight(paramInt);
    AppMethodBeat.o(26791);
  }
  
  public void setPosInDataList(int paramInt)
  {
    this.vzg = paramInt;
  }
  
  public void setRichTextEditing(String paramString)
  {
    AppMethodBeat.i(26793);
    diM();
    if (!bo.isNullOrNil(paramString)) {
      setSpannableText(com.tencent.mm.plugin.wenote.model.nativenote.a.a.ajK(paramString));
    }
    for (;;)
    {
      diN();
      AppMethodBeat.o(26793);
      return;
      setText("");
    }
  }
  
  public void setSpannableText(Spanned paramSpanned)
  {
    AppMethodBeat.i(26794);
    diM();
    diO();
    super.setText(paramSpanned, TextView.BufferType.EDITABLE);
    diP();
    diQ();
    u.a(this, new t[0]);
    diN();
    AppMethodBeat.o(26794);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(26795);
    diM();
    super.setText(paramString);
    diN();
    AppMethodBeat.o(26795);
  }
  
  public void setTextWithoutIgnore(String paramString)
  {
    AppMethodBeat.i(26796);
    super.setText(paramString);
    AppMethodBeat.o(26796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText
 * JD-Core Version:    0.7.0.1
 */