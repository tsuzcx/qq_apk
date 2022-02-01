package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.p;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.webview.c.f.34;
import com.tencent.mm.plugin.webview.c.f.36;
import com.tencent.mm.plugin.webview.c.f.40;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
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
  private Set<b.a> EyA = new HashSet();
  RelativeLayout EyB;
  protected int EyC;
  protected int EyD;
  protected String EyE;
  protected List<Runnable> EyF;
  private Runnable EyG;
  protected boolean Eyy;
  private com.tencent.mm.plugin.webview.fts.c.b Eyz;
  protected View fVr;
  private SmileyPanel gXW;
  protected String kid;
  private View mtt;
  protected String query;
  protected int scene;
  protected int type;
  
  private String C(EmojiInfo paramEmojiInfo)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("md5", paramEmojiInfo.field_md5);
    ((Bundle)localObject1).putString("designerId", paramEmojiInfo.field_designerID);
    ((Bundle)localObject1).putString("aeskey", paramEmojiInfo.field_aeskey);
    ((Bundle)localObject1).putString("encryptUrl", paramEmojiInfo.field_encrypturl);
    ((Bundle)localObject1).putString("productId", paramEmojiInfo.field_groupId);
    ((Bundle)localObject1).putString("name", paramEmojiInfo.field_name);
    ((Bundle)localObject1).putString("thumbUrl", paramEmojiInfo.field_thumbUrl);
    try
    {
      localObject2 = this.lzT.x(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.Ee())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.OzS) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int aT(Bundle paramBundle)
  {
    return bu.aSB(paramBundle.getString("playerId"));
  }
  
  private void aU(Bundle paramBundle)
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
        ab localab;
        if (localJSONObject != null)
        {
          localab = new ab();
          localab.iconUrl = localJSONObject.optString("icon");
          localab.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label156;
          }
        }
        label156:
        for (boolean bool = true;; bool = false)
        {
          localab.isSelected = bool;
          localab.desc = localJSONObject.optString("desc");
          localArrayList.add(localab);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.WebSearch.BaseSearchWebViewUI", bu.o(localJSONException));
      ae.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.f)g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(this, str1, str2, localArrayList, new com.tencent.mm.plugin.websearch.api.aa()
        {
          public final void iU(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(198347);
            if (BaseSearchWebViewUI.this.getJsapi() != null)
            {
              com.tencent.mm.plugin.webview.c.f localf = BaseSearchWebViewUI.this.getJsapi();
              if (!localf.BZx)
              {
                ae.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
                AppMethodBeat.o(198347);
                return;
              }
              ae.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
              HashMap localHashMap = new HashMap();
              localHashMap.put("index", Integer.valueOf(paramAnonymousInt1));
              localHashMap.put("actionSheetId", Integer.valueOf(paramAnonymousInt2));
              ar.f(new f.34(localf, l.a.b("onSearchActionSheetClick", localHashMap, localf.EeC, localf.vVT)));
            }
            AppMethodBeat.o(198347);
          }
        }));
      }
    }
  }
  
  private void daf()
  {
    if (this.fVr != null)
    {
      this.fVr.setVisibility(8);
      if (this.EyG != null)
      {
        this.handler.removeCallbacks(this.EyG);
        this.EyG = null;
      }
    }
  }
  
  protected final Drawable Yj(int paramInt)
  {
    int i = 2131691594;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return getResources().getDrawable(paramInt);
      paramInt = 2131691419;
      continue;
      paramInt = 2131691426;
      continue;
      paramInt = 2131691422;
      continue;
      paramInt = 2131691417;
      continue;
      paramInt = 2131691421;
      continue;
      paramInt = 2131691418;
      continue;
      paramInt = 2131691428;
      continue;
      paramInt = 2131691420;
      continue;
      paramInt = 2131691425;
      continue;
      paramInt = 2131691423;
      continue;
      paramInt = 2131691424;
      continue;
      paramInt = 2131691429;
    }
  }
  
  public final void a(b.a parama)
  {
    this.EyA.add(parama);
  }
  
  protected final void at(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().BZx))
    {
      paramRunnable.run();
      return;
    }
    ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi not ready, waiting");
    if (this.EyF == null) {
      this.EyF = new ArrayList();
    }
    this.EyF.add(paramRunnable);
  }
  
  public void bAi()
  {
    super.bAi();
    if (this.Eyz == null) {
      this.Eyz = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.osM, this);
    }
    this.Eyz.DRx = getJsapi();
    if (this.lzT != null) {}
    for (;;)
    {
      try
      {
        this.lzT.k(51, new Bundle());
        this.EyB = ((RelativeLayout)findViewById(2131299401));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ae.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }
  }
  
  public final boolean bAk()
  {
    return true;
  }
  
  protected final void bSg()
  {
    super.bSg();
    if ((this.EyF != null) && (!this.EyF.isEmpty()))
    {
      Object localObject = new ArrayList(this.EyF);
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.EyF.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    ac.ePI();
  }
  
  protected void d(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public final void eSc()
  {
    if (this.mtt == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.mtt);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.mtt = null;
      localObject = this.EyA.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).DD();
      }
    }
  }
  
  protected e eXE()
  {
    return null;
  }
  
  protected final void eXI()
  {
    super.eXI();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.dEb;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(i, str1, str2, bool, this.query, this.type, this.EyE, this.Efm);
      return;
    }
  }
  
  public final void eXJ()
  {
    if (this.EyB != null) {
      this.EyB.setVisibility(8);
    }
    if (this.gXW != null) {
      this.gXW.ffw();
    }
  }
  
  public void n(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    switch (paramInt)
    {
    default: 
      super.n(paramInt, paramBundle);
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
                  d(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                  return;
                  localObject1 = paramBundle.getString("fts_key_json_data");
                } while (getJsapi() == null);
                try
                {
                  paramBundle = getJsapi();
                  localObject1 = new JSONObject((String)localObject1);
                  if (!paramBundle.BZx)
                  {
                    ae.e("MicroMsg.JsApiHandler", "not ready");
                    return;
                  }
                }
                catch (JSONException paramBundle)
                {
                  ae.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                  return;
                }
                ar.f(new f.36(paramBundle, l.a.a("onGetMatchContactList", (JSONObject)localObject1, paramBundle.EeC, paramBundle.vVT)));
                return;
                aU(paramBundle);
                return;
                localObject1 = com.tencent.mm.plugin.websearch.widget.view.a.eQA();
                paramInt = paramBundle.getInt("actionSheetId");
                paramBundle = (com.tencent.mm.ui.widget.a.e)((com.tencent.mm.plugin.websearch.widget.view.a)localObject1).DWC.remove(Integer.valueOf(paramInt));
              } while (paramBundle == null);
              paramBundle.bqD();
              return;
              localObject1 = eXE();
              if (localObject1 != null)
              {
                paramInt = paramBundle.getInt("x", -1);
                int i = paramBundle.getInt("y", -1);
                localObject2 = paramBundle.getString("widgetId");
                paramBundle = paramBundle.getString("eventId");
                ((e)localObject1).DWQ.h(paramInt, i, (String)localObject2, paramBundle);
                return;
              }
              ae.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.Eyz;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).O(aT(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.Eyz;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).P(aT(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.Eyz;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).Xj(aT(paramBundle));
        return;
        localObject1 = this.Eyz;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).cy(aT(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      localObject1 = getJsapi();
      if (!((com.tencent.mm.plugin.webview.c.f)localObject1).BZx)
      {
        ae.e("MicroMsg.JsApiHandler", "onGetPoiInfo fail, not ready");
        return;
      }
      ae.i("MicroMsg.JsApiHandler", "onGetPoiInfo success, ready");
      localObject2 = new HashMap();
      ((Map)localObject2).put("json", paramBundle.getString("json"));
      ((Map)localObject2).put("searchId", paramBundle.getString("searchId"));
      ((Map)localObject2).put("poiId", paramBundle.getString("poiId"));
      ar.f(new f.40((com.tencent.mm.plugin.webview.c.f)localObject1, l.a.b("onGetPoiInfoReturn", (Map)localObject2, ((com.tencent.mm.plugin.webview.c.f)localObject1).EeC, ((com.tencent.mm.plugin.webview.c.f)localObject1).vVT)));
      return;
    case 148: 
      localObject1 = paramBundle.getString("title", "");
      localObject2 = paramBundle.getString("icon", "");
      paramInt = paramBundle.getInt("duration", 500);
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (;;)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198343);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cZw, this.liE, paramInt, bool1);
            AppMethodBeat.o(198343);
          }
        });
        return;
        bool1 = false;
      }
    case 149: 
      localObject1 = paramBundle.getString("title", "");
      if (paramBundle.getInt("mask", 0) > 0) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80573);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cZw, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      daf();
      return;
    case 151: 
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.gXW == null)
      {
        this.gXW = com.tencent.mm.api.aa.bi(this);
        this.gXW.setEntranceScene(ChatFooterPanel.FkN);
        this.gXW.setVisibility(0);
        this.gXW.setShowSmiley(false);
        this.gXW.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.api.aa.bj(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.EyB.addView(this.gXW, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.cb.a.n(this, 2131099679));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.cb.a.ay(this, 2131165289), 0, com.tencent.mm.cb.a.ay(this, 2131165289));
        ((TextView)localObject1).setTextColor(com.tencent.mm.cb.a.n(this, 2131100490));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(2131762943);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.api.aa.bj(this);
        this.EyB.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = com.tencent.mm.api.aa.Lw();
        ((z)localObject1).cSG = new z.a()
        {
          public final void a(final p paramAnonymousp)
          {
            AppMethodBeat.i(198345);
            final String str1 = BaseSearchWebViewUI.this.EyC + ";" + BaseSearchWebViewUI.this.sessionId + ";" + paramBundle;
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this).set16029ExtraInfo(str1);
            paramAnonymousp = (EmojiInfo)paramAnonymousp;
            str1 = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
            Object localObject1;
            if ((paramAnonymousp.Ee()) || (paramAnonymousp.field_catalog == EmojiGroupInfo.OzS))
            {
              ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramAnonymousp.field_catalog) });
              if (!o.fB(str1))
              {
                localObject1 = paramAnonymousp.z(BaseSearchWebViewUI.this, 480);
                if (localObject1 == null) {}
              }
            }
            try
            {
              h.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
              ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(o.aZR(str1)), str1 });
              str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
              localObject1 = paramAnonymousp.field_md5;
              final String str2 = paramAnonymousp.field_aeskey;
              final String str3 = paramAnonymousp.field_encrypturl;
              boolean bool = paramAnonymousp.fxn();
              i = 0;
              if (com.tencent.mm.plugin.emoji.h.b.x(paramAnonymousp))
              {
                i = 1;
                ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
                Object localObject2 = BaseSearchWebViewUI.this.getJsapi();
                if (!bool) {
                  break label386;
                }
                j = 0;
                ((com.tencent.mm.plugin.webview.c.f)localObject2).a((String)localObject1, str1, i, j, str3, str2);
                if (!bool)
                {
                  localObject2 = com.tencent.mm.emoji.loader.e.gkR;
                  com.tencent.mm.emoji.loader.e.a(paramAnonymousp, new i.a()
                  {
                    public final void dg(boolean paramAnonymous2Boolean)
                    {
                      int i = 0;
                      AppMethodBeat.i(198344);
                      if (paramAnonymous2Boolean)
                      {
                        Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
                        ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.lCn, str1, localObject, Boolean.valueOf(o.fB((String)localObject)) });
                        localObject = BaseSearchWebViewUI.this.getJsapi();
                        String str1 = this.lCn;
                        String str2 = str1;
                        int j = i;
                        if (paramAnonymous2Boolean) {}
                        for (;;)
                        {
                          ((com.tencent.mm.plugin.webview.c.f)localObject).a(str1, str2, j, i, str3, str2);
                          AppMethodBeat.o(198344);
                          return;
                          i = 1;
                        }
                      }
                      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.lCn, str1 });
                      AppMethodBeat.o(198344);
                    }
                  });
                }
                BaseSearchWebViewUI.this.EyB.setVisibility(8);
                AppMethodBeat.o(198345);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                final int i;
                int j;
                ae.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localException, "SaveEmojiBitmap", new Object[0]);
                continue;
                if (com.tencent.mm.plugin.emoji.h.b.y(paramAnonymousp))
                {
                  i = 2;
                }
                else if (com.tencent.mm.plugin.emoji.h.b.w(paramAnonymousp))
                {
                  i = 3;
                  continue;
                  label386:
                  j = 1;
                }
              }
            }
          }
          
          public final void onHide() {}
        };
        this.gXW.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.EyB.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198346);
          BaseSearchWebViewUI.this.getJsapi().g(paramInt, this.val$errMsg, paramBundle, "", "onSimilarEmoticonReady");
          ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, paramBundle });
          AppMethodBeat.o(198346);
        }
      });
      return;
    }
    paramInt = paramBundle.getInt("fts_key_ret_code");
    Object localObject1 = paramBundle.getString("fts_key_err_msg");
    Object localObject2 = paramBundle.getString("fts_key_json_data", "");
    paramBundle = paramBundle.getString("fts_key_id", "");
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80577);
        BaseSearchWebViewUI.this.getJsapi().g(paramInt, this.val$errMsg, this.oLD, paramBundle, "onSearchWebQueryReady");
        ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSearchWebQueryReady, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, this.oLD });
        AppMethodBeat.o(80577);
      }
    });
  }
  
  public void onBackPressed()
  {
    eXJ();
    Iterator localIterator = this.EyA.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((b.a)localIterator.next()).onBackPressed() | bool) {}
    if (!bool) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.Eyy = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.Eyz == null) {
      this.Eyz = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.osM, this);
    }
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.EyC = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.EyE = getIntent().getStringExtra("tabId");
    this.kid = getIntent().getStringExtra("searchId");
    this.EyD = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.dEb;
    if (this.type == 0) {
      bool = true;
    }
    ac.a(i, paramBundle, str, bool, this.query, this.type, this.EyE, this.Efm, this.kid);
    if (!ad.n(this, this.scene)) {
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, 2131495324, null);
      paramBundle.setBackgroundResource(2131101053);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.fVr = paramBundle;
      if ((this.fVr != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.fVr);
      }
      daf();
      return;
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.EyA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.EyA.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.dEb;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(i, (String)localObject, str, bool, this.query, this.type, this.Efm);
      ae.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.EyA.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).eSa();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.EyA.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).eSb();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.EyA.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onBackground();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      ae.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.EyA.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(View paramView, boolean paramBoolean)
  {
    eSc();
    this.mtt = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (com.tencent.mm.compatible.util.d.lB(19)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */