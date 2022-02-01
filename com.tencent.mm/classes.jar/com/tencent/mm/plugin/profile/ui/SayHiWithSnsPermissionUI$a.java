package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

final class SayHiWithSnsPermissionUI$a
  extends ClickableSpan
{
  public String remark;
  
  public SayHiWithSnsPermissionUI$a(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI, String paramString)
  {
    this.remark = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27405);
    SayHiWithSnsPermissionUI.a(this.HcH).setText(l.b(this.HcH, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI.a(this.HcH).getTextSize()));
    SayHiWithSnsPermissionUI.a(this.HcH).setSelection(SayHiWithSnsPermissionUI.a(this.HcH).getText().length());
    SayHiWithSnsPermissionUI.s(this.HcH).setVisibility(8);
    SayHiWithSnsPermissionUI.o(this.HcH)[4] = 1;
    AppMethodBeat.o(27405);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(27406);
    paramTextPaint.setColor(this.HcH.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(27406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.a
 * JD-Core Version:    0.7.0.1
 */