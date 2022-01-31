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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private ImageButton kjq;
  private LinearLayout.LayoutParams lcr;
  private ImageButton vjV;
  private ImageButton vjW;
  private ImageButton vjX;
  private ImageButton vjY;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(R.g.bottombar_bg);
    this.lcr = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
    this.lcr.topMargin = a.fromDPToPix(getContext(), 0);
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
    this.kjq = new ImageButton(getContext());
    this.kjq.setImageResource(R.g.chat_more_del_btn);
    this.kjq.setScaleType(ImageView.ScaleType.CENTER);
    this.kjq.setBackgroundResource(0);
    this.kjq.setContentDescription(paramContext.getString(R.l.chatting_more_delete));
    this.vjX = new ImageButton(getContext());
    this.vjX.setImageResource(R.g.chat_more_more_btn);
    this.vjX.setScaleType(ImageView.ScaleType.CENTER);
    this.vjX.setBackgroundResource(0);
    this.vjX.setContentDescription(paramContext.getString(R.l.chatting_more));
    this.vjW = new ImageButton(getContext());
    this.vjW.setImageResource(R.g.chat_more_email_btn);
    this.vjW.setScaleType(ImageView.ScaleType.CENTER);
    this.vjW.setBackgroundResource(0);
    this.vjW.setContentDescription(paramContext.getString(R.l.chatting_more_email));
    cCO();
  }
  
  public final void GQ(int paramInt)
  {
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.vjV.setClickable(bool);
      this.vjV.setEnabled(bool);
      if (k.cCx().size() <= 0) {
        break label87;
      }
      this.vjX.setClickable(bool);
      this.vjX.setEnabled(bool);
    }
    for (;;)
    {
      this.kjq.setClickable(bool);
      this.kjq.setEnabled(bool);
      this.vjY.setClickable(bool);
      this.vjY.setEnabled(bool);
      return;
      bool = false;
      break;
      label87:
      this.vjW.setClickable(bool);
      this.vjW.setEnabled(bool);
    }
  }
  
  public final void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    switch (paramInt)
    {
    default: 
      y.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    case 2: 
      this.vjX.setOnClickListener(paramOnClickListener);
      return;
    case 3: 
      this.kjq.setOnClickListener(paramOnClickListener);
      return;
    case 1: 
      this.vjW.setOnClickListener(paramOnClickListener);
      return;
    case 0: 
      this.vjV.setOnClickListener(paramOnClickListener);
      return;
    }
    this.vjY.setOnClickListener(paramOnClickListener);
  }
  
  public final void cCO()
  {
    removeAllViews();
    addView(this.vjV, this.lcr);
    addView(this.vjY, this.lcr);
    addView(this.kjq, this.lcr);
    if (k.cCx().size() > 0)
    {
      addView(this.vjX, this.lcr);
      return;
    }
    addView(this.vjW, this.lcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */