package com.tencent.mm.plugin.voip.ui;

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
  private Drawable NVL;
  private Drawable NVM;
  private ImageView cJr;
  private Context mContext;
  private View.OnTouchListener nan;
  private TextView rR;
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115391);
    this.NVL = null;
    this.NVM = null;
    this.nan = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(115389);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(115389);
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
      this.NVL = paramContext.getDrawable(b.h.VoipButton_iconRes);
      this.NVM = paramContext.getDrawable(b.h.VoipButton_iconResPressed);
      paramAttributeSet = paramContext.getString(b.h.VoipButton_iconTip);
      int i = paramContext.getResourceId(b.h.VoipButton_iconTip, -1);
      paramContext.recycle();
      this.cJr = ((ImageView)findViewById(b.d.small_icon_button));
      this.cJr.setImageDrawable(this.NVL);
      this.cJr.setOnTouchListener(this.nan);
      this.cJr.setContentDescription(paramAttributeSet);
      this.rR = ((TextView)findViewById(b.d.small_icon_text));
      if (i != -1) {
        this.rR.setText(getContext().getString(i));
      }
      AppMethodBeat.o(115391);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(115391);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115392);
    this.cJr.setEnabled(paramBoolean);
    this.rR.setEnabled(paramBoolean);
    AppMethodBeat.o(115392);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115390);
    this.cJr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */