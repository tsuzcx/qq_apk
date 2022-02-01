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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private boolean CCf;
  private boolean CCg = true;
  private r mSearchViewHelper;
  private int oqc;
  String query;
  private int type;
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(80473);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.query = str;
    if (!bs.isNullOrNil(str))
    {
      this.query = str;
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80466);
          if (BaseEmojiStoreSearchWebViewUI.this.Cjc != null) {
            BaseEmojiStoreSearchWebViewUI.this.Cjc.ezS();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.Cjc.ezU());
    }
    try
    {
      if (this.kYt != null) {
        this.kYt.v(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!bs.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(13054, new Object[] { Integer.valueOf(this.oqc), Integer.valueOf(1), paramString });
        AppMethodBeat.o(80473);
        return false;
        ac.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void Gb(String paramString)
  {
    AppMethodBeat.i(80472);
    if ((this.CCg) && (bs.isNullOrNil(paramString)))
    {
      this.CCg = false;
      if (!this.CCf)
      {
        ap.n(new Runnable()
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
      this.mSearchViewHelper.fts();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void aPa()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void aPb() {}
  
  public final void aPc()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.fts();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void aPd() {}
  
  public final com.tencent.mm.plugin.webview.core.h bMD()
  {
    AppMethodBeat.i(188500);
    com.tencent.mm.plugin.webview.core.h localh = super.bMD();
    if (localh != null) {
      localh.a(new a((byte)0));
    }
    AppMethodBeat.o(188500);
    return localh;
  }
  
  public final boolean bMq()
  {
    return false;
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(80469);
    super.bvh();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.CCf = getIntent().getBooleanExtra("showkeyboard", false);
    this.oqc = getIntent().getIntExtra("sence", 0);
    this.nKq.setOnTouchListener(new View.OnTouchListener()
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
    this.mSearchViewHelper.xO(false);
    this.mSearchViewHelper.ITM = this;
    showOptionMenu(false);
    if (this.CAF != null) {
      this.CAF.ut(true);
    }
    this.nKq.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final void eDW()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public final boolean eEm()
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
  
  public void y(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80475);
    ac.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.y(paramInt, paramBundle);
      AppMethodBeat.o(80475);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.Cjc;
      if (!paramBundle.Apr)
      {
        ac.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        AppMethodBeat.o(80475);
        return;
      }
      ac.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      ac.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.CjQ = l;
      str1 = l.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.Cjz, paramBundle.CjA);
      ac.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      ap.f(new f.61(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.Cjc.ezS();
    AppMethodBeat.o(80475);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.core.e
  {
    private a() {}
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188498);
      ac.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(188498);
    }
    
    public final void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188499);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(188499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */