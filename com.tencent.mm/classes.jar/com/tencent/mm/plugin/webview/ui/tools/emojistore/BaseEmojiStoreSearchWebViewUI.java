package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.app.Activity;
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
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.h.70;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI
  extends WebViewUI
  implements s.b
{
  private boolean Jmy;
  private boolean Jmz = true;
  private s mSearchViewHelper;
  private int qoX;
  String query;
  private int type;
  
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
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80466);
          if (BaseEmojiStoreSearchWebViewUI.this.IBw != null) {
            BaseEmojiStoreSearchWebViewUI.this.IBw.gbf();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.IBw.gbh());
    }
    try
    {
      if (this.mHh != null) {
        this.mHh.v(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!Util.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(13054, new Object[] { Integer.valueOf(this.qoX), Integer.valueOf(1), paramString });
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
    if ((this.Jmz) && (Util.isNullOrNil(paramString)))
    {
      this.Jmz = false;
      if (!this.Jmy)
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
      this.mSearchViewHelper.gXq();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(80469);
    super.bXg();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.Jmy = getIntent().getBooleanExtra("showkeyboard", false);
    this.qoX = getIntent().getIntExtra("sence", 0);
    this.pGj.setOnTouchListener(new View.OnTouchListener()
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
    this.mSearchViewHelper.CK(false);
    this.mSearchViewHelper.Qwi = this;
    showOptionMenu(false);
    if (this.JjI != null) {
      this.JjI.zh(true);
    }
    this.pGj.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211201);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(211201);
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final void bnA()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.gXq();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void bnz() {}
  
  public final boolean cpC()
  {
    return false;
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(211204);
    i locali = super.cpO();
    if (locali != null) {
      locali.a(new a((byte)0));
    }
    AppMethodBeat.o(211204);
    return locali;
  }
  
  public int getLayoutId()
  {
    return 2131493987;
  }
  
  public final boolean gfP()
  {
    return true;
  }
  
  public final void gfy()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(80470);
    if (this.mSearchViewHelper != null)
    {
      this.mSearchViewHelper.a(this, paramMenu);
      this.mSearchViewHelper.setHint(getString(2131758586));
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
  
  public void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80475);
    Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.z(paramInt, paramBundle);
      AppMethodBeat.o(80475);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.IBw;
      if (!paramBundle.GBl)
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
      paramBundle.IRD = l;
      str1 = n.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.IRj, paramBundle.zpY);
      Log.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      MMHandlerThread.postToMainThread(new h.70(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.IBw.gbf();
    AppMethodBeat.o(80475);
  }
  
  final class a
    extends f
  {
    private a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211202);
      Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(211202);
    }
    
    public final void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211203);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(211203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */