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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class be
{
  aq XkJ;
  
  public be(aq paramaq)
  {
    AppMethodBeat.i(274458);
    this.XkJ = paramaq;
    paramaq = this.XkJ.getContext();
    TextView localTextView = new TextView(paramaq, null, R.m.ChattingUISplit);
    localTextView.setBackgroundResource(R.g.dne);
    localTextView.setId(R.h.dzo);
    localTextView.setVisibility(8);
    int i = localTextView.getResources().getDimensionPixelSize(R.f.SmallestTextSize);
    int j = a.aY(paramaq, R.f.SmallestTextSize);
    if (j != i) {
      Log.e("MicroMsg.ChattingItemStackMsgContainerHandler", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    }
    localTextView.setTextSize(0, i);
    localTextView.setTextColor(paramaq.getResources().getColor(R.e.BW_0_Alpha_0_5));
    localTextView.setIncludeFontPadding(false);
    localTextView.setGravity(17);
    localTextView.setPadding(paramaq.getResources().getDimensionPixelSize(R.f.BigPadding), paramaq.getResources().getDimensionPixelSize(R.f.SmallestPadding), paramaq.getResources().getDimensionPixelSize(R.f.BigPadding), paramaq.getResources().getDimensionPixelSize(R.f.SmallestPadding));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, a.aY(paramaq, R.f.Edge_2_5_A));
    localLayoutParams.addRule(4, R.h.dzs);
    localLayoutParams.addRule(19, R.h.dzs);
    localLayoutParams.addRule(21, -1);
    localLayoutParams.setMargins(paramaq.getResources().getDimensionPixelSize(R.f.LargePadding), 0, paramaq.getResources().getDimensionPixelSize(R.f.LargePadding), 0);
    this.XkJ.addView(localTextView, localLayoutParams);
    AppMethodBeat.o(274458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be
 * JD-Core Version:    0.7.0.1
 */