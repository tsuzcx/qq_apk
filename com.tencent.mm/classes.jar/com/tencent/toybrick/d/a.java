package com.tencent.toybrick.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.ui.BaseToyUI;
import java.util.LinkedList;

public final class a
{
  public a ZPW;
  private BaseToyUI ZPZ;
  
  public a(BaseToyUI paramBaseToyUI)
  {
    AppMethodBeat.i(159962);
    this.ZPZ = paramBaseToyUI;
    this.ZPW = new a(paramBaseToyUI);
    AppMethodBeat.o(159962);
  }
  
  public final class a
  {
    public LinkedList<g> ZQa;
    public boolean ZQb;
    public Drawable ZQc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159961);
      this.ZQa = new LinkedList();
      this.ZQb = true;
      this.ZQc = new ColorDrawable(paramContext.getResources().getColor(a.c.list_devider_color));
      AppMethodBeat.o(159961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.d.a
 * JD-Core Version:    0.7.0.1
 */