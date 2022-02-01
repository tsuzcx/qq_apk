package com.tencent.mm.plugin.profile.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.api.c;
import com.tencent.mm.api.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;

final class k$2
  implements i
{
  k$2(k paramk, s params) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(251938);
    Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, errType: %d, errCode: %d, errMsg: %s, scene: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      h.aGY().b(30, this);
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
      this.ucj.dismiss();
      this.GZA.fqq();
      AppMethodBeat.o(251938);
      return;
      localObject = ((com.tencent.mm.pluginsdk.model.t)paramq).hhc();
      Log.i("MicroMsg.ContactWidgetMiniShopHelper", "onSceneEnd, respUsername: ".concat(String.valueOf(localObject)));
      paramq = ((n)h.ae(n.class)).bbL().RG("gh_579db1f2cf89");
      if ((paramq != null) && (!Util.isNullOrNil((String)localObject))) {
        break;
      }
      Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, contact: %s, respUsername: %s", new Object[] { paramq, localObject });
      paramString = ((p)h.ae(p.class)).gu(paramq.field_username);
      if (paramString != null) {
        ((p)h.ae(p.class)).a(paramString);
      }
      h.aHG().aHp().i(327825, Boolean.TRUE);
    }
    if (ab.Qk(paramq.field_username))
    {
      String str = Util.nullAsNil(paramq.field_username);
      paramString = ((p)h.ae(p.class)).gu(str);
      if (paramString == null) {
        paramString.field_username = ((String)localObject);
      }
      ((p)h.ae(p.class)).gv(str);
      paramq.Iy(str);
    }
    for (;;)
    {
      paramq.setUsername((String)localObject);
      if ((int)paramq.jxt == 0) {
        ((n)h.ae(n.class)).bbL().aw(paramq);
      }
      if ((int)paramq.jxt <= 0)
      {
        Log.e("MicroMsg.ContactWidgetMiniShopHelper", "updateContact, insert contact fail");
        break;
      }
      ab.H(paramq);
      localObject = ((n)h.ae(n.class)).bbL().RG(paramq.field_username);
      if (paramString != null)
      {
        ((p)h.ae(p.class)).b(paramString);
        break;
      }
      paramString = ((p)h.ae(p.class)).gu(((ax)localObject).field_username);
      if ((paramString == null) || (paramString.YR()))
      {
        Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, shouldUpdate");
        az.a.ltq.aP(((ax)localObject).field_username, "");
        com.tencent.mm.am.d.TA(((ax)localObject).field_username);
        break;
      }
      if (!((as)localObject).hyb()) {
        break;
      }
      Log.i("MicroMsg.ContactWidgetMiniShopHelper", "updateBizInfoInNeed, last check time:" + ((ax)localObject).hDo);
      az.a.ltq.aP(((ax)localObject).field_username, "");
      com.tencent.mm.am.d.TA(((ax)localObject).field_username);
      break;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.2
 * JD-Core Version:    0.7.0.1
 */