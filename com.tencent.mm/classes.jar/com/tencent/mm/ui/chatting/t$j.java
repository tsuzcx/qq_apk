package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class t$j
  extends t.e
{
  public t$j(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(34602);
    paramView = (bk)paramView.getTag();
    int i = paramView.tid;
    parambv = paramView.hEQ;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    int j = paramView.pageType;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.fmn);
      localIntent.putExtra("set_id", i);
      localIntent.putExtra("set_title", parambv);
      localIntent.putExtra("set_iconURL", str2);
      localIntent.putExtra("set_desc", str1);
      localIntent.putExtra("headurl", str3);
      localIntent.putExtra("pageType", j);
      d.b(parama.Kkd.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
      AppMethodBeat.o(34602);
      return;
    }
    ae.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(34602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.j
 * JD-Core Version:    0.7.0.1
 */