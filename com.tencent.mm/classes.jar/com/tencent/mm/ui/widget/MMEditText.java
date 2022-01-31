package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText
  extends PasterEditText
{
  private InputConnection ACR;
  private a ACS;
  int vzq = 0;
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void alZ(String paramString)
  {
    AppMethodBeat.i(107882);
    int i = getSelectionStart();
    setText(b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(107882);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(107882);
  }
  
  public final void avk(String paramString)
  {
    AppMethodBeat.i(107877);
    getContext();
    int m = b.bW(getText().toString(), getSelectionStart());
    getContext();
    int i = b.bW(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.fv(21))
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
        ab.d("MicroMsg.MMEditText", "exceed :%s, %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        AppMethodBeat.o(107877);
        return;
      }
      setText(b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(107877);
      return;
    }
  }
  
  public InputConnection getInputConnection()
  {
    return this.ACR;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(107876);
    this.ACR = super.onCreateInputConnection(paramEditorInfo);
    paramEditorInfo = this.ACR;
    AppMethodBeat.o(107876);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107883);
    if (this.ACS == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      ab.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.ACS == null) || (paramInt != 4)) {
        break label191;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      ab.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      AppMethodBeat.o(107883);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      ab.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        ab.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
        this.ACS.bNU();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(107883);
        return true;
      }
    }
    label191:
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(107883);
    return bool;
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc 233
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iload_1
    //   7: invokespecial 235	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   10: istore_2
    //   11: iload_1
    //   12: ldc 236
    //   14: if_icmpne +21 -> 35
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 25	com/tencent/mm/ui/widget/MMEditText:vzq	I
    //   22: aload_0
    //   23: invokevirtual 63	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   26: invokevirtual 85	java/lang/Object:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: invokespecial 238	com/tencent/mm/ui/widget/MMEditText:alZ	(Ljava/lang/String;)V
    //   35: ldc 233
    //   37: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload_2
    //   41: ireturn
    //   42: astore_3
    //   43: ldc 128
    //   45: ldc 240
    //   47: iconst_1
    //   48: anewarray 81	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_3
    //   54: aastore
    //   55: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -49 -> 11
    //   63: astore_3
    //   64: ldc 128
    //   66: ldc 245
    //   68: iconst_1
    //   69: anewarray 81	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_3
    //   75: aastore
    //   76: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: ldc 233
    //   81: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_0
    //   85: ireturn
    //   86: astore 4
    //   88: ldc 128
    //   90: ldc 247
    //   92: iconst_1
    //   93: anewarray 81	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: getfield 25	com/tencent/mm/ui/widget/MMEditText:vzq	I
    //   102: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 25	com/tencent/mm/ui/widget/MMEditText:vzq	I
    //   113: iconst_3
    //   114: if_icmpge +29 -> 143
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 25	com/tencent/mm/ui/widget/MMEditText:vzq	I
    //   122: iconst_1
    //   123: iadd
    //   124: putfield 25	com/tencent/mm/ui/widget/MMEditText:vzq	I
    //   127: aload_0
    //   128: ldc 249
    //   130: aload_3
    //   131: invokestatic 252	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   134: invokevirtual 256	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokespecial 238	com/tencent/mm/ui/widget/MMEditText:alZ	(Ljava/lang/String;)V
    //   140: goto -105 -> 35
    //   143: ldc 233
    //   145: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload 4
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	MMEditText
    //   0	151	1	paramInt	int
    //   10	50	2	bool	boolean
    //   29	3	3	str	String
    //   42	12	3	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   63	68	3	localNullPointerException	java.lang.NullPointerException
    //   86	63	4	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   5	11	42	java/lang/IndexOutOfBoundsException
    //   5	11	63	java/lang/NullPointerException
    //   30	35	86	java/lang/IndexOutOfBoundsException
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(107878);
    try
    {
      boolean bool = super.requestFocus(paramInt, paramRect);
      AppMethodBeat.o(107878);
      return bool;
    }
    catch (IllegalStateException paramRect)
    {
      ab.e("MicroMsg.MMEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(107878);
    }
    return false;
  }
  
  public void setBackListener(a parama)
  {
    this.ACS = parama;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(107879);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(107879);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ab.printErrStackTrace("MicroMsg.MMEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
      AppMethodBeat.o(107879);
    }
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107880);
    super.setSelection(paramInt1, paramInt2);
    AppMethodBeat.o(107880);
  }
  
  public static abstract interface a
  {
    public abstract void bNU();
  }
  
  public static abstract interface b
  {
    public abstract void are();
  }
  
  public static final class c
    implements TextWatcher
  {
    private TextView ACT;
    public MMEditText.b ACU = null;
    private boolean ACV = false;
    private final int limit;
    private EditText pLt;
    
    public c(EditText paramEditText, TextView paramTextView, int paramInt)
    {
      this.pLt = paramEditText;
      this.ACT = paramTextView;
      this.limit = paramInt;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int m = 0;
      AppMethodBeat.i(107874);
      String str = paramEditable.toString();
      paramEditable = "";
      int j = 0;
      int i = 0;
      int k = i;
      if (j < str.length())
      {
        if (bo.B(str.charAt(j))) {
          i += 2;
        }
        for (;;)
        {
          k = i;
          if (i > this.limit) {
            break label98;
          }
          paramEditable = paramEditable + str.charAt(j);
          j += 1;
          break;
          i += 1;
        }
      }
      label98:
      if (k > this.limit) {}
      for (;;)
      {
        try
        {
          this.pLt.setText(paramEditable);
          if (this.ACV) {
            continue;
          }
          i = this.pLt.getText().toString().length();
          this.pLt.setSelection(i);
          this.ACV = false;
        }
        catch (Exception localException)
        {
          this.ACV = true;
          ab.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(localException.getMessage())));
          this.pLt.setText(paramEditable);
          this.pLt.setSelection(0);
          continue;
          continue;
        }
        i = this.limit - k;
        if (i >= 0) {
          continue;
        }
        i = m;
        if (this.ACT != null) {
          this.ACT.setText(i / 2);
        }
        AppMethodBeat.o(107874);
        return;
        this.pLt.setSelection(0);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(107875);
      if (this.ACU != null) {
        this.ACU.are();
      }
      AppMethodBeat.o(107875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText
 * JD-Core Version:    0.7.0.1
 */