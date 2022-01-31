package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.u;

final class ag$5
  implements AdapterView.OnItemClickListener
{
  ag$5(ag paramag) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(31646);
    paramAdapterView = (bi)ag.d(this.zHJ).getItem(paramInt);
    if ((paramAdapterView != null) && (!bo.isNullOrNil(paramAdapterView.field_talker)))
    {
      h.qsU.e(10450, new Object[] { Integer.valueOf(1) });
      paramView = new Intent(this.zHJ.caz.zJz.getContext(), ChattingUI.class);
      paramView.putExtra("Chat_User", paramAdapterView.field_talker);
      paramView.putExtra("finish_direct", true);
      paramView.putExtra("show_search_chat_content_result", false);
      paramView.putExtra("msg_local_id", paramAdapterView.field_msgId);
      paramView.putExtra("img_gallery_enter_from_chatting_ui", true);
      this.zHJ.caz.zJz.startActivity(paramView);
    }
    AppMethodBeat.o(31646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag.5
 * JD-Core Version:    0.7.0.1
 */