package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.h.a.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi.d;

final class NearbySayHiListUI$11
  implements AdapterView.OnItemClickListener
{
  NearbySayHiListUI$11(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt;
    if (NearbySayHiListUI.d(this.mDP).getHeaderViewsCount() > 0) {
      i = paramInt - NearbySayHiListUI.d(this.mDP).getHeaderViewsCount();
    }
    bf localbf = (bf)NearbySayHiListUI.b(this.mDP).getItem(i);
    if ((localbf == null) || (localbf.field_content == null)) {
      return;
    }
    paramView = bi.d.acc(localbf.field_content);
    paramAdapterView = new Intent();
    if (com.tencent.mm.bp.a.cki())
    {
      paramAdapterView.putExtra("Chat_User", localbf.field_sayhiencryptuser);
      paramAdapterView.putExtra("lbs_mode", true);
      paramAdapterView.putExtra("add_scene", 18);
      com.tencent.mm.plugin.nearby.a.eUR.e(paramAdapterView, this.mDP);
      paramAdapterView = new i();
      paramAdapterView.bFc.scene = paramView.scene;
      com.tencent.mm.sdk.b.a.udP.m(paramAdapterView);
      return;
    }
    Intent localIntent = new Intent();
    if (bk.bl(paramView.pyp))
    {
      paramAdapterView = localbf.field_sayhiuser;
      label179:
      localIntent.putExtra("Contact_User", paramAdapterView);
      localIntent.putExtra("Contact_Alias", paramView.cMT);
      localIntent.putExtra("Contact_Nick", paramView.nickname);
      localIntent.putExtra("Contact_QuanPin", paramView.fha);
      localIntent.putExtra("Contact_PyInitial", paramView.fgZ);
      localIntent.putExtra("Contact_Sex", paramView.sex);
      localIntent.putExtra("Contact_Signature", paramView.signature);
      localIntent.putExtra("Contact_Scene", paramView.scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", paramView.getCity());
      localIntent.putExtra("Contact_Province", paramView.getProvince());
      if (!bk.bl(localbf.field_sayhicontent)) {
        break label556;
      }
    }
    label556:
    for (paramAdapterView = this.mDP.getString(b.h.chatting_from_verify_lbs_tip);; paramAdapterView = localbf.field_sayhicontent)
    {
      localIntent.putExtra("Contact_Content", paramAdapterView);
      localIntent.putExtra("Contact_verify_Scene", paramView.scene);
      localIntent.putExtra("Contact_Uin", paramView.mXV);
      localIntent.putExtra("Contact_QQNick", paramView.fhb);
      localIntent.putExtra("Contact_Mobile_MD5", paramView.uBW);
      localIntent.putExtra("User_From_Fmessage", true);
      localIntent.putExtra("Contact_from_msgType", 37);
      localIntent.putExtra("Verify_ticket", paramView.kzG);
      localIntent.putExtra("Contact_Source_FMessage", paramView.scene);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      paramAdapterView = ((j)g.r(j.class)).Fw().abl(paramView.pyp);
      if ((paramAdapterView != null) && ((int)paramAdapterView.dBe >= 0) && (!com.tencent.mm.n.a.gR(paramAdapterView.field_type)))
      {
        paramInt = paramView.bNb;
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 5)) {
          localIntent.putExtra("User_Verify", true);
        }
        localIntent.putExtra("Contact_IsLBSFriend", true);
        localIntent.putExtra("Sns_from_Scene", 18);
      }
      com.tencent.mm.plugin.nearby.a.eUR.d(localIntent, this.mDP);
      break;
      paramAdapterView = paramView.pyp;
      break label179;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.11
 * JD-Core Version:    0.7.0.1
 */