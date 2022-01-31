package com.tencent.mm.ui.chatting.f;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class b
  implements f<bi>
{
  private a caz;
  private MMChattingListView zOu;
  public b.a zOv;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.zOu = paramMMChattingListView;
    this.caz = parama;
  }
  
  public final void a(d.d paramd)
  {
    AppMethodBeat.i(32479);
    if (!this.caz.bSe)
    {
      ab.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(32479);
      return;
    }
    ab.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", new Object[] { paramd.toString() });
    Object localObject = (o)this.caz.ay(o.class);
    if ((localObject != null) && (((o)localObject).dIg() != null) && (((o)localObject).dIg().vWC))
    {
      ab.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
      this.caz.qT(true);
    }
    if (paramd.zOE != d.a.zOy)
    {
      localObject = this.zOu;
      MMPullDownView.d((ViewGroup)((MMPullDownView)localObject).zlw, 4);
      MMPullDownView.d((ViewGroup)((MMPullDownView)localObject).yWv, 4);
    }
    ((q)this.caz.ay(q.class)).startTimer();
    if (this.zOv != null) {
      this.zOv.a(this.zOu, paramd);
    }
    AppMethodBeat.o(32479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.b
 * JD-Core Version:    0.7.0.1
 */