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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class b
{
  private ImageView TLT;
  private View Xex;
  private TextView adtM;
  private ImageView adtN;
  public ViewGroup adtO;
  public WeImageView adtP;
  public TextView adtQ;
  public ViewGroup adtR;
  public WeImageView adtS;
  public ImageView adtT;
  private ImageView adtU;
  public ImageView adtV;
  public ImageView adtW;
  private View adtX;
  private ImageView nfU;
  public TextView pJJ;
  
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
      this.pJJ = ((TextView)paramView.findViewById(a.g.title_area));
      this.adtM = ((TextView)paramView.findViewById(a.g.title_area_user_level));
      this.adtN = ((ImageView)paramView.findViewById(a.g.title_left_iv));
      this.adtO = ((ViewGroup)paramView.findViewById(a.g.title_area_container));
      this.adtP = ((WeImageView)paramView.findViewById(a.g.title_area_btn));
      this.adtQ = ((TextView)paramView.findViewById(a.g.sub_title_area));
      this.adtR = ((ViewGroup)paramView.findViewById(a.g.sub_title_area_container));
      this.adtS = ((WeImageView)paramView.findViewById(a.g.sub_title_area_btn));
      this.TLT = ((ImageView)paramView.findViewById(a.g.mute_icon));
      this.adtT = ((ImageView)paramView.findViewById(a.g.phone_icon));
      this.adtU = ((ImageView)paramView.findViewById(a.g.qmsg_icon));
      this.Xex = paramView.findViewById(a.g.actionbar_up_indicator);
      this.nfU = ((ImageView)paramView.findViewById(a.g.arrow_area_btn));
      this.adtV = ((ImageView)paramView.findViewById(a.g.reject_icon));
      this.adtW = ((ImageView)paramView.findViewById(a.g.user_tag_view));
      this.adtX = paramView;
      a.v(this.pJJ, a.e.ActionBarTextSize);
      a.v(this.adtQ, a.e.HintTextSize);
      a.v(this.adtM, a.e.DescTextSize);
      AppMethodBeat.o(141266);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
    }
  }
  
  public final void KQ(boolean paramBoolean)
  {
    AppMethodBeat.i(249379);
    WeImageView localWeImageView = this.adtP;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localWeImageView.setVisibility(i);
      this.adtS.setVisibility(8);
      this.adtP.setIconColor(this.pJJ.getCurrentTextColor());
      AppMethodBeat.o(249379);
      return;
    }
  }
  
  public final void KR(boolean paramBoolean)
  {
    AppMethodBeat.i(141268);
    ImageView localImageView = this.TLT;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141268);
      return;
    }
  }
  
  public final void KS(boolean paramBoolean)
  {
    AppMethodBeat.i(141269);
    ImageView localImageView = this.adtU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141269);
      return;
    }
  }
  
  public final void aQ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(249377);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      this.adtQ.setVisibility(8);
      AppMethodBeat.o(249377);
      return;
    }
    this.adtQ.setVisibility(0);
    this.adtQ.setText(paramCharSequence);
    if (com.tencent.mm.cd.a.mp(this.adtQ.getContext()))
    {
      this.adtQ.setTextSize(1, 14.0F);
      this.pJJ.setTextSize(1, 18.0F);
    }
    AppMethodBeat.o(249377);
  }
  
  public final void jhC()
  {
    AppMethodBeat.i(249374);
    this.adtM.setText("");
    Log.i("MicroMsg.ActionBarCustomArea", "resetUserLevel!");
    AppMethodBeat.o(249374);
  }
  
  public final void jhD()
  {
    AppMethodBeat.i(249388);
    int i = a.j.actionbar_icon_dark_back;
    if ((this.nfU != null) && (i != 0)) {
      this.nfU.setImageResource(i);
    }
    AppMethodBeat.o(249388);
  }
  
  public final void setClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141270);
    this.Xex.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(141270);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141267);
    this.pJJ.setText(paramCharSequence);
    if (!a.jhB())
    {
      if (com.tencent.mm.cd.a.mp(this.pJJ.getContext()))
      {
        this.pJJ.setTextSize(0, com.tencent.mm.cd.a.bs(this.pJJ.getContext(), a.e.ActionBarTextSize) * com.tencent.mm.cd.a.jO(this.pJJ.getContext()));
        AppMethodBeat.o(141267);
      }
    }
    else {
      a.v(this.pJJ, a.e.ActionBarTextSize);
    }
    AppMethodBeat.o(141267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */