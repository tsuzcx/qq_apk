package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;

final class am$1
  implements View.OnClickListener
{
  am$1(am paramam, bi parambi, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (ah.bl(this.vGC.field_imgPath))
    {
      y.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
      return;
    }
    ((ai)am.a(this.vGE).ac(ai.class)).cFx().b(this.vGD, this.vGC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.1
 * JD-Core Version:    0.7.0.1
 */