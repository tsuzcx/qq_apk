package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;

final class NearbyFriendsUI$10
  implements AdapterView.OnItemClickListener
{
  NearbyFriendsUI$10(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(55451);
    if (NearbyFriendsUI.p(this.pdm) <= 0)
    {
      i = paramInt;
      if (NearbyFriendsUI.q(this.pdm) <= 0) {}
    }
    else
    {
      i = paramInt - 1;
    }
    paramInt = i;
    if (com.tencent.mm.bo.a.dkM())
    {
      paramInt = i;
      if (NearbyFriendsUI.n(this.pdm) != null) {
        paramInt = i - 1;
      }
    }
    int i = paramInt;
    if (NearbyFriendsUI.r(this.pdm)) {
      i = paramInt - 1;
    }
    if ((i < 0) || (i >= NearbyFriendsUI.s(this.pdm).size()))
    {
      AppMethodBeat.o(55451);
      return;
    }
    paramAdapterView = (azr)NearbyFriendsUI.s(this.pdm).get(i);
    if (NearbyFriendsUI.d.AC(paramAdapterView.gwP))
    {
      paramAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(this.pdm).get(paramAdapterView.jJA);
      paramAdapterView.pdw |= 0x1;
      if (paramAdapterView.pdt == 1)
      {
        paramView = new AppBrandStatObject();
        paramView.scene = 1134;
        ((com.tencent.mm.plugin.appbrand.service.j)g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(this.pdm, paramAdapterView.pdu, "", 0, 0, "", paramView);
        AppMethodBeat.o(55451);
        return;
      }
      if (paramAdapterView.pdt == 2)
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramAdapterView.pdu);
        paramView.putExtra("geta8key_scene", 25);
        paramView.putExtra("stastic_scene", 12);
        com.tencent.mm.bq.d.b(this.pdm.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(55451);
      return;
    }
    paramView = paramAdapterView.jJA;
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramView);
    Object localObject;
    if (com.tencent.mm.n.a.je(localad.field_type))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramView);
      ((Intent)localObject).putExtra("Contact_Scene", 18);
      ((Intent)localObject).putExtra("Sns_from_Scene", 18);
      ((Intent)localObject).putExtra("lbs_ticket", paramAdapterView.wYu);
      ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
      if ((paramView != null) && (paramView.length() > 0))
      {
        if (localad.dwz()) {
          h.qsU.kvStat(10298, paramView + ",18");
        }
        paramAdapterView = new qr();
        paramAdapterView.cHh.intent = ((Intent)localObject);
        paramAdapterView.cHh.username = paramView;
        com.tencent.mm.sdk.b.a.ymk.l(paramAdapterView);
        ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
        com.tencent.mm.plugin.nearby.a.gmO.c((Intent)localObject, this.pdm);
      }
      AppMethodBeat.o(55451);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.jJA);
    paramView.putExtra("Contact_Alias", paramAdapterView.gwU);
    paramView.putExtra("Contact_Nick", paramAdapterView.jKG);
    paramView.putExtra("Contact_Distance", paramAdapterView.xpd);
    paramView.putExtra("Contact_Signature", paramAdapterView.gwS);
    paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(paramAdapterView.gwY, paramAdapterView.gwQ, paramAdapterView.gwR));
    paramView.putExtra("Contact_Sex", paramAdapterView.gwP);
    paramView.putExtra("Contact_IsLBSFriend", true);
    paramView.putExtra("Contact_Scene", 18);
    paramView.putExtra("Contact_VUser_Info", paramAdapterView.xpf);
    paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.xpe);
    paramView.putExtra("Contact_KWeibo_flag", paramAdapterView.xpi);
    paramView.putExtra("Contact_KWeibo", paramAdapterView.xpg);
    paramView.putExtra("Contact_KWeiboNick", paramAdapterView.xph);
    paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.xpk.gxa);
    paramView.putExtra("Contact_KSnsBgId", paramAdapterView.xpk.gxc);
    paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.xpk.gxb);
    paramView.putExtra("lbs_ticket", paramAdapterView.wYu);
    paramView.putExtra("Contact_IsLbsGotoChatting", true);
    if (paramAdapterView.gwZ != null)
    {
      localObject = new com.tencent.mm.aj.d();
      ((com.tencent.mm.aj.d)localObject).field_brandList = paramAdapterView.gwZ;
      ((com.tencent.mm.aj.d)localObject).field_brandFlag = paramAdapterView.xpl.gxd;
      ((com.tencent.mm.aj.d)localObject).field_brandIconURL = paramAdapterView.xpl.gxg;
      ((com.tencent.mm.aj.d)localObject).field_extInfo = paramAdapterView.xpl.gxe;
      ((com.tencent.mm.aj.d)localObject).field_brandInfo = paramAdapterView.xpl.gxf;
      paramView.putExtra("KBrandInfo_item", new MCacheItem((c)localObject));
    }
    paramView.putExtra("Sns_from_Scene", 18);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
    com.tencent.mm.plugin.nearby.a.gmO.c(paramView, this.pdm);
    AppMethodBeat.o(55451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */