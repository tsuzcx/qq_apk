package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class AllRemindMsgUI$a
  implements f, Runnable
{
  AllRemindMsgUI$a(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29117);
    ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 866)
      {
        AppMethodBeat.o(29117);
        return;
      }
      d.post(new AllRemindMsgUI.a.1(this, paramm), "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
      AppMethodBeat.o(29117);
      return;
    }
    ab.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AllRemindMsgUI.c(this.yTD).setVisibility(0);
    AllRemindMsgUI.e(this.yTD).setVisibility(8);
    AppMethodBeat.o(29117);
  }
  
  public final void run()
  {
    AppMethodBeat.i(29116);
    com.tencent.mm.modelsimple.p localp = new com.tencent.mm.modelsimple.p();
    aw.Rc().a(localp, 0);
    AppMethodBeat.o(29116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a
 * JD-Core Version:    0.7.0.1
 */