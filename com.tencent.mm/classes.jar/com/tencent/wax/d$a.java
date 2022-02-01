package com.tencent.wax;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.c.a.a;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.engine.d;

public final class d$a
{
  public static final String uYZ;
  public Context IR;
  public String MkH;
  public String MkI;
  public FlutterView.b MkJ;
  public d MkK;
  public c MkL;
  public a MkM;
  public a.a MkN;
  
  static
  {
    AppMethodBeat.i(217481);
    uYZ = io.flutter.embedding.android.d.a.MBn.name();
    AppMethodBeat.o(217481);
  }
  
  public d$a(Context paramContext)
  {
    AppMethodBeat.i(217480);
    this.MkH = "main";
    this.MkI = "/";
    this.MkJ = FlutterView.b.MBV;
    this.MkK = new d(new String[0]);
    this.IR = paramContext;
    AppMethodBeat.o(217480);
  }
  
  public final a a(a parama)
  {
    this.MkM = parama;
    return this;
  }
  
  public final a a(a.a parama)
  {
    this.MkN = parama;
    return this;
  }
  
  public final a a(c paramc)
  {
    this.MkL = paramc;
    return this;
  }
  
  public final a a(FlutterView.b paramb)
  {
    this.MkJ = paramb;
    return this;
  }
  
  public final a aZW(String paramString)
  {
    this.MkH = paramString;
    return this;
  }
  
  public final a fYS()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wax.d.a
 * JD-Core Version:    0.7.0.1
 */