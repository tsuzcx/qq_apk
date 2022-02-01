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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatTipImageView
  extends AvatarPatImageView
  implements d
{
  public PatPopupWindow ARv;
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public AvatarPatTipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206984);
    this.ARv = new PatPopupWindow(View.inflate(MMApplicationContext.getContext(), 2131495900, null));
    this.ARv.setAnimationStyle(2131821239);
    this.ARv.setOutsideTouchable(true);
    AppMethodBeat.o(206984);
  }
  
  public void aJN(String paramString)
  {
    AppMethodBeat.i(206987);
    final int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = MMApplicationContext.getResources().getDimensionPixelSize(2131165297);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    ((TextView)this.ARv.getContentView().findViewById(2131305793)).setText(l.c(MMApplicationContext.getContext(), paramString));
    this.ARv.a(this, localLayoutParams);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206983);
        int[] arrayOfInt = new int[2];
        View localView = AvatarPatTipImageView.this.ARv.getContentView();
        localView.getLocationOnScreen(arrayOfInt);
        localView = localView.findViewById(2131309162);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        localLayoutParams.leftMargin = (arrayOfInt[0] + AvatarPatTipImageView.this.getWidth() / 2 - arrayOfInt[0] - localView.getWidth() / 2);
        localView.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(206983);
      }
    });
    AppMethodBeat.o(206987);
  }
  
  public final void eBp()
  {
    AppMethodBeat.i(206988);
    this.ARv.dismiss();
    AppMethodBeat.o(206988);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(206986);
    super.onAttachedToWindow();
    this.ARu.ARA = this;
    AppMethodBeat.o(206986);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(206989);
    super.onDetachedFromWindow();
    this.ARu.eBr();
    this.ARv.dismiss();
    AppMethodBeat.o(206989);
  }
  
  public void setTagUsername(String paramString)
  {
    AppMethodBeat.i(206985);
    if (!Util.nullAsNil(getTagUsername()).equals(paramString)) {
      this.ARu.eBr();
    }
    super.setTagUsername(paramString);
    AppMethodBeat.o(206985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView
 * JD-Core Version:    0.7.0.1
 */