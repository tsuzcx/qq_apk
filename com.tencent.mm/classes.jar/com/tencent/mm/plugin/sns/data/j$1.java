package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.device.appstore.d;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.pluginsdk.model.app.am;

final class j$1
  implements am
{
  j$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210257);
    if (paramBoolean1)
    {
      j.b(this.iaf, this.xNk, this.xNl, 2, "0");
      e locale = e.x(this.CxF, this.iaf, this.xNk, this.xNl);
      if (locale != null) {
        d.a(locale);
      }
      AppMethodBeat.o(210257);
      return;
    }
    j.b(this.iaf, this.xNk, this.xNl, 2, "2");
    AppMethodBeat.o(210257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j.1
 * JD-Core Version:    0.7.0.1
 */