package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s$h
  extends s.e
{
  public s$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(30726);
    paramView = (az)paramView.getTag();
    parambi = new Intent();
    parambi.putExtra("geta8key_username", parama.getTalkerUserName());
    parambi.putExtra("rawUrl", paramView.dGR);
    d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
    AppMethodBeat.o(30726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.h
 * JD-Core Version:    0.7.0.1
 */