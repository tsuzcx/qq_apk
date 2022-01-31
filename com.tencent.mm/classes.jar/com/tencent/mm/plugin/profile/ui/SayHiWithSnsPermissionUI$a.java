package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;

final class SayHiWithSnsPermissionUI$a
  extends ClickableSpan
{
  public String hKa;
  
  public SayHiWithSnsPermissionUI$a(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI, String paramString)
  {
    this.hKa = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23777);
    SayHiWithSnsPermissionUI.b(this.pCR).setText(j.b(this.pCR, bo.nullAsNil(this.hKa), SayHiWithSnsPermissionUI.b(this.pCR).getTextSize()));
    SayHiWithSnsPermissionUI.b(this.pCR).setSelection(SayHiWithSnsPermissionUI.b(this.pCR).getText().length());
    SayHiWithSnsPermissionUI.m(this.pCR).setVisibility(8);
    SayHiWithSnsPermissionUI.l(this.pCR)[4] = 1;
    AppMethodBeat.o(23777);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(23778);
    paramTextPaint.setColor(this.pCR.getResources().getColor(2131689771));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(23778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.a
 * JD-Core Version:    0.7.0.1
 */