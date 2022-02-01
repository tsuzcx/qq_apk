package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class av$f
  extends c.a
{
  a.f GHI;
  LinearLayout GJT;
  TextView GJU;
  ImageView GJi;
  com.tencent.mm.ui.widget.textview.a GLC;
  com.tencent.mm.pluginsdk.ui.span.g GLD;
  a.e GLE;
  ViewStub GLF;
  ChattingItemTranslate GLG;
  MMNeat7extView GPr;
  com.tencent.mm.ui.widget.b.a GqT;
  View hFi;
  protected TextView qkL;
  
  private static boolean faR()
  {
    AppMethodBeat.i(37421);
    try
    {
      String str = com.tencent.mm.m.g.Zd().getValue("CellTextViewEnable");
      int i = bt.getInt(str, 1);
      boolean bool = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FrL, true);
      ad.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((1 == i) && (bool))
      {
        AppMethodBeat.o(37421);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(37421);
      return false;
    }
    AppMethodBeat.o(37421);
    return false;
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37420);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.GPr = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.GPr.setMaxWidth((int)(com.tencent.mm.cd.a.ap(this.GPr.getContext(), 2131166038) / com.tencent.mm.ce.a.eCR()));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.hFi = paramView.findViewById(2131298071);
    this.GLF = ((ViewStub)paramView.findViewById(2131306075));
    if (!paramBoolean)
    {
      this.GJi = ((ImageView)paramView.findViewById(2131298176));
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
    }
    this.GLD = new com.tencent.mm.pluginsdk.ui.span.g(this.GPr, new n(this.GPr.getContext()));
    this.GPr.setIsOpen(faR());
    this.GPr.setTextCrashListener(new av.c((byte)0));
    this.qkL = ((TextView)paramView.findViewById(2131298044));
    this.GJT = ((LinearLayout)paramView.findViewById(2131298050));
    this.GJU = ((TextView)paramView.findViewById(2131298051));
    AppMethodBeat.o(37420);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av.f
 * JD-Core Version:    0.7.0.1
 */