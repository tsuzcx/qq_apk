package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class u$1
  implements View.OnClickListener
{
  u$1(u paramu) {}
  
  public final void onClick(View paramView)
  {
    new Intent().putExtra("composeType", 1);
    d.x(this.vkL.mContext, "qqmail", ".ui.ComposeUI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.1
 * JD-Core Version:    0.7.0.1
 */