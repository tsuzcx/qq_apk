package com.tencent.toybrick.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;

public final class c$a
  extends d.a
{
  ImageView oFp;
  ImageView xaO;
  ImageView xaP;
  ImageView xaQ;
  TextView xaR;
  View xaS;
  
  public c$a(c paramc, View paramView)
  {
    super(paramView);
    this.xaO = ((ImageView)paramView.findViewById(a.f.image_right_iv));
    this.xaR = ((TextView)paramView.findViewById(a.f.right_desc));
    this.xaP = ((ImageView)paramView.findViewById(a.f.right_prospect));
    this.xaS = paramView.findViewById(a.f.right_rl);
    this.oFp = ((ImageView)paramView.findViewById(a.f.right_arrow));
    this.xaQ = ((ImageView)paramView.findViewById(a.f.right_center_prospect));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.toybrick.c.c.a
 * JD-Core Version:    0.7.0.1
 */