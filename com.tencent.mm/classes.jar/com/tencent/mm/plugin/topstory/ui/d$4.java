package com.tencent.mm.plugin.topstory.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class d$4
  implements com.tencent.mm.ak.g
{
  d$4(com.tencent.mm.plugin.topstory.a.c.d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125868);
    com.tencent.mm.kernel.g.agi().b(this.tWo.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(125868);
      return;
    }
    paramString = ((com.tencent.mm.plugin.topstory.a.c.d)paramn).ecF().username;
    paramn = new Intent();
    paramn.putExtra("Contact_User", paramString);
    paramn.putExtra("Contact_Scene", 3);
    if ((paramString != null) && (paramString.length() > 0)) {
      com.tencent.mm.br.d.b(ai.getContext(), "profile", ".ui.ContactInfoUI", paramn);
    }
    AppMethodBeat.o(125868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.4
 * JD-Core Version:    0.7.0.1
 */