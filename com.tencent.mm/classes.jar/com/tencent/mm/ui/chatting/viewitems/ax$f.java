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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class ax$f
  extends c.a
{
  com.tencent.mm.ui.widget.b.a JZs;
  MMNeat7extView KCm;
  a.f Kur;
  ImageView KvW;
  LinearLayout KwH;
  TextView KwI;
  com.tencent.mm.ui.widget.textview.a Kyr;
  com.tencent.mm.pluginsdk.ui.span.g Kys;
  a.e Kyt;
  ViewStub Kyu;
  ChattingItemTranslate Kyv;
  View iBX;
  protected TextView rLB;
  
  private static boolean fLM()
  {
    AppMethodBeat.i(37421);
    try
    {
      String str = com.tencent.mm.n.g.acL().getValue("CellTextViewEnable");
      int i = bu.getInt(str, 1);
      boolean bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IWv, true);
      ae.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
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
  
  public final c.a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37420);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.KCm = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.KCm.setMaxWidth((int)(com.tencent.mm.cb.a.ay(this.KCm.getContext(), 2131166038) / com.tencent.mm.cc.a.flw()));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.iBX = paramView.findViewById(2131298071);
    this.Kyu = ((ViewStub)paramView.findViewById(2131306075));
    if (!paramBoolean)
    {
      this.KvW = ((ImageView)paramView.findViewById(2131298176));
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
    }
    this.Kys = new com.tencent.mm.pluginsdk.ui.span.g(this.KCm, new n(this.KCm.getContext()));
    this.KCm.setIsOpen(fLM());
    this.KCm.setTextCrashListener(new ax.c((byte)0));
    this.rLB = ((TextView)paramView.findViewById(2131298044));
    this.KwH = ((LinearLayout)paramView.findViewById(2131298050));
    this.KwI = ((TextView)paramView.findViewById(2131298051));
    AppMethodBeat.o(37420);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.f
 * JD-Core Version:    0.7.0.1
 */