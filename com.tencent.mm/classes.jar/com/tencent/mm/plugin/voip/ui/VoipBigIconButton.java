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

public class VoipBigIconButton
  extends FrameLayout
{
  private Drawable NVJ;
  private Drawable NVK;
  private Drawable NVL;
  private Drawable NVM;
  private ImageView cJr;
  private Context mContext;
  private View.OnTouchListener nan;
  private TextView rR;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115375);
    this.NVJ = null;
    this.NVK = null;
    this.NVL = null;
    this.NVM = null;
    this.nan = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(115374);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(115374);
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
        this.NVJ = paramAttributeSet.getDrawable(b.h.VoipButton_iconBackground);
        this.NVK = paramAttributeSet.getDrawable(b.h.VoipButton_iconBackgroundPressed);
        this.NVL = paramAttributeSet.getDrawable(b.h.VoipButton_iconRes);
        this.NVM = paramAttributeSet.getDrawable(b.h.VoipButton_iconResPressed);
        int i = paramAttributeSet.getResourceId(b.h.VoipButton_iconTip, -1);
        int j = paramAttributeSet.getResourceId(b.h.VoipButton_iconTip, 0);
        if (j == 0) {
          break label313;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.NVK == null)
        {
          paramAttributeSet = this.NVJ;
          this.NVK = paramAttributeSet;
          if (this.NVM != null) {
            break label305;
          }
          paramAttributeSet = this.NVL;
          this.NVM = paramAttributeSet;
          this.cJr = ((ImageView)findViewById(b.d.big_icon_button));
          this.cJr.setBackgroundDrawable(this.NVJ);
          this.cJr.setImageDrawable(this.NVL);
          this.cJr.setOnTouchListener(this.nan);
          this.cJr.setContentDescription(paramContext);
          this.rR = ((TextView)findViewById(b.d.big_icon_text));
          if (i != -1) {
            this.rR.setText(getContext().getString(i));
          }
          AppMethodBeat.o(115375);
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
        AppMethodBeat.o(115375);
      }
      paramAttributeSet = this.NVK;
      continue;
      label305:
      paramAttributeSet = this.NVM;
      continue;
      label313:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115376);
    this.cJr.setEnabled(paramBoolean);
    this.rR.setEnabled(paramBoolean);
    AppMethodBeat.o(115376);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115377);
    this.cJr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */