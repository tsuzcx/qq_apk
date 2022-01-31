package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.sdk.platformtools.bo;

final class BizChatSearchUI$2
  implements AdapterView.OnItemClickListener
{
  BizChatSearchUI$2(BizChatSearchUI paramBizChatSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(30136);
    paramView = BizChatSearchUI.a(this.ztH).OZ(paramInt);
    paramAdapterView = this.ztH;
    if ((paramView.kwo == BizChatSearchUI.g.zuf) || (paramView.kwo == BizChatSearchUI.g.zug)) {
      if ((paramView.data instanceof c))
      {
        paramView = (c)paramView.data;
        if (paramView == null) {
          break label613;
        }
        paramLong = paramView.field_bizChatLocalId;
      }
    }
    for (;;)
    {
      Object localObject;
      if ((bo.isNullOrNil(paramAdapterView.jUE)) || (paramLong < 0L))
      {
        AppMethodBeat.o(30136);
        return;
        paramLong = l;
        if (!(paramView.data instanceof kt)) {
          continue;
        }
        localObject = ((kt)paramView.data).wyk;
        String str = paramAdapterView.jUE;
        paramView = new j();
        paramView.field_userId = ((kw)localObject).wyi;
        paramView.field_userName = ((kw)localObject).kqi;
        paramView.field_brandUserName = str;
        paramView.field_headImageUrl = ((kw)localObject).wyc;
        paramView.field_profileUrl = ((kw)localObject).wyq;
        paramView.field_UserVersion = ((kw)localObject).ver;
        paramView.field_addMemberUrl = ((kw)localObject).wyg;
        if (z.afm().b(paramView)) {
          break label607;
        }
      }
      label607:
      for (boolean bool = z.afm().a(paramView);; bool = true)
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
        localObject = z.afl().gF(paramView.field_bizChatLocalId);
        ((a)localObject).field_bizChatId = paramView.field_bizChatLocalId;
        ((a)localObject).field_unReadCount = 0;
        if (bo.isNullOrNil(((a)localObject).field_brandUserName))
        {
          ((a)localObject).field_brandUserName = paramView.field_brandUserName;
          ((a)localObject).field_lastMsgTime = System.currentTimeMillis();
          ((a)localObject).field_flag = ((a)localObject).field_lastMsgTime;
        }
        if (!z.afl().b((a)localObject)) {
          z.afl().a((a)localObject);
        }
        paramLong = paramView.field_bizChatLocalId;
        break;
        paramView = new Intent();
        paramView.putExtra("Chat_User", paramAdapterView.jUE);
        paramView.putExtra("key_biz_chat_id", paramLong);
        paramView.putExtra("finish_direct", true);
        paramView.putExtra("key_need_send_video", false);
        paramView.putExtra("key_is_biz_chat", true);
        d.f(paramAdapterView.getContext(), ".ui.chatting.ChattingUI", paramView);
        AppMethodBeat.o(30136);
        return;
        if (paramView.kwo == BizChatSearchUI.g.zuh)
        {
          if (((Integer)paramView.data).intValue() == BizChatSearchUI.g.zul)
          {
            paramView = new Intent(paramAdapterView.getContext(), BizChatSearchUI.class);
            paramView.putExtra("enterprise_biz_name", paramAdapterView.jUE);
            paramView.putExtra("biz_chat_search_scene", 2);
            paramView.putExtra("biz_chat_search_text", paramAdapterView.jTZ.getSearchContent());
            paramAdapterView.startActivity(paramView);
            AppMethodBeat.o(30136);
            return;
          }
          if (((Integer)paramView.data).intValue() == BizChatSearchUI.g.zum)
          {
            paramView = new Intent(paramAdapterView.getContext(), BizChatSearchUI.class);
            paramView.putExtra("enterprise_biz_name", paramAdapterView.jUE);
            paramView.putExtra("biz_chat_search_scene", 3);
            paramView.putExtra("biz_chat_search_text", paramAdapterView.jTZ.getSearchContent());
            paramAdapterView.startActivity(paramView);
          }
        }
        AppMethodBeat.o(30136);
        return;
      }
      label613:
      paramLong = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.2
 * JD-Core Version:    0.7.0.1
 */