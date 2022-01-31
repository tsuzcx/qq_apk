package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.e;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.g;
import java.io.IOException;

public final class c
  extends a
{
  public c(int paramInt)
  {
    super(2, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903066, paramViewGroup, false);
    paramViewGroup = new d(this);
    paramViewGroup.afL = ((TextView)paramContext.findViewById(2131558443));
    paramViewGroup.ahg = ((MMGIFImageView)paramContext.findViewById(2131558474));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (d)paramb;
    if (nx())
    {
      paramb.afL.setVisibility(0);
      TextView localTextView = paramb.afL;
      e.mB();
      localTextView.setText(e.a(paramContext, this.ahe.afg.VT, 24));
    }
    for (;;)
    {
      paramContext = new com.tencent.mm.wear.app.c.a();
      paramContext.acM = 2130837533;
      paramContext.acL = paramb.ahg;
      paramContext.type = 1;
      paramContext.acG = this.ahe.afg.VO;
      paramContext.width = (MMActivity.nc() / 2);
      paramContext.height = (MMActivity.nb() / 2);
      try
      {
        paramb = new com.tencent.mm.e.a.d();
        paramb.h(this.ahe.afg.VX.toByteArray());
        paramContext.acQ = paramb.Vq;
        paramContext.acJ = paramb.Vr;
        label150:
        h.me().a(paramContext);
        return;
        paramb.afL.setVisibility(8);
      }
      catch (IOException paramb)
      {
        break label150;
      }
    }
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.c
 * JD-Core Version:    0.7.0.1
 */