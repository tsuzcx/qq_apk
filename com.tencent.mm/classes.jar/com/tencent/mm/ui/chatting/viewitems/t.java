package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public final class t
  extends RelativeLayout
{
  private LayoutInflater fhz;
  private int vDO;
  
  public t(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    this.fhz = paramLayoutInflater;
    this.vDO = paramInt;
    paramLayoutInflater = this.fhz.inflate(R.i.chatting_history_msg_tip_layout, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(R.h.chatting_histroy_msg_tip);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, R.m.ChattingUISplit);
    paramLayoutInflater.setId(R.h.chatting_time_tv);
    paramInt = paramLayoutInflater.getResources().getDimensionPixelSize(R.f.SmallestTextSize);
    int i = a.aa(getContext(), R.f.SmallestTextSize);
    if (i != paramInt) {
      y.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, R.h.chatting_histroy_msg_tip);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(R.i.mm_big_checkbox, this, false);
    paramLayoutInflater.setId(R.h.chatting_checkbox);
    paramInt = a.fromDPToPix(getContext(), 32);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.BasicPaddingSize), getResources().getDimensionPixelSize(R.f.SmallPadding), 0);
    localLayoutParams.addRule(3, R.h.chatting_time_tv);
    localLayoutParams.addRule(11);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.fhz.inflate(this.vDO, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      y.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = R.h.chatting_content_area;
      paramLayoutInflater.setId(R.h.chatting_content_area);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, R.h.chatting_time_tv);
    localLayoutParams.addRule(0, R.h.chatting_checkbox);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(R.h.chatting_maskview);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t
 * JD-Core Version:    0.7.0.1
 */