package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;

final class SelectConversationUI$30
  implements e.a
{
  SelectConversationUI$30(SelectConversationUI paramSelectConversationUI, Intent paramIntent, String paramString, View paramView) {}
  
  public final void B(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(35152);
    if (paramBoolean)
    {
      this.val$intent.putExtra("custom_send_text", paramString);
      SelectConversationUI.a(this.AAp, -1, this.val$intent);
      this.AAp.finish();
    }
    for (;;)
    {
      ((i)g.E(i.class)).a(this.hpi, this.val$view);
      AppMethodBeat.o(35152);
      return;
      SelectConversationUI.a(this.AAp, 0, this.val$intent);
      this.AAp.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.30
 * JD-Core Version:    0.7.0.1
 */