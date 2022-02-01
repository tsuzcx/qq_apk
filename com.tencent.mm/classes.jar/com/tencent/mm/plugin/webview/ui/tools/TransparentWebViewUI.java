package com.tencent.mm.plugin.webview.ui.tools;

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
  public final boolean dhz()
  {
    return false;
  }
  
  public void initView()
  {
    int i = 1;
    AppMethodBeat.i(79797);
    super.initView();
    this.WYD.iyd();
    this.WYD.qWv = false;
    this.WYD.IJ(true);
    this.WYD.aut(0);
    if ((getIntent() != null) && (getIntent().hasExtra("show_full_screen")) && (getIntent().getBooleanExtra("show_full_screen", false))) {}
    for (;;)
    {
      if ((i != 0) && (this.WXa != null)) {
        this.WXa.setCanMove(false);
      }
      AppMethodBeat.o(79797);
      return;
      i = 0;
    }
  }
  
  protected final void ixx()
  {
    AppMethodBeat.i(79798);
    setBackGroundColorResource(0);
    getContentView().setBackgroundResource(0);
    this.sMP.setBackgroundResource(17170445);
    this.sMP.setBackgroundColor(0);
    findViewById(c.f.webview_keyboard_ll).setBackgroundResource(17170445);
    findViewById(c.f.root_container).setBackgroundResource(17170445);
    AppMethodBeat.o(79798);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79796);
    super.onCreate(paramBundle);
    if (this.Wzx == 1001)
    {
      this.Wzx = 0;
      if (this.WXe != null)
      {
        this.WXe.enable();
        AppMethodBeat.o(79796);
      }
    }
    else if (this.Wzx == 1002)
    {
      this.Wzx = 1;
      if (this.WXe != null) {
        this.WXe.enable();
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