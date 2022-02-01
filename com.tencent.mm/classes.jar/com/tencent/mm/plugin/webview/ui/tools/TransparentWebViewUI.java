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
  public final boolean bRP()
  {
    return false;
  }
  
  protected final void eVH()
  {
    AppMethodBeat.i(79798);
    setBackGroundColorResource(0);
    getContentView().setBackgroundResource(0);
    this.osM.setBackgroundResource(17170445);
    this.osM.setBackgroundColor(0);
    findViewById(2131306921).setBackgroundResource(17170445);
    findViewById(2131304241).setBackgroundResource(17170445);
    AppMethodBeat.o(79798);
  }
  
  public void initView()
  {
    int i = 1;
    AppMethodBeat.i(79797);
    super.initView();
    this.Ewp.EtH = true;
    this.Ewp.jZw = false;
    this.Ewp.vm(true);
    this.Ewp.Yc(0);
    if ((getIntent() != null) && (getIntent().hasExtra("show_full_screen")) && (getIntent().getBooleanExtra("show_full_screen", false))) {}
    for (;;)
    {
      if ((i != 0) && (this.EuM != null)) {
        this.EuM.setCanMove(false);
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
    if (this.screenOrientation == 1001)
    {
      this.screenOrientation = 0;
      if (this.EuP != null)
      {
        this.EuP.enable();
        AppMethodBeat.o(79796);
      }
    }
    else if (this.screenOrientation == 1002)
    {
      this.screenOrientation = 1;
      if (this.EuP != null) {
        this.EuP.enable();
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