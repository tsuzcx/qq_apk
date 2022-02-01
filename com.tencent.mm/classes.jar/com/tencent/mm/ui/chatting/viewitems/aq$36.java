package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class aq$36
  extends ViewOutlineProvider
{
  aq$36(aq paramaq) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(255375);
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), a.br(MMApplicationContext.getContext(), R.f.Edge_0_1_2_5_A));
    AppMethodBeat.o(255375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.36
 * JD-Core Version:    0.7.0.1
 */