package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BizChatSearchUI$2
  implements AdapterView.OnItemClickListener
{
  BizChatSearchUI$2(BizChatSearchUI paramBizChatSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = -1L;
    paramView = BizChatSearchUI.a(this.vfi).GF(paramInt);
    paramAdapterView = this.vfi;
    if ((paramView.ivk == BizChatSearchUI.g.vfG) || (paramView.ivk == BizChatSearchUI.g.vfH)) {
      if ((paramView.data instanceof c))
      {
        paramView = (c)paramView.data;
        if (paramView == null) {
          break label592;
        }
        paramLong = paramView.field_bizChatLocalId;
      }
    }
    for (;;)
    {
      label87:
      Object localObject;
      if ((bk.bl(paramAdapterView.idQ)) || (paramLong < 0L))
      {
        return;
        paramLong = l;
        if (!(paramView.data instanceof is)) {
          continue;
        }
        localObject = ((is)paramView.data).sCR;
        String str = paramAdapterView.idQ;
        paramView = new j();
        paramView.field_userId = ((iv)localObject).sCP;
        paramView.field_userName = ((iv)localObject).ipb;
        paramView.field_brandUserName = str;
        paramView.field_headImageUrl = ((iv)localObject).sCJ;
        paramView.field_profileUrl = ((iv)localObject).sCX;
        paramView.field_UserVersion = ((iv)localObject).ver;
        paramView.field_addMemberUrl = ((iv)localObject).sCN;
        if (z.MC().b(paramView)) {
          break label586;
        }
      }
      label586:
      for (boolean bool = z.MC().a(paramView);; bool = true)
      {
        paramLong = l;
        if (!bool) {
          break;
        }
        localObject = new c();
        ((c)localObject).field_bizChatServId = paramView.field_userId;
        ((c)localObject).field_brandUserName = paramView.field_brandUserName;
        ((c)localObject).field_chatName = paramView.field_userName;
        ((c)localObject).field_chatType = 1;
        paramView = e.e((c)localObject);
        paramLong = l;
        if (paramView == null) {
          break;
        }
        localObject = z.MB().bK(paramView.field_bizChatLocalId);
        ((a)localObject).field_bizChatId = paramView.field_bizChatLocalId;
        ((a)localObject).field_unReadCount = 0;
        if (bk.bl(((a)localObject).field_brandUserName))
        {
          ((a)localObject).field_brandUserName = paramView.field_brandUserName;
          ((a)localObject).field_lastMsgTime = System.currentTimeMillis();
          ((a)localObject).field_flag = ((a)localObject).field_lastMsgTime;
        }
        if (!z.MB().b((a)localObject)) {
          z.MB().a((a)localObject);
        }
        paramLong = paramView.field_bizChatLocalId;
        break;
        paramView = new Intent();
        paramView.putExtra("Chat_User", paramAdapterView.idQ);
        paramView.putExtra("key_biz_chat_id", paramLong);
        paramView.putExtra("finish_direct", true);
        paramView.putExtra("key_need_send_video", false);
        paramView.putExtra("key_is_biz_chat", true);
        d.e(paramAdapterView.mController.uMN, ".ui.chatting.ChattingUI", paramView);
        return;
        if (paramView.ivk != BizChatSearchUI.g.vfI) {
          break label87;
        }
        if (((Integer)paramView.data).intValue() == BizChatSearchUI.g.vfM)
        {
          paramView = new Intent(paramAdapterView.mController.uMN, BizChatSearchUI.class);
          paramView.putExtra("enterprise_biz_name", paramAdapterView.idQ);
          paramView.putExtra("biz_chat_search_scene", 2);
          paramView.putExtra("biz_chat_search_text", paramAdapterView.idl.getSearchContent());
          paramAdapterView.startActivity(paramView);
          return;
        }
        if (((Integer)paramView.data).intValue() != BizChatSearchUI.g.vfN) {
          break label87;
        }
        paramView = new Intent(paramAdapterView.mController.uMN, BizChatSearchUI.class);
        paramView.putExtra("enterprise_biz_name", paramAdapterView.idQ);
        paramView.putExtra("biz_chat_search_scene", 3);
        paramView.putExtra("biz_chat_search_text", paramAdapterView.idl.getSearchContent());
        paramAdapterView.startActivity(paramView);
        return;
      }
      label592:
      paramLong = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.2
 * JD-Core Version:    0.7.0.1
 */