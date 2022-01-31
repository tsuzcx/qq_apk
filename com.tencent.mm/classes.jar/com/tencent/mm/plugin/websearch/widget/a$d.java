package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$d
{
  int cvs;
  String cwc;
  int gXf;
  String hny;
  boolean isLoading;
  boolean uMq;
  
  private a$d(a parama) {}
  
  public final String toString()
  {
    AppMethodBeat.i(91406);
    String str = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[] { this.cwc, this.hny, Integer.valueOf(this.cvs), Integer.valueOf(this.gXf) });
    AppMethodBeat.o(91406);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.d
 * JD-Core Version:    0.7.0.1
 */