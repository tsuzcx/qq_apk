package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.m;

public final class l
  extends c
{
  public l(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint, paramDisplayMetrics, paramInt);
  }
  
  protected final b a(b.a parama)
  {
    AppMethodBeat.i(81182);
    parama = new m(parama, 2);
    AppMethodBeat.o(81182);
    return parama;
  }
  
  protected final String cij()
  {
    return "driving";
  }
  
  protected final int cik()
  {
    return 2131302890;
  }
  
  protected final float getAspectRatio()
  {
    return 1.467F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.l
 * JD-Core Version:    0.7.0.1
 */