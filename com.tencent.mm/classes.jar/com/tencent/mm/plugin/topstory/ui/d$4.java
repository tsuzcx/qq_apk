package com.tencent.mm.plugin.topstory.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class d$4
  implements f
{
  d$4(com.tencent.mm.plugin.topstory.a.c.d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1531);
    g.Rc().b(this.tfI.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.TopStory.TopStoryUILogic", "goUserProfile failed, NetSceneTopStoryGetUsername errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(1531);
      return;
    }
    paramString = ((arm)((com.tencent.mm.plugin.topstory.a.c.d)paramm).rr.fsW.fta).username;
    paramm = new Intent();
    paramm.putExtra("Contact_User", paramString);
    paramm.putExtra("Contact_Scene", 3);
    if ((paramString != null) && (paramString.length() > 0)) {
      com.tencent.mm.bq.d.b(ah.getContext(), "profile", ".ui.ContactInfoUI", paramm);
    }
    AppMethodBeat.o(1531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d.4
 * JD-Core Version:    0.7.0.1
 */