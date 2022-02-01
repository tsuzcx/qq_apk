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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private View JoE;
  private int Joe;
  
  public boolean awE()
  {
    AppMethodBeat.i(80695);
    ggL().gXf();
    this.JoE.setVisibility(0);
    boolean bool = super.awE();
    AppMethodBeat.o(80695);
    return bool;
  }
  
  public final int bXh()
  {
    AppMethodBeat.i(80693);
    if ((d.oD(23)) && (!MIUI.isMIUIV8()))
    {
      i = getResources().getColor(2131101424);
      AppMethodBeat.o(80693);
      return i;
    }
    int i = super.bXh();
    AppMethodBeat.o(80693);
    return i;
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(80694);
    super.eh(paramBoolean);
    if (!paramBoolean)
    {
      this.Jnb.setPadding(this.Joe, 0, this.Jnb.getPaddingRight(), 0);
      ggL().gWY();
    }
    ggL().gXf();
    AppMethodBeat.o(80694);
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80697);
    int i = -1;
    if ((getType() == 8) && (this.Jnz)) {
      i = 2131761018;
    }
    while (i < 0)
    {
      str = MMApplicationContext.getContext().getResources().getString(2131755972) + agR(getType());
      AppMethodBeat.o(80697);
      return str;
      switch (getType())
      {
      default: 
        break;
      case 1: 
        i = 2131765075;
        break;
      case 8: 
        i = 2131761017;
        break;
      case 2: 
        i = 2131765074;
        break;
      case 16: 
        i = 2131761015;
        break;
      case 64: 
        i = 2131755440;
        break;
      case 256: 
      case 384: 
        i = 2131761004;
        break;
      case 128: 
        i = 2131761005;
        break;
      case 512: 
        i = 2131761013;
        break;
      case 1024: 
        i = 2131761014;
      }
    }
    String str = MMApplicationContext.getContext().getResources().getString(2131765073, new Object[] { MMApplicationContext.getContext().getResources().getString(i) });
    AppMethodBeat.o(80697);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131496533;
  }
  
  protected final void ggF()
  {
    AppMethodBeat.i(80696);
    finish();
    AppMethodBeat.o(80696);
  }
  
  protected final void ggH()
  {
    AppMethodBeat.i(80698);
    super.ggH();
    this.JoE.setVisibility(0);
    AppMethodBeat.o(80698);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(211289);
    super.onCreate(paramBundle);
    this.JoE = findViewById(2131310394);
    ggL().fYP();
    ggL().gXf();
    ggL().gWY();
    this.Joe = a.fromDPToPix(this, 48);
    if (getScene() == 24) {
      this.JoE.setVisibility(4);
    }
    findViewById(2131307157).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80690);
        FTSSOSMoreWebViewUI.this.ggL().vy.clearFocus();
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
          FTSSOSMoreWebViewUI.this.ggL().awD();
          FTSSOSMoreWebViewUI.this.ggL().awC();
          AppMethodBeat.o(80691);
        }
      }, 128L);
    }
    int i = getResources().getColor(2131101424);
    if (!ao.isDarkMode()) {
      bool = true;
    }
    bt(i, bool);
    paramBundle = ggL().getClearBtn();
    if (paramBundle != null) {
      paramBundle.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(211289);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI
 * JD-Core Version:    0.7.0.1
 */