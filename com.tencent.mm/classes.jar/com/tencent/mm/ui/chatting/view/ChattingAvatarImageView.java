package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.patmsg.ui.PatPopupWindow;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;

public class ChattingAvatarImageView
  extends AvatarPatTipImageView
{
  private c<bc> JXz;
  private Runnable Ofq;
  private final String TAG;
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingAvatarImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194265);
    this.TAG = "MicroMsg.ChattingAvatarImageView";
    this.JXz = new c() {};
    this.Ofq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194264);
        int[] arrayOfInt = new int[2];
        ChattingAvatarImageView.this.getLocationOnScreen(arrayOfInt);
        int i = aj.getResources().getDimensionPixelSize(2131165303);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = (-aj.getResources().getDimensionPixelSize(2131165274));
        ChattingAvatarImageView.e(ChattingAvatarImageView.this).a(ChattingAvatarImageView.this, localLayoutParams);
        ChattingAvatarImageView.this.post(new ChattingAvatarImageView.2.1(this, arrayOfInt));
        AppMethodBeat.o(194264);
      }
    };
    AppMethodBeat.o(194265);
  }
  
  public final void aul(String paramString)
  {
    AppMethodBeat.i(194267);
    ((TextView)this.wFQ.getContentView().findViewById(2131308171)).setText(k.c(aj.getContext(), paramString));
    postDelayed(this.Ofq, 200L);
    AppMethodBeat.o(194267);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(221415);
    super.onDetachedFromWindow();
    removeCallbacks(this.Ofq);
    AppMethodBeat.o(221415);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(194266);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.JXz != null)
    {
      if (paramInt == 8)
      {
        this.JXz.dead();
        AppMethodBeat.o(194266);
        return;
      }
      if (paramInt == 0) {
        this.JXz.alive();
      }
    }
    AppMethodBeat.o(194266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.ChattingAvatarImageView
 * JD-Core Version:    0.7.0.1
 */