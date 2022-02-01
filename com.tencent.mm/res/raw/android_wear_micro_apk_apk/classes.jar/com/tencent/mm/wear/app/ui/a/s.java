package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.g;

public final class s
  extends a
{
  public s(int paramInt)
  {
    super(10, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903075, paramViewGroup, false);
    paramViewGroup = new t(this);
    paramViewGroup.ajn = ((TextView)paramContext.findViewById(2131558444));
    paramViewGroup.akT = ((ImageView)paramContext.findViewById(2131558476));
    paramViewGroup.akU = ((TextView)paramContext.findViewById(2131558477));
    paramViewGroup.akV = ((ImageView)paramContext.findViewById(2131558478));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (t)paramb;
    if (ok())
    {
      paramb.ajn.setVisibility(0);
      TextView localTextView = paramb.ajn;
      e.nn();
      localTextView.setText(e.a(paramContext, this.akG.aiI.XO, 24));
      paramContext = new String(this.akG.aiI.XS.toByteArray());
      paramb.akU.setText(paramContext);
      if (this.akG.aiI.XJ != h.mQ().nh().nt()) {
        break label164;
      }
      paramb.akT.setBackgroundResource(2130837609);
      paramContext = (AnimationDrawable)paramb.akT.getBackground();
      if (paramContext != null) {
        paramContext.start();
      }
    }
    for (;;)
    {
      if (!this.akG.aiI.XR) {
        break label208;
      }
      paramb.akV.setVisibility(8);
      return;
      paramb.ajn.setVisibility(8);
      break;
      label164:
      if ((paramb.akT.getBackground() instanceof AnimationDrawable))
      {
        paramContext = (AnimationDrawable)paramb.akT.getBackground();
        if (paramContext != null) {
          paramContext.stop();
        }
      }
      paramb.akT.setBackgroundResource(2130837612);
    }
    label208:
    paramb.akV.setVisibility(0);
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.cj(5);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.s
 * JD-Core Version:    0.7.0.1
 */