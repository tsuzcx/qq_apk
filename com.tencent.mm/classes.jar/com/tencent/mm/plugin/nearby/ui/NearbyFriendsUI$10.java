package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.List;
import java.util.Map;

final class NearbyFriendsUI$10
  implements AdapterView.OnItemClickListener
{
  NearbyFriendsUI$10(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(89848);
    Object localObject = new b();
    ((b)localObject).bm(paramAdapterView);
    ((b)localObject).bm(paramView);
    ((b)localObject).pH(paramInt);
    ((b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
    if (NearbyFriendsUI.p(this.AAi) <= 0)
    {
      i = paramInt;
      if (NearbyFriendsUI.q(this.AAi) <= 0) {}
    }
    else
    {
      i = paramInt - 1;
    }
    paramInt = i;
    if (com.tencent.mm.bp.a.glC())
    {
      paramInt = i;
      if (NearbyFriendsUI.n(this.AAi) != null) {
        paramInt = i - 1;
      }
    }
    int i = paramInt;
    if (NearbyFriendsUI.r(this.AAi)) {
      i = paramInt - 1;
    }
    if ((i < 0) || (i >= NearbyFriendsUI.s(this.AAi).size()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(89848);
      return;
    }
    paramAdapterView = (chi)NearbyFriendsUI.s(this.AAi).get(i);
    if (NearbyFriendsUI.d.JD(paramAdapterView.kdY))
    {
      paramAdapterView = (NearbyFriendsUI.a)NearbyFriendsUI.t(this.AAi).get(paramAdapterView.UserName);
      paramAdapterView.uSf |= 0x1;
      if (paramAdapterView.uSc == 1)
      {
        paramView = new AppBrandStatObject();
        paramView.scene = 1134;
        ((r)g.af(r.class)).a(this.AAi, paramAdapterView.uSd, "", 0, 0, "", paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(89848);
        return;
        if (paramAdapterView.uSc == 2)
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", paramAdapterView.uSd);
          paramView.putExtra("geta8key_scene", 25);
          paramView.putExtra("stastic_scene", 12);
          com.tencent.mm.br.c.b(this.AAi.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
    paramView = paramAdapterView.UserName;
    as localas = ((l)g.af(l.class)).aSN().Kn(paramView);
    if (com.tencent.mm.contact.c.oR(localas.field_type))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramView);
      ((Intent)localObject).putExtra("Contact_Scene", 18);
      ((Intent)localObject).putExtra("Sns_from_Scene", 18);
      ((Intent)localObject).putExtra("lbs_ticket", paramAdapterView.LRO);
      ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
      if ((paramView != null) && (paramView.length() > 0))
      {
        if (localas.gBM()) {
          h.CyF.kvStat(10298, paramView + ",18");
        }
        paramAdapterView = new uj();
        paramAdapterView.eaI.intent = ((Intent)localObject);
        paramAdapterView.eaI.username = paramView;
        EventCenter.instance.publish(paramAdapterView);
        ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
        com.tencent.mm.plugin.nearby.a.jRt.c((Intent)localObject, this.AAi);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(89848);
      return;
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView.UserName);
      paramView.putExtra("Contact_Alias", paramAdapterView.ked);
      paramView.putExtra("Contact_Nick", paramAdapterView.oUJ);
      paramView.putExtra("Contact_Distance", paramAdapterView.MmJ);
      paramView.putExtra("Contact_Signature", paramAdapterView.keb);
      paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramAdapterView.keh, paramAdapterView.kdZ, paramAdapterView.kea));
      paramView.putExtra("Contact_Sex", paramAdapterView.kdY);
      paramView.putExtra("Contact_IsLBSFriend", true);
      paramView.putExtra("Contact_Scene", 18);
      paramView.putExtra("Contact_VUser_Info", paramAdapterView.MmL);
      paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.MmK);
      paramView.putExtra("Contact_KWeibo_flag", paramAdapterView.MmO);
      paramView.putExtra("Contact_KWeibo", paramAdapterView.MmM);
      paramView.putExtra("Contact_KWeiboNick", paramAdapterView.MmN);
      paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.MmQ.kej);
      paramView.putExtra("Contact_KSnsBgId", paramAdapterView.MmQ.kel);
      paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.MmQ.kek);
      paramView.putExtra("lbs_ticket", paramAdapterView.LRO);
      paramView.putExtra("Contact_IsLbsGotoChatting", true);
      if (paramAdapterView.kei != null)
      {
        localObject = new com.tencent.mm.api.c();
        ((com.tencent.mm.api.c)localObject).field_brandList = paramAdapterView.kei;
        ((com.tencent.mm.api.c)localObject).field_brandFlag = paramAdapterView.MmR.kem;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramAdapterView.MmR.kep;
        ((com.tencent.mm.api.c)localObject).field_extInfo = paramAdapterView.MmR.ken;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = paramAdapterView.MmR.keo;
        paramView.putExtra("KBrandInfo_item", new MCacheItem((IAutoDBItem)localObject));
      }
      paramView.putExtra("Sns_from_Scene", 18);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
      com.tencent.mm.plugin.nearby.a.jRt.c(paramView, this.AAi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */