package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.j;

public final class q
  extends j
{
  private ImageView adRo;
  public TextView adRp;
  private Context mContext;
  public Button mkz;
  private Button njI;
  public TextView qjr;
  public TextView titleTv;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251346);
    this.mContext = paramContext;
    aFf(a.h.half_bottom_error_verify_tips_dlg_layout);
    this.adRo = ((ImageView)this.rootView.findViewById(com.tencent.mm.ah.a.g.errro_title_icon));
    this.adRp = ((TextView)this.rootView.findViewById(com.tencent.mm.ah.a.g.error_link));
    this.titleTv = ((TextView)this.rootView.findViewById(com.tencent.mm.ah.a.g.tips_title));
    this.qjr = ((TextView)this.rootView.findViewById(com.tencent.mm.ah.a.g.tips_hint));
    this.mkz = ((Button)this.rootView.findViewById(com.tencent.mm.ah.a.g.next_btn));
    this.njI = ((Button)this.rootView.findViewById(com.tencent.mm.ah.a.g.cancel_btn));
    this.adRo.setImageDrawable(bb.m(paramContext, a.j.icons_outlined_error, paramContext.getResources().getColor(a.d.Yellow)));
    AppMethodBeat.o(251346);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.ck.a.g.mm_half_bottom_custom_outside_dialog;
  }
  
  public final q l(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251350);
    this.njI.setOnClickListener(paramOnClickListener);
    if (this.agfS != null) {
      this.agfS.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(251350);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.q
 * JD-Core Version:    0.7.0.1
 */