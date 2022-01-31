package com.tencent.toybrick.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import java.util.LinkedList;

public final class a$a
{
  public LinkedList<g> BxU;
  public boolean BxV;
  public Drawable BxW;
  
  public a$a(a parama, Context paramContext)
  {
    AppMethodBeat.i(113224);
    this.BxU = new LinkedList();
    this.BxV = true;
    this.BxW = new ColorDrawable(paramContext.getResources().getColor(2131690217));
    AppMethodBeat.o(113224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.d.a.a
 * JD-Core Version:    0.7.0.1
 */