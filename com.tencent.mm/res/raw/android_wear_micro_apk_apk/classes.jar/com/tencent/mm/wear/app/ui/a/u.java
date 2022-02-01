package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.g;

public final class u
  extends a
{
  public u(int paramInt)
  {
    super(11, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903076, paramViewGroup, false);
    paramViewGroup = new v(this);
    paramViewGroup.akT = ((ImageView)paramContext.findViewById(2131558476));
    paramViewGroup.akU = ((TextView)paramContext.findViewById(2131558477));
    paramViewGroup.akV = ((ImageView)paramContext.findViewById(2131558478));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramContext = (v)paramb;
    paramb = new String(this.akG.aiI.XS.toByteArray());
    paramContext.akU.setText(paramb);
    if (this.akG.aiI.XJ == h.mQ().nh().nt())
    {
      paramContext.akT.setBackgroundResource(2130837616);
      paramb = (AnimationDrawable)paramContext.akT.getBackground();
      if (paramb != null) {
        paramb.start();
      }
    }
    for (;;)
    {
      paramContext.akV.setVisibility(8);
      return;
      if ((paramContext.akT.getBackground() instanceof AnimationDrawable))
      {
        paramb = (AnimationDrawable)paramContext.akT.getBackground();
        if (paramb != null) {
          paramb.stop();
        }
      }
      paramContext.akT.setBackgroundResource(2130837615);
    }
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.cj(5);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.u
 * JD-Core Version:    0.7.0.1
 */