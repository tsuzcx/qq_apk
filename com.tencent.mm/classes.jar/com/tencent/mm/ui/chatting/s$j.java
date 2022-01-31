package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s$j
  extends s.e
{
  public s$j(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(30728);
    paramView = (az)paramView.getTag();
    int i = paramView.tid;
    parambi = paramView.fiM;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    int j = paramView.pageType;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.dGR);
      localIntent.putExtra("set_id", i);
      localIntent.putExtra("set_title", parambi);
      localIntent.putExtra("set_iconURL", str2);
      localIntent.putExtra("set_desc", str1);
      localIntent.putExtra("headurl", str3);
      localIntent.putExtra("pageType", j);
      d.b(parama.zJz.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", localIntent);
      AppMethodBeat.o(30728);
      return;
    }
    ab.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(30728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.j
 * JD-Core Version:    0.7.0.1
 */