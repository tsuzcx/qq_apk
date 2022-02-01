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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.b.a;

public class VoipSmallIconButton
  extends FrameLayout
{
  private Drawable Cjw;
  private Drawable Cjx;
  private View.OnTouchListener Cjy;
  private TextView Wf;
  private ImageView cum;
  private Context mContext;
  
  public VoipSmallIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115391);
    this.Cjw = null;
    this.Cjx = null;
    this.Cjy = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(115389);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/voip/ui/VoipSmallIconButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/plugin/voip/ui/VoipSmallIconButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(115389);
          return false;
          VoipSmallIconButton.b(VoipSmallIconButton.this).setImageDrawable(VoipSmallIconButton.a(VoipSmallIconButton.this));
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(2131099673));
          continue;
          VoipSmallIconButton.b(VoipSmallIconButton.this).setImageDrawable(VoipSmallIconButton.e(VoipSmallIconButton.this));
          VoipSmallIconButton.d(VoipSmallIconButton.this).setTextColor(VoipSmallIconButton.c(VoipSmallIconButton.this).getResources().getColor(2131101182));
        }
      }
    };
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131494578, this);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, b.a.VoipButton, 0, 0);
    try
    {
      this.Cjw = paramContext.getDrawable(2);
      this.Cjx = paramContext.getDrawable(3);
      paramAttributeSet = paramContext.getString(4);
      int i = paramContext.getResourceId(4, -1);
      paramContext.recycle();
      this.cum = ((ImageView)findViewById(2131304850));
      this.cum.setImageDrawable(this.Cjw);
      this.cum.setOnTouchListener(this.Cjy);
      this.cum.setContentDescription(paramAttributeSet);
      this.Wf = ((TextView)findViewById(2131304852));
      if (i != -1) {
        this.Wf.setText(getContext().getString(i));
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
    this.cum.setEnabled(paramBoolean);
    this.Wf.setEnabled(paramBoolean);
    AppMethodBeat.o(115392);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115390);
    this.cum.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipSmallIconButton
 * JD-Core Version:    0.7.0.1
 */