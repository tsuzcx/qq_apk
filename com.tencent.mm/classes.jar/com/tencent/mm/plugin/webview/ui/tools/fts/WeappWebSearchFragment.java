package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeappWebSearchFragment
  extends Fragment
{
  private String cJr;
  private LinearLayout elj;
  private ak handler;
  private int scene = 201;
  private e vjC;
  private com.tencent.mm.plugin.webview.fts.d.a vjD;
  MMWebViewWithJsApi vmb;
  
  private void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(8623);
    ArrayList localArrayList = new ArrayList();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    String str3 = paramBundle.getString("items");
    try
    {
      JSONArray localJSONArray = new JSONArray(str3);
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        y localy;
        if (localJSONObject != null)
        {
          localy = new y();
          localy.iconUrl = localJSONObject.optString("icon");
          localy.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label155;
          }
        }
        label155:
        for (boolean bool = true;; bool = false)
        {
          localy.gDG = bool;
          localy.desc = localJSONObject.optString("desc");
          localArrayList.add(localy);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.WebSearch.WeappWebSearchFragment", bo.l(localJSONException));
      ab.v("MicroMsg.WebSearch.WeappWebSearchFragment", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((h)g.E(h.class)).a(getActivity(), str1, str2, localArrayList, new WeappWebSearchFragment.9(this)));
      }
      AppMethodBeat.o(8623);
    }
  }
  
  protected final boolean A(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8622);
    Object localObject1;
    int i;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(8622);
      return false;
    case 142: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
      i = paramBundle.getInt("fts_key_is_expired", 1);
      int j = paramBundle.getInt("fts_key_is_preload", 0);
      this.handler.post(new WeappWebSearchFragment.2(this, (String)localObject1, paramInt, i, j));
    }
    for (;;)
    {
      AppMethodBeat.o(8622);
      return true;
      localObject1 = new HashMap();
      Object localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((Map)localObject1).put(str, paramBundle.get(str));
      }
      this.handler.post(new WeappWebSearchFragment.3(this, (Map)localObject1));
      continue;
      localObject1 = paramBundle.getString("fts_key_json_data");
      localObject2 = paramBundle.getString("fts_key_req_id");
      boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
      paramBundle = paramBundle.getBundle("fts_key_data");
      this.handler.post(new WeappWebSearchFragment.4(this, paramBundle, (String)localObject1, bool, (String)localObject2));
      continue;
      paramInt = paramBundle.getInt("fts_key_ret", 0);
      paramBundle = paramBundle.getString("fts_key_data");
      this.handler.post(new WeappWebSearchFragment.5(this, paramInt, paramBundle));
      continue;
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
      i = paramBundle.getInt("fts_key_is_cache_data", 0);
      this.handler.post(new WeappWebSearchFragment.6(this, paramInt, (String)localObject1, i));
      continue;
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new WeappWebSearchFragment.7(this, paramBundle));
      continue;
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new WeappWebSearchFragment.8(this, (String)localObject1, paramInt));
      continue;
      this.vjC.b(paramBundle, this.scene);
      continue;
      this.vjC.ar(paramBundle);
      continue;
      this.vjC.as(paramBundle);
      continue;
      this.vjC.at(paramBundle);
      continue;
      paramBundle = paramBundle.getString("fts_key_json_data");
      if (getJsapi() != null)
      {
        try
        {
          getJsapi().aU(new JSONObject(paramBundle));
        }
        catch (JSONException paramBundle)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.WeappWebSearchFragment", paramBundle, "", new Object[0]);
        }
        continue;
        aq(paramBundle);
        continue;
        com.tencent.mm.plugin.websearch.widget.view.a.daf().JA(paramBundle.getInt("actionSheetId"));
        continue;
        localObject1 = this.vjC;
        if (localObject1 != null)
        {
          ((e)localObject1).au(paramBundle);
        }
        else
        {
          ab.e("MicroMsg.WebSearch.WeappWebSearchFragment", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
          getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
          continue;
          getJsapi().ay(paramBundle);
        }
      }
    }
  }
  
  public final d getJsapi()
  {
    AppMethodBeat.i(8624);
    if (this.vmb != null)
    {
      d locald = this.vmb.getJsapi();
      AppMethodBeat.o(8624);
      return locald;
    }
    AppMethodBeat.o(8624);
    return null;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(8618);
    super.onActivityCreated(paramBundle);
    AppMethodBeat.o(8618);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(8619);
    this.handler = new ak();
    this.vmb = ((MMWebViewWithJsApi)f.a.vsl.dz(getContext()));
    this.vmb.setWebViewClient(new WeappWebSearchFragment.1(this, this.vmb));
    this.vjD = new com.tencent.mm.plugin.webview.fts.d.a(this.vmb);
    this.vjC = new e(((h)g.E(h.class)).a(getContext(), this.vjD));
    this.cJr = getArguments().getString("url");
    if (!TextUtils.isEmpty(this.cJr)) {
      this.vmb.loadUrl(this.cJr);
    }
    this.elj = ((LinearLayout)paramLayoutInflater.inflate(2130971295, paramViewGroup, false));
    this.elj.addView(this.vmb);
    paramLayoutInflater = this.elj;
    AppMethodBeat.o(8619);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8620);
    super.onDestroy();
    try
    {
      this.vmb.destroy();
      this.vmb.setWebChromeClient(null);
      this.vmb.setWebViewClient(null);
      this.vmb.setOnTouchListener(null);
      this.vmb.setOnLongClickListener(null);
      this.vmb.setVisibility(8);
      this.vmb.removeAllViews();
      this.vmb.clearView();
      this.vmb = null;
      this.vjC.onDestroy();
      AppMethodBeat.o(8620);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebSearch.WeappWebSearchFragment", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(8620);
    }
  }
  
  protected final boolean z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8621);
    switch (paramInt)
    {
    default: 
      ((FTSSOSHomeWebViewUI)getActivity()).l(paramInt, paramBundle);
      AppMethodBeat.o(8621);
      return true;
    }
    boolean bool = A(paramInt, paramBundle);
    AppMethodBeat.o(8621);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment
 * JD-Core Version:    0.7.0.1
 */