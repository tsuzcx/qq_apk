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
import com.tencent.mm.ui.anim.content.b.a;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.cedit.api.c.a;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.ui.widget.edittext.a;
import com.tencent.mm.ui.widget.edittext.a.a;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

public class MMEditText
  extends PasterEditText
  implements c
{
  private InputConnection afTd;
  private boolean afTe = false;
  private a afTf;
  private MMEditText.d afTg;
  private a afTh;
  int xAf = 0;
  
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
  
  public static boolean jEE()
  {
    AppMethodBeat.i(251601);
    if ((MIUI.ifMIUI()) && (d.rb(28)))
    {
      AppMethodBeat.o(251601);
      return true;
    }
    AppMethodBeat.o(251601);
    return false;
  }
  
  public final void Ni(boolean paramBoolean)
  {
    AppMethodBeat.i(251699);
    if (this.afTh != null)
    {
      if (!paramBoolean)
      {
        this.afTh.pause();
        AppMethodBeat.o(251699);
        return;
      }
      this.afTh.resume();
    }
    AppMethodBeat.o(251699);
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(251669);
    if (parama == null)
    {
      AppMethodBeat.o(251669);
      return;
    }
    setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(251701);
        if ((paramAnonymousTextView instanceof c))
        {
          boolean bool = parama.rR(paramAnonymousInt);
          AppMethodBeat.o(251701);
          return bool;
        }
        AppMethodBeat.o(251701);
        return false;
      }
    });
    AppMethodBeat.o(251669);
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame)
  {
    AppMethodBeat.i(251687);
    paramList1 = new a.a(this).oq(paramList1).or(paramList2);
    paramList1.KCR = paramString;
    this.afTh = paramList1.jHV();
    this.afTh.agcz = parame;
    AppMethodBeat.o(251687);
  }
  
  public void bDt(String paramString)
  {
    AppMethodBeat.i(143355);
    getContext();
    int m = com.tencent.mm.ui.i.c.b.dW(getText().toString(), getSelectionStart());
    getContext();
    int i = com.tencent.mm.ui.i.c.b.dW(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, m) + paramString + ((StringBuffer)localObject).substring(i, ((StringBuffer)localObject).length());
    i = -1;
    int k = i;
    int j;
    if (d.rb(21))
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
      setText(com.tencent.mm.ui.i.c.b.c(getContext(), (CharSequence)localObject, getTextSize()));
      setSelection(i);
      AppMethodBeat.o(143355);
      return;
    }
  }
  
  public void bqF(String paramString)
  {
    AppMethodBeat.i(143360);
    int i = getSelectionStart();
    setText(com.tencent.mm.ui.i.c.b.c(getContext(), paramString, getTextSize()));
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
  
  public final void cRR()
  {
    AppMethodBeat.i(251693);
    if (this.afTh != null) {
      this.afTh.cRR();
    }
    AppMethodBeat.o(251693);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(251681);
    if (this.afTh != null) {
      this.afTh.destroy();
    }
    AppMethodBeat.o(251681);
  }
  
  public InputConnection getInputConnection()
  {
    return this.afTd;
  }
  
  public com.tencent.mm.ui.anim.content.b getSizeAnimController()
  {
    AppMethodBeat.i(251696);
    Object localObject = com.tencent.mm.ui.anim.content.b.adMs;
    localObject = b.a.jlA();
    AppMethodBeat.o(251696);
    return localObject;
  }
  
  public final void jED()
  {
    AppMethodBeat.i(251623);
    if (getInputConnection() != null)
    {
      getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
      getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
      AppMethodBeat.o(251623);
      return;
    }
    dispatchKeyEvent(new KeyEvent(0, 67));
    dispatchKeyEvent(new KeyEvent(1, 67));
    AppMethodBeat.o(251623);
  }
  
  public final void jEF()
  {
    AppMethodBeat.i(251690);
    if (this.afTh != null) {
      this.afTh.cRR();
    }
    AppMethodBeat.o(251690);
  }
  
  public final View jEG()
  {
    return this;
  }
  
  public final boolean jEH()
  {
    return false;
  }
  
  public final ViewParent jEI()
  {
    AppMethodBeat.i(251705);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(251705);
    return localViewParent;
  }
  
  public final boolean jEJ()
  {
    AppMethodBeat.i(251715);
    boolean bool = requestFocus();
    AppMethodBeat.o(251715);
    return bool;
  }
  
  public final Context jEK()
  {
    AppMethodBeat.i(251716);
    Context localContext = getContext();
    AppMethodBeat.o(251716);
    return localContext;
  }
  
  public final int jEL()
  {
    AppMethodBeat.i(251718);
    int i = getWidth();
    AppMethodBeat.o(251718);
    return i;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(143354);
    this.afTd = super.onCreateInputConnection(paramEditorInfo);
    if ((this.afTd != null) && (this.afTe))
    {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      paramEditorInfo.inputType &= 0xFFFDFFFF;
    }
    paramEditorInfo = this.afTd;
    AppMethodBeat.o(143354);
    return paramEditorInfo;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143361);
    if (this.afTf == null) {}
    KeyEvent.DispatcherState localDispatcherState;
    for (boolean bool = true;; bool = false)
    {
      Log.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B keycode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((this.afTf == null) || (paramInt != 4)) {
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
        this.afTf.onBack();
        paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
        if (paramKeyEvent != null) {
          paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        AppMethodBeat.o(143361);
        return true;
      }
    }
    label206:
    if ((this.afTg != null) && (this.afTg.awK(paramInt)))
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
    AppMethodBeat.i(251677);
    if (this.afTh != null) {
      this.afTh.cRR();
    }
    AppMethodBeat.o(251677);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 386	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   11: istore_2
    //   12: iload_1
    //   13: ldc_w 387
    //   16: if_icmpne +21 -> 37
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 37	com/tencent/mm/ui/widget/MMEditText:xAf	I
    //   24: aload_0
    //   25: invokevirtual 129	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   28: invokevirtual 135	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 389	com/tencent/mm/ui/widget/MMEditText:bqF	(Ljava/lang/String;)V
    //   37: ldc_w 384
    //   40: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: astore_3
    //   46: ldc 183
    //   48: ldc_w 391
    //   51: iconst_1
    //   52: anewarray 131	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: aastore
    //   59: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -52 -> 12
    //   67: astore_3
    //   68: ldc 183
    //   70: ldc_w 396
    //   73: iconst_1
    //   74: anewarray 131	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_3
    //   80: aastore
    //   81: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc_w 384
    //   87: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore 4
    //   94: ldc 183
    //   96: ldc_w 398
    //   99: iconst_1
    //   100: anewarray 131	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_0
    //   106: getfield 37	com/tencent/mm/ui/widget/MMEditText:xAf	I
    //   109: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: getfield 37	com/tencent/mm/ui/widget/MMEditText:xAf	I
    //   120: iconst_3
    //   121: if_icmpge +30 -> 151
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 37	com/tencent/mm/ui/widget/MMEditText:xAf	I
    //   129: iconst_1
    //   130: iadd
    //   131: putfield 37	com/tencent/mm/ui/widget/MMEditText:xAf	I
    //   134: aload_0
    //   135: ldc_w 400
    //   138: aload_3
    //   139: invokestatic 403	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 389	com/tencent/mm/ui/widget/MMEditText:bqF	(Ljava/lang/String;)V
    //   148: goto -111 -> 37
    //   151: ldc_w 384
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
    AppMethodBeat.i(251719);
    try
    {
      boolean bool = super.performLongClick();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(251719);
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
    this.afTf = parama;
  }
  
  public void setEnableSendBtn(boolean paramBoolean)
  {
    this.afTe = paramBoolean;
  }
  
  public void setKeyCodeEnterListener(MMEditText.d paramd)
  {
    this.afTg = paramd;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251707);
    if ((this.afTh != null) && (paramOnClickListener != null) && (!paramOnClickListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.afTh.aggh = paramOnClickListener;
      AppMethodBeat.o(251707);
      return;
    }
    super.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251707);
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(251710);
    if ((this.afTh != null) && (paramOnFocusChangeListener != null) && (!paramOnFocusChangeListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.afTh.aggg = paramOnFocusChangeListener;
      AppMethodBeat.o(251710);
      return;
    }
    super.setOnFocusChangeListener(paramOnFocusChangeListener);
    AppMethodBeat.o(251710);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(251714);
    if ((this.afTh != null) && (paramOnLongClickListener != null) && (!paramOnLongClickListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.afTh.agge = paramOnLongClickListener;
      AppMethodBeat.o(251714);
      return;
    }
    super.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(251714);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(251713);
    if ((this.afTh != null) && (paramOnTouchListener != null) && (!paramOnTouchListener.getClass().getName().contains("SelectableEditTextHelper")))
    {
      this.afTh.aggf = paramOnTouchListener;
      AppMethodBeat.o(251713);
      return;
    }
    super.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(251713);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText
 * JD-Core Version:    0.7.0.1
 */