package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.57;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI
  extends WebViewUI
  implements n.b
{
  String bVk;
  private n icu;
  private boolean rsV;
  private boolean rsW = true;
  private int rsX;
  private int type;
  
  public final void Wl()
  {
    finish();
  }
  
  public final void Wm() {}
  
  public final void Wn()
  {
    this.icu.cIL();
    showVKB();
  }
  
  public final void Wo() {}
  
  protected final void aoX()
  {
    super.aoX();
    this.bVk = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.rsV = getIntent().getBooleanExtra("showkeyboard", false);
    this.rsX = getIntent().getIntExtra("sence", 0);
    this.niQ.setWebViewClient(new BaseEmojiStoreSearchWebViewUI.a(this, (byte)0));
    this.niQ.setOnTouchListener(new BaseEmojiStoreSearchWebViewUI.1(this));
    this.icu = new n();
    a(this.icu);
    this.icu.nK(false);
    this.icu.weq = this;
    showOptionMenu(false);
    if (this.rpn != null) {
      this.rpn.lh(true);
    }
    this.niQ.setOnLongClickListener(new BaseEmojiStoreSearchWebViewUI.2(this));
  }
  
  protected final void cdU()
  {
    finish();
  }
  
  protected final boolean ces()
  {
    return true;
  }
  
  protected final int getLayoutId()
  {
    return R.i.emoji_webview_ui;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.icu != null)
    {
      this.icu.a(this, paramMenu);
      this.icu.setHint(getString(R.l.emoji_search_hit));
    }
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public final boolean pB(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.bVk = str;
    if (!bk.bl(str))
    {
      this.bVk = str;
      this.handler.post(new BaseEmojiStoreSearchWebViewUI.4(this));
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.bVk);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.rbk.cge());
    }
    try
    {
      if (this.gGn != null) {
        this.gGn.q(1, paramString);
      }
      for (;;)
      {
        XM();
        paramString = "";
        if (!bk.bl(str)) {
          paramString = str.replace(",", " ");
        }
        h.nFQ.f(13054, new Object[] { Integer.valueOf(this.rsX), Integer.valueOf(1), paramString });
        return false;
        y.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void pC(String paramString)
  {
    if ((this.rsW) && (bk.bl(paramString)))
    {
      this.rsW = false;
      if (!this.rsV) {
        ai.l(new BaseEmojiStoreSearchWebViewUI.3(this), 500L);
      }
    }
    else
    {
      return;
    }
    this.icu.cIL();
    showVKB();
  }
  
  protected void s(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.s(paramInt, paramBundle);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.rbk;
      if (!paramBundle.ready)
      {
        y.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        return;
      }
      y.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      y.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.rxU = l;
      str1 = i.a.a("getSearchEmotionDataCallBack", localHashMap, paramBundle.rxI, paramBundle.rxJ);
      y.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      ai.d(new d.57(paramBundle, str1));
      return;
    }
    this.rbk.cgd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */