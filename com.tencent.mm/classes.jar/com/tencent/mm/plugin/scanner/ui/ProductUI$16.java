package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.k;

final class ProductUI$16
  implements View.OnClickListener
{
  ProductUI$16(ProductUI paramProductUI, q.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81099);
    paramView = new Intent("android.intent.action.VIEW");
    k.a(this.qyh.getContext(), paramView, Uri.parse(this.qyj.field_playurl), "video/*");
    this.qyh.startActivity(paramView);
    AppMethodBeat.o(81099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.16
 * JD-Core Version:    0.7.0.1
 */