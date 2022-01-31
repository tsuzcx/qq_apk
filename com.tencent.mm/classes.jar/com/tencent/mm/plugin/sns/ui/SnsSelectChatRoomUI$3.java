package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;

final class SnsSelectChatRoomUI$3
  implements View.OnClickListener
{
  SnsSelectChatRoomUI$3(SnsSelectChatRoomUI paramSnsSelectChatRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145553);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ad)))
    {
      paramView = (ad)paramView.getTag();
      SnsSelectChatRoomUI.a(this.rUo, paramView);
    }
    AppMethodBeat.o(145553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectChatRoomUI.3
 * JD-Core Version:    0.7.0.1
 */