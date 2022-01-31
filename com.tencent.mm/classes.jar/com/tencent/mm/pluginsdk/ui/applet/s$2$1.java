package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class s$2$1
  implements ap.a
{
  s$2$1(s.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(79789);
    s locals;
    if (this.vUy.vUx.gwd != null)
    {
      locals = this.vUy.vUx;
      String str = this.vUy.vUx.pLt.getText().toString().trim();
      Context localContext = locals.context;
      locals.context.getString(2131297087);
      locals.tipDialog = h.b(localContext, locals.context.getString(2131303128), true, new s.5(locals));
      locals.content = str;
      if ((locals.vUs.size() != 1) || (!ad.arf((String)locals.vUs.getFirst()))) {
        break label130;
      }
      locals.dnK();
    }
    for (;;)
    {
      AppMethodBeat.o(79789);
      return false;
      label130:
      locals.dnv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.2.1
 * JD-Core Version:    0.7.0.1
 */