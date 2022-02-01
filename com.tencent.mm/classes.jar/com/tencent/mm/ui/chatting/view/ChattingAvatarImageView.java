package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.be;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ChattingAvatarImageView
  extends AvatarPatTipImageView
{
  private IListener<be> PGg;
  private Runnable PGh;
  private final String TAG;
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233533);
    this.TAG = "MicroMsg.ChattingAvatarImageView";
    this.PGg = new IListener() {};
    this.PGh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233532);
        final int[] arrayOfInt = new int[2];
        ChattingAvatarImageView.this.getLocationOnScreen(arrayOfInt);
        int i = MMApplicationContext.getResources().getDimensionPixelSize(2131165314);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = (-MMApplicationContext.getResources().getDimensionPixelSize(2131165277));
        ChattingAvatarImageView.e(ChattingAvatarImageView.this).a(ChattingAvatarImageView.this, localLayoutParams);
        ChattingAvatarImageView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233531);
            int[] arrayOfInt = new int[2];
            View localView = ChattingAvatarImageView.f(ChattingAvatarImageView.this).getContentView();
            localView.getLocationOnScreen(arrayOfInt);
            localView = localView.findViewById(2131309162);
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            localLayoutParams.leftMargin = (arrayOfInt[0] + ChattingAvatarImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
            localView.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(233531);
          }
        });
        AppMethodBeat.o(233532);
      }
    };
    AppMethodBeat.o(233533);
  }
  
  public final void aJN(String paramString) {}
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(233535);
    super.onDetachedFromWindow();
    removeCallbacks(this.PGh);
    this.PGg.dead();
    AppMethodBeat.o(233535);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(233534);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.PGg != null)
    {
      if (paramInt == 8)
      {
        this.PGg.dead();
        AppMethodBeat.o(233534);
        return;
      }
      if (paramInt == 0) {
        this.PGg.alive();
      }
    }
    AppMethodBeat.o(233534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView
 * JD-Core Version:    0.7.0.1
 */