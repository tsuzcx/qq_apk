package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.img.DetailImgUI;

public final class g
  extends a
{
  public g(int paramInt)
  {
    super(6, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903068, paramViewGroup, false);
    paramViewGroup = new h(this);
    paramViewGroup.ajn = ((TextView)paramContext.findViewById(2131558444));
    paramViewGroup.akL = ((ImageView)paramContext.findViewById(2131558449));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (h)paramb;
    if (ok())
    {
      paramb.ajn.setVisibility(0);
      TextView localTextView = paramb.ajn;
      e.nn();
      localTextView.setText(e.a(paramContext, this.akG.aiI.XO, 24));
    }
    for (;;)
    {
      paramContext = new com.tencent.mm.wear.app.c.a();
      paramContext.agn = 2131427357;
      paramContext.agm = paramb.akL;
      paramContext.type = 2;
      paramContext.agh = this.akG.aiI.XJ;
      paramContext.width = MMActivity.nP();
      paramContext.height = MMActivity.nO();
      com.tencent.mm.wear.app.b.h.mR().a(paramContext);
      return;
      paramb.ajn.setVisibility(8);
    }
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.cj(6);
    parama = new Intent(paramContext, DetailImgUI.class);
    parama.putExtra("key_msg_id", this.akG.aiI.XJ);
    paramContext.startActivity(parama);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.g
 * JD-Core Version:    0.7.0.1
 */