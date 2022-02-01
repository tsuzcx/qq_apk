package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.71;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI
  extends WebViewUI
  implements s.c
{
  private boolean XbH;
  private boolean XbI = true;
  private s mSearchViewHelper;
  String query;
  private int type;
  private int wQW;
  
  public void E(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80475);
    Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.E(paramInt, paramBundle);
      AppMethodBeat.o(80475);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.WlX;
      if (!paramBundle.UcS)
      {
        Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        AppMethodBeat.o(80475);
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      Log.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.WEf = l;
      str1 = p.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.WDI, paramBundle.KQY);
      Log.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      MMHandlerThread.postToMainThread(new j.71(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.WlX.itG();
    AppMethodBeat.o(80475);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(80473);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.query = str;
    if (!Util.isNullOrNil(str))
    {
      this.query = str;
      getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80466);
          if (BaseEmojiStoreSearchWebViewUI.this.WlX != null) {
            BaseEmojiStoreSearchWebViewUI.this.WlX.itG();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.WlX.itI());
    }
    try
    {
      if (this.sLC != null) {
        this.sLC.A(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!Util.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(13054, new Object[] { Integer.valueOf(this.wQW), Integer.valueOf(1), paramString });
        AppMethodBeat.o(80473);
        return false;
        Log.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(80472);
    if ((this.XbI) && (Util.isNullOrNil(paramString)))
    {
      this.XbI = false;
      if (!this.XbH)
      {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(80465);
            BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).clearFocus();
            BaseEmojiStoreSearchWebViewUI.this.hideVKB();
            AppMethodBeat.o(80465);
          }
        }, 500L);
        AppMethodBeat.o(80472);
        return;
      }
      this.mSearchViewHelper.jCM();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void bWx() {}
  
  public final void bWy()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.jCM();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void bWz() {}
  
  public final void cKX()
  {
    AppMethodBeat.i(80469);
    super.cKX();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.XbH = getIntent().getBooleanExtra("showkeyboard", false);
    this.wQW = getIntent().getIntExtra("sence", 0);
    this.sMP.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80464);
        BaseEmojiStoreSearchWebViewUI.this.hideVKB();
        AppMethodBeat.o(80464);
        return false;
      }
    });
    this.mSearchViewHelper = new s();
    addSearchMenu(true, this.mSearchViewHelper);
    this.mSearchViewHelper.MY(false);
    this.mSearchViewHelper.afKz = this;
    showOptionMenu(false);
    if (this.WYD != null) {
      this.WYD.IJ(true);
    }
    this.sMP.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(296475);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(296475);
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(296477);
    k localk = super.dhx();
    if (localk != null) {
      localk.a(new a((byte)0));
    }
    AppMethodBeat.o(296477);
    return localk;
  }
  
  public int getLayoutId()
  {
    return c.g.emoji_webview_ui;
  }
  
  public final void iyF()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public final boolean iyV()
  {
    return false;
  }
  
  public final boolean iza()
  {
    return true;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(80470);
    if (this.mSearchViewHelper != null)
    {
      this.mSearchViewHelper.a(this, paramMenu);
      this.mSearchViewHelper.setHint(getString(c.i.emoji_search_hit));
    }
    AppMethodBeat.o(80470);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80477);
    super.onDestroy();
    AppMethodBeat.o(80477);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.core.h
  {
    private a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(296481);
      Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(296481);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(296486);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(296486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */