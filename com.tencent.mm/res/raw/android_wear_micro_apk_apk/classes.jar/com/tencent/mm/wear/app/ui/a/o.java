package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.g;

public final class o
  extends a
{
  public o(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903073, paramViewGroup, false);
    paramViewGroup = new p(this);
    paramViewGroup.ajn = ((TextView)paramContext.findViewById(2131558444));
    paramViewGroup.akO = ((TextView)paramContext.findViewById(2131558462));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (p)paramb;
    if (ok())
    {
      paramb.ajn.setVisibility(0);
      TextView localTextView = paramb.ajn;
      e.nn();
      localTextView.setText(e.a(paramContext, this.akG.aiI.XO, 24));
    }
    for (;;)
    {
      paramb = paramb.akO;
      e.nn();
      paramb.setText(e.a(paramContext, this.akG.aiI.Xs, 21));
      return;
      paramb.ajn.setVisibility(8);
    }
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.o
 * JD-Core Version:    0.7.0.1
 */