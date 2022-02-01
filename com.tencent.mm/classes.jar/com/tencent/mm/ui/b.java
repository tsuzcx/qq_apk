package com.tencent.mm.ui;

import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class b
{
  private ImageView MZk;
  private View Qmj;
  public TextView VPH;
  private ImageView VPI;
  public ViewGroup VPJ;
  public WeImageView VPK;
  public TextView VPL;
  public ViewGroup VPM;
  public WeImageView VPN;
  public ImageView VPO;
  private ImageView VPP;
  public ImageView VPQ;
  private View VPR;
  private ImageView kCv;
  public TextView mNb;
  
  public b(View paramView)
  {
    AppMethodBeat.i(141266);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      this.mNb = ((TextView)paramView.findViewById(a.g.title_area));
      this.VPH = ((TextView)paramView.findViewById(a.g.title_area_user_level));
      this.VPI = ((ImageView)paramView.findViewById(a.g.title_left_iv));
      this.VPJ = ((ViewGroup)paramView.findViewById(a.g.title_area_container));
      this.VPK = ((WeImageView)paramView.findViewById(a.g.title_area_btn));
      this.VPL = ((TextView)paramView.findViewById(a.g.sub_title_area));
      this.VPM = ((ViewGroup)paramView.findViewById(a.g.sub_title_area_container));
      this.VPN = ((WeImageView)paramView.findViewById(a.g.sub_title_area_btn));
      this.MZk = ((ImageView)paramView.findViewById(a.g.mute_icon));
      this.VPO = ((ImageView)paramView.findViewById(a.g.phone_icon));
      this.VPP = ((ImageView)paramView.findViewById(a.g.qmsg_icon));
      this.Qmj = paramView.findViewById(a.g.actionbar_up_indicator);
      this.kCv = ((ImageView)paramView.findViewById(a.g.arrow_area_btn));
      this.VPQ = ((ImageView)paramView.findViewById(a.g.reject_icon));
      this.VPR = paramView;
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
    }
  }
  
  public final void Fg(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.MZk;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void Fh(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.VPP;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141269);
      return;
    }
  }
  
  public final void aD(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(221049);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      this.VPL.setVisibility(8);
      AppMethodBeat.o(221049);
      return;
    }
    this.VPL.setVisibility(0);
    this.VPL.setText(paramCharSequence);
    if (a.ko(this.VPL.getContext()))
    {
      this.VPL.setTextSize(1, 14.0F);
      this.mNb.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(221049);
  }
  
  public final void hFp()
  {
    AppMethodBeat.i(221040);
    this.VPH.setText("");
    Log.i("MicroMsg.ActionBarCustomArea", "resetUserLevel!");
    AppMethodBeat.o(221040);
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(221056);
    int i = a.j.actionbar_icon_dark_back;
    if ((this.kCv != null) && (i != 0)) {
      this.kCv.setImageResource(i);
    }
    AppMethodBeat.o(221056);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.Qmj.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.mNb.setText(paramCharSequence);
    if (a.ko(this.mNb.getContext())) {
      this.mNb.setTextSize(0, a.aZ(this.mNb.getContext(), a.e.ActionBarTextSize) * a.km(this.mNb.getContext()));
    }
    AppMethodBeat.o(141267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */