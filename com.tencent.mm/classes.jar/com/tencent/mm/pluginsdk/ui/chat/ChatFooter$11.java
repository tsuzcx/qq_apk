package com.tencent.mm.pluginsdk.ui.chat;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.ArrayList;

final class ChatFooter$11
  implements View.OnClickListener
{
  ChatFooter$11(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    int j = -1;
    AppMethodBeat.i(31504);
    Object localObject1 = ChatFooter.r(this.Cff);
    ChatFooter localChatFooter = this.Cff;
    int i = j;
    if (localChatFooter.getAppPanelUnCertainEnterArrayList() != null)
    {
      i = j;
      if (localChatFooter.getAppPanelUnCertainEnterArrayList().size() > 0)
      {
        i = 0;
        int k;
        for (j = -1; i < localChatFooter.getAppPanelUnCertainEnterArrayList().size(); j = k)
        {
          Object localObject2 = (a.a)localChatFooter.getAppPanelUnCertainEnterArrayList().get(i);
          k = j;
          if (((a.a)localObject2).Cbj == 1)
          {
            k = j;
            if (!ChatFooter.aCe(((a.a)localObject2).Cbi))
            {
              localObject2 = ((a.a)localObject2).Cbi;
              ax.aFC("plus_uncertain_enter").edit().putBoolean((String)localObject2, true);
              k = j;
              if (j == -1) {
                k = i;
              }
            }
          }
          i += 1;
        }
        i = j;
      }
    }
    localChatFooter.CbF.setVisibility(8);
    ((ImageButton)localObject1).setTag(Integer.valueOf(i));
    this.Cff.fu(paramView);
    if ((u.aro().booleanValue()) && (this.Cff.CcA != null))
    {
      paramView = this.Cff.CcA;
      localObject1 = Boolean.TRUE;
      paramView.a((Boolean)localObject1, (Boolean)localObject1);
    }
    AppMethodBeat.o(31504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.11
 * JD-Core Version:    0.7.0.1
 */