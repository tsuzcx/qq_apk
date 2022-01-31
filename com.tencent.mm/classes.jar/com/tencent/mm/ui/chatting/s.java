package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s
{
  public static final class l
    extends s.e
  {
    public l(com.tencent.mm.ui.chatting.d.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(30730);
      paramView = (az)paramView.getTag();
      int i = paramView.tid;
      parambi = paramView.fiM;
      String str1 = paramView.desc;
      String str2 = paramView.iconUrl;
      String str3 = paramView.secondUrl;
      if (i != 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
        localIntent.putExtra("rawUrl", paramView.dGR);
        localIntent.putExtra("topic_id", i);
        localIntent.putExtra("topic_name", parambi);
        localIntent.putExtra("topic_desc", str1);
        localIntent.putExtra("topic_icon_url", str2);
        localIntent.putExtra("topic_ad_url", str3);
        localIntent.putExtra("extra_scence", 22);
        d.b(parama.zJz.getContext(), "emoji", ".ui.EmojiStoreTopicUI", localIntent);
        AppMethodBeat.o(30730);
        return;
      }
      ab.i("MicroMsg.DesignerClickListener", "topic id is zero.");
      AppMethodBeat.o(30730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */