package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private int Ezb;
  private View Ezx;
  
  public final void bAi()
  {
    boolean bool = false;
    AppMethodBeat.i(80692);
    super.bAi();
    this.Ezx = findViewById(2131306921);
    eXD().eQt();
    eXD().fOm();
    eXD().fOg();
    this.Ezb = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    if (getScene() == 24) {
      this.Ezx.setVisibility(4);
    }
    findViewById(2131304239).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSMoreWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        FTSSOSMoreWebViewUI.this.eXD().vr.clearFocus();
        FTSSOSMoreWebViewUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSSOSMoreWebViewUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
          FTSSOSMoreWebViewUI.this.eXD().fOj();
          FTSSOSMoreWebViewUI.this.eXD().fOi();
          AppMethodBeat.o(80691);
        }
      }, 128L);
    }
    int i = getResources().getColor(2131101179);
    if (!al.isDarkMode()) {
      bool = true;
    }
    aZ(i, bool);
    ImageButton localImageButton = eXD().getClearBtn();
    if (localImageButton != null) {
      localImageButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(80692);
  }
  
  public final int bAj()
  {
    AppMethodBeat.i(80693);
    if ((d.lA(23)) && (!com.tencent.mm.sdk.h.b.abu()))
    {
      i = getResources().getColor(2131101179);
      AppMethodBeat.o(80693);
      return i;
    }
    int i = super.bAj();
    AppMethodBeat.o(80693);
    return i;
  }
  
  public boolean bAu()
  {
    AppMethodBeat.i(80695);
    eXD().fOm();
    this.Ezx.setVisibility(0);
    boolean bool = super.bAu();
    AppMethodBeat.o(80695);
    return bool;
  }
  
  protected final void eXA()
  {
    AppMethodBeat.i(80698);
    super.eXA();
    this.Ezx.setVisibility(0);
    AppMethodBeat.o(80698);
  }
  
  protected final void eXy()
  {
    AppMethodBeat.i(80696);
    finish();
    AppMethodBeat.o(80696);
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80697);
    int i = -1;
    if ((getType() == 8) && (this.Eyy)) {
      i = 2131759697;
    }
    while (i < 0)
    {
      str = ak.getContext().getResources().getString(2131755882) + Yi(getType());
      AppMethodBeat.o(80697);
      return str;
      switch (getType())
      {
      default: 
        break;
      case 1: 
        i = 2131762939;
        break;
      case 8: 
        i = 2131759696;
        break;
      case 2: 
        i = 2131762938;
        break;
      case 16: 
        i = 2131759694;
        break;
      case 64: 
        i = 2131755401;
        break;
      case 256: 
      case 384: 
        i = 2131759683;
        break;
      case 128: 
        i = 2131759684;
        break;
      case 512: 
        i = 2131759692;
        break;
      case 1024: 
        i = 2131759693;
      }
    }
    String str = ak.getContext().getResources().getString(2131762937, new Object[] { ak.getContext().getResources().getString(i) });
    AppMethodBeat.o(80697);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131495631;
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(80694);
    super.mb(paramBoolean);
    if (!paramBoolean)
    {
      this.Eyd.setPadding(this.Ezb, 0, this.Eyd.getPaddingRight(), 0);
      eXD().fOg();
    }
    eXD().fOm();
    AppMethodBeat.o(80694);
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