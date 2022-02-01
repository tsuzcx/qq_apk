package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.by;

public final class t$h
  extends t.e
{
  public t$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(34600);
    paramView = (by)paramView.getTag();
    paramca = new Intent();
    paramca.putExtra("geta8key_username", parama.getTalkerUserName());
    paramca.putExtra("rawUrl", paramView.ilh);
    c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.h
 * JD-Core Version:    0.7.0.1
 */