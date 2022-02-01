package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$a
{
  public int Jlf;
  public int Jlg;
  JSONObject Jlh;
  long iTK;
  String icon;
  public String id;
  int scene;
  public String url;
  
  public d$a()
  {
    AppMethodBeat.i(80445);
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(ar.a.OgN, null);
    Log.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      this.id = null;
      this.url = null;
      this.icon = null;
      this.Jlg = (a.jn(MMApplicationContext.getContext()) - b.Jkx - b.Jky);
      this.Jlf = (b.Jkw + MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167150));
      this.Jlh = new JSONObject();
      Log.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.Jlg), Integer.valueOf(this.Jlf) });
      AppMethodBeat.o(80445);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.url = ((JSONObject)localObject).getString("url");
      this.id = ((JSONObject)localObject).optString("id", MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
      this.icon = ((JSONObject)localObject).getString("icon");
      this.Jlf = ((JSONObject)localObject).getInt("pos_y");
      this.Jlg = ((JSONObject)localObject).getInt("pos_x");
      this.iTK = ((JSONObject)localObject).getLong("last_active_time");
      this.Jlh = ((JSONObject)localObject).getJSONObject("extras");
      this.scene = ((JSONObject)localObject).optInt("scene", 0);
      AppMethodBeat.o(80445);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80445);
    }
  }
  
  final void save()
  {
    AppMethodBeat.i(80446);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", Util.nullAsNil(this.id));
      ((JSONObject)localObject).put("url", Util.nullAsNil(this.url));
      ((JSONObject)localObject).put("icon", Util.nullAsNil(this.icon));
      ((JSONObject)localObject).put("pos_y", this.Jlf);
      ((JSONObject)localObject).put("pos_x", this.Jlg);
      ((JSONObject)localObject).put("last_active_time", this.iTK);
      ((JSONObject)localObject).put("extras", this.Jlh);
      ((JSONObject)localObject).put("scene", this.scene);
      localObject = ((JSONObject)localObject).toString();
      g.aAi();
      g.aAh().azQ().set(ar.a.OgN, localObject);
      AppMethodBeat.o(80446);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(80446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d.a
 * JD-Core Version:    0.7.0.1
 */