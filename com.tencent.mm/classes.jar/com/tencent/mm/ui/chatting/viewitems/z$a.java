package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.NinePatchCropImageView;

final class z$a
  extends c.a
{
  public ImageIndicatorView EpV;
  public ImageView PKw;
  public View detailLayout;
  public ImageView finderAvatar;
  public TextView finderDesc;
  public ImageView finderIcon;
  public TextView finderNickname;
  public TextView finderText;
  public ImageView finderThumb;
  public ImageView tickIV;
  public int width;
  
  public final a Q(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(233734);
    super.create(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131298411);
    Object localObject = paramView.getContext();
    this.width = ((int)((((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimension(2131165289)) / 2.0F));
    localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = this.width;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.finderAvatar = ((ImageView)paramView.findViewById(2131298472));
    this.finderNickname = ((TextView)paramView.findViewById(2131298477));
    this.finderThumb = ((ImageView)paramView.findViewById(2131298481));
    this.finderDesc = ((TextView)paramView.findViewById(2131298473));
    this.finderText = ((TextView)paramView.findViewById(2131298480));
    this.finderIcon = ((ImageView)paramView.findViewById(2131298474));
    this.PKw = ((ImageView)paramView.findViewById(2131298476));
    this.EpV = ((ImageIndicatorView)paramView.findViewById(2131298475));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.detailLayout = paramView.findViewById(2131298394);
    int i;
    if (!((aj)g.ah(aj.class)).showFinderEntry())
    {
      i = 1;
      if (i == 0)
      {
        this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
        this.maskView = paramView.findViewById(2131298508);
      }
      if (!paramBoolean) {
        break label350;
      }
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.tickIV = ((ImageView)paramView.findViewById(2131298556));
      if ((this.finderThumb instanceof NinePatchCropImageView)) {
        ((NinePatchCropImageView)this.finderThumb).setNinePatchId(2131231809);
      }
    }
    for (;;)
    {
      this.finderIcon.setImageDrawable(ar.m(this.finderIcon.getContext(), 2131690801, a.n(this.finderIcon.getContext(), 2131099792)));
      AppMethodBeat.o(233734);
      return this;
      i = 0;
      break;
      label350:
      if ((this.finderThumb instanceof NinePatchCropImageView)) {
        ((NinePatchCropImageView)this.finderThumb).setNinePatchId(2131231692);
      }
    }
  }
  
  public final View getMainContainerView()
  {
    return this.detailLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */