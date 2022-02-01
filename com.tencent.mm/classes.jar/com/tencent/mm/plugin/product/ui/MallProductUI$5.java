package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;

final class MallProductUI$5
  implements AdapterView.OnItemClickListener
{
  MallProductUI$5(MallProductUI paramMallProductUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(67068);
    paramView = (m)paramView.getTag();
    paramAdapterView = MallProductUI.e(this.uyT);
    if ((paramView != null) && (paramView.uyw != null))
    {
      paramView = paramView.uyw;
      ad.i("MicroMsg.MallProductUI", "goProductUI type : " + paramView.type);
      switch (paramView.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(67068);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView.url);
      e.X(paramAdapterView.jgS, localIntent);
      AppMethodBeat.o(67068);
      return;
      paramView = paramView.data.replace("product_id=", "");
      localIntent = new Intent();
      localIntent.putExtra("key_product_id", paramView);
      localIntent.putExtra("key_product_scene", 6);
      d.b(paramAdapterView.jgS, "mall", ".product.ui.MallProductUI", localIntent);
      paramAdapterView.jgS.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.5
 * JD-Core Version:    0.7.0.1
 */