package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class v$l
  extends v.e
{
  public v$l(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(34604);
    paramView = (bz)paramView.getTag();
    int i = paramView.tid;
    paramcc = paramView.nTr;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.kLg);
      localIntent.putExtra("topic_id", i);
      localIntent.putExtra("topic_name", paramcc);
      localIntent.putExtra("topic_desc", str1);
      localIntent.putExtra("topic_icon_url", str2);
      localIntent.putExtra("topic_ad_url", str3);
      localIntent.putExtra("extra_scence", 22);
      c.b(parama.aezO.getContext(), "emoji", ".ui.EmojiStoreTopicUI", localIntent);
      AppMethodBeat.o(34604);
      return;
    }
    Log.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(34604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.l
 * JD-Core Version:    0.7.0.1
 */