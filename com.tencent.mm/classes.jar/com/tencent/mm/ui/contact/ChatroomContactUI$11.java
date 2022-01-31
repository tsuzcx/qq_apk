package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.h.b.a.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.io.IOException;

final class ChatroomContactUI$11
  implements AdapterView.OnItemClickListener
{
  ChatroomContactUI$11(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new StringBuilder("onItemClick ").append(paramInt);
    if (ChatroomContactUI.d(this.vKh) == null)
    {
      paramAdapterView = ChatroomContactUI.d(this.vKh);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChatroomContactUI", paramAdapterView);
      if (paramInt >= ChatroomContactUI.b(this.vKh).getHeaderViewsCount()) {
        break label77;
      }
    }
    label77:
    do
    {
      return;
      paramAdapterView = Boolean.valueOf(ChatroomContactUI.d(this.vKh).wiO);
      break;
      paramInt -= ChatroomContactUI.b(this.vKh).getHeaderViewsCount();
      if ((ChatroomContactUI.d(this.vKh) == null) || (!ChatroomContactUI.d(this.vKh).wiO)) {
        break label817;
      }
      boolean bool1 = ChatroomContactUI.d(this.vKh).sk(paramInt);
      boolean bool2 = ChatroomContactUI.d(this.vKh).Ik(paramInt);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChatroomContactUI", "onItemClick " + bool2);
      if (bool2)
      {
        paramView = ChatroomContactUI.d(this.vKh);
        if (ChatroomContactUI.e(this.vKh) == null) {}
        for (paramAdapterView = "";; paramAdapterView = ChatroomContactUI.e(this.vKh).getSearchContent())
        {
          paramView.aet(paramAdapterView);
          return;
        }
      }
      if (!bool1) {
        break label647;
      }
      paramView = ChatroomContactUI.d(this.vKh).Ii(paramInt);
      paramAdapterView = paramView.sQs.tFO;
      au.Hx();
      localObject = c.Fw().abl(paramAdapterView);
      if (!a.gR(((ao)localObject).field_type)) {
        break label347;
      }
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView);
      paramView.putExtra("Contact_Scene", 3);
    } while ((paramAdapterView == null) || (paramAdapterView.length() <= 0));
    if (((ad)localObject).cua()) {
      h.nFQ.aC(10298, paramAdapterView + ",3");
    }
    e.a(paramView, paramAdapterView);
    com.tencent.mm.br.d.b(this.vKh, "profile", ".ui.ContactInfoUI", paramView);
    return;
    label347:
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", paramView.sQs.tFO);
    ((Intent)localObject).putExtra("Contact_Alias", paramView.ffm);
    ((Intent)localObject).putExtra("Contact_Nick", paramView.tmw.tFO);
    ((Intent)localObject).putExtra("Contact_Signature", paramView.ffk);
    ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramView.ffq, paramView.ffi, paramView.ffj));
    ((Intent)localObject).putExtra("Contact_Sex", paramView.ffh);
    ((Intent)localObject).putExtra("Contact_VUser_Info", paramView.tph);
    ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramView.tpg);
    ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramView.tpk);
    ((Intent)localObject).putExtra("Contact_KWeibo", paramView.tpi);
    ((Intent)localObject).putExtra("Contact_KWeiboNick", paramView.tpj);
    ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramView.tpm.ffs);
    ((Intent)localObject).putExtra("Contact_KSnsBgId", paramView.tpm.ffu);
    ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramView.tpm.fft);
    if (paramView.tpn != null) {}
    try
    {
      ((Intent)localObject).putExtra("Contact_customInfo", paramView.tpn.toByteArray());
      if ((paramView.tpg & 0x8) > 0) {
        h.nFQ.aC(10298, paramAdapterView + ",3");
      }
      com.tencent.mm.br.d.b(this.vKh, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
      }
    }
    label647:
    paramAdapterView = ChatroomContactUI.d(this.vKh).Ij(paramInt);
    if (paramAdapterView == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.d(this.vKh).getCount()), Integer.valueOf(paramInt) });
      return;
    }
    y.o(ChatroomContactUI.e(this.vKh).getSearchContent(), 9, 3, paramInt + 1);
    paramAdapterView = paramAdapterView.field_username;
    if (com.tencent.mm.model.s.hb(paramAdapterView))
    {
      paramView = new m();
      paramView.ciU = paramAdapterView;
      paramView.ciV = 2L;
      paramView.QX();
    }
    paramView = new Intent(this.vKh.mController.uMN, ChattingUI.class);
    paramView.addFlags(67108864);
    paramView.putExtra("Chat_User", paramAdapterView);
    paramView.putExtra("Chat_Mode", 1);
    this.vKh.mController.uMN.startActivity(paramView);
    return;
    label817:
    paramAdapterView = (ad)ChatroomContactUI.f(this.vKh).getItem(paramInt);
    if (com.tencent.mm.model.s.hb(paramAdapterView.field_username))
    {
      paramView = new m();
      paramView.ciU = paramAdapterView.field_username;
      paramView.ciV = 2L;
      paramView.QX();
    }
    paramAdapterView = paramAdapterView.field_username;
    ChatroomContactUI.b(this.vKh, paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.11
 * JD-Core Version:    0.7.0.1
 */