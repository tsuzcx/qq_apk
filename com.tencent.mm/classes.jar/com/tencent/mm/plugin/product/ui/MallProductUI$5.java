package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class MallProductUI$5
  implements AdapterView.OnItemClickListener
{
  MallProductUI$5(MallProductUI paramMallProductUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44161);
    paramView = (m)paramView.getTag();
    paramAdapterView = MallProductUI.e(this.pxl);
    if ((paramView != null) && (paramView.pwO != null))
    {
      paramView = paramView.pwO;
      ab.i("MicroMsg.MallProductUI", "goProductUI type : " + paramView.type);
      switch (paramView.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44161);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.url);
      d.b(paramAdapterView.gQx, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(44161);
      return;
      paramView = paramView.data.replace("product_id=", "");
      localIntent = new Intent();
      localIntent.putExtra("key_product_id", paramView);
      localIntent.putExtra("key_product_scene", 6);
      d.b(paramAdapterView.gQx, "mall", ".product.ui.MallProductUI", localIntent);
      paramAdapterView.gQx.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.5
 * JD-Core Version:    0.7.0.1
 */