package com.tencent.mm.plugin.topstory.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.d;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c$4
  implements i
{
  c$4(d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125868);
    g.azz().b(this.yEv.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(125868);
      return;
    }
    paramString = ((d)paramq).fyb().username;
    paramq = new Intent();
    paramq.putExtra("Contact_User", paramString);
    paramq.putExtra("Contact_Scene", 3);
    if ((paramString != null) && (paramString.length() > 0)) {
      c.b(MMApplicationContext.getContext(), "profile", ".ui.ContactInfoUI", paramq);
    }
    AppMethodBeat.o(125868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.4
 * JD-Core Version:    0.7.0.1
 */