package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private WeImageButton Phu;
  private WeImageButton Phv;
  private WeImageButton Phw;
  private WeImageButton Phx;
  private WeImageButton Phy;
  private LinearLayout.LayoutParams xTw;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(at.aN(getContext(), 2130969286));
    this.xTw = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165585), 1.0F);
    this.xTw.topMargin = a.fromDPToPix(getContext(), 0);
    this.Phu = new WeImageButton(getContext());
    this.Phu.setImageResource(2131231639);
    this.Phu.setScaleType(ImageView.ScaleType.CENTER);
    this.Phu.setBackgroundResource(0);
    this.Phu.setContentDescription(paramContext.getString(2131757465));
    this.Phy = new WeImageButton(getContext());
    this.Phy.setImageResource(2131231636);
    this.Phy.setScaleType(ImageView.ScaleType.CENTER);
    this.Phy.setBackgroundResource(0);
    this.Phy.setContentDescription(paramContext.getString(2131757464));
    this.Phx = new WeImageButton(getContext());
    this.Phx.setImageResource(2131231634);
    this.Phx.setScaleType(ImageView.ScaleType.CENTER);
    this.Phx.setBackgroundResource(0);
    this.Phx.setContentDescription(paramContext.getString(2131757462));
    this.Phw = new WeImageButton(getContext());
    this.Phw.setImageResource(2131231637);
    this.Phw.setScaleType(ImageView.ScaleType.CENTER);
    this.Phw.setBackgroundResource(0);
    this.Phw.setContentDescription(paramContext.getString(2131757461));
    this.Phv = new WeImageButton(getContext());
    this.Phv.setImageResource(2131231635);
    this.Phv.setScaleType(ImageView.ScaleType.CENTER);
    this.Phv.setBackgroundResource(0);
    this.Phv.setContentDescription(paramContext.getString(2131757463));
    eer();
    AppMethodBeat.o(34552);
  }
  
  public final void amj(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.Phu.setClickable(bool);
      this.Phu.setEnabled(bool);
      if (k.gNu().size() <= 0) {
        break label97;
      }
      this.Phw.setClickable(bool);
      this.Phw.setEnabled(bool);
    }
    for (;;)
    {
      this.Phx.setClickable(bool);
      this.Phx.setEnabled(bool);
      this.Phy.setClickable(bool);
      this.Phy.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.Phv.setClickable(bool);
      this.Phv.setEnabled(bool);
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
      this.Phw.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.Phx.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.Phv.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.Phu.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.Phy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void eer()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.Phu, this.xTw);
    addView(this.Phy, this.xTw);
    addView(this.Phx, this.xTw);
    addView(this.Phv, this.xTw);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */