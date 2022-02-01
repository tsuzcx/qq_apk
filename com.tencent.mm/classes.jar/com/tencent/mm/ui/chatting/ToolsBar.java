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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams CXH;
  private WeImageButton WAW;
  private WeImageButton WBa;
  private WeImageButton WEN;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(aw.bf(getContext(), R.d.list_top_line_selector));
    this.CXH = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
    this.WAW = new WeImageButton(getContext());
    this.WAW.setImageResource(R.g.dmN);
    this.WAW.setScaleType(ImageView.ScaleType.CENTER);
    this.WAW.setBackgroundResource(0);
    this.WAW.setContentDescription(paramContext.getString(R.l.chatting_more_share));
    this.WBa = new WeImageButton(getContext());
    this.WBa.setImageResource(R.g.dmL);
    this.WBa.setScaleType(ImageView.ScaleType.CENTER);
    this.WBa.setBackgroundResource(0);
    this.WBa.setContentDescription(paramContext.getString(R.l.chatting_more_favorite));
    this.WEN = new WeImageButton(getContext());
    this.WEN.setImageResource(R.g.dmM);
    this.WEN.setScaleType(ImageView.ScaleType.CENTER);
    this.WEN.setBackgroundResource(0);
    this.WEN.setContentDescription(paramContext.getString(R.l.chatting_more_favorite));
    removeAllViews();
    addView(this.WAW, this.CXH);
    addView(this.WBa, this.CXH);
    addView(this.WEN, this.CXH);
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
      this.WAW.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.WBa.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.WEN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */