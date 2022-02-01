package com.tencent.mm.ui.websearch;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(7)
public class WebSearchVoiceUI
  extends MMActivity
{
  private b KCO = null;
  private com.tencent.mm.pluginsdk.ui.websearch.a KPQ;
  private View KPR;
  private int KPS;
  private String dCW;
  private int scene;
  private String sessionId;
  
  private int getStatusBarColor()
  {
    AppMethodBeat.i(39591);
    int i = getResources().getColor(2131101159);
    AppMethodBeat.o(39591);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496076;
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(39590);
    boolean bool = super.initNavigationSwipeBack();
    if (!isSupportNavigationSwipeBack()) {
      com.tencent.mm.ui.statusbar.a.e(getContentView(), getStatusBarColor(), true);
    }
    AppMethodBeat.o(39590);
    return bool;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(39589);
    super.initSwipeBack();
    if ((getSwipeBackLayout() != null) && (getSwipeBackLayout().getChildCount() > 0))
    {
      View localView = getSwipeBackLayout().getChildAt(0);
      getSwipeBackLayout().removeView(localView);
      this.KCO = new b(this);
      this.KCO.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.KCO);
      getSwipeBackLayout().setContentView(this.KCO);
    }
    com.tencent.mm.ui.statusbar.a.e(getContentView(), getStatusBarColor(), true);
    AppMethodBeat.o(39589);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39592);
    super.onBackPressed();
    setResult(0);
    finish();
    AppMethodBeat.o(39592);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39588);
    super.onCreate(paramBundle);
    setBackBtnColorFilter(-16777216);
    setMMTitleColor(-16777216);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(2131101159));
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101159)));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39584);
        WebSearchVoiceUI.this.finish();
        AppMethodBeat.o(39584);
        return true;
      }
    });
    if (getIntent() != null)
    {
      this.sessionId = getIntent().getStringExtra("sessionId");
      this.dCW = getIntent().getStringExtra("subSessionId");
      this.scene = getIntent().getIntExtra("key_scene", -1);
      this.KPS = getIntent().getIntExtra("key_is_nav_voice", 0);
    }
    this.KPR = findViewById(2131306548);
    this.mController.hideTitleView();
    if (this.KPQ == null)
    {
      this.KPQ = new com.tencent.mm.pluginsdk.ui.websearch.a(getContext());
      this.KPQ.setCallback(new a.a()
      {
        public final void aMB(String paramAnonymousString)
        {
          AppMethodBeat.i(39586);
          String str = paramAnonymousString;
          if (!TextUtils.isEmpty(paramAnonymousString))
          {
            str = paramAnonymousString;
            if (paramAnonymousString.length() > 2) {
              str = paramAnonymousString.substring(0, paramAnonymousString.length() - 1);
            }
          }
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("text", str);
          WebSearchVoiceUI.this.setResult(0, paramAnonymousString);
          g.yhR.f(15178, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39586);
        }
        
        public final void fcf()
        {
          AppMethodBeat.i(39585);
          WebSearchVoiceUI.this.setResult(0);
          g.yhR.f(15178, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39585);
        }
        
        public final void vK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39587);
          if (paramAnonymousBoolean) {
            g.yhR.f(15178, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          }
          AppMethodBeat.o(39587);
        }
      });
    }
    this.KPQ.fex();
    com.tencent.mm.pluginsdk.ui.websearch.a locala = this.KPQ;
    ad.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(locala.EXY), Boolean.valueOf(locala.FeV) });
    if (locala.FeV)
    {
      locala.FeV = false;
      View localView = locala.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = locala.EXY;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      locala.fez();
      locala.requestLayout();
    }
    this.KPQ.setVisibility(0);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    ((ViewGroup)findViewById(2131304239)).addView(this.KPQ, paramBundle);
    g.yhR.f(15178, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.sessionId, this.dCW, Integer.valueOf(this.scene), Integer.valueOf(this.KPS) });
    AppMethodBeat.o(39588);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39593);
    super.onDestroy();
    if (this.KPQ != null) {
      this.KPQ.destroy();
    }
    AppMethodBeat.o(39593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.WebSearchVoiceUI
 * JD-Core Version:    0.7.0.1
 */