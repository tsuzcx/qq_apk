package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class aq
  extends a
  implements af
{
  public final void gIk()
  {
    AppMethodBeat.i(35525);
    final Intent localIntent = this.dom.Pwc.getContext().getIntent();
    if (localIntent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3)
    {
      AppMethodBeat.o(35525);
      return;
    }
    localIntent.setClass(this.dom.Pwc.getContext(), SendAppMessageWrapperUI.class);
    localIntent.putExtra("Select_Conv_User", this.dom.getTalkerUserName());
    this.dom.a(localIntent, 228, new c.a()
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
              ReportUtil.ab(false, 0);
              AppMethodBeat.o(35523);
              return;
            }
            if (!aq.this.dom.Pwc.getContext().isFinishing())
            {
              aq.this.dom.Pwc.getContext().finish();
              AppMethodBeat.o(35523);
            }
          }
          else
          {
            paramAnonymousIntent = ReportUtil.d(localIntent.getExtras(), 0);
            ReportUtil.a(aq.this.dom.Pwc.getContext(), paramAnonymousIntent, true);
            if (!aq.this.dom.Pwc.getContext().isFinishing()) {
              aq.this.dom.Pwc.getContext().finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aq
 * JD-Core Version:    0.7.0.1
 */