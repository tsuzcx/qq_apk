package com.tencent.mm.ui.widget.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;

public final class d$b$a
  extends RecyclerView.v
  implements View.OnClickListener
{
  TextView fcy;
  ImageView hic;
  TextView oFq;
  RadioButton wnr;
  ImageView wns;
  LinearLayout wnt;
  
  public d$b$a(d.b paramb, View paramView)
  {
    super(paramView);
    paramView.setOnClickListener(this);
    this.fcy = ((TextView)paramView.findViewById(a.f.title));
    this.hic = ((ImageView)paramView.findViewById(a.f.icon));
    this.wnt = ((LinearLayout)paramView.findViewById(a.f.root));
    if ((d.v(paramb.wnq)) || (d.x(paramb.wnq)))
    {
      this.oFq = ((TextView)paramView.findViewById(a.f.desc));
      this.wnr = ((RadioButton)paramView.findViewById(a.f.radio));
      this.wns = ((ImageView)paramView.findViewById(a.f.divider));
    }
  }
  
  public final void onClick(View paramView)
  {
    if (this.wnu.aeW != null) {
      this.wnu.aeW.onItemClick(null, paramView, getPosition(), getPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */