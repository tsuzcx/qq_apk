package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends j
{
  public View ATQ;
  public View ATR;
  private TextView ATS;
  
  public k(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.ATQ = paramView;
    this.ATR = LayoutInflater.from(paramContext).inflate(2131496086, this, false);
    this.ATR.setVisibility(0);
    this.ATR.setBackgroundResource(2131101165);
    j(this.ATR, paramView);
    this.ATS = ((TextView)this.ATR.findViewById(2131307119));
    AppMethodBeat.o(78371);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.ATR.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(78374);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(78372);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bt.isNullOrNil(paramString))
      {
        paramString = getContext().getString(2131766116, new Object[] { paramString });
        this.ATS.setVisibility(0);
        this.ATS.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.ATS.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.ATR.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */