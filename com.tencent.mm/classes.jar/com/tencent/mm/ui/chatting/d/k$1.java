package com.tencent.mm.ui.chatting.d;

import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.cedit.api.c;

final class k$1
  implements View.OnLayoutChangeListener
{
  k$1(k paramk, c paramc, com.tencent.mm.plugin.gamelife.a.a parama, ChatFooter paramChatFooter) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(288652);
    paramInt1 = this.WIg.hZD();
    if (paramInt1 < 0)
    {
      AppMethodBeat.o(288652);
      return;
    }
    paramInt2 = com.tencent.mm.ci.a.fromDPToPix(this.WIj.fgR.WQv.getContext(), 52);
    Object localObject1 = null;
    paramView = (View)localObject1;
    if (!TextUtils.isEmpty(this.WIh.getTag()))
    {
      paramView = (View)localObject1;
      if (this.WIh.eAh() == 1) {
        paramView = String.format(" (%s)", new Object[] { this.WIh.getTag() });
      }
    }
    Object localObject2 = Util.nullAsNil(this.WIh.eAf().field_nickname);
    localObject1 = localObject2;
    if (paramView != null) {
      localObject1 = (String)localObject2 + paramView;
    }
    float f = Layout.getDesiredWidth((String)localObject1 + " : ", this.WIg.getPaint());
    localObject2 = new StringBuilder();
    localObject1 = this.WIh.eAf().field_nickname;
    if ((localObject1 != null) && (f > paramInt1 - paramInt2)) {
      if (paramView == null)
      {
        paramInt1 = 20;
        String str = g.hV((String)localObject1, paramInt1);
        localObject1 = str;
        if (Character.isHighSurrogate(str.charAt(str.length() - 1))) {
          localObject1 = str.substring(0, str.length() - 1);
        }
      }
    }
    for (localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append("...");; localObject1 = localObject2)
    {
      if (paramView != null) {
        ((StringBuilder)localObject1).append(paramView);
      }
      if (((StringBuilder)localObject1).length() != 0) {
        ((StringBuilder)localObject1).append(" : ");
      }
      this.WIi.a(this.WIj.fgR.getSelfUserName(), Boolean.FALSE, l.c(this.WIj.fgR.WQv.getContext(), (CharSequence)localObject1));
      this.WIg.removeOnLayoutChangeListener(this);
      AppMethodBeat.o(288652);
      return;
      paramInt1 = 12;
      break;
      ((StringBuilder)localObject2).append((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k.1
 * JD-Core Version:    0.7.0.1
 */