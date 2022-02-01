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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText
  extends PasterEditText
{
  private InputConnection Hzv;
  private boolean Hzw = false;
  private a Hzx;
  int oow = 0;
  
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
  
  private void aBB(String paramString)
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
  
  public final void aMd(String paramString)
  {
    AppMethodBeat.i(143355);
    getContext();
    int m = b.cJ(getText().toString(), getSelectionStart());
    getContext();
    int i = b.cJ(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.lf(21))
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
        ad.d("MicroMsg.MMEditText", "exceed :%s, %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        AppMethodBeat.o(143355);
        return;
      }
      setText(b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(143355);
      return;
    }
  }
  
  public InputConnection getInputConnection()
  {
    return this.Hzv;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(143354);
    this.Hzv = super.onCreateInputConnection(paramEditorInfo);
    if ((this.Hzv != null) && (this.Hzw)) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    paramEditorInfo = this.Hzv;
    AppMethodBeat.o(143354);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143361);
    if (this.Hzx == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      ad.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.Hzx == null) || (paramInt != 4)) {
        break label191;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      ad.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      AppMethodBeat.o(143361);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      ad.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        ad.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
        this.Hzx.onBack();
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
    //   0: ldc 245
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iload_1
    //   7: invokespecial 247	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   10: istore_2
    //   11: iload_1
    //   12: ldc 248
    //   14: if_icmpne +21 -> 35
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 27	com/tencent/mm/ui/widget/MMEditText:oow	I
    //   22: aload_0
    //   23: invokevirtual 69	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   26: invokevirtual 91	java/lang/Object:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: invokespecial 250	com/tencent/mm/ui/widget/MMEditText:aBB	(Ljava/lang/String;)V
    //   35: ldc 245
    //   37: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload_2
    //   41: ireturn
    //   42: astore_3
    //   43: ldc 134
    //   45: ldc 252
    //   47: iconst_1
    //   48: anewarray 87	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_3
    //   54: aastore
    //   55: invokestatic 255	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -49 -> 11
    //   63: astore_3
    //   64: ldc 134
    //   66: ldc_w 257
    //   69: iconst_1
    //   70: anewarray 87	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_3
    //   76: aastore
    //   77: invokestatic 255	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: ldc 245
    //   82: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore 4
    //   89: ldc 134
    //   91: ldc_w 259
    //   94: iconst_1
    //   95: anewarray 87	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: getfield 27	com/tencent/mm/ui/widget/MMEditText:oow	I
    //   104: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 255	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: getfield 27	com/tencent/mm/ui/widget/MMEditText:oow	I
    //   115: iconst_3
    //   116: if_icmpge +30 -> 146
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 27	com/tencent/mm/ui/widget/MMEditText:oow	I
    //   124: iconst_1
    //   125: iadd
    //   126: putfield 27	com/tencent/mm/ui/widget/MMEditText:oow	I
    //   129: aload_0
    //   130: ldc_w 261
    //   133: aload_3
    //   134: invokestatic 264	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokevirtual 268	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokespecial 250	com/tencent/mm/ui/widget/MMEditText:aBB	(Ljava/lang/String;)V
    //   143: goto -108 -> 35
    //   146: ldc 245
    //   148: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload 4
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	MMEditText
    //   0	154	1	paramInt	int
    //   10	50	2	bool	boolean
    //   29	3	3	str	String
    //   42	12	3	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   63	71	3	localNullPointerException	java.lang.NullPointerException
    //   87	65	4	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   5	11	42	java/lang/IndexOutOfBoundsException
    //   5	11	63	java/lang/NullPointerException
    //   30	35	87	java/lang/IndexOutOfBoundsException
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
      ad.e("MicroMsg.MMEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(143356);
    }
    return false;
  }
  
  public void setBackListener(a parama)
  {
    this.Hzx = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.Hzw = paramBoolean;
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
      ad.printErrStackTrace("MicroMsg.MMEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
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