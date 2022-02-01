package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ad;
import java.util.ArrayList;

public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public boolean aWU()
  {
    AppMethodBeat.i(80701);
    if (iAq() != null) {
      iAq().getFtsEditText().dzv.clearFocus();
    }
    int i = getIntent().getIntExtra(f.s.adxb, 0);
    if (i != 0)
    {
      ArrayList localArrayList = getIntent().getStringArrayListExtra(f.s.adxc);
      if (localArrayList != null) {
        h.OAn.b(i, new Object[] { localArrayList });
      }
    }
    boolean bool = super.aWU();
    AppMethodBeat.o(80701);
    return bool;
  }
  
  public final void atq(int paramInt)
  {
    AppMethodBeat.i(80705);
    if ((this.sMP == null) || (this.sMP.getSettings() == null))
    {
      AppMethodBeat.o(80705);
      return;
    }
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.md(getContext()));
    if (f >= a.mj(getContext()))
    {
      this.sMP.getSettings().setTextZoom(160);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.mi(getContext()))
    {
      this.sMP.getSettings().setTextZoom(150);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.mh(getContext()))
    {
      this.sMP.getSettings().setTextZoom(140);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.mg(getContext()))
    {
      this.sMP.getSettings().setTextZoom(130);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.mf(getContext()))
    {
      this.sMP.getSettings().setTextZoom(120);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.me(getContext()))
    {
      this.sMP.getSettings().setTextZoom(110);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.md(getContext()))
    {
      this.sMP.getSettings().setTextZoom(100);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.mc(getContext()))
    {
      this.sMP.getSettings().setTextZoom(90);
      AppMethodBeat.o(80705);
      return;
    }
    this.sMP.getSettings().setTextZoom(80);
    AppMethodBeat.o(80705);
  }
  
  protected final Drawable auD(int paramInt)
  {
    AppMethodBeat.i(296849);
    if (this.Xde)
    {
      localDrawable = getResources().getDrawable(c.h.icons_outlined_wechat_search_one_search);
      AppMethodBeat.o(296849);
      return localDrawable;
    }
    Drawable localDrawable = super.auD(paramInt);
    AppMethodBeat.o(296849);
    return localDrawable;
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80700);
    if (this.Xde)
    {
      str = MMApplicationContext.getContext().getResources().getString(c.i.app_search);
      AppMethodBeat.o(80700);
      return str;
    }
    String str = getIntent().getStringExtra("key_search_input_hint");
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(80700);
      return str;
    }
    int i = -1;
    switch (getType())
    {
    }
    for (;;)
    {
      if (getScene() == 56) {
        i = c.i.search_recommend_hint_history;
      }
      if (i >= 0) {
        break;
      }
      str = MMApplicationContext.getContext().getResources().getString(c.i.app_search);
      AppMethodBeat.o(80700);
      return str;
      i = c.i.search_education_biz_contact;
      continue;
      i = c.i.fts_header_timeline;
      continue;
      i = c.i.search_education_article;
      continue;
      i = c.i.fts_header_poi;
      continue;
      i = c.i.app_brand_entrance;
      continue;
      i = c.i.fts_header_emoji;
      continue;
      i = c.i.fts_header_emoji_product;
      continue;
      i = c.i.fts_header_music;
      continue;
      i = c.i.fts_header_novel;
    }
    str = MMApplicationContext.getContext().getResources().getString(c.i.search_detail_page_hint, new Object[] { MMApplicationContext.getContext().getResources().getString(i) });
    AppMethodBeat.o(80700);
    return str;
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80704);
    super.onClickCancelBtn(paramView);
    finish();
    AppMethodBeat.o(80704);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80699);
    super.onCreate(paramBundle);
    int i;
    if ((d.rb(23)) && (!MIUI.isMIUIV8()))
    {
      i = getResources().getColor(c.c.white);
      if (aw.isDarkMode()) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      cn(i, bool);
      AppMethodBeat.o(80699);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80703);
    super.onPause();
    as.iqk();
    AppMethodBeat.o(80703);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80702);
    super.onResume();
    as.iqj();
    AppMethodBeat.o(80702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI
 * JD-Core Version:    0.7.0.1
 */