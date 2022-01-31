package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class FTSSearchTabWebViewUI
  extends FTSBaseWebViewUI
{
  public final void KD(int paramInt)
  {
    AppMethodBeat.i(8538);
    if ((this.pOd == null) || (this.pOd.getSettings() == null))
    {
      AppMethodBeat.o(8538);
      return;
    }
    float f = getContext().getSharedPreferences(ah.dsP(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.gg(getContext()));
    if (f >= com.tencent.mm.cb.a.gm(getContext()))
    {
      this.pOd.getSettings().setTextZoom(160);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gl(getContext()))
    {
      this.pOd.getSettings().setTextZoom(150);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gk(getContext()))
    {
      this.pOd.getSettings().setTextZoom(140);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gj(getContext()))
    {
      this.pOd.getSettings().setTextZoom(130);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gi(getContext()))
    {
      this.pOd.getSettings().setTextZoom(120);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gh(getContext()))
    {
      this.pOd.getSettings().setTextZoom(110);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gg(getContext()))
    {
      this.pOd.getSettings().setTextZoom(100);
      AppMethodBeat.o(8538);
      return;
    }
    if (f >= com.tencent.mm.cb.a.gf(getContext()))
    {
      this.pOd.getSettings().setTextZoom(90);
      AppMethodBeat.o(8538);
      return;
    }
    this.pOd.getSettings().setTextZoom(80);
    AppMethodBeat.o(8538);
  }
  
  public void aMf()
  {
    AppMethodBeat.i(155703);
    super.aMf();
    Drawable localDrawable = com.tencent.mm.bd.a.b(this.type, getContext());
    this.mWO.getFtsEditText().getIconView().setImageDrawable(localDrawable);
    this.mWO.getFtsEditText().bDi();
    AppMethodBeat.o(155703);
  }
  
  public boolean aMm()
  {
    AppMethodBeat.i(8534);
    if (this.mWO != null) {
      this.mWO.getFtsEditText().naN.clearFocus();
    }
    int i = getIntent().getIntExtra(e.l.yVx, 0);
    if (i != 0)
    {
      ArrayList localArrayList = getIntent().getStringArrayListExtra(e.l.yVy);
      if (localArrayList != null) {
        h.qsU.e(i, new Object[] { localArrayList });
      }
    }
    boolean bool = super.aMm();
    AppMethodBeat.o(8534);
    return bool;
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(8533);
    String str = getIntent().getStringExtra("key_search_input_hint");
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(8533);
      return str;
    }
    int i = -1;
    switch (this.type)
    {
    }
    for (;;)
    {
      if (this.scene == 56) {
        i = 2131303021;
      }
      if (i >= 0) {
        break;
      }
      str = ah.getContext().getResources().getString(2131297065);
      AppMethodBeat.o(8533);
      return str;
      i = 2131303000;
      continue;
      i = 2131300223;
      continue;
      i = 2131302999;
      continue;
      i = 2131300221;
      continue;
      i = 2131296630;
      continue;
      i = 2131300210;
      continue;
      i = 2131300211;
      continue;
      i = 2131300219;
      continue;
      i = 2131300220;
    }
    str = ah.getContext().getResources().getString(2131302998, new Object[] { ah.getContext().getResources().getString(i) });
    AppMethodBeat.o(8533);
    return str;
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(8537);
    super.onClickCancelBtn(paramView);
    finish();
    AppMethodBeat.o(8537);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8532);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    AppMethodBeat.o(8532);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8536);
    super.onPause();
    an.cZI();
    AppMethodBeat.o(8536);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8535);
    super.onResume();
    an.cZH();
    AppMethodBeat.o(8535);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI
 * JD-Core Version:    0.7.0.1
 */