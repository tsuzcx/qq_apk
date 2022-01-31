package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText
  extends PasterEditText
{
  int rIK = 0;
  private InputConnection wjk;
  private a wjl;
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Wu(String paramString)
  {
    int i = getSelectionStart();
    setText(b.d(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
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
  
  public final void aex(String paramString)
  {
    getContext();
    int i = b.bs(getText().toString(), getSelectionStart());
    getContext();
    int j = b.bs(getText().toString(), getSelectionEnd());
    Object localObject = new StringBuffer(getText());
    localObject = ((StringBuffer)localObject).substring(0, i) + paramString + ((StringBuffer)localObject).substring(j, ((StringBuffer)localObject).length());
    setText(b.d(getContext(), (CharSequence)localObject, getTextSize()));
    setSelection(i + paramString.length());
  }
  
  public InputConnection getInputConnection()
  {
    return this.wjk;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    this.wjk = super.onCreateInputConnection(paramEditorInfo);
    return this.wjk;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    KeyEvent.DispatcherState localDispatcherState;
    if (this.wjl == null)
    {
      bool = true;
      y.v("MicroMsg.MMEditText", "on onKeyPreIme, listener null ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.wjl == null) || (paramInt != 4)) {
        break label176;
      }
      if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
        break label85;
      }
      y.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.startTracking(paramKeyEvent, this);
      }
    }
    label85:
    do
    {
      return true;
      bool = false;
      break;
      if (paramKeyEvent.getAction() != 1) {
        break label176;
      }
      y.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
      localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null) {
        localDispatcherState.handleUpEvent(paramKeyEvent);
      }
      if ((!paramKeyEvent.isTracking()) || (paramKeyEvent.isCanceled())) {
        break label176;
      }
      y.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
      this.wjl.bgg();
      paramKeyEvent = (InputMethodManager)getContext().getSystemService("input_method");
    } while (paramKeyEvent == null);
    paramKeyEvent.hideSoftInputFromWindow(getWindowToken(), 0);
    return true;
    label176:
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 199	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   5: istore_2
    //   6: iload_1
    //   7: ldc 200
    //   9: if_icmpne +21 -> 30
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 25	com/tencent/mm/ui/widget/MMEditText:rIK	I
    //   17: aload_0
    //   18: invokevirtual 57	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   21: invokevirtual 76	java/lang/Object:toString	()Ljava/lang/String;
    //   24: astore_3
    //   25: aload_0
    //   26: aload_3
    //   27: invokespecial 202	com/tencent/mm/ui/widget/MMEditText:Wu	(Ljava/lang/String;)V
    //   30: iload_2
    //   31: ireturn
    //   32: astore_3
    //   33: ldc 116
    //   35: ldc 204
    //   37: iconst_1
    //   38: anewarray 72	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_3
    //   44: aastore
    //   45: invokestatic 207	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: iconst_0
    //   49: istore_2
    //   50: goto -44 -> 6
    //   53: astore_3
    //   54: ldc 116
    //   56: ldc 209
    //   58: iconst_1
    //   59: anewarray 72	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: aastore
    //   66: invokestatic 207	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore 4
    //   73: ldc 116
    //   75: ldc 211
    //   77: iconst_1
    //   78: anewarray 72	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: getfield 25	com/tencent/mm/ui/widget/MMEditText:rIK	I
    //   87: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 207	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: getfield 25	com/tencent/mm/ui/widget/MMEditText:rIK	I
    //   98: iconst_3
    //   99: if_icmpge +36 -> 135
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 25	com/tencent/mm/ui/widget/MMEditText:rIK	I
    //   107: iconst_1
    //   108: iadd
    //   109: putfield 25	com/tencent/mm/ui/widget/MMEditText:rIK	I
    //   112: aload_0
    //   113: new 89	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 218
    //   119: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_3
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 202	com/tencent/mm/ui/widget/MMEditText:Wu	(Ljava/lang/String;)V
    //   132: goto -102 -> 30
    //   135: aload 4
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	MMEditText
    //   0	138	1	paramInt	int
    //   5	45	2	bool	boolean
    //   24	3	3	str	String
    //   32	12	3	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   53	70	3	localNullPointerException	java.lang.NullPointerException
    //   71	65	4	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   0	6	32	java/lang/IndexOutOfBoundsException
    //   0	6	53	java/lang/NullPointerException
    //   25	30	71	java/lang/IndexOutOfBoundsException
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setBackListener(a parama)
  {
    this.wjl = parama;
  }
  
  public void setSelection(int paramInt)
  {
    super.setSelection(paramInt);
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    super.setSelection(paramInt1, paramInt2);
  }
  
  public static abstract interface a
  {
    public abstract void bgg();
  }
  
  public static abstract interface b
  {
    public abstract void XC();
  }
  
  public static final class c
    implements TextWatcher
  {
    private final int limit;
    private EditText nge;
    private TextView wjm;
    public MMEditText.b wjn = null;
    private boolean wjo = false;
    
    public c(EditText paramEditText, TextView paramTextView, int paramInt)
    {
      this.nge = paramEditText;
      this.wjm = paramTextView;
      this.limit = paramInt;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int m = 0;
      String str1 = paramEditable.toString();
      paramEditable = "";
      int j = 0;
      int i = 0;
      int k = i;
      if (j < str1.length())
      {
        if (bk.l(str1.charAt(j))) {
          i += 2;
        }
        for (;;)
        {
          k = i;
          if (i > this.limit) {
            break label93;
          }
          paramEditable = paramEditable + str1.charAt(j);
          j += 1;
          break;
          i += 1;
        }
      }
      label93:
      if (k > this.limit) {}
      for (;;)
      {
        try
        {
          this.nge.setText(paramEditable);
          if (this.wjo) {
            continue;
          }
          i = this.nge.getText().toString().length();
          this.nge.setSelection(i);
          this.wjo = false;
        }
        catch (Exception localException)
        {
          this.wjo = true;
          String str2 = localException.getMessage();
          y.e("MicroMsg.MMEditText", "error " + str2);
          this.nge.setText(paramEditable);
          this.nge.setSelection(0);
          continue;
          continue;
        }
        i = this.limit - k;
        if (i >= 0) {
          continue;
        }
        i = m;
        if (this.wjm != null) {
          this.wjm.setText(i / 2);
        }
        return;
        this.nge.setSelection(0);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.wjn != null) {
        this.wjn.XC();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMEditText
 * JD-Core Version:    0.7.0.1
 */