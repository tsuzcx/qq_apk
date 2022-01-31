package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private ImageButton mDW;
  private LinearLayout.LayoutParams nAm;
  private ImageButton zyX;
  private ImageButton zyY;
  private ImageButton zyZ;
  private ImageButton zzA;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30684);
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(2130838022);
    this.nAm = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131427853), 1.0F);
    this.nAm.topMargin = a.fromDPToPix(getContext(), 0);
    this.zyX = new ImageButton(getContext());
    this.zyX.setImageResource(2130838239);
    this.zyX.setScaleType(ImageView.ScaleType.CENTER);
    this.zyX.setBackgroundResource(0);
    this.zyX.setContentDescription(paramContext.getString(2131298261));
    this.zzA = new ImageButton(getContext());
    this.zzA.setImageResource(2130838236);
    this.zzA.setScaleType(ImageView.ScaleType.CENTER);
    this.zzA.setBackgroundResource(0);
    this.zzA.setContentDescription(paramContext.getString(2131298260));
    this.mDW = new ImageButton(getContext());
    this.mDW.setImageResource(2130838234);
    this.mDW.setScaleType(ImageView.ScaleType.CENTER);
    this.mDW.setBackgroundResource(0);
    this.mDW.setContentDescription(paramContext.getString(2131298258));
    this.zyZ = new ImageButton(getContext());
    this.zyZ.setImageResource(2130838237);
    this.zyZ.setScaleType(ImageView.ScaleType.CENTER);
    this.zyZ.setBackgroundResource(0);
    this.zyZ.setContentDescription(paramContext.getString(2131298257));
    this.zyY = new ImageButton(getContext());
    this.zyY.setImageResource(2130838235);
    this.zyY.setScaleType(ImageView.ScaleType.CENTER);
    this.zyY.setBackgroundResource(0);
    this.zyY.setContentDescription(paramContext.getString(2131298259));
    dGA();
    AppMethodBeat.o(30684);
  }
  
  public final void Pr(int paramInt)
  {
    AppMethodBeat.i(30686);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.zyX.setClickable(bool);
      this.zyX.setEnabled(bool);
      if (j.dGk().size() <= 0) {
        break label99;
      }
      this.zyZ.setClickable(bool);
      this.zyZ.setEnabled(bool);
    }
    for (;;)
    {
      this.mDW.setClickable(bool);
      this.mDW.setEnabled(bool);
      this.zzA.setClickable(bool);
      this.zzA.setEnabled(bool);
      AppMethodBeat.o(30686);
      return;
      bool = false;
      break;
      label99:
      this.zyY.setClickable(bool);
      this.zyY.setEnabled(bool);
    }
  }
  
  public final void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(30687);
    switch (paramInt)
    {
    default: 
      ab.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30687);
      return;
    case 2: 
      this.zyZ.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(30687);
      return;
    case 3: 
      this.mDW.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(30687);
      return;
    case 1: 
      this.zyY.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(30687);
      return;
    case 0: 
      this.zyX.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(30687);
      return;
    }
    this.zzA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(30687);
  }
  
  public final void dGA()
  {
    AppMethodBeat.i(30685);
    removeAllViews();
    addView(this.zyX, this.nAm);
    addView(this.zzA, this.nAm);
    addView(this.mDW, this.nAm);
    addView(this.zyY, this.nAm);
    AppMethodBeat.o(30685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */