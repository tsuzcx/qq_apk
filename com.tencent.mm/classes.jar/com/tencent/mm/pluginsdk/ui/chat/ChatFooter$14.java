package com.tencent.mm.pluginsdk.ui.chat;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.tools.tips.TipsPopupWindow;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ChatFooter$14
  implements Runnable
{
  ChatFooter$14(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(245386);
    Object localObject1 = new int[2];
    Object localObject2 = ChatFooter.t(this.YiY).getContentView();
    ((View)localObject2).getLocationOnScreen((int[])localObject1);
    localObject1 = ((View)localObject2).findViewById(R.h.tip_triangle_iv);
    localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).leftMargin = MMApplicationContext.getResources().getDimensionPixelSize(R.f.Edge_2A);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    AppMethodBeat.o(245386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.14
 * JD-Core Version:    0.7.0.1
 */