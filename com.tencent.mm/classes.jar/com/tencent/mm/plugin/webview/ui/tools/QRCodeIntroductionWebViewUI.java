package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.ui.base.h.c;

public class QRCodeIntroductionWebViewUI
  extends WebViewUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79672);
    super.onCreate(paramBundle);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(79669);
        QRCodeIntroductionWebViewUI.a(QRCodeIntroductionWebViewUI.this);
        AppMethodBeat.o(79669);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(79670);
        QRCodeIntroductionWebViewUI.this.finish();
        AppMethodBeat.o(79670);
        return true;
      }
    });
    AppMethodBeat.o(79672);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI
 * JD-Core Version:    0.7.0.1
 */