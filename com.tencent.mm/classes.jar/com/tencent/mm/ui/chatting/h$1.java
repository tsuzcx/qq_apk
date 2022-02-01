package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.c;

final class h$1
  implements View.OnClickListener
{
  h$1(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34384);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ((c)g.ab(c.class)).a(paramView.getContext(), null, null);
    a.a(this, "com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.1
 * JD-Core Version:    0.7.0.1
 */