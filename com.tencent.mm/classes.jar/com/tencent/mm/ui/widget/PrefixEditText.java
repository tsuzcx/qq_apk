package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/PrefixEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "hintSpan", "Landroid/text/SpannableString;", "isHintVisible", "", "prefixText", "", "textWatcher", "Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "dismissHint", "", "init", "text", "hint", "hintColor", "onSelectionChanged", "selStart", "selEnd", "setSelection", "index", "start", "stop", "setTextSpanWithNoTextWatcher", "setTextWithNoTextWatcher", "showHint", "Companion", "PrefixTextWatcher", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PrefixEditText
  extends MMEditText
{
  public static final a afUB;
  private String afUC = "";
  private b afUD;
  
  static
  {
    AppMethodBeat.i(251618);
    afUB = new a((byte)0);
    AppMethodBeat.o(251618);
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
    AppMethodBeat.i(251613);
    b localb = this.afUD;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramSpannableString);
      addTextChangedListener((TextWatcher)localb);
    }
    AppMethodBeat.o(251613);
  }
  
  private final void setTextWithNoTextWatcher(String paramString)
  {
    AppMethodBeat.i(251609);
    b localb = this.afUD;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramString);
      addTextChangedListener((TextWatcher)localb);
    }
    AppMethodBeat.o(251609);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251635);
    int i;
    int j;
    if (!Util.isNullOrNil(this.afUC))
    {
      i = this.afUC.length();
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
      AppMethodBeat.o(251635);
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
    AppMethodBeat.i(251622);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(251622);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(251622);
    }
  }
  
  public final void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251629);
    try
    {
      super.setSelection(paramInt1, paramInt2);
      AppMethodBeat.o(251629);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(251629);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/PrefixEditText$Companion;", "", "()V", "TAG", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "prefix", "", "(Landroid/widget/EditText;Ljava/lang/String;)V", "beforeText", "isRevert", "", "()Z", "setRevert", "(Z)V", "getPrefix", "()Ljava/lang/String;", "prefixSize", "", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "beforeTextCs", "", "start", "count", "after", "onTextChanged", "before", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      throw null;
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      throw null;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.PrefixEditText
 * JD-Core Version:    0.7.0.1
 */