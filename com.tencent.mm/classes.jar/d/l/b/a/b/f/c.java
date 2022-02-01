package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class c
{
  private static final f JLS;
  private static final Pattern JLT;
  private static final d.g.a.b<String, f> JLU;
  public final String JLV;
  private transient b JLW;
  private transient c JLX;
  private transient f JLY;
  
  static
  {
    AppMethodBeat.i(59315);
    JLS = f.aQE("<root>");
    JLT = Pattern.compile("\\.");
    JLU = new d.g.a.b() {};
    AppMethodBeat.o(59315);
  }
  
  private c(String paramString)
  {
    AppMethodBeat.i(59299);
    this.JLV = paramString;
    AppMethodBeat.o(59299);
  }
  
  c(String paramString, b paramb)
  {
    AppMethodBeat.i(59298);
    this.JLV = paramString;
    this.JLW = paramb;
    AppMethodBeat.o(59298);
  }
  
  private c(String paramString, c paramc, f paramf)
  {
    AppMethodBeat.i(59300);
    this.JLV = paramString;
    this.JLX = paramc;
    this.JLY = paramf;
    AppMethodBeat.o(59300);
  }
  
  private void compute()
  {
    AppMethodBeat.i(59301);
    int i = this.JLV.lastIndexOf('.');
    if (i >= 0)
    {
      this.JLY = f.aQF(this.JLV.substring(i + 1));
      this.JLX = new c(this.JLV.substring(0, i));
      AppMethodBeat.o(59301);
      return;
    }
    this.JLY = f.aQF(this.JLV);
    this.JLX = b.JLP.fHc();
    AppMethodBeat.o(59301);
  }
  
  public static c t(f paramf)
  {
    AppMethodBeat.i(59311);
    if (paramf == null) {
      adP(16);
    }
    paramf = new c(paramf.qV(), b.JLP.fHc(), paramf);
    AppMethodBeat.o(59311);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59313);
    if (this == paramObject)
    {
      AppMethodBeat.o(59313);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    paramObject = (c)paramObject;
    if (!this.JLV.equals(paramObject.JLV))
    {
      AppMethodBeat.o(59313);
      return false;
    }
    AppMethodBeat.o(59313);
    return true;
  }
  
  public final f fHe()
  {
    AppMethodBeat.i(59307);
    if (this.JLY != null)
    {
      localObject = this.JLY;
      if (localObject == null) {
        adP(10);
      }
      AppMethodBeat.o(59307);
      return localObject;
    }
    if (this.JLV.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59307);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.JLY;
    if (localObject == null) {
      adP(11);
    }
    AppMethodBeat.o(59307);
    return localObject;
  }
  
  public final f fHf()
  {
    AppMethodBeat.i(59308);
    if (this.JLV.isEmpty())
    {
      localf = JLS;
      if (localf == null) {
        adP(12);
      }
      AppMethodBeat.o(59308);
      return localf;
    }
    f localf = fHe();
    if (localf == null) {
      adP(13);
    }
    AppMethodBeat.o(59308);
    return localf;
  }
  
  public final boolean fHg()
  {
    AppMethodBeat.i(59303);
    if ((this.JLW != null) || (qV().indexOf('<') < 0))
    {
      AppMethodBeat.o(59303);
      return true;
    }
    AppMethodBeat.o(59303);
    return false;
  }
  
  public final b fHh()
  {
    AppMethodBeat.i(59304);
    if (this.JLW != null)
    {
      localb = this.JLW;
      if (localb == null) {
        adP(5);
      }
      AppMethodBeat.o(59304);
      return localb;
    }
    this.JLW = new b(this);
    b localb = this.JLW;
    if (localb == null) {
      adP(6);
    }
    AppMethodBeat.o(59304);
    return localb;
  }
  
  public final c fHi()
  {
    AppMethodBeat.i(59305);
    if (this.JLX != null)
    {
      localObject = this.JLX;
      if (localObject == null) {
        adP(7);
      }
      AppMethodBeat.o(59305);
      return localObject;
    }
    if (this.JLV.isEmpty())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59305);
      throw ((Throwable)localObject);
    }
    compute();
    Object localObject = this.JLX;
    if (localObject == null) {
      adP(8);
    }
    AppMethodBeat.o(59305);
    return localObject;
  }
  
  public final List<f> fHj()
  {
    AppMethodBeat.i(59309);
    if (this.JLV.isEmpty()) {}
    for (List localList = Collections.emptyList();; localList = e.a(JLT.split(this.JLV), JLU))
    {
      if (localList == null) {
        adP(14);
      }
      AppMethodBeat.o(59309);
      return localList;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59314);
    int i = this.JLV.hashCode();
    AppMethodBeat.o(59314);
    return i;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59310);
    if (paramf == null) {
      adP(15);
    }
    if (this.JLV.isEmpty())
    {
      AppMethodBeat.o(59310);
      return false;
    }
    int j = this.JLV.indexOf('.');
    String str = this.JLV;
    paramf = paramf.qV();
    int i = j;
    if (j == -1) {
      i = this.JLV.length();
    }
    boolean bool = str.regionMatches(0, paramf, 0, i);
    AppMethodBeat.o(59310);
    return bool;
  }
  
  public final String qV()
  {
    AppMethodBeat.i(59302);
    String str = this.JLV;
    if (str == null) {
      adP(4);
    }
    AppMethodBeat.o(59302);
    return str;
  }
  
  public final c s(f paramf)
  {
    AppMethodBeat.i(59306);
    if (paramf == null) {
      adP(9);
    }
    if (this.JLV.isEmpty()) {}
    for (String str = paramf.qV();; str = this.JLV + "." + paramf.qV())
    {
      paramf = new c(str, this, paramf);
      AppMethodBeat.o(59306);
      return paramf;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59312);
    if (this.JLV.isEmpty()) {}
    for (String str = JLS.qV();; str = this.JLV)
    {
      if (str == null) {
        adP(17);
      }
      AppMethodBeat.o(59312);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.c
 * JD-Core Version:    0.7.0.1
 */