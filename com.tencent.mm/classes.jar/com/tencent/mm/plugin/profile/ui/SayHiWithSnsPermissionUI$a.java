package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    SayHiWithSnsPermissionUI.a(this.Biw).setText(l.b(this.Biw, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI.a(this.Biw).getTextSize()));
    SayHiWithSnsPermissionUI.a(this.Biw).setSelection(SayHiWithSnsPermissionUI.a(this.Biw).getText().length());
    SayHiWithSnsPermissionUI.p(this.Biw).setVisibility(8);
    SayHiWithSnsPermissionUI.m(this.Biw)[4] = 1;
    AppMethodBeat.o(27405);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(27406);
    paramTextPaint.setColor(this.Biw.getResources().getColor(2131100053));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(27406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.a
 * JD-Core Version:    0.7.0.1
 */