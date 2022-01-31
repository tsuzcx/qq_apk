package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.62;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI
  extends WebViewUI
  implements q.b
{
  private q mSearchViewHelper;
  String query;
  private int type;
  private boolean vjb;
  private boolean vjc = true;
  private int vjd;
  
  public final void aMf()
  {
    AppMethodBeat.i(8293);
    super.aMf();
    this.query = getIntent().getStringExtra("keyword");
    this.type = getIntent().getIntExtra("type", 0);
    this.vjb = getIntent().getBooleanExtra("showkeyboard", false);
    this.vjd = getIntent().getIntExtra("sence", 0);
    this.pOd.setWebViewClient(new BaseEmojiStoreSearchWebViewUI.a(this, (byte)0));
    this.pOd.setOnTouchListener(new BaseEmojiStoreSearchWebViewUI.1(this));
    this.mSearchViewHelper = new q();
    addSearchMenu(true, this.mSearchViewHelper);
    this.mSearchViewHelper.ru(false);
    this.mSearchViewHelper.Axg = this;
    showOptionMenu(false);
    if (this.vgh != null) {
      this.vgh.op(true);
    }
    this.pOd.setOnLongClickListener(new BaseEmojiStoreSearchWebViewUI.2(this));
    AppMethodBeat.o(8293);
  }
  
  public final void aZy()
  {
    AppMethodBeat.i(8300);
    finish();
    AppMethodBeat.o(8300);
  }
  
  public final void apN()
  {
    AppMethodBeat.i(8295);
    finish();
    AppMethodBeat.o(8295);
  }
  
  public final void apO() {}
  
  public final void apP()
  {
    AppMethodBeat.i(8298);
    this.mSearchViewHelper.dNz();
    showVKB();
    AppMethodBeat.o(8298);
  }
  
  public final void apQ() {}
  
  public final boolean deA()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130969421;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(8294);
    if (this.mSearchViewHelper != null)
    {
      this.mSearchViewHelper.a(this, paramMenu);
      this.mSearchViewHelper.setHint(getString(2131299169));
    }
    AppMethodBeat.o(8294);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8301);
    super.onDestroy();
    AppMethodBeat.o(8301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void w(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8299);
    ab.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      super.w(paramInt, paramBundle);
      AppMethodBeat.o(8299);
      return;
    case 80001: 
      String str1 = paramBundle.getString("emoji_store_json_data");
      boolean bool = paramBundle.getBoolean("emoji_store_new_query", true);
      String str2 = paramBundle.getString("emoji_store_page_buf");
      long l = paramBundle.getLong("emoji_store_search_id");
      paramBundle = this.uQS;
      if (!paramBundle.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
        AppMethodBeat.o(8299);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("newQuery", Boolean.valueOf(bool));
      localHashMap.put("nextPageBuffer", str2);
      ab.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[] { Long.valueOf(l) });
      paramBundle.voO = l;
      str1 = i.a.b("getSearchEmotionDataCallBack", localHashMap, paramBundle.voB, paramBundle.voC);
      ab.i("MicroMsg.JsApiHandler", "event:%s", new Object[] { str1 });
      al.d(new d.62(paramBundle, str1));
      AppMethodBeat.o(8299);
      return;
    }
    this.uQS.dgo();
    AppMethodBeat.o(8299);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(8297);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    this.query = str;
    if (!bo.isNullOrNil(str))
    {
      this.query = str;
      this.handler.post(new BaseEmojiStoreSearchWebViewUI.4(this));
      paramString = new Bundle();
      paramString.putInt("type", this.type);
      paramString.putString("nextPageBuffer", "");
      paramString.putString("keyword", this.query);
      paramString.putInt("webview_instance_id", hashCode());
      paramString.putLong("searchID", this.uQS.dgq());
    }
    try
    {
      if (this.igU != null) {
        this.igU.u(1, paramString);
      }
      for (;;)
      {
        hideVKB();
        paramString = "";
        if (!bo.isNullOrNil(str)) {
          paramString = str.replace(",", " ");
        }
        h.qsU.e(13054, new Object[] { Integer.valueOf(this.vjd), Integer.valueOf(1), paramString });
        AppMethodBeat.o(8297);
        return false;
        ab.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
      }
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", paramString, "doSearch", new Object[0]);
      }
    }
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(8296);
    if ((this.vjc) && (bo.isNullOrNil(paramString)))
    {
      this.vjc = false;
      if (!this.vjb)
      {
        al.p(new BaseEmojiStoreSearchWebViewUI.3(this), 500L);
        AppMethodBeat.o(8296);
        return;
      }
      this.mSearchViewHelper.dNz();
      showVKB();
    }
    AppMethodBeat.o(8296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
 * JD-Core Version:    0.7.0.1
 */