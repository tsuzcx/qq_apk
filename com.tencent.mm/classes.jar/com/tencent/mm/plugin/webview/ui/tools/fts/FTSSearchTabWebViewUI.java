package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public final void US(int paramInt)
  {
    AppMethodBeat.i(80705);
    if ((this.nKq == null) || (this.nKq.getSettings() == null))
    {
      AppMethodBeat.o(80705);
      return;
    }
    float f = getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cc.a.hQ(getContext()));
    if (f >= com.tencent.mm.cc.a.hW(getContext()))
    {
      this.nKq.getSettings().setTextZoom(160);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hV(getContext()))
    {
      this.nKq.getSettings().setTextZoom(150);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hU(getContext()))
    {
      this.nKq.getSettings().setTextZoom(140);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hT(getContext()))
    {
      this.nKq.getSettings().setTextZoom(130);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hS(getContext()))
    {
      this.nKq.getSettings().setTextZoom(120);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hR(getContext()))
    {
      this.nKq.getSettings().setTextZoom(110);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hQ(getContext()))
    {
      this.nKq.getSettings().setTextZoom(100);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= com.tencent.mm.cc.a.hP(getContext()))
    {
      this.nKq.getSettings().setTextZoom(90);
      AppMethodBeat.o(80705);
      return;
    }
    this.nKq.getSettings().setTextZoom(80);
    AppMethodBeat.o(80705);
  }
  
  public boolean bvs()
  {
    AppMethodBeat.i(80701);
    if (this.CCZ != null) {
      this.CCZ.getFtsEditText().ty.clearFocus();
    }
    int i = getIntent().getIntExtra(e.m.HhG, 0);
    if (i != 0)
    {
      ArrayList localArrayList = getIntent().getStringArrayListExtra(e.m.HhH);
      if (localArrayList != null) {
        h.wUl.f(i, new Object[] { localArrayList });
      }
    }
    boolean bool = super.bvs();
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
        i = 2131762963;
      }
      if (i >= 0) {
        break;
      }
      str = com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getString(2131755882);
      AppMethodBeat.o(80700);
      return str;
      i = 2131762939;
      continue;
      i = 2131759696;
      continue;
      i = 2131762938;
      continue;
      i = 2131759694;
      continue;
      i = 2131755401;
      continue;
      i = 2131759683;
      continue;
      i = 2131759684;
      continue;
      i = 2131759692;
      continue;
      i = 2131759693;
    }
    str = com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getString(2131762937, new Object[] { com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getString(i) });
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
    if ((d.kZ(23)) && (!b.YJ()))
    {
      i = getResources().getColor(2131101179);
      if (aj.DT()) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      aM(i, bool);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
        paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
        paramBundle.excludeTarget(16908335, true);
        getWindow().setEnterTransition(paramBundle);
      }
      AppMethodBeat.o(80699);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80703);
    super.onPause();
    com.tencent.mm.plugin.websearch.api.ai.exA();
    AppMethodBeat.o(80703);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80702);
    super.onResume();
    com.tencent.mm.plugin.websearch.api.ai.exz();
    AppMethodBeat.o(80702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI
 * JD-Core Version:    0.7.0.1
 */