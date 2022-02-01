package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
  extends k
{
  public View Ehs;
  public View Eht;
  private TextView Ehu;
  
  public l(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(78371);
    this.Ehs = paramView;
    this.Eht = LayoutInflater.from(paramContext).inflate(2131496086, this, false);
    this.Eht.setVisibility(0);
    this.Eht.setBackgroundResource(2131101165);
    k(this.Eht, paramView);
    this.Ehu = ((TextView)this.Eht.findViewById(2131307119));
    AppMethodBeat.o(78371);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(78374);
    ((ViewGroup)this.Eht.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(78374);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(78372);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bu.isNullOrNil(paramString))
      {
        paramString = getContext().getString(2131766116, new Object[] { paramString });
        this.Ehu.setVisibility(0);
        this.Ehu.setText(paramString);
        AppMethodBeat.o(78372);
        return;
      }
    }
    this.Ehu.setVisibility(8);
    AppMethodBeat.o(78372);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(78373);
    this.Eht.setVisibility(paramInt);
    AppMethodBeat.o(78373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */