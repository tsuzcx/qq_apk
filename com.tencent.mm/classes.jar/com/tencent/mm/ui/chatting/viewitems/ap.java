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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class ap
  extends RelativeLayout
{
  private int contentLayout;
  private LayoutInflater pUI;
  
  public ap(LayoutInflater paramLayoutInflater, int paramInt)
  {
    super(paramLayoutInflater.getContext());
    AppMethodBeat.i(37191);
    this.pUI = paramLayoutInflater;
    this.contentLayout = paramInt;
    setClipChildren(false);
    paramLayoutInflater = this.pUI.inflate(R.i.ghu, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(R.h.fzC);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.pUI.inflate(R.i.gff, null);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramLayoutInflater.setId(R.h.fyu);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
    localLayoutParams.addRule(3, R.h.fzC);
    paramLayoutInflater.setVisibility(8);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new TextView(getContext(), null, R.m.ChattingUISplit);
    paramLayoutInflater.setId(R.h.fAm);
    paramInt = a.br(getContext(), R.f.SmallestTextSize);
    int i = a.br(getContext(), R.f.SmallestTextSize);
    if (i != paramInt) {
      Log.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    paramLayoutInflater.setTextSize(0, paramInt);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, R.h.fyu);
    localLayoutParams.addRule(14);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = (CheckBox)LayoutInflater.from(getContext()).inflate(R.i.mm_big_checkbox, this, false);
    paramLayoutInflater.setId(R.h.fxt);
    paramInt = a.fromDPToPix(getContext(), 24);
    localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    localLayoutParams.setMargins(getResources().getDimensionPixelSize(R.f.SmallPadding), getResources().getDimensionPixelSize(R.f.BiggerPadding), -getResources().getDimensionPixelSize(R.f.Edge_0_5_A), 0);
    localLayoutParams.addRule(3, R.h.fAm);
    localLayoutParams.addRule(9);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = this.pUI.inflate(this.contentLayout, null);
    i = paramLayoutInflater.getId();
    paramInt = i;
    if (-1 == i)
    {
      Log.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
      paramInt = R.h.fxw;
      paramLayoutInflater.setId(R.h.fxw);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, R.h.fAm);
    localLayoutParams.addRule(1, R.h.fxt);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new View(getContext());
    paramLayoutInflater.setId(R.h.fzn);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    paramLayoutInflater = new ImageView(getContext());
    paramLayoutInflater.setBackgroundColor(paramLayoutInflater.getResources().getColor(R.e.FG_2));
    paramLayoutInflater.setId(R.h.fxu);
    paramLayoutInflater.setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(6, paramInt);
    localLayoutParams.addRule(8, paramInt);
    addView(paramLayoutInflater, localLayoutParams);
    AppMethodBeat.o(37191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap
 * JD-Core Version:    0.7.0.1
 */