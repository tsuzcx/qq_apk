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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public class AvatarPatTipImageView
  extends AvatarPatImageView
  implements d
{
  public PatPopupWindow wVC;
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220362);
    this.wVC = new PatPopupWindow(View.inflate(ak.getContext(), 2131496417, null));
    this.wVC.setAnimationStyle(2131821787);
    this.wVC.setOutsideTouchable(true);
    AppMethodBeat.o(220362);
  }
  
  public void avA(String paramString)
  {
    AppMethodBeat.i(220365);
    final int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = ak.getResources().getDimensionPixelSize(2131165290);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    ((TextView)this.wVC.getContentView().findViewById(2131308171)).setText(k.c(ak.getContext(), paramString));
    this.wVC.a(this, localLayoutParams);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220361);
        int[] arrayOfInt = new int[2];
        View localView = AvatarPatTipImageView.this.wVC.getContentView();
        localView.getLocationOnScreen(arrayOfInt);
        localView = localView.findViewById(2131308443);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt[0] + AvatarPatTipImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(220361);
      }
    });
    AppMethodBeat.o(220365);
  }
  
  public final void dBE()
  {
    AppMethodBeat.i(220366);
    this.wVC.dismiss();
    AppMethodBeat.o(220366);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(220364);
    super.onAttachedToWindow();
    this.wVB.wVH = this;
    AppMethodBeat.o(220364);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(220367);
    super.onDetachedFromWindow();
    this.wVB.dBG();
    this.wVC.dismiss();
    AppMethodBeat.o(220367);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(220363);
    if (!bu.nullAsNil(getTagUsername()).equals(paramString)) {
      this.wVB.dBG();
    }
    super.setTagUsername(paramString);
    AppMethodBeat.o(220363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
 * JD-Core Version:    0.7.0.1
 */