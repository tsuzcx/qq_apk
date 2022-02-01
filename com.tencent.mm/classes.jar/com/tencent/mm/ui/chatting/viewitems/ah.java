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
import com.tencent.mm.sdk.platformtools.ae;

public final class ah
  extends RelativeLayout
{
  private int KzY;
  private LayoutInflater jiz;
  
  public ah(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    AppMethodBeat.i(37191);
    this.jiz = paramLayoutInflater;
    this.KzY = paramInt;
    setClipChildren(false);
    paramLayoutInflater = this.jiz.inflate(2131496442, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131308258);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165516), 0, getResources().getDimensionPixelSize(2131165516));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.jiz.inflate(2131493407, null);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(2131298104);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165516), 0, getResources().getDimensionPixelSize(2131165516));
    localLayoutParams.addRule(3, 2131308258);
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, 2131820835);
    paramLayoutInflater.setId(2131298178);
    paramInt = paramLayoutInflater.getResources().getDimensionPixelSize(2131165576);
    int i = a.ax(getContext(), 2131165576);
    if (i != paramInt) {
      ae.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 2131298104);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131165516), 0, getResources().getDimensionPixelSize(2131165516));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(2131494770, this, false);
    paramLayoutInflater.setId(2131298068);
    paramInt = a.fromDPToPix(getContext(), 24);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(2131165568), getResources().getDimensionPixelSize(2131165198), -getResources().getDimensionPixelSize(2131165274), 0);
    localLayoutParams.addRule(3, 2131298178);
    localLayoutParams.addRule(9);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.jiz.inflate(this.KzY, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      ae.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = 2131298071;
      paramLayoutInflater.setId(2131298071);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131298178);
    localLayoutParams.addRule(1, 2131298068);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(2131298147);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new ImageView(getContext());
    paramLayoutInflater.setBackgroundColor(paramLayoutInflater.getResources().getColor(2131099735));
    paramLayoutInflater.setId(2131308255);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    AppMethodBeat.o(37191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah
 * JD-Core Version:    0.7.0.1
 */