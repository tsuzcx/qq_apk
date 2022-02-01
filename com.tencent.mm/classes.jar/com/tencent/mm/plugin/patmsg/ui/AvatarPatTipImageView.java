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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class AvatarPatTipImageView
  extends AvatarPatImageView
  implements d
{
  public PatPopupWindow wFQ;
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215728);
    this.wFQ = new PatPopupWindow(View.inflate(aj.getContext(), 2131496417, null));
    this.wFQ.setAnimationStyle(2131821787);
    this.wFQ.setOutsideTouchable(true);
    AppMethodBeat.o(215728);
  }
  
  public void aul(String paramString)
  {
    AppMethodBeat.i(215731);
    final int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = aj.getResources().getDimensionPixelSize(2131165290);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    ((TextView)this.wFQ.getContentView().findViewById(2131308171)).setText(k.c(aj.getContext(), paramString));
    this.wFQ.a(this, localLayoutParams);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215727);
        int[] arrayOfInt = new int[2];
        View localView = AvatarPatTipImageView.this.wFQ.getContentView();
        localView.getLocationOnScreen(arrayOfInt);
        localView = localView.findViewById(2131308443);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt[0] + AvatarPatTipImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(215727);
      }
    });
    AppMethodBeat.o(215731);
  }
  
  public final void dyo()
  {
    AppMethodBeat.i(215732);
    this.wFQ.dismiss();
    AppMethodBeat.o(215732);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(215730);
    super.onAttachedToWindow();
    this.wFP.wFV = this;
    AppMethodBeat.o(215730);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(215733);
    super.onDetachedFromWindow();
    this.wFP.dyq();
    this.wFQ.dismiss();
    AppMethodBeat.o(215733);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(215729);
    if (!bt.nullAsNil(getTagUsername()).equals(paramString)) {
      this.wFP.dyq();
    }
    super.setTagUsername(paramString);
    AppMethodBeat.o(215729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
 * JD-Core Version:    0.7.0.1
 */