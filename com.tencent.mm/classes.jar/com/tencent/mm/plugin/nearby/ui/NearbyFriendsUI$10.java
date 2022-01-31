package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.h.a.pk;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class NearbyFriendsUI$10
  implements AdapterView.OnItemClickListener
{
  NearbyFriendsUI$10(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (NearbyFriendsUI.o(this.mDs) <= 0)
    {
      i = paramInt;
      if (NearbyFriendsUI.p(this.mDs) <= 0) {}
    }
    else
    {
      i = paramInt - 1;
    }
    paramInt = i;
    if (com.tencent.mm.bp.a.cki())
    {
      paramInt = i;
      if (NearbyFriendsUI.m(this.mDs) != null) {
        paramInt = i - 1;
      }
    }
    int i = paramInt;
    if (NearbyFriendsUI.q(this.mDs)) {
      i = paramInt - 1;
    }
    if ((i < 0) || (i >= NearbyFriendsUI.r(this.mDs).size())) {}
    ad localad;
    Object localObject;
    do
    {
      do
      {
        return;
        paramAdapterView = (atm)NearbyFriendsUI.r(this.mDs).get(i);
        if (!NearbyFriendsUI.c.ve(paramAdapterView.ffh)) {
          break;
        }
        paramAdapterView = NearbyFriendsUI.c.b(paramAdapterView);
        y.d("MicroMsg.NearbyFriend", "poi item click, go:" + bk.pm(paramAdapterView));
      } while (bk.bl(paramAdapterView));
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView);
      paramView.putExtra("geta8key_scene", 25);
      paramView.putExtra("stastic_scene", 12);
      com.tencent.mm.br.d.b(this.mDs.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
      return;
      paramView = paramAdapterView.hPY;
      localad = ((j)g.r(j.class)).Fw().abl(paramView);
      if (!com.tencent.mm.n.a.gR(localad.field_type)) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", paramView);
      ((Intent)localObject).putExtra("Contact_Scene", 18);
      ((Intent)localObject).putExtra("Sns_from_Scene", 18);
      ((Intent)localObject).putExtra("lbs_ticket", paramAdapterView.tac);
      ((Intent)localObject).putExtra("Contact_IsLbsGotoChatting", true);
    } while ((paramView == null) || (paramView.length() <= 0));
    if (localad.cua()) {
      h.nFQ.aC(10298, paramView + ",18");
    }
    paramAdapterView = new pk();
    paramAdapterView.bYW.intent = ((Intent)localObject);
    paramAdapterView.bYW.username = paramView;
    com.tencent.mm.sdk.b.a.udP.m(paramAdapterView);
    ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
    com.tencent.mm.plugin.nearby.a.eUR.d((Intent)localObject, this.mDs);
    return;
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramAdapterView.hPY);
    paramView.putExtra("Contact_Alias", paramAdapterView.ffm);
    paramView.putExtra("Contact_Nick", paramAdapterView.hRf);
    paramView.putExtra("Contact_Distance", paramAdapterView.tpf);
    paramView.putExtra("Contact_Signature", paramAdapterView.ffk);
    paramView.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramAdapterView.ffq, paramAdapterView.ffi, paramAdapterView.ffj));
    paramView.putExtra("Contact_Sex", paramAdapterView.ffh);
    paramView.putExtra("Contact_IsLBSFriend", true);
    paramView.putExtra("Contact_Scene", 18);
    paramView.putExtra("Contact_VUser_Info", paramAdapterView.tph);
    paramView.putExtra("Contact_VUser_Info_Flag", paramAdapterView.tpg);
    paramView.putExtra("Contact_KWeibo_flag", paramAdapterView.tpk);
    paramView.putExtra("Contact_KWeibo", paramAdapterView.tpi);
    paramView.putExtra("Contact_KWeiboNick", paramAdapterView.tpj);
    paramView.putExtra("Contact_KSnsIFlag", paramAdapterView.tpm.ffs);
    paramView.putExtra("Contact_KSnsBgId", paramAdapterView.tpm.ffu);
    paramView.putExtra("Contact_KSnsBgUrl", paramAdapterView.tpm.fft);
    paramView.putExtra("lbs_ticket", paramAdapterView.tac);
    paramView.putExtra("Contact_IsLbsGotoChatting", true);
    if (paramAdapterView.ffr != null)
    {
      localObject = new com.tencent.mm.ai.d();
      ((com.tencent.mm.ai.d)localObject).field_brandList = paramAdapterView.ffr;
      ((com.tencent.mm.ai.d)localObject).field_brandFlag = paramAdapterView.tpn.ffv;
      ((com.tencent.mm.ai.d)localObject).field_brandIconURL = paramAdapterView.tpn.ffy;
      ((com.tencent.mm.ai.d)localObject).field_extInfo = paramAdapterView.tpn.ffw;
      ((com.tencent.mm.ai.d)localObject).field_brandInfo = paramAdapterView.tpn.ffx;
      paramView.putExtra("KBrandInfo_item", new MCacheItem((c)localObject));
    }
    paramView.putExtra("Sns_from_Scene", 18);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 5);
    com.tencent.mm.plugin.nearby.a.eUR.d(paramView, this.mDs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.10
 * JD-Core Version:    0.7.0.1
 */