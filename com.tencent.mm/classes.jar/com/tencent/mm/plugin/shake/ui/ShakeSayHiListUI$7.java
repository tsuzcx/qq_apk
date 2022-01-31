package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;

final class ShakeSayHiListUI$7
  implements AdapterView.OnItemClickListener
{
  ShakeSayHiListUI$7(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bt)ShakeSayHiListUI.b(this.odv).getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.field_content == null)) {
      return;
    }
    paramView = bi.d.acc(paramAdapterView.field_content);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView.pyp);
    localIntent.putExtra("Contact_Encryptusername", paramView.uCl);
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
    if (bk.bl(paramAdapterView.field_sayhicontent)) {}
    for (paramAdapterView = this.odv.getString(R.l.chatting_from_verify_lbs_tip);; paramAdapterView = paramAdapterView.field_sayhicontent)
    {
      localIntent.putExtra("Contact_Content", paramAdapterView);
      localIntent.putExtra("Contact_verify_Scene", paramView.scene);
      localIntent.putExtra("Contact_Uin", paramView.mXV);
      localIntent.putExtra("Contact_QQNick", paramView.fhb);
      localIntent.putExtra("Contact_Mobile_MD5", paramView.uBW);
      localIntent.putExtra("User_From_Fmessage", true);
      localIntent.putExtra("Contact_from_msgType", 37);
      localIntent.putExtra("Verify_ticket", paramView.kzG);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Source_FMessage", paramView.scene);
      au.Hx();
      paramAdapterView = c.Fw().abl(paramView.pyp);
      if ((paramAdapterView != null) && ((int)paramAdapterView.dBe >= 0) && (!com.tencent.mm.n.a.gR(paramAdapterView.field_type)))
      {
        paramInt = paramView.bNb;
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 5)) {
          localIntent.putExtra("User_Verify", true);
        }
        localIntent.putExtra("Contact_IsLBSFriend", true);
        localIntent.putExtra("Sns_from_Scene", 18);
      }
      com.tencent.mm.plugin.shake.a.eUR.d(localIntent, this.odv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.7
 * JD-Core Version:    0.7.0.1
 */