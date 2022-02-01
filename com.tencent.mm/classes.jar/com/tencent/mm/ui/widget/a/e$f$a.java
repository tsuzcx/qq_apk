package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class e$f$a
  extends RecyclerView.v
  implements View.OnClickListener
{
  ImageView OEh;
  LinearLayout OEi;
  ImageView Ynr;
  ImageView Yns;
  RadioButton Ynt;
  View Ynu;
  View jMT;
  TextView jMg;
  TextView msF;
  WeImageView znz;
  
  public e$f$a(e.f paramf, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(159346);
    this.Ynr = null;
    paramView.setOnClickListener(this);
    this.jMg = ((TextView)paramView.findViewById(a.f.title));
    this.znz = ((WeImageView)paramView.findViewById(a.f.icon));
    this.OEi = ((LinearLayout)paramView.findViewById(a.f.root));
    this.Ynu = paramView.findViewById(a.f.new_tip);
    this.jMT = paramView.findViewById(a.f.red_dot);
    if (e.C(paramf.Ynn))
    {
      this.Yns = ((ImageView)paramView.findViewById(a.f.icon_bg));
      this.Ynr = ((ImageView)paramView.findViewById(a.f.icon_badge));
    }
    if (e.D(paramf.Ynn)) {
      this.Ynt = ((RadioButton)paramView.findViewById(a.f.radio));
    }
    if ((e.D(paramf.Ynn)) || (e.J(paramf.Ynn)))
    {
      this.msF = ((TextView)paramView.findViewById(a.f.desc));
      this.OEh = ((ImageView)paramView.findViewById(a.f.divider));
    }
    AppMethodBeat.o(159346);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159347);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.Ynq.tp != null) {
      this.Ynq.tp.onItemClick(null, paramView, getPosition(), getPosition());
    }
    a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.f.a
 * JD-Core Version:    0.7.0.1
 */