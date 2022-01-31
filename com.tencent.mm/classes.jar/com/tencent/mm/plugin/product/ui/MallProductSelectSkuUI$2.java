package com.tencent.mm.plugin.product.ui;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class MallProductSelectSkuUI$2
  implements AdapterView.OnItemClickListener
{
  MallProductSelectSkuUI$2(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    AppMethodBeat.i(44106);
    Object localObject = (Pair)paramView.getTag();
    paramView = this.pwB;
    c localc = MallProductSelectSkuUI.b(this.pwB);
    String str = (String)((Pair)localObject).first;
    localObject = (String)((Pair)localObject).second;
    ab.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + (String)localObject + ")");
    if ((localc.pui.containsKey(str)) && (((String)localc.pui.get(str)).equals(localObject)))
    {
      localc.pui.remove(str);
      localc.pua = c.V(localc.pui);
      if (localc.puh != null) {
        paramAdapterView = (e)localc.puh.get(localc.pua);
      }
    }
    for (localc.pul = paramAdapterView;; localc.pul = ((e)localc.puh.get(localc.pua)))
    {
      localc.cbl();
      paramAdapterView = localc.pul;
      do
      {
        MallProductSelectSkuUI.a(paramView, paramAdapterView);
        MallProductSelectSkuUI.a(this.pwB);
        AppMethodBeat.o(44106);
        return;
        paramAdapterView = null;
        break;
        localc.pui.put(str, localObject);
        localc.pua = c.V(localc.pui);
        ab.d("MicroMsg.MallProductManager", "getSkuInfoId (" + localc.pua + ")");
      } while (localc.puh == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.2
 * JD-Core Version:    0.7.0.1
 */