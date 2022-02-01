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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.z;
import java.util.ArrayList;

public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public final void Xp(int paramInt)
  {
    AppMethodBeat.i(80705);
    if ((this.osM == null) || (this.osM.getSettings() == null))
    {
      AppMethodBeat.o(80705);
      return;
    }
    float f = getContext().getSharedPreferences(ak.fow(), 0).getFloat("current_text_size_scale_key", a.ie(getContext()));
    if (f >= a.ik(getContext()))
    {
      this.osM.getSettings().setTextZoom(160);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ij(getContext()))
    {
      this.osM.getSettings().setTextZoom(150);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ii(getContext()))
    {
      this.osM.getSettings().setTextZoom(140);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ih(getContext()))
    {
      this.osM.getSettings().setTextZoom(130);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ig(getContext()))
    {
      this.osM.getSettings().setTextZoom(120);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.jdMethod_if(getContext()))
    {
      this.osM.getSettings().setTextZoom(110);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.ie(getContext()))
    {
      this.osM.getSettings().setTextZoom(100);
      AppMethodBeat.o(80705);
      return;
    }
    if (f >= a.id(getContext()))
    {
      this.osM.getSettings().setTextZoom(90);
      AppMethodBeat.o(80705);
      return;
    }
    this.osM.getSettings().setTextZoom(80);
    AppMethodBeat.o(80705);
  }
  
  public boolean bAu()
  {
    AppMethodBeat.i(80701);
    if (this.EyL != null) {
      this.EyL.getFtsEditText().vr.clearFocus();
    }
    int i = getIntent().getIntExtra(e.m.JpE, 0);
    if (i != 0)
    {
      ArrayList localArrayList = getIntent().getStringArrayListExtra(e.m.JpF);
      if (localArrayList != null) {
        g.yxI.f(i, new Object[] { localArrayList });
      }
    }
    boolean bool = super.bAu();
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
      str = ak.getContext().getResources().getString(2131755882);
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
    str = ak.getContext().getResources().getString(2131762937, new Object[] { ak.getContext().getResources().getString(i) });
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
    if ((d.lA(23)) && (!b.abu()))
    {
      i = getResources().getColor(2131101179);
      if (al.isDarkMode()) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      aZ(i, bool);
      AppMethodBeat.o(80699);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80703);
    super.onPause();
    am.eQa();
    AppMethodBeat.o(80703);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80702);
    super.onResume();
    am.ePZ();
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