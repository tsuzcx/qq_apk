package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$h
  extends s.e
{
  public s$h(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(34600);
    paramView = (bi)paramView.getTag();
    parambl = new Intent();
    parambl.putExtra("geta8key_username", parama.getTalkerUserName());
    parambl.putExtra("rawUrl", paramView.eOT);
    d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
    AppMethodBeat.o(34600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.h
 * JD-Core Version:    0.7.0.1
 */