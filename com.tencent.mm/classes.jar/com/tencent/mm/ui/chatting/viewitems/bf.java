package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.m;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class bf
{
  ap aeVv;
  
  public bf(ap paramap)
  {
    AppMethodBeat.i(255243);
    this.aeVv = paramap;
    paramap = this.aeVv.getContext();
    TextView localTextView = new TextView(paramap, null, R.m.ChattingUISplit);
    localTextView.setBackgroundResource(R.g.fnq);
    localTextView.setId(R.h.fAi);
    localTextView.setVisibility(8);
    int i = localTextView.getResources().getDimensionPixelSize(R.f.SmallestTextSize);
    int j = a.br(paramap, R.f.SmallestTextSize);
    if (j != i) {
      Log.e("MicroMsg.ChattingItemStackMsgContainerHandler", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    }
    localTextView.setTextSize(0, i);
    localTextView.setTextColor(paramap.getResources().getColor(R.e.BW_0_Alpha_0_5));
    localTextView.setIncludeFontPadding(false);
    localTextView.setGravity(17);
    localTextView.setPadding(paramap.getResources().getDimensionPixelSize(R.f.BigPadding), paramap.getResources().getDimensionPixelSize(R.f.SmallestPadding), paramap.getResources().getDimensionPixelSize(R.f.BigPadding), paramap.getResources().getDimensionPixelSize(R.f.SmallestPadding));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, a.br(paramap, R.f.Edge_2_5_A));
    localLayoutParams.addRule(4, R.h.fAm);
    localLayoutParams.addRule(19, R.h.fAm);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.setMargins(paramap.getResources().getDimensionPixelSize(R.f.LargePadding), 0, paramap.getResources().getDimensionPixelSize(R.f.LargePadding), 0);
    this.aeVv.addView(localTextView, localLayoutParams);
    AppMethodBeat.o(255243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */