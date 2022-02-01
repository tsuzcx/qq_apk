package com.tencent.mm.ui.websearch;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.y;

@com.tencent.mm.ui.base.a(7)
public class WebSearchVoiceUI
  extends MMActivity
{
  private b afCA = null;
  private com.tencent.mm.pluginsdk.ui.websearch.a afRQ;
  private View afRR;
  private int afRS;
  private String hVn;
  private int scene;
  private String sessionId;
  
  private int jEy()
  {
    AppMethodBeat.i(39591);
    int i = getResources().getColor(R.e.websearch_bg);
    AppMethodBeat.o(39591);
    return i;
  }
  
  public int getLayoutId()
  {
    return R.i.websearch_voice_ui;
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(39590);
    boolean bool = super.initNavigationSwipeBack();
    if (!isSupportNavigationSwipeBack()) {
      com.tencent.mm.ui.statusbar.a.h(getContentView(), jEy(), true);
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
      this.afCA = new b(this);
      this.afCA.addView(localView, new FrameLayout.LayoutParams(-1, -1));
      getSwipeBackLayout().addView(this.afCA);
      getSwipeBackLayout().setContentView(this.afCA);
    }
    com.tencent.mm.ui.statusbar.a.h(getContentView(), jEy(), true);
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
    setBackBtnColorFilter(R.e.BW_0);
    setMMTitleColor(-16777216);
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.websearch_bg));
      getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.websearch_bg)));
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
      this.hVn = getIntent().getStringExtra("subSessionId");
      this.scene = getIntent().getIntExtra("key_scene", -1);
      this.afRS = getIntent().getIntExtra("key_is_nav_voice", 0);
    }
    this.afRR = findViewById(R.h.voiceinput_mask_view);
    this.mController.hideTitleView();
    if (this.afRQ == null)
    {
      this.afRQ = new com.tencent.mm.pluginsdk.ui.websearch.a(getContext());
      this.afRQ.setCallback(new a.a()
      {
        public final void JE(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39587);
          if (paramAnonymousBoolean) {
            h.OAn.b(15178, new Object[] { Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          }
          AppMethodBeat.o(39587);
        }
        
        public final void bqK(String paramAnonymousString)
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
          h.OAn.b(15178, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39586);
        }
        
        public final void iKN()
        {
          AppMethodBeat.i(39585);
          WebSearchVoiceUI.this.setResult(0);
          h.OAn.b(15178, new Object[] { Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(WebSearchVoiceUI.this), WebSearchVoiceUI.b(WebSearchVoiceUI.this), Integer.valueOf(WebSearchVoiceUI.c(WebSearchVoiceUI.this)), Integer.valueOf(WebSearchVoiceUI.d(WebSearchVoiceUI.this)) });
          WebSearchVoiceUI.this.finish();
          AppMethodBeat.o(39585);
        }
      });
    }
    this.afRQ.iNo();
    com.tencent.mm.pluginsdk.ui.websearch.a locala = this.afRQ;
    Log.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(locala.Yea), Boolean.valueOf(locala.Ylr) });
    if (locala.Ylr)
    {
      locala.Ylr = false;
      View localView = locala.findViewById(R.h.gcO);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = locala.Yea;
      paramBundle = localLayoutParams;
      if (localLayoutParams == null) {
        paramBundle = new LinearLayout.LayoutParams(-1, i);
      }
      paramBundle.height = i;
      localView.setLayoutParams(paramBundle);
      locala.iNq();
      locala.requestLayout();
    }
    this.afRQ.setVisibility(0);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    ((ViewGroup)findViewById(R.h.root)).addView(this.afRQ, paramBundle);
    h.OAn.b(15178, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.sessionId, this.hVn, Integer.valueOf(this.scene), Integer.valueOf(this.afRS) });
    AppMethodBeat.o(39588);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39593);
    super.onDestroy();
    if (this.afRQ != null) {
      this.afRQ.destroy();
    }
    AppMethodBeat.o(39593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.websearch.WebSearchVoiceUI
 * JD-Core Version:    0.7.0.1
 */