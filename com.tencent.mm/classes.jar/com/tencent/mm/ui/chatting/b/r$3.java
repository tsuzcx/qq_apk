package com.tencent.mm.ui.chatting.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class r$3
  extends Handler
{
  r$3(r paramr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    boolean bool;
    if (paramMessage.what == 1)
    {
      paramMessage = (com.tencent.mm.ui.chatting.b.b.y)this.vqB.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
      if ((paramMessage.cFl()) || (paramMessage.cFk()))
      {
        bool = true;
        this.vqB.byx.vtB.setIsBottomShowAll(false);
        this.vqB.byx.vtB.setBottomViewVisible(true);
        if (!bool) {
          break label138;
        }
        this.vqB.byx.vtB.nb(true);
        label101:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", new Object[] { Boolean.valueOf(bool), this.vqB.byx.getTalkerUserName() });
      }
    }
    label138:
    do
    {
      return;
      bool = false;
      break;
      paramMessage = new Bundle();
      paramMessage.putBoolean("load_bottom", true);
      this.vqB.byx.vtB.am(paramMessage);
      break label101;
      if (paramMessage.what == 2)
      {
        this.vqB.byx.vtB.setIsBottomShowAll(true);
        this.vqB.byx.vtB.setBottomViewVisible(true);
        r.b(this.vqB).postDelayed(new r.3.1(this), 300L);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", new Object[] { this.vqB.byx.getTalkerUserName() });
        return;
      }
      if (paramMessage.what == 4)
      {
        this.vqB.byx.vtB.setIsBottomShowAll(false);
        this.vqB.byx.vtB.setBottomViewVisible(true);
        paramMessage = new Bundle();
        paramMessage.putBoolean("load_bottom", true);
        this.vqB.byx.vtB.am(paramMessage);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", new Object[] { this.vqB.byx.getTalkerUserName() });
        return;
      }
    } while (paramMessage.what != 8);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
    this.vqB.byx.vtz.cCq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.r.3
 * JD-Core Version:    0.7.0.1
 */