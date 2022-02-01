package com.tencent.mm.plugin.talkroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.y;

final class TalkRoomUI$12
  implements View.OnClickListener
{
  TalkRoomUI$12(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29600);
    paramView = this.yKo;
    az.arV();
    if (bt.a((Integer)c.afk().get(144641, null), 0) > 0) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.yKo.onBackPressed();
      }
      AppMethodBeat.o(29600);
      return;
      i locali = new i(paramView, 2131821726);
      LinearLayout localLinearLayout = (LinearLayout)y.js(aj.getContext()).inflate(2131495745, null);
      localLinearLayout.setMinimumWidth(10000);
      Button localButton = (Button)localLinearLayout.findViewById(2131300871);
      locali.setCanceledOnTouchOutside(true);
      locali.setOnDismissListener(new TalkRoomUI.17(paramView));
      locali.setCancelable(false);
      localButton.setOnClickListener(new TalkRoomUI.2(paramView, locali));
      locali.setContentView(localLinearLayout);
      locali.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.12
 * JD-Core Version:    0.7.0.1
 */