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
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.search.FTSEditTextView;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private View CDI;
  private int CDm;
  
  public final void bvh()
  {
    boolean bool = false;
    AppMethodBeat.i(80692);
    super.bvh();
    this.CDI = findViewById(2131306921);
    eEX().exR();
    eEX().fth();
    this.ucS.setVisibility(0);
    eEX().ftb();
    this.CDm = a.fromDPToPix(this, 48);
    if (getScene() == 24) {
      this.CDI.setVisibility(4);
    }
    findViewById(2131304239).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(80690);
        FTSSOSMoreWebViewUI.this.eEX().ty.clearFocus();
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
          FTSSOSMoreWebViewUI.this.eEX().fte();
          FTSSOSMoreWebViewUI.this.eEX().ftd();
          AppMethodBeat.o(80691);
        }
      }, 128L);
    }
    int i = getResources().getColor(2131101179);
    if (!aj.DT()) {
      bool = true;
    }
    aM(i, bool);
    ImageButton localImageButton = eEX().getClearBtn();
    if (localImageButton != null) {
      localImageButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(80692);
  }
  
  public final int bvi()
  {
    AppMethodBeat.i(80693);
    if ((d.kZ(23)) && (!b.YJ()))
    {
      i = getResources().getColor(2131101179);
      AppMethodBeat.o(80693);
      return i;
    }
    int i = super.bvi();
    AppMethodBeat.o(80693);
    return i;
  }
  
  public boolean bvs()
  {
    AppMethodBeat.i(80695);
    eEX().fth();
    this.CDI.setVisibility(0);
    boolean bool = super.bvs();
    AppMethodBeat.o(80695);
    return bool;
  }
  
  protected final void eET()
  {
    AppMethodBeat.i(80696);
    finish();
    AppMethodBeat.o(80696);
  }
  
  protected final void eEU()
  {
    AppMethodBeat.i(80698);
    super.eEU();
    this.CDI.setVisibility(0);
    AppMethodBeat.o(80698);
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(80697);
    int i = -1;
    if ((getType() == 8) && (this.CCM)) {
      i = 2131759697;
    }
    while (i < 0)
    {
      str = ai.getContext().getResources().getString(2131755882) + VM(getType());
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
    String str = ai.getContext().getResources().getString(2131762937, new Object[] { ai.getContext().getResources().getString(i) });
    AppMethodBeat.o(80697);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2131495631;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(80694);
    super.lF(paramBoolean);
    if (!paramBoolean)
    {
      this.CCt.setPadding(this.CDm, 0, this.CCt.getPaddingRight(), 0);
      this.ucS.setVisibility(0);
      eEX().ftb();
    }
    eEX().fth();
    AppMethodBeat.o(80694);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI
 * JD-Core Version:    0.7.0.1
 */