package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;

public final class l
  extends k
{
  public View rcC;
  public View rcD;
  private TextView rcE;
  
  public l(Context paramContext, View paramView)
  {
    super(paramContext);
    this.rcC = paramView;
    this.rcD = LayoutInflater.from(paramContext).inflate(R.i.webview_logo_layout, this, false);
    this.rcD.setVisibility(0);
    this.rcD.setBackgroundResource(R.e.webview_logo_bg_color);
    paramContext = this.rcD;
    removeAllViews();
    this.gUB = paramContext;
    this.gUC = new FrameLayout(getContext());
    this.gUC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.gUC.addView(paramContext);
    this.QR = paramView;
    this.gUD = new FrameLayout(getContext());
    this.gUD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.gUD.addView(paramView);
    addView(this.gUC);
    addView(this.gUD);
    this.rcE = ((TextView)this.rcD.findViewById(R.h.x5_logo_url));
  }
  
  public final void setBgColor(int paramInt)
  {
    ((ViewGroup)this.rcD.getParent()).setBackgroundColor(paramInt);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    if (!bk.bl(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bk.bl(paramString))
      {
        paramString = getContext().getString(R.l.webview_logo_url, new Object[] { paramString });
        this.rcE.setVisibility(0);
        this.rcE.setText(paramString);
        return;
      }
    }
    this.rcE.setVisibility(8);
  }
  
  public final void setX5LogoViewVisibility(int paramInt)
  {
    this.rcD.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */