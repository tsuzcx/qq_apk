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
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.61;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI
  extends WebViewUI
  implements r.b
{
  private boolean BjR;
  private boolean BjS = true;
  private r mSearchViewHelper;
  private int nNc;
  String query;
  private int type;
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(80473);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.query = str;
    if (!bt.isNullOrNil(str))
    {
      this.query = str;
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80466);
          if (BaseEmojiStoreSearchWebViewUI.this.AQP != null) {
            BaseEmojiStoreSearchWebViewUI.this.AQP.ekw();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.AQP.eky());
    }
    try
    {
      if (this.kxf != null) {
        this.kxf.u(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!bt.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(13054, new Object[] { Integer.valueOf(this.nNc), Integer.valueOf(1), paramString });
        AppMethodBeat.o(80473);
        return false;
        ad.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void BY(String paramString)
  {
    AppMethodBeat.i(80472);
    if ((this.BjS) && (bt.isNullOrNil(paramString)))
    {
      this.BjS = false;
      if (!this.BjR)
      {
        aq.n(new Runnable()
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
      this.mSearchViewHelper.fdx();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void aIk() {}
  
  public final void aIl()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.fdx();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void aIm() {}
  
  public final boolean bFc()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.webview.core.h bFq()
  {
    AppMethodBeat.i(188065);
    com.tencent.mm.plugin.webview.core.h localh = super.bFq();
    if (localh != null) {
      localh.a(new a((byte)0));
    }
    AppMethodBeat.o(188065);
    return localh;
  }
  
  public final void bol()
  {
    AppMethodBeat.i(80469);
    super.bol();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.BjR = getIntent().getBooleanExtra("showkeyboard", false);
    this.nNc = getIntent().getIntExtra("sence", 0);
    this.nhy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80464);
        BaseEmojiStoreSearchWebViewUI.this.hideVKB();
        AppMethodBeat.o(80464);
        return false;
      }
    });
    this.mSearchViewHelper = new r();
    addSearchMenu(true, this.mSearchViewHelper);
    this.mSearchViewHelper.wH(false);
    this.mSearchViewHelper.Htp = this;
    showOptionMenu(false);
    if (this.Bis != null) {
      this.Bis.tr(true);
    }
    this.nhy.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final void eoB()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public final boolean eoR()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131493833;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(80470);
    if (this.mSearchViewHelper != null)
    {
      this.mSearchViewHelper.a(this, paramMenu);
      this.mSearchViewHelper.setHint(getString(2131758295));
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
  
  public void x(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80475);
    ad.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.x(paramInt, paramBundle);
      AppMethodBeat.o(80475);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.AQP;
      if (!paramBundle.yZR)
      {
        ad.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        AppMethodBeat.o(80475);
        return;
      }
      ad.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      ad.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.ARD = l;
      str1 = l.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.ARm, paramBundle.ARn);
      ad.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      aq.f(new f.61(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.AQP.ekw();
    AppMethodBeat.o(80475);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.core.e
  {
    private a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188063);
      ad.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(188063);
    }
    
    public final void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188064);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(188064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */