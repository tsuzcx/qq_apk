package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.h.c.b;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.cedit.api.c.a;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.ui.widget.edittext.a;
import com.tencent.mm.ui.widget.edittext.a.a;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;
import java.util.Set;

public class MMEditText
  extends PasterEditText
  implements c
{
  private InputConnection Ybl;
  private boolean Ybm = false;
  private a Ybn;
  private MMEditText.d Ybo;
  private a Ybp;
  int utI = 0;
  
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
  
  public static boolean hZv()
  {
    AppMethodBeat.i(207177);
    if ((MIUI.ifMIUI()) && (d.qV(28)))
    {
      AppMethodBeat.o(207177);
      return true;
    }
    AppMethodBeat.o(207177);
    return false;
  }
  
  public final void Hm(boolean paramBoolean)
  {
    AppMethodBeat.i(207185);
    if (this.Ybp != null)
    {
      if (!paramBoolean)
      {
        this.Ybp.pause();
        AppMethodBeat.o(207185);
        return;
      }
      this.Ybp.resume();
    }
    AppMethodBeat.o(207185);
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(207178);
    if (parama == null)
    {
      AppMethodBeat.o(207178);
      return;
    }
    setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(188838);
        if ((paramAnonymousTextView instanceof c))
        {
          boolean bool = parama.rQ(paramAnonymousInt);
          AppMethodBeat.o(188838);
          return bool;
        }
        AppMethodBeat.o(188838);
        return false;
      }
    });
    AppMethodBeat.o(207178);
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(207183);
    a.a locala = new a.a(this);
    if (paramList1 != null) {
      locala.Yom.addAll(paramList1);
    }
    if (paramList2 != null) {
      locala.Ygq.addAll(paramList2);
    }
    locala.EJk = paramString;
    this.Ybp = locala.icJ();
    this.Ybp.YkA = parame;
    AppMethodBeat.o(207183);
  }
  
  public final void bBa(String paramString)
  {
    AppMethodBeat.i(143355);
    getContext();
    int m = b.dv(getText().toString(), getSelectionStart());
    getContext();
    int i = b.dv(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.qV(21))
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
        Log.d("MicroMsg.MMEditText", "exceed :%s, %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        AppMethodBeat.o(143355);
        return;
      }
      setText(b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(143355);
      return;
    }
  }
  
  public void bqQ(String paramString)
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
  
  public final void destroy()
  {
    AppMethodBeat.i(207182);
    if (this.Ybp != null) {
      this.Ybp.destroy();
    }
    AppMethodBeat.o(207182);
  }
  
  public InputConnection getInputConnection()
  {
    return this.Ybl;
  }
  
  public boolean getSimilarPasteChange()
  {
    return false;
  }
  
  public final void hZA() {}
  
  public final boolean hZB()
  {
    AppMethodBeat.i(207196);
    boolean bool = requestFocus();
    AppMethodBeat.o(207196);
    return bool;
  }
  
  public final Context hZC()
  {
    AppMethodBeat.i(207197);
    Context localContext = getContext();
    AppMethodBeat.o(207197);
    return localContext;
  }
  
  public final int hZD()
  {
    AppMethodBeat.i(207198);
    int i = getWidth();
    AppMethodBeat.o(207198);
    return i;
  }
  
  public final void hZu()
  {
    AppMethodBeat.i(207171);
    if (getInputConnection() != null)
    {
      getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      AppMethodBeat.o(207171);
      return;
    }
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(207171);
  }
  
  public final void hZw()
  {
    AppMethodBeat.i(207184);
    if (this.Ybp != null) {
      this.Ybp.cpo();
    }
    AppMethodBeat.o(207184);
  }
  
  public final View hZx()
  {
    return this;
  }
  
  public final boolean hZy()
  {
    return false;
  }
  
  public final ViewParent hZz()
  {
    AppMethodBeat.i(207189);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(207189);
    return localViewParent;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(143354);
    this.Ybl = super.onCreateInputConnection(paramEditorInfo);
    if ((this.Ybl != null) && (this.Ybm))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    paramEditorInfo = this.Ybl;
    AppMethodBeat.o(143354);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143361);
    if (this.Ybn == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B keycode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((this.Ybn == null) || (paramInt != 4)) {
        break label206;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break;
      }
      Log.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
      AppMethodBeat.o(143361);
      return true;
    }
    if (paramKeyEvent.getAction() == 1)
    {
      Log.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        Log.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
        this.Ybn.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(143361);
        return true;
      }
    }
    label206:
    if ((this.Ybo != null) && (this.Ybo.aqF(paramInt)))
    {
      AppMethodBeat.o(143361);
      return true;
    }
    bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(143361);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(207181);
    if (this.Ybp != null) {
      this.Ybp.cpo();
    }
    AppMethodBeat.o(207181);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 377
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 379	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 380
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 37	com/tencent/mm/ui/widget/MMEditText:utI	I
    //   24: aload_0
    //   25: invokevirtual 135	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 141	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 382	com/tencent/mm/ui/widget/MMEditText:bqQ	(Ljava/lang/String;)V
    //   37: ldc_w 377
    //   40: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 189
    //   48: ldc_w 384
    //   51: iconst_1
    //   52: anewarray 137	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 189
    //   70: ldc_w 389
    //   73: iconst_1
    //   74: anewarray 137	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 377
    //   87: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 189
    //   96: ldc_w 391
    //   99: iconst_1
    //   100: anewarray 137	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 37	com/tencent/mm/ui/widget/MMEditText:utI	I
    //   109: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 387	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 37	com/tencent/mm/ui/widget/MMEditText:utI	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 37	com/tencent/mm/ui/widget/MMEditText:utI	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 37	com/tencent/mm/ui/widget/MMEditText:utI	I
    //   134: aload_0
    //   135: ldc_w 393
    //   138: aload_3
    //   139: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 400	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 382	com/tencent/mm/ui/widget/MMEditText:bqQ	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 377
    //   154: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(207200);
    try
    {
      boolean bool = super.performLongClick();
      AppMethodBeat.o(207200);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207200);
    }
    return false;
  }
  
  public final void refresh(boolean paramBoolean) {}
  
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
      Log.e("MicroMsg.MMEditText", "[requestFocus] error:%s", new Object[] { paramRect });
      AppMethodBeat.o(143356);
    }
    return false;
  }
  
  public void setBackListener(a parama)
  {
    this.Ybn = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.Ybm = paramBoolean;
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    this.Ybo = paramd;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(207190);
    if ((this.Ybp != null) && (paramOnClickListener != null) && (!paramOnClickListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.Ybp.YnV = paramOnClickListener;
      AppMethodBeat.o(207190);
      return;
    }
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(207190);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(207191);
    if ((this.Ybp != null) && (paramOnFocusChangeListener != null) && (!paramOnFocusChangeListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.Ybp.YnU = paramOnFocusChangeListener;
      AppMethodBeat.o(207191);
      return;
    }
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(207191);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(207193);
    if ((this.Ybp != null) && (paramOnLongClickListener != null) && (!paramOnLongClickListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.Ybp.YnS = paramOnLongClickListener;
      AppMethodBeat.o(207193);
      return;
    }
    super.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(207193);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(207192);
    if ((this.Ybp != null) && (paramOnTouchListener != null) && (!paramOnTouchListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.Ybp.YnT = paramOnTouchListener;
      AppMethodBeat.o(207192);
      return;
    }
    super.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(207192);
  }
  
  public void setPasterLen(int paramInt) {}
  
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
      Log.printErrStackTrace("MicroMsg.MMEditText", localIndexOutOfBoundsException, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(paramInt)), new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText
 * JD-Core Version:    0.7.0.1
 */