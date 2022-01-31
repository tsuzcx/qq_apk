package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class s$2$1
  implements am.a
{
  s$2$1(s.2 param2) {}
  
  public final boolean tC()
  {
    s locals;
    String str;
    if (this.sdt.sds.feu != null)
    {
      locals = this.sdt.sds;
      str = this.sdt.sds.nge.getText().toString().trim();
      Context localContext = locals.context;
      locals.context.getString(a.h.app_tip);
      locals.tipDialog = h.b(localContext, locals.context.getString(a.h.sendrequest_sending), true, new s.5(locals));
      locals.content = str;
      if ((locals.sdp.size() == 1) && (ad.aaU((String)locals.sdp.getFirst()))) {
        locals.cmS();
      }
    }
    else
    {
      return false;
    }
    g.DO().dJT.a(new m(2, locals.sdp, locals.nkB, str, ""), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.2.1
 * JD-Core Version:    0.7.0.1
 */