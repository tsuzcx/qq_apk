package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.anim.content.b.a;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

public class MMCustomEditText
  extends PasterEditTextCompact
  implements c
{
  private static final String afTo;
  private InputConnection afTd;
  private boolean afTe;
  private MMEditText.a afTf;
  private MMEditText.d afTg;
  private a afWA;
  private boolean afWz;
  int xAf;
  
  static
  {
    AppMethodBeat.i(252267);
    afTo = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    AppMethodBeat.o(252267);
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.afTe = false;
    this.afWz = false;
    this.xAf = 0;
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252242);
    this.afTe = false;
    this.afWz = false;
    this.xAf = 0;
    this.afWA = new MMCustomEditText.2(this);
    AppMethodBeat.o(252242);
  }
  
  private void bqF(String paramString)
  {
    AppMethodBeat.i(252254);
    int i = getSelectionStart();
    setText(com.tencent.mm.ui.i.c.b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(252254);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(252254);
  }
  
  private String getFilterText()
  {
    AppMethodBeat.i(252261);
    Object localObject = getText();
    if (localObject == null)
    {
      AppMethodBeat.o(252261);
      return "";
    }
    localObject = ((CharSequence)localObject).toString().replaceAll(afTo, "*");
    AppMethodBeat.o(252261);
    return localObject;
  }
  
  public final void Ni(boolean paramBoolean) {}
  
  public final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252275);
    try
    {
      super.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
      AppMethodBeat.o(252275);
      return;
    }
    finally
    {
      Log.e("MicroMsg.MMCustomEditText", "init crash:%s", new Object[] { Util.stackTraceToString(paramContext) });
      b.aEp(0);
      this.afWz = true;
      AppMethodBeat.o(252275);
    }
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(252341);
    if (parama == null)
    {
      AppMethodBeat.o(252341);
      return;
    }
    setOnEditorActionListener(new CustomTextView.c()
    {
      public final boolean a(CustomTextView paramAnonymousCustomTextView, int paramAnonymousInt)
      {
        AppMethodBeat.i(252208);
        if ((paramAnonymousCustomTextView instanceof c))
        {
          boolean bool = parama.rR(paramAnonymousInt);
          AppMethodBeat.o(252208);
          return bool;
        }
        AppMethodBeat.o(252208);
        return false;
      }
    });
    AppMethodBeat.o(252341);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(252386);
    try
    {
      super.a(paramCharSequence, paramBufferType, paramBoolean, paramInt);
      AppMethodBeat.o(252386);
      return;
    }
    finally
    {
      paramBufferType = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[setText] text:%s, e:%s", new Object[] { paramBufferType, paramCharSequence });
      if (this.afWA != null) {
        this.afWA.a(paramCharSequence, paramBufferType, "setText");
      }
      b.aEp(3);
      paramBufferType = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv())
      {
        AppMethodBeat.o(252386);
        throw paramCharSequence;
      }
      AppMethodBeat.o(252386);
    }
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(252415);
    setReuseBrands(paramList1);
    setReuseItems(paramList2);
    setHighlightColor(getContext().getResources().getColor(a.d.selected_blue));
    setMenuCallback(parame);
    AppMethodBeat.o(252415);
  }
  
  public final void bDt(String paramString)
  {
    AppMethodBeat.i(252300);
    getContext();
    int m = com.tencent.mm.ui.i.c.b.dW(getText().toString(), getSelectionStart());
    getContext();
    int i = com.tencent.mm.ui.i.c.b.dW(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (com.tencent.mm.compatible.util.d.rb(21))
    {
      InputFilter[] arrayOfInputFilter = getFilters();
      k = i;
      if (arrayOfInputFilter != null)
      {
        int n = arrayOfInputFilter.length;
        j = 0;
        k = i;
        if (j < n)
        {
          InputFilter localInputFilter = arrayOfInputFilter[j];
          if (!(localInputFilter instanceof InputFilter.LengthFilter)) {
            break label253;
          }
          i = ((InputFilter.LengthFilter)localInputFilter).getMax();
        }
      }
    }
    label253:
    for (;;)
    {
      j += 1;
      break;
      i = paramString.length() + m;
      if ((k > 0) && (i > k))
      {
        Log.d("MicroMsg.MMCustomEditText", "exceed :%s, %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        AppMethodBeat.o(252300);
        return;
      }
      setText(com.tencent.mm.ui.i.c.b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(252300);
      return;
    }
  }
  
  public final void cRR() {}
  
  public final void destroy() {}
  
  public InputConnection getInputConnection()
  {
    return this.afTd;
  }
  
  public com.tencent.mm.ui.anim.content.b getSizeAnimController()
  {
    AppMethodBeat.i(252429);
    Object localObject = com.tencent.mm.ui.anim.content.b.adMs;
    localObject = b.a.jlA();
    AppMethodBeat.o(252429);
    return localObject;
  }
  
  public final void jEF() {}
  
  public final View jEG()
  {
    return this;
  }
  
  public final boolean jEH()
  {
    return this.afWz;
  }
  
  public final ViewParent jEI()
  {
    AppMethodBeat.i(252457);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(252457);
    return localViewParent;
  }
  
  public final boolean jEJ()
  {
    AppMethodBeat.i(252464);
    boolean bool = requestFocus();
    AppMethodBeat.o(252464);
    return bool;
  }
  
  public final Context jEK()
  {
    AppMethodBeat.i(252468);
    Context localContext = getContext();
    AppMethodBeat.o(252468);
    return localContext;
  }
  
  public final int jEL()
  {
    AppMethodBeat.i(252474);
    int i = getWidth();
    AppMethodBeat.o(252474);
    return i;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(252285);
    this.afTd = super.onCreateInputConnection(paramEditorInfo);
    if ((this.afTd != null) && (this.afTe))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    paramEditorInfo = this.afTd;
    AppMethodBeat.o(252285);
    return paramEditorInfo;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(252358);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(252358);
      return;
    }
    finally
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onDraw] text:%s, e:%s", new Object[] { localObject, paramCanvas });
      if (this.afWA != null) {
        this.afWA.a(paramCanvas, (String)localObject, "onDraw");
      }
      b.aEp(2);
      localObject = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv())
      {
        AppMethodBeat.o(252358);
        throw paramCanvas;
      }
      AppMethodBeat.o(252358);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252335);
    if (this.afTf == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme, listener null ? %B keycode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((this.afTf == null) || (paramInt != 4)) {
        break label206;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      AppMethodBeat.o(252335);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme action up is tracking");
        this.afTf.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(252335);
        return true;
      }
    }
    label206:
    if ((this.afTg != null) && (this.afTg.awK(paramInt)))
    {
      AppMethodBeat.o(252335);
      return true;
    }
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(252335);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252377);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(252377);
      return;
    }
    finally
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onMeasure] text:%s, e:%s", new Object[] { localObject, localThrowable });
      if (this.afWA != null) {
        this.afWA.a(localThrowable, (String)localObject, "onMeasure");
      }
      b.aEp(1);
      localObject = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv())
      {
        AppMethodBeat.o(252377);
        throw localThrowable;
      }
      AppMethodBeat.o(252377);
    }
  }
  
  public final void onPause() {}
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(252368);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(252368);
      return bool;
    }
    finally
    {
      Log.e("MicroMsg.MMCustomEditText", "onPreDraw err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      b.aEp(8);
      AppMethodBeat.o(252368);
    }
    return false;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 438
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 440	com/tencent/mm/ui/widget/cedit/api/PasterEditTextCompact:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 441
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:xAf	I
    //   24: aload_0
    //   25: invokevirtual 96	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 222	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokespecial 443	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:bqF	(Ljava/lang/String;)V
    //   37: ldc_w 438
    //   40: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 130
    //   48: ldc_w 445
    //   51: iconst_1
    //   52: anewarray 134	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 130
    //   70: ldc_w 447
    //   73: iconst_1
    //   74: anewarray 134	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 438
    //   87: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 130
    //   96: ldc_w 449
    //   99: iconst_1
    //   100: anewarray 134	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:xAf	I
    //   109: invokestatic 267	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:xAf	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:xAf	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:xAf	I
    //   134: aload_0
    //   135: ldc_w 451
    //   138: aload_3
    //   139: invokestatic 454	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 458	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial 443	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:bqF	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 438
    //   154: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 4
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	MMCustomEditText
    //   0	160	1	paramInt	int
    //   11	53	2	bool	boolean
    //   31	3	3	str	String
    //   45	13	3	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   67	72	3	localNullPointerException	java.lang.NullPointerException
    //   92	66	4	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   6	12	45	java/lang/IndexOutOfBoundsException
    //   6	12	67	java/lang/NullPointerException
    //   32	37	92	java/lang/IndexOutOfBoundsException
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252396);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(252396);
      return bool;
    }
    finally
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onTouchEvent] text:%s, e:%s", new Object[] { localObject, paramMotionEvent });
      if (this.afWA != null) {
        this.afWA.a(paramMotionEvent, (String)localObject, "onTouchEvent");
      }
      b.aEp(4);
      localObject = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv())
      {
        AppMethodBeat.o(252396);
        throw paramMotionEvent;
      }
      AppMethodBeat.o(252396);
    }
    return false;
  }
  
  public final void refresh(boolean paramBoolean) {}
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(252310);
    try
    {
      boolean bool = super.requestFocus(paramInt, paramRect);
      AppMethodBeat.o(252310);
      return bool;
    }
    catch (IllegalStateException paramRect)
    {
      Log.e("MicroMsg.MMCustomEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(252310);
    }
    return false;
  }
  
  public void setBackListener(MMEditText.a parama)
  {
    this.afTf = parama;
  }
  
  public void setEditCrashListener(a parama)
  {
    this.afWA = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.afTe = paramBoolean;
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    this.afTg = paramd;
  }
  
  public void setPasterLen(int paramInt) {}
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(252317);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(252317);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.printErrStackTrace("MicroMsg.MMCustomEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(252317);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMCustomEditText
 * JD-Core Version:    0.7.0.1
 */