package com.tencent.mm.pluginsdk.ui.chat;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$38
  implements Animator.AnimatorListener
{
  ChatFooter$38(ChatFooter paramChatFooter) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(156074);
    ChatFooter.h(this.vXU).setVisibility(8);
    AppMethodBeat.o(156074);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(156073);
    if (!ChatFooter.ax(this.vXU))
    {
      ChatFooter.h(this.vXU).setVisibility(8);
      AppMethodBeat.o(156073);
      return;
    }
    ab.i("MicroMsg.ChatFooter", "animHideSendBtn onAnimationEnd!! cansend change:%s", new Object[] { Boolean.valueOf(ChatFooter.ax(this.vXU)) });
    this.vXU.doJ();
    AppMethodBeat.o(156073);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(156072);
    ChatFooter.h(this.vXU).setVisibility(0);
    AppMethodBeat.o(156072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.38
 * JD-Core Version:    0.7.0.1
 */