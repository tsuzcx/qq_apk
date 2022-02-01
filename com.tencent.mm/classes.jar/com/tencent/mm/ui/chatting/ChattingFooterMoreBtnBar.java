package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.d;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams IRX;
  private WeImageButton aeiq;
  private WeImageButton aeir;
  private WeImageButton aeis;
  private WeImageButton aeit;
  private WeImageButton aeiu;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(bd.by(getContext(), R.d.list_top_line_selector));
    this.IRX = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
    this.IRX.topMargin = a.fromDPToPix(getContext(), 0);
    this.aeiq = new WeImageButton(getContext());
    this.aeiq.setImageResource(R.g.fmZ);
    this.aeiq.setScaleType(ImageView.ScaleType.CENTER);
    this.aeiq.setBackgroundResource(0);
    this.aeiq.setContentDescription(paramContext.getString(R.l.chatting_more_share));
    this.aeiu = new WeImageButton(getContext());
    this.aeiu.setImageResource(R.g.fmX);
    this.aeiu.setScaleType(ImageView.ScaleType.CENTER);
    this.aeiu.setBackgroundResource(0);
    this.aeiu.setContentDescription(paramContext.getString(R.l.chatting_more_favorite));
    this.aeit = new WeImageButton(getContext());
    this.aeit.setImageResource(R.g.fmV);
    this.aeit.setScaleType(ImageView.ScaleType.CENTER);
    this.aeit.setBackgroundResource(0);
    this.aeit.setContentDescription(paramContext.getString(R.l.chatting_more_delete));
    this.aeis = new WeImageButton(getContext());
    this.aeis.setImageResource(R.g.chat_more_more_btn);
    this.aeis.setScaleType(ImageView.ScaleType.CENTER);
    this.aeis.setBackgroundResource(0);
    this.aeis.setContentDescription(paramContext.getString(R.l.chatting_more));
    this.aeir = new WeImageButton(getContext());
    this.aeir.setImageResource(R.g.fmW);
    this.aeir.setScaleType(ImageView.ScaleType.CENTER);
    this.aeir.setBackgroundResource(0);
    this.aeir.setContentDescription(paramContext.getString(R.l.chatting_more_email));
    fWe();
    AppMethodBeat.o(34552);
  }
  
  public final void aBM(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.aeiq.setClickable(bool);
      this.aeiq.setEnabled(bool);
      if (m.jpe().size() <= 0) {
        break label97;
      }
      this.aeis.setClickable(bool);
      this.aeis.setEnabled(bool);
    }
    for (;;)
    {
      this.aeit.setClickable(bool);
      this.aeit.setEnabled(bool);
      this.aeiu.setClickable(bool);
      this.aeiu.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.aeir.setClickable(bool);
      this.aeir.setEnabled(bool);
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34555);
    switch (paramInt)
    {
    default: 
      Log.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34555);
      return;
    case 2: 
      this.aeis.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.aeit.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.aeir.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.aeiq.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.aeiu.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void fWe()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.aeiq, this.IRX);
    addView(this.aeiu, this.IRX);
    addView(this.aeit, this.IRX);
    addView(this.aeir, this.IRX);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */