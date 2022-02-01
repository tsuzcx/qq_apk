package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.br;
import com.tencent.mm.plugin.patmsg.d.c;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ChattingAvatarImageView
  extends AvatarPatTipImageView
{
  private final String TAG;
  private IListener<br> aeKF;
  private Runnable aeKG;
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254278);
    this.TAG = "MicroMsg.ChattingAvatarImageView";
    this.aeKF = new IListener(f.hfK) {};
    this.aeKG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254275);
        final int[] arrayOfInt = new int[2];
        ChattingAvatarImageView.this.getLocationOnScreen(arrayOfInt);
        int i = MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_A);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = (-MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_0_5_A));
        ChattingAvatarImageView.e(ChattingAvatarImageView.this).b(ChattingAvatarImageView.this, localLayoutParams);
        ChattingAvatarImageView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254279);
            int[] arrayOfInt = new int[2];
            View localView = ChattingAvatarImageView.f(ChattingAvatarImageView.this).getContentView();
            localView.getLocationOnScreen(arrayOfInt);
            localView = localView.findViewById(d.d.tip_triangle_iv);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.leftMargin = (arrayOfInt[0] + ChattingAvatarImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
            localView.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(254279);
          }
        });
        AppMethodBeat.o(254275);
      }
    };
    AppMethodBeat.o(254278);
  }
  
  public final void ao(CharSequence paramCharSequence) {}
  
  public float getTipTextSize()
  {
    AppMethodBeat.i(254298);
    try
    {
      float f = ((TextView)this.MHA.getContentView().findViewById(d.d.pat_msg_tv)).getTextSize();
      AppMethodBeat.o(254298);
      return f;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ChattingAvatarImageView", localThrowable, "getTipTextSize err", new Object[0]);
      AppMethodBeat.o(254298);
    }
    return 0.0F;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(254304);
    super.onDetachedFromWindow();
    removeCallbacks(this.aeKG);
    this.aeKF.dead();
    AppMethodBeat.o(254304);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(254295);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.aeKF != null)
    {
      if (paramInt == 8)
      {
        this.aeKF.dead();
        AppMethodBeat.o(254295);
        return;
      }
      if (paramInt == 0) {
        this.aeKF.alive();
      }
    }
    AppMethodBeat.o(254295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView
 * JD-Core Version:    0.7.0.1
 */