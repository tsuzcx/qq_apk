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
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class al$d
  extends c.a
{
  public static final int XhL;
  public static final int XhM;
  static final c jak;
  protected LinearLayout XdA;
  ImageView XdI;
  protected ImageView XdM;
  protected TextView XdN;
  protected TextView XdO;
  protected LinearLayout XdP;
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
  protected ViewGroup XhO;
  protected View XhP;
  protected ThreeDotsLoadingView rfc;
  protected ImageView sDJ;
  
  static
  {
    AppMethodBeat.i(37104);
    XhL = a.fromDPToPix(MMApplicationContext.getContext(), 240);
    XhM = a.fromDPToPix(MMApplicationContext.getContext(), 192);
    com.tencent.mm.ay.a.a.c.a locala1 = new com.tencent.mm.ay.a.a.c.a();
    locala1.lRP = R.k.app_brand_app_default_icon_for_tail;
    com.tencent.mm.ay.a.a.c.a locala2 = locala1.dO(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.kPz = true;
    locala2.lRD = true;
    locala2.lRB = true;
    jak = locala1.bmL();
    AppMethodBeat.o(37104);
  }
  
  public final d V(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
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
    this.rfc = ((ThreeDotsLoadingView)paramView.findViewById(R.h.loading_view));
    this.sDJ = ((ImageView)paramView.findViewById(R.h.cover_iv));
    this.XdT = ((TextView)paramView.findViewById(R.h.dwf));
    this.XhN = ((TextView)paramView.findViewById(R.h.dvW));
    this.XdM = ((ImageView)paramView.findViewById(R.h.dwh));
    this.XdN = ((TextView)paramView.findViewById(R.h.dwj));
    this.XdO = ((TextView)paramView.findViewById(R.h.dwi));
    this.XhO = ((ViewGroup)paramView.findViewById(R.h.dCX));
    AppMethodBeat.o(37103);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.XdA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.d
 * JD-Core Version:    0.7.0.1
 */