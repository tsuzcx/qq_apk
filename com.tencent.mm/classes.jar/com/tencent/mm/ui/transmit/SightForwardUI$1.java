package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ChattingUI;

final class SightForwardUI$1
  implements b
{
  SightForwardUI$1(SightForwardUI paramSightForwardUI) {}
  
  public final void cng()
  {
    AppMethodBeat.i(35275);
    Intent localIntent = new Intent();
    localIntent.setClass(this.AAX.getContext(), LauncherUI.class).addFlags(67108864);
    this.AAX.startActivity(localIntent);
    this.AAX.finish();
    AppMethodBeat.o(35275);
  }
  
  public final void startChattingUI(String paramString)
  {
    AppMethodBeat.i(35274);
    Intent localIntent = new Intent(this.AAX.getContext(), ChattingUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("Chat_User", paramString);
    this.AAX.startActivity(localIntent);
    this.AAX.finish();
    AppMethodBeat.o(35274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI.1
 * JD-Core Version:    0.7.0.1
 */