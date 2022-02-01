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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@com.tencent.mm.ui.base.a(7)
public class WebSearchVoiceUI
  extends MMActivity
{
  private b ILH = null;
  private com.tencent.mm.pluginsdk.ui.websearch.a IYL;
  private View IYM;
  private int IYN;
  private String drf;
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
      this.ILH = new b(this);
      this.ILH.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.ILH);
      getSwipeBackLayout().setContentView(this.ILH);
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
      this.drf = getIntent().getStringExtra("subSessionId");
      this.scene = getIntent().getIntExtra("key_scene", -1);
      this.IYN = getIntent().getIntExtra("key_is_nav_voice", 0);
    }
    this.IYM = findViewById(2131306548);
    this.mController.hideTitleView();
    if (this.IYL == null)
    {
      this.IYL = new com.tencent.mm.pluginsdk.ui.websearch.a(getContext());
      this.IYL.setCallback(new a.a()
      {
        public final void aGY(String paramAnonymousString)
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
          h.wUl.f(15178, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39586);
        }
        
        public final void eNg()
        {
          AppMethodBeat.i(39585);
          WebSearchVoiceUI.this.setResult(0);
          h.wUl.f(15178, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39585);
        }
        
        public final void uZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39587);
          if (paramAnonymousBoolean) {
            h.wUl.f(15178, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          }
          AppMethodBeat.o(39587);
        }
      });
    }
    this.IYL.ePv();
    com.tencent.mm.pluginsdk.ui.websearch.a locala = this.IYL;
    ac.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(locala.DsU), Boolean.valueOf(locala.DzM) });
    if (locala.DzM)
    {
      locala.DzM = false;
      View localView = locala.findViewById(2131306495);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = locala.DsU;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      locala.ePx();
      locala.requestLayout();
    }
    this.IYL.setVisibility(0);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    ((ViewGroup)findViewById(2131304239)).addView(this.IYL, paramBundle);
    h.wUl.f(15178, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.sessionId, this.drf, Integer.valueOf(this.scene), Integer.valueOf(this.IYN) });
    AppMethodBeat.o(39588);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39593);
    super.onDestroy();
    if (this.IYL != null) {
      this.IYL.destroy();
    }
    AppMethodBeat.o(39593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.WebSearchVoiceUI
 * JD-Core Version:    0.7.0.1
 */