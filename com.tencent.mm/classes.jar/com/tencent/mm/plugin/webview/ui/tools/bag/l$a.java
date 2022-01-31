package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONException;
import org.json.JSONObject;

final class l$a
{
  String cDz;
  long fAH;
  String id;
  int scene;
  String url;
  int viH;
  int viI;
  JSONObject viJ;
  
  public l$a()
  {
    AppMethodBeat.i(8216);
    g.RM();
    Object localObject = (String)g.RL().Ru().get(ac.a.yKh, null);
    ab.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
    if (bo.isNullOrNil((String)localObject))
    {
      this.id = null;
      this.url = null;
      this.cDz = null;
      this.viI = (a.gw(ah.getContext()) - b.vhq - b.vhr);
      this.viH = (b.vhp + ah.getContext().getResources().getDimensionPixelSize(2131428835));
      this.viJ = new JSONObject();
      ab.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.viI), Integer.valueOf(this.viH) });
      AppMethodBeat.o(8216);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.url = ((JSONObject)localObject).getString("url");
      this.id = ((JSONObject)localObject).optString("id", ag.cE(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
      this.cDz = ((JSONObject)localObject).getString("icon");
      this.viH = ((JSONObject)localObject).getInt("pos_y");
      this.viI = ((JSONObject)localObject).getInt("pos_x");
      this.fAH = ((JSONObject)localObject).getLong("last_active_time");
      this.viJ = ((JSONObject)localObject).getJSONObject("extras");
      this.scene = ((JSONObject)localObject).optInt("scene", 0);
      AppMethodBeat.o(8216);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(8216);
    }
  }
  
  final void save()
  {
    AppMethodBeat.i(8217);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", bo.nullAsNil(this.id));
      ((JSONObject)localObject).put("url", bo.nullAsNil(this.url));
      ((JSONObject)localObject).put("icon", bo.nullAsNil(this.cDz));
      ((JSONObject)localObject).put("pos_y", this.viH);
      ((JSONObject)localObject).put("pos_x", this.viI);
      ((JSONObject)localObject).put("last_active_time", this.fAH);
      ((JSONObject)localObject).put("extras", this.viJ);
      ((JSONObject)localObject).put("scene", this.scene);
      localObject = ((JSONObject)localObject).toString();
      g.RM();
      g.RL().Ru().set(ac.a.yKh, localObject);
      AppMethodBeat.o(8217);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
      AppMethodBeat.o(8217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.a
 * JD-Core Version:    0.7.0.1
 */