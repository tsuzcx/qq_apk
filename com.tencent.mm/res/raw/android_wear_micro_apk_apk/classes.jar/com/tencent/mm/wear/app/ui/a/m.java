package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.ui.g;
import com.tencent.mm.wear.app.ui.message.ReplyLuckyUI;
import java.io.IOException;

public final class m
  extends a
{
  public m(int paramInt)
  {
    super(9, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903071, paramViewGroup, false);
    paramViewGroup = new n(this);
    paramViewGroup.ahm = ((TextView)paramContext.findViewById(2131558461));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = ((n)paramb).ahm;
    e.mB();
    paramb.setText(e.a(paramContext, this.ahe.afg.Vx, 21));
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.bN(7);
    com.tencent.mm.e.a.n localn = new com.tencent.mm.e.a.n();
    localn.VO = parama.ahe.afg.VO;
    localn.VN = parama.ahe.afg.VN;
    localn.Vw = parama.ahe.afg.VT;
    localn.Vx = parama.ahe.afg.Vx;
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
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.m
 * JD-Core Version:    0.7.0.1
 */