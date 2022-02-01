package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$a
{
  public int ExM;
  public int ExN;
  JSONObject ExO;
  String dEM;
  long hYM;
  public String id;
  int scene;
  public String url;
  
  public d$a()
  {
    AppMethodBeat.i(80445);
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(am.a.IYq, null);
    ae.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      this.id = null;
      this.url = null;
      this.dEM = null;
      this.ExN = (a.iu(ak.getContext()) - b.Exe - b.Exf);
      this.ExM = (b.Exd + ak.getContext().getResources().getDimensionPixelSize(2131167015));
      this.ExO = new JSONObject();
      ae.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.ExN), Integer.valueOf(this.ExM) });
      AppMethodBeat.o(80445);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.url = ((JSONObject)localObject).getString("url");
      this.id = ((JSONObject)localObject).optString("id", com.tencent.mm.sdk.platformtools.aj.ej(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
      this.dEM = ((JSONObject)localObject).getString("icon");
      this.ExM = ((JSONObject)localObject).getInt("pos_y");
      this.ExN = ((JSONObject)localObject).getInt("pos_x");
      this.hYM = ((JSONObject)localObject).getLong("last_active_time");
      this.ExO = ((JSONObject)localObject).getJSONObject("extras");
      this.scene = ((JSONObject)localObject).optInt("scene", 0);
      AppMethodBeat.o(80445);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80445);
    }
  }
  
  final void save()
  {
    AppMethodBeat.i(80446);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", bu.nullAsNil(this.id));
      ((JSONObject)localObject).put("url", bu.nullAsNil(this.url));
      ((JSONObject)localObject).put("icon", bu.nullAsNil(this.dEM));
      ((JSONObject)localObject).put("pos_y", this.ExM);
      ((JSONObject)localObject).put("pos_x", this.ExN);
      ((JSONObject)localObject).put("last_active_time", this.hYM);
      ((JSONObject)localObject).put("extras", this.ExO);
      ((JSONObject)localObject).put("scene", this.scene);
      localObject = ((JSONObject)localObject).toString();
      g.ajS();
      g.ajR().ajA().set(am.a.IYq, localObject);
      AppMethodBeat.o(80446);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d.a
 * JD-Core Version:    0.7.0.1
 */