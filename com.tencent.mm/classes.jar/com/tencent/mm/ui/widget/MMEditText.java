package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText
  extends PasterEditText
{
  private InputConnection LnC;
  private boolean LnD = false;
  private a LnE;
  int pCk = 0;
  
  public MMEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aNS(String paramString)
  {
    AppMethodBeat.i(143360);
    int i = getSelectionStart();
    setText(b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(143360);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(143360);
  }
  
  public final void aZf(String paramString)
  {
    AppMethodBeat.i(143355);
    getContext();
    int m = b.cV(getText().toString(), getSelectionStart());
    getContext();
    int i = b.cV(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.lA(21))
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
            break label252;
          }
          i = ((InputFilter.LengthFilter)localInputFilter).getMax();
        }
      }
    }
    label252:
    for (;;)
    {
      j += 1;
      break;
      i = paramString.length() + m;
      if ((k > 0) && (i > k))
      {
        ae.d("MicroMsg.MMEditText", "exceed :%s, %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        AppMethodBeat.o(143355);
        return;
      }
      setText(b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(143355);
      return;
    }
  }
  
  public final void fPJ()
  {
    AppMethodBeat.i(193764);
    if (getInputConnection() != null)
    {
      getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      AppMethodBeat.o(193764);
      return;
    }
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(193764);
  }
  
  public InputConnection getInputConnection()
  {
    return this.LnC;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(143354);
    this.LnC = super.onCreateInputConnection(paramEditorInfo);
    if ((this.LnC != null) && (this.LnD)) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    paramEditorInfo = this.LnC;
    AppMethodBeat.o(143354);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143361);
    if (this.LnE == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      ae.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.LnE == null) || (paramInt != 4)) {
        break label191;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      ae.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      AppMethodBeat.o(143361);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      ae.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        ae.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
        this.LnE.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(143361);
        return true;
      }
    }
    label191:
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(143361);
    return bool;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 261
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 263	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 264
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 27	com/tencent/mm/ui/widget/MMEditText:pCk	I
    //   24: aload_0
    //   25: invokevirtual 69	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 91	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokespecial 266	com/tencent/mm/ui/widget/MMEditText:aNS	(Ljava/lang/String;)V
    //   37: ldc_w 261
    //   40: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 134
    //   48: ldc_w 268
    //   51: iconst_1
    //   52: anewarray 87	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 271	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 134
    //   70: ldc_w 273
    //   73: iconst_1
    //   74: anewarray 87	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 271	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 261
    //   87: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 134
    //   96: ldc_w 275
    //   99: iconst_1
    //   100: anewarray 87	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 27	com/tencent/mm/ui/widget/MMEditText:pCk	I
    //   109: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 271	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 27	com/tencent/mm/ui/widget/MMEditText:pCk	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 27	com/tencent/mm/ui/widget/MMEditText:pCk	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 27	com/tencent/mm/ui/widget/MMEditText:pCk	I
    //   134: aload_0
    //   135: ldc_w 277
    //   138: aload_3
    //   139: invokestatic 280	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokespecial 266	com/tencent/mm/ui/widget/MMEditText:aNS	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 261
    //   154: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 4
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	MMEditText
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
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(143356);
    try
    {
      boolean bool = super.requestFocus(paramInt, paramRect);
      AppMethodBeat.o(143356);
      return bool;
    }
    catch (IllegalStateException paramRect)
    {
      ae.e("MicroMsg.MMEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(143356);
    }
    return false;
  }
  
  public void setBackListener(a parama)
  {
    this.LnE = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.LnD = paramBoolean;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(143357);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(143357);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ae.printErrStackTrace("MicroMsg.MMEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(143357);
    }
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143358);
    super.setSelection(paramInt1, paramInt2);
    AppMethodBeat.o(143358);
  }
  
  public static abstract interface a
  {
    public abstract void onBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText
 * JD-Core Version:    0.7.0.1
 */