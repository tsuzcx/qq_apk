package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class t$i
  extends t.e
{
  public t$i(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(34601);
    paramView = (bq)paramView.getTag();
    int i = paramView.designerUIN;
    paramca = paramView.designerName;
    String str = paramView.designerRediretctUrl;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.fQR);
      localIntent.putExtra("uin", i);
      localIntent.putExtra("name", paramca);
      localIntent.putExtra("rediret_url", str);
      localIntent.putExtra("extra_scence", 22);
      c.b(parama.Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", localIntent);
    }
    AppMethodBeat.o(34601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.i
 * JD-Core Version:    0.7.0.1
 */