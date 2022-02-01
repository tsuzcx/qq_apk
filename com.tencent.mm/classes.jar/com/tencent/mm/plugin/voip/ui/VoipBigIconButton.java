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
  private TextView Tu;
  private ImageView kPl;
  private Context mContext;
  private Drawable zrH;
  private Drawable zrI;
  private Drawable zrJ;
  private Drawable zrK;
  private View.OnTouchListener zrL;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115375);
    this.zrH = null;
    this.zrI = null;
    this.zrJ = null;
    this.zrK = null;
    this.zrL = new View.OnTouchListener()
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
        this.zrH = paramAttributeSet.getDrawable(0);
        this.zrI = paramAttributeSet.getDrawable(1);
        this.zrJ = paramAttributeSet.getDrawable(2);
        this.zrK = paramAttributeSet.getDrawable(3);
        int i = paramAttributeSet.getResourceId(4, -1);
        int j = paramAttributeSet.getResourceId(4, 0);
        if (j == 0) {
          break label298;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.zrI == null)
        {
          paramAttributeSet = this.zrH;
          this.zrI = paramAttributeSet;
          if (this.zrK != null) {
            break label290;
          }
          paramAttributeSet = this.zrJ;
          this.zrK = paramAttributeSet;
          this.kPl = ((ImageView)findViewById(2131297213));
          this.kPl.setBackgroundDrawable(this.zrH);
          this.kPl.setImageDrawable(this.zrJ);
          this.kPl.setOnTouchListener(this.zrL);
          this.kPl.setContentDescription(paramContext);
          this.Tu = ((TextView)findViewById(2131297216));
          if (i != -1) {
            this.Tu.setText(getContext().getString(i));
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
      paramAttributeSet = this.zrI;
      continue;
      label290:
      paramAttributeSet = this.zrK;
      continue;
      label298:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115376);
    this.kPl.setEnabled(paramBoolean);
    this.Tu.setEnabled(paramBoolean);
    AppMethodBeat.o(115376);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115377);
    this.kPl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */