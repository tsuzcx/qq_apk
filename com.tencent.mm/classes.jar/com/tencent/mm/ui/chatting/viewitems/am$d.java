package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class am$d
  extends c.a
{
  public static final int XhL;
  public static final int XhM;
  static c jak;
  protected LinearLayout XdA;
  ImageView XdI;
  protected ImageView XdM;
  protected TextView XdN;
  protected TextView XdO;
  protected LinearLayout XdP;
  protected ImageView XdQ;
  protected ImageView XdS;
  protected TextView XdT;
  protected ImageView Xdo;
  protected ImageView Xdr;
  protected ImageView Xds;
  protected TextView Xdu;
  protected ChattingItemFooter Xdv;
  protected ImageView Xdw;
  protected LinearLayout Xdx;
  protected ViewGroup Xdy;
  protected TextView Xdz;
  protected TextView XhN;
  protected TextView XhV;
  protected TextView XhW;
  
  static
  {
    AppMethodBeat.i(37128);
    XhL = a.fromDPToPix(MMApplicationContext.getContext(), 240);
    XhM = a.fromDPToPix(MMApplicationContext.getContext(), 192);
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.lRP = R.k.app_brand_app_default_icon_for_tail;
    locala.dO(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20)).lRB = true;
    jak = locala.bmL();
    AppMethodBeat.o(37128);
  }
  
  public final d W(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37127);
    super.create(paramView);
    this.Xdo = ((ImageView)paramView.findViewById(R.h.dwJ));
    this.Xdr = ((ImageView)this.convertView.findViewById(R.h.dxi));
    this.Xds = ((ImageView)this.convertView.findViewById(R.h.dzr));
    this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
    this.Xdw = ((ImageView)paramView.findViewById(R.h.dwD));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.Xdv = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
    this.Xdx = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
    this.Xdy = ((ViewGroup)paramView.findViewById(R.h.dLC));
    this.Xdz = ((TextView)paramView.findViewById(R.h.dLz));
    this.XdA = ((LinearLayout)paramView.findViewById(R.h.dwR));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    if (!paramBoolean)
    {
      this.XdI = ((ImageView)this.convertView.findViewById(R.h.chatting_status_tick));
      this.uploadingPB = ((ProgressBar)this.convertView.findViewById(R.h.dYz));
    }
    this.XdP = ((LinearLayout)paramView.findViewById(R.h.dvU));
    this.XdQ = ((ImageView)paramView.findViewById(R.h.dvV));
    this.XdS = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
    this.XdT = ((TextView)paramView.findViewById(R.h.dwf));
    this.XhN = ((TextView)paramView.findViewById(R.h.dvW));
    this.XhV = ((TextView)paramView.findViewById(R.h.dwl));
    this.XdM = ((ImageView)paramView.findViewById(R.h.dwh));
    this.XdN = ((TextView)paramView.findViewById(R.h.dwj));
    this.XdO = ((TextView)paramView.findViewById(R.h.dwi));
    this.XhW = ((TextView)paramView.findViewById(R.h.dwk));
    AppMethodBeat.o(37127);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.XdA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.d
 * JD-Core Version:    0.7.0.1
 */