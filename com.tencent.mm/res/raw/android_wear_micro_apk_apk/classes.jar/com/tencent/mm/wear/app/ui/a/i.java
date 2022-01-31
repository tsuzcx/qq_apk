package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.g;
import com.tencent.mm.wear.app.ui.img.DetailImgUI;

public final class i
  extends a
{
  public i(int paramInt)
  {
    super(7, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903069, paramViewGroup, false);
    paramViewGroup = new j(this);
    paramViewGroup.ahj = ((ImageView)paramContext.findViewById(2131558448));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramContext = (j)paramb;
    paramb = new com.tencent.mm.wear.app.c.a();
    paramb.acM = 2131427357;
    paramb.acL = paramContext.ahj;
    paramb.type = 2;
    paramb.acG = this.ahe.afg.VO;
    paramb.width = MMActivity.nc();
    paramb.height = MMActivity.nb();
    h.me().a(paramb);
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    com.tencent.mm.wear.app.d.a.bN(6);
    parama = new Intent(paramContext, DetailImgUI.class);
    parama.putExtra("key_msg_id", this.ahe.afg.VO);
    paramContext.startActivity(parama);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.i
 * JD-Core Version:    0.7.0.1
 */