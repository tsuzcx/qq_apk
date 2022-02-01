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
  private static final String Ybw;
  private InputConnection Ybl;
  private boolean Ybm;
  private MMEditText.a Ybn;
  private MMEditText.d Ybo;
  private boolean YeE;
  private a YeF;
  int utI;
  
  static
  {
    AppMethodBeat.i(220535);
    Ybw = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    AppMethodBeat.o(220535);
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Ybm = false;
    this.YeE = false;
    this.utI = 0;
  }
  
  public MMCustomEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220438);
    this.Ybm = false;
    this.YeE = false;
    this.utI = 0;
    this.YeF = new MMCustomEditText.2(this);
    AppMethodBeat.o(220438);
  }
  
  private void bqQ(String paramString)
  {
    AppMethodBeat.i(220490);
    int i = getSelectionStart();
    setText(com.tencent.mm.ui.h.c.b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(220490);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(220490);
  }
  
  private String getFilterText()
  {
    AppMethodBeat.i(220499);
    Object localObject = getText();
    if (localObject == null)
    {
      AppMethodBeat.o(220499);
      return "";
    }
    localObject = ((CharSequence)localObject).toString().replaceAll(Ybw, "*");
    AppMethodBeat.o(220499);
    return localObject;
  }
  
  public final void Hm(boolean paramBoolean) {}
  
  public final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220443);
    try
    {
      super.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
      AppMethodBeat.o(220443);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.MMCustomEditText", "init crash:%s", new Object[] { Util.stackTraceToString(paramContext) });
      b.axG(0);
      this.YeE = true;
      AppMethodBeat.o(220443);
    }
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(220496);
    if (parama == null)
    {
      AppMethodBeat.o(220496);
      return;
    }
    setOnEditorActionListener(new CustomTextView.c()
    {
      public final boolean a(CustomTextView paramAnonymousCustomTextView, int paramAnonymousInt)
      {
        AppMethodBeat.i(189702);
        if ((paramAnonymousCustomTextView instanceof c))
        {
          boolean bool = parama.rQ(paramAnonymousInt);
          AppMethodBeat.o(189702);
          return bool;
        }
        AppMethodBeat.o(189702);
        return false;
      }
    });
    AppMethodBeat.o(220496);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(220518);
    try
    {
      super.a(paramCharSequence, paramBufferType, paramBoolean, paramInt);
      AppMethodBeat.o(220518);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramBufferType = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[setText] text:%s, e:%s", new Object[] { paramBufferType, paramCharSequence });
      if (this.YeF != null) {
        this.YeF.a(paramCharSequence, paramBufferType, "setText");
      }
      b.axG(3);
      paramBufferType = com.tencent.mm.util.d.YyA;
      if (com.tencent.mm.util.d.ien())
      {
        AppMethodBeat.o(220518);
        throw paramCharSequence;
      }
      AppMethodBeat.o(220518);
    }
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(220524);
    setReuseBrands(paramList1);
    setReuseItems(paramList2);
    setHighlightColor(getContext().getResources().getColor(a.d.selected_blue));
    setMenuCallback(parame);
    AppMethodBeat.o(220524);
  }
  
  public final void bBa(String paramString)
  {
    AppMethodBeat.i(220467);
    getContext();
    int m = com.tencent.mm.ui.h.c.b.dv(getText().toString(), getSelectionStart());
    getContext();
    int i = com.tencent.mm.ui.h.c.b.dv(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (com.tencent.mm.compatible.util.d.qV(21))
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
        AppMethodBeat.o(220467);
        return;
      }
      setText(com.tencent.mm.ui.h.c.b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(220467);
      return;
    }
  }
  
  public final void destroy() {}
  
  public InputConnection getInputConnection()
  {
    return this.Ybl;
  }
  
  public final boolean hZB()
  {
    AppMethodBeat.i(220531);
    boolean bool = requestFocus();
    AppMethodBeat.o(220531);
    return bool;
  }
  
  public final Context hZC()
  {
    AppMethodBeat.i(220532);
    Context localContext = getContext();
    AppMethodBeat.o(220532);
    return localContext;
  }
  
  public final int hZD()
  {
    AppMethodBeat.i(220533);
    int i = getWidth();
    AppMethodBeat.o(220533);
    return i;
  }
  
  public final void hZw() {}
  
  public final View hZx()
  {
    return this;
  }
  
  public final boolean hZy()
  {
    return this.YeE;
  }
  
  public final ViewParent hZz()
  {
    AppMethodBeat.i(220528);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(220528);
    return localViewParent;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(220453);
    this.Ybl = super.onCreateInputConnection(paramEditorInfo);
    if ((this.Ybl != null) && (this.Ybm))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    paramEditorInfo = this.Ybl;
    AppMethodBeat.o(220453);
    return paramEditorInfo;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(220503);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(220503);
      return;
    }
    catch (Throwable paramCanvas)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onDraw] text:%s, e:%s", new Object[] { localObject, paramCanvas });
      if (this.YeF != null) {
        this.YeF.a(paramCanvas, (String)localObject, "onDraw");
      }
      b.axG(2);
      localObject = com.tencent.mm.util.d.YyA;
      if (com.tencent.mm.util.d.ien())
      {
        AppMethodBeat.o(220503);
        throw paramCanvas;
      }
      AppMethodBeat.o(220503);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(220494);
    if (this.Ybn == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.MMCustomEditText", "on onKeyPreIme, listener null ? %B keycode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((this.Ybn == null) || (paramInt != 4)) {
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
      AppMethodBeat.o(220494);
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
        this.Ybn.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(220494);
        return true;
      }
    }
    label206:
    if ((this.Ybo != null) && (this.Ybo.aqF(paramInt)))
    {
      AppMethodBeat.o(220494);
      return true;
    }
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(220494);
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220510);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(220510);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onMeasure] text:%s, e:%s", new Object[] { localObject, localThrowable });
      if (this.YeF != null) {
        this.YeF.a(localThrowable, (String)localObject, "onMeasure");
      }
      b.axG(1);
      localObject = com.tencent.mm.util.d.YyA;
      if (com.tencent.mm.util.d.ien())
      {
        AppMethodBeat.o(220510);
        throw localThrowable;
      }
      AppMethodBeat.o(220510);
    }
  }
  
  public final void onPause() {}
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(220506);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(220506);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.MMCustomEditText", "onPreDraw err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
      b.axG(8);
      AppMethodBeat.o(220506);
    }
    return false;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 425
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 427	com/tencent/mm/ui/widget/cedit/api/PasterEditTextCompact:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 428
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:utI	I
    //   24: aload_0
    //   25: invokevirtual 96	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 224	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokespecial 430	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:bqQ	(Ljava/lang/String;)V
    //   37: ldc_w 425
    //   40: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 132
    //   48: ldc_w 432
    //   51: iconst_1
    //   52: anewarray 136	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 132
    //   70: ldc_w 434
    //   73: iconst_1
    //   74: anewarray 136	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 425
    //   87: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 132
    //   96: ldc_w 436
    //   99: iconst_1
    //   100: anewarray 136	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:utI	I
    //   109: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:utI	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:utI	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 56	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:utI	I
    //   134: aload_0
    //   135: ldc_w 438
    //   138: aload_3
    //   139: invokestatic 441	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 445	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial 430	com/tencent/mm/ui/widget/cedit/api/MMCustomEditText:bqQ	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 425
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
    AppMethodBeat.i(220522);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(220522);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      Object localObject = getFilterText();
      Log.e("MicroMsg.MMCustomEditText", "[onTouchEvent] text:%s, e:%s", new Object[] { localObject, paramMotionEvent });
      if (this.YeF != null) {
        this.YeF.a(paramMotionEvent, (String)localObject, "onTouchEvent");
      }
      b.axG(4);
      localObject = com.tencent.mm.util.d.YyA;
      if (com.tencent.mm.util.d.ien())
      {
        AppMethodBeat.o(220522);
        throw paramMotionEvent;
      }
      AppMethodBeat.o(220522);
    }
    return false;
  }
  
  public final void refresh(boolean paramBoolean) {}
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(220470);
    try
    {
      boolean bool = super.requestFocus(paramInt, paramRect);
      AppMethodBeat.o(220470);
      return bool;
    }
    catch (IllegalStateException paramRect)
    {
      Log.e("MicroMsg.MMCustomEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(220470);
    }
    return false;
  }
  
  public void setBackListener(MMEditText.a parama)
  {
    this.Ybn = parama;
  }
  
  public void setEditCrashListener(a parama)
  {
    this.YeF = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.Ybm = paramBoolean;
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    this.Ybo = paramd;
  }
  
  public void setPasterLen(int paramInt) {}
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(220471);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(220471);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.printErrStackTrace("MicroMsg.MMCustomEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(220471);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMCustomEditText
 * JD-Core Version:    0.7.0.1
 */