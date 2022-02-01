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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.NinePatchCropImageView;

final class n$a
  extends c.a
{
  public ImageView KbJ;
  public ImageView KbK;
  public TextView KbL;
  public ImageView KbM;
  public TextView KbN;
  public TextView KbO;
  public ImageView KbP;
  public ImageView KbQ;
  public View KbR;
  public int width;
  public ImageIndicatorView zQo;
  
  public final a C(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163338);
    super.gn(paramView);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131298069);
    Object localObject = paramView.getContext();
    this.width = ((int)((((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimension(2131165284)) / 2.0F));
    localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = this.width;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.KbK = ((ImageView)paramView.findViewById(2131298122));
    this.KbL = ((TextView)paramView.findViewById(2131298126));
    this.KbM = ((ImageView)paramView.findViewById(2131298128));
    this.KbN = ((TextView)paramView.findViewById(2131298123));
    this.KbO = ((TextView)paramView.findViewById(2131298127));
    this.KbP = ((ImageView)paramView.findViewById(2131298124));
    this.KbQ = ((ImageView)paramView.findViewById(2131298125));
    this.zQo = ((ImageIndicatorView)paramView.findViewById(2131308257));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.KbR = paramView.findViewById(2131298053);
    int i;
    if (!((t)g.ad(t.class)).showFinderEntry())
    {
      i = 1;
      if (i == 0)
      {
        this.iCK = ((CheckBox)paramView.findViewById(2131298068));
        this.gZU = paramView.findViewById(2131298147);
      }
      if (!paramBoolean) {
        break label350;
      }
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.KbJ = ((ImageView)paramView.findViewById(2131298176));
      if ((this.KbM instanceof NinePatchCropImageView)) {
        ((NinePatchCropImageView)this.KbM).setNinePatchId(2131234981);
      }
    }
    for (;;)
    {
      this.KbP.setImageDrawable(ao.k(this.KbP.getContext(), 2131690572, a.n(this.KbP.getContext(), 2131099777)));
      AppMethodBeat.o(163338);
      return this;
      i = 0;
      break;
      label350:
      if ((this.KbM instanceof NinePatchCropImageView)) {
        ((NinePatchCropImageView)this.KbM).setNinePatchId(2131234979);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.a
 * JD-Core Version:    0.7.0.1
 */