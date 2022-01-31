package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.d.a;

final class r$3
  extends Handler
{
  r$3(r paramr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(31443);
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
    {
      paramMessage = (z)this.zGh.caz.ay(z.class);
      boolean bool;
      if ((paramMessage.dJd()) || (paramMessage.dJc()))
      {
        bool = true;
        this.zGh.caz.zJB.setIsBottomShowAll(false);
        this.zGh.caz.zJB.setBottomViewVisible(true);
        if (!bool) {
          break label150;
        }
        this.zGh.caz.zJB.qE(true);
      }
      for (;;)
      {
        ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), this.zGh.caz.getTalkerUserName() });
        AppMethodBeat.o(31443);
        return;
        bool = false;
        break;
        label150:
        paramMessage = new Bundle();
        paramMessage.putBoolean("load_bottom", true);
        this.zGh.caz.zJB.aF(paramMessage);
      }
    }
    if (paramMessage.what == 2)
    {
      this.zGh.caz.zJB.setIsBottomShowAll(true);
      this.zGh.caz.zJB.setBottomViewVisible(true);
      r.b(this.zGh).postDelayed(new r.3.1(this), 300L);
      ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { this.zGh.caz.getTalkerUserName() });
      AppMethodBeat.o(31443);
      return;
    }
    if (paramMessage.what == 4)
    {
      this.zGh.caz.zJB.setIsBottomShowAll(false);
      this.zGh.caz.zJB.setBottomViewVisible(true);
      paramMessage = new Bundle();
      paramMessage.putBoolean("load_bottom", true);
      this.zGh.caz.zJB.aF(paramMessage);
      ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { this.zGh.caz.getTalkerUserName() });
      AppMethodBeat.o(31443);
      return;
    }
    if (paramMessage.what == 8)
    {
      ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
      this.zGh.caz.zJz.dGd();
    }
    AppMethodBeat.o(31443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r.3
 * JD-Core Version:    0.7.0.1
 */