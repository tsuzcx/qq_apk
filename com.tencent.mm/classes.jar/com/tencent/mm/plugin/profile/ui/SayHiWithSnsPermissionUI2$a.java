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
    SayHiWithSnsPermissionUI2.a(this.HcW).setText(l.b(this.HcW, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI2.a(this.HcW).getTextSize()));
    SayHiWithSnsPermissionUI2.a(this.HcW).setSelection(SayHiWithSnsPermissionUI2.a(this.HcW).getText().length());
    SayHiWithSnsPermissionUI2.t(this.HcW).setVisibility(8);
    SayHiWithSnsPermissionUI2.p(this.HcW)[4] = 1;
    AppMethodBeat.o(179687);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(179688);
    paramTextPaint.setColor(this.HcW.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(179688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.a
 * JD-Core Version:    0.7.0.1
 */