package com.tencent.mm.ui.conversation;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$8
  implements View.OnClickListener
{
  h$8(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34360);
    if ((h.f(this.Akm) == null) || (h.f(this.Akm).getOnItemClickListener() == null))
    {
      ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
      AppMethodBeat.o(34360);
      return;
    }
    if (paramView.getTag() == null)
    {
      ab.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
      AppMethodBeat.o(34360);
      return;
    }
    if (!this.Akm.zEj)
    {
      ab.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
      AppMethodBeat.o(34360);
      return;
    }
    h.f localf = (h.f)paramView.getTag();
    int i = localf.position;
    int j = h.f(this.Akm).getHeaderViewsCount();
    h.f(this.Akm).getOnItemClickListener().onItemClick(h.f(this.Akm), paramView, i + j, this.Akm.getItemId(localf.position));
    AppMethodBeat.o(34360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.8
 * JD-Core Version:    0.7.0.1
 */