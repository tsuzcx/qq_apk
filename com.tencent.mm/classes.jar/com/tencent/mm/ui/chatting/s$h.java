package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class s$h
  extends s.e
{
  public s$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(34600);
    paramView = (bk)paramView.getTag();
    parambu = new Intent();
    parambu.putExtra("geta8key_username", parama.getTalkerUserName());
    parambu.putExtra("rawUrl", paramView.fkq);
    d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.h
 * JD-Core Version:    0.7.0.1
 */