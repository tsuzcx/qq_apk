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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatTipImageView
  extends AvatarPatImageView
  implements d
{
  public PatPopupWindow MHA;
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266373);
    this.MHA = new PatPopupWindow(View.inflate(MMApplicationContext.getContext(), d.e.pat_tips_view, null));
    this.MHA.setAnimationStyle(d.g.PatTipWindowAnimation);
    this.MHA.setOutsideTouchable(true);
    AppMethodBeat.o(266373);
  }
  
  public void ao(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(266402);
    final int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = MMApplicationContext.getResources().getDimensionPixelSize(d.c.Edge_2_5_A);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    ((TextView)this.MHA.getContentView().findViewById(d.d.pat_msg_tv)).setText(p.b(MMApplicationContext.getContext(), paramCharSequence));
    this.MHA.b(this, localLayoutParams);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266392);
        int[] arrayOfInt = new int[2];
        View localView = AvatarPatTipImageView.this.MHA.getContentView();
        localView.getLocationOnScreen(arrayOfInt);
        localView = localView.findViewById(d.d.tip_triangle_iv);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt[0] + AvatarPatTipImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(266392);
      }
    });
    AppMethodBeat.o(266402);
  }
  
  public float getTipTextSize()
  {
    AppMethodBeat.i(266394);
    try
    {
      float f = ((TextView)this.MHA.getContentView().findViewById(d.d.pat_msg_tv)).getTextSize();
      AppMethodBeat.o(266394);
      return f;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AvatarPatTipImageView", localThrowable, "getTipTextSize err", new Object[0]);
      AppMethodBeat.o(266394);
    }
    return 0.0F;
  }
  
  public final void gxK()
  {
    AppMethodBeat.i(266409);
    this.MHA.dismiss();
    AppMethodBeat.o(266409);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(266382);
    super.onAttachedToWindow();
    this.MHz.MHF = this;
    AppMethodBeat.o(266382);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(266415);
    super.onDetachedFromWindow();
    this.MHz.gxM();
    this.MHA.dismiss();
    AppMethodBeat.o(266415);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(266378);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.MHz.gxM();
    }
    super.setTagUsername(paramString);
    AppMethodBeat.o(266378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
 * JD-Core Version:    0.7.0.1
 */