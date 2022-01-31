package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.x;

final class af$5
  implements AdapterView.OnItemClickListener
{
  af$5(af paramaf) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bi)af.d(this.vsd).getItem(paramInt);
    if ((paramAdapterView != null) && (!bk.bl(paramAdapterView.field_talker)))
    {
      h.nFQ.f(10450, new Object[] { Integer.valueOf(1) });
      paramView = new Intent(this.vsd.byx.vtz.getContext(), ChattingUI.class);
      paramView.putExtra("Chat_User", paramAdapterView.field_talker);
      paramView.putExtra("finish_direct", true);
      paramView.putExtra("show_search_chat_content_result", false);
      paramView.putExtra("msg_local_id", paramAdapterView.field_msgId);
      paramView.putExtra("img_gallery_enter_from_chatting_ui", true);
      this.vsd.byx.vtz.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.af.5
 * JD-Core Version:    0.7.0.1
 */