package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;

final class x$1
  implements View.OnClickListener
{
  x$1(x paramx) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(1);
    s.hm("gh_43f2581f6fd6");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_is_latest", true);
    localIntent.putExtra("rank_id", "#");
    localIntent.putExtra("key_only_show_latest_rank", true);
    localIntent.putExtra("app_username", r.gV("gh_43f2581f6fd6"));
    localIntent.putExtra("device_type", 1);
    com.tencent.mm.br.d.b(paramView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x.1
 * JD-Core Version:    0.7.0.1
 */