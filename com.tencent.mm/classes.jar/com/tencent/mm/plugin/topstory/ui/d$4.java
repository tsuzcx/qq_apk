package com.tencent.mm.plugin.topstory.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

final class d$4
  implements f
{
  d$4(com.tencent.mm.plugin.topstory.a.c.d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125868);
    g.ajj().b(this.vkU.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(125868);
      return;
    }
    paramString = ((com.tencent.mm.plugin.topstory.a.c.d)paramn).esD().username;
    paramn = new Intent();
    paramn.putExtra("Contact_User", paramString);
    paramn.putExtra("Contact_Scene", 3);
    if ((paramString != null) && (paramString.length() > 0)) {
      com.tencent.mm.br.d.b(ak.getContext(), "profile", ".ui.ContactInfoUI", paramn);
    }
    AppMethodBeat.o(125868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.4
 * JD-Core Version:    0.7.0.1
 */