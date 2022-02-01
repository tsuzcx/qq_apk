package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$l
  extends s.e
{
  public s$l(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(34604);
    paramView = (bi)paramView.getTag();
    int i = paramView.tid;
    parambl = paramView.gJt;
    String str1 = paramView.desc;
    String str2 = paramView.iconUrl;
    String str3 = paramView.secondUrl;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.eOT);
      localIntent.putExtra("topic_id", i);
      localIntent.putExtra("topic_name", parambl);
      localIntent.putExtra("topic_desc", str1);
      localIntent.putExtra("topic_icon_url", str2);
      localIntent.putExtra("topic_ad_url", str3);
      localIntent.putExtra("extra_scence", 22);
      d.b(parama.GzJ.getContext(), "emoji", ".ui.EmojiStoreTopicUI", localIntent);
      AppMethodBeat.o(34604);
      return;
    }
    ad.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    AppMethodBeat.o(34604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.l
 * JD-Core Version:    0.7.0.1
 */