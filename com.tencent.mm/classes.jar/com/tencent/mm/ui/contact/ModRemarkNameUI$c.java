package com.tencent.mm.ui.contact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;

final class ModRemarkNameUI$c
  extends ClickableSpan
{
  public String hKa;
  
  public ModRemarkNameUI$c(ModRemarkNameUI paramModRemarkNameUI, String paramString)
  {
    this.hKa = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33750);
    ModRemarkNameUI.a(this.Aeo).setText(j.b(this.Aeo, ah.nullAsNil(this.hKa), ModRemarkNameUI.a(this.Aeo).getTextSize()));
    ModRemarkNameUI.a(this.Aeo).setSelection(ModRemarkNameUI.a(this.Aeo).getText().length());
    ModRemarkNameUI.l(this.Aeo).setVisibility(8);
    AppMethodBeat.o(33750);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(33751);
    paramTextPaint.setColor(this.Aeo.getResources().getColor(2131689771));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(33751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.c
 * JD-Core Version:    0.7.0.1
 */