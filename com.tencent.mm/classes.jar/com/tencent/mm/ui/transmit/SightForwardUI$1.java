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
  
  public final void eWf()
  {
    AppMethodBeat.i(39482);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.QAz.getContext(), LauncherUI.class).addFlags(67108864);
    SightForwardUI localSightForwardUI = this.QAz;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localSightForwardUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localSightForwardUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localSightForwardUI, "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.QAz.finish();
    AppMethodBeat.o(39482);
  }
  
  public final void startChattingUI(String paramString)
  {
    AppMethodBeat.i(39481);
    Object localObject = new Intent(this.QAz.getContext(), ChattingUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Chat_User", paramString);
    paramString = this.QAz;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.QAz.finish();
    AppMethodBeat.o(39481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI.1
 * JD-Core Version:    0.7.0.1
 */