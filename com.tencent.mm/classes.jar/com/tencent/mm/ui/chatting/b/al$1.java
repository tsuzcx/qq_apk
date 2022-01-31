package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class al$1
  implements j.a
{
  al$1(al paramal) {}
  
  public final void a(String paramString, l paraml)
  {
    y.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify " + paramString);
    if (!bk.bl(paramString)) {
      al.a(this.vsS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.al.1
 * JD-Core Version:    0.7.0.1
 */