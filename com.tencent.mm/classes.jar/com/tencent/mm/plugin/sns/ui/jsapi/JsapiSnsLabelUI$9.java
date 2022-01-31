package com.tencent.mm.plugin.sns.ui.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.ui.base.h;

final class JsapiSnsLabelUI$9
  implements DialogInterface.OnClickListener
{
  JsapiSnsLabelUI$9(JsapiSnsLabelUI paramJsapiSnsLabelUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40180);
    JsapiSnsLabelUI.i(this.sjc);
    a.bKV().cc(JsapiSnsLabelUI.b(this.sjc));
    JsapiSnsLabelUI.a(this.sjc, h.b(this.sjc, this.sjc.getString(2131303858), false, null));
    AppMethodBeat.o(40180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.9
 * JD-Core Version:    0.7.0.1
 */