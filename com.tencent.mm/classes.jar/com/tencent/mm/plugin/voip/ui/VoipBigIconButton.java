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

public class VoipBigIconButton
  extends FrameLayout
{
  private Drawable Cju;
  private Drawable Cjv;
  private Drawable Cjw;
  private Drawable Cjx;
  private View.OnTouchListener Cjy;
  private TextView Wf;
  private ImageView cum;
  private Context mContext;
  
  public VoipBigIconButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115375);
    this.Cju = null;
    this.Cjv = null;
    this.Cjw = null;
    this.Cjx = null;
    this.Cjy = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(115374);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/voip/ui/VoipBigIconButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/plugin/voip/ui/VoipBigIconButton$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
        this.Cju = paramAttributeSet.getDrawable(0);
        this.Cjv = paramAttributeSet.getDrawable(1);
        this.Cjw = paramAttributeSet.getDrawable(2);
        this.Cjx = paramAttributeSet.getDrawable(3);
        int i = paramAttributeSet.getResourceId(4, -1);
        int j = paramAttributeSet.getResourceId(4, 0);
        if (j == 0) {
          break label298;
        }
        paramContext = getContext().getString(j);
        paramAttributeSet.recycle();
        if (this.Cjv == null)
        {
          paramAttributeSet = this.Cju;
          this.Cjv = paramAttributeSet;
          if (this.Cjx != null) {
            break label290;
          }
          paramAttributeSet = this.Cjw;
          this.Cjx = paramAttributeSet;
          this.cum = ((ImageView)findViewById(2131297213));
          this.cum.setBackgroundDrawable(this.Cju);
          this.cum.setImageDrawable(this.Cjw);
          this.cum.setOnTouchListener(this.Cjy);
          this.cum.setContentDescription(paramContext);
          this.Wf = ((TextView)findViewById(2131297216));
          if (i != -1) {
            this.Wf.setText(getContext().getString(i));
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
      paramAttributeSet = this.Cjv;
      continue;
      label290:
      paramAttributeSet = this.Cjx;
      continue;
      label298:
      paramContext = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(115376);
    this.cum.setEnabled(paramBoolean);
    this.Wf.setEnabled(paramBoolean);
    AppMethodBeat.o(115376);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(115377);
    this.cum.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(115377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBigIconButton
 * JD-Core Version:    0.7.0.1
 */