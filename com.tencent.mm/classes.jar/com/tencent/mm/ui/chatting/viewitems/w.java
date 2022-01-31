package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  extends RelativeLayout
{
  private LayoutInflater exe;
  private int zUZ;
  
  public w(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    AppMethodBeat.i(33121);
    this.exe = paramLayoutInflater;
    this.zUZ = paramInt;
    setClipChildren(false);
    paramLayoutInflater = this.exe.inflate(2130969043, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131820582);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131427808), 0, getResources().getDimensionPixelSize(2131427808));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, 2131493161);
    paramLayoutInflater.setId(2131820587);
    paramInt = paramLayoutInflater.getResources().getDimensionPixelSize(2131427862);
    int i = a.ao(getContext(), 2131427862);
    if (i != paramInt) {
      ab.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131820582);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131427808), 0, getResources().getDimensionPixelSize(2131427808));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(2130970147, this, false);
    paramLayoutInflater.setId(2131820579);
    paramInt = a.fromDPToPix(getContext(), 32);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131427496), getResources().getDimensionPixelSize(2131427854), 0);
    localLayoutParams.addRule(3, 2131820587);
    localLayoutParams.addRule(11);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.exe.inflate(this.zUZ, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      ab.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = 2131820580;
      paramLayoutInflater.setId(2131820580);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131820587);
    localLayoutParams.addRule(0, 2131820579);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(2131820586);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    AppMethodBeat.o(33121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */