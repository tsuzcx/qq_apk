package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity$PatTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusDoWhatActivity;)V", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"})
public final class TextStatusDoWhatActivity$b
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(235609);
    Object localObject = TextStatusDoWhatActivity.a(this.MLa);
    if (localObject != null) {
      ((EditText)localObject).removeTextChangedListener((TextWatcher)TextStatusDoWhatActivity.b(this.MLa));
    }
    int i = g.a(String.valueOf(paramEditable), g.a.XSu);
    Log.i("MicroMsg.TextStatus.TextStatusDoWhatActivity", "afterTextChanged inputCount:".concat(String.valueOf(i)));
    localObject = String.valueOf(paramEditable);
    if (i > this.MLa.MKV)
    {
      String str = g.hV((String)localObject, this.MLa.MKV);
      if (paramEditable != null) {
        paramEditable.replace(str.length(), ((String)localObject).length(), (CharSequence)"");
      }
      w.w((Context)this.MLa, this.MLa.getString(b.h.settings_modify_custom_text_status_invalid_more), b.g.icons_outlined_info);
    }
    localObject = TextStatusDoWhatActivity.a(this.MLa);
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)TextStatusDoWhatActivity.b(this.MLa));
    }
    localObject = TextStatusDoWhatActivity.c(this.MLa);
    if (localObject != null)
    {
      localObject = (Button)((View)localObject).findViewById(b.e.confirm_btn);
      if (localObject != null)
      {
        if ((paramEditable == null) || (paramEditable.length() != 0)) {}
        for (boolean bool = true;; bool = false)
        {
          ((Button)localObject).setEnabled(bool);
          AppMethodBeat.o(235609);
          return;
        }
      }
    }
    AppMethodBeat.o(235609);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.b
 * JD-Core Version:    0.7.0.1
 */