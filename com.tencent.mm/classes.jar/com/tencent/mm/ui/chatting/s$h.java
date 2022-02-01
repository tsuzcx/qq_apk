package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bj;

public final class s$h
  extends s.e
{
  public s$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(34600);
    paramView = (bj)paramView.getTag();
    parambo = new Intent();
    parambo.putExtra("geta8key_username", parama.getTalkerUserName());
    parambo.putExtra("rawUrl", paramView.eSb);
    d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.h
 * JD-Core Version:    0.7.0.1
 */