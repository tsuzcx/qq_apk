package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONException;
import org.json.JSONObject;

public final class l$a
{
  String bVO;
  long ekr;
  String id;
  int rsB;
  int rsC;
  JSONObject rsD;
  int scene;
  public String url;
  
  public l$a()
  {
    g.DQ();
    Object localObject = (String)g.DP().Dz().get(ac.a.uzt, null);
    y.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
    if (bk.bl((String)localObject))
    {
      this.id = null;
      this.url = null;
      this.bVO = null;
      this.rsC = (a.fj(ae.getContext()) - b.rrl - b.rrm);
      this.rsB = (b.rrk + ae.getContext().getResources().getDimensionPixelSize(R.f.webview_bag_init_top_margin));
      this.rsD = new JSONObject();
      y.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.rsC), Integer.valueOf(this.rsB) });
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.url = ((JSONObject)localObject).getString("url");
      this.id = ((JSONObject)localObject).optString("id", ad.bB(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
      this.bVO = ((JSONObject)localObject).getString("icon");
      this.rsB = ((JSONObject)localObject).getInt("pos_y");
      this.rsC = ((JSONObject)localObject).getInt("pos_x");
      this.ekr = ((JSONObject)localObject).getLong("last_active_time");
      this.rsD = ((JSONObject)localObject).getJSONObject("extras");
      this.scene = ((JSONObject)localObject).optInt("scene", 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
    }
  }
  
  final void save()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", bk.pm(this.id));
      ((JSONObject)localObject).put("url", bk.pm(this.url));
      ((JSONObject)localObject).put("icon", bk.pm(this.bVO));
      ((JSONObject)localObject).put("pos_y", this.rsB);
      ((JSONObject)localObject).put("pos_x", this.rsC);
      ((JSONObject)localObject).put("last_active_time", this.ekr);
      ((JSONObject)localObject).put("extras", this.rsD);
      ((JSONObject)localObject).put("scene", this.scene);
      localObject = ((JSONObject)localObject).toString();
      g.DQ();
      g.DP().Dz().c(ac.a.uzt, localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.a
 * JD-Core Version:    0.7.0.1
 */