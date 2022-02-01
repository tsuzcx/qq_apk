package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/PrefixEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "hintSpan", "Landroid/text/SpannableString;", "isHintVisible", "", "prefixText", "", "textWatcher", "Lcom/tencent/mm/ui/widget/PrefixEditText$PrefixTextWatcher;", "dismissHint", "", "init", "text", "hint", "hintColor", "onSelectionChanged", "selStart", "selEnd", "setSelection", "index", "start", "stop", "setTextSpanWithNoTextWatcher", "setTextWithNoTextWatcher", "showHint", "Companion", "PrefixTextWatcher", "libmmui_release"})
public final class PrefixEditText
  extends MMEditText
{
  public static final a YcN;
  private String YcL = "";
  private PrefixEditText.b YcM;
  
  static
  {
    AppMethodBeat.i(196674);
    YcN = new a((byte)0);
    AppMethodBeat.o(196674);
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
    AppMethodBeat.i(196669);
    PrefixEditText.b localb = this.YcM;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramSpannableString);
      addTextChangedListener((TextWatcher)localb);
      AppMethodBeat.o(196669);
      return;
    }
    AppMethodBeat.o(196669);
  }
  
  private final void setTextWithNoTextWatcher(String paramString)
  {
    AppMethodBeat.i(196668);
    PrefixEditText.b localb = this.YcM;
    if (localb != null)
    {
      removeTextChangedListener((TextWatcher)localb);
      setText((CharSequence)paramString);
      addTextChangedListener((TextWatcher)localb);
      AppMethodBeat.o(196668);
      return;
    }
    AppMethodBeat.o(196668);
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196673);
    int i;
    int j;
    if (!Util.isNullOrNil(this.YcL))
    {
      i = this.YcL.length();
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
      AppMethodBeat.o(196673);
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
    AppMethodBeat.i(196670);
    try
    {
      super.setSelection(paramInt);
      AppMethodBeat.o(196670);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(196670);
    }
  }
  
  public final void setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196671);
    try
    {
      super.setSelection(paramInt1, paramInt2);
      AppMethodBeat.o(196671);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(196671);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/PrefixEditText$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.PrefixEditText
 * JD-Core Version:    0.7.0.1
 */