package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class am$f
  extends c.a
{
  View gcq;
  com.tencent.mm.ui.widget.c.a zCx;
  a.f zRm;
  ImageView zSm;
  MMNeat7extView zXe;
  ImageView zXf;
  TextView zXg;
  ViewStub zXh;
  ChattingItemTranslate zXi;
  com.tencent.mm.ui.widget.textview.a zXj;
  f zXk;
  a.e zXl;
  
  private static boolean dLv()
  {
    AppMethodBeat.i(33322);
    try
    {
      String str = com.tencent.mm.m.g.Nq().getValue("CellTextViewEnable");
      int i = bo.getInt(str, 1);
      boolean bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yIO, true);
      ab.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((1 == i) && (bool))
      {
        AppMethodBeat.o(33322);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(33322);
      return false;
    }
    AppMethodBeat.o(33322);
    return false;
  }
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33321);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zXe = ((MMNeat7extView)paramView.findViewById(2131821123));
    this.zXe.setMaxWidth((int)(com.tencent.mm.cb.a.ap(this.zXe.getContext(), 2131428227) / com.tencent.mm.cc.a.dqS()));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.gcq = paramView.findViewById(2131820580);
    this.zXh = ((ViewStub)paramView.findViewById(2131822575));
    if (paramBoolean)
    {
      this.zXf = ((ImageView)paramView.findViewById(2131822573));
      this.zXg = ((TextView)paramView.findViewById(2131822574));
    }
    for (;;)
    {
      this.zXk = new f(this.zXe, new m(this.zXe.getContext()));
      this.zXe.setIsOpen(dLv());
      this.zXe.setTextCrashListener(new am.c((byte)0));
      AppMethodBeat.o(33321);
      return this;
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.f
 * JD-Core Version:    0.7.0.1
 */