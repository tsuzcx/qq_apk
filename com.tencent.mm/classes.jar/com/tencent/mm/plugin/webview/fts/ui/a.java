package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a
{
  int De;
  float iaW;
  View idW;
  GestureDetector idY;
  float iea;
  int ieb;
  int iec;
  Runnable ied;
  Context mContext;
  a.a uPZ;
  a.b uQa;
  
  public a(Context paramContext, View paramView, a.b paramb)
  {
    AppMethodBeat.i(5822);
    this.uPZ = a.a.uQc;
    this.iaW = 0.0F;
    this.De = 0;
    this.iea = 0.0F;
    this.ieb = -1;
    this.iec = 0;
    this.ied = new a.1(this);
    this.mContext = paramContext;
    this.uQa = paramb;
    this.idW = paramView;
    this.idY = new GestureDetector(this.mContext, new a.2(this));
    this.iaW = c.cP(paramContext);
    AppMethodBeat.o(5822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a
 * JD-Core Version:    0.7.0.1
 */