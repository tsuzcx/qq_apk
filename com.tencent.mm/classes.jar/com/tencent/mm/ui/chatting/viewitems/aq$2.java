package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;

final class aq$2
  implements View.OnClickListener
{
  aq$2(aq paramaq, bi parambi, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33395);
    if (bo.isNullOrNil(this.zXY.field_imgPath))
    {
      ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
      AppMethodBeat.o(33395);
      return;
    }
    paramView = ((aj)aq.c(this.zYg).ay(aj.class)).dJv();
    int i = this.zXZ;
    bi localbi = this.zXY;
    if (localbi != null)
    {
      paramView.dFI();
      aw.aaz();
      Boolean localBoolean = (Boolean)c.Ru().get(4115, null);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        aw.aaz();
        c.Ru().set(4115, Boolean.TRUE);
        paramView.dFO();
        paramView.zww = t.a(paramView.caz.zJz.getActivity(), paramView.context.getString(2131298264), 4000L);
      }
      if ((paramView.mtU.isPlaying()) && (localbi.field_msgId == paramView.zwt))
      {
        paramView.dFN();
        AppMethodBeat.o(33395);
        return;
      }
      paramView.av(localbi);
      if ((localbi.field_isSend == 0) && (!s.K(localbi))) {
        paramView.Ph(i + 1);
      }
      paramView.qR(true);
    }
    AppMethodBeat.o(33395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.2
 * JD-Core Version:    0.7.0.1
 */