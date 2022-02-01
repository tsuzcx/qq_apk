package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/PrefixEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "hintSpan", "Landroid/text/SpannableString;", "isHintVisible", "", "prefixText", "", "textWatcher", "Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "dismissHint", "", "init", "text", "hint", "hintColor", "onSelectionChanged", "selStart", "selEnd", "setSelection", "index", "start", "stop", "setTextSpanWithNoTextWatcher", "setTextWithNoTextWatcher", "showHint", "Companion", "PrefixTextWatcher", "libmmui_release"})
public final class PrefixEditText
  extends MMEditText
{
  public static final a QEk;
  private String QEi = "";
  private b QEj;
  
  static
  {
    AppMethodBeat.i(204884);
    QEk = new a((byte)0);
    AppMethodBeat.o(204884);
  }
  
  public PrefixEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PrefixEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void setTextSpanWithNoTextWatcher(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(204880);
    b localb = this.QEj;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramSpannableString);
      addTextChangedListener((TextWatcher)localb);
      AppMethodBeat.o(204880);
      return;
    }
    AppMethodBeat.o(204880);
  }
  
  private final void setTextWithNoTextWatcher(String paramString)
  {
    AppMethodBeat.i(204879);
    b localb = this.QEj;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramString);
      addTextChangedListener((TextWatcher)localb);
      AppMethodBeat.o(204879);
      return;
    }
    AppMethodBeat.o(204879);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204883);
    int i;
    int j;
    if (!Util.isNullOrNil(this.QEi))
    {
      i = this.QEi.length();
      if (paramInt1 >= i) {
        break label115;
      }
      j = i;
      if (paramInt2 >= i) {
        break label121;
      }
    }
    for (;;)
    {
      if ((paramInt1 != j) || (paramInt2 != i))
      {
        Log.i("Finder.PrefixEditText", "onSelectionChanged : " + paramInt1 + "--" + paramInt2 + " pos:" + j + "--" + i);
        setSelection(j, i);
      }
      super.onSelectionChanged(paramInt1, paramInt2);
      AppMethodBeat.o(204883);
      return;
      label115:
      j = paramInt1;
      break;
      label121:
      i = paramInt2;
    }
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(204881);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(204881);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(204881);
    }
  }
  
  public final void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204882);
    try
    {
      super.setSelection(paramInt1, paramInt2);
      AppMethodBeat.o(204882);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(204882);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/PrefixEditText$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "prefix", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "beforeText", "isRevert", "", "()Z", "setRevert", "(Z)V", "getPrefix", "()Ljava/lang/String;", "prefixSize", "", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "beforeTextCs", "", "start", "count", "after", "onTextChanged", "before", "libmmui_release"})
  public static final class b
    implements TextWatcher
  {
    private String GeX;
    private boolean QEl;
    private int QEm;
    private final EditText vy;
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(204877);
      EditText localEditText;
      if (this.QEl)
      {
        localEditText = this.vy;
        localEditText.removeTextChangedListener((TextWatcher)this);
        paramEditable = this.GeX;
        if (paramEditable == null) {
          break label71;
        }
      }
      label71:
      for (paramEditable = (CharSequence)paramEditable;; paramEditable = (CharSequence)"")
      {
        localEditText.setText(paramEditable);
        localEditText.addTextChangedListener((TextWatcher)this);
        localEditText.setSelection(this.QEm);
        this.QEl = false;
        AppMethodBeat.o(204877);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(204878);
      String str;
      if (paramInt1 == this.QEm - 1)
      {
        if (paramInt2 > 0)
        {
          this.QEl = true;
          if (paramCharSequence != null)
          {
            str = paramCharSequence.toString();
            paramCharSequence = str;
            if (str != null) {}
          }
          else
          {
            paramCharSequence = "";
          }
          this.GeX = paramCharSequence;
          AppMethodBeat.o(204878);
        }
      }
      else if (paramInt1 < this.QEm - 1)
      {
        this.QEl = true;
        if (paramCharSequence != null)
        {
          str = paramCharSequence.toString();
          paramCharSequence = str;
          if (str != null) {}
        }
        else
        {
          paramCharSequence = "";
        }
        this.GeX = paramCharSequence;
      }
      AppMethodBeat.o(204878);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.PrefixEditText
 * JD-Core Version:    0.7.0.1
 */