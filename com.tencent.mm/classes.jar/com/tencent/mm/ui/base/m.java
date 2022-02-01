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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.g;

public final class m
  extends g
{
  private ImageView Wkg;
  public TextView Wkh;
  public Button jLo;
  private Button kGN;
  private Context mContext;
  public TextView nmi;
  public TextView titleTv;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(222274);
    this.mContext = paramContext;
    ayv(a.h.half_bottom_error_verify_tips_dlg_layout);
    this.Wkg = ((ImageView)this.oFW.findViewById(com.tencent.mm.ah.a.g.errro_title_icon));
    this.Wkh = ((TextView)this.oFW.findViewById(com.tencent.mm.ah.a.g.error_link));
    this.titleTv = ((TextView)this.oFW.findViewById(com.tencent.mm.ah.a.g.tips_title));
    this.nmi = ((TextView)this.oFW.findViewById(com.tencent.mm.ah.a.g.tips_hint));
    this.jLo = ((Button)this.oFW.findViewById(com.tencent.mm.ah.a.g.next_btn));
    this.kGN = ((Button)this.oFW.findViewById(com.tencent.mm.ah.a.g.cancel_btn));
    this.Wkg.setImageDrawable(au.o(paramContext, a.j.icons_outlined_error, paramContext.getResources().getColor(a.d.Yellow)));
    AppMethodBeat.o(222274);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.cr.a.g.mm_half_bottom_custom_outside_dialog;
  }
  
  public final m i(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(222278);
    this.kGN.setOnClickListener(paramOnClickListener);
    if (this.YnG != null) {
      this.YnG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(222278);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.m
 * JD-Core Version:    0.7.0.1
 */