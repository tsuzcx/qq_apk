package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class al
  extends a
  implements ab
{
  public final void fgg()
  {
    AppMethodBeat.i(35525);
    final Intent localIntent = this.cLy.HZF.getContext().getIntent();
    if (localIntent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3)
    {
      AppMethodBeat.o(35525);
      return;
    }
    localIntent.setClass(this.cLy.HZF.getContext(), SendAppMessageWrapperUI.class);
    localIntent.putExtra("Select_Conv_User", this.cLy.getTalkerUserName());
    this.cLy.a(localIntent, 228, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(35523);
        localIntent.removeExtra("SendAppMessageWrapper_Scene");
        if (paramAnonymousInt1 == 228) {
          if (paramAnonymousInt2 == -1)
          {
            if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getBooleanExtra("Select_stay_in_wx", false)))
            {
              ReportUtil.U(false, 0);
              AppMethodBeat.o(35523);
              return;
            }
            if (!al.this.cLy.HZF.getContext().isFinishing())
            {
              al.this.cLy.HZF.getContext().finish();
              AppMethodBeat.o(35523);
            }
          }
          else
          {
            paramAnonymousIntent = ReportUtil.c(localIntent.getExtras(), 0);
            ReportUtil.a(al.this.cLy.HZF.getContext(), paramAnonymousIntent, true);
            if (!al.this.cLy.HZF.getContext().isFinishing()) {
              al.this.cLy.HZF.getContext().finish();
            }
          }
        }
        AppMethodBeat.o(35523);
      }
    });
    AppMethodBeat.o(35525);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35524);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(35524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.al
 * JD-Core Version:    0.7.0.1
 */