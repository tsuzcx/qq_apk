package com.tencent.mm.plugin.product.ui;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class MallProductSelectSkuUI$2
  implements AdapterView.OnItemClickListener
{
  MallProductSelectSkuUI$2(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    Object localObject = (Pair)paramView.getTag();
    paramView = this.mUv;
    c localc = MallProductSelectSkuUI.b(this.mUv);
    String str = (String)((Pair)localObject).first;
    localObject = (String)((Pair)localObject).second;
    y.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + (String)localObject + ")");
    if ((localc.mSb.containsKey(str)) && (((String)localc.mSb.get(str)).equals(localObject)))
    {
      localc.mSb.remove(str);
      localc.mRT = c.G(localc.mSb);
      if (localc.mSa != null) {
        paramAdapterView = (e)localc.mSa.get(localc.mRT);
      }
    }
    for (localc.mSe = paramAdapterView;; localc.mSe = ((e)localc.mSa.get(localc.mRT)))
    {
      localc.bsf();
      paramAdapterView = localc.mSe;
      do
      {
        MallProductSelectSkuUI.a(paramView, paramAdapterView);
        MallProductSelectSkuUI.a(this.mUv);
        return;
        paramAdapterView = null;
        break;
        localc.mSb.put(str, localObject);
        localc.mRT = c.G(localc.mSb);
        y.d("MicroMsg.MallProductManager", "getSkuInfoId (" + localc.mRT + ")");
      } while (localc.mSa == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.2
 * JD-Core Version:    0.7.0.1
 */