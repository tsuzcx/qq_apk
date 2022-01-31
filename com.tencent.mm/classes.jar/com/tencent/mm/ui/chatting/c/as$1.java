package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class as$1
  implements ao.d
{
  as$1(as paramas) {}
  
  public final void w(String paramString, final long paramLong)
  {
    AppMethodBeat.i(31866);
    ab.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramString + " time " + paramLong);
    if (t.or(aw.getNotification().IF())) {
      com.tencent.mm.ui.base.h.a(this.zJk.caz.zJz.getContext(), false, paramString, this.zJk.caz.zJz.getMMResources().getString(2131304587), this.zJk.caz.zJz.getMMResources().getString(2131304584), this.zJk.caz.zJz.getMMResources().getString(2131304586), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31865);
          aw.aaz();
          if (c.YC().an(aw.getNotification().IF(), paramLong))
          {
            int i = ((com.tencent.mm.ui.chatting.c.b.h)as.1.this.zJk.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dwi();
            paramAnonymousInt = ((com.tencent.mm.ui.chatting.c.b.h)as.1.this.zJk.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).getCount();
            aw.aaz();
            i = c.YC().f(aw.getNotification().IF(), paramLong, i - paramAnonymousInt);
            if (i < 0)
            {
              AppMethodBeat.o(31865);
              return;
            }
            if (paramAnonymousInt > i) {
              as.1.this.zJk.caz.Pu(i);
            }
          }
          AppMethodBeat.o(31865);
        }
      }, null);
    }
    AppMethodBeat.o(31866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.as.1
 * JD-Core Version:    0.7.0.1
 */