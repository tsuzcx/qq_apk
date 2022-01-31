package com.tencent.mm.plugin.profile.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class b$7
  implements MMActivity.a
{
  b$7(b paramb) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23263);
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      g.bPJ().q(str1, str2, bool);
      g.bPJ().fh(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.l(b.e(this.pxL), b.e(this.pxL).getString(2131299979));
    }
    AppMethodBeat.o(23263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b.7
 * JD-Core Version:    0.7.0.1
 */