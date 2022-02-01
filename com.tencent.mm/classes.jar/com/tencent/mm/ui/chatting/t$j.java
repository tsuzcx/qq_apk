package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class t$j
  extends t.e
{
  public t$j(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(34602);
    paramView = (bq)paramView.getTag();
    int i = paramView.tid;
    paramca = paramView.iyW;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    int j = paramView.pageType;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.fQR);
      localIntent.putExtra("set_id", i);
      localIntent.putExtra("set_title", paramca);
      localIntent.putExtra("set_iconURL", str2);
      localIntent.putExtra("set_desc", str1);
      localIntent.putExtra("headurl", str3);
      localIntent.putExtra("pageType", j);
      c.b(parama.Pwc.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
      AppMethodBeat.o(34602);
      return;
    }
    Log.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(34602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.j
 * JD-Core Version:    0.7.0.1
 */