package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
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
  private e Bki;
  private com.tencent.mm.plugin.webview.fts.d.a Bkj;
  MMWebViewWithJsApi Bmn;
  private String dAl;
  private LinearLayout fyb;
  private ap handler;
  private int scene = 201;
  
  private void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(80794);
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
            break label154;
          }
        }
        label154:
        for (boolean bool = true;; bool = false)
        {
          localy.ira = bool;
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
      ad.e("MicroMsg.WebSearch.WeappWebSearchFragment", bt.m(localJSONException));
      ad.v("MicroMsg.WebSearch.WeappWebSearchFragment", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getActivity(), str1, str2, localArrayList, new x()
        {
          public final void io(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80788);
            if (WeappWebSearchFragment.this.getJsapi() != null) {
              WeappWebSearchFragment.this.getJsapi().it(paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(80788);
          }
        }));
      }
      AppMethodBeat.o(80794);
    }
  }
  
  public final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    AppMethodBeat.i(188101);
    if (this.Bmn != null)
    {
      com.tencent.mm.plugin.webview.c.f localf = this.Bmn.getJsapi();
      AppMethodBeat.o(188101);
      return localf;
    }
    AppMethodBeat.o(188101);
    return null;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(80789);
    super.onActivityCreated(paramBundle);
    AppMethodBeat.o(80789);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(80790);
    this.handler = new ap();
    this.Bmn = ((MMWebViewWithJsApi)f.a.Bud.eg(getContext()));
    this.Bmn.setWebViewClient(new k(this.Bmn)
    {
      public final void a(com.tencent.mm.plugin.webview.stub.e paramAnonymouse, com.tencent.mm.plugin.webview.e.g paramAnonymousg)
      {
        AppMethodBeat.i(188100);
        try
        {
          super.a(paramAnonymouse, paramAnonymousg);
          if (WeappWebSearchFragment.a(WeappWebSearchFragment.this) != null) {
            WeappWebSearchFragment.a(WeappWebSearchFragment.this).AQP = WeappWebSearchFragment.b(WeappWebSearchFragment.this).getJsapi();
          }
          AppMethodBeat.o(188100);
          return;
        }
        catch (Exception paramAnonymouse)
        {
          ad.printErrStackTrace("MicroMsg.WebSearch.WeappWebSearchFragment", paramAnonymouse, "", new Object[0]);
          AppMethodBeat.o(188100);
        }
      }
      
      public final m beG()
      {
        AppMethodBeat.i(80780);
        m local1 = new m()
        {
          public final boolean f(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
          {
            AppMethodBeat.i(80778);
            switch (paramAnonymous2Int)
            {
            }
            for (;;)
            {
              boolean bool = super.f(paramAnonymous2Int, paramAnonymous2Bundle);
              AppMethodBeat.o(80778);
              return bool;
              WeappWebSearchFragment.this.y(paramAnonymous2Int, paramAnonymous2Bundle);
            }
          }
        };
        AppMethodBeat.o(80780);
        return local1;
      }
    });
    this.Bkj = new com.tencent.mm.plugin.webview.fts.d.a(this.Bmn);
    this.Bki = new e(((com.tencent.mm.plugin.websearch.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(getContext(), this.Bkj));
    this.dAl = getArguments().getString("url");
    if (!TextUtils.isEmpty(this.dAl)) {
      this.Bmn.loadUrl(this.dAl);
    }
    this.fyb = ((LinearLayout)paramLayoutInflater.inflate(2131496077, paramViewGroup, false));
    this.fyb.addView(this.Bmn);
    paramLayoutInflater = this.fyb;
    AppMethodBeat.o(80790);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80791);
    super.onDestroy();
    try
    {
      this.Bmn.destroy();
      this.Bmn.setWebChromeClient(null);
      this.Bmn.setWebViewClient(null);
      this.Bmn.setOnTouchListener(null);
      this.Bmn.setOnLongClickListener(null);
      this.Bmn.setVisibility(8);
      this.Bmn.removeAllViews();
      this.Bmn.clearView();
      this.Bmn = null;
      this.Bki.onDestroy();
      AppMethodBeat.o(80791);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WebSearch.WeappWebSearchFragment", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(80791);
    }
  }
  
  protected final boolean y(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80792);
    switch (paramInt)
    {
    default: 
      ((FTSSOSHomeWebViewUI)getActivity()).m(paramInt, paramBundle);
      AppMethodBeat.o(80792);
      return true;
    }
    boolean bool = z(paramInt, paramBundle);
    AppMethodBeat.o(80792);
    return bool;
  }
  
  protected final boolean z(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(80793);
    Object localObject1;
    final int i;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(80793);
      return false;
    case 142: 
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
      i = paramBundle.getInt("fts_key_is_expired", 1);
      final int j = paramBundle.getInt("fts_key_is_preload", 0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80781);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().q(this.lCl, paramInt, i, j);
          }
          AppMethodBeat.o(80781);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(80793);
      return true;
      localObject1 = new HashMap();
      Object localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((Map)localObject1).put(str, paramBundle.get(str));
      }
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80782);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().bs(this.AhJ);
          }
          AppMethodBeat.o(80782);
        }
      });
      continue;
      localObject1 = paramBundle.getString("fts_key_json_data");
      localObject2 = paramBundle.getString("fts_key_req_id");
      final boolean bool = paramBundle.getBoolean("fts_key_new_query", true);
      paramBundle = paramBundle.getBundle("fts_key_data");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80783);
          if (WeappWebSearchFragment.this.getJsapi() != null)
          {
            if ((paramBundle != null) && (paramBundle.getInt("isRefresh") == 1) && (paramBundle.getString("widgetId") != null))
            {
              WeappWebSearchFragment.this.getJsapi().jV(paramBundle.getString("widgetId"), this.lCl);
              AppMethodBeat.o(80783);
              return;
            }
            WeappWebSearchFragment.this.getJsapi().j(this.lCl, bool, this.APj);
          }
          AppMethodBeat.o(80783);
        }
      });
      continue;
      paramInt = paramBundle.getInt("fts_key_ret", 0);
      paramBundle = paramBundle.getString("fts_key_data");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80784);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().cq(paramInt, paramBundle);
          }
          AppMethodBeat.o(80784);
        }
      });
      continue;
      localObject1 = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_teach_request_type", 0);
      i = paramBundle.getInt("fts_key_is_cache_data", 0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80785);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().u(paramInt, this.lCl, i);
          }
          AppMethodBeat.o(80785);
        }
      });
      continue;
      paramBundle = paramBundle.getString("fts_key_json_data");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80786);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().avX(paramBundle);
          }
          AppMethodBeat.o(80786);
        }
      });
      continue;
      localObject1 = paramBundle.getString("fts_key_sns_id");
      paramInt = paramBundle.getInt("fts_key_status", 0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80787);
          if (WeappWebSearchFragment.this.getJsapi() != null) {
            WeappWebSearchFragment.this.getJsapi().fd(this.Bkp, paramInt);
          }
          AppMethodBeat.o(80787);
        }
      });
      continue;
      this.Bki.b(paramBundle, this.scene);
      continue;
      this.Bki.aK(paramBundle);
      continue;
      this.Bki.aL(paramBundle);
      continue;
      this.Bki.aM(paramBundle);
      continue;
      paramBundle = paramBundle.getString("fts_key_json_data");
      if (getJsapi() != null)
      {
        try
        {
          getJsapi().bq(new JSONObject(paramBundle));
        }
        catch (JSONException paramBundle)
        {
          ad.printErrStackTrace("MicroMsg.WebSearch.WeappWebSearchFragment", paramBundle, "", new Object[0]);
        }
        continue;
        aJ(paramBundle);
        continue;
        com.tencent.mm.plugin.websearch.widget.view.a.eiE().Sp(paramBundle.getInt("actionSheetId"));
        continue;
        localObject1 = this.Bki;
        if (localObject1 != null)
        {
          ((e)localObject1).aN(paramBundle);
        }
        else
        {
          ad.e("MicroMsg.WebSearch.WeappWebSearchFragment", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
          getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
          continue;
          getJsapi().ao(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment
 * JD-Core Version:    0.7.0.1
 */