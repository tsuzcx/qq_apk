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

public class VoipBigIconButton
  extends FrameLayout
{
  private Drawable HeR;
  private Drawable HeS;
  private Drawable HeT;
  private Drawable HeU;
  private View.OnTouchListener HeV;
  private TextView Ws;
  private ImageView cIN;
  private Context mContext;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115375);
    this.HeR = null;
    this.HeS = null;
    this.HeT = null;
    this.HeU = null;
    this.HeV = new View.OnTouchListener()
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
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(2131099679));
          continue;
          VoipBigIconButton.b(VoipBigIconButton.this).setBackgroundDrawable(VoipBigIconButton.f(VoipBigIconButton.this));
          VoipBigIconButton.b(VoipBigIconButton.this).setImageDrawable(VoipBigIconButton.g(VoipBigIconButton.this));
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(2131101427));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131495203, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.a.VoipButton, 0, 0);
    for (;;)
    {
      try
      {
        this.HeR = paramAttributeSet.getDrawable(0);
        this.HeS = paramAttributeSet.getDrawable(1);
        this.HeT = paramAttributeSet.getDrawable(2);
        this.HeU = paramAttributeSet.getDrawable(3);
        int i = paramAttributeSet.getResourceId(4, -1);
        int j = paramAttributeSet.getResourceId(4, 0);
        if (j == 0) {
          break label298;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.HeS == null)
        {
          paramAttributeSet = this.HeR;
          this.HeS = paramAttributeSet;
          if (this.HeU != null) {
            break label290;
          }
          paramAttributeSet = this.HeT;
          this.HeU = paramAttributeSet;
          this.cIN = ((ImageView)findViewById(2131297368));
          this.cIN.setBackgroundDrawable(this.HeR);
          this.cIN.setImageDrawable(this.HeT);
          this.cIN.setOnTouchListener(this.HeV);
          this.cIN.setContentDescription(paramContext);
          this.Ws = ((TextView)findViewById(2131297371));
          if (i != -1) {
            this.Ws.setText(getContext().getString(i));
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
      paramAttributeSet = this.HeS;
      continue;
      label290:
      paramAttributeSet = this.HeU;
      continue;
      label298:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115376);
    this.cIN.setEnabled(paramBoolean);
    this.Ws.setEnabled(paramBoolean);
    AppMethodBeat.o(115376);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115377);
    this.cIN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */