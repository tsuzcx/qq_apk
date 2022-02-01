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

public class VoipBigIconButton
  extends FrameLayout
{
  private Drawable UVE;
  private Drawable UVF;
  private Drawable UVG;
  private Drawable UVH;
  private ImageView ewg;
  private Context mContext;
  private View.OnTouchListener pWX;
  private TextView sQ;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293463);
    this.UVE = null;
    this.UVF = null;
    this.UVG = null;
    this.UVH = null;
    this.pWX = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(293445);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(293445);
          return false;
          VoipBigIconButton.b(VoipBigIconButton.this).setBackgroundDrawable(VoipBigIconButton.a(VoipBigIconButton.this));
          VoipBigIconButton.b(VoipBigIconButton.this).setImageDrawable(VoipBigIconButton.c(VoipBigIconButton.this));
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(b.a.BW_100_Alpha_0_8));
          continue;
          VoipBigIconButton.b(VoipBigIconButton.this).setBackgroundDrawable(VoipBigIconButton.f(VoipBigIconButton.this));
          VoipBigIconButton.b(VoipBigIconButton.this).setImageDrawable(VoipBigIconButton.g(VoipBigIconButton.this));
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(b.a.white_text_color));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(b.e.layout_voip_big_icon_button, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.h.VoipButton, 0, 0);
    for (;;)
    {
      try
      {
        this.UVE = paramAttributeSet.getDrawable(b.h.VoipButton_iconBackground);
        this.UVF = paramAttributeSet.getDrawable(b.h.VoipButton_iconBackgroundPressed);
        this.UVG = paramAttributeSet.getDrawable(b.h.VoipButton_iconRes);
        this.UVH = paramAttributeSet.getDrawable(b.h.VoipButton_iconResPressed);
        int i = paramAttributeSet.getResourceId(b.h.VoipButton_iconTip, -1);
        int j = paramAttributeSet.getResourceId(b.h.VoipButton_iconTip, 0);
        if (j == 0) {
          break label313;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.UVF == null)
        {
          paramAttributeSet = this.UVE;
          this.UVF = paramAttributeSet;
          if (this.UVH != null) {
            break label305;
          }
          paramAttributeSet = this.UVG;
          this.UVH = paramAttributeSet;
          this.ewg = ((ImageView)findViewById(b.d.big_icon_button));
          this.ewg.setBackgroundDrawable(this.UVE);
          this.ewg.setImageDrawable(this.UVG);
          this.ewg.setOnTouchListener(this.pWX);
          this.ewg.setContentDescription(paramContext);
          this.sQ = ((TextView)findViewById(b.d.big_icon_text));
          if (i != -1) {
            this.sQ.setText(getContext().getString(i));
          }
          AppMethodBeat.o(293463);
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
        AppMethodBeat.o(293463);
      }
      paramAttributeSet = this.UVF;
      continue;
      label305:
      paramAttributeSet = this.UVH;
      continue;
      label313:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(293497);
    this.ewg.setEnabled(paramBoolean);
    this.sQ.setEnabled(paramBoolean);
    AppMethodBeat.o(293497);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(293499);
    this.ewg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(293499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */