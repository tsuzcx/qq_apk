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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams CXH;
  private WeImageButton WAW;
  private WeImageButton WAX;
  private WeImageButton WAY;
  private WeImageButton WAZ;
  private WeImageButton WBa;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(aw.bf(getContext(), R.d.list_top_line_selector));
    this.CXH = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
    this.CXH.topMargin = a.fromDPToPix(getContext(), 0);
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
    this.WAZ = new WeImageButton(getContext());
    this.WAZ.setImageResource(R.g.dmJ);
    this.WAZ.setScaleType(ImageView.ScaleType.CENTER);
    this.WAZ.setBackgroundResource(0);
    this.WAZ.setContentDescription(paramContext.getString(R.l.chatting_more_delete));
    this.WAY = new WeImageButton(getContext());
    this.WAY.setImageResource(R.g.chat_more_more_btn);
    this.WAY.setScaleType(ImageView.ScaleType.CENTER);
    this.WAY.setBackgroundResource(0);
    this.WAY.setContentDescription(paramContext.getString(R.l.chatting_more));
    this.WAX = new WeImageButton(getContext());
    this.WAX.setImageResource(R.g.dmK);
    this.WAX.setScaleType(ImageView.ScaleType.CENTER);
    this.WAX.setBackgroundResource(0);
    this.WAX.setContentDescription(paramContext.getString(R.l.chatting_more_email));
    eNL();
    AppMethodBeat.o(34552);
  }
  
  public final void avk(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.WAW.setClickable(bool);
      this.WAW.setEnabled(bool);
      if (k.hMD().size() <= 0) {
        break label97;
      }
      this.WAY.setClickable(bool);
      this.WAY.setEnabled(bool);
    }
    for (;;)
    {
      this.WAZ.setClickable(bool);
      this.WAZ.setEnabled(bool);
      this.WBa.setClickable(bool);
      this.WBa.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.WAX.setClickable(bool);
      this.WAX.setEnabled(bool);
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
      this.WAY.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.WAZ.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.WAX.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.WAW.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.WBa.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void eNL()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.WAW, this.CXH);
    addView(this.WBa, this.CXH);
    addView(this.WAZ, this.CXH);
    addView(this.WAX, this.CXH);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */