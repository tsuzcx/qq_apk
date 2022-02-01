package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.ArrayList;

public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public final void agP(int paramInt)
  {
    AppMethodBeat.i(80705);
    if ((this.pGj == null) || (this.pGj.getSettings() == null))
    {
      AppMethodBeat.o(80705);
      return;
    }
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.iX(getContext()));
    if (f >= a.jd(getContext()))
    {
      this.pGj.getSettings().setTextZoom(160);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.jc(getContext()))
    {
      this.pGj.getSettings().setTextZoom(150);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.jb(getContext()))
    {
      this.pGj.getSettings().setTextZoom(140);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ja(getContext()))
    {
      this.pGj.getSettings().setTextZoom(130);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.iZ(getContext()))
    {
      this.pGj.getSettings().setTextZoom(120);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.iY(getContext()))
    {
      this.pGj.getSettings().setTextZoom(110);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.iX(getContext()))
    {
      this.pGj.getSettings().setTextZoom(100);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.iW(getContext()))
    {
      this.pGj.getSettings().setTextZoom(90);
      AppMethodBeat.o(80705);
      return;
    }
    this.pGj.getSettings().setTextZoom(80);
    AppMethodBeat.o(80705);
  }
  
  public boolean awE()
  {
    AppMethodBeat.i(80701);
    if (this.JnL != null) {
      this.JnL.getFtsEditText().vy.clearFocus();
    }
    int i = getIntent().getIntExtra(e.p.OzF, 0);
    if (i != 0)
    {
      ArrayList localArrayList = getIntent().getStringArrayListExtra(e.p.OzG);
      if (localArrayList != null) {
        h.CyF.a(i, new Object[] { localArrayList });
      }
    }
    boolean bool = super.awE();
    AppMethodBeat.o(80701);
    return bool;
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80700);
    String str = getIntent().getStringExtra("key_search_input_hint");
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(80700);
      return str;
    }
    int i = -1;
    switch (this.type)
    {
    }
    for (;;)
    {
      if (this.scene == 56) {
        i = 2131765100;
      }
      if (i >= 0) {
        break;
      }
      str = MMApplicationContext.getContext().getResources().getString(2131755972);
      AppMethodBeat.o(80700);
      return str;
      i = 2131765075;
      continue;
      i = 2131761017;
      continue;
      i = 2131765074;
      continue;
      i = 2131761015;
      continue;
      i = 2131755440;
      continue;
      i = 2131761004;
      continue;
      i = 2131761005;
      continue;
      i = 2131761013;
      continue;
      i = 2131761014;
    }
    str = MMApplicationContext.getContext().getResources().getString(2131765073, new Object[] { MMApplicationContext.getContext().getResources().getString(i) });
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
    if ((d.oD(23)) && (!MIUI.isMIUIV8()))
    {
      i = getResources().getColor(2131101424);
      if (ao.isDarkMode()) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      bt(i, bool);
      AppMethodBeat.o(80699);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80703);
    super.onPause();
    ar.fYn();
    AppMethodBeat.o(80703);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80702);
    super.onResume();
    ar.fYm();
    AppMethodBeat.o(80702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI
 * JD-Core Version:    0.7.0.1
 */