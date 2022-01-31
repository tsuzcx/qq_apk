package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.websearch.widget.view.a;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.31;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.34;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.37;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSearchWebViewUI
  extends LoadDataWebviewUI
  implements b.b
{
  protected String bVk;
  protected String fTF;
  private View gSt;
  protected boolean rtM;
  private b rtN;
  private Set<b.a> rtO = new HashSet();
  protected int rtP;
  protected int rtQ;
  protected String rtR;
  protected List<Runnable> rtS;
  protected int scene;
  protected int type;
  
  private static int Y(Bundle paramBundle)
  {
    return bk.ZR(paramBundle.getString("playerId"));
  }
  
  private void Z(Bundle paramBundle)
  {
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
        com.tencent.mm.plugin.websearch.api.y localy;
        if (localJSONObject != null)
        {
          localy = new com.tencent.mm.plugin.websearch.api.y();
          localy.iconUrl = localJSONObject.optString("icon");
          localy.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label149;
          }
        }
        label149:
        for (boolean bool = true;; bool = false)
        {
          localy.fmm = bool;
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
      com.tencent.mm.sdk.platformtools.y.e("BaseSearchWebViewUI", bk.j(localJSONException));
      com.tencent.mm.sdk.platformtools.y.v("BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((h)g.r(h.class)).a(this, str1, str2, localArrayList, new x()
        {
          public final void eA(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald;
            if (BaseSearchWebViewUI.b(BaseSearchWebViewUI.this) != null)
            {
              locald = BaseSearchWebViewUI.c(BaseSearchWebViewUI.this);
              if (!locald.ready) {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
              }
            }
            else
            {
              return;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
            HashMap localHashMap = new HashMap();
            localHashMap.put("index", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("actionSheetId", Integer.valueOf(paramAnonymousInt2));
            ai.d(new d.31(locald, i.a.a("onSearchActionSheetClick", localHashMap, locald.rxI, locald.rxJ)));
          }
        }));
      }
    }
  }
  
  private void cfz()
  {
    if ((this.rtS != null) && (!this.rtS.isEmpty()))
    {
      Object localObject = new ArrayList(this.rtS);
      com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.rtS.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
  }
  
  protected final void P(Runnable paramRunnable)
  {
    if ((this.rbk != null) && (this.rbk.ready))
    {
      paramRunnable.run();
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "jsapi not ready, waiting");
    if (this.rtS == null) {
      this.rtS = new ArrayList();
    }
    this.rtS.add(paramRunnable);
  }
  
  public final void a(b.a parama)
  {
    this.rtO.add(parama);
  }
  
  public void aoX()
  {
    super.aoX();
    this.rtN.rbk = this.rbk;
    if ((this.rbk != null) && (!this.rbk.ready)) {
      this.rbk.a(new BaseSearchWebViewUI.1(this));
    }
    while (this.gGn != null)
    {
      try
      {
        this.gGn.f(51, new Bundle());
        return;
      }
      catch (RemoteException localRemoteException)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        return;
      }
      cfz();
      com.tencent.mm.sdk.platformtools.y.d("BaseSearchWebViewUI", "jsapi ready");
    }
    com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
  }
  
  protected final boolean aoZ()
  {
    return true;
  }
  
  protected void b(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public final void caO()
  {
    if (this.gSt == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.gSt);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.gSt = null;
      localObject = this.rtO.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).ajc();
      }
    }
  }
  
  protected e cfu()
  {
    return null;
  }
  
  protected final void cfy()
  {
    super.cfy();
    int i = this.scene;
    String str1 = this.bIB;
    String str2 = this.bVp;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      String str3 = this.bVk;
      int j = this.type;
      z.a(12, i, str1, str2, "", 0, bool, "", true, str3, this.rtR, j, this.rvc);
      return;
    }
  }
  
  public void i(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      super.i(paramInt, paramBundle);
    case 135: 
    case 137: 
    case 133: 
    case 134: 
    case 100002: 
    case 200000: 
    case 200001: 
    case 200002: 
    case 200003: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  b(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                  return;
                  paramBundle = paramBundle.getString("fts_key_json_data");
                } while (this.rbk == null);
                try
                {
                  localObject1 = this.rbk;
                  ai.d(new d.34((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1, i.a.a("onGetMatchContactList", new JSONObject(paramBundle), ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxI, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxJ)));
                  return;
                }
                catch (JSONException paramBundle)
                {
                  com.tencent.mm.sdk.platformtools.y.printErrStackTrace("BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                  return;
                }
                Z(paramBundle);
                return;
                localObject1 = a.cak();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.d)((a)localObject1).qXt.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.bFp();
              return;
              localObject1 = cfu();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).qXH.f(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              com.tencent.mm.sdk.platformtools.y.e("BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              this.rbk.a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.rtN;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).w(Y(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.rtN;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).x(Y(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.rtN;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).BU(Y(paramBundle));
        return;
        localObject1 = this.rtN;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).aV(Y(paramBundle), paramBundle.getString("type"));
      return;
    }
    Object localObject1 = this.rbk;
    if (!((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).ready)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("json", paramBundle.getString("json"));
    ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
    ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
    ai.d(new d.37((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1, i.a.a("onGetPoiInfoReturn", (Map)localObject2, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxI, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxJ)));
  }
  
  public final void m(View paramView, boolean paramBoolean)
  {
    caO();
    this.gSt = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.gG(19)) {
      localViewGroup.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(1024);
      if (paramBoolean) {
        setRequestedOrientation(0);
      }
      return;
      localViewGroup.setSystemUiVisibility(4098);
    }
  }
  
  public void onBackPressed()
  {
    Iterator localIterator = this.rtO.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((b.a)localIterator.next()).qc() | bool) {}
    if (!bool) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.rtM = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    this.rtN = new b(this.mController.uMN, this.niQ, this);
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.rtP = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.bVk = getIntent().getStringExtra("ftsQuery");
    this.rtR = getIntent().getStringExtra("tabId");
    this.fTF = getIntent().getStringExtra("searchId");
    this.rtQ = this.type;
    int i = this.scene;
    paramBundle = this.bIB;
    String str1 = this.bVp;
    if (this.type == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      String str2 = this.bVk;
      int j = this.type;
      String str3 = this.rtR;
      boolean bool2 = this.rvc;
      z.a(1, i, paramBundle, str1, this.fTF, 0, bool1, "", true, str2, str3, j, bool2);
      if (aa.i(this, this.scene)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "request for grant location permission");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "has location permission");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.rtO.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.rtO.clear();
    int i = this.scene;
    localObject = this.bIB;
    String str = this.bVp;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      z.a(14, i, (String)localObject, str, "", 0, bool, "", true, this.bVk, "", this.type, this.rvc);
      com.tencent.mm.sdk.platformtools.y.d("BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.rtO.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).caM();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.rtO.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).caN();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    Iterator localIterator = this.rtO.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).qa();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      com.tencent.mm.sdk.platformtools.y.i("BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.rtO.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).pY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */