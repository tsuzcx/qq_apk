package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.c;

final class k$1
  implements View.OnClickListener
{
  k$1(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34384);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ((c)h.ax(c.class)).a(paramView.getContext(), null, null);
    a.a(this, "com/tencent/mm/ui/chatting/ChattingDownloaderFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.1
 * JD-Core Version:    0.7.0.1
 */