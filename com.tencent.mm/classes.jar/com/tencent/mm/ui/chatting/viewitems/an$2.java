package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.x;

final class an$2
  implements View.OnClickListener
{
  an$2(an paraman, bi parambi, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(this.vGC.field_imgPath)) {
      y.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
    }
    int i;
    bi localbi;
    do
    {
      return;
      paramView = ((ai)an.c(this.vGK).ac(ai.class)).cFx();
      i = this.vGD;
      localbi = this.vGC;
    } while (localbi == null);
    paramView.cBW();
    au.Hx();
    Boolean localBoolean = (Boolean)c.Dz().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      au.Hx();
      c.Dz().o(4115, Boolean.valueOf(true));
      paramView.cCc();
      paramView.vhC = s.a(paramView.byx.vtz.getActivity(), paramView.context.getString(R.l.chatting_music_volumn_change), 4000L);
    }
    if ((paramView.jZC.isPlaying()) && (localbi.field_msgId == paramView.vhz))
    {
      paramView.cCb();
      return;
    }
    paramView.an(localbi);
    if ((localbi.field_isSend == 0) && (!q.F(localbi))) {
      paramView.GI(i + 1);
    }
    paramView.ni(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.2
 * JD-Core Version:    0.7.0.1
 */