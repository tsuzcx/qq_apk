package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

public final class aa$a
  extends c.a
{
  a.f PGP;
  protected TextView PHZ;
  protected MMNeat7extView PKD;
  com.tencent.mm.ui.widget.textview.a PKE;
  h PKF;
  a.e PKG;
  ViewStub PKH;
  ChattingItemTranslate PKI;
  View PLb;
  public View jxm;
  protected ImageView stateIV;
  protected TextView tln;
  com.tencent.mm.ui.widget.b.a wnj;
  
  public final a gW(View paramView)
  {
    AppMethodBeat.i(37002);
    super.create(paramView);
    this.PKD = ((MMNeat7extView)paramView.findViewById(2131298416));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
    this.stateIV = ((ImageView)paramView.findViewById(2131298554));
    this.tln = ((TextView)paramView.findViewById(2131298385));
    this.PHZ = ((TextView)paramView.findViewById(2131298364));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.clickArea = paramView.findViewById(2131306452);
    this.PLb = paramView.findViewById(2131306453);
    this.jxm = paramView.findViewById(2131298414);
    this.PKH = ((ViewStub)paramView.findViewById(2131309405));
    this.PKF = new h(this.PKD, new o(this.PKD.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PKD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */