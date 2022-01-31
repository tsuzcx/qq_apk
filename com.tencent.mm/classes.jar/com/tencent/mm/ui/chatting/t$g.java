package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.aw;

public final class t$g
  extends t.d
{
  public t$g(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    parambi = new Intent();
    parambi.putExtra("geta8key_username", parama.getTalkerUserName());
    parambi.putExtra("rawUrl", paramView.cQF);
    d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.g
 * JD-Core Version:    0.7.0.1
 */