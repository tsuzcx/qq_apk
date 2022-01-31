package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;

final class ChatFooterCustom$3
  implements View.OnClickListener
{
  ChatFooterCustom$3(ChatFooterCustom paramChatFooterCustom) {}
  
  public final void onClick(View paramView)
  {
    ChatFooterCustom.d(this.vit).cCw();
    paramView = (ImageView)paramView;
    int i;
    int j;
    if (paramView.getTag() == null)
    {
      paramView.setTag(new Object());
      paramView.setImageResource(R.g.mmfooter_listtotext_arrow2);
      i = 0;
      if (i < ChatFooterCustom.e(this.vit))
      {
        paramView = ChatFooterCustom.f(this.vit).getChildAt(i);
        if (i >= 3) {}
        for (j = 0;; j = 8)
        {
          paramView.setVisibility(j);
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramView.setTag(null);
      paramView.setImageResource(R.g.mmfooter_listtotext_arrow1);
      i = 0;
      if (i < ChatFooterCustom.e(this.vit))
      {
        paramView = ChatFooterCustom.f(this.vit).getChildAt(i);
        if (i < 3) {}
        for (j = 0;; j = 8)
        {
          paramView.setVisibility(j);
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChatFooterCustom.3
 * JD-Core Version:    0.7.0.1
 */