package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  extends l
{
  private View WGS;
  private View WGT;
  private TextView WGU;
  
  public m(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.WGS = paramView;
    this.WGT = LayoutInflater.from(paramContext).inflate(c.g.webview_logo_layout, this, false);
    this.WGT.setVisibility(0);
    this.WGT.setBackgroundResource(c.c.webview_logo_bg_color);
    h(this.WGT, paramView);
    this.WGU = ((TextView)this.WGT.findViewById(c.f.x5_logo_url));
    AppMethodBeat.o(78371);
  }
  
  public final void iuC()
  {
    AppMethodBeat.i(295953);
    setPullDownEnabled(false);
    this.WGT.setVisibility(8);
    this.WGS.setBackgroundColor(0);
    setBackgroundColor(0);
    AppMethodBeat.o(295953);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.WGT.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(78374);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(78372);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!Util.isNullOrNil(paramString))
      {
        paramString = getContext().getString(c.i.webview_logo_url, new Object[] { paramString });
        this.WGU.setVisibility(0);
        this.WGU.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.WGU.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.WGT.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */