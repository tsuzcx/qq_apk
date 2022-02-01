package com.tencent.mm.ui.conversation;

import android.graphics.Point;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.conversation.presenter.d;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$5
  implements AdapterView.OnItemLongClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$5(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI, Point paramPoint) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38550);
    paramAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).anT(paramInt);
    d locald = EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.Qfj, paramAdapterView);
    if (locald == null)
    {
      AppMethodBeat.o(38550);
      return false;
    }
    boolean bool = locald.a(paramView, this.Qfk, paramInt, paramLong, paramAdapterView);
    AppMethodBeat.o(38550);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.5
 * JD-Core Version:    0.7.0.1
 */