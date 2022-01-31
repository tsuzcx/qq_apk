package com.tencent.mm.plugin.talkroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.y;

final class TalkRoomUI$12
  implements View.OnClickListener
{
  TalkRoomUI$12(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.pCk;
    au.Hx();
    if (bk.a((Integer)c.Dz().get(144641, null), 0) > 0) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.pCk.onBackPressed();
      }
      return;
      i locali = new i(paramView, R.m.mmdialog);
      LinearLayout localLinearLayout = (LinearLayout)y.gt(ae.getContext()).inflate(R.i.talkroom_welcome_ui, null);
      localLinearLayout.setMinimumWidth(10000);
      Button localButton = (Button)localLinearLayout.findViewById(R.h.i_know_btn);
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