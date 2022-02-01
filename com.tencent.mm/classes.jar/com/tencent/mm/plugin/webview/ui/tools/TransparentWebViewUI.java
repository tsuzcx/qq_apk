package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.ui.widget.MMWebView;

@com.tencent.mm.ui.base.a(3)
public class TransparentWebViewUI
  extends GameWebViewUI
{
  public final boolean cDX()
  {
    return false;
  }
  
  protected final void gXB()
  {
    AppMethodBeat.i(79798);
    setBackGroundColorResource(0);
    getContentView().setBackgroundResource(0);
    this.pHS.setBackgroundResource(17170445);
    this.pHS.setBackgroundColor(0);
    findViewById(c.f.webview_keyboard_ll).setBackgroundResource(17170445);
    findViewById(c.f.root_container).setBackgroundResource(17170445);
    AppMethodBeat.o(79798);
  }
  
  public void initView()
  {
    int i = 1;
    AppMethodBeat.i(79797);
    super.initView();
    l locall = this.QgG;
    l.gYh();
    locall.Qeo = true;
    this.QgG.nWH = false;
    this.QgG.Dc(true);
    this.QgG.aoA(0);
    if ((getIntent() != null) && (getIntent().hasExtra("show_full_screen")) && (getIntent().getBooleanExtra("show_full_screen", false))) {}
    for (;;)
    {
      if ((i != 0) && (this.Qfd != null)) {
        this.Qfd.setCanMove(false);
      }
      AppMethodBeat.o(79797);
      return;
      i = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79796);
    super.onCreate(paramBundle);
    if (this.PJe == 1001)
    {
      this.PJe = 0;
      if (this.Qfg != null)
      {
        this.Qfg.enable();
        AppMethodBeat.o(79796);
      }
    }
    else if (this.PJe == 1002)
    {
      this.PJe = 1;
      if (this.Qfg != null) {
        this.Qfg.enable();
      }
    }
    AppMethodBeat.o(79796);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.TransparentWebViewUI
 * JD-Core Version:    0.7.0.1
 */