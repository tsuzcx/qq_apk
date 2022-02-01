package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class w
{
  private static float vEt = 0.1F;
  
  public static void h(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255006);
    String str = paramcc.field_content;
    Object localObject = null;
    if (str != null) {
      localObject = k.b.aP(str, paramcc.field_reserved);
    }
    if (localObject != null)
    {
      paramcc = (com.tencent.mm.plugin.game.luggage.f.a)((k.b)localObject).aK(com.tencent.mm.plugin.game.luggage.f.a.class);
      if ((paramcc != null) && (!Util.isNullOrNil(paramcc.jumpUrl)))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramcc.jumpUrl);
        c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
    }
    AppMethodBeat.o(255006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */