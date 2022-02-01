package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

public final class ad$a
  extends c.a
{
  com.tencent.mm.ui.widget.b.a AYp;
  a.f Xcj;
  protected TextView Xdu;
  a.e XgA;
  ViewStub XgB;
  ChattingItemTranslate XgC;
  View XgU;
  protected MMNeat7extView Xgx;
  com.tencent.mm.ui.widget.textview.a Xgy;
  h Xgz;
  public View fyN;
  protected ImageView stateIV;
  protected TextView wRL;
  
  public final View getMainContainerView()
  {
    return this.Xgx;
  }
  
  public final a ii(View paramView)
  {
    AppMethodBeat.i(37002);
    super.create(paramView);
    this.Xgx = ((MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
    this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
    this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
    this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.clickArea = paramView.findViewById(R.h.dRY);
    this.XgU = paramView.findViewById(R.h.dRZ);
    this.fyN = paramView.findViewById(R.h.dxc);
    this.XgB = ((ViewStub)paramView.findViewById(R.h.dXZ));
    this.Xgz = new h(this.Xgx, new o(this.Xgx.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.a
 * JD-Core Version:    0.7.0.1
 */