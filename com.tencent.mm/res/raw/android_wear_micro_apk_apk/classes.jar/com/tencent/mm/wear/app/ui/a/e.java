package com.tencent.mm.wear.app.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.e.a.d;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.emoji.gif.MMGIFImageView;
import com.tencent.mm.wear.app.ui.MMActivity;
import com.tencent.mm.wear.app.ui.g;
import java.io.IOException;

public final class e
  extends a
{
  public e(int paramInt)
  {
    super(4, paramInt);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903067, paramViewGroup, false);
    paramViewGroup = new f(this);
    paramViewGroup.akI = ((MMGIFImageView)paramContext.findViewById(2131558475));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, b paramb)
  {
    paramb = (f)paramb;
    paramContext = new com.tencent.mm.wear.app.c.a();
    paramContext.agm = paramb.akI;
    paramContext.agn = 2130837533;
    paramContext.type = 1;
    paramContext.agh = this.akG.aiI.XJ;
    paramContext.width = (MMActivity.nP() / 2);
    paramContext.height = (MMActivity.nO() / 2);
    try
    {
      paramb = new d();
      paramb.h(this.akG.aiI.XS.toByteArray());
      paramContext.agr = paramb.Xl;
      paramContext.agk = paramb.Xm;
      label106:
      h.mR().a(paramContext);
      return;
    }
    catch (IOException paramb)
    {
      break label106;
    }
  }
  
  public final boolean a(Context paramContext, a parama)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a.e
 * JD-Core Version:    0.7.0.1
 */