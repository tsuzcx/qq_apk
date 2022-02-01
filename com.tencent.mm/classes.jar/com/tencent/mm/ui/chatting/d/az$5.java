package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.v;

final class az$5
  implements AdapterView.OnItemClickListener
{
  az$5(az paramaz) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35542);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    paramView = (ca)az.d(this.WOi).getItem(paramInt);
    if ((paramView != null) && (!Util.isNullOrNil(paramView.field_talker)))
    {
      h.IzE.a(10450, new Object[] { Integer.valueOf(1) });
      paramAdapterView = new Intent(this.WOi.fgR.WQv.getContext(), ChattingUI.class);
      paramAdapterView.putExtra("Chat_User", paramView.field_talker);
      paramAdapterView.putExtra("finish_direct", true);
      paramAdapterView.putExtra("show_search_chat_content_result", false);
      paramAdapterView.putExtra("msg_local_id", paramView.field_msgId);
      paramAdapterView.putExtra("img_gallery_enter_from_chatting_ui", true);
      paramView = this.WOi.fgR.WQv;
      paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAdapterView);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramAdapterView.aFh(), "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramAdapterView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/SearchComponent$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(35542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.az.5
 * JD-Core Version:    0.7.0.1
 */