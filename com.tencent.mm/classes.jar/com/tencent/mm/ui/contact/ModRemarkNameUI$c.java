package com.tencent.mm.ui.contact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMClearEditText;

final class ModRemarkNameUI$c
  extends ClickableSpan
{
  public String remark;
  
  public ModRemarkNameUI$c(ModRemarkNameUI paramModRemarkNameUI, String paramString)
  {
    this.remark = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37870);
    ModRemarkNameUI.a(this.Xug).setText(l.b(this.Xug, Util.nullAsNil(this.remark), ModRemarkNameUI.a(this.Xug).getTextSize()));
    ModRemarkNameUI.a(this.Xug).setSelection(ModRemarkNameUI.a(this.Xug).getText().length());
    ModRemarkNameUI.l(this.Xug).setVisibility(8);
    AppMethodBeat.o(37870);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(37871);
    paramTextPaint.setColor(this.Xug.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(37871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.c
 * JD-Core Version:    0.7.0.1
 */