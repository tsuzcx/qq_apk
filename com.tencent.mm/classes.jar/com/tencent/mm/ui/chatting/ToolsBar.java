package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private WeImageButton Phu;
  private WeImageButton Phy;
  private WeImageButton Pld;
  private LinearLayout.LayoutParams xTw;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(at.aN(getContext(), 2130969286));
    this.xTw = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165585), 1.0F);
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
    this.Pld = new WeImageButton(getContext());
    this.Pld.setImageResource(2131231638);
    this.Pld.setScaleType(ImageView.ScaleType.CENTER);
    this.Pld.setBackgroundResource(0);
    this.Pld.setContentDescription(paramContext.getString(2131757464));
    removeAllViews();
    addView(this.Phu, this.xTw);
    addView(this.Phy, this.xTw);
    addView(this.Pld, this.xTw);
    AppMethodBeat.o(34960);
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34961);
    switch (paramInt)
    {
    default: 
      Log.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34961);
      return;
    case 0: 
      this.Phu.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.Phy.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.Pld.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */