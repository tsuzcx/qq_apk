package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.io.IOException;

final class ChatroomContactUI$11
  implements AdapterView.OnItemClickListener
{
  ChatroomContactUI$11(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33583);
    paramView = new StringBuilder("onItemClick ").append(paramInt);
    if (ChatroomContactUI.d(this.AbH) == null) {}
    for (paramAdapterView = ChatroomContactUI.d(this.AbH);; paramAdapterView = Boolean.valueOf(ChatroomContactUI.d(this.AbH).ABF))
    {
      ab.d("MicroMsg.ChatroomContactUI", paramAdapterView);
      if (paramInt >= ChatroomContactUI.b(this.AbH).getHeaderViewsCount()) {
        break;
      }
      AppMethodBeat.o(33583);
      return;
    }
    paramInt -= ChatroomContactUI.b(this.AbH).getHeaderViewsCount();
    if ((ChatroomContactUI.d(this.AbH) != null) && (ChatroomContactUI.d(this.AbH).ABF))
    {
      boolean bool1 = ChatroomContactUI.d(this.AbH).xj(paramInt);
      boolean bool2 = ChatroomContactUI.d(this.AbH).QW(paramInt);
      ab.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
      if (bool2)
      {
        paramView = ChatroomContactUI.d(this.AbH);
        if (ChatroomContactUI.e(this.AbH) == null) {}
        for (paramAdapterView = "";; paramAdapterView = ChatroomContactUI.e(this.AbH).getSearchContent())
        {
          paramView.avg(paramAdapterView);
          AppMethodBeat.o(33583);
          return;
        }
      }
      if (bool1)
      {
        paramView = ChatroomContactUI.d(this.AbH).QU(paramInt);
        paramAdapterView = paramView.wOT.xJE;
        aw.aaz();
        Object localObject = c.YA().arw(paramAdapterView);
        if (a.je(((aq)localObject).field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", paramAdapterView);
          paramView.putExtra("Contact_Scene", 3);
          if ((paramAdapterView != null) && (paramAdapterView.length() > 0))
          {
            if (((ad)localObject).dwz()) {
              h.qsU.kvStat(10298, paramAdapterView + ",3");
            }
            e.a(paramView, paramAdapterView);
            com.tencent.mm.bq.d.b(this.AbH, "profile", ".ui.ContactInfoUI", paramView);
          }
          AppMethodBeat.o(33583);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramView.wOT.xJE);
        ((Intent)localObject).putExtra("Contact_Alias", paramView.gwU);
        ((Intent)localObject).putExtra("Contact_Nick", paramView.xmi.xJE);
        ((Intent)localObject).putExtra("Contact_Signature", paramView.gwS);
        ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aF(paramView.gwY, paramView.gwQ, paramView.gwR));
        ((Intent)localObject).putExtra("Contact_Sex", paramView.gwP);
        ((Intent)localObject).putExtra("Contact_VUser_Info", paramView.xpf);
        ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramView.xpe);
        ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramView.xpi);
        ((Intent)localObject).putExtra("Contact_KWeibo", paramView.xpg);
        ((Intent)localObject).putExtra("Contact_KWeiboNick", paramView.xph);
        ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramView.xpk.gxa);
        ((Intent)localObject).putExtra("Contact_KSnsBgId", paramView.xpk.gxc);
        ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramView.xpk.gxb);
        if (paramView.xpl != null) {}
        try
        {
          ((Intent)localObject).putExtra("Contact_customInfo", paramView.xpl.toByteArray());
          if ((paramView.xpe & 0x8) > 0) {
            h.qsU.kvStat(10298, paramAdapterView + ",3");
          }
          com.tencent.mm.bq.d.b(this.AbH, "profile", ".ui.ContactInfoUI", (Intent)localObject);
          AppMethodBeat.o(33583);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
          }
        }
      }
      paramAdapterView = ChatroomContactUI.d(this.AbH).QV(paramInt);
      if (paramAdapterView == null)
      {
        ab.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.d(this.AbH).getCount()), Integer.valueOf(paramInt) });
        AppMethodBeat.o(33583);
        return;
      }
      z.r(ChatroomContactUI.e(this.AbH).getSearchContent(), 9, 3, paramInt + 1);
      paramAdapterView = paramAdapterView.field_username;
      if (t.nK(paramAdapterView))
      {
        paramView = new v();
        paramView.fq(paramAdapterView);
        paramView.cTE = 2L;
        paramView.ake();
      }
      paramView = new Intent(this.AbH.getContext(), ChattingUI.class);
      paramView.addFlags(67108864);
      paramView.putExtra("Chat_User", paramAdapterView);
      paramView.putExtra("Chat_Mode", 1);
      this.AbH.getContext().startActivity(paramView);
      AppMethodBeat.o(33583);
      return;
    }
    paramAdapterView = (ad)ChatroomContactUI.f(this.AbH).getItem(paramInt);
    if (t.nK(paramAdapterView.field_username))
    {
      paramView = new v();
      paramView.fq(paramAdapterView.field_username);
      paramView.cTE = 2L;
      paramView.ake();
    }
    paramAdapterView = paramAdapterView.field_username;
    ChatroomContactUI.b(this.AbH, paramAdapterView);
    AppMethodBeat.o(33583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.11
 * JD-Core Version:    0.7.0.1
 */