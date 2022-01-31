package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.e.g;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;

public class m
  extends LinearLayout
{
  private TextView haW;
  private ImageView irM;
  private Context mContext;
  private String mTitle;
  private ImageView rcF;
  private p rcG;
  public l rcH;
  private s rcI;
  public c rcJ = null;
  private e rcp;
  
  public m(e parame)
  {
    super(parame.mContext);
    this.mContext = parame.mContext;
    this.rcp = parame;
    setLayoutParams(new LinearLayout.LayoutParams(-1, getActionBarHeight()));
    setBackgroundResource(R.e.action_bar_color);
    View localView = com.tencent.mm.ui.y.gt(getContext()).inflate(R.i.webview_action_bar, this, false);
    addView(localView);
    this.irM = ((ImageView)localView.findViewById(R.h.actionbar_back));
    this.irM.setOnClickListener(new m.1(this));
    this.haW = ((TextView)localView.findViewById(R.h.title));
    this.rcF = ((ImageView)localView.findViewById(R.h.actionbar_option_btn));
    this.rcF.setOnClickListener(new m.2(this, parame));
    this.rcF.setClickable(false);
  }
  
  private int getActionBarHeight()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
      return this.mContext.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
    }
    return this.mContext.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
  }
  
  public final void aW(int paramInt, String paramString)
  {
    setBackgroundColor(paramInt);
    if (bk.pm(paramString).equals("black"))
    {
      this.haW.setTextColor(-16777216);
      this.irM.setColorFilter(-16777216);
      this.rcF.setImageResource(R.k.actionbar_icon_dark_more);
      return;
    }
    this.haW.setTextColor(-1);
    this.irM.clearColorFilter();
    this.rcF.setImageResource(R.k.actionbar_icon_light_more);
  }
  
  public void aYv()
  {
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).mController.hideVKB();
    }
    m.3 local3 = new m.3(this);
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      ai.l(local3, l);
      return;
    }
  }
  
  public void aYw()
  {
    if (this.rcG != null) {
      this.rcG.cbq();
    }
  }
  
  public final boolean caS()
  {
    if (this.rcI != null)
    {
      Object localObject1 = this.rcI;
      if ((((s)localObject1).rcU) && (!bk.bl(((s)localObject1).cbs())) && (!bk.bl(((s)localObject1).cbt())) && (!bk.bl(((s)localObject1).cbu()))) {}
      for (int i = 1; i != 0; i = 0)
      {
        Object localObject2 = this.rcI.cbs();
        localObject1 = this.rcI.cbt();
        String str = this.rcI.cbu();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject2, localObject1, str });
        View localView = View.inflate(getContext(), R.i.mm_alert_checkbox, null);
        Object localObject3 = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
        ((CheckBox)localObject3).setChecked(false);
        ((CheckBox)localObject3).setVisibility(8);
        localObject3 = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
        ((TextView)localObject3).setText((CharSequence)localObject2);
        ((TextView)localObject3).setTextColor(getResources().getColor(R.e.normal_text_color));
        localObject2 = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
        ((TextView)localObject2).setTextColor(getResources().getColor(R.e.normal_text_color));
        ((TextView)localObject2).setVisibility(8);
        this.rcJ = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, (String)localObject1, str, new m.4(this), new m.5(this));
        return true;
      }
    }
    return false;
  }
  
  public final void cbm()
  {
    if (!this.rcp.bil.qj().qe()) {
      ((Activity)this.mContext).finish();
    }
  }
  
  public l getMenuHelp()
  {
    if (this.rcH == null) {
      this.rcH = new l();
    }
    return this.rcH;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new s(paramBundle))
    {
      this.rcI = paramBundle;
      return;
    }
  }
  
  public void setOptionBtnEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rcF.setClickable(true);
      return;
    }
    this.rcF.setClickable(false);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.haW.setTextColor(paramInt);
  }
  
  public void setTitleText(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.haW.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */