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
    paramViewGroup.afL = ((TextView)paramContext.findViewById(2131558443));
    paramViewGroup.ahr = ((ImageView)paramContext.findViewById(2131558475));
    paramViewGroup.ahs = ((TextView)paramContext.findViewById(2131558476));
    paramViewGroup.aht = ((ImageView)paramContext.findViewById(2131558477));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (t)paramb;
    if (nx())
    {
      paramb.afL.setVisibility(0);
      TextView localTextView = paramb.afL;
      e.mB();
      localTextView.setText(e.a(paramContext, this.ahe.afg.VT, 24));
      paramContext = new String(this.ahe.afg.VX.toByteArray());
      paramb.ahs.setText(paramContext);
      if (this.ahe.afg.VO != h.md().mv().mH()) {
        break label164;
      }
      paramb.ahr.setBackgroundResource(2130837609);
      paramContext = (AnimationDrawable)paramb.ahr.getBackground();
      if (paramContext != null) {
        paramContext.start();
      }
    }
    for (;;)
    {
      if (!this.ahe.afg.VW) {
        break label208;
      }
      paramb.aht.setVisibility(8);
      return;
      paramb.afL.setVisibility(8);
      break;
      label164:
      if ((paramb.ahr.getBackground() instanceof AnimationDrawable))
      {
        paramContext = (AnimationDrawable)paramb.ahr.getBackground();
        if (paramContext != null) {
          paramContext.stop();
        }
      }
      paramb.ahr.setBackgroundResource(2130837612);
    }
    label208:
    paramb.aht.setVisibility(0);
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.bN(5);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.s
 * JD-Core Version:    0.7.0.1
 */