package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;

public class ToolsBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams lcr;
  private ImageButton vjV;
  private ImageButton vjY;
  private ImageButton vnq;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(R.g.bottombar_bg);
    this.lcr = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
    this.vjV = new ImageButton(getContext());
    this.vjV.setImageResource(R.g.chat_more_tran_btn);
    this.vjV.setScaleType(ImageView.ScaleType.CENTER);
    this.vjV.setBackgroundResource(0);
    this.vjV.setContentDescription(paramContext.getString(R.l.chatting_more_share));
    this.vjY = new ImageButton(getContext());
    this.vjY.setImageResource(R.g.chat_more_fav_btn);
    this.vjY.setScaleType(ImageView.ScaleType.CENTER);
    this.vjY.setBackgroundResource(0);
    this.vjY.setContentDescription(paramContext.getString(R.l.chatting_more_favorite));
    this.vnq = new ImageButton(getContext());
    this.vnq.setImageResource(R.g.chat_more_remind_btn);
    this.vnq.setScaleType(ImageView.ScaleType.CENTER);
    this.vnq.setBackgroundResource(0);
    this.vnq.setContentDescription(paramContext.getString(R.l.chatting_more_favorite));
    removeAllViews();
    addView(this.vjV, this.lcr);
    addView(this.vjY, this.lcr);
    addView(this.vnq, this.lcr);
  }
  
  public final void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    switch (paramInt)
    {
    default: 
      y.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    case 0: 
      this.vjV.setOnClickListener(paramOnClickListener);
      return;
    case 1: 
      this.vjY.setOnClickListener(paramOnClickListener);
      return;
    }
    this.vnq.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */