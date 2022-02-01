package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.h;

public class VoipSmallIconButton
  extends FrameLayout
{
  private Drawable UVG;
  private Drawable UVH;
  private ImageView ewg;
  private Context mContext;
  private View.OnTouchListener pWX;
  private TextView sQ;
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293436);
    this.UVG = null;
    this.UVH = null;
    this.pWX = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(293425);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(293425);
          return false;
          VoipSmallIconButton.b(VoipSmallIconButton.this).setImageDrawable(VoipSmallIconButton.a(VoipSmallIconButton.this));
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(b.a.BW_100_Alpha_0_8));
          continue;
          VoipSmallIconButton.b(VoipSmallIconButton.this).setImageDrawable(VoipSmallIconButton.e(VoipSmallIconButton.this));
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(b.a.white_text_color));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(b.e.layout_voip_small_icon_button, this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.h.VoipButton, 0, 0);
    try
    {
      this.UVG = paramContext.getDrawable(b.h.VoipButton_iconRes);
      this.UVH = paramContext.getDrawable(b.h.VoipButton_iconResPressed);
      paramAttributeSet = paramContext.getString(b.h.VoipButton_iconTip);
      int i = paramContext.getResourceId(b.h.VoipButton_iconTip, -1);
      paramContext.recycle();
      this.ewg = ((ImageView)findViewById(b.d.small_icon_button));
      this.ewg.setImageDrawable(this.UVG);
      this.ewg.setOnTouchListener(this.pWX);
      this.ewg.setContentDescription(paramAttributeSet);
      this.sQ = ((TextView)findViewById(b.d.small_icon_text));
      if (i != -1) {
        this.sQ.setText(getContext().getString(i));
      }
      AppMethodBeat.o(293436);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(293436);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(293464);
    this.ewg.setEnabled(paramBoolean);
    this.sQ.setEnabled(paramBoolean);
    AppMethodBeat.o(293464);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(293459);
    this.ewg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(293459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */