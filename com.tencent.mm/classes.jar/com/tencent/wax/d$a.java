package com.tencent.wax;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.c.a.a;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.engine.d;

public final class d$a
{
  public static final String tWq;
  public Context GX;
  public String KuG;
  public String KuH;
  public FlutterView.b KuI;
  public d KuJ;
  public c KuK;
  public a KuL;
  public a.a KuM;
  
  static
  {
    AppMethodBeat.i(191684);
    tWq = io.flutter.embedding.android.d.a.KKz.name();
    AppMethodBeat.o(191684);
  }
  
  public d$a(Context paramContext)
  {
    AppMethodBeat.i(191683);
    this.KuG = "main";
    this.KuH = "/";
    this.KuI = FlutterView.b.KLe;
    this.KuJ = new d(new String[0]);
    this.GX = paramContext;
    AppMethodBeat.o(191683);
  }
  
  public final a a(a parama)
  {
    this.KuL = parama;
    return this;
  }
  
  public final a a(a.a parama)
  {
    this.KuM = parama;
    return this;
  }
  
  public final a a(c paramc)
  {
    this.KuK = paramc;
    return this;
  }
  
  public final a a(FlutterView.b paramb)
  {
    this.KuI = paramb;
    return this;
  }
  
  public final a aTY(String paramString)
  {
    this.KuG = paramString;
    return this;
  }
  
  public final a fHB()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wax.d.a
 * JD-Core Version:    0.7.0.1
 */