package com.tencent.toybrick.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.ui.BaseToyUI;
import java.util.LinkedList;

public final class a
{
  private BaseToyUI SnR;
  public a Snl;
  
  public a(BaseToyUI paramBaseToyUI)
  {
    AppMethodBeat.i(159962);
    this.SnR = paramBaseToyUI;
    this.Snl = new a(paramBaseToyUI);
    AppMethodBeat.o(159962);
  }
  
  public final class a
  {
    public LinkedList<g> Soh;
    public boolean Soi;
    public Drawable Soj;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159961);
      this.Soh = new LinkedList();
      this.Soi = true;
      this.Soj = new ColorDrawable(paramContext.getResources().getColor(2131100690));
      AppMethodBeat.o(159961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.d.a
 * JD-Core Version:    0.7.0.1
 */