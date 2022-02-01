package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  extends j
{
  public View Cmd;
  public View Cme;
  private TextView Cmf;
  
  public k(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.Cmd = paramView;
    this.Cme = LayoutInflater.from(paramContext).inflate(2131496086, this, false);
    this.Cme.setVisibility(0);
    this.Cme.setBackgroundResource(2131101165);
    j(this.Cme, paramView);
    this.Cmf = ((TextView)this.Cme.findViewById(2131307119));
    AppMethodBeat.o(78371);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.Cme.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(78374);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(78372);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bs.isNullOrNil(paramString))
      {
        paramString = getContext().getString(2131766116, new Object[] { paramString });
        this.Cmf.setVisibility(0);
        this.Cmf.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.Cmf.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.Cme.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */