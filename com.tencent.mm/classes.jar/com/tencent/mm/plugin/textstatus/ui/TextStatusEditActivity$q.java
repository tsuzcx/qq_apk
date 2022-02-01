package com.tencent.mm.plugin.textstatus.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$13", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"})
public final class TextStatusEditActivity$q
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(258450);
    Object localObject1 = this.GeQ.fwu();
    Object localObject2 = this.GeQ.fwr().getText();
    p.g(localObject2, "etDesc.text");
    boolean bool;
    if (!n.aL((CharSequence)localObject2)) {
      bool = true;
    }
    for (;;)
    {
      ((View)localObject1).setEnabled(bool);
      if (this.GeQ.fwu().isEnabled())
      {
        TextStatusEditActivity.b(this.GeQ).setVisibility(8);
        localObject1 = String.valueOf(paramEditable);
        if (f.a((String)localObject1, f.a.Qui) > 64)
        {
          localObject2 = f.hm((String)localObject1, 64);
          if (paramEditable == null) {}
        }
      }
      try
      {
        paramEditable.replace(((String)localObject2).length(), ((String)localObject1).length(), (CharSequence)"");
        this.GeQ.dv(null);
        AppMethodBeat.o(258450);
        return;
        bool = false;
        continue;
        TextStatusEditActivity.b(this.GeQ).setVisibility(0);
      }
      catch (Exception paramEditable)
      {
        for (;;)
        {
          Log.e("MicroMsg.TxtStatus.TextStatusEditActivity", "etDesc replace: " + paramEditable.getMessage());
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.q
 * JD-Core Version:    0.7.0.1
 */