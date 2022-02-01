package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.ce.c;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class bj$f
  extends c.a
{
  protected TextView Aoo;
  com.tencent.mm.ui.widget.b.a GAa;
  a.f aeMh;
  ImageView aeNG;
  LinearLayout aeOr;
  TextView aeOs;
  com.tencent.mm.ui.widget.textview.a aeQt;
  l aeQu;
  a.e aeQv;
  ViewStub aeQw;
  ChattingItemTranslate aeQx;
  MMNeat7extView aeVM;
  View hDw;
  
  private static boolean jxA()
  {
    AppMethodBeat.i(37421);
    try
    {
      String str = i.aRC().getValue("CellTextViewEnable");
      int i = Util.getInt(str, 1);
      boolean bool = h.baE().ban().getBoolean(at.a.acUD, true);
      Log.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
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
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37420);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeVM = ((MMNeat7extView)paramView.findViewById(R.h.fxy));
    this.aeVM.setMaxWidth((int)(com.tencent.mm.cd.a.bs(this.aeVM.getContext(), R.f.chatting_normal_item_width) / c.iRs()));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.hDw = paramView.findViewById(R.h.fxw);
    this.aeQw = ((ViewStub)paramView.findViewById(R.h.gaF));
    if (!paramBoolean)
    {
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    }
    this.aeQu = new l(this.aeVM, new s(this.aeVM.getContext()));
    this.aeVM.setIsOpen(jxA());
    this.aeVM.setTextCrashListener(new bj.c((byte)0));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
    this.aeOr = ((LinearLayout)paramView.findViewById(R.h.fxf));
    this.aeOs = ((TextView)paramView.findViewById(R.h.fxg));
    AppMethodBeat.o(37420);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.aeVM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.f
 * JD-Core Version:    0.7.0.1
 */