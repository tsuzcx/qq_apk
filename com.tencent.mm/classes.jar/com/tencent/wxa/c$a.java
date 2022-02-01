package com.tencent.wxa;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a.a;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.e.a;
import io.flutter.embedding.engine.d;
import io.flutter.embedding.engine.plugins.a;
import java.util.HashSet;

public final class c$a
{
  public static final String cpb;
  public String ZYN;
  public String ZYO;
  public FlutterView.b ZYP;
  public d ZYQ;
  private HashSet<b> ZYR;
  public a.a ZYS;
  public HashSet<a> ZYT;
  public Context mAppContext;
  
  static
  {
    AppMethodBeat.i(224765);
    cpb = e.a.aaoG.name();
    AppMethodBeat.o(224765);
  }
  
  public c$a(Context paramContext)
  {
    AppMethodBeat.i(224757);
    this.ZYN = "main";
    this.ZYO = "/";
    this.ZYP = FlutterView.b.aapx;
    this.ZYQ = new d(new String[0]);
    this.ZYR = new HashSet();
    this.ZYT = new HashSet();
    this.mAppContext = paramContext;
    AppMethodBeat.o(224757);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(224759);
    if (!this.ZYR.contains(paramb)) {
      this.ZYR.add(paramb);
    }
    AppMethodBeat.o(224759);
    return this;
  }
  
  public final a a(a.a parama)
  {
    this.ZYS = parama;
    return this;
  }
  
  public final a bEA(String paramString)
  {
    this.ZYN = paramString;
    return this;
  }
  
  public final a ivw()
  {
    return this;
  }
  
  public final a k(HashSet<a> paramHashSet)
  {
    AppMethodBeat.i(224761);
    this.ZYT.addAll(paramHashSet);
    AppMethodBeat.o(224761);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.c.a
 * JD-Core Version:    0.7.0.1
 */