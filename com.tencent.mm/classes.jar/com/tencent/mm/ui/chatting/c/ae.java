package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class ae
  extends a
  implements v
{
  public final void dBY()
  {
    AppMethodBeat.i(31630);
    Intent localIntent = this.caz.zJz.getContext().getIntent();
    if (localIntent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3)
    {
      AppMethodBeat.o(31630);
      return;
    }
    localIntent.setClass(this.caz.zJz.getContext(), SendAppMessageWrapperUI.class);
    localIntent.putExtra("Select_Conv_User", this.caz.getTalkerUserName());
    this.caz.a(localIntent, 228, new ae.1(this, localIntent));
    AppMethodBeat.o(31630);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31629);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(31629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ae
 * JD-Core Version:    0.7.0.1
 */