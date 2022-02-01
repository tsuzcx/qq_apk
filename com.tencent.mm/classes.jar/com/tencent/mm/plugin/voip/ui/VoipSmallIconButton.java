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

public class VoipSmallIconButton
  extends FrameLayout
{
  private Drawable HeT;
  private Drawable HeU;
  private View.OnTouchListener HeV;
  private TextView Ws;
  private ImageView cIN;
  private Context mContext;
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115391);
    this.HeT = null;
    this.HeU = null;
    this.HeV = new View.OnTouchListener()
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
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(2131099679));
          continue;
          VoipSmallIconButton.b(VoipSmallIconButton.this).setImageDrawable(VoipSmallIconButton.e(VoipSmallIconButton.this));
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(2131101427));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131495204, this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.a.VoipButton, 0, 0);
    try
    {
      this.HeT = paramContext.getDrawable(2);
      this.HeU = paramContext.getDrawable(3);
      paramAttributeSet = paramContext.getString(4);
      int i = paramContext.getResourceId(4, -1);
      paramContext.recycle();
      this.cIN = ((ImageView)findViewById(2131307936));
      this.cIN.setImageDrawable(this.HeT);
      this.cIN.setOnTouchListener(this.HeV);
      this.cIN.setContentDescription(paramAttributeSet);
      this.Ws = ((TextView)findViewById(2131307938));
      if (i != -1) {
        this.Ws.setText(getContext().getString(i));
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
    this.cIN.setEnabled(paramBoolean);
    this.Ws.setEnabled(paramBoolean);
    AppMethodBeat.o(115392);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115390);
    this.cIN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */