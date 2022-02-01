package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.g;
import com.tencent.mm.wear.app.ui.message.ReplyLuckyUI;
import java.io.IOException;

public final class k
  extends a
{
  public k(int paramInt)
  {
    super(8, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903070, paramViewGroup, false);
    paramViewGroup = new l(this);
    paramViewGroup.ajn = ((TextView)paramContext.findViewById(2131558444));
    paramViewGroup.akO = ((TextView)paramContext.findViewById(2131558462));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (l)paramb;
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
    com.tencent.mm.wear.app.d.a.cj(7);
    n localn = new n();
    localn.XJ = parama.akG.aiI.XJ;
    localn.XI = parama.akG.aiI.XI;
    localn.Xr = parama.akG.aiI.XO;
    localn.Xs = parama.akG.aiI.Xs;
    parama = new Intent(paramContext, ReplyLuckyUI.class);
    try
    {
      parama.putExtra("key_data", localn.toByteArray());
      label91:
      parama.putExtra("key_open", true);
      paramContext.startActivity(parama);
      return true;
    }
    catch (IOException localIOException)
    {
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.k
 * JD-Core Version:    0.7.0.1
 */