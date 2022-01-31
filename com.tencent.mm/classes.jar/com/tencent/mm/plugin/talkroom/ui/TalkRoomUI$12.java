package com.tencent.mm.plugin.talkroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.w;

final class TalkRoomUI$12
  implements View.OnClickListener
{
  TalkRoomUI$12(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25917);
    paramView = this.tdT;
    aw.aaz();
    if (bo.a((Integer)c.Ru().get(144641, null), 0) > 0) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.tdT.onBackPressed();
      }
      AppMethodBeat.o(25917);
      return;
      i locali = new i(paramView, 2131493884);
      LinearLayout localLinearLayout = (LinearLayout)w.hM(ah.getContext()).inflate(2130970989, null);
      localLinearLayout.setMinimumWidth(10000);
      Button localButton = (Button)localLinearLayout.findViewById(2131828490);
      locali.setCanceledOnTouchOutside(true);
      locali.setOnDismissListener(new TalkRoomUI.17(paramView));
      locali.setCancelable(false);
      localButton.setOnClickListener(new TalkRoomUI.2(paramView, locali));
      locali.setContentView(localLinearLayout);
      locali.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.12
 * JD-Core Version:    0.7.0.1
 */