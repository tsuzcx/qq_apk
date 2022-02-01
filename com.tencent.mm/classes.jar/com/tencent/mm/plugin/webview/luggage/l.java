package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  extends k
{
  public View IUe;
  public View IUf;
  private TextView IUg;
  
  public l(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.IUe = paramView;
    this.IUf = LayoutInflater.from(paramContext).inflate(2131497073, this, false);
    this.IUf.setVisibility(0);
    this.IUf.setBackgroundResource(2131101408);
    l(this.IUf, paramView);
    this.IUg = ((TextView)this.IUf.findViewById(2131310659));
    AppMethodBeat.o(78371);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.IUf.getParent()).setBackgroundColor(paramInt);
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
        paramString = getContext().getString(2131768587, new Object[] { paramString });
        this.IUg.setVisibility(0);
        this.IUg.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.IUg.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.IUf.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */