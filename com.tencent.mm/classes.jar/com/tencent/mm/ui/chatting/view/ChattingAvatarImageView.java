package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bi;
import com.tencent.mm.plugin.patmsg.d.c;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ChattingAvatarImageView
  extends AvatarPatTipImageView
{
  private final String TAG;
  private IListener<bi> XaY;
  private Runnable XaZ;
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236914);
    this.TAG = "MicroMsg.ChattingAvatarImageView";
    this.XaY = new IListener() {};
    this.XaZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289267);
        final int[] arrayOfInt = new int[2];
        ChattingAvatarImageView.this.getLocationOnScreen(arrayOfInt);
        int i = MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_A);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = (-MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_0_5_A));
        ChattingAvatarImageView.e(ChattingAvatarImageView.this).a(ChattingAvatarImageView.this, localLayoutParams);
        ChattingAvatarImageView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(278710);
            int[] arrayOfInt = new int[2];
            View localView = ChattingAvatarImageView.f(ChattingAvatarImageView.this).getContentView();
            localView.getLocationOnScreen(arrayOfInt);
            localView = localView.findViewById(d.d.tip_triangle_iv);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.leftMargin = (arrayOfInt[0] + ChattingAvatarImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
            localView.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(278710);
          }
        });
        AppMethodBeat.o(289267);
      }
    };
    AppMethodBeat.o(236914);
  }
  
  public final void aUj(String paramString) {}
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(236918);
    super.onDetachedFromWindow();
    removeCallbacks(this.XaZ);
    this.XaY.dead();
    AppMethodBeat.o(236918);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(236917);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.XaY != null)
    {
      if (paramInt == 8)
      {
        this.XaY.dead();
        AppMethodBeat.o(236917);
        return;
      }
      if (paramInt == 0) {
        this.XaY.alive();
      }
    }
    AppMethodBeat.o(236917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView
 * JD-Core Version:    0.7.0.1
 */