package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;

final class e$6
  implements Runnable
{
  e$6(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(31249);
    if (this.zEC.caz == null)
    {
      ab.e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
      AppMethodBeat.o(31249);
      return;
    }
    aw.aaz();
    Object localObject = c.YJ().oU(this.zEC.caz.getTalkerUserName());
    if ((localObject != null) && (((u)localObject).dwp()))
    {
      ab.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
      localObject = b.aoI(this.zEC.caz.getTalkerUserName()).D(this.zEC.caz.getTalkerUserName(), ((u)localObject).dwo());
      ((com.tencent.mm.roomsdk.a.c.a)localObject).b(new e.6.1(this));
      ((com.tencent.mm.roomsdk.a.c.a)localObject).drn();
    }
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e.6
 * JD-Core Version:    0.7.0.1
 */