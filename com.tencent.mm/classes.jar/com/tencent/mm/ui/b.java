package com.tencent.mm.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.cb.a;

public final class b
{
  public TextView eXO;
  private ImageView kjC;
  private ImageView pEX;
  private View rvn;
  public TextView uGq;
  public ImageView uGr;
  private ImageView uGs;
  public ImageView uGt;
  private View uGu;
  
  public b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      this.eXO = ((TextView)paramView.findViewById(a.g.title_area));
      this.uGq = ((TextView)paramView.findViewById(a.g.sub_title_area));
      this.pEX = ((ImageView)paramView.findViewById(a.g.mute_icon));
      this.uGr = ((ImageView)paramView.findViewById(a.g.phone_icon));
      this.uGs = ((ImageView)paramView.findViewById(a.g.qmsg_icon));
      this.rvn = paramView.findViewById(a.g.arrow_area);
      this.kjC = ((ImageView)paramView.findViewById(a.g.arrow_area_btn));
      this.uGt = ((ImageView)paramView.findViewById(a.g.reject_icon));
      this.uGu = paramView;
      return;
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
    }
  }
  
  public final void cxQ()
  {
    this.eXO.setTextColor(-1);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    this.rvn.setOnClickListener(paramOnClickListener);
  }
  
  public final void mF(boolean paramBoolean)
  {
    ImageView localImageView = this.pEX;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public final void mG(boolean paramBoolean)
  {
    ImageView localImageView = this.uGs;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public final void s(Drawable paramDrawable)
  {
    if ((this.kjC != null) && (paramDrawable != null)) {
      this.kjC.setImageDrawable(paramDrawable);
    }
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.eXO.setText(paramCharSequence);
    if (a.fh(this.eXO.getContext())) {
      this.eXO.setTextSize(0, a.ab(this.eXO.getContext(), a.e.ActionBarTextSize) * a.ff(this.eXO.getContext()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */