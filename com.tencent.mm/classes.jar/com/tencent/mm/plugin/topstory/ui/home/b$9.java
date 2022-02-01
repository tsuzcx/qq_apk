package com.tencent.mm.plugin.topstory.ui.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.ui.tools.l;

final class b$9
  implements DialogInterface.OnClickListener
{
  b$9(b paramb, Bundle paramBundle, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125939);
    e.ygI.f(17080, new Object[] { Integer.valueOf(43), Integer.valueOf(1) });
    paramDialogInterface = new WXOpenBusinessView.Resp(this.BsT);
    l.a(this.BsT, paramDialogInterface, this.cCk);
    AppMethodBeat.o(125939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.9
 * JD-Core Version:    0.7.0.1
 */