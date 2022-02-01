package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class s$j
  extends s.e
{
  public s$j(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(34602);
    paramView = (bk)paramView.getTag();
    int i = paramView.tid;
    parambu = paramView.hCc;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    int j = paramView.pageType;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.fkq);
      localIntent.putExtra("set_id", i);
      localIntent.putExtra("set_title", parambu);
      localIntent.putExtra("set_iconURL", str2);
      localIntent.putExtra("set_desc", str1);
      localIntent.putExtra("headurl", str3);
      localIntent.putExtra("pageType", j);
      d.b(parama.JOR.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
      AppMethodBeat.o(34602);
      return;
    }
    ad.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(34602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.j
 * JD-Core Version:    0.7.0.1
 */