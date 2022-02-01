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
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams IRX;
  private WeImageButton aeiq;
  private WeImageButton aeiu;
  private WeImageButton aemn;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(bd.by(getContext(), R.d.list_top_line_selector));
    this.IRX = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.SmallListHeight), 1.0F);
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
    this.aemn = new WeImageButton(getContext());
    this.aemn.setImageResource(R.g.fmY);
    this.aemn.setScaleType(ImageView.ScaleType.CENTER);
    this.aemn.setBackgroundResource(0);
    this.aemn.setContentDescription(paramContext.getString(R.l.chatting_more_remind));
    removeAllViews();
    addView(this.aeiq, this.IRX);
    addView(this.aeiu, this.IRX);
    addView(this.aemn, this.IRX);
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
      this.aeiq.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.aeiu.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.aemn.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */