package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;

public final class t$l
  extends t.d
{
  public t$l(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    h.a(parama.vtz.getContext(), parama.vtz.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable_msg), "", parama.vtz.getMMResources().getString(R.l.emoji_chatting_reward_tips_enable), parama.vtz.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable), new t.l.1(this), new t.l.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.l
 * JD-Core Version:    0.7.0.1
 */