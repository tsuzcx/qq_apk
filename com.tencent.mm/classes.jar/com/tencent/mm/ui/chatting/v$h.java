package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class v$h
  extends v.e
{
  public v$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(34600);
    paramView = (bz)paramView.getTag();
    paramcc = new Intent();
    paramcc.putExtra("geta8key_username", parama.getTalkerUserName());
    paramcc.putExtra("rawUrl", paramView.kLg);
    c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.h
 * JD-Core Version:    0.7.0.1
 */