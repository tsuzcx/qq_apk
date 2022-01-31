package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

public final class o
{
  String iIg;
  MMWebView pOn;
  boolean vhd = false;
  WebViewUI vhe;
  
  public o(WebViewUI paramWebViewUI)
  {
    this.vhe = paramWebViewUI;
  }
  
  @SuppressLint({"ResourceType"})
  private void deV()
  {
    AppMethodBeat.i(8137);
    View localView = this.vhe.findViewById(2131824788);
    if (localView != null) {
      localView.setBackgroundColor(deZ());
    }
    int i = this.vhe.getResources().getColor(2131690698);
    localView = this.vhe.findViewById(2131829546);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.vhe.findViewById(2131829548);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.vhe.findViewById(2131829547);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131232233);
    }
    AppMethodBeat.o(8137);
  }
  
  private void deW()
  {
    AppMethodBeat.i(8138);
    int i = deZ();
    this.vhe.setActionbarColor(i);
    this.vhe.showActionbarLine();
    AppMethodBeat.o(8138);
  }
  
  private boolean deY()
  {
    AppMethodBeat.i(8140);
    if (this.vhe == null)
    {
      AppMethodBeat.o(8140);
      return false;
    }
    String str2 = this.iIg;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = this.vhe.daZ();
    }
    boolean bool = e.ajq(str1);
    AppMethodBeat.o(8140);
    return bool;
  }
  
  final boolean deT()
  {
    AppMethodBeat.i(8135);
    if (this.vhe.aMh())
    {
      AppMethodBeat.o(8135);
      return true;
    }
    Intent localIntent = this.vhe.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getBooleanExtra("disable_light_actionbar_style", false))
      {
        ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
        AppMethodBeat.o(8135);
        return true;
      }
      String str = localIntent.getStringExtra("status_bar_style");
      if ((!bo.isNullOrNil(str)) && (str.equals("black")))
      {
        ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
        AppMethodBeat.o(8135);
        return true;
      }
      if (localIntent.getIntExtra("customize_status_bar_color", 0) != 0)
      {
        ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
        AppMethodBeat.o(8135);
        return true;
      }
      if (localIntent.getBooleanExtra("open_custom_style_url", false))
      {
        ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
        AppMethodBeat.o(8135);
        return true;
      }
      if (localIntent.getBooleanExtra("show_full_screen", false))
      {
        ab.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
        AppMethodBeat.o(8135);
        return true;
      }
    }
    AppMethodBeat.o(8135);
    return false;
  }
  
  final void deU()
  {
    AppMethodBeat.i(8136);
    deW();
    deV();
    deX();
    AppMethodBeat.o(8136);
  }
  
  final void deX()
  {
    AppMethodBeat.i(8139);
    if (!deY())
    {
      this.vhe.showActionbarLine();
      AppMethodBeat.o(8139);
      return;
    }
    if ((this.pOn != null) && (this.pOn.getWebScrollY() > 0))
    {
      this.vhe.showActionbarLine();
      AppMethodBeat.o(8139);
      return;
    }
    this.vhe.hideActionbarLine();
    AppMethodBeat.o(8139);
  }
  
  public final int deZ()
  {
    AppMethodBeat.i(8141);
    if (deY())
    {
      i = this.vhe.getResources().getColor(2131690697);
      AppMethodBeat.o(8141);
      return i;
    }
    int i = this.vhe.getResources().getColor(2131690692);
    AppMethodBeat.o(8141);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */