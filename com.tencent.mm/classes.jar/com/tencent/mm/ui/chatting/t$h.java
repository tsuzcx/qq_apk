package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class t$h
  extends t.e
{
  public t$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(34600);
    paramView = (bk)paramView.getTag();
    parambv = new Intent();
    parambv.putExtra("geta8key_username", parama.getTalkerUserName());
    parambv.putExtra("rawUrl", paramView.fmn);
    d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.h
 * JD-Core Version:    0.7.0.1
 */