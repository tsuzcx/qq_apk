package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.ui.widget.MMWebView;

@com.tencent.mm.ui.base.a(3)
public class TransparentWebViewUI
  extends GameWebViewUI
{
  public final boolean aYi()
  {
    return false;
  }
  
  protected final void ddH()
  {
    AppMethodBeat.i(7587);
    setBackGroundColorResource(0);
    getContentView().setBackgroundResource(0);
    this.pOd.setBackgroundResource(17170445);
    this.pOd.setBackgroundColor(0);
    findViewById(2131823716).setBackgroundResource(17170445);
    findViewById(2131823717).setBackgroundResource(17170445);
    AppMethodBeat.o(7587);
  }
  
  public void initView()
  {
    int i = 1;
    AppMethodBeat.i(7586);
    super.initView();
    this.vgh.vdj = true;
    this.vgh.hht = false;
    this.vgh.op(true);
    this.vgh.Kw(0);
    if ((getIntent() != null) && (getIntent().hasExtra("show_full_screen")) && (getIntent().getBooleanExtra("show_full_screen", false))) {}
    for (;;)
    {
      if ((i != 0) && (this.vem != null)) {
        this.vem.setCanMove(false);
      }
      AppMethodBeat.o(7586);
      return;
      i = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7585);
    super.onCreate(paramBundle);
    if (this.screenOrientation == 1001)
    {
      this.screenOrientation = 0;
      if (this.vep != null)
      {
        this.vep.enable();
        AppMethodBeat.o(7585);
      }
    }
    else if (this.screenOrientation == 1002)
    {
      this.screenOrientation = 1;
      if (this.vep != null) {
        this.vep.enable();
      }
    }
    AppMethodBeat.o(7585);
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