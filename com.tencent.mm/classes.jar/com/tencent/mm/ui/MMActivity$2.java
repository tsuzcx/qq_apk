package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMActivity$2
  implements Runnable
{
  MMActivity$2(MMActivity paramMMActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(250258);
    MMActivity localMMActivity = this.adDD;
    Object localObject = this.adDD.getIntent();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/MMActivity$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localMMActivity, "com/tencent/mm/ui/MMActivity$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(250258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMActivity.2
 * JD-Core Version:    0.7.0.1
 */