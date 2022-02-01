package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.pluginsdk.model.app.am;

final class j$3$1
  implements am
{
  j$3$1(j.3 param3) {}
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210255);
    if (paramBoolean1) {
      h.a(this.CxE.iaf, this.CxE.val$appId, 1, 2, this.CxE.xNk, this.CxE.xNl, this.CxE.CqH);
    }
    if (!paramBoolean1) {
      al.gh(this.CxE.val$context);
    }
    AppMethodBeat.o(210255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.j.3.1
 * JD-Core Version:    0.7.0.1
 */