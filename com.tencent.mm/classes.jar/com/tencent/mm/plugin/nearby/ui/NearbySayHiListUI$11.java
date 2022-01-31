package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.i;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi.d;

final class NearbySayHiListUI$11
  implements AdapterView.OnItemClickListener
{
  NearbySayHiListUI$11(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(55505);
    int i = paramInt;
    if (NearbySayHiListUI.d(this.pdR).getHeaderViewsCount() > 0) {
      i = paramInt - NearbySayHiListUI.d(this.pdR).getHeaderViewsCount();
    }
    bf localbf = (bf)NearbySayHiListUI.b(this.pdR).getItem(i);
    if ((localbf == null) || (localbf.field_content == null))
    {
      AppMethodBeat.o(55505);
      return;
    }
    paramView = bi.d.asm(localbf.field_content);
    paramAdapterView = new Intent();
    if (com.tencent.mm.bo.a.dkM())
    {
      paramAdapterView.putExtra("Chat_User", localbf.field_sayhiencryptuser);
      paramAdapterView.putExtra("lbs_mode", true);
      paramAdapterView.putExtra("add_scene", 18);
      com.tencent.mm.plugin.nearby.a.gmO.d(paramAdapterView, this.pdR);
      paramAdapterView = new i();
      paramAdapterView.cmn.scene = paramView.scene;
      com.tencent.mm.sdk.b.a.ymk.l(paramAdapterView);
      AppMethodBeat.o(55505);
      return;
    }
    Intent localIntent = new Intent();
    if (bo.isNullOrNil(paramView.tac))
    {
      paramAdapterView = localbf.field_sayhiuser;
      label194:
      localIntent.putExtra("Contact_User", paramAdapterView);
      localIntent.putExtra("Contact_Alias", paramView.dCJ);
      localIntent.putExtra("Contact_Nick", paramView.nickname);
      localIntent.putExtra("Contact_QuanPin", paramView.gyI);
      localIntent.putExtra("Contact_PyInitial", paramView.gyH);
      localIntent.putExtra("Contact_Sex", paramView.dqC);
      localIntent.putExtra("Contact_Signature", paramView.signature);
      localIntent.putExtra("Contact_Scene", paramView.scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", paramView.getCity());
      localIntent.putExtra("Contact_Province", paramView.getProvince());
      if (!bo.isNullOrNil(localbf.field_sayhicontent)) {
        break label570;
      }
    }
    label570:
    for (paramAdapterView = this.pdR.getString(2131298188);; paramAdapterView = localbf.field_sayhicontent)
    {
      localIntent.putExtra("Contact_Content", paramAdapterView);
      localIntent.putExtra("Contact_verify_Scene", paramView.scene);
      localIntent.putExtra("Contact_Uin", paramView.pAI);
      localIntent.putExtra("Contact_QQNick", paramView.gyJ);
      localIntent.putExtra("Contact_Mobile_MD5", paramView.yOi);
      localIntent.putExtra("User_From_Fmessage", true);
      localIntent.putExtra("Contact_from_msgType", 37);
      localIntent.putExtra("Verify_ticket", paramView.mVw);
      localIntent.putExtra("Contact_Source_FMessage", paramView.scene);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      paramAdapterView = ((j)g.E(j.class)).YA().arw(paramView.tac);
      if ((paramAdapterView != null) && ((int)paramAdapterView.euF >= 0) && (!com.tencent.mm.n.a.je(paramAdapterView.field_type)))
      {
        paramInt = paramView.cut;
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 5)) {
          localIntent.putExtra("User_Verify", true);
        }
        localIntent.putExtra("Contact_IsLBSFriend", true);
        localIntent.putExtra("Sns_from_Scene", 18);
      }
      com.tencent.mm.plugin.nearby.a.gmO.c(localIntent, this.pdR);
      break;
      paramAdapterView = paramView.tac;
      break label194;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.11
 * JD-Core Version:    0.7.0.1
 */