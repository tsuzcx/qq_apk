package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class ag
  extends RelativeLayout
{
  private int Inh;
  private LayoutInflater iMw;
  
  public ag(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    AppMethodBeat.i(37191);
    this.iMw = paramLayoutInflater;
    this.Inh = paramInt;
    setClipChildren(false);
    paramLayoutInflater = this.iMw.inflate(2131493407, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131298104);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165516), 0, getResources().getDimensionPixelSize(2131165516));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, 2131820835);
    paramLayoutInflater.setId(2131298178);
    paramInt = paramLayoutInflater.getResources().getDimensionPixelSize(2131165576);
    int i = a.au(getContext(), 2131165576);
    if (i != paramInt) {
      ac.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131298104);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165516), 0, getResources().getDimensionPixelSize(2131165516));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(2131494770, this, false);
    paramLayoutInflater.setId(2131298068);
    paramInt = a.fromDPToPix(getContext(), 32);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165187), getResources().getDimensionPixelSize(2131165568), 0);
    localLayoutParams.addRule(3, 2131298178);
    localLayoutParams.addRule(11);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.iMw.inflate(this.Inh, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      ac.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = 2131298071;
      paramLayoutInflater.setId(2131298071);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131298178);
    localLayoutParams.addRule(0, 2131298068);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(2131298147);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    AppMethodBeat.o(37191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */