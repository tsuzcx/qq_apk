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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.63;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.core.h;
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
  private boolean EfM;
  private boolean EfN = true;
  private r mSearchViewHelper;
  private int oTx;
  String query;
  private int type;
  
  public final boolean Jp(String paramString)
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
          if (BaseEmojiStoreSearchWebViewUI.this.DzP != null) {
            BaseEmojiStoreSearchWebViewUI.this.DzP.eOG();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.DzP.eOI());
    }
    try
    {
      if (this.lvv != null) {
        this.lvv.w(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!bt.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        g.yhR.f(13054, new Object[] { Integer.valueOf(this.oTx), Integer.valueOf(1), paramString });
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
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(80472);
    if ((this.EfN) && (bt.isNullOrNil(paramString)))
    {
      this.EfN = false;
      if (!this.EfM)
      {
        aq.o(new Runnable()
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
      this.mSearchViewHelper.fKg();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void aSn() {}
  
  public final void aSo()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.fKg();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void aSp() {}
  
  public final boolean bQR()
  {
    return false;
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(208148);
    h localh = super.bRd();
    if (localh != null) {
      localh.a(new a((byte)0));
    }
    AppMethodBeat.o(208148);
    return localh;
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(80469);
    super.bzn();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.EfM = getIntent().getBooleanExtra("showkeyboard", false);
    this.oTx = getIntent().getIntExtra("sence", 0);
    this.omW.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80464);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        BaseEmojiStoreSearchWebViewUI.this.hideVKB();
        a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(80464);
        return false;
      }
    });
    this.mSearchViewHelper = new r();
    addSearchMenu(true, this.mSearchViewHelper);
    this.mSearchViewHelper.yC(false);
    this.mSearchViewHelper.KKQ = this;
    showOptionMenu(false);
    if (this.Een != null) {
      this.Een.ve(true);
    }
    this.omW.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208145);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(208145);
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final void eSO()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public final boolean eTe()
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
  
  public void z(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(80475);
    ad.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
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
      paramBundle = this.DzP;
      if (!paramBundle.BHY)
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
      paramBundle.DMX = l;
      str1 = l.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.DMD, paramBundle.vJP);
      ad.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      aq.f(new f.63(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.DzP.eOG();
    AppMethodBeat.o(80475);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.core.e
  {
    private a() {}
    
    public final void aGk(String paramString)
    {
      AppMethodBeat.i(208147);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(208147);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(208146);
      ad.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(208146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */