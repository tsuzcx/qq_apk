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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class aw$f
  extends c.a
{
  com.tencent.mm.ui.widget.b.a HQL;
  a.f IhD;
  LinearLayout IjQ;
  TextView IjR;
  ImageView Ijf;
  com.tencent.mm.pluginsdk.ui.span.g IlA;
  a.e IlB;
  ViewStub IlC;
  ChattingItemTranslate IlD;
  com.tencent.mm.ui.widget.textview.a Ilz;
  MMNeat7extView Ipt;
  View ifK;
  protected TextView qTn;
  
  private static boolean fqH()
  {
    AppMethodBeat.i(37421);
    try
    {
      String str = com.tencent.mm.m.g.ZY().getValue("CellTextViewEnable");
      int i = bs.getInt(str, 1);
      boolean bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GPB, true);
      ac.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
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
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.Ipt = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.Ipt.setMaxWidth((int)(com.tencent.mm.cc.a.av(this.Ipt.getContext(), 2131166038) / com.tencent.mm.cd.a.eSl()));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.ifK = paramView.findViewById(2131298071);
    this.IlC = ((ViewStub)paramView.findViewById(2131306075));
    if (!paramBoolean)
    {
      this.Ijf = ((ImageView)paramView.findViewById(2131298176));
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
    }
    this.IlA = new com.tencent.mm.pluginsdk.ui.span.g(this.Ipt, new n(this.Ipt.getContext()));
    this.Ipt.setIsOpen(fqH());
    this.Ipt.setTextCrashListener(new aw.c((byte)0));
    this.qTn = ((TextView)paramView.findViewById(2131298044));
    this.IjQ = ((LinearLayout)paramView.findViewById(2131298050));
    this.IjR = ((TextView)paramView.findViewById(2131298051));
    AppMethodBeat.o(37420);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.f
 * JD-Core Version:    0.7.0.1
 */