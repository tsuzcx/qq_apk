package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private View QlY;
  private int Qlw;
  
  public boolean aDV()
  {
    AppMethodBeat.i(80695);
    haa().hXQ();
    this.QlY.setVisibility(0);
    boolean bool = super.aDV();
    AppMethodBeat.o(80695);
    return bool;
  }
  
  public final int cjL()
  {
    AppMethodBeat.i(80693);
    if ((d.qV(23)) && (!MIUI.isMIUIV8()))
    {
      i = getResources().getColor(c.c.white);
      AppMethodBeat.o(80693);
      return i;
    }
    int i = super.cjL();
    AppMethodBeat.o(80693);
    return i;
  }
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(80694);
    super.eF(paramBoolean);
    if (!paramBoolean)
    {
      this.Qks.setPadding(this.Qlw, 0, this.Qks.getPaddingRight(), 0);
      haa().hXB();
    }
    haa().hXQ();
    AppMethodBeat.o(80694);
  }
  
  protected final void gZU()
  {
    AppMethodBeat.i(80696);
    finish();
    AppMethodBeat.o(80696);
  }
  
  protected final void gZW()
  {
    AppMethodBeat.i(80698);
    super.gZW();
    this.QlY.setVisibility(0);
    AppMethodBeat.o(80698);
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80697);
    int i = -1;
    if ((getType() == 8) && (this.QkQ)) {
      i = c.i.fts_header_timeline_publisher;
    }
    while (i < 0)
    {
      str = MMApplicationContext.getContext().getResources().getString(c.i.app_search) + aoI(getType());
      AppMethodBeat.o(80697);
      return str;
      switch (getType())
      {
      default: 
        break;
      case 1: 
        i = c.i.search_education_biz_contact;
        break;
      case 8: 
        i = c.i.fts_header_timeline;
        break;
      case 2: 
        i = c.i.search_education_article;
        break;
      case 16: 
        i = c.i.fts_header_poi;
        break;
      case 64: 
        i = c.i.app_brand_entrance;
        break;
      case 256: 
      case 384: 
        i = c.i.fts_header_emoji;
        break;
      case 128: 
        i = c.i.fts_header_emoji_product;
        break;
      case 512: 
        i = c.i.fts_header_music;
        break;
      case 1024: 
        i = c.i.fts_header_novel;
      }
    }
    String str = MMApplicationContext.getContext().getResources().getString(c.i.search_detail_page_hint, new Object[] { MMApplicationContext.getContext().getResources().getString(i) });
    AppMethodBeat.o(80697);
    return str;
  }
  
  public int getLayoutId()
  {
    return c.g.sos_more_webview_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(265887);
    super.onCreate(paramBundle);
    this.QlY = findViewById(c.f.webview_keyboard_ll);
    haa().gRA();
    haa().hXQ();
    haa().hXB();
    this.Qlw = a.fromDPToPix(this, 48);
    if (getScene() == 24) {
      this.QlY.setVisibility(4);
    }
    findViewById(c.f.root).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80690);
        FTSSOSMoreWebViewUI.this.haa().bGw.clearFocus();
        FTSSOSMoreWebViewUI.this.hideVKB();
        AppMethodBeat.o(80690);
        return false;
      }
    });
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsneedkeyboard", false))) {
      getContentView().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80691);
          FTSSOSMoreWebViewUI.this.haa().aDU();
          FTSSOSMoreWebViewUI.this.haa().aDT();
          AppMethodBeat.o(80691);
        }
      }, 128L);
    }
    int i = getResources().getColor(c.c.white);
    if (!ar.isDarkMode()) {
      bool = true;
    }
    bF(i, bool);
    paramBundle = haa().getClearBtn();
    if (paramBundle != null) {
      paramBundle.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(265887);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI
 * JD-Core Version:    0.7.0.1
 */