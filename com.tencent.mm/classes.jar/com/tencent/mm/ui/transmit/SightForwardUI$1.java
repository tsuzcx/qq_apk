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
  
  public final void gZc()
  {
    AppMethodBeat.i(39482);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.afPJ.getContext(), LauncherUI.class).addFlags(67108864);
    SightForwardUI localSightForwardUI = this.afPJ;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localSightForwardUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localSightForwardUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localSightForwardUI, "com/tencent/mm/ui/transmit/SightForwardUI$1", "onDismiss", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.afPJ.finish();
    AppMethodBeat.o(39482);
  }
  
  public final void startChattingUI(String paramString)
  {
    AppMethodBeat.i(39481);
    Object localObject = new Intent(this.afPJ.getContext(), ChattingUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Chat_User", paramString);
    paramString = this.afPJ;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/transmit/SightForwardUI$1", "startChattingUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.afPJ.finish();
    AppMethodBeat.o(39481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SightForwardUI.1
 * JD-Core Version:    0.7.0.1
 */