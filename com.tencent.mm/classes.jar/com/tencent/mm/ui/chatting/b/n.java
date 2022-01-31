package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.b.b.k;

@com.tencent.mm.ui.chatting.b.a.a(cFA=k.class)
public class n
  extends a
  implements k
{
  @TargetApi(11)
  public final void cEn()
  {
    if (Build.VERSION.SDK_INT < 11) {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
    }
    ChatFooter localChatFooter;
    do
    {
      return;
      if (this.byx.getListView() != null) {
        this.byx.getListView().setOnDragListener(null);
      }
      localChatFooter = ((com.tencent.mm.ui.chatting.b.b.n)this.byx.ac(com.tencent.mm.ui.chatting.b.b.n.class)).cEq();
    } while (localChatFooter == null);
    localChatFooter.setOnDragListener(null);
    localChatFooter.setEditTextOnDragListener(null);
  }
  
  @TargetApi(11)
  public final void cEo()
  {
    boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj();
    boolean bool2 = ((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFk();
    if ((bool1) || (bool2)) {
      return;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUI.DragDropComponent", "sdk not support dragdrop event");
      return;
    }
    new n.1(this).run();
  }
  
  public final void cyN()
  {
    cEo();
  }
  
  public final void cyR()
  {
    cEn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.n
 * JD-Core Version:    0.7.0.1
 */