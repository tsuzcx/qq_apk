package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class an
  extends RelativeLayout
{
  private int PMC;
  private LayoutInflater kgB;
  
  public an(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    AppMethodBeat.i(37191);
    this.kgB = paramLayoutInflater;
    this.PMC = paramInt;
    setClipChildren(false);
    paramLayoutInflater = this.kgB.inflate(2131493628, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131298529);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165534), 0, getResources().getDimensionPixelSize(2131165534));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.kgB.inflate(2131493501, null);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131298454);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165534), 0, getResources().getDimensionPixelSize(2131165534));
    localLayoutParams.addRule(3, 2131298529);
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, 2131820839);
    paramLayoutInflater.setId(2131298558);
    paramInt = paramLayoutInflater.getResources().getDimensionPixelSize(2131165594);
    int i = a.aG(getContext(), 2131165594);
    if (i != paramInt) {
      Log.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131298454);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165534), 0, getResources().getDimensionPixelSize(2131165534));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(2131495504, this, false);
    paramLayoutInflater.setId(2131298410);
    paramInt = a.fromDPToPix(getContext(), 24);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165586), getResources().getDimensionPixelSize(2131165201), -getResources().getDimensionPixelSize(2131165277), 0);
    localLayoutParams.addRule(3, 2131298558);
    localLayoutParams.addRule(9);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.kgB.inflate(this.PMC, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      Log.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = 2131298414;
      paramLayoutInflater.setId(2131298414);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131298558);
    localLayoutParams.addRule(1, 2131298410);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(2131298508);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new ImageView(getContext());
    paramLayoutInflater.setBackgroundColor(paramLayoutInflater.getResources().getColor(2131099749));
    paramLayoutInflater.setId(2131298412);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    AppMethodBeat.o(37191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */