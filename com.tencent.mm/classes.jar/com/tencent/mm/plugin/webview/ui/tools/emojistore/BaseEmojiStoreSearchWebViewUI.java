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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private boolean ExP;
  private boolean ExQ = true;
  private r mSearchViewHelper;
  private int oZZ;
  String query;
  private int type;
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(80473);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.query = str;
    if (!bu.isNullOrNil(str))
    {
      this.query = str;
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80466);
          if (BaseEmojiStoreSearchWebViewUI.this.DRx != null) {
            BaseEmojiStoreSearchWebViewUI.this.DRx.eSr();
          }
          AppMethodBeat.o(80466);
        }
      });
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.DRx.eSt());
    }
    try
    {
      if (this.lzT != null) {
        this.lzT.w(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!bu.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        g.yxI.f(13054, new Object[] { Integer.valueOf(this.oZZ), Integer.valueOf(1), paramString });
        AppMethodBeat.o(80473);
        return false;
        ae.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(80472);
    if ((this.ExQ) && (bu.isNullOrNil(paramString)))
    {
      this.ExQ = false;
      if (!this.ExP)
      {
        ar.o(new Runnable()
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
      this.mSearchViewHelper.fOx();
      showVKB();
    }
    AppMethodBeat.o(80472);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(80471);
    finish();
    AppMethodBeat.o(80471);
  }
  
  public final void aSM() {}
  
  public final void aSN()
  {
    AppMethodBeat.i(80474);
    this.mSearchViewHelper.fOx();
    showVKB();
    AppMethodBeat.o(80474);
  }
  
  public final void aSO() {}
  
  public final void bAi()
  {
    AppMethodBeat.i(80469);
    super.bAi();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.ExP = getIntent().getBooleanExtra("showkeyboard", false);
    this.oZZ = getIntent().getIntExtra("sence", 0);
    this.osM.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80464);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        BaseEmojiStoreSearchWebViewUI.this.hideVKB();
        a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(80464);
        return false;
      }
    });
    this.mSearchViewHelper = new r();
    addSearchMenu(true, this.mSearchViewHelper);
    this.mSearchViewHelper.yP(false);
    this.mSearchViewHelper.Lhk = this;
    showOptionMenu(false);
    if (this.Ewp != null) {
      this.Ewp.vm(true);
    }
    this.osM.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198324);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        a.a(true, this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(198324);
        return true;
      }
    });
    AppMethodBeat.o(80469);
  }
  
  public final boolean bRS()
  {
    return false;
  }
  
  public final h bSe()
  {
    AppMethodBeat.i(198327);
    h localh = super.bSe();
    if (localh != null) {
      localh.a(new a((byte)0));
    }
    AppMethodBeat.o(198327);
    return localh;
  }
  
  public final void eWA()
  {
    AppMethodBeat.i(80476);
    finish();
    AppMethodBeat.o(80476);
  }
  
  public final boolean eWR()
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
    ae.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
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
      paramBundle = this.DRx;
      if (!paramBundle.BZx)
      {
        ae.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        AppMethodBeat.o(80475);
        return;
      }
      ae.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      ae.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.EeW = l;
      str1 = l.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.EeC, paramBundle.vVT);
      ae.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      ar.f(new f.63(paramBundle, str1));
      AppMethodBeat.o(80475);
      return;
    }
    this.DRx.eSr();
    AppMethodBeat.o(80475);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.core.e
  {
    private a() {}
    
    public final void aHE(String paramString)
    {
      AppMethodBeat.i(198326);
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      AppMethodBeat.o(198326);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(198325);
      ae.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[] { paramString });
      BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
      BaseEmojiStoreSearchWebViewUI.a(BaseEmojiStoreSearchWebViewUI.this).setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
      AppMethodBeat.o(198325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */