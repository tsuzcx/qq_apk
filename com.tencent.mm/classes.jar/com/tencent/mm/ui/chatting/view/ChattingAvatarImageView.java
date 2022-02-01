package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;

public class ChattingAvatarImageView
  extends AvatarPatTipImageView
{
  private c<bc> KtQ;
  private Runnable KtR;
  private final String TAG;
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187657);
    this.TAG = "MicroMsg.ChattingAvatarImageView";
    this.KtQ = new c() {};
    this.KtR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187656);
        final int[] arrayOfInt = new int[2];
        ChattingAvatarImageView.this.getLocationOnScreen(arrayOfInt);
        int i = ak.getResources().getDimensionPixelSize(2131165303);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = (-ak.getResources().getDimensionPixelSize(2131165274));
        ChattingAvatarImageView.e(ChattingAvatarImageView.this).a(ChattingAvatarImageView.this, localLayoutParams);
        ChattingAvatarImageView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187655);
            int[] arrayOfInt = new int[2];
            View localView = ChattingAvatarImageView.f(ChattingAvatarImageView.this).getContentView();
            localView.getLocationOnScreen(arrayOfInt);
            localView = localView.findViewById(2131308443);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.leftMargin = (arrayOfInt[0] + ChattingAvatarImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
            localView.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(187655);
          }
        });
        AppMethodBeat.o(187656);
      }
    };
    AppMethodBeat.o(187657);
  }
  
  public final void avA(String paramString)
  {
    AppMethodBeat.i(187659);
    AppMethodBeat.o(187659);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(187660);
    super.onDetachedFromWindow();
    removeCallbacks(this.KtR);
    AppMethodBeat.o(187660);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(187658);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.KtQ != null)
    {
      if (paramInt == 8)
      {
        this.KtQ.dead();
        AppMethodBeat.o(187658);
        return;
      }
      if (paramInt == 0) {
        this.KtQ.alive();
      }
    }
    AppMethodBeat.o(187658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView
 * JD-Core Version:    0.7.0.1
 */