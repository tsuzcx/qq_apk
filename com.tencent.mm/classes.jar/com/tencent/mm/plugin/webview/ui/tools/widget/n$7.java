package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$7", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-webview_release"})
public final class n$7
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82698);
    paramCharSequence = n.l(this.CNx);
    Editable localEditable = n.b(this.CNx).getText();
    k.g(localEditable, "contentEt.text");
    if (((CharSequence)localEditable).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramCharSequence.setEnabled(bool);
      AppMethodBeat.o(82698);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.7
 * JD-Core Version:    0.7.0.1
 */