package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;

final class e$6
  implements Runnable
{
  e$6(e parame) {}
  
  public final void run()
  {
    if (this.vpa.byx == null) {
      y.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
    }
    do
    {
      return;
      au.Hx();
      localObject = c.FF().in(this.vpa.byx.getTalkerUserName());
    } while ((localObject == null) || (!((u)localObject).ctO()));
    y.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
    Object localObject = b.YK(this.vpa.byx.getTalkerUserName()).y(this.vpa.byx.getTalkerUserName(), ((u)localObject).ctN());
    ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new e.6.1(this));
    ((com.tencent.mm.roomsdk.a.c.a)localObject).cpz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.e.6
 * JD-Core Version:    0.7.0.1
 */