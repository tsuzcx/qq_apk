package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.g;

public final class q
  extends a
{
  public q(int paramInt)
  {
    super(3, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903074, paramViewGroup, false);
    paramViewGroup = new r(this);
    paramViewGroup.ahm = ((TextView)paramContext.findViewById(2131558461));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = ((r)paramb).ahm;
    e.mB();
    paramb.setText(e.a(paramContext, this.ahe.afg.Vx, 21));
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.q
 * JD-Core Version:    0.7.0.1
 */