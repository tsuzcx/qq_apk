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

final class SayHiWithSnsPermissionUI3$a
  extends ClickableSpan
{
  public String remark;
  
  public SayHiWithSnsPermissionUI3$a(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3, String paramString)
  {
    this.remark = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(231916);
    SayHiWithSnsPermissionUI3.d(this.BiJ).setText(l.b(this.BiJ, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI3.d(this.BiJ).getTextSize()));
    SayHiWithSnsPermissionUI3.d(this.BiJ).setSelection(SayHiWithSnsPermissionUI3.d(this.BiJ).getText().length());
    SayHiWithSnsPermissionUI3.s(this.BiJ).setVisibility(8);
    SayHiWithSnsPermissionUI3.q(this.BiJ)[4] = 1;
    AppMethodBeat.o(231916);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(231917);
    paramTextPaint.setColor(this.BiJ.getResources().getColor(2131100053));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(231917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.a
 * JD-Core Version:    0.7.0.1
 */