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
  private BaseToyUI MFQ;
  public a MFk;
  
  public a(BaseToyUI paramBaseToyUI)
  {
    AppMethodBeat.i(159962);
    this.MFQ = paramBaseToyUI;
    this.MFk = new a(paramBaseToyUI);
    AppMethodBeat.o(159962);
  }
  
  public final class a
  {
    public LinkedList<g> MGg;
    public boolean MGh;
    public Drawable MGi;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159961);
      this.MGg = new LinkedList();
      this.MGh = true;
      this.MGi = new ColorDrawable(paramContext.getResources().getColor(2131100551));
      AppMethodBeat.o(159961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.d.a
 * JD-Core Version:    0.7.0.1
 */