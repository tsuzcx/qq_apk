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
  private Drawable AKs;
  private Drawable AKt;
  private Drawable AKu;
  private Drawable AKv;
  private View.OnTouchListener AKw;
  private TextView Up;
  private ImageView lqK;
  private Context mContext;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115375);
    this.AKs = null;
    this.AKt = null;
    this.AKu = null;
    this.AKv = null;
    this.AKw = new View.OnTouchListener()
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
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(2131099673));
          continue;
          VoipBigIconButton.b(VoipBigIconButton.this).setBackgroundDrawable(VoipBigIconButton.f(VoipBigIconButton.this));
          VoipBigIconButton.b(VoipBigIconButton.this).setImageDrawable(VoipBigIconButton.g(VoipBigIconButton.this));
          VoipBigIconButton.e(VoipBigIconButton.this).setTextColor(VoipBigIconButton.d(VoipBigIconButton.this).getResources().getColor(2131101182));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131494577, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.a.VoipButton, 0, 0);
    for (;;)
    {
      try
      {
        this.AKs = paramAttributeSet.getDrawable(0);
        this.AKt = paramAttributeSet.getDrawable(1);
        this.AKu = paramAttributeSet.getDrawable(2);
        this.AKv = paramAttributeSet.getDrawable(3);
        int i = paramAttributeSet.getResourceId(4, -1);
        int j = paramAttributeSet.getResourceId(4, 0);
        if (j == 0) {
          break label298;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.AKt == null)
        {
          paramAttributeSet = this.AKs;
          this.AKt = paramAttributeSet;
          if (this.AKv != null) {
            break label290;
          }
          paramAttributeSet = this.AKu;
          this.AKv = paramAttributeSet;
          this.lqK = ((ImageView)findViewById(2131297213));
          this.lqK.setBackgroundDrawable(this.AKs);
          this.lqK.setImageDrawable(this.AKu);
          this.lqK.setOnTouchListener(this.AKw);
          this.lqK.setContentDescription(paramContext);
          this.Up = ((TextView)findViewById(2131297216));
          if (i != -1) {
            this.Up.setText(getContext().getString(i));
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
      paramAttributeSet = this.AKt;
      continue;
      label290:
      paramAttributeSet = this.AKv;
      continue;
      label298:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115376);
    this.lqK.setEnabled(paramBoolean);
    this.Up.setEnabled(paramBoolean);
    AppMethodBeat.o(115376);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115377);
    this.lqK.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */