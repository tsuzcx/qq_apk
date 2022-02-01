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
    AppMethodBeat.i(280438);
    SayHiWithSnsPermissionUI3.d(this.Hdf).setText(l.b(this.Hdf, Util.nullAsNil(this.remark), SayHiWithSnsPermissionUI3.d(this.Hdf).getTextSize()));
    SayHiWithSnsPermissionUI3.d(this.Hdf).setSelection(SayHiWithSnsPermissionUI3.d(this.Hdf).getText().length());
    SayHiWithSnsPermissionUI3.x(this.Hdf).setVisibility(8);
    SayHiWithSnsPermissionUI3.u(this.Hdf)[4] = 1;
    AppMethodBeat.o(280438);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(280439);
    paramTextPaint.setColor(this.Hdf.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(280439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.a
 * JD-Core Version:    0.7.0.1
 */