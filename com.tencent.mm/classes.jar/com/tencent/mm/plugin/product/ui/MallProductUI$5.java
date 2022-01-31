package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.y;

final class MallProductUI$5
  implements AdapterView.OnItemClickListener
{
  MallProductUI$5(MallProductUI paramMallProductUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (m)paramView.getTag();
    paramAdapterView = MallProductUI.e(this.mVg);
    if ((paramView != null) && (paramView.mUJ != null))
    {
      paramView = paramView.mUJ;
      y.i("MicroMsg.MallProductUI", "goProductUI type : " + paramView.type);
    }
    switch (paramView.type)
    {
    default: 
      return;
    case 0: 
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.url);
      d.b(paramAdapterView.fyk, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      return;
    }
    paramView = paramView.data.replace("product_id=", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_product_id", paramView);
    localIntent.putExtra("key_product_scene", 6);
    d.b(paramAdapterView.fyk, "mall", ".product.ui.MallProductUI", localIntent);
    paramAdapterView.fyk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.5
 * JD-Core Version:    0.7.0.1
 */