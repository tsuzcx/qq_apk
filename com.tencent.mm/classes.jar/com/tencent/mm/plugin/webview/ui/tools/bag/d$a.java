package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$a
{
  public int EfJ;
  public int EfK;
  JSONObject EfL;
  String dDH;
  long hVU;
  public String id;
  int scene;
  public String url;
  
  public d$a()
  {
    AppMethodBeat.i(80445);
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(al.a.IDQ, null);
    ad.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      this.id = null;
      this.url = null;
      this.dDH = null;
      this.EfK = (a.ip(aj.getContext()) - b.Efb - b.Efc);
      this.EfJ = (b.Efa + aj.getContext().getResources().getDimensionPixelSize(2131167015));
      this.EfL = new JSONObject();
      ad.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.EfK), Integer.valueOf(this.EfJ) });
      AppMethodBeat.o(80445);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.url = ((JSONObject)localObject).getString("url");
      this.id = ((JSONObject)localObject).optString("id", com.tencent.mm.sdk.platformtools.ai.ee(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
      this.dDH = ((JSONObject)localObject).getString("icon");
      this.EfJ = ((JSONObject)localObject).getInt("pos_y");
      this.EfK = ((JSONObject)localObject).getInt("pos_x");
      this.hVU = ((JSONObject)localObject).getLong("last_active_time");
      this.EfL = ((JSONObject)localObject).getJSONObject("extras");
      this.scene = ((JSONObject)localObject).optInt("scene", 0);
      AppMethodBeat.o(80445);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80445);
    }
  }
  
  final void save()
  {
    AppMethodBeat.i(80446);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", bt.nullAsNil(this.id));
      ((JSONObject)localObject).put("url", bt.nullAsNil(this.url));
      ((JSONObject)localObject).put("icon", bt.nullAsNil(this.dDH));
      ((JSONObject)localObject).put("pos_y", this.EfJ);
      ((JSONObject)localObject).put("pos_x", this.EfK);
      ((JSONObject)localObject).put("last_active_time", this.hVU);
      ((JSONObject)localObject).put("extras", this.EfL);
      ((JSONObject)localObject).put("scene", this.scene);
      localObject = ((JSONObject)localObject).toString();
      g.ajD();
      g.ajC().ajl().set(al.a.IDQ, localObject);
      AppMethodBeat.o(80446);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d.a
 * JD-Core Version:    0.7.0.1
 */