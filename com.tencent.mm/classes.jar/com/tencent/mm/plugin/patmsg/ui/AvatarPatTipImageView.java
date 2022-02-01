package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.plugin.patmsg.d.c;
import com.tencent.mm.plugin.patmsg.d.d;
import com.tencent.mm.plugin.patmsg.d.e;
import com.tencent.mm.plugin.patmsg.d.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatTipImageView
  extends AvatarPatImageView
  implements d
{
  public PatPopupWindow GKG;
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186403);
    this.GKG = new PatPopupWindow(View.inflate(MMApplicationContext.getContext(), d.e.pat_tips_view, null));
    this.GKG.setAnimationStyle(d.g.PatTipWindowAnimation);
    this.GKG.setOutsideTouchable(true);
    AppMethodBeat.o(186403);
  }
  
  public void aUj(String paramString)
  {
    AppMethodBeat.i(186412);
    final int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_2_5_A);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    ((TextView)this.GKG.getContentView().findViewById(d.d.pat_msg_tv)).setText(l.c(MMApplicationContext.getContext(), paramString));
    this.GKG.a(this, localLayoutParams);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186699);
        int[] arrayOfInt = new int[2];
        View localView = AvatarPatTipImageView.this.GKG.getContentView();
        localView.getLocationOnScreen(arrayOfInt);
        localView = localView.findViewById(d.d.tip_triangle_iv);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt[0] + AvatarPatTipImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(186699);
      }
    });
    AppMethodBeat.o(186412);
  }
  
  public final void fmW()
  {
    AppMethodBeat.i(186414);
    this.GKG.dismiss();
    AppMethodBeat.o(186414);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(186409);
    super.onAttachedToWindow();
    this.GKF.GKL = this;
    AppMethodBeat.o(186409);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(186416);
    super.onDetachedFromWindow();
    this.GKF.fmY();
    this.GKG.dismiss();
    AppMethodBeat.o(186416);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(186407);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.GKF.fmY();
    }
    super.setTagUsername(paramString);
    AppMethodBeat.o(186407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
 * JD-Core Version:    0.7.0.1
 */