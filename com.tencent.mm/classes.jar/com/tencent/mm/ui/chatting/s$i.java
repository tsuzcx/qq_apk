package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$i
  extends s.e
{
  public s$i(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(34601);
    paramView = (bi)paramView.getTag();
    int i = paramView.designerUIN;
    parambl = paramView.designerName;
    String str = paramView.designerRediretctUrl;
    if (i != 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      localIntent.putExtra("rawUrl", paramView.eOT);
      localIntent.putExtra("uin", i);
      localIntent.putExtra("name", parambl);
      localIntent.putExtra("rediret_url", str);
      localIntent.putExtra("extra_scence", 22);
      d.b(parama.GzJ.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", localIntent);
    }
    AppMethodBeat.o(34601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.i
 * JD-Core Version:    0.7.0.1
 */