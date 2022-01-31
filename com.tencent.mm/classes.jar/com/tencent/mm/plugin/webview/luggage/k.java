package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  extends j
{
  public View uSo;
  public View uSp;
  private TextView uSq;
  
  public k(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(6168);
    this.uSo = paramView;
    this.uSp = LayoutInflater.from(paramContext).inflate(2130971304, this, false);
    this.uSp.setVisibility(0);
    this.uSp.setBackgroundResource(2131690695);
    paramContext = this.uSp;
    removeAllViews();
    this.ixK = paramContext;
    this.ixL = new FrameLayout(getContext());
    this.ixL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ixL.addView(paramContext);
    this.Qz = paramView;
    this.ixM = new FrameLayout(getContext());
    this.ixM.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ixM.addView(paramView);
    addView(this.ixL);
    addView(this.ixM);
    this.uSq = ((TextView)this.uSp.findViewById(2131829546));
    AppMethodBeat.o(6168);
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(6171);
    ((ViewGroup)this.uSp.getParent()).setBackgroundColor(paramInt);
    AppMethodBeat.o(6171);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(6169);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bo.isNullOrNil(paramString))
      {
        paramString = getContext().getString(2131305882, new Object[] { paramString });
        this.uSq.setVisibility(0);
        this.uSq.setText(paramString);
        AppMethodBeat.o(6169);
        return;
      }
    }
    this.uSq.setVisibility(8);
    AppMethodBeat.o(6169);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    AppMethodBeat.i(6170);
    this.uSp.setVisibility(paramInt);
    AppMethodBeat.o(6170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.k
 * JD-Core Version:    0.7.0.1
 */