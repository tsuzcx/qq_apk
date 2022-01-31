package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.d.a;

final class m$6
  implements d.a
{
  m$6(a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30605);
    if (paramIntent == null)
    {
      ab.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
      AppMethodBeat.o(30605);
      return;
    }
    if (paramInt1 == 225)
    {
      String str = paramIntent.getStringExtra("enterprise_biz_name");
      long l = paramIntent.getLongExtra("key_biz_chat_id", -1L);
      m.a(this.zyx, str, l);
    }
    AppMethodBeat.o(30605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.6
 * JD-Core Version:    0.7.0.1
 */