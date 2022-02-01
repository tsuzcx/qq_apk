package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
  extends k
{
  public View DPs;
  public View DPt;
  private TextView DPu;
  
  public l(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.DPs = paramView;
    this.DPt = LayoutInflater.from(paramContext).inflate(2131496086, this, false);
    this.DPt.setVisibility(0);
    this.DPt.setBackgroundResource(2131101165);
    k(this.DPt, paramView);
    this.DPu = ((TextView)this.DPt.findViewById(2131307119));
    AppMethodBeat.o(78371);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.DPt.getParent()).setBackgroundColor(paramInt);
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
        this.DPu.setVisibility(0);
        this.DPu.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.DPu.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.DPt.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */