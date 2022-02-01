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
import com.tencent.mm.api.z.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
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
  RelativeLayout BkA;
  protected int BkB;
  protected int BkC;
  protected String BkD;
  protected List<Runnable> BkE;
  private Runnable BkF;
  protected boolean Bkx;
  private com.tencent.mm.plugin.webview.fts.c.b Bky;
  private Set<b.a> Bkz = new HashSet();
  protected View fwo;
  protected String jko;
  private View lmD;
  private SmileyPanel qVT;
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
      localObject2 = this.kxf.v(7, (Bundle)localObject1);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label93:
      break label93;
    }
    localObject2 = ((Bundle)localObject1).getString("emojiPath");
    if (!paramEmojiInfo.CZ())
    {
      localObject1 = localObject2;
      if (paramEmojiInfo.field_catalog != EmojiGroupInfo.LBO) {}
    }
    else
    {
      localObject1 = (String)localObject2 + "_fts";
    }
    return localObject1;
  }
  
  private static int aI(Bundle paramBundle)
  {
    return bt.aGh(paramBundle.getString("playerId"));
  }
  
  private void aJ(Bundle paramBundle)
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
        y localy;
        if (localJSONObject != null)
        {
          localy = new y();
          localy.iconUrl = localJSONObject.optString("icon");
          localy.title = localJSONObject.optString("title");
          if (localJSONObject.optInt("selected") != 1) {
            break label156;
          }
        }
        label156:
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
      ad.e("MicroMsg.WebSearch.BaseSearchWebViewUI", bt.m(localJSONException));
      ad.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", new Object[] { str1, str2, str3 });
      if (!localArrayList.isEmpty()) {
        paramBundle.putInt("actionSheetId", ((com.tencent.mm.plugin.websearch.api.e)g.ab(com.tencent.mm.plugin.websearch.api.e.class)).a(this, str1, str2, localArrayList, new x()
        {
          public final void io(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(188082);
            if (BaseSearchWebViewUI.this.getJsapi() != null) {
              BaseSearchWebViewUI.this.getJsapi().it(paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(188082);
          }
        }));
      }
    }
  }
  
  private void cBH()
  {
    if (this.fwo != null)
    {
      this.fwo.setVisibility(8);
      if (this.BkF != null)
      {
        this.handler.removeCallbacks(this.BkF);
        this.BkF = null;
      }
    }
  }
  
  protected final Drawable TF(int paramInt)
  {
    int i = 2131691237;
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
    this.Bkz.add(parama);
  }
  
  protected final void au(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().yZR))
    {
      paramRunnable.run();
      return;
    }
    ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi not ready, waiting");
    if (this.BkE == null) {
      this.BkE = new ArrayList();
    }
    this.BkE.add(paramRunnable);
  }
  
  protected final void bFs()
  {
    super.bFs();
    if ((this.BkE != null) && (!this.BkE.isEmpty()))
    {
      Object localObject = new ArrayList(this.BkE);
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.BkE.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    ad.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    com.tencent.mm.plugin.websearch.api.z.ehO();
  }
  
  public void bol()
  {
    super.bol();
    if (this.Bky == null) {
      this.Bky = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.nhy, this);
    }
    this.Bky.AQP = getJsapi();
    if (this.kxf != null) {}
    for (;;)
    {
      try
      {
        this.kxf.j(51, new Bundle());
        this.BkA = ((RelativeLayout)findViewById(2131299401));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localRemoteException, "", new Object[0]);
        continue;
      }
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
    }
  }
  
  public final boolean bon()
  {
    return true;
  }
  
  protected void c(int paramInt, String paramString, Map<String, Object> paramMap) {}
  
  public final void ekh()
  {
    if (this.lmD == null) {}
    for (;;)
    {
      return;
      Object localObject = (ViewGroup)getWindow().getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(0);
      ((ViewGroup)localObject).removeView(this.lmD);
      getWindow().clearFlags(1024);
      if (getRequestedOrientation() == 0) {
        setRequestedOrientation(1);
      }
      this.lmD = null;
      localObject = this.Bkz.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).Cx();
      }
    }
  }
  
  protected e epD()
  {
    return null;
  }
  
  protected final void epI()
  {
    super.epI();
    int i = this.scene;
    String str1 = this.sessionId;
    String str2 = this.dtw;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.websearch.api.z.a(i, str1, str2, bool, this.query, this.type, this.BkD, this.ARU);
      return;
    }
  }
  
  public final void epJ()
  {
    if (this.BkA != null) {
      this.BkA.setVisibility(8);
    }
    if (this.qVT != null) {
      this.qVT.exq();
    }
  }
  
  public void m(final int paramInt, final Bundle paramBundle)
  {
    boolean bool2 = true;
    final boolean bool1 = true;
    switch (paramInt)
    {
    default: 
      super.m(paramInt, paramBundle);
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
                return;
                c(paramBundle.getInt("FTS_KEY_onStartWebSearch_type", 0), paramBundle.getString("FTS_KEY_onStartWebSearch_query"), (Map)paramBundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                return;
                paramBundle = paramBundle.getString("fts_key_json_data");
              } while (getJsapi() == null);
              try
              {
                getJsapi().bq(new JSONObject(paramBundle));
                return;
              }
              catch (JSONException paramBundle)
              {
                ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", paramBundle, "", new Object[0]);
                return;
              }
              aJ(paramBundle);
              return;
              com.tencent.mm.plugin.websearch.widget.view.a.eiE().Sp(paramBundle.getInt("actionSheetId"));
              return;
              localObject1 = epD();
              if (localObject1 != null)
              {
                ((e)localObject1).aN(paramBundle);
                return;
              }
              ad.e("MicroMsg.WebSearch.BaseSearchWebViewUI", "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView");
              getJsapi().a(paramBundle.getString(""), false, "can not find FTSSearchWidgetMgr to handle tapSearchWAWidgetView", paramBundle.getString("widgetId"));
              return;
              localObject1 = this.Bky;
            } while (localObject1 == null);
            ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).L(aI(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
            return;
            localObject1 = this.Bky;
          } while (localObject1 == null);
          ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).M(aI(paramBundle), paramBundle.getString("viewProps"), paramBundle.getString("videoProps"));
          return;
          localObject1 = this.Bky;
        } while (localObject1 == null);
        ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).SD(aI(paramBundle));
        return;
        localObject1 = this.Bky;
      } while (localObject1 == null);
      ((com.tencent.mm.plugin.webview.fts.c.e)localObject1).cp(aI(paramBundle), paramBundle.getString("type"));
      return;
    case 145: 
      getJsapi().ao(paramBundle);
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
            AppMethodBeat.i(188078);
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cPN, this.khH, paramInt, bool1);
            AppMethodBeat.o(188078);
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
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, this.cPN, "loading", -1, bool1);
            AppMethodBeat.o(80573);
          }
        });
        return;
      }
    case 150: 
      cBH();
      return;
    case 151: 
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "GOTO_EMOTICON");
      hideVKB();
      paramBundle = paramBundle.getString("requestId");
      if (this.qVT == null)
      {
        this.qVT = com.tencent.mm.api.aa.bg(this);
        this.qVT.setEntranceScene(ChatFooterPanel.BUX);
        this.qVT.setVisibility(0);
        this.qVT.setShowSmiley(false);
        this.qVT.onResume();
        localObject1 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.api.aa.bh(this));
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        this.BkA.addView(this.qVT, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(getApplicationContext());
        ((TextView)localObject1).setBackgroundColor(com.tencent.mm.cd.a.n(this, 2131099679));
        ((TextView)localObject1).setPadding(0, com.tencent.mm.cd.a.ap(this, 2131165289), 0, com.tencent.mm.cd.a.ap(this, 2131165289));
        ((TextView)localObject1).setTextColor(com.tencent.mm.cd.a.n(this, 2131100490));
        ((TextView)localObject1).setTextSize(15.0F);
        ((TextView)localObject1).setText(2131762943);
        ((TextView)localObject1).setGravity(17);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.api.aa.bh(this);
        this.BkA.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = com.tencent.mm.api.aa.Kf();
        ((com.tencent.mm.api.z)localObject1).cJL = new z.a()
        {
          public final void a(final p paramAnonymousp)
          {
            AppMethodBeat.i(188080);
            final String str1 = BaseSearchWebViewUI.this.BkB + ";" + BaseSearchWebViewUI.this.sessionId + ";" + paramBundle;
            BaseSearchWebViewUI.a(BaseSearchWebViewUI.this).set16029ExtraInfo(str1);
            paramAnonymousp = (EmojiInfo)paramAnonymousp;
            str1 = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
            Object localObject1;
            if ((paramAnonymousp.CZ()) || (paramAnonymousp.field_catalog == EmojiGroupInfo.LBO))
            {
              ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "emoji is system emoji %s", new Object[] { Integer.valueOf(paramAnonymousp.field_catalog) });
              if (!i.eK(str1))
              {
                localObject1 = paramAnonymousp.z(BaseSearchWebViewUI.this, 480);
                if (localObject1 == null) {}
              }
            }
            try
            {
              com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.PNG, str1, false);
              ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "save emoji bitmap %d %s", new Object[] { Long.valueOf(i.aMN(str1)), str1 });
              str1 = "weixin://fts/emoji?path=".concat(String.valueOf(str1));
              localObject1 = paramAnonymousp.field_md5;
              final String str2 = paramAnonymousp.field_aeskey;
              final String str3 = paramAnonymousp.field_encrypturl;
              boolean bool = paramAnonymousp.fZM();
              i = 0;
              if (com.tencent.mm.plugin.emoji.h.b.x(paramAnonymousp))
              {
                i = 1;
                ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSelectedEmoji %s %s %b", new Object[] { localObject1, str1, Boolean.valueOf(bool) });
                Object localObject2 = BaseSearchWebViewUI.this.getJsapi();
                if (!bool) {
                  break label386;
                }
                j = 0;
                ((com.tencent.mm.plugin.webview.c.f)localObject2).b((String)localObject1, str1, i, j, str3, str2);
                if (!bool)
                {
                  localObject2 = com.tencent.mm.emoji.loader.e.fLn;
                  com.tencent.mm.emoji.loader.e.a(paramAnonymousp, new i.a()
                  {
                    public final void df(boolean paramAnonymous2Boolean)
                    {
                      int i = 0;
                      AppMethodBeat.i(188079);
                      if (paramAnonymous2Boolean)
                      {
                        Object localObject = BaseSearchWebViewUI.a(BaseSearchWebViewUI.this, paramAnonymousp);
                        ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s emojiPath %s exist %b", new Object[] { this.kzy, str1, localObject, Boolean.valueOf(i.eK((String)localObject)) });
                        localObject = BaseSearchWebViewUI.this.getJsapi();
                        String str1 = this.kzy;
                        String str2 = str1;
                        int j = i;
                        if (paramAnonymous2Boolean) {}
                        for (;;)
                        {
                          ((com.tencent.mm.plugin.webview.c.f)localObject).b(str1, str2, j, i, str3, str2);
                          AppMethodBeat.o(188079);
                          return;
                          i = 1;
                        }
                      }
                      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "loadFile %s %s fail", new Object[] { this.kzy, str1 });
                      AppMethodBeat.o(188079);
                    }
                  });
                }
                BaseSearchWebViewUI.this.BkA.setVisibility(8);
                AppMethodBeat.o(188080);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                final int i;
                int j;
                ad.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", localException, "SaveEmojiBitmap", new Object[0]);
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
        this.qVT.setCallback((com.tencent.mm.pluginsdk.ui.chat.f)localObject1);
      }
      this.BkA.setVisibility(0);
      return;
    case 152: 
      paramInt = paramBundle.getInt("fts_key_ret_code");
      localObject1 = paramBundle.getString("fts_key_err_msg");
      paramBundle = paramBundle.getString("fts_key_json_data", "");
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188081);
          BaseSearchWebViewUI.this.getJsapi().f(paramInt, this.val$errMsg, paramBundle, "", "onSimilarEmoticonReady");
          ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, paramBundle });
          AppMethodBeat.o(188081);
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
        BaseSearchWebViewUI.this.getJsapi().f(paramInt, this.val$errMsg, this.nyH, paramBundle, "onSearchWebQueryReady");
        ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(paramInt), this.val$errMsg, this.nyH });
        AppMethodBeat.o(80577);
      }
    });
  }
  
  public void onBackPressed()
  {
    epJ();
    Iterator localIterator = this.Bkz.iterator();
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
      this.Bkx = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
    }
    if (this.Bky == null) {
      this.Bky = new com.tencent.mm.plugin.webview.fts.c.b(getContext(), this.nhy, this);
    }
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    this.BkB = this.scene;
    this.type = getIntent().getIntExtra("ftsType", 0);
    this.query = getIntent().getStringExtra("ftsQuery");
    this.BkD = getIntent().getStringExtra("tabId");
    this.jko = getIntent().getStringExtra("searchId");
    this.BkC = this.type;
    int i = this.scene;
    paramBundle = this.sessionId;
    String str = this.dtw;
    if (this.type == 0) {
      bool = true;
    }
    com.tencent.mm.plugin.websearch.api.z.a(i, paramBundle, str, bool, this.query, this.type, this.BkD, this.ARU, this.jko);
    if (!com.tencent.mm.plugin.websearch.api.aa.n(this, this.scene)) {
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
    }
    for (;;)
    {
      paramBundle = View.inflate(this, 2131495324, null);
      paramBundle.setBackgroundResource(2131101053);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.fwo = paramBundle;
      if ((this.fwo != null) && ((getContentView() instanceof ViewGroup))) {
        ((ViewGroup)getContentView()).addView(this.fwo);
      }
      cBH();
      return;
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.Bkz.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).onDestroy();
    }
    this.Bkz.clear();
    int i = this.scene;
    localObject = this.sessionId;
    String str = this.dtw;
    if (this.type == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.websearch.api.z.a(i, (String)localObject, str, bool, this.query, this.type, this.ARU);
      ad.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator;
    if (paramInt == 25)
    {
      localIterator = this.Bkz.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).ekf();
      }
    }
    if (paramInt == 24)
    {
      localIterator = this.Bkz.iterator();
      while (localIterator.hasNext()) {
        ((b.a)localIterator.next()).ekg();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.Bkz.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onBackground();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0) {}
    for (paramArrayOfString = paramArrayOfInt[0];; paramArrayOfString = "")
    {
      ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", new Object[] { paramArrayOfString });
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.Bkz.iterator();
    while (localIterator.hasNext()) {
      ((b.a)localIterator.next()).onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    ekh();
    this.lmD = paramView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.addView(paramView, localLayoutParams);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (d.lg(19)) {
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