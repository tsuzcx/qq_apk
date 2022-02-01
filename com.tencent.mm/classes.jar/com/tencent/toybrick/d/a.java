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
  private BaseToyUI KsS;
  public a Ksm;
  
  public a(BaseToyUI paramBaseToyUI)
  {
    AppMethodBeat.i(159962);
    this.KsS = paramBaseToyUI;
    this.Ksm = new a(paramBaseToyUI);
    AppMethodBeat.o(159962);
  }
  
  public final class a
  {
    public LinkedList<g> Kti;
    public boolean Ktj;
    public Drawable Ktk;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159961);
      this.Kti = new LinkedList();
      this.Ktj = true;
      this.Ktk = new ColorDrawable(paramContext.getResources().getColor(2131100551));
      AppMethodBeat.o(159961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.d.a
 * JD-Core Version:    0.7.0.1
 */