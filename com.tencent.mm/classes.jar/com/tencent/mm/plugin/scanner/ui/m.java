package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;

public class m
  extends c
{
  public m(i.b paramb, Point paramPoint, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    super(paramb, paramPoint, paramDisplayMetrics, paramInt);
  }
  
  protected final b a(b.a parama)
  {
    AppMethodBeat.i(81183);
    parama = new com.tencent.mm.plugin.scanner.util.m(parama, 1);
    AppMethodBeat.o(81183);
    return parama;
  }
  
  protected final String cij()
  {
    return "identity";
  }
  
  protected final int cik()
  {
    return 2131302891;
  }
  
  protected final float getAspectRatio()
  {
    return 1.586F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.m
 * JD-Core Version:    0.7.0.1
 */