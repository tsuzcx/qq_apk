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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static final String QCU;
  private InputConnection QCI;
  private boolean QCJ;
  private MMEditText.a QCK;
  private MMEditText.d QCL;
  private boolean QFP;
  private a QFQ;
  int qRC;
  
  static
  {
    AppMethodBeat.i(205472);
    QCU = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    AppMethodBeat.o(205472);
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.QCJ = false;
    this.QFP = false;
    this.qRC = 0;
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205451);
    this.QCJ = false;
    this.QFP = false;
    this.qRC = 0;
    this.QFQ = new MMCustomEditText.2(this);
    AppMethodBeat.o(205451);
  }
  
  private void beu(String paramString)
  {
    AppMethodBeat.i(205458);
    int i = getSelectionStart();
    setText(com.tencent.mm.ui.g.c.b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(205458);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(205458);
  }
  
  private String getFilterText()
  {
    AppMethodBeat.i(205461);
    Object localObject = getText();
    if (localObject == null)
    {
      AppMethodBeat.o(205461);
      return "";
    }
    localObject = ((CharSequence)localObject).toString().replaceAll(QCU, "*");
    AppMethodBeat.o(205461);
    return localObject;
  }
  
  public final void CS(boolean paramBoolean) {}
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(205460);
    if (parama == null)
    {
      AppMethodBeat.o(205460);
      return;
    }
    setOnEditorActionListener(new CustomTextView.c()
    {
      public final boolean a(CustomTextView paramAnonymousCustomTextView, int paramAnonymousInt)
      {
        AppMethodBeat.i(205449);
        if ((paramAnonymousCustomTextView instanceof c))
        {
          boolean bool = parama.ZY(paramAnonymousInt);
          AppMethodBeat.o(205449);
          return bool;
        }
        AppMethodBeat.o(205449);
        return false;
      }
    });
    AppMethodBeat.o(205460);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205465);
    try
    {
      super.a(paramCharSequence, paramBufferType, paramBoolean, paramInt);
      AppMethodBeat.o(205465);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramBufferType = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[setText] text:%s, e:%s", new Object[] { paramBufferType, paramCharSequence });
      if (this.QFQ != null) {
        this.QFQ.a(paramCharSequence, paramBufferType, "setText");
      }
      b.aow(3);
      paramBufferType = com.tencent.mm.util.c.QYz;
      if (com.tencent.mm.util.c.hdg())
      {
        AppMethodBeat.o(205465);
        throw paramCharSequence;
      }
      AppMethodBeat.o(205465);
    }
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(205467);
    setReuseBrands(paramList1);
    setReuseItems(paramList2);
    setHighlightColor(getContext().getResources().getColor(2131101045));
    setMenuCallback(parame);
    AppMethodBeat.o(205467);
  }
  
  public final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205452);
    try
    {
      super.b(paramContext, paramAttributeSet, paramInt1, paramInt2);
      AppMethodBeat.o(205452);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.MMCustomEditText", "init crash:%s", new Object[] { Util.stackTraceToString(paramContext) });
      b.aow(0);
      this.QFP = true;
      AppMethodBeat.o(205452);
    }
  }
  
  public final void bol(String paramString)
  {
    AppMethodBeat.i(205454);
    getContext();
    int m = com.tencent.mm.ui.g.c.b.db(getText().toString(), getSelectionStart());
    getContext();
    int i = com.tencent.mm.ui.g.c.b.db(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.oD(21))
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
        AppMethodBeat.o(205454);
        return;
      }
      setText(com.tencent.mm.ui.g.c.b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(205454);
      return;
    }
  }
  
  public final void destroy() {}
  
  public final void gYF() {}
  
  public final View gYG()
  {
    return this;
  }
  
  public final boolean gYH()
  {
    return this.QFP;
  }
  
  public final ViewParent gYI()
  {
    AppMethodBeat.i(205468);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(205468);
    return localViewParent;
  }
  
  public final boolean gYJ()
  {
    AppMethodBeat.i(205469);
    boolean bool = requestFocus();
    AppMethodBeat.o(205469);
    return bool;
  }
  
  public final Context gYK()
  {
    AppMethodBeat.i(205470);
    Context localContext = getContext();
    AppMethodBeat.o(205470);
    return localContext;
  }
  
  public final int gYL()
  {
    AppMethodBeat.i(205471);
    int i = getWidth();
    AppMethodBeat.o(205471);
    return i;
  }
  
  public InputConnection getInputConnection()
  {
    return this.QCI;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(205453);
    this.QCI = super.onCreateInputConnection(paramEditorInfo);
    if ((this.QCI != null) && (this.QCJ))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    paramEditorInfo = this.QCI;
    AppMethodBeat.o(205453);
    return paramEditorInfo;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(205462);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(205462);
      return;
    }
    catch (Throwable paramCanvas)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onDraw] text:%s, e:%s", new Object[] { localObject, paramCanvas });
      if (this.QFQ != null) {
        this.QFQ.a(paramCanvas, (String)localObject, "onDraw");
      }
      b.aow(2);
      localObject = com.tencent.mm.util.c.QYz;
      if (com.tencent.mm.util.c.hdg())
      {
        AppMethodBeat.o(205462);
        throw paramCanvas;
      }
      AppMethodBeat.o(205462);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205459);
    if (this.QCK == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme, listener null ? %B keycode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((this.QCK == null) || (paramInt != 4)) {
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
      AppMethodBeat.o(205459);
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
        this.QCK.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(205459);
        return true;
      }
    }
    label206:
    if ((this.QCL != null) && (this.QCL.aiD(paramInt)))
    {
      AppMethodBeat.o(205459);
      return true;
    }
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(205459);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205464);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(205464);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onMeasure] text:%s, e:%s", new Object[] { localObject, localThrowable });
      if (this.QFQ != null) {
        this.QFQ.a(localThrowable, (String)localObject, "onMeasure");
      }
      b.aow(1);
      localObject = com.tencent.mm.util.c.QYz;
      if (com.tencent.mm.util.c.hdg())
      {
        AppMethodBeat.o(205464);
        throw localThrowable;
      }
      AppMethodBeat.o(205464);
    }
  }
  
  public final void onPause() {}
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(205463);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(205463);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MMCustomEditText", "onPreDraw err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      b.aow(8);
      AppMethodBeat.o(205463);
    }
    return false;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 422
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 424	com/tencent/mm/ui/widget/cedit/api/PasterEditTextCompact:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 425
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:qRC	I
    //   24: aload_0
    //   25: invokevirtual 96	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 221	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokespecial 427	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:beu	(Ljava/lang/String;)V
    //   37: ldc_w 422
    //   40: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 143
    //   48: ldc_w 429
    //   51: iconst_1
    //   52: anewarray 147	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 143
    //   70: ldc_w 431
    //   73: iconst_1
    //   74: anewarray 147	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 422
    //   87: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 143
    //   96: ldc_w 433
    //   99: iconst_1
    //   100: anewarray 147	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:qRC	I
    //   109: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:qRC	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:qRC	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:qRC	I
    //   134: aload_0
    //   135: ldc_w 435
    //   138: aload_3
    //   139: invokestatic 438	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 442	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial 427	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:beu	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 422
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
    AppMethodBeat.i(205466);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(205466);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onTouchEvent] text:%s, e:%s", new Object[] { localObject, paramMotionEvent });
      if (this.QFQ != null) {
        this.QFQ.a(paramMotionEvent, (String)localObject, "onTouchEvent");
      }
      b.aow(4);
      localObject = com.tencent.mm.util.c.QYz;
      if (com.tencent.mm.util.c.hdg())
      {
        AppMethodBeat.o(205466);
        throw paramMotionEvent;
      }
      AppMethodBeat.o(205466);
    }
    return false;
  }
  
  public final void refresh(boolean paramBoolean) {}
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(205455);
    try
    {
      boolean bool = super.requestFocus(paramInt, paramRect);
      AppMethodBeat.o(205455);
      return bool;
    }
    catch (IllegalStateException paramRect)
    {
      Log.e("MicroMsg.MMCustomEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(205455);
    }
    return false;
  }
  
  public void setBackListener(MMEditText.a parama)
  {
    this.QCK = parama;
  }
  
  public void setEditCrashListener(a parama)
  {
    this.QFQ = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.QCJ = paramBoolean;
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    this.QCL = paramd;
  }
  
  public void setPasterLen(int paramInt) {}
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(205456);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(205456);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.printErrStackTrace("MicroMsg.MMCustomEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(205456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMCustomEditText
 * JD-Core Version:    0.7.0.1
 */