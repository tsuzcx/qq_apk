package com.tencent.mm.ui;

import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.finder.report.d.e;
import com.tencent.mm.plugin.finder.view.t;
import com.tencent.mm.plugin.finder.view.t.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.contact.e;

final class SingleChatInfoUI$10
  implements ContactListExpandPreference.a
{
  SingleChatInfoUI$10(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void asG()
  {
    AppMethodBeat.i(288602);
    if (SingleChatInfoUI.e(this.WeA) != null) {
      SingleChatInfoUI.e(this.WeA).hkC();
    }
    AppMethodBeat.o(288602);
  }
  
  public final void e(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(288600);
    Object localObject3 = SingleChatInfoUI.e(this.WeA).aqq(paramInt);
    Object localObject2 = Util.nullAsNil(SingleChatInfoUI.e(this.WeA).aqs(paramInt));
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      bh.beI();
      co localco = com.tencent.mm.model.c.bbM().aPj((String)localObject3);
      localObject1 = localObject2;
      if (localco != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(localco.field_encryptUsername)) {
          localObject1 = localco.field_conRemark;
        }
      }
    }
    if (Util.isNullOrNil((String)localObject3))
    {
      AppMethodBeat.o(288600);
      return;
    }
    if (as.aEF(SingleChatInfoUI.a(this.WeA)))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.d.zUg;
      localObject1 = com.tencent.mm.plugin.finder.report.d.dPe();
      ((d.e)localObject1).zUy += 1L;
      Log.i(((d.e)localObject1).TAG, "incChatInfoClickCount:" + ((d.e)localObject1).zUy);
      localObject2 = ((ab)h.ae(ab.class)).aED(SingleChatInfoUI.a(this.WeA));
      if (as.bvP((String)localObject2))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
        localObject2 = aj.Bnu;
        aj.a.a(paramViewGroup.getContext(), (Intent)localObject1, 0L, 10, false);
        ((ak)h.ag(ak.class)).enterFinderProfileUI(paramViewGroup.getContext(), (Intent)localObject1);
        AppMethodBeat.o(288600);
        return;
      }
      if (as.bvN((String)localObject2))
      {
        localObject1 = new Intent();
        localObject2 = ((m)h.ae(m.class)).aEt((String)localObject2);
        localObject3 = t.BbG;
        t.a.a((ai)localObject2, (Intent)localObject1);
        ((Intent)localObject1).putExtra("IsPoster", true);
        localObject2 = t.BbG;
        t.a.a(paramViewGroup.getContext(), (Intent)localObject1, 2, null);
        AppMethodBeat.o(288600);
        return;
      }
      Log.i("MicroMsg.SingleChatInfoUI", "talkerName :".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(288600);
      return;
    }
    if (as.bvQ(SingleChatInfoUI.a(this.WeA)))
    {
      ((PluginGameLife)h.ag(PluginGameLife.class)).enterGameLifeProfileUI(this.WeA.getContext(), SingleChatInfoUI.a(this.WeA), a.DeE);
      AppMethodBeat.o(288600);
      return;
    }
    paramViewGroup = new Intent();
    paramViewGroup.putExtra("Contact_User", (String)localObject3);
    paramViewGroup.putExtra("Contact_RemarkName", (String)localObject1);
    paramViewGroup.putExtra("Contact_Nick", Util.nullAsNil(SingleChatInfoUI.e(this.WeA).aqr(paramInt)));
    paramViewGroup.putExtra("Contact_RoomMember", true);
    paramViewGroup.putExtra("CONTACT_INFO_UI_SOURCE", 9);
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject3);
    if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).jxt > 0) && (com.tencent.mm.contact.d.rk(((ax)localObject1).field_type))) {
      e.a(paramViewGroup, (String)localObject3);
    }
    paramViewGroup.putExtra("Kdel_from", 0);
    com.tencent.mm.by.c.b(this.WeA, "profile", ".ui.ContactInfoUI", paramViewGroup, 0);
    AppMethodBeat.o(288600);
  }
  
  public final void qv(int paramInt) {}
  
  public final void qw(int paramInt)
  {
    AppMethodBeat.i(288603);
    SingleChatInfoUI.f(this.WeA);
    AppMethodBeat.o(288603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.10
 * JD-Core Version:    0.7.0.1
 */