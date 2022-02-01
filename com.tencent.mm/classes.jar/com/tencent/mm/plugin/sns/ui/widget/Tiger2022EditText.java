package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.i.c.b;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022EditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "insetText", "", "text", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Tiger2022EditText
  extends MMEditText
{
  public Tiger2022EditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(369961);
    AppMethodBeat.o(369961);
  }
  
  public final void bDt(String paramString)
  {
    AppMethodBeat.i(369962);
    paramString = b.c(getContext(), (CharSequence)paramString, getTextSize());
    Editable localEditable = getEditableText();
    if (localEditable != null)
    {
      localEditable.insert(getSelectionStart(), paramString);
      AppMethodBeat.o(369962);
      return;
    }
    setText(paramString);
    AppMethodBeat.o(369962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.Tiger2022EditText
 * JD-Core Version:    0.7.0.1
 */