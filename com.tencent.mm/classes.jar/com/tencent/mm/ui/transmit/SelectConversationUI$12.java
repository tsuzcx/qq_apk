package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SelectConversationUI$12
  implements View.OnClickListener
{
  SelectConversationUI$12(SelectConversationUI paramSelectConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35136);
    if (SelectConversationUI.a(this.AAp))
    {
      SelectConversationUI.b(this.AAp);
      AppMethodBeat.o(35136);
      return;
    }
    paramView = this.AAp.getIntent().getStringExtra("Select_App_Id");
    if ((SelectConversationUI.c(this.AAp)) && (bo.isNullOrNil(paramView)))
    {
      SelectConversationUI.d(this.AAp);
      AppMethodBeat.o(35136);
      return;
    }
    SelectConversationUI.e(this.AAp);
    AppMethodBeat.o(35136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.12
 * JD-Core Version:    0.7.0.1
 */