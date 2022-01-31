package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;

@com.tencent.mm.ui.base.a(3)
public class TransparentWebViewUI
  extends GameWebViewUI
{
  protected final boolean aYK()
  {
    return false;
  }
  
  protected final void cdH()
  {
    setBackGroundColorResource(0);
    this.mController.contentView.setBackgroundResource(0);
    this.niQ.setBackgroundResource(17170445);
    this.niQ.setBackgroundColor(0);
    findViewById(R.h.webview_keyboard_ll).setBackgroundResource(17170445);
    findViewById(R.h.root_container).setBackgroundResource(17170445);
  }
  
  protected final void initView()
  {
    int i = 1;
    super.initView();
    this.rpn.rnk = true;
    this.rpn.fOd = false;
    this.rpn.lh(true);
    this.rpn.CC(0);
    if ((getIntent() != null) && (getIntent().hasExtra("show_full_screen")) && (getIntent().getBooleanExtra("show_full_screen", false))) {}
    for (;;)
    {
      if ((i != 0) && (this.rnz != null)) {
        this.rnz.setCanMove(false);
      }
      return;
      i = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.screenOrientation == 1001)
    {
      this.screenOrientation = 0;
      if (this.gAS != null) {
        this.gAS.enable();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.screenOrientation != 1002);
      this.screenOrientation = 1;
    } while (this.gAS == null);
    this.gAS.enable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.TransparentWebViewUI
 * JD-Core Version:    0.7.0.1
 */