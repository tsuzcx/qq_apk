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

final class SayHiWithSnsPermissionUI2$a
  extends ClickableSpan
{
  public String remark;
  
  public SayHiWithSnsPermissionUI2$a(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2, String paramString)
  {
    this.remark = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179687);
    SayHiWithSnsPermissionUI2.a(this.BiF).setText(l.b(this.BiF, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI2.a(this.BiF).getTextSize()));
    SayHiWithSnsPermissionUI2.a(this.BiF).setSelection(SayHiWithSnsPermissionUI2.a(this.BiF).getText().length());
    SayHiWithSnsPermissionUI2.p(this.BiF).setVisibility(8);
    SayHiWithSnsPermissionUI2.m(this.BiF)[4] = 1;
    AppMethodBeat.o(179687);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(179688);
    paramTextPaint.setColor(this.BiF.getResources().getColor(2131100053));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(179688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.a
 * JD-Core Version:    0.7.0.1
 */