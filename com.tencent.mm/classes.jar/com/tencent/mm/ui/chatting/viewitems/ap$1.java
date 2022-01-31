package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;

final class ap$1
  implements View.OnClickListener
{
  ap$1(ap paramap, bi parambi, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33383);
    if (ah.isNullOrNil(this.zXY.field_imgPath))
    {
      ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
      AppMethodBeat.o(33383);
      return;
    }
    ((aj)ap.a(this.zYa).ay(aj.class)).dJv().b(this.zXZ, this.zXY);
    AppMethodBeat.o(33383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.1
 * JD-Core Version:    0.7.0.1
 */