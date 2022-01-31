package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;

public class FTSSOSMoreWebViewUI
  extends BaseSOSWebViewUI
{
  private int vkx;
  private View vli;
  
  public final void aMf()
  {
    AppMethodBeat.i(8525);
    super.aMf();
    this.vli = findViewById(2131823716);
    dfA().dNi();
    dfA().bDj();
    this.pbT.setVisibility(0);
    dfA().bDh();
    this.vkx = com.tencent.mm.cb.a.fromDPToPix(this, 48);
    dfA().setIconRes(com.tencent.mm.bd.a.b(getType(), this));
    if (getScene() == 24) {
      this.vli.setVisibility(4);
    }
    findViewById(2131821003).setOnTouchListener(new FTSSOSMoreWebViewUI.1(this));
    if ((getIntent() != null) && (getIntent().getBooleanExtra("ftsneedkeyboard", false))) {
      getContentView().postDelayed(new FTSSOSMoreWebViewUI.2(this), 128L);
    }
    au(getResources().getColor(2131690709), true);
    ImageButton localImageButton = dfA().getClearBtn();
    if (localImageButton != null) {
      localImageButton.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(8525);
  }
  
  public final int aMg()
  {
    AppMethodBeat.i(8526);
    if ((d.fv(23)) && (!b.Mo()))
    {
      i = getResources().getColor(2131690709);
      AppMethodBeat.o(8526);
      return i;
    }
    int i = super.aMg();
    AppMethodBeat.o(8526);
    return i;
  }
  
  public boolean aMm()
  {
    AppMethodBeat.i(8528);
    dfA().bDj();
    this.vli.setVisibility(0);
    boolean bool = super.aMm();
    AppMethodBeat.o(8528);
    return bool;
  }
  
  protected final void dfw()
  {
    AppMethodBeat.i(8529);
    finish();
    AppMethodBeat.o(8529);
  }
  
  protected final void dfx()
  {
    AppMethodBeat.i(8531);
    super.dfx();
    this.vli.setVisibility(0);
    AppMethodBeat.o(8531);
  }
  
  protected String getHint()
  {
    AppMethodBeat.i(8530);
    int i = -1;
    if ((getType() == 8) && (this.vjR)) {
      i = 2131300224;
    }
    while (i < 0)
    {
      str = ah.getContext().getResources().getString(2131297065) + KH(getType());
      AppMethodBeat.o(8530);
      return str;
      switch (getType())
      {
      default: 
        break;
      case 1: 
        i = 2131303000;
        break;
      case 8: 
        i = 2131300223;
        break;
      case 2: 
        i = 2131302999;
        break;
      case 16: 
        i = 2131300221;
        break;
      case 64: 
        i = 2131296630;
        break;
      case 256: 
      case 384: 
        i = 2131300210;
        break;
      case 128: 
        i = 2131300211;
        break;
      case 512: 
        i = 2131300219;
        break;
      case 1024: 
        i = 2131300220;
      }
    }
    String str = ah.getContext().getResources().getString(2131302998, new Object[] { ah.getContext().getResources().getString(i) });
    AppMethodBeat.o(8530);
    return str;
  }
  
  public int getLayoutId()
  {
    return 2130970904;
  }
  
  public final void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(8527);
    super.hQ(paramBoolean);
    if (!paramBoolean)
    {
      this.vjy.setPadding(this.vkx, 0, this.vjy.getPaddingRight(), 0);
      this.pbT.setVisibility(0);
      dfA().bDh();
    }
    dfA().bDj();
    AppMethodBeat.o(8527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI
 * JD-Core Version:    0.7.0.1
 */