package com.tencent.mm.plugin.profile.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

final class k$2
  implements i
{
  k$2(k paramk, com.tencent.mm.ui.base.q paramq) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(231868);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, errType: %d, errCode: %d, errMsg: %s, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.p))
    {
      g.azz().b(30, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label126;
      }
      Log.w("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, fail");
      if ((4 == paramInt1) && (-24 == paramInt2) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(MMApplicationContext.getContext(), paramString, 1).show();
      }
    }
    label126:
    Object localObject;
    for (;;)
    {
      this.qDi.dismiss();
      this.BfC.eEy();
      AppMethodBeat.o(231868);
      return;
      localObject = ((com.tencent.mm.pluginsdk.model.p)paramq).gmD();
      Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, respUsername: ".concat(String.valueOf(localObject)));
      paramq = ((l)g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
      if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
        break;
      }
      Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, contact: %s, respUsername: %s", new Object[] { paramq, localObject });
      paramString = ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).fJ(paramq.field_username);
      if (paramString != null) {
        ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).a(paramString);
      }
      g.aAh().azQ().set(327825, Boolean.TRUE);
    }
    if (ab.IR(paramq.field_username))
    {
      String str = Util.nullAsNil(paramq.field_username);
      paramString = ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).fJ(str);
      if (paramString == null) {
        paramString.field_username = ((String)localObject);
      }
      ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).fK(str);
      paramq.BK(str);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject);
      if ((int)paramq.gMZ == 0) {
        ((l)g.af(l.class)).aSN().aq(paramq);
      }
      if ((int)paramq.gMZ <= 0)
      {
        Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, insert contact fail");
        break;
      }
      ab.B(paramq);
      localObject = ((l)g.af(l.class)).aSN().Kn(paramq.field_username);
      if (paramString != null)
      {
        ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).b(paramString);
        break;
      }
      paramString = ((com.tencent.mm.api.p)g.af(com.tencent.mm.api.p.class)).fJ(((ax)localObject).field_username);
      if ((paramString == null) || (paramString.Uz()))
      {
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, shouldUpdate");
        ay.a.iDq.aL(((ax)localObject).field_username, "");
        com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
        break;
      }
      if (!((as)localObject).gBQ()) {
        break;
      }
      Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, last check time:" + ((ax)localObject).fuP);
      ay.a.iDq.aL(((ax)localObject).field_username, "");
      com.tencent.mm.aj.c.Mf(((ax)localObject).field_username);
      break;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.2
 * JD-Core Version:    0.7.0.1
 */