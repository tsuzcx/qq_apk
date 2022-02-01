package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public final class ad
{
  public static final int[] Wbe = { 16843087, 16843088, 16843379 };
  public static final int[] Wbf = { 16843379 };
  
  public static LayoutInflater b(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(141465);
    a.ez(paramLayoutInflater.getContext());
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramLayoutInflater.getContext());
    ad.a locala = new ad.a((byte)0);
    locala.layoutInflater = paramLayoutInflater;
    paramLayoutInflater.setFactory(locala);
    AppMethodBeat.o(141465);
    return paramLayoutInflater;
  }
  
  public static void c(LayoutInflater paramLayoutInflater)
  {
    AppMethodBeat.i(216563);
    a.ez(paramLayoutInflater.getContext());
    ad.a locala = new ad.a((byte)0);
    locala.layoutInflater = paramLayoutInflater;
    paramLayoutInflater.setFactory(locala);
    AppMethodBeat.o(216563);
  }
  
  public static LayoutInflater kS(Context paramContext)
  {
    AppMethodBeat.i(141466);
    a.ez(paramContext);
    paramContext = LayoutInflater.from(paramContext).cloneInContext(paramContext);
    ad.a locala = new ad.a((byte)0);
    locala.layoutInflater = paramContext;
    paramContext.setFactory(locala);
    AppMethodBeat.o(141466);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */