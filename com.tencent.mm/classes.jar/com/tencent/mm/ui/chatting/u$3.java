package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.api.ay;
import com.tencent.mm.ui.chatting.d.a;

final class u$3
  implements c.a
{
  u$3(a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34579);
    if (paramInt1 == 3001)
    {
      Log.i("MicroMsg.ChattingItemHelper", "gotoEditUI() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramInt2) });
      if ((-1 == paramInt2) && (paramIntent != null)) {
        ((ay)this.aehw.cm(ay.class)).aHY(paramIntent.getStringExtra("key_group_solitatire_content"));
      }
    }
    AppMethodBeat.o(34579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.3
 * JD-Core Version:    0.7.0.1
 */